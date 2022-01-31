package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.i.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class j
  implements a, g
{
  public int bWw;
  public String bWy;
  public byte[] cKp;
  public String cqq;
  public int cxH;
  public String desc;
  public byte[] gcZ;
  public byte[] gdd;
  private Intent intent;
  protected Context mContext;
  private Notification oUV;
  public int rJd;
  public int size;
  public int uin;
  public String[] ykH;
  public int ykg;
  public String[] ylA;
  public String ylB;
  public com.tencent.mm.c.i ylC;
  public i.a ylD;
  public boolean ylE;
  public boolean ylF;
  public boolean ylG;
  public String ylH;
  public boolean ylI;
  boolean ylJ;
  long ylK;
  f ylL;
  private long ylM;
  private b.a ylN;
  com.tencent.mm.sandbox.monitor.c yly;
  ArrayList<g> ylz;
  
  private j()
  {
    AppMethodBeat.i(28957);
    this.yly = null;
    this.ylz = new ArrayList(1);
    this.cxH = d.whH;
    this.ylE = false;
    this.ylF = false;
    this.ylG = false;
    this.ylI = false;
    this.ylJ = false;
    this.intent = null;
    this.oUV = null;
    this.mContext = null;
    this.ylL = new f(this);
    this.ylM = -1L;
    this.ylN = new b.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, bvk paramAnonymousbvk)
      {
        AppMethodBeat.i(28953);
        j.this.ylJ = false;
        j.this.ylL.stop();
        j.this.ylK = System.currentTimeMillis();
        if (j.this.yly == null)
        {
          j.this.aE(2, true);
          AppMethodBeat.o(28953);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          ab.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (j.this.rJd != 2) {
            j.a(j.this, 100, 100);
          }
          if (j.this.ylE)
          {
            i.as(j.this.mContext, 0);
            paramAnonymousbvk = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.h.Mp());
            j.this.ylB = paramAnonymousbvk.getString(ah.getPackageName(), "");
            ab.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { j.this.ylB, j.this.yly.dru() });
            if (bo.isNullOrNil(j.this.ylB)) {
              break label452;
            }
          }
          for (;;)
          {
            try
            {
              com.tencent.mm.c.c.c(new File(j.this.yly.dru()), j.this.ylB);
              ab.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4006), j.this.ylB });
              if (j.this.rJd != 1) {
                break label491;
              }
              i.at(j.this.mContext, 8);
              j.a(j.this);
              j.this.abi(j.this.yly.dru());
              if (j.this.ylI)
              {
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 58L, 1L, false);
                ab.d("MicroMsg.UpdaterManager", "boots download success.");
              }
              i.drQ();
              AppMethodBeat.o(28953);
              return;
              i.as(j.this.mContext, 9);
            }
            catch (Exception paramAnonymousbvk)
            {
              ab.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymousbvk.getMessage());
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4007), paramAnonymousbvk.getMessage() });
              continue;
            }
            label452:
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4008) });
            continue;
            label491:
            if (j.this.rJd == 0)
            {
              j.this.abi(j.this.yly.dru());
            }
            else if (j.this.rJd == 2)
            {
              i.at(j.this.mContext, 1);
              j.a(j.this);
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          ab.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.dM();
          AppUpdaterUI.dry();
          i.drP();
          AppMethodBeat.o(28953);
          return;
        }
        if (((j.this.yly instanceof c)) && (j.this.ykg != 4))
        {
          ab.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (j.this.ylE)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              i.as(j.this.mContext, paramAnonymousInt1);
            }
            j.this.ylE = false;
            if (j.this.rJd == 1) {
              if (j.this.ylI)
              {
                ab.d("MicroMsg.UpdaterManager", "boots download failed. %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
                switch (paramAnonymousInt1)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          j.this.a(j.this.yly);
          AppMethodBeat.o(28953);
          return;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 55L, 1L, false);
          continue;
          j.b(j.this);
          continue;
          if (j.this.rJd == 0)
          {
            j.this.aE(1, true);
          }
          else if (j.this.rJd == 2)
          {
            j.c(j.this);
            continue;
            paramAnonymousbvk = j.this;
            paramAnonymousInt1 = j.this.size;
            String str = j.this.cqq;
            paramAnonymousInt2 = j.this.ykg;
            int i = j.this.uin;
            byte[] arrayOfByte1 = j.this.gcZ;
            byte[] arrayOfByte2 = j.this.cKp;
            String[] arrayOfString = j.this.ylA;
            if (j.this.rJd == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousbvk.yly = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              j.d(j.this);
              break;
            }
            ab.e("MicroMsg.UpdaterManager", "update failed");
            i.as(j.this.mContext, 10);
            if (j.this.rJd == 1) {
              j.e(j.this);
            } else if (j.this.rJd == 0) {
              j.this.aE(1, true);
            }
          }
        }
      }
      
      public final void dW(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28952);
        ab.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (j.this.rJd != 2) {
          j.a(j.this, paramAnonymousInt2, paramAnonymousInt1);
        }
        j.this.dW(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(28952);
      }
      
      public final void nJ(long paramAnonymousLong)
      {
        AppMethodBeat.i(28954);
        f localf = j.this.ylL;
        localf.caS.post(new f.2(localf, paramAnonymousLong));
        AppMethodBeat.o(28954);
      }
      
      public final void nK(long paramAnonymousLong)
      {
        AppMethodBeat.i(28955);
        f localf = j.this.ylL;
        localf.caS.post(new f.3(localf, paramAnonymousLong));
        AppMethodBeat.o(28955);
      }
    };
    this.mContext = ah.getContext();
    AppMethodBeat.o(28957);
  }
  
  private void drT()
  {
    AppMethodBeat.i(28966);
    MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.aox() - 86400L).commit();
    aE(2, true);
    drA();
    AppMethodBeat.o(28966);
  }
  
  private void drU()
  {
    AppMethodBeat.i(28967);
    MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.aox() - 86400L).commit();
    aE(2, true);
    drB();
    AppMethodBeat.o(28967);
  }
  
  private void drV()
  {
    AppMethodBeat.i(28968);
    if ((this.rJd == 2) && (!at.isWifi(this.mContext)))
    {
      i.drO();
      ab.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      AppMethodBeat.o(28968);
      return;
    }
    if ((this.rJd == 2) && (f.aoL(this.cqq)))
    {
      ab.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.ylL.stop();
      AppMethodBeat.o(28968);
      return;
    }
    this.ylL.es(this.cqq, this.size);
    if (this.yly != null)
    {
      aE(1, false);
      this.ylJ = true;
      this.yly.a(this.ylN);
      cqU();
      if (this.rJd == 2) {
        i.drO();
      }
    }
    AppMethodBeat.o(28968);
  }
  
  private void drW()
  {
    AppMethodBeat.i(28969);
    cancel();
    ab.i("MicroMsg.UpdaterManager", "downloadFullPack");
    i.as(this.mContext, 7);
    if ((this.ykH != null) && (this.ykH.length > 0))
    {
      i = this.size;
      str = this.cqq;
      j = this.ykg;
      localObject = this.ykH;
      if (this.rJd == 2) {}
      for (bool = true;; bool = false)
      {
        this.yly = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 76L, 1L, true);
        drV();
        AppMethodBeat.o(28969);
        return;
      }
    }
    int i = this.size;
    String str = this.cqq;
    int j = this.ykg;
    int k = this.uin;
    Object localObject = this.gcZ;
    byte[] arrayOfByte = this.cKp;
    String[] arrayOfString = this.ylA;
    if (this.rJd == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.yly = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void pF(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(28962);
    ab.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ab.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.rJd), Boolean.valueOf(this.ylJ) });
    if (this.intent == null)
    {
      ab.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      AppMethodBeat.o(28962);
      return;
    }
    if (this.ylJ)
    {
      ab.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      AppMethodBeat.o(28962);
      return;
    }
    if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
    {
      ab.e("MicroMsg.UpdaterManager", "no sdcard.");
      drT();
      AppMethodBeat.o(28962);
      return;
    }
    if ((this.rJd == 2) && (!paramBoolean)) {
      i.at(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.Uc(this.cqq);
    ab.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      ab.i("MicroMsg.UpdaterManager", "update package already exist.");
      aE(1, true);
      abi(str1);
      if ((this.rJd == 2) && (!i.aoM(this.cqq))) {
        i.a(this.cqq, this.ylB, this.desc, this.size, this.rJd, this.ykg, this.ylH);
      }
      AppMethodBeat.o(28962);
      return;
    }
    if (this.ylG)
    {
      if (this.yly != null) {
        this.yly.deleteTempFile();
      }
      i.as(this.mContext, 11);
    }
    if ((!this.ylG) && (this.ylE) && (this.ylC != null) && (this.ylD != null))
    {
      ab.i("MicroMsg.UpdaterManager", "Incresment Update");
      i.as(this.mContext, 5);
      if (!com.tencent.mm.compatible.util.f.gc(this.size + this.ylD.size))
      {
        drU();
        AppMethodBeat.o(28962);
        return;
      }
      cancel();
      int i = this.ylD.size;
      str1 = this.cqq;
      int j = this.ykg;
      String str2 = this.ylC.bWJ + this.ylD.url;
      String str3 = this.ylD.bWN;
      String str4 = this.ylD.bWM;
      if (this.rJd == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.yly = new c(i, str1, j, str2, str3, str4, paramBoolean);
        drV();
        AppMethodBeat.o(28962);
        return;
      }
    }
    if (!com.tencent.mm.compatible.util.f.gc(this.size))
    {
      ab.e("MicroMsg.UpdaterManager", "SDCard is full");
      drU();
      AppMethodBeat.o(28962);
      return;
    }
    drW();
    AppMethodBeat.o(28962);
  }
  
  private void reset()
  {
    AppMethodBeat.i(28965);
    cancel();
    this.bWw = 0;
    this.bWy = null;
    this.ylA = null;
    this.cxH = d.whH;
    this.ykg = 0;
    this.gcZ = null;
    this.cKp = null;
    this.gdd = null;
    this.uin = 0;
    this.cqq = null;
    this.size = 0;
    this.desc = null;
    this.ykH = null;
    this.ylC = null;
    this.ylD = null;
    this.ylE = false;
    this.ylF = false;
    this.rJd = 0;
    this.ylG = false;
    this.intent = null;
    this.ylJ = false;
    this.oUV = null;
    this.ylM = 0L;
    AppMethodBeat.o(28965);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(28973);
    Iterator localIterator = this.ylz.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(28973);
  }
  
  public final void aE(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28963);
    this.ylF = paramBoolean;
    new ak().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28951);
        ((NotificationManager)j.this.mContext.getSystemService("notification")).cancel(99);
        ab.d("MicroMsg.UpdaterManager", "finishType == " + paramInt);
        if ((paramInt == 2) && (j.this.ykg == 1))
        {
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
          j.this.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        }
        AppMethodBeat.o(28951);
      }
    }, 300L);
    AppMethodBeat.o(28963);
  }
  
  public final boolean aI(Intent paramIntent)
  {
    AppMethodBeat.i(28959);
    boolean bool = aJ(paramIntent);
    ab.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      pF(false);
    }
    AppMethodBeat.o(28959);
    return bool;
  }
  
  public final boolean aJ(Intent paramIntent)
  {
    AppMethodBeat.i(28960);
    ab.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
    if (paramIntent == null)
    {
      ab.i("MicroMsg.UpdaterManager", "intent == null");
      AppMethodBeat.o(28960);
      return false;
    }
    int j = paramIntent.getIntExtra("intent_update_type", 3);
    int i = paramIntent.getIntExtra("intent_extra_download_mode", 1);
    String str = paramIntent.getStringExtra("intent_extra_md5");
    if ((this.ylJ) && (!str.equalsIgnoreCase(this.cqq)) && (this.rJd == 2)) {
      cancel();
    }
    Object localObject;
    while (!this.ylJ)
    {
      i.drQ();
      reset();
      this.intent = paramIntent;
      this.bWw = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.bWy = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.ylA = paramIntent.getStringArrayExtra("intent_short_ips");
      this.cxH = paramIntent.getIntExtra("intent_client_version", d.whH);
      d.whH = this.cxH;
      this.ykg = j;
      this.gcZ = paramIntent.getByteArrayExtra("intent_extra_session");
      this.cKp = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.gdd = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.cqq = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.ykH = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.rJd = i;
      this.ylG = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject != null)
      {
        ab.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.ylC = com.tencent.mm.c.i.dq((String)localObject);
      }
      localObject = paramIntent.getStringExtra("intent_extra_extinfo");
      ab.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject });
      if (!bo.isNullOrNil((String)localObject))
      {
        this.ylH = ((String)br.F((String)localObject, "extinfo").get(".extinfo.notautodownloadrange"));
        ab.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.ylH });
      }
      ab.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.ylJ) });
      if ((j != 999) || (this.ykH == null) || (this.ykH.length <= 0)) {
        break;
      }
      if (i == 2) {
        ab.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
      }
      AppMethodBeat.o(28960);
      return true;
    }
    ab.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
    AppMethodBeat.o(28960);
    return true;
    if (this.ykH != null)
    {
      localObject = this.ykH;
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        ab.i("MicroMsg.UpdaterManager", "download url : ".concat(String.valueOf(localObject[i])));
        i += 1;
      }
    }
    ab.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[] { str, Integer.valueOf(this.size) });
    if ((str == null) || (this.size == 0))
    {
      AppMethodBeat.o(28960);
      return false;
    }
    if (j == 2)
    {
      boolean bool = com.tencent.mm.modelcontrol.b.sM(this.ylH);
      ab.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 78L, 1L, true);
        AppMethodBeat.o(28960);
        return false;
      }
    }
    if (this.ylC != null)
    {
      ab.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject = com.tencent.mm.pluginsdk.f.i.fU(this.mContext);
      this.ylD = this.ylC.dp((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder("increase apkMD5 = ").append((String)localObject).append(" : ");
      if (this.ylD == null)
      {
        localObject = "not match";
        ab.i("MicroMsg.UpdaterManager", (String)localObject);
      }
    }
    else
    {
      ab.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.ylG) });
      this.ylI = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.ylD == null) || (com.tencent.mm.sandbox.monitor.c.aoJ(str))) && (!this.ylI)) {
        break label837;
      }
      ab.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.ylE = true;
    }
    for (;;)
    {
      paramIntent = i.dlS();
      if ((!bo.isNullOrNil(paramIntent)) && (!paramIntent.equals(str))) {
        i.drR();
      }
      AppMethodBeat.o(28960);
      return true;
      localObject = "match";
      break;
      label837:
      ab.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(28972);
    Iterator localIterator = this.ylz.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).abi(paramString);
    }
    AppMethodBeat.o(28972);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(28964);
    if (this.yly != null)
    {
      this.ylJ = false;
      this.yly.cancel();
      this.yly = null;
      this.ylK = System.currentTimeMillis();
      this.ylL.stop();
    }
    AppMethodBeat.o(28964);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(28971);
    Iterator localIterator = this.ylz.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cqU();
    }
    AppMethodBeat.o(28971);
  }
  
  public final void dW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28970);
    Iterator localIterator = this.ylz.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).dW(paramInt1, paramInt2);
    }
    AppMethodBeat.o(28970);
  }
  
  public final void drA()
  {
    AppMethodBeat.i(28974);
    Iterator localIterator = this.ylz.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).drA();
    }
    AppMethodBeat.o(28974);
  }
  
  public final void drB()
  {
    AppMethodBeat.i(28975);
    Iterator localIterator = this.ylz.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).drB();
    }
    AppMethodBeat.o(28975);
  }
  
  public final void drS()
  {
    AppMethodBeat.i(156904);
    pF(false);
    AppMethodBeat.o(156904);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(28976);
    if ((this.ylJ) || (System.currentTimeMillis() - this.ylK <= UpdaterService.ylT))
    {
      ab.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.ylJ), Long.valueOf(this.ylK), Long.valueOf(System.currentTimeMillis() - this.ylK) });
      AppMethodBeat.o(28976);
      return true;
    }
    ab.i("MicroMsg.UpdaterManager", "not busy");
    AppMethodBeat.o(28976);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(28977);
    ab.i("MicroMsg.UpdaterManager", "onDestroy");
    if (!this.ylJ)
    {
      reset();
      aE(1, true);
    }
    AppMethodBeat.o(28977);
  }
  
  public final void pD(boolean paramBoolean)
  {
    AppMethodBeat.i(28958);
    ab.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    f localf = this.ylL;
    if (localf.muY != paramBoolean)
    {
      localf.pE(true);
      localf.muY = paramBoolean;
    }
    if ((this.rJd != 2) || (this.ylJ))
    {
      ab.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.rJd), Boolean.valueOf(this.ylJ) });
      AppMethodBeat.o(28958);
      return;
    }
    if (paramBoolean)
    {
      if (aJ(this.intent))
      {
        pF(true);
        AppMethodBeat.o(28958);
      }
    }
    else if (this.ylJ) {
      cancel();
    }
    AppMethodBeat.o(28958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.j
 * JD-Core Version:    0.7.0.1
 */