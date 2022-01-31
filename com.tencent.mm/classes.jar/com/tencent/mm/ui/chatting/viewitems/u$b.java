package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public final class u$b
{
  public String ceb;
  public String dRD;
  public String dTB;
  public String dTC;
  public String dTD;
  public String dTE;
  public String dTF;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public static b az(Map<String, String> paramMap)
  {
    b localb = new b();
    localb.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
    localb.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
    localb.ceb = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
    localb.dTB = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
    localb.dTC = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
    localb.time = bk.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
    localb.dTD = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
    localb.dTE = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
    localb.dTF = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
    localb.type = bk.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
    localb.dRD = ((String)paramMap.get(".msg.appmsg.template_id"));
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.b
 * JD-Core Version:    0.7.0.1
 */