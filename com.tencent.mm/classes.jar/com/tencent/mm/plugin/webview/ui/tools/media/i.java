package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.c;
import com.tencent.mm.bb.f;
import com.tencent.mm.bb.g;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.np.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.protocal.protobuf.flp;
import com.tencent.mm.protocal.protobuf.flq;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "", "ct", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "lastMusicId", "", "getLastMusicId", "()Ljava/lang/String;", "setLastMusicId", "(Ljava/lang/String;)V", "mContext", "mCurrentAlbumId", "mWebViewAlbumInfo", "Lcom/tencent/mm/protocal/protobuf/WebViewAlbumInfo;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicPlayerListener", "()Lcom/tencent/mm/sdk/event/IListener;", "playActionSource", "", "getPlayActionSource", "()I", "setPlayActionSource", "(I)V", "playId", "getPlayId", "setPlayId", "doReport", "", "event", "info", "Lcom/tencent/mm/protocal/protobuf/WebViewAudioInfo;", "eventType", "formatReportData", "data", "getAlbumIdFromMusicId", "musicId", "getAudioIdFromMusicId", "getAudioListState", "domain", "albumId", "getDomainFromMusicId", "getWebViewAlbumInfoInfo", "getWebViewAudioInfo", "playAudioList", "", "playAudioId", "appId", "saveCurrentAudioPlayTime", "saveWebViewAlbumInfoInfo", "saveWebViewAudioInfo", "startTimer", "stopTimer", "albumInfoKey", "audioInfoKey", "Companion", "plugin-webview_release"})
public final class i
{
  private static i QuF;
  public static final a QuG;
  private flp QuA;
  private String QuB;
  private int QuC;
  private String QuD;
  private String QuE;
  private Context mContext;
  final IListener<np> ozM;
  private MTimerHandler pEb;
  private final MMKVSlotManager sFn;
  
  static
  {
    AppMethodBeat.i(182673);
    QuG = new a((byte)0);
    AppMethodBeat.o(182673);
  }
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(182672);
    this.QuB = "";
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__web_music_slot_mmkv_key__");
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…b_music_slot_mmkv_key__\")");
    this.sFn = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
    this.ozM = ((IListener)new c(this));
    this.pEb = new MTimerHandler("MicroMsg.MusicAlbumHelper", (MTimerHandler.CallBack)new b(this), true);
    this.QuC = 1;
    this.QuD = "";
    this.QuE = "";
    this.mContext = paramContext;
    AppMethodBeat.o(182672);
  }
  
  private final void a(flq paramflq, int paramInt)
  {
    AppMethodBeat.i(238231);
    if (paramflq == null)
    {
      AppMethodBeat.o(238231);
      return;
    }
    long l = System.currentTimeMillis();
    h.IzE.a(19839, new Object[] { paramflq.Uus, Long.valueOf(paramflq.msgId), Integer.valueOf(paramflq.idx), paramflq.UKz, paramflq.fmF, Integer.valueOf(paramflq.fEi), Long.valueOf(paramflq.sBg), paramflq.UKA, Integer.valueOf(paramflq.scene), Integer.valueOf(paramflq.wGA), this.QuD, Integer.valueOf(paramflq.duration), Integer.valueOf(paramflq.JJP), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(this.QuC), ab.aXb(paramflq.UKB), Integer.valueOf(paramflq.UKE), bna(paramflq.UKC), bna(paramflq.UKD) });
    AppMethodBeat.o(238231);
  }
  
  private final void a(String paramString, flq paramflq)
  {
    AppMethodBeat.i(238218);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238218);
      return;
    }
    try
    {
      ((MultiProcessMMKV)this.sFn.getSlotForWrite()).encode(bmX(paramString), paramflq.toByteArray());
      AppMethodBeat.o(238218);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MusicAlbumHelper", "saveWebViewAudioInfo ex " + paramString.getMessage());
      AppMethodBeat.o(238218);
    }
  }
  
  private final void a(String paramString1, String paramString2, flp paramflp)
  {
    AppMethodBeat.i(238223);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (n.ba(localCharSequence)))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)paramString2;
        if ((localCharSequence != null) && (!n.ba(localCharSequence))) {
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
      AppMethodBeat.o(238223);
      return;
      i = 0;
      break;
    }
    try
    {
      label79:
      ((MultiProcessMMKV)this.sFn.getSlotForWrite()).encode(mJ(paramString1, paramString2), paramflp.toByteArray());
      AppMethodBeat.o(238223);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.MusicAlbumHelper", "saveWebViewAlbumInfoInfo ex " + paramString1.getMessage());
      AppMethodBeat.o(238223);
    }
  }
  
  private static String bc(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(182661);
    p.k(paramString1, "$this$musicId");
    p.k(paramString2, "albumId");
    paramString1 = paramString3 + '_' + paramString2 + '_' + paramString1;
    AppMethodBeat.o(182661);
    return paramString1;
  }
  
  private static String bmX(String paramString)
  {
    AppMethodBeat.i(238201);
    p.k(paramString, "$this$audioInfoKey");
    paramString = "audioInfo_" + paramString + '}';
    AppMethodBeat.o(238201);
    return paramString;
  }
  
  private final flq bmZ(String paramString)
  {
    AppMethodBeat.i(238216);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238216);
      return null;
    }
    localObject = this.sFn;
    paramString = bmX(paramString);
    localObject = (MultiProcessMMKV)((MMKVSlotManager)localObject).findSlot(paramString);
    if (localObject != null) {
      if (((MultiProcessMMKV)localObject).containsKey(paramString))
      {
        paramString = ((MultiProcessMMKV)localObject).decodeBytes(paramString);
        if (paramString != null) {
          if (paramString.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label137;
            }
            i = 1;
            label95:
            if (i == 0) {
              break label160;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = flq.class.newInstance();
        ((com.tencent.mm.cd.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.cd.a)localObject;
        paramString = (flq)paramString;
        AppMethodBeat.o(238216);
        return paramString;
      }
      catch (Exception paramString)
      {
        label137:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label95;
      label160:
      paramString = null;
      continue;
      paramString = null;
    }
  }
  
  private static String bna(String paramString)
  {
    AppMethodBeat.i(238233);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238233);
      return "";
    }
    paramString = n.l(paramString, ",", "", false);
    AppMethodBeat.o(238233);
    return paramString;
  }
  
  private final void d(np paramnp)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(238227);
        Object localObject2 = paramnp.fMc.fLV;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.bb.a.bnA();
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(238227);
          return;
        }
        if (Util.isNullOrNil(this.QuE))
        {
          localObject2 = ((f)localObject1).lVt;
          p.j(localObject2, "musicWrapper.MusicId");
          this.QuE = ((String)localObject2);
          this.QuD = String.valueOf(System.currentTimeMillis());
        }
        Log.i("MicroMsg.MusicAlbumHelper", "doWebViewReport musicId = " + this.QuE + ", playId=" + this.QuD + ", playActionSource=" + this.QuC + "，action=" + paramnp.fMc.action);
        switch (paramnp.fMc.action)
        {
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
          if (!Util.isEqual(this.QuE, ((f)localObject1).lVt))
          {
            localObject1 = ((f)localObject1).lVt;
            p.j(localObject1, "musicWrapper.MusicId");
            this.QuE = ((String)localObject1);
            this.QuD = String.valueOf(System.currentTimeMillis());
            Log.i("MicroMsg.MusicAlbumHelper", "doWebViewReport new music musicId = " + this.QuE + ", playId=" + this.QuD);
          }
          switch (paramnp.fMc.action)
          {
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 10: 
            AppMethodBeat.o(238227);
          }
          break;
        case 3: 
          a(bmZ(this.QuE), 4);
        }
      }
      finally {}
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 7);
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 8);
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 9);
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 100);
      AppMethodBeat.o(238227);
      continue;
      this.QuC = 2;
      AppMethodBeat.o(238227);
      continue;
      this.QuC = 3;
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 1);
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 2);
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 3);
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 5);
      AppMethodBeat.o(238227);
      continue;
      a(bmZ(this.QuE), 6);
      continue;
    }
  }
  
  private static String mJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238204);
    p.k(paramString1, "$this$albumInfoKey");
    paramString1 = "album_" + paramString2 + '_' + paramString1 + '}';
    AppMethodBeat.o(238204);
    return paramString1;
  }
  
  private final flp mL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238221);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.ba((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
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
      AppMethodBeat.o(238221);
      return null;
      i = 0;
      break;
    }
    label74:
    localObject = this.sFn;
    paramString1 = mJ(paramString1, paramString2);
    paramString2 = (MultiProcessMMKV)((MMKVSlotManager)localObject).findSlot(paramString1);
    if (paramString2 != null) {
      if (paramString2.containsKey(paramString1))
      {
        paramString1 = paramString2.decodeBytes(paramString1);
        if (paramString1 != null) {
          if (paramString1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label174;
            }
            i = 1;
            label131:
            if (i == 0) {
              break label197;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = flp.class.newInstance();
        ((com.tencent.mm.cd.a)paramString2).parseFrom(paramString1);
        paramString1 = (com.tencent.mm.cd.a)paramString2;
        paramString1 = (flp)paramString1;
        AppMethodBeat.o(238221);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        label174:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString1, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label131;
      label197:
      paramString1 = null;
      continue;
      paramString1 = null;
    }
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(182671);
    Log.d("MicroMsg.MusicAlbumHelper", "stop timer");
    this.pEb.stopTimer();
    AppMethodBeat.o(182671);
  }
  
  public final String bmY(String paramString)
  {
    try
    {
      AppMethodBeat.i(182667);
      paramString = mK(MMKVSlotManager.decodeString$default(this.sFn, "currentAlbumId", null, 2, null), paramString);
      AppMethodBeat.o(182667);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String bnb(String paramString)
  {
    AppMethodBeat.i(238235);
    paramString = bmZ(paramString);
    if (paramString != null)
    {
      paramString = paramString.UKz;
      AppMethodBeat.o(238235);
      return paramString;
    }
    AppMethodBeat.o(238235);
    return null;
  }
  
  public final String bnc(String paramString)
  {
    AppMethodBeat.i(238237);
    paramString = bmZ(paramString);
    if (paramString != null)
    {
      paramString = paramString.fmF;
      AppMethodBeat.o(238237);
      return paramString;
    }
    AppMethodBeat.o(238237);
    return null;
  }
  
  public final void hbt()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182670);
        Object localObject1 = com.tencent.mm.bb.a.bnA();
        if (localObject1 == null) {
          break label262;
        }
        if (((f)localObject1).lVt == null)
        {
          AppMethodBeat.o(182670);
          return;
        }
        Object localObject5 = com.tencent.mm.bb.a.bnB();
        if (localObject5 == null) {
          break label253;
        }
        Object localObject4 = (MultiProcessMMKV)this.sFn.getSlotForWrite();
        Object localObject6 = bmZ(((f)localObject1).lVt);
        if (localObject6 == null) {
          break label244;
        }
        if (((flq)localObject6).JJP < 0) {
          break label235;
        }
        if (((c)localObject5).getPosition() > 0) {
          ((flq)localObject6).JJP = ((c)localObject5).getPosition();
        }
        ((flq)localObject6).duration = Math.max(0, ((c)localObject5).getDuration());
        a(((f)localObject1).lVt, (flq)localObject6);
        localObject5 = bnb(((f)localObject1).lVt);
        localObject6 = bnc(((f)localObject1).lVt);
        localObject1 = bmZ(((f)localObject1).lVt);
        if (localObject1 != null)
        {
          localObject1 = ((flq)localObject1).domain;
          if ((Util.isNullOrNil((String)localObject5)) || (Util.isNullOrNil((String)localObject6))) {
            break label235;
          }
          ((MultiProcessMMKV)localObject4).encode("currentAlbumId", (String)localObject5);
          localObject4 = mL((String)localObject5, (String)localObject1);
          if (localObject4 == null) {
            break label235;
          }
          flp localflp = this.QuA;
          if (localflp != null) {
            localflp.UKx = ((String)localObject6);
          }
          ((flp)localObject4).UKx = ((String)localObject6);
          a((String)localObject5, (String)localObject1, (flp)localObject4);
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
  
  public final boolean j(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
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
      this.QuA = new flp();
      this.QuB = paramString1;
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
          Object localObject3 = this.QuA;
          if (localObject3 != null)
          {
            localObject3 = ((flp)localObject3).UKy;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(str2);
            }
          }
          localObject2 = g.a(10, str9, str6, str8, str10, str11, (String)localObject2, str1, b.aSL(), d.bbW() + str9.hashCode(), str7, paramString5);
          ((f)localObject2).lVQ = paramString4;
          ((f)localObject2).fod = (m * 1000);
          ((f)localObject2).lVR = paramString2;
          ((f)localObject2).protocol = ((String)localObject1);
          ((f)localObject2).lVT = str3;
          ((f)localObject2).lVC = str4;
          ((f)localObject2).fUd = str5;
          ((f)localObject2).lzL = d1;
          ((f)localObject2).volume = ((float)d2);
          localObject1 = bmZ(str1);
          paramString2 = (String)localObject1;
          if (localObject1 == null) {
            paramString2 = new flq();
          }
          if (paramString2.JJP <= 0)
          {
            paramString2.JJP = 0;
            paramString2.UKz = paramString1;
            paramString2.fmF = str2;
            paramString2.UKF = ((float)d1);
            localObject1 = localJSONObject.optJSONObject("reportData");
            if (localObject1 != null)
            {
              paramString2.fEi = ((JSONObject)localObject1).optInt("VoiceType", 0);
              paramString2.Uus = ((JSONObject)localObject1).optString("BizUin", "");
              paramString2.msgId = ((JSONObject)localObject1).optLong("MsgId", 0L);
              paramString2.idx = ((JSONObject)localObject1).optInt("Idx", 0);
              paramString2.UKA = ((JSONObject)localObject1).optString("SessionIdStr", "0");
              paramString2.UKB = ((JSONObject)localObject1).optString("AlbumURL", "");
              paramString2.UKC = ((JSONObject)localObject1).optString("AlbumTitle", "");
              paramString2.UKD = ((JSONObject)localObject1).optString("AudioTitle", "");
              paramString2.sBg = ((JSONObject)localObject1).optLong("EnterId", 0L);
              paramString2.scene = ((JSONObject)localObject1).optInt("Scene", 0);
              paramString2.wGA = ((JSONObject)localObject1).optInt("SubScene", 0);
              paramString2.UKE = ((JSONObject)localObject1).optInt("AudioPos", 0);
            }
            paramString2.domain = paramString4;
            a(str1, paramString2);
          }
          p.j(localObject2, "wrapper");
          localList.add(localObject2);
          j += 1;
          break;
          paramString2 = this.QuA;
          if (paramString2 == null) {
            p.iCn();
          }
          a(paramString1, paramString4, paramString2);
          break label204;
          this.QuC = 1;
          com.tencent.mm.bb.a.f(localList, i);
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
      p.j(str2, "audioId");
      if (paramString1 == null) {
        p.iCn();
      }
      str1 = bc(str2, paramString1, paramString4);
      bool = p.h(str2, paramString3);
      if (!bool) {
        break label1011;
      }
      i = j;
    }
  }
  
  public final String mK(String paramString1, String paramString2)
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
        hbt();
        Object localObject1;
        if ((Util.isEqual(paramString1, this.QuB)) && (this.QuA != null))
        {
          localObject1 = this.QuA;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((flp)localObject1).UKy;
          if (Util.isNullOrNil((List)localObject1))
          {
            AppMethodBeat.o(182668);
            paramString1 = null;
          }
        }
        else
        {
          localObject1 = mL(paramString1, paramString2);
          if (localObject1 != null)
          {
            this.QuA = ((flp)localObject1);
            this.QuB = paramString1;
            localObject1 = ((flp)localObject1).UKy;
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
          Object localObject2 = this.QuA;
          if (localObject2 != null)
          {
            str = ((flp)localObject2).UKx;
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
          if (!n.ba((CharSequence)localObject1)) {
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
            p.iCn();
          }
          localObject1 = bmZ(bc(str, paramString1, paramString2));
          localJSONObject2 = new JSONObject();
          if (localObject1 != null)
          {
            i = ((flq)localObject1).JJP;
            localJSONObject2.put("currentTime", i / 1000);
            if (localObject1 != null)
            {
              i = ((flq)localObject1).duration;
              localJSONObject2.put("duration", i / 1000);
              if (localObject1 == null) {
                continue;
              }
              localObject1 = Float.valueOf(((flq)localObject1).UKF);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$Companion;", "", "()V", "TAG", "", "albumDelimiter", "currentAlbumIdKey", "<set-?>", "Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "instance", "getInstance", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "setInstance", "(Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;)V", "plugin-webview_release"})
  public static final class a
  {
    public static i hbv()
    {
      AppMethodBeat.i(182656);
      if (i.hbu() == null) {}
      try
      {
        if (i.hbu() == null)
        {
          localObject1 = MMApplicationContext.getContext();
          p.j(localObject1, "MMApplicationContext.getContext()");
          i.d(new i((Context)localObject1, (byte)0));
          localObject1 = i.hbu();
          if (localObject1 != null)
          {
            localObject1 = ((i)localObject1).ozM;
            if (localObject1 != null) {
              ((IListener)localObject1).alive();
            }
          }
        }
        Object localObject1 = x.aazN;
        localObject1 = i.hbu();
        AppMethodBeat.o(182656);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(182656);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(i parami) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(182659);
      this.QuH.hbt();
      AppMethodBeat.o(182659);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-webview_release"})
  public static final class c
    extends IListener<np>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.i
 * JD-Core Version:    0.7.0.1
 */