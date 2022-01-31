package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import org.json.JSONArray;

final class h$3
  implements n.d
{
  h$3(h paramh, f paramf, Context paramContext, byg parambyg, b paramb) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (h.a(this.pER))
    {
      this.pER.pEP.bNx().bMs();
      h.b(this.pER);
    }
    this.pER.pEP.bNF();
    if (paramMenuItem.getItemId() == 0)
    {
      this.pES.bNV();
      paramMenuItem = p.pGr;
      localContext = this.val$context;
      localObject2 = this.pET;
      localObject3 = this.pEU.bNv();
      if ((localObject2 != null) && (localObject3 != null))
      {
        paramMenuItem.pGs = ((byg)localObject2);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Ksnsupload_title", ((byg)localObject2).jxS);
        ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ((byg)localObject2).qUd);
        ((Intent)localObject1).putExtra("Ksnsupload_link", ((byg)localObject2).jxR);
        if (!bk.bl(((byg)localObject2).oBT)) {
          break label444;
        }
        paramMenuItem = localContext.getString(b.g.recommend_video_share_desc_default);
        ((Intent)localObject1).putExtra("KContentObjDesc", paramMenuItem);
        ((Intent)localObject1).putExtra("KlinkThumb_url", ((byg)localObject2).qUd);
        ((Intent)localObject1).putExtra("Ksnsupload_source", 1);
        ((Intent)localObject1).putExtra("Ksnsupload_type", 16);
        ((Intent)localObject1).putExtra("need_result", true);
        paramMenuItem = new ckw();
        paramMenuItem.qTY = ((byg)localObject2).tOx;
        paramMenuItem.qTZ = ((byg)localObject2).tOA;
        paramMenuItem.qUa = ((byf)localObject3).fTF;
        paramMenuItem.qUb = ((byg)localObject2).tOz;
        paramMenuItem.qUc = 100201L;
        paramMenuItem.jxR = ((byg)localObject2).jxR;
        paramMenuItem.jxS = ((byg)localObject2).jxS;
        paramMenuItem.oBT = ((byg)localObject2).oBT;
        paramMenuItem.qUd = ((byg)localObject2).qUd;
        paramMenuItem.qUe = ((byg)localObject2).qUe;
        paramMenuItem.qUf = ((byg)localObject2).qUf;
        paramMenuItem.aWf = ((byg)localObject2).aWf;
        paramMenuItem.mSy = ((byg)localObject2).mSy;
        paramMenuItem.qUg = ((byg)localObject2).qUg;
        paramMenuItem.qUh = ((byg)localObject2).qUh;
        paramMenuItem.qUi = p.cQ(((byf)localObject3).qTG).toString();
        paramMenuItem.qUj = g.cP(((byg)localObject2).sXo).toString();
        paramMenuItem.qUk = ((byg)localObject2).tOJ;
        paramMenuItem.thumbUrl = ((byg)localObject2).tOv;
      }
    }
    label444:
    while (paramMenuItem.getItemId() != 1) {
      try
      {
        paramMenuItem = paramMenuItem.toByteArray();
        if (paramMenuItem != null) {
          ((Intent)localObject1).putExtra("KWebSearchInfo", paramMenuItem);
        }
        d.b(localContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1, 1024);
        return;
        paramMenuItem = ((byg)localObject2).oBT;
      }
      catch (IOException paramMenuItem)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", paramMenuItem, "", new Object[0]);
          paramMenuItem = null;
        }
      }
    }
    this.pES.bNV();
    paramMenuItem = p.pGr;
    Context localContext = this.val$context;
    Object localObject1 = this.pET;
    Object localObject2 = this.pEU.bNv();
    paramMenuItem.pGs = ((byg)localObject1);
    Object localObject3 = new g.a();
    ((g.a)localObject3).type = 5;
    ((g.a)localObject3).title = ((byg)localObject1).jxS;
    if (bk.bl(((byg)localObject1).oBT)) {}
    for (paramMenuItem = localContext.getString(b.g.recommend_video_share_desc_default);; paramMenuItem = ((byg)localObject1).oBT)
    {
      ((g.a)localObject3).description = paramMenuItem;
      ((g.a)localObject3).url = ((byg)localObject1).jxR;
      ((g.a)localObject3).thumburl = ((byg)localObject1).qUd;
      paramMenuItem = new ab();
      paramMenuItem.qTY = ((byg)localObject1).tOx;
      paramMenuItem.qTZ = ((byg)localObject1).tOA;
      paramMenuItem.qUa = ((byf)localObject2).fTF;
      paramMenuItem.qUb = ((byg)localObject1).tOz;
      paramMenuItem.qUc = 100201L;
      paramMenuItem.jxR = ((byg)localObject1).jxR;
      paramMenuItem.jxS = ((byg)localObject1).jxS;
      paramMenuItem.oBT = ((byg)localObject1).oBT;
      paramMenuItem.qUd = ((byg)localObject1).qUd;
      paramMenuItem.qUe = ((byg)localObject1).qUe;
      paramMenuItem.qUf = ((byg)localObject1).qUf;
      paramMenuItem.aWf = ((byg)localObject1).aWf;
      paramMenuItem.mSy = ((byg)localObject1).mSy;
      paramMenuItem.qUg = ((byg)localObject1).qUg;
      paramMenuItem.qUh = ((byg)localObject1).qUh;
      paramMenuItem.qUi = p.cQ(((byf)localObject2).qTG).toString();
      paramMenuItem.qUj = g.cP(((byg)localObject1).sXo).toString();
      paramMenuItem.qUk = ((byg)localObject1).tOJ;
      paramMenuItem.thumbUrl = ((byg)localObject1).tOv;
      ((g.a)localObject3).a(paramMenuItem);
      paramMenuItem = g.a.a((g.a)localObject3, null, null);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
      ((Intent)localObject1).putExtra("Retr_Msg_content", paramMenuItem);
      ((Intent)localObject1).putExtra("Multi_Retr", true);
      ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
      d.c(localContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1, 2048);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.3
 * JD-Core Version:    0.7.0.1
 */