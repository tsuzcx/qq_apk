package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class b
  extends f
{
  public String songAlbumUrl = "";
  public String songLyric = "";
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(152373);
    this.songAlbumUrl = ((String)paramMap.get(".msg.appmsg.songalbumurl"));
    this.songLyric = ((String)paramMap.get(".msg.appmsg.songlyric"));
    AppMethodBeat.o(152373);
  }
  
  public final f apu()
  {
    AppMethodBeat.i(152371);
    b localb = new b();
    localb.songAlbumUrl = this.songAlbumUrl;
    localb.songLyric = this.songLyric;
    AppMethodBeat.o(152371);
    return localb;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152372);
    if (!bt.isNullOrNil(this.songAlbumUrl)) {
      paramStringBuilder.append("<songalbumurl>").append(bt.aGf(this.songAlbumUrl)).append("</songalbumurl>");
    }
    if (!bt.isNullOrNil(this.songLyric)) {
      paramStringBuilder.append("<songlyric>").append(bt.aGf(this.songLyric)).append("</songlyric>");
    }
    AppMethodBeat.o(152372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */