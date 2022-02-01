package com.tencent.thumbplayer.g.a.a;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.api.report.TPLiveReportInfo;
import com.tencent.thumbplayer.api.report.TPVodReportInfo;
import com.tencent.thumbplayer.utils.e;
import com.tencent.thumbplayer.utils.e.a;
import com.tencent.thumbplayer.utils.f;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c
  implements ITPBusinessReportManager, com.tencent.thumbplayer.g.a.a
{
  private static boolean ZEB = false;
  private static com.tencent.thumbplayer.utils.c ZEF = null;
  private boolean ZAc;
  private HandlerThread ZEC;
  private b ZED;
  private final Object ZEE;
  private TPDefaultReportInfo ZEG;
  private d ZEH;
  private int ZEI;
  private int ZEJ;
  private boolean ZEK;
  private boolean ZEL;
  private long ZEM;
  private long ZEN;
  private int ZEO;
  private int ZEP;
  private int ZEQ;
  private boolean ZER;
  private boolean ZES;
  private String ZET;
  private String ZEU;
  private String ZEV;
  private int ZEW;
  private long ZEX;
  private c ZEY;
  private d.a ZEZ;
  private d.l ZFa;
  private final e ZFb;
  private e.a ZFc;
  private int ZyH;
  private int cGd;
  private Context mContext;
  private int mDownloadType;
  private boolean mIsExit;
  private int pIN;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(221620);
    this.ZEE = new Object();
    this.mIsExit = false;
    this.ZEG = null;
    this.ZEH = null;
    this.ZEI = 1;
    this.ZEJ = 0;
    this.ZEK = true;
    this.ZEL = true;
    this.ZEM = 0L;
    this.ZEN = 0L;
    this.pIN = 0;
    this.ZEO = 0;
    this.ZEP = 0;
    this.ZEQ = 0;
    this.ZER = false;
    this.ZAc = false;
    this.ZES = false;
    this.ZET = "0";
    this.ZEU = "";
    this.ZyH = 0;
    this.mDownloadType = 0;
    this.ZEV = "";
    this.ZEW = 0;
    this.ZEX = 0L;
    this.cGd = -1;
    this.ZEY = new a();
    this.ZEZ = null;
    this.ZFa = null;
    this.ZFb = new e((byte)0);
    this.ZFc = new c.2(this);
    this.mContext = paramContext.getApplicationContext();
    AppMethodBeat.o(221620);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(221665);
    g.i("TPReportManager", "onReportEvent: " + parama.toString());
    AppMethodBeat.o(221665);
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(221679);
    d.n localn = this.ZEH.ZFF;
    if (localn == null)
    {
      AppMethodBeat.o(221679);
      return;
    }
    if ((this.ZEG != null) && ((this.ZEG instanceof TPVodReportInfo)) && (paramBoolean))
    {
      localn.ZHF = ((TPVodReportInfo)this.ZEG).currentPlayState;
      localn.ZHG = ((TPVodReportInfo)this.ZEG).optimizedPlay;
      if (((TPVodReportInfo)this.ZEG).hasSubtitles)
      {
        i = 1;
        localn.ZHH = i;
        localn.ZHK = ((TPVodReportInfo)this.ZEG).bizId;
        localn.ZHM = ((TPVodReportInfo)this.ZEG).clipCount;
        localn.ZHN = ((TPVodReportInfo)this.ZEG).videoStatus;
        localn.ZGO = this.ZEG.freeType;
      }
    }
    else
    {
      if (!this.ZFb.ZFq) {
        break label351;
      }
      i = 1;
      label169:
      localn.ZHJ = i;
      if (!this.ZFb.ZFp) {
        break label356;
      }
    }
    label351:
    label356:
    for (int i = j;; i = 0)
    {
      localn.ZHI = i;
      localn.ZHL = 0;
      parama.bR("freetype", localn.ZGO);
      parama.bR("currentplay", localn.ZHF);
      parama.bR("optimizedplay", localn.ZHG);
      parama.bR("subtitles", localn.ZHH);
      parama.bR("selsubtitles", localn.ZHI);
      parama.bR("multitrack", localn.ZHJ);
      parama.bR("bizid", localn.ZHK);
      parama.bR("hevclv", localn.ZHL);
      parama.bR("clip", localn.ZHM);
      parama.bR("status", localn.ZHN);
      AppMethodBeat.o(221679);
      return;
      i = 0;
      break;
      i = 0;
      break label169;
    }
  }
  
  private void aBp(int paramInt)
  {
    AppMethodBeat.i(221767);
    if (this.mContext == null)
    {
      AppMethodBeat.o(221767);
      return;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)this.mContext.getSystemService("phone");
    if (localTelephonyManager == null)
    {
      g.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      AppMethodBeat.o(221767);
      return;
    }
    g.i("TPReportManager", "EventHandler handleMessage ");
    Object localObject = new c.1(this);
    localObject = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "handleSignalStrength", "(I)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "handleSignalStrength", "(I)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(221767);
  }
  
  private static int ah(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(221742);
    if (paramMap == null)
    {
      AppMethodBeat.o(221742);
      return 0;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      int i = ((Integer)paramMap).intValue();
      AppMethodBeat.o(221742);
      return i;
    }
    AppMethodBeat.o(221742);
    return 0;
  }
  
  private static boolean ai(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(221751);
    if (paramMap == null)
    {
      AppMethodBeat.o(221751);
      return false;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      boolean bool = ((Boolean)paramMap).booleanValue();
      AppMethodBeat.o(221751);
      return bool;
    }
    AppMethodBeat.o(221751);
    return false;
  }
  
  private static long b(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    AppMethodBeat.i(221744);
    if (paramMap == null)
    {
      AppMethodBeat.o(221744);
      return paramLong;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      paramLong = ((Long)paramMap).longValue();
      AppMethodBeat.o(221744);
      return paramLong;
    }
    AppMethodBeat.o(221744);
    return paramLong;
  }
  
  private void b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(221710);
    d.g localg = this.ZEH.ZFE;
    if (localg == null)
    {
      AppMethodBeat.o(221710);
      return;
    }
    int i;
    if ((this.ZEG != null) && ((this.ZEG instanceof TPLiveReportInfo)) && (paramBoolean))
    {
      localg.ZGL = ((TPLiveReportInfo)this.ZEG).adPlayLength;
      localg.ZGR = ((TPLiveReportInfo)this.ZEG).programId;
      localg.ZGS = ((TPLiveReportInfo)this.ZEG).streamId;
      localg.ZGT = ((TPLiveReportInfo)this.ZEG).contentId;
      localg.ZGU = ((TPLiveReportInfo)this.ZEG).playTime;
      localg.ZGX = ((TPLiveReportInfo)this.ZEG).liveType;
      if (((TPLiveReportInfo)this.ZEG).isUserPay)
      {
        i = 1;
        localg.ZGV = i;
        if (!((TPLiveReportInfo)this.ZEG).isLookBack) {
          break label1291;
        }
        i = 1;
        label174:
        localg.ZGZ = i;
        localg.ZGY = ((TPLiveReportInfo)this.ZEG).cdnServer;
        localg.ZGO = this.ZEG.freeType;
        localg.ZGJ = this.ZEG.uin;
        localg.ZGI = this.ZEG.uip;
        if (!this.ZEG.enableP2p) {
          break label1296;
        }
        i = 1;
        label243:
        localg.ZGQ = i;
      }
    }
    else
    {
      if ((this.ZEG != null) && ((this.ZEG instanceof TPLiveReportInfo))) {
        localg.ZHa = ((TPLiveReportInfo)this.ZEG).liveDelay;
      }
      if (!this.ZES) {
        break label1301;
      }
      i = 1;
      label290:
      localg.ZGP = i;
      localg.downloadUrl = this.ZFb.smT;
      if (TextUtils.isEmpty(localg.downloadUrl)) {
        localg.downloadUrl = this.ZEH.ZFx.ZGE;
      }
      localg.ZGM = this.ZFb.cdnIp;
      localg.ZGH = System.currentTimeMillis();
      if (this.ZFb.ZFe > 0L)
      {
        localObject = this.ZFb;
        ((e)localObject).ZFf = ((int)(((e)localObject).ZFf + (System.currentTimeMillis() - this.ZFb.ZFe)));
        if ((!this.ZEK) && (!this.ZAc) && (!this.ZFb.Zzw)) {
          break label1306;
        }
        this.ZFb.ZFe = 0L;
      }
      label428:
      localg.ZGK = this.ZFb.ZFf;
      this.ZFb.ZFf = 0;
      localg.ZGr = "2.9.0.1112";
      Object localObject = (UiModeManager)this.mContext.getSystemService("uimode");
      if (localObject == null) {
        break label1344;
      }
      if (((UiModeManager)localObject).getCurrentModeType() != 4) {
        break label1319;
      }
      i = 9;
    }
    for (;;)
    {
      localg.ZGN = i;
      localg.ZGj = bMs();
      localg.ZHe = this.ZFb.ZFm;
      this.ZFb.ZFm = 0;
      localg.ZHf = this.ZEO;
      if (this.ZFb.ZFo > 0)
      {
        localg.ZHg = (this.ZFb.ZFn / this.ZFb.ZFo);
        this.ZFb.ZFn = 0;
        this.ZFb.ZFo = 0;
      }
      localg.ZHb = 0;
      localg.ZHc = "";
      localg.ZHh = 0;
      localg.ZHd = 0;
      localg.ZHm = 0;
      localg.ZGW = this.ZFb.ZFr;
      localg.ZHi = (this.ZFb.ZFh - this.ZFb.ZFg);
      localg.ZHj = this.ZFb.ZFi;
      localg.ZHk = this.ZFb.MTA;
      this.ZFb.MTA = 0;
      this.ZFb.ZFi = 0;
      localg.ZHl = 0;
      localg.ZHn = this.ZET;
      localg.ZFs = this.ZFb.ZFs;
      localg.ZFt = this.ZFb.ZFt;
      parama.cu("ftime", localg.ZGH);
      parama.put("sip", localg.ZGI);
      parama.put("iqq", localg.ZGJ);
      parama.bR("prdlength", localg.ZGK);
      parama.bR("playad", localg.ZGL);
      parama.put("fplayerver", localg.ZGr);
      parama.put("dsip", localg.ZGM);
      parama.bR("devtype", localg.ZGN);
      parama.bR("nettype", localg.ZGj);
      parama.bR("freetype", localg.ZGO);
      parama.bR("use_p2p", localg.ZGP);
      parama.bR("p2p_play", localg.ZGQ);
      parama.bR("livepid", localg.ZGR);
      parama.bR("sid", localg.ZGS);
      parama.bR("contentid", localg.ZGT);
      parama.bR("playtime", localg.ZGU);
      parama.bR("isuserpay", localg.ZGV);
      parama.put("switch", localg.ZGW);
      parama.bR("live_type", localg.ZGX);
      parama.put("xserverip", localg.ZGY);
      parama.put("durl", localg.downloadUrl);
      parama.bR("lookback", localg.ZGZ);
      parama.bR("live_delay", localg.ZHa);
      parama.bR("live_tag", localg.ZHb);
      parama.put("extraInfo", localg.ZHc);
      parama.bR("cnntime", localg.ZHd);
      parama.bR("maxspeed", localg.ZHe);
      parama.bR("testspeed", localg.ZHf);
      parama.bR("downspeed", localg.ZHg);
      parama.bR("recnncount", localg.ZHh);
      parama.cu("loadingtime", localg.ZHi);
      parama.bR("blocktime", localg.ZHj);
      parama.bR("blockcount", localg.ZHk);
      parama.bR("errorcode", localg.ZHl);
      parama.bR("geturltime", localg.ZHm);
      parama.put("fullecode", localg.ZHn);
      parama.bR("get_stream_data_duration", localg.ZHo);
      parama.bR("get_sync_frame_duration", localg.ZHp);
      parama.put("spanId", localg.ZFs);
      parama.put("tuid", localg.ZFt);
      AppMethodBeat.o(221710);
      return;
      i = 0;
      break;
      label1291:
      i = 0;
      break label174;
      label1296:
      i = 0;
      break label243;
      label1301:
      i = 0;
      break label290;
      label1306:
      this.ZFb.ZFe = System.currentTimeMillis();
      break label428;
      label1319:
      if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) {
        i = 5;
      } else {
        label1344:
        i = 2;
      }
    }
  }
  
  @SuppressLint({"MissingPermission"})
  private int bMs()
  {
    j = 0;
    AppMethodBeat.i(221761);
    if (this.mContext == null)
    {
      AppMethodBeat.o(221761);
      return 0;
    }
    for (;;)
    {
      try
      {
        localObject = (ConnectivityManager)this.mContext.getSystemService("connectivity");
        i = j;
        if (localObject != null)
        {
          localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
          i = j;
          if (localObject != null)
          {
            i = j;
            if (((NetworkInfo)localObject).isConnected())
            {
              i = ((NetworkInfo)localObject).getType();
              switch (i)
              {
              default: 
                i = j;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        g.e("TPReportManager", localException);
        int i = j;
        continue;
      }
      AppMethodBeat.o(221761);
      return i;
      i = ((NetworkInfo)localObject).getSubtype();
      switch (i)
      {
      default: 
        i = 0;
        break;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        i = 2;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        i = 3;
        break;
      case 13: 
        i = 4;
        continue;
        i = 1;
        continue;
        i = 10;
      }
    }
  }
  
  private void cv(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(221624);
    g.i("TPReportManager", "onSeekComplete");
    this.ZER = false;
    if (paramMap == null)
    {
      AppMethodBeat.o(221624);
      return;
    }
    if (this.ZFa == null)
    {
      AppMethodBeat.o(221624);
      return;
    }
    this.ZFa.ZHA = b(paramMap, "etime", System.currentTimeMillis());
    this.ZFa.ZHy = (b(paramMap, "petime", 0L) / 1000L);
    this.ZFa.ZFO = this.ZET;
    long l = this.ZFa.ZHA - this.ZFa.ZHz;
    if (l > 1200L)
    {
      this.ZEQ += 1;
      this.ZEP = ((int)(l + this.ZEP));
    }
    paramMap = this.ZEH.ZFC;
    paramMap.ZHB += 1;
    paramMap.ZHD = this.ZEP;
    paramMap.ZHC = this.ZEQ;
    if (paramMap.ZHE.size() < 20)
    {
      paramMap.ZHE.add(this.ZFa);
      paramMap = new h();
      d.l locall = this.ZFa;
      paramMap.bR("format", locall.ZFJ);
      paramMap.cu("pstime", locall.ZHx);
      paramMap.cu("petime", locall.ZHy);
      paramMap.cu("lstime", locall.ZHz);
      paramMap.cu("letime", locall.ZHA);
      paramMap.put("code", locall.ZFO);
      this.ZEY.a(40, paramMap);
    }
    this.ZFa = null;
    AppMethodBeat.o(221624);
  }
  
  private void cw(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(221636);
    g.i("TPReportManager", "onBufferingEnd");
    this.ZAc = false;
    if (!this.ZFb.Zzw) {
      this.ZFb.ZFe = System.currentTimeMillis();
    }
    if (paramMap == null)
    {
      AppMethodBeat.o(221636);
      return;
    }
    long l = b(paramMap, "etime", System.currentTimeMillis());
    int i = (int)(l - this.ZFb.ZFj);
    if (i <= 1200)
    {
      AppMethodBeat.o(221636);
      return;
    }
    if (this.ZER)
    {
      AppMethodBeat.o(221636);
      return;
    }
    Object localObject = this.ZFb;
    ((e)localObject).MTA += 1;
    this.ZFb.ZFk = l;
    localObject = this.ZFb;
    ((e)localObject).ZFi += (int)(this.ZFb.ZFk - this.ZFb.ZFj);
    if (this.ZEZ == null)
    {
      AppMethodBeat.o(221636);
      return;
    }
    this.ZEZ.ZFM = b(paramMap, "etime", 0L);
    this.ZEZ.ZFO = this.ZET;
    paramMap = this.ZEH.ZFB;
    paramMap.ZFQ += 1;
    paramMap.ZFR += i;
    if (paramMap.ZFS.size() < 20)
    {
      paramMap.ZFS.add(this.ZEZ);
      paramMap = new h();
      localObject = this.ZEZ;
      paramMap.bR("scene", ((d.a)localObject).ZFG);
      paramMap.bR("levent", ((d.a)localObject).ZFH);
      paramMap.bR("reason", ((d.a)localObject).ZFI);
      paramMap.bR("format", ((d.a)localObject).ZFJ);
      paramMap.cu("ptime", ((d.a)localObject).ZFK);
      paramMap.cu("stime", ((d.a)localObject).ZFL);
      paramMap.cu("etime", ((d.a)localObject).ZFM);
      paramMap.put("url", ((d.a)localObject).ZFN);
      paramMap.put("code", ((d.a)localObject).ZFO);
      this.ZEY.a(35, paramMap);
    }
    this.ZEZ = null;
    AppMethodBeat.o(221636);
  }
  
  private void cx(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(221662);
    g.i("TPReportManager", "onPlayEnd");
    if ((paramMap == null) || (this.ZEK))
    {
      AppMethodBeat.o(221662);
      return;
    }
    if (this.ZAc) {
      cw(new f().L("etime", Long.valueOf(System.currentTimeMillis())).map);
    }
    if (this.ZER) {
      cv(new f().L("etime", Long.valueOf(System.currentTimeMillis())).map);
    }
    if (this.ZFb.ZFe > 0L)
    {
      localObject = this.ZFb;
      ((e)localObject).ZFf += (int)(System.currentTimeMillis() - this.ZFb.ZFe);
      this.ZFb.ZFe = 0L;
    }
    this.ZER = false;
    Object localObject = new h();
    this.ZEH.ZFB.c((a)localObject);
    this.ZEH.ZFB.reset();
    this.ZEH.ZFC.c((a)localObject);
    this.ZEH.ZFC.reset();
    d.i locali = this.ZEH.ZFD;
    locali.ZFM = b(paramMap, "etime", System.currentTimeMillis());
    locali.ZFI = ah(paramMap, "reason");
    locali.ZFO = this.ZET;
    if (this.ZEM > 0L)
    {
      this.ZEN += locali.ZFM - this.ZEM;
      this.ZEM = 0L;
    }
    locali.ZHs = ((float)this.ZEN / 1000.0F);
    locali.c((a)localObject);
    this.ZEY.a(50, (a)localObject);
    this.ZEK = true;
    this.ZET = "0";
    this.ZEM = 0L;
    this.ZEN = 0L;
    this.ZEQ = 0;
    this.ZEP = 0;
    paramMap = this.ZFb;
    paramMap.ZFe = 0L;
    paramMap.ZFf = 0;
    paramMap.ZFg = 0L;
    paramMap.ZFh = 0L;
    paramMap.MTA = 0;
    paramMap.ZFi = 0;
    paramMap.ZFj = 0L;
    paramMap.ZFk = 0L;
    paramMap.ZFl = 0;
    paramMap.ZFm = 0;
    paramMap.ZFn = 0;
    paramMap.ZFo = 0;
    paramMap.ZFp = false;
    paramMap.ZFq = false;
    paramMap.Zzw = false;
    paramMap.ZFr = "";
    paramMap.smT = "";
    paramMap.cdnIp = "";
    paramMap.cdnUip = "";
    paramMap.ZFs = "";
    paramMap.ZFt = "";
    irN();
    AppMethodBeat.o(221662);
  }
  
  private static String g(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(221749);
    if (paramMap == null)
    {
      AppMethodBeat.o(221749);
      return paramString2;
    }
    paramMap = paramMap.get(paramString1);
    if (paramMap != null)
    {
      paramMap = (String)paramMap;
      AppMethodBeat.o(221749);
      return paramMap;
    }
    AppMethodBeat.o(221749);
    return paramString2;
  }
  
  private void irM()
  {
    AppMethodBeat.i(221671);
    g.i("TPReportManager", "onLivePeriodReport");
    h localh = new h();
    this.ZEY.a(263, localh);
    AppMethodBeat.o(221671);
  }
  
  private void irN()
  {
    AppMethodBeat.i(221674);
    g.i("TPReportManager", "removeCacheEvent: mFlowId: " + this.ZEU);
    if ((ZEF != null) && (!TextUtils.isEmpty(this.ZEU))) {
      ZEF.bDD(this.ZEU);
    }
    AppMethodBeat.o(221674);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(221741);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(221741);
      return;
    case 100: 
      paramInt1 = 999;
    }
    for (;;)
    {
      this.ZED.obtainMessage(paramInt1, paramObject).sendToTarget();
      AppMethodBeat.o(221741);
      return;
      paramInt1 = 1000;
      continue;
      paramInt1 = 1001;
      continue;
      paramInt1 = 1002;
      continue;
      paramInt1 = 1003;
      continue;
      paramInt1 = 1012;
      continue;
      paramInt1 = 1004;
      continue;
      paramInt1 = 1005;
      continue;
      paramInt1 = 1006;
      continue;
      paramInt1 = 1007;
      continue;
      paramInt1 = 1008;
      continue;
      paramInt1 = 1009;
      continue;
      paramInt1 = 1010;
      continue;
      paramInt1 = 1011;
      continue;
      paramInt1 = 1013;
      continue;
      paramInt1 = 1014;
      continue;
      paramInt1 = 1015;
      continue;
      paramInt1 = 2002;
      continue;
      paramInt1 = 1016;
      continue;
      paramInt1 = 1019;
      continue;
      paramInt1 = 1020;
      continue;
      paramInt1 = 1021;
      continue;
      paramInt1 = 1017;
      continue;
      paramInt1 = 1018;
      continue;
      paramInt1 = 1022;
    }
  }
  
  public final void bbp()
  {
    AppMethodBeat.i(221724);
    this.ZEC = new HandlerThread("TP-ReportThread");
    this.ZEC.start();
    this.ZED = new b(this.ZEC.getLooper());
    this.ZEH = new d();
    this.ZED.sendEmptyMessage(4001);
    e.a(this.ZFc);
    try
    {
      if (ZEF == null) {
        ZEF = new com.tencent.thumbplayer.utils.c(this.mContext, "TPReportCache");
      }
      if (!ZEB) {
        this.ZED.obtainMessage(4000).sendToTarget();
      }
      ZEB = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(221724);
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(221729);
    g.i("TPReportManager", "release: ");
    this.ZED.sendEmptyMessage(4002);
    e.b(this.ZFc);
    if (this.ZEC != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label75;
      }
      this.ZEC.quitSafely();
    }
    for (;;)
    {
      this.ZEC = null;
      g.i("TPReportManager", "release: end!");
      AppMethodBeat.o(221729);
      return;
      label75:
      synchronized (this.ZEE)
      {
        this.mIsExit = false;
        this.ZED.sendEmptyMessage(100);
        for (;;)
        {
          boolean bool = this.mIsExit;
          if (!bool) {
            try
            {
              this.ZEE.wait(5000L, 0);
            }
            catch (InterruptedException localInterruptedException)
            {
              g.e("TPReportManager", localInterruptedException);
            }
          }
        }
      }
      this.ZEC.quit();
    }
  }
  
  public void reportEvent(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(221715);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(221715);
      return;
    case 1000: 
      paramInt = 2000;
    }
    for (;;)
    {
      this.ZED.obtainMessage(paramInt, localObject).sendToTarget();
      AppMethodBeat.o(221715);
      return;
      paramInt = 2001;
      continue;
      paramInt = 2003;
    }
  }
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    this.ZEG = paramTPDefaultReportInfo;
  }
  
  final class a
    implements c.c
  {
    a() {}
    
    public final void a(int paramInt, a parama)
    {
      AppMethodBeat.i(221584);
      boolean bool = true;
      if (paramInt > 30) {
        bool = false;
      }
      c.a(c.this, parama, paramInt, bool);
      c.b(parama);
      AppMethodBeat.o(221584);
    }
  }
  
  final class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(221592);
      Map localMap = null;
      if ((paramMessage.obj instanceof Map)) {
        localMap = (Map)paramMessage.obj;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(221592);
        return;
        c.a(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.b(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.c(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.d(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.e(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.f(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.g(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.h(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.i(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.j(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.k(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.l(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.m(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.n(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.o(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.p(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.q(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.r(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.s(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.t(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.u(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.v(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.w(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.x(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.y(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.z(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.A(c.this, localMap);
        AppMethodBeat.o(221592);
        return;
        c.a(c.this);
        AppMethodBeat.o(221592);
        return;
        c.b(c.this);
        AppMethodBeat.o(221592);
        return;
        if ((paramMessage.obj instanceof String))
        {
          c.a(c.this, (String)paramMessage.obj);
          AppMethodBeat.o(221592);
          return;
          c.c(c.this);
          AppMethodBeat.o(221592);
          return;
          c.d(c.this);
          AppMethodBeat.o(221592);
          return;
          c.irO();
          AppMethodBeat.o(221592);
          return;
          c.e(c.this);
          AppMethodBeat.o(221592);
          return;
          c.f(c.this);
        }
      }
    }
  }
  
  static abstract interface c
  {
    public abstract void a(int paramInt, a parama);
  }
  
  final class d
    implements c.c
  {
    d() {}
    
    public final void a(int paramInt, a parama)
    {
      AppMethodBeat.i(221594);
      parama = new h();
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInt > 30)
      {
        bool1 = bool2;
        if (paramInt != 263) {
          bool1 = false;
        }
      }
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(221594);
        return;
      case 30: 
        paramInt = 205;
      }
      for (;;)
      {
        c.a(c.this, parama, paramInt, bool1);
        c.b(c.this, parama, bool1);
        if (paramInt != 205) {
          parama.bR("loadingtime", 0);
        }
        g.i("TPReportManager", "liveExParam.prePlayLengthInt: " + c.h(c.this).ZFE.ZGK);
        c.b(parama);
        AppMethodBeat.o(221594);
        return;
        c.g(c.this).removeMessages(3000);
        paramInt = 263;
        continue;
        c.g(c.this).removeMessages(3000);
        continue;
        c.g(c.this).removeMessages(3000);
        c.g(c.this).sendEmptyMessageDelayed(3000, 60000L);
      }
    }
  }
  
  final class e
  {
    int MTA = 0;
    long ZFe = 0L;
    int ZFf = 0;
    long ZFg = 0L;
    long ZFh = 0L;
    int ZFi = 0;
    long ZFj = 0L;
    long ZFk = 0L;
    int ZFl = 0;
    int ZFm = 0;
    int ZFn = 0;
    int ZFo = 0;
    boolean ZFp = false;
    boolean ZFq = false;
    String ZFr = "";
    String ZFs = "";
    String ZFt = "";
    boolean Zzw = false;
    String cdnIp = "";
    String cdnUip = "";
    String smT = "";
    
    private e() {}
  }
  
  final class f
    implements c.c
  {
    f() {}
    
    public final void a(int paramInt, a parama)
    {
      AppMethodBeat.i(221605);
      boolean bool = true;
      if (paramInt > 30) {
        bool = false;
      }
      c.a(c.this, parama, paramInt, bool);
      c.a(c.this, parama, bool);
      c.b(parama);
      AppMethodBeat.o(221605);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.a.c
 * JD-Core Version:    0.7.0.1
 */