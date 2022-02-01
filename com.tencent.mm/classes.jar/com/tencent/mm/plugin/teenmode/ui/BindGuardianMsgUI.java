package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/BindGuardianMsgUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "()V", "bindBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getBindBtn", "()Landroid/widget/Button;", "bindBtn$delegate", "Lkotlin/Lazy;", "bindGuardianUserName", "", "getBindGuardianUserName", "()Ljava/lang/String;", "bindGuardianUserName$delegate", "bindWardUserName", "getBindWardUserName", "bindWardUserName$delegate", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "descTV$delegate", "iKnowBtn", "getIKnowBtn", "iKnowBtn$delegate", "reqTime", "", "getReqTime", "()J", "reqTime$delegate", "stateIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStateIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "stateIcon$delegate", "ticket", "getTicket", "ticket$delegate", "titleTV", "getTitleTV", "titleTV$delegate", "accept", "", "getLayoutId", "", "getState", "Lcom/tencent/mm/plugin/teenmode/ui/BindGuardianMsgUI$Companion$STATE;", "hideErrorTip", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataChanged", "onDestroy", "sameDay", "", "t", "showErrorTip", "errMsg", "updateView", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BindGuardianMsgUI
  extends MMActivity
  implements g
{
  public static final BindGuardianMsgUI.a SZQ;
  private final j SZA;
  private final j SZC;
  private final j SZR;
  private final j SZS;
  private final j SZT;
  private final j SZU;
  private final j SZV;
  private final j SZW;
  private final j SZX;
  
  static
  {
    AppMethodBeat.i(279230);
    SZQ = new BindGuardianMsgUI.a((byte)0);
    AppMethodBeat.o(279230);
  }
  
  public BindGuardianMsgUI()
  {
    AppMethodBeat.i(279126);
    this.SZA = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.SZR = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.SZS = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.SZT = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.SZC = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.SZU = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.SZV = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.SZW = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.SZX = kotlin.k.cm((kotlin.g.a.a)new i(this));
    AppMethodBeat.o(279126);
  }
  
  private static final ah a(w paramw, BindGuardianMsgUI paramBindGuardianMsgUI, b.a parama)
  {
    AppMethodBeat.i(279224);
    s.u(paramBindGuardianMsgUI, "this$0");
    paramw.dismiss();
    if ((parama.errCode != 0) || (parama.errType != 0))
    {
      parama = parama.errMsg;
      TextView localTextView = (TextView)paramBindGuardianMsgUI.findViewById(a.d.error_tip);
      localTextView.setVisibility(0);
      paramw = parama;
      if (parama == null)
      {
        paramw = paramBindGuardianMsgUI.getString(a.g.app_err_server_busy_tip);
        s.s(paramw, "getString(R.string.app_err_server_busy_tip)");
      }
      localTextView.setText((CharSequence)paramw);
    }
    paramw = ah.aiuX;
    AppMethodBeat.o(279224);
    return paramw;
  }
  
  private static final void a(BindGuardianMsgUI paramBindGuardianMsgUI, View paramView)
  {
    AppMethodBeat.i(279207);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramBindGuardianMsgUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/BindGuardianMsgUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramBindGuardianMsgUI, "this$0");
    paramView = com.tencent.mm.ui.base.k.a((Context)paramBindGuardianMsgUI, paramBindGuardianMsgUI.getContext().getString(a.g.app_sending), false, null);
    ((TextView)paramBindGuardianMsgUI.findViewById(a.d.error_tip)).setVisibility(8);
    localObject1 = paramBindGuardianMsgUI.hEU();
    s.checkNotNull(localObject1);
    s.s(localObject1, "bindWardUserName!!");
    localObject2 = paramBindGuardianMsgUI.bIQ();
    s.checkNotNull(localObject2);
    s.s(localObject2, "ticket!!");
    new com.tencent.mm.plugin.teenmode.b.e((String)localObject1, (String)localObject2).bFJ().a((com.tencent.mm.vending.e.b)paramBindGuardianMsgUI).b(new BindGuardianMsgUI..ExternalSyntheticLambda3(paramView, paramBindGuardianMsgUI));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/BindGuardianMsgUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279207);
  }
  
  private static final boolean a(BindGuardianMsgUI paramBindGuardianMsgUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279195);
    s.u(paramBindGuardianMsgUI, "this$0");
    paramBindGuardianMsgUI.finish();
    AppMethodBeat.o(279195);
    return true;
  }
  
  private static final void b(BindGuardianMsgUI paramBindGuardianMsgUI, View paramView)
  {
    AppMethodBeat.i(279215);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBindGuardianMsgUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/BindGuardianMsgUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBindGuardianMsgUI, "this$0");
    paramBindGuardianMsgUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/BindGuardianMsgUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279215);
  }
  
  private final String bIQ()
  {
    AppMethodBeat.i(279171);
    String str = (String)this.SZW.getValue();
    AppMethodBeat.o(279171);
    return str;
  }
  
  private final TextView getTitleTV()
  {
    AppMethodBeat.i(279136);
    TextView localTextView = (TextView)this.SZR.getValue();
    AppMethodBeat.o(279136);
    return localTextView;
  }
  
  private final WeImageView hEH()
  {
    AppMethodBeat.i(279130);
    WeImageView localWeImageView = (WeImageView)this.SZA.getValue();
    AppMethodBeat.o(279130);
    return localWeImageView;
  }
  
  private final Button hEJ()
  {
    AppMethodBeat.i(279153);
    Button localButton = (Button)this.SZC.getValue();
    AppMethodBeat.o(279153);
    return localButton;
  }
  
  private final TextView hER()
  {
    AppMethodBeat.i(279140);
    TextView localTextView = (TextView)this.SZS.getValue();
    AppMethodBeat.o(279140);
    return localTextView;
  }
  
  private final Button hES()
  {
    AppMethodBeat.i(279149);
    Button localButton = (Button)this.SZT.getValue();
    AppMethodBeat.o(279149);
    return localButton;
  }
  
  private final String hET()
  {
    AppMethodBeat.i(279157);
    String str = (String)this.SZU.getValue();
    AppMethodBeat.o(279157);
    return str;
  }
  
  private final String hEU()
  {
    AppMethodBeat.i(279163);
    String str = (String)this.SZV.getValue();
    AppMethodBeat.o(279163);
    return str;
  }
  
  private final long hEV()
  {
    AppMethodBeat.i(279176);
    long l = ((Number)this.SZX.getValue()).longValue();
    AppMethodBeat.o(279176);
    return l;
  }
  
  private a.a hEW()
  {
    AppMethodBeat.i(279185);
    Object localObject = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
    localObject = com.tencent.mm.plugin.teenmode.b.a.e.hEC();
    String str = bIQ();
    s.checkNotNull(str);
    s.s(str, "ticket!!");
    localObject = ((com.tencent.mm.plugin.teenmode.b.a.d)localObject).bdl(str);
    if (z.bAM().equals(hEU()))
    {
      if (((com.tencent.mm.plugin.teenmode.a.f)localObject).field_time > 0L)
      {
        str = hET();
        localObject = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu();
        if (localObject == null) {}
        for (localObject = null; n.T(str, (String)localObject, false); localObject = ((az)localObject).field_username)
        {
          localObject = a.a.SZZ;
          AppMethodBeat.o(279185);
          return localObject;
        }
        localObject = a.a.Tad;
        AppMethodBeat.o(279185);
        return localObject;
      }
      if (wj(hEV()))
      {
        localObject = a.a.SZY;
        AppMethodBeat.o(279185);
        return localObject;
      }
      localObject = a.a.Tac;
      AppMethodBeat.o(279185);
      return localObject;
    }
    if (((com.tencent.mm.plugin.teenmode.a.f)localObject).field_time > 0L)
    {
      if (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).bdk(hEU()))
      {
        localObject = a.a.Tab;
        AppMethodBeat.o(279185);
        return localObject;
      }
      localObject = a.a.Tae;
      AppMethodBeat.o(279185);
      return localObject;
    }
    if (wj(hEV()))
    {
      localObject = a.a.Taa;
      AppMethodBeat.o(279185);
      return localObject;
    }
    localObject = a.a.Tac;
    AppMethodBeat.o(279185);
    return localObject;
  }
  
  private static boolean wj(long paramLong)
  {
    AppMethodBeat.i(279191);
    if (paramLong / 86400000L == cn.bDv() / 86400000L)
    {
      AppMethodBeat.o(279191);
      return true;
    }
    AppMethodBeat.o(279191);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.e.SWw;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279274);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    initView();
    setBackBtn(new BindGuardianMsgUI..ExternalSyntheticLambda0(this));
    hES().setOnClickListener(new BindGuardianMsgUI..ExternalSyntheticLambda1(this));
    hEJ().setOnClickListener(new BindGuardianMsgUI..ExternalSyntheticLambda2(this));
    updateView();
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a((g)this);
    AppMethodBeat.o(279274);
  }
  
  public final void onDataChanged()
  {
    AppMethodBeat.i(279299);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this));
    AppMethodBeat.o(279299);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279280);
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).b((g)this);
    super.onDestroy();
    AppMethodBeat.o(279280);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(279294);
    Object localObject = hEW();
    switch (b.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(279294);
      return;
      hEH().oR(a.f.icons_filled_time, a.a.Blue);
      getTitleTV().setText(a.g.SXp);
      hER().setVisibility(8);
      hES().setVisibility(8);
      hEJ().setVisibility(0);
      AppMethodBeat.o(279294);
      return;
      hEH().oR(a.f.icons_filled_done2, a.a.wechat_green);
      getTitleTV().setText(a.g.SXh);
      hER().setVisibility(8);
      hES().setVisibility(8);
      hEJ().setVisibility(0);
      AppMethodBeat.o(279294);
      return;
      hEH().oR(a.f.icons_outlined_umbrella, a.a.wechat_green);
      getTitleTV().setText(a.g.SXi);
      localObject = hER();
      ((TextView)localObject).setVisibility(0);
      au localau = ab.Jg(hEU());
      ((TextView)localObject).setText((CharSequence)getString(a.g.SXd, new Object[] { localau.aSV() }));
      hES().setVisibility(0);
      hEJ().setVisibility(8);
      AppMethodBeat.o(279294);
      return;
      hEH().oR(a.f.icons_filled_done2, a.a.wechat_green);
      getTitleTV().setText(a.g.SXg);
      hER().setVisibility(8);
      hES().setVisibility(8);
      hEJ().setVisibility(0);
      AppMethodBeat.o(279294);
      return;
      hEH().oR(a.f.icons_filled_error, a.a.Yellow);
      getTitleTV().setText(a.g.SXo);
      hER().setVisibility(8);
      hES().setVisibility(8);
      hEJ().setVisibility(0);
      AppMethodBeat.o(279294);
      return;
      hEH().oR(a.f.icons_filled_error, a.a.Yellow);
      getTitleTV().setText(a.g.SXn);
      hER().setVisibility(8);
      hES().setVisibility(8);
      hEJ().setVisibility(0);
      AppMethodBeat.o(279294);
      return;
      hEH().oR(a.f.icons_filled_error, a.a.Yellow);
      getTitleTV().setText(a.g.SXf);
      localObject = hER();
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(a.g.SXf);
      hES().setVisibility(8);
      hEJ().setVisibility(0);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/BindGuardianMsgUI$Companion$STATE;", "", "(Ljava/lang/String;I)V", "WARD_UNBIND", "WARD_BINDED", "GUARDIAN_UNBIND", "GUARDIAN_BINDED", "EXPIRED", "WARD_REMOVE", "GUARDIAN_REMOVE", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a$a
  {
    static
    {
      AppMethodBeat.i(279015);
      SZY = new a("WARD_UNBIND", 0);
      SZZ = new a("WARD_BINDED", 1);
      Taa = new a("GUARDIAN_UNBIND", 2);
      Tab = new a("GUARDIAN_BINDED", 3);
      Tac = new a("EXPIRED", 4);
      Tad = new a("WARD_REMOVE", 5);
      Tae = new a("GUARDIAN_REMOVE", 6);
      Taf = new a[] { SZY, SZZ, Taa, Tab, Tac, Tad, Tae };
      AppMethodBeat.o(279015);
    }
    
    private a$a() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Button>
  {
    c(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<String>
  {
    d(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<String>
  {
    e(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<Button>
  {
    g(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<Long>
  {
    i(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    j(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<String>
  {
    k(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<TextView>
  {
    l(BindGuardianMsgUI paramBindGuardianMsgUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.BindGuardianMsgUI
 * JD-Core Version:    0.7.0.1
 */