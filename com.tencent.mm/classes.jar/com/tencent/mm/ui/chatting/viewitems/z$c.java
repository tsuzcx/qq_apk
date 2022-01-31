package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.da.b;
import com.tencent.mm.g.a.of;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.ad;
import com.tencent.mm.ui.chatting.c.b.o;
import java.util.Iterator;
import java.util.LinkedList;

public final class z$c
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public z$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.zzP = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33200);
    ab.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
    g.RL().Ru().set(ac.a.yKt, Long.valueOf(System.currentTimeMillis()));
    EmojiCaptureReporter.bnz();
    paramView = new da();
    paramView.cqt.type = 2;
    com.tencent.mm.sdk.b.a.ymk.l(paramView);
    com.tencent.mm.sdk.b.a.ymk.l(new of());
    if (!paramView.cqu.cqv)
    {
      paramView = ((d)g.G(d.class)).getEmojiStorageMgr().yNq.blb();
      if (paramView != null)
      {
        Iterator localIterator = paramView.xND.iterator();
        while (localIterator.hasNext())
        {
          cdb localcdb = (cdb)localIterator.next();
          if (localcdb.ProductID.equals(String.valueOf("capture"))) {
            localcdb.wux = 0;
          }
        }
      }
      ((d)g.G(d.class)).getEmojiStorageMgr().yNq.b(paramView);
      com.tencent.mm.ca.a.dqM();
      paramView = com.tencent.mm.ca.a.yiH;
      a.b.aoG("capture");
    }
    ((o)this.zzP.ay(o.class)).dIg().doj();
    paramView = this.zzP;
    ab.i("MicroMsg.ChattingContext", "[scrollToLast]");
    paramView.zJA.dGI();
    AppMethodBeat.o(33200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.c
 * JD-Core Version:    0.7.0.1
 */