package com.tencent.mm.ui.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/search/WebSearchView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/view/View;", "getBackBtn", "()Landroid/view/View;", "setBackBtn", "(Landroid/view/View;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "ftsEditText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "setFtsEditText", "(Lcom/tencent/mm/ui/search/FTSEditTextView;)V", "searchIcon", "Landroid/widget/ImageView;", "getSearchIcon", "()Landroid/widget/ImageView;", "setSearchIcon", "(Landroid/widget/ImageView;)V", "searchViewListener", "Lcom/tencent/mm/ui/search/ISearchViewListener;", "initView", "", "setSearchViewListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebSearchView
  extends LinearLayout
{
  public ImageView Boh;
  public View CxW;
  public FTSEditTextView Mhl;
  public View afCw;
  private a afCx;
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(250028);
    initView();
    AppMethodBeat.o(250028);
  }
  
  public WebSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(250031);
    initView();
    AppMethodBeat.o(250031);
  }
  
  private static final void a(WebSearchView paramWebSearchView, View paramView)
  {
    AppMethodBeat.i(250041);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWebSearchView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/WebSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWebSearchView, "this$0");
    paramWebSearchView = paramWebSearchView.afCx;
    if (paramWebSearchView != null)
    {
      s.s(paramView, "v");
      paramWebSearchView.onClickBackBtn(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/search/WebSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(250041);
  }
  
  private static final void b(WebSearchView paramWebSearchView, View paramView)
  {
    AppMethodBeat.i(250044);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWebSearchView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/WebSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWebSearchView, "this$0");
    paramWebSearchView = paramWebSearchView.afCx;
    if (paramWebSearchView != null)
    {
      s.s(paramView, "v");
      paramWebSearchView.onClickCancelBtn(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/search/WebSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(250044);
  }
  
  private void initView()
  {
    AppMethodBeat.i(250036);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(250036);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(a.h.web_actionbar_searchview, (ViewGroup)this, true);
    localObject = findViewById(a.g.ab_back_btn);
    s.s(localObject, "findViewById(R.id.ab_back_btn)");
    setBackBtn((View)localObject);
    Util.expandViewTouchArea(getBackBtn(), 200, 200, 200, 200);
    getBackBtn().setOnClickListener(new WebSearchView..ExternalSyntheticLambda1(this));
    localObject = findViewById(a.g.cancel_btn);
    s.s(localObject, "findViewById(R.id.cancel_btn)");
    setCancelBtn((View)localObject);
    getCancelBtn().setOnClickListener(new WebSearchView..ExternalSyntheticLambda0(this));
    localObject = findViewById(a.g.search_icon);
    s.s(localObject, "findViewById(R.id.search_icon)");
    setSearchIcon((ImageView)localObject);
    localObject = findViewById(a.g.fts_edittext);
    s.s(localObject, "findViewById(R.id.fts_edittext)");
    setFtsEditText((FTSEditTextView)localObject);
    getFtsEditText().jBL();
    AppMethodBeat.o(250036);
  }
  
  public final View getBackBtn()
  {
    AppMethodBeat.i(250071);
    View localView = this.CxW;
    if (localView != null)
    {
      AppMethodBeat.o(250071);
      return localView;
    }
    s.bIx("backBtn");
    AppMethodBeat.o(250071);
    return null;
  }
  
  public final View getCancelBtn()
  {
    AppMethodBeat.i(250076);
    View localView = this.afCw;
    if (localView != null)
    {
      AppMethodBeat.o(250076);
      return localView;
    }
    s.bIx("cancelBtn");
    AppMethodBeat.o(250076);
    return null;
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    AppMethodBeat.i(250060);
    FTSEditTextView localFTSEditTextView = this.Mhl;
    if (localFTSEditTextView != null)
    {
      AppMethodBeat.o(250060);
      return localFTSEditTextView;
    }
    s.bIx("ftsEditText");
    AppMethodBeat.o(250060);
    return null;
  }
  
  public final ImageView getSearchIcon()
  {
    AppMethodBeat.i(250067);
    ImageView localImageView = this.Boh;
    if (localImageView != null)
    {
      AppMethodBeat.o(250067);
      return localImageView;
    }
    s.bIx("searchIcon");
    AppMethodBeat.o(250067);
    return null;
  }
  
  public final void setBackBtn(View paramView)
  {
    AppMethodBeat.i(250073);
    s.u(paramView, "<set-?>");
    this.CxW = paramView;
    AppMethodBeat.o(250073);
  }
  
  public final void setCancelBtn(View paramView)
  {
    AppMethodBeat.i(250079);
    s.u(paramView, "<set-?>");
    this.afCw = paramView;
    AppMethodBeat.o(250079);
  }
  
  public final void setFtsEditText(FTSEditTextView paramFTSEditTextView)
  {
    AppMethodBeat.i(250065);
    s.u(paramFTSEditTextView, "<set-?>");
    this.Mhl = paramFTSEditTextView;
    AppMethodBeat.o(250065);
  }
  
  public final void setSearchIcon(ImageView paramImageView)
  {
    AppMethodBeat.i(250068);
    s.u(paramImageView, "<set-?>");
    this.Boh = paramImageView;
    AppMethodBeat.o(250068);
  }
  
  public final void setSearchViewListener(a parama)
  {
    AppMethodBeat.i(250088);
    s.u(parama, "searchViewListener");
    this.afCx = parama;
    AppMethodBeat.o(250088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.search.WebSearchView
 * JD-Core Version:    0.7.0.1
 */