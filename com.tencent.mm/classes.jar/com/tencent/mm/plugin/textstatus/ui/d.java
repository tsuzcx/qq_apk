package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.ui.base.v;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hasMeasure", "", "menuLayout", "Landroid/view/View;", "popupPadding", "", "showDirection", "Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow$ShowDirection;", "topMargin", "vArrow", "setPopupPadding", "", "padding", "setPopupTopMargin", "showWith", "anchor", "Companion", "ShowDirection", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends v
{
  public static final d.a TvG;
  final View GDu;
  final View GDw;
  boolean GDx;
  int GDy;
  d.b TvH;
  int bmv;
  final Context context;
  
  static
  {
    AppMethodBeat.i(291355);
    TvG = new d.a((byte)0);
    AppMethodBeat.o(291355);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(291342);
    this.context = paramContext;
    this.GDy = 5;
    this.TvH = d.b.TvI;
    setContentView(LayoutInflater.from(this.context).inflate(a.f.TfR, null));
    setClippingEnabled(false);
    paramContext = getContentView().findViewById(a.e.v_arrow);
    s.s(paramContext, "contentView.findViewById(R.id.v_arrow)");
    this.GDu = paramContext;
    paramContext = getContentView().findViewById(a.e.menu_content);
    s.s(paramContext, "contentView.findViewById(R.id.menu_content)");
    this.GDw = paramContext;
    getContentView().setOnClickListener(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(291342);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(291347);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.dismiss();
    a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.d
 * JD-Core Version:    0.7.0.1
 */