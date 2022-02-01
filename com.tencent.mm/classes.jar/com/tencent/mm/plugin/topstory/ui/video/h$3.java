package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

final class h$3
  implements u.i
{
  h$3(h paramh, f paramf, Context paramContext, foh paramfoh, b paramb, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(126074);
    if (h.a(this.TLO))
    {
      this.TLO.TLM.hNB().bcl();
      h.b(this.TLO);
    }
    this.TLO.TLM.hNI();
    Object localObject2;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    if (paramMenuItem.getItemId() == 1)
    {
      this.TLP.hOb();
      paramMenuItem = p.TNr;
      localObject2 = this.val$context;
      Object localObject1 = this.TLQ;
      localObject4 = this.TLR.hNz();
      if ((localObject1 != null) && (localObject4 != null))
      {
        paramMenuItem.TNs = ((foh)localObject1);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("Ksnsupload_title", ((foh)localObject1).svG);
        ((Intent)localObject3).putExtra("Ksnsupload_imgurl", ((foh)localObject1).Wpe);
        ((Intent)localObject3).putExtra("Ksnsupload_link", ((foh)localObject1).ytZ);
        if (!Util.isNullOrNil(((foh)localObject1).ICb)) {
          break label555;
        }
      }
      label555:
      for (paramMenuItem = ((Context)localObject2).getString(c.g.recommend_video_share_desc_default);; paramMenuItem = ((foh)localObject1).ICb)
      {
        ((Intent)localObject3).putExtra("KContentObjDesc", paramMenuItem);
        ((Intent)localObject3).putExtra("KlinkThumb_url", ((foh)localObject1).Wpe);
        ((Intent)localObject3).putExtra("Ksnsupload_source", 1);
        ((Intent)localObject3).putExtra("Ksnsupload_type", 16);
        ((Intent)localObject3).putExtra("need_result", true);
        localObject5 = new gib();
        ((gib)localObject5).WoZ = ((foh)localObject1).Ido;
        ((gib)localObject5).Wpa = ((foh)localObject1).abOy;
        ((gib)localObject5).Wpb = ((foe)localObject4).mpa;
        ((gib)localObject5).Wpc = ((foh)localObject1).abOx;
        ((gib)localObject5).Wpd = 100201L;
        ((gib)localObject5).ytZ = ((foh)localObject1).ytZ;
        ((gib)localObject5).svG = ((foh)localObject1).svG;
        ((gib)localObject5).ICb = ((foh)localObject1).ICb;
        ((gib)localObject5).Wpe = ((foh)localObject1).Wpe;
        ((gib)localObject5).Wpf = ((foh)localObject1).Wpf;
        ((gib)localObject5).Wpg = ((foh)localObject1).Wpg;
        ((gib)localObject5).source = ((foh)localObject1).source;
        ((gib)localObject5).ibx = ((foh)localObject1).ibx;
        ((gib)localObject5).Wph = ((foh)localObject1).Wph;
        ((gib)localObject5).Wpi = ((foh)localObject1).Wpi;
        paramMenuItem = new LinkedList();
        paramMenuItem.addAll(((foe)localObject4).Wol);
        paramMenuItem.addAll(((foh)localObject1).Wol);
        ((gib)localObject5).Wpj = p.lF(paramMenuItem).toString();
        ((gib)localObject5).Wpk = g.lE(((foh)localObject1).Idn).toString();
        ((gib)localObject5).Wpl = ((foh)localObject1).abOF;
        ((gib)localObject5).thumbUrl = ((foh)localObject1).oeS;
        if ((p.l((foh)localObject1)) && (((foe)localObject4).abOl != null)) {
          ((gib)localObject5).Wpm = ((foe)localObject4).abOl.title;
        }
        paramMenuItem = null;
        try
        {
          localObject1 = ((gib)localObject5).toByteArray();
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
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.TLR.hNz(), this.TLQ, this.dyI, 7, "");
        AppMethodBeat.o(126074);
        return;
      }
    }
    Context localContext;
    if (paramMenuItem.getItemId() == 0)
    {
      this.TLP.hOb();
      paramMenuItem = p.TNr;
      localContext = this.val$context;
      localObject2 = this.TLQ;
      localObject3 = this.TLR.hNz();
      paramMenuItem.TNs = ((foh)localObject2);
      localObject4 = new k.b();
      ((k.b)localObject4).type = 5;
      ((k.b)localObject4).title = ((foh)localObject2).svG;
      if (!Util.isNullOrNil(((foh)localObject2).ICb)) {
        break label1080;
      }
    }
    label1080:
    for (paramMenuItem = localContext.getString(c.g.recommend_video_share_desc_default);; paramMenuItem = ((foh)localObject2).ICb)
    {
      ((k.b)localObject4).description = paramMenuItem;
      ((k.b)localObject4).url = ((foh)localObject2).ytZ;
      ((k.b)localObject4).thumburl = ((foh)localObject2).Wpe;
      paramMenuItem = new ak();
      paramMenuItem.WoZ = ((foh)localObject2).Ido;
      paramMenuItem.Wpa = ((foh)localObject2).abOy;
      paramMenuItem.Wpb = ((foe)localObject3).mpa;
      paramMenuItem.Wpc = ((foh)localObject2).abOx;
      paramMenuItem.Wpd = 100201L;
      paramMenuItem.ytZ = ((foh)localObject2).ytZ;
      paramMenuItem.svG = ((foh)localObject2).svG;
      paramMenuItem.ICb = ((foh)localObject2).ICb;
      paramMenuItem.Wpe = ((foh)localObject2).Wpe;
      paramMenuItem.Wpf = ((foh)localObject2).Wpf;
      paramMenuItem.Wpg = ((foh)localObject2).Wpg;
      paramMenuItem.source = ((foh)localObject2).source;
      paramMenuItem.ibx = ((foh)localObject2).ibx;
      paramMenuItem.Wph = ((foh)localObject2).Wph;
      paramMenuItem.Wpi = ((foh)localObject2).Wpi;
      localObject5 = new LinkedList();
      ((List)localObject5).addAll(((foe)localObject3).Wol);
      ((List)localObject5).addAll(((foh)localObject2).Wol);
      paramMenuItem.Wpj = p.lF((List)localObject5).toString();
      paramMenuItem.Wpk = g.lE(((foh)localObject2).Idn).toString();
      paramMenuItem.Wpl = ((foh)localObject2).abOF;
      paramMenuItem.thumbUrl = ((foh)localObject2).oeS;
      if ((p.l((foh)localObject2)) && (((foe)localObject3).abOl != null)) {
        paramMenuItem.Wpm = ((foe)localObject3).abOl.title;
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
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.TLR.hNz(), this.TLQ, this.dyI, 6, "");
      AppMethodBeat.o(126074);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.3
 * JD-Core Version:    0.7.0.1
 */