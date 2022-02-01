package com.tencent.mm.ui.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/search/WebSearchView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/view/View;", "getBackBtn", "()Landroid/view/View;", "setBackBtn", "(Landroid/view/View;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "ftsEditText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "setFtsEditText", "(Lcom/tencent/mm/ui/search/FTSEditTextView;)V", "searchIcon", "Landroid/widget/ImageView;", "getSearchIcon", "()Landroid/widget/ImageView;", "setSearchIcon", "(Landroid/widget/ImageView;)V", "searchViewListener", "Lcom/tencent/mm/ui/search/ISearchViewListener;", "initView", "", "setSearchViewListener", "libmmui_release"})
public final class WebSearchView
  extends LinearLayout
{
  public FTSEditTextView Gng;
  public View JeE;
  private b XMi;
  public ImageView xOf;
  public View xZQ;
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220019);
    initView();
    AppMethodBeat.o(220019);
  }
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220020);
    initView();
    AppMethodBeat.o(220020);
  }
  
  private void initView()
  {
    AppMethodBeat.i(220017);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(220017);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(a.h.web_actionbar_searchview, (ViewGroup)this, true);
    localObject = findViewById(a.g.ab_back_btn);
    p.j(localObject, "findViewById(R.id.ab_back_btn)");
    this.xZQ = ((View)localObject);
    localObject = this.xZQ;
    if (localObject == null) {
      p.bGy("backBtn");
    }
    Util.expandViewTouchArea((View)localObject, 200, 200, 200, 200);
    localObject = this.xZQ;
    if (localObject == null) {
      p.bGy("backBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    localObject = findViewById(a.g.cancel_btn);
    p.j(localObject, "findViewById(R.id.cancel_btn)");
    this.JeE = ((View)localObject);
    localObject = this.JeE;
    if (localObject == null) {
      p.bGy("cancelBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
    localObject = findViewById(a.g.search_icon);
    p.j(localObject, "findViewById(R.id.search_icon)");
    this.xOf = ((ImageView)localObject);
    localObject = findViewById(a.g.fts_edittext);
    p.j(localObject, "findViewById(R.id.fts_edittext)");
    this.Gng = ((FTSEditTextView)localObject);
    localObject = this.Gng;
    if (localObject == null) {
      p.bGy("ftsEditText");
    }
    ((FTSEditTextView)localObject).hXB();
    AppMethodBeat.o(220017);
  }
  
  public final View getBackBtn()
  {
    AppMethodBeat.i(220010);
    View localView = this.xZQ;
    if (localView == null) {
      p.bGy("backBtn");
    }
    AppMethodBeat.o(220010);
    return localView;
  }
  
  public final View getCancelBtn()
  {
    AppMethodBeat.i(220013);
    View localView = this.JeE;
    if (localView == null) {
      p.bGy("cancelBtn");
    }
    AppMethodBeat.o(220013);
    return localView;
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    AppMethodBeat.i(220005);
    FTSEditTextView localFTSEditTextView = this.Gng;
    if (localFTSEditTextView == null) {
      p.bGy("ftsEditText");
    }
    AppMethodBeat.o(220005);
    return localFTSEditTextView;
  }
  
  public final ImageView getSearchIcon()
  {
    AppMethodBeat.i(220008);
    ImageView localImageView = this.xOf;
    if (localImageView == null) {
      p.bGy("searchIcon");
    }
    AppMethodBeat.o(220008);
    return localImageView;
  }
  
  public final void setBackBtn(View paramView)
  {
    AppMethodBeat.i(220012);
    p.k(paramView, "<set-?>");
    this.xZQ = paramView;
    AppMethodBeat.o(220012);
  }
  
  public final void setCancelBtn(View paramView)
  {
    AppMethodBeat.i(220014);
    p.k(paramView, "<set-?>");
    this.JeE = paramView;
    AppMethodBeat.o(220014);
  }
  
  public final void setFtsEditText(FTSEditTextView paramFTSEditTextView)
  {
    AppMethodBeat.i(220006);
    p.k(paramFTSEditTextView, "<set-?>");
    this.Gng = paramFTSEditTextView;
    AppMethodBeat.o(220006);
  }
  
  public final void setSearchIcon(ImageView paramImageView)
  {
    AppMethodBeat.i(220009);
    p.k(paramImageView, "<set-?>");
    this.xOf = paramImageView;
    AppMethodBeat.o(220009);
  }
  
  public final void setSearchViewListener(b paramb)
  {
    AppMethodBeat.i(220018);
    p.k(paramb, "searchViewListener");
    this.XMi = paramb;
    AppMethodBeat.o(220018);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208229);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = WebSearchView.a(this.XMj);
      if (localObject != null)
      {
        p.j(paramView, "v");
        ((b)localObject).onClickBackBtn(paramView);
      }
      a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208229);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(189520);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = WebSearchView.a(this.XMj);
      if (localObject != null)
      {
        p.j(paramView, "v");
        ((b)localObject).onClickCancelBtn(paramView);
      }
      a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(189520);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.search.WebSearchView
 * JD-Core Version:    0.7.0.1
 */