package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.g;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.mx.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.faw;
import com.tencent.mm.protocal.protobuf.fax;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "", "ct", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "lastMusicId", "", "getLastMusicId", "()Ljava/lang/String;", "setLastMusicId", "(Ljava/lang/String;)V", "mContext", "mCurrentAlbumId", "mWebViewAlbumInfo", "Lcom/tencent/mm/protocal/protobuf/WebViewAlbumInfo;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicPlayerListener", "()Lcom/tencent/mm/sdk/event/IListener;", "playActionSource", "", "getPlayActionSource", "()I", "setPlayActionSource", "(I)V", "playId", "getPlayId", "setPlayId", "doReport", "", "event", "info", "Lcom/tencent/mm/protocal/protobuf/WebViewAudioInfo;", "eventType", "formatReportData", "data", "getAlbumIdFromMusicId", "musicId", "getAudioIdFromMusicId", "getAudioListState", "domain", "albumId", "getDomainFromMusicId", "getWebViewAlbumInfoInfo", "getWebViewAudioInfo", "playAudioList", "", "playAudioId", "appId", "saveCurrentAudioPlayTime", "saveWebViewAlbumInfoInfo", "saveWebViewAudioInfo", "startTimer", "stopTimer", "albumInfoKey", "audioInfoKey", "Companion", "plugin-webview_release"})
public final class i
{
  private static i JwQ;
  public static final a JwR;
  private faw JwL;
  private String JwM;
  private int JwN;
  private String JwO;
  private String JwP;
  final IListener<mx> lEl;
  private Context mContext;
  private MTimerHandler mEP;
  private final MMKVSlotManager pvV;
  
  static
  {
    AppMethodBeat.i(182673);
    JwR = new a((byte)0);
    AppMethodBeat.o(182673);
  }
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(182672);
    this.JwM = "";
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__web_music_slot_mmkv_key__");
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…b_music_slot_mmkv_key__\")");
    this.pvV = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
    this.lEl = ((IListener)new c(this));
    this.mEP = new MTimerHandler("MicroMsg.MusicAlbumHelper", (MTimerHandler.CallBack)new b(this), true);
    this.JwN = 1;
    this.JwO = "";
    this.JwP = "";
    this.mContext = paramContext;
    AppMethodBeat.o(182672);
  }
  
  private final void a(fax paramfax, int paramInt)
  {
    AppMethodBeat.i(210571);
    if (paramfax == null)
    {
      AppMethodBeat.o(210571);
      return;
    }
    long l = System.currentTimeMillis();
    h.CyF.a(19839, new Object[] { paramfax.NhM, Long.valueOf(paramfax.msgId), Integer.valueOf(paramfax.idx), paramfax.Nxj, paramfax.dtX, Integer.valueOf(paramfax.dLt), Long.valueOf(paramfax.prZ), paramfax.Nxk, Integer.valueOf(paramfax.scene), Integer.valueOf(paramfax.pHw), this.JwO, Integer.valueOf(paramfax.duration), Integer.valueOf(paramfax.Dzt), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(this.JwN), z.bfG(paramfax.Nxl), Integer.valueOf(paramfax.Nxo), bbc(paramfax.Nxm), bbc(paramfax.Nxn) });
    AppMethodBeat.o(210571);
  }
  
  private final void a(String paramString, fax paramfax)
  {
    AppMethodBeat.i(210567);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(210567);
      return;
    }
    localObject = (MultiProcessMMKV)this.pvV.getSlot();
    try
    {
      ((MultiProcessMMKV)localObject).encode(baZ(paramString), paramfax.toByteArray());
      AppMethodBeat.o(210567);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MusicAlbumHelper", "saveWebViewAudioInfo ex " + paramString.getMessage());
      AppMethodBeat.o(210567);
    }
  }
  
  private final void a(String paramString1, String paramString2, faw paramfaw)
  {
    AppMethodBeat.i(210569);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.aL((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.aL((CharSequence)localObject))) {
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
      AppMethodBeat.o(210569);
      return;
      i = 0;
      break;
    }
    label79:
    localObject = (MultiProcessMMKV)this.pvV.getSlot();
    try
    {
      ((MultiProcessMMKV)localObject).encode(mi(paramString1, paramString2), paramfaw.toByteArray());
      AppMethodBeat.o(210569);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.MusicAlbumHelper", "saveWebViewAlbumInfoInfo ex " + paramString1.getMessage());
      AppMethodBeat.o(210569);
    }
  }
  
  private static String baZ(String paramString)
  {
    AppMethodBeat.i(210564);
    p.h(paramString, "$this$audioInfoKey");
    paramString = "audioInfo_" + paramString + '}';
    AppMethodBeat.o(210564);
    return paramString;
  }
  
  private final fax bbb(String paramString)
  {
    AppMethodBeat.i(210566);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(210566);
      return null;
    }
    localObject = (MultiProcessMMKV)this.pvV.getSlot();
    paramString = baZ(paramString);
    if (((MultiProcessMMKV)localObject).containsKey(paramString))
    {
      paramString = ((MultiProcessMMKV)localObject).decodeBytes(paramString);
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
        localObject = fax.class.newInstance();
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bw.a)localObject;
        paramString = (fax)paramString;
        AppMethodBeat.o(210566);
        return paramString;
      }
      catch (Exception paramString)
      {
        label130:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label88;
      label153:
      paramString = null;
    }
  }
  
  private static String bbc(String paramString)
  {
    AppMethodBeat.i(210572);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.aL(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(210572);
      return "";
    }
    paramString = n.j(paramString, ",", "", false);
    AppMethodBeat.o(210572);
    return paramString;
  }
  
  private static String bh(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(182661);
    p.h(paramString1, "$this$musicId");
    p.h(paramString2, "albumId");
    paramString1 = paramString3 + '_' + paramString2 + '_' + paramString1;
    AppMethodBeat.o(182661);
    return paramString1;
  }
  
  private final void c(mx parammx)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210570);
        Object localObject2 = parammx.dSE.dSy;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.ay.a.bef();
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(210570);
          return;
        }
        if (Util.isNullOrNil(this.JwP))
        {
          localObject2 = ((f)localObject1).jeV;
          p.g(localObject2, "musicWrapper.MusicId");
          this.JwP = ((String)localObject2);
          this.JwO = String.valueOf(System.currentTimeMillis());
        }
        Log.i("MicroMsg.MusicAlbumHelper", "doWebViewReport musicId = " + this.JwP + ", playId=" + this.JwO + ", playActionSource=" + this.JwN + "，action=" + parammx.dSE.action);
        switch (parammx.dSE.action)
        {
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
          if (!Util.isEqual(this.JwP, ((f)localObject1).jeV))
          {
            localObject1 = ((f)localObject1).jeV;
            p.g(localObject1, "musicWrapper.MusicId");
            this.JwP = ((String)localObject1);
            this.JwO = String.valueOf(System.currentTimeMillis());
            Log.i("MicroMsg.MusicAlbumHelper", "doWebViewReport new music musicId = " + this.JwP + ", playId=" + this.JwO);
          }
          switch (parammx.dSE.action)
          {
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 10: 
            AppMethodBeat.o(210570);
          }
          break;
        case 3: 
          a(bbb(this.JwP), 4);
        }
      }
      finally {}
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 7);
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 8);
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 9);
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 100);
      AppMethodBeat.o(210570);
      continue;
      this.JwN = 2;
      AppMethodBeat.o(210570);
      continue;
      this.JwN = 3;
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 1);
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 2);
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 3);
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 5);
      AppMethodBeat.o(210570);
      continue;
      a(bbb(this.JwP), 6);
      continue;
    }
  }
  
  private static String mi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210565);
    p.h(paramString1, "$this$albumInfoKey");
    paramString1 = "album_" + paramString2 + '_' + paramString1 + '}';
    AppMethodBeat.o(210565);
    return paramString1;
  }
  
  private final faw mk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210568);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.aL((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.aL((CharSequence)localObject))) {
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
      AppMethodBeat.o(210568);
      return null;
      i = 0;
      break;
    }
    label74:
    localObject = (MultiProcessMMKV)this.pvV.getSlot();
    paramString1 = mi(paramString1, paramString2);
    if (((MultiProcessMMKV)localObject).containsKey(paramString1))
    {
      paramString1 = ((MultiProcessMMKV)localObject).decodeBytes(paramString1);
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
        paramString2 = faw.class.newInstance();
        ((com.tencent.mm.bw.a)paramString2).parseFrom(paramString1);
        paramString1 = (com.tencent.mm.bw.a)paramString2;
        paramString1 = (faw)paramString1;
        AppMethodBeat.o(210568);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        label168:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString1, "decode ProtoBuffer", new Object[0]);
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
    Log.d("MicroMsg.MusicAlbumHelper", "stop timer");
    this.mEP.stopTimer();
    AppMethodBeat.o(182671);
  }
  
  public final String bba(String paramString)
  {
    try
    {
      AppMethodBeat.i(182667);
      paramString = mj(((MultiProcessMMKV)this.pvV.getSlot()).decodeString("currentAlbumId"), paramString);
      AppMethodBeat.o(182667);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String bbd(String paramString)
  {
    AppMethodBeat.i(210573);
    paramString = bbb(paramString);
    if (paramString != null)
    {
      paramString = paramString.Nxj;
      AppMethodBeat.o(210573);
      return paramString;
    }
    AppMethodBeat.o(210573);
    return null;
  }
  
  public final String bbe(String paramString)
  {
    AppMethodBeat.i(210574);
    paramString = bbb(paramString);
    if (paramString != null)
    {
      paramString = paramString.dtX;
      AppMethodBeat.o(210574);
      return paramString;
    }
    AppMethodBeat.o(210574);
    return null;
  }
  
  public final void ghV()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182670);
        Object localObject1 = com.tencent.mm.ay.a.bef();
        if (localObject1 == null) {
          break label262;
        }
        if (((f)localObject1).jeV == null)
        {
          AppMethodBeat.o(182670);
          return;
        }
        Object localObject5 = com.tencent.mm.ay.a.beg();
        if (localObject5 == null) {
          break label253;
        }
        Object localObject4 = (MultiProcessMMKV)this.pvV.getSlot();
        Object localObject6 = bbb(((f)localObject1).jeV);
        if (localObject6 == null) {
          break label244;
        }
        if (((fax)localObject6).Dzt < 0) {
          break label235;
        }
        if (((c)localObject5).getPosition() > 0) {
          ((fax)localObject6).Dzt = ((c)localObject5).getPosition();
        }
        ((fax)localObject6).duration = Math.max(0, ((c)localObject5).getDuration());
        a(((f)localObject1).jeV, (fax)localObject6);
        localObject5 = bbd(((f)localObject1).jeV);
        localObject6 = bbe(((f)localObject1).jeV);
        localObject1 = bbb(((f)localObject1).jeV);
        if (localObject1 != null)
        {
          localObject1 = ((fax)localObject1).domain;
          if ((Util.isNullOrNil((String)localObject5)) || (Util.isNullOrNil((String)localObject6))) {
            break label235;
          }
          ((MultiProcessMMKV)localObject4).encode("currentAlbumId", (String)localObject5);
          localObject4 = mk((String)localObject5, (String)localObject1);
          if (localObject4 == null) {
            break label235;
          }
          faw localfaw = this.JwL;
          if (localfaw != null) {
            localfaw.Nxh = ((String)localObject6);
          }
          ((faw)localObject4).Nxh = ((String)localObject6);
          a((String)localObject5, (String)localObject1, (faw)localObject4);
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
  
  public final boolean k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(182669);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString3)))
    {
      Log.i("MicroMsg.MusicAlbumHelper", "playAudioList invalid params");
      AppMethodBeat.o(182669);
      return false;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray(paramString2);
      if (localJSONArray.length() <= 0)
      {
        Log.i("MicroMsg.MusicAlbumHelper", "playAudioList invalid mAudioList");
        AppMethodBeat.o(182669);
        return false;
      }
    }
    catch (Exception paramString1)
    {
      Log.w("MicroMsg.MusicAlbumHelper", "setAudioList ex:%s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(182669);
      return false;
    }
    localList = (List)new ArrayList();
    try
    {
      this.JwL = new faw();
      this.JwM = paramString1;
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
          if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil(str6)))
          {
            Log.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, src or title is null");
            AppMethodBeat.o(182669);
            return false;
          }
          Object localObject3 = this.JwL;
          if (localObject3 != null)
          {
            localObject3 = ((faw)localObject3).Nxi;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(str2);
            }
          }
          localObject2 = g.a(10, str9, str6, str8, str10, str11, (String)localObject2, str1, b.aKJ(), d.aSY() + str9.hashCode(), str7, paramString5);
          ((f)localObject2).jfs = paramString4;
          ((f)localObject2).dvv = (m * 1000);
          ((f)localObject2).jft = paramString2;
          ((f)localObject2).protocol = ((String)localObject1);
          ((f)localObject2).jfv = str3;
          ((f)localObject2).jfe = str4;
          ((f)localObject2).eag = str5;
          ((f)localObject2).iJH = d1;
          ((f)localObject2).volume = ((float)d2);
          localObject1 = bbb(str1);
          paramString2 = (String)localObject1;
          if (localObject1 == null) {
            paramString2 = new fax();
          }
          if (paramString2.Dzt <= 0)
          {
            paramString2.Dzt = 0;
            paramString2.Nxj = paramString1;
            paramString2.dtX = str2;
            paramString2.Nxp = ((float)d1);
            localObject1 = localJSONObject.optJSONObject("reportData");
            if (localObject1 != null)
            {
              paramString2.dLt = ((JSONObject)localObject1).optInt("VoiceType", 0);
              paramString2.NhM = ((JSONObject)localObject1).optString("BizUin", "");
              paramString2.msgId = ((JSONObject)localObject1).optLong("MsgId", 0L);
              paramString2.idx = ((JSONObject)localObject1).optInt("Idx", 0);
              paramString2.Nxk = ((JSONObject)localObject1).optString("SessionIdStr", "0");
              paramString2.Nxl = ((JSONObject)localObject1).optString("AlbumURL", "");
              paramString2.Nxm = ((JSONObject)localObject1).optString("AlbumTitle", "");
              paramString2.Nxn = ((JSONObject)localObject1).optString("AudioTitle", "");
              paramString2.prZ = ((JSONObject)localObject1).optLong("EnterId", 0L);
              paramString2.scene = ((JSONObject)localObject1).optInt("Scene", 0);
              paramString2.pHw = ((JSONObject)localObject1).optInt("SubScene", 0);
              paramString2.Nxo = ((JSONObject)localObject1).optInt("AudioPos", 0);
            }
            paramString2.domain = paramString4;
            a(str1, paramString2);
          }
          p.g(localObject2, "wrapper");
          localList.add(localObject2);
          j += 1;
          break;
          paramString2 = this.JwL;
          if (paramString2 == null) {
            p.hyc();
          }
          a(paramString1, paramString4, paramString2);
          break label204;
          this.JwN = 1;
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
        paramString1 = new t("null cannot be cast to non-null type org.json.JSONObject");
        AppMethodBeat.o(182669);
        throw paramString1;
      }
      catch (Exception paramString1) {}
      Log.w("MicroMsg.MusicAlbumHelper", "playAudioList ex:%s", new Object[] { paramString1.getMessage() });
      if (!Util.isNullOrNil(localList)) {
        break label981;
      }
      Log.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, wrapperList is null");
      AppMethodBeat.o(182669);
      return false;
      localJSONObject = (JSONObject)paramString2;
      str2 = localJSONObject.optString("audioId", "");
      if (Util.isNullOrNil(str2))
      {
        Log.i("MicroMsg.MusicAlbumHelper", "playAudioList audioId is empty");
        AppMethodBeat.o(182669);
        return false;
      }
      p.g(str2, "audioId");
      if (paramString1 == null) {
        p.hyc();
      }
      str1 = bh(str2, paramString1, paramString4);
      bool = p.j(str2, paramString3);
      if (!bool) {
        break label1011;
      }
      i = j;
    }
  }
  
  public final String mj(String paramString1, String paramString2)
  {
    label454:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182668);
        if (Util.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(182668);
          paramString1 = null;
          return paramString1;
        }
        ghV();
        Object localObject1;
        if ((Util.isEqual(paramString1, this.JwM)) && (this.JwL != null))
        {
          localObject1 = this.JwL;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = ((faw)localObject1).Nxi;
          if (Util.isNullOrNil((List)localObject1))
          {
            AppMethodBeat.o(182668);
            paramString1 = null;
          }
        }
        else
        {
          localObject1 = mk(paramString1, paramString2);
          if (localObject1 != null)
          {
            this.JwL = ((faw)localObject1);
            this.JwM = paramString1;
            localObject1 = ((faw)localObject1).Nxi;
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
          Object localObject2 = this.JwL;
          if (localObject2 != null)
          {
            str = ((faw)localObject2).Nxh;
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
          if (!n.aL((CharSequence)localObject1)) {
            continue;
          }
        }
        catch (Exception paramString1)
        {
          String str;
          JSONObject localJSONObject2;
          Log.w("MicroMsg.MusicAlbumHelper", "getAudioListState ex:%s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(182668);
          paramString1 = null;
        }
        if (i == 0)
        {
          if (paramString1 == null) {
            p.hyc();
          }
          localObject1 = bbb(bh(str, paramString1, paramString2));
          localJSONObject2 = new JSONObject();
          if (localObject1 != null)
          {
            i = ((fax)localObject1).Dzt;
            localJSONObject2.put("currentTime", i / 1000);
            if (localObject1 != null)
            {
              i = ((fax)localObject1).duration;
              localJSONObject2.put("duration", i / 1000);
              if (localObject1 == null) {
                continue;
              }
              localObject1 = Float.valueOf(((fax)localObject1).Nxp);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$Companion;", "", "()V", "TAG", "", "albumDelimiter", "currentAlbumIdKey", "<set-?>", "Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "instance", "getInstance", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "setInstance", "(Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;)V", "plugin-webview_release"})
  public static final class a
  {
    public static i ghX()
    {
      AppMethodBeat.i(182656);
      if (i.ghW() == null) {}
      try
      {
        if (i.ghW() == null)
        {
          localObject1 = MMApplicationContext.getContext();
          p.g(localObject1, "MMApplicationContext.getContext()");
          i.d(new i((Context)localObject1, (byte)0));
          localObject1 = i.ghW();
          if (localObject1 != null)
          {
            localObject1 = ((i)localObject1).lEl;
            if (localObject1 != null) {
              ((IListener)localObject1).alive();
            }
          }
        }
        Object localObject1 = x.SXb;
        localObject1 = i.ghW();
        AppMethodBeat.o(182656);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(182656);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(i parami) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(182659);
      this.JwS.ghV();
      AppMethodBeat.o(182659);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-webview_release"})
  public static final class c
    extends IListener<mx>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.i
 * JD-Core Version:    0.7.0.1
 */