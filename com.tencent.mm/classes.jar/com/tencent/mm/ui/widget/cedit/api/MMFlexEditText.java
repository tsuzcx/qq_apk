package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
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
import com.tencent.mm.ui.anim.content.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.ui.widget.MMEditText.d;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cedit/api/MMFlexEditText;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/ui/widget/cedit/api/IEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "DEF_EDT_CUSTOM_CLASS", "", "getDEF_EDT_CUSTOM_CLASS", "()Ljava/lang/String;", "setDEF_EDT_CUSTOM_CLASS", "(Ljava/lang/String;)V", "DEF_EDT_SYS_CLASS", "getDEF_EDT_SYS_CLASS", "setDEF_EDT_SYS_CLASS", "TAG", "edtCustom", "getEdtCustom", "()Lcom/tencent/mm/ui/widget/cedit/api/IEditText;", "setEdtCustom", "(Lcom/tencent/mm/ui/widget/cedit/api/IEditText;)V", "edtCustomClass", "getEdtCustomClass", "setEdtCustomClass", "edtSys", "getEdtSys", "setEdtSys", "edtSysClass", "getEdtSysClass", "setEdtSysClass", "sizeAnimController", "Lcom/tencent/mm/ui/anim/content/SizeAnimController;", "getSizeAnimController", "()Lcom/tencent/mm/ui/anim/content/SizeAnimController;", "useSys", "", "Ljava/lang/Boolean;", "_getContext", "_getParent", "Landroid/view/ViewParent;", "_getWidth", "_requestFocus", "_setOnEditorActionListener", "", "l", "Lcom/tencent/mm/ui/widget/cedit/api/IEditText$OnEditorActionListener;", "addOnLayoutChangeListener", "listener", "Landroid/view/View$OnLayoutChangeListener;", "addTextChangedListener", "watcher", "Landroid/text/TextWatcher;", "append", "text", "", "clearComposingText", "clearFocus", "closeSelectAndTools", "destroy", "getContentDescription", "getEdtByClass", "name", "getHint", "getImeOptions", "getInputConnection", "Landroid/view/inputmethod/InputConnection;", "getInputExtras", "Landroid/os/Bundle;", "create", "getInputType", "getLineCount", "getPaint", "Landroid/text/TextPaint;", "getPasterContent", "getPasterLen", "getSelectionStart", "getSimilarPasteChange", "getSimilarPasteSeqStr", "Lcom/tencent/mm/ui/anim/content/ISizeAnimController;", "getText", "Landroid/text/Editable;", "getTextSize", "", "getVisibility", "initClass", "initEdt", "initMenu", "canReuseBrands", "", "itemTitles", "lang", "menuCallback", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnMenuCallback;", "insetText", "isInitFail", "length", "onKeyboardShow", "isShow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "refresh", "isUseSys", "removeOnLayoutChangeListener", "removeTextChangedListener", "resetSimilarPasteChange", "setAlpha", "alpha", "setBackListener", "Lcom/tencent/mm/ui/widget/MMEditText$IBackListener;", "setBreakStrategy", "breakStrategy", "setContentDescription", "contentDescription", "setCustomSelectionActionModeCallback", "actionModeCallback", "Landroid/view/ActionMode$Callback;", "setEnableSendBtn", "enableSendBtn", "setFilters", "filters", "", "Landroid/text/InputFilter;", "([Landroid/text/InputFilter;)V", "setHint", "hint", "setImeOptions", "imeOptions", "setInputType", "type", "setKeyCodeEnterListener", "keyCodeEnterListener", "Lcom/tencent/mm/ui/widget/MMEditText$OnKeyCodeEnterListener;", "setMaxHeight", "maxPixels", "setOnClickListener", "Landroid/view/View$OnClickListener;", "setOnDragListener", "Landroid/view/View$OnDragListener;", "setOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "setOnLongClickListener", "Landroid/view/View$OnLongClickListener;", "setOnTouchListener", "Landroid/view/View$OnTouchListener;", "setPasterLen", "parsterLen", "setSelection", "index", "setText", "setTextColor", "color", "setTextCursorDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setTextSize", "unit", "size", "setVisibility", "visibility", "toggleAppPanel", "view", "Landroid/view/View;", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMFlexEditText
  extends FrameLayout
  implements c
{
  public static final MMFlexEditText.a afWC;
  private static final char afWK;
  private final String TAG;
  private final com.tencent.mm.ui.anim.content.c adMp;
  private String afWD;
  private String afWE;
  private String afWF;
  private String afWG;
  private c afWH;
  private c afWI;
  private Boolean afWJ;
  
  static
  {
    AppMethodBeat.i(252292);
    afWC = new MMFlexEditText.a((byte)0);
    afWK = '​';
    AppMethodBeat.o(252292);
  }
  
  public MMFlexEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(252252);
    this.afWD = "com.tencent.mm.ui.widget.MMEditText";
    this.afWE = "com.tencent.mm.ui.widget.cedit.api.MMCustomEditText";
    this.afWF = this.afWD;
    this.afWG = this.afWE;
    this.adMp = new com.tencent.mm.ui.anim.content.c((View)this);
    this.TAG = s.X("MicroMsg.MMFlexEditText@", Integer.valueOf(hashCode()));
    Log.i(this.TAG, "init with attrs");
    e(paramContext, paramAttributeSet);
    this.afWI = a(this.afWG, paramContext, paramAttributeSet);
    this.afWH = a(this.afWF, paramContext, paramAttributeSet);
    jFm();
    AppMethodBeat.o(252252);
  }
  
  public MMFlexEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(252245);
    this.afWD = "com.tencent.mm.ui.widget.MMEditText";
    this.afWE = "com.tencent.mm.ui.widget.cedit.api.MMCustomEditText";
    this.afWF = this.afWD;
    this.afWG = this.afWE;
    this.adMp = new com.tencent.mm.ui.anim.content.c((View)this);
    this.TAG = s.X("MicroMsg.MMFlexEditText@", Integer.valueOf(hashCode()));
    Log.i(this.TAG, "init with defStyle");
    e(paramContext, paramAttributeSet);
    this.afWI = a(this.afWG, paramContext, paramAttributeSet, paramInt);
    this.afWH = a(this.afWF, paramContext, paramAttributeSet, paramInt);
    jFm();
    AppMethodBeat.o(252245);
  }
  
  private final c a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(252271);
    try
    {
      paramString = Class.forName(paramString).getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { paramContext, paramAttributeSet });
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.cedit.api.IEditText");
        AppMethodBeat.o(252271);
        throw paramString;
      }
    }
    finally
    {
      Log.e(this.TAG, "getEdtByClass err1:%s", new Object[] { Util.stackTraceToString(paramString) });
      paramString = (c)new MMEditText(paramContext, paramAttributeSet);
    }
    for (;;)
    {
      AppMethodBeat.o(252271);
      return paramString;
      paramString = (c)paramString;
    }
  }
  
  private final c a(String paramString, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(252282);
    try
    {
      paramString = Class.forName(paramString).getConstructor(new Class[] { Context.class, AttributeSet.class, Integer.TYPE }).newInstance(new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt) });
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.cedit.api.IEditText");
        AppMethodBeat.o(252282);
        throw paramString;
      }
    }
    finally
    {
      Log.e(this.TAG, "getEdtByClass err2:%s", new Object[] { Util.stackTraceToString(paramString) });
      paramString = (c)new MMEditText(paramContext, paramAttributeSet, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(252282);
      return paramString;
      paramString = (c)paramString;
    }
  }
  
  private final void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(252264);
    if (paramAttributeSet == null)
    {
      AppMethodBeat.o(252264);
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMFlexEditText);
    s.s(paramContext, "context.obtainStyledAttr…styleable.MMFlexEditText)");
    this.afWF = paramContext.getString(a.m.MMFlexEditText_sysEdt);
    this.afWG = paramContext.getString(a.m.MMFlexEditText_customEdt);
    paramContext.recycle();
    AppMethodBeat.o(252264);
  }
  
  private final void jFm()
  {
    AppMethodBeat.i(252258);
    setPadding(0, 0, 0, 0);
    refresh(true);
    addTextChangedListener((TextWatcher)new b(this));
    AppMethodBeat.o(252258);
  }
  
  public final void Ni(boolean paramBoolean)
  {
    AppMethodBeat.i(252591);
    c localc;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc != null)
      {
        localc.Ni(paramBoolean);
        AppMethodBeat.o(252591);
      }
    }
    else
    {
      localc = this.afWI;
      if (localc != null) {
        localc.Ni(paramBoolean);
      }
    }
    AppMethodBeat.o(252591);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(252416);
    s.u(parama, "l");
    c localc = this.afWH;
    if (localc != null) {
      localc.a(parama);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.a(parama);
    }
    AppMethodBeat.o(252416);
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame)
  {
    AppMethodBeat.i(252584);
    s.u(paramList1, "canReuseBrands");
    s.u(paramList2, "itemTitles");
    s.u(paramString, "lang");
    s.u(parame, "menuCallback");
    c localc = this.afWI;
    if (localc != null) {
      localc.a(paramList1, paramList2, paramString, parame);
    }
    localc = this.afWH;
    if (localc != null) {
      localc.a(paramList1, paramList2, paramString, parame);
    }
    AppMethodBeat.o(252584);
  }
  
  public final void addOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(252559);
    s.u(paramOnLayoutChangeListener, "listener");
    c localc = this.afWH;
    if (localc != null) {
      localc.addOnLayoutChangeListener(paramOnLayoutChangeListener);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.addOnLayoutChangeListener(paramOnLayoutChangeListener);
    }
    AppMethodBeat.o(252559);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(252469);
    s.u(paramTextWatcher, "watcher");
    c localc = this.afWH;
    if (localc != null) {
      localc.addTextChangedListener(paramTextWatcher);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(252469);
  }
  
  public final void append(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252484);
    c localc = this.afWH;
    if (localc != null) {
      localc.append(paramCharSequence);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.append(paramCharSequence);
    }
    AppMethodBeat.o(252484);
  }
  
  public final void bDt(String paramString)
  {
    AppMethodBeat.i(252498);
    s.u(paramString, "text");
    c localc = this.afWH;
    if (localc != null) {
      localc.bDt(paramString);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.bDt(paramString);
    }
    AppMethodBeat.o(252498);
  }
  
  public final void cRR()
  {
    AppMethodBeat.i(252662);
    c localc;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      if (this.afWH != null)
      {
        localc = this.afWH;
        if (localc != null)
        {
          localc.cRR();
          AppMethodBeat.o(252662);
        }
      }
    }
    else if (this.afWI != null)
    {
      localc = this.afWI;
      if (localc != null) {
        localc.cRR();
      }
    }
    AppMethodBeat.o(252662);
  }
  
  public final void clearComposingText()
  {
    AppMethodBeat.i(252453);
    c localc = this.afWH;
    if (localc != null) {
      localc.clearComposingText();
    }
    localc = this.afWI;
    if (localc != null) {
      localc.clearComposingText();
    }
    AppMethodBeat.o(252453);
  }
  
  public final void clearFocus()
  {
    AppMethodBeat.i(252648);
    c localc = this.afWI;
    if (localc != null) {
      localc.clearFocus();
    }
    localc = this.afWH;
    if (localc != null) {
      localc.clearFocus();
    }
    AppMethodBeat.o(252648);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(252581);
    c localc = this.afWI;
    if (localc != null) {
      localc.destroy();
    }
    localc = this.afWH;
    if (localc != null) {
      localc.destroy();
    }
    AppMethodBeat.o(252581);
  }
  
  public final CharSequence getContentDescription()
  {
    AppMethodBeat.i(252659);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      if (this.afWH != null)
      {
        localObject = this.afWH;
        if (localObject == null)
        {
          AppMethodBeat.o(252659);
          return null;
        }
        localObject = ((c)localObject).getContentDescription();
        AppMethodBeat.o(252659);
        return localObject;
      }
    }
    else if (this.afWI != null)
    {
      localObject = this.afWI;
      if (localObject == null)
      {
        AppMethodBeat.o(252659);
        return null;
      }
      localObject = ((c)localObject).getContentDescription();
      AppMethodBeat.o(252659);
      return localObject;
    }
    Object localObject = super.getContentDescription();
    AppMethodBeat.o(252659);
    return localObject;
  }
  
  public final String getDEF_EDT_CUSTOM_CLASS()
  {
    return this.afWE;
  }
  
  public final String getDEF_EDT_SYS_CLASS()
  {
    return this.afWD;
  }
  
  public final c getEdtCustom()
  {
    return this.afWI;
  }
  
  public final String getEdtCustomClass()
  {
    return this.afWG;
  }
  
  public final c getEdtSys()
  {
    return this.afWH;
  }
  
  public final String getEdtSysClass()
  {
    return this.afWF;
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(252675);
    Object localObject;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      if (this.afWH != null)
      {
        localObject = this.afWH;
        if (localObject == null)
        {
          AppMethodBeat.o(252675);
          return null;
        }
        localObject = ((c)localObject).getHint();
        AppMethodBeat.o(252675);
        return localObject;
      }
    }
    else if (this.afWI != null)
    {
      localObject = this.afWI;
      if (localObject == null)
      {
        AppMethodBeat.o(252675);
        return null;
      }
      localObject = ((c)localObject).getHint();
      AppMethodBeat.o(252675);
      return localObject;
    }
    AppMethodBeat.o(252675);
    return null;
  }
  
  public final int getImeOptions()
  {
    AppMethodBeat.i(252411);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252411);
        return 0;
      }
      i = localc.getImeOptions();
      AppMethodBeat.o(252411);
      return i;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252411);
      return 0;
    }
    int i = localc.getImeOptions();
    AppMethodBeat.o(252411);
    return i;
  }
  
  public final InputConnection getInputConnection()
  {
    AppMethodBeat.i(252495);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject = this.afWH;
      if (localObject == null)
      {
        AppMethodBeat.o(252495);
        return null;
      }
      localObject = ((c)localObject).getInputConnection();
      AppMethodBeat.o(252495);
      return localObject;
    }
    Object localObject = this.afWI;
    if (localObject == null)
    {
      AppMethodBeat.o(252495);
      return null;
    }
    localObject = ((c)localObject).getInputConnection();
    AppMethodBeat.o(252495);
    return localObject;
  }
  
  public final Bundle getInputExtras(boolean paramBoolean)
  {
    AppMethodBeat.i(252389);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject = this.afWH;
      if (localObject == null)
      {
        AppMethodBeat.o(252389);
        return null;
      }
      localObject = ((c)localObject).getInputExtras(paramBoolean);
      AppMethodBeat.o(252389);
      return localObject;
    }
    Object localObject = this.afWI;
    if (localObject == null)
    {
      AppMethodBeat.o(252389);
      return null;
    }
    localObject = ((c)localObject).getInputExtras(paramBoolean);
    AppMethodBeat.o(252389);
    return localObject;
  }
  
  public final int getInputType()
  {
    AppMethodBeat.i(252520);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252520);
        return 0;
      }
      i = localc.getInputType();
      AppMethodBeat.o(252520);
      return i;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252520);
      return 0;
    }
    int i = localc.getInputType();
    AppMethodBeat.o(252520);
    return i;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(252480);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252480);
        return 0;
      }
      i = localc.getLineCount();
      AppMethodBeat.o(252480);
      return i;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252480);
      return 0;
    }
    int i = localc.getLineCount();
    AppMethodBeat.o(252480);
    return i;
  }
  
  public final TextPaint getPaint()
  {
    AppMethodBeat.i(252564);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject = this.afWH;
      if (localObject == null)
      {
        AppMethodBeat.o(252564);
        return null;
      }
      localObject = ((c)localObject).getPaint();
      AppMethodBeat.o(252564);
      return localObject;
    }
    Object localObject = this.afWI;
    if (localObject == null)
    {
      AppMethodBeat.o(252564);
      return null;
    }
    localObject = ((c)localObject).getPaint();
    AppMethodBeat.o(252564);
    return localObject;
  }
  
  public final CharSequence getPasterContent()
  {
    AppMethodBeat.i(252432);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject = this.afWH;
      if (localObject == null)
      {
        AppMethodBeat.o(252432);
        return null;
      }
      localObject = ((c)localObject).getPasterContent();
      AppMethodBeat.o(252432);
      return localObject;
    }
    Object localObject = this.afWI;
    if (localObject == null)
    {
      AppMethodBeat.o(252432);
      return null;
    }
    localObject = ((c)localObject).getPasterContent();
    AppMethodBeat.o(252432);
    return localObject;
  }
  
  public final int getPasterLen()
  {
    AppMethodBeat.i(252544);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252544);
        return 0;
      }
      i = localc.getPasterLen();
      AppMethodBeat.o(252544);
      return i;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252544);
      return 0;
    }
    int i = localc.getPasterLen();
    AppMethodBeat.o(252544);
    return i;
  }
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(252458);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252458);
        return 0;
      }
      i = localc.getSelectionStart();
      AppMethodBeat.o(252458);
      return i;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252458);
      return 0;
    }
    int i = localc.getSelectionStart();
    AppMethodBeat.o(252458);
    return i;
  }
  
  public final boolean getSimilarPasteChange()
  {
    AppMethodBeat.i(252437);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252437);
        return false;
      }
      bool = localc.getSimilarPasteChange();
      AppMethodBeat.o(252437);
      return bool;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252437);
      return false;
    }
    boolean bool = localc.getSimilarPasteChange();
    AppMethodBeat.o(252437);
    return bool;
  }
  
  public final String getSimilarPasteSeqStr()
  {
    AppMethodBeat.i(252444);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject = this.afWH;
      if (localObject == null)
      {
        AppMethodBeat.o(252444);
        return "";
      }
      localObject = ((c)localObject).getSimilarPasteSeqStr();
      if (localObject == null)
      {
        AppMethodBeat.o(252444);
        return "";
      }
      AppMethodBeat.o(252444);
      return localObject;
    }
    Object localObject = this.afWI;
    if (localObject == null)
    {
      AppMethodBeat.o(252444);
      return "";
    }
    localObject = ((c)localObject).getSimilarPasteSeqStr();
    if (localObject == null)
    {
      AppMethodBeat.o(252444);
      return "";
    }
    AppMethodBeat.o(252444);
    return localObject;
  }
  
  public final com.tencent.mm.ui.anim.content.b getSizeAnimController()
  {
    return (com.tencent.mm.ui.anim.content.b)this.adMp;
  }
  
  public final com.tencent.mm.ui.anim.content.c getSizeAnimController()
  {
    return this.adMp;
  }
  
  public final Editable getText()
  {
    AppMethodBeat.i(252363);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject = this.afWH;
      if (localObject == null)
      {
        AppMethodBeat.o(252363);
        return null;
      }
      localObject = ((c)localObject).getText();
      AppMethodBeat.o(252363);
      return localObject;
    }
    Object localObject = this.afWI;
    if (localObject == null)
    {
      AppMethodBeat.o(252363);
      return null;
    }
    localObject = ((c)localObject).getText();
    AppMethodBeat.o(252363);
    return localObject;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(252502);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252502);
        return 0.0F;
      }
      f = localc.getTextSize();
      AppMethodBeat.o(252502);
      return f;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252502);
      return 0.0F;
    }
    float f = localc.getTextSize();
    AppMethodBeat.o(252502);
    return f;
  }
  
  public final int getVisibility()
  {
    c localc = null;
    Object localObject = null;
    AppMethodBeat.i(252598);
    if (this.afWJ == null)
    {
      i = super.getVisibility();
      AppMethodBeat.o(252598);
      return i;
    }
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null) {}
      while (localObject == null)
      {
        i = super.getVisibility();
        AppMethodBeat.o(252598);
        return i;
        localObject = Integer.valueOf(localc.getVisibility());
      }
      i = ((Integer)localObject).intValue();
      AppMethodBeat.o(252598);
      return i;
    }
    localObject = this.afWI;
    if (localObject == null) {}
    for (localObject = localc; localObject == null; localObject = Integer.valueOf(((c)localObject).getVisibility()))
    {
      i = super.getVisibility();
      AppMethodBeat.o(252598);
      return i;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(252598);
    return i;
  }
  
  public final void jEF()
  {
    AppMethodBeat.i(252588);
    c localc;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc != null)
      {
        localc.jEF();
        AppMethodBeat.o(252588);
      }
    }
    else
    {
      localc = this.afWI;
      if (localc != null) {
        localc.jEF();
      }
    }
    AppMethodBeat.o(252588);
  }
  
  public final View jEG()
  {
    AppMethodBeat.i(252627);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject = this.afWH;
      if (localObject == null)
      {
        AppMethodBeat.o(252627);
        return null;
      }
      localObject = ((c)localObject).jEG();
      AppMethodBeat.o(252627);
      return localObject;
    }
    Object localObject = this.afWI;
    if (localObject == null)
    {
      AppMethodBeat.o(252627);
      return null;
    }
    localObject = ((c)localObject).jEG();
    AppMethodBeat.o(252627);
    return localObject;
  }
  
  public final boolean jEH()
  {
    return false;
  }
  
  public final ViewParent jEI()
  {
    AppMethodBeat.i(252639);
    ViewParent localViewParent = getParent();
    s.s(localViewParent, "parent");
    AppMethodBeat.o(252639);
    return localViewParent;
  }
  
  public final boolean jEJ()
  {
    bool2 = false;
    AppMethodBeat.i(252490);
    for (;;)
    {
      try
      {
        if (!s.p(this.afWJ, Boolean.TRUE)) {
          continue;
        }
        localc = this.afWH;
        if (localc != null) {
          continue;
        }
        bool1 = bool2;
      }
      finally
      {
        c localc;
        boolean bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(252490);
      return bool1;
      bool1 = localc.jEJ();
      continue;
      localc = this.afWI;
      bool1 = bool2;
      if (localc != null) {
        bool1 = localc.jEJ();
      }
    }
  }
  
  public final Context jEK()
  {
    AppMethodBeat.i(252551);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject = this.afWH;
      if (localObject == null)
      {
        AppMethodBeat.o(252551);
        return null;
      }
      localObject = ((c)localObject).jEK();
      AppMethodBeat.o(252551);
      return localObject;
    }
    Object localObject = this.afWI;
    if (localObject == null)
    {
      AppMethodBeat.o(252551);
      return null;
    }
    localObject = ((c)localObject).jEK();
    AppMethodBeat.o(252551);
    return localObject;
  }
  
  public final int jEL()
  {
    AppMethodBeat.i(252563);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252563);
        return 0;
      }
      i = localc.jEL();
      AppMethodBeat.o(252563);
      return i;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252563);
      return 0;
    }
    int i = localc.jEL();
    AppMethodBeat.o(252563);
    return i;
  }
  
  public final void jFl()
  {
    AppMethodBeat.i(252449);
    c localc;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc != null)
      {
        localc.jFl();
        AppMethodBeat.o(252449);
      }
    }
    else
    {
      localc = this.afWI;
      if (localc != null) {
        localc.jFl();
      }
    }
    AppMethodBeat.o(252449);
  }
  
  public final int length()
  {
    AppMethodBeat.i(252475);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc == null)
      {
        AppMethodBeat.o(252475);
        return 0;
      }
      i = localc.length();
      AppMethodBeat.o(252475);
      return i;
    }
    c localc = this.afWI;
    if (localc == null)
    {
      AppMethodBeat.o(252475);
      return 0;
    }
    int i = localc.length();
    AppMethodBeat.o(252475);
    return i;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252670);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.adMp.ob(paramInt2, paramInt4);
    AppMethodBeat.o(252670);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252667);
    r localr = this.adMp.jlB();
    if (localr != null)
    {
      setMeasuredDimension(((Number)localr.bsC).intValue(), ((Number)localr.bsD).intValue());
      AppMethodBeat.o(252667);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    localr = this.adMp.jlC();
    if (localr != null) {
      setMeasuredDimension(((Number)localr.bsC).intValue(), ((Number)localr.bsD).intValue());
    }
    AppMethodBeat.o(252667);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(252578);
    c localc;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc != null)
      {
        localc.onPause();
        AppMethodBeat.o(252578);
      }
    }
    else
    {
      localc = this.afWI;
      if (localc != null) {
        localc.onPause();
      }
    }
    AppMethodBeat.o(252578);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(252623);
    Log.i(this.TAG, "refresh isUseSys:%s, mUseSys:%s", new Object[] { Boolean.valueOf(paramBoolean), this.afWJ });
    Object localObject1 = this.afWI;
    if ((localObject1 != null) && (((c)localObject1).jEH() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramBoolean = true;
      }
      if ((this.afWJ == null) || (!s.p(this.afWJ, Boolean.valueOf(paramBoolean)))) {
        break;
      }
      AppMethodBeat.o(252623);
      return;
    }
    this.afWJ = Boolean.valueOf(paramBoolean);
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localObject1 = this.afWH;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null)
        {
          localObject1 = this.afWH;
          if (localObject1 != null) {
            break label218;
          }
          localObject1 = null;
          label147:
          addView((View)localObject1);
        }
        localObject1 = this.afWH;
        if (localObject1 != null) {
          ((c)localObject1).setVisibility(0);
        }
        localObject1 = this.afWI;
        if (localObject1 != null) {
          break label228;
        }
      }
      label218:
      label228:
      for (localObject1 = localObject2;; localObject1 = ((c)localObject1).jEI())
      {
        if (localObject1 == null) {
          break label323;
        }
        localObject1 = this.afWI;
        if (localObject1 == null) {
          break label323;
        }
        ((c)localObject1).setVisibility(8);
        AppMethodBeat.o(252623);
        return;
        localObject1 = ((c)localObject1).jEI();
        break;
        localObject1 = ((c)localObject1).jEG();
        break label147;
      }
    }
    b.aEp(9);
    localObject1 = this.afWH;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject1 = this.afWH;
        if (localObject1 != null) {
          ((c)localObject1).setVisibility(8);
        }
      }
      localObject1 = this.afWI;
      if (localObject1 != null) {
        break label340;
      }
      localObject1 = null;
      label286:
      if (localObject1 == null)
      {
        localObject1 = this.afWI;
        if (localObject1 != null) {
          break label350;
        }
      }
    }
    label323:
    label340:
    label350:
    for (localObject1 = localObject3;; localObject1 = ((c)localObject1).jEG())
    {
      addView((View)localObject1);
      localObject1 = this.afWI;
      if (localObject1 != null) {
        ((c)localObject1).setVisibility(0);
      }
      AppMethodBeat.o(252623);
      return;
      localObject1 = ((c)localObject1).jEI();
      break;
      localObject1 = ((c)localObject1).jEI();
      break label286;
    }
  }
  
  public final void removeOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(252568);
    s.u(paramOnLayoutChangeListener, "listener");
    c localc = this.afWH;
    if (localc != null) {
      localc.removeOnLayoutChangeListener(paramOnLayoutChangeListener);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.removeOnLayoutChangeListener(paramOnLayoutChangeListener);
    }
    AppMethodBeat.o(252568);
  }
  
  public final void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(252512);
    s.u(paramTextWatcher, "watcher");
    c localc = this.afWH;
    if (localc != null) {
      localc.removeTextChangedListener(paramTextWatcher);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.removeTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(252512);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(252644);
    c localc = this.afWI;
    if (localc != null) {
      localc.setAlpha(paramFloat);
    }
    localc = this.afWH;
    if (localc != null) {
      localc.setAlpha(paramFloat);
    }
    AppMethodBeat.o(252644);
  }
  
  public final void setBackListener(MMEditText.a parama)
  {
    AppMethodBeat.i(252555);
    s.u(parama, "listener");
    c localc = this.afWH;
    if (localc != null) {
      localc.setBackListener(parama);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setBackListener(parama);
    }
    AppMethodBeat.o(252555);
  }
  
  public final void setBreakStrategy(int paramInt)
  {
    AppMethodBeat.i(252397);
    c localc = this.afWH;
    if (localc != null) {
      localc.setBreakStrategy(paramInt);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setBreakStrategy(paramInt);
    }
    AppMethodBeat.o(252397);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252654);
    super.setContentDescription(paramCharSequence);
    c localc;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      if (this.afWH != null)
      {
        localc = this.afWH;
        if (localc != null)
        {
          localc.setContentDescription(paramCharSequence);
          AppMethodBeat.o(252654);
        }
      }
    }
    else if (this.afWI != null)
    {
      localc = this.afWI;
      if (localc != null) {
        localc.setContentDescription(paramCharSequence);
      }
    }
    AppMethodBeat.o(252654);
  }
  
  public final void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(252426);
    s.u(paramCallback, "actionModeCallback");
    c localc = this.afWH;
    if (localc != null) {
      localc.setCustomSelectionActionModeCallback(paramCallback);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setCustomSelectionActionModeCallback(paramCallback);
    }
    AppMethodBeat.o(252426);
  }
  
  public final void setDEF_EDT_CUSTOM_CLASS(String paramString)
  {
    AppMethodBeat.i(252315);
    s.u(paramString, "<set-?>");
    this.afWE = paramString;
    AppMethodBeat.o(252315);
  }
  
  public final void setDEF_EDT_SYS_CLASS(String paramString)
  {
    AppMethodBeat.i(252302);
    s.u(paramString, "<set-?>");
    this.afWD = paramString;
    AppMethodBeat.o(252302);
  }
  
  public final void setEdtCustom(c paramc)
  {
    this.afWI = paramc;
  }
  
  public final void setEdtCustomClass(String paramString)
  {
    this.afWG = paramString;
  }
  
  public final void setEdtSys(c paramc)
  {
    this.afWH = paramc;
  }
  
  public final void setEdtSysClass(String paramString)
  {
    this.afWF = paramString;
  }
  
  public final void setEnableSendBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(252539);
    c localc = this.afWH;
    if (localc != null) {
      localc.setEnableSendBtn(paramBoolean);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setEnableSendBtn(paramBoolean);
    }
    AppMethodBeat.o(252539);
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(252531);
    s.u(paramArrayOfInputFilter, "filters");
    c localc = this.afWH;
    if (localc != null) {
      localc.setFilters(paramArrayOfInputFilter);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(252531);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252509);
    c localc = this.afWH;
    if (localc != null) {
      localc.setHint(paramCharSequence);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setHint(paramCharSequence);
    }
    AppMethodBeat.o(252509);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(252379);
    c localc = this.afWH;
    if (localc != null) {
      localc.setImeOptions(paramInt);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setImeOptions(paramInt);
    }
    AppMethodBeat.o(252379);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(252514);
    c localc = this.afWH;
    if (localc != null) {
      localc.setInputType(paramInt);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setInputType(paramInt);
    }
    AppMethodBeat.o(252514);
  }
  
  public final void setKeyCodeEnterListener(MMEditText.d paramd)
  {
    AppMethodBeat.i(252465);
    s.u(paramd, "keyCodeEnterListener");
    c localc = this.afWH;
    if (localc != null) {
      localc.setKeyCodeEnterListener(paramd);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setKeyCodeEnterListener(paramd);
    }
    AppMethodBeat.o(252465);
  }
  
  public final void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(252404);
    c localc;
    if (this.afWH != null)
    {
      localc = this.afWH;
      if (localc != null) {
        localc.setMaxHeight(paramInt);
      }
    }
    if (this.afWI != null)
    {
      localc = this.afWI;
      if (localc != null) {
        localc.setMaxHeight(paramInt);
      }
    }
    AppMethodBeat.o(252404);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(252547);
    c localc = this.afWH;
    if (localc != null) {
      localc.setOnClickListener(paramOnClickListener);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(252547);
  }
  
  public final void setOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(252524);
    c localc = this.afWH;
    if (localc != null) {
      localc.setOnDragListener(paramOnDragListener);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setOnDragListener(paramOnDragListener);
    }
    AppMethodBeat.o(252524);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(252608);
    s.u(paramOnFocusChangeListener, "l");
    c localc = this.afWI;
    if (localc != null) {
      localc.setOnFocusChangeListener(paramOnFocusChangeListener);
    }
    localc = this.afWH;
    if (localc != null) {
      localc.setOnFocusChangeListener(paramOnFocusChangeListener);
    }
    AppMethodBeat.o(252608);
  }
  
  public final void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(252613);
    c localc = this.afWI;
    if (localc != null) {
      localc.setOnLongClickListener(paramOnLongClickListener);
    }
    localc = this.afWH;
    if (localc != null) {
      localc.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(252613);
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(252602);
    s.u(paramOnTouchListener, "l");
    c localc = this.afWI;
    if (localc != null) {
      localc.setOnTouchListener(paramOnTouchListener);
    }
    localc = this.afWH;
    if (localc != null) {
      localc.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(252602);
  }
  
  public final void setPasterLen(int paramInt)
  {
    AppMethodBeat.i(252631);
    c localc = this.afWH;
    if (localc != null) {
      localc.setPasterLen(paramInt);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setPasterLen(paramInt);
    }
    AppMethodBeat.o(252631);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(252488);
    c localc = this.afWH;
    if (localc != null) {
      localc.setSelection(paramInt);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setSelection(paramInt);
    }
    AppMethodBeat.o(252488);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252374);
    c localc = this.afWH;
    if (localc != null) {
      localc.setText(paramCharSequence);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setText(paramCharSequence);
    }
    AppMethodBeat.o(252374);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(252535);
    c localc = this.afWH;
    if (localc != null) {
      localc.setTextColor(paramInt);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setTextColor(paramInt);
    }
    AppMethodBeat.o(252535);
  }
  
  public final void setTextCursorDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(369641);
    c localc = this.afWH;
    if (localc != null) {
      localc.setTextCursorDrawable(paramDrawable);
    }
    localc = this.afWI;
    if (localc != null) {
      localc.setTextCursorDrawable(paramDrawable);
    }
    AppMethodBeat.o(369641);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(252650);
    c localc;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      if (this.afWH != null)
      {
        localc = this.afWH;
        if (localc != null)
        {
          localc.setTextSize(paramInt, paramFloat);
          AppMethodBeat.o(252650);
        }
      }
    }
    else if (this.afWI != null)
    {
      localc = this.afWI;
      if (localc != null) {
        localc.setTextSize(paramInt, paramFloat);
      }
    }
    AppMethodBeat.o(252650);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(252573);
    c localc;
    if (s.p(this.afWJ, Boolean.TRUE))
    {
      localc = this.afWH;
      if (localc != null)
      {
        localc.setVisibility(paramInt);
        AppMethodBeat.o(252573);
      }
    }
    else
    {
      localc = this.afWI;
      if (localc != null) {
        localc.setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(252573);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/cedit/api/MMFlexEditText$initEdt$1", "Landroid/text/TextWatcher;", "deleteFirstChar", "", "getDeleteFirstChar", "()Ljava/lang/Character;", "setDeleteFirstChar", "(Ljava/lang/Character;)V", "Ljava/lang/Character;", "fixLineSpan", "Lcom/tencent/mm/ui/anim/content/FixLineSpaceSpan;", "getFixLineSpan", "()Lcom/tencent/mm/ui/anim/content/FixLineSpaceSpan;", "isDelete", "", "()Z", "setDelete", "(Z)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    private boolean AcH;
    private final a afWL;
    private Character afWM;
    
    b(MMFlexEditText paramMMFlexEditText)
    {
      AppMethodBeat.i(252214);
      this.afWL = new a();
      AppMethodBeat.o(252214);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 1;
      AppMethodBeat.i(252234);
      this.afWN.getSizeAnimController().cancel();
      Object localObject;
      if ((paramEditable instanceof SpannableStringBuilder)) {
        if (this.AcH)
        {
          localObject = this.afWM;
          MMFlexEditText.a locala = MMFlexEditText.afWC;
          int j = MMFlexEditText.jFn();
          if (localObject == null)
          {
            AppMethodBeat.o(252234);
            return;
          }
          if (((Character)localObject).charValue() == j)
          {
            if (((CharSequence)paramEditable).length() > 0) {}
            while ((i != 0) && (((SpannableStringBuilder)paramEditable).charAt(((SpannableStringBuilder)paramEditable).length() - 1) == '\n'))
            {
              ((SpannableStringBuilder)paramEditable).delete(((SpannableStringBuilder)paramEditable).length() - 1, ((SpannableStringBuilder)paramEditable).length());
              AppMethodBeat.o(252234);
              return;
              i = 0;
            }
          }
        }
        else
        {
          if (((CharSequence)paramEditable).length() <= 0) {
            break label201;
          }
        }
      }
      label201:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (((SpannableStringBuilder)paramEditable).charAt(((SpannableStringBuilder)paramEditable).length() - 1) == '\n'))
        {
          paramEditable = (SpannableStringBuilder)paramEditable;
          localObject = MMFlexEditText.afWC;
          paramEditable.append(MMFlexEditText.jFn());
        }
        AppMethodBeat.o(252234);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252221);
      if (paramInt2 > paramInt3) {}
      for (boolean bool = true;; bool = false)
      {
        this.AcH = bool;
        if ((this.AcH) && (paramCharSequence != null)) {
          this.afWM = Character.valueOf(paramCharSequence.charAt(paramInt1));
        }
        AppMethodBeat.o(252221);
        return;
      }
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252227);
      if (((paramCharSequence instanceof SpannableStringBuilder)) && (((SpannableStringBuilder)paramCharSequence).getSpanStart(this.afWL) == -1))
      {
        ((SpannableStringBuilder)paramCharSequence).removeSpan(this.afWL);
        ((SpannableStringBuilder)paramCharSequence).setSpan(this.afWL, 0, paramCharSequence.length(), 18);
      }
      AppMethodBeat.o(252227);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.MMFlexEditText
 * JD-Core Version:    0.7.0.1
 */