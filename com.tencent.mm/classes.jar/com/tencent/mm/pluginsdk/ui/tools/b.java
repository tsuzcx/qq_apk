package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public class b
  extends f
{
  public String songAlbumUrl = "";
  public String songLyric = "";
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152372);
    if (!bu.isNullOrNil(this.songAlbumUrl)) {
      paramStringBuilder.append("<songalbumurl>").append(bu.aSz(this.songAlbumUrl)).append("</songalbumurl>");
    }
    if (!bu.isNullOrNil(this.songLyric)) {
      paramStringBuilder.append("<songlyric>").append(bu.aSz(this.songLyric)).append("</songlyric>");
    }
    AppMethodBeat.o(152372);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(152373);
    this.songAlbumUrl = ((String)paramMap.get(".msg.appmsg.songalbumurl"));
    this.songLyric = ((String)paramMap.get(".msg.appmsg.songlyric"));
    AppMethodBeat.o(152373);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(152371);
    b localb = new b();
    localb.songAlbumUrl = this.songAlbumUrl;
    localb.songLyric = this.songLyric;
    AppMethodBeat.o(152371);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */