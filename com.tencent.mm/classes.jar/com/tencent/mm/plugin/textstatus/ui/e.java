package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.ui.base.r;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hasMeasure", "", "menuLayout", "Landroid/view/View;", "popupPadding", "", "showDirection", "Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow$ShowDirection;", "topMargin", "vArrow", "setPopupPadding", "", "padding", "setPopupTopMargin", "showWith", "anchor", "Companion", "ShowDirection", "plugin-textstatus_release"})
public final class e
  extends r
{
  public static final a MJz;
  final View Bbf;
  final View Bbg;
  boolean Bbh;
  int Bbj;
  int Gr;
  e.b MJy;
  final Context context;
  
  static
  {
    AppMethodBeat.i(237033);
    MJz = new a((byte)0);
    AppMethodBeat.o(237033);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(237032);
    this.context = paramContext;
    this.Bbj = 5;
    this.MJy = e.b.MJB;
    setContentView(LayoutInflater.from(this.context).inflate(b.f.Myn, null));
    setClippingEnabled(false);
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
        AppMethodBeat.i(236664);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.MJA.dismiss();
        a.a(this, "com/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(236664);
      }
    });
    AppMethodBeat.o(237032);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow$Companion;", "", "()V", "POPUP_PADDING", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.e
 * JD-Core Version:    0.7.0.1
 */