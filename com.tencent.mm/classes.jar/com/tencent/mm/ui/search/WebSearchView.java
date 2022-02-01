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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/search/WebSearchView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/view/View;", "getBackBtn", "()Landroid/view/View;", "setBackBtn", "(Landroid/view/View;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "ftsEditText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "setFtsEditText", "(Lcom/tencent/mm/ui/search/FTSEditTextView;)V", "searchIcon", "Landroid/widget/ImageView;", "getSearchIcon", "()Landroid/widget/ImageView;", "setSearchIcon", "(Landroid/widget/ImageView;)V", "searchViewListener", "Lcom/tencent/mm/ui/search/ISearchViewListener;", "initView", "", "setSearchViewListener", "libmmui_release"})
public final class WebSearchView
  extends LinearLayout
{
  public ImageView FlK;
  public FTSEditTextView KZa;
  private b KZg;
  public View vrJ;
  public View yUf;
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193873);
    initView();
    AppMethodBeat.o(193873);
  }
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193874);
    initView();
    AppMethodBeat.o(193874);
  }
  
  private void initView()
  {
    AppMethodBeat.i(193871);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(193871);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(2131496373, (ViewGroup)this, true);
    localObject = findViewById(2131296303);
    p.g(localObject, "findViewById(R.id.ab_back_btn)");
    this.vrJ = ((View)localObject);
    localObject = this.vrJ;
    if (localObject == null) {
      p.bdF("backBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    localObject = findViewById(2131297690);
    p.g(localObject, "findViewById(R.id.cancel_btn)");
    this.yUf = ((View)localObject);
    localObject = this.yUf;
    if (localObject == null) {
      p.bdF("cancelBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
    localObject = findViewById(2131304422);
    p.g(localObject, "findViewById(R.id.search_icon)");
    this.FlK = ((ImageView)localObject);
    localObject = findViewById(2131300315);
    p.g(localObject, "findViewById(R.id.fts_edittext)");
    this.KZa = ((FTSEditTextView)localObject);
    localObject = this.KZa;
    if (localObject == null) {
      p.bdF("ftsEditText");
    }
    ((FTSEditTextView)localObject).fOg();
    AppMethodBeat.o(193871);
  }
  
  public final View getBackBtn()
  {
    AppMethodBeat.i(193867);
    View localView = this.vrJ;
    if (localView == null) {
      p.bdF("backBtn");
    }
    AppMethodBeat.o(193867);
    return localView;
  }
  
  public final View getCancelBtn()
  {
    AppMethodBeat.i(193869);
    View localView = this.yUf;
    if (localView == null) {
      p.bdF("cancelBtn");
    }
    AppMethodBeat.o(193869);
    return localView;
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    AppMethodBeat.i(193863);
    FTSEditTextView localFTSEditTextView = this.KZa;
    if (localFTSEditTextView == null) {
      p.bdF("ftsEditText");
    }
    AppMethodBeat.o(193863);
    return localFTSEditTextView;
  }
  
  public final ImageView getSearchIcon()
  {
    AppMethodBeat.i(193865);
    ImageView localImageView = this.FlK;
    if (localImageView == null) {
      p.bdF("searchIcon");
    }
    AppMethodBeat.o(193865);
    return localImageView;
  }
  
  public final void setBackBtn(View paramView)
  {
    AppMethodBeat.i(193868);
    p.h(paramView, "<set-?>");
    this.vrJ = paramView;
    AppMethodBeat.o(193868);
  }
  
  public final void setCancelBtn(View paramView)
  {
    AppMethodBeat.i(193870);
    p.h(paramView, "<set-?>");
    this.yUf = paramView;
    AppMethodBeat.o(193870);
  }
  
  public final void setFtsEditText(FTSEditTextView paramFTSEditTextView)
  {
    AppMethodBeat.i(193864);
    p.h(paramFTSEditTextView, "<set-?>");
    this.KZa = paramFTSEditTextView;
    AppMethodBeat.o(193864);
  }
  
  public final void setSearchIcon(ImageView paramImageView)
  {
    AppMethodBeat.i(193866);
    p.h(paramImageView, "<set-?>");
    this.FlK = paramImageView;
    AppMethodBeat.o(193866);
  }
  
  public final void setSearchViewListener(b paramb)
  {
    AppMethodBeat.i(193872);
    p.h(paramb, "searchViewListener");
    this.KZg = paramb;
    AppMethodBeat.o(193872);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193861);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      a.b("com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = WebSearchView.a(this.KZh);
      if (localObject != null)
      {
        p.g(paramView, "v");
        ((b)localObject).onClickBackBtn(paramView);
      }
      a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(193861);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193862);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      a.b("com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = WebSearchView.a(this.KZh);
      if (localObject != null)
      {
        p.g(paramView, "v");
        ((b)localObject).onClickCancelBtn(paramView);
      }
      a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(193862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.search.WebSearchView
 * JD-Core Version:    0.7.0.1
 */