package com.tencent.mm.plugin.thumbplayer.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "filePath", "decodeKey", "urlToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDecodeKey", "()Ljava/lang/String;", "getFilePath", "uniqueSalt", "", "getUrl", "getUrlToken", "uniqueValue", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements com.tencent.mm.loader.g.a.c
{
  private final long TCw;
  final String decodeKey;
  final String filePath;
  final String msf;
  final String url;
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(272158);
    this.url = paramString1;
    this.filePath = paramString2;
    this.decodeKey = paramString3;
    this.msf = paramString4;
    this.TCw = c.hKB().Zn();
    AppMethodBeat.o(272158);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(272165);
    if (!Util.isNullOrNil(this.url)) {}
    for (String str = this.url;; str = this.filePath)
    {
      str = str + '_' + this.TCw + '_' + hashCode();
      AppMethodBeat.o(272165);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.g
 * JD-Core Version:    0.7.0.1
 */