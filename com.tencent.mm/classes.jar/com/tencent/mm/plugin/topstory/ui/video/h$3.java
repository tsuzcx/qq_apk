package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

final class h$3
  implements n.e
{
  h$3(h paramh, f paramf, Context paramContext, dpa paramdpa, b paramb, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(126074);
    if (h.a(this.BLN))
    {
      this.BLN.BLL.eti().edW();
      h.b(this.BLN);
    }
    this.BLN.BLL.etq();
    Context localContext;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    LinkedList localLinkedList;
    if (paramMenuItem.getItemId() == 1)
    {
      this.BLO.bTP();
      paramMenuItem = p.BNo;
      localContext = this.val$context;
      localObject2 = this.BLP;
      localObject3 = this.BLQ.etg();
      if ((localObject2 != null) && (localObject3 != null))
      {
        paramMenuItem.BNp = ((dpa)localObject2);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Ksnsupload_title", ((dpa)localObject2).qlw);
        ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ((dpa)localObject2).DTI);
        ((Intent)localObject1).putExtra("Ksnsupload_link", ((dpa)localObject2).qlv);
        if (!bu.isNullOrNil(((dpa)localObject2).uly)) {
          break label555;
        }
        paramMenuItem = localContext.getString(2131762231);
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("KContentObjDesc", paramMenuItem);
        ((Intent)localObject1).putExtra("KlinkThumb_url", ((dpa)localObject2).DTI);
        ((Intent)localObject1).putExtra("Ksnsupload_source", 1);
        ((Intent)localObject1).putExtra("Ksnsupload_type", 16);
        ((Intent)localObject1).putExtra("need_result", true);
        paramMenuItem = new egh();
        paramMenuItem.DTD = ((dpa)localObject2).udb;
        paramMenuItem.DTE = ((dpa)localObject2).HWj;
        paramMenuItem.DTF = ((dox)localObject3).kid;
        paramMenuItem.DTG = ((dpa)localObject2).HWi;
        paramMenuItem.DTH = 100201L;
        paramMenuItem.qlv = ((dpa)localObject2).qlv;
        paramMenuItem.qlw = ((dpa)localObject2).qlw;
        paramMenuItem.uly = ((dpa)localObject2).uly;
        paramMenuItem.DTI = ((dpa)localObject2).DTI;
        paramMenuItem.DTJ = ((dpa)localObject2).DTJ;
        paramMenuItem.DTK = ((dpa)localObject2).DTK;
        paramMenuItem.source = ((dpa)localObject2).source;
        paramMenuItem.dJL = ((dpa)localObject2).dJL;
        paramMenuItem.DTL = ((dpa)localObject2).DTL;
        paramMenuItem.DTM = ((dpa)localObject2).DTM;
        localLinkedList = new LinkedList();
        localLinkedList.addAll(((dox)localObject3).DTg);
        localLinkedList.addAll(((dpa)localObject2).DTg);
        paramMenuItem.DTN = p.gJ(localLinkedList).toString();
        paramMenuItem.DTO = com.tencent.mm.plugin.topstory.a.h.gI(((dpa)localObject2).uda).toString();
        paramMenuItem.DTP = ((dpa)localObject2).HWr;
        paramMenuItem.thumbUrl = ((dpa)localObject2).HWg;
        if ((p.k((dpa)localObject2)) && (((dox)localObject3).HVU != null)) {
          paramMenuItem.DTQ = ((dox)localObject3).HVU.title;
        }
        try
        {
          paramMenuItem = paramMenuItem.toByteArray();
          if (paramMenuItem != null) {
            ((Intent)localObject1).putExtra("KWebSearchInfo", paramMenuItem);
          }
          d.b(localContext, "sns", ".ui.SnsUploadUI", (Intent)localObject1, 1024);
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.BLQ.etg(), this.BLP, this.vb, 7, "");
          AppMethodBeat.o(126074);
          return;
          label555:
          paramMenuItem = ((dpa)localObject2).uly;
        }
        catch (IOException paramMenuItem)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", paramMenuItem, "", new Object[0]);
            paramMenuItem = null;
          }
        }
      }
    }
    if (paramMenuItem.getItemId() == 0)
    {
      this.BLO.bTP();
      paramMenuItem = p.BNo;
      localContext = this.val$context;
      localObject1 = this.BLP;
      localObject2 = this.BLQ.etg();
      paramMenuItem.BNp = ((dpa)localObject1);
      localObject3 = new k.b();
      ((k.b)localObject3).type = 5;
      ((k.b)localObject3).title = ((dpa)localObject1).qlw;
      if (!bu.isNullOrNil(((dpa)localObject1).uly)) {
        break label1082;
      }
    }
    label1082:
    for (paramMenuItem = localContext.getString(2131762231);; paramMenuItem = ((dpa)localObject1).uly)
    {
      ((k.b)localObject3).description = paramMenuItem;
      ((k.b)localObject3).url = ((dpa)localObject1).qlv;
      ((k.b)localObject3).thumburl = ((dpa)localObject1).DTI;
      paramMenuItem = new com.tencent.mm.plugin.websearch.api.ae();
      paramMenuItem.DTD = ((dpa)localObject1).udb;
      paramMenuItem.DTE = ((dpa)localObject1).HWj;
      paramMenuItem.DTF = ((dox)localObject2).kid;
      paramMenuItem.DTG = ((dpa)localObject1).HWi;
      paramMenuItem.DTH = 100201L;
      paramMenuItem.qlv = ((dpa)localObject1).qlv;
      paramMenuItem.qlw = ((dpa)localObject1).qlw;
      paramMenuItem.uly = ((dpa)localObject1).uly;
      paramMenuItem.DTI = ((dpa)localObject1).DTI;
      paramMenuItem.DTJ = ((dpa)localObject1).DTJ;
      paramMenuItem.DTK = ((dpa)localObject1).DTK;
      paramMenuItem.source = ((dpa)localObject1).source;
      paramMenuItem.dJL = ((dpa)localObject1).dJL;
      paramMenuItem.DTL = ((dpa)localObject1).DTL;
      paramMenuItem.DTM = ((dpa)localObject1).DTM;
      localLinkedList = new LinkedList();
      localLinkedList.addAll(((dox)localObject2).DTg);
      localLinkedList.addAll(((dpa)localObject1).DTg);
      paramMenuItem.DTN = p.gJ(localLinkedList).toString();
      paramMenuItem.DTO = com.tencent.mm.plugin.topstory.a.h.gI(((dpa)localObject1).uda).toString();
      paramMenuItem.DTP = ((dpa)localObject1).HWr;
      paramMenuItem.thumbUrl = ((dpa)localObject1).HWg;
      if ((p.k((dpa)localObject1)) && (((dox)localObject2).HVU != null)) {
        paramMenuItem.DTQ = ((dox)localObject2).HVU.title;
      }
      ((k.b)localObject3).a(paramMenuItem);
      paramMenuItem = k.b.a((k.b)localObject3, null, null);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
      ((Intent)localObject1).putExtra("Retr_Msg_content", paramMenuItem);
      ((Intent)localObject1).putExtra("Multi_Retr", true);
      ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
      d.c(localContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1, 2048);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.BLQ.etg(), this.BLP, this.vb, 6, "");
      AppMethodBeat.o(126074);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.3
 * JD-Core Version:    0.7.0.1
 */