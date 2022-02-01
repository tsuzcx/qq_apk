package com.tencent.mm.plugin.mv.ui;

import android.util.Base64;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.storage.data.o;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/MvLogic;", "", "()V", "TAG", "", "canShareMv", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "convertFinderLongVideoDuration", "", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "fillMvMakerInfo", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "fillSongInfo", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "generateFlexAlbumIdByOriginId", "albumOriginId", "", "generateSongId", "generateSongInfoBase64", "getAppIconPath", "appId", "iconType", "", "getCoverPath", "url", "getSongId", "getVideoPath", "mediaId", "loadAlphaAppIcon", "imageView", "Landroid/widget/ImageView;", "loadAppIcon", "defaultRes", "toInfoString", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Maz;
  
  static
  {
    AppMethodBeat.i(286479);
    Maz = new a();
    AppMethodBeat.o(286479);
  }
  
  public static void R(FinderObject paramFinderObject)
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(286470);
    s.u(paramFinderObject, "obj");
    Object localObject1 = paramFinderObject.attachmentList;
    if (localObject1 == null) {
      localObject1 = localLinkedList;
    }
    do
    {
      if (localObject1 != null)
      {
        Log.i("MicroMsg.Mv.MvLogic", s.X("convertFinderLongVideoDuration replace success ", Long.valueOf(paramFinderObject.id)));
        paramFinderObject = paramFinderObject.objectDesc;
        if (paramFinderObject != null) {
          paramFinderObject.media = ((LinkedList)localObject1);
        }
      }
      AppMethodBeat.o(286470);
      return;
      localObject2 = ((atr)localObject1).ZEi;
      localObject1 = localLinkedList;
    } while (localObject2 == null);
    Object localObject2 = ((Iterable)localObject2).iterator();
    label90:
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((atq)localObject1).type == 1)
      {
        i = 1;
        label121:
        if (i == 0) {
          break label257;
        }
      }
    }
    for (;;)
    {
      localObject2 = (atq)localObject1;
      localObject1 = localLinkedList;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((atq)localObject2).ZEf;
      localObject1 = localLinkedList;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((byx)localObject2).ZXx;
      localObject1 = localLinkedList;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((dne)localObject2).aaUt;
      localObject1 = localLinkedList;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((dnh)localObject2).media;
      localObject1 = localLinkedList;
      if (localObject2 == null) {
        break;
      }
      s.u(localObject2, "<this>");
      localLinkedList = new LinkedList();
      localObject2 = ((Iterable)localObject2).iterator();
      for (;;)
      {
        localObject1 = localLinkedList;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localLinkedList.add(o.b((dnv)((Iterator)localObject2).next()));
      }
      i = 0;
      break label121;
      label257:
      break label90;
      localObject1 = null;
    }
  }
  
  public static String a(boo paramboo)
  {
    AppMethodBeat.i(286402);
    s.u(paramboo, "songInfo");
    paramboo = Base64.encode(paramboo.toByteArray(), 2);
    s.s(paramboo, "encode(songInfo.toByteArray(), Base64.NO_WRAP)");
    paramboo = new String(paramboo, kotlin.n.d.UTF_8);
    AppMethodBeat.o(286402);
    return paramboo;
  }
  
  public static void a(com.tencent.mm.plugin.music.model.e.a parama, boo paramboo)
  {
    AppMethodBeat.i(286410);
    s.u(parama, "music");
    s.u(paramboo, "songInfo");
    paramboo.songName = parama.field_songName;
    paramboo.rDl = parama.field_songSinger;
    paramboo.ZWR = parama.field_songWebUrl;
    paramboo.ZWQ = parama.field_appId;
    paramboo.musicDataUrl = parama.field_songWifiUrl;
    paramboo.ZWS = parama.field_songHAlbumUrl;
    paramboo.Mcq = parama.field_songLyric;
    paramboo.mLQ = "";
    AppMethodBeat.o(286410);
  }
  
  public static String aPB(String paramString)
  {
    AppMethodBeat.i(286371);
    s.u(paramString, "url");
    com.tencent.mm.plugin.music.model.g localg = com.tencent.mm.plugin.music.model.g.LMs;
    paramString = paramString.getBytes(kotlin.n.d.UTF_8);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = com.tencent.mm.vfs.ah.v(new u(com.tencent.mm.plugin.music.model.g.aOX(s.X("thumb_", com.tencent.mm.b.g.getMessageDigest(paramString)))).jKT());
    s.s(paramString, "VFSFile(MusicFileNameUti…Array())}\")).absolutePath");
    AppMethodBeat.o(286371);
    return paramString;
  }
  
  public static String aPC(String paramString)
  {
    AppMethodBeat.i(286377);
    s.u(paramString, "mediaId");
    com.tencent.mm.plugin.music.model.g localg = com.tencent.mm.plugin.music.model.g.LMs;
    paramString = com.tencent.mm.vfs.ah.v(new u(com.tencent.mm.plugin.music.model.g.aOY(paramString)).jKT());
    s.s(paramString, "VFSFile(MusicFileNameUti…th(mediaId)).absolutePath");
    AppMethodBeat.o(286377);
    return paramString;
  }
  
  public static String b(boo paramboo)
  {
    AppMethodBeat.i(286459);
    s.u(paramboo, "<this>");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("songId: ").append(paramboo.mLQ).append("\n");
    localStringBuffer.append("songName: ").append(paramboo.songName).append("\n");
    localStringBuffer.append("singer: ").append(paramboo.rDl).append("\n");
    localStringBuffer.append("albumName: ").append(paramboo.albumName).append("\n");
    localStringBuffer.append("albumUrl: ").append(paramboo.ZWS).append("\n");
    localStringBuffer.append("genre: ").append(paramboo.ZTA).append("\n");
    localStringBuffer.append("publicTime: ").append(paramboo.ZWU).append("\n");
    localStringBuffer.append("duration: ").append(paramboo.duration).append("\n");
    localStringBuffer.append("dataUrl: ").append(paramboo.musicDataUrl).append("\n");
    localStringBuffer.append("webUrl: ").append(paramboo.ZWR).append("\n");
    localStringBuffer.append("songLyric: ").append(paramboo.Mcq).append("\n");
    paramboo = s.X("FinderMVSongInfo ", localStringBuffer);
    AppMethodBeat.o(286459);
    return paramboo;
  }
  
  public static void d(dtf paramdtf)
  {
    AppMethodBeat.i(286397);
    s.u(paramdtf, "mvData");
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    m localm = d.a.auT(z.bAW());
    Object localObject2;
    int m;
    int k;
    int n;
    int j;
    int i;
    label179:
    label197:
    label223:
    int i1;
    if (localm != null)
    {
      localObject1 = paramdtf.aaYK;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = new FinderContact();
        ((FinderContact)localObject2).username = localm.getUsername();
        ((FinderContact)localObject2).nickname = localm.getNickname();
        ((FinderContact)localObject2).headUrl = localm.amx();
        ((FinderContact)localObject2).signature = localm.getSignature();
        ((FinderContact)localObject2).coverImgUrl = localm.field_coverImg;
        ((FinderContact)localObject2).liveCoverImgUrl = localm.field_liveCoverImg;
        ((FinderContact)localObject2).authInfo = localm.field_authInfo;
        localObject3 = kotlin.ah.aiuX;
        ((FinderObject)localObject1).contact = ((FinderContact)localObject2);
      }
      m = 0;
      k = 0;
      n = 0;
      j = 0;
      localObject1 = paramdtf.aaYK;
      boq localboq;
      Iterator localIterator2;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject3 = paramdtf.ZJp;
        if ((localObject1 == null) || (((bol)localObject1).ZWM != 1)) {
          break label435;
        }
        i = 1;
        if (i == 0) {
          break label486;
        }
        localObject1 = paramdtf.aaYK;
        if (localObject1 != null) {
          break label440;
        }
        localObject1 = null;
        localObject1 = (List)localObject1;
        if (localObject1 == null) {
          break label665;
        }
        Iterator localIterator1 = ((Iterable)localObject1).iterator();
        i = 0;
        i1 = i;
        n = j;
        m = k;
        if (!localIterator1.hasNext()) {
          break label668;
        }
        localboq = (boq)localIterator1.next();
        n = k + localboq.ZWY;
        if (localboq.refObjectId == 0L) {
          break label583;
        }
        i1 = i + localboq.ZWY;
        s.s(localObject3, "refList");
        localIterator2 = ((Iterable)localObject3).iterator();
        m = j;
      }
      label305:
      label435:
      label440:
      label577:
      label581:
      for (;;)
      {
        i = i1;
        j = m;
        k = n;
        if (!localIterator2.hasNext()) {
          break label223;
        }
        localObject1 = (FinderObject)localIterator2.next();
        if (((FinderObject)localObject1).id == localboq.refObjectId)
        {
          i = 1;
          label352:
          if (i == 0) {
            break label561;
          }
          label356:
          if (localObject1 == null) {
            break label565;
          }
          localObject2 = ((FinderObject)localObject1).contact;
          if (localObject2 != null) {
            break label567;
          }
          localObject2 = null;
          label376:
          if (!s.p(localObject2, localm.getUsername())) {
            break label577;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label581;
          }
          m += localboq.ZWY;
          break label305;
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          break;
          i = 0;
          break label179;
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label197;
          }
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label197;
          }
          localObject1 = ((bol)localObject1).ZWL;
          break label197;
          label486:
          localObject1 = paramdtf.aaYK;
          if (localObject1 == null) {
            localObject1 = null;
          }
          for (;;)
          {
            localObject1 = (List)localObject1;
            break;
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((bol)localObject1).ZWI;
              }
            }
          }
          i = 0;
          break label352;
          localObject1 = null;
          break label356;
          break label305;
          localObject2 = ((FinderContact)localObject2).username;
          break label376;
          localObject1 = null;
        }
      }
      label561:
      label565:
      label567:
      label583:
      localObject1 = localboq.ZWZ;
      if (localObject1 != null) {
        if (((CharSequence)localObject1).length() > 0)
        {
          k = 1;
          label610:
          if (k != 1) {
            break label660;
          }
          k = 1;
          label617:
          if (k == 0) {
            break label801;
          }
          k = localboq.ZWY;
          j += localboq.ZWY;
          k = i + k;
          i = j;
          j = k;
        }
      }
    }
    for (;;)
    {
      k = i;
      i = j;
      j = k;
      k = n;
      break;
      k = 0;
      break label610;
      label660:
      k = 0;
      break label617;
      label665:
      i1 = 0;
      label668:
      if (m > 0)
      {
        paramdtf = paramdtf.aaYK;
        if (paramdtf != null) {
          break label779;
        }
        paramdtf = null;
      }
      for (;;)
      {
        if (paramdtf != null)
        {
          localObject1 = new bon();
          ((bon)localObject1).ZWP = (i1 / m);
          ((bon)localObject1).ZWO = (n / m);
          Log.i("MicroMsg.Mv.MvLogic", "createPostData completion:" + ((bon)localObject1).ZWP + ", orignality:" + ((bon)localObject1).ZWO);
          localObject2 = kotlin.ah.aiuX;
          paramdtf.LXo = ((bon)localObject1);
        }
        AppMethodBeat.o(286397);
        return;
        label779:
        paramdtf = paramdtf.objectDesc;
        if (paramdtf == null) {
          paramdtf = null;
        } else {
          paramdtf = paramdtf.mvInfo;
        }
      }
      label801:
      k = j;
      j = i;
      i = k;
    }
  }
  
  public static boolean e(f paramf)
  {
    AppMethodBeat.i(286416);
    s.u(paramf, "musicMv");
    if (paramf.LXs == 1)
    {
      AppMethodBeat.o(286416);
      return true;
    }
    if (paramf.LXs == 4)
    {
      AppMethodBeat.o(286416);
      return true;
    }
    AppMethodBeat.o(286416);
    return false;
  }
  
  public static boolean k(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(286426);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(286426);
      return false;
    }
    if (paramImageView == null)
    {
      AppMethodBeat.o(286426);
      return false;
    }
    localObject = new StringBuilder();
    com.tencent.mm.plugin.music.model.g localg = com.tencent.mm.plugin.music.model.g.LMs;
    paramString = com.tencent.mm.plugin.music.model.g.gnY() + paramString + ".png";
    if (!y.ZC(paramString))
    {
      Log.i("MicroMsg.Mv.MvLogic", "appId icon isnot exist");
      AppMethodBeat.o(286426);
      return false;
    }
    localObject = new c.a();
    ((c.a)localObject).oKn = true;
    ((c.a)localObject).oKs = 1;
    localObject = ((c.a)localObject).bKx();
    s.s(localObject, "Builder().setCacheInMemo…ns.LoadFrom.FILE).build()");
    r.bKe().a(paramString, paramImageView, (c)localObject, (h)new a.a());
    AppMethodBeat.o(286426);
    return true;
  }
  
  public static String sH(long paramLong)
  {
    AppMethodBeat.i(286446);
    String str = s.X("local_", Long.valueOf(paramLong));
    AppMethodBeat.o(286446);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a
 * JD-Core Version:    0.7.0.1
 */