package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_collapseButton", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "get_collapseButton", "()Landroid/widget/TextView;", "_collapseButton$delegate", "Lkotlin/Lazy;", "_collapseImage", "Landroid/widget/ImageView;", "get_collapseImage", "()Landroid/widget/ImageView;", "_collapseImage$delegate", "_collapseLastRight", "", "_contentBackupText", "get_contentBackupText", "_contentBackupText$delegate", "_contentText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "get_contentText", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "_contentText$delegate", "_expandLastRight", "centerContentPlaceHolder", "Landroid/support/constraint/Placeholder;", "getCenterContentPlaceHolder", "()Landroid/support/constraint/Placeholder;", "centerContentPlaceHolder$delegate", "collapseButton", "Landroid/view/View;", "getCollapseButton", "()Landroid/view/View;", "collapseButtonExpendText", "getCollapseButtonExpendText", "()I", "setCollapseButtonExpendText", "(I)V", "collapsed", "", "getCollapsed", "()Z", "setCollapsed", "(Z)V", "contentText", "getContentText", "fullContentPlaceHolder", "getFullContentPlaceHolder", "fullContentPlaceHolder$delegate", "imageCollapse", "isSpecialText", "setSpecialText", "lastLineHeight", "getLastLineHeight", "lastLineRight", "getLastLineRight", "()F", "layoutId", "leftBottomCollapsePlaceHolder", "getLeftBottomCollapsePlaceHolder", "leftBottomCollapsePlaceHolder$delegate", "mContext", "maxLines", "needCollapse", "noCollapseCenter", "onCollapse", "Lkotlin/Function0;", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function0;", "setOnCollapse", "(Lkotlin/jvm/functions/Function0;)V", "onExpand", "getOnExpand", "setOnExpand", "preMeasureWidth", "resource", "Landroid/content/res/Resources;", "getResource", "()Landroid/content/res/Resources;", "resource$delegate", "rightBottomCollapsePlaceHolder", "getRightBottomCollapsePlaceHolder", "rightBottomCollapsePlaceHolder$delegate", "rightCollapse", "rightCollapsePlaceHolder", "getRightCollapsePlaceHolder", "rightCollapsePlaceHolder$delegate", "text", "", "textSize", "getTextSize", "textUpdated", "dpToPixel", "getDpToPixel", "(F)F", "_setText", "calcRightOffset", "layout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "init", "measureTruncate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetRightOffset", "setCollapseButtonText", "setCollapseStatus", "setMaxLines", "setOnTextTouchListener", "l", "Landroid/view/View$OnTouchListener;", "setText", "isRequestLayout", "setTextSize", "unit", "size", "setupCollapseButton", "setupRightCollapsePosition", "switch", "libmmui_release"})
public final class MMCollapsibleTextView
  extends ConstraintLayout
{
  private final int DDQ;
  private final f LmY;
  private boolean LmZ;
  private boolean Lna;
  private boolean Lnb;
  private boolean Lnc;
  private final f Lnd;
  private final f Lne;
  private final f Lnf;
  private final f Lng;
  private final f Lnh;
  private final f Lni;
  private final f Lnj;
  private final f Lnk;
  private final f Lnl;
  private boolean Lnm;
  private d.g.a.a<d.z> Lnn;
  private d.g.a.a<d.z> Lno;
  private int Lnp;
  private float Lnq;
  private float Lnr;
  private int Lns;
  private Context mContext;
  private int maxLines;
  private boolean ozd;
  private boolean tGH;
  private CharSequence text;
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140979);
    this.LmY = g.O((d.g.a.a)new i(this));
    this.maxLines = 2147483647;
    this.DDQ = 2131494782;
    this.Lnd = g.O((d.g.a.a)new d(this));
    this.Lne = g.O((d.g.a.a)new c(this));
    this.Lnf = g.O((d.g.a.a)new a(this));
    this.Lng = g.O((d.g.a.a)new b(this));
    this.Lnh = g.O((d.g.a.a)new f(this));
    this.Lni = g.O((d.g.a.a)new e(this));
    this.Lnj = g.O((d.g.a.a)new g(this));
    this.Lnk = g.O((d.g.a.a)new j(this));
    this.Lnl = g.O((d.g.a.a)new k(this));
    this.Lnm = true;
    this.Lnp = -1;
    this.Lnq = -1.0F;
    this.Lnr = -1.0F;
    this.Lns = 2131758627;
    this.mContext = paramContext;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(140979);
  }
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140980);
    this.LmY = g.O((d.g.a.a)new i(this));
    this.maxLines = 2147483647;
    this.DDQ = 2131494782;
    this.Lnd = g.O((d.g.a.a)new d(this));
    this.Lne = g.O((d.g.a.a)new c(this));
    this.Lnf = g.O((d.g.a.a)new a(this));
    this.Lng = g.O((d.g.a.a)new b(this));
    this.Lnh = g.O((d.g.a.a)new f(this));
    this.Lni = g.O((d.g.a.a)new e(this));
    this.Lnj = g.O((d.g.a.a)new g(this));
    this.Lnk = g.O((d.g.a.a)new j(this));
    this.Lnl = g.O((d.g.a.a)new k(this));
    this.Lnm = true;
    this.Lnp = -1;
    this.Lnq = -1.0F;
    this.Lnr = -1.0F;
    this.Lns = 2131758627;
    this.mContext = paramContext;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(140980);
  }
  
  private final void fPI()
  {
    AppMethodBeat.i(140977);
    float f;
    if (this.ozd) {
      f = this.Lnp * 3.0F / 4.0F;
    }
    while (getLastLineRight() < f)
    {
      localObject1 = getRightCollapsePlaceHolder();
      p.g(localObject1, "rightCollapsePlaceHolder");
      localObject1 = ((Placeholder)localObject1).getLayoutParams();
      int i;
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(140977);
        throw ((Throwable)localObject1);
        i = this.Lnp;
        localObject1 = getCollapseButton();
        p.g(localObject1, "collapseButton");
        f = i - ((View)localObject1).getMeasuredWidth();
      }
      else
      {
        localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
        i = getLastLineHeight();
        localObject2 = getCollapseButton();
        p.g(localObject2, "collapseButton");
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (Math.max(0, i - ((View)localObject2).getMeasuredHeight()) / 2 + 1);
        localObject2 = getRightCollapsePlaceHolder();
        p.g(localObject2, "rightCollapsePlaceHolder");
        ((Placeholder)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        getRightBottomCollapsePlaceHolder().setContentId(-1);
        localObject1 = getRightCollapsePlaceHolder();
        localObject2 = getCollapseButton();
        p.g(localObject2, "collapseButton");
        ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
        getRightCollapsePlaceHolder().updatePreLayout((ConstraintLayout)this);
        AppMethodBeat.o(140977);
        return;
      }
    }
    getRightCollapsePlaceHolder().setContentId(-1);
    Object localObject1 = getRightBottomCollapsePlaceHolder();
    Object localObject2 = getCollapseButton();
    p.g(localObject2, "collapseButton");
    ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
    getRightBottomCollapsePlaceHolder().updatePreLayout((ConstraintLayout)this);
    AppMethodBeat.o(140977);
  }
  
  private final Placeholder getCenterContentPlaceHolder()
  {
    AppMethodBeat.i(140964);
    Placeholder localPlaceholder = (Placeholder)this.Lni.getValue();
    AppMethodBeat.o(140964);
    return localPlaceholder;
  }
  
  private final View getCollapseButton()
  {
    AppMethodBeat.i(140972);
    if (this.Lnc)
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
    AppMethodBeat.i(140963);
    Placeholder localPlaceholder = (Placeholder)this.Lnh.getValue();
    AppMethodBeat.o(140963);
    return localPlaceholder;
  }
  
  private final int getLastLineHeight()
  {
    AppMethodBeat.i(140974);
    if (this.ozd)
    {
      localObject = get_contentBackupText();
      p.g(localObject, "_contentBackupText");
      i = ((TextView)localObject).getLineHeight();
      AppMethodBeat.o(140974);
      return i;
    }
    Object localObject = get_contentText();
    p.g(localObject, "_contentText");
    int i = ((MMNeat7extView)localObject).getLineHeight();
    AppMethodBeat.o(140974);
    return i;
  }
  
  private final float getLastLineRight()
  {
    if (this.Lnm) {
      return this.Lnq;
    }
    return this.Lnr;
  }
  
  private final Placeholder getLeftBottomCollapsePlaceHolder()
  {
    AppMethodBeat.i(140965);
    Placeholder localPlaceholder = (Placeholder)this.Lnj.getValue();
    AppMethodBeat.o(140965);
    return localPlaceholder;
  }
  
  private final Resources getResource()
  {
    AppMethodBeat.i(140958);
    Resources localResources = (Resources)this.LmY.getValue();
    AppMethodBeat.o(140958);
    return localResources;
  }
  
  private final Placeholder getRightBottomCollapsePlaceHolder()
  {
    AppMethodBeat.i(140966);
    Placeholder localPlaceholder = (Placeholder)this.Lnk.getValue();
    AppMethodBeat.o(140966);
    return localPlaceholder;
  }
  
  private final Placeholder getRightCollapsePlaceHolder()
  {
    AppMethodBeat.i(140967);
    Placeholder localPlaceholder = (Placeholder)this.Lnl.getValue();
    AppMethodBeat.o(140967);
    return localPlaceholder;
  }
  
  private final ImageView get_collapseImage()
  {
    AppMethodBeat.i(140962);
    ImageView localImageView = (ImageView)this.Lng.getValue();
    AppMethodBeat.o(140962);
    return localImageView;
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
      paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.MMCollapsibleTextView, paramInt, 0);
      p.g(paramAttributeSet, "tArray");
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
        if (n == 4) {
          this.maxLines = paramAttributeSet.getInt(n, 2147483647);
        }
        for (;;)
        {
          m += 1;
          break;
          if (n == 0)
          {
            i = paramAttributeSet.getDimensionPixelSize(n, i);
          }
          else if (n == 1)
          {
            j = paramAttributeSet.getColor(n, j);
          }
          else if (n == 2)
          {
            k = paramAttributeSet.getColor(n, k);
          }
          else if (n == 5)
          {
            paramInt = paramAttributeSet.getDimensionPixelSize(n, paramInt);
          }
          else
          {
            if (n == 6)
            {
              if (paramAttributeSet.getInt(n, 0) != 0) {}
              for (bool = true;; bool = false)
              {
                this.Lnb = bool;
                break;
              }
            }
            if (n != 8) {
              break label255;
            }
            this.Lna = paramAttributeSet.getBoolean(n, this.Lna);
          }
        }
        label255:
        if (n == 7) {
          if (paramAttributeSet.getInt(n, 0) == 0) {
            break label284;
          }
        }
        label284:
        for (boolean bool = true;; bool = false)
        {
          this.Lnc = bool;
          break;
        }
      }
    }
    com.tencent.mm.ui.z.jV(this.mContext).inflate(this.DDQ, (ViewGroup)this);
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
    p.g(paramAttributeSet, "fullContentPlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    paramAttributeSet = getCenterContentPlaceHolder();
    p.g(paramAttributeSet, "centerContentPlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    paramAttributeSet = getLeftBottomCollapsePlaceHolder();
    p.g(paramAttributeSet, "leftBottomCollapsePlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    paramAttributeSet = getRightBottomCollapsePlaceHolder();
    p.g(paramAttributeSet, "rightBottomCollapsePlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    paramAttributeSet = getRightCollapsePlaceHolder();
    p.g(paramAttributeSet, "rightCollapsePlaceHolder");
    paramAttributeSet.setEmptyVisibility(8);
    AppMethodBeat.o(140968);
  }
  
  private final void setCollapseStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(140976);
    Object localObject;
    if (this.Lnc)
    {
      localObject = get_collapseImage();
      if (paramBoolean)
      {
        i = 2131690127;
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
      i = 2131689953;
      break;
      localObject = get_collapseButton();
      if (paramBoolean) {}
      for (i = this.Lns;; i = 2131757431)
      {
        ((TextView)localObject).setText(i);
        break;
      }
    }
  }
  
  private final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(140970);
    if (this.ozd)
    {
      TextView localTextView = get_contentBackupText();
      p.g(localTextView, "_contentBackupText");
      localTextView.setMaxLines(paramInt);
      AppMethodBeat.o(140970);
      return;
    }
    get_contentText().setMaxLines(paramInt);
    AppMethodBeat.o(140970);
  }
  
  public final int getCollapseButtonExpendText()
  {
    return this.Lns;
  }
  
  public final boolean getCollapsed()
  {
    return this.Lnm;
  }
  
  public final View getContentText()
  {
    AppMethodBeat.i(140971);
    if (this.ozd)
    {
      localObject = get_contentBackupText();
      p.g(localObject, "_contentBackupText");
      localObject = (View)localObject;
      AppMethodBeat.o(140971);
      return localObject;
    }
    Object localObject = get_contentText();
    p.g(localObject, "_contentText");
    localObject = (View)localObject;
    AppMethodBeat.o(140971);
    return localObject;
  }
  
  public final d.g.a.a<d.z> getOnCollapse()
  {
    return this.Lnn;
  }
  
  public final d.g.a.a<d.z> getOnExpand()
  {
    return this.Lno;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(140969);
    MMNeat7extView localMMNeat7extView = get_contentText();
    p.g(localMMNeat7extView, "_contentText");
    float f = localMMNeat7extView.getTextSize();
    AppMethodBeat.o(140969);
    return f;
  }
  
  public final TextView get_collapseButton()
  {
    AppMethodBeat.i(140961);
    TextView localTextView = (TextView)this.Lnf.getValue();
    AppMethodBeat.o(140961);
    return localTextView;
  }
  
  public final TextView get_contentBackupText()
  {
    AppMethodBeat.i(140960);
    TextView localTextView = (TextView)this.Lne.getValue();
    AppMethodBeat.o(140960);
    return localTextView;
  }
  
  public final MMNeat7extView get_contentText()
  {
    AppMethodBeat.i(140959);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.Lnd.getValue();
    AppMethodBeat.o(140959);
    return localMMNeat7extView;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140975);
    final int i = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    Object localObject1;
    Object localObject2;
    boolean bool;
    label164:
    label198:
    float f1;
    if ((this.LmZ) || (i != this.Lnp))
    {
      this.Lnq = -1.0F;
      this.Lnr = -1.0F;
      this.LmZ = false;
      this.Lnp = i;
      get_contentText().setMaxLines(2147483647);
      localObject1 = get_contentText();
      localObject2 = this.text;
      if (localObject2 == null) {
        p.bdF("text");
      }
      ((MMNeat7extView)localObject1).aq((CharSequence)localObject2);
      localObject1 = get_contentText();
      p.g(localObject1, "_contentText");
      this.ozd = ((MMNeat7extView)localObject1).fXn();
      com.tencent.neattextview.textview.layout.a locala = get_contentText().kR(i, 2147483647);
      if (locala == null) {
        break label731;
      }
      i = locala.fXb();
      if (i <= this.maxLines) {
        break label737;
      }
      bool = true;
      this.tGH = bool;
      if ((this.Lna) && (!this.tGH)) {
        break label743;
      }
      getFullContentPlaceHolder().setContentId(getContentText().getId());
      if (this.tGH)
      {
        getCollapseButton().setOnClickListener((View.OnClickListener)new l(this));
        localObject1 = getCollapseButton();
        p.g(localObject1, "collapseButton");
        ((View)localObject1).setVisibility(0);
        if (!this.Lnb)
        {
          localObject1 = getLeftBottomCollapsePlaceHolder();
          localObject2 = getCollapseButton();
          p.g(localObject2, "collapseButton");
          ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
        }
        setCollapseStatus(this.Lnm);
        if (this.Lnb)
        {
          if (!this.Lnc) {
            break label760;
          }
          i = (int)(getLastLineHeight() * 0.8F);
          localObject1 = get_collapseImage();
          p.g(localObject1, "_collapseImage");
          localObject1 = ((ImageView)localObject1).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).height = i;
          localObject2 = get_collapseImage();
          p.g(localObject2, "_collapseImage");
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          get_collapseImage().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
          localObject1 = get_collapseImage();
          p.g(localObject1, "_collapseImage");
          localObject2 = ((ImageView)localObject1).getParent();
          localObject1 = localObject2;
          if (!(localObject2 instanceof View)) {
            localObject1 = null;
          }
          localObject1 = (View)localObject1;
          if (localObject1 != null) {
            ((View)localObject1).post((Runnable)new h((View)localObject1, this, i));
          }
          label452:
          localObject1 = getResource();
          p.g(localObject1, "resource");
          f1 = ((Resources)localObject1).getDisplayMetrics().density;
          localObject1 = getCollapseButton();
          p.g(localObject1, "collapseButton");
          float f2 = ((View)localObject1).getMeasuredWidth();
          get_contentText().a(TextUtils.TruncateAt.END, f1 * 1.0F + 0.5F + f2);
          if (locala != null)
          {
            i = this.maxLines;
            int j = locala.fXb();
            if (!this.ozd) {
              break label780;
            }
            f1 = locala.getLineRight(i - 1);
            label556:
            this.Lnq = f1;
            this.Lnr = locala.getLineRight(j - 1);
          }
          fPI();
        }
      }
      localObject1 = this.text;
      if (localObject1 == null) {
        p.bdF("text");
      }
      if (!this.ozd) {
        break label785;
      }
      localObject2 = get_contentBackupText();
      p.g(localObject2, "_contentBackupText");
      ((TextView)localObject2).setVisibility(0);
      localObject2 = get_contentText();
      p.g(localObject2, "_contentText");
      ((MMNeat7extView)localObject2).setVisibility(8);
      localObject2 = get_contentBackupText();
      p.g(localObject2, "_contentBackupText");
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (!this.tGH)
      {
        localObject1 = getCollapseButton();
        p.g(localObject1, "collapseButton");
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject1 = getCollapseButton();
          p.g(localObject1, "collapseButton");
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
      p.g(localObject2, "_contentText");
      ((MMNeat7extView)localObject2).setVisibility(0);
      localObject2 = get_contentBackupText();
      p.g(localObject2, "_contentBackupText");
      ((TextView)localObject2).setVisibility(8);
      get_contentText().aq((CharSequence)localObject1);
    }
  }
  
  public final void setCollapseButtonExpendText(int paramInt)
  {
    this.Lns = paramInt;
  }
  
  public final void setCollapseButtonText(int paramInt)
  {
    this.Lns = paramInt;
  }
  
  public final void setCollapsed(boolean paramBoolean)
  {
    this.Lnm = paramBoolean;
  }
  
  public final void setOnCollapse(d.g.a.a<d.z> parama)
  {
    this.Lnn = parama;
  }
  
  public final void setOnExpand(d.g.a.a<d.z> parama)
  {
    this.Lno = parama;
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
    this.ozd = paramBoolean;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(140978);
    p.h(paramCharSequence, "text");
    p.h(paramCharSequence, "text");
    this.text = paramCharSequence;
    this.LmZ = true;
    AppMethodBeat.o(140978);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<TextView>
  {
    a(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<ImageView>
  {
    b(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<TextView>
  {
    c(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<MMNeat7extView>
  {
    d(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<Placeholder>
  {
    e(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Placeholder>
  {
    f(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<Placeholder>
  {
    g(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/ui/widget/MMCollapsibleTextView$measureTruncate$2$1"})
  static final class h
    implements Runnable
  {
    h(View paramView, MMCollapsibleTextView paramMMCollapsibleTextView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(140952);
      Rect localRect = new Rect();
      int i = (int)(i * 1.5F);
      MMCollapsibleTextView.a(jdField_this).getHitRect(localRect);
      localRect.top -= i;
      localRect.left -= i;
      localRect.bottom += i;
      localRect.right = (i + localRect.right);
      this.scH.setTouchDelegate(new TouchDelegate(localRect, (View)MMCollapsibleTextView.a(jdField_this)));
      AppMethodBeat.o(140952);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<Resources>
  {
    i(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<Placeholder>
  {
    j(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<Placeholder>
  {
    k(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(MMCollapsibleTextView paramMMCollapsibleTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(140956);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMCollapsibleTextView$setupCollapseButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      MMCollapsibleTextView.b(this.Lnt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMCollapsibleTextView$setupCollapseButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(140956);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */