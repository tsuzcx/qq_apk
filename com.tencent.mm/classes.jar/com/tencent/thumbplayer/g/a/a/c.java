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
  private static boolean SbQ = false;
  private static com.tencent.thumbplayer.utils.c SbU = null;
  private PhoneStateListener GUP;
  private int RVX;
  private boolean RXs;
  private HandlerThread SbR;
  private b SbS;
  private final Object SbT;
  private TPDefaultReportInfo SbV;
  private d SbW;
  private int SbX;
  private int SbY;
  private boolean SbZ;
  private boolean Sca;
  private long Scb;
  private long Scc;
  private int Scd;
  private int Sce;
  private int Scf;
  private boolean Scg;
  private boolean Sch;
  private String Sci;
  private String Scj;
  private String Sck;
  private int Scl;
  private long Scm;
  private c Scn;
  private d.a Sco;
  private d.l Scp;
  private final e Scq;
  private e.a Scr;
  private int cFx;
  private Context mContext;
  private int mDownloadType;
  private int mHZ;
  private boolean mIsExit;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(189529);
    this.SbT = new Object();
    this.mIsExit = false;
    this.SbV = null;
    this.SbW = null;
    this.SbX = 1;
    this.SbY = 0;
    this.SbZ = true;
    this.Sca = true;
    this.Scb = 0L;
    this.Scc = 0L;
    this.mHZ = 0;
    this.Scd = 0;
    this.Sce = 0;
    this.Scf = 0;
    this.Scg = false;
    this.RXs = false;
    this.Sch = false;
    this.Sci = "0";
    this.Scj = "";
    this.RVX = 0;
    this.mDownloadType = 0;
    this.Sck = "";
    this.Scl = 0;
    this.Scm = 0L;
    this.cFx = -1;
    this.Scn = new a();
    this.Sco = null;
    this.Scp = null;
    this.Scq = new e((byte)0);
    this.GUP = new c.1(this);
    this.Scr = new e.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
      {
        AppMethodBeat.i(189524);
        g.i("TPReportManager", "OnGlobalEventChangeListener eventId: ".concat(String.valueOf(paramAnonymousInt1)));
        switch (paramAnonymousInt1)
        {
        default: 
          AppMethodBeat.o(189524);
          return;
        }
        for (paramAnonymousInt1 = 2100;; paramAnonymousInt1 = 2101)
        {
          c.f(c.this).obtainMessage(paramAnonymousInt1, null).sendToTarget();
          AppMethodBeat.o(189524);
          return;
        }
      }
    };
    this.mContext = paramContext.getApplicationContext();
    AppMethodBeat.o(189529);
  }
  
  private static int T(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(189542);
    if (paramMap == null)
    {
      AppMethodBeat.o(189542);
      return 0;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      int i = ((Integer)paramMap).intValue();
      AppMethodBeat.o(189542);
      return i;
    }
    AppMethodBeat.o(189542);
    return 0;
  }
  
  private static boolean U(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(189545);
    if (paramMap == null)
    {
      AppMethodBeat.o(189545);
      return false;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      boolean bool = ((Boolean)paramMap).booleanValue();
      AppMethodBeat.o(189545);
      return bool;
    }
    AppMethodBeat.o(189545);
    return false;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(189533);
    g.i("TPReportManager", "onReportEvent: " + parama.toString());
    AppMethodBeat.o(189533);
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(189536);
    d.n localn = this.SbW.ScU;
    if (localn == null)
    {
      AppMethodBeat.o(189536);
      return;
    }
    if ((this.SbV != null) && ((this.SbV instanceof TPVodReportInfo)) && (paramBoolean))
    {
      localn.SeU = ((TPVodReportInfo)this.SbV).currentPlayState;
      localn.SeV = ((TPVodReportInfo)this.SbV).optimizedPlay;
      if (((TPVodReportInfo)this.SbV).hasSubtitles)
      {
        i = 1;
        localn.SeW = i;
        localn.SeZ = ((TPVodReportInfo)this.SbV).bizId;
        localn.Sfb = ((TPVodReportInfo)this.SbV).clipCount;
        localn.Sfc = ((TPVodReportInfo)this.SbV).videoStatus;
        localn.Sed = this.SbV.freeType;
      }
    }
    else
    {
      if (!this.Scq.ScF) {
        break label354;
      }
      i = 1;
      label171:
      localn.SeY = i;
      if (!this.Scq.ScE) {
        break label359;
      }
    }
    label354:
    label359:
    for (int i = j;; i = 0)
    {
      localn.SeX = i;
      localn.Sfa = 0;
      parama.put("freetype", localn.Sed);
      parama.put("currentplay", localn.SeU);
      parama.put("optimizedplay", localn.SeV);
      parama.put("subtitles", localn.SeW);
      parama.put("selsubtitles", localn.SeX);
      parama.put("multitrack", localn.SeY);
      parama.put("bizid", localn.SeZ);
      parama.put("hevclv", localn.Sfa);
      parama.put("clip", localn.Sfb);
      parama.put("status", localn.Sfc);
      AppMethodBeat.o(189536);
      return;
      i = 0;
      break;
      i = 0;
      break label171;
    }
  }
  
  private static long b(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    AppMethodBeat.i(189543);
    if (paramMap == null)
    {
      AppMethodBeat.o(189543);
      return paramLong;
    }
    paramMap = paramMap.get(paramString);
    if (paramMap != null)
    {
      paramLong = ((Long)paramMap).longValue();
      AppMethodBeat.o(189543);
      return paramLong;
    }
    AppMethodBeat.o(189543);
    return paramLong;
  }
  
  private void b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(189537);
    d.g localg = this.SbW.ScT;
    if (localg == null)
    {
      AppMethodBeat.o(189537);
      return;
    }
    int i;
    if ((this.SbV != null) && ((this.SbV instanceof TPLiveReportInfo)) && (paramBoolean))
    {
      localg.Sea = ((TPLiveReportInfo)this.SbV).adPlayLength;
      localg.Seg = ((TPLiveReportInfo)this.SbV).programId;
      localg.Seh = ((TPLiveReportInfo)this.SbV).streamId;
      localg.Sei = ((TPLiveReportInfo)this.SbV).contentId;
      localg.Sej = ((TPLiveReportInfo)this.SbV).playTime;
      localg.Sem = ((TPLiveReportInfo)this.SbV).liveType;
      if (((TPLiveReportInfo)this.SbV).isUserPay)
      {
        i = 1;
        localg.Sek = i;
        if (!((TPLiveReportInfo)this.SbV).isLookBack) {
          break label1291;
        }
        i = 1;
        label174:
        localg.Seo = i;
        localg.Sen = ((TPLiveReportInfo)this.SbV).cdnServer;
        localg.Sed = this.SbV.freeType;
        localg.SdY = this.SbV.uin;
        localg.SdX = this.SbV.uip;
        if (!this.SbV.enableP2p) {
          break label1296;
        }
        i = 1;
        label243:
        localg.Sef = i;
      }
    }
    else
    {
      if ((this.SbV != null) && ((this.SbV instanceof TPLiveReportInfo))) {
        localg.Sep = ((TPLiveReportInfo)this.SbV).liveDelay;
      }
      if (!this.Sch) {
        break label1301;
      }
      i = 1;
      label290:
      localg.See = i;
      localg.downloadUrl = this.Scq.pkK;
      if (TextUtils.isEmpty(localg.downloadUrl)) {
        localg.downloadUrl = this.SbW.ScM.SdT;
      }
      localg.Seb = this.Scq.cdnIp;
      localg.SdW = System.currentTimeMillis();
      if (this.Scq.Sct > 0L)
      {
        localObject = this.Scq;
        ((e)localObject).Scu = ((int)(((e)localObject).Scu + (System.currentTimeMillis() - this.Scq.Sct)));
        if ((!this.SbZ) && (!this.RXs) && (!this.Scq.RWM)) {
          break label1306;
        }
        this.Scq.Sct = 0L;
      }
      label428:
      localg.SdZ = this.Scq.Scu;
      this.Scq.Scu = 0;
      localg.SdG = "2.9.0.1112";
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
      localg.Sec = i;
      localg.Sdy = bAX();
      localg.Set = this.Scq.JON;
      this.Scq.JON = 0;
      localg.Seu = this.Scd;
      if (this.Scq.ScD > 0)
      {
        localg.Sev = (this.Scq.ScC / this.Scq.ScD);
        this.Scq.ScC = 0;
        this.Scq.ScD = 0;
      }
      localg.Seq = 0;
      localg.Ser = "";
      localg.Sew = 0;
      localg.Ses = 0;
      localg.SeB = 0;
      localg.Sel = this.Scq.ScG;
      localg.Sex = (this.Scq.Scw - this.Scq.Scv);
      localg.Sey = this.Scq.Scy;
      localg.Sez = this.Scq.Scx;
      this.Scq.Scx = 0;
      this.Scq.Scy = 0;
      localg.SeA = 0;
      localg.SeC = this.Sci;
      localg.ScH = this.Scq.ScH;
      localg.ScI = this.Scq.ScI;
      parama.put("ftime", localg.SdW);
      parama.put("sip", localg.SdX);
      parama.put("iqq", localg.SdY);
      parama.put("prdlength", localg.SdZ);
      parama.put("playad", localg.Sea);
      parama.put("fplayerver", localg.SdG);
      parama.put("dsip", localg.Seb);
      parama.put("devtype", localg.Sec);
      parama.put("nettype", localg.Sdy);
      parama.put("freetype", localg.Sed);
      parama.put("use_p2p", localg.See);
      parama.put("p2p_play", localg.Sef);
      parama.put("livepid", localg.Seg);
      parama.put("sid", localg.Seh);
      parama.put("contentid", localg.Sei);
      parama.put("playtime", localg.Sej);
      parama.put("isuserpay", localg.Sek);
      parama.put("switch", localg.Sel);
      parama.put("live_type", localg.Sem);
      parama.put("xserverip", localg.Sen);
      parama.put("durl", localg.downloadUrl);
      parama.put("lookback", localg.Seo);
      parama.put("live_delay", localg.Sep);
      parama.put("live_tag", localg.Seq);
      parama.put("extraInfo", localg.Ser);
      parama.put("cnntime", localg.Ses);
      parama.put("maxspeed", localg.Set);
      parama.put("testspeed", localg.Seu);
      parama.put("downspeed", localg.Sev);
      parama.put("recnncount", localg.Sew);
      parama.put("loadingtime", localg.Sex);
      parama.put("blocktime", localg.Sey);
      parama.put("blockcount", localg.Sez);
      parama.put("errorcode", localg.SeA);
      parama.put("geturltime", localg.SeB);
      parama.put("fullecode", localg.SeC);
      parama.put("get_stream_data_duration", localg.SeD);
      parama.put("get_sync_frame_duration", localg.SeE);
      parama.put("spanId", localg.ScH);
      parama.put("tuid", localg.ScI);
      AppMethodBeat.o(189537);
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
      this.Scq.Sct = System.currentTimeMillis();
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
  private int bAX()
  {
    j = 0;
    AppMethodBeat.i(189546);
    if (this.mContext == null)
    {
      AppMethodBeat.o(189546);
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
      AppMethodBeat.o(189546);
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
  
  private void cp(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189530);
    g.i("TPReportManager", "onSeekComplete");
    this.Scg = false;
    if (paramMap == null)
    {
      AppMethodBeat.o(189530);
      return;
    }
    if (this.Scp == null)
    {
      AppMethodBeat.o(189530);
      return;
    }
    this.Scp.SeP = b(paramMap, "etime", System.currentTimeMillis());
    this.Scp.SeN = (b(paramMap, "petime", 0L) / 1000L);
    this.Scp.Sdd = this.Sci;
    long l = this.Scp.SeP - this.Scp.SeO;
    if (l > 1200L)
    {
      this.Scf += 1;
      this.Sce = ((int)(l + this.Sce));
    }
    paramMap = this.SbW.ScR;
    paramMap.SeQ += 1;
    paramMap.SeS = this.Sce;
    paramMap.SeR = this.Scf;
    if (paramMap.SeT.size() < 20)
    {
      paramMap.SeT.add(this.Scp);
      paramMap = new h();
      d.l locall = this.Scp;
      paramMap.put("format", locall.ScY);
      paramMap.put("pstime", locall.SeM);
      paramMap.put("petime", locall.SeN);
      paramMap.put("lstime", locall.SeO);
      paramMap.put("letime", locall.SeP);
      paramMap.put("code", locall.Sdd);
      this.Scn.a(40, paramMap);
    }
    this.Scp = null;
    AppMethodBeat.o(189530);
  }
  
  private void cq(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189531);
    g.i("TPReportManager", "onBufferingEnd");
    this.RXs = false;
    if (!this.Scq.RWM) {
      this.Scq.Sct = System.currentTimeMillis();
    }
    if (paramMap == null)
    {
      AppMethodBeat.o(189531);
      return;
    }
    long l = b(paramMap, "etime", System.currentTimeMillis());
    int i = (int)(l - this.Scq.Scz);
    if (i <= 1200)
    {
      AppMethodBeat.o(189531);
      return;
    }
    if (this.Scg)
    {
      AppMethodBeat.o(189531);
      return;
    }
    Object localObject = this.Scq;
    ((e)localObject).Scx += 1;
    this.Scq.ScA = l;
    localObject = this.Scq;
    ((e)localObject).Scy += (int)(this.Scq.ScA - this.Scq.Scz);
    if (this.Sco == null)
    {
      AppMethodBeat.o(189531);
      return;
    }
    this.Sco.Sdb = b(paramMap, "etime", 0L);
    this.Sco.Sdd = this.Sci;
    paramMap = this.SbW.ScQ;
    paramMap.Sdf += 1;
    paramMap.Sdg += i;
    if (paramMap.Sdh.size() < 20)
    {
      paramMap.Sdh.add(this.Sco);
      paramMap = new h();
      localObject = this.Sco;
      paramMap.put("scene", ((d.a)localObject).ScV);
      paramMap.put("levent", ((d.a)localObject).ScW);
      paramMap.put("reason", ((d.a)localObject).ScX);
      paramMap.put("format", ((d.a)localObject).ScY);
      paramMap.put("ptime", ((d.a)localObject).ScZ);
      paramMap.put("stime", ((d.a)localObject).Sda);
      paramMap.put("etime", ((d.a)localObject).Sdb);
      paramMap.put("url", ((d.a)localObject).Sdc);
      paramMap.put("code", ((d.a)localObject).Sdd);
      this.Scn.a(35, paramMap);
    }
    this.Sco = null;
    AppMethodBeat.o(189531);
  }
  
  private void cr(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189532);
    g.i("TPReportManager", "onPlayEnd");
    if ((paramMap == null) || (this.SbZ))
    {
      AppMethodBeat.o(189532);
      return;
    }
    if (this.RXs) {
      cq(new f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
    }
    if (this.Scg) {
      cp(new f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
    }
    if (this.Scq.Sct > 0L)
    {
      localObject = this.Scq;
      ((e)localObject).Scu += (int)(System.currentTimeMillis() - this.Scq.Sct);
      this.Scq.Sct = 0L;
    }
    this.Scg = false;
    Object localObject = new h();
    this.SbW.ScQ.c((a)localObject);
    this.SbW.ScQ.reset();
    this.SbW.ScR.c((a)localObject);
    this.SbW.ScR.reset();
    d.i locali = this.SbW.ScS;
    locali.Sdb = b(paramMap, "etime", System.currentTimeMillis());
    locali.ScX = T(paramMap, "reason");
    locali.Sdd = this.Sci;
    if (this.Scb > 0L)
    {
      this.Scc += locali.Sdb - this.Scb;
      this.Scb = 0L;
    }
    locali.SeH = ((float)this.Scc / 1000.0F);
    locali.c((a)localObject);
    this.Scn.a(50, (a)localObject);
    this.SbZ = true;
    this.Sci = "0";
    this.Scb = 0L;
    this.Scc = 0L;
    this.Scf = 0;
    this.Sce = 0;
    paramMap = this.Scq;
    paramMap.Sct = 0L;
    paramMap.Scu = 0;
    paramMap.Scv = 0L;
    paramMap.Scw = 0L;
    paramMap.Scx = 0;
    paramMap.Scy = 0;
    paramMap.Scz = 0L;
    paramMap.ScA = 0L;
    paramMap.ScB = 0;
    paramMap.JON = 0;
    paramMap.ScC = 0;
    paramMap.ScD = 0;
    paramMap.ScE = false;
    paramMap.ScF = false;
    paramMap.RWM = false;
    paramMap.ScG = "";
    paramMap.pkK = "";
    paramMap.cdnIp = "";
    paramMap.cdnUip = "";
    paramMap.ScH = "";
    paramMap.ScI = "";
    hom();
    AppMethodBeat.o(189532);
  }
  
  private static String f(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189544);
    if (paramMap == null)
    {
      AppMethodBeat.o(189544);
      return paramString2;
    }
    paramMap = paramMap.get(paramString1);
    if (paramMap != null)
    {
      paramMap = (String)paramMap;
      AppMethodBeat.o(189544);
      return paramMap;
    }
    AppMethodBeat.o(189544);
    return paramString2;
  }
  
  private void hol()
  {
    AppMethodBeat.i(189534);
    g.i("TPReportManager", "onLivePeriodReport");
    h localh = new h();
    this.Scn.a(263, localh);
    AppMethodBeat.o(189534);
  }
  
  private void hom()
  {
    AppMethodBeat.i(189535);
    g.i("TPReportManager", "removeCacheEvent: mFlowId: " + this.Scj);
    if ((SbU != null) && (!TextUtils.isEmpty(this.Scj))) {
      SbU.bqG(this.Scj);
    }
    AppMethodBeat.o(189535);
  }
  
  public final void aSs()
  {
    AppMethodBeat.i(189539);
    this.SbR = new HandlerThread("TP-ReportThread");
    this.SbR.start();
    this.SbS = new b(this.SbR.getLooper());
    this.SbW = new d();
    TelephonyManager localTelephonyManager;
    if (this.mContext != null)
    {
      localTelephonyManager = (TelephonyManager)this.mContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        break label156;
      }
      g.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
    }
    for (;;)
    {
      e.a(this.Scr);
      try
      {
        if (SbU == null) {
          SbU = new com.tencent.thumbplayer.utils.c(this.mContext, "TPReportCache");
        }
        if (!SbQ) {
          this.SbS.obtainMessage(4000).sendToTarget();
        }
        SbQ = true;
        return;
      }
      finally
      {
        label156:
        Object localObject2;
        AppMethodBeat.o(189539);
      }
      localObject2 = this.GUP;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "signalStrengthRegister", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "signalStrengthRegister", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(189541);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(189541);
      return;
    case 100: 
      paramInt1 = 999;
    }
    for (;;)
    {
      this.SbS.obtainMessage(paramInt1, paramObject).sendToTarget();
      AppMethodBeat.o(189541);
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
  
  public final void onDetach()
  {
    AppMethodBeat.i(189540);
    g.i("TPReportManager", "release: ");
    if (this.mContext != null)
    {
      ??? = (TelephonyManager)this.mContext.getSystemService("phone");
      if (??? == null) {
        g.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      }
    }
    else
    {
      e.b(this.Scr);
      if (this.SbR != null)
      {
        if (Build.VERSION.SDK_INT < 18) {
          break label192;
        }
        this.SbR.quitSafely();
      }
    }
    for (;;)
    {
      this.SbR = null;
      g.i("TPReportManager", "release: end!");
      AppMethodBeat.o(189540);
      return;
      Object localObject2 = this.GUP;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(???, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "signalStrengthUnRegister", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)???).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(???, "com/tencent/thumbplayer/tplayer/plugins/report/TPReportManager", "signalStrengthUnRegister", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      break;
      label192:
      synchronized (this.SbT)
      {
        this.mIsExit = false;
        this.SbS.sendEmptyMessage(100);
        for (;;)
        {
          boolean bool = this.mIsExit;
          if (!bool) {
            try
            {
              this.SbT.wait(5000L, 0);
            }
            catch (InterruptedException localInterruptedException)
            {
              g.e("TPReportManager", localInterruptedException);
            }
          }
        }
      }
      this.SbR.quit();
    }
  }
  
  public void reportEvent(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189538);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(189538);
      return;
    case 1000: 
      paramInt = 2000;
    }
    for (;;)
    {
      this.SbS.obtainMessage(paramInt, localObject).sendToTarget();
      AppMethodBeat.o(189538);
      return;
      paramInt = 2001;
      continue;
      paramInt = 2003;
    }
  }
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    this.SbV = paramTPDefaultReportInfo;
  }
  
  final class a
    implements c.c
  {
    a() {}
    
    public final void a(int paramInt, a parama)
    {
      AppMethodBeat.i(189525);
      boolean bool = true;
      if (paramInt > 30) {
        bool = false;
      }
      c.a(c.this, parama, paramInt, bool);
      c.b(parama);
      AppMethodBeat.o(189525);
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
      AppMethodBeat.i(189526);
      Map localMap = null;
      if ((paramMessage.obj instanceof Map)) {
        localMap = (Map)paramMessage.obj;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(189526);
        return;
        c.a(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.b(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.c(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.d(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.e(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.f(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.g(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.h(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.i(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.j(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.k(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.l(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.m(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.n(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.o(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.p(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.q(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.r(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.s(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.t(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.u(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.v(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.w(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.x(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.y(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.z(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.A(c.this, localMap);
        AppMethodBeat.o(189526);
        return;
        c.a(c.this);
        AppMethodBeat.o(189526);
        return;
        c.b(c.this);
        AppMethodBeat.o(189526);
        return;
        if ((paramMessage.obj instanceof String))
        {
          c.a(c.this, (String)paramMessage.obj);
          AppMethodBeat.o(189526);
          return;
          c.c(c.this);
          AppMethodBeat.o(189526);
          return;
          c.d(c.this);
          AppMethodBeat.o(189526);
          return;
          c.hon();
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
      AppMethodBeat.i(189527);
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
        AppMethodBeat.o(189527);
        return;
      case 30: 
        paramInt = 205;
      }
      for (;;)
      {
        c.a(c.this, parama, paramInt, bool1);
        c.b(c.this, parama, bool1);
        if (paramInt != 205) {
          parama.put("loadingtime", 0);
        }
        g.i("TPReportManager", "liveExParam.prePlayLengthInt: " + c.g(c.this).ScT.SdZ);
        c.b(parama);
        AppMethodBeat.o(189527);
        return;
        c.f(c.this).removeMessages(3000);
        paramInt = 263;
        continue;
        c.f(c.this).removeMessages(3000);
        continue;
        c.f(c.this).removeMessages(3000);
        c.f(c.this).sendEmptyMessageDelayed(3000, 60000L);
      }
    }
  }
  
  final class e
  {
    int JON = 0;
    boolean RWM = false;
    long ScA = 0L;
    int ScB = 0;
    int ScC = 0;
    int ScD = 0;
    boolean ScE = false;
    boolean ScF = false;
    String ScG = "";
    String ScH = "";
    String ScI = "";
    long Sct = 0L;
    int Scu = 0;
    long Scv = 0L;
    long Scw = 0L;
    int Scx = 0;
    int Scy = 0;
    long Scz = 0L;
    String cdnIp = "";
    String cdnUip = "";
    String pkK = "";
    
    private e() {}
  }
  
  final class f
    implements c.c
  {
    f() {}
    
    public final void a(int paramInt, a parama)
    {
      AppMethodBeat.i(189528);
      boolean bool = true;
      if (paramInt > 30) {
        bool = false;
      }
      c.a(c.this, parama, paramInt, bool);
      c.a(c.this, parama, bool);
      c.b(parama);
      AppMethodBeat.o(189528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.a.c
 * JD-Core Version:    0.7.0.1
 */