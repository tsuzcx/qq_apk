package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.TextView.SavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.b;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.h.c.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/MMClearEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imgX", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getImgX", "()Landroid/graphics/drawable/Drawable;", "setImgX", "(Landroid/graphics/drawable/Drawable;)V", "isClearBtnAlwaysDismiss", "", "mEnableRestoreState", "getMEnableRestoreState", "()Z", "setMEnableRestoreState", "(Z)V", "mOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "addClearButton", "", "getDefaultOnTouchListener", "init", "manageClearButton", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "processPaste", "srcString", "", "removeClearButton", "setClearBtnAlwaysDismiss", "setOnFocusChangeListener", "l", "Companion", "libmmui_release"})
public final class MMClearEditText
  extends MMEditText
{
  public static final MMClearEditText.a YaF;
  private View.OnFocusChangeListener HBD;
  private boolean RcS;
  private Drawable RcT;
  private boolean WiU;
  private final View.OnTouchListener nan;
  
  static
  {
    AppMethodBeat.i(194247);
    YaF = new MMClearEditText.a((byte)0);
    AppMethodBeat.o(194247);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194246);
    this.RcT = aw.bf(getContext(), a.b.et_clear_selector);
    this.nan = ((View.OnTouchListener)new d(this));
    init();
    AppMethodBeat.o(194246);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194245);
    this.RcT = aw.bf(getContext(), a.b.et_clear_selector);
    this.nan = ((View.OnTouchListener)new d(this));
    init();
    AppMethodBeat.o(194245);
  }
  
  private final void hjx()
  {
    AppMethodBeat.i(194241);
    if ((n.ba((CharSequence)getText().toString())) || (!isFocused()))
    {
      hjz();
      AppMethodBeat.o(194241);
      return;
    }
    hjy();
    AppMethodBeat.o(194241);
  }
  
  private final void hjy()
  {
    AppMethodBeat.i(194242);
    if (!this.WiU) {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.RcT, getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(194242);
  }
  
  private final void hjz()
  {
    AppMethodBeat.i(194243);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(194243);
  }
  
  private final void init()
  {
    AppMethodBeat.i(194239);
    if (this.RcT == null) {
      this.RcT = aw.bf(getContext(), a.b.et_clear_selector);
    }
    Drawable localDrawable1 = this.RcT;
    Drawable localDrawable2 = this.RcT;
    p.j(localDrawable2, "imgX");
    int i = localDrawable2.getIntrinsicWidth();
    localDrawable2 = this.RcT;
    p.j(localDrawable2, "imgX");
    localDrawable1.setBounds(0, 0, i, localDrawable2.getIntrinsicHeight());
    localDrawable1 = this.RcT;
    p.j(localDrawable1, "imgX");
    i = localDrawable1.getIntrinsicWidth();
    localDrawable1 = this.RcT;
    p.j(localDrawable1, "imgX");
    Log.i("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localDrawable1.getIntrinsicHeight()) });
    hjx();
    localDrawable1 = this.RcT;
    p.j(localDrawable1, "imgX");
    setHeight(localDrawable1.getIntrinsicHeight() + getResources().getDimensionPixelSize(a.d.OneDPPadding) * 5);
    setOnTouchListener(this.nan);
    addTextChangedListener((TextWatcher)new b(this));
    super.setOnFocusChangeListener((View.OnFocusChangeListener)new c(this));
    AppMethodBeat.o(194239);
  }
  
  public final void bqQ(String paramString)
  {
    AppMethodBeat.i(194240);
    p.k(paramString, "srcString");
    int i = getSelectionStart();
    setText(b.c(getContext(), (CharSequence)paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i = j + i;
      if (i <= getText().length())
      {
        setSelection(i);
        AppMethodBeat.o(194240);
      }
    }
    else
    {
      setSelection(i);
    }
    AppMethodBeat.o(194240);
  }
  
  public final View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.nan;
  }
  
  public final Drawable getImgX()
  {
    return this.RcT;
  }
  
  public final boolean getMEnableRestoreState()
  {
    return this.RcS;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(194244);
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(194244);
      return;
    }
    if (!this.RcS) {
      paramParcelable = (Parcelable)View.BaseSavedState.EMPTY_STATE;
    }
    for (;;)
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(194244);
      return;
    }
  }
  
  public final void setImgX(Drawable paramDrawable)
  {
    this.RcT = paramDrawable;
  }
  
  public final void setMEnableRestoreState(boolean paramBoolean)
  {
    this.RcS = paramBoolean;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.HBD = paramOnFocusChangeListener;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/widget/MMClearEditText$init$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "arg0", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "libmmui_release"})
  public static final class b
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(224044);
      p.k(paramEditable, "arg0");
      AppMethodBeat.o(224044);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(224046);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(224046);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(224042);
      p.k(paramCharSequence, "s");
      MMClearEditText.a(this.YaG);
      AppMethodBeat.o(224042);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "arg0", "Landroid/view/View;", "kotlin.jvm.PlatformType", "arg1", "", "onFocusChange"})
  static final class c
    implements View.OnFocusChangeListener
  {
    c(MMClearEditText paramMMClearEditText) {}
    
    public final void onFocusChange(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(223496);
      View.OnFocusChangeListener localOnFocusChangeListener = MMClearEditText.b(this.YaG);
      if (localOnFocusChangeListener != null) {
        localOnFocusChangeListener.onFocusChange(paramView, paramBoolean);
      }
      MMClearEditText.a(this.YaG);
      AppMethodBeat.o(223496);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(MMClearEditText paramMMClearEditText) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200715);
      paramView = this.YaG;
      if (paramView.getCompoundDrawables()[2] == null)
      {
        AppMethodBeat.o(200715);
        return false;
      }
      p.j(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() != 1)
      {
        AppMethodBeat.o(200715);
        return false;
      }
      float f = paramMotionEvent.getX();
      int i = paramView.getWidth();
      int j = paramView.getPaddingRight();
      paramMotionEvent = this.YaG.getImgX();
      p.j(paramMotionEvent, "imgX");
      if (f > i - j - paramMotionEvent.getIntrinsicWidth())
      {
        paramView.setText((CharSequence)"");
        MMClearEditText.c(this.YaG);
      }
      AppMethodBeat.o(200715);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */