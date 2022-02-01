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
import com.tencent.mm.ui.search.FTSEditTextView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "backBtn", "Landroid/view/View;", "<set-?>", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "ftsEditText", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "searchIcon", "Landroid/widget/ImageView;", "searchViewListener", "Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "hideSearchIcon", "", "init", "setSearchViewListener", "Companion", "FTSImageSearchListener", "FTSSearchViewListener", "IFTSTagModel", "plugin-mv_release"})
public final class FTSSearchNoActionBarView
  extends LinearLayout
{
  public static final a Awy;
  private FTSEditTextView Awv;
  private ImageView Aww;
  private b Awx;
  private View uvi;
  
  static
  {
    AppMethodBeat.i(257401);
    Awy = new a((byte)0);
    AppMethodBeat.o(257401);
  }
  
  public FTSSearchNoActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(257399);
    init();
    AppMethodBeat.o(257399);
  }
  
  public FTSSearchNoActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(257400);
    init();
    AppMethodBeat.o(257400);
  }
  
  private final void init()
  {
    AppMethodBeat.i(257398);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(257398);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(2131494775, (ViewGroup)this, true);
    this.uvi = findViewById(2131297963);
    localObject = this.uvi;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    this.Aww = ((ImageView)findViewById(2131307390));
    localObject = this.Aww;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = findViewById(2131301807);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.search.FTSEditTextView");
      AppMethodBeat.o(257398);
      throw ((Throwable)localObject);
    }
    this.Awv = ((FTSEditTextView)localObject);
    AppMethodBeat.o(257398);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.Awv;
  }
  
  public final void setSearchViewListener(b paramb)
  {
    this.Awx = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "", "onClickBackBtn", "", "view", "Landroid/view/View;", "onClickCancelBtn", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void ewk();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FTSSearchNoActionBarView paramFTSSearchNoActionBarView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257397);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (FTSSearchNoActionBarView.a(this.Awz) != null)
      {
        paramView = FTSSearchNoActionBarView.a(this.Awz);
        if (paramView == null) {
          p.hyc();
        }
        paramView.ewk();
      }
      a.a(this, "com/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.FTSSearchNoActionBarView
 * JD-Core Version:    0.7.0.1
 */