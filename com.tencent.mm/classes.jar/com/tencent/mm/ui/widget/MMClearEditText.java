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
import com.tencent.mm.ck.a.b;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.i.c.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/MMClearEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imgX", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getImgX", "()Landroid/graphics/drawable/Drawable;", "setImgX", "(Landroid/graphics/drawable/Drawable;)V", "isClearBtnAlwaysDismiss", "", "mEnableRestoreState", "getMEnableRestoreState", "()Z", "setMEnableRestoreState", "(Z)V", "mOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "addClearButton", "", "getDefaultOnTouchListener", "init", "manageClearButton", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "processPaste", "srcString", "", "removeClearButton", "setClearBtnAlwaysDismiss", "setOnFocusChangeListener", "l", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMClearEditText
  extends MMEditText
{
  public static final MMClearEditText.a afSy;
  private View.OnFocusChangeListener Nzg;
  private boolean XYY;
  private Drawable XYZ;
  private boolean adPX;
  private final View.OnTouchListener pWX;
  
  static
  {
    AppMethodBeat.i(251568);
    afSy = new MMClearEditText.a((byte)0);
    AppMethodBeat.o(251568);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251537);
    this.XYZ = bd.by(getContext(), a.b.et_clear_selector);
    this.pWX = new MMClearEditText..ExternalSyntheticLambda1(this);
    init();
    AppMethodBeat.o(251537);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251535);
    this.XYZ = bd.by(getContext(), a.b.et_clear_selector);
    this.pWX = new MMClearEditText..ExternalSyntheticLambda1(this);
    init();
    AppMethodBeat.o(251535);
  }
  
  private static final void a(MMClearEditText paramMMClearEditText, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(251556);
    s.u(paramMMClearEditText, "this$0");
    View.OnFocusChangeListener localOnFocusChangeListener = paramMMClearEditText.Nzg;
    if (localOnFocusChangeListener != null) {
      localOnFocusChangeListener.onFocusChange(paramView, paramBoolean);
    }
    paramMMClearEditText.iKp();
    AppMethodBeat.o(251556);
  }
  
  private static final boolean a(MMClearEditText paramMMClearEditText, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251561);
    s.u(paramMMClearEditText, "this$0");
    if (paramMMClearEditText.getCompoundDrawables()[2] == null)
    {
      AppMethodBeat.o(251561);
      return false;
    }
    if (paramMotionEvent.getAction() != 1)
    {
      AppMethodBeat.o(251561);
      return false;
    }
    if (paramMotionEvent.getX() > paramMMClearEditText.getWidth() - paramMMClearEditText.getPaddingRight() - paramMMClearEditText.getImgX().getIntrinsicWidth())
    {
      paramMMClearEditText.setText((CharSequence)"");
      paramMMClearEditText.iKr();
    }
    AppMethodBeat.o(251561);
    return false;
  }
  
  private final void iKp()
  {
    AppMethodBeat.i(251545);
    if ((n.bp((CharSequence)getText().toString())) || (!isFocused()))
    {
      iKr();
      AppMethodBeat.o(251545);
      return;
    }
    iKq();
    AppMethodBeat.o(251545);
  }
  
  private final void iKq()
  {
    AppMethodBeat.i(251549);
    if (!this.adPX) {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.XYZ, getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(251549);
  }
  
  private final void iKr()
  {
    AppMethodBeat.i(251552);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(251552);
  }
  
  private final void init()
  {
    AppMethodBeat.i(251542);
    if (this.XYZ == null) {
      this.XYZ = bd.by(getContext(), a.b.et_clear_selector);
    }
    this.XYZ.setBounds(0, 0, this.XYZ.getIntrinsicWidth(), this.XYZ.getIntrinsicHeight());
    Log.i("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.XYZ.getIntrinsicWidth()), Integer.valueOf(this.XYZ.getIntrinsicHeight()) });
    iKp();
    setHeight(this.XYZ.getIntrinsicHeight() + getResources().getDimensionPixelSize(a.d.OneDPPadding) * 5);
    setOnTouchListener(this.pWX);
    addTextChangedListener((TextWatcher)new b(this));
    super.setOnFocusChangeListener(new MMClearEditText..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(251542);
  }
  
  public final void bqF(String paramString)
  {
    AppMethodBeat.i(251585);
    s.u(paramString, "srcString");
    int i = getSelectionStart();
    setText(b.c(getContext(), (CharSequence)paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i = j + i;
      if (i <= getText().length())
      {
        setSelection(i);
        AppMethodBeat.o(251585);
      }
    }
    else
    {
      setSelection(i);
    }
    AppMethodBeat.o(251585);
  }
  
  public final View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.pWX;
  }
  
  public final Drawable getImgX()
  {
    return this.XYZ;
  }
  
  public final boolean getMEnableRestoreState()
  {
    return this.XYY;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(251593);
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(251593);
      return;
    }
    if (!this.XYY) {
      paramParcelable = (Parcelable)View.BaseSavedState.EMPTY_STATE;
    }
    for (;;)
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(251593);
      return;
    }
  }
  
  public final void setImgX(Drawable paramDrawable)
  {
    this.XYZ = paramDrawable;
  }
  
  public final void setMEnableRestoreState(boolean paramBoolean)
  {
    this.XYY = paramBoolean;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.Nzg = paramOnFocusChangeListener;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/MMClearEditText$init$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "arg0", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    b(MMClearEditText paramMMClearEditText) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(251632);
      s.u(paramEditable, "arg0");
      AppMethodBeat.o(251632);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(251637);
      s.u(paramCharSequence, "s");
      AppMethodBeat.o(251637);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(251625);
      s.u(paramCharSequence, "s");
      MMClearEditText.a(this.afSz);
      AppMethodBeat.o(251625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */