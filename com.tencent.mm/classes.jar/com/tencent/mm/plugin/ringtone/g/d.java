package com.tencent.mm.plugin.ringtone.g;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.plugin.ringtone.i.a.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.q;
import com.tencent.mm.protocal.protobuf.a.u;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.protocal.protobuf.a.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "", "()V", "info", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "startTs", "", "endTs", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;JJ)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;JJLcom/tencent/mm/protocal/protobuf/FinderObject;)V", "hashCode", "", "detailRaw", "Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;", "duration", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;JJLcom/tencent/mm/protocal/protobuf/FinderObject;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;J)V", "channelId", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "cover", "getCover", "setCover", "createTime", "getCreateTime", "()J", "setCreateTime", "(J)V", "finderNonceId", "getFinderNonceId", "setFinderNonceId", "finderObjectId", "getFinderObjectId", "setFinderObjectId", "mDetailRaw", "getMDetailRaw", "()Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;", "setMDetailRaw", "(Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;)V", "mDuration", "getMDuration", "setMDuration", "mEndTime", "getMEndTime", "setMEndTime", "mFinderObject", "getMFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setMFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "mHashCode", "getMHashCode", "setMHashCode", "mInfo", "getMInfo", "()Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "setMInfo", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;)V", "mSingerName", "getMSingerName", "setMSingerName", "mSongName", "getMSongName", "setMSongName", "mStartTime", "getMStartTime", "setMStartTime", "mVibrateInfo", "Lcom/tencent/mm/protocal/protobuf/ringtone/VibrationInfo;", "getMVibrateInfo", "()Lcom/tencent/mm/protocal/protobuf/ringtone/VibrationInfo;", "setMVibrateInfo", "(Lcom/tencent/mm/protocal/protobuf/ringtone/VibrationInfo;)V", "musicSid", "", "getMusicSid", "()I", "setMusicSid", "(I)V", "ringtoneSource", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneSource;", "getRingtoneSource", "()Lcom/tencent/mm/plugin/ringtone/params/RingtoneSource;", "setRingtoneSource", "(Lcom/tencent/mm/plugin/ringtone/params/RingtoneSource;)V", "tryFinderAudio", "", "getTryFinderAudio", "()Z", "setTryFinderAudio", "(Z)V", "unAvailable", "getUnAvailable", "setUnAvailable", "checkIfChannelValid", "getMediaId", "getRingtonePath", "getVibrateInfo", "Lcom/tencent/mm/plugin/ringtoneapi/api/VibrateDescInfo;", "setRingtonePath", "", "path", "toJson", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a ODu;
  public String LYS;
  public boolean OBU;
  public String ODA;
  public c ODB;
  public int ODC;
  public com.tencent.mm.protocal.protobuf.a.ah ODD;
  public boolean ODE;
  public com.tencent.mm.plugin.thumbplayer.a.b ODv;
  public FinderObject ODw;
  String ODx;
  public aa ODy;
  public String ODz;
  public String channelId;
  public long createTime;
  public long mDuration;
  public long mEndTime;
  public long mIH;
  public long mStartTime;
  public String nUM;
  
  static
  {
    AppMethodBeat.i(272861);
    ODu = new a((byte)0);
    AppMethodBeat.o(272861);
  }
  
  public d()
  {
    this.channelId = "";
    this.ODB = c.ODp;
    this.LYS = "";
  }
  
  public d(com.tencent.mm.plugin.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(272857);
    this.channelId = "";
    this.ODB = c.ODp;
    this.LYS = "";
    this.ODv = paramb;
    this.mStartTime = 0L;
    this.mEndTime = 9223372036854775807L;
    AppMethodBeat.o(272857);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(272872);
    s.u(paramc, "<set-?>");
    this.ODB = paramc;
    AppMethodBeat.o(272872);
  }
  
  public final void aUx(String paramString)
  {
    AppMethodBeat.i(272867);
    s.u(paramString, "<set-?>");
    this.channelId = paramString;
    AppMethodBeat.o(272867);
  }
  
  public final void aUy(String paramString)
  {
    AppMethodBeat.i(272875);
    s.u(paramString, "<set-?>");
    this.LYS = paramString;
    AppMethodBeat.o(272875);
  }
  
  public final String gOC()
  {
    Object localObject = this.ODv;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).path;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final com.tencent.mm.plugin.aj.a.a gOD()
  {
    Object localObject2 = null;
    AppMethodBeat.i(272895);
    com.tencent.mm.plugin.aj.a.a locala = new com.tencent.mm.plugin.aj.a.a();
    Object localObject1 = this.ODv;
    if (localObject1 == null)
    {
      localObject1 = null;
      locala.fileName = ((String)localObject1);
      localObject1 = this.ODD;
      if (localObject1 != null) {
        break label62;
      }
    }
    label62:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.protocal.protobuf.a.ah)localObject1).acjx)
    {
      locala.fileUrl = ((String)localObject1);
      AppMethodBeat.o(272895);
      return locala;
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId;
      break;
    }
  }
  
  public final boolean gOE()
  {
    AppMethodBeat.i(272909);
    Object localObject = MMApplicationContext.getContext().getSystemService("notification");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(272909);
      throw ((Throwable)localObject);
    }
    localObject = (NotificationManager)localObject;
    if (Build.VERSION.SDK_INT >= 26) {
      for (;;)
      {
        try
        {
          localObject = ((NotificationManager)localObject).getNotificationChannel(this.channelId);
          if (localObject == null) {
            continue;
          }
          bool = true;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.TPMediaInfoDesc", s.X("checkIfChannelValid fail:", localException.getLocalizedMessage()));
          boolean bool = false;
          continue;
        }
        AppMethodBeat.o(272909);
        return bool;
        bool = false;
      }
    }
    AppMethodBeat.o(272909);
    return true;
  }
  
  public final String getMediaId()
  {
    Object localObject = this.ODv;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).mediaId;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final String toJson()
  {
    AppMethodBeat.i(272917);
    i locali = new i();
    Object localObject = this.ODv;
    if (localObject == null)
    {
      localObject = "{}";
      locali.m("mInfo", localObject);
      locali.t("mStartTime", this.mStartTime);
      locali.t("mEndTime", this.mEndTime);
      locali.m("mHashCode", this.ODx);
      locali.t("mDuration", this.mDuration);
      locali.m("mSongName", this.ODz);
      locali.m("mSingerName", this.ODA);
      locali.m("cover", this.nUM);
      locali.m("channelId", this.channelId);
      locali.au("ringtoneSource", this.ODB.ordinal());
      locali.t("finderObjectId", this.mIH);
      locali.m("finderNonceId", this.LYS);
      locali.au("musicSid", this.ODC);
      locali.A("unAvailable", this.OBU);
      localObject = this.ODD;
      if (localObject != null) {
        break label255;
      }
    }
    label255:
    for (localObject = null;; localObject = ((com.tencent.mm.protocal.protobuf.a.ah)localObject).acjx)
    {
      locali.m("mVibrateInfo", localObject);
      locali.t("createTime", this.createTime);
      localObject = locali.toString();
      s.s(localObject, "JSONObject().apply {\n   …ime)\n        }.toString()");
      AppMethodBeat.o(272917);
      return localObject;
      localObject = a.a((com.tencent.mm.plugin.thumbplayer.a.b)localObject);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc$Companion;", "", "()V", "TAG", "", "fromDefaultRingPlayInfo", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "fromExtRingBackDetail", "extRingBackDetail", "Lcom/tencent/mm/protocal/protobuf/ringtone/ExtRingBackDetail;", "fromFinderMedia", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "media", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "songName", "fromFinderRingBack", "startTs", "", "endTs", "finderObjectId", "rawData", "Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;", "hashCode", "unAvailable", "", "fromFinderRingBackDetail", "detail", "Lcom/tencent/mm/protocal/protobuf/ringtone/FinderRingBackDetail;", "info", "fromJson", "json", "fromMusicRingBack", "rawDetail", "fromRingBack", "ringback", "Lcom/tencent/mm/protocal/protobuf/ringtone/RingBack;", "(Lcom/tencent/mm/protocal/protobuf/ringtone/RingBack;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "toJson", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static d a(long paramLong1, long paramLong2, FinderObject paramFinderObject, long paramLong3, String paramString)
    {
      AppMethodBeat.i(272973);
      d locald = new d();
      if (paramFinderObject != null)
      {
        Object localObject = paramFinderObject.objectDesc;
        if (localObject != null)
        {
          localObject = ((FinderObjectDesc)localObject).media;
          if (localObject != null)
          {
            localObject = (FinderMedia)p.oL((List)localObject);
            if (localObject != null)
            {
              com.tencent.mm.plugin.thumbplayer.a.b localb = ((cn)h.az(cn.class)).createMediaInfo((FinderMedia)localObject, Long.valueOf(paramLong3), false);
              if (localb != null)
              {
                localb.path = s.X(localb.path, ".ring");
                locald.ODw = paramFinderObject;
                locald.ODx = localb.mediaId;
                locald.mEndTime = paramLong2;
                locald.mStartTime = paramLong1;
                locald.ODy = null;
                locald.ODx = paramString;
                locald.mDuration = Math.min(9223372036854775807L, paramLong2 - paramLong1);
                locald.ODv = localb;
                paramString = locald.ODv;
                if (paramString != null) {
                  paramString.videoFlag = "A0";
                }
                locald.nUM = ((FinderMedia)localObject).coverUrl;
                locald.ODE = true;
                locald.ODz = MMApplicationContext.getContext().getResources().getString(b.f.finder_resource);
                locald.ODA = MMApplicationContext.getContext().getResources().getString(b.f.finder_resource_author);
                paramFinderObject = paramFinderObject.nickname;
                if (paramFinderObject != null) {
                  locald.ODA = paramFinderObject;
                }
                locald.OBU = false;
                locald.mIH = paramLong3;
                locald.ODD = null;
              }
            }
          }
        }
      }
      AppMethodBeat.o(272973);
      return locald;
    }
    
    public static d a(long paramLong1, long paramLong2, aa paramaa, String paramString)
    {
      AppMethodBeat.i(272934);
      s.u(paramaa, "rawDetail");
      v localv = paramaa.acjr;
      if (localv == null)
      {
        AppMethodBeat.o(272934);
        return null;
      }
      Object localObject1 = localv.acjj;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = Integer.valueOf(((u)localObject1).aaYO))
      {
        AppMethodBeat.o(272934);
        return null;
      }
      int i = ((Integer)localObject1).intValue();
      localObject1 = s.X("music_ringtone_", Integer.valueOf(i));
      Object localObject2 = com.tencent.mm.plugin.ringtone.c.OBr;
      String str = com.tencent.mm.plugin.ringtone.c.cI(i, (String)localObject1);
      localObject2 = new d();
      ((d)localObject2).ODv = new com.tencent.mm.plugin.thumbplayer.a.b((String)localObject1, str, localv.URL, 0, 0);
      ((d)localObject2).mStartTime = paramLong1;
      localObject1 = paramaa.acjr;
      if (localObject1 == null)
      {
        localObject1 = null;
        ((d)localObject2).nUM = ((String)localObject1);
        ((d)localObject2).ODy = paramaa;
        ((d)localObject2).mEndTime = paramLong2;
        ((d)localObject2).ODx = paramString;
        ((d)localObject2).mDuration = localv.acjm;
        paramString = paramaa.acjr;
        if (paramString != null) {
          break label274;
        }
        paramString = null;
        label210:
        ((d)localObject2).ODA = paramString;
        paramString = paramaa.acjr;
        if (paramString != null) {
          break label308;
        }
      }
      label274:
      label308:
      for (paramString = null;; paramString = paramString.oOx)
      {
        ((d)localObject2).ODz = paramString;
        ((d)localObject2).ODC = i;
        ((d)localObject2).ODD = paramaa.acju;
        AppMethodBeat.o(272934);
        return localObject2;
        localObject1 = ((v)localObject1).acjl;
        break;
        paramString = paramString.acjk;
        if (paramString == null)
        {
          paramString = null;
          break label210;
        }
        paramString = (String)p.oL((List)paramString);
        break label210;
      }
    }
    
    public static d a(long paramLong1, long paramLong2, com.tencent.mm.protocal.protobuf.a.c paramc, FinderObject paramFinderObject)
    {
      AppMethodBeat.i(272883);
      s.u(paramc, "detail");
      Object localObject = paramc.aciR;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = Long.valueOf(((com.tencent.mm.protocal.protobuf.a.b)localObject).aacf))
      {
        AppMethodBeat.o(272883);
        return null;
      }
      long l = ((Long)localObject).longValue();
      localObject = paramc.aciR;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ((com.tencent.mm.protocal.protobuf.a.b)localObject).aacg)
      {
        AppMethodBeat.o(272883);
        return null;
      }
      d locald = new d();
      locald.mStartTime = paramLong1;
      locald.mEndTime = paramLong2;
      locald.ODz = MMApplicationContext.getContext().getResources().getString(b.f.finder_resource);
      locald.ODA = MMApplicationContext.getContext().getResources().getString(b.f.finder_resource_author);
      locald.mIH = l;
      locald.aUy((String)localObject);
      localObject = locald.ODv;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).videoFlag = "A0";
      }
      locald.ODE = true;
      localObject = paramc.crB;
      if (localObject != null) {
        if (n.bp((CharSequence)localObject)) {
          break label401;
        }
      }
      label401:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          locald.ODz = ((String)localObject);
        }
        localObject = paramc.Nickname;
        if (localObject != null) {
          locald.ODA = (locald.ODA + " · " + (String)localObject);
        }
        locald.nUM = paramc.ILh;
        if (paramFinderObject != null)
        {
          paramc = paramFinderObject.objectDesc;
          if (paramc != null)
          {
            paramc = paramc.media;
            if (paramc != null)
            {
              paramc = (FinderMedia)p.oL((List)paramc);
              if (paramc != null)
              {
                paramc = ((cn)h.az(cn.class)).createMediaInfo(paramc, Long.valueOf(l), false);
                if (paramc != null)
                {
                  paramc.path = s.X(paramc.path, ".ring");
                  locald.ODv = paramc;
                  locald.ODw = paramFinderObject;
                }
              }
            }
          }
        }
        AppMethodBeat.o(272883);
        return locald;
      }
    }
    
    public static d a(FinderObject paramFinderObject, FinderMedia paramFinderMedia, String paramString)
    {
      AppMethodBeat.i(272907);
      s.u(paramFinderObject, "finderObject");
      s.u(paramFinderMedia, "media");
      s.u(paramString, "songName");
      d locald = new d();
      locald.mStartTime = 0L;
      locald.mEndTime = (paramFinderMedia.videoDuration * 1000L);
      locald.ODz = MMApplicationContext.getContext().getResources().getString(b.f.finder_resource);
      locald.ODA = MMApplicationContext.getContext().getResources().getString(b.f.finder_resource_author);
      locald.mIH = paramFinderObject.id;
      String str = paramFinderObject.objectNonceId;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      locald.aUy((String)localObject);
      localObject = locald.ODv;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).videoFlag = "A0";
      }
      locald.ODE = true;
      locald.nUM = s.X(Util.nullAsNil(paramFinderMedia.thumbUrl), Util.nullAsNil(paramFinderMedia.thumb_url_token));
      paramFinderMedia = ((cn)h.az(cn.class)).createMediaInfo(paramFinderMedia, Long.valueOf(paramFinderObject.id), false);
      if (paramFinderMedia != null)
      {
        paramFinderMedia.path = s.X(paramFinderMedia.path, ".ring");
        locald.ODv = paramFinderMedia;
        paramFinderMedia = locald.ODv;
        if (paramFinderMedia != null) {
          paramFinderMedia.videoFlag = "A0";
        }
      }
      int i;
      if (!n.bp((CharSequence)paramString))
      {
        i = 1;
        if (i == 0) {
          break label323;
        }
      }
      for (;;)
      {
        if (paramString != null) {
          locald.ODz = paramString;
        }
        paramFinderMedia = paramFinderObject.nickname;
        if (paramFinderMedia != null) {
          locald.ODA = (locald.ODA + " · " + paramFinderMedia);
        }
        locald.ODw = paramFinderObject;
        AppMethodBeat.o(272907);
        return locald;
        i = 0;
        break;
        label323:
        paramString = null;
      }
    }
    
    public static d a(com.tencent.mm.protocal.protobuf.a.c paramc, aa paramaa)
    {
      d locald = null;
      AppMethodBeat.i(272863);
      s.u(paramc, "detail");
      s.u(paramaa, "info");
      Object localObject = paramc.aciR;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = Long.valueOf(((com.tencent.mm.protocal.protobuf.a.b)localObject).aacf))
      {
        paramc = gOF();
        AppMethodBeat.o(272863);
        return paramc;
      }
      long l = ((Long)localObject).longValue();
      localObject = paramc.aciR;
      if (localObject == null) {}
      for (localObject = locald; localObject == null; localObject = ((com.tencent.mm.protocal.protobuf.a.b)localObject).aacg)
      {
        paramc = gOF();
        AppMethodBeat.o(272863);
        return paramc;
      }
      locald = new d();
      locald.ODz = MMApplicationContext.getContext().getResources().getString(b.f.finder_resource);
      locald.ODA = MMApplicationContext.getContext().getResources().getString(b.f.finder_resource_author);
      locald.mIH = l;
      locald.aUy((String)localObject);
      localObject = locald.ODv;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).videoFlag = "A0";
      }
      locald.ODE = true;
      localObject = paramc.crB;
      if (localObject != null) {
        if (n.bp((CharSequence)localObject)) {
          break label276;
        }
      }
      label276:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          locald.ODz = ((String)localObject);
        }
        localObject = paramc.Nickname;
        if (localObject != null) {
          locald.ODA = ((String)localObject);
        }
        locald.ODD = paramaa.acju;
        locald.nUM = paramc.ILh;
        AppMethodBeat.o(272863);
        return locald;
      }
    }
    
    private static com.tencent.mm.plugin.thumbplayer.a.b a(com.tencent.mm.plugin.thumbplayer.a.b paramb, String paramString)
    {
      int i = 1;
      AppMethodBeat.i(273080);
      s.u(paramb, "<this>");
      s.u(paramString, "json");
      com.tencent.mm.plugin.thumbplayer.a.b localb = new com.tencent.mm.plugin.thumbplayer.a.b();
      for (;;)
      {
        try
        {
          paramString = new i(paramString);
          localb.mediaId = paramString.getString("mediaId");
          localb.path = paramString.getString("path");
          localb.url = paramString.getString("url");
          localb.width = paramString.getInt("width");
          localb.height = paramString.getInt("height");
          paramb = (JSONObject)paramString;
        }
        catch (Exception paramb)
        {
          continue;
          paramb = null;
          continue;
        }
        try
        {
          if (paramb.has("decodeKey") != true) {
            continue;
          }
          if (i == 0) {
            continue;
          }
          paramb = paramb.getString("decodeKey");
        }
        catch (Exception paramb)
        {
          Log.printDebugStack("safeGetString", "", new Object[] { paramb });
          paramb = null;
          continue;
        }
        localb.decodeKey = paramb;
        localb.hJv = paramString.getBoolean("isLocal");
        localb.vYw = paramString.getLong("videoDuration");
        localb.hYK = paramString.getInt("rotate");
        localb.loop = paramString.getBoolean("loop");
        AppMethodBeat.o(273080);
        return localb;
        i = 0;
      }
    }
    
    public static String a(com.tencent.mm.plugin.thumbplayer.a.b paramb)
    {
      AppMethodBeat.i(273061);
      s.u(paramb, "<this>");
      i locali = new i();
      locali.m("mediaId", paramb.mediaId);
      locali.m("path", paramb.path);
      locali.m("url", paramb.url);
      locali.au("width", paramb.width);
      locali.au("height", paramb.height);
      locali.m("decodeKey", paramb.decodeKey);
      locali.A("isLocal", paramb.hJv);
      locali.t("videoDuration", paramb.vYw);
      locali.au("rotate", paramb.hYK);
      locali.A("loop", paramb.loop);
      paramb = locali.toString();
      s.s(paramb, "JSONObject().apply {\n   …\n            }.toString()");
      AppMethodBeat.o(273061);
      return paramb;
    }
    
    public static d aUz(String paramString)
    {
      Object localObject2 = null;
      int k = 1;
      AppMethodBeat.i(273042);
      s.u(paramString, "json");
      d locald = new d();
      i locali = new i(paramString);
      for (;;)
      {
        try
        {
          paramString = d.ODu;
          paramString = new com.tencent.mm.plugin.thumbplayer.a.b();
          localObject1 = locali.getString("mInfo");
          s.s(localObject1, "jsonObject.getString(\"mInfo\")");
          locald.ODv = a(paramString, (String)localObject1);
          locald.mStartTime = locali.getLong("mStartTime");
          locald.mEndTime = locali.getLong("mEndTime");
          paramString = (JSONObject)locali;
        }
        catch (Exception paramString)
        {
          Object localObject1;
          label135:
          label173:
          label185:
          label210:
          label222:
          int m;
          int n;
          continue;
          int i = 0;
          continue;
        }
        try
        {
          if (paramString.has("mHashCode") != true) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          paramString = paramString.getString("mHashCode");
        }
        catch (Exception paramString)
        {
          Log.printDebugStack("safeGetString", "", new Object[] { paramString });
          paramString = null;
        }
      }
      locald.ODx = paramString;
      locald.mDuration = locali.getLong("mDuration");
      paramString = (JSONObject)locali;
      try
      {
        if (paramString.has("mSongName") != true) {
          break label710;
        }
        i = 1;
        if (i == 0) {
          break label700;
        }
        paramString = paramString.getString("mSongName");
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printDebugStack("safeGetString", "", new Object[] { paramString });
          paramString = null;
        }
      }
      locald.ODz = paramString;
      paramString = (JSONObject)locali;
      try
      {
        if (paramString.has("mSingerName") != true) {
          break label715;
        }
        i = 1;
        if (i == 0) {
          break label695;
        }
        paramString = paramString.getString("mSingerName");
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printDebugStack("safeGetString", "", new Object[] { paramString });
          paramString = null;
        }
      }
      locald.ODA = paramString;
      paramString = (JSONObject)locali;
      try
      {
        if (paramString.has("cover") != true) {
          break label720;
        }
        i = 1;
        label247:
        if (i == 0) {
          break label690;
        }
        paramString = paramString.getString("cover");
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label259:
          Log.printDebugStack("safeGetString", "", new Object[] { paramString });
          paramString = null;
        }
      }
      locald.nUM = paramString;
      paramString = (JSONObject)locali;
      try
      {
        if (paramString.has("channelId") != true) {
          break label725;
        }
        i = 1;
        label284:
        if (i == 0) {
          break label685;
        }
        paramString = paramString.getString("channelId");
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label296:
          Log.printDebugStack("safeGetString", "", new Object[] { paramString });
          paramString = null;
        }
        paramString = (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
        AppMethodBeat.o(273042);
        throw paramString;
      }
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      locald.aUx((String)localObject1);
      paramString = c.ODn;
      m = locali.getInt("ringtoneSource");
      paramString = c.gOB();
      n = paramString.length;
      i = 0;
      for (;;)
      {
        if (i < n)
        {
          localObject1 = paramString[i];
          if (((c)localObject1).ordinal() != m) {
            break label730;
          }
        }
        label685:
        label690:
        label695:
        label700:
        label710:
        label715:
        label720:
        label725:
        label730:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label735;
          }
          locald.a((c)localObject1);
          locald.mIH = locali.getLong("finderObjectId");
          paramString = locali.getString("finderNonceId");
          s.s(paramString, "jsonObject.getString(\"finderNonceId\")");
          locald.aUy(paramString);
          locald.ODC = locali.getInt("musicSid");
          localObject1 = new com.tencent.mm.protocal.protobuf.a.ah();
          JSONObject localJSONObject = (JSONObject)locali;
          try
          {
            if (localJSONObject.has("mVibrateInfo") != true) {
              break label746;
            }
            i = k;
            paramString = localObject2;
            if (i != 0) {
              paramString = localJSONObject.getString("mVibrateInfo");
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              Log.printDebugStack("safeGetString", "", new Object[] { paramString });
              paramString = localObject2;
            }
          }
          ((com.tencent.mm.protocal.protobuf.a.ah)localObject1).acjx = paramString;
          paramString = kotlin.ah.aiuX;
          locald.ODD = ((com.tencent.mm.protocal.protobuf.a.ah)localObject1);
          locald.OBU = locali.getBoolean("unAvailable");
          locald.createTime = locali.getLong("createTime");
          AppMethodBeat.o(273042);
          return locald;
          i = 0;
          break;
          paramString = null;
          break label296;
          paramString = null;
          break label259;
          paramString = null;
          break label222;
          paramString = null;
          break label185;
          paramString = null;
          break label135;
          i = 0;
          break label173;
          i = 0;
          break label210;
          i = 0;
          break label247;
          i = 0;
          break label284;
        }
        label735:
        i += 1;
      }
    }
    
    public static d gOF()
    {
      AppMethodBeat.i(273007);
      d locald = new d();
      Object localObject = new com.tencent.mm.plugin.thumbplayer.a.b("voip_default_sound", com.tencent.mm.plugin.ringtone.c.gOl(), "", 0, 0);
      locald.ODz = MMApplicationContext.getContext().getResources().getText(b.f.ringtone_defalut).toString();
      locald.mStartTime = 0L;
      locald.mEndTime = 4400L;
      locald.mDuration = 4400L;
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).hJv = true;
      locald.ODv = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject);
      localObject = new com.tencent.mm.protocal.protobuf.a.ah();
      ((com.tencent.mm.protocal.protobuf.a.ah)localObject).acjx = "phonering.HE";
      kotlin.ah localah = kotlin.ah.aiuX;
      locald.ODD = ((com.tencent.mm.protocal.protobuf.a.ah)localObject);
      AppMethodBeat.o(273007);
      return locald;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      extends k
      implements m<aq, kotlin.d.d<? super d>, Object>
    {
      long Yx;
      int label;
      
      public a(z paramz, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(272833);
        paramObject = (kotlin.d.d)new a(this.ODF, paramd);
        AppMethodBeat.o(272833);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(272827);
        Object localObject2 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(272827);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          if (this.ODF.vhJ == 1)
          {
            paramObject = this.ODF.acjh;
            if (paramObject == null) {}
            for (paramObject = null; paramObject == null; paramObject = Integer.valueOf(paramObject.aaYO))
            {
              AppMethodBeat.o(272827);
              return null;
            }
            int i = paramObject.intValue();
            paramObject = PluginRingtone.OBl;
            paramObject = (kotlin.d.d)this;
            this.label = 1;
            localObject1 = PluginRingtone.a.getSingleMusicRingBackPlayInfo(i, paramObject);
            paramObject = localObject1;
            if (localObject1 == localObject2)
            {
              AppMethodBeat.o(272827);
              return localObject2;
            }
          }
        case 1: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (q)paramObject;
          if (paramObject == null)
          {
            AppMethodBeat.o(272827);
            return null;
          }
          paramObject = paramObject.aciQ;
          if (paramObject == null)
          {
            AppMethodBeat.o(272827);
            return null;
          }
          localObject1 = this.ODF;
          localObject2 = d.ODu;
          paramObject = d.a.a(((z)localObject1).abaj, ((z)localObject1).abak, paramObject);
          AppMethodBeat.o(272827);
          return paramObject;
          paramObject = this.ODF.acji;
          if (paramObject == null) {}
          for (paramObject = null; paramObject == null; paramObject = kotlin.d.b.a.b.BF(paramObject.aacf))
          {
            AppMethodBeat.o(272827);
            return null;
          }
          l = paramObject.longValue();
          paramObject = this.ODF.acji;
          if (paramObject == null) {}
          for (paramObject = null; paramObject == null; paramObject = paramObject.aacg)
          {
            AppMethodBeat.o(272827);
            return null;
          }
          localObject1 = PluginRingtone.OBl;
          localObject1 = (kotlin.d.d)this;
          this.Yx = l;
          this.label = 2;
          localObject1 = com.tencent.mm.plugin.ringtone.i.a.getRingBackFromFinder(l, paramObject, (kotlin.d.d)localObject1);
          paramObject = localObject1;
          if (localObject1 != localObject2) {
            break label354;
          }
          AppMethodBeat.o(272827);
          return localObject2;
        }
        long l = this.Yx;
        ResultKt.throwOnFailure(paramObject);
        label354:
        paramObject = (a.a)paramObject;
        if (paramObject == null)
        {
          AppMethodBeat.o(272827);
          return null;
        }
        paramObject = paramObject.ABJ;
        if (paramObject == null)
        {
          AppMethodBeat.o(272827);
          return null;
        }
        Object localObject1 = this.ODF;
        localObject2 = d.ODu;
        paramObject = d.a.a(((z)localObject1).abaj, ((z)localObject1).abak, paramObject, l, null, 112);
        AppMethodBeat.o(272827);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.g.d
 * JD-Core Version:    0.7.0.1
 */