package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "filePath", "decodeKey", "urlToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDecodeKey", "()Ljava/lang/String;", "getFilePath", "uniqueSalt", "", "getUrl", "getUrlToken", "uniqueValue", "plugin-thumbplayer_release"})
public final class g
  implements com.tencent.mm.loader.h.a.c
{
  private final long MPW;
  final String decodeKey;
  final String filePath;
  final String url;
  final String zZu;
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(191017);
    this.url = paramString1;
    this.filePath = paramString2;
    this.decodeKey = paramString3;
    this.zZu = paramString4;
    this.MPW = c.gnO().zC();
    AppMethodBeat.o(191017);
  }
  
  public final String aBv()
  {
    AppMethodBeat.i(191012);
    if (!Util.isNullOrNil(this.url)) {}
    for (String str = this.url;; str = this.filePath)
    {
      str = str + '_' + this.MPW + '_' + hashCode();
      AppMethodBeat.o(191012);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.g
 * JD-Core Version:    0.7.0.1
 */