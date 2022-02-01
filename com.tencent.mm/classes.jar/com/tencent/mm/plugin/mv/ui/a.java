package com.tencent.mm.plugin.mv.ui;

import android.util.Base64;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MvLogic;", "", "()V", "TAG", "", "canShareMv", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "fillMvMakerInfo", "", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "fillSongInfo", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "generateFlexAlbumIdByOriginId", "albumOriginId", "", "generateSongId", "generateSongInfoBase64", "getAppIconPath", "appId", "iconType", "", "getCoverPath", "url", "getSongId", "getVideoPath", "mediaId", "loadAlphaAppIcon", "imageView", "Landroid/widget/ImageView;", "loadAppIcon", "defaultRes", "toInfoString", "plugin-mv_release"})
public final class a
{
  public static final a Gfi;
  
  static
  {
    AppMethodBeat.i(243303);
    Gfi = new a();
    AppMethodBeat.o(243303);
  }
  
  public static String OJ(long paramLong)
  {
    AppMethodBeat.i(243301);
    String str = "local_".concat(String.valueOf(paramLong));
    AppMethodBeat.o(243301);
    return str;
  }
  
  public static String a(bds parambds)
  {
    AppMethodBeat.i(243290);
    p.k(parambds, "songInfo");
    parambds = Base64.encode(parambds.toByteArray(), 2);
    p.j(parambds, "Base64.encode(songInfo.t…eArray(), Base64.NO_WRAP)");
    parambds = new String(parambds, kotlin.n.d.UTF_8);
    AppMethodBeat.o(243290);
    return parambds;
  }
  
  public static void a(com.tencent.mm.plugin.music.model.e.a parama, bds parambds)
  {
    AppMethodBeat.i(243291);
    p.k(parama, "music");
    p.k(parambds, "songInfo");
    parambds.HLH = parama.field_songName;
    parambds.ozs = parama.field_songSinger;
    parambds.SOK = parama.field_songWebUrl;
    parambds.SOJ = parama.field_appId;
    parambds.musicDataUrl = parama.field_songWifiUrl;
    parambds.SOM = parama.field_songHAlbumUrl;
    parambds.SOL = parama.field_songLyric;
    parambds.kkU = "";
    AppMethodBeat.o(243291);
  }
  
  public static String aSH(String paramString)
  {
    AppMethodBeat.i(243286);
    p.k(paramString, "url");
    Object localObject = com.tencent.mm.plugin.music.model.g.FRy;
    localObject = new StringBuilder("thumb_");
    paramString = paramString.getBytes(kotlin.n.d.UTF_8);
    p.j(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.music.model.g.aSf(com.tencent.mm.b.g.getMessageDigest(paramString))).bOF();
    p.j(paramString, "VFSFile(MusicFileNameUti…Array())}\")).absolutePath");
    AppMethodBeat.o(243286);
    return paramString;
  }
  
  public static String aSI(String paramString)
  {
    AppMethodBeat.i(243287);
    p.k(paramString, "mediaId");
    com.tencent.mm.plugin.music.model.g localg = com.tencent.mm.plugin.music.model.g.FRy;
    paramString = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.music.model.g.aSg(paramString)).bOF();
    p.j(paramString, "VFSFile(MusicFileNameUti…th(mediaId)).absolutePath");
    AppMethodBeat.o(243287);
    return paramString;
  }
  
  public static String b(bds parambds)
  {
    AppMethodBeat.i(243302);
    p.k(parambds, "$this$toInfoString");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("songId: ").append(parambds.kkU).append("\n");
    localStringBuffer.append("songName: ").append(parambds.HLH).append("\n");
    localStringBuffer.append("singer: ").append(parambds.ozs).append("\n");
    localStringBuffer.append("albumName: ").append(parambds.albumName).append("\n");
    localStringBuffer.append("albumUrl: ").append(parambds.SOM).append("\n");
    localStringBuffer.append("genre: ").append(parambds.SMY).append("\n");
    localStringBuffer.append("publicTime: ").append(parambds.SOO).append("\n");
    localStringBuffer.append("duration: ").append(parambds.duration).append("\n");
    localStringBuffer.append("dataUrl: ").append(parambds.musicDataUrl).append("\n");
    localStringBuffer.append("webUrl: ").append(parambds.SOK).append("\n");
    localStringBuffer.append("songLyric: ").append(parambds.SOL).append("\n");
    parambds = "FinderMVSongInfo " + localStringBuffer;
    AppMethodBeat.o(243302);
    return parambds;
  }
  
  public static void d(dbo paramdbo)
  {
    AppMethodBeat.i(243289);
    p.k(paramdbo, "mvData");
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    i locali = d.a.aAK(z.bdh());
    int m;
    int k;
    int i1;
    label230:
    int n;
    label256:
    label385:
    label389:
    label413:
    label567:
    if (locali != null)
    {
      localObject1 = paramdbo.TIV;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new FinderContact();
        ((FinderContact)localObject2).username = locali.getUsername();
        ((FinderContact)localObject2).nickname = locali.getNickname();
        ((FinderContact)localObject2).headUrl = locali.Mm();
        ((FinderContact)localObject2).signature = locali.getSignature();
        ((FinderContact)localObject2).coverImgUrl = locali.field_coverImg;
        ((FinderContact)localObject2).liveCoverImgUrl = locali.field_liveCoverImg;
        ((FinderContact)localObject2).authInfo = locali.field_authInfo;
        ((FinderObject)localObject1).contact = ((FinderContact)localObject2);
      }
      m = 0;
      k = 0;
      i1 = 0;
      int j = 0;
      localObject1 = paramdbo.TIV;
      LinkedList localLinkedList;
      Iterator localIterator1;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          localLinkedList = paramdbo.SGC;
          if ((localObject1 == null) || (((bdp)localObject1).SOF != 1)) {
            break label456;
          }
          localObject1 = paramdbo.TIV;
          if (localObject1 == null) {
            break label450;
          }
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 == null) {
            break label450;
          }
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 == null) {
            break label450;
          }
          localObject1 = ((bdp)localObject1).SOE;
          localObject1 = (List)localObject1;
          if (localObject1 == null) {
            break label599;
          }
          localIterator1 = ((Iterable)localObject1).iterator();
          i = 0;
        }
      }
      bdt localbdt;
      label338:
      do
      {
        i1 = j;
        n = i;
        m = k;
        if (!localIterator1.hasNext()) {
          break label602;
        }
        localbdt = (bdt)localIterator1.next();
        n = k + localbdt.SOR;
        if (localbdt.refObjectId != 0L)
        {
          i1 = i + localbdt.SOR;
          p.j(localLinkedList, "refList");
          Iterator localIterator2 = ((Iterable)localLinkedList).iterator();
          m = j;
          for (;;)
          {
            j = m;
            i = i1;
            k = n;
            if (!localIterator2.hasNext()) {
              break label256;
            }
            localObject1 = (FinderObject)localIterator2.next();
            if (((FinderObject)localObject1).id == localbdt.refObjectId)
            {
              i = 1;
              if (i == 0) {
                break label519;
              }
              if (localObject1 == null) {
                break label523;
              }
              localObject2 = ((FinderObject)localObject1).contact;
              if (localObject2 == null) {
                break label525;
              }
              localObject2 = ((FinderContact)localObject2).username;
              if (!p.h(localObject2, locali.getUsername())) {
                break label531;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label535;
              }
              m = localbdt.SOR + m;
              break label338;
              localObject1 = null;
              break;
              localObject1 = null;
              break label230;
              localObject1 = paramdbo.TIV;
              if (localObject1 != null)
              {
                localObject1 = ((FinderObject)localObject1).objectDesc;
                if (localObject1 != null)
                {
                  localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
                  if (localObject1 == null) {}
                }
              }
              for (localObject1 = ((bdp)localObject1).SOB;; localObject1 = null)
              {
                localObject1 = (List)localObject1;
                break;
              }
              i = 0;
              break label385;
              localObject1 = null;
              break label389;
              break label338;
              localObject2 = null;
              break label413;
              localObject1 = null;
            }
          }
        }
        localObject1 = localbdt.SOS;
        k = n;
      } while (localObject1 == null);
      label450:
      label456:
      if (((CharSequence)localObject1).length() > 0)
      {
        k = 1;
        if (k != 1) {
          break label735;
        }
        i = localbdt.SOR + i;
        j += localbdt.SOR;
      }
    }
    label519:
    label523:
    label525:
    label531:
    label535:
    label599:
    label602:
    label735:
    for (;;)
    {
      k = n;
      break;
      k = 0;
      break label567;
      n = 0;
      if (m > 0)
      {
        paramdbo = paramdbo.TIV;
        if (paramdbo != null)
        {
          paramdbo = paramdbo.objectDesc;
          if (paramdbo != null)
          {
            paramdbo = paramdbo.mvInfo;
            if (paramdbo != null)
            {
              localObject1 = new bdr();
              ((bdr)localObject1).SOI = (n / m);
              ((bdr)localObject1).SOH = (i1 / m);
              Log.i("MicroMsg.Mv.MvLogic", "createPostData completion:" + ((bdr)localObject1).SOI + ", orignality:" + ((bdr)localObject1).SOH);
              paramdbo.Gbq = ((bdr)localObject1);
              AppMethodBeat.o(243289);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(243289);
      return;
      AppMethodBeat.o(243289);
      return;
    }
  }
  
  public static boolean e(f paramf)
  {
    AppMethodBeat.i(243292);
    p.k(paramf, "musicMv");
    if (paramf.Gbu == 1)
    {
      AppMethodBeat.o(243292);
      return true;
    }
    if (paramf.Gbu == 4)
    {
      AppMethodBeat.o(243292);
      return true;
    }
    AppMethodBeat.o(243292);
    return false;
  }
  
  public static boolean i(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(243295);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(243295);
      return false;
    }
    if (paramImageView == null)
    {
      AppMethodBeat.o(243295);
      return false;
    }
    localObject = new StringBuilder();
    com.tencent.mm.plugin.music.model.g localg = com.tencent.mm.plugin.music.model.g.FRy;
    paramString = com.tencent.mm.plugin.music.model.g.feR() + paramString + ".png";
    if (!u.agG(paramString))
    {
      Log.i("MicroMsg.Mv.MvLogic", "appId icon isnot exist");
      AppMethodBeat.o(243295);
      return false;
    }
    localObject = new c.a().gs(true).bmH().bmL();
    p.j(localObject, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
    com.tencent.mm.ay.q.bml().a(paramString, paramImageView, (c)localObject, (h)new a.a());
    AppMethodBeat.o(243295);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a
 * JD-Core Version:    0.7.0.1
 */