package com.tencent.mm.plugin.story.ui.view.editor;

import a.a.e;
import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.InsectRelativeLayout;
import com.tencent.mm.media.editor.view.TextColorSelector;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.MMTextView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "IMPUT_LINES_LIMIT", "INPUT_LIMIT", "TAG", "", "addTipGroup", "Landroid/view/View;", "addTipInput", "Landroid/widget/EditText;", "addTipOverSizeIndicator", "Lcom/tencent/mm/ui/widget/MMTextView;", "animatorColorPanel", "Landroid/view/ViewPropertyAnimator;", "animatorInputPanel", "animatorInputTipPanel", "bgColor", "bgToggle", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;)V", "cancel", "colorSelector", "Lcom/tencent/mm/media/editor/view/TextColorSelector;", "colorSelectorGroup", "confirm", "getConfirm", "()Landroid/view/View;", "setConfirm", "(Landroid/view/View;)V", "hasBackground", "", "getHasBackground", "()Z", "setHasBackground", "(Z)V", "headerPanel", "input", "Lcom/tencent/mm/plugin/story/ui/view/editor/PhotoEditText;", "inputRoot", "Landroid/view/ViewGroup;", "lastBottom", "mode", "realDisplayHeight", "value", "selectedIndex", "setSelectedIndex", "(I)V", "showImeRunnable", "Ljava/lang/Runnable;", "textColor", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "waitKeyBoardShown", "animationWithColorPanel", "toTransY", "", "animationWithInputPanel", "animationWithTipPanel", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "isShow", "resetTranslation", "setConfirmBtnColor", "color", "setImeVisibility", "setOnVisibleChangeCallback", "setShow", "show", "setVisibility", "visibility", "setup", "text", "", "textBgColor", "setupTextMode", "setupTipMode", "switchMode", "updateInput", "AddTextCallback", "Companion", "plugin-story_release"})
public final class EditorInputView
  extends InsectRelativeLayout
{
  private static final int[] sMX;
  private static final int sPi = -1;
  private static final int sPj = -419430401;
  private static final int sPk;
  private static final int sPl;
  private static final int sPm = 0;
  private static final int sPn = 1;
  public static final EditorInputView.b sPo;
  private final String TAG;
  private int aRn;
  private int bgColor;
  private b<? super Boolean, y> eTl;
  private View lzo;
  private View lzp;
  private final TextColorSelector lzr;
  private int lzw;
  private boolean lzx;
  private final Runnable lzz;
  int mode;
  private final int sOS;
  private final int sOT;
  PhotoEditText sOU;
  private ViewGroup sOV;
  private View sOW;
  private final ImageView sOX;
  private final View sOY;
  private final View sOZ;
  final EditText sPa;
  private final MMTextView sPb;
  private ViewPropertyAnimator sPc;
  private ViewPropertyAnimator sPd;
  private ViewPropertyAnimator sPe;
  private int sPf;
  EditorInputView.a sPg;
  private boolean sPh;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(110565);
    sPo = new EditorInputView.b((byte)0);
    sPi = -1;
    sPj = -419430401;
    int[] arrayOfInt = new int[7];
    arrayOfInt[0] = -1;
    arrayOfInt[1] = -16777216;
    arrayOfInt[2] = -372399;
    arrayOfInt[3] = -15616;
    arrayOfInt[4] = -16268960;
    arrayOfInt[5] = -15683841;
    arrayOfInt[6] = -10197008;
    arrayOfInt;
    sMX = arrayOfInt;
    sPk = arrayOfInt[1];
    sPl = sMX[0] & sPj;
    sPn = 1;
    AppMethodBeat.o(110565);
  }
  
  public EditorInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110564);
    AppMethodBeat.o(110564);
  }
  
  public EditorInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110563);
    this.TAG = "MicroMsg.EditorInputView";
    this.sOS = 108;
    this.sOT = 7;
    this.mode = sPm;
    this.sPf = am.hQ(paramContext).y;
    View.inflate(paramContext, 2130969354, (ViewGroup)this);
    setBackgroundColor(getResources().getColor(2131690544));
    paramAttributeSet = findViewById(2131823522);
    j.p(paramAttributeSet, "findViewById(R.id.change_text_input)");
    this.sOU = ((PhotoEditText)paramAttributeSet);
    paramAttributeSet = findViewById(2131823521);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_input_root)");
    this.sOV = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131823515);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_input_header)");
    this.sOW = paramAttributeSet;
    paramAttributeSet = findViewById(2131823516);
    j.p(paramAttributeSet, "findViewById(R.id.change_text_cancel)");
    this.lzo = paramAttributeSet;
    paramAttributeSet = findViewById(2131823517);
    j.p(paramAttributeSet, "findViewById(R.id.change_text_confirm)");
    this.lzp = paramAttributeSet;
    if (af.hW(paramContext)) {
      this.sOW.setPadding(this.sOW.getPaddingLeft(), af.hV(paramContext) + al.ap(paramContext, 2131427582), this.sOW.getPaddingRight(), this.sOW.getPaddingBottom());
    }
    paramContext = findViewById(2131823519);
    j.p(paramContext, "findViewById(R.id.story_editor_input_bg_toggle)");
    this.sOX = ((ImageView)paramContext);
    paramContext = findViewById(2131823520);
    j.p(paramContext, "findViewById(R.id.story_…tor_input_color_selector)");
    this.lzr = ((TextColorSelector)paramContext);
    paramContext = findViewById(2131823518);
    j.p(paramContext, "findViewById(R.id.story_editor_input_color)");
    this.sOY = paramContext;
    paramContext = findViewById(2131823523);
    j.p(paramContext, "findViewById(R.id.story_editor_tip_input_root)");
    this.sOZ = paramContext;
    paramContext = findViewById(2131823524);
    j.p(paramContext, "findViewById(R.id.tip_text_input)");
    this.sPa = ((EditText)paramContext);
    paramContext = findViewById(2131823525);
    j.p(paramContext, "findViewById(R.id.tip_over_size_indicator)");
    this.sPb = ((MMTextView)paramContext);
    this.sOU.setOnFocusChangeListener((View.OnFocusChangeListener)new EditorInputView.1(this));
    this.sOZ.setTranslationY(this.sPf);
    this.sOV.setTranslationY(this.sPf);
    this.sOY.setTranslationY(this.sPf);
    this.sPa.setOnFocusChangeListener((View.OnFocusChangeListener)new EditorInputView.2(this));
    this.sPa.addTextChangedListener((TextWatcher)new EditorInputView.3(this));
    this.lzo.setOnClickListener((View.OnClickListener)new EditorInputView.4(this));
    this.lzp.setOnClickListener((View.OnClickListener)new EditorInputView.5(this));
    setOnClickListener((View.OnClickListener)new EditorInputView.6(this));
    this.sOX.setOnClickListener((View.OnClickListener)new EditorInputView.7(this));
    this.lzr.setColorSelectedCallback((b)new EditorInputView.8(this));
    this.lzr.setColorList(sMX);
    this.lzr.setSelected(0);
    this.sOU.setTypeface(this.sOU.getTypeface(), 1);
    this.lzz = ((Runnable)new EditorInputView.c(this));
    AppMethodBeat.o(110563);
  }
  
  private final void cFG()
  {
    AppMethodBeat.i(110558);
    int i;
    if (this.sPh)
    {
      this.bgColor = (sMX[this.aRn] & sPj);
      switch (this.aRn)
      {
      default: 
        i = sMX[0];
        this.textColor = i;
      }
    }
    for (;;)
    {
      this.sOU.setTextColor(this.textColor);
      this.sOU.setTextBackground(this.bgColor);
      this.sOU.postInvalidate();
      AppMethodBeat.o(110558);
      return;
      i = sMX[1];
      break;
      this.textColor = (sMX[this.aRn] & sPi);
      this.bgColor = 0;
    }
  }
  
  private final void g(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151220);
    this.sOU.setText(paramCharSequence);
    if (paramCharSequence != null) {
      this.sOU.setSelection(paramCharSequence.length());
    }
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.sPh = bool;
      if (this.sPh) {
        paramInt1 = paramInt2 | sPj ^ 0xFFFFFFFF;
      }
      setSelectedIndex(e.k(sMX, paramInt1));
      this.lzr.setSelected(this.aRn);
      this.sOX.setActivated(this.sPh);
      cFG();
      AppMethodBeat.o(151220);
      return;
    }
  }
  
  private final void l(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(151219);
    this.sPa.setText(paramCharSequence);
    if (paramCharSequence != null) {
      this.sPa.setSelection(paramCharSequence.length());
    }
    this.sPa.setTextColor(paramInt);
    this.sPa.postInvalidate();
    AppMethodBeat.o(151219);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(110560);
    if (paramBoolean)
    {
      post(this.lzz);
      AppMethodBeat.o(110560);
      return;
    }
    removeCallbacks(this.lzz);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(110560);
      return;
    }
    AppMethodBeat.o(110560);
  }
  
  private final void setSelectedIndex(int paramInt)
  {
    this.aRn = paramInt;
    if (this.aRn < 0) {
      this.aRn = 0;
    }
  }
  
  public final void bi(float paramFloat)
  {
    AppMethodBeat.i(110557);
    this.sOV.setPadding((int)paramFloat, 0, (int)paramFloat, 0);
    AppMethodBeat.o(110557);
  }
  
  public final void f(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151218);
    int i = this.mode;
    if (i == sPm)
    {
      g(paramCharSequence, paramInt1, paramInt2);
      AppMethodBeat.o(151218);
      return;
    }
    if (i == sPn) {
      l(paramCharSequence, paramInt1);
    }
    AppMethodBeat.o(151218);
  }
  
  public final EditorInputView.a getCallback()
  {
    return this.sPg;
  }
  
  public final View getConfirm()
  {
    return this.lzp;
  }
  
  public final boolean getHasBackground()
  {
    return this.sPh;
  }
  
  public final boolean jk(int paramInt)
  {
    AppMethodBeat.i(110561);
    this.lzw = paramInt;
    ab.d(this.TAG, "realDisplayHeight:" + this.sPf + " bottom:" + paramInt + " colorSelectorGroup.measuredHeight:" + this.sOY.getMeasuredHeight() + " headerPanel.measuredHeight:" + this.sOW.getMeasuredHeight() + " WeUIToolHelper.getStatusBarHeight(context):" + am.getStatusBarHeight(getContext()) + " inputRoot.measuredHeight:" + this.sOV.getMeasuredHeight());
    float f;
    ViewPropertyAnimator localViewPropertyAnimator;
    if (this.mode == sPm)
    {
      int i = this.sOW.getMeasuredHeight();
      int j = (this.sPf - paramInt - this.sOY.getMeasuredHeight() - i - this.sOV.getMeasuredHeight()) / 2;
      int k = this.sPf;
      int m = this.sOY.getMeasuredHeight();
      f = i + j;
      ab.d(this.TAG, "animationWithInputPanel ".concat(String.valueOf(f)));
      localViewPropertyAnimator = this.sPd;
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.cancel();
      }
      this.sPd = this.sOV.animate().translationY(f);
      localViewPropertyAnimator = this.sPd;
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.start();
      }
      f = k - paramInt - m;
      ab.d(this.TAG, "animationWithColorPanel ".concat(String.valueOf(f)));
      localViewPropertyAnimator = this.sPc;
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.cancel();
      }
      this.sPc = this.sOY.animate().translationY(f);
      localViewPropertyAnimator = this.sPc;
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.start();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(110561);
      return true;
      f = this.sPf - paramInt - this.sOZ.getMeasuredHeight();
      ab.d(this.TAG, "animationWithTipPanel ".concat(String.valueOf(f)));
      localViewPropertyAnimator = this.sPe;
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.cancel();
      }
      this.sPe = this.sOZ.animate().translationY(f);
      localViewPropertyAnimator = this.sPe;
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.start();
      }
    }
  }
  
  public final void setCallback(EditorInputView.a parama)
  {
    this.sPg = parama;
  }
  
  public final void setConfirm(View paramView)
  {
    AppMethodBeat.i(151217);
    j.q(paramView, "<set-?>");
    this.lzp = paramView;
    AppMethodBeat.o(151217);
  }
  
  public final void setConfirmBtnColor(int paramInt)
  {
    AppMethodBeat.i(151221);
    this.lzp.setBackgroundColor(paramInt);
    AppMethodBeat.o(151221);
  }
  
  public final void setHasBackground(boolean paramBoolean)
  {
    this.sPh = paramBoolean;
  }
  
  public final void setOnVisibleChangeCallback(b<? super Boolean, y> paramb)
  {
    this.eTl = paramb;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(110559);
    if (paramBoolean)
    {
      setVisibility(0);
      localb = this.eTl;
      if (localb != null) {
        localb.S(Boolean.TRUE);
      }
      if (this.mode == sPm)
      {
        this.sOZ.setVisibility(8);
        this.sOY.setVisibility(0);
        this.sOV.setVisibility(0);
        AppMethodBeat.o(110559);
        return;
      }
      if (this.mode == sPn)
      {
        this.sOV.setVisibility(8);
        this.sOY.setVisibility(0);
        this.sOZ.setVisibility(0);
      }
      AppMethodBeat.o(110559);
      return;
    }
    this.lzx = true;
    setVisibility(8);
    this.sOY.setTranslationY(this.sPf);
    this.sOV.setTranslationY(this.sPf);
    this.sOZ.setTranslationY(this.sPf);
    b localb = this.eTl;
    if (localb != null)
    {
      localb.S(Boolean.FALSE);
      AppMethodBeat.o(110559);
      return;
    }
    AppMethodBeat.o(110559);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(110562);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.mode == sPm)
      {
        this.sOU.requestFocus();
        AppMethodBeat.o(110562);
        return;
      }
      if (this.mode == sPn) {
        this.sPa.requestFocus();
      }
    }
    AppMethodBeat.o(110562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorInputView
 * JD-Core Version:    0.7.0.1
 */