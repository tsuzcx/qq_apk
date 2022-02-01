package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class k
  implements a, h
{
  public int EMv;
  public int HWJ;
  public String[] HXl;
  com.tencent.mm.sandbox.monitor.c HYb;
  ArrayList<h> HYc;
  public String[] HYd;
  public String HYe;
  public com.tencent.mm.d.i HYf;
  public i.a HYg;
  public boolean HYh;
  public boolean HYi;
  public boolean HYj;
  public String HYk;
  public boolean HYl;
  boolean HYm;
  long HYn;
  g HYo;
  private long HYp;
  private b.a HYq;
  public int cSe;
  public String cSg;
  public byte[] dLl;
  public String desc;
  public byte[] iEm;
  public byte[] iEq;
  private Intent intent;
  private Notification jSl;
  protected Context mContext;
  public String md5;
  public int size;
  public int uin;
  public int zTO;
  
  private k()
  {
    AppMethodBeat.i(32771);
    this.HYb = null;
    this.HYc = new ArrayList(1);
    this.EMv = d.Fnj;
    this.HYh = false;
    this.HYi = false;
    this.HYj = false;
    this.HYl = false;
    this.HYm = false;
    this.intent = null;
    this.jSl = null;
    this.mContext = null;
    this.HYo = new g(this);
    this.HYp = -1L;
    this.HYq = new b.a()
    {
      public final void CO(long paramAnonymousLong)
      {
        AppMethodBeat.i(32768);
        g localg = k.this.HYo;
        localg.cXg.post(new g.2(localg, paramAnonymousLong));
        AppMethodBeat.o(32768);
      }
      
      public final void CP(long paramAnonymousLong)
      {
        AppMethodBeat.i(32769);
        g localg = k.this.HYo;
        localg.cXg.post(new g.3(localg, paramAnonymousLong));
        AppMethodBeat.o(32769);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, cvp paramAnonymouscvp)
      {
        AppMethodBeat.i(32767);
        k.this.HYm = false;
        k.this.HYo.stop();
        k.this.HYn = System.currentTimeMillis();
        if (k.this.HYb == null)
        {
          k.this.bc(2, true);
          AppMethodBeat.o(32767);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          ad.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (k.this.zTO != 2) {
            k.a(k.this, 100, 100);
          }
          if (k.this.HYh)
          {
            j.aB(k.this.mContext, 0);
            paramAnonymouscvp = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.abm());
            k.this.HYe = paramAnonymouscvp.getString(aj.getPackageName(), "");
            ad.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { k.this.HYe, k.this.HYb.fit() });
            if ((bt.isNullOrNil(k.this.HYe)) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
              break label462;
            }
          }
          for (;;)
          {
            try
            {
              com.tencent.mm.d.c.g(new File(com.tencent.mm.vfs.i.k(k.this.HYb.fit(), true)), k.this.HYe);
              ad.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4006), k.this.HYe });
              if (k.this.zTO != 1) {
                break label501;
              }
              j.aC(k.this.mContext, 8);
              k.a(k.this);
              k.this.axG(k.this.HYb.fit());
              if (k.this.HYl)
              {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 58L, 1L, false);
                ad.d("MicroMsg.UpdaterManager", "boots download success.");
              }
              j.fiP();
              AppMethodBeat.o(32767);
              return;
              j.aB(k.this.mContext, 9);
            }
            catch (Exception paramAnonymouscvp)
            {
              ad.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymouscvp.getMessage());
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4007), paramAnonymouscvp.getMessage() });
              continue;
            }
            label462:
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4008) });
            continue;
            label501:
            if (k.this.zTO == 0)
            {
              k.this.axG(k.this.HYb.fit());
            }
            else if (k.this.zTO == 2)
            {
              j.aC(k.this.mContext, 1);
              k.a(k.this);
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          ad.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.fD();
          AppUpdaterUI.fix();
          j.fiO();
          AppMethodBeat.o(32767);
          return;
        }
        if (((k.this.HYb instanceof c)) && (k.this.HWJ != 4))
        {
          ad.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (k.this.HYh)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              j.aB(k.this.mContext, paramAnonymousInt1);
            }
            k.this.HYh = false;
            if (k.this.zTO == 1) {
              if (k.this.HYl)
              {
                ad.d("MicroMsg.UpdaterManager", "boots download failed. %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
                switch (paramAnonymousInt1)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          k.this.a(k.this.HYb);
          AppMethodBeat.o(32767);
          return;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 55L, 1L, false);
          continue;
          k.b(k.this);
          continue;
          if (k.this.zTO == 0)
          {
            k.this.bc(1, true);
          }
          else if (k.this.zTO == 2)
          {
            k.c(k.this);
            continue;
            paramAnonymouscvp = k.this;
            paramAnonymousInt1 = k.this.size;
            String str = k.this.md5;
            paramAnonymousInt2 = k.this.HWJ;
            int i = k.this.uin;
            byte[] arrayOfByte1 = k.this.iEm;
            byte[] arrayOfByte2 = k.this.dLl;
            String[] arrayOfString = k.this.HYd;
            if (k.this.zTO == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymouscvp.HYb = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              k.d(k.this);
              break;
            }
            ad.e("MicroMsg.UpdaterManager", "update failed");
            j.aB(k.this.mContext, 10);
            if (k.this.zTO == 1) {
              k.e(k.this);
            } else if (k.this.zTO == 0) {
              k.this.bc(1, true);
            }
          }
        }
      }
      
      public final void eZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32766);
        ad.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (k.this.zTO != 2) {
          k.a(k.this, paramAnonymousInt2, paramAnonymousInt1);
        }
        k.this.eZ(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32766);
      }
    };
    this.mContext = aj.getContext();
    AppMethodBeat.o(32771);
  }
  
  private void fiR()
  {
    AppMethodBeat.i(32780);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aQJ() - 86400L).commit();
    bc(2, true);
    fiz();
    AppMethodBeat.o(32780);
  }
  
  private void fiS()
  {
    AppMethodBeat.i(32781);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aQJ() - 86400L).commit();
    bc(2, true);
    fiA();
    AppMethodBeat.o(32781);
  }
  
  private void fiT()
  {
    AppMethodBeat.i(32782);
    if ((this.zTO == 2) && (!ay.isWifi(this.mContext)))
    {
      j.fiN();
      ad.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      AppMethodBeat.o(32782);
      return;
    }
    if ((this.zTO == 2) && (g.aPL(this.md5)))
    {
      ad.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.HYo.stop();
      AppMethodBeat.o(32782);
      return;
    }
    this.HYo.gf(this.md5, this.size);
    if (this.HYb != null)
    {
      bc(1, false);
      this.HYm = true;
      this.HYb.a(this.HYq);
      dRW();
      if (this.zTO == 2) {
        j.fiN();
      }
    }
    AppMethodBeat.o(32782);
  }
  
  private void fiU()
  {
    AppMethodBeat.i(32783);
    cancel();
    ad.i("MicroMsg.UpdaterManager", "downloadFullPack");
    j.aB(this.mContext, 7);
    if ((this.HXl != null) && (this.HXl.length > 0))
    {
      i = this.size;
      str = this.md5;
      j = this.HWJ;
      localObject = this.HXl;
      if (this.zTO == 2) {}
      for (bool = true;; bool = false)
      {
        this.HYb = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 76L, 1L, true);
        fiT();
        AppMethodBeat.o(32783);
        return;
      }
    }
    int i = this.size;
    String str = this.md5;
    int j = this.HWJ;
    int k = this.uin;
    Object localObject = this.iEm;
    byte[] arrayOfByte = this.dLl;
    String[] arrayOfString = this.HYd;
    if (this.zTO == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.HYb = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(32779);
    cancel();
    this.cSe = 0;
    this.cSg = null;
    this.HYd = null;
    this.EMv = d.Fnj;
    this.HWJ = 0;
    this.iEm = null;
    this.dLl = null;
    this.iEq = null;
    this.uin = 0;
    this.md5 = null;
    this.size = 0;
    this.desc = null;
    this.HXl = null;
    this.HYf = null;
    this.HYg = null;
    this.HYh = false;
    this.HYi = false;
    this.zTO = 0;
    this.HYj = false;
    this.intent = null;
    this.HYm = false;
    this.jSl = null;
    this.HYp = 0L;
    AppMethodBeat.o(32779);
  }
  
  private void ws(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(32776);
    ad.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.zTO), Boolean.valueOf(this.HYm) });
    if (this.intent == null)
    {
      ad.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      AppMethodBeat.o(32776);
      return;
    }
    if (this.HYm)
    {
      ad.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      AppMethodBeat.o(32776);
      return;
    }
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      ad.e("MicroMsg.UpdaterManager", "no sdcard.");
      fiR();
      AppMethodBeat.o(32776);
      return;
    }
    if ((this.zTO == 2) && (!paramBoolean)) {
      j.aC(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.aqS(this.md5);
    ad.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      ad.i("MicroMsg.UpdaterManager", "update package already exist.");
      bc(1, true);
      axG(str1);
      if ((this.zTO == 2) && (!j.aPM(this.md5))) {
        j.a(this.md5, this.HYe, this.desc, this.size, this.zTO, this.HWJ, this.HYk);
      }
      AppMethodBeat.o(32776);
      return;
    }
    if (this.HYj)
    {
      if (this.HYb != null) {
        this.HYb.deleteTempFile();
      }
      j.aB(this.mContext, 11);
    }
    if ((!this.HYj) && (this.HYh) && (this.HYf != null) && (this.HYg != null))
    {
      ad.i("MicroMsg.UpdaterManager", "Incresment Update");
      j.aB(this.mContext, 5);
      if (!e.qR(this.size + this.HYg.size))
      {
        fiS();
        AppMethodBeat.o(32776);
        return;
      }
      cancel();
      int i = this.HYg.size;
      str1 = this.md5;
      int j = this.HWJ;
      String str2 = this.HYf.cSr + this.HYg.url;
      String str3 = this.HYg.patchMd5;
      String str4 = this.HYg.cSu;
      if (this.zTO == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.HYb = new c(i, str1, j, str2, str3, str4, paramBoolean);
        fiT();
        AppMethodBeat.o(32776);
        return;
      }
    }
    if (!e.qR(this.size))
    {
      ad.e("MicroMsg.UpdaterManager", "SDCard is full");
      fiS();
      AppMethodBeat.o(32776);
      return;
    }
    fiU();
    AppMethodBeat.o(32776);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(32787);
    Iterator localIterator = this.HYc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(32787);
  }
  
  public final void axG(String paramString)
  {
    AppMethodBeat.i(32786);
    Iterator localIterator = this.HYc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).axG(paramString);
    }
    AppMethodBeat.o(32786);
  }
  
  public final void bc(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32777);
    this.HYi = paramBoolean;
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32765);
        ((NotificationManager)k.this.mContext.getSystemService("notification")).cancel(99);
        ad.d("MicroMsg.UpdaterManager", "finishType == " + paramInt);
        if ((paramInt == 2) && (k.this.HWJ == 1))
        {
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
          k.this.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        }
        AppMethodBeat.o(32765);
      }
    }, 300L);
    AppMethodBeat.o(32777);
  }
  
  public final boolean bh(Intent paramIntent)
  {
    AppMethodBeat.i(32773);
    boolean bool = bi(paramIntent);
    ad.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      ws(false);
    }
    AppMethodBeat.o(32773);
    return bool;
  }
  
  public final boolean bi(Intent paramIntent)
  {
    AppMethodBeat.i(32774);
    ad.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
    if (paramIntent == null)
    {
      ad.i("MicroMsg.UpdaterManager", "intent == null");
      AppMethodBeat.o(32774);
      return false;
    }
    int j = paramIntent.getIntExtra("intent_update_type", 3);
    int i = paramIntent.getIntExtra("intent_extra_download_mode", 1);
    String str = paramIntent.getStringExtra("intent_extra_md5");
    if ((this.HYm) && (!str.equalsIgnoreCase(this.md5)) && (this.zTO == 2)) {
      cancel();
    }
    Object localObject;
    while (!this.HYm)
    {
      j.fiP();
      reset();
      this.intent = paramIntent;
      this.cSe = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.cSg = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.HYd = paramIntent.getStringArrayExtra("intent_short_ips");
      this.EMv = paramIntent.getIntExtra("intent_client_version", d.Fnj);
      d.Fnj = this.EMv;
      this.HWJ = j;
      this.iEm = paramIntent.getByteArrayExtra("intent_extra_session");
      this.dLl = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.iEq = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.md5 = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.HXl = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.zTO = i;
      this.HYj = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject != null)
      {
        ad.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.HYf = com.tencent.mm.d.i.eY((String)localObject);
      }
      localObject = paramIntent.getStringExtra("intent_extra_extinfo");
      ad.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject });
      if (!bt.isNullOrNil((String)localObject))
      {
        this.HYk = ((String)bw.M((String)localObject, "extinfo").get(".extinfo.notautodownloadrange"));
        ad.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.HYk });
      }
      ad.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.HYm) });
      if ((j != 999) || (this.HXl == null) || (this.HXl.length <= 0)) {
        break;
      }
      if (i == 2) {
        ad.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
      }
      AppMethodBeat.o(32774);
      return true;
    }
    ad.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
    AppMethodBeat.o(32774);
    return true;
    if (this.HXl != null)
    {
      localObject = this.HXl;
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        ad.i("MicroMsg.UpdaterManager", "download url : ".concat(String.valueOf(localObject[i])));
        i += 1;
      }
    }
    ad.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[] { str, Integer.valueOf(this.size) });
    if ((str == null) || (this.size == 0))
    {
      AppMethodBeat.o(32774);
      return false;
    }
    if (j == 2)
    {
      boolean bool = com.tencent.mm.modelcontrol.b.ET(this.HYk);
      ad.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 78L, 1L, true);
        AppMethodBeat.o(32774);
        return false;
      }
    }
    if (this.HYf != null)
    {
      ad.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject = com.tencent.mm.pluginsdk.i.j.hw(this.mContext);
      this.HYg = this.HYf.eX((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder("increase apkMD5 = ").append((String)localObject).append(" : ");
      if (this.HYg == null)
      {
        localObject = "not match";
        ad.i("MicroMsg.UpdaterManager", (String)localObject);
      }
    }
    else
    {
      ad.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.HYj) });
      this.HYl = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.HYg == null) || (com.tencent.mm.sandbox.monitor.c.aPG(str))) && (!this.HYl)) {
        break label837;
      }
      ad.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.HYh = true;
    }
    for (;;)
    {
      paramIntent = j.fav();
      if ((!bt.isNullOrNil(paramIntent)) && (!paramIntent.equals(str))) {
        j.fiQ();
      }
      AppMethodBeat.o(32774);
      return true;
      localObject = "match";
      break;
      label837:
      ad.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32778);
    if (this.HYb != null)
    {
      this.HYm = false;
      this.HYb.cancel();
      this.HYb = null;
      this.HYn = System.currentTimeMillis();
      this.HYo.stop();
    }
    AppMethodBeat.o(32778);
  }
  
  public final void cjl()
  {
    AppMethodBeat.i(221387);
    ws(false);
    AppMethodBeat.o(221387);
  }
  
  public final void dRW()
  {
    AppMethodBeat.i(32785);
    Iterator localIterator = this.HYc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).dRW();
    }
    AppMethodBeat.o(32785);
  }
  
  public final void eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32784);
    Iterator localIterator = this.HYc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).eZ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(32784);
  }
  
  public final void fiA()
  {
    AppMethodBeat.i(32789);
    Iterator localIterator = this.HYc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).fiA();
    }
    AppMethodBeat.o(32789);
  }
  
  public final void fiz()
  {
    AppMethodBeat.i(32788);
    Iterator localIterator = this.HYc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).fiz();
    }
    AppMethodBeat.o(32788);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32790);
    if ((this.HYm) || (System.currentTimeMillis() - this.HYn <= UpdaterService.HYw))
    {
      ad.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.HYm), Long.valueOf(this.HYn), Long.valueOf(System.currentTimeMillis() - this.HYn) });
      AppMethodBeat.o(32790);
      return true;
    }
    ad.i("MicroMsg.UpdaterManager", "not busy");
    AppMethodBeat.o(32790);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32791);
    ad.i("MicroMsg.UpdaterManager", "onDestroy");
    if (!this.HYm)
    {
      reset();
      bc(1, true);
    }
    AppMethodBeat.o(32791);
  }
  
  public final void wq(boolean paramBoolean)
  {
    AppMethodBeat.i(32772);
    ad.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g localg = this.HYo;
    if (localg.ruo != paramBoolean)
    {
      localg.wr(true);
      localg.ruo = paramBoolean;
    }
    if ((this.zTO != 2) || (this.HYm))
    {
      ad.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.zTO), Boolean.valueOf(this.HYm) });
      AppMethodBeat.o(32772);
      return;
    }
    if (paramBoolean)
    {
      if (bi(this.intent))
      {
        ws(true);
        AppMethodBeat.o(32772);
      }
    }
    else if (this.HYm) {
      cancel();
    }
    AppMethodBeat.o(32772);
  }
  
  static final class a
  {
    public static final k HYt;
    
    static
    {
      AppMethodBeat.i(32770);
      HYt = new k((byte)0);
      AppMethodBeat.o(32770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */