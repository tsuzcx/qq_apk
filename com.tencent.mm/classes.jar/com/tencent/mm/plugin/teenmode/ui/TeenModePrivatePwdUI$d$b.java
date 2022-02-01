package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.b.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.b.a.c;
import com.tencent.mm.plugin.teenmode.b.j;
import com.tencent.mm.protocal.protobuf.fwq;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tenpay.android.wechat.TempSecureEditText;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class TeenModePrivatePwdUI$d$b
  implements kotlinx.coroutines.b.h<a<fwq>>
{
  public TeenModePrivatePwdUI$d$b(TeenModePrivatePwdUI paramTeenModePrivatePwdUI) {}
  
  public final Object a(a<fwq> parama, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(279129);
    parama = (a)parama;
    if (parama.ovD == b.ovB)
    {
      if ((parama.errCode != 0) || (TeenModePrivatePwdUI.b(this.Tbm) != 5)) {
        break label56;
      }
      TeenModePrivatePwdUI.h(this.Tbm);
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(279129);
      return parama;
      label56:
      paramd = TeenModePrivatePwdUI.i(this.Tbm);
      if (paramd != null) {
        paramd.dismiss();
      }
      if (parama.errCode == 0)
      {
        j localj = j.hEy();
        parama = (fwq)parama.ott;
        if (parama == null)
        {
          parama = null;
          label98:
          paramd = parama;
          if (parama == null) {
            paramd = j.hEy().hFb;
          }
          localj.hFb = paramd;
          j.hEy().qfP = 2;
          this.Tbm.setResult(-1);
          TeenModePrivatePwdUI.j(this.Tbm);
          if (this.Tbm.getIntent().getIntExtra("intent_extra_biz_type", 0) == 0) {
            continue;
          }
          paramd = new com.tencent.mm.plugin.teenmode.a.e();
          paramd.field_businessType = this.Tbm.getIntent().getIntExtra("intent_extra_biz_type", 2147483647);
          paramd.field_businessKey = this.Tbm.getIntent().getStringExtra("intent_extra_biz_key");
          parama = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu();
          if (parama != null) {
            break label275;
          }
        }
        label275:
        for (parama = null;; parama = parama.field_username)
        {
          paramd.field_guardianUserName = parama;
          paramd.field_wardUserName = z.bAM();
          paramd.field_time = cn.bDv();
          parama = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
          com.tencent.mm.plugin.teenmode.b.a.e.hEB().replace((IAutoDBItem)paramd);
          ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEs();
          break;
          parama = parama.Njp;
          break label98;
        }
      }
      else
      {
        paramd = (fwq)parama.ott;
        if ((paramd != null) && (paramd.abUo == true)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label402;
          }
          paramd = new g.a((Context)this.Tbm.getContext());
          paramd.bDE(parama.errMsg);
          paramd.bDJ(this.Tbm.getString(a.g.forget_password)).aEX(a.g.app_i_know);
          paramd.c((g.c)new TeenModePrivatePwdUI.d.a(this.Tbm)).show();
          TeenModePrivatePwdUI.k(this.Tbm).setText((CharSequence)"");
          break;
        }
        label402:
        TeenModePrivatePwdUI.b(this.Tbm, parama.errMsg);
        TeenModePrivatePwdUI.k(this.Tbm).setText((CharSequence)"");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModePrivatePwdUI.d.b
 * JD-Core Version:    0.7.0.1
 */