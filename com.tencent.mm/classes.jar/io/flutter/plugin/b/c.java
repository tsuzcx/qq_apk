package io.flutter.plugin.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Selection;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.m;
import io.flutter.embedding.engine.c.m.a;
import io.flutter.embedding.engine.c.m.a.a;
import io.flutter.embedding.engine.c.m.b;
import io.flutter.embedding.engine.c.m.c;
import io.flutter.embedding.engine.c.m.d;
import io.flutter.embedding.engine.c.m.e;
import io.flutter.embedding.engine.c.m.f;
import io.flutter.plugin.a.k;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;

public final class c
{
  private final m SOi;
  final AutofillManager SSG;
  public a SSH;
  m.a SSI;
  SparseArray<m.a> SSJ;
  public boolean SSK;
  public InputConnection SSL;
  Rect SSM;
  private final boolean SSN;
  public boolean SSO;
  Editable SSv;
  public final InputMethodManager SSy;
  public final View mView;
  private PlatformViewsController platformViewsController;
  
  public c(View paramView, m paramm, PlatformViewsController paramPlatformViewsController)
  {
    AppMethodBeat.i(214901);
    this.SSH = new a(c.a.a.SSU, 0);
    this.mView = paramView;
    this.SSy = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.SSG = ((AutofillManager)paramView.getContext().getSystemService(AutofillManager.class));
      this.SOi = paramm;
      paramm.SRo = new m.e()
      {
        public final void a(double paramAnonymousDouble1, double paramAnonymousDouble2, double[] paramAnonymousArrayOfDouble)
        {
          AppMethodBeat.i(214890);
          c localc = c.this;
          double[] arrayOfDouble = new double[4];
          if ((paramAnonymousArrayOfDouble[3] == 0.0D) && (paramAnonymousArrayOfDouble[7] == 0.0D) && (paramAnonymousArrayOfDouble[15] == 1.0D)) {}
          for (boolean bool = true;; bool = false)
          {
            double d = paramAnonymousArrayOfDouble[12] / paramAnonymousArrayOfDouble[15];
            arrayOfDouble[1] = d;
            arrayOfDouble[0] = d;
            d = paramAnonymousArrayOfDouble[13] / paramAnonymousArrayOfDouble[15];
            arrayOfDouble[3] = d;
            arrayOfDouble[2] = d;
            paramAnonymousArrayOfDouble = new c.2(localc, bool, paramAnonymousArrayOfDouble, arrayOfDouble);
            paramAnonymousArrayOfDouble.w(paramAnonymousDouble1, 0.0D);
            paramAnonymousArrayOfDouble.w(paramAnonymousDouble1, paramAnonymousDouble2);
            paramAnonymousArrayOfDouble.w(0.0D, paramAnonymousDouble2);
            paramAnonymousArrayOfDouble = Float.valueOf(localc.mView.getContext().getResources().getDisplayMetrics().density);
            localc.SSM = new Rect((int)(arrayOfDouble[0] * paramAnonymousArrayOfDouble.floatValue()), (int)(arrayOfDouble[2] * paramAnonymousArrayOfDouble.floatValue()), (int)Math.ceil(arrayOfDouble[1] * paramAnonymousArrayOfDouble.floatValue()), (int)Math.ceil(arrayOfDouble[3] * paramAnonymousArrayOfDouble.floatValue()));
            AppMethodBeat.o(214890);
            return;
          }
        }
        
        public final void a(int paramAnonymousInt, m.a paramAnonymousa)
        {
          AppMethodBeat.i(9939);
          c localc = c.this;
          localc.SSH = new c.a(c.a.a.SSV, paramAnonymousInt);
          localc.hxn();
          localc.SSI = paramAnonymousa;
          m.a[] arrayOfa = paramAnonymousa.SRz;
          if (paramAnonymousa.SRy == null) {
            localc.SSJ = null;
          }
          for (;;)
          {
            localc.SSv = Editable.Factory.getInstance().newEditable("");
            localc.SSK = true;
            localc.SSO = false;
            localc.SSM = null;
            AppMethodBeat.o(9939);
            return;
            localc.SSJ = new SparseArray();
            if (arrayOfa == null)
            {
              localc.SSJ.put(paramAnonymousa.SRy.SRA.hashCode(), paramAnonymousa);
            }
            else
            {
              int i = arrayOfa.length;
              paramAnonymousInt = 0;
              while (paramAnonymousInt < i)
              {
                paramAnonymousa = arrayOfa[paramAnonymousInt];
                m.a.a locala = paramAnonymousa.SRy;
                if (locala != null) {
                  localc.SSJ.put(locala.SRA.hashCode(), paramAnonymousa);
                }
                paramAnonymousInt += 1;
              }
            }
          }
        }
        
        public final void a(m.d paramAnonymousd)
        {
          AppMethodBeat.i(9941);
          c.this.a(c.this.mView, paramAnonymousd);
          AppMethodBeat.o(9941);
        }
        
        public final void atw(int paramAnonymousInt)
        {
          AppMethodBeat.i(9940);
          c localc = c.this;
          localc.mView.requestFocus();
          localc.SSH = new c.a(c.a.a.SSW, paramAnonymousInt);
          localc.SSy.restartInput(localc.mView);
          localc.SSK = false;
          AppMethodBeat.o(9940);
        }
        
        public final void hide()
        {
          AppMethodBeat.i(9938);
          c.this.hR(c.this.mView);
          AppMethodBeat.o(9938);
        }
        
        public final void hxk()
        {
          AppMethodBeat.i(214889);
          c localc = c.this;
          if ((Build.VERSION.SDK_INT < 26) || (localc.SSG == null) || (!localc.hxo()))
          {
            AppMethodBeat.o(214889);
            return;
          }
          String str = localc.SSI.SRy.SRA;
          int[] arrayOfInt = new int[2];
          localc.mView.getLocationOnScreen(arrayOfInt);
          Rect localRect = new Rect(localc.SSM);
          localRect.offset(arrayOfInt[0], arrayOfInt[1]);
          localc.SSG.notifyViewEntered(localc.mView, str.hashCode(), localRect);
          AppMethodBeat.o(214889);
        }
        
        public final void hxl()
        {
          AppMethodBeat.i(9942);
          c localc = c.this;
          if (localc.SSH.SST != c.a.a.SSW)
          {
            localc.SSH = new c.a(c.a.a.SSU, 0);
            localc.SSO = false;
            localc.hxn();
            localc.SSM = null;
          }
          AppMethodBeat.o(9942);
        }
        
        public final void show()
        {
          AppMethodBeat.i(9937);
          c localc = c.this;
          View localView = c.this.mView;
          localView.requestFocus();
          localc.SSy.showSoftInput(localView, 0);
          AppMethodBeat.o(9937);
        }
      };
      paramm.bbv.a("TextInputClient.requestExistingInputState", null, null);
      this.platformViewsController = paramPlatformViewsController;
      this.platformViewsController.SMp = this;
      if ((this.SSy.getCurrentInputMethodSubtype() != null) && (Build.VERSION.SDK_INT >= 21) && (Build.MANUFACTURER.equals("samsung"))) {
        break label162;
      }
    }
    label162:
    for (boolean bool = false;; bool = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung"))
    {
      this.SSN = bool;
      AppMethodBeat.o(214901);
      return;
      this.SSG = null;
      break;
    }
  }
  
  private static int a(m.b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, m.c paramc)
  {
    int j;
    if (paramb.SRD == m.f.SRM) {
      j = 4;
    }
    int i;
    label204:
    label237:
    do
    {
      do
      {
        return j;
        if (paramb.SRD != m.f.SRP) {
          break;
        }
        i = 2;
        if (paramb.SRE) {
          i = 4098;
        }
        j = i;
      } while (!paramb.SRF);
      return i | 0x2000;
      if (paramb.SRD == m.f.SRQ) {
        return 3;
      }
      i = 1;
      if (paramb.SRD == m.f.SRR)
      {
        i = 131073;
        if (!paramBoolean1) {
          break label204;
        }
        i = i | 0x80000 | 0x80;
      }
      for (;;)
      {
        if (paramc != m.c.SRG) {
          break label237;
        }
        return i | 0x1000;
        if (paramb.SRD == m.f.SRS)
        {
          i = 33;
          break;
        }
        if (paramb.SRD == m.f.SRT)
        {
          i = 17;
          break;
        }
        if (paramb.SRD == m.f.SRU)
        {
          i = 145;
          break;
        }
        if (paramb.SRD == m.f.SRN)
        {
          i = 97;
          break;
        }
        if (paramb.SRD != m.f.SRO) {
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
      if (paramc == m.c.SRH) {
        return i | 0x2000;
      }
      j = i;
    } while (paramc != m.c.SRI);
    return i | 0x4000;
  }
  
  public final InputConnection a(View paramView, EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9956);
    if (this.SSH.SST == c.a.a.SSU)
    {
      this.SSL = null;
      AppMethodBeat.o(9956);
      return null;
    }
    if (this.SSH.SST == c.a.a.SSW)
    {
      if (this.SSO)
      {
        paramView = this.SSL;
        AppMethodBeat.o(9956);
        return paramView;
      }
      this.SSL = this.platformViewsController.r(Integer.valueOf(this.SSH.id)).onCreateInputConnection(paramEditorInfo);
      paramView = this.SSL;
      AppMethodBeat.o(9956);
      return paramView;
    }
    paramEditorInfo.inputType = a(this.SSI.SRv, this.SSI.SRr, this.SSI.SRs, this.SSI.SRt, this.SSI.SRu);
    paramEditorInfo.imeOptions = 33554432;
    int i;
    if (this.SSI.SRw == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.SSI.SRx != null)
      {
        paramEditorInfo.actionLabel = this.SSI.SRx;
        paramEditorInfo.actionId = i;
      }
      paramEditorInfo.imeOptions = (i | paramEditorInfo.imeOptions);
      paramView = new b(paramView, this.SSH.id, this.SOi, this.SSv, paramEditorInfo);
      paramEditorInfo.initialSelStart = Selection.getSelectionStart(this.SSv);
      paramEditorInfo.initialSelEnd = Selection.getSelectionEnd(this.SSv);
      this.SSL = paramView;
      paramView = this.SSL;
      AppMethodBeat.o(9956);
      return paramView;
      i = 6;
      continue;
      i = this.SSI.SRw.intValue();
    }
  }
  
  final void a(View paramView, m.d paramd)
  {
    AppMethodBeat.i(214903);
    if (!paramd.text.equals(this.SSv.toString())) {
      this.SSv.replace(0, this.SSv.length(), paramd.text);
    }
    String str1 = this.SSv.toString();
    if ((Build.VERSION.SDK_INT < 26) || (this.SSG == null) || (!hxo()))
    {
      int i = paramd.selectionStart;
      int j = paramd.selectionEnd;
      if ((i < 0) || (i > this.SSv.length()) || (j < 0) || (j > this.SSv.length())) {
        break label263;
      }
      Selection.setSelection(this.SSv, i, j);
    }
    for (;;)
    {
      paramd = this.SSL;
      if ((paramd != null) && ((paramd instanceof b))) {
        ((b)paramd).SSB = false;
      }
      if ((this.SSN) || (this.SSK)) {
        break label273;
      }
      this.SSy.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.SSv), 0), Math.max(Selection.getSelectionEnd(this.SSv), 0), BaseInputConnection.getComposingSpanStart(this.SSv), BaseInputConnection.getComposingSpanEnd(this.SSv));
      AppMethodBeat.o(214903);
      return;
      String str2 = this.SSI.SRy.SRA;
      this.SSG.notifyValueChanged(this.mView, str2.hashCode(), AutofillValue.forText(str1));
      break;
      label263:
      Selection.removeSelection(this.SSv);
    }
    label273:
    this.SSy.restartInput(paramView);
    this.SSK = false;
    AppMethodBeat.o(214903);
  }
  
  public final void a(ViewStructure paramViewStructure)
  {
    AppMethodBeat.i(214904);
    if ((Build.VERSION.SDK_INT < 26) || (!hxo()))
    {
      AppMethodBeat.o(214904);
      return;
    }
    String str = this.SSI.SRy.SRA;
    AutofillId localAutofillId = paramViewStructure.getAutofillId();
    int i = 0;
    if (i < this.SSJ.size())
    {
      int j = this.SSJ.keyAt(i);
      m.a.a locala = ((m.a)this.SSJ.valueAt(i)).SRy;
      ViewStructure localViewStructure;
      if (locala != null)
      {
        paramViewStructure.addChildCount(1);
        localViewStructure = paramViewStructure.newChild(i);
        localViewStructure.setAutofillId(localAutofillId, j);
        localViewStructure.setAutofillValue(AutofillValue.forText(locala.SRC.text));
        localViewStructure.setAutofillHints(locala.SRB);
        localViewStructure.setAutofillType(1);
        localViewStructure.setVisibility(0);
        if ((str.hashCode() != j) || (this.SSM == null)) {
          break label206;
        }
        localViewStructure.setDimens(this.SSM.left, this.SSM.top, 0, 0, this.SSM.width(), this.SSM.height());
      }
      for (;;)
      {
        i += 1;
        break;
        label206:
        localViewStructure.setDimens(0, 0, 0, 0, 1, 1);
      }
    }
    AppMethodBeat.o(214904);
  }
  
  public final void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(214905);
    if (Build.VERSION.SDK_INT < 26)
    {
      AppMethodBeat.o(214905);
      return;
    }
    m.a.a locala = this.SSI.SRy;
    if (locala == null)
    {
      AppMethodBeat.o(214905);
      return;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      Object localObject1 = (m.a)this.SSJ.get(j);
      if ((localObject1 != null) && (((m.a)localObject1).SRy != null))
      {
        localObject1 = ((m.a)localObject1).SRy;
        Object localObject2 = ((AutofillValue)paramSparseArray.valueAt(i)).getTextValue().toString();
        localObject2 = new m.d((String)localObject2, ((String)localObject2).length(), ((String)localObject2).length());
        if (((m.a.a)localObject1).SRA.equals(locala.SRA)) {
          a(this.mView, (m.d)localObject2);
        }
        localHashMap.put(((m.a.a)localObject1).SRA, localObject2);
      }
      i += 1;
    }
    this.SOi.a(this.SSH.id, localHashMap);
    AppMethodBeat.o(214905);
  }
  
  public final void destroy()
  {
    this.platformViewsController.SMp = null;
    this.SOi.SRo = null;
  }
  
  public final void hR(View paramView)
  {
    AppMethodBeat.i(9957);
    hxn();
    this.SSy.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    AppMethodBeat.o(9957);
  }
  
  final void hxn()
  {
    AppMethodBeat.i(214902);
    if ((Build.VERSION.SDK_INT < 26) || (this.SSG == null) || (this.SSI == null) || (this.SSI.SRy == null))
    {
      AppMethodBeat.o(214902);
      return;
    }
    String str = this.SSI.SRy.SRA;
    this.SSG.notifyViewExited(this.mView, str.hashCode());
    AppMethodBeat.o(214902);
  }
  
  final boolean hxo()
  {
    return this.SSJ != null;
  }
  
  public static final class a
  {
    public a SST;
    public int id;
    
    public a(a parama, int paramInt)
    {
      this.SST = parama;
      this.id = paramInt;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(9936);
        SSU = new a("NO_TARGET", 0);
        SSV = new a("FRAMEWORK_CLIENT", 1);
        SSW = new a("PLATFORM_VIEW", 2);
        SSX = new a[] { SSU, SSV, SSW };
        AppMethodBeat.o(9936);
      }
      
      private a() {}
    }
  }
  
  static abstract interface b
  {
    public abstract void w(double paramDouble1, double paramDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.b.c
 * JD-Core Version:    0.7.0.1
 */