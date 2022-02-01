package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.a.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "copySongInfo", "Lorg/json/JSONObject;", "genCgiInfo", "genMvHeadInfo", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "genMvRefObjInfo", "Lorg/json/JSONArray;", "genMvTrackInfo", "longClickMoreMenu", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  public static final f.a Mek;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(287819);
    Mek = new f.a((byte)0);
    AppMethodBeat.o(287819);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287693);
    this.TAG = "MicroMsg.Mv.MusicMvDebugUIC";
    AppMethodBeat.o(287693);
  }
  
  private static final void a(f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(287768);
    kotlin.g.b.s.u(paramf, "this$0");
    params.a(1101, (CharSequence)paramf.getContext().getString(b.h.LVS), b.g.bottomsheet_icon_star, paramf.getContext().getResources().getColor(b.b.Brand), false);
    params.a(1102, (CharSequence)paramf.getContext().getString(b.h.LVU), b.g.bottomsheet_icon_star, paramf.getContext().getResources().getColor(b.b.Brand), false);
    params.a(1103, (CharSequence)paramf.getContext().getString(b.h.LVW), b.g.bottomsheet_icon_star, paramf.getContext().getResources().getColor(b.b.Brand), false);
    params.a(1104, (CharSequence)paramf.getContext().getString(b.h.LVV), b.g.bottomsheet_icon_star, paramf.getContext().getResources().getColor(b.b.Brand), false);
    params.a(1105, (CharSequence)paramf.getContext().getString(b.h.LVT), b.g.bottomsheet_icon_star, paramf.getContext().getResources().getColor(b.b.Brand), false);
    AppMethodBeat.o(287768);
  }
  
  private static final void a(f paramf, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONObject paramJSONObject3, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(287802);
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramJSONObject1, "$songInfoText");
    kotlin.g.b.s.u(paramJSONObject2, "$mvHeadInfoText");
    kotlin.g.b.s.u(paramJSONArray1, "$mvTrackInfoText");
    kotlin.g.b.s.u(paramJSONArray2, "$mvRefObjInfoText");
    kotlin.g.b.s.u(paramJSONObject3, "$cgiInfo");
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(287802);
      return;
    case 1201: 
      paramJSONObject1 = g.LMs;
      y.ew(g.gnZ(), true);
      paramf.getActivity().finish();
      Toast.makeText((Context)paramf.getActivity(), b.h.app_clear_ok, 0).show();
      AppMethodBeat.o(287802);
      return;
    }
    paramf = "music_mv_info_" + com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd_HH_mm_ss", System.currentTimeMillis() / 1000L) + ".json";
    paramMenuItem = new JSONObject();
    try
    {
      paramMenuItem.put("songInfoText", paramJSONObject1);
      paramMenuItem.put("mvHeadInfoText", paramJSONObject2);
      paramMenuItem.put("mvTrackInfoText", paramJSONArray1);
      paramMenuItem.put("mvRefObjInfoText", paramJSONArray2);
      paramMenuItem.put("cgiInfo", paramJSONObject3);
      return;
    }
    finally
    {
      paramJSONObject2 = (com.tencent.mm.plugin.repairer.a)h.az(com.tencent.mm.plugin.repairer.a.class);
      paramJSONArray1 = paramMenuItem.toString();
      kotlin.g.b.s.s(paramJSONArray1, "saveObj.toString()");
      paramJSONArray1 = paramJSONArray1.getBytes(kotlin.n.d.UTF_8);
      kotlin.g.b.s.s(paramJSONArray1, "(this as java.lang.String).getBytes(charset)");
      paramJSONObject2.saveRepairerFile(paramf, paramJSONArray1, true);
      AppMethodBeat.o(287802);
    }
  }
  
  private static final void a(JSONObject paramJSONObject1, f paramf, JSONObject paramJSONObject2, JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONObject paramJSONObject3, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(287789);
    kotlin.g.b.s.u(paramJSONObject1, "$songInfoText");
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramJSONObject2, "$mvHeadInfoText");
    kotlin.g.b.s.u(paramJSONArray1, "$mvTrackInfoText");
    kotlin.g.b.s.u(paramJSONArray2, "$mvRefObjInfoText");
    kotlin.g.b.s.u(paramJSONObject3, "$cgiInfo");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287789);
      return;
      ClipboardHelper.setText((CharSequence)paramJSONObject1.toString());
      Toast.makeText((Context)paramf.getActivity(), b.h.app_copy_ok, 0).show();
      AppMethodBeat.o(287789);
      return;
      ClipboardHelper.setText((CharSequence)paramJSONObject2.toString());
      Toast.makeText((Context)paramf.getActivity(), b.h.app_copy_ok, 0).show();
      AppMethodBeat.o(287789);
      return;
      ClipboardHelper.setText((CharSequence)paramJSONArray1.toString());
      Toast.makeText((Context)paramf.getActivity(), b.h.app_copy_ok, 0).show();
      AppMethodBeat.o(287789);
      return;
      ClipboardHelper.setText((CharSequence)paramJSONArray2.toString());
      Toast.makeText((Context)paramf.getActivity(), b.h.app_copy_ok, 0).show();
      AppMethodBeat.o(287789);
      return;
      ClipboardHelper.setText((CharSequence)paramJSONObject3.toString());
      Toast.makeText((Context)paramf.getActivity(), b.h.app_copy_ok, 0).show();
    }
  }
  
  private static final void b(f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(287778);
    kotlin.g.b.s.u(paramf, "this$0");
    params.a(1201, (CharSequence)paramf.getContext().getString(b.h.LVQ), b.g.bottomsheet_icon_star, paramf.getContext().getResources().getColor(b.b.Brand), false);
    params.a(1202, (CharSequence)paramf.getContext().getString(b.h.LVR), b.g.bottomsheet_icon_star, paramf.getContext().getResources().getColor(b.b.Brand), false);
    AppMethodBeat.o(287778);
  }
  
  private static JSONArray g(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(287707);
    JSONArray localJSONArray = new JSONArray();
    paramf = (Iterable)paramf.LXm;
    int i = 0;
    paramf = paramf.iterator();
    while (paramf.hasNext())
    {
      Object localObject = paramf.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (boq)localObject;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", i);
      localJSONObject.put("refObjectId", ((boq)localObject).refObjectId);
      localJSONObject.put("unsignedRefObjectId", com.tencent.mm.ae.d.hF(((boq)localObject).refObjectId));
      localJSONObject.put("refNonceId", ((boq)localObject).ZWZ);
      localJSONObject.put("timeOffsetInMvMs", ((boq)localObject).TBM);
      localJSONObject.put("timeLengthInMvMs", ((boq)localObject).ZWY);
      localJSONObject.put("timeOffsetInClipMs", ((boq)localObject).TBO);
      localJSONObject.put("isFirstUpload", ((boq)localObject).ZXa);
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    AppMethodBeat.o(287707);
    return localJSONArray;
  }
  
  private static JSONObject gqE()
  {
    AppMethodBeat.i(287753);
    Map localMap = ak.e(new r[] { new r(Integer.valueOf(5286), "NetSceneMusicMvCheckPermission"), new r(Integer.valueOf(3710), "NetSceneMusicMvFinderLike"), new r(Integer.valueOf(5904), "NetSceneMusicMvGetBeatTrack"), new r(Integer.valueOf(6860), "NetSceneMusicMvGetRecommendList"), new r(Integer.valueOf(3966), "NetSceneMusicMvGetFinderFavFeed"), new r(Integer.valueOf(3763), "NetSceneMusicMvGetFinderFeedDetail"), new r(Integer.valueOf(3965), "NetSceneMusicMvGetFinderLikeFeed"), new r(Integer.valueOf(5292), "NetSceneMusicMvGetSongStatus"), new r(Integer.valueOf(6820), "NetSceneMusicMvHeartbeat"), new r(Integer.valueOf(6893), "NetSceneMusicMvJoin"), new r(Integer.valueOf(6672), "NetSceneMusicMvPostLiveMsg") });
    JSONObject localJSONObject = new JSONObject();
    Object localObject = com.tencent.mm.plugin.mv.model.a.a.LYz;
    Iterator localIterator = ((Map)com.tencent.mm.plugin.mv.model.a.a.gpO()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localMap.get(localEntry.getKey());
      localObject = str;
      if (str == null) {
        localObject = String.valueOf(((Number)localEntry.getKey()).intValue());
      }
      localJSONObject.put((String)localObject, ((c)localEntry.getValue()).toString());
    }
    AppMethodBeat.o(287753);
    return localJSONObject;
  }
  
  private static final void gqF() {}
  
  private static JSONArray h(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(287735);
    JSONArray localJSONArray = new JSONArray();
    paramf = (Iterable)paramf.LXr;
    int i = 0;
    Iterator localIterator = paramf.iterator();
    if (localIterator.hasNext())
    {
      paramf = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      FinderObject localFinderObject = (FinderObject)paramf;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", i);
      localJSONObject.put("id", localFinderObject.id);
      localJSONObject.put("unsignedId", com.tencent.mm.ae.d.hF(localFinderObject.id));
      localJSONObject.put("objectNonceId", localFinderObject.objectNonceId);
      paramf = localFinderObject.contact;
      if (paramf == null)
      {
        paramf = null;
        label136:
        localJSONObject.put("username", paramf);
        paramf = localFinderObject.contact;
        if (paramf != null) {
          break label407;
        }
        paramf = null;
        label158:
        localJSONObject.put("nickname", paramf);
        if (localFinderObject.id == 0L) {
          break label415;
        }
      }
      label407:
      label415:
      for (paramf = kotlin.g.b.s.X("video_", Long.valueOf(localFinderObject.id));; paramf = kotlin.g.b.s.X("video_", localFinderObject.objectNonceId))
      {
        localJSONObject.put("mediaId", paramf);
        com.tencent.mm.plugin.mv.ui.a locala = com.tencent.mm.plugin.mv.ui.a.Maz;
        localJSONObject.put("videoPath", com.tencent.mm.plugin.mv.ui.a.aPC(paramf));
        paramf = localFinderObject.objectDesc;
        if (paramf != null)
        {
          paramf = paramf.media;
          if (paramf != null)
          {
            paramf = (FinderMedia)p.oL((List)paramf);
            if (paramf != null)
            {
              localJSONObject.put("video_url", kotlin.g.b.s.X(paramf.url, paramf.url_token));
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
        paramf = paramf.username;
        break label136;
        paramf = paramf.nickname;
        break label158;
      }
    }
    AppMethodBeat.o(287735);
    return localJSONArray;
  }
  
  public final void f(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(287896);
    kotlin.g.b.s.u(paramf, "musicMv");
    Object localObject1 = com.tencent.mm.util.d.agsY;
    Object localObject3;
    JSONObject localJSONObject;
    label285:
    label326:
    Object localObject2;
    long l;
    if (com.tencent.mm.util.d.jJv())
    {
      localObject1 = k.aeZF;
      localObject3 = ((e)k.d(getActivity()).q(e.class)).LWI;
      localJSONObject = new JSONObject();
      localJSONObject.put("songId", ((boo)localObject3).mLQ);
      localJSONObject.put("songName", ((boo)localObject3).songName);
      localJSONObject.put("singer", ((boo)localObject3).rDl);
      localJSONObject.put("albumName", ((boo)localObject3).albumName);
      localJSONObject.put("albumUrl", ((boo)localObject3).ZWS);
      localJSONObject.put("musicWebUrl", ((boo)localObject3).ZWR);
      localJSONObject.put("musicDataUrl", ((boo)localObject3).musicDataUrl);
      localJSONObject.put("genre", ((boo)localObject3).ZTA);
      localJSONObject.put("publicTime", ((boo)localObject3).ZWT);
      localJSONObject.put("musicAppId", ((boo)localObject3).ZWQ);
      localJSONObject.put("publicTimeS", ((boo)localObject3).ZWU);
      localJSONObject.put("extraInfo", ((boo)localObject3).extraInfo);
      localJSONObject.put("identification", ((boo)localObject3).identification);
      localObject1 = ((boo)localObject3).ZWW;
      if (localObject1 != null) {
        break label807;
      }
      localObject1 = "";
      localJSONObject.put("operationUrl", localObject1);
      localObject1 = j.gnw().gnj();
      if (localObject1 != null) {
        break label831;
      }
      localObject1 = null;
      localJSONObject.put("duration", localObject1);
      localJSONObject.put("musicDuration", ((boo)localObject3).duration);
      localObject1 = j.gnw().gnj();
      if (localObject1 != null) {
        break label846;
      }
      localObject1 = null;
      localJSONObject.put("currentPosition", localObject1);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("localId", paramf.LXg);
      ((JSONObject)localObject2).put("localCoverPath", paramf.LXi);
      ((JSONObject)localObject2).put("mvObjectId", paramf.LXj);
      localObject1 = paramf.LXj;
      if (localObject1 != null) {
        break label861;
      }
      l = 0L;
      label398:
      ((JSONObject)localObject2).put("unsignedMvObjectId", com.tencent.mm.ae.d.hF(l));
      ((JSONObject)localObject2).put("mvObjectNonceId", paramf.LXk);
      ((JSONObject)localObject2).put("mvMakerNickName", paramf.LXl);
      localObject1 = paramf.LXp;
      if (localObject1 != null) {
        break label870;
      }
      localObject1 = null;
      label451:
      ((JSONObject)localObject2).put("mvMakerUsername", localObject1);
      ((JSONObject)localObject2).put("coverUrl", paramf.coverUrl);
      ((JSONObject)localObject2).put("likeCount", paramf.likeCount);
      ((JSONObject)localObject2).put("forwardCount", paramf.forwardCount);
      ((JSONObject)localObject2).put("commentCount", paramf.commentCount);
      ((JSONObject)localObject2).put("mvPostStatus", paramf.LXs);
      ((JSONObject)localObject2).put("isDelete", paramf.AcH);
      localObject1 = paramf.LXo;
      if (localObject1 != null) {
        break label880;
      }
      localObject1 = null;
      label554:
      ((JSONObject)localObject2).put("originality", localObject1);
      localObject1 = paramf.LXo;
      if (localObject1 != null) {
        break label893;
      }
    }
    label807:
    label831:
    label846:
    label861:
    label870:
    label880:
    label893:
    for (localObject1 = null;; localObject1 = Float.valueOf(((bon)localObject1).ZWP))
    {
      ((JSONObject)localObject2).put("completion", localObject1);
      localObject1 = g(paramf);
      paramf = h(paramf);
      localObject3 = gqE();
      com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 0, false);
      localf.Vtg = new f..ExternalSyntheticLambda1(this);
      localf.GAz = new f..ExternalSyntheticLambda0(this);
      localf.GAC = new f..ExternalSyntheticLambda3(localJSONObject, this, (JSONObject)localObject2, (JSONArray)localObject1, paramf, (JSONObject)localObject3);
      localf.agem = new f..ExternalSyntheticLambda2(this, localJSONObject, (JSONObject)localObject2, (JSONArray)localObject1, paramf, (JSONObject)localObject3);
      localf.aeLi = f..ExternalSyntheticLambda4.INSTANCE;
      localf.dDn();
      Log.e(this.TAG, "MV START####################################################START");
      Log.e(this.TAG, kotlin.g.b.s.X("songInfoText: ", localJSONObject));
      Log.e(this.TAG, kotlin.g.b.s.X("mvHeadInfoText: ", localObject2));
      Log.e(this.TAG, kotlin.g.b.s.X("mvTrackInfoText: ", localObject1));
      Log.e(this.TAG, kotlin.g.b.s.X("mvRefObjInfoText: ", paramf));
      Log.e(this.TAG, kotlin.g.b.s.X("cgiInfo: ", paramf));
      Log.e(this.TAG, "MV END  ####################################################  END");
      AppMethodBeat.o(287896);
      return;
      localObject2 = ((bop)localObject1).ZWX;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.music.e.a.d)localObject1).getDuration());
      break label285;
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.music.e.a.d)localObject1).gmA());
      break label326;
      l = ((Long)localObject1).longValue();
      break label398;
      localObject1 = ((FinderContact)localObject1).username;
      break label451;
      localObject1 = Float.valueOf(((bon)localObject1).ZWO);
      break label554;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.f
 * JD-Core Version:    0.7.0.1
 */