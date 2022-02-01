package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.i;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.base.v;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "onClickListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;)V", "autoDismissTime", "", "hasMeasure", "", "menuLayout", "Landroid/view/View;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getOnClickListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;", "popupPadding", "", "tipsTv", "Landroid/widget/TextView;", "topMargin", "vArrow", "setAutoDismissTimeMs", "", "time", "setGone", "setMusicMv", "setPopupPadding", "padding", "setPopupTopMargin", "setTips", "tips", "Landroid/text/SpannableString;", "", "setVisible", "showWith", "anchor", "Companion", "OnClickListener", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends v
{
  public static final d.a Mkb;
  public final TextView DMt;
  private final View GDu;
  private final View GDw;
  private boolean GDx;
  public int GDy;
  public long GDz;
  public f Mcj;
  private final b Mkc;
  public int bmv;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(286916);
    Mkb = new d.a((byte)0);
    AppMethodBeat.o(286916);
  }
  
  public d(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(286893);
    this.context = paramContext;
    this.Mkc = paramb;
    this.GDy = 5;
    this.GDz = 10000L;
    setContentView(LayoutInflater.from(this.context).inflate(b.f.LVJ, null));
    setClippingEnabled(false);
    paramContext = getContentView().findViewById(b.e.tv_tips);
    s.s(paramContext, "contentView.findViewById(R.id.tv_tips)");
    this.DMt = ((TextView)paramContext);
    paramContext = getContentView().findViewById(b.e.v_arrow);
    s.s(paramContext, "contentView.findViewById(R.id.v_arrow)");
    this.GDu = paramContext;
    paramContext = getContentView().findViewById(b.e.menu_content);
    s.s(paramContext, "contentView.findViewById(R.id.menu_content)");
    this.GDw = paramContext;
    getContentView().setOnClickListener(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(286893);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(286909);
    s.u(paramd, "this$0");
    if (paramd.isShowing()) {
      paramd.dismiss();
    }
    AppMethodBeat.o(286909);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(286904);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramView = paramd.Mkc;
    if (paramView != null) {
      paramView.j(paramd.Mcj);
    }
    paramd.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286904);
  }
  
  public final void dUX()
  {
    AppMethodBeat.i(286938);
    View localView = getContentView();
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(286938);
  }
  
  public final void gX(View paramView)
  {
    AppMethodBeat.i(286932);
    s.u(paramView, "anchor");
    if (!this.GDx)
    {
      getContentView().measure(0, 0);
      this.GDx = true;
    }
    int i = getContentView().getMeasuredWidth();
    int j = getContentView().getMeasuredHeight();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    Object localObject = ao.mX(this.context);
    int k = ((ao.a)localObject).width;
    int m = ((ao.a)localObject).height;
    int i1 = com.tencent.mm.cd.a.fromDPToPix(this.context, 16);
    int n = arrayOfInt[1] - j;
    i1 = k - i - i1;
    localObject = this.GDu.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(286932);
      throw paramView;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).setMarginStart(arrayOfInt[0] + paramView.getWidth() / 2 - i1 - this.GDu.getMeasuredWidth() / 2);
    if (((RelativeLayout.LayoutParams)localObject).getMarginStart() < 0)
    {
      s.X("invalid loc:", Integer.valueOf(((RelativeLayout.LayoutParams)localObject).getMarginStart()));
      dismiss();
      AppMethodBeat.o(286932);
      return;
    }
    setAnimationStyle(b.i.LWj);
    showAtLocation(paramView, 0, i1, n);
    paramView = getContentView();
    if (paramView != null) {
      paramView.postDelayed(new d..ExternalSyntheticLambda1(this), this.GDz);
    }
    paramView = am.aixg;
    s.s(String.format("popX:%s, popY:%s, sw:%s, sh:%s, pw:%s, ph:%s", Arrays.copyOf(new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) }, 6)), "java.lang.String.format(format, *args)");
    AppMethodBeat.o(286932);
  }
  
  public final void gsf()
  {
    AppMethodBeat.i(286946);
    View localView = getContentView();
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(286946);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;", "", "onClick", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void j(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.d
 * JD-Core Version:    0.7.0.1
 */