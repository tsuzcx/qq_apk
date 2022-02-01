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
import com.tencent.mm.ah.a.m;
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
  String YeH;
  String YeI;
  String YeJ;
  String YeK;
  c YeL;
  c YeM;
  private Boolean YeN;
  
  public MMFlexEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(219391);
    this.YeH = "com.tencent.mm.ui.widget.MMEditText";
    this.YeI = "com.tencent.mm.ui.widget.cedit.api.MMCustomEditText";
    this.YeJ = this.YeH;
    this.YeK = this.YeI;
    Log.i("MicroMsg.MMFlexEditText", "init with attrs");
    e(paramContext, paramAttributeSet);
    this.YeM = a(this.YeK, paramContext, paramAttributeSet);
    this.YeL = a(this.YeJ, paramContext, paramAttributeSet);
    iae();
    AppMethodBeat.o(219391);
  }
  
  public MMFlexEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219389);
    this.YeH = "com.tencent.mm.ui.widget.MMEditText";
    this.YeI = "com.tencent.mm.ui.widget.cedit.api.MMCustomEditText";
    this.YeJ = this.YeH;
    this.YeK = this.YeI;
    Log.i("MicroMsg.MMFlexEditText", "init with defStyle");
    e(paramContext, paramAttributeSet);
    this.YeM = a(this.YeK, paramContext, paramAttributeSet, paramInt);
    this.YeL = a(this.YeJ, paramContext, paramAttributeSet, paramInt);
    iae();
    AppMethodBeat.o(219389);
  }
  
  private static c a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(219397);
    try
    {
      paramString = (c)Class.forName(paramString).getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { paramContext, paramAttributeSet });
      AppMethodBeat.o(219397);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.MMFlexEditText", "getEdtByClass err1:%s", new Object[] { Util.stackTraceToString(paramString) });
      paramString = new MMEditText(paramContext, paramAttributeSet);
      AppMethodBeat.o(219397);
    }
    return paramString;
  }
  
  private static c a(String paramString, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(219399);
    try
    {
      paramString = (c)Class.forName(paramString).getConstructor(new Class[] { Context.class, AttributeSet.class, Integer.TYPE }).newInstance(new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt) });
      AppMethodBeat.o(219399);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.MMFlexEditText", "getEdtByClass err2:%s", new Object[] { Util.stackTraceToString(paramString) });
      paramString = new MMEditText(paramContext, paramAttributeSet, paramInt);
      AppMethodBeat.o(219399);
    }
    return paramString;
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(219394);
    if (paramAttributeSet == null)
    {
      AppMethodBeat.o(219394);
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMFlexEditText);
    this.YeJ = paramContext.getString(a.m.MMFlexEditText_sysEdt);
    this.YeK = paramContext.getString(a.m.MMFlexEditText_customEdt);
    paramContext.recycle();
    AppMethodBeat.o(219394);
  }
  
  private void iae()
  {
    AppMethodBeat.i(219392);
    setPadding(0, 0, 0, 0);
    refresh(true);
    AppMethodBeat.o(219392);
  }
  
  public final void Hm(boolean paramBoolean)
  {
    AppMethodBeat.i(219482);
    if (this.YeN.booleanValue())
    {
      this.YeL.Hm(paramBoolean);
      AppMethodBeat.o(219482);
      return;
    }
    this.YeM.Hm(paramBoolean);
    AppMethodBeat.o(219482);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(219417);
    this.YeL.a(parama);
    this.YeM.a(parama);
    AppMethodBeat.o(219417);
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame)
  {
    AppMethodBeat.i(219478);
    this.YeM.a(paramList1, paramList2, paramString, parame);
    this.YeL.a(paramList1, paramList2, paramString, parame);
    AppMethodBeat.o(219478);
  }
  
  public void addOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(219467);
    this.YeL.addOnLayoutChangeListener(paramOnLayoutChangeListener);
    this.YeM.addOnLayoutChangeListener(paramOnLayoutChangeListener);
    AppMethodBeat.o(219467);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(219437);
    this.YeL.addTextChangedListener(paramTextWatcher);
    this.YeM.addTextChangedListener(paramTextWatcher);
    AppMethodBeat.o(219437);
  }
  
  public void append(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(219440);
    this.YeL.append(paramCharSequence);
    this.YeM.append(paramCharSequence);
    AppMethodBeat.o(219440);
  }
  
  public final void bBa(String paramString)
  {
    AppMethodBeat.i(219444);
    this.YeL.bBa(paramString);
    this.YeM.bBa(paramString);
    AppMethodBeat.o(219444);
  }
  
  public void clearComposingText()
  {
    AppMethodBeat.i(219431);
    this.YeL.clearComposingText();
    this.YeM.clearComposingText();
    AppMethodBeat.o(219431);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(219514);
    this.YeM.clearFocus();
    this.YeL.clearFocus();
    AppMethodBeat.o(219514);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(219474);
    this.YeM.destroy();
    this.YeL.destroy();
    AppMethodBeat.o(219474);
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(219520);
    if (this.YeN.booleanValue())
    {
      if (this.YeL != null)
      {
        localCharSequence = this.YeL.getContentDescription();
        AppMethodBeat.o(219520);
        return localCharSequence;
      }
    }
    else if (this.YeM != null)
    {
      localCharSequence = this.YeM.getContentDescription();
      AppMethodBeat.o(219520);
      return localCharSequence;
    }
    CharSequence localCharSequence = super.getContentDescription();
    AppMethodBeat.o(219520);
    return localCharSequence;
  }
  
  public CharSequence getHint()
  {
    AppMethodBeat.i(219522);
    CharSequence localCharSequence;
    if (this.YeN.booleanValue())
    {
      if (this.YeL != null)
      {
        localCharSequence = this.YeL.getHint();
        AppMethodBeat.o(219522);
        return localCharSequence;
      }
    }
    else if (this.YeM != null)
    {
      localCharSequence = this.YeM.getHint();
      AppMethodBeat.o(219522);
      return localCharSequence;
    }
    AppMethodBeat.o(219522);
    return null;
  }
  
  public int getImeOptions()
  {
    AppMethodBeat.i(219415);
    if (this.YeN.booleanValue())
    {
      i = this.YeL.getImeOptions();
      AppMethodBeat.o(219415);
      return i;
    }
    int i = this.YeM.getImeOptions();
    AppMethodBeat.o(219415);
    return i;
  }
  
  public InputConnection getInputConnection()
  {
    AppMethodBeat.i(219443);
    if (this.YeN.booleanValue())
    {
      localInputConnection = this.YeL.getInputConnection();
      AppMethodBeat.o(219443);
      return localInputConnection;
    }
    InputConnection localInputConnection = this.YeM.getInputConnection();
    AppMethodBeat.o(219443);
    return localInputConnection;
  }
  
  public Bundle getInputExtras(boolean paramBoolean)
  {
    AppMethodBeat.i(219406);
    if (this.YeN.booleanValue())
    {
      localBundle = this.YeL.getInputExtras(paramBoolean);
      AppMethodBeat.o(219406);
      return localBundle;
    }
    Bundle localBundle = this.YeM.getInputExtras(paramBoolean);
    AppMethodBeat.o(219406);
    return localBundle;
  }
  
  public int getInputType()
  {
    AppMethodBeat.i(219451);
    if (this.YeN.booleanValue())
    {
      i = this.YeL.getInputType();
      AppMethodBeat.o(219451);
      return i;
    }
    int i = this.YeM.getInputType();
    AppMethodBeat.o(219451);
    return i;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(219439);
    if (this.YeN.booleanValue())
    {
      i = this.YeL.getLineCount();
      AppMethodBeat.o(219439);
      return i;
    }
    int i = this.YeM.getLineCount();
    AppMethodBeat.o(219439);
    return i;
  }
  
  public TextPaint getPaint()
  {
    AppMethodBeat.i(219469);
    if (this.YeN.booleanValue())
    {
      localTextPaint = this.YeL.getPaint();
      AppMethodBeat.o(219469);
      return localTextPaint;
    }
    TextPaint localTextPaint = this.YeM.getPaint();
    AppMethodBeat.o(219469);
    return localTextPaint;
  }
  
  public CharSequence getPasterContent()
  {
    AppMethodBeat.i(219423);
    if (this.YeN.booleanValue())
    {
      localCharSequence = this.YeL.getPasterContent();
      AppMethodBeat.o(219423);
      return localCharSequence;
    }
    CharSequence localCharSequence = this.YeM.getPasterContent();
    AppMethodBeat.o(219423);
    return localCharSequence;
  }
  
  public int getPasterLen()
  {
    AppMethodBeat.i(219462);
    if (this.YeN.booleanValue())
    {
      i = this.YeL.getPasterLen();
      AppMethodBeat.o(219462);
      return i;
    }
    int i = this.YeM.getPasterLen();
    AppMethodBeat.o(219462);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(219434);
    if (this.YeN.booleanValue())
    {
      i = this.YeL.getSelectionStart();
      AppMethodBeat.o(219434);
      return i;
    }
    int i = this.YeM.getSelectionStart();
    AppMethodBeat.o(219434);
    return i;
  }
  
  public boolean getSimilarPasteChange()
  {
    AppMethodBeat.i(219425);
    if (this.YeN.booleanValue())
    {
      bool = this.YeL.getSimilarPasteChange();
      AppMethodBeat.o(219425);
      return bool;
    }
    boolean bool = this.YeM.getSimilarPasteChange();
    AppMethodBeat.o(219425);
    return bool;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(219401);
    if (this.YeN.booleanValue())
    {
      localEditable = this.YeL.getText();
      AppMethodBeat.o(219401);
      return localEditable;
    }
    Editable localEditable = this.YeM.getText();
    AppMethodBeat.o(219401);
    return localEditable;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(219445);
    if (this.YeN.booleanValue())
    {
      f = this.YeL.getTextSize();
      AppMethodBeat.o(219445);
      return f;
    }
    float f = this.YeM.getTextSize();
    AppMethodBeat.o(219445);
    return f;
  }
  
  public int getVisibility()
  {
    AppMethodBeat.i(219485);
    if (this.YeN == null)
    {
      i = super.getVisibility();
      AppMethodBeat.o(219485);
      return i;
    }
    if (this.YeN.booleanValue())
    {
      i = this.YeL.getVisibility();
      AppMethodBeat.o(219485);
      return i;
    }
    int i = this.YeM.getVisibility();
    AppMethodBeat.o(219485);
    return i;
  }
  
  public final void hZA()
  {
    AppMethodBeat.i(219428);
    if (this.YeN.booleanValue())
    {
      this.YeL.hZA();
      AppMethodBeat.o(219428);
      return;
    }
    this.YeM.hZA();
    AppMethodBeat.o(219428);
  }
  
  public final boolean hZB()
  {
    AppMethodBeat.i(219442);
    try
    {
      if (this.YeN.booleanValue())
      {
        bool = this.YeL.hZB();
        AppMethodBeat.o(219442);
        return bool;
      }
      boolean bool = this.YeM.hZB();
      AppMethodBeat.o(219442);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219442);
    }
    return false;
  }
  
  public final Context hZC()
  {
    AppMethodBeat.i(219464);
    if (this.YeN.booleanValue())
    {
      localContext = this.YeL.hZC();
      AppMethodBeat.o(219464);
      return localContext;
    }
    Context localContext = this.YeM.hZC();
    AppMethodBeat.o(219464);
    return localContext;
  }
  
  public final int hZD()
  {
    AppMethodBeat.i(219468);
    if (this.YeN.booleanValue())
    {
      i = this.YeL.hZD();
      AppMethodBeat.o(219468);
      return i;
    }
    int i = this.YeM.hZD();
    AppMethodBeat.o(219468);
    return i;
  }
  
  public final void hZw()
  {
    AppMethodBeat.i(219481);
    if (this.YeN.booleanValue())
    {
      this.YeL.hZw();
      AppMethodBeat.o(219481);
      return;
    }
    this.YeM.hZw();
    AppMethodBeat.o(219481);
  }
  
  public final View hZx()
  {
    AppMethodBeat.i(219504);
    if (this.YeN.booleanValue())
    {
      localView = this.YeL.hZx();
      AppMethodBeat.o(219504);
      return localView;
    }
    View localView = this.YeM.hZx();
    AppMethodBeat.o(219504);
    return localView;
  }
  
  public final boolean hZy()
  {
    return false;
  }
  
  public final ViewParent hZz()
  {
    AppMethodBeat.i(219511);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(219511);
    return localViewParent;
  }
  
  public int length()
  {
    AppMethodBeat.i(219438);
    if (this.YeN.booleanValue())
    {
      i = this.YeL.length();
      AppMethodBeat.o(219438);
      return i;
    }
    int i = this.YeM.length();
    AppMethodBeat.o(219438);
    return i;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(219473);
    if (this.YeN.booleanValue())
    {
      this.YeL.onPause();
      AppMethodBeat.o(219473);
      return;
    }
    this.YeM.onPause();
    AppMethodBeat.o(219473);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(219501);
    Log.i("MicroMsg.MMFlexEditText", "refresh isUseSys:%s, mUseSys:%s", new Object[] { Boolean.valueOf(paramBoolean), this.YeN });
    if (this.YeM.hZy()) {
      paramBoolean = true;
    }
    if ((this.YeN != null) && (this.YeN.booleanValue() == paramBoolean))
    {
      AppMethodBeat.o(219501);
      return;
    }
    this.YeN = Boolean.valueOf(paramBoolean);
    if (this.YeN.booleanValue())
    {
      if (this.YeL.hZz() == null) {
        addView(this.YeL.hZx());
      }
      this.YeL.setVisibility(0);
      if (this.YeM.hZz() != null)
      {
        this.YeM.setVisibility(8);
        AppMethodBeat.o(219501);
      }
    }
    else
    {
      b.axG(9);
      if (this.YeL.hZz() != null) {
        this.YeL.setVisibility(8);
      }
      if (this.YeM.hZz() == null) {
        addView(this.YeM.hZx());
      }
      this.YeM.setVisibility(0);
    }
    AppMethodBeat.o(219501);
  }
  
  public void removeOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(219470);
    this.YeL.removeOnLayoutChangeListener(paramOnLayoutChangeListener);
    this.YeM.removeOnLayoutChangeListener(paramOnLayoutChangeListener);
    AppMethodBeat.o(219470);
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(219448);
    this.YeL.removeTextChangedListener(paramTextWatcher);
    this.YeM.removeTextChangedListener(paramTextWatcher);
    AppMethodBeat.o(219448);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(219513);
    this.YeM.setAlpha(paramFloat);
    this.YeL.setAlpha(paramFloat);
    AppMethodBeat.o(219513);
  }
  
  public void setBackListener(MMEditText.a parama)
  {
    AppMethodBeat.i(219466);
    this.YeL.setBackListener(parama);
    this.YeM.setBackListener(parama);
    AppMethodBeat.o(219466);
  }
  
  public void setBreakStrategy(int paramInt)
  {
    AppMethodBeat.i(219409);
    this.YeL.setBreakStrategy(paramInt);
    this.YeM.setBreakStrategy(paramInt);
    AppMethodBeat.o(219409);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(219517);
    super.setContentDescription(paramCharSequence);
    if (this.YeN.booleanValue())
    {
      if (this.YeL != null)
      {
        this.YeL.setContentDescription(paramCharSequence);
        AppMethodBeat.o(219517);
      }
    }
    else if (this.YeM != null) {
      this.YeM.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(219517);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(219420);
    this.YeL.setCustomSelectionActionModeCallback(paramCallback);
    this.YeM.setCustomSelectionActionModeCallback(paramCallback);
    AppMethodBeat.o(219420);
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(219461);
    this.YeL.setEnableSendBtn(paramBoolean);
    this.YeM.setEnableSendBtn(paramBoolean);
    AppMethodBeat.o(219461);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(219457);
    this.YeL.setFilters(paramArrayOfInputFilter);
    this.YeM.setFilters(paramArrayOfInputFilter);
    AppMethodBeat.o(219457);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(219446);
    this.YeL.setHint(paramCharSequence);
    this.YeM.setHint(paramCharSequence);
    AppMethodBeat.o(219446);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(219405);
    this.YeL.setImeOptions(paramInt);
    this.YeM.setImeOptions(paramInt);
    AppMethodBeat.o(219405);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(219449);
    this.YeL.setInputType(paramInt);
    this.YeM.setInputType(paramInt);
    AppMethodBeat.o(219449);
  }
  
  public void setKeyCodeEnterListener(MMEditText.d paramd)
  {
    AppMethodBeat.i(219435);
    this.YeL.setKeyCodeEnterListener(paramd);
    this.YeM.setKeyCodeEnterListener(paramd);
    AppMethodBeat.o(219435);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(219411);
    if (this.YeL != null) {
      this.YeL.setMaxHeight(paramInt);
    }
    if (this.YeM != null) {
      this.YeM.setMaxHeight(paramInt);
    }
    AppMethodBeat.o(219411);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(219463);
    this.YeL.setOnClickListener(paramOnClickListener);
    this.YeM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(219463);
  }
  
  public void setOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(219455);
    this.YeL.setOnDragListener(paramOnDragListener);
    this.YeM.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(219455);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(219491);
    this.YeM.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.YeL.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(219491);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(219493);
    this.YeM.setOnLongClickListener(paramOnLongClickListener);
    this.YeL.setOnLongClickListener(paramOnLongClickListener);
    AppMethodBeat.o(219493);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(219489);
    this.YeM.setOnTouchListener(paramOnTouchListener);
    this.YeL.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(219489);
  }
  
  public void setPasterLen(int paramInt)
  {
    AppMethodBeat.i(219509);
    this.YeL.setPasterLen(paramInt);
    this.YeM.setPasterLen(paramInt);
    AppMethodBeat.o(219509);
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(219441);
    this.YeL.setSelection(paramInt);
    this.YeM.setSelection(paramInt);
    AppMethodBeat.o(219441);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(219403);
    this.YeL.setText(paramCharSequence);
    this.YeM.setText(paramCharSequence);
    AppMethodBeat.o(219403);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(219460);
    this.YeL.setTextColor(paramInt);
    this.YeM.setTextColor(paramInt);
    AppMethodBeat.o(219460);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(219516);
    if (this.YeN.booleanValue())
    {
      if (this.YeL != null)
      {
        this.YeL.setTextSize(paramInt, paramFloat);
        AppMethodBeat.o(219516);
      }
    }
    else if (this.YeM != null) {
      this.YeM.setTextSize(paramInt, paramFloat);
    }
    AppMethodBeat.o(219516);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(219472);
    if (this.YeN.booleanValue())
    {
      this.YeL.setVisibility(paramInt);
      AppMethodBeat.o(219472);
      return;
    }
    this.YeM.setVisibility(paramInt);
    AppMethodBeat.o(219472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.MMFlexEditText
 * JD-Core Version:    0.7.0.1
 */