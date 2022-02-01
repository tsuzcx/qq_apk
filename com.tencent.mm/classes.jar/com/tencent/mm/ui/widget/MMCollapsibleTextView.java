package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.af;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_collapseButton", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "get_collapseButton", "()Landroid/widget/TextView;", "_collapseButton$delegate", "Lkotlin/Lazy;", "_collapseImage", "Landroid/widget/ImageView;", "get_collapseImage", "()Landroid/widget/ImageView;", "_collapseImage$delegate", "_collapseLastRight", "", "_contentBackupText", "get_contentBackupText", "_contentBackupText$delegate", "_contentText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "get_contentText", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "_contentText$delegate", "_expandLastRight", "centerContentPlaceHolder", "Landroidx/constraintlayout/widget/Placeholder;", "getCenterContentPlaceHolder", "()Landroidx/constraintlayout/widget/Placeholder;", "centerContentPlaceHolder$delegate", "collapseButton", "Landroid/view/View;", "getCollapseButton", "()Landroid/view/View;", "collapseButtonExpendText", "getCollapseButtonExpendText", "()I", "setCollapseButtonExpendText", "(I)V", "collapsed", "", "getCollapsed", "()Z", "setCollapsed", "(Z)V", "contentText", "getContentText", "fullContentPlaceHolder", "getFullContentPlaceHolder", "fullContentPlaceHolder$delegate", "imageCollapse", "isSpecialText", "setSpecialText", "lastLineHeight", "getLastLineHeight", "lastLineRight", "getLastLineRight", "()F", "layoutId", "leftBottomCollapsePlaceHolder", "getLeftBottomCollapsePlaceHolder", "leftBottomCollapsePlaceHolder$delegate", "mContext", "maxLines", "needCollapse", "noCollapseCenter", "onCollapse", "Lkotlin/Function0;", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function0;", "setOnCollapse", "(Lkotlin/jvm/functions/Function0;)V", "onExpand", "getOnExpand", "setOnExpand", "preMeasureWidth", "resource", "Landroid/content/res/Resources;", "getResource", "()Landroid/content/res/Resources;", "resource$delegate", "rightBottomCollapsePlaceHolder", "getRightBottomCollapsePlaceHolder", "rightBottomCollapsePlaceHolder$delegate", "rightCollapse", "rightCollapsePlaceHolder", "getRightCollapsePlaceHolder", "rightCollapsePlaceHolder$delegate", "text", "", "textSize", "getTextSize", "textUpdated", "dpToPixel", "getDpToPixel", "(F)F", "_setText", "calcRightOffset", "layout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "init", "measureTruncate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetRightOffset", "setCollapseButtonText", "setCollapseStatus", "setMaxLines", "setOnTextTouchListener", "l", "Landroid/view/View$OnTouchListener;", "setText", "isRequestLayout", "setTextSize", "unit", "size", "setupCollapseButton", "setupRightCollapsePosition", "switch", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMCollapsibleTextView
  extends ConstraintLayout
{
  private final int VWi;
  private final j afSA;
  private boolean afSB;
  private boolean afSC;
  private boolean afSD;
  private boolean afSE;
  private final j afSF;
  private final j afSG;
  private final j afSH;
  private final j afSI;
  private final j afSJ;
  private final j afSK;
  private final j afSL;
  private final j afSM;
  private final j afSN;
  private boolean afSO;
  private kotlin.g.a.a<ah> afSP;
  private kotlin.g.a.a<ah> afSQ;
  private int afSR;
  private float afSS;
  private float afST;
  private int afSU;
  private CharSequence bba;
  private Context mContext;
  private int maxLines;
  private boolean vZb;
  private boolean vpw;
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140979);
    this.afSA = k.cm((kotlin.g.a.a)new h(this));
    this.maxLines = 2147483647;
    this.VWi = a.h.mm_collapsible_textview_v2;
    this.bba = ((CharSequence)"");
    this.afSF = k.cm((kotlin.g.a.a)new d(this));
    this.afSG = k.cm((kotlin.g.a.a)new c(this));
    this.afSH = k.cm((kotlin.g.a.a)new a(this));
    this.afSI = k.cm((kotlin.g.a.a)new b(this));
    this.afSJ = k.cm((kotlin.g.a.a)new f(this));
    this.afSK = k.cm((kotlin.g.a.a)new e(this));
    this.afSL = k.cm((kotlin.g.a.a)new g(this));
    this.afSM = k.cm((kotlin.g.a.a)new i(this));
    this.afSN = k.cm((kotlin.g.a.a)new j(this));
    this.afSO = true;
    this.afSR = -1;
    this.afSS = -1.0F;
    this.afST = -1.0F;
    this.afSU = a.k.expend;
    this.mContext = paramContext;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(140979);
  }
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140980);
    this.afSA = k.cm((kotlin.g.a.a)new h(this));
    this.maxLines = 2147483647;
    this.VWi = a.h.mm_collapsible_textview_v2;
    this.bba = ((CharSequence)"");
    this.afSF = k.cm((kotlin.g.a.a)new d(this));
    this.afSG = k.cm((kotlin.g.a.a)new c(this));
    this.afSH = k.cm((kotlin.g.a.a)new a(this));
    this.afSI = k.cm((kotlin.g.a.a)new b(this));
    this.afSJ = k.cm((kotlin.g.a.a)new f(this));
    this.afSK = k.cm((kotlin.g.a.a)new e(this));
    this.afSL = k.cm((kotlin.g.a.a)new g(this));
    this.afSM = k.cm((kotlin.g.a.a)new i(this));
    this.afSN = k.cm((kotlin.g.a.a)new j(this));
    this.afSO = true;
    this.afSR = -1;
    this.afSS = -1.0F;
    this.afST = -1.0F;
    this.afSU = a.k.expend;
    this.mContext = paramContext;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(140980);
  }
  
  private static final void a(int paramInt, MMCollapsibleTextView paramMMCollapsibleTextView, View paramView)
  {
    AppMethodBeat.i(251704);
    s.u(paramMMCollapsibleTextView, "this$0");
    s.u(paramView, "$this_apply");
    Rect localRect = new Rect();
    paramInt = (int)(paramInt * 1.5F);
    paramMMCollapsibleTextView.get_collapseImage().getHitRect(localRect);
    localRect.top -= paramInt;
    localRect.left -= paramInt;
    localRect.bottom += paramInt;
    localRect.right = (paramInt + localRect.right);
    paramView.setTouchDelegate(new TouchDelegate(localRect, (View)paramMMCollapsibleTextView.get_collapseImage()));
    AppMethodBeat.o(251704);
  }
  
  private static final void a(MMCollapsibleTextView paramMMCollapsibleTextView, View paramView)
  {
    AppMethodBeat.i(251706);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramMMCollapsibleTextView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMCollapsibleTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMMCollapsibleTextView, "this$0");
    boolean bool;
    if (!paramMMCollapsibleTextView.afSO)
    {
      bool = true;
      paramMMCollapsibleTextView.afSO = bool;
      if (!paramMMCollapsibleTextView.afSO) {
        break label160;
      }
      paramView = paramMMCollapsibleTextView.afSP;
      if (paramView != null) {
        paramView.invoke();
      }
    }
    for (;;)
    {
      paramMMCollapsibleTextView.setCollapseStatus(paramMMCollapsibleTextView.afSO);
      if ((paramMMCollapsibleTextView.vpw) && (paramMMCollapsibleTextView.afSD)) {
        paramMMCollapsibleTextView.jEC();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/widget/MMCollapsibleTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251706);
      return;
      bool = false;
      break;
      label160:
      paramView = paramMMCollapsibleTextView.afSQ;
      if (paramView != null) {
        paramView.invoke();
      }
    }
  }
  
  private final Placeholder getCenterContentPlaceHolder()
  {
    AppMethodBeat.i(251652);
    Placeholder localPlaceholder = (Placeholder)this.afSK.getValue();
    AppMethodBeat.o(251652);
    return localPlaceholder;
  }
  
  private final View getCollapseButton()
  {
    AppMethodBeat.i(140972);
    if (this.afSE)
    {
      localView = (View)get_collapseImage();
      AppMethodBeat.o(140972);
      return localView;
    }
    View localView = (View)get_collapseButton();
    AppMethodBeat.o(140972);
    return localView;
  }
  
  private final Placeholder getFullContentPlaceHolder()
  {
    AppMethodBeat.i(251648);
    Placeholder localPlaceholder = (Placeholder)this.afSJ.getValue();
    AppMethodBeat.o(251648);
    return localPlaceholder;
  }
  
  private final int getLastLineHeight()
  {
    AppMethodBeat.i(140974);
    if (this.vZb)
    {
      i = get_contentBackupText().getLineHeight();
      AppMethodBeat.o(140974);
      return i;
    }
    int i = get_contentText().getLineHeight();
    AppMethodBeat.o(140974);
    return i;
  }
  
  private final float getLastLineRight()
  {
    if (this.afSO) {
      return this.afSS;
    }
    return this.afST;
  }
  
  private final Placeholder getLeftBottomCollapsePlaceHolder()
  {
    AppMethodBeat.i(251656);
    Placeholder localPlaceholder = (Placeholder)this.afSL.getValue();
    AppMethodBeat.o(251656);
    return localPlaceholder;
  }
  
  private final Resources getResource()
  {
    AppMethodBeat.i(140958);
    Resources localResources = (Resources)this.afSA.getValue();
    AppMethodBeat.o(140958);
    return localResources;
  }
  
  private final Placeholder getRightBottomCollapsePlaceHolder()
  {
    AppMethodBeat.i(251662);
    Placeholder localPlaceholder = (Placeholder)this.afSM.getValue();
    AppMethodBeat.o(251662);
    return localPlaceholder;
  }
  
  private final Placeholder getRightCollapsePlaceHolder()
  {
    AppMethodBeat.i(251666);
    Placeholder localPlaceholder = (Placeholder)this.afSN.getValue();
    AppMethodBeat.o(251666);
    return localPlaceholder;
  }
  
  private final ImageView get_collapseImage()
  {
    AppMethodBeat.i(140962);
    ImageView localImageView = (ImageView)this.afSI.getValue();
    AppMethodBeat.o(140962);
    return localImageView;
  }
  
  private final void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(140968);
    int m = -1;
    int n = -1;
    int i1 = -1;
    int i2 = -1;
    int i3 = i2;
    int i = i1;
    int j = n;
    int k = m;
    int i4;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.m.MMCollapsibleTextView, paramInt, 0);
      paramInt = 0;
      i4 = paramAttributeSet.getIndexCount();
      i3 = i2;
      i = i1;
      j = n;
      k = m;
      if (i4 <= 0) {}
    }
    for (;;)
    {
      i3 = paramInt + 1;
      int i5 = paramAttributeSet.getIndex(paramInt);
      if (i5 == a.m.MMCollapsibleTextView_android_maxLines)
      {
        this.maxLines = paramAttributeSet.getInt(i5, 2147483647);
        k = m;
        j = n;
        i = i1;
        paramInt = i2;
      }
      while (i3 >= i4)
      {
        i3 = paramInt;
        af.mU(this.mContext).inflate(this.VWi, (ViewGroup)this);
        if (i != -1) {
          get_collapseButton().setTextColor(i);
        }
        if (j != -1)
        {
          get_contentText().setTextColor(j);
          get_contentBackupText().setTextColor(j);
        }
        if (k != -1)
        {
          get_collapseButton().setTextSize(0, k);
          get_contentText().setTextSize(0, k);
          get_contentBackupText().setTextSize(0, k);
        }
        if (i3 != -1)
        {
          get_contentText().setSpacingAdd(i3);
          get_contentBackupText().setLineSpacing(i3, 1.0F);
        }
        getFullContentPlaceHolder().setEmptyVisibility(8);
        getCenterContentPlaceHolder().setEmptyVisibility(8);
        getLeftBottomCollapsePlaceHolder().setEmptyVisibility(8);
        getRightBottomCollapsePlaceHolder().setEmptyVisibility(8);
        getRightCollapsePlaceHolder().setEmptyVisibility(8);
        AppMethodBeat.o(140968);
        return;
        if (i5 == a.m.MMCollapsibleTextView_android_textSize)
        {
          k = paramAttributeSet.getDimensionPixelSize(i5, m);
          paramInt = i2;
          i = i1;
          j = n;
        }
        else if (i5 == a.m.MMCollapsibleTextView_android_textColor)
        {
          j = paramAttributeSet.getColor(i5, n);
          paramInt = i2;
          i = i1;
          k = m;
        }
        else if (i5 == a.m.MMCollapsibleTextView_android_textColorLink)
        {
          i = paramAttributeSet.getColor(i5, i1);
          paramInt = i2;
          j = n;
          k = m;
        }
        else if (i5 == a.m.MMCollapsibleTextView_android_lineSpacingExtra)
        {
          paramInt = paramAttributeSet.getDimensionPixelSize(i5, i2);
          i = i1;
          j = n;
          k = m;
        }
        else
        {
          boolean bool;
          if (i5 == a.m.MMCollapsibleTextView_collapseButtonPosition)
          {
            if (paramAttributeSet.getInt(i5, 0) != 0) {}
            for (bool = true;; bool = false)
            {
              this.afSD = bool;
              paramInt = i2;
              i = i1;
              j = n;
              k = m;
              break;
            }
          }
          if (i5 == a.m.MMCollapsibleTextView_noCollapseCenter)
          {
            this.afSC = paramAttributeSet.getBoolean(i5, this.afSC);
            paramInt = i2;
            i = i1;
            j = n;
            k = m;
          }
          else
          {
            paramInt = i2;
            i = i1;
            j = n;
            k = m;
            if (i5 == a.m.MMCollapsibleTextView_collapseButtonStyle)
            {
              if (paramAttributeSet.getInt(i5, 0) != 0) {}
              for (bool = true;; bool = false)
              {
                this.afSE = bool;
                paramInt = i2;
                i = i1;
                j = n;
                k = m;
                break;
              }
            }
          }
        }
      }
      i2 = paramInt;
      i1 = i;
      n = j;
      m = k;
      paramInt = i3;
    }
  }
  
  private final void jEC()
  {
    AppMethodBeat.i(140977);
    float f;
    if (this.vZb) {
      f = this.afSR * 3.0F / 4.0F;
    }
    while (getLastLineRight() < f)
    {
      Object localObject = getRightCollapsePlaceHolder().getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(140977);
        throw ((Throwable)localObject);
        f = this.afSR - getCollapseButton().getMeasuredWidth();
      }
      else
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (Math.max(0, getLastLineHeight() - getCollapseButton().getMeasuredHeight()) / 2 + 1);
        getRightCollapsePlaceHolder().setLayoutParams((ViewGroup.LayoutParams)localObject);
        getRightBottomCollapsePlaceHolder().setContentId(-1);
        getRightCollapsePlaceHolder().setContentId(getCollapseButton().getId());
        getRightCollapsePlaceHolder().a((ConstraintLayout)this);
        AppMethodBeat.o(140977);
        return;
      }
    }
    getRightCollapsePlaceHolder().setContentId(-1);
    getRightBottomCollapsePlaceHolder().setContentId(getCollapseButton().getId());
    getRightBottomCollapsePlaceHolder().a((ConstraintLayout)this);
    AppMethodBeat.o(140977);
  }
  
  private final void setCollapseStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(140976);
    Object localObject;
    if (this.afSE)
    {
      localObject = get_collapseImage();
      if (paramBoolean)
      {
        i = a.j.expend;
        ((ImageView)localObject).setImageResource(i);
        if (!paramBoolean) {
          break label88;
        }
      }
    }
    label88:
    for (int i = this.maxLines;; i = 2147483647)
    {
      setMaxLines(i);
      AppMethodBeat.o(140976);
      return;
      i = a.j.collapse;
      break;
      localObject = get_collapseButton();
      if (paramBoolean) {}
      for (i = this.afSU;; i = a.k.collapse)
      {
        ((TextView)localObject).setText(i);
        break;
      }
    }
  }
  
  private final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(140970);
    if (this.vZb)
    {
      get_contentBackupText().setMaxLines(paramInt);
      AppMethodBeat.o(140970);
      return;
    }
    get_contentText().setMaxLines(paramInt);
    AppMethodBeat.o(140970);
  }
  
  public final int getCollapseButtonExpendText()
  {
    return this.afSU;
  }
  
  public final boolean getCollapsed()
  {
    return this.afSO;
  }
  
  public final View getContentText()
  {
    AppMethodBeat.i(140971);
    if (this.vZb)
    {
      localObject = get_contentBackupText();
      s.s(localObject, "_contentBackupText");
      localObject = (View)localObject;
      AppMethodBeat.o(140971);
      return localObject;
    }
    Object localObject = get_contentText();
    s.s(localObject, "_contentText");
    localObject = (View)localObject;
    AppMethodBeat.o(140971);
    return localObject;
  }
  
  public final kotlin.g.a.a<ah> getOnCollapse()
  {
    return this.afSP;
  }
  
  public final kotlin.g.a.a<ah> getOnExpand()
  {
    return this.afSQ;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(140969);
    float f = get_contentText().getTextSize();
    AppMethodBeat.o(140969);
    return f;
  }
  
  public final TextView get_collapseButton()
  {
    AppMethodBeat.i(140961);
    TextView localTextView = (TextView)this.afSH.getValue();
    AppMethodBeat.o(140961);
    return localTextView;
  }
  
  public final TextView get_contentBackupText()
  {
    AppMethodBeat.i(140960);
    TextView localTextView = (TextView)this.afSG.getValue();
    AppMethodBeat.o(140960);
    return localTextView;
  }
  
  public final MMNeat7extView get_contentText()
  {
    AppMethodBeat.i(140959);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.afSF.getValue();
    AppMethodBeat.o(140959);
    return localMMNeat7extView;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140975);
    int i = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    com.tencent.neattextview.textview.layout.a locala;
    boolean bool;
    label127:
    Object localObject;
    label161:
    label315:
    label338:
    float f1;
    if ((this.afSB) || (i != this.afSR))
    {
      this.afSS = -1.0F;
      this.afST = -1.0F;
      this.afSB = false;
      this.afSR = i;
      get_contentText().setMaxLines(2147483647);
      get_contentText().aZ(this.bba);
      this.vZb = get_contentText().vZb;
      locala = get_contentText().pE(i, 2147483647);
      if (locala != null) {
        break label530;
      }
      i = 0;
      if (i <= this.maxLines) {
        break label542;
      }
      bool = true;
      this.vpw = bool;
      if ((this.afSC) && (!this.vpw)) {
        break label548;
      }
      getFullContentPlaceHolder().setContentId(getContentText().getId());
      if (this.vpw)
      {
        getCollapseButton().setOnClickListener(new MMCollapsibleTextView..ExternalSyntheticLambda0(this));
        getCollapseButton().setVisibility(0);
        if (!this.afSD) {
          getLeftBottomCollapsePlaceHolder().setContentId(getCollapseButton().getId());
        }
        setCollapseStatus(this.afSO);
        if (this.afSD)
        {
          if (!this.afSE) {
            break label571;
          }
          i = (int)(getLastLineHeight() * 0.8F);
          localObject = get_collapseImage().getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = i;
          get_collapseImage().setLayoutParams((ViewGroup.LayoutParams)localObject);
          get_collapseImage().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
          localObject = get_collapseImage().getParent();
          if (!(localObject instanceof View)) {
            break label565;
          }
          localObject = (View)localObject;
          if (localObject != null) {
            ((View)localObject).post(new MMCollapsibleTextView..ExternalSyntheticLambda1(i, this, (View)localObject));
          }
          f1 = getResource().getDisplayMetrics().density;
          float f2 = getCollapseButton().getMeasuredWidth();
          get_contentText().a(TextUtils.TruncateAt.END, f1 * 1.0F + 0.5F + f2);
          if (locala != null)
          {
            s.s(locala, "layout");
            i = this.maxLines;
            int j = locala.jQH();
            if (!this.vZb) {
              break label591;
            }
            f1 = locala.aGL(i - 1);
            label426:
            this.afSS = f1;
            this.afST = locala.aGL(j - 1);
          }
          jEC();
        }
      }
      localObject = this.bba;
      if (!this.vZb) {
        break label596;
      }
      get_contentBackupText().setVisibility(0);
      get_contentText().setVisibility(8);
      get_contentBackupText().setText((CharSequence)localObject);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((!this.vpw) && (getCollapseButton().getVisibility() != 8)) {
        getCollapseButton().setVisibility(8);
      }
      AppMethodBeat.o(140975);
      return;
      label530:
      i = locala.jQH();
      break;
      label542:
      bool = false;
      break label127;
      label548:
      getCenterContentPlaceHolder().setContentId(getContentText().getId());
      break label161;
      label565:
      localObject = null;
      break label315;
      label571:
      get_collapseButton().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      break label338;
      label591:
      f1 = 0.0F;
      break label426;
      label596:
      get_contentText().setVisibility(0);
      get_contentBackupText().setVisibility(8);
      get_contentText().aZ((CharSequence)localObject);
    }
  }
  
  public final void setCollapseButtonExpendText(int paramInt)
  {
    this.afSU = paramInt;
  }
  
  public final void setCollapseButtonText(int paramInt)
  {
    this.afSU = paramInt;
  }
  
  public final void setCollapsed(boolean paramBoolean)
  {
    this.afSO = paramBoolean;
  }
  
  public final void setOnCollapse(kotlin.g.a.a<ah> parama)
  {
    this.afSP = parama;
  }
  
  public final void setOnExpand(kotlin.g.a.a<ah> parama)
  {
    this.afSQ = parama;
  }
  
  public final void setOnTextTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(140973);
    get_contentBackupText().setOnTouchListener(paramOnTouchListener);
    get_contentText().setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(140973);
  }
  
  public final void setSpecialText(boolean paramBoolean)
  {
    this.vZb = paramBoolean;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(140978);
    s.u(paramCharSequence, "text");
    s.u(paramCharSequence, "text");
    this.bba = paramCharSequence;
    this.afSB = true;
    AppMethodBeat.o(140978);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    b(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MMNeat7extView>
  {
    d(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Placeholder>
  {
    e(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Placeholder>
  {
    f(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<Placeholder>
  {
    g(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Resources>
  {
    h(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<Placeholder>
  {
    i(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<Placeholder>
  {
    j(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */