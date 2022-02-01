package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.eet;
import com.tencent.mm.protocal.protobuf.eeu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "", "ct", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "lastMusicId", "", "getLastMusicId", "()Ljava/lang/String;", "setLastMusicId", "(Ljava/lang/String;)V", "mContext", "mCurrentAlbumId", "mWebViewAlbumInfo", "Lcom/tencent/mm/protocal/protobuf/WebViewAlbumInfo;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicPlayerListener", "()Lcom/tencent/mm/sdk/event/IListener;", "playActionSource", "", "getPlayActionSource", "()I", "setPlayActionSource", "(I)V", "playId", "getPlayId", "setPlayId", "doReport", "", "event", "info", "Lcom/tencent/mm/protocal/protobuf/WebViewAudioInfo;", "eventType", "formatReportData", "data", "getAlbumIdFromMusicId", "musicId", "getAudioIdFromMusicId", "getAudioListState", "domain", "albumId", "getDomainFromMusicId", "getWebViewAlbumInfoInfo", "getWebViewAudioInfo", "playAudioList", "", "playAudioId", "appId", "saveCurrentAudioPlayTime", "saveWebViewAlbumInfoInfo", "saveWebViewAudioInfo", "startTimer", "stopTimer", "albumInfoKey", "audioInfoKey", "Companion", "plugin-webview_release"})
public final class i
{
  private static i Eph;
  public static final a Epi;
  private final ar DAd;
  private eet Epc;
  private String Epd;
  private int Epe;
  private String Epf;
  private String Epg;
  final com.tencent.mm.sdk.b.c<mf> kwD;
  private av lts;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(182673);
    Epi = new a((byte)0);
    AppMethodBeat.o(182673);
  }
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(182672);
    this.Epd = "";
    ax localax = ax.aQz("__web_music_slot_mmkv_key__");
    p.g(localax, "MultiProcessMMKV.getMMKV…b_music_slot_mmkv_key__\")");
    this.DAd = new ar(localax, 15552000L);
    this.kwD = ((com.tencent.mm.sdk.b.c)new c(this));
    this.lts = new av("MicroMsg.MusicAlbumHelper", (av.a)new b(this), true);
    this.Epe = 1;
    this.Epf = "";
    this.Epg = "";
    this.mContext = paramContext;
    AppMethodBeat.o(182672);
  }
  
  private final void a(eeu parameeu, int paramInt)
  {
    AppMethodBeat.i(207621);
    if (parameeu == null)
    {
      AppMethodBeat.o(207621);
      return;
    }
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.report.service.g.yhR.f(19839, new Object[] { parameeu.HBQ, Long.valueOf(parameeu.msgId), Integer.valueOf(parameeu.idx), parameeu.HQd, parameeu.dce, Integer.valueOf(parameeu.dtc), Long.valueOf(parameeu.oaT), parameeu.HQe, Integer.valueOf(parameeu.scene), Integer.valueOf(parameeu.ooi), this.Epf, Integer.valueOf(parameeu.duration), Integer.valueOf(parameeu.HQc), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(this.Epe), x.aNF(parameeu.HQf), Integer.valueOf(parameeu.HQi), aJu(parameeu.HQg), aJu(parameeu.HQh) });
    AppMethodBeat.o(207621);
  }
  
  private final void a(String paramString, eeu parameeu)
  {
    AppMethodBeat.i(207617);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207617);
      return;
    }
    localObject = (ax)this.DAd.fjV();
    try
    {
      ((ax)localObject).encode(aJr(paramString), parameeu.toByteArray());
      AppMethodBeat.o(207617);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MusicAlbumHelper", "saveWebViewAudioInfo ex " + paramString.getMessage());
      AppMethodBeat.o(207617);
    }
  }
  
  private final void a(String paramString1, String paramString2, eet parameet)
  {
    AppMethodBeat.i(207619);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.aE((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.aE((CharSequence)localObject))) {
          break label73;
        }
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label79;
      }
      AppMethodBeat.o(207619);
      return;
      i = 0;
      break;
    }
    label79:
    localObject = (ax)this.DAd.fjV();
    try
    {
      ((ax)localObject).encode(lc(paramString1, paramString2), parameet.toByteArray());
      AppMethodBeat.o(207619);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.MusicAlbumHelper", "saveWebViewAlbumInfoInfo ex " + paramString1.getMessage());
      AppMethodBeat.o(207619);
    }
  }
  
  private static String aJr(String paramString)
  {
    AppMethodBeat.i(207614);
    p.h(paramString, "$this$audioInfoKey");
    paramString = "audioInfo_" + paramString + '}';
    AppMethodBeat.o(207614);
    return paramString;
  }
  
  private final eeu aJt(String paramString)
  {
    AppMethodBeat.i(207616);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207616);
      return null;
    }
    localObject = (ax)this.DAd.fjV();
    paramString = aJr(paramString);
    if (((ax)localObject).containsKey(paramString))
    {
      paramString = ((ax)localObject).decodeBytes(paramString);
      if (paramString != null) {
        if (paramString.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label130;
          }
          i = 1;
          label88:
          if (i == 0) {
            break label153;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = eeu.class.newInstance();
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bx.a)localObject;
        paramString = (eeu)paramString;
        AppMethodBeat.o(207616);
        return paramString;
      }
      catch (Exception paramString)
      {
        label130:
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label88;
      label153:
      paramString = null;
    }
  }
  
  private static String aJu(String paramString)
  {
    AppMethodBeat.i(207622);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.aE(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207622);
      return "";
    }
    paramString = n.h(paramString, ",", "", false);
    AppMethodBeat.o(207622);
    return paramString;
  }
  
  private static String aW(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(182661);
    p.h(paramString1, "$this$musicId");
    p.h(paramString2, "albumId");
    paramString1 = paramString3 + '_' + paramString2 + '_' + paramString1;
    AppMethodBeat.o(182661);
    return paramString1;
  }
  
  private final void b(mf parammf)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207620);
        Object localObject2 = parammf.dzK.dzE;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.az.a.aJJ();
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(207620);
          return;
        }
        if (bt.isNullOrNil(this.Epg))
        {
          localObject2 = ((f)localObject1).ihg;
          p.g(localObject2, "musicWrapper.MusicId");
          this.Epg = ((String)localObject2);
          this.Epf = String.valueOf(System.currentTimeMillis());
        }
        ad.i("MicroMsg.MusicAlbumHelper", "doWebViewReport musicId = " + this.Epg + ", playId=" + this.Epf + ", playActionSource=" + this.Epe + "，action=" + parammf.dzK.action);
        switch (parammf.dzK.action)
        {
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
          if (!bt.lQ(this.Epg, ((f)localObject1).ihg))
          {
            localObject1 = ((f)localObject1).ihg;
            p.g(localObject1, "musicWrapper.MusicId");
            this.Epg = ((String)localObject1);
            this.Epf = String.valueOf(System.currentTimeMillis());
            ad.i("MicroMsg.MusicAlbumHelper", "doWebViewReport new music musicId = " + this.Epg + ", playId=" + this.Epf);
          }
          switch (parammf.dzK.action)
          {
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 10: 
            AppMethodBeat.o(207620);
          }
          break;
        case 3: 
          a(aJt(this.Epg), 4);
        }
      }
      finally {}
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 7);
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 8);
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 9);
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 100);
      AppMethodBeat.o(207620);
      continue;
      this.Epe = 2;
      AppMethodBeat.o(207620);
      continue;
      this.Epe = 3;
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 1);
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 2);
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 3);
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 5);
      AppMethodBeat.o(207620);
      continue;
      a(aJt(this.Epg), 6);
      continue;
    }
  }
  
  private static String lc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207615);
    p.h(paramString1, "$this$albumInfoKey");
    paramString1 = "album_" + paramString2 + '_' + paramString1 + '}';
    AppMethodBeat.o(207615);
    return paramString1;
  }
  
  private final eet le(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207618);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.aE((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.aE((CharSequence)localObject))) {
          break label69;
        }
      }
    }
    label69:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label74;
      }
      AppMethodBeat.o(207618);
      return null;
      i = 0;
      break;
    }
    label74:
    localObject = (ax)this.DAd.fjV();
    paramString1 = lc(paramString1, paramString2);
    if (((ax)localObject).containsKey(paramString1))
    {
      paramString1 = ((ax)localObject).decodeBytes(paramString1);
      if (paramString1 != null) {
        if (paramString1.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label168;
          }
          i = 1;
          label125:
          if (i == 0) {
            break label191;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = eet.class.newInstance();
        ((com.tencent.mm.bx.a)paramString2).parseFrom(paramString1);
        paramString1 = (com.tencent.mm.bx.a)paramString2;
        paramString1 = (eet)paramString1;
        AppMethodBeat.o(207618);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        label168:
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString1, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label125;
      label191:
      paramString1 = null;
    }
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(182671);
    ad.d("MicroMsg.MusicAlbumHelper", "stop timer");
    this.lts.stopTimer();
    AppMethodBeat.o(182671);
  }
  
  public final String aJs(String paramString)
  {
    try
    {
      AppMethodBeat.i(182667);
      paramString = ld(((ax)this.DAd.fjV()).decodeString("currentAlbumId"), paramString);
      AppMethodBeat.o(182667);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String aJv(String paramString)
  {
    AppMethodBeat.i(207623);
    paramString = aJt(paramString);
    if (paramString != null)
    {
      paramString = paramString.HQd;
      AppMethodBeat.o(207623);
      return paramString;
    }
    AppMethodBeat.o(207623);
    return null;
  }
  
  public final String aJw(String paramString)
  {
    AppMethodBeat.i(207624);
    paramString = aJt(paramString);
    if (paramString != null)
    {
      paramString = paramString.dce;
      AppMethodBeat.o(207624);
      return paramString;
    }
    AppMethodBeat.o(207624);
    return null;
  }
  
  public final void eVe()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182670);
        Object localObject1 = com.tencent.mm.az.a.aJJ();
        if (localObject1 == null) {
          break label262;
        }
        if (((f)localObject1).ihg == null)
        {
          AppMethodBeat.o(182670);
          return;
        }
        Object localObject5 = com.tencent.mm.az.a.aJK();
        if (localObject5 == null) {
          break label253;
        }
        Object localObject4 = (ax)this.DAd.fjV();
        Object localObject6 = aJt(((f)localObject1).ihg);
        if (localObject6 == null) {
          break label244;
        }
        if (((eeu)localObject6).HQc < 0) {
          break label235;
        }
        if (((com.tencent.mm.az.c)localObject5).getPosition() > 0) {
          ((eeu)localObject6).HQc = ((com.tencent.mm.az.c)localObject5).getPosition();
        }
        ((eeu)localObject6).duration = Math.max(0, ((com.tencent.mm.az.c)localObject5).getDuration());
        a(((f)localObject1).ihg, (eeu)localObject6);
        localObject5 = aJv(((f)localObject1).ihg);
        localObject6 = aJw(((f)localObject1).ihg);
        localObject1 = aJt(((f)localObject1).ihg);
        if (localObject1 != null)
        {
          localObject1 = ((eeu)localObject1).EFF;
          if ((bt.isNullOrNil((String)localObject5)) || (bt.isNullOrNil((String)localObject6))) {
            break label235;
          }
          ((ax)localObject4).encode("currentAlbumId", (String)localObject5);
          localObject4 = le((String)localObject5, (String)localObject1);
          if (localObject4 == null) {
            break label235;
          }
          eet localeet = this.Epc;
          if (localeet != null) {
            localeet.HQa = ((String)localObject6);
          }
          ((eet)localObject4).HQa = ((String)localObject6);
          a((String)localObject5, (String)localObject1, (eet)localObject4);
          AppMethodBeat.o(182670);
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
      continue;
      label235:
      AppMethodBeat.o(182670);
      continue;
      label244:
      AppMethodBeat.o(182670);
      continue;
      label253:
      AppMethodBeat.o(182670);
      continue;
      label262:
      AppMethodBeat.o(182670);
    }
  }
  
  public final boolean g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(182669);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString3)))
    {
      ad.i("MicroMsg.MusicAlbumHelper", "playAudioList invalid params");
      AppMethodBeat.o(182669);
      return false;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray(paramString2);
      if (localJSONArray.length() <= 0)
      {
        ad.i("MicroMsg.MusicAlbumHelper", "playAudioList invalid mAudioList");
        AppMethodBeat.o(182669);
        return false;
      }
    }
    catch (Exception paramString1)
    {
      ad.w("MicroMsg.MusicAlbumHelper", "setAudioList ex:%s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(182669);
      return false;
    }
    localList = (List)new ArrayList();
    try
    {
      this.Epc = new eet();
      this.Epd = paramString1;
      j = 0;
      k = localJSONArray.length();
      i = 0;
    }
    catch (Exception paramString1)
    {
      try
      {
        int j;
        int k;
        int i;
        label185:
        label204:
        label228:
        JSONObject localJSONObject;
        String str2;
        String str1;
        boolean bool;
        Object localObject2 = localJSONObject.optString("src", "");
        String str6 = localJSONObject.optString("title");
        String str7 = localJSONObject.optString("epname", "");
        String str8 = localJSONObject.optString("singer", "");
        String str9 = localJSONObject.optString("coverImgUrl", "");
        String str10 = localJSONObject.optString("webUrl");
        paramString2 = localJSONObject.optString("srcId", "");
        Object localObject1 = localJSONObject.optString("protocol", "");
        String str11 = localJSONObject.optString("lowbandSrc", "");
        String str3 = localJSONObject.optString("musicbar_url", "");
        double d1 = localJSONObject.optDouble("playbackRate", 1.0D);
        double d2 = localJSONObject.optDouble("volume", 1.0D);
        if (d1 < 0.5D) {
          break label1014;
        }
        if (d1 <= 2.0D) {
          break label1008;
        }
        for (;;)
        {
          String str4 = localJSONObject.optString("songLyric", "");
          String str5 = localJSONObject.optString("src_username", "");
          int m = localJSONObject.optInt("startTime", 0);
          if ((bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil(str6)))
          {
            ad.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, src or title is null");
            AppMethodBeat.o(182669);
            return false;
          }
          Object localObject3 = this.Epc;
          if (localObject3 != null)
          {
            localObject3 = ((eet)localObject3).HQb;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(str2);
            }
          }
          localObject2 = com.tencent.mm.az.g.a(10, str9, str6, str8, str10, str11, (String)localObject2, str1, b.arU(), d.azA() + str9.hashCode(), str7, paramString5);
          ((f)localObject2).ihD = paramString4;
          ((f)localObject2).ddx = (m * 1000);
          ((f)localObject2).ihE = paramString2;
          ((f)localObject2).protocol = ((String)localObject1);
          ((f)localObject2).ihG = str3;
          ((f)localObject2).ihp = str4;
          ((f)localObject2).dHo = str5;
          ((f)localObject2).hLI = d1;
          ((f)localObject2).volume = ((float)d2);
          localObject1 = aJt(str1);
          paramString2 = (String)localObject1;
          if (localObject1 == null) {
            paramString2 = new eeu();
          }
          if (paramString2.HQc <= 0)
          {
            paramString2.HQc = 0;
            paramString2.HQd = paramString1;
            paramString2.dce = str2;
            paramString2.HQj = ((float)d1);
            localObject1 = localJSONObject.optJSONObject("reportData");
            if (localObject1 != null)
            {
              paramString2.dtc = ((JSONObject)localObject1).optInt("VoiceType", 0);
              paramString2.HBQ = ((JSONObject)localObject1).optString("BizUin", "");
              paramString2.msgId = ((JSONObject)localObject1).optLong("MsgId", 0L);
              paramString2.idx = ((JSONObject)localObject1).optInt("Idx", 0);
              paramString2.HQe = ((JSONObject)localObject1).optString("SessionIdStr", "0");
              paramString2.HQf = ((JSONObject)localObject1).optString("AlbumURL", "");
              paramString2.HQg = ((JSONObject)localObject1).optString("AlbumTitle", "");
              paramString2.HQh = ((JSONObject)localObject1).optString("AudioTitle", "");
              paramString2.oaT = ((JSONObject)localObject1).optLong("EnterId", 0L);
              paramString2.scene = ((JSONObject)localObject1).optInt("Scene", 0);
              paramString2.ooi = ((JSONObject)localObject1).optInt("SubScene", 0);
              paramString2.HQi = ((JSONObject)localObject1).optInt("AudioPos", 0);
            }
            paramString2.EFF = paramString4;
            a(str1, paramString2);
          }
          p.g(localObject2, "wrapper");
          localList.add(localObject2);
          j += 1;
          break;
          paramString2 = this.Epc;
          if (paramString2 == null) {
            p.gfZ();
          }
          a(paramString1, paramString4, paramString2);
          break label204;
          this.Epe = 1;
          com.tencent.mm.az.a.f(localList, i);
          AppMethodBeat.o(182669);
          return true;
          paramString1 = paramString1;
          i = 0;
          break label185;
          continue;
          break label312;
          d1 = 1.0D;
        }
      }
      catch (Exception paramString1) {}
    }
    if (j < k)
    {
      try
      {
        paramString2 = localJSONArray.get(j);
        if (paramString2 != null) {
          break label228;
        }
        paramString1 = new v("null cannot be cast to non-null type org.json.JSONObject");
        AppMethodBeat.o(182669);
        throw paramString1;
      }
      catch (Exception paramString1) {}
      ad.w("MicroMsg.MusicAlbumHelper", "playAudioList ex:%s", new Object[] { paramString1.getMessage() });
      if (!bt.hj(localList)) {
        break label981;
      }
      ad.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, wrapperList is null");
      AppMethodBeat.o(182669);
      return false;
      localJSONObject = (JSONObject)paramString2;
      str2 = localJSONObject.optString("audioId", "");
      if (bt.isNullOrNil(str2))
      {
        ad.i("MicroMsg.MusicAlbumHelper", "playAudioList audioId is empty");
        AppMethodBeat.o(182669);
        return false;
      }
      p.g(str2, "audioId");
      if (paramString1 == null) {
        p.gfZ();
      }
      str1 = aW(str2, paramString1, paramString4);
      bool = p.i(str2, paramString3);
      if (!bool) {
        break label1011;
      }
      i = j;
    }
  }
  
  public final String ld(String paramString1, String paramString2)
  {
    label454:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182668);
        if (bt.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(182668);
          paramString1 = null;
          return paramString1;
        }
        eVe();
        Object localObject1;
        if ((bt.lQ(paramString1, this.Epd)) && (this.Epc != null))
        {
          localObject1 = this.Epc;
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject1 = ((eet)localObject1).HQb;
          if (bt.hj((List)localObject1))
          {
            AppMethodBeat.o(182668);
            paramString1 = null;
          }
        }
        else
        {
          localObject1 = le(paramString1, paramString2);
          if (localObject1 != null)
          {
            this.Epc = ((eet)localObject1);
            this.Epd = paramString1;
            localObject1 = ((eet)localObject1).HQb;
            continue;
          }
          localObject1 = null;
          continue;
        }
        JSONObject localJSONObject1;
        int i;
        try
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("albumId", paramString1);
          Object localObject2 = this.Epc;
          if (localObject2 != null)
          {
            str = ((eet)localObject2).HQa;
            localObject2 = str;
            if (str != null) {}
          }
          else
          {
            localObject2 = Integer.valueOf(0);
          }
          localJSONObject1.put("audioId", localObject2);
          if (localObject1 == null) {
            continue;
          }
          localObject2 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          str = (String)((Iterator)localObject2).next();
          localObject1 = (CharSequence)str;
          if (localObject1 == null) {
            break label454;
          }
          if (!n.aE((CharSequence)localObject1)) {
            continue;
          }
        }
        catch (Exception paramString1)
        {
          String str;
          JSONObject localJSONObject2;
          ad.w("MicroMsg.MusicAlbumHelper", "getAudioListState ex:%s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(182668);
          paramString1 = null;
        }
        if (i == 0)
        {
          if (paramString1 == null) {
            p.gfZ();
          }
          localObject1 = aJt(aW(str, paramString1, paramString2));
          localJSONObject2 = new JSONObject();
          if (localObject1 != null)
          {
            i = ((eeu)localObject1).HQc;
            localJSONObject2.put("currentTime", i / 1000);
            if (localObject1 != null)
            {
              i = ((eeu)localObject1).duration;
              localJSONObject2.put("duration", i / 1000);
              if (localObject1 == null) {
                continue;
              }
              localObject1 = Float.valueOf(((eeu)localObject1).HQj);
              localJSONObject2.put("playbackRate", localObject1);
              localJSONObject1.put(str, localJSONObject2);
              continue;
              continue;
              i = 0;
              continue;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          i = 0;
          continue;
          localObject1 = Float.valueOf(1.0F);
          continue;
          paramString1 = localJSONObject1.toString();
          AppMethodBeat.o(182668);
          continue;
          i = 1;
        }
      }
      finally {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$Companion;", "", "()V", "TAG", "", "albumDelimiter", "currentAlbumIdKey", "<set-?>", "Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "instance", "getInstance", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "setInstance", "(Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;)V", "plugin-webview_release"})
  public static final class a
  {
    public static i eVg()
    {
      AppMethodBeat.i(182656);
      if (i.eVf() == null) {}
      try
      {
        if (i.eVf() == null)
        {
          localObject1 = aj.getContext();
          p.g(localObject1, "MMApplicationContext.getContext()");
          i.d(new i((Context)localObject1, (byte)0));
          localObject1 = i.eVf();
          if (localObject1 != null)
          {
            localObject1 = ((i)localObject1).kwD;
            if (localObject1 != null) {
              ((com.tencent.mm.sdk.b.c)localObject1).alive();
            }
          }
        }
        Object localObject1 = z.MKo;
        localObject1 = i.eVf();
        AppMethodBeat.o(182656);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(182656);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements av.a
  {
    b(i parami) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(182659);
      this.Epj.eVe();
      AppMethodBeat.o(182659);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-webview_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<mf>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.i
 * JD-Core Version:    0.7.0.1
 */