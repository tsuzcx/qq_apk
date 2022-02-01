package com.tencent.mm.plugin.mv.ui;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MvLogic;", "", "()V", "TAG", "", "canShareMv", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "fillMvMakerInfo", "", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "fillSongInfo", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "generateSongId", "generateSongInfoBase64", "getCoverPath", "url", "getSongId", "getVideoPath", "mediaId", "loadAppIcon", "appId", "iconType", "", "imageView", "Landroid/widget/ImageView;", "defaultRes", "plugin-mv_release"})
public final class a
{
  public static final a ArA;
  
  static
  {
    AppMethodBeat.i(256958);
    ArA = new a();
    AppMethodBeat.o(256958);
  }
  
  public static void a(com.tencent.mm.plugin.music.model.e.a parama, axy paramaxy)
  {
    AppMethodBeat.i(256955);
    p.h(parama, "music");
    p.h(paramaxy, "songInfo");
    paramaxy.BPc = parama.field_songName;
    paramaxy.lDR = parama.field_songSinger;
    paramaxy.LIg = parama.field_songWebUrl;
    paramaxy.LIf = parama.field_appId;
    paramaxy.musicDataUrl = parama.field_songWifiUrl;
    paramaxy.Djf = parama.field_songHAlbumUrl;
    paramaxy.LIh = parama.field_songLyric;
    paramaxy.AqO = "";
    AppMethodBeat.o(256955);
  }
  
  public static String aIo(String paramString)
  {
    AppMethodBeat.i(256950);
    p.h(paramString, "url");
    Object localObject = com.tencent.mm.plugin.music.model.g.Aku;
    localObject = new StringBuilder("thumb_");
    paramString = paramString.getBytes(d.UTF_8);
    p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = new o(com.tencent.mm.plugin.music.model.g.aHP(com.tencent.mm.b.g.getMessageDigest(paramString))).getAbsolutePath();
    p.g(paramString, "VFSFile(MusicFileNameUti…Array())}\")).absolutePath");
    AppMethodBeat.o(256950);
    return paramString;
  }
  
  public static String aIp(String paramString)
  {
    AppMethodBeat.i(256951);
    p.h(paramString, "mediaId");
    com.tencent.mm.plugin.music.model.g localg = com.tencent.mm.plugin.music.model.g.Aku;
    paramString = new o(com.tencent.mm.plugin.music.model.g.aHQ(paramString)).getAbsolutePath();
    p.g(paramString, "VFSFile(MusicFileNameUti…th(mediaId)).absolutePath");
    AppMethodBeat.o(256951);
    return paramString;
  }
  
  public static String b(axy paramaxy)
  {
    AppMethodBeat.i(256954);
    p.h(paramaxy, "songInfo");
    paramaxy = Base64.encode(paramaxy.toByteArray(), 2);
    p.g(paramaxy, "Base64.encode(songInfo.t…eArray(), Base64.NO_WRAP)");
    paramaxy = new String(paramaxy, d.UTF_8);
    AppMethodBeat.o(256954);
    return paramaxy;
  }
  
  public static void c(csp paramcsp)
  {
    AppMethodBeat.i(256952);
    p.h(paramcsp, "mvData");
    Object localObject1 = c.tsp;
    com.tencent.mm.plugin.finder.api.g localg = c.a.asG(z.aUg());
    int i;
    long l2;
    label252:
    int j;
    if (localg != null)
    {
      localObject1 = paramcsp.MxE;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new FinderContact();
        ((FinderContact)localObject2).username = localg.getUsername();
        ((FinderContact)localObject2).nickname = localg.getNickname();
        ((FinderContact)localObject2).headUrl = localg.cXH();
        ((FinderContact)localObject2).signature = localg.getSignature();
        ((FinderContact)localObject2).coverImgUrl = localg.field_coverImg;
        ((FinderContact)localObject2).liveCoverImgUrl = localg.field_liveCoverImg;
        ((FinderContact)localObject2).authInfo = localg.field_authInfo;
        ((FinderObject)localObject1).contact = ((FinderContact)localObject2);
      }
      long l1 = 0L;
      localObject1 = paramcsp.MxE;
      Iterator localIterator1;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 != null)
          {
            localObject1 = ((axw)localObject1).LId;
            if (localObject1 != null)
            {
              i = ((LinkedList)localObject1).size();
              localObject1 = paramcsp.MxE;
              l2 = l1;
              if (localObject1 == null) {
                break label484;
              }
              localObject1 = ((FinderObject)localObject1).objectDesc;
              l2 = l1;
              if (localObject1 == null) {
                break label484;
              }
              localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
              l2 = l1;
              if (localObject1 == null) {
                break label484;
              }
              localObject1 = ((axw)localObject1).LId;
              l2 = l1;
              if (localObject1 == null) {
                break label484;
              }
              localIterator1 = ((Iterable)localObject1).iterator();
            }
          }
        }
      }
      label316:
      label357:
      label361:
      do
      {
        l2 = l1;
        if (!localIterator1.hasNext()) {
          break label484;
        }
        axz localaxz = (axz)localIterator1.next();
        if (localaxz.refObjectId != 0L)
        {
          localObject1 = paramcsp.LDi;
          p.g(localObject1, "mvData.refObjectList");
          Iterator localIterator2 = ((Iterable)localObject1).iterator();
          l2 = l1;
          for (;;)
          {
            l1 = l2;
            if (!localIterator2.hasNext()) {
              break label252;
            }
            localObject1 = (FinderObject)localIterator2.next();
            if (((FinderObject)localObject1).id == localaxz.refObjectId)
            {
              j = 1;
              if (j == 0) {
                break label422;
              }
              if (localObject1 == null) {
                break label426;
              }
              localObject2 = ((FinderObject)localObject1).contact;
              if (localObject2 == null) {
                break label428;
              }
              localObject2 = ((FinderContact)localObject2).username;
              if (!p.j(localObject2, localg.getUsername())) {
                break label434;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label438;
              }
              l2 += 1L;
              break label316;
              i = 0;
              break;
              j = 0;
              break label357;
              localObject1 = null;
              break label361;
              break label316;
              localObject2 = null;
              break label385;
              localObject1 = null;
            }
          }
        }
        localObject1 = localaxz.LIm;
      } while (localObject1 == null);
      label385:
      label422:
      label426:
      label428:
      label434:
      label438:
      if (((CharSequence)localObject1).length() > 0)
      {
        j = 1;
        label467:
        if (j != 1) {
          break label589;
        }
        l1 = 1L + l1;
      }
    }
    label589:
    for (;;)
    {
      break;
      j = 0;
      break label467;
      label484:
      if (i > 0L)
      {
        paramcsp = paramcsp.MxE;
        if (paramcsp != null)
        {
          paramcsp = paramcsp.objectDesc;
          if (paramcsp != null)
          {
            paramcsp = paramcsp.mvInfo;
            if (paramcsp != null)
            {
              localObject1 = new axx();
              ((axx)localObject1).LIe = ((float)l2 / i);
              Log.i("SimpleUIComponent", "createPostData originality:" + ((axx)localObject1).LIe);
              paramcsp.ApI = ((axx)localObject1);
              AppMethodBeat.o(256952);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(256952);
      return;
      AppMethodBeat.o(256952);
      return;
    }
  }
  
  public static boolean c(e parame)
  {
    AppMethodBeat.i(256956);
    p.h(parame, "musicMv");
    if (parame.ApM == 1)
    {
      AppMethodBeat.o(256956);
      return true;
    }
    if (parame.ApM == 4)
    {
      AppMethodBeat.o(256956);
      return true;
    }
    AppMethodBeat.o(256956);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a
 * JD-Core Version:    0.7.0.1
 */