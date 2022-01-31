package com.tencent.mm.plugin.record.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

final class RecordMsgFileUI$14
  implements Runnable
{
  RecordMsgFileUI$14(RecordMsgFileUI paramRecordMsgFileUI, List paramList, String paramString, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(24270);
    File localFile = new File(n.c(RecordMsgFileUI.a(this.pZN), RecordMsgFileUI.b(this.pZN)));
    Iterator localIterator = this.pZO.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      Object localObject1;
      if (localFile.exists())
      {
        localObject1 = RecordMsgFileUI.m(this.pZN);
        ab.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[] { localFile.getAbsolutePath(), localObject1 });
        if (RecordMsgFileUI.c(this.pZN) == 15) {
          com.tencent.mm.plugin.messenger.a.g.bPJ().a(this.pZN.getContext(), str1, localFile.getAbsolutePath(), (String)localObject1, 62, RecordMsgFileUI.a(this.pZN).duration, "");
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.messenger.a.g.bPJ().fh(this.mxS, str1);
        break;
        com.tencent.mm.plugin.messenger.a.g.bPJ().a(this.pZN.getContext(), str1, localFile.getAbsolutePath(), (String)localObject1, 1, RecordMsgFileUI.a(this.pZN).duration, "");
        continue;
        Object localObject2 = RecordMsgFileUI.a(this.pZN).wSJ;
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = ((String)localObject2);
          localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
          String str2 = bo.bf(RecordMsgFileUI.a(this.pZN).title, this.pZN.getContext().getResources().getString(2131299853));
          ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
          ((WXMediaMessage)localObject2).title = str2;
          ((WXMediaMessage)localObject2).description = RecordMsgFileUI.a(this.pZN).desc;
          ((WXMediaMessage)localObject2).thumbData = bo.readFromFile(n.f(RecordMsgFileUI.a(this.pZN), RecordMsgFileUI.b(this.pZN)));
          if (((WXMediaMessage)localObject2).thumbData == null)
          {
            localObject1 = new StringBuilder();
            aw.aaz();
            ((WXMediaMessage)localObject2).thumbData = bo.readFromFile(c.YU() + "web/" + com.tencent.mm.a.g.w(bo.bf(RecordMsgFileUI.a(this.pZN).cpH, "").getBytes()));
          }
          l.a((WXMediaMessage)localObject2, "", "", str1, 3, null);
        }
      }
    }
    al.d(this.bZt);
    AppMethodBeat.o(24270);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(24271);
    String str = super.toString() + "|onActivityResult1";
    AppMethodBeat.o(24271);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.14
 * JD-Core Version:    0.7.0.1
 */