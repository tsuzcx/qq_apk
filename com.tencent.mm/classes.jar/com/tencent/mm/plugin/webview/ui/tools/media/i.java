package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mg.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "", "ct", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "lastMusicId", "", "getLastMusicId", "()Ljava/lang/String;", "setLastMusicId", "(Ljava/lang/String;)V", "mContext", "mCurrentAlbumId", "mWebViewAlbumInfo", "Lcom/tencent/mm/protocal/protobuf/WebViewAlbumInfo;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicPlayerListener", "()Lcom/tencent/mm/sdk/event/IListener;", "playActionSource", "", "getPlayActionSource", "()I", "setPlayActionSource", "(I)V", "playId", "getPlayId", "setPlayId", "doReport", "", "event", "info", "Lcom/tencent/mm/protocal/protobuf/WebViewAudioInfo;", "eventType", "formatReportData", "data", "getAlbumIdFromMusicId", "musicId", "getAudioIdFromMusicId", "getAudioListState", "domain", "albumId", "getDomainFromMusicId", "getWebViewAlbumInfoInfo", "getWebViewAudioInfo", "playAudioList", "", "playAudioId", "appId", "saveCurrentAudioPlayTime", "saveWebViewAlbumInfoInfo", "saveWebViewAudioInfo", "startTimer", "stopTimer", "albumInfoKey", "audioInfoKey", "Companion", "plugin-webview_release"})
public final class i
{
  private static i EHm;
  public static final a EHn;
  private final as DSc;
  private egk EHh;
  private String EHi;
  private int EHj;
  private String EHk;
  private String EHl;
  final com.tencent.mm.sdk.b.c<mg> kzS;
  private aw lxR;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(182673);
    EHn = new a((byte)0);
    AppMethodBeat.o(182673);
  }
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(182672);
    this.EHi = "";
    ay localay = ay.aRW("__web_music_slot_mmkv_key__");
    p.g(localay, "MultiProcessMMKV.getMMKV…b_music_slot_mmkv_key__\")");
    this.DSc = new as(localay, 15552000L);
    this.kzS = ((com.tencent.mm.sdk.b.c)new c(this));
    this.lxR = new aw("MicroMsg.MusicAlbumHelper", (aw.a)new b(this), true);
    this.EHj = 1;
    this.EHk = "";
    this.EHl = "";
    this.mContext = paramContext;
    AppMethodBeat.o(182672);
  }
  
  private final void a(egl paramegl, int paramInt)
  {
    AppMethodBeat.i(199379);
    if (paramegl == null)
    {
      AppMethodBeat.o(199379);
      return;
    }
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.report.service.g.yxI.f(19839, new Object[] { paramegl.HVD, Long.valueOf(paramegl.msgId), Integer.valueOf(paramegl.idx), paramegl.Ikk, paramegl.ddg, Integer.valueOf(paramegl.dui), Long.valueOf(paramegl.ogK), paramegl.Ikl, Integer.valueOf(paramegl.scene), Integer.valueOf(paramegl.otZ), this.EHk, Integer.valueOf(paramegl.duration), Integer.valueOf(paramegl.Ikj), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(this.EHj), x.aPc(paramegl.Ikm), Integer.valueOf(paramegl.Ikp), aKN(paramegl.Ikn), aKN(paramegl.Iko) });
    AppMethodBeat.o(199379);
  }
  
  private final void a(String paramString, egl paramegl)
  {
    AppMethodBeat.i(199375);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aD((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199375);
      return;
    }
    localObject = (ay)this.DSc.fnP();
    try
    {
      ((ay)localObject).encode(aKK(paramString), paramegl.toByteArray());
      AppMethodBeat.o(199375);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.MusicAlbumHelper", "saveWebViewAudioInfo ex " + paramString.getMessage());
      AppMethodBeat.o(199375);
    }
  }
  
  private final void a(String paramString1, String paramString2, egk paramegk)
  {
    AppMethodBeat.i(199377);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.aD((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.aD((CharSequence)localObject))) {
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
      AppMethodBeat.o(199377);
      return;
      i = 0;
      break;
    }
    label79:
    localObject = (ay)this.DSc.fnP();
    try
    {
      ((ay)localObject).encode(lj(paramString1, paramString2), paramegk.toByteArray());
      AppMethodBeat.o(199377);
      return;
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.MusicAlbumHelper", "saveWebViewAlbumInfoInfo ex " + paramString1.getMessage());
      AppMethodBeat.o(199377);
    }
  }
  
  private static String aKK(String paramString)
  {
    AppMethodBeat.i(199372);
    p.h(paramString, "$this$audioInfoKey");
    paramString = "audioInfo_" + paramString + '}';
    AppMethodBeat.o(199372);
    return paramString;
  }
  
  private final egl aKM(String paramString)
  {
    AppMethodBeat.i(199374);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aD((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199374);
      return null;
    }
    localObject = (ay)this.DSc.fnP();
    paramString = aKK(paramString);
    if (((ay)localObject).containsKey(paramString))
    {
      paramString = ((ay)localObject).decodeBytes(paramString);
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
        localObject = egl.class.newInstance();
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bw.a)localObject;
        paramString = (egl)paramString;
        AppMethodBeat.o(199374);
        return paramString;
      }
      catch (Exception paramString)
      {
        label130:
        ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label88;
      label153:
      paramString = null;
    }
  }
  
  private static String aKN(String paramString)
  {
    AppMethodBeat.i(199380);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.aD(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199380);
      return "";
    }
    paramString = n.h(paramString, ",", "", false);
    AppMethodBeat.o(199380);
    return paramString;
  }
  
  private static String aX(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(182661);
    p.h(paramString1, "$this$musicId");
    p.h(paramString2, "albumId");
    paramString1 = paramString3 + '_' + paramString2 + '_' + paramString1;
    AppMethodBeat.o(182661);
    return paramString1;
  }
  
  private final void b(mg parammg)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(199378);
        Object localObject2 = parammg.dAP.dAJ;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.ay.a.aKc();
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(199378);
          return;
        }
        if (bu.isNullOrNil(this.EHl))
        {
          localObject2 = ((f)localObject1).ijZ;
          p.g(localObject2, "musicWrapper.MusicId");
          this.EHl = ((String)localObject2);
          this.EHk = String.valueOf(System.currentTimeMillis());
        }
        ae.i("MicroMsg.MusicAlbumHelper", "doWebViewReport musicId = " + this.EHl + ", playId=" + this.EHk + ", playActionSource=" + this.EHj + "，action=" + parammg.dAP.action);
        switch (parammg.dAP.action)
        {
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
          if (!bu.lX(this.EHl, ((f)localObject1).ijZ))
          {
            localObject1 = ((f)localObject1).ijZ;
            p.g(localObject1, "musicWrapper.MusicId");
            this.EHl = ((String)localObject1);
            this.EHk = String.valueOf(System.currentTimeMillis());
            ae.i("MicroMsg.MusicAlbumHelper", "doWebViewReport new music musicId = " + this.EHl + ", playId=" + this.EHk);
          }
          switch (parammg.dAP.action)
          {
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 10: 
            AppMethodBeat.o(199378);
          }
          break;
        case 3: 
          a(aKM(this.EHl), 4);
        }
      }
      finally {}
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 7);
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 8);
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 9);
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 100);
      AppMethodBeat.o(199378);
      continue;
      this.EHj = 2;
      AppMethodBeat.o(199378);
      continue;
      this.EHj = 3;
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 1);
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 2);
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 3);
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 5);
      AppMethodBeat.o(199378);
      continue;
      a(aKM(this.EHl), 6);
      continue;
    }
  }
  
  private static String lj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199373);
    p.h(paramString1, "$this$albumInfoKey");
    paramString1 = "album_" + paramString2 + '_' + paramString1 + '}';
    AppMethodBeat.o(199373);
    return paramString1;
  }
  
  private final egk ll(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199376);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.aD((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.aD((CharSequence)localObject))) {
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
      AppMethodBeat.o(199376);
      return null;
      i = 0;
      break;
    }
    label74:
    localObject = (ay)this.DSc.fnP();
    paramString1 = lj(paramString1, paramString2);
    if (((ay)localObject).containsKey(paramString1))
    {
      paramString1 = ((ay)localObject).decodeBytes(paramString1);
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
        paramString2 = egk.class.newInstance();
        ((com.tencent.mm.bw.a)paramString2).parseFrom(paramString1);
        paramString1 = (com.tencent.mm.bw.a)paramString2;
        paramString1 = (egk)paramString1;
        AppMethodBeat.o(199376);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        label168:
        ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString1, "decode ProtoBuffer", new Object[0]);
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
    ae.d("MicroMsg.MusicAlbumHelper", "stop timer");
    this.lxR.stopTimer();
    AppMethodBeat.o(182671);
  }
  
  public final String aKL(String paramString)
  {
    try
    {
      AppMethodBeat.i(182667);
      paramString = lk(((ay)this.DSc.fnP()).decodeString("currentAlbumId"), paramString);
      AppMethodBeat.o(182667);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String aKO(String paramString)
  {
    AppMethodBeat.i(199381);
    paramString = aKM(paramString);
    if (paramString != null)
    {
      paramString = paramString.Ikk;
      AppMethodBeat.o(199381);
      return paramString;
    }
    AppMethodBeat.o(199381);
    return null;
  }
  
  public final String aKP(String paramString)
  {
    AppMethodBeat.i(199382);
    paramString = aKM(paramString);
    if (paramString != null)
    {
      paramString = paramString.ddg;
      AppMethodBeat.o(199382);
      return paramString;
    }
    AppMethodBeat.o(199382);
    return null;
  }
  
  public final void eYR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182670);
        Object localObject1 = com.tencent.mm.ay.a.aKc();
        if (localObject1 == null) {
          break label262;
        }
        if (((f)localObject1).ijZ == null)
        {
          AppMethodBeat.o(182670);
          return;
        }
        Object localObject5 = com.tencent.mm.ay.a.aKd();
        if (localObject5 == null) {
          break label253;
        }
        Object localObject4 = (ay)this.DSc.fnP();
        Object localObject6 = aKM(((f)localObject1).ijZ);
        if (localObject6 == null) {
          break label244;
        }
        if (((egl)localObject6).Ikj < 0) {
          break label235;
        }
        if (((com.tencent.mm.ay.c)localObject5).getPosition() > 0) {
          ((egl)localObject6).Ikj = ((com.tencent.mm.ay.c)localObject5).getPosition();
        }
        ((egl)localObject6).duration = Math.max(0, ((com.tencent.mm.ay.c)localObject5).getDuration());
        a(((f)localObject1).ijZ, (egl)localObject6);
        localObject5 = aKO(((f)localObject1).ijZ);
        localObject6 = aKP(((f)localObject1).ijZ);
        localObject1 = aKM(((f)localObject1).ijZ);
        if (localObject1 != null)
        {
          localObject1 = ((egl)localObject1).EYb;
          if ((bu.isNullOrNil((String)localObject5)) || (bu.isNullOrNil((String)localObject6))) {
            break label235;
          }
          ((ay)localObject4).encode("currentAlbumId", (String)localObject5);
          localObject4 = ll((String)localObject5, (String)localObject1);
          if (localObject4 == null) {
            break label235;
          }
          egk localegk = this.EHh;
          if (localegk != null) {
            localegk.Ikh = ((String)localObject6);
          }
          ((egk)localObject4).Ikh = ((String)localObject6);
          a((String)localObject5, (String)localObject1, (egk)localObject4);
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
    if ((bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString3)))
    {
      ae.i("MicroMsg.MusicAlbumHelper", "playAudioList invalid params");
      AppMethodBeat.o(182669);
      return false;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray(paramString2);
      if (localJSONArray.length() <= 0)
      {
        ae.i("MicroMsg.MusicAlbumHelper", "playAudioList invalid mAudioList");
        AppMethodBeat.o(182669);
        return false;
      }
    }
    catch (Exception paramString1)
    {
      ae.w("MicroMsg.MusicAlbumHelper", "setAudioList ex:%s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(182669);
      return false;
    }
    localList = (List)new ArrayList();
    try
    {
      this.EHh = new egk();
      this.EHi = paramString1;
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
          if ((bu.isNullOrNil((String)localObject2)) || (bu.isNullOrNil(str6)))
          {
            ae.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, src or title is null");
            AppMethodBeat.o(182669);
            return false;
          }
          Object localObject3 = this.EHh;
          if (localObject3 != null)
          {
            localObject3 = ((egk)localObject3).Iki;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(str2);
            }
          }
          localObject2 = com.tencent.mm.ay.g.a(10, str9, str6, str8, str10, str11, (String)localObject2, str1, b.asj(), d.azQ() + str9.hashCode(), str7, paramString5);
          ((f)localObject2).ikw = paramString4;
          ((f)localObject2).dez = (m * 1000);
          ((f)localObject2).ikx = paramString2;
          ((f)localObject2).protocol = ((String)localObject1);
          ((f)localObject2).ikz = str3;
          ((f)localObject2).iki = str4;
          ((f)localObject2).dIt = str5;
          ((f)localObject2).hOB = d1;
          ((f)localObject2).volume = ((float)d2);
          localObject1 = aKM(str1);
          paramString2 = (String)localObject1;
          if (localObject1 == null) {
            paramString2 = new egl();
          }
          if (paramString2.Ikj <= 0)
          {
            paramString2.Ikj = 0;
            paramString2.Ikk = paramString1;
            paramString2.ddg = str2;
            paramString2.Ikq = ((float)d1);
            localObject1 = localJSONObject.optJSONObject("reportData");
            if (localObject1 != null)
            {
              paramString2.dui = ((JSONObject)localObject1).optInt("VoiceType", 0);
              paramString2.HVD = ((JSONObject)localObject1).optString("BizUin", "");
              paramString2.msgId = ((JSONObject)localObject1).optLong("MsgId", 0L);
              paramString2.idx = ((JSONObject)localObject1).optInt("Idx", 0);
              paramString2.Ikl = ((JSONObject)localObject1).optString("SessionIdStr", "0");
              paramString2.Ikm = ((JSONObject)localObject1).optString("AlbumURL", "");
              paramString2.Ikn = ((JSONObject)localObject1).optString("AlbumTitle", "");
              paramString2.Iko = ((JSONObject)localObject1).optString("AudioTitle", "");
              paramString2.ogK = ((JSONObject)localObject1).optLong("EnterId", 0L);
              paramString2.scene = ((JSONObject)localObject1).optInt("Scene", 0);
              paramString2.otZ = ((JSONObject)localObject1).optInt("SubScene", 0);
              paramString2.Ikp = ((JSONObject)localObject1).optInt("AudioPos", 0);
            }
            paramString2.EYb = paramString4;
            a(str1, paramString2);
          }
          p.g(localObject2, "wrapper");
          localList.add(localObject2);
          j += 1;
          break;
          paramString2 = this.EHh;
          if (paramString2 == null) {
            p.gkB();
          }
          a(paramString1, paramString4, paramString2);
          break label204;
          this.EHj = 1;
          com.tencent.mm.ay.a.f(localList, i);
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
      ae.w("MicroMsg.MusicAlbumHelper", "playAudioList ex:%s", new Object[] { paramString1.getMessage() });
      if (!bu.ht(localList)) {
        break label981;
      }
      ae.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, wrapperList is null");
      AppMethodBeat.o(182669);
      return false;
      localJSONObject = (JSONObject)paramString2;
      str2 = localJSONObject.optString("audioId", "");
      if (bu.isNullOrNil(str2))
      {
        ae.i("MicroMsg.MusicAlbumHelper", "playAudioList audioId is empty");
        AppMethodBeat.o(182669);
        return false;
      }
      p.g(str2, "audioId");
      if (paramString1 == null) {
        p.gkB();
      }
      str1 = aX(str2, paramString1, paramString4);
      bool = p.i(str2, paramString3);
      if (!bool) {
        break label1011;
      }
      i = j;
    }
  }
  
  public final String lk(String paramString1, String paramString2)
  {
    label454:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182668);
        if (bu.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(182668);
          paramString1 = null;
          return paramString1;
        }
        eYR();
        Object localObject1;
        if ((bu.lX(paramString1, this.EHi)) && (this.EHh != null))
        {
          localObject1 = this.EHh;
          if (localObject1 == null) {
            p.gkB();
          }
          localObject1 = ((egk)localObject1).Iki;
          if (bu.ht((List)localObject1))
          {
            AppMethodBeat.o(182668);
            paramString1 = null;
          }
        }
        else
        {
          localObject1 = ll(paramString1, paramString2);
          if (localObject1 != null)
          {
            this.EHh = ((egk)localObject1);
            this.EHi = paramString1;
            localObject1 = ((egk)localObject1).Iki;
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
          Object localObject2 = this.EHh;
          if (localObject2 != null)
          {
            str = ((egk)localObject2).Ikh;
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
          if (!n.aD((CharSequence)localObject1)) {
            continue;
          }
        }
        catch (Exception paramString1)
        {
          String str;
          JSONObject localJSONObject2;
          ae.w("MicroMsg.MusicAlbumHelper", "getAudioListState ex:%s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(182668);
          paramString1 = null;
        }
        if (i == 0)
        {
          if (paramString1 == null) {
            p.gkB();
          }
          localObject1 = aKM(aX(str, paramString1, paramString2));
          localJSONObject2 = new JSONObject();
          if (localObject1 != null)
          {
            i = ((egl)localObject1).Ikj;
            localJSONObject2.put("currentTime", i / 1000);
            if (localObject1 != null)
            {
              i = ((egl)localObject1).duration;
              localJSONObject2.put("duration", i / 1000);
              if (localObject1 == null) {
                continue;
              }
              localObject1 = Float.valueOf(((egl)localObject1).Ikq);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$Companion;", "", "()V", "TAG", "", "albumDelimiter", "currentAlbumIdKey", "<set-?>", "Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "instance", "getInstance", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "setInstance", "(Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;)V", "plugin-webview_release"})
  public static final class a
  {
    public static i eYT()
    {
      AppMethodBeat.i(182656);
      if (i.eYS() == null) {}
      try
      {
        if (i.eYS() == null)
        {
          localObject1 = ak.getContext();
          p.g(localObject1, "MMApplicationContext.getContext()");
          i.d(new i((Context)localObject1, (byte)0));
          localObject1 = i.eYS();
          if (localObject1 != null)
          {
            localObject1 = ((i)localObject1).kzS;
            if (localObject1 != null) {
              ((com.tencent.mm.sdk.b.c)localObject1).alive();
            }
          }
        }
        Object localObject1 = z.Nhr;
        localObject1 = i.eYS();
        AppMethodBeat.o(182656);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(182656);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements aw.a
  {
    b(i parami) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(182659);
      this.EHo.eYR();
      AppMethodBeat.o(182659);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-webview_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<mg>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.i
 * JD-Core Version:    0.7.0.1
 */