package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.v;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/view/QuoteTipsPopupWindow;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hasMeasure", "", "likeClickListener", "Landroid/view/View$OnClickListener;", "getLikeClickListener", "()Landroid/view/View$OnClickListener;", "setLikeClickListener", "(Landroid/view/View$OnClickListener;)V", "menuLayout", "Landroid/view/View;", "popupPadding", "", "showDirection", "Lcom/tencent/mm/ui/chatting/view/QuoteTipsPopupWindow$ShowDirection;", "topMargin", "topThreashold", "vArrow", "setPopupPadding", "", "padding", "setPopupTopMargin", "setQuoteClickListener", "listener", "setTopThreashold", "showWith", "anchor", "Companion", "ShowDirection", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends v
{
  public static final d.a aeLA;
  public final View GDu;
  public final View GDw;
  public boolean GDx;
  public int GDy;
  public int aeLB;
  public d.b aeLC;
  public View.OnClickListener aeLD;
  public int bmv;
  public final Context context;
  
  static
  {
    AppMethodBeat.i(254299);
    aeLA = new d.a((byte)0);
    AppMethodBeat.o(254299);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(254292);
    this.context = paramContext;
    this.GDy = 5;
    this.aeLC = d.b.aeLF;
    setContentView(LayoutInflater.from(this.context).inflate(R.i.gno, null));
    setOutsideTouchable(true);
    setFocusable(true);
    paramContext = getContentView().findViewById(R.h.v_arrow);
    s.s(paramContext, "contentView.findViewById(R.id.v_arrow)");
    this.GDu = paramContext;
    paramContext = getContentView().findViewById(R.h.menu_content);
    s.s(paramContext, "contentView.findViewById(R.id.menu_content)");
    this.GDw = paramContext;
    getContentView().setOnClickListener(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(254292);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(254296);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/view/QuoteTipsPopupWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    localObject = paramd.aeLD;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    paramd.dismiss();
    a.a(new Object(), "com/tencent/mm/ui/chatting/view/QuoteTipsPopupWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(254296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.d
 * JD-Core Version:    0.7.0.1
 */