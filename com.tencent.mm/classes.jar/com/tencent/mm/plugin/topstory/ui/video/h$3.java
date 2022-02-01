package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

final class h$3
  implements o.g
{
  h$3(h paramh, f paramf, Context paramContext, eiw parameiw, b paramb, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(126074);
    if (h.a(this.Gmt))
    {
      this.Gmt.Gmr.fyF().eYd();
      h.b(this.Gmt);
    }
    this.Gmt.Gmr.fyM();
    Context localContext;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    LinkedList localLinkedList;
    if (paramMenuItem.getItemId() == 1)
    {
      this.Gmu.crC();
      paramMenuItem = p.GnV;
      localContext = this.val$context;
      localObject2 = this.Gmv;
      localObject3 = this.Gmw.fyD();
      if ((localObject2 != null) && (localObject3 != null))
      {
        paramMenuItem.GnW = ((eiw)localObject2);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Ksnsupload_title", ((eiw)localObject2).msN);
        ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ((eiw)localObject2).IED);
        ((Intent)localObject1).putExtra("Ksnsupload_link", ((eiw)localObject2).rCq);
        if (!Util.isNullOrNil(((eiw)localObject2).xDQ)) {
          break label555;
        }
        paramMenuItem = localContext.getString(2131764255);
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("KContentObjDesc", paramMenuItem);
        ((Intent)localObject1).putExtra("KlinkThumb_url", ((eiw)localObject2).IED);
        ((Intent)localObject1).putExtra("Ksnsupload_source", 1);
        ((Intent)localObject1).putExtra("Ksnsupload_type", 16);
        ((Intent)localObject1).putExtra("need_result", true);
        paramMenuItem = new fat();
        paramMenuItem.IEy = ((eiw)localObject2).psI;
        paramMenuItem.IEz = ((eiw)localObject2).Nir;
        paramMenuItem.IEA = ((eit)localObject3).hes;
        paramMenuItem.IEB = ((eiw)localObject2).Niq;
        paramMenuItem.IEC = 100201L;
        paramMenuItem.rCq = ((eiw)localObject2).rCq;
        paramMenuItem.msN = ((eiw)localObject2).msN;
        paramMenuItem.xDQ = ((eiw)localObject2).xDQ;
        paramMenuItem.IED = ((eiw)localObject2).IED;
        paramMenuItem.IEE = ((eiw)localObject2).IEE;
        paramMenuItem.IEF = ((eiw)localObject2).IEF;
        paramMenuItem.source = ((eiw)localObject2).source;
        paramMenuItem.eby = ((eiw)localObject2).eby;
        paramMenuItem.IEG = ((eiw)localObject2).IEG;
        paramMenuItem.IEH = ((eiw)localObject2).IEH;
        localLinkedList = new LinkedList();
        localLinkedList.addAll(((eit)localObject3).IDO);
        localLinkedList.addAll(((eiw)localObject2).IDO);
        paramMenuItem.IEI = p.hL(localLinkedList).toString();
        paramMenuItem.IEJ = com.tencent.mm.plugin.topstory.a.h.hK(((eiw)localObject2).xuO).toString();
        paramMenuItem.IEK = ((eiw)localObject2).Niy;
        paramMenuItem.thumbUrl = ((eiw)localObject2).Nio;
        if ((p.l((eiw)localObject2)) && (((eit)localObject3).Nid != null)) {
          paramMenuItem.IEL = ((eit)localObject3).Nid.title;
        }
        try
        {
          paramMenuItem = paramMenuItem.toByteArray();
          if (paramMenuItem != null) {
            ((Intent)localObject1).putExtra("KWebSearchInfo", paramMenuItem);
          }
          c.b(localContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1, 1024);
          ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Gmw.fyD(), this.Gmv, this.vi, 7, "");
          AppMethodBeat.o(126074);
          return;
          label555:
          paramMenuItem = ((eiw)localObject2).xDQ;
        }
        catch (IOException paramMenuItem)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", paramMenuItem, "", new Object[0]);
            paramMenuItem = null;
          }
        }
      }
    }
    if (paramMenuItem.getItemId() == 0)
    {
      this.Gmu.crC();
      paramMenuItem = p.GnV;
      localContext = this.val$context;
      localObject1 = this.Gmv;
      localObject2 = this.Gmw.fyD();
      paramMenuItem.GnW = ((eiw)localObject1);
      localObject3 = new k.b();
      ((k.b)localObject3).type = 5;
      ((k.b)localObject3).title = ((eiw)localObject1).msN;
      if (!Util.isNullOrNil(((eiw)localObject1).xDQ)) {
        break label1082;
      }
    }
    label1082:
    for (paramMenuItem = localContext.getString(2131764255);; paramMenuItem = ((eiw)localObject1).xDQ)
    {
      ((k.b)localObject3).description = paramMenuItem;
      ((k.b)localObject3).url = ((eiw)localObject1).rCq;
      ((k.b)localObject3).thumburl = ((eiw)localObject1).IED;
      paramMenuItem = new aj();
      paramMenuItem.IEy = ((eiw)localObject1).psI;
      paramMenuItem.IEz = ((eiw)localObject1).Nir;
      paramMenuItem.IEA = ((eit)localObject2).hes;
      paramMenuItem.IEB = ((eiw)localObject1).Niq;
      paramMenuItem.IEC = 100201L;
      paramMenuItem.rCq = ((eiw)localObject1).rCq;
      paramMenuItem.msN = ((eiw)localObject1).msN;
      paramMenuItem.xDQ = ((eiw)localObject1).xDQ;
      paramMenuItem.IED = ((eiw)localObject1).IED;
      paramMenuItem.IEE = ((eiw)localObject1).IEE;
      paramMenuItem.IEF = ((eiw)localObject1).IEF;
      paramMenuItem.source = ((eiw)localObject1).source;
      paramMenuItem.eby = ((eiw)localObject1).eby;
      paramMenuItem.IEG = ((eiw)localObject1).IEG;
      paramMenuItem.IEH = ((eiw)localObject1).IEH;
      localLinkedList = new LinkedList();
      localLinkedList.addAll(((eit)localObject2).IDO);
      localLinkedList.addAll(((eiw)localObject1).IDO);
      paramMenuItem.IEI = p.hL(localLinkedList).toString();
      paramMenuItem.IEJ = com.tencent.mm.plugin.topstory.a.h.hK(((eiw)localObject1).xuO).toString();
      paramMenuItem.IEK = ((eiw)localObject1).Niy;
      paramMenuItem.thumbUrl = ((eiw)localObject1).Nio;
      if ((p.l((eiw)localObject1)) && (((eit)localObject2).Nid != null)) {
        paramMenuItem.IEL = ((eit)localObject2).Nid.title;
      }
      ((k.b)localObject3).a(paramMenuItem);
      paramMenuItem = k.b.a((k.b)localObject3, null, null);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
      ((Intent)localObject1).putExtra("Retr_Msg_content", paramMenuItem);
      ((Intent)localObject1).putExtra("Multi_Retr", true);
      ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
      c.c(localContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1, 2048);
      ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Gmw.fyD(), this.Gmv, this.vi, 6, "");
      AppMethodBeat.o(126074);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.3
 * JD-Core Version:    0.7.0.1
 */