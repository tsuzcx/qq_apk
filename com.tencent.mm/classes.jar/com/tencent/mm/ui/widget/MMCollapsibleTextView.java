package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
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
import com.tencent.mm.ui.ad;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_collapseButton", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "get_collapseButton", "()Landroid/widget/TextView;", "_collapseButton$delegate", "Lkotlin/Lazy;", "_collapseImage", "Landroid/widget/ImageView;", "get_collapseImage", "()Landroid/widget/ImageView;", "_collapseImage$delegate", "_collapseLastRight", "", "_contentBackupText", "get_contentBackupText", "_contentBackupText$delegate", "_contentText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "get_contentText", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "_contentText$delegate", "_expandLastRight", "centerContentPlaceHolder", "Landroidx/constraintlayout/widget/Placeholder;", "getCenterContentPlaceHolder", "()Landroidx/constraintlayout/widget/Placeholder;", "centerContentPlaceHolder$delegate", "collapseButton", "Landroid/view/View;", "getCollapseButton", "()Landroid/view/View;", "collapseButtonExpendText", "getCollapseButtonExpendText", "()I", "setCollapseButtonExpendText", "(I)V", "collapsed", "", "getCollapsed", "()Z", "setCollapsed", "(Z)V", "contentText", "getContentText", "fullContentPlaceHolder", "getFullContentPlaceHolder", "fullContentPlaceHolder$delegate", "imageCollapse", "isSpecialText", "setSpecialText", "lastLineHeight", "getLastLineHeight", "lastLineRight", "getLastLineRight", "()F", "layoutId", "leftBottomCollapsePlaceHolder", "getLeftBottomCollapsePlaceHolder", "leftBottomCollapsePlaceHolder$delegate", "mContext", "maxLines", "needCollapse", "noCollapseCenter", "onCollapse", "Lkotlin/Function0;", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function0;", "setOnCollapse", "(Lkotlin/jvm/functions/Function0;)V", "onExpand", "getOnExpand", "setOnExpand", "preMeasureWidth", "resource", "Landroid/content/res/Resources;", "getResource", "()Landroid/content/res/Resources;", "resource$delegate", "rightBottomCollapsePlaceHolder", "getRightBottomCollapsePlaceHolder", "rightBottomCollapsePlaceHolder$delegate", "rightCollapse", "rightCollapsePlaceHolder", "getRightCollapsePlaceHolder", "rightCollapsePlaceHolder$delegate", "text", "", "textSize", "getTextSize", "textUpdated", "dpToPixel", "getDpToPixel", "(F)F", "_setText", "calcRightOffset", "layout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "init", "measureTruncate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetRightOffset", "setCollapseButtonText", "setCollapseStatus", "setMaxLines", "setOnTextTouchListener", "l", "Landroid/view/View$OnTouchListener;", "setText", "isRequestLayout", "setTextSize", "unit", "size", "setupCollapseButton", "setupRightCollapsePosition", "switch", "libmmui_release"})
public final class MMCollapsibleTextView
  extends ConstraintLayout
{
  private boolean BJC;
  private CharSequence LV;
  private final int Pfu;
  private final f YaH;
  private boolean YaI;
  private boolean YaJ;
  private boolean YaK;
  private boolean YaL;
  private final f YaM;
  private final f YaN;
  private final f YaO;
  private final f YaP;
  private final f YaQ;
  private final f YaR;
  private final f YaS;
  private final f YaT;
  private final f YaU;
  private boolean YaV;
  private kotlin.g.a.a<x> YaW;
  private kotlin.g.a.a<x> YaX;
  private int YaY;
  private float YaZ;
  private float Yba;
  private int Ybb;
  private Context mContext;
  private int maxLines;
  private boolean sTK;
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140979);
    this.YaH = g.ar((kotlin.g.a.a)new i(this));
    this.maxLines = 2147483647;
    this.Pfu = a.h.mm_collapsible_textview_v2;
    this.YaM = g.ar((kotlin.g.a.a)new d(this));
    this.YaN = g.ar((kotlin.g.a.a)new c(this));
    this.YaO = g.ar((kotlin.g.a.a)new a(this));
    this.YaP = g.ar((kotlin.g.a.a)new b(this));
    this.YaQ = g.ar((kotlin.g.a.a)new f(this));
    this.YaR = g.ar((kotlin.g.a.a)new e(this));
    this.YaS = g.ar((kotlin.g.a.a)new g(this));
    this.YaT = g.ar((kotlin.g.a.a)new j(this));
    this.YaU = g.ar((kotlin.g.a.a)new k(this));
    this.YaV = true;
    this.YaY = -1;
    this.YaZ = -1.0F;
    this.Yba = -1.0F;
    this.Ybb = a.k.expend;
    this.mContext = paramContext;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(140979);
  }
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140980);
    this.YaH = g.ar((kotlin.g.a.a)new i(this));
    this.maxLines = 2147483647;
    this.Pfu = a.h.mm_collapsible_textview_v2;
    this.YaM = g.ar((kotlin.g.a.a)new d(this));
    this.YaN = g.ar((kotlin.g.a.a)new c(this));
    this.YaO = g.ar((kotlin.g.a.a)new a(this));
    this.YaP = g.ar((kotlin.g.a.a)new b(this));
    this.YaQ = g.ar((kotlin.g.a.a)new f(this));
    this.YaR = g.ar((kotlin.g.a.a)new e(this));
    this.YaS = g.ar((kotlin.g.a.a)new g(this));
    this.YaT = g.ar((kotlin.g.a.a)new j(this));
    this.YaU = g.ar((kotlin.g.a.a)new k(this));
    this.YaV = true;
    this.YaY = -1;
    this.YaZ = -1.0F;
    this.Yba = -1.0F;
    this.Ybb = a.k.expend;
    this.mContext = paramContext;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(140980);
  }
  
  private final Placeholder getCenterContentPlaceHolder()
  {
    AppMethodBeat.i(196873);
    Placeholder localPlaceholder = (Placeholder)this.YaR.getValue();
    AppMethodBeat.o(196873);
    return localPlaceholder;
  }
  
  private final View getCollapseButton()
  {
    AppMethodBeat.i(140972);
    if (this.YaL)
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
    AppMethodBeat.i(196871);
    Placeholder localPlaceholder = (Placeholder)this.YaQ.getValue();
    AppMethodBeat.o(196871);
    return localPlaceholder;
  }
  
  private final int getLastLineHeight()
  {
    AppMethodBeat.i(140974);
    if (this.sTK)
    {
      localObject = get_contentBackupText();
      p.j(localObject, "_contentBackupText");
      i = ((TextView)localObject).getLineHeight();
      AppMethodBeat.o(140974);
      return i;
    }
    Object localObject = get_contentText();
    p.j(localObject, "_contentText");
    int i = ((MMNeat7extView)localObject).getLineHeight();
    AppMethodBeat.o(140974);
    return i;
  }
  
  private final float getLastLineRight()
  {
    if (this.YaV) {
      return this.YaZ;
    }
    return this.Yba;
  }
  
  private final Placeholder getLeftBottomCollapsePlaceHolder()
  {
    AppMethodBeat.i(196874);
    Placeholder localPlaceholder = (Placeholder)this.YaS.getValue();
    AppMethodBeat.o(196874);
    return localPlaceholder;
  }
  
  private final Resources getResource()
  {
    AppMethodBeat.i(140958);
    Resources localResources = (Resources)this.YaH.getValue();
    AppMethodBeat.o(140958);
    return localResources;
  }
  
  private final Placeholder getRightBottomCollapsePlaceHolder()
  {
    AppMethodBeat.i(196875);
    Placeholder localPlaceholder = (Placeholder)this.YaT.getValue();
    AppMethodBeat.o(196875);
    return localPlaceholder;
  }
  
  private final Placeholder getRightCollapsePlaceHolder()
  {
    AppMethodBeat.i(196876);
    Placeholder localPlaceholder = (Placeholder)this.YaU.getValue();
    AppMethodBeat.o(196876);
    return localPlaceholder;
  }
  
  private final ImageView get_collapseImage()
  {
    AppMethodBeat.i(140962);
    ImageView localImageView = (ImageView)this.YaP.getValue();
    AppMethodBeat.o(140962);
    return localImageView;
  }
  
  private final void hZt()
  {
    AppMethodBeat.i(140977);
    float f;
    if (this.sTK) {
      f = this.YaY * 3.0F / 4.0F;
    }
    while (getLastLineRight() < f)
    {
      localObject1 = getRightCollapsePlaceHolder();
      p.j(localObject1, "rightCollapsePlaceHolder");
      localObject1 = ((Placeholder)localObject1).getLayoutParams();
      int i;
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(140977);
        throw ((Throwable)localObject1);
        i = this.YaY;
        localObject1 = getCollapseButton();
        p.j(localObject1, "collapseButton");
        f = i - ((View)localObject1).getMeasuredWidth();
      }
      else
      {
        localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
        i = getLastLineHeight();
        localObject2 = getCollapseButton();
        p.j(localObject2, "collapseButton");
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (Math.max(0, i - ((View)localObject2).getMeasuredHeight()) / 2 + 1);
        localObject2 = getRightCollapsePlaceHolder();
        p.j(localObject2, "rightCollapsePlaceHolder");
        ((Placeholder)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        getRightBottomCollapsePlaceHolder().setContentId(-1);
        localObject1 = getRightCollapsePlaceHolder();
        localObject2 = getCollapseButton();
        p.j(localObject2, "collapseButton");
        ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
        getRightCollapsePlaceHolder().a((ConstraintLayout)this);
        AppMethodBeat.o(140977);
        return;
      }
    }
    getRightCollapsePlaceHolder().setContentId(-1);
    Object localObject1 = getRightBottomCollapsePlaceHolder();
    Object localObject2 = getCollapseButton();
    p.j(localObject2, "collapseButton");
    ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
    getRightBottomCollapsePlaceHolder().a((ConstraintLayout)this);
    AppMethodBeat.o(140977);
  }
  
  @SuppressLint({"Recycle", "CustomViewStyleable"})
  private final void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(140968);
    int i = -1;
    int j = -1;
    int k = -1;
    int n = -1;
    int i1 = n;
    int i2 = k;
    int i3 = j;
    int i4 = i;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.m.MMCollapsibleTextView, paramInt, 0);
      p.j(paramAttributeSet, "tArray");
      int i5 = paramAttributeSet.getIndexCount();
      int m = 0;
      paramInt = n;
      i1 = paramInt;
      i2 = k;
      i3 = j;
      i4 = i;
      if (m < i5)
      {
        n = paramAttributeSet.getIndex(m);
        if (n == a.m.MMCollapsibleTextView_android_maxLines) {
          this.maxLines = paramAttributeSet.getInt(n, 2147483647);
        }
        for (;;)
        {
          m += 1;
          break;
          if (n == a.m.MMCollapsibleTextView_android_textSize)
          {
            i = paramAttributeSet.getDimensionPixelSize(n, i);
          }
          else if (n == a.m.MMCollapsibleTextView_android_textColor)
          {
            j = paramAttributeSet.getColor(n, j);
          }
          else if (n == a.m.MMCollapsibleTextView_android_textColorLink)
          {
            k = paramAttributeSet.getColor(n, k);
          }
          else if (n == a.m.MMCollapsibleTextView_android_lineSpacingExtra)
          {
            paramInt = paramAttributeSet.getDimensionPixelSize(n, paramInt);
          }
          else
          {
            if (n == a.m.MMCollapsibleTextView_collapseButtonPosition)
            {
              if (paramAttributeSet.getInt(n, 0) != 0) {}
              for (bool = true;; bool = false)
              {
                this.YaK = bool;
                break;
              }
            }
            if (n != a.m.MMCollapsibleTextView_noCollapseCenter) {
              break label268;
            }
            this.YaJ = paramAttributeSet.getBoolean(n, this.YaJ);
          }
        }
        label268:
        if (n == a.m.MMCollapsibleTextView_collapseButtonStyle) {
          if (paramAttributeSet.getInt(n, 0) == 0) {
            break label298;
          }
        }
        label298:
        for (boolean bool = true;; bool = false)
        {
          this.YaL = bool;
          break;
        }
      }
    }
    ad.kS(this.mContext).inflate(this.Pfu, (ViewGroup)this);
    if (i2 != -1) {
      get_collapseButton().setTextColor(i2);
    }
    if (i3 != -1)
    {
      get_contentText().setTextColor(i3);
      get_contentBackupText().setTextColor(i3);
    }
    if (i4 != -1)
    {
      get_collapseButton().setTextSize(0, i4);
      get_contentText().setTextSize(0, i4);
      get_contentBackupText().setTextSize(0, i4);
    }
    if (i1 != -1)
    {
      get_contentText().setSpacingAdd(i1);
      get_contentBackupText().setLineSpacing(i1, 1.0F);
    }
    paramAttributeSet = getFullContentPlaceHolder();
    p.j(paramAttributeSet, "fullContentPlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    paramAttributeSet = getCenterContentPlaceHolder();
    p.j(paramAttributeSet, "centerContentPlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    paramAttributeSet = getLeftBottomCollapsePlaceHolder();
    p.j(paramAttributeSet, "leftBottomCollapsePlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    paramAttributeSet = getRightBottomCollapsePlaceHolder();
    p.j(paramAttributeSet, "rightBottomCollapsePlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    paramAttributeSet = getRightCollapsePlaceHolder();
    p.j(paramAttributeSet, "rightCollapsePlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    AppMethodBeat.o(140968);
  }
  
  private final void setCollapseStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(140976);
    Object localObject;
    if (this.YaL)
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
      for (i = this.Ybb;; i = a.k.collapse)
      {
        ((TextView)localObject).setText(i);
        break;
      }
    }
  }
  
  private final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(140970);
    if (this.sTK)
    {
      TextView localTextView = get_contentBackupText();
      p.j(localTextView, "_contentBackupText");
      localTextView.setMaxLines(paramInt);
      AppMethodBeat.o(140970);
      return;
    }
    get_contentText().setMaxLines(paramInt);
    AppMethodBeat.o(140970);
  }
  
  public final int getCollapseButtonExpendText()
  {
    return this.Ybb;
  }
  
  public final boolean getCollapsed()
  {
    return this.YaV;
  }
  
  public final View getContentText()
  {
    AppMethodBeat.i(140971);
    if (this.sTK)
    {
      localObject = get_contentBackupText();
      p.j(localObject, "_contentBackupText");
      localObject = (View)localObject;
      AppMethodBeat.o(140971);
      return localObject;
    }
    Object localObject = get_contentText();
    p.j(localObject, "_contentText");
    localObject = (View)localObject;
    AppMethodBeat.o(140971);
    return localObject;
  }
  
  public final kotlin.g.a.a<x> getOnCollapse()
  {
    return this.YaW;
  }
  
  public final kotlin.g.a.a<x> getOnExpand()
  {
    return this.YaX;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(140969);
    MMNeat7extView localMMNeat7extView = get_contentText();
    p.j(localMMNeat7extView, "_contentText");
    float f = localMMNeat7extView.getTextSize();
    AppMethodBeat.o(140969);
    return f;
  }
  
  public final TextView get_collapseButton()
  {
    AppMethodBeat.i(140961);
    TextView localTextView = (TextView)this.YaO.getValue();
    AppMethodBeat.o(140961);
    return localTextView;
  }
  
  public final TextView get_contentBackupText()
  {
    AppMethodBeat.i(140960);
    TextView localTextView = (TextView)this.YaN.getValue();
    AppMethodBeat.o(140960);
    return localTextView;
  }
  
  public final MMNeat7extView get_contentText()
  {
    AppMethodBeat.i(140959);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.YaM.getValue();
    AppMethodBeat.o(140959);
    return localMMNeat7extView;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140975);
    int i = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    Object localObject1;
    Object localObject2;
    boolean bool;
    label164:
    label198:
    float f1;
    if ((this.YaI) || (i != this.YaY))
    {
      this.YaZ = -1.0F;
      this.Yba = -1.0F;
      this.YaI = false;
      this.YaY = i;
      get_contentText().setMaxLines(2147483647);
      localObject1 = get_contentText();
      localObject2 = this.LV;
      if (localObject2 == null) {
        p.bGy("text");
      }
      ((MMNeat7extView)localObject1).aL((CharSequence)localObject2);
      localObject1 = get_contentText();
      p.j(localObject1, "_contentText");
      this.sTK = ((MMNeat7extView)localObject1).ikB();
      com.tencent.neattextview.textview.layout.a locala = get_contentText().nH(i, 2147483647);
      if (locala == null) {
        break label731;
      }
      i = locala.ikp();
      if (i <= this.maxLines) {
        break label737;
      }
      bool = true;
      this.BJC = bool;
      if ((this.YaJ) && (!this.BJC)) {
        break label743;
      }
      getFullContentPlaceHolder().setContentId(getContentText().getId());
      if (this.BJC)
      {
        getCollapseButton().setOnClickListener((View.OnClickListener)new MMCollapsibleTextView.l(this));
        localObject1 = getCollapseButton();
        p.j(localObject1, "collapseButton");
        ((View)localObject1).setVisibility(0);
        if (!this.YaK)
        {
          localObject1 = getLeftBottomCollapsePlaceHolder();
          localObject2 = getCollapseButton();
          p.j(localObject2, "collapseButton");
          ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
        }
        setCollapseStatus(this.YaV);
        if (this.YaK)
        {
          if (!this.YaL) {
            break label760;
          }
          i = (int)(getLastLineHeight() * 0.8F);
          localObject1 = get_collapseImage();
          p.j(localObject1, "_collapseImage");
          localObject1 = ((ImageView)localObject1).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).height = i;
          localObject2 = get_collapseImage();
          p.j(localObject2, "_collapseImage");
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          get_collapseImage().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
          localObject1 = get_collapseImage();
          p.j(localObject1, "_collapseImage");
          localObject2 = ((ImageView)localObject1).getParent();
          localObject1 = localObject2;
          if (!(localObject2 instanceof View)) {
            localObject1 = null;
          }
          localObject1 = (View)localObject1;
          if (localObject1 != null) {
            ((View)localObject1).post((Runnable)new MMCollapsibleTextView.h((View)localObject1, this, i));
          }
          label452:
          localObject1 = getResource();
          p.j(localObject1, "resource");
          f1 = ((Resources)localObject1).getDisplayMetrics().density;
          localObject1 = getCollapseButton();
          p.j(localObject1, "collapseButton");
          float f2 = ((View)localObject1).getMeasuredWidth();
          get_contentText().a(TextUtils.TruncateAt.END, f1 * 1.0F + 0.5F + f2);
          if (locala != null)
          {
            i = this.maxLines;
            int j = locala.ikp();
            if (!this.sTK) {
              break label780;
            }
            f1 = locala.azY(i - 1);
            label556:
            this.YaZ = f1;
            this.Yba = locala.azY(j - 1);
          }
          hZt();
        }
      }
      localObject1 = this.LV;
      if (localObject1 == null) {
        p.bGy("text");
      }
      if (!this.sTK) {
        break label785;
      }
      localObject2 = get_contentBackupText();
      p.j(localObject2, "_contentBackupText");
      ((TextView)localObject2).setVisibility(0);
      localObject2 = get_contentText();
      p.j(localObject2, "_contentText");
      ((MMNeat7extView)localObject2).setVisibility(8);
      localObject2 = get_contentBackupText();
      p.j(localObject2, "_contentBackupText");
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (!this.BJC)
      {
        localObject1 = getCollapseButton();
        p.j(localObject1, "collapseButton");
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject1 = getCollapseButton();
          p.j(localObject1, "collapseButton");
          ((View)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(140975);
      return;
      label731:
      i = 0;
      break;
      label737:
      bool = false;
      break label164;
      label743:
      getCenterContentPlaceHolder().setContentId(getContentText().getId());
      break label198;
      label760:
      get_collapseButton().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      break label452;
      label780:
      f1 = 0.0F;
      break label556;
      label785:
      localObject2 = get_contentText();
      p.j(localObject2, "_contentText");
      ((MMNeat7extView)localObject2).setVisibility(0);
      localObject2 = get_contentBackupText();
      p.j(localObject2, "_contentBackupText");
      ((TextView)localObject2).setVisibility(8);
      get_contentText().aL((CharSequence)localObject1);
    }
  }
  
  public final void setCollapseButtonExpendText(int paramInt)
  {
    this.Ybb = paramInt;
  }
  
  public final void setCollapseButtonText(int paramInt)
  {
    this.Ybb = paramInt;
  }
  
  public final void setCollapsed(boolean paramBoolean)
  {
    this.YaV = paramBoolean;
  }
  
  public final void setOnCollapse(kotlin.g.a.a<x> parama)
  {
    this.YaW = parama;
  }
  
  public final void setOnExpand(kotlin.g.a.a<x> parama)
  {
    this.YaX = parama;
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
    this.sTK = paramBoolean;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(140978);
    p.k(paramCharSequence, "text");
    p.k(paramCharSequence, "text");
    this.LV = paramCharSequence;
    this.YaI = true;
    AppMethodBeat.o(140978);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<TextView>
  {
    a(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    b(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<TextView>
  {
    c(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<MMNeat7extView>
  {
    d(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Placeholder>
  {
    e(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<Placeholder>
  {
    f(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<Placeholder>
  {
    g(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<Resources>
  {
    i(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<Placeholder>
  {
    j(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/constraintlayout/widget/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<Placeholder>
  {
    k(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */