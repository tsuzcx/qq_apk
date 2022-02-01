package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.g;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.dyr;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "", "ct", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "lastMusicId", "", "getLastMusicId", "()Ljava/lang/String;", "setLastMusicId", "(Ljava/lang/String;)V", "mContext", "mCurrentAlbumId", "mWebViewAlbumInfo", "Lcom/tencent/mm/protocal/protobuf/WebViewAlbumInfo;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicPlayerListener", "()Lcom/tencent/mm/sdk/event/IListener;", "playActionSource", "", "getPlayActionSource", "()I", "setPlayActionSource", "(I)V", "playId", "getPlayId", "setPlayId", "doReport", "", "event", "info", "Lcom/tencent/mm/protocal/protobuf/WebViewAudioInfo;", "eventType", "formatReportData", "data", "getAlbumIdFromMusicId", "musicId", "getAudioIdFromMusicId", "getAudioListState", "domain", "albumId", "getDomainFromMusicId", "getWebViewAlbumInfoInfo", "getWebViewAudioInfo", "playAudioList", "", "playAudioId", "appId", "saveCurrentAudioPlayTime", "saveWebViewAlbumInfoInfo", "saveWebViewAudioInfo", "startTimer", "stopTimer", "albumInfoKey", "audioInfoKey", "Companion", "plugin-webview_release"})
public final class h
{
  private static h CLr;
  public static final a CLs;
  private dyr CLl;
  private String CLm;
  private final aq CLn;
  private int CLo;
  private String CLp;
  private String CLq;
  private au kWt;
  final com.tencent.mm.sdk.b.c<lw> kce;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(182673);
    CLs = new a((byte)0);
    AppMethodBeat.o(182673);
  }
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(182672);
    this.CLm = "";
    aw localaw = aw.aKT("__web_music_slot_mmkv_key__");
    k.g(localaw, "MultiProcessMMKV.getMMKV…b_music_slot_mmkv_key__\")");
    this.CLn = new aq(localaw, 15552000L);
    this.kce = ((com.tencent.mm.sdk.b.c)new c(this));
    this.kWt = new au("MicroMsg.MusicAlbumHelper", (au.a)new b(this), true);
    this.CLo = 1;
    this.CLp = "";
    this.CLq = "";
    this.mContext = paramContext;
    AppMethodBeat.o(182672);
  }
  
  private final void a(dys paramdys, int paramInt)
  {
    AppMethodBeat.i(189481);
    if (paramdys == null)
    {
      AppMethodBeat.o(189481);
      return;
    }
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.report.service.h.wUl.f(19839, new Object[] { paramdys.FRk, Long.valueOf(paramdys.msgId), Integer.valueOf(paramdys.idx), paramdys.GeX, paramdys.cQO, Integer.valueOf(paramdys.dhE), Long.valueOf(paramdys.nzO), paramdys.GeY, Integer.valueOf(paramdys.scene), Integer.valueOf(paramdys.nLC), this.CLp, Integer.valueOf(paramdys.duration), Integer.valueOf(paramdys.GeW), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(this.CLo), x.aId(paramdys.GeZ), Integer.valueOf(paramdys.Gfc), aDT(paramdys.Gfa), aDT(paramdys.Gfb) });
    AppMethodBeat.o(189481);
  }
  
  private final void a(String paramString, dys paramdys)
  {
    AppMethodBeat.i(189477);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aD((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(189477);
      return;
    }
    localObject = (aw)this.CLn.eUr();
    try
    {
      ((aw)localObject).encode(aDQ(paramString), paramdys.toByteArray());
      AppMethodBeat.o(189477);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.MusicAlbumHelper", "saveWebViewAudioInfo ex " + paramString.getMessage());
      AppMethodBeat.o(189477);
    }
  }
  
  private final void a(String paramString1, String paramString2, dyr paramdyr)
  {
    AppMethodBeat.i(189479);
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
      AppMethodBeat.o(189479);
      return;
      i = 0;
      break;
    }
    label79:
    localObject = (aw)this.CLn.eUr();
    try
    {
      ((aw)localObject).encode(kF(paramString1, paramString2), paramdyr.toByteArray());
      AppMethodBeat.o(189479);
      return;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.MusicAlbumHelper", "saveWebViewAlbumInfoInfo ex " + paramString1.getMessage());
      AppMethodBeat.o(189479);
    }
  }
  
  private static String aDQ(String paramString)
  {
    AppMethodBeat.i(189474);
    k.h(paramString, "$this$audioInfoKey");
    paramString = "audioInfo_" + paramString + '}';
    AppMethodBeat.o(189474);
    return paramString;
  }
  
  private final dys aDS(String paramString)
  {
    AppMethodBeat.i(189476);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aD((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(189476);
      return null;
    }
    localObject = (aw)this.CLn.eUr();
    paramString = aDQ(paramString);
    if (((aw)localObject).containsKey(paramString))
    {
      paramString = ((aw)localObject).decodeBytes(paramString);
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
        localObject = dys.class.newInstance();
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bw.a)localObject;
        paramString = (dys)paramString;
        AppMethodBeat.o(189476);
        return paramString;
      }
      catch (Exception paramString)
      {
        label130:
        ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label88;
      label153:
      paramString = null;
    }
  }
  
  private static String aDT(String paramString)
  {
    AppMethodBeat.i(189482);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.aD(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(189482);
      return "";
    }
    paramString = n.h(paramString, ",", "", false);
    AppMethodBeat.o(189482);
    return paramString;
  }
  
  private static String aO(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(182661);
    k.h(paramString1, "$this$musicId");
    k.h(paramString2, "albumId");
    paramString1 = paramString3 + '_' + paramString2 + '_' + paramString1;
    AppMethodBeat.o(182661);
    return paramString1;
  }
  
  private final void b(lw paramlw)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(189480);
        Object localObject2 = paramlw.dnW.dnQ;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.ay.a.aGy();
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(189480);
          return;
        }
        if (bs.isNullOrNil(this.CLq))
        {
          localObject2 = ((f)localObject1).hNS;
          k.g(localObject2, "musicWrapper.MusicId");
          this.CLq = ((String)localObject2);
          this.CLp = String.valueOf(System.currentTimeMillis());
        }
        ac.i("MicroMsg.MusicAlbumHelper", "doWebViewReport musicId = " + this.CLq + ", playId=" + this.CLp + ", playActionSource=" + this.CLo + "，action=" + paramlw.dnW.action);
        switch (paramlw.dnW.action)
        {
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
          if (!bs.lr(this.CLq, ((f)localObject1).hNS))
          {
            localObject1 = ((f)localObject1).hNS;
            k.g(localObject1, "musicWrapper.MusicId");
            this.CLq = ((String)localObject1);
            this.CLp = String.valueOf(System.currentTimeMillis());
            ac.i("MicroMsg.MusicAlbumHelper", "doWebViewReport new music musicId = " + this.CLq + ", playId=" + this.CLp);
          }
          switch (paramlw.dnW.action)
          {
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 10: 
            AppMethodBeat.o(189480);
          }
          break;
        case 3: 
          a(aDS(this.CLq), 4);
        }
      }
      finally {}
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 7);
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 8);
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 9);
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 100);
      AppMethodBeat.o(189480);
      continue;
      this.CLo = 2;
      AppMethodBeat.o(189480);
      continue;
      this.CLo = 3;
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 1);
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 2);
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 3);
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 5);
      AppMethodBeat.o(189480);
      continue;
      a(aDS(this.CLq), 6);
      continue;
    }
  }
  
  private static String kF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189475);
    k.h(paramString1, "$this$albumInfoKey");
    paramString1 = "album_" + paramString2 + '_' + paramString1 + '}';
    AppMethodBeat.o(189475);
    return paramString1;
  }
  
  private final dyr kH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189478);
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
      AppMethodBeat.o(189478);
      return null;
      i = 0;
      break;
    }
    label74:
    localObject = (aw)this.CLn.eUr();
    paramString1 = kF(paramString1, paramString2);
    if (((aw)localObject).containsKey(paramString1))
    {
      paramString1 = ((aw)localObject).decodeBytes(paramString1);
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
        paramString2 = dyr.class.newInstance();
        ((com.tencent.mm.bw.a)paramString2).parseFrom(paramString1);
        paramString1 = (com.tencent.mm.bw.a)paramString2;
        paramString1 = (dyr)paramString1;
        AppMethodBeat.o(189478);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        label168:
        ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString1, "decode ProtoBuffer", new Object[0]);
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
    ac.d("MicroMsg.MusicAlbumHelper", "stop timer");
    this.kWt.stopTimer();
    AppMethodBeat.o(182671);
  }
  
  public final String aDR(String paramString)
  {
    try
    {
      AppMethodBeat.i(182667);
      paramString = kG(((aw)this.CLn.eUr()).decodeString("currentAlbumId"), paramString);
      AppMethodBeat.o(182667);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String aDU(String paramString)
  {
    AppMethodBeat.i(189483);
    paramString = aDS(paramString);
    if (paramString != null)
    {
      paramString = paramString.GeX;
      AppMethodBeat.o(189483);
      return paramString;
    }
    AppMethodBeat.o(189483);
    return null;
  }
  
  public final String aDV(String paramString)
  {
    AppMethodBeat.i(189484);
    paramString = aDS(paramString);
    if (paramString != null)
    {
      paramString = paramString.cQO;
      AppMethodBeat.o(189484);
      return paramString;
    }
    AppMethodBeat.o(189484);
    return null;
  }
  
  public final void eGh()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182670);
        Object localObject1 = com.tencent.mm.ay.a.aGy();
        if (localObject1 == null) {
          break label262;
        }
        if (((f)localObject1).hNS == null)
        {
          AppMethodBeat.o(182670);
          return;
        }
        Object localObject5 = com.tencent.mm.ay.a.aGz();
        if (localObject5 == null) {
          break label253;
        }
        Object localObject4 = (aw)this.CLn.eUr();
        Object localObject6 = aDS(((f)localObject1).hNS);
        if (localObject6 == null) {
          break label244;
        }
        if (((dys)localObject6).GeW < 0) {
          break label235;
        }
        if (((com.tencent.mm.ay.c)localObject5).getPosition() > 0) {
          ((dys)localObject6).GeW = ((com.tencent.mm.ay.c)localObject5).getPosition();
        }
        ((dys)localObject6).duration = Math.max(0, ((com.tencent.mm.ay.c)localObject5).getDuration());
        a(((f)localObject1).hNS, (dys)localObject6);
        localObject5 = aDU(((f)localObject1).hNS);
        localObject6 = aDV(((f)localObject1).hNS);
        localObject1 = aDS(((f)localObject1).hNS);
        if (localObject1 != null)
        {
          localObject1 = ((dys)localObject1).DbG;
          if ((bs.isNullOrNil((String)localObject5)) || (bs.isNullOrNil((String)localObject6))) {
            break label235;
          }
          ((aw)localObject4).encode("currentAlbumId", (String)localObject5);
          localObject4 = kH((String)localObject5, (String)localObject1);
          if (localObject4 == null) {
            break label235;
          }
          dyr localdyr = this.CLl;
          if (localdyr != null) {
            localdyr.GeU = ((String)localObject6);
          }
          ((dyr)localObject4).GeU = ((String)localObject6);
          a((String)localObject5, (String)localObject1, (dyr)localObject4);
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
    if ((bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString3)))
    {
      ac.i("MicroMsg.MusicAlbumHelper", "playAudioList invalid params");
      AppMethodBeat.o(182669);
      return false;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray(paramString2);
      if (localJSONArray.length() <= 0)
      {
        ac.i("MicroMsg.MusicAlbumHelper", "playAudioList invalid mAudioList");
        AppMethodBeat.o(182669);
        return false;
      }
    }
    catch (Exception paramString1)
    {
      ac.w("MicroMsg.MusicAlbumHelper", "setAudioList ex:%s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(182669);
      return false;
    }
    localList = (List)new ArrayList();
    try
    {
      this.CLl = new dyr();
      this.CLm = paramString1;
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
          if ((bs.isNullOrNil((String)localObject2)) || (bs.isNullOrNil(str6)))
          {
            ac.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, src or title is null");
            AppMethodBeat.o(182669);
            return false;
          }
          Object localObject3 = this.CLl;
          if (localObject3 != null)
          {
            localObject3 = ((dyr)localObject3).GeV;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(str2);
            }
          }
          localObject2 = g.a(10, str9, str6, str8, str10, str11, (String)localObject2, str1, b.aph(), d.awL() + str9.hashCode(), str7, paramString5);
          ((f)localObject2).hOp = paramString4;
          ((f)localObject2).cSh = 0;
          ((f)localObject2).hOq = paramString2;
          ((f)localObject2).protocol = ((String)localObject1);
          ((f)localObject2).hOs = str3;
          ((f)localObject2).hOb = str4;
          ((f)localObject2).dvl = str5;
          ((f)localObject2).htq = d1;
          ((f)localObject2).volume = ((float)d2);
          localObject1 = aDS(str1);
          paramString2 = (String)localObject1;
          if (localObject1 == null) {
            paramString2 = new dys();
          }
          if (paramString2.GeW <= 0)
          {
            paramString2.GeW = 0;
            paramString2.GeX = paramString1;
            paramString2.cQO = str2;
            localObject1 = localJSONObject.optJSONObject("reportData");
            if (localObject1 != null)
            {
              paramString2.dhE = ((JSONObject)localObject1).optInt("VoiceType", 0);
              paramString2.FRk = ((JSONObject)localObject1).optString("BizUin", "");
              paramString2.msgId = ((JSONObject)localObject1).optLong("MsgId", 0L);
              paramString2.idx = ((JSONObject)localObject1).optInt("Idx", 0);
              paramString2.GeY = ((JSONObject)localObject1).optString("SessionIdStr", "0");
              paramString2.GeZ = ((JSONObject)localObject1).optString("AlbumURL", "");
              paramString2.Gfa = ((JSONObject)localObject1).optString("AlbumTitle", "");
              paramString2.Gfb = ((JSONObject)localObject1).optString("AudioTitle", "");
              paramString2.nzO = ((JSONObject)localObject1).optLong("EnterId", 0L);
              paramString2.scene = ((JSONObject)localObject1).optInt("Scene", 0);
              paramString2.nLC = ((JSONObject)localObject1).optInt("SubScene", 0);
              paramString2.Gfc = ((JSONObject)localObject1).optInt("AudioPos", 0);
            }
            paramString2.DbG = paramString4;
            a(str1, paramString2);
          }
          k.g(localObject2, "wrapper");
          localList.add(localObject2);
          j += 1;
          break;
          paramString2 = this.CLl;
          if (paramString2 == null) {
            k.fOy();
          }
          a(paramString1, paramString4, paramString2);
          break label204;
          this.CLo = 1;
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
      ac.w("MicroMsg.MusicAlbumHelper", "playAudioList ex:%s", new Object[] { paramString1.getMessage() });
      if (!bs.gY(localList)) {
        break label958;
      }
      ac.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, wrapperList is null");
      AppMethodBeat.o(182669);
      return false;
      localJSONObject = (JSONObject)paramString2;
      str2 = localJSONObject.optString("audioId", "");
      if (bs.isNullOrNil(str2))
      {
        ac.i("MicroMsg.MusicAlbumHelper", "playAudioList audioId is empty");
        AppMethodBeat.o(182669);
        return false;
      }
      k.g(str2, "audioId");
      if (paramString1 == null) {
        k.fOy();
      }
      str1 = aO(str2, paramString1, paramString4);
      bool = k.g(str2, paramString3);
      if (!bool) {
        break label988;
      }
      i = j;
    }
  }
  
  public final String kG(String paramString1, String paramString2)
  {
    label419:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182668);
        if (bs.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(182668);
          paramString1 = null;
          return paramString1;
        }
        eGh();
        Object localObject1;
        if ((bs.lr(paramString1, this.CLm)) && (this.CLl != null))
        {
          localObject1 = this.CLl;
          if (localObject1 == null) {
            k.fOy();
          }
          localObject1 = ((dyr)localObject1).GeV;
          if (bs.gY((List)localObject1))
          {
            AppMethodBeat.o(182668);
            paramString1 = null;
          }
        }
        else
        {
          localObject1 = kH(paramString1, paramString2);
          if (localObject1 != null)
          {
            this.CLl = ((dyr)localObject1);
            this.CLm = paramString1;
            localObject1 = ((dyr)localObject1).GeV;
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
          localObject2 = this.CLl;
          if (localObject2 != null)
          {
            localObject3 = ((dyr)localObject2).GeU;
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
          if (!n.aD((CharSequence)localObject3)) {
            continue;
          }
        }
        catch (Exception paramString1)
        {
          Object localObject2;
          Object localObject3;
          JSONObject localJSONObject2;
          ac.w("MicroMsg.MusicAlbumHelper", "getAudioListState ex:%s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(182668);
          paramString1 = null;
        }
        if (i == 0)
        {
          if (paramString1 == null) {
            k.fOy();
          }
          localObject3 = aDS(aO((String)localObject2, paramString1, paramString2));
          localJSONObject2 = new JSONObject();
          if (localObject3 != null)
          {
            i = ((dys)localObject3).GeW;
            localJSONObject2.put("currentTime", i / 1000);
            if (localObject3 != null)
            {
              i = ((dys)localObject3).duration;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$Companion;", "", "()V", "TAG", "", "albumDelimiter", "currentAlbumIdKey", "<set-?>", "Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "instance", "getInstance", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "setInstance", "(Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;)V", "plugin-webview_release"})
  public static final class a
  {
    public static h eGj()
    {
      AppMethodBeat.i(182656);
      if (h.eGi() == null) {}
      try
      {
        if (h.eGi() == null)
        {
          localObject1 = ai.getContext();
          k.g(localObject1, "MMApplicationContext.getContext()");
          h.d(new h((Context)localObject1, (byte)0));
          localObject1 = h.eGi();
          if (localObject1 != null)
          {
            localObject1 = ((h)localObject1).kce;
            if (localObject1 != null) {
              ((com.tencent.mm.sdk.b.c)localObject1).alive();
            }
          }
        }
        Object localObject1 = y.KTp;
        localObject1 = h.eGi();
        AppMethodBeat.o(182656);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(182656);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements au.a
  {
    b(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(182659);
      this.CLt.eGh();
      AppMethodBeat.o(182659);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-webview_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<lw>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h
 * JD-Core Version:    0.7.0.1
 */