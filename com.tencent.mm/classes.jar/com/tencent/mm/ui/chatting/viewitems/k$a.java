package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class k$a
  extends f
{
  public int Kbr;
  public String appId;
  public String appName;
  public String iconUrl;
  public int state;
  
  private static String C(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(36915);
    paramMap = bt.nullAsNil((String)paramMap.get(".msg.appmsg.downloaderapp.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(36915);
    return paramMap;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(36914);
    if (paramb.type == 671088689)
    {
      ad.i("MicroMsg.ChattingItemAppMsgDownloader", "values: %s", new Object[] { paramMap.toString() });
      this.state = bt.getInt(C(paramMap, "state"), 0);
      this.appId = C(paramMap, "appid");
      this.appName = C(paramMap, "appname");
      this.Kbr = bt.getInt(C(paramMap, "appsize"), 0);
      this.iconUrl = C(paramMap, "iconurl");
    }
    AppMethodBeat.o(36914);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(36913);
    a locala = new a();
    AppMethodBeat.o(36913);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.a
 * JD-Core Version:    0.7.0.1
 */