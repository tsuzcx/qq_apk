package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class x$b
{
  public String cMO;
  public String fhC;
  public String fjH;
  public String fjI;
  public String fjJ;
  public String fjK;
  public String fjL;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public static b aY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(33156);
    b localb = new b();
    localb.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
    localb.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
    localb.cMO = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
    localb.fjH = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
    localb.fjI = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
    localb.time = bo.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
    localb.fjJ = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
    localb.fjK = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
    localb.fjL = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
    localb.type = bo.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
    localb.fhC = ((String)paramMap.get(".msg.appmsg.template_id"));
    AppMethodBeat.o(33156);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.b
 * JD-Core Version:    0.7.0.1
 */