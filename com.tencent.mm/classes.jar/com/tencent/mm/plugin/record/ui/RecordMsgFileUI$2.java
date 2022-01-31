package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;

final class RecordMsgFileUI$2
  implements Runnable
{
  RecordMsgFileUI$2(RecordMsgFileUI paramRecordMsgFileUI, List paramList, String paramString, Runnable paramRunnable) {}
  
  public final void run()
  {
    Object localObject1 = h.c(RecordMsgFileUI.a(this.nue), RecordMsgFileUI.b(this.nue));
    Object localObject2 = new WXFileObject();
    ((WXFileObject)localObject2).setFilePath((String)localObject1);
    localObject1 = new WXMediaMessage();
    ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
    ((WXMediaMessage)localObject1).title = RecordMsgFileUI.a(this.nue).title;
    ((WXMediaMessage)localObject1).description = RecordMsgFileUI.a(this.nue).desc;
    ((WXMediaMessage)localObject1).thumbData = bk.readFromFile(h.f(RecordMsgFileUI.a(this.nue), RecordMsgFileUI.b(this.nue)));
    localObject2 = this.nuf.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      l.a((WXMediaMessage)localObject1, "", "", str, 3, null);
      g.bhI().dO(this.kdi, str);
    }
    ai.d(this.bxs);
  }
  
  public final String toString()
  {
    return super.toString() + "|onActivityResult2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.2
 * JD-Core Version:    0.7.0.1
 */