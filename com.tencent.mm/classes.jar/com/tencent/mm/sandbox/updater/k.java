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
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class k
  implements a, h
{
  public int DhK;
  public int GkX;
  public String[] Gly;
  long GmA;
  g GmB;
  private long GmC;
  private b.a GmD;
  com.tencent.mm.sandbox.monitor.c Gmo;
  ArrayList<h> Gmp;
  public String[] Gmq;
  public String Gmr;
  public com.tencent.mm.d.i Gms;
  public i.a Gmt;
  public boolean Gmu;
  public boolean Gmv;
  public boolean Gmw;
  public String Gmx;
  public boolean Gmy;
  boolean Gmz;
  public int cHa;
  public String cHc;
  public String desc;
  public byte[] dyZ;
  public byte[] ikV;
  public byte[] ikZ;
  private Intent intent;
  private Notification jyo;
  protected Context mContext;
  public String md5;
  public int size;
  public int uin;
  public int yCt;
  
  private k()
  {
    AppMethodBeat.i(32771);
    this.Gmo = null;
    this.Gmp = new ArrayList(1);
    this.DhK = d.DIc;
    this.Gmu = false;
    this.Gmv = false;
    this.Gmw = false;
    this.Gmy = false;
    this.Gmz = false;
    this.intent = null;
    this.jyo = null;
    this.mContext = null;
    this.GmB = new g(this);
    this.GmC = -1L;
    this.GmD = new b.a()
    {
      public final void Aa(long paramAnonymousLong)
      {
        AppMethodBeat.i(32769);
        g localg = k.this.GmB;
        localg.cLS.post(new g.3(localg, paramAnonymousLong));
        AppMethodBeat.o(32769);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, cqk paramAnonymouscqk)
      {
        AppMethodBeat.i(32767);
        k.this.Gmz = false;
        k.this.GmB.stop();
        k.this.GmA = System.currentTimeMillis();
        if (k.this.Gmo == null)
        {
          k.this.aV(2, true);
          AppMethodBeat.o(32767);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          ac.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (k.this.yCt != 2) {
            k.a(k.this, 100, 100);
          }
          if (k.this.Gmu)
          {
            j.ay(k.this.mContext, 0);
            paramAnonymouscqk = MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.YK());
            k.this.Gmr = paramAnonymouscqk.getString(ai.getPackageName(), "");
            ac.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { k.this.Gmr, k.this.Gmo.eSR() });
            if ((bs.isNullOrNil(k.this.Gmr)) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
              break label462;
            }
          }
          for (;;)
          {
            try
            {
              com.tencent.mm.d.c.g(new File(com.tencent.mm.vfs.i.k(k.this.Gmo.eSR(), true)), k.this.Gmr);
              ac.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4006), k.this.Gmr });
              if (k.this.yCt != 1) {
                break label501;
              }
              j.az(k.this.mContext, 8);
              k.a(k.this);
              k.this.asD(k.this.Gmo.eSR());
              if (k.this.Gmy)
              {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 58L, 1L, false);
                ac.d("MicroMsg.UpdaterManager", "boots download success.");
              }
              j.eTn();
              AppMethodBeat.o(32767);
              return;
              j.ay(k.this.mContext, 9);
            }
            catch (Exception paramAnonymouscqk)
            {
              ac.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymouscqk.getMessage());
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4007), paramAnonymouscqk.getMessage() });
              continue;
            }
            label462:
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4008) });
            continue;
            label501:
            if (k.this.yCt == 0)
            {
              k.this.asD(k.this.Gmo.eSR());
            }
            else if (k.this.yCt == 2)
            {
              j.az(k.this.mContext, 1);
              k.a(k.this);
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          ac.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.fm();
          AppUpdaterUI.eSV();
          j.eTm();
          AppMethodBeat.o(32767);
          return;
        }
        if (((k.this.Gmo instanceof c)) && (k.this.GkX != 4))
        {
          ac.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (k.this.Gmu)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              j.ay(k.this.mContext, paramAnonymousInt1);
            }
            k.this.Gmu = false;
            if (k.this.yCt == 1) {
              if (k.this.Gmy)
              {
                ac.d("MicroMsg.UpdaterManager", "boots download failed. %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
                switch (paramAnonymousInt1)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          k.this.a(k.this.Gmo);
          AppMethodBeat.o(32767);
          return;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 55L, 1L, false);
          continue;
          k.b(k.this);
          continue;
          if (k.this.yCt == 0)
          {
            k.this.aV(1, true);
          }
          else if (k.this.yCt == 2)
          {
            k.c(k.this);
            continue;
            paramAnonymouscqk = k.this;
            paramAnonymousInt1 = k.this.size;
            String str = k.this.md5;
            paramAnonymousInt2 = k.this.GkX;
            int i = k.this.uin;
            byte[] arrayOfByte1 = k.this.ikV;
            byte[] arrayOfByte2 = k.this.dyZ;
            String[] arrayOfString = k.this.Gmq;
            if (k.this.yCt == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymouscqk.Gmo = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              k.d(k.this);
              break;
            }
            ac.e("MicroMsg.UpdaterManager", "update failed");
            j.ay(k.this.mContext, 10);
            if (k.this.yCt == 1) {
              k.e(k.this);
            } else if (k.this.yCt == 0) {
              k.this.aV(1, true);
            }
          }
        }
      }
      
      public final void eV(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32766);
        ac.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (k.this.yCt != 2) {
          k.a(k.this, paramAnonymousInt2, paramAnonymousInt1);
        }
        k.this.eV(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32766);
      }
      
      public final void zZ(long paramAnonymousLong)
      {
        AppMethodBeat.i(32768);
        g localg = k.this.GmB;
        localg.cLS.post(new g.2(localg, paramAnonymousLong));
        AppMethodBeat.o(32768);
      }
    };
    this.mContext = ai.getContext();
    AppMethodBeat.o(32771);
  }
  
  private void eTp()
  {
    AppMethodBeat.i(32780);
    MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bs.aNx() - 86400L).commit();
    aV(2, true);
    eSX();
    AppMethodBeat.o(32780);
  }
  
  private void eTq()
  {
    AppMethodBeat.i(32781);
    MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bs.aNx() - 86400L).commit();
    aV(2, true);
    eSY();
    AppMethodBeat.o(32781);
  }
  
  private void eTr()
  {
    AppMethodBeat.i(32782);
    if ((this.yCt == 2) && (!ax.isWifi(this.mContext)))
    {
      j.eTl();
      ac.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      AppMethodBeat.o(32782);
      return;
    }
    if ((this.yCt == 2) && (g.aKf(this.md5)))
    {
      ac.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.GmB.stop();
      AppMethodBeat.o(32782);
      return;
    }
    this.GmB.fI(this.md5, this.size);
    if (this.Gmo != null)
    {
      aV(1, false);
      this.Gmz = true;
      this.Gmo.a(this.GmD);
      dFC();
      if (this.yCt == 2) {
        j.eTl();
      }
    }
    AppMethodBeat.o(32782);
  }
  
  private void eTs()
  {
    AppMethodBeat.i(32783);
    cancel();
    ac.i("MicroMsg.UpdaterManager", "downloadFullPack");
    j.ay(this.mContext, 7);
    if ((this.Gly != null) && (this.Gly.length > 0))
    {
      i = this.size;
      str = this.md5;
      j = this.GkX;
      localObject = this.Gly;
      if (this.yCt == 2) {}
      for (bool = true;; bool = false)
      {
        this.Gmo = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 76L, 1L, true);
        eTr();
        AppMethodBeat.o(32783);
        return;
      }
    }
    int i = this.size;
    String str = this.md5;
    int j = this.GkX;
    int k = this.uin;
    Object localObject = this.ikV;
    byte[] arrayOfByte = this.dyZ;
    String[] arrayOfString = this.Gmq;
    if (this.yCt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.Gmo = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(32779);
    cancel();
    this.cHa = 0;
    this.cHc = null;
    this.Gmq = null;
    this.DhK = d.DIc;
    this.GkX = 0;
    this.ikV = null;
    this.dyZ = null;
    this.ikZ = null;
    this.uin = 0;
    this.md5 = null;
    this.size = 0;
    this.desc = null;
    this.Gly = null;
    this.Gms = null;
    this.Gmt = null;
    this.Gmu = false;
    this.Gmv = false;
    this.yCt = 0;
    this.Gmw = false;
    this.intent = null;
    this.Gmz = false;
    this.jyo = null;
    this.GmC = 0L;
    AppMethodBeat.o(32779);
  }
  
  private void vG(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(32776);
    ac.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ac.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.yCt), Boolean.valueOf(this.Gmz) });
    if (this.intent == null)
    {
      ac.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      AppMethodBeat.o(32776);
      return;
    }
    if (this.Gmz)
    {
      ac.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      AppMethodBeat.o(32776);
      return;
    }
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      ac.e("MicroMsg.UpdaterManager", "no sdcard.");
      eTp();
      AppMethodBeat.o(32776);
      return;
    }
    if ((this.yCt == 2) && (!paramBoolean)) {
      j.az(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.amd(this.md5);
    ac.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      ac.i("MicroMsg.UpdaterManager", "update package already exist.");
      aV(1, true);
      asD(str1);
      if ((this.yCt == 2) && (!j.aKg(this.md5))) {
        j.a(this.md5, this.Gmr, this.desc, this.size, this.yCt, this.GkX, this.Gmx);
      }
      AppMethodBeat.o(32776);
      return;
    }
    if (this.Gmw)
    {
      if (this.Gmo != null) {
        this.Gmo.deleteTempFile();
      }
      j.ay(this.mContext, 11);
    }
    if ((!this.Gmw) && (this.Gmu) && (this.Gms != null) && (this.Gmt != null))
    {
      ac.i("MicroMsg.UpdaterManager", "Incresment Update");
      j.ay(this.mContext, 5);
      if (!e.oR(this.size + this.Gmt.size))
      {
        eTq();
        AppMethodBeat.o(32776);
        return;
      }
      cancel();
      int i = this.Gmt.size;
      str1 = this.md5;
      int j = this.GkX;
      String str2 = this.Gms.cHn + this.Gmt.url;
      String str3 = this.Gmt.patchMd5;
      String str4 = this.Gmt.cHq;
      if (this.yCt == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.Gmo = new c(i, str1, j, str2, str3, str4, paramBoolean);
        eTr();
        AppMethodBeat.o(32776);
        return;
      }
    }
    if (!e.oR(this.size))
    {
      ac.e("MicroMsg.UpdaterManager", "SDCard is full");
      eTq();
      AppMethodBeat.o(32776);
      return;
    }
    eTs();
    AppMethodBeat.o(32776);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(32787);
    Iterator localIterator = this.Gmp.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(32787);
  }
  
  public final void aV(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32777);
    this.Gmv = paramBoolean;
    new ao().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32765);
        ((NotificationManager)k.this.mContext.getSystemService("notification")).cancel(99);
        ac.d("MicroMsg.UpdaterManager", "finishType == " + paramInt);
        if ((paramInt == 2) && (k.this.GkX == 1))
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
  
  public final void asD(String paramString)
  {
    AppMethodBeat.i(32786);
    Iterator localIterator = this.Gmp.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).asD(paramString);
    }
    AppMethodBeat.o(32786);
  }
  
  public final boolean bc(Intent paramIntent)
  {
    AppMethodBeat.i(32773);
    boolean bool = bd(paramIntent);
    ac.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      vG(false);
    }
    AppMethodBeat.o(32773);
    return bool;
  }
  
  public final boolean bd(Intent paramIntent)
  {
    AppMethodBeat.i(32774);
    ac.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
    if (paramIntent == null)
    {
      ac.i("MicroMsg.UpdaterManager", "intent == null");
      AppMethodBeat.o(32774);
      return false;
    }
    int j = paramIntent.getIntExtra("intent_update_type", 3);
    int i = paramIntent.getIntExtra("intent_extra_download_mode", 1);
    String str = paramIntent.getStringExtra("intent_extra_md5");
    if ((this.Gmz) && (!str.equalsIgnoreCase(this.md5)) && (this.yCt == 2)) {
      cancel();
    }
    Object localObject;
    while (!this.Gmz)
    {
      j.eTn();
      reset();
      this.intent = paramIntent;
      this.cHa = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.cHc = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.Gmq = paramIntent.getStringArrayExtra("intent_short_ips");
      this.DhK = paramIntent.getIntExtra("intent_client_version", d.DIc);
      d.DIc = this.DhK;
      this.GkX = j;
      this.ikV = paramIntent.getByteArrayExtra("intent_extra_session");
      this.dyZ = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.ikZ = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.md5 = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.Gly = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.yCt = i;
      this.Gmw = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject != null)
      {
        ac.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.Gms = com.tencent.mm.d.i.ed((String)localObject);
      }
      localObject = paramIntent.getStringExtra("intent_extra_extinfo");
      ac.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject });
      if (!bs.isNullOrNil((String)localObject))
      {
        this.Gmx = ((String)bv.L((String)localObject, "extinfo").get(".extinfo.notautodownloadrange"));
        ac.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.Gmx });
      }
      ac.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.Gmz) });
      if ((j != 999) || (this.Gly == null) || (this.Gly.length <= 0)) {
        break;
      }
      if (i == 2) {
        ac.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
      }
      AppMethodBeat.o(32774);
      return true;
    }
    ac.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
    AppMethodBeat.o(32774);
    return true;
    if (this.Gly != null)
    {
      localObject = this.Gly;
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        ac.i("MicroMsg.UpdaterManager", "download url : ".concat(String.valueOf(localObject[i])));
        i += 1;
      }
    }
    ac.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[] { str, Integer.valueOf(this.size) });
    if ((str == null) || (this.size == 0))
    {
      AppMethodBeat.o(32774);
      return false;
    }
    if (j == 2)
    {
      boolean bool = com.tencent.mm.modelcontrol.b.BU(this.Gmx);
      ac.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 78L, 1L, true);
        AppMethodBeat.o(32774);
        return false;
      }
    }
    if (this.Gms != null)
    {
      ac.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject = com.tencent.mm.pluginsdk.g.i.hr(this.mContext);
      this.Gmt = this.Gms.ec((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder("increase apkMD5 = ").append((String)localObject).append(" : ");
      if (this.Gmt == null)
      {
        localObject = "not match";
        ac.i("MicroMsg.UpdaterManager", (String)localObject);
      }
    }
    else
    {
      ac.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.Gmw) });
      this.Gmy = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.Gmt == null) || (com.tencent.mm.sandbox.monitor.c.aKa(str))) && (!this.Gmy)) {
        break label837;
      }
      ac.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.Gmu = true;
    }
    for (;;)
    {
      paramIntent = j.eLy();
      if ((!bs.isNullOrNil(paramIntent)) && (!paramIntent.equals(str))) {
        j.eTo();
      }
      AppMethodBeat.o(32774);
      return true;
      localObject = "match";
      break;
      label837:
      ac.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32778);
    if (this.Gmo != null)
    {
      this.Gmz = false;
      this.Gmo.cancel();
      this.Gmo = null;
      this.GmA = System.currentTimeMillis();
      this.GmB.stop();
    }
    AppMethodBeat.o(32778);
  }
  
  public final void ceI()
  {
    AppMethodBeat.i(210120);
    vG(false);
    AppMethodBeat.o(210120);
  }
  
  public final void dFC()
  {
    AppMethodBeat.i(32785);
    Iterator localIterator = this.Gmp.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).dFC();
    }
    AppMethodBeat.o(32785);
  }
  
  public final void eSX()
  {
    AppMethodBeat.i(32788);
    Iterator localIterator = this.Gmp.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).eSX();
    }
    AppMethodBeat.o(32788);
  }
  
  public final void eSY()
  {
    AppMethodBeat.i(32789);
    Iterator localIterator = this.Gmp.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).eSY();
    }
    AppMethodBeat.o(32789);
  }
  
  public final void eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32784);
    Iterator localIterator = this.Gmp.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).eV(paramInt1, paramInt2);
    }
    AppMethodBeat.o(32784);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32790);
    if ((this.Gmz) || (System.currentTimeMillis() - this.GmA <= UpdaterService.GmJ))
    {
      ac.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.Gmz), Long.valueOf(this.GmA), Long.valueOf(System.currentTimeMillis() - this.GmA) });
      AppMethodBeat.o(32790);
      return true;
    }
    ac.i("MicroMsg.UpdaterManager", "not busy");
    AppMethodBeat.o(32790);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32791);
    ac.i("MicroMsg.UpdaterManager", "onDestroy");
    if (!this.Gmz)
    {
      reset();
      aV(1, true);
    }
    AppMethodBeat.o(32791);
  }
  
  public final void vE(boolean paramBoolean)
  {
    AppMethodBeat.i(32772);
    ac.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g localg = this.GmB;
    if (localg.qKm != paramBoolean)
    {
      localg.vF(true);
      localg.qKm = paramBoolean;
    }
    if ((this.yCt != 2) || (this.Gmz))
    {
      ac.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.yCt), Boolean.valueOf(this.Gmz) });
      AppMethodBeat.o(32772);
      return;
    }
    if (paramBoolean)
    {
      if (bd(this.intent))
      {
        vG(true);
        AppMethodBeat.o(32772);
      }
    }
    else if (this.Gmz) {
      cancel();
    }
    AppMethodBeat.o(32772);
  }
  
  static final class a
  {
    public static final k GmG;
    
    static
    {
      AppMethodBeat.i(32770);
      GmG = new k((byte)0);
      AppMethodBeat.o(32770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */