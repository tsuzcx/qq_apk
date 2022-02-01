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
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/search/WebSearchView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/view/View;", "getBackBtn", "()Landroid/view/View;", "setBackBtn", "(Landroid/view/View;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "ftsEditText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "setFtsEditText", "(Lcom/tencent/mm/ui/search/FTSEditTextView;)V", "searchIcon", "Landroid/widget/ImageView;", "getSearchIcon", "()Landroid/widget/ImageView;", "setSearchIcon", "(Landroid/widget/ImageView;)V", "searchViewListener", "Lcom/tencent/mm/ui/search/ISearchViewListener;", "initView", "", "setSearchViewListener", "libmmui_release"})
public final class WebSearchView
  extends LinearLayout
{
  public ImageView Doj;
  private b ILF;
  public FTSEditTextView ILz;
  public View ucS;
  public View xpx;
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197300);
    initView();
    AppMethodBeat.o(197300);
  }
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197301);
    initView();
    AppMethodBeat.o(197301);
  }
  
  private void initView()
  {
    AppMethodBeat.i(197297);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(197297);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(2131496373, (ViewGroup)this, true);
    localObject = findViewById(2131296303);
    k.g(localObject, "findViewById(R.id.ab_back_btn)");
    this.ucS = ((View)localObject);
    localObject = this.ucS;
    if (localObject == null) {
      k.aVY("backBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    localObject = findViewById(2131297690);
    k.g(localObject, "findViewById(R.id.cancel_btn)");
    this.xpx = ((View)localObject);
    localObject = this.xpx;
    if (localObject == null) {
      k.aVY("cancelBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
    localObject = findViewById(2131304422);
    k.g(localObject, "findViewById(R.id.search_icon)");
    this.Doj = ((ImageView)localObject);
    localObject = findViewById(2131300315);
    k.g(localObject, "findViewById(R.id.fts_edittext)");
    this.ILz = ((FTSEditTextView)localObject);
    localObject = this.ILz;
    if (localObject == null) {
      k.aVY("ftsEditText");
    }
    ((FTSEditTextView)localObject).ftb();
    AppMethodBeat.o(197297);
  }
  
  public final View getBackBtn()
  {
    AppMethodBeat.i(197293);
    View localView = this.ucS;
    if (localView == null) {
      k.aVY("backBtn");
    }
    AppMethodBeat.o(197293);
    return localView;
  }
  
  public final View getCancelBtn()
  {
    AppMethodBeat.i(197295);
    View localView = this.xpx;
    if (localView == null) {
      k.aVY("cancelBtn");
    }
    AppMethodBeat.o(197295);
    return localView;
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    AppMethodBeat.i(197289);
    FTSEditTextView localFTSEditTextView = this.ILz;
    if (localFTSEditTextView == null) {
      k.aVY("ftsEditText");
    }
    AppMethodBeat.o(197289);
    return localFTSEditTextView;
  }
  
  public final ImageView getSearchIcon()
  {
    AppMethodBeat.i(197291);
    ImageView localImageView = this.Doj;
    if (localImageView == null) {
      k.aVY("searchIcon");
    }
    AppMethodBeat.o(197291);
    return localImageView;
  }
  
  public final void setBackBtn(View paramView)
  {
    AppMethodBeat.i(197294);
    k.h(paramView, "<set-?>");
    this.ucS = paramView;
    AppMethodBeat.o(197294);
  }
  
  public final void setCancelBtn(View paramView)
  {
    AppMethodBeat.i(197296);
    k.h(paramView, "<set-?>");
    this.xpx = paramView;
    AppMethodBeat.o(197296);
  }
  
  public final void setFtsEditText(FTSEditTextView paramFTSEditTextView)
  {
    AppMethodBeat.i(197290);
    k.h(paramFTSEditTextView, "<set-?>");
    this.ILz = paramFTSEditTextView;
    AppMethodBeat.o(197290);
  }
  
  public final void setSearchIcon(ImageView paramImageView)
  {
    AppMethodBeat.i(197292);
    k.h(paramImageView, "<set-?>");
    this.Doj = paramImageView;
    AppMethodBeat.o(197292);
  }
  
  public final void setSearchViewListener(b paramb)
  {
    AppMethodBeat.i(197298);
    k.h(paramb, "searchViewListener");
    this.ILF = paramb;
    AppMethodBeat.o(197298);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197287);
      b localb = WebSearchView.a(this.ILG);
      if (localb != null)
      {
        k.g(paramView, "v");
        localb.onClickBackBtn(paramView);
        AppMethodBeat.o(197287);
        return;
      }
      AppMethodBeat.o(197287);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchView paramWebSearchView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197288);
      b localb = WebSearchView.a(this.ILG);
      if (localb != null)
      {
        k.g(paramView, "v");
        localb.onClickCancelBtn(paramView);
        AppMethodBeat.o(197288);
        return;
      }
      AppMethodBeat.o(197288);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.search.WebSearchView
 * JD-Core Version:    0.7.0.1
 */