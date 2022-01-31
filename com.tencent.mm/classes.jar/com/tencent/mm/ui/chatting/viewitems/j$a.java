package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.f;
import com.tencent.mm.af.j.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class j$a
  extends f
{
  public String appId;
  public String appName;
  public String iconUrl;
  public int state;
  public int zTK;
  
  private static String w(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(32931);
    paramMap = bo.nullAsNil((String)paramMap.get(".msg.appmsg.downloaderapp.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(32931);
    return paramMap;
  }
  
  public final f Yk()
  {
    AppMethodBeat.i(32929);
    a locala = new a();
    AppMethodBeat.o(32929);
    return locala;
  }
  
  public final void a(Map<String, String> paramMap, j.b paramb)
  {
    AppMethodBeat.i(32930);
    if (paramb.type == 671088689)
    {
      ab.i("MicroMsg.ChattingItemAppMsgDownloader", "values: %s", new Object[] { paramMap.toString() });
      this.state = bo.getInt(w(paramMap, "state"), 0);
      this.appId = w(paramMap, "appid");
      this.appName = w(paramMap, "appname");
      this.zTK = bo.getInt(w(paramMap, "appsize"), 0);
      this.iconUrl = w(paramMap, "iconurl");
    }
    AppMethodBeat.o(32930);
  }
  
  public final void b(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */