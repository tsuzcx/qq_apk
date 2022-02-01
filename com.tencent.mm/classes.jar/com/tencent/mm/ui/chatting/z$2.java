package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.d;
import com.tencent.mm.bc.j;
import com.tencent.mm.plugin.eggspring.b.c;
import com.tencent.mm.plugin.eggspring.ui.SpringCardActivity;

final class z$2
  implements ChattingAnimFrame.d
{
  z$2(z paramz, Activity paramActivity) {}
  
  public final void a(c paramc, d paramd)
  {
    AppMethodBeat.i(160230);
    Intent localIntent;
    if ((paramc != null) && (paramc.pzi))
    {
      localIntent = new Intent(this.JDD, SpringCardActivity.class);
      localIntent.putExtra("SpringCard.KeyWord", paramc.iiW);
      localIntent.putExtra("SpringCard.AppId", paramc.appId);
      localIntent.putExtra("SpringCard.TraceId", paramc.jSR);
      if (paramd != null) {
        break label287;
      }
    }
    label287:
    for (paramc = null;; paramc = paramd.gkH)
    {
      if (paramc != null)
      {
        localIntent.putExtra("SpringCard.BtmMainTile", paramc.ijb);
        localIntent.putExtra("SpringCard.BtmMainTileColor", paramc.ijc);
        localIntent.putExtra("SpringCard.BtmSubTitle", paramc.ijd);
        localIntent.putExtra("SpringCard.BtmSubTitleColor", paramc.ije);
        localIntent.putExtra("SpringCard.BrandIcon", paramc.ijf);
        localIntent.putExtra("SpringCard.BrandName", paramc.doD);
        localIntent.putExtra("SpringCard.BrandBgColor", paramc.ijg);
        localIntent.putExtra("SpringCard.BrandBtmImg", paramc.ijh);
        localIntent.putExtra("SpringCard.BrandRedPocketCoverMainTitle", paramc.iji);
        localIntent.putExtra("SpringCard.BrandRedPocketCoverSubTitle", paramc.ijj);
        localIntent.putExtra("SpringCard.BrandCouponMainTitle", paramc.ijk);
        localIntent.putExtra("SpringCard.BrandCouponSubTitle", paramc.ijl);
      }
      paramc = this.JDD;
      paramd = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramc, paramd.ahp(), "com/tencent/mm/ui/chatting/EggMgr$2", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramc.startActivity((Intent)paramd.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/EggMgr$2", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.JDD.overridePendingTransition(2130772108, 2130772048);
      AppMethodBeat.o(160230);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z.2
 * JD-Core Version:    0.7.0.1
 */