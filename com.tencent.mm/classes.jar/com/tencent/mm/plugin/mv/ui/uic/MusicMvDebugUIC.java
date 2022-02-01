package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.mv.a.a.n;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.ui.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "copySongInfo", "genCgiInfo", "genMvHeadInfo", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "genMvRefObjInfo", "genMvTrackInfo", "longClickMoreMenu", "", "Companion", "plugin-mv_release"})
public final class MusicMvDebugUIC
  extends UIComponent
{
  public static final a Att;
  public final String TAG;
  
  static
  {
    AppMethodBeat.i(257119);
    Att = new a((byte)0);
    AppMethodBeat.o(257119);
  }
  
  public MusicMvDebugUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257118);
    this.TAG = "MicroMsg.Mv.MusicMvDebugUIC";
    AppMethodBeat.o(257118);
  }
  
  public static String gFm()
  {
    AppMethodBeat.i(258909);
    Map localMap = ae.e(new o[] { new o(Integer.valueOf(5286), "NetSceneMusicMvCheckPermission"), new o(Integer.valueOf(3710), "NetSceneMusicMvFinderLike"), new o(Integer.valueOf(5904), "NetSceneMusicMvGetBeatTrack"), new o(Integer.valueOf(6860), "NetSceneMusicMvGetRecommendList"), new o(Integer.valueOf(3966), "NetSceneMusicMvGetFinderFavFeed"), new o(Integer.valueOf(3763), "NetSceneMusicMvGetFinderFeedDetail"), new o(Integer.valueOf(3965), "NetSceneMusicMvGetFinderLikeFeed"), new o(Integer.valueOf(5292), "NetSceneMusicMvGetSongStatus"), new o(Integer.valueOf(6820), "NetSceneMusicMvHeartbeat"), new o(Integer.valueOf(6893), "NetSceneMusicMvJoin"), new o(Integer.valueOf(6672), "NetSceneMusicMvPostLiveMsg") });
    JSONObject localJSONObject = new JSONObject();
    Object localObject = com.tencent.mm.plugin.mv.a.a.m.UqI;
    Iterator localIterator = ((Map)com.tencent.mm.plugin.mv.a.a.m.gFf()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localMap.get(localEntry.getKey());
      localObject = str;
      if (str == null) {
        localObject = String.valueOf(((Number)localEntry.getKey()).intValue());
      }
      localJSONObject.put((String)localObject, ((n)localEntry.getValue()).toString());
    }
    localObject = localJSONObject.toString();
    p.g(localObject, "cgiInfoObj.toString()");
    AppMethodBeat.o(258909);
    return localObject;
  }
  
  public static String l(e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(258906);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("localId", parame.ApB);
    localJSONObject.put("localCoverPath", parame.ApD);
    localJSONObject.put("mvObjectId", parame.ApE);
    Object localObject1 = parame.ApE;
    long l;
    if (localObject1 != null)
    {
      l = ((Long)localObject1).longValue();
      localJSONObject.put("unsignedMvObjectId", d.zs(l));
      localJSONObject.put("mvObjectNonceId", parame.ApF);
      localJSONObject.put("mvMakerNickName", parame.ApG);
      localObject1 = parame.ApJ;
      if (localObject1 == null) {
        break label256;
      }
    }
    label256:
    for (localObject1 = ((FinderContact)localObject1).username;; localObject1 = null)
    {
      localJSONObject.put("mvMakerUsername", localObject1);
      localJSONObject.put("coverUrl", parame.coverUrl);
      localJSONObject.put("likeCount", parame.likeCount);
      localJSONObject.put("forwardCount", parame.forwardCount);
      localJSONObject.put("commentCount", parame.commentCount);
      localJSONObject.put("mvPostStatus", parame.ApM);
      localJSONObject.put("isDelete", parame.tav);
      localObject1 = parame.ApI;
      parame = localObject2;
      if (localObject1 != null) {
        parame = Float.valueOf(((axx)localObject1).LIe);
      }
      localJSONObject.put("originality", parame);
      parame = localJSONObject.toString();
      p.g(parame, "mvHeadInfo.toString()");
      AppMethodBeat.o(258906);
      return parame;
      l = 0L;
      break;
    }
  }
  
  public static String m(e parame)
  {
    AppMethodBeat.i(258907);
    JSONArray localJSONArray = new JSONArray();
    parame = (Iterable)parame.ApH;
    int i = 0;
    parame = parame.iterator();
    while (parame.hasNext())
    {
      Object localObject = parame.next();
      if (i < 0) {
        j.hxH();
      }
      localObject = (axz)localObject;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", i);
      localJSONObject.put("refObjectId", ((axz)localObject).refObjectId);
      localJSONObject.put("unsignedRefObjectId", d.zs(((axz)localObject).refObjectId));
      localJSONObject.put("refNonceId", ((axz)localObject).LIm);
      localJSONObject.put("timeOffsetInMvMs", ((axz)localObject).Ghu);
      localJSONObject.put("timeLengthInMvMs", ((axz)localObject).LIl);
      localJSONObject.put("timeOffsetInClipMs", ((axz)localObject).Ghw);
      localJSONObject.put("isFirstUpload", ((axz)localObject).UtY);
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    parame = localJSONArray.toString();
    p.g(parame, "trackInfoList.toString()");
    AppMethodBeat.o(258907);
    return parame;
  }
  
  public static String n(e parame)
  {
    AppMethodBeat.i(258908);
    JSONArray localJSONArray = new JSONArray();
    parame = (Iterable)parame.ApL;
    int i = 0;
    Iterator localIterator = parame.iterator();
    if (localIterator.hasNext())
    {
      parame = localIterator.next();
      if (i < 0) {
        j.hxH();
      }
      FinderObject localFinderObject = (FinderObject)parame;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", i);
      localJSONObject.put("id", localFinderObject.id);
      localJSONObject.put("unsignedId", d.zs(localFinderObject.id));
      localJSONObject.put("objectNonceId", localFinderObject.objectNonceId);
      parame = localFinderObject.contact;
      if (parame != null)
      {
        parame = parame.username;
        label139:
        localJSONObject.put("username", parame);
        parame = localFinderObject.contact;
        if (parame == null) {
          break label429;
        }
        parame = parame.nickname;
        label164:
        localJSONObject.put("nickname", parame);
        if (localFinderObject.id == 0L) {
          break label434;
        }
      }
      label429:
      label434:
      for (parame = "video_" + localFinderObject.id;; parame = "video_" + localFinderObject.objectNonceId)
      {
        localJSONObject.put("mediaId", parame);
        a locala = a.ArA;
        localJSONObject.put("videoPath", a.aIp(parame));
        parame = localFinderObject.objectDesc;
        if (parame != null)
        {
          parame = parame.media;
          if (parame != null)
          {
            parame = (FinderMedia)j.kt((List)parame);
            if (parame != null)
            {
              localJSONObject.put("video_url", parame.url + parame.url_token);
              localJSONObject.put("decodeKey", parame.decodeKey);
              localJSONObject.put("fileSize", parame.fileSize);
              localJSONObject.put("width", Float.valueOf(parame.width));
              localJSONObject.put("height", Float.valueOf(parame.height));
              localJSONObject.put("videoDuration", parame.videoDuration);
              localJSONObject.put("mediaType", parame.mediaType);
              localJSONObject.put("bitrate", parame.bitrate);
              localJSONObject.put("coverUrl", parame.coverUrl);
            }
          }
        }
        localJSONArray.put(localJSONObject);
        i += 1;
        break;
        parame = null;
        break label139;
        parame = null;
        break label164;
      }
    }
    parame = localJSONArray.toString();
    p.g(parame, "refInfoList.toString()");
    AppMethodBeat.o(258908);
    return parame;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDebugUIC$Companion;", "", "()V", "MENU_ID_DEBUG_CLEAR_CACHE", "", "MENU_ID_DEBUG_MV_CGI_INFO", "MENU_ID_DEBUG_MV_HEAD_INFO", "MENU_ID_DEBUG_MV_REF_OBJ_LIST_INFO", "MENU_ID_DEBUG_MV_TRACK_LIST_INFO", "MENU_ID_DEBUG_SONG_INFO", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class c
    implements o.f
  {
    public c(MusicMvDebugUIC paramMusicMvDebugUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(258902);
      paramm.a(1201, (CharSequence)this.Atu.getContext().getString(2131758266), 2131689842, this.Atu.getContext().getResources().getColor(2131099710), false);
      AppMethodBeat.o(258902);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC
 * JD-Core Version:    0.7.0.1
 */