package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.az.g;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.ln.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.protobuf.dtb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "", "ct", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "lastMusicId", "", "getLastMusicId", "()Ljava/lang/String;", "setLastMusicId", "(Ljava/lang/String;)V", "mContext", "mCurrentAlbumId", "mWebViewAlbumInfo", "Lcom/tencent/mm/protocal/protobuf/WebViewAlbumInfo;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicPlayerListener", "()Lcom/tencent/mm/sdk/event/IListener;", "playActionSource", "", "getPlayActionSource", "()I", "setPlayActionSource", "(I)V", "playId", "getPlayId", "setPlayId", "doReport", "", "event", "info", "Lcom/tencent/mm/protocal/protobuf/WebViewAudioInfo;", "eventType", "formatReportData", "data", "getAlbumIdFromMusicId", "musicId", "getAudioIdFromMusicId", "getAudioListState", "domain", "albumId", "getDomainFromMusicId", "getWebViewAlbumInfoInfo", "getWebViewAudioInfo", "playAudioList", "", "playAudioId", "appId", "saveCurrentAudioPlayTime", "saveWebViewAlbumInfoInfo", "saveWebViewAudioInfo", "startTimer", "stopTimer", "albumInfoKey", "audioInfoKey", "Companion", "plugin-webview_release"})
public final class h
{
  private static h Btl;
  public static final a Btm;
  private dta Btf;
  private String Btg;
  private final ar Bth;
  private int Bti;
  private String Btj;
  private String Btk;
  final com.tencent.mm.sdk.b.c<ln> jBI;
  private av kvf;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(182673);
    Btm = new a((byte)0);
    AppMethodBeat.o(182673);
  }
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(182672);
    this.Btg = "";
    ax localax = ax.aFC("__web_music_slot_mmkv_key__");
    k.g(localax, "MultiProcessMMKV.getMMKV…b_music_slot_mmkv_key__\")");
    this.Bth = new ar(localax, 15552000L);
    this.jBI = ((com.tencent.mm.sdk.b.c)new c(this));
    this.kvf = new av("MicroMsg.MusicAlbumHelper", (av.a)new b(this), true);
    this.Bti = 1;
    this.Btj = "";
    this.Btk = "";
    this.mContext = paramContext;
    AppMethodBeat.o(182672);
  }
  
  private final void a(dtb paramdtb, int paramInt)
  {
    AppMethodBeat.i(188912);
    if (paramdtb == null)
    {
      AppMethodBeat.o(188912);
      return;
    }
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.report.service.h.vKh.f(19839, new Object[] { paramdtb.Euj, Long.valueOf(paramdtb.msgId), Integer.valueOf(paramdtb.idx), paramdtb.EHL, paramdtb.cTr, Integer.valueOf(paramdtb.dkj), Long.valueOf(paramdtb.mXp), paramdtb.EHM, Integer.valueOf(paramdtb.scene), Integer.valueOf(paramdtb.niJ), this.Btj, Integer.valueOf(paramdtb.duration), Integer.valueOf(paramdtb.EHK), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(this.Bti), x.aCL(paramdtb.EHN), Integer.valueOf(paramdtb.EHQ), ayC(paramdtb.EHO), ayC(paramdtb.EHP) });
    AppMethodBeat.o(188912);
  }
  
  private final void a(String paramString, dtb paramdtb)
  {
    AppMethodBeat.i(188908);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aC((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(188908);
      return;
    }
    localObject = (ax)this.Bth.eEX();
    try
    {
      ((ax)localObject).encode(ayz(paramString), paramdtb.toByteArray());
      AppMethodBeat.o(188908);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MusicAlbumHelper", "saveWebViewAudioInfo ex " + paramString.getMessage());
      AppMethodBeat.o(188908);
    }
  }
  
  private final void a(String paramString1, String paramString2, dta paramdta)
  {
    AppMethodBeat.i(188910);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.aC((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.aC((CharSequence)localObject))) {
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
      AppMethodBeat.o(188910);
      return;
      i = 0;
      break;
    }
    label79:
    localObject = (ax)this.Bth.eEX();
    try
    {
      ((ax)localObject).encode(kj(paramString1, paramString2), paramdta.toByteArray());
      AppMethodBeat.o(188910);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.MusicAlbumHelper", "saveWebViewAlbumInfoInfo ex " + paramString1.getMessage());
      AppMethodBeat.o(188910);
    }
  }
  
  private static String aL(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(182661);
    k.h(paramString1, "$this$musicId");
    k.h(paramString2, "albumId");
    paramString1 = paramString3 + '_' + paramString2 + '_' + paramString1;
    AppMethodBeat.o(182661);
    return paramString1;
  }
  
  private final dtb ayB(String paramString)
  {
    AppMethodBeat.i(188907);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aC((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(188907);
      return null;
    }
    localObject = (ax)this.Bth.eEX();
    paramString = ayz(paramString);
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
        localObject = dtb.class.newInstance();
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bx.a)localObject;
        paramString = (dtb)paramString;
        AppMethodBeat.o(188907);
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
  
  private static String ayC(String paramString)
  {
    AppMethodBeat.i(188913);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.aC(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(188913);
      return "";
    }
    paramString = n.h(paramString, ",", "", false);
    AppMethodBeat.o(188913);
    return paramString;
  }
  
  private static String ayz(String paramString)
  {
    AppMethodBeat.i(188905);
    k.h(paramString, "$this$audioInfoKey");
    paramString = "audioInfo_" + paramString + '}';
    AppMethodBeat.o(188905);
    return paramString;
  }
  
  private final void b(ln paramln)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(188911);
        Object localObject2 = paramln.dql.dqf;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.az.a.azI();
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(188911);
          return;
        }
        if (bt.isNullOrNil(this.Btk))
        {
          localObject2 = ((f)localObject1).hnp;
          k.g(localObject2, "musicWrapper.MusicId");
          this.Btk = ((String)localObject2);
          this.Btj = String.valueOf(System.currentTimeMillis());
        }
        ad.i("MicroMsg.MusicAlbumHelper", "doWebViewReport musicId = " + this.Btk + ", playId=" + this.Btj + ", playActionSource=" + this.Bti + "，action=" + paramln.dql.action);
        switch (paramln.dql.action)
        {
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
          if (!bt.kU(this.Btk, ((f)localObject1).hnp))
          {
            localObject1 = ((f)localObject1).hnp;
            k.g(localObject1, "musicWrapper.MusicId");
            this.Btk = ((String)localObject1);
            this.Btj = String.valueOf(System.currentTimeMillis());
            ad.i("MicroMsg.MusicAlbumHelper", "doWebViewReport new music musicId = " + this.Btk + ", playId=" + this.Btj);
          }
          switch (paramln.dql.action)
          {
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 10: 
            AppMethodBeat.o(188911);
          }
          break;
        case 3: 
          a(ayB(this.Btk), 4);
        }
      }
      finally {}
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 7);
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 8);
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 9);
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 100);
      AppMethodBeat.o(188911);
      continue;
      this.Bti = 2;
      AppMethodBeat.o(188911);
      continue;
      this.Bti = 3;
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 1);
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 2);
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 3);
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 5);
      AppMethodBeat.o(188911);
      continue;
      a(ayB(this.Btk), 6);
      continue;
    }
  }
  
  private static String kj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188906);
    k.h(paramString1, "$this$albumInfoKey");
    paramString1 = "album_" + paramString2 + '_' + paramString1 + '}';
    AppMethodBeat.o(188906);
    return paramString1;
  }
  
  private final dta kl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188909);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.aC((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.aC((CharSequence)localObject))) {
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
      AppMethodBeat.o(188909);
      return null;
      i = 0;
      break;
    }
    label74:
    localObject = (ax)this.Bth.eEX();
    paramString1 = kj(paramString1, paramString2);
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
        paramString2 = dta.class.newInstance();
        ((com.tencent.mm.bx.a)paramString2).parseFrom(paramString1);
        paramString1 = (com.tencent.mm.bx.a)paramString2;
        paramString1 = (dta)paramString1;
        AppMethodBeat.o(188909);
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
    this.kvf.stopTimer();
    AppMethodBeat.o(182671);
  }
  
  public final String ayA(String paramString)
  {
    try
    {
      AppMethodBeat.i(182667);
      paramString = kk(((ax)this.Bth.eEX()).decodeString("currentAlbumId"), paramString);
      AppMethodBeat.o(182667);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String ayD(String paramString)
  {
    AppMethodBeat.i(188914);
    paramString = ayB(paramString);
    if (paramString != null)
    {
      paramString = paramString.EHL;
      AppMethodBeat.o(188914);
      return paramString;
    }
    AppMethodBeat.o(188914);
    return null;
  }
  
  public final String ayE(String paramString)
  {
    AppMethodBeat.i(188915);
    paramString = ayB(paramString);
    if (paramString != null)
    {
      paramString = paramString.cTr;
      AppMethodBeat.o(188915);
      return paramString;
    }
    AppMethodBeat.o(188915);
    return null;
  }
  
  public final void eqN()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182670);
        Object localObject1 = com.tencent.mm.az.a.azI();
        if (localObject1 == null) {
          break label262;
        }
        if (((f)localObject1).hnp == null)
        {
          AppMethodBeat.o(182670);
          return;
        }
        Object localObject5 = com.tencent.mm.az.a.azJ();
        if (localObject5 == null) {
          break label253;
        }
        Object localObject4 = (ax)this.Bth.eEX();
        Object localObject6 = ayB(((f)localObject1).hnp);
        if (localObject6 == null) {
          break label244;
        }
        if (((dtb)localObject6).EHK < 0) {
          break label235;
        }
        if (((com.tencent.mm.az.c)localObject5).getPosition() > 0) {
          ((dtb)localObject6).EHK = ((com.tencent.mm.az.c)localObject5).getPosition();
        }
        ((dtb)localObject6).duration = Math.max(0, ((com.tencent.mm.az.c)localObject5).getDuration());
        a(((f)localObject1).hnp, (dtb)localObject6);
        localObject5 = ayD(((f)localObject1).hnp);
        localObject6 = ayE(((f)localObject1).hnp);
        localObject1 = ayB(((f)localObject1).hnp);
        if (localObject1 != null)
        {
          localObject1 = ((dtb)localObject1).BJx;
          if ((bt.isNullOrNil((String)localObject5)) || (bt.isNullOrNil((String)localObject6))) {
            break label235;
          }
          ((ax)localObject4).encode("currentAlbumId", (String)localObject5);
          localObject4 = kl((String)localObject5, (String)localObject1);
          if (localObject4 == null) {
            break label235;
          }
          dta localdta = this.Btf;
          if (localdta != null) {
            localdta.EHI = ((String)localObject6);
          }
          ((dta)localObject4).EHI = ((String)localObject6);
          a((String)localObject5, (String)localObject1, (dta)localObject4);
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
      this.Btf = new dta();
      this.Btg = paramString1;
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
          break label991;
        }
        if (d1 <= 2.0D) {
          break label985;
        }
        for (;;)
        {
          String str4 = localJSONObject.optString("songLyric", "");
          String str5 = localJSONObject.optString("src_username", "");
          if ((bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil(str6)))
          {
            ad.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, src or title is null");
            AppMethodBeat.o(182669);
            return false;
          }
          Object localObject3 = this.Btf;
          if (localObject3 != null)
          {
            localObject3 = ((dta)localObject3).EHJ;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(str2);
            }
          }
          localObject2 = g.a(10, str9, str6, str8, str10, str11, (String)localObject2, str1, b.aih(), d.apW() + str9.hashCode(), str7, paramString5);
          ((f)localObject2).hnM = paramString4;
          ((f)localObject2).cUL = 0;
          ((f)localObject2).hnN = paramString2;
          ((f)localObject2).protocol = ((String)localObject1);
          ((f)localObject2).hnP = str3;
          ((f)localObject2).hny = str4;
          ((f)localObject2).dxz = str5;
          ((f)localObject2).gSR = d1;
          ((f)localObject2).volume = ((float)d2);
          localObject1 = ayB(str1);
          paramString2 = (String)localObject1;
          if (localObject1 == null) {
            paramString2 = new dtb();
          }
          if (paramString2.EHK <= 0)
          {
            paramString2.EHK = 0;
            paramString2.EHL = paramString1;
            paramString2.cTr = str2;
            localObject1 = localJSONObject.optJSONObject("reportData");
            if (localObject1 != null)
            {
              paramString2.dkj = ((JSONObject)localObject1).optInt("VoiceType", 0);
              paramString2.Euj = ((JSONObject)localObject1).optString("BizUin", "");
              paramString2.msgId = ((JSONObject)localObject1).optLong("MsgId", 0L);
              paramString2.idx = ((JSONObject)localObject1).optInt("Idx", 0);
              paramString2.EHM = ((JSONObject)localObject1).optString("SessionIdStr", "0");
              paramString2.EHN = ((JSONObject)localObject1).optString("AlbumURL", "");
              paramString2.EHO = ((JSONObject)localObject1).optString("AlbumTitle", "");
              paramString2.EHP = ((JSONObject)localObject1).optString("AudioTitle", "");
              paramString2.mXp = ((JSONObject)localObject1).optLong("EnterId", 0L);
              paramString2.scene = ((JSONObject)localObject1).optInt("Scene", 0);
              paramString2.niJ = ((JSONObject)localObject1).optInt("SubScene", 0);
              paramString2.EHQ = ((JSONObject)localObject1).optInt("AudioPos", 0);
            }
            paramString2.BJx = paramString4;
            a(str1, paramString2);
          }
          k.g(localObject2, "wrapper");
          localList.add(localObject2);
          j += 1;
          break;
          paramString2 = this.Btf;
          if (paramString2 == null) {
            k.fvU();
          }
          a(paramString1, paramString4, paramString2);
          break label204;
          this.Bti = 1;
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
      if (!bt.gL(localList)) {
        break label958;
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
      k.g(str2, "audioId");
      if (paramString1 == null) {
        k.fvU();
      }
      str1 = aL(str2, paramString1, paramString4);
      bool = k.g(str2, paramString3);
      if (!bool) {
        break label988;
      }
      i = j;
    }
  }
  
  public final String kk(String paramString1, String paramString2)
  {
    label419:
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
        eqN();
        Object localObject1;
        if ((bt.kU(paramString1, this.Btg)) && (this.Btf != null))
        {
          localObject1 = this.Btf;
          if (localObject1 == null) {
            k.fvU();
          }
          localObject1 = ((dta)localObject1).EHJ;
          if (bt.gL((List)localObject1))
          {
            AppMethodBeat.o(182668);
            paramString1 = null;
          }
        }
        else
        {
          localObject1 = kl(paramString1, paramString2);
          if (localObject1 != null)
          {
            this.Btf = ((dta)localObject1);
            this.Btg = paramString1;
            localObject1 = ((dta)localObject1).EHJ;
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
          localObject2 = this.Btf;
          if (localObject2 != null)
          {
            localObject3 = ((dta)localObject2).EHI;
            localObject2 = localObject3;
            if (localObject3 != null) {}
          }
          else
          {
            localObject2 = Integer.valueOf(0);
          }
          localJSONObject1.put("audioId", localObject2);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = (CharSequence)localObject2;
          if (localObject3 == null) {
            break label419;
          }
          if (!n.aC((CharSequence)localObject3)) {
            continue;
          }
        }
        catch (Exception paramString1)
        {
          Object localObject2;
          Object localObject3;
          JSONObject localJSONObject2;
          ad.w("MicroMsg.MusicAlbumHelper", "getAudioListState ex:%s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(182668);
          paramString1 = null;
        }
        if (i == 0)
        {
          if (paramString1 == null) {
            k.fvU();
          }
          localObject3 = ayB(aL((String)localObject2, paramString1, paramString2));
          localJSONObject2 = new JSONObject();
          if (localObject3 != null)
          {
            i = ((dtb)localObject3).EHK;
            localJSONObject2.put("currentTime", i / 1000);
            if (localObject3 != null)
            {
              i = ((dtb)localObject3).duration;
              localJSONObject2.put("duration", i / 1000);
              localJSONObject1.put((String)localObject2, localJSONObject2);
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
          paramString1 = localJSONObject1.toString();
          AppMethodBeat.o(182668);
          continue;
          i = 1;
        }
      }
      finally {}
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$Companion;", "", "()V", "TAG", "", "albumDelimiter", "currentAlbumIdKey", "<set-?>", "Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "instance", "getInstance", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "setInstance", "(Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;)V", "plugin-webview_release"})
  public static final class a
  {
    public static h eqP()
    {
      AppMethodBeat.i(182656);
      if (h.eqO() == null) {}
      try
      {
        if (h.eqO() == null)
        {
          localObject1 = aj.getContext();
          k.g(localObject1, "MMApplicationContext.getContext()");
          h.d(new h((Context)localObject1, (byte)0));
          localObject1 = h.eqO();
          if (localObject1 != null)
          {
            localObject1 = ((h)localObject1).jBI;
            if (localObject1 != null) {
              ((com.tencent.mm.sdk.b.c)localObject1).alive();
            }
          }
        }
        Object localObject1 = y.JfV;
        localObject1 = h.eqO();
        AppMethodBeat.o(182656);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(182656);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements av.a
  {
    b(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(182659);
      this.Btn.eqN();
      AppMethodBeat.o(182659);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-webview_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<ln>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h
 * JD-Core Version:    0.7.0.1
 */