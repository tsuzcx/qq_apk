package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"buildBusinessBuffer", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "escape", "", "toMusicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "albumUrl", "toXml", "plugin-mv_release"})
public final class d
{
  public static final String a(bds parambds, f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235889);
    p.k(parambds, "songInfo");
    Object localObject1 = new StringBuilder("\n<MusicVideoStatusOpenParams>\n");
    p.k(parambds, "$this$toXml");
    StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(n.bHx("<FinderMVSongInfo>\n    <songName>" + dJ(parambds.HLH) + "</songName>\n    <singer>" + dJ(parambds.ozs) + "</singer>\n    <musicDataUrl>" + dJ(parambds.musicDataUrl) + "</musicDataUrl>\n    <musicAppId>" + dJ(parambds.SOJ) + "</musicAppId>\n    <musicWebUrl>" + dJ(parambds.SOK) + "</musicWebUrl>\n    <songId>" + dJ(parambds.kkU) + "</songId>\n    <lyric>" + dJ(parambds.SOL) + "</lyric>\n    <albumName>" + dJ(parambds.albumName) + "</albumName>\n    <albumUrl>" + dJ(parambds.SOM) + "</albumUrl>\n    <genre>" + dJ(parambds.SMY) + "</genre>\n    <publicTime>" + dJ(parambds.SON) + "</publicTime>\n    <publicTimeS>" + dJ(Long.valueOf(parambds.SOO)) + "</publicTimeS>\n    <extraInfo>" + dJ(parambds.extraInfo) + "</extraInfo>\n    <identification>" + dJ(parambds.identification) + "</identification>\n    <duration>" + parambds.duration + "</duration>\n</FinderMVSongInfo>\n")).append('\n');
    localObject1 = paramf;
    if (paramf == null) {
      localObject1 = new f();
    }
    paramf = parambds.SOM;
    p.k(localObject1, "$this$toXml");
    p.k(localObject1, "$this$toMusicShareObject");
    if (((f)localObject1).Gbu == 1)
    {
      localObject2 = ((f)localObject1).Gbl;
      parambds = ((f)localObject1).Gbm;
      if ((localObject2 == null) || (parambds == null)) {
        break label632;
      }
      long l = ((Number)localObject2).longValue();
      if (l == 0L) {
        break label637;
      }
      localObject2 = new dbr();
      ((dbr)localObject2).Ruu = com.tencent.mm.ae.d.Fw(l);
      ((dbr)localObject2).Ruv = parambds;
      String str = ((f)localObject1).coverUrl;
      parambds = str;
      if (str == null) {
        parambds = paramf;
      }
      ((dbr)localObject2).Ruw = parambds;
      ((dbr)localObject2).Rux = ((f)localObject1).Gbn;
      parambds = (bds)localObject2;
    }
    for (;;)
    {
      paramf = parambds;
      if (parambds == null) {
        paramf = new dbr();
      }
      parambds = am.a(paramf);
      p.j(parambds, "MusicMvShareParser.makeC…sicShareObject(albumUrl))");
      parambds = n.bHx(parambds + "\n</MusicVideoStatusOpenParams>");
      AppMethodBeat.o(235889);
      return parambds;
      if (((f)localObject1).Gbu == 4)
      {
        localObject1 = ((f)localObject1).Gbx;
        if (localObject1 != null)
        {
          paramf = new dbr();
          paramf.Ruu = com.tencent.mm.ae.d.Fw(((FinderObject)localObject1).id);
          paramf.Ruv = ((FinderObject)localObject1).objectNonceId;
          parambds = ((FinderObject)localObject1).objectDesc;
          if (parambds != null)
          {
            parambds = parambds.media;
            if (parambds != null)
            {
              parambds = (FinderMedia)j.lp((List)parambds);
              if (parambds == null) {}
            }
          }
          for (parambds = parambds.thumbUrl + parambds.thumb_url_token;; parambds = (bds)localObject2)
          {
            paramf.Ruw = parambds;
            parambds = ((FinderObject)localObject1).contact;
            if (parambds != null)
            {
              localObject1 = parambds.nickname;
              parambds = (bds)localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              parambds = "";
            }
            paramf.Rux = parambds;
            parambds = paramf;
            break;
          }
        }
      }
      label632:
      parambds = null;
      continue;
      label637:
      parambds = null;
    }
  }
  
  private static String dJ(Object paramObject)
  {
    AppMethodBeat.i(235885);
    if (paramObject != null)
    {
      String str = paramObject.toString();
      paramObject = str;
      if (str != null) {}
    }
    else
    {
      paramObject = "";
    }
    paramObject = Util.escapeStringForXml(paramObject);
    p.j(paramObject, "Util.escapeStringForXml(this?.toString() ?: \"\")");
    AppMethodBeat.o(235885);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.d
 * JD-Core Version:    0.7.0.1
 */