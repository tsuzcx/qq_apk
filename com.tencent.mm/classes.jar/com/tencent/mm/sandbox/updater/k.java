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
import com.tencent.mm.protocal.protobuf.cld;
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
  public int BPw;
  public int ENK;
  public String[] EOl;
  com.tencent.mm.sandbox.monitor.c EPb;
  ArrayList<h> EPc;
  public String[] EPd;
  public String EPe;
  public com.tencent.mm.d.i EPf;
  public i.a EPg;
  public boolean EPh;
  public boolean EPi;
  public boolean EPj;
  public String EPk;
  public boolean EPl;
  boolean EPm;
  long EPn;
  g EPo;
  private long EPp;
  private b.a EPq;
  public int cJT;
  public String cJV;
  public byte[] dBl;
  public String desc;
  public byte[] hKC;
  public byte[] hKy;
  private Notification iXX;
  private Intent intent;
  protected Context mContext;
  public String md5;
  public int size;
  public int uin;
  public int xpD;
  
  private k()
  {
    AppMethodBeat.i(32771);
    this.EPb = null;
    this.EPc = new ArrayList(1);
    this.BPw = d.CpK;
    this.EPh = false;
    this.EPi = false;
    this.EPj = false;
    this.EPl = false;
    this.EPm = false;
    this.intent = null;
    this.iXX = null;
    this.mContext = null;
    this.EPo = new g(this);
    this.EPp = -1L;
    this.EPq = new b.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, cld paramAnonymouscld)
      {
        AppMethodBeat.i(32767);
        k.this.EPm = false;
        k.this.EPo.stop();
        k.this.EPn = System.currentTimeMillis();
        if (k.this.EPb == null)
        {
          k.this.aR(2, true);
          AppMethodBeat.o(32767);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          ad.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (k.this.xpD != 2) {
            k.a(k.this, 100, 100);
          }
          if (k.this.EPh)
          {
            j.as(k.this.mContext, 0);
            paramAnonymouscld = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.XN());
            k.this.EPe = paramAnonymouscld.getString(aj.getPackageName(), "");
            ad.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { k.this.EPe, k.this.EPb.eDx() });
            if ((bt.isNullOrNil(k.this.EPe)) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
              break label462;
            }
          }
          for (;;)
          {
            try
            {
              com.tencent.mm.d.c.g(new File(com.tencent.mm.vfs.i.k(k.this.EPb.eDx(), true)), k.this.EPe);
              ad.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(4006), k.this.EPe });
              if (k.this.xpD != 1) {
                break label501;
              }
              j.at(k.this.mContext, 8);
              k.a(k.this);
              k.this.apm(k.this.EPb.eDx());
              if (k.this.EPl)
              {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 58L, 1L, false);
                ad.d("MicroMsg.UpdaterManager", "boots download success.");
              }
              j.eDT();
              AppMethodBeat.o(32767);
              return;
              j.as(k.this.mContext, 9);
            }
            catch (Exception paramAnonymouscld)
            {
              ad.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymouscld.getMessage());
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(322L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(4007), paramAnonymouscld.getMessage() });
              continue;
            }
            label462:
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(4008) });
            continue;
            label501:
            if (k.this.xpD == 0)
            {
              k.this.apm(k.this.EPb.eDx());
            }
            else if (k.this.xpD == 2)
            {
              j.at(k.this.mContext, 1);
              k.a(k.this);
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          ad.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.fe();
          AppUpdaterUI.eDB();
          j.eDS();
          AppMethodBeat.o(32767);
          return;
        }
        if (((k.this.EPb instanceof c)) && (k.this.ENK != 4))
        {
          ad.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (k.this.EPh)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              j.as(k.this.mContext, paramAnonymousInt1);
            }
            k.this.EPh = false;
            if (k.this.xpD == 1) {
              if (k.this.EPl)
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
          k.this.a(k.this.EPb);
          AppMethodBeat.o(32767);
          return;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 55L, 1L, false);
          continue;
          k.b(k.this);
          continue;
          if (k.this.xpD == 0)
          {
            k.this.aR(1, true);
          }
          else if (k.this.xpD == 2)
          {
            k.c(k.this);
            continue;
            paramAnonymouscld = k.this;
            paramAnonymousInt1 = k.this.size;
            String str = k.this.md5;
            paramAnonymousInt2 = k.this.ENK;
            int i = k.this.uin;
            byte[] arrayOfByte1 = k.this.hKy;
            byte[] arrayOfByte2 = k.this.dBl;
            String[] arrayOfString = k.this.EPd;
            if (k.this.xpD == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymouscld.EPb = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              k.d(k.this);
              break;
            }
            ad.e("MicroMsg.UpdaterManager", "update failed");
            j.as(k.this.mContext, 10);
            if (k.this.xpD == 1) {
              k.e(k.this);
            } else if (k.this.xpD == 0) {
              k.this.aR(1, true);
            }
          }
        }
      }
      
      public final void eS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32766);
        ad.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (k.this.xpD != 2) {
          k.a(k.this, paramAnonymousInt2, paramAnonymousInt1);
        }
        k.this.eS(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32766);
      }
      
      public final void vw(long paramAnonymousLong)
      {
        AppMethodBeat.i(32768);
        g localg = k.this.EPo;
        localg.cOx.post(new g.2(localg, paramAnonymousLong));
        AppMethodBeat.o(32768);
      }
      
      public final void vx(long paramAnonymousLong)
      {
        AppMethodBeat.i(32769);
        g localg = k.this.EPo;
        localg.cOx.post(new g.3(localg, paramAnonymousLong));
        AppMethodBeat.o(32769);
      }
    };
    this.mContext = aj.getContext();
    AppMethodBeat.o(32771);
  }
  
  private void eDV()
  {
    AppMethodBeat.i(32780);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aGK() - 86400L).commit();
    aR(2, true);
    eDD();
    AppMethodBeat.o(32780);
  }
  
  private void eDW()
  {
    AppMethodBeat.i(32781);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aGK() - 86400L).commit();
    aR(2, true);
    eDE();
    AppMethodBeat.o(32781);
  }
  
  private void eDX()
  {
    AppMethodBeat.i(32782);
    if ((this.xpD == 2) && (!ay.isWifi(this.mContext)))
    {
      j.eDR();
      ad.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      AppMethodBeat.o(32782);
      return;
    }
    if ((this.xpD == 2) && (g.aEO(this.md5)))
    {
      ad.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.EPo.stop();
      AppMethodBeat.o(32782);
      return;
    }
    this.EPo.fD(this.md5, this.size);
    if (this.EPb != null)
    {
      aR(1, false);
      this.EPm = true;
      this.EPb.a(this.EPq);
      duP();
      if (this.xpD == 2) {
        j.eDR();
      }
    }
    AppMethodBeat.o(32782);
  }
  
  private void eDY()
  {
    AppMethodBeat.i(32783);
    cancel();
    ad.i("MicroMsg.UpdaterManager", "downloadFullPack");
    j.as(this.mContext, 7);
    if ((this.EOl != null) && (this.EOl.length > 0))
    {
      i = this.size;
      str = this.md5;
      j = this.ENK;
      localObject = this.EOl;
      if (this.xpD == 2) {}
      for (bool = true;; bool = false)
      {
        this.EPb = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 76L, 1L, true);
        eDX();
        AppMethodBeat.o(32783);
        return;
      }
    }
    int i = this.size;
    String str = this.md5;
    int j = this.ENK;
    int k = this.uin;
    Object localObject = this.hKy;
    byte[] arrayOfByte = this.dBl;
    String[] arrayOfString = this.EPd;
    if (this.xpD == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.EPb = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(32779);
    cancel();
    this.cJT = 0;
    this.cJV = null;
    this.EPd = null;
    this.BPw = d.CpK;
    this.ENK = 0;
    this.hKy = null;
    this.dBl = null;
    this.hKC = null;
    this.uin = 0;
    this.md5 = null;
    this.size = 0;
    this.desc = null;
    this.EOl = null;
    this.EPf = null;
    this.EPg = null;
    this.EPh = false;
    this.EPi = false;
    this.xpD = 0;
    this.EPj = false;
    this.intent = null;
    this.EPm = false;
    this.iXX = null;
    this.EPp = 0L;
    AppMethodBeat.o(32779);
  }
  
  private void uE(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(32776);
    ad.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.xpD), Boolean.valueOf(this.EPm) });
    if (this.intent == null)
    {
      ad.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      AppMethodBeat.o(32776);
      return;
    }
    if (this.EPm)
    {
      ad.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      AppMethodBeat.o(32776);
      return;
    }
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      ad.e("MicroMsg.UpdaterManager", "no sdcard.");
      eDV();
      AppMethodBeat.o(32776);
      return;
    }
    if ((this.xpD == 2) && (!paramBoolean)) {
      j.at(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.ahi(this.md5);
    ad.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      ad.i("MicroMsg.UpdaterManager", "update package already exist.");
      aR(1, true);
      apm(str1);
      if ((this.xpD == 2) && (!j.aEP(this.md5))) {
        j.a(this.md5, this.EPe, this.desc, this.size, this.xpD, this.ENK, this.EPk);
      }
      AppMethodBeat.o(32776);
      return;
    }
    if (this.EPj)
    {
      if (this.EPb != null) {
        this.EPb.deleteTempFile();
      }
      j.as(this.mContext, 11);
    }
    if ((!this.EPj) && (this.EPh) && (this.EPf != null) && (this.EPg != null))
    {
      ad.i("MicroMsg.UpdaterManager", "Incresment Update");
      j.as(this.mContext, 5);
      if (!e.lo(this.size + this.EPg.size))
      {
        eDW();
        AppMethodBeat.o(32776);
        return;
      }
      cancel();
      int i = this.EPg.size;
      str1 = this.md5;
      int j = this.ENK;
      String str2 = this.EPf.bob + this.EPg.url;
      String str3 = this.EPg.patchMd5;
      String str4 = this.EPg.cKi;
      if (this.xpD == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.EPb = new c(i, str1, j, str2, str3, str4, paramBoolean);
        eDX();
        AppMethodBeat.o(32776);
        return;
      }
    }
    if (!e.lo(this.size))
    {
      ad.e("MicroMsg.UpdaterManager", "SDCard is full");
      eDW();
      AppMethodBeat.o(32776);
      return;
    }
    eDY();
    AppMethodBeat.o(32776);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(32787);
    Iterator localIterator = this.EPc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(32787);
  }
  
  public final void aR(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32777);
    this.EPi = paramBoolean;
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32765);
        ((NotificationManager)k.this.mContext.getSystemService("notification")).cancel(99);
        ad.d("MicroMsg.UpdaterManager", "finishType == " + paramInt);
        if ((paramInt == 2) && (k.this.ENK == 1))
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
  
  public final void apm(String paramString)
  {
    AppMethodBeat.i(32786);
    Iterator localIterator = this.EPc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).apm(paramString);
    }
    AppMethodBeat.o(32786);
  }
  
  public final void bXv()
  {
    AppMethodBeat.i(204878);
    uE(false);
    AppMethodBeat.o(204878);
  }
  
  public final boolean bb(Intent paramIntent)
  {
    AppMethodBeat.i(32773);
    boolean bool = bc(paramIntent);
    ad.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      uE(false);
    }
    AppMethodBeat.o(32773);
    return bool;
  }
  
  public final boolean bc(Intent paramIntent)
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
    if ((this.EPm) && (!str.equalsIgnoreCase(this.md5)) && (this.xpD == 2)) {
      cancel();
    }
    Object localObject;
    while (!this.EPm)
    {
      j.eDT();
      reset();
      this.intent = paramIntent;
      this.cJT = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.cJV = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.EPd = paramIntent.getStringArrayExtra("intent_short_ips");
      this.BPw = paramIntent.getIntExtra("intent_client_version", d.CpK);
      d.CpK = this.BPw;
      this.ENK = j;
      this.hKy = paramIntent.getByteArrayExtra("intent_extra_session");
      this.dBl = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.hKC = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.md5 = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.EOl = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.xpD = i;
      this.EPj = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject != null)
      {
        ad.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.EPf = com.tencent.mm.d.i.eo((String)localObject);
      }
      localObject = paramIntent.getStringExtra("intent_extra_extinfo");
      ad.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject });
      if (!bt.isNullOrNil((String)localObject))
      {
        this.EPk = ((String)bw.K((String)localObject, "extinfo").get(".extinfo.notautodownloadrange"));
        ad.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.EPk });
      }
      ad.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.EPm) });
      if ((j != 999) || (this.EOl == null) || (this.EOl.length <= 0)) {
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
    if (this.EOl != null)
    {
      localObject = this.EOl;
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
      boolean bool = com.tencent.mm.modelcontrol.b.xO(this.EPk);
      ad.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 78L, 1L, true);
        AppMethodBeat.o(32774);
        return false;
      }
    }
    if (this.EPf != null)
    {
      ad.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject = com.tencent.mm.pluginsdk.g.i.hg(this.mContext);
      this.EPg = this.EPf.en((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder("increase apkMD5 = ").append((String)localObject).append(" : ");
      if (this.EPg == null)
      {
        localObject = "not match";
        ad.i("MicroMsg.UpdaterManager", (String)localObject);
      }
    }
    else
    {
      ad.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.EPj) });
      this.EPl = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.EPg == null) || (com.tencent.mm.sandbox.monitor.c.aEJ(str))) && (!this.EPl)) {
        break label837;
      }
      ad.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.EPh = true;
    }
    for (;;)
    {
      paramIntent = j.ewe();
      if ((!bt.isNullOrNil(paramIntent)) && (!paramIntent.equals(str))) {
        j.eDU();
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
    if (this.EPb != null)
    {
      this.EPm = false;
      this.EPb.cancel();
      this.EPb = null;
      this.EPn = System.currentTimeMillis();
      this.EPo.stop();
    }
    AppMethodBeat.o(32778);
  }
  
  public final void duP()
  {
    AppMethodBeat.i(32785);
    Iterator localIterator = this.EPc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).duP();
    }
    AppMethodBeat.o(32785);
  }
  
  public final void eDD()
  {
    AppMethodBeat.i(32788);
    Iterator localIterator = this.EPc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).eDD();
    }
    AppMethodBeat.o(32788);
  }
  
  public final void eDE()
  {
    AppMethodBeat.i(32789);
    Iterator localIterator = this.EPc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).eDE();
    }
    AppMethodBeat.o(32789);
  }
  
  public final void eS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32784);
    Iterator localIterator = this.EPc.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).eS(paramInt1, paramInt2);
    }
    AppMethodBeat.o(32784);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32790);
    if ((this.EPm) || (System.currentTimeMillis() - this.EPn <= UpdaterService.EPw))
    {
      ad.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.EPm), Long.valueOf(this.EPn), Long.valueOf(System.currentTimeMillis() - this.EPn) });
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
    if (!this.EPm)
    {
      reset();
      aR(1, true);
    }
    AppMethodBeat.o(32791);
  }
  
  public final void uC(boolean paramBoolean)
  {
    AppMethodBeat.i(32772);
    ad.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g localg = this.EPo;
    if (localg.qbG != paramBoolean)
    {
      localg.uD(true);
      localg.qbG = paramBoolean;
    }
    if ((this.xpD != 2) || (this.EPm))
    {
      ad.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.xpD), Boolean.valueOf(this.EPm) });
      AppMethodBeat.o(32772);
      return;
    }
    if (paramBoolean)
    {
      if (bc(this.intent))
      {
        uE(true);
        AppMethodBeat.o(32772);
      }
    }
    else if (this.EPm) {
      cancel();
    }
    AppMethodBeat.o(32772);
  }
  
  static final class a
  {
    public static final k EPt;
    
    static
    {
      AppMethodBeat.i(32770);
      EPt = new k((byte)0);
      AppMethodBeat.o(32770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */