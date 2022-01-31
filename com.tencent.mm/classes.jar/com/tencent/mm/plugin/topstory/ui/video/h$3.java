package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import org.json.JSONArray;

final class h$3
  implements n.d
{
  h$3(h paramh, f paramf, Context paramContext, ckx paramckx, b paramb, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(1715);
    if (h.a(this.tio))
    {
      this.tio.tim.cJh().ctY();
      h.b(this.tio);
    }
    this.tio.tim.cJo();
    Context localContext;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (paramMenuItem.getItemId() == 0)
    {
      this.tip.cJI();
      paramMenuItem = p.tjM;
      localContext = this.val$context;
      localObject2 = this.tiq;
      localObject3 = this.tir.cJf();
      if ((localObject2 != null) && (localObject3 != null))
      {
        paramMenuItem.tjN = ((ckx)localObject2);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Ksnsupload_title", ((ckx)localObject2).lHr);
        ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ((ckx)localObject2).uJn);
        ((Intent)localObject1).putExtra("Ksnsupload_link", ((ckx)localObject2).lHq);
        if (!bo.isNullOrNil(((ckx)localObject2).rrm)) {
          break label524;
        }
        paramMenuItem = localContext.getString(2131302348);
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("KContentObjDesc", paramMenuItem);
        ((Intent)localObject1).putExtra("KlinkThumb_url", ((ckx)localObject2).uJn);
        ((Intent)localObject1).putExtra("Ksnsupload_source", 1);
        ((Intent)localObject1).putExtra("Ksnsupload_type", 16);
        ((Intent)localObject1).putExtra("need_result", true);
        paramMenuItem = new cyl();
        paramMenuItem.uJi = ((ckx)localObject2).xVa;
        paramMenuItem.uJj = ((ckx)localObject2).xVd;
        paramMenuItem.uJk = ((ckw)localObject3).hng;
        paramMenuItem.uJl = ((ckx)localObject2).xVc;
        paramMenuItem.uJm = 100201L;
        paramMenuItem.lHq = ((ckx)localObject2).lHq;
        paramMenuItem.lHr = ((ckx)localObject2).lHr;
        paramMenuItem.rrm = ((ckx)localObject2).rrm;
        paramMenuItem.uJn = ((ckx)localObject2).uJn;
        paramMenuItem.uJo = ((ckx)localObject2).uJo;
        paramMenuItem.uJp = ((ckx)localObject2).uJp;
        paramMenuItem.source = ((ckx)localObject2).source;
        paramMenuItem.puE = ((ckx)localObject2).puE;
        paramMenuItem.uJq = ((ckx)localObject2).uJq;
        paramMenuItem.uJr = ((ckx)localObject2).uJr;
        paramMenuItem.uJs = p.dS(((ckw)localObject3).uIO).toString();
        paramMenuItem.uJt = com.tencent.mm.plugin.topstory.a.g.dR(((ckx)localObject2).wVo).toString();
        paramMenuItem.uJu = ((ckx)localObject2).xVm;
        paramMenuItem.thumbUrl = ((ckx)localObject2).xUY;
        if ((p.h((ckx)localObject2)) && (((ckw)localObject3).xUQ != null)) {
          paramMenuItem.uJv = ((ckw)localObject3).xUQ.title;
        }
        try
        {
          paramMenuItem = paramMenuItem.toByteArray();
          if (paramMenuItem != null) {
            ((Intent)localObject1).putExtra("KWebSearchInfo", paramMenuItem);
          }
          d.b(localContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1, 1024);
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tir.cJf(), this.tiq, this.lU, 7, "");
          AppMethodBeat.o(1715);
          return;
          label524:
          paramMenuItem = ((ckx)localObject2).rrm;
        }
        catch (IOException paramMenuItem)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", paramMenuItem, "", new Object[0]);
            paramMenuItem = null;
          }
        }
      }
    }
    if (paramMenuItem.getItemId() == 1)
    {
      this.tip.cJI();
      paramMenuItem = p.tjM;
      localContext = this.val$context;
      localObject1 = this.tiq;
      localObject2 = this.tir.cJf();
      paramMenuItem.tjN = ((ckx)localObject1);
      localObject3 = new j.b();
      ((j.b)localObject3).type = 5;
      ((j.b)localObject3).title = ((ckx)localObject1).lHr;
      if (!bo.isNullOrNil(((ckx)localObject1).rrm)) {
        break label1021;
      }
    }
    label1021:
    for (paramMenuItem = localContext.getString(2131302348);; paramMenuItem = ((ckx)localObject1).rrm)
    {
      ((j.b)localObject3).description = paramMenuItem;
      ((j.b)localObject3).url = ((ckx)localObject1).lHq;
      ((j.b)localObject3).thumburl = ((ckx)localObject1).uJn;
      paramMenuItem = new com.tencent.mm.plugin.websearch.api.ab();
      paramMenuItem.uJi = ((ckx)localObject1).xVa;
      paramMenuItem.uJj = ((ckx)localObject1).xVd;
      paramMenuItem.uJk = ((ckw)localObject2).hng;
      paramMenuItem.uJl = ((ckx)localObject1).xVc;
      paramMenuItem.uJm = 100201L;
      paramMenuItem.lHq = ((ckx)localObject1).lHq;
      paramMenuItem.lHr = ((ckx)localObject1).lHr;
      paramMenuItem.rrm = ((ckx)localObject1).rrm;
      paramMenuItem.uJn = ((ckx)localObject1).uJn;
      paramMenuItem.uJo = ((ckx)localObject1).uJo;
      paramMenuItem.uJp = ((ckx)localObject1).uJp;
      paramMenuItem.source = ((ckx)localObject1).source;
      paramMenuItem.puE = ((ckx)localObject1).puE;
      paramMenuItem.uJq = ((ckx)localObject1).uJq;
      paramMenuItem.uJr = ((ckx)localObject1).uJr;
      paramMenuItem.uJs = p.dS(((ckw)localObject2).uIO).toString();
      paramMenuItem.uJt = com.tencent.mm.plugin.topstory.a.g.dR(((ckx)localObject1).wVo).toString();
      paramMenuItem.uJu = ((ckx)localObject1).xVm;
      paramMenuItem.thumbUrl = ((ckx)localObject1).xUY;
      if ((p.h((ckx)localObject1)) && (((ckw)localObject2).xUQ != null)) {
        paramMenuItem.uJv = ((ckw)localObject2).xUQ.title;
      }
      ((j.b)localObject3).a(paramMenuItem);
      paramMenuItem = j.b.a((j.b)localObject3, null, null);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
      ((Intent)localObject1).putExtra("Retr_Msg_content", paramMenuItem);
      ((Intent)localObject1).putExtra("Multi_Retr", true);
      ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
      d.b(localContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1, 2048);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tir.cJf(), this.tiq, this.lU, 6, "");
      AppMethodBeat.o(1715);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.3
 * JD-Core Version:    0.7.0.1
 */