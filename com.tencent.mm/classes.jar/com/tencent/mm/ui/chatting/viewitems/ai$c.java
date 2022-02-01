package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a.b;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.dg.b;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.chatting.c.b.q;

public final class ai$c
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  public ai$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.Gob = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37290);
    ad.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
    g.afB().afk().set(ae.a.FtE, Long.valueOf(System.currentTimeMillis()));
    EmojiCaptureReporter.bXo();
    paramView = new dg();
    paramView.dfp.type = 2;
    com.tencent.mm.sdk.b.a.ESL.l(paramView);
    com.tencent.mm.sdk.b.a.ESL.l(new pu());
    if (!paramView.dfq.dfr)
    {
      com.tencent.mm.cc.a.eCL();
      paramView = com.tencent.mm.cc.a.EMi;
      a.b.aEG("capture");
      ((q)this.Gob.be(q.class)).eXs().setDefaultSmileyByDetail(z.abU());
    }
    ((q)this.Gob.be(q.class)).eXs().eyX();
    this.Gob.eVO();
    AppMethodBeat.o(37290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.c
 * JD-Core Version:    0.7.0.1
 */