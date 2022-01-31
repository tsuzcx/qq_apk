package com.tencent.mm.plugin.record.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.File;
import java.util.Iterator;
import java.util.List;

final class RecordMsgFileUI$14
  implements Runnable
{
  RecordMsgFileUI$14(RecordMsgFileUI paramRecordMsgFileUI, List paramList, String paramString, Runnable paramRunnable) {}
  
  public final void run()
  {
    File localFile = new File(h.c(RecordMsgFileUI.a(this.nue), RecordMsgFileUI.b(this.nue)));
    Iterator localIterator = this.nuf.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      Object localObject1;
      if (localFile.exists())
      {
        localObject1 = RecordMsgFileUI.m(this.nue);
        y.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[] { localFile.getAbsolutePath(), localObject1 });
        if (RecordMsgFileUI.c(this.nue) == 15) {
          com.tencent.mm.plugin.messenger.a.g.bhI().a(this.nue.mController.uMN, str1, localFile.getAbsolutePath(), (String)localObject1, 62, RecordMsgFileUI.a(this.nue).duration, "");
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.messenger.a.g.bhI().dO(this.kdi, str1);
        break;
        com.tencent.mm.plugin.messenger.a.g.bhI().a(this.nue.mController.uMN, str1, localFile.getAbsolutePath(), (String)localObject1, 1, RecordMsgFileUI.a(this.nue).duration, "");
        continue;
        Object localObject2 = RecordMsgFileUI.a(this.nue).sUN;
        if (!bk.bl((String)localObject2))
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = ((String)localObject2);
          localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
          String str2 = bk.aM(RecordMsgFileUI.a(this.nue).title, this.nue.mController.uMN.getResources().getString(R.l.favorite_video));
          ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
          ((WXMediaMessage)localObject2).title = str2;
          ((WXMediaMessage)localObject2).description = RecordMsgFileUI.a(this.nue).desc;
          ((WXMediaMessage)localObject2).thumbData = bk.readFromFile(h.f(RecordMsgFileUI.a(this.nue), RecordMsgFileUI.b(this.nue)));
          if (((WXMediaMessage)localObject2).thumbData == null)
          {
            localObject1 = new StringBuilder();
            au.Hx();
            ((WXMediaMessage)localObject2).thumbData = bk.readFromFile(c.FQ() + "web/" + com.tencent.mm.a.g.o(bk.aM(RecordMsgFileUI.a(this.nue).bIm, "").getBytes()));
          }
          l.a((WXMediaMessage)localObject2, "", "", str1, 3, null);
        }
      }
    }
    ai.d(this.bxs);
  }
  
  public final String toString()
  {
    return super.toString() + "|onActivityResult1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.14
 * JD-Core Version:    0.7.0.1
 */