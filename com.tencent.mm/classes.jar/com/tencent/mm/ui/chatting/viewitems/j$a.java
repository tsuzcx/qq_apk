package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public class j$a
  extends com.tencent.mm.ae.d
{
  public String appId;
  public String appName;
  public String iconUrl;
  public int state;
  public int vCH;
  
  private static String v(Map<String, String> paramMap, String paramString)
  {
    return bk.pm((String)paramMap.get(".msg.appmsg.downloaderapp." + paramString));
  }
  
  public final com.tencent.mm.ae.d Fk()
  {
    return new a();
  }
  
  public final void a(StringBuilder paramStringBuilder, g.a parama, String paramString, com.tencent.mm.j.d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, g.a parama)
  {
    if (parama.type == 671088689)
    {
      y.i("MicroMsg.ChattingItemAppMsgDownloader", "values: %s", new Object[] { paramMap.toString() });
      this.state = bk.getInt(v(paramMap, "state"), 0);
      this.appId = v(paramMap, "appid");
      this.appName = v(paramMap, "appname");
      this.vCH = bk.getInt(v(paramMap, "appsize"), 0);
      this.iconUrl = v(paramMap, "iconurl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */