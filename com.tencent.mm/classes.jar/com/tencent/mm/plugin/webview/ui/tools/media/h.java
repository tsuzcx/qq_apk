package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.ox.a;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.g;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.protobuf.gie;
import com.tencent.mm.protocal.protobuf.gif;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "", "ct", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "lastMusicId", "", "getLastMusicId", "()Ljava/lang/String;", "setLastMusicId", "(Ljava/lang/String;)V", "mContext", "mCurrentAlbumId", "mWebViewAlbumInfo", "Lcom/tencent/mm/protocal/protobuf/WebViewAlbumInfo;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicPlayerListener", "()Lcom/tencent/mm/sdk/event/IListener;", "playActionSource", "", "getPlayActionSource", "()I", "setPlayActionSource", "(I)V", "playId", "getPlayId", "setPlayId", "doReport", "", "event", "info", "Lcom/tencent/mm/protocal/protobuf/WebViewAudioInfo;", "eventType", "formatReportData", "data", "getAlbumIdFromMusicId", "musicId", "getAudioIdFromMusicId", "getAudioListState", "domain", "albumId", "getDomainFromMusicId", "getWebViewAlbumInfoInfo", "getWebViewAudioInfo", "playAudioList", "", "playAudioId", "appId", "saveCurrentAudioPlayTime", "saveWebViewAlbumInfoInfo", "saveWebViewAudioInfo", "startTimer", "stopTimer", "albumInfoKey", "audioInfoKey", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static h XmE;
  public static final a Xmy;
  private String XmA;
  private int XmB;
  private String XmC;
  private String XmD;
  private gie Xmz;
  private Context mContext;
  final IListener<ox> rDF;
  private MTimerHandler sJn;
  private final MMKVSlotManager vKT;
  
  static
  {
    AppMethodBeat.i(182673);
    Xmy = new a((byte)0);
    AppMethodBeat.o(182673);
  }
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(182672);
    this.XmA = "";
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__web_music_slot_mmkv_key__");
    s.s(localMultiProcessMMKV, "getMMKV(\"__web_music_slot_mmkv_key__\")");
    this.vKT = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
    this.rDF = ((IListener)new WebViewMusicAlbumHelper.musicPlayerListener.1(this, com.tencent.mm.app.f.hfK));
    this.sJn = new MTimerHandler("MicroMsg.MusicAlbumHelper", new h..ExternalSyntheticLambda0(this), true);
    this.XmB = 1;
    this.XmC = "";
    this.XmD = "";
    this.mContext = paramContext;
    AppMethodBeat.o(182672);
  }
  
  private final void a(gif paramgif, int paramInt)
  {
    AppMethodBeat.i(296760);
    if (paramgif == null)
    {
      AppMethodBeat.o(296760);
      return;
    }
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.report.service.h.OAn.b(19839, new Object[] { paramgif.abNV, Long.valueOf(paramgif.msgId), Integer.valueOf(paramgif.idx), paramgif.aceH, paramgif.hqQ, Integer.valueOf(paramgif.hIY), Long.valueOf(paramgif.vGG), paramgif.aceI, Integer.valueOf(paramgif.scene), Integer.valueOf(paramgif.AcJ), this.XmC, Integer.valueOf(paramgif.duration), Integer.valueOf(paramgif.Qbt), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(this.XmB), aa.aUC(paramgif.aceJ), Integer.valueOf(paramgif.aceM), bmF(paramgif.aceK), bmF(paramgif.aceL) });
    AppMethodBeat.o(296760);
  }
  
  private final void a(String paramString, gif paramgif)
  {
    AppMethodBeat.i(296734);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(296734);
      return;
    }
    try
    {
      ((MultiProcessMMKV)this.vKT.getSlotForWrite()).encode(bmC(paramString), paramgif.toByteArray());
      AppMethodBeat.o(296734);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MusicAlbumHelper", s.X("saveWebViewAudioInfo ex ", paramString.getMessage()));
      AppMethodBeat.o(296734);
    }
  }
  
  private final void a(String paramString1, String paramString2, gie paramgie)
  {
    AppMethodBeat.i(296743);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (n.bp(localCharSequence)))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)paramString2;
        if ((localCharSequence != null) && (!n.bp(localCharSequence))) {
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
      AppMethodBeat.o(296743);
      return;
      i = 0;
      break;
    }
    try
    {
      label79:
      ((MultiProcessMMKV)this.vKT.getSlotForWrite()).encode(oz(paramString1, paramString2), paramgie.toByteArray());
      AppMethodBeat.o(296743);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.MusicAlbumHelper", s.X("saveWebViewAlbumInfoInfo ex ", paramString1.getMessage()));
      AppMethodBeat.o(296743);
    }
  }
  
  private static final boolean a(h paramh)
  {
    AppMethodBeat.i(296769);
    s.u(paramh, "this$0");
    paramh.iBF();
    AppMethodBeat.o(296769);
    return true;
  }
  
  private static String bmC(String paramString)
  {
    AppMethodBeat.i(296718);
    s.u(paramString, "<this>");
    paramString = "audioInfo_" + paramString + '}';
    AppMethodBeat.o(296718);
    return paramString;
  }
  
  private final gif bmE(String paramString)
  {
    AppMethodBeat.i(296730);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(296730);
      return null;
    }
    localObject = this.vKT;
    paramString = bmC(paramString);
    localObject = (MultiProcessMMKV)((MMKVSlotManager)localObject).findSlot(paramString);
    if (localObject == null) {}
    label142:
    label165:
    for (paramString = null;; paramString = null)
    {
      paramString = (gif)paramString;
      AppMethodBeat.o(296730);
      return paramString;
      if (((MultiProcessMMKV)localObject).containsKey(paramString))
      {
        paramString = ((MultiProcessMMKV)localObject).decodeBytes(paramString);
        if (paramString != null)
        {
          if (paramString.length == 0)
          {
            i = 1;
            label104:
            if (i != 0) {
              break label142;
            }
          }
          for (i = 1;; i = 0)
          {
            for (;;)
            {
              if (i == 0) {
                break label165;
              }
              try
              {
                localObject = gif.class.newInstance();
                ((com.tencent.mm.bx.a)localObject).parseFrom(paramString);
                paramString = (com.tencent.mm.bx.a)localObject;
              }
              catch (Exception paramString)
              {
                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
              }
            }
            i = 0;
            break label104;
          }
        }
      }
    }
  }
  
  private static String bmF(String paramString)
  {
    AppMethodBeat.i(296764);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(296764);
      return "";
    }
    paramString = n.m(paramString, ",", "", false);
    AppMethodBeat.o(296764);
    return paramString;
  }
  
  private static String bv(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(182661);
    s.u(paramString1, "<this>");
    s.u(paramString2, "albumId");
    paramString1 = paramString3 + '_' + paramString2 + '_' + paramString1;
    AppMethodBeat.o(182661);
    return paramString1;
  }
  
  private final void d(ox paramox)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(296755);
        Object localObject2 = paramox.hRN.hRG;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.mm.aw.a.bLn();
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(296755);
          return;
        }
        if (Util.isNullOrNil(this.XmD))
        {
          localObject2 = ((com.tencent.mm.aw.f)localObject1).oOv;
          s.s(localObject2, "musicWrapper.MusicId");
          this.XmD = ((String)localObject2);
          this.XmC = String.valueOf(System.currentTimeMillis());
        }
        Log.d("MicroMsg.MusicAlbumHelper", "doWebViewReport musicId = " + this.XmD + ", playId=" + this.XmC + ", playActionSource=" + this.XmB + "，action=" + paramox.hRN.action);
        switch (paramox.hRN.action)
        {
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
          if (!Util.isEqual(this.XmD, ((com.tencent.mm.aw.f)localObject1).oOv))
          {
            localObject1 = ((com.tencent.mm.aw.f)localObject1).oOv;
            s.s(localObject1, "musicWrapper.MusicId");
            this.XmD = ((String)localObject1);
            this.XmC = String.valueOf(System.currentTimeMillis());
            Log.d("MicroMsg.MusicAlbumHelper", "doWebViewReport new music musicId = " + this.XmD + ", playId=" + this.XmC);
          }
          switch (paramox.hRN.action)
          {
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 10: 
            AppMethodBeat.o(296755);
          }
          break;
        case 3: 
          a(bmE(this.XmD), 4);
        }
      }
      finally {}
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 7);
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 8);
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 9);
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 100);
      AppMethodBeat.o(296755);
      continue;
      this.XmB = 2;
      AppMethodBeat.o(296755);
      continue;
      this.XmB = 3;
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 1);
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 2);
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 3);
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 5);
      AppMethodBeat.o(296755);
      continue;
      a(bmE(this.XmD), 6);
      continue;
    }
  }
  
  private final gie oB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(296740);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
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
      AppMethodBeat.o(296740);
      return null;
      i = 0;
      break;
    }
    label74:
    localObject = this.vKT;
    paramString1 = oz(paramString1, paramString2);
    paramString2 = (MultiProcessMMKV)((MMKVSlotManager)localObject).findSlot(paramString1);
    if (paramString2 == null) {}
    label140:
    label179:
    label202:
    for (paramString1 = null;; paramString1 = null)
    {
      paramString1 = (gie)paramString1;
      AppMethodBeat.o(296740);
      return paramString1;
      if (paramString2.containsKey(paramString1))
      {
        paramString1 = paramString2.decodeBytes(paramString1);
        if (paramString1 != null)
        {
          if (paramString1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label179;
            }
          }
          for (i = 1;; i = 0)
          {
            for (;;)
            {
              if (i == 0) {
                break label202;
              }
              try
              {
                paramString2 = gie.class.newInstance();
                ((com.tencent.mm.bx.a)paramString2).parseFrom(paramString1);
                paramString1 = (com.tencent.mm.bx.a)paramString2;
              }
              catch (Exception paramString1)
              {
                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString1, "decode ProtoBuffer", new Object[0]);
              }
            }
            i = 0;
            break label140;
          }
        }
      }
    }
  }
  
  private static String oz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(296721);
    s.u(paramString1, "<this>");
    paramString1 = "album_" + paramString2 + '_' + paramString1 + '}';
    AppMethodBeat.o(296721);
    return paramString1;
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(182671);
    Log.d("MicroMsg.MusicAlbumHelper", "stop timer");
    this.sJn.stopTimer();
    AppMethodBeat.o(182671);
  }
  
  public final String bmD(String paramString)
  {
    try
    {
      AppMethodBeat.i(182667);
      paramString = oA(MMKVSlotManager.decodeString$default(this.vKT, "currentAlbumId", null, 2, null), paramString);
      AppMethodBeat.o(182667);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String bmG(String paramString)
  {
    AppMethodBeat.i(296836);
    paramString = bmE(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(296836);
      return null;
    }
    paramString = paramString.aceH;
    AppMethodBeat.o(296836);
    return paramString;
  }
  
  public final String bmH(String paramString)
  {
    AppMethodBeat.i(296841);
    paramString = bmE(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(296841);
      return null;
    }
    paramString = paramString.hqQ;
    AppMethodBeat.o(296841);
    return paramString;
  }
  
  public final void iBF()
  {
    label227:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182670);
        Object localObject1 = com.tencent.mm.aw.a.bLn();
        if (localObject1 != null)
        {
          if (((com.tencent.mm.aw.f)localObject1).oOv == null)
          {
            AppMethodBeat.o(182670);
            return;
          }
          Object localObject4 = com.tencent.mm.aw.a.bLo();
          if (localObject4 != null)
          {
            Object localObject3 = (MultiProcessMMKV)this.vKT.getSlotForWrite();
            Object localObject5 = bmE(((com.tencent.mm.aw.f)localObject1).oOv);
            if ((localObject5 != null) && (((gif)localObject5).Qbt >= 0))
            {
              if (((c)localObject4).mPosition > 0) {
                ((gif)localObject5).Qbt = ((c)localObject4).mPosition;
              }
              ((gif)localObject5).duration = Math.max(0, ((c)localObject4).cam);
              a(((com.tencent.mm.aw.f)localObject1).oOv, (gif)localObject5);
              localObject4 = bmG(((com.tencent.mm.aw.f)localObject1).oOv);
              localObject5 = bmH(((com.tencent.mm.aw.f)localObject1).oOv);
              localObject1 = bmE(((com.tencent.mm.aw.f)localObject1).oOv);
              if (localObject1 != null) {
                break label227;
              }
              localObject1 = null;
              if ((!Util.isNullOrNil((String)localObject4)) && (!Util.isNullOrNil((String)localObject5)))
              {
                ((MultiProcessMMKV)localObject3).encode("currentAlbumId", (String)localObject4);
                localObject3 = oB((String)localObject4, (String)localObject1);
                if (localObject3 != null)
                {
                  gie localgie = this.Xmz;
                  if (localgie != null) {
                    localgie.aceF = ((String)localObject5);
                  }
                  ((gie)localObject3).aceF = ((String)localObject5);
                  a((String)localObject4, (String)localObject1, (gie)localObject3);
                }
              }
            }
          }
        }
        AppMethodBeat.o(182670);
        continue;
        String str = localObject2.domain;
      }
      finally {}
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
    int m = 0;
    int i = 0;
    List localList = (List)new ArrayList();
    int j = m;
    for (;;)
    {
      int k;
      int n;
      try
      {
        this.Xmz = new gie();
        j = m;
        this.XmA = paramString1;
        k = 0;
        j = m;
        n = localJSONArray.length();
        if (n <= 0) {
          break label1075;
        }
        m = k + 1;
        j = i;
        paramString2 = localJSONArray.get(k);
        if (paramString2 != null) {
          break label267;
        }
        j = i;
        paramString1 = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        j = i;
        AppMethodBeat.o(182669);
        j = i;
        throw paramString1;
      }
      catch (Exception paramString1)
      {
        i = j;
      }
      label224:
      Log.w("MicroMsg.MusicAlbumHelper", "playAudioList ex:%s", new Object[] { paramString1.getMessage() });
      label267:
      JSONObject localJSONObject;
      String str2;
      String str1;
      if (Util.isNullOrNil(localList))
      {
        Log.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, wrapperList is null");
        AppMethodBeat.o(182669);
        return false;
        j = i;
        localJSONObject = (JSONObject)paramString2;
        j = i;
        str2 = localJSONObject.optString("audioId", "");
        j = i;
        if (Util.isNullOrNil(str2))
        {
          j = i;
          Log.i("MicroMsg.MusicAlbumHelper", "playAudioList audioId is empty");
          j = i;
          AppMethodBeat.o(182669);
          return false;
        }
        j = i;
        s.s(str2, "audioId");
        j = i;
        s.checkNotNull(paramString1);
        j = i;
        str1 = bv(str2, paramString1, paramString4);
        j = i;
        boolean bool = s.p(str2, paramString3);
        if (!bool) {
          break label1072;
        }
        i = k;
      }
      try
      {
        label384:
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
        if (d1 >= 0.5D) {
          if (d1 > 2.0D) {
            break label1081;
          }
        }
        for (;;)
        {
          label542:
          String str4 = localJSONObject.optString("songLyric", "");
          String str5 = localJSONObject.optString("src_username", "");
          j = localJSONObject.optInt("startTime", 0);
          if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil(str6)))
          {
            Log.e("MicroMsg.MusicAlbumHelper", "playAudioList fail, src or title is null");
            AppMethodBeat.o(182669);
            return false;
          }
          Object localObject3 = this.Xmz;
          if (localObject3 != null)
          {
            localObject3 = ((gie)localObject3).aceG;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(str2);
            }
          }
          localObject2 = g.a(10, str9, str6, str8, str10, str11, (String)localObject2, str1, b.bmz(), s.X(d.bzL(), Integer.valueOf(str9.hashCode())), str7, paramString5);
          ((com.tencent.mm.aw.f)localObject2).oOS = paramString4;
          ((com.tencent.mm.aw.f)localObject2).startTime = (j * 1000);
          ((com.tencent.mm.aw.f)localObject2).oOT = paramString2;
          ((com.tencent.mm.aw.f)localObject2).protocol = ((String)localObject1);
          ((com.tencent.mm.aw.f)localObject2).oOV = str3;
          ((com.tencent.mm.aw.f)localObject2).oOE = str4;
          ((com.tencent.mm.aw.f)localObject2).iaa = str5;
          ((com.tencent.mm.aw.f)localObject2).orm = d1;
          ((com.tencent.mm.aw.f)localObject2).volume = ((float)d2);
          localObject1 = bmE(str1);
          paramString2 = (String)localObject1;
          if (localObject1 == null) {
            paramString2 = new gif();
          }
          if (paramString2.Qbt <= 0)
          {
            paramString2.Qbt = 0;
            paramString2.aceH = paramString1;
            paramString2.hqQ = str2;
            paramString2.aceN = ((float)d1);
            localObject1 = localJSONObject.optJSONObject("reportData");
            if (localObject1 != null)
            {
              paramString2.hIY = ((JSONObject)localObject1).optInt("VoiceType", 0);
              paramString2.abNV = ((JSONObject)localObject1).optString("BizUin", "");
              paramString2.msgId = ((JSONObject)localObject1).optLong("MsgId", 0L);
              paramString2.idx = ((JSONObject)localObject1).optInt("Idx", 0);
              paramString2.aceI = ((JSONObject)localObject1).optString("SessionIdStr", "0");
              paramString2.aceJ = ((JSONObject)localObject1).optString("AlbumURL", "");
              paramString2.aceK = ((JSONObject)localObject1).optString("AlbumTitle", "");
              paramString2.aceL = ((JSONObject)localObject1).optString("AudioTitle", "");
              paramString2.vGG = ((JSONObject)localObject1).optLong("EnterId", 0L);
              paramString2.scene = ((JSONObject)localObject1).optInt("Scene", 0);
              paramString2.AcJ = ((JSONObject)localObject1).optInt("SubScene", 0);
              paramString2.aceM = ((JSONObject)localObject1).optInt("AudioPos", 0);
            }
            paramString2.domain = paramString4;
            a(str1, paramString2);
          }
          s.s(localObject2, "wrapper");
          localList.add(localObject2);
          if (m >= n) {}
          for (;;)
          {
            try
            {
              paramString2 = this.Xmz;
              s.checkNotNull(paramString2);
              a(paramString1, paramString4, paramString2);
            }
            catch (Exception paramString1) {}
            break label224;
            this.XmB = 1;
            com.tencent.mm.aw.a.o(localList, i);
            AppMethodBeat.o(182669);
            return true;
            k = m;
            break;
            break label542;
            label1072:
            break label384;
            label1075:
            i = 0;
          }
          label1081:
          d1 = 1.0D;
        }
      }
      catch (Exception paramString1) {}
    }
  }
  
  public final String oA(String paramString1, String paramString2)
  {
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
        iBF();
        if ((Util.isEqual(paramString1, this.XmA)) && (this.Xmz != null))
        {
          localObject1 = this.Xmz;
          s.checkNotNull(localObject1);
          localObject1 = ((gie)localObject1).aceG;
          if (Util.isNullOrNil((List)localObject1))
          {
            AppMethodBeat.o(182668);
            paramString1 = null;
          }
        }
        else
        {
          localObject1 = oB(paramString1, paramString2);
          if (localObject1 == null) {
            break label447;
          }
          this.Xmz = ((gie)localObject1);
          this.XmA = paramString1;
          localObject1 = ((gie)localObject1).aceG;
          continue;
        }
        JSONObject localJSONObject1;
        Object localObject2;
        try
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("albumId", paramString1);
          localObject2 = this.Xmz;
          if (localObject2 != null) {
            continue;
          }
          localObject2 = Integer.valueOf(0);
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
            break label453;
          }
          if (!n.bp((CharSequence)localObject3)) {
            break label459;
          }
        }
        catch (Exception paramString1)
        {
          JSONObject localJSONObject2;
          Log.w("MicroMsg.MusicAlbumHelper", "getAudioListState ex:%s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(182668);
          paramString1 = null;
        }
        if (i != 0) {
          continue;
        }
        s.checkNotNull(paramString1);
        Object localObject3 = bmE(bv((String)localObject2, paramString1, paramString2));
        localJSONObject2 = new JSONObject();
        if (localObject3 == null)
        {
          i = 0;
          localJSONObject2.put("currentTime", i / 1000);
          if (localObject3 == null)
          {
            i = 0;
            localJSONObject2.put("duration", i / 1000);
            if (localObject3 != null) {
              continue;
            }
            f = 1.0F;
            localJSONObject2.put("playbackRate", Float.valueOf(f));
            localJSONObject1.put((String)localObject2, localJSONObject2);
            continue;
            continue;
            localObject3 = ((gie)localObject2).aceF;
            localObject2 = localObject3;
            if (localObject3 != null) {
              continue;
            }
            localObject2 = Integer.valueOf(0);
            continue;
          }
        }
        else
        {
          i = ((gif)localObject3).Qbt;
          continue;
        }
        i = ((gif)localObject3).duration;
        continue;
        float f = ((gif)localObject3).aceN;
        continue;
        paramString1 = localJSONObject1.toString();
        AppMethodBeat.o(182668);
        continue;
        Object localObject1 = null;
      }
      finally {}
      label447:
      continue;
      label453:
      int i = 1;
      continue;
      label459:
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$Companion;", "", "()V", "TAG", "", "albumDelimiter", "currentAlbumIdKey", "<set-?>", "Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "instance", "getInstance", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static h iBH()
    {
      AppMethodBeat.i(182656);
      if (h.iBG() == null) {}
      try
      {
        if (h.iBG() == null)
        {
          localObject1 = MMApplicationContext.getContext();
          s.s(localObject1, "getContext()");
          h.b(new h((Context)localObject1, (byte)0));
          localObject1 = h.iBG();
          if (localObject1 != null) {
            ((h)localObject1).rDF.alive();
          }
        }
        Object localObject1 = ah.aiuX;
        localObject1 = h.iBG();
        AppMethodBeat.o(182656);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(182656);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h
 * JD-Core Version:    0.7.0.1
 */