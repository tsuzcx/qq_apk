package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.ui.search.FTSEditTextView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "backBtn", "Landroid/view/View;", "<set-?>", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "ftsEditText", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "searchIcon", "Landroid/widget/ImageView;", "searchViewListener", "Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "hideSearchIcon", "", "init", "setSearchViewListener", "Companion", "FTSImageSearchListener", "FTSSearchViewListener", "IFTSTagModel", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FTSSearchNoActionBarView
  extends LinearLayout
{
  public static final FTSSearchNoActionBarView.a Mhk;
  private ImageView Boh;
  private View CxW;
  private FTSEditTextView Mhl;
  private FTSSearchNoActionBarView.b Mhm;
  
  static
  {
    AppMethodBeat.i(286910);
    Mhk = new FTSSearchNoActionBarView.a((byte)0);
    AppMethodBeat.o(286910);
  }
  
  public FTSSearchNoActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286886);
    init();
    AppMethodBeat.o(286886);
  }
  
  public FTSSearchNoActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(286889);
    init();
    AppMethodBeat.o(286889);
  }
  
  private static final void a(FTSSearchNoActionBarView paramFTSSearchNoActionBarView, View paramView)
  {
    AppMethodBeat.i(286905);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFTSSearchNoActionBarView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFTSSearchNoActionBarView, "this$0");
    if (paramFTSSearchNoActionBarView.Mhm != null)
    {
      paramFTSSearchNoActionBarView = paramFTSSearchNoActionBarView.Mhm;
      s.checkNotNull(paramFTSSearchNoActionBarView);
      paramFTSSearchNoActionBarView.grp();
    }
    a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286905);
  }
  
  private final void init()
  {
    AppMethodBeat.i(286896);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(286896);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(b.f.fts_searchview, (ViewGroup)this, true);
    this.CxW = findViewById(b.e.cancel_btn);
    localObject = this.CxW;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new FTSSearchNoActionBarView..ExternalSyntheticLambda0(this));
    }
    this.Boh = ((ImageView)findViewById(b.e.search_icon));
    localObject = this.Boh;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = findViewById(b.e.fts_edittext);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.search.FTSEditTextView");
      AppMethodBeat.o(286896);
      throw ((Throwable)localObject);
    }
    this.Mhl = ((FTSEditTextView)localObject);
    AppMethodBeat.o(286896);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.Mhl;
  }
  
  public final void setSearchViewListener(FTSSearchNoActionBarView.b paramb)
  {
    this.Mhm = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.FTSSearchNoActionBarView
 * JD-Core Version:    0.7.0.1
 */