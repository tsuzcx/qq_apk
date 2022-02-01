package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class ag$b
{
  public String dDM;
  public String gIj;
  public String gKB;
  public String gKC;
  public String gKD;
  public String gKE;
  public String gKF;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public static b bM(Map<String, String> paramMap)
  {
    AppMethodBeat.i(37239);
    b localb = new b();
    localb.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
    localb.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
    localb.dDM = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
    localb.gKB = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
    localb.gKC = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
    localb.time = bt.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
    localb.gKD = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
    localb.gKE = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
    localb.gKF = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
    localb.type = bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
    localb.gIj = ((String)paramMap.get(".msg.appmsg.template_id"));
    AppMethodBeat.o(37239);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag.b
 * JD-Core Version:    0.7.0.1
 */