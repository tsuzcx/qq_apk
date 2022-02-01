package com.tencent.mm.plugin.mv.ui.view;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.ui.search.FTSEditTextView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "backBtn", "Landroid/view/View;", "<set-?>", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "ftsEditText", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "searchIcon", "Landroid/widget/ImageView;", "searchViewListener", "Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "hideSearchIcon", "", "init", "setSearchViewListener", "Companion", "FTSImageSearchListener", "FTSSearchViewListener", "IFTSTagModel", "plugin-mv_release"})
public final class FTSSearchNoActionBarView
  extends LinearLayout
{
  public static final FTSSearchNoActionBarView.a Gni;
  private FTSEditTextView Gng;
  private b Gnh;
  private ImageView xOf;
  private View xZQ;
  
  static
  {
    AppMethodBeat.i(230031);
    Gni = new FTSSearchNoActionBarView.a((byte)0);
    AppMethodBeat.o(230031);
  }
  
  public FTSSearchNoActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(230028);
    init();
    AppMethodBeat.o(230028);
  }
  
  public FTSSearchNoActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(230030);
    init();
    AppMethodBeat.o(230030);
  }
  
  private final void init()
  {
    AppMethodBeat.i(230026);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(230026);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(b.f.fts_searchview, (ViewGroup)this, true);
    this.xZQ = findViewById(b.e.cancel_btn);
    localObject = this.xZQ;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    this.xOf = ((ImageView)findViewById(b.e.search_icon));
    localObject = this.xOf;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = findViewById(b.e.fts_edittext);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.search.FTSEditTextView");
      AppMethodBeat.o(230026);
      throw ((Throwable)localObject);
    }
    this.Gng = ((FTSEditTextView)localObject);
    AppMethodBeat.o(230026);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.Gng;
  }
  
  public final void setSearchViewListener(b paramb)
  {
    this.Gnh = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "", "onClickBackBtn", "", "view", "Landroid/view/View;", "onClickCancelBtn", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void fhA();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FTSSearchNoActionBarView paramFTSSearchNoActionBarView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243386);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (FTSSearchNoActionBarView.a(this.Gnj) != null)
      {
        paramView = FTSSearchNoActionBarView.a(this.Gnj);
        if (paramView == null) {
          p.iCn();
        }
        paramView.fhA();
      }
      a.a(this, "com/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.FTSSearchNoActionBarView
 * JD-Core Version:    0.7.0.1
 */