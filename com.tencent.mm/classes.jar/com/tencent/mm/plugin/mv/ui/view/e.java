package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.ui.base.r;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "onClickListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;)V", "autoDismissTime", "", "hasMeasure", "", "menuLayout", "Landroid/view/View;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getOnClickListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;", "popupPadding", "", "tipsTv", "Landroid/widget/TextView;", "topMargin", "vArrow", "setAutoDismissTimeMs", "", "time", "setGone", "setMusicMv", "setPopupPadding", "padding", "setPopupTopMargin", "setTips", "tips", "Landroid/text/SpannableString;", "", "setVisible", "showWith", "anchor", "Companion", "OnClickListener", "plugin-mv_release"})
public final class e
  extends r
{
  public static final e.a Gqb;
  public final TextView AWF;
  public final View Bbf;
  private final View Bbg;
  public boolean Bbh;
  public int Bbj;
  public long Bbk;
  public f GgZ;
  final b Gqa;
  public int Gr;
  public final Context context;
  
  static
  {
    AppMethodBeat.i(227423);
    Gqb = new e.a((byte)0);
    AppMethodBeat.o(227423);
  }
  
  public e(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(227421);
    this.context = paramContext;
    this.Gqa = paramb;
    this.Bbj = 5;
    this.Bbk = 10000L;
    setContentView(LayoutInflater.from(this.context).inflate(b.f.FZM, null));
    setClippingEnabled(false);
    paramContext = getContentView().findViewById(b.e.tv_tips);
    p.j(paramContext, "contentView.findViewById(R.id.tv_tips)");
    this.AWF = ((TextView)paramContext);
    paramContext = getContentView().findViewById(b.e.v_arrow);
    p.j(paramContext, "contentView.findViewById(R.id.v_arrow)");
    this.Bbf = paramContext;
    paramContext = getContentView().findViewById(b.e.menu_content);
    p.j(paramContext, "contentView.findViewById(R.id.menu_content)");
    this.Bbg = paramContext;
    getContentView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(229928);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.Gqc.Gqa;
        if (paramAnonymousView != null) {
          paramAnonymousView.i(e.a(this.Gqc));
        }
        this.Gqc.dismiss();
        a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229928);
      }
    });
    AppMethodBeat.o(227421);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;", "", "onClick", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void i(f paramf);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(226368);
      if (this.Gqc.isShowing()) {
        this.Gqc.dismiss();
      }
      AppMethodBeat.o(226368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.e
 * JD-Core Version:    0.7.0.1
 */