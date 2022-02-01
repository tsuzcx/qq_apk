package io.flutter.plugin.editing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets.Type;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidKeyProcessor;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.InputType;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;

public class TextInputPlugin
  implements ListenableEditingState.EditingStateWatcher
{
  private static final String TAG = "TextInputPlugin";
  private final AutofillManager afm;
  private TextInputChannel.Configuration configuration;
  private ImeSyncDeferringInsetsCallback imeSyncCallback;
  private InputTarget inputTarget;
  private boolean isInputConnectionLocked;
  private AndroidKeyProcessor keyProcessor;
  private Rect lastClientRect;
  private InputConnection lastInputConnection;
  private SparseArray<TextInputChannel.Configuration> mAutofillConfigurations;
  private ListenableEditingState mEditable;
  private final InputMethodManager mImm;
  private TextInputChannel.TextEditState mLastKnownFrameworkTextEditingState;
  private boolean mRestartInputPending;
  private final View mView;
  private PlatformViewsController platformViewsController;
  private final boolean restartAlwaysRequired;
  private final TextInputChannel textInputChannel;
  
  public TextInputPlugin(View paramView, TextInputChannel paramTextInputChannel, PlatformViewsController paramPlatformViewsController)
  {
    AppMethodBeat.i(189752);
    this.inputTarget = new InputTarget(TextInputPlugin.InputTarget.Type.NO_TARGET, 0);
    this.mView = paramView;
    this.mImm = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.afm = ((AutofillManager)paramView.getContext().getSystemService(AutofillManager.class));
      if (Build.VERSION.SDK_INT >= 30) {
        if ((this.mView.getWindowSystemUiVisibility() & 0x2) != 0) {
          break label200;
        }
      }
    }
    label200:
    for (int i = WindowInsets.Type.navigationBars() | 0x0;; i = 0)
    {
      int j = i;
      if ((this.mView.getWindowSystemUiVisibility() & 0x4) == 0) {
        j = i | WindowInsets.Type.statusBars();
      }
      this.imeSyncCallback = new ImeSyncDeferringInsetsCallback(paramView, j, WindowInsets.Type.ime());
      this.imeSyncCallback.install();
      this.textInputChannel = paramTextInputChannel;
      paramTextInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler()
      {
        public void clearClient()
        {
          AppMethodBeat.i(9942);
          TextInputPlugin.this.clearTextInputClient();
          AppMethodBeat.o(9942);
        }
        
        public void finishAutofillContext(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(189780);
          if ((Build.VERSION.SDK_INT < 26) || (TextInputPlugin.this.afm == null))
          {
            AppMethodBeat.o(189780);
            return;
          }
          if (paramAnonymousBoolean)
          {
            TextInputPlugin.this.afm.commit();
            AppMethodBeat.o(189780);
            return;
          }
          TextInputPlugin.this.afm.cancel();
          AppMethodBeat.o(189780);
        }
        
        public void hide()
        {
          AppMethodBeat.i(9938);
          TextInputPlugin.access$200(TextInputPlugin.this, TextInputPlugin.this.mView);
          AppMethodBeat.o(9938);
        }
        
        public void requestAutofill()
        {
          AppMethodBeat.i(189769);
          TextInputPlugin.access$300(TextInputPlugin.this);
          AppMethodBeat.o(189769);
        }
        
        public void sendAppPrivateCommand(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(189819);
          TextInputPlugin.this.sendTextInputAppPrivateCommand(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(189819);
        }
        
        public void setClient(int paramAnonymousInt, TextInputChannel.Configuration paramAnonymousConfiguration)
        {
          AppMethodBeat.i(9939);
          TextInputPlugin.this.setTextInputClient(paramAnonymousInt, paramAnonymousConfiguration);
          AppMethodBeat.o(9939);
        }
        
        public void setEditableSizeAndTransform(double paramAnonymousDouble1, double paramAnonymousDouble2, double[] paramAnonymousArrayOfDouble)
        {
          AppMethodBeat.i(189809);
          TextInputPlugin.access$600(TextInputPlugin.this, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousArrayOfDouble);
          AppMethodBeat.o(189809);
        }
        
        public void setEditingState(TextInputChannel.TextEditState paramAnonymousTextEditState)
        {
          AppMethodBeat.i(9941);
          TextInputPlugin.this.setTextInputEditingState(TextInputPlugin.this.mView, paramAnonymousTextEditState);
          AppMethodBeat.o(9941);
        }
        
        public void setPlatformViewClient(int paramAnonymousInt)
        {
          AppMethodBeat.i(9940);
          TextInputPlugin.access$500(TextInputPlugin.this, paramAnonymousInt);
          AppMethodBeat.o(9940);
        }
        
        public void show()
        {
          AppMethodBeat.i(9937);
          TextInputPlugin.access$100(TextInputPlugin.this, TextInputPlugin.this.mView);
          AppMethodBeat.o(9937);
        }
      });
      paramTextInputChannel.requestExistingInputState();
      this.platformViewsController = paramPlatformViewsController;
      this.platformViewsController.attachTextInputPlugin(this);
      this.restartAlwaysRequired = isRestartAlwaysRequired();
      AppMethodBeat.o(189752);
      return;
      this.afm = null;
      break;
    }
  }
  
  private void hideTextInput(View paramView)
  {
    AppMethodBeat.i(9957);
    notifyViewExited();
    this.mImm.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    AppMethodBeat.o(9957);
  }
  
  private static int inputTypeFromTextInputType(TextInputChannel.InputType paramInputType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TextInputChannel.TextCapitalization paramTextCapitalization)
  {
    int j;
    if (paramInputType.type == TextInputChannel.TextInputType.DATETIME) {
      j = 4;
    }
    int i;
    label204:
    label238:
    do
    {
      do
      {
        return j;
        if (paramInputType.type != TextInputChannel.TextInputType.NUMBER) {
          break;
        }
        i = 2;
        if (paramInputType.isSigned) {
          i = 4098;
        }
        j = i;
      } while (!paramInputType.isDecimal);
      return i | 0x2000;
      if (paramInputType.type == TextInputChannel.TextInputType.PHONE) {
        return 3;
      }
      i = 1;
      if (paramInputType.type == TextInputChannel.TextInputType.MULTILINE)
      {
        i = 131073;
        if (!paramBoolean1) {
          break label204;
        }
        i = i | 0x80000 | 0x80;
      }
      for (;;)
      {
        if (paramTextCapitalization != TextInputChannel.TextCapitalization.CHARACTERS) {
          break label238;
        }
        return i | 0x1000;
        if (paramInputType.type == TextInputChannel.TextInputType.EMAIL_ADDRESS)
        {
          i = 33;
          break;
        }
        if (paramInputType.type == TextInputChannel.TextInputType.URL)
        {
          i = 17;
          break;
        }
        if (paramInputType.type == TextInputChannel.TextInputType.VISIBLE_PASSWORD)
        {
          i = 145;
          break;
        }
        if (paramInputType.type == TextInputChannel.TextInputType.NAME)
        {
          i = 97;
          break;
        }
        if (paramInputType.type != TextInputChannel.TextInputType.POSTAL_ADDRESS) {
          break;
        }
        i = 113;
        break;
        j = i;
        if (paramBoolean2) {
          j = i | 0x8000;
        }
        i = j;
        if (!paramBoolean3) {
          i = j | 0x80000;
        }
      }
      if (paramTextCapitalization == TextInputChannel.TextCapitalization.WORDS) {
        return i | 0x2000;
      }
      j = i;
    } while (paramTextCapitalization != TextInputChannel.TextCapitalization.SENTENCES);
    return i | 0x4000;
  }
  
  private boolean isRestartAlwaysRequired()
  {
    AppMethodBeat.i(189799);
    if ((this.mImm.getCurrentInputMethodSubtype() == null) || (Build.VERSION.SDK_INT < 21) || (!Build.MANUFACTURER.equals("samsung")))
    {
      AppMethodBeat.o(189799);
      return false;
    }
    Object localObject = this.mView.getContext().getContentResolver();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG("default_input_method").cG(localObject);
    localObject = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "io/flutter/plugin/editing/TextInputPlugin", "isRestartAlwaysRequired", "()Z", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
    if (localObject == null)
    {
      AppMethodBeat.o(189799);
      return false;
    }
    boolean bool = ((String)localObject).contains("Samsung");
    AppMethodBeat.o(189799);
    return bool;
  }
  
  private boolean needsAutofill()
  {
    return this.mAutofillConfigurations != null;
  }
  
  private void notifyValueChanged(String paramString)
  {
    AppMethodBeat.i(189821);
    if ((Build.VERSION.SDK_INT < 26) || (this.afm == null) || (!needsAutofill()))
    {
      AppMethodBeat.o(189821);
      return;
    }
    String str = this.configuration.autofill.uniqueIdentifier;
    this.afm.notifyValueChanged(this.mView, str.hashCode(), AutofillValue.forText(paramString));
    AppMethodBeat.o(189821);
  }
  
  private void notifyViewEntered()
  {
    AppMethodBeat.i(189812);
    if ((Build.VERSION.SDK_INT < 26) || (this.afm == null) || (!needsAutofill()))
    {
      AppMethodBeat.o(189812);
      return;
    }
    String str = this.configuration.autofill.uniqueIdentifier;
    int[] arrayOfInt = new int[2];
    this.mView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect(this.lastClientRect);
    localRect.offset(arrayOfInt[0], arrayOfInt[1]);
    this.afm.notifyViewEntered(this.mView, str.hashCode(), localRect);
    AppMethodBeat.o(189812);
  }
  
  private void notifyViewExited()
  {
    AppMethodBeat.i(189816);
    if ((Build.VERSION.SDK_INT < 26) || (this.afm == null) || (this.configuration == null) || (this.configuration.autofill == null) || (!needsAutofill()))
    {
      AppMethodBeat.o(189816);
      return;
    }
    String str = this.configuration.autofill.uniqueIdentifier;
    this.afm.notifyViewExited(this.mView, str.hashCode());
    AppMethodBeat.o(189816);
  }
  
  private void saveEditableSizeAndTransform(double paramDouble1, double paramDouble2, final double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(189792);
    final double[] arrayOfDouble = new double[4];
    if ((paramArrayOfDouble[3] == 0.0D) && (paramArrayOfDouble[7] == 0.0D) && (paramArrayOfDouble[15] == 1.0D)) {}
    for (final boolean bool = true;; bool = false)
    {
      double d = paramArrayOfDouble[12] / paramArrayOfDouble[15];
      arrayOfDouble[1] = d;
      arrayOfDouble[0] = d;
      d = paramArrayOfDouble[13] / paramArrayOfDouble[15];
      arrayOfDouble[3] = d;
      arrayOfDouble[2] = d;
      paramArrayOfDouble = new MinMax()
      {
        public void inspect(double paramAnonymousDouble1, double paramAnonymousDouble2)
        {
          double d1;
          double d2;
          if (bool)
          {
            d1 = 1.0D;
            d2 = (paramArrayOfDouble[0] * paramAnonymousDouble1 + paramArrayOfDouble[4] * paramAnonymousDouble2 + paramArrayOfDouble[12]) * d1;
            paramAnonymousDouble1 = d1 * (paramArrayOfDouble[1] * paramAnonymousDouble1 + paramArrayOfDouble[5] * paramAnonymousDouble2 + paramArrayOfDouble[13]);
            if (d2 >= arrayOfDouble[0]) {
              break label141;
            }
            arrayOfDouble[0] = d2;
            label89:
            if (paramAnonymousDouble1 >= arrayOfDouble[2]) {
              break label164;
            }
            arrayOfDouble[2] = paramAnonymousDouble1;
          }
          label141:
          label164:
          while (paramAnonymousDouble1 <= arrayOfDouble[3])
          {
            return;
            d1 = 1.0D / (paramArrayOfDouble[3] * paramAnonymousDouble1 + paramArrayOfDouble[7] * paramAnonymousDouble2 + paramArrayOfDouble[15]);
            break;
            if (d2 <= arrayOfDouble[1]) {
              break label89;
            }
            arrayOfDouble[1] = d2;
            break label89;
          }
          arrayOfDouble[3] = paramAnonymousDouble1;
        }
      };
      paramArrayOfDouble.inspect(paramDouble1, 0.0D);
      paramArrayOfDouble.inspect(paramDouble1, paramDouble2);
      paramArrayOfDouble.inspect(0.0D, paramDouble2);
      paramArrayOfDouble = Float.valueOf(this.mView.getContext().getResources().getDisplayMetrics().density);
      int i = (int)(arrayOfDouble[0] * paramArrayOfDouble.floatValue());
      int j = (int)(arrayOfDouble[2] * paramArrayOfDouble.floatValue());
      int k = (int)Math.ceil(arrayOfDouble[1] * paramArrayOfDouble.floatValue());
      paramDouble1 = arrayOfDouble[3];
      this.lastClientRect = new Rect(i, j, k, (int)Math.ceil(paramArrayOfDouble.floatValue() * paramDouble1));
      AppMethodBeat.o(189792);
      return;
    }
  }
  
  private void setPlatformViewTextInputClient(int paramInt)
  {
    AppMethodBeat.i(189786);
    this.mView.requestFocus();
    this.inputTarget = new InputTarget(TextInputPlugin.InputTarget.Type.PLATFORM_VIEW, paramInt);
    this.mImm.restartInput(this.mView);
    this.mRestartInputPending = false;
    AppMethodBeat.o(189786);
  }
  
  private void showTextInput(View paramView)
  {
    AppMethodBeat.i(189767);
    paramView.requestFocus();
    this.mImm.showSoftInput(paramView, 0);
    AppMethodBeat.o(189767);
  }
  
  private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration paramConfiguration)
  {
    AppMethodBeat.i(189828);
    if (Build.VERSION.SDK_INT < 26)
    {
      AppMethodBeat.o(189828);
      return;
    }
    if ((paramConfiguration == null) || (paramConfiguration.autofill == null))
    {
      this.mAutofillConfigurations = null;
      AppMethodBeat.o(189828);
      return;
    }
    TextInputChannel.Configuration[] arrayOfConfiguration = paramConfiguration.fields;
    this.mAutofillConfigurations = new SparseArray();
    if (arrayOfConfiguration == null)
    {
      this.mAutofillConfigurations.put(paramConfiguration.autofill.uniqueIdentifier.hashCode(), paramConfiguration);
      AppMethodBeat.o(189828);
      return;
    }
    int j = arrayOfConfiguration.length;
    int i = 0;
    while (i < j)
    {
      paramConfiguration = arrayOfConfiguration[i];
      TextInputChannel.Configuration.Autofill localAutofill = paramConfiguration.autofill;
      if (localAutofill != null)
      {
        this.mAutofillConfigurations.put(localAutofill.uniqueIdentifier.hashCode(), paramConfiguration);
        this.afm.notifyValueChanged(this.mView, localAutofill.uniqueIdentifier.hashCode(), AutofillValue.forText(localAutofill.editState.text));
      }
      i += 1;
    }
    AppMethodBeat.o(189828);
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(190005);
    if (Build.VERSION.SDK_INT < 26)
    {
      AppMethodBeat.o(190005);
      return;
    }
    TextInputChannel.Configuration.Autofill localAutofill = this.configuration.autofill;
    if (localAutofill == null)
    {
      AppMethodBeat.o(190005);
      return;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      Object localObject1 = (TextInputChannel.Configuration)this.mAutofillConfigurations.get(j);
      if ((localObject1 != null) && (((TextInputChannel.Configuration)localObject1).autofill != null))
      {
        localObject1 = ((TextInputChannel.Configuration)localObject1).autofill;
        Object localObject2 = ((AutofillValue)paramSparseArray.valueAt(i)).getTextValue().toString();
        localObject2 = new TextInputChannel.TextEditState((String)localObject2, ((String)localObject2).length(), ((String)localObject2).length(), -1, -1);
        if (((TextInputChannel.Configuration.Autofill)localObject1).uniqueIdentifier.equals(localAutofill.uniqueIdentifier)) {
          setTextInputEditingState(this.mView, (TextInputChannel.TextEditState)localObject2);
        }
        localHashMap.put(((TextInputChannel.Configuration.Autofill)localObject1).uniqueIdentifier, localObject2);
      }
      i += 1;
    }
    this.textInputChannel.updateEditingStateWithTag(this.inputTarget.id, localHashMap);
    AppMethodBeat.o(190005);
  }
  
  public void clearPlatformViewClient(int paramInt)
  {
    AppMethodBeat.i(189948);
    if ((this.inputTarget.type == TextInputPlugin.InputTarget.Type.PLATFORM_VIEW) && (this.inputTarget.id == paramInt))
    {
      this.inputTarget = new InputTarget(TextInputPlugin.InputTarget.Type.NO_TARGET, 0);
      hideTextInput(this.mView);
      this.mImm.restartInput(this.mView);
      this.mRestartInputPending = false;
    }
    AppMethodBeat.o(189948);
  }
  
  void clearTextInputClient()
  {
    AppMethodBeat.i(189978);
    if (this.inputTarget.type == TextInputPlugin.InputTarget.Type.PLATFORM_VIEW)
    {
      AppMethodBeat.o(189978);
      return;
    }
    this.mEditable.removeEditingStateListener(this);
    notifyViewExited();
    updateAutofillConfigurationIfNeeded(null);
    this.inputTarget = new InputTarget(TextInputPlugin.InputTarget.Type.NO_TARGET, 0);
    unlockPlatformViewInputConnection();
    this.lastClientRect = null;
    AppMethodBeat.o(189978);
  }
  
  public InputConnection createInputConnection(View paramView, EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9956);
    if (this.inputTarget.type == TextInputPlugin.InputTarget.Type.NO_TARGET)
    {
      this.lastInputConnection = null;
      AppMethodBeat.o(9956);
      return null;
    }
    if (this.inputTarget.type == TextInputPlugin.InputTarget.Type.PLATFORM_VIEW)
    {
      if (this.isInputConnectionLocked)
      {
        paramView = this.lastInputConnection;
        AppMethodBeat.o(9956);
        return paramView;
      }
      this.lastInputConnection = this.platformViewsController.getPlatformViewById(Integer.valueOf(this.inputTarget.id)).onCreateInputConnection(paramEditorInfo);
      paramView = this.lastInputConnection;
      AppMethodBeat.o(9956);
      return paramView;
    }
    paramEditorInfo.inputType = inputTypeFromTextInputType(this.configuration.inputType, this.configuration.obscureText, this.configuration.autocorrect, this.configuration.enableSuggestions, this.configuration.textCapitalization);
    paramEditorInfo.imeOptions = 33554432;
    int i;
    if (this.configuration.inputAction == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.configuration.actionLabel != null)
      {
        paramEditorInfo.actionLabel = this.configuration.actionLabel;
        paramEditorInfo.actionId = i;
      }
      paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
      paramView = new InputConnectionAdaptor(paramView, this.inputTarget.id, this.textInputChannel, this.keyProcessor, this.mEditable, paramEditorInfo);
      paramEditorInfo.initialSelStart = this.mEditable.getSelectionStart();
      paramEditorInfo.initialSelEnd = this.mEditable.getSelectionEnd();
      this.lastInputConnection = paramView;
      paramView = this.lastInputConnection;
      AppMethodBeat.o(9956);
      return paramView;
      i = 6;
      continue;
      i = this.configuration.inputAction.intValue();
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(189923);
    this.platformViewsController.detachTextInputPlugin();
    this.textInputChannel.setTextInputMethodHandler(null);
    notifyViewExited();
    if (this.mEditable != null) {
      this.mEditable.removeEditingStateListener(this);
    }
    if (this.imeSyncCallback != null) {
      this.imeSyncCallback.remove();
    }
    AppMethodBeat.o(189923);
  }
  
  public void didChangeEditingState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(189985);
    if (paramBoolean1) {
      notifyValueChanged(this.mEditable.toString());
    }
    int j = this.mEditable.getSelectionStart();
    int k = this.mEditable.getSelectionEnd();
    int m = this.mEditable.getComposingStart();
    int n = this.mEditable.getComposingEnd();
    if ((this.mLastKnownFrameworkTextEditingState == null) || ((this.mEditable.toString().equals(this.mLastKnownFrameworkTextEditingState.text)) && (j == this.mLastKnownFrameworkTextEditingState.selectionStart) && (k == this.mLastKnownFrameworkTextEditingState.selectionEnd) && (m == this.mLastKnownFrameworkTextEditingState.composingStart) && (n == this.mLastKnownFrameworkTextEditingState.composingEnd))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.v("TextInputPlugin", "send EditingState to flutter: " + this.mEditable.toString());
        this.textInputChannel.updateEditingState(this.inputTarget.id, this.mEditable.toString(), j, k, m, n);
        this.mLastKnownFrameworkTextEditingState = new TextInputChannel.TextEditState(this.mEditable.toString(), j, k, m, n);
      }
      AppMethodBeat.o(189985);
      return;
    }
  }
  
  Editable getEditable()
  {
    return this.mEditable;
  }
  
  ImeSyncDeferringInsetsCallback getImeSyncCallback()
  {
    return this.imeSyncCallback;
  }
  
  public InputMethodManager getInputMethodManager()
  {
    return this.mImm;
  }
  
  public AndroidKeyProcessor getKeyEventProcessor()
  {
    return this.keyProcessor;
  }
  
  public InputConnection getLastInputConnection()
  {
    return this.lastInputConnection;
  }
  
  public void lockPlatformViewInputConnection()
  {
    if (this.inputTarget.type == TextInputPlugin.InputTarget.Type.PLATFORM_VIEW) {
      this.isInputConnectionLocked = true;
    }
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(189994);
    if ((Build.VERSION.SDK_INT < 26) || (!needsAutofill()))
    {
      AppMethodBeat.o(189994);
      return;
    }
    String str = this.configuration.autofill.uniqueIdentifier;
    AutofillId localAutofillId = paramViewStructure.getAutofillId();
    paramInt = 0;
    if (paramInt < this.mAutofillConfigurations.size())
    {
      int i = this.mAutofillConfigurations.keyAt(paramInt);
      TextInputChannel.Configuration.Autofill localAutofill = ((TextInputChannel.Configuration)this.mAutofillConfigurations.valueAt(paramInt)).autofill;
      ViewStructure localViewStructure;
      if (localAutofill != null)
      {
        paramViewStructure.addChildCount(1);
        localViewStructure = paramViewStructure.newChild(paramInt);
        localViewStructure.setAutofillId(localAutofillId, i);
        localViewStructure.setAutofillHints(localAutofill.hints);
        localViewStructure.setAutofillType(1);
        localViewStructure.setVisibility(0);
        if ((str.hashCode() != i) || (this.lastClientRect == null)) {
          break label202;
        }
        localViewStructure.setDimens(this.lastClientRect.left, this.lastClientRect.top, 0, 0, this.lastClientRect.width(), this.lastClientRect.height());
        localViewStructure.setAutofillValue(AutofillValue.forText(this.mEditable));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        label202:
        localViewStructure.setDimens(0, 0, 0, 0, 1, 1);
        localViewStructure.setAutofillValue(AutofillValue.forText(localAutofill.editState.text));
      }
    }
    AppMethodBeat.o(189994);
  }
  
  public void sendTextInputAppPrivateCommand(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(189957);
    this.mImm.sendAppPrivateCommand(this.mView, paramString, paramBundle);
    AppMethodBeat.o(189957);
  }
  
  public void setKeyEventProcessor(AndroidKeyProcessor paramAndroidKeyProcessor)
  {
    this.keyProcessor = paramAndroidKeyProcessor;
  }
  
  void setTextInputClient(int paramInt, TextInputChannel.Configuration paramConfiguration)
  {
    AppMethodBeat.i(189963);
    notifyViewExited();
    this.inputTarget = new InputTarget(TextInputPlugin.InputTarget.Type.FRAMEWORK_CLIENT, paramInt);
    if (this.mEditable != null) {
      this.mEditable.removeEditingStateListener(this);
    }
    if (paramConfiguration.autofill != null) {}
    for (TextInputChannel.TextEditState localTextEditState = paramConfiguration.autofill.editState;; localTextEditState = null)
    {
      this.mEditable = new ListenableEditingState(localTextEditState, this.mView);
      this.configuration = paramConfiguration;
      updateAutofillConfigurationIfNeeded(paramConfiguration);
      this.mRestartInputPending = true;
      unlockPlatformViewInputConnection();
      this.lastClientRect = null;
      this.mEditable.addEditingStateListener(this);
      AppMethodBeat.o(189963);
      return;
    }
  }
  
  void setTextInputEditingState(View paramView, TextInputChannel.TextEditState paramTextEditState)
  {
    AppMethodBeat.i(189972);
    this.mLastKnownFrameworkTextEditingState = paramTextEditState;
    this.mEditable.setEditingState(paramTextEditState);
    if ((this.restartAlwaysRequired) || (this.mRestartInputPending))
    {
      this.mImm.restartInput(paramView);
      this.mRestartInputPending = false;
    }
    AppMethodBeat.o(189972);
  }
  
  public void unlockPlatformViewInputConnection()
  {
    this.isInputConnectionLocked = false;
  }
  
  static class InputTarget
  {
    int id;
    TextInputPlugin.InputTarget.Type type;
    
    public InputTarget(TextInputPlugin.InputTarget.Type paramType, int paramInt)
    {
      this.type = paramType;
      this.id = paramInt;
    }
  }
  
  static abstract interface MinMax
  {
    public abstract void inspect(double paramDouble1, double paramDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.editing.TextInputPlugin
 * JD-Core Version:    0.7.0.1
 */