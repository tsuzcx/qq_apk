package com.tencent.mm.ui.widget.cedit.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.ui.widget.MMEditText.d;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.lang.reflect.Constructor;
import java.util.List;

public class MMFlexEditText
  extends FrameLayout
  implements c
{
  String QFS;
  String QFT;
  String QFU;
  String QFV;
  c QFW;
  c QFX;
  private Boolean QFY;
  
  public MMFlexEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205474);
    this.QFS = "com.tencent.mm.ui.widget.MMEditText";
    this.QFT = "com.tencent.mm.ui.widget.cedit.api.MMCustomEditText";
    this.QFU = this.QFS;
    this.QFV = this.QFT;
    Log.i("MicroMsg.MMFlexEditText", "init with attrs");
    e(paramContext, paramAttributeSet);
    this.QFX = a(this.QFV, paramContext, paramAttributeSet);
    this.QFW = a(this.QFU, paramContext, paramAttributeSet);
    gZn();
    AppMethodBeat.o(205474);
  }
  
  public MMFlexEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205473);
    this.QFS = "com.tencent.mm.ui.widget.MMEditText";
    this.QFT = "com.tencent.mm.ui.widget.cedit.api.MMCustomEditText";
    this.QFU = this.QFS;
    this.QFV = this.QFT;
    Log.i("MicroMsg.MMFlexEditText", "init with defStyle");
    e(paramContext, paramAttributeSet);
    this.QFX = a(this.QFV, paramContext, paramAttributeSet, paramInt);
    this.QFW = a(this.QFU, paramContext, paramAttributeSet, paramInt);
    gZn();
    AppMethodBeat.o(205473);
  }
  
  private static c a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(205477);
    try
    {
      paramString = (c)Class.forName(paramString).getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { paramContext, paramAttributeSet });
      AppMethodBeat.o(205477);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.MMFlexEditText", "getEdtByClass err1:%s", new Object[] { Util.stackTraceToString(paramString) });
      paramString = new MMEditText(paramContext, paramAttributeSet);
      AppMethodBeat.o(205477);
    }
    return paramString;
  }
  
  private static c a(String paramString, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(205478);
    try
    {
      paramString = (c)Class.forName(paramString).getConstructor(new Class[] { Context.class, AttributeSet.class, Integer.TYPE }).newInstance(new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt) });
      AppMethodBeat.o(205478);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.MMFlexEditText", "getEdtByClass err2:%s", new Object[] { Util.stackTraceToString(paramString) });
      paramString = new MMEditText(paramContext, paramAttributeSet, paramInt);
      AppMethodBeat.o(205478);
    }
    return paramString;
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(205476);
    if (paramAttributeSet == null)
    {
      AppMethodBeat.o(205476);
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMFlexEditText);
    this.QFU = paramContext.getString(1);
    this.QFV = paramContext.getString(0);
    paramContext.recycle();
    AppMethodBeat.o(205476);
  }
  
  private void gZn()
  {
    AppMethodBeat.i(205475);
    setPadding(0, 0, 0, 0);
    refresh(true);
    AppMethodBeat.o(205475);
  }
  
  public final void CS(boolean paramBoolean)
  {
    AppMethodBeat.i(205522);
    if (this.QFY.booleanValue())
    {
      this.QFW.CS(paramBoolean);
      AppMethodBeat.o(205522);
      return;
    }
    this.QFX.CS(paramBoolean);
    AppMethodBeat.o(205522);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(205486);
    this.QFW.a(parama);
    this.QFX.a(parama);
    AppMethodBeat.o(205486);
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame)
  {
    AppMethodBeat.i(205520);
    this.QFX.a(paramList1, paramList2, paramString, parame);
    this.QFW.a(paramList1, paramList2, paramString, parame);
    AppMethodBeat.o(205520);
  }
  
  public void addOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(205513);
    this.QFW.addOnLayoutChangeListener(paramOnLayoutChangeListener);
    this.QFX.addOnLayoutChangeListener(paramOnLayoutChangeListener);
    AppMethodBeat.o(205513);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(205492);
    this.QFW.addTextChangedListener(paramTextWatcher);
    this.QFX.addTextChangedListener(paramTextWatcher);
    AppMethodBeat.o(205492);
  }
  
  public void append(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205495);
    this.QFW.append(paramCharSequence);
    this.QFX.append(paramCharSequence);
    AppMethodBeat.o(205495);
  }
  
  public final void bol(String paramString)
  {
    AppMethodBeat.i(205499);
    this.QFW.bol(paramString);
    this.QFX.bol(paramString);
    AppMethodBeat.o(205499);
  }
  
  public void clearComposingText()
  {
    AppMethodBeat.i(205489);
    this.QFW.clearComposingText();
    this.QFX.clearComposingText();
    AppMethodBeat.o(205489);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(205532);
    this.QFX.clearFocus();
    this.QFW.clearFocus();
    AppMethodBeat.o(205532);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(205519);
    this.QFX.destroy();
    this.QFW.destroy();
    AppMethodBeat.o(205519);
  }
  
  public final void gYF()
  {
    AppMethodBeat.i(205521);
    if (this.QFY.booleanValue())
    {
      this.QFW.gYF();
      AppMethodBeat.o(205521);
      return;
    }
    this.QFX.gYF();
    AppMethodBeat.o(205521);
  }
  
  public final View gYG()
  {
    AppMethodBeat.i(205528);
    if (this.QFY.booleanValue())
    {
      localView = this.QFW.gYG();
      AppMethodBeat.o(205528);
      return localView;
    }
    View localView = this.QFX.gYG();
    AppMethodBeat.o(205528);
    return localView;
  }
  
  public final boolean gYH()
  {
    return false;
  }
  
  public final ViewParent gYI()
  {
    AppMethodBeat.i(205530);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(205530);
    return localViewParent;
  }
  
  public final boolean gYJ()
  {
    AppMethodBeat.i(205497);
    if (this.QFY.booleanValue())
    {
      bool = this.QFW.gYJ();
      AppMethodBeat.o(205497);
      return bool;
    }
    boolean bool = this.QFX.gYJ();
    AppMethodBeat.o(205497);
    return bool;
  }
  
  public final Context gYK()
  {
    AppMethodBeat.i(205511);
    if (this.QFY.booleanValue())
    {
      localContext = this.QFW.gYK();
      AppMethodBeat.o(205511);
      return localContext;
    }
    Context localContext = this.QFX.gYK();
    AppMethodBeat.o(205511);
    return localContext;
  }
  
  public final int gYL()
  {
    AppMethodBeat.i(205514);
    if (this.QFY.booleanValue())
    {
      i = this.QFW.gYL();
      AppMethodBeat.o(205514);
      return i;
    }
    int i = this.QFX.gYL();
    AppMethodBeat.o(205514);
    return i;
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(205535);
    if (this.QFY.booleanValue())
    {
      if (this.QFW != null)
      {
        localCharSequence = this.QFW.getContentDescription();
        AppMethodBeat.o(205535);
        return localCharSequence;
      }
    }
    else if (this.QFX != null)
    {
      localCharSequence = this.QFX.getContentDescription();
      AppMethodBeat.o(205535);
      return localCharSequence;
    }
    CharSequence localCharSequence = super.getContentDescription();
    AppMethodBeat.o(205535);
    return localCharSequence;
  }
  
  public CharSequence getHint()
  {
    AppMethodBeat.i(205536);
    CharSequence localCharSequence;
    if (this.QFY.booleanValue())
    {
      if (this.QFW != null)
      {
        localCharSequence = this.QFW.getHint();
        AppMethodBeat.o(205536);
        return localCharSequence;
      }
    }
    else if (this.QFX != null)
    {
      localCharSequence = this.QFX.getHint();
      AppMethodBeat.o(205536);
      return localCharSequence;
    }
    AppMethodBeat.o(205536);
    return null;
  }
  
  public int getImeOptions()
  {
    AppMethodBeat.i(205485);
    if (this.QFY.booleanValue())
    {
      i = this.QFW.getImeOptions();
      AppMethodBeat.o(205485);
      return i;
    }
    int i = this.QFX.getImeOptions();
    AppMethodBeat.o(205485);
    return i;
  }
  
  public InputConnection getInputConnection()
  {
    AppMethodBeat.i(205498);
    if (this.QFY.booleanValue())
    {
      localInputConnection = this.QFW.getInputConnection();
      AppMethodBeat.o(205498);
      return localInputConnection;
    }
    InputConnection localInputConnection = this.QFX.getInputConnection();
    AppMethodBeat.o(205498);
    return localInputConnection;
  }
  
  public Bundle getInputExtras(boolean paramBoolean)
  {
    AppMethodBeat.i(205482);
    if (this.QFY.booleanValue())
    {
      localBundle = this.QFW.getInputExtras(paramBoolean);
      AppMethodBeat.o(205482);
      return localBundle;
    }
    Bundle localBundle = this.QFX.getInputExtras(paramBoolean);
    AppMethodBeat.o(205482);
    return localBundle;
  }
  
  public int getInputType()
  {
    AppMethodBeat.i(205504);
    if (this.QFY.booleanValue())
    {
      i = this.QFW.getInputType();
      AppMethodBeat.o(205504);
      return i;
    }
    int i = this.QFX.getInputType();
    AppMethodBeat.o(205504);
    return i;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(205494);
    if (this.QFY.booleanValue())
    {
      i = this.QFW.getLineCount();
      AppMethodBeat.o(205494);
      return i;
    }
    int i = this.QFX.getLineCount();
    AppMethodBeat.o(205494);
    return i;
  }
  
  public TextPaint getPaint()
  {
    AppMethodBeat.i(205515);
    if (this.QFY.booleanValue())
    {
      localTextPaint = this.QFW.getPaint();
      AppMethodBeat.o(205515);
      return localTextPaint;
    }
    TextPaint localTextPaint = this.QFX.getPaint();
    AppMethodBeat.o(205515);
    return localTextPaint;
  }
  
  public CharSequence getPasterContent()
  {
    AppMethodBeat.i(205488);
    if (this.QFY.booleanValue())
    {
      localCharSequence = this.QFW.getPasterContent();
      AppMethodBeat.o(205488);
      return localCharSequence;
    }
    CharSequence localCharSequence = this.QFX.getPasterContent();
    AppMethodBeat.o(205488);
    return localCharSequence;
  }
  
  public int getPasterLen()
  {
    AppMethodBeat.i(205509);
    if (this.QFY.booleanValue())
    {
      i = this.QFW.getPasterLen();
      AppMethodBeat.o(205509);
      return i;
    }
    int i = this.QFX.getPasterLen();
    AppMethodBeat.o(205509);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(205490);
    if (this.QFY.booleanValue())
    {
      i = this.QFW.getSelectionStart();
      AppMethodBeat.o(205490);
      return i;
    }
    int i = this.QFX.getSelectionStart();
    AppMethodBeat.o(205490);
    return i;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(205479);
    if (this.QFY.booleanValue())
    {
      localEditable = this.QFW.getText();
      AppMethodBeat.o(205479);
      return localEditable;
    }
    Editable localEditable = this.QFX.getText();
    AppMethodBeat.o(205479);
    return localEditable;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(205500);
    if (this.QFY.booleanValue())
    {
      f = this.QFW.getTextSize();
      AppMethodBeat.o(205500);
      return f;
    }
    float f = this.QFX.getTextSize();
    AppMethodBeat.o(205500);
    return f;
  }
  
  public int getVisibility()
  {
    AppMethodBeat.i(205523);
    if (this.QFY == null)
    {
      i = super.getVisibility();
      AppMethodBeat.o(205523);
      return i;
    }
    if (this.QFY.booleanValue())
    {
      i = this.QFW.getVisibility();
      AppMethodBeat.o(205523);
      return i;
    }
    int i = this.QFX.getVisibility();
    AppMethodBeat.o(205523);
    return i;
  }
  
  public int length()
  {
    AppMethodBeat.i(205493);
    if (this.QFY.booleanValue())
    {
      i = this.QFW.length();
      AppMethodBeat.o(205493);
      return i;
    }
    int i = this.QFX.length();
    AppMethodBeat.o(205493);
    return i;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(205518);
    if (this.QFY.booleanValue())
    {
      this.QFW.onPause();
      AppMethodBeat.o(205518);
      return;
    }
    this.QFX.onPause();
    AppMethodBeat.o(205518);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(205527);
    Log.i("MicroMsg.MMFlexEditText", "refresh isUseSys:%s, mUseSys:%s", new Object[] { Boolean.valueOf(paramBoolean), this.QFY });
    if (this.QFX.gYH()) {
      paramBoolean = true;
    }
    if ((this.QFY != null) && (this.QFY.booleanValue() == paramBoolean))
    {
      AppMethodBeat.o(205527);
      return;
    }
    this.QFY = Boolean.valueOf(paramBoolean);
    if (this.QFY.booleanValue())
    {
      if (this.QFW.gYI() == null) {
        addView(this.QFW.gYG());
      }
      this.QFW.setVisibility(0);
      if (this.QFX.gYI() != null)
      {
        this.QFX.setVisibility(8);
        AppMethodBeat.o(205527);
      }
    }
    else
    {
      b.aow(9);
      if (this.QFW.gYI() != null) {
        this.QFW.setVisibility(8);
      }
      if (this.QFX.gYI() == null) {
        addView(this.QFX.gYG());
      }
      this.QFX.setVisibility(0);
    }
    AppMethodBeat.o(205527);
  }
  
  public void removeOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(205516);
    this.QFW.removeOnLayoutChangeListener(paramOnLayoutChangeListener);
    this.QFX.removeOnLayoutChangeListener(paramOnLayoutChangeListener);
    AppMethodBeat.o(205516);
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(205502);
    this.QFW.removeTextChangedListener(paramTextWatcher);
    this.QFX.removeTextChangedListener(paramTextWatcher);
    AppMethodBeat.o(205502);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(205531);
    this.QFX.setAlpha(paramFloat);
    this.QFW.setAlpha(paramFloat);
    AppMethodBeat.o(205531);
  }
  
  public void setBackListener(MMEditText.a parama)
  {
    AppMethodBeat.i(205512);
    this.QFW.setBackListener(parama);
    this.QFX.setBackListener(parama);
    AppMethodBeat.o(205512);
  }
  
  public void setBreakStrategy(int paramInt)
  {
    AppMethodBeat.i(205483);
    this.QFW.setBreakStrategy(paramInt);
    this.QFX.setBreakStrategy(paramInt);
    AppMethodBeat.o(205483);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205534);
    super.setContentDescription(paramCharSequence);
    if (this.QFY.booleanValue())
    {
      if (this.QFW != null)
      {
        this.QFW.setContentDescription(paramCharSequence);
        AppMethodBeat.o(205534);
      }
    }
    else if (this.QFX != null) {
      this.QFX.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(205534);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(205487);
    this.QFW.setCustomSelectionActionModeCallback(paramCallback);
    this.QFX.setCustomSelectionActionModeCallback(paramCallback);
    AppMethodBeat.o(205487);
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(205508);
    this.QFW.setEnableSendBtn(paramBoolean);
    this.QFX.setEnableSendBtn(paramBoolean);
    AppMethodBeat.o(205508);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(205506);
    this.QFW.setFilters(paramArrayOfInputFilter);
    this.QFX.setFilters(paramArrayOfInputFilter);
    AppMethodBeat.o(205506);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205501);
    this.QFW.setHint(paramCharSequence);
    this.QFX.setHint(paramCharSequence);
    AppMethodBeat.o(205501);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(205481);
    this.QFW.setImeOptions(paramInt);
    this.QFX.setImeOptions(paramInt);
    AppMethodBeat.o(205481);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(205503);
    this.QFW.setInputType(paramInt);
    this.QFX.setInputType(paramInt);
    AppMethodBeat.o(205503);
  }
  
  public void setKeyCodeEnterListener(MMEditText.d paramd)
  {
    AppMethodBeat.i(205491);
    this.QFW.setKeyCodeEnterListener(paramd);
    this.QFX.setKeyCodeEnterListener(paramd);
    AppMethodBeat.o(205491);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(205484);
    if (this.QFW != null) {
      this.QFW.setMaxHeight(paramInt);
    }
    if (this.QFX != null) {
      this.QFX.setMaxHeight(paramInt);
    }
    AppMethodBeat.o(205484);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(205510);
    this.QFW.setOnClickListener(paramOnClickListener);
    this.QFX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(205510);
  }
  
  public void setOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(205505);
    this.QFW.setOnDragListener(paramOnDragListener);
    this.QFX.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(205505);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(205525);
    this.QFX.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.QFW.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(205525);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(205526);
    this.QFX.setOnLongClickListener(paramOnLongClickListener);
    this.QFW.setOnLongClickListener(paramOnLongClickListener);
    AppMethodBeat.o(205526);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(205524);
    this.QFX.setOnTouchListener(paramOnTouchListener);
    this.QFW.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(205524);
  }
  
  public void setPasterLen(int paramInt)
  {
    AppMethodBeat.i(205529);
    this.QFW.setPasterLen(paramInt);
    this.QFX.setPasterLen(paramInt);
    AppMethodBeat.o(205529);
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(205496);
    this.QFW.setSelection(paramInt);
    this.QFX.setSelection(paramInt);
    AppMethodBeat.o(205496);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205480);
    this.QFW.setText(paramCharSequence);
    this.QFX.setText(paramCharSequence);
    AppMethodBeat.o(205480);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(205507);
    this.QFW.setTextColor(paramInt);
    this.QFX.setTextColor(paramInt);
    AppMethodBeat.o(205507);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(205533);
    if (this.QFY.booleanValue())
    {
      if (this.QFW != null)
      {
        this.QFW.setTextSize(paramInt, paramFloat);
        AppMethodBeat.o(205533);
      }
    }
    else if (this.QFX != null) {
      this.QFX.setTextSize(paramInt, paramFloat);
    }
    AppMethodBeat.o(205533);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(205517);
    if (this.QFY.booleanValue())
    {
      this.QFW.setVisibility(paramInt);
      AppMethodBeat.o(205517);
      return;
    }
    this.QFX.setVisibility(paramInt);
    AppMethodBeat.o(205517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.MMFlexEditText
 * JD-Core Version:    0.7.0.1
 */