package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.c.i.a;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class j
  implements a, g
{
  public String bIW;
  public int bQo = d.spa;
  public int bvl;
  public String bvn;
  public byte[] cbM;
  public String desc;
  public byte[] eNt;
  public byte[] eNv;
  private Intent intent = null;
  protected Context mContext = null;
  public int oRr;
  private Notification pAt = null;
  public int size;
  public int ubR;
  public String[] ucs;
  com.tencent.mm.sandbox.monitor.c udj = null;
  ArrayList<g> udk = new ArrayList(1);
  public String[] udl;
  public String udm;
  public com.tencent.mm.c.i udn;
  public i.a udo;
  public boolean udp = false;
  public boolean udq = false;
  public boolean udr = false;
  public String uds;
  public boolean udt = false;
  boolean udu = false;
  long udv;
  f udw = new f(this);
  private long udx = -1L;
  private b.a udy = new b.a()
  {
    public final void b(int paramAnonymousInt1, int paramAnonymousInt2, bly paramAnonymousbly)
    {
      j.this.udu = false;
      j.this.udw.stop();
      j.this.udv = System.currentTimeMillis();
      if (j.this.udj == null)
      {
        j.this.an(2, true);
        return;
      }
      if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
      {
        y.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
        if (j.this.oRr != 2) {
          j.a(j.this, 100, 100);
        }
        if (j.this.udp)
        {
          i.ae(j.this.mContext, 0);
          paramAnonymousbly = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "yyb_pkg_sig_prefs", 4);
          j.this.udm = paramAnonymousbly.getString(ae.getPackageName(), "");
          y.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { j.this.udm, j.this.udj.cpF() });
          if (bk.bl(j.this.udm)) {
            break label432;
          }
        }
        for (;;)
        {
          try
          {
            com.tencent.mm.c.c.c(new File(j.this.udj.cpF()), j.this.udm);
            y.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
            com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 6L, 1L, false);
            com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4006), j.this.udm });
            if (j.this.oRr != 1) {
              break label471;
            }
            i.af(j.this.mContext, 8);
            j.a(j.this);
            j.this.Op(j.this.udj.cpF());
            if (j.this.udt)
            {
              com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 58L, 1L, false);
              y.d("MicroMsg.UpdaterManager", "boots download success.");
            }
            i.cqa();
            return;
            i.ae(j.this.mContext, 9);
          }
          catch (Exception paramAnonymousbly)
          {
            y.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymousbly.getMessage());
            com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 7L, 1L, false);
            com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4007), paramAnonymousbly.getMessage() });
            continue;
          }
          label432:
          com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 8L, 1L, false);
          com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4008) });
          continue;
          label471:
          if (j.this.oRr == 0)
          {
            j.this.Op(j.this.udj.cpF());
          }
          else if (j.this.oRr == 2)
          {
            i.af(j.this.mContext, 1);
            j.a(j.this);
          }
        }
      }
      if (paramAnonymousInt2 == -13)
      {
        y.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
        UpdaterService.dx();
        AppUpdaterUI.cpJ();
        i.cpZ();
        return;
      }
      if (((j.this.udj instanceof c)) && (j.this.ubR != 4))
      {
        y.e("MicroMsg.UpdaterManager", "download package from cdn error.");
        if (j.this.udp)
        {
          if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
            i.ae(j.this.mContext, paramAnonymousInt1);
          }
          j.this.udp = false;
          if (j.this.oRr == 1) {
            if (j.this.udt)
            {
              y.d("MicroMsg.UpdaterManager", "boots download failed. %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              switch (paramAnonymousInt1)
              {
              }
            }
          }
        }
      }
      for (;;)
      {
        j.this.a(j.this.udj);
        return;
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 52L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 53L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 54L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 51L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 55L, 1L, false);
        continue;
        j.b(j.this);
        continue;
        if (j.this.oRr == 0)
        {
          j.this.an(1, true);
        }
        else if (j.this.oRr == 2)
        {
          j.c(j.this);
          continue;
          paramAnonymousbly = j.this;
          paramAnonymousInt1 = j.this.size;
          String str = j.this.bIW;
          paramAnonymousInt2 = j.this.ubR;
          int i = j.this.uin;
          byte[] arrayOfByte1 = j.this.eNt;
          byte[] arrayOfByte2 = j.this.cbM;
          String[] arrayOfString = j.this.udl;
          if (j.this.oRr == 2) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousbly.udj = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
            j.d(j.this);
            break;
          }
          y.e("MicroMsg.UpdaterManager", "update failed");
          i.ae(j.this.mContext, 10);
          if (j.this.oRr == 1) {
            j.e(j.this);
          } else if (j.this.oRr == 0) {
            j.this.an(1, true);
          }
        }
      }
    }
    
    public final void cy(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      y.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      if (j.this.oRr != 2) {
        j.a(j.this, paramAnonymousInt2, paramAnonymousInt1);
      }
      j.this.cy(paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public final void hm(long paramAnonymousLong)
    {
      f localf = j.this.udw;
      localf.byQ.post(new f.2(localf, paramAnonymousLong));
    }
    
    public final void hn(long paramAnonymousLong)
    {
      f localf = j.this.udw;
      localf.byQ.post(new f.3(localf, paramAnonymousLong));
    }
  };
  public int uin;
  
  private void cqd()
  {
    MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bk.UX() - 86400L).commit();
    an(2, true);
    cpM();
  }
  
  private void cqe()
  {
    if ((this.oRr == 2) && (!aq.isWifi(this.mContext)))
    {
      i.cpY();
      y.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
    }
    do
    {
      do
      {
        return;
        if ((this.oRr == 2) && (f.YN(this.bIW)))
        {
          y.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
          this.udw.stop();
          return;
        }
        this.udw.dm(this.bIW, this.size);
      } while (this.udj == null);
      an(1, false);
      this.udu = true;
      this.udj.a(this.udy);
      bFl();
    } while (this.oRr != 2);
    i.cpY();
  }
  
  private void cqf()
  {
    cancel();
    y.i("MicroMsg.UpdaterManager", "downloadFullPack");
    i.ae(this.mContext, 7);
    if ((this.ucs != null) && (this.ucs.length > 0))
    {
      i = this.size;
      str = this.bIW;
      j = this.ubR;
      localObject = this.ucs;
      if (this.oRr == 2) {}
      for (bool = true;; bool = false)
      {
        this.udj = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 76L, 1L, true);
        cqe();
        return;
      }
    }
    int i = this.size;
    String str = this.bIW;
    int j = this.ubR;
    int k = this.uin;
    Object localObject = this.eNt;
    byte[] arrayOfByte = this.cbM;
    String[] arrayOfString = this.udl;
    if (this.oRr == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.udj = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void mq(boolean paramBoolean)
  {
    boolean bool = true;
    y.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    y.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.oRr), Boolean.valueOf(this.udu) });
    if (this.intent == null) {
      y.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
    }
    String str1;
    do
    {
      return;
      if (this.udu)
      {
        y.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
        return;
      }
      if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
      {
        y.e("MicroMsg.UpdaterManager", "no sdcard.");
        MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bk.UX() - 86400L).commit();
        an(2, true);
        cpL();
        return;
      }
      if ((this.oRr == 2) && (!paramBoolean)) {
        i.af(this.mContext, 0);
      }
      str1 = com.tencent.mm.sandbox.monitor.c.Iq(this.bIW);
      y.i("MicroMsg.UpdaterManager", str1);
      if (str1 == null) {
        break;
      }
      y.i("MicroMsg.UpdaterManager", "update package already exist.");
      an(1, true);
      Op(str1);
    } while ((this.oRr != 2) || (i.YO(this.bIW)));
    i.a(this.bIW, this.udm, this.desc, this.size, this.oRr, this.ubR, this.uds);
    return;
    if (this.udr)
    {
      if (this.udj != null) {
        this.udj.deleteTempFile();
      }
      i.ae(this.mContext, 11);
    }
    if ((!this.udr) && (this.udp) && (this.udn != null) && (this.udo != null))
    {
      y.i("MicroMsg.UpdaterManager", "Incresment Update");
      i.ae(this.mContext, 5);
      if (!com.tencent.mm.compatible.util.f.bs(this.size + this.udo.size))
      {
        cqd();
        return;
      }
      cancel();
      int i = this.udo.size;
      str1 = this.bIW;
      int j = this.ubR;
      String str2 = this.udn.bvy + this.udo.url;
      String str3 = this.udo.bvC;
      String str4 = this.udo.bvB;
      if (this.oRr == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.udj = new c(i, str1, j, str2, str3, str4, paramBoolean);
        cqe();
        return;
      }
    }
    if (!com.tencent.mm.compatible.util.f.bs(this.size))
    {
      y.e("MicroMsg.UpdaterManager", "SDCard is full");
      cqd();
      return;
    }
    cqf();
  }
  
  private void reset()
  {
    cancel();
    this.bvl = 0;
    this.bvn = null;
    this.udl = null;
    this.bQo = d.spa;
    this.ubR = 0;
    this.eNt = null;
    this.cbM = null;
    this.eNv = null;
    this.uin = 0;
    this.bIW = null;
    this.size = 0;
    this.desc = null;
    this.ucs = null;
    this.udn = null;
    this.udo = null;
    this.udp = false;
    this.udq = false;
    this.oRr = 0;
    this.udr = false;
    this.intent = null;
    this.udu = false;
    this.pAt = null;
    this.udx = 0L;
  }
  
  public final void Op(String paramString)
  {
    Iterator localIterator = this.udk.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).Op(paramString);
    }
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    Iterator localIterator = this.udk.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramc);
    }
  }
  
  public final boolean aj(Intent paramIntent)
  {
    boolean bool = ak(paramIntent);
    y.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      mq(false);
    }
    return bool;
  }
  
  public final boolean ak(Intent paramIntent)
  {
    boolean bool2 = true;
    y.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
    boolean bool1;
    if (paramIntent == null)
    {
      y.i("MicroMsg.UpdaterManager", "intent == null");
      bool1 = false;
      return bool1;
    }
    int j = paramIntent.getIntExtra("intent_update_type", 3);
    int i = paramIntent.getIntExtra("intent_extra_download_mode", 1);
    String str = paramIntent.getStringExtra("intent_extra_md5");
    if ((this.udu) && (!str.equalsIgnoreCase(this.bIW)) && (this.oRr == 2)) {
      cancel();
    }
    Object localObject1;
    while (!this.udu)
    {
      i.cqa();
      reset();
      this.intent = paramIntent;
      this.bvl = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.bvn = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.udl = paramIntent.getStringArrayExtra("intent_short_ips");
      this.bQo = paramIntent.getIntExtra("intent_client_version", d.spa);
      d.spa = this.bQo;
      this.ubR = j;
      this.eNt = paramIntent.getByteArrayExtra("intent_extra_session");
      this.cbM = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.eNv = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.bIW = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.ucs = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.oRr = i;
      this.udr = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject1 = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject1 != null)
      {
        y.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.udn = com.tencent.mm.c.i.cf((String)localObject1);
      }
      localObject1 = paramIntent.getStringExtra("intent_extra_extinfo");
      y.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject1 });
      if (!bk.bl((String)localObject1))
      {
        this.uds = ((String)bn.s((String)localObject1, "extinfo").get(".extinfo.notautodownloadrange"));
        y.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.uds });
      }
      y.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.udu) });
      if ((j != 999) || (this.ucs == null) || (this.ucs.length <= 0)) {
        break label463;
      }
      bool1 = bool2;
      if (i != 2) {
        break;
      }
      y.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
      return true;
    }
    y.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
    return true;
    label463:
    Object localObject2;
    if (this.ucs != null)
    {
      localObject1 = this.ucs;
      int k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        y.i("MicroMsg.UpdaterManager", "download url : " + (String)localObject2);
        i += 1;
      }
    }
    y.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[] { str, Integer.valueOf(this.size) });
    if ((str == null) || (this.size == 0)) {
      return false;
    }
    if (j == 2)
    {
      bool1 = com.tencent.mm.modelcontrol.b.lO(this.uds);
      y.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 78L, 1L, true);
        return false;
      }
    }
    if (this.udn != null)
    {
      y.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject1 = com.tencent.mm.pluginsdk.f.i.eU(this.mContext);
      this.udo = this.udn.ce((String)localObject1);
      localObject2 = new StringBuilder("increase apkMD5 = ").append((String)localObject1).append(" : ");
      if (this.udo == null)
      {
        localObject1 = "not match";
        label697:
        y.i("MicroMsg.UpdaterManager", (String)localObject1);
      }
    }
    else
    {
      y.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.udr) });
      this.udt = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.udo == null) || (com.tencent.mm.sandbox.monitor.c.YL(str))) && (!this.udt)) {
        break label825;
      }
      y.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.udp = true;
    }
    for (;;)
    {
      paramIntent = i.cli();
      bool1 = bool2;
      if (bk.bl(paramIntent)) {
        break;
      }
      bool1 = bool2;
      if (paramIntent.equals(str)) {
        break;
      }
      i.cqb();
      return true;
      localObject1 = "match";
      break label697;
      label825:
      y.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void an(final int paramInt, boolean paramBoolean)
  {
    this.udq = paramBoolean;
    new ah().postDelayed(new Runnable()
    {
      public final void run()
      {
        ((NotificationManager)j.this.mContext.getSystemService("notification")).cancel(99);
        y.d("MicroMsg.UpdaterManager", "finishType == " + paramInt);
        if ((paramInt == 2) && (j.this.ubR == 1))
        {
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
          j.this.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        }
      }
    }, 300L);
  }
  
  public final void bFl()
  {
    Iterator localIterator = this.udk.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).bFl();
    }
  }
  
  public final void cancel()
  {
    if (this.udj != null)
    {
      this.udu = false;
      this.udj.cancel();
      this.udj = null;
      this.udv = System.currentTimeMillis();
      this.udw.stop();
    }
  }
  
  public final void cpL()
  {
    Iterator localIterator = this.udk.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cpL();
    }
  }
  
  public final void cpM()
  {
    Iterator localIterator = this.udk.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cpM();
    }
  }
  
  public final void cqc()
  {
    mq(false);
  }
  
  public final void cy(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.udk.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cy(paramInt1, paramInt2);
    }
  }
  
  public final boolean isBusy()
  {
    if ((this.udu) || (System.currentTimeMillis() - this.udv <= UpdaterService.udE))
    {
      y.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.udu), Long.valueOf(this.udv), Long.valueOf(System.currentTimeMillis() - this.udv) });
      return true;
    }
    y.i("MicroMsg.UpdaterManager", "not busy");
    return false;
  }
  
  public final void mo(boolean paramBoolean)
  {
    y.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    f localf = this.udw;
    if (localf.kaC != paramBoolean)
    {
      localf.mp(true);
      localf.kaC = paramBoolean;
    }
    if ((this.oRr != 2) || (this.udu)) {
      y.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.oRr), Boolean.valueOf(this.udu) });
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (!ak(this.intent));
      mq(true);
      return;
    } while (!this.udu);
    cancel();
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.UpdaterManager", "onDestroy");
    if (!this.udu)
    {
      reset();
      an(1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.j
 * JD-Core Version:    0.7.0.1
 */