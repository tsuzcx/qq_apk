package com.tencent.thumbplayer.g.a.a;

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
  private static boolean ahJE = false;
  private static com.tencent.thumbplayer.utils.c ahJI = null;
  private int UxL;
  private int ahDK;
  private boolean ahFf;
  private HandlerThread ahJF;
  private b ahJG;
  private final Object ahJH;
  private TPDefaultReportInfo ahJJ;
  private d ahJK;
  private int ahJL;
  private int ahJM;
  private boolean ahJN;
  private boolean ahJO;
  private long ahJP;
  private long ahJQ;
  private int ahJR;
  private int ahJS;
  private int ahJT;
  private boolean ahJU;
  private boolean ahJV;
  private String ahJW;
  private String ahJX;
  private String ahJY;
  private int ahJZ;
  private long ahKa;
  private c ahKb;
  private d.a ahKc;
  private d.l ahKd;
  private final e ahKe;
  private e.a ahKf;
  private int ezr;
  private Context mContext;
  private int mDownloadType;
  private boolean mIsExit;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(227257);
    this.ahJH = new Object();
    this.mIsExit = false;
    this.ahJJ = null;
    this.ahJK = null;
    this.ahJL = 1;
    this.ahJM = 0;
    this.ahJN = true;
    this.ahJO = true;
    this.ahJP = 0L;
    this.ahJQ = 0L;
    this.UxL = 0;
    this.ahJR = 0;
    this.ahJS = 0;
    this.ahJT = 0;
    this.ahJU = false;
    this.ahFf = false;
    this.ahJV = false;
    this.ahJW = "0";
    this.ahJX = "";
    this.ahDK = 0;
    this.mDownloadType = 0;
    this.ahJY = "";
    this.ahJZ = 0;
    this.ahKa = 0L;
    this.ezr = -1;
    this.ahKb = new a();
    this.ahKc = null;
    this.ahKd = null;
    this.ahKe = new e((byte)0);
    this.ahKf = new e.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
      {
        AppMethodBeat.i(227229);
        g.i("TPReportManager", "OnGlobalEventChangeListener eventId: ".concat(String.valueOf(paramAnonymousInt1)));
        switch (paramAnonymousInt1)
        {
        default: 
          AppMethodBeat.o(227229);
          return;
        }
        for (paramAnonymousInt1 = 2100;; paramAnonymousInt1 = 2101)
        {
          c.g(c.this).obtainMessage(paramAnonymousInt1, null).sendToTarget();
          AppMethodBeat.o(227229);
          return;
        }
      }
    };
    this.mContext = paramContext.getApplicationContext();
    AppMethodBeat.o(227257);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(227294);
    g.i("TPReportManager", "onReportEvent: " + parama.toString());
    AppMethodBeat.o(227294);
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(227315);
    d.n localn = this.ahJK.ahKI;
    if (localn == null)
    {
      AppMethodBeat.o(227315);
      return;
    }
    if ((this.ahJJ != null) && ((this.ahJJ instanceof TPVodReportInfo)) && (paramBoolean))
    {
      localn.ahMI = ((TPVodReportInfo)this.ahJJ).currentPlayState;
      localn.ahMJ = ((TPVodReportInfo)this.ahJJ).optimizedPlay;
      if (((TPVodReportInfo)this.ahJJ).hasSubtitles)
      {
        i = 1;
        localn.ahMK = i;
        localn.ahMN = ((TPVodReportInfo)this.ahJJ).bizId;
        localn.ahMP = ((TPVodReportInfo)this.ahJJ).clipCount;
        localn.ahMQ = ((TPVodReportInfo)this.ahJJ).videoStatus;
        localn.ahLR = this.ahJJ.freeType;
      }
    }
    else
    {
      if (!this.ahKe.ahKt) {
        break label351;
      }
      i = 1;
      label169:
      localn.ahMM = i;
      if (!this.ahKe.ahKs) {
        break label356;
      }
    }
    label351:
    label356:
    for (int i = j;; i = 0)
    {
      localn.ahML = i;
      localn.ahMO = 0;
      parama.cj("freetype", localn.ahLR);
      parama.cj("currentplay", localn.ahMI);
      parama.cj("optimizedplay", localn.ahMJ);
      parama.cj("subtitles", localn.ahMK);
      parama.cj("selsubtitles", localn.ahML);
      parama.cj("multitrack", localn.ahMM);
      parama.cj("bizid", localn.ahMN);
      parama.cj("hevclv", localn.ahMO);
      parama.cj("clip", localn.ahMP);
      parama.cj("status", localn.ahMQ);
      AppMethodBeat.o(227315);
      return;
      i = 0;
      break;
      i = 0;
      break label169;
    }
  }
  
  private static int aB(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(227344);
    if (paramMap == null)
    {
      AppMethodBeat.o(227344);
      return 0;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      int i = ((Integer)paramMap).intValue();
      AppMethodBeat.o(227344);
      return i;
    }
    AppMethodBeat.o(227344);
    return 0;
  }
  
  private static boolean aC(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(227370);
    if (paramMap == null)
    {
      AppMethodBeat.o(227370);
      return false;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      boolean bool = ((Boolean)paramMap).booleanValue();
      AppMethodBeat.o(227370);
      return bool;
    }
    AppMethodBeat.o(227370);
    return false;
  }
  
  private void aIb(int paramInt)
  {
    AppMethodBeat.i(227404);
    if (this.mContext == null)
    {
      AppMethodBeat.o(227404);
      return;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)this.mContext.getSystemService("phone");
    if (localTelephonyManager == null)
    {
      g.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      AppMethodBeat.o(227404);
      return;
    }
    g.i("TPReportManager", "EventHandler handleMessage ");
    Object localObject = new c.1(this);
    localObject = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "handleSignalStrength", "(I)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "handleSignalStrength", "(I)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(227404);
  }
  
  private static long b(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    AppMethodBeat.i(227353);
    if (paramMap == null)
    {
      AppMethodBeat.o(227353);
      return paramLong;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      paramLong = ((Long)paramMap).longValue();
      AppMethodBeat.o(227353);
      return paramLong;
    }
    AppMethodBeat.o(227353);
    return paramLong;
  }
  
  private void b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(227334);
    d.g localg = this.ahJK.ahKH;
    if (localg == null)
    {
      AppMethodBeat.o(227334);
      return;
    }
    int i;
    if ((this.ahJJ != null) && ((this.ahJJ instanceof TPLiveReportInfo)) && (paramBoolean))
    {
      localg.ahLO = ((TPLiveReportInfo)this.ahJJ).adPlayLength;
      localg.ahLU = ((TPLiveReportInfo)this.ahJJ).programId;
      localg.ahLV = ((TPLiveReportInfo)this.ahJJ).streamId;
      localg.ahLW = ((TPLiveReportInfo)this.ahJJ).contentId;
      localg.ahLX = ((TPLiveReportInfo)this.ahJJ).playTime;
      localg.ahMa = ((TPLiveReportInfo)this.ahJJ).liveType;
      if (((TPLiveReportInfo)this.ahJJ).isUserPay)
      {
        i = 1;
        localg.ahLY = i;
        if (!((TPLiveReportInfo)this.ahJJ).isLookBack) {
          break label1291;
        }
        i = 1;
        label174:
        localg.ahMc = i;
        localg.ahMb = ((TPLiveReportInfo)this.ahJJ).cdnServer;
        localg.ahLR = this.ahJJ.freeType;
        localg.ahLM = this.ahJJ.uin;
        localg.ahLL = this.ahJJ.uip;
        if (!this.ahJJ.enableP2p) {
          break label1296;
        }
        i = 1;
        label243:
        localg.ahLT = i;
      }
    }
    else
    {
      if ((this.ahJJ != null) && ((this.ahJJ instanceof TPLiveReportInfo))) {
        localg.ahMd = ((TPLiveReportInfo)this.ahJJ).liveDelay;
      }
      if (!this.ahJV) {
        break label1301;
      }
      i = 1;
      label290:
      localg.ahLS = i;
      localg.downloadUrl = this.ahKe.mOI;
      if (TextUtils.isEmpty(localg.downloadUrl)) {
        localg.downloadUrl = this.ahJK.ahKA.ahLH;
      }
      localg.ahLP = this.ahKe.cdnIp;
      localg.ahLK = System.currentTimeMillis();
      if (this.ahKe.ahKh > 0L)
      {
        localObject = this.ahKe;
        ((e)localObject).ahKi = ((int)(((e)localObject).ahKi + (System.currentTimeMillis() - this.ahKe.ahKh)));
        if ((!this.ahJN) && (!this.ahFf) && (!this.ahKe.ahEy)) {
          break label1306;
        }
        this.ahKe.ahKh = 0L;
      }
      label428:
      localg.ahLN = this.ahKe.ahKi;
      this.ahKe.ahKi = 0;
      localg.ahLu = "2.9.0.1112";
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
      localg.ahLQ = i;
      localg.ahLm = clS();
      localg.ahMh = this.ahKe.ahKp;
      this.ahKe.ahKp = 0;
      localg.ahMi = this.ahJR;
      if (this.ahKe.ahKr > 0)
      {
        localg.ahMj = (this.ahKe.ahKq / this.ahKe.ahKr);
        this.ahKe.ahKq = 0;
        this.ahKe.ahKr = 0;
      }
      localg.ahMe = 0;
      localg.ahMf = "";
      localg.ahMk = 0;
      localg.ahMg = 0;
      localg.ahMp = 0;
      localg.ahLZ = this.ahKe.ahKu;
      localg.ahMl = (this.ahKe.ahKk - this.ahKe.ahKj);
      localg.ahMm = this.ahKe.ahKl;
      localg.ahMn = this.ahKe.Gpp;
      this.ahKe.Gpp = 0;
      this.ahKe.ahKl = 0;
      localg.ahMo = 0;
      localg.ahMq = this.ahJW;
      localg.ahKv = this.ahKe.ahKv;
      localg.ahKw = this.ahKe.ahKw;
      parama.cG("ftime", localg.ahLK);
      parama.put("sip", localg.ahLL);
      parama.put("iqq", localg.ahLM);
      parama.cj("prdlength", localg.ahLN);
      parama.cj("playad", localg.ahLO);
      parama.put("fplayerver", localg.ahLu);
      parama.put("dsip", localg.ahLP);
      parama.cj("devtype", localg.ahLQ);
      parama.cj("nettype", localg.ahLm);
      parama.cj("freetype", localg.ahLR);
      parama.cj("use_p2p", localg.ahLS);
      parama.cj("p2p_play", localg.ahLT);
      parama.cj("livepid", localg.ahLU);
      parama.cj("sid", localg.ahLV);
      parama.cj("contentid", localg.ahLW);
      parama.cj("playtime", localg.ahLX);
      parama.cj("isuserpay", localg.ahLY);
      parama.put("switch", localg.ahLZ);
      parama.cj("live_type", localg.ahMa);
      parama.put("xserverip", localg.ahMb);
      parama.put("durl", localg.downloadUrl);
      parama.cj("lookback", localg.ahMc);
      parama.cj("live_delay", localg.ahMd);
      parama.cj("live_tag", localg.ahMe);
      parama.put("extraInfo", localg.ahMf);
      parama.cj("cnntime", localg.ahMg);
      parama.cj("maxspeed", localg.ahMh);
      parama.cj("testspeed", localg.ahMi);
      parama.cj("downspeed", localg.ahMj);
      parama.cj("recnncount", localg.ahMk);
      parama.cG("loadingtime", localg.ahMl);
      parama.cj("blocktime", localg.ahMm);
      parama.cj("blockcount", localg.ahMn);
      parama.cj("errorcode", localg.ahMo);
      parama.cj("geturltime", localg.ahMp);
      parama.put("fullecode", localg.ahMq);
      parama.cj("get_stream_data_duration", localg.ahMr);
      parama.cj("get_sync_frame_duration", localg.ahMs);
      parama.put("spanId", localg.ahKv);
      parama.put("tuid", localg.ahKw);
      AppMethodBeat.o(227334);
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
      this.ahKe.ahKh = System.currentTimeMillis();
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
  
  private int clS()
  {
    j = 0;
    AppMethodBeat.i(227389);
    if (this.mContext == null)
    {
      AppMethodBeat.o(227389);
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
      AppMethodBeat.o(227389);
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
  
  private void jdMethod_do(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(227266);
    g.i("TPReportManager", "onSeekComplete");
    this.ahJU = false;
    if (paramMap == null)
    {
      AppMethodBeat.o(227266);
      return;
    }
    if (this.ahKd == null)
    {
      AppMethodBeat.o(227266);
      return;
    }
    this.ahKd.ahMD = b(paramMap, "etime", System.currentTimeMillis());
    this.ahKd.ahMB = (b(paramMap, "petime", 0L) / 1000L);
    this.ahKd.ahKR = this.ahJW;
    long l = this.ahKd.ahMD - this.ahKd.ahMC;
    if (l > 1200L)
    {
      this.ahJT += 1;
      this.ahJS = ((int)(l + this.ahJS));
    }
    paramMap = this.ahJK.ahKF;
    paramMap.ahME += 1;
    paramMap.ahMG = this.ahJS;
    paramMap.ahMF = this.ahJT;
    if (paramMap.ahMH.size() < 20)
    {
      paramMap.ahMH.add(this.ahKd);
      paramMap = new h();
      d.l locall = this.ahKd;
      paramMap.cj("format", locall.ahKM);
      paramMap.cG("pstime", locall.ahMA);
      paramMap.cG("petime", locall.ahMB);
      paramMap.cG("lstime", locall.ahMC);
      paramMap.cG("letime", locall.ahMD);
      paramMap.put("code", locall.ahKR);
      this.ahKb.a(40, paramMap);
    }
    this.ahKd = null;
    AppMethodBeat.o(227266);
  }
  
  private void dp(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(227274);
    g.i("TPReportManager", "onBufferingEnd");
    this.ahFf = false;
    if (!this.ahKe.ahEy) {
      this.ahKe.ahKh = System.currentTimeMillis();
    }
    if (paramMap == null)
    {
      AppMethodBeat.o(227274);
      return;
    }
    long l = b(paramMap, "etime", System.currentTimeMillis());
    int i = (int)(l - this.ahKe.ahKm);
    if (i <= 1200)
    {
      AppMethodBeat.o(227274);
      return;
    }
    if (this.ahJU)
    {
      AppMethodBeat.o(227274);
      return;
    }
    Object localObject = this.ahKe;
    ((e)localObject).Gpp += 1;
    this.ahKe.ahKn = l;
    localObject = this.ahKe;
    ((e)localObject).ahKl += (int)(this.ahKe.ahKn - this.ahKe.ahKm);
    if (this.ahKc == null)
    {
      AppMethodBeat.o(227274);
      return;
    }
    this.ahKc.ahKP = b(paramMap, "etime", 0L);
    this.ahKc.ahKR = this.ahJW;
    paramMap = this.ahJK.ahKE;
    paramMap.ahKT += 1;
    paramMap.ahKU += i;
    if (paramMap.ahKV.size() < 20)
    {
      paramMap.ahKV.add(this.ahKc);
      paramMap = new h();
      localObject = this.ahKc;
      paramMap.cj("scene", ((d.a)localObject).ahKJ);
      paramMap.cj("levent", ((d.a)localObject).ahKK);
      paramMap.cj("reason", ((d.a)localObject).ahKL);
      paramMap.cj("format", ((d.a)localObject).ahKM);
      paramMap.cG("ptime", ((d.a)localObject).ahKN);
      paramMap.cG("stime", ((d.a)localObject).ahKO);
      paramMap.cG("etime", ((d.a)localObject).ahKP);
      paramMap.put("url", ((d.a)localObject).ahKQ);
      paramMap.put("code", ((d.a)localObject).ahKR);
      this.ahKb.a(35, paramMap);
    }
    this.ahKc = null;
    AppMethodBeat.o(227274);
  }
  
  private void dq(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(227287);
    g.i("TPReportManager", "onPlayEnd");
    if ((paramMap == null) || (this.ahJN))
    {
      AppMethodBeat.o(227287);
      return;
    }
    if (this.ahFf) {
      dp(new f().X("etime", Long.valueOf(System.currentTimeMillis())).map);
    }
    if (this.ahJU) {
      jdMethod_do(new f().X("etime", Long.valueOf(System.currentTimeMillis())).map);
    }
    if (this.ahKe.ahKh > 0L)
    {
      localObject = this.ahKe;
      ((e)localObject).ahKi += (int)(System.currentTimeMillis() - this.ahKe.ahKh);
      this.ahKe.ahKh = 0L;
    }
    this.ahJU = false;
    Object localObject = new h();
    this.ahJK.ahKE.c((a)localObject);
    this.ahJK.ahKE.reset();
    this.ahJK.ahKF.c((a)localObject);
    this.ahJK.ahKF.reset();
    d.i locali = this.ahJK.ahKG;
    locali.ahKP = b(paramMap, "etime", System.currentTimeMillis());
    locali.ahKL = aB(paramMap, "reason");
    locali.ahKR = this.ahJW;
    if (this.ahJP > 0L)
    {
      this.ahJQ += locali.ahKP - this.ahJP;
      this.ahJP = 0L;
    }
    locali.ahMv = ((float)this.ahJQ / 1000.0F);
    locali.c((a)localObject);
    this.ahKb.a(50, (a)localObject);
    this.ahJN = true;
    this.ahJW = "0";
    this.ahJP = 0L;
    this.ahJQ = 0L;
    this.ahJT = 0;
    this.ahJS = 0;
    paramMap = this.ahKe;
    paramMap.ahKh = 0L;
    paramMap.ahKi = 0;
    paramMap.ahKj = 0L;
    paramMap.ahKk = 0L;
    paramMap.Gpp = 0;
    paramMap.ahKl = 0;
    paramMap.ahKm = 0L;
    paramMap.ahKn = 0L;
    paramMap.ahKo = 0;
    paramMap.ahKp = 0;
    paramMap.ahKq = 0;
    paramMap.ahKr = 0;
    paramMap.ahKs = false;
    paramMap.ahKt = false;
    paramMap.ahEy = false;
    paramMap.ahKu = "";
    paramMap.mOI = "";
    paramMap.cdnIp = "";
    paramMap.cdnUip = "";
    paramMap.ahKv = "";
    paramMap.ahKw = "";
    kbn();
    AppMethodBeat.o(227287);
  }
  
  private static String f(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(227364);
    if (paramMap == null)
    {
      AppMethodBeat.o(227364);
      return paramString2;
    }
    paramMap = paramMap.get(paramString1);
    if (paramMap != null)
    {
      paramMap = (String)paramMap;
      AppMethodBeat.o(227364);
      return paramMap;
    }
    AppMethodBeat.o(227364);
    return paramString2;
  }
  
  private void kbm()
  {
    AppMethodBeat.i(227299);
    g.i("TPReportManager", "onLivePeriodReport");
    h localh = new h();
    this.ahKb.a(263, localh);
    AppMethodBeat.o(227299);
  }
  
  private void kbn()
  {
    AppMethodBeat.i(227308);
    g.i("TPReportManager", "removeCacheEvent: mFlowId: " + this.ahJX);
    if ((ahJI != null) && (!TextUtils.isEmpty(this.ahJX))) {
      ahJI.bGj(this.ahJX);
    }
    AppMethodBeat.o(227308);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(227790);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(227790);
      return;
    case 100: 
      paramInt1 = 999;
    }
    for (;;)
    {
      this.ahJG.obtainMessage(paramInt1, paramObject).sendToTarget();
      AppMethodBeat.o(227790);
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
  
  public final void bwk()
  {
    AppMethodBeat.i(227774);
    this.ahJF = new HandlerThread("TP-ReportThread");
    this.ahJF.start();
    this.ahJG = new b(this.ahJF.getLooper());
    this.ahJK = new d();
    this.ahJG.sendEmptyMessage(4001);
    e.a(this.ahKf);
    try
    {
      if (ahJI == null) {
        ahJI = new com.tencent.thumbplayer.utils.c(this.mContext, "TPReportCache");
      }
      if (!ahJE) {
        this.ahJG.obtainMessage(4000).sendToTarget();
      }
      ahJE = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(227774);
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(227784);
    g.i("TPReportManager", "release: ");
    this.ahJG.sendEmptyMessage(4002);
    e.b(this.ahKf);
    if (this.ahJF != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label75;
      }
      this.ahJF.quitSafely();
    }
    for (;;)
    {
      this.ahJF = null;
      g.i("TPReportManager", "release: end!");
      AppMethodBeat.o(227784);
      return;
      label75:
      synchronized (this.ahJH)
      {
        this.mIsExit = false;
        this.ahJG.sendEmptyMessage(100);
        for (;;)
        {
          boolean bool = this.mIsExit;
          if (!bool) {
            try
            {
              this.ahJH.wait(5000L, 0);
            }
            catch (InterruptedException localInterruptedException)
            {
              g.e("TPReportManager", localInterruptedException);
            }
          }
        }
      }
      this.ahJF.quit();
    }
  }
  
  public void reportEvent(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(227767);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(227767);
      return;
    case 1000: 
      paramInt = 2000;
    }
    for (;;)
    {
      this.ahJG.obtainMessage(paramInt, localObject).sendToTarget();
      AppMethodBeat.o(227767);
      return;
      paramInt = 2001;
      continue;
      paramInt = 2003;
    }
  }
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    this.ahJJ = paramTPDefaultReportInfo;
  }
  
  final class a
    implements c.c
  {
    a() {}
    
    public final void a(int paramInt, a parama)
    {
      AppMethodBeat.i(227281);
      boolean bool = true;
      if (paramInt > 30) {
        bool = false;
      }
      c.a(c.this, parama, paramInt, bool);
      c.b(parama);
      AppMethodBeat.o(227281);
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
      AppMethodBeat.i(227277);
      Map localMap = null;
      if ((paramMessage.obj instanceof Map)) {
        localMap = (Map)paramMessage.obj;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(227277);
        return;
        c.a(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.b(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.c(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.d(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.e(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.f(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.g(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.h(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.i(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.j(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.k(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.l(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.m(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.n(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.o(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.p(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.q(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.r(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.s(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.t(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.u(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.v(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.w(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.x(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.y(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.z(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.A(c.this, localMap);
        AppMethodBeat.o(227277);
        return;
        c.a(c.this);
        AppMethodBeat.o(227277);
        return;
        c.b(c.this);
        AppMethodBeat.o(227277);
        return;
        if ((paramMessage.obj instanceof String))
        {
          c.a(c.this, (String)paramMessage.obj);
          AppMethodBeat.o(227277);
          return;
          c.c(c.this);
          AppMethodBeat.o(227277);
          return;
          c.d(c.this);
          AppMethodBeat.o(227277);
          return;
          c.kbo();
          AppMethodBeat.o(227277);
          return;
          c.e(c.this);
          AppMethodBeat.o(227277);
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
      AppMethodBeat.i(227285);
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
        AppMethodBeat.o(227285);
        return;
      case 30: 
        paramInt = 205;
      }
      for (;;)
      {
        c.a(c.this, parama, paramInt, bool1);
        c.b(c.this, parama, bool1);
        if (paramInt != 205) {
          parama.cj("loadingtime", 0);
        }
        g.i("TPReportManager", "liveExParam.prePlayLengthInt: " + c.h(c.this).ahKH.ahLN);
        c.b(parama);
        AppMethodBeat.o(227285);
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
    int Gpp = 0;
    boolean ahEy = false;
    long ahKh = 0L;
    int ahKi = 0;
    long ahKj = 0L;
    long ahKk = 0L;
    int ahKl = 0;
    long ahKm = 0L;
    long ahKn = 0L;
    int ahKo = 0;
    int ahKp = 0;
    int ahKq = 0;
    int ahKr = 0;
    boolean ahKs = false;
    boolean ahKt = false;
    String ahKu = "";
    String ahKv = "";
    String ahKw = "";
    String cdnIp = "";
    String cdnUip = "";
    String mOI = "";
    
    private e() {}
  }
  
  final class f
    implements c.c
  {
    f() {}
    
    public final void a(int paramInt, a parama)
    {
      AppMethodBeat.i(227279);
      boolean bool = true;
      if (paramInt > 30) {
        bool = false;
      }
      c.a(c.this, parama, paramInt, bool);
      c.a(c.this, parama, bool);
      c.b(parama);
      AppMethodBeat.o(227279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.a.c
 * JD-Core Version:    0.7.0.1
 */