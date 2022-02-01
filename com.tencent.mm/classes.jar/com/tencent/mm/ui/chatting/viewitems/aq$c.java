package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class aq$c
{
  public String ihx;
  public String nSg;
  public String nUK;
  public String nUL;
  public String nUM;
  public String nUN;
  public String nUO;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public static c cM(Map<String, String> paramMap)
  {
    AppMethodBeat.i(37239);
    c localc = new c();
    localc.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
    localc.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
    localc.ihx = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
    localc.nUK = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
    localc.nUL = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
    localc.time = Util.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
    localc.nUM = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
    localc.nUN = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
    localc.nUO = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
    localc.type = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
    localc.nSg = ((String)paramMap.get(".msg.appmsg.template_id"));
    AppMethodBeat.o(37239);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.c
 * JD-Core Version:    0.7.0.1
 */