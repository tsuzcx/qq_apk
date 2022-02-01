package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class l$a
  extends f
{
  public int Xfz;
  public String appId;
  public String appName;
  public String iconUrl;
  public int state;
  
  private static String ae(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(36915);
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.downloaderapp.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(36915);
    return paramMap;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(36914);
    if (paramb.type == 671088689)
    {
      Log.i("MicroMsg.ChattingItemAppMsgDownloader", "values: %s", new Object[] { paramMap.toString() });
      this.state = Util.getInt(ae(paramMap, "state"), 0);
      this.appId = ae(paramMap, "appid");
      this.appName = ae(paramMap, "appname");
      this.Xfz = Util.getInt(ae(paramMap, "appsize"), 0);
      this.iconUrl = ae(paramMap, "iconurl");
    }
    AppMethodBeat.o(36914);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(36913);
    a locala = new a();
    AppMethodBeat.o(36913);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.a
 * JD-Core Version:    0.7.0.1
 */