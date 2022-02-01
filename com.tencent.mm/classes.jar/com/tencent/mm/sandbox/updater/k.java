package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class k
  implements a, h
{
  public int KHe;
  public int URN;
  public String[] USp;
  com.tencent.mm.sandbox.monitor.c UTh;
  ArrayList<h> UTi;
  public String[] UTj;
  public String UTk;
  public i UTl;
  public i.a UTm;
  public boolean UTn;
  public boolean UTo;
  public boolean UTp;
  public String UTq;
  public boolean UTr;
  boolean UTs;
  long UTt;
  g UTu;
  private long UTv;
  private b.a UTw;
  public String desc;
  public byte[] fYH;
  public String faQ;
  private Intent intent;
  public int lZO;
  protected Context mContext;
  public String md5;
  public byte[] mtR;
  public byte[] mtV;
  private Notification nSJ;
  public int size;
  public int uin;
  public int updateMode;
  
  private k()
  {
    AppMethodBeat.i(32771);
    this.UTh = null;
    this.UTi = new ArrayList(1);
    this.lZO = d.RAD;
    this.UTn = false;
    this.UTo = false;
    this.UTp = false;
    this.UTr = false;
    this.UTs = false;
    this.intent = null;
    this.nSJ = null;
    this.mContext = null;
    this.UTu = new g(this);
    this.UTv = -1L;
    this.UTw = new b.a()
    {
      public final void Uk(long paramAnonymousLong)
      {
        AppMethodBeat.i(32768);
        g localg = k.this.UTu;
        localg.timer.post(new g.2(localg, paramAnonymousLong));
        AppMethodBeat.o(32768);
      }
      
      public final void Ul(long paramAnonymousLong)
      {
        AppMethodBeat.i(32769);
        g localg = k.this.UTu;
        localg.timer.post(new g.3(localg, paramAnonymousLong));
        AppMethodBeat.o(32769);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, dyy paramAnonymousdyy)
      {
        AppMethodBeat.i(32767);
        k.this.UTs = false;
        k.this.UTu.stop();
        k.this.UTt = System.currentTimeMillis();
        if (k.this.UTh == null)
        {
          k.this.bP(2, true);
          AppMethodBeat.o(32767);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (k.this.KHe != 2) {
            k.a(k.this, 100, 100);
          }
          if (k.this.UTn)
          {
            j.bc(k.this.mContext, 0);
            paramAnonymousdyy = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.avK());
            k.this.UTk = paramAnonymousdyy.getString(MMApplicationContext.getPackageName(), "");
            Log.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { k.this.UTk, k.this.UTh.hrX() });
            if ((Util.isNullOrNil(k.this.UTk)) || (BuildInfo.IS_FLAVOR_RED)) {
              break label462;
            }
          }
          for (;;)
          {
            try
            {
              com.tencent.mm.d.c.h(new File(u.n(k.this.UTh.hrX(), true)), k.this.UTk);
              Log.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4006), k.this.UTk });
              if (k.this.KHe != 1) {
                break label501;
              }
              j.bd(k.this.mContext, 8);
              k.a(k.this);
              k.this.aYs(k.this.UTh.hrX());
              if (k.this.UTr)
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 58L, 1L, false);
                Log.d("MicroMsg.UpdaterManager", "boots download success.");
              }
              j.hst();
              AppMethodBeat.o(32767);
              return;
              j.bc(k.this.mContext, 9);
            }
            catch (Exception paramAnonymousdyy)
            {
              Log.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymousdyy.getMessage());
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4007), paramAnonymousdyy.getMessage() });
              continue;
            }
            label462:
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4008) });
            continue;
            label501:
            if (k.this.KHe == 0)
            {
              k.this.aYs(k.this.UTh.hrX());
            }
            else if (k.this.KHe == 2)
            {
              j.bd(k.this.mContext, 1);
              k.a(k.this);
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          Log.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.hz();
          AppUpdaterUI.hsb();
          j.hss();
          AppMethodBeat.o(32767);
          return;
        }
        if (((k.this.UTh instanceof c)) && (k.this.URN != 4))
        {
          Log.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (k.this.UTn)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              j.bc(k.this.mContext, paramAnonymousInt1);
            }
            k.this.UTn = false;
            if (k.this.KHe == 1) {
              if (k.this.UTr)
              {
                Log.d("MicroMsg.UpdaterManager", "boots download failed. %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
                switch (paramAnonymousInt1)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          k.this.a(k.this.UTh);
          AppMethodBeat.o(32767);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 55L, 1L, false);
          continue;
          k.b(k.this);
          continue;
          if (k.this.KHe == 0)
          {
            k.this.bP(1, true);
          }
          else if (k.this.KHe == 2)
          {
            k.c(k.this);
            continue;
            paramAnonymousdyy = k.this;
            paramAnonymousInt1 = k.this.size;
            String str = k.this.md5;
            paramAnonymousInt2 = k.this.URN;
            int i = k.this.uin;
            byte[] arrayOfByte1 = k.this.mtR;
            byte[] arrayOfByte2 = k.this.fYH;
            String[] arrayOfString = k.this.UTj;
            if (k.this.KHe == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousdyy.UTh = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              k.d(k.this);
              break;
            }
            Log.e("MicroMsg.UpdaterManager", "update failed");
            j.bc(k.this.mContext, 10);
            if (k.this.KHe == 1) {
              k.e(k.this);
            } else if (k.this.KHe == 0) {
              k.this.bP(1, true);
            }
          }
        }
      }
      
      public final void fK(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32766);
        Log.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (k.this.KHe != 2) {
          k.a(k.this, paramAnonymousInt2, paramAnonymousInt1);
        }
        k.this.fK(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32766);
      }
    };
    this.mContext = MMApplicationContext.getContext();
    AppMethodBeat.o(32771);
  }
  
  private void EH(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(32776);
    Log.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.KHe), Boolean.valueOf(this.UTs) });
    if (this.intent == null)
    {
      Log.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      AppMethodBeat.o(32776);
      return;
    }
    if (this.UTs)
    {
      Log.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      AppMethodBeat.o(32776);
      return;
    }
    if (!com.tencent.mm.compatible.util.g.avJ().equals("mounted"))
    {
      Log.e("MicroMsg.UpdaterManager", "no sdcard.");
      hsv();
      AppMethodBeat.o(32776);
      return;
    }
    if ((this.KHe == 2) && (!paramBoolean)) {
      j.bd(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.aPB(this.md5);
    Log.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      Log.i("MicroMsg.UpdaterManager", "update package already exist.");
      bP(1, true);
      aYs(str1);
      if ((this.KHe == 2) && (!j.bue(this.md5))) {
        j.a(this.md5, this.UTk, this.desc, this.size, this.KHe, this.URN, this.UTq);
      }
      AppMethodBeat.o(32776);
      return;
    }
    if (this.UTp)
    {
      if (this.UTh != null) {
        this.UTh.deleteTempFile();
      }
      j.bc(this.mContext, 11);
    }
    if ((!this.UTp) && (this.UTn) && (this.UTl != null) && (this.UTm != null))
    {
      Log.i("MicroMsg.UpdaterManager", "Incresment Update");
      j.bc(this.mContext, 5);
      if (!e.EY(this.size + this.UTm.size))
      {
        hsw();
        AppMethodBeat.o(32776);
        return;
      }
      cancel();
      int i = this.UTm.size;
      str1 = this.md5;
      int j = this.URN;
      String str2 = this.UTl.fba + this.UTm.url;
      String str3 = this.UTm.patchMd5;
      String str4 = this.UTm.fbd;
      if (this.KHe == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.UTh = new c(i, str1, j, str2, str3, str4, paramBoolean);
        hsx();
        AppMethodBeat.o(32776);
        return;
      }
    }
    if (!e.EY(this.size))
    {
      Log.e("MicroMsg.UpdaterManager", "SDCard is full");
      hsw();
      AppMethodBeat.o(32776);
      return;
    }
    hsy();
    AppMethodBeat.o(32776);
  }
  
  private void hsv()
  {
    AppMethodBeat.i(32780);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L).commit();
    bP(2, true);
    hsd();
    AppMethodBeat.o(32780);
  }
  
  private void hsw()
  {
    AppMethodBeat.i(32781);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L).commit();
    bP(2, true);
    hse();
    AppMethodBeat.o(32781);
  }
  
  private void hsx()
  {
    AppMethodBeat.i(32782);
    if ((this.KHe == 2) && (!NetStatusUtil.isWifi(this.mContext)))
    {
      j.hsr();
      Log.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      AppMethodBeat.o(32782);
      return;
    }
    if ((this.KHe == 2) && (g.bud(this.md5)))
    {
      Log.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.UTu.stop();
      AppMethodBeat.o(32782);
      return;
    }
    this.UTu.hv(this.md5, this.size);
    if (this.UTh != null)
    {
      bP(1, false);
      this.UTs = true;
      this.UTh.a(this.UTw);
      fJU();
      if (this.KHe == 2) {
        j.hsr();
      }
    }
    AppMethodBeat.o(32782);
  }
  
  private void hsy()
  {
    AppMethodBeat.i(32783);
    cancel();
    Log.i("MicroMsg.UpdaterManager", "downloadFullPack");
    j.bc(this.mContext, 7);
    if ((this.USp != null) && (this.USp.length > 0))
    {
      i = this.size;
      str = this.md5;
      j = this.URN;
      localObject = this.USp;
      if (this.KHe == 2) {}
      for (bool = true;; bool = false)
      {
        this.UTh = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 76L, 1L, true);
        hsx();
        AppMethodBeat.o(32783);
        return;
      }
    }
    int i = this.size;
    String str = this.md5;
    int j = this.URN;
    int k = this.uin;
    Object localObject = this.mtR;
    byte[] arrayOfByte = this.fYH;
    String[] arrayOfString = this.UTj;
    if (this.KHe == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.UTh = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(32779);
    cancel();
    this.updateMode = 0;
    this.faQ = null;
    this.UTj = null;
    this.lZO = d.RAD;
    this.URN = 0;
    this.mtR = null;
    this.fYH = null;
    this.mtV = null;
    this.uin = 0;
    this.md5 = null;
    this.size = 0;
    this.desc = null;
    this.USp = null;
    this.UTl = null;
    this.UTm = null;
    this.UTn = false;
    this.UTo = false;
    this.KHe = 0;
    this.UTp = false;
    this.intent = null;
    this.UTs = false;
    this.nSJ = null;
    this.UTv = 0L;
    AppMethodBeat.o(32779);
  }
  
  public final void EF(boolean paramBoolean)
  {
    AppMethodBeat.i(32772);
    Log.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g localg = this.UTu;
    if (localg.wIk != paramBoolean)
    {
      localg.EG(true);
      localg.wIk = paramBoolean;
    }
    if ((this.KHe != 2) || (this.UTs))
    {
      Log.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.KHe), Boolean.valueOf(this.UTs) });
      AppMethodBeat.o(32772);
      return;
    }
    if (paramBoolean)
    {
      if (bv(this.intent))
      {
        EH(true);
        AppMethodBeat.o(32772);
      }
    }
    else if (this.UTs) {
      cancel();
    }
    AppMethodBeat.o(32772);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(32787);
    Iterator localIterator = this.UTi.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(32787);
  }
  
  public final void aYs(String paramString)
  {
    AppMethodBeat.i(32786);
    Iterator localIterator = this.UTi.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).aYs(paramString);
    }
    AppMethodBeat.o(32786);
  }
  
  public final void bP(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32777);
    this.UTo = paramBoolean;
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32765);
        ((NotificationManager)k.this.mContext.getSystemService("notification")).cancel(99);
        Log.d("MicroMsg.UpdaterManager", "finishType == " + paramInt);
        if ((paramInt == 2) && (k.this.URN == 1))
        {
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
          k.this.mContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
        }
        AppMethodBeat.o(32765);
      }
    }, 300L);
    AppMethodBeat.o(32777);
  }
  
  public final boolean bu(Intent paramIntent)
  {
    AppMethodBeat.i(32773);
    boolean bool = bv(paramIntent);
    Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      EH(false);
    }
    AppMethodBeat.o(32773);
    return bool;
  }
  
  public final boolean bv(Intent paramIntent)
  {
    AppMethodBeat.i(32774);
    Log.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
    if (paramIntent == null)
    {
      Log.i("MicroMsg.UpdaterManager", "intent == null");
      AppMethodBeat.o(32774);
      return false;
    }
    int j = paramIntent.getIntExtra("intent_update_type", 3);
    int i = paramIntent.getIntExtra("intent_extra_download_mode", 1);
    String str = paramIntent.getStringExtra("intent_extra_md5");
    if ((this.UTs) && (!str.equalsIgnoreCase(this.md5)) && (this.KHe == 2)) {
      cancel();
    }
    Object localObject;
    while (!this.UTs)
    {
      j.hst();
      reset();
      this.intent = paramIntent;
      this.updateMode = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.faQ = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.UTj = paramIntent.getStringArrayExtra("intent_short_ips");
      this.lZO = paramIntent.getIntExtra("intent_client_version", d.RAD);
      d.RAD = this.lZO;
      this.URN = j;
      this.mtR = paramIntent.getByteArrayExtra("intent_extra_session");
      this.fYH = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.mtV = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.md5 = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.USp = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.KHe = i;
      this.UTp = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject != null)
      {
        Log.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.UTl = i.gB((String)localObject);
      }
      localObject = paramIntent.getStringExtra("intent_extra_extinfo");
      Log.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject });
      if (!Util.isNullOrNil((String)localObject))
      {
        this.UTq = ((String)XmlParser.parseXml((String)localObject, "extinfo", null).get(".extinfo.notautodownloadrange"));
        Log.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.UTq });
      }
      Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.UTs) });
      if ((j != 999) || (this.USp == null) || (this.USp.length <= 0)) {
        break;
      }
      if (i == 2) {
        Log.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
      }
      AppMethodBeat.o(32774);
      return true;
    }
    Log.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
    AppMethodBeat.o(32774);
    return true;
    if (this.USp != null)
    {
      localObject = this.USp;
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        Log.i("MicroMsg.UpdaterManager", "download url : ".concat(String.valueOf(localObject[i])));
        i += 1;
      }
    }
    Log.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[] { str, Integer.valueOf(this.size) });
    if ((str == null) || (this.size == 0))
    {
      AppMethodBeat.o(32774);
      return false;
    }
    if (j == 2)
    {
      boolean bool = com.tencent.mm.modelcontrol.b.VC(this.UTq);
      Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 78L, 1L, true);
        AppMethodBeat.o(32774);
        return false;
      }
    }
    if (this.UTl != null)
    {
      Log.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject = com.tencent.mm.pluginsdk.j.g.jz(this.mContext);
      this.UTm = this.UTl.gA((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder("increase apkMD5 = ").append((String)localObject).append(" : ");
      if (this.UTm == null)
      {
        localObject = "not match";
        Log.i("MicroMsg.UpdaterManager", (String)localObject);
      }
    }
    else
    {
      Log.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.UTp) });
      this.UTr = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.UTm == null) || (com.tencent.mm.sandbox.monitor.c.btY(str))) && (!this.UTr)) {
        break label823;
      }
      Log.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.UTn = true;
    }
    for (;;)
    {
      paramIntent = j.hhZ();
      if ((!Util.isNullOrNil(paramIntent)) && (!paramIntent.equals(str))) {
        j.hsu();
      }
      AppMethodBeat.o(32774);
      return true;
      localObject = "match";
      break;
      label823:
      Log.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void cXm()
  {
    AppMethodBeat.i(293359);
    EH(false);
    AppMethodBeat.o(293359);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32778);
    if (this.UTh != null)
    {
      this.UTs = false;
      this.UTh.cancel();
      this.UTh = null;
      this.UTt = System.currentTimeMillis();
      this.UTu.stop();
    }
    AppMethodBeat.o(32778);
  }
  
  public final void fJU()
  {
    AppMethodBeat.i(32785);
    Iterator localIterator = this.UTi.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).fJU();
    }
    AppMethodBeat.o(32785);
  }
  
  public final void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32784);
    Iterator localIterator = this.UTi.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).fK(paramInt1, paramInt2);
    }
    AppMethodBeat.o(32784);
  }
  
  public final void hsd()
  {
    AppMethodBeat.i(32788);
    Iterator localIterator = this.UTi.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).hsd();
    }
    AppMethodBeat.o(32788);
  }
  
  public final void hse()
  {
    AppMethodBeat.i(32789);
    Iterator localIterator = this.UTi.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).hse();
    }
    AppMethodBeat.o(32789);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32790);
    if ((this.UTs) || (System.currentTimeMillis() - this.UTt <= UpdaterService.UTC))
    {
      Log.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.UTs), Long.valueOf(this.UTt), Long.valueOf(System.currentTimeMillis() - this.UTt) });
      AppMethodBeat.o(32790);
      return true;
    }
    Log.i("MicroMsg.UpdaterManager", "not busy");
    AppMethodBeat.o(32790);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32791);
    Log.i("MicroMsg.UpdaterManager", "onDestroy");
    if (!this.UTs)
    {
      reset();
      bP(1, true);
    }
    AppMethodBeat.o(32791);
  }
  
  static final class a
  {
    public static final k UTz;
    
    static
    {
      AppMethodBeat.i(32770);
      UTz = new k((byte)0);
      AppMethodBeat.o(32770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */