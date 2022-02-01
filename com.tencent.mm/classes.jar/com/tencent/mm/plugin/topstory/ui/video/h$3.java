package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

final class h$3
  implements q.g
{
  h$3(h paramh, f paramf, Context paramContext, esy paramesy, b paramb, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(126074);
    if (h.a(this.MZf))
    {
      this.MZf.MZd.gqC().fLJ();
      h.b(this.MZf);
    }
    this.MZf.MZd.gqJ();
    Object localObject2;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    if (paramMenuItem.getItemId() == 1)
    {
      this.MZg.cEI();
      paramMenuItem = p.NaI;
      localObject2 = this.val$context;
      Object localObject1 = this.MZh;
      localObject4 = this.MZi.gqA();
      if ((localObject1 != null) && (localObject4 != null))
      {
        paramMenuItem.NaJ = ((esy)localObject1);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("Ksnsupload_title", ((esy)localObject1).pqW);
        ((Intent)localObject3).putExtra("Ksnsupload_imgurl", ((esy)localObject1).PyV);
        ((Intent)localObject3).putExtra("Ksnsupload_link", ((esy)localObject1).vhY);
        if (!Util.isNullOrNil(((esy)localObject1).CHR)) {
          break label555;
        }
      }
      label555:
      for (paramMenuItem = ((Context)localObject2).getString(c.g.recommend_video_share_desc_default);; paramMenuItem = ((esy)localObject1).CHR)
      {
        ((Intent)localObject3).putExtra("KContentObjDesc", paramMenuItem);
        ((Intent)localObject3).putExtra("KlinkThumb_url", ((esy)localObject1).PyV);
        ((Intent)localObject3).putExtra("Ksnsupload_source", 1);
        ((Intent)localObject3).putExtra("Ksnsupload_type", 16);
        ((Intent)localObject3).putExtra("need_result", true);
        localObject5 = new flm();
        ((flm)localObject5).PyQ = ((esy)localObject1).Crh;
        ((flm)localObject5).PyR = ((esy)localObject1).UuX;
        ((flm)localObject5).PyS = ((esv)localObject4).jQi;
        ((flm)localObject5).PyT = ((esy)localObject1).UuW;
        ((flm)localObject5).PyU = 100201L;
        ((flm)localObject5).vhY = ((esy)localObject1).vhY;
        ((flm)localObject5).pqW = ((esy)localObject1).pqW;
        ((flm)localObject5).CHR = ((esy)localObject1).CHR;
        ((flm)localObject5).PyV = ((esy)localObject1).PyV;
        ((flm)localObject5).PyW = ((esy)localObject1).PyW;
        ((flm)localObject5).PyX = ((esy)localObject1).PyX;
        ((flm)localObject5).source = ((esy)localObject1).source;
        ((flm)localObject5).fVx = ((esy)localObject1).fVx;
        ((flm)localObject5).PyY = ((esy)localObject1).PyY;
        ((flm)localObject5).PyZ = ((esy)localObject1).PyZ;
        paramMenuItem = new LinkedList();
        paramMenuItem.addAll(((esv)localObject4).Pye);
        paramMenuItem.addAll(((esy)localObject1).Pye);
        ((flm)localObject5).Pza = p.iA(paramMenuItem).toString();
        ((flm)localObject5).Pzb = com.tencent.mm.plugin.topstory.a.h.iz(((esy)localObject1).Crg).toString();
        ((flm)localObject5).Pzc = ((esy)localObject1).Uve;
        ((flm)localObject5).thumbUrl = ((esy)localObject1).UuU;
        if ((p.l((esy)localObject1)) && (((esv)localObject4).UuJ != null)) {
          ((flm)localObject5).Pzd = ((esv)localObject4).UuJ.title;
        }
        paramMenuItem = null;
        try
        {
          localObject1 = ((flm)localObject5).toByteArray();
          paramMenuItem = (MenuItem)localObject1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", localIOException, "", new Object[0]);
          }
        }
        if (paramMenuItem != null) {
          ((Intent)localObject3).putExtra("KWebSearchInfo", paramMenuItem);
        }
        c.b((Context)localObject2, "sns", ".ui.SnsUploadUI", (Intent)localObject3, 1024);
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.MZi.gqA(), this.MZh, this.bFI, 7, "");
        AppMethodBeat.o(126074);
        return;
      }
    }
    Context localContext;
    if (paramMenuItem.getItemId() == 0)
    {
      this.MZg.cEI();
      paramMenuItem = p.NaI;
      localContext = this.val$context;
      localObject2 = this.MZh;
      localObject3 = this.MZi.gqA();
      paramMenuItem.NaJ = ((esy)localObject2);
      localObject4 = new k.b();
      ((k.b)localObject4).type = 5;
      ((k.b)localObject4).title = ((esy)localObject2).pqW;
      if (!Util.isNullOrNil(((esy)localObject2).CHR)) {
        break label1080;
      }
    }
    label1080:
    for (paramMenuItem = localContext.getString(c.g.recommend_video_share_desc_default);; paramMenuItem = ((esy)localObject2).CHR)
    {
      ((k.b)localObject4).description = paramMenuItem;
      ((k.b)localObject4).url = ((esy)localObject2).vhY;
      ((k.b)localObject4).thumburl = ((esy)localObject2).PyV;
      paramMenuItem = new aj();
      paramMenuItem.PyQ = ((esy)localObject2).Crh;
      paramMenuItem.PyR = ((esy)localObject2).UuX;
      paramMenuItem.PyS = ((esv)localObject3).jQi;
      paramMenuItem.PyT = ((esy)localObject2).UuW;
      paramMenuItem.PyU = 100201L;
      paramMenuItem.vhY = ((esy)localObject2).vhY;
      paramMenuItem.pqW = ((esy)localObject2).pqW;
      paramMenuItem.CHR = ((esy)localObject2).CHR;
      paramMenuItem.PyV = ((esy)localObject2).PyV;
      paramMenuItem.PyW = ((esy)localObject2).PyW;
      paramMenuItem.PyX = ((esy)localObject2).PyX;
      paramMenuItem.source = ((esy)localObject2).source;
      paramMenuItem.fVx = ((esy)localObject2).fVx;
      paramMenuItem.PyY = ((esy)localObject2).PyY;
      paramMenuItem.PyZ = ((esy)localObject2).PyZ;
      localObject5 = new LinkedList();
      ((List)localObject5).addAll(((esv)localObject3).Pye);
      ((List)localObject5).addAll(((esy)localObject2).Pye);
      paramMenuItem.Pza = p.iA((List)localObject5).toString();
      paramMenuItem.Pzb = com.tencent.mm.plugin.topstory.a.h.iz(((esy)localObject2).Crg).toString();
      paramMenuItem.Pzc = ((esy)localObject2).Uve;
      paramMenuItem.thumbUrl = ((esy)localObject2).UuU;
      if ((p.l((esy)localObject2)) && (((esv)localObject3).UuJ != null)) {
        paramMenuItem.Pzd = ((esv)localObject3).UuJ.title;
      }
      ((k.b)localObject4).a(paramMenuItem);
      paramMenuItem = k.b.a((k.b)localObject4, null, null);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
      ((Intent)localObject2).putExtra("Retr_Msg_content", paramMenuItem);
      ((Intent)localObject2).putExtra("Multi_Retr", true);
      ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
      c.d(localContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2, 2048);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.MZi.gqA(), this.MZh, this.bFI, 6, "");
      AppMethodBeat.o(126074);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.3
 * JD-Core Version:    0.7.0.1
 */