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
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/search/WebSearchView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/view/View;", "getBackBtn", "()Landroid/view/View;", "setBackBtn", "(Landroid/view/View;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "ftsEditText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "setFtsEditText", "(Lcom/tencent/mm/ui/search/FTSEditTextView;)V", "searchIcon", "Landroid/widget/ImageView;", "getSearchIcon", "()Landroid/widget/ImageView;", "setSearchIcon", "(Landroid/widget/ImageView;)V", "searchViewListener", "Lcom/tencent/mm/ui/search/ISearchViewListener;", "initView", "", "setSearchViewListener", "libmmui_release"})
public final class WebSearchView
  extends LinearLayout
{
  public ImageView ETp;
  public FTSEditTextView KCG;
  private b KCM;
  public View vfC;
  public View yEa;
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(186616);
    initView();
    AppMethodBeat.o(186616);
  }
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186617);
    initView();
    AppMethodBeat.o(186617);
  }
  
  private void initView()
  {
    AppMethodBeat.i(186614);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(186614);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(2131496373, (ViewGroup)this, true);
    localObject = findViewById(2131296303);
    p.g(localObject, "findViewById(R.id.ab_back_btn)");
    this.vfC = ((View)localObject);
    localObject = this.vfC;
    if (localObject == null) {
      p.bcb("backBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    localObject = findViewById(2131297690);
    p.g(localObject, "findViewById(R.id.cancel_btn)");
    this.yEa = ((View)localObject);
    localObject = this.yEa;
    if (localObject == null) {
      p.bcb("cancelBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
    localObject = findViewById(2131304422);
    p.g(localObject, "findViewById(R.id.search_icon)");
    this.ETp = ((ImageView)localObject);
    localObject = findViewById(2131300315);
    p.g(localObject, "findViewById(R.id.fts_edittext)");
    this.KCG = ((FTSEditTextView)localObject);
    localObject = this.KCG;
    if (localObject == null) {
      p.bcb("ftsEditText");
    }
    ((FTSEditTextView)localObject).fJP();
    AppMethodBeat.o(186614);
  }
  
  public final View getBackBtn()
  {
    AppMethodBeat.i(186610);
    View localView = this.vfC;
    if (localView == null) {
      p.bcb("backBtn");
    }
    AppMethodBeat.o(186610);
    return localView;
  }
  
  public final View getCancelBtn()
  {
    AppMethodBeat.i(186612);
    View localView = this.yEa;
    if (localView == null) {
      p.bcb("cancelBtn");
    }
    AppMethodBeat.o(186612);
    return localView;
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    AppMethodBeat.i(186606);
    FTSEditTextView localFTSEditTextView = this.KCG;
    if (localFTSEditTextView == null) {
      p.bcb("ftsEditText");
    }
    AppMethodBeat.o(186606);
    return localFTSEditTextView;
  }
  
  public final ImageView getSearchIcon()
  {
    AppMethodBeat.i(186608);
    ImageView localImageView = this.ETp;
    if (localImageView == null) {
      p.bcb("searchIcon");
    }
    AppMethodBeat.o(186608);
    return localImageView;
  }
  
  public final void setBackBtn(View paramView)
  {
    AppMethodBeat.i(186611);
    p.h(paramView, "<set-?>");
    this.vfC = paramView;
    AppMethodBeat.o(186611);
  }
  
  public final void setCancelBtn(View paramView)
  {
    AppMethodBeat.i(186613);
    p.h(paramView, "<set-?>");
    this.yEa = paramView;
    AppMethodBeat.o(186613);
  }
  
  public final void setFtsEditText(FTSEditTextView paramFTSEditTextView)
  {
    AppMethodBeat.i(186607);
    p.h(paramFTSEditTextView, "<set-?>");
    this.KCG = paramFTSEditTextView;
    AppMethodBeat.o(186607);
  }
  
  public final void setSearchIcon(ImageView paramImageView)
  {
    AppMethodBeat.i(186609);
    p.h(paramImageView, "<set-?>");
    this.ETp = paramImageView;
    AppMethodBeat.o(186609);
  }
  
  public final void setSearchViewListener(b paramb)
  {
    AppMethodBeat.i(186615);
    p.h(paramb, "searchViewListener");
    this.KCM = paramb;
    AppMethodBeat.o(186615);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186604);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      a.b("com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = WebSearchView.a(this.KCN);
      if (localObject != null)
      {
        p.g(paramView, "v");
        ((b)localObject).onClickBackBtn(paramView);
      }
      a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186604);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186605);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      a.b("com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = WebSearchView.a(this.KCN);
      if (localObject != null)
      {
        p.g(paramView, "v");
        ((b)localObject).onClickCancelBtn(paramView);
      }
      a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186605);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.search.WebSearchView
 * JD-Core Version:    0.7.0.1
 */