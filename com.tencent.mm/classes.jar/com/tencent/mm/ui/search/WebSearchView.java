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
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/search/WebSearchView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/view/View;", "getBackBtn", "()Landroid/view/View;", "setBackBtn", "(Landroid/view/View;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "ftsEditText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "setFtsEditText", "(Lcom/tencent/mm/ui/search/FTSEditTextView;)V", "searchIcon", "Landroid/widget/ImageView;", "getSearchIcon", "()Landroid/widget/ImageView;", "setSearchIcon", "(Landroid/widget/ImageView;)V", "searchViewListener", "Lcom/tencent/mm/ui/search/ISearchViewListener;", "initView", "", "setSearchViewListener", "libmmui_release"})
public final class WebSearchView
  extends LinearLayout
{
  public FTSEditTextView Awv;
  public ImageView Aww;
  public View CYY;
  private b Qod;
  public View uvi;
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204858);
    initView();
    AppMethodBeat.o(204858);
  }
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204859);
    initView();
    AppMethodBeat.o(204859);
  }
  
  private void initView()
  {
    AppMethodBeat.i(204856);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(204856);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(2131497052, (ViewGroup)this, true);
    localObject = findViewById(2131296316);
    p.g(localObject, "findViewById(R.id.ab_back_btn)");
    this.uvi = ((View)localObject);
    localObject = this.uvi;
    if (localObject == null) {
      p.btv("backBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    localObject = findViewById(2131297963);
    p.g(localObject, "findViewById(R.id.cancel_btn)");
    this.CYY = ((View)localObject);
    localObject = this.CYY;
    if (localObject == null) {
      p.btv("cancelBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
    localObject = findViewById(2131307390);
    p.g(localObject, "findViewById(R.id.search_icon)");
    this.Aww = ((ImageView)localObject);
    localObject = findViewById(2131301807);
    p.g(localObject, "findViewById(R.id.fts_edittext)");
    this.Awv = ((FTSEditTextView)localObject);
    localObject = this.Awv;
    if (localObject == null) {
      p.btv("ftsEditText");
    }
    ((FTSEditTextView)localObject).gWY();
    AppMethodBeat.o(204856);
  }
  
  public final View getBackBtn()
  {
    AppMethodBeat.i(204852);
    View localView = this.uvi;
    if (localView == null) {
      p.btv("backBtn");
    }
    AppMethodBeat.o(204852);
    return localView;
  }
  
  public final View getCancelBtn()
  {
    AppMethodBeat.i(204854);
    View localView = this.CYY;
    if (localView == null) {
      p.btv("cancelBtn");
    }
    AppMethodBeat.o(204854);
    return localView;
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    AppMethodBeat.i(204848);
    FTSEditTextView localFTSEditTextView = this.Awv;
    if (localFTSEditTextView == null) {
      p.btv("ftsEditText");
    }
    AppMethodBeat.o(204848);
    return localFTSEditTextView;
  }
  
  public final ImageView getSearchIcon()
  {
    AppMethodBeat.i(204850);
    ImageView localImageView = this.Aww;
    if (localImageView == null) {
      p.btv("searchIcon");
    }
    AppMethodBeat.o(204850);
    return localImageView;
  }
  
  public final void setBackBtn(View paramView)
  {
    AppMethodBeat.i(204853);
    p.h(paramView, "<set-?>");
    this.uvi = paramView;
    AppMethodBeat.o(204853);
  }
  
  public final void setCancelBtn(View paramView)
  {
    AppMethodBeat.i(204855);
    p.h(paramView, "<set-?>");
    this.CYY = paramView;
    AppMethodBeat.o(204855);
  }
  
  public final void setFtsEditText(FTSEditTextView paramFTSEditTextView)
  {
    AppMethodBeat.i(204849);
    p.h(paramFTSEditTextView, "<set-?>");
    this.Awv = paramFTSEditTextView;
    AppMethodBeat.o(204849);
  }
  
  public final void setSearchIcon(ImageView paramImageView)
  {
    AppMethodBeat.i(204851);
    p.h(paramImageView, "<set-?>");
    this.Aww = paramImageView;
    AppMethodBeat.o(204851);
  }
  
  public final void setSearchViewListener(b paramb)
  {
    AppMethodBeat.i(204857);
    p.h(paramb, "searchViewListener");
    this.Qod = paramb;
    AppMethodBeat.o(204857);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204846);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = WebSearchView.a(this.Qoe);
      if (localObject != null)
      {
        p.g(paramView, "v");
        ((b)localObject).onClickBackBtn(paramView);
      }
      a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204846);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204847);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = WebSearchView.a(this.Qoe);
      if (localObject != null)
      {
        p.g(paramView, "v");
        ((b)localObject).onClickCancelBtn(paramView);
      }
      a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.search.WebSearchView
 * JD-Core Version:    0.7.0.1
 */