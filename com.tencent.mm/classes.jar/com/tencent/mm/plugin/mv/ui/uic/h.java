package com.tencent.mm.plugin.mv.ui.uic;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.mv.model.a.b;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "copySongInfo", "Lorg/json/JSONObject;", "genCgiInfo", "genMvHeadInfo", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "genMvRefObjInfo", "Lorg/json/JSONArray;", "genMvTrackInfo", "longClickMoreMenu", "", "Companion", "plugin-mv_release"})
public final class h
  extends UIComponent
{
  public static final a Gja;
  final String TAG;
  
  static
  {
    AppMethodBeat.i(225927);
    Gja = new a((byte)0);
    AppMethodBeat.o(225927);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(225926);
    this.TAG = "MicroMsg.Mv.MusicMvDebugUIC";
    AppMethodBeat.o(225926);
  }
  
  static JSONObject fgW()
  {
    AppMethodBeat.i(225924);
    Map localMap = ae.e(new o[] { new o(Integer.valueOf(5286), "NetSceneMusicMvCheckPermission"), new o(Integer.valueOf(3710), "NetSceneMusicMvFinderLike"), new o(Integer.valueOf(5904), "NetSceneMusicMvGetBeatTrack"), new o(Integer.valueOf(6860), "NetSceneMusicMvGetRecommendList"), new o(Integer.valueOf(3966), "NetSceneMusicMvGetFinderFavFeed"), new o(Integer.valueOf(3763), "NetSceneMusicMvGetFinderFeedDetail"), new o(Integer.valueOf(3965), "NetSceneMusicMvGetFinderLikeFeed"), new o(Integer.valueOf(5292), "NetSceneMusicMvGetSongStatus"), new o(Integer.valueOf(6820), "NetSceneMusicMvHeartbeat"), new o(Integer.valueOf(6893), "NetSceneMusicMvJoin"), new o(Integer.valueOf(6672), "NetSceneMusicMvPostLiveMsg") });
    JSONObject localJSONObject = new JSONObject();
    Object localObject = com.tencent.mm.plugin.mv.model.a.a.GcY;
    Iterator localIterator = ((Map)com.tencent.mm.plugin.mv.model.a.a.fgn()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localMap.get(localEntry.getKey());
      localObject = str;
      if (str == null) {
        localObject = String.valueOf(((Number)localEntry.getKey()).intValue());
      }
      localJSONObject.put((String)localObject, ((b)localEntry.getValue()).toString());
    }
    AppMethodBeat.o(225924);
    return localJSONObject;
  }
  
  static JSONArray g(f paramf)
  {
    AppMethodBeat.i(225913);
    JSONArray localJSONArray = new JSONArray();
    paramf = (Iterable)paramf.Gbo;
    int i = 0;
    paramf = paramf.iterator();
    while (paramf.hasNext())
    {
      Object localObject = paramf.next();
      if (i < 0) {
        j.iBO();
      }
      localObject = (bdt)localObject;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", i);
      localJSONObject.put("refObjectId", ((bdt)localObject).refObjectId);
      localJSONObject.put("unsignedRefObjectId", d.Fw(((bdt)localObject).refObjectId));
      localJSONObject.put("refNonceId", ((bdt)localObject).SOS);
      localJSONObject.put("timeOffsetInMvMs", ((bdt)localObject).MSE);
      localJSONObject.put("timeLengthInMvMs", ((bdt)localObject).SOR);
      localJSONObject.put("timeOffsetInClipMs", ((bdt)localObject).MSG);
      localJSONObject.put("isFirstUpload", ((bdt)localObject).SOT);
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    AppMethodBeat.o(225913);
    return localJSONArray;
  }
  
  static JSONArray h(f paramf)
  {
    AppMethodBeat.i(225921);
    JSONArray localJSONArray = new JSONArray();
    paramf = (Iterable)paramf.Gbt;
    int i = 0;
    Iterator localIterator = paramf.iterator();
    if (localIterator.hasNext())
    {
      paramf = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      FinderObject localFinderObject = (FinderObject)paramf;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", i);
      localJSONObject.put("id", localFinderObject.id);
      localJSONObject.put("unsignedId", d.Fw(localFinderObject.id));
      localJSONObject.put("objectNonceId", localFinderObject.objectNonceId);
      paramf = localFinderObject.contact;
      if (paramf != null)
      {
        paramf = paramf.username;
        label137:
        localJSONObject.put("username", paramf);
        paramf = localFinderObject.contact;
        if (paramf == null) {
          break label428;
        }
        paramf = paramf.nickname;
        label162:
        localJSONObject.put("nickname", paramf);
        if (localFinderObject.id == 0L) {
          break label433;
        }
      }
      label428:
      label433:
      for (paramf = "video_" + localFinderObject.id;; paramf = "video_" + localFinderObject.objectNonceId)
      {
        localJSONObject.put("mediaId", paramf);
        com.tencent.mm.plugin.mv.ui.a locala = com.tencent.mm.plugin.mv.ui.a.Gfi;
        localJSONObject.put("videoPath", com.tencent.mm.plugin.mv.ui.a.aSI(paramf));
        paramf = localFinderObject.objectDesc;
        if (paramf != null)
        {
          paramf = paramf.media;
          if (paramf != null)
          {
            paramf = (FinderMedia)j.lp((List)paramf);
            if (paramf != null)
            {
              localJSONObject.put("video_url", paramf.url + paramf.url_token);
              localJSONObject.put("decodeKey", paramf.decodeKey);
              localJSONObject.put("fileSize", paramf.fileSize);
              localJSONObject.put("width", Float.valueOf(paramf.width));
              localJSONObject.put("height", Float.valueOf(paramf.height));
              localJSONObject.put("videoDuration", paramf.videoDuration);
              localJSONObject.put("mediaType", paramf.mediaType);
              localJSONObject.put("bitrate", paramf.bitrate);
              localJSONObject.put("coverUrl", paramf.coverUrl);
            }
          }
        }
        localJSONArray.put(localJSONObject);
        i += 1;
        break;
        paramf = null;
        break label137;
        paramf = null;
        break label162;
      }
    }
    AppMethodBeat.o(225921);
    return localJSONArray;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDebugUIC$Companion;", "", "()V", "MENU_ID_DEBUG_CLEAR_CACHE", "", "MENU_ID_DEBUG_EXPORT_FILE", "MENU_ID_DEBUG_MV_CGI_INFO", "MENU_ID_DEBUG_MV_HEAD_INFO", "MENU_ID_DEBUG_MV_REF_OBJ_LIST_INFO", "MENU_ID_DEBUG_MV_TRACK_LIST_INFO", "MENU_ID_DEBUG_SONG_INFO", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.h
 * JD-Core Version:    0.7.0.1
 */