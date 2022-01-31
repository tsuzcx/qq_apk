package com.tencent.mm.ui.widget;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.g;
import a.l;
import a.y;
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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.ui.w;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_collapseButton", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "get_collapseButton", "()Landroid/widget/TextView;", "_collapseButton$delegate", "Lkotlin/Lazy;", "_collapseImage", "Landroid/widget/ImageView;", "get_collapseImage", "()Landroid/widget/ImageView;", "_collapseImage$delegate", "_collapseLastRight", "", "_contentBackupText", "get_contentBackupText", "_contentBackupText$delegate", "_contentText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "get_contentText", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "_contentText$delegate", "_expandLastRight", "centerContentPlaceHolder", "Landroid/support/constraint/Placeholder;", "getCenterContentPlaceHolder", "()Landroid/support/constraint/Placeholder;", "centerContentPlaceHolder$delegate", "collapseButton", "Landroid/view/View;", "getCollapseButton", "()Landroid/view/View;", "collapsed", "", "getCollapsed", "()Z", "setCollapsed", "(Z)V", "contentText", "getContentText", "fullContentPlaceHolder", "getFullContentPlaceHolder", "fullContentPlaceHolder$delegate", "imageCollapse", "isSpecialText", "lastLineHeight", "getLastLineHeight", "()I", "lastLineRight", "getLastLineRight", "()F", "layoutId", "leftBottomCollapsePlaceHolder", "getLeftBottomCollapsePlaceHolder", "leftBottomCollapsePlaceHolder$delegate", "mContext", "maxLines", "needCollapse", "noCollapseCenter", "onCollapse", "Lkotlin/Function0;", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function0;", "setOnCollapse", "(Lkotlin/jvm/functions/Function0;)V", "onExpand", "getOnExpand", "setOnExpand", "preMeasureWidth", "resource", "Landroid/content/res/Resources;", "getResource", "()Landroid/content/res/Resources;", "resource$delegate", "rightBottomCollapsePlaceHolder", "getRightBottomCollapsePlaceHolder", "rightBottomCollapsePlaceHolder$delegate", "rightCollapse", "rightCollapsePlaceHolder", "getRightCollapsePlaceHolder", "rightCollapsePlaceHolder$delegate", "text", "", "textSize", "getTextSize", "textUpdated", "dpToPixel", "getDpToPixel", "(F)F", "_setText", "calcRightOffset", "layout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "init", "measureTruncate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetRightOffset", "setCollapseStatus", "setMaxLines", "setText", "setTextSize", "unit", "size", "setupCollapseButton", "setupRightCollapsePosition", "switch", "libmmui_release"})
public final class MMCollapsibleTextView
  extends ConstraintLayout
{
  private final f ACA;
  private boolean ACB;
  private a.f.a.a<y> ACC;
  private a.f.a.a<y> ACD;
  private int ACE;
  private float ACF;
  private float ACG;
  private final f ACn;
  private boolean ACo;
  private boolean ACp;
  private boolean ACq;
  private boolean ACr;
  private final f ACs;
  private final f ACt;
  private final f ACu;
  private final f ACv;
  private final f ACw;
  private final f ACx;
  private final f ACy;
  private final f ACz;
  private boolean kji;
  private Context mContext;
  private boolean mTD;
  private int maxLines;
  private CharSequence text;
  private final int uwF;
  
  static
  {
    AppMethodBeat.i(142793);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "resource", "getResource()Landroid/content/res/Resources;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "_contentText", "get_contentText()Lcom/tencent/mm/ui/widget/MMNeat7extView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "_contentBackupText", "get_contentBackupText()Landroid/widget/TextView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "_collapseButton", "get_collapseButton()Landroid/widget/TextView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "_collapseImage", "get_collapseImage()Landroid/widget/ImageView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "fullContentPlaceHolder", "getFullContentPlaceHolder()Landroid/support/constraint/Placeholder;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "centerContentPlaceHolder", "getCenterContentPlaceHolder()Landroid/support/constraint/Placeholder;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "leftBottomCollapsePlaceHolder", "getLeftBottomCollapsePlaceHolder()Landroid/support/constraint/Placeholder;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "rightBottomCollapsePlaceHolder", "getRightBottomCollapsePlaceHolder()Landroid/support/constraint/Placeholder;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(MMCollapsibleTextView.class), "rightCollapsePlaceHolder", "getRightCollapsePlaceHolder()Landroid/support/constraint/Placeholder;")) };
    AppMethodBeat.o(142793);
  }
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142814);
    this.ACn = g.j((a.f.a.a)new i(this));
    this.maxLines = 2147483647;
    this.uwF = 2130970159;
    this.ACs = g.j((a.f.a.a)new d(this));
    this.ACt = g.j((a.f.a.a)new c(this));
    this.ACu = g.j((a.f.a.a)new a(this));
    this.ACv = g.j((a.f.a.a)new b(this));
    this.ACw = g.j((a.f.a.a)new f(this));
    this.ACx = g.j((a.f.a.a)new e(this));
    this.ACy = g.j((a.f.a.a)new g(this));
    this.ACz = g.j((a.f.a.a)new j(this));
    this.ACA = g.j((a.f.a.a)new k(this));
    this.ACB = true;
    this.ACE = -1;
    this.ACF = -1.0F;
    this.ACG = -1.0F;
    this.mContext = paramContext;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(142814);
  }
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142815);
    this.ACn = g.j((a.f.a.a)new i(this));
    this.maxLines = 2147483647;
    this.uwF = 2130970159;
    this.ACs = g.j((a.f.a.a)new d(this));
    this.ACt = g.j((a.f.a.a)new c(this));
    this.ACu = g.j((a.f.a.a)new a(this));
    this.ACv = g.j((a.f.a.a)new b(this));
    this.ACw = g.j((a.f.a.a)new f(this));
    this.ACx = g.j((a.f.a.a)new e(this));
    this.ACy = g.j((a.f.a.a)new g(this));
    this.ACz = g.j((a.f.a.a)new j(this));
    this.ACA = g.j((a.f.a.a)new k(this));
    this.ACB = true;
    this.ACE = -1;
    this.ACF = -1.0F;
    this.ACG = -1.0F;
    this.mContext = paramContext;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(142815);
  }
  
  private final void dOD()
  {
    AppMethodBeat.i(142812);
    float f;
    if (this.kji) {
      f = this.ACE * 3.0F / 4.0F;
    }
    while (getLastLineRight() < f)
    {
      localObject1 = getRightCollapsePlaceHolder();
      j.p(localObject1, "rightCollapsePlaceHolder");
      localObject1 = ((Placeholder)localObject1).getLayoutParams();
      int i;
      if (localObject1 == null)
      {
        localObject1 = new a.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(142812);
        throw ((Throwable)localObject1);
        i = this.ACE;
        localObject1 = getCollapseButton();
        j.p(localObject1, "collapseButton");
        f = i - ((View)localObject1).getMeasuredWidth();
      }
      else
      {
        localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
        i = getLastLineHeight();
        localObject2 = getCollapseButton();
        j.p(localObject2, "collapseButton");
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (Math.max(0, i - ((View)localObject2).getMeasuredHeight()) / 2 + 1);
        localObject2 = getRightCollapsePlaceHolder();
        j.p(localObject2, "rightCollapsePlaceHolder");
        ((Placeholder)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        getRightBottomCollapsePlaceHolder().setContentId(-1);
        localObject1 = getRightCollapsePlaceHolder();
        localObject2 = getCollapseButton();
        j.p(localObject2, "collapseButton");
        ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
        getRightCollapsePlaceHolder().updatePreLayout((ConstraintLayout)this);
        AppMethodBeat.o(142812);
        return;
      }
    }
    getRightCollapsePlaceHolder().setContentId(-1);
    Object localObject1 = getRightBottomCollapsePlaceHolder();
    Object localObject2 = getCollapseButton();
    j.p(localObject2, "collapseButton");
    ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
    getRightBottomCollapsePlaceHolder().updatePreLayout((ConstraintLayout)this);
    AppMethodBeat.o(142812);
  }
  
  private final Placeholder getCenterContentPlaceHolder()
  {
    AppMethodBeat.i(142800);
    Placeholder localPlaceholder = (Placeholder)this.ACx.getValue();
    AppMethodBeat.o(142800);
    return localPlaceholder;
  }
  
  private final View getCollapseButton()
  {
    AppMethodBeat.i(142808);
    if (this.ACr)
    {
      localView = (View)get_collapseImage();
      AppMethodBeat.o(142808);
      return localView;
    }
    View localView = (View)get_collapseButton();
    AppMethodBeat.o(142808);
    return localView;
  }
  
  private final View getContentText()
  {
    AppMethodBeat.i(142807);
    if (this.kji)
    {
      localView = (View)get_contentBackupText();
      AppMethodBeat.o(142807);
      return localView;
    }
    View localView = (View)get_contentText();
    AppMethodBeat.o(142807);
    return localView;
  }
  
  private final Placeholder getFullContentPlaceHolder()
  {
    AppMethodBeat.i(142799);
    Placeholder localPlaceholder = (Placeholder)this.ACw.getValue();
    AppMethodBeat.o(142799);
    return localPlaceholder;
  }
  
  private final int getLastLineHeight()
  {
    AppMethodBeat.i(142809);
    if (this.kji)
    {
      localObject = get_contentBackupText();
      j.p(localObject, "_contentBackupText");
      i = ((TextView)localObject).getLineHeight();
      AppMethodBeat.o(142809);
      return i;
    }
    Object localObject = get_contentText();
    j.p(localObject, "_contentText");
    int i = ((MMNeat7extView)localObject).getLineHeight();
    AppMethodBeat.o(142809);
    return i;
  }
  
  private final float getLastLineRight()
  {
    if (this.ACB) {
      return this.ACF;
    }
    return this.ACG;
  }
  
  private final Placeholder getLeftBottomCollapsePlaceHolder()
  {
    AppMethodBeat.i(142801);
    Placeholder localPlaceholder = (Placeholder)this.ACy.getValue();
    AppMethodBeat.o(142801);
    return localPlaceholder;
  }
  
  private final Resources getResource()
  {
    AppMethodBeat.i(142794);
    Resources localResources = (Resources)this.ACn.getValue();
    AppMethodBeat.o(142794);
    return localResources;
  }
  
  private final Placeholder getRightBottomCollapsePlaceHolder()
  {
    AppMethodBeat.i(142802);
    Placeholder localPlaceholder = (Placeholder)this.ACz.getValue();
    AppMethodBeat.o(142802);
    return localPlaceholder;
  }
  
  private final Placeholder getRightCollapsePlaceHolder()
  {
    AppMethodBeat.i(142803);
    Placeholder localPlaceholder = (Placeholder)this.ACA.getValue();
    AppMethodBeat.o(142803);
    return localPlaceholder;
  }
  
  private final ImageView get_collapseImage()
  {
    AppMethodBeat.i(142798);
    ImageView localImageView = (ImageView)this.ACv.getValue();
    AppMethodBeat.o(142798);
    return localImageView;
  }
  
  @SuppressLint({"Recycle", "CustomViewStyleable"})
  private final void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142804);
    int i3;
    int i2;
    int i1;
    int n;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.MMCollapsibleTextView, paramInt, 0);
      j.p(paramAttributeSet, "tArray");
      int i4 = paramAttributeSet.getIndexCount();
      paramInt = -1;
      int k = -1;
      int j = -1;
      int i = -1;
      int m = 0;
      i3 = paramInt;
      i2 = k;
      i1 = j;
      n = i;
      if (m < i4)
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
            if (n == 7)
            {
              if (paramAttributeSet.getInt(n, 0) != 0) {}
              for (bool = true;; bool = false)
              {
                this.ACq = bool;
                break;
              }
            }
            if (n != 6) {
              break label237;
            }
            this.ACp = paramAttributeSet.getBoolean(n, this.ACp);
          }
        }
        label237:
        if (n == 8) {
          if (paramAttributeSet.getInt(n, 0) == 0) {
            break label266;
          }
        }
        label266:
        for (boolean bool = true;; bool = false)
        {
          this.ACr = bool;
          break;
        }
      }
    }
    else
    {
      i3 = -1;
      i2 = -1;
      i1 = -1;
      n = -1;
    }
    w.hM(this.mContext).inflate(this.uwF, (ViewGroup)this);
    if (i2 != -1) {
      get_collapseButton().setTextColor(i2);
    }
    if (i1 != -1)
    {
      get_contentText().setTextColor(i1);
      get_contentBackupText().setTextColor(i1);
    }
    if (n != -1)
    {
      get_collapseButton().setTextSize(0, n);
      get_contentText().setTextSize(0, n);
      get_contentBackupText().setTextSize(0, n);
    }
    if (i3 != -1)
    {
      get_contentText().setSpacingAdd(i3);
      get_contentBackupText().setLineSpacing(i3, 1.0F);
    }
    AppMethodBeat.o(142804);
  }
  
  private final void setCollapseStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(142811);
    Object localObject;
    if (this.ACr)
    {
      localObject = get_collapseImage();
      if (paramBoolean)
      {
        i = 2131231283;
        ((ImageView)localObject).setImageResource(i);
        if (!paramBoolean) {
          break label87;
        }
      }
    }
    label87:
    for (int i = this.maxLines;; i = 2147483647)
    {
      setMaxLines(i);
      AppMethodBeat.o(142811);
      return;
      i = 2131231150;
      break;
      localObject = get_collapseButton();
      if (paramBoolean) {}
      for (i = 2131299495;; i = 2131298419)
      {
        ((TextView)localObject).setText(i);
        break;
      }
    }
  }
  
  private final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(142806);
    if (this.kji)
    {
      TextView localTextView = get_contentBackupText();
      j.p(localTextView, "_contentBackupText");
      localTextView.setMaxLines(paramInt);
      AppMethodBeat.o(142806);
      return;
    }
    get_contentText().setMaxLines(paramInt);
    AppMethodBeat.o(142806);
  }
  
  public final boolean getCollapsed()
  {
    return this.ACB;
  }
  
  public final a.f.a.a<y> getOnCollapse()
  {
    return this.ACC;
  }
  
  public final a.f.a.a<y> getOnExpand()
  {
    return this.ACD;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(142805);
    MMNeat7extView localMMNeat7extView = get_contentText();
    j.p(localMMNeat7extView, "_contentText");
    float f = localMMNeat7extView.getTextSize();
    AppMethodBeat.o(142805);
    return f;
  }
  
  public final TextView get_collapseButton()
  {
    AppMethodBeat.i(142797);
    TextView localTextView = (TextView)this.ACu.getValue();
    AppMethodBeat.o(142797);
    return localTextView;
  }
  
  public final TextView get_contentBackupText()
  {
    AppMethodBeat.i(142796);
    TextView localTextView = (TextView)this.ACt.getValue();
    AppMethodBeat.o(142796);
    return localTextView;
  }
  
  public final MMNeat7extView get_contentText()
  {
    AppMethodBeat.i(142795);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.ACs.getValue();
    AppMethodBeat.o(142795);
    return localMMNeat7extView;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142810);
    final int i = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    Object localObject1;
    Object localObject2;
    boolean bool;
    label211:
    float f1;
    if ((this.ACo) || (i != this.ACE))
    {
      this.ACF = -1.0F;
      this.ACG = -1.0F;
      this.ACo = false;
      this.ACE = i;
      get_contentText().setMaxLines(2147483647);
      localObject1 = get_contentText();
      localObject2 = this.text;
      if (localObject2 == null) {
        j.ays("text");
      }
      ((MMNeat7extView)localObject1).af((CharSequence)localObject2);
      localObject1 = get_contentText();
      j.p(localObject1, "_contentText");
      this.kji = ((MMNeat7extView)localObject1).dTA();
      com.tencent.neattextview.textview.layout.a locala = get_contentText().Sa(i);
      j.p(locala, "layout");
      if (locala.dTo() <= this.maxLines) {
        break label641;
      }
      bool = true;
      this.mTD = bool;
      if ((this.ACp) && (!this.mTD)) {
        break label647;
      }
      localObject1 = getFullContentPlaceHolder();
      localObject2 = getContentText();
      j.p(localObject2, "contentText");
      ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
      if (this.mTD)
      {
        getCollapseButton().setOnClickListener((View.OnClickListener)new l(this));
        localObject1 = getCollapseButton();
        j.p(localObject1, "collapseButton");
        ((View)localObject1).setVisibility(0);
        if (!this.ACq)
        {
          localObject1 = getLeftBottomCollapsePlaceHolder();
          localObject2 = getCollapseButton();
          j.p(localObject2, "collapseButton");
          ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
        }
        setCollapseStatus(this.ACB);
        if (this.ACq)
        {
          if (!this.ACr) {
            break label680;
          }
          i = (int)(getLastLineHeight() * 0.8F);
          localObject1 = get_collapseImage();
          j.p(localObject1, "_collapseImage");
          localObject1 = ((ImageView)localObject1).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).height = i;
          localObject2 = get_collapseImage();
          j.p(localObject2, "_collapseImage");
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          get_collapseImage().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
          localObject1 = get_collapseImage();
          j.p(localObject1, "_collapseImage");
          localObject2 = ((ImageView)localObject1).getParent();
          localObject1 = localObject2;
          if (!(localObject2 instanceof View)) {
            localObject1 = null;
          }
          localObject1 = (View)localObject1;
          if (localObject1 != null) {
            ((View)localObject1).post((Runnable)new h((View)localObject1, this, i));
          }
          label462:
          localObject1 = getResource();
          j.p(localObject1, "resource");
          f1 = ((Resources)localObject1).getDisplayMetrics().density;
          localObject1 = getCollapseButton();
          j.p(localObject1, "collapseButton");
          float f2 = ((View)localObject1).getMeasuredWidth();
          get_contentText().a(TextUtils.TruncateAt.END, f1 * 1.0F + 0.5F + f2);
          i = this.maxLines;
          int j = locala.dTo();
          if (!this.kji) {
            break label700;
          }
          f1 = locala.getLineRight(i - 1);
          label560:
          this.ACF = f1;
          this.ACG = locala.getLineRight(j - 1);
          dOD();
        }
      }
      localObject1 = this.text;
      if (localObject1 == null) {
        j.ays("text");
      }
      if (!this.kji) {
        break label705;
      }
      localObject2 = get_contentBackupText();
      j.p(localObject2, "_contentBackupText");
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(142810);
      return;
      label641:
      bool = false;
      break;
      label647:
      localObject1 = getCenterContentPlaceHolder();
      localObject2 = getContentText();
      j.p(localObject2, "contentText");
      ((Placeholder)localObject1).setContentId(((View)localObject2).getId());
      break label211;
      label680:
      get_collapseButton().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      break label462;
      label700:
      f1 = 0.0F;
      break label560;
      label705:
      get_contentText().af((CharSequence)localObject1);
    }
  }
  
  public final void setCollapsed(boolean paramBoolean)
  {
    this.ACB = paramBoolean;
  }
  
  public final void setOnCollapse(a.f.a.a<y> parama)
  {
    this.ACC = parama;
  }
  
  public final void setOnExpand(a.f.a.a<y> parama)
  {
    this.ACD = parama;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142813);
    j.q(paramCharSequence, "text");
    this.text = paramCharSequence;
    this.ACo = true;
    AppMethodBeat.o(142813);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends a.f.b.k
    implements a.f.a.a<TextView>
  {
    a(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends a.f.b.k
    implements a.f.a.a<ImageView>
  {
    b(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends a.f.b.k
    implements a.f.a.a<TextView>
  {
    c(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends a.f.b.k
    implements a.f.a.a<MMNeat7extView>
  {
    d(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends a.f.b.k
    implements a.f.a.a<Placeholder>
  {
    e(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends a.f.b.k
    implements a.f.a.a<Placeholder>
  {
    f(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends a.f.b.k
    implements a.f.a.a<Placeholder>
  {
    g(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/ui/widget/MMCollapsibleTextView$measureTruncate$2$1"})
  static final class h
    implements Runnable
  {
    h(View paramView, MMCollapsibleTextView paramMMCollapsibleTextView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(142788);
      Rect localRect = new Rect();
      int i = (int)(i * 1.5F);
      MMCollapsibleTextView.a(jdField_this).getHitRect(localRect);
      localRect.top -= i;
      localRect.left -= i;
      localRect.bottom += i;
      localRect.right = (i + localRect.right);
      this.ACI.setTouchDelegate(new TouchDelegate(localRect, (View)MMCollapsibleTextView.a(jdField_this)));
      AppMethodBeat.o(142788);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends a.f.b.k
    implements a.f.a.a<Resources>
  {
    i(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends a.f.b.k
    implements a.f.a.a<Placeholder>
  {
    j(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/support/constraint/Placeholder;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends a.f.b.k
    implements a.f.a.a<Placeholder>
  {
    k(MMCollapsibleTextView paramMMCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(MMCollapsibleTextView paramMMCollapsibleTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(142792);
      MMCollapsibleTextView.b(this.ACH);
      AppMethodBeat.o(142792);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */