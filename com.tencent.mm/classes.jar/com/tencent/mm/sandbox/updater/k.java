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
import com.tencent.mm.protocal.protobuf.dpc;
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
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class k
  implements a, h
{
  public int EtH;
  public String[] NEQ;
  public int NEo;
  com.tencent.mm.sandbox.monitor.c NFH;
  ArrayList<h> NFI;
  public String[] NFJ;
  public String NFK;
  public i NFL;
  public i.a NFM;
  public boolean NFN;
  public boolean NFO;
  public boolean NFP;
  public String NFQ;
  public boolean NFR;
  boolean NFS;
  long NFT;
  g NFU;
  private long NFV;
  private b.a NFW;
  public String desc;
  public String djj;
  public byte[] ees;
  private Intent intent;
  public byte[] jDo;
  public byte[] jDs;
  public int jjS;
  private Notification kYy;
  protected Context mContext;
  public String md5;
  public int size;
  public int uin;
  public int updateMode;
  
  private k()
  {
    AppMethodBeat.i(32771);
    this.NFH = null;
    this.NFI = new ArrayList(1);
    this.jjS = d.KyO;
    this.NFN = false;
    this.NFO = false;
    this.NFP = false;
    this.NFR = false;
    this.NFS = false;
    this.intent = null;
    this.kYy = null;
    this.mContext = null;
    this.NFU = new g(this);
    this.NFV = -1L;
    this.NFW = new b.a()
    {
      public final void MC(long paramAnonymousLong)
      {
        AppMethodBeat.i(32768);
        g localg = k.this.NFU;
        localg.timer.post(new g.2(localg, paramAnonymousLong));
        AppMethodBeat.o(32768);
      }
      
      public final void MD(long paramAnonymousLong)
      {
        AppMethodBeat.i(32769);
        g localg = k.this.NFU;
        localg.timer.post(new g.3(localg, paramAnonymousLong));
        AppMethodBeat.o(32769);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, dpc paramAnonymousdpc)
      {
        AppMethodBeat.i(32767);
        k.this.NFS = false;
        k.this.NFU.stop();
        k.this.NFT = System.currentTimeMillis();
        if (k.this.NFH == null)
        {
          k.this.bC(2, true);
          AppMethodBeat.o(32767);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (k.this.EtH != 2) {
            k.a(k.this, 100, 100);
          }
          if (k.this.NFN)
          {
            j.aK(k.this.mContext, 0);
            paramAnonymousdpc = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aps());
            k.this.NFK = paramAnonymousdpc.getString(MMApplicationContext.getPackageName(), "");
            Log.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { k.this.NFK, k.this.NFH.gvY() });
            if ((Util.isNullOrNil(k.this.NFK)) || (BuildInfo.IS_FLAVOR_RED)) {
              break label462;
            }
          }
          for (;;)
          {
            try
            {
              com.tencent.mm.d.c.g(new File(s.k(k.this.NFH.gvY(), true)), k.this.NFK);
              Log.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4006), k.this.NFK });
              if (k.this.EtH != 1) {
                break label501;
              }
              j.aL(k.this.mContext, 8);
              k.a(k.this);
              k.this.aNH(k.this.NFH.gvY());
              if (k.this.NFR)
              {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 58L, 1L, false);
                Log.d("MicroMsg.UpdaterManager", "boots download success.");
              }
              j.gwu();
              AppMethodBeat.o(32767);
              return;
              j.aK(k.this.mContext, 9);
            }
            catch (Exception paramAnonymousdpc)
            {
              Log.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymousdpc.getMessage());
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4007), paramAnonymousdpc.getMessage() });
              continue;
            }
            label462:
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4008) });
            continue;
            label501:
            if (k.this.EtH == 0)
            {
              k.this.aNH(k.this.NFH.gvY());
            }
            else if (k.this.EtH == 2)
            {
              j.aL(k.this.mContext, 1);
              k.a(k.this);
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          Log.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.fK();
          AppUpdaterUI.gwc();
          j.gwt();
          AppMethodBeat.o(32767);
          return;
        }
        if (((k.this.NFH instanceof c)) && (k.this.NEo != 4))
        {
          Log.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (k.this.NFN)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              j.aK(k.this.mContext, paramAnonymousInt1);
            }
            k.this.NFN = false;
            if (k.this.EtH == 1) {
              if (k.this.NFR)
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
          k.this.a(k.this.NFH);
          AppMethodBeat.o(32767);
          return;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 55L, 1L, false);
          continue;
          k.b(k.this);
          continue;
          if (k.this.EtH == 0)
          {
            k.this.bC(1, true);
          }
          else if (k.this.EtH == 2)
          {
            k.c(k.this);
            continue;
            paramAnonymousdpc = k.this;
            paramAnonymousInt1 = k.this.size;
            String str = k.this.md5;
            paramAnonymousInt2 = k.this.NEo;
            int i = k.this.uin;
            byte[] arrayOfByte1 = k.this.jDo;
            byte[] arrayOfByte2 = k.this.ees;
            String[] arrayOfString = k.this.NFJ;
            if (k.this.EtH == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousdpc.NFH = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              k.d(k.this);
              break;
            }
            Log.e("MicroMsg.UpdaterManager", "update failed");
            j.aK(k.this.mContext, 10);
            if (k.this.EtH == 1) {
              k.e(k.this);
            } else if (k.this.EtH == 0) {
              k.this.bC(1, true);
            }
          }
        }
      }
      
      public final void fn(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32766);
        Log.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (k.this.EtH != 2) {
          k.a(k.this, paramAnonymousInt2, paramAnonymousInt1);
        }
        k.this.fn(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32766);
      }
    };
    this.mContext = MMApplicationContext.getContext();
    AppMethodBeat.o(32771);
  }
  
  private void AA(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(32776);
    Log.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.EtH), Boolean.valueOf(this.NFS) });
    if (this.intent == null)
    {
      Log.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      AppMethodBeat.o(32776);
      return;
    }
    if (this.NFS)
    {
      Log.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      AppMethodBeat.o(32776);
      return;
    }
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      Log.e("MicroMsg.UpdaterManager", "no sdcard.");
      gww();
      AppMethodBeat.o(32776);
      return;
    }
    if ((this.EtH == 2) && (!paramBoolean)) {
      j.aL(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.aFr(this.md5);
    Log.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      Log.i("MicroMsg.UpdaterManager", "update package already exist.");
      bC(1, true);
      aNH(str1);
      if ((this.EtH == 2) && (!j.bhM(this.md5))) {
        j.a(this.md5, this.NFK, this.desc, this.size, this.EtH, this.NEo, this.NFQ);
      }
      AppMethodBeat.o(32776);
      return;
    }
    if (this.NFP)
    {
      if (this.NFH != null) {
        this.NFH.deleteTempFile();
      }
      j.aK(this.mContext, 11);
    }
    if ((!this.NFP) && (this.NFN) && (this.NFL != null) && (this.NFM != null))
    {
      Log.i("MicroMsg.UpdaterManager", "Incresment Update");
      j.aK(this.mContext, 5);
      if (!e.yV(this.size + this.NFM.size))
      {
        gwx();
        AppMethodBeat.o(32776);
        return;
      }
      cancel();
      int i = this.NFM.size;
      str1 = this.md5;
      int j = this.NEo;
      String str2 = this.NFL.djt + this.NFM.url;
      String str3 = this.NFM.patchMd5;
      String str4 = this.NFM.djw;
      if (this.EtH == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.NFH = new c(i, str1, j, str2, str3, str4, paramBoolean);
        gwy();
        AppMethodBeat.o(32776);
        return;
      }
    }
    if (!e.yV(this.size))
    {
      Log.e("MicroMsg.UpdaterManager", "SDCard is full");
      gwx();
      AppMethodBeat.o(32776);
      return;
    }
    gwz();
    AppMethodBeat.o(32776);
  }
  
  private void gww()
  {
    AppMethodBeat.i(32780);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L).commit();
    bC(2, true);
    gwe();
    AppMethodBeat.o(32780);
  }
  
  private void gwx()
  {
    AppMethodBeat.i(32781);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L).commit();
    bC(2, true);
    gwf();
    AppMethodBeat.o(32781);
  }
  
  private void gwy()
  {
    AppMethodBeat.i(32782);
    if ((this.EtH == 2) && (!NetStatusUtil.isWifi(this.mContext)))
    {
      j.gws();
      Log.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      AppMethodBeat.o(32782);
      return;
    }
    if ((this.EtH == 2) && (g.bhL(this.md5)))
    {
      Log.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.NFU.stop();
      AppMethodBeat.o(32782);
      return;
    }
    this.NFU.gM(this.md5, this.size);
    if (this.NFH != null)
    {
      bC(1, false);
      this.NFS = true;
      this.NFH.a(this.NFW);
      eWN();
      if (this.EtH == 2) {
        j.gws();
      }
    }
    AppMethodBeat.o(32782);
  }
  
  private void gwz()
  {
    AppMethodBeat.i(32783);
    cancel();
    Log.i("MicroMsg.UpdaterManager", "downloadFullPack");
    j.aK(this.mContext, 7);
    if ((this.NEQ != null) && (this.NEQ.length > 0))
    {
      i = this.size;
      str = this.md5;
      j = this.NEo;
      localObject = this.NEQ;
      if (this.EtH == 2) {}
      for (bool = true;; bool = false)
      {
        this.NFH = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 76L, 1L, true);
        gwy();
        AppMethodBeat.o(32783);
        return;
      }
    }
    int i = this.size;
    String str = this.md5;
    int j = this.NEo;
    int k = this.uin;
    Object localObject = this.jDo;
    byte[] arrayOfByte = this.ees;
    String[] arrayOfString = this.NFJ;
    if (this.EtH == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.NFH = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(32779);
    cancel();
    this.updateMode = 0;
    this.djj = null;
    this.NFJ = null;
    this.jjS = d.KyO;
    this.NEo = 0;
    this.jDo = null;
    this.ees = null;
    this.jDs = null;
    this.uin = 0;
    this.md5 = null;
    this.size = 0;
    this.desc = null;
    this.NEQ = null;
    this.NFL = null;
    this.NFM = null;
    this.NFN = false;
    this.NFO = false;
    this.EtH = 0;
    this.NFP = false;
    this.intent = null;
    this.NFS = false;
    this.kYy = null;
    this.NFV = 0L;
    AppMethodBeat.o(32779);
  }
  
  public final void Ay(boolean paramBoolean)
  {
    AppMethodBeat.i(32772);
    Log.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g localg = this.NFU;
    if (localg.tcf != paramBoolean)
    {
      localg.Az(true);
      localg.tcf = paramBoolean;
    }
    if ((this.EtH != 2) || (this.NFS))
    {
      Log.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.EtH), Boolean.valueOf(this.NFS) });
      AppMethodBeat.o(32772);
      return;
    }
    if (paramBoolean)
    {
      if (bv(this.intent))
      {
        AA(true);
        AppMethodBeat.o(32772);
      }
    }
    else if (this.NFS) {
      cancel();
    }
    AppMethodBeat.o(32772);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(32787);
    Iterator localIterator = this.NFI.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(32787);
  }
  
  public final void aNH(String paramString)
  {
    AppMethodBeat.i(32786);
    Iterator localIterator = this.NFI.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).aNH(paramString);
    }
    AppMethodBeat.o(32786);
  }
  
  public final void bC(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32777);
    this.NFO = paramBoolean;
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32765);
        ((NotificationManager)k.this.mContext.getSystemService("notification")).cancel(99);
        Log.d("MicroMsg.UpdaterManager", "finishType == " + paramInt);
        if ((paramInt == 2) && (k.this.NEo == 1))
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
      AA(false);
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
    if ((this.NFS) && (!str.equalsIgnoreCase(this.md5)) && (this.EtH == 2)) {
      cancel();
    }
    Object localObject;
    while (!this.NFS)
    {
      j.gwu();
      reset();
      this.intent = paramIntent;
      this.updateMode = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.djj = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.NFJ = paramIntent.getStringArrayExtra("intent_short_ips");
      this.jjS = paramIntent.getIntExtra("intent_client_version", d.KyO);
      d.KyO = this.jjS;
      this.NEo = j;
      this.jDo = paramIntent.getByteArrayExtra("intent_extra_session");
      this.ees = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.jDs = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.md5 = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.NEQ = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.EtH = i;
      this.NFP = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject != null)
      {
        Log.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.NFL = i.fR((String)localObject);
      }
      localObject = paramIntent.getStringExtra("intent_extra_extinfo");
      Log.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject });
      if (!Util.isNullOrNil((String)localObject))
      {
        this.NFQ = ((String)XmlParser.parseXml((String)localObject, "extinfo", null).get(".extinfo.notautodownloadrange"));
        Log.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.NFQ });
      }
      Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.NFS) });
      if ((j != 999) || (this.NEQ == null) || (this.NEQ.length <= 0)) {
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
    if (this.NEQ != null)
    {
      localObject = this.NEQ;
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
      boolean bool = com.tencent.mm.modelcontrol.b.Of(this.NFQ);
      Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 78L, 1L, true);
        AppMethodBeat.o(32774);
        return false;
      }
    }
    if (this.NFL != null)
    {
      Log.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject = com.tencent.mm.pluginsdk.i.g.iw(this.mContext);
      this.NFM = this.NFL.fQ((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder("increase apkMD5 = ").append((String)localObject).append(" : ");
      if (this.NFM == null)
      {
        localObject = "not match";
        Log.i("MicroMsg.UpdaterManager", (String)localObject);
      }
    }
    else
    {
      Log.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.NFP) });
      this.NFR = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.NFM == null) || (com.tencent.mm.sandbox.monitor.c.bhG(str))) && (!this.NFR)) {
        break label823;
      }
      Log.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.NFN = true;
    }
    for (;;)
    {
      paramIntent = j.gnt();
      if ((!Util.isNullOrNil(paramIntent)) && (!paramIntent.equals(str))) {
        j.gwv();
      }
      AppMethodBeat.o(32774);
      return true;
      localObject = "match";
      break;
      label823:
      Log.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void cID()
  {
    AppMethodBeat.i(258256);
    AA(false);
    AppMethodBeat.o(258256);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32778);
    if (this.NFH != null)
    {
      this.NFS = false;
      this.NFH.cancel();
      this.NFH = null;
      this.NFT = System.currentTimeMillis();
      this.NFU.stop();
    }
    AppMethodBeat.o(32778);
  }
  
  public final void eWN()
  {
    AppMethodBeat.i(32785);
    Iterator localIterator = this.NFI.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).eWN();
    }
    AppMethodBeat.o(32785);
  }
  
  public final void fn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32784);
    Iterator localIterator = this.NFI.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).fn(paramInt1, paramInt2);
    }
    AppMethodBeat.o(32784);
  }
  
  public final void gwe()
  {
    AppMethodBeat.i(32788);
    Iterator localIterator = this.NFI.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).gwe();
    }
    AppMethodBeat.o(32788);
  }
  
  public final void gwf()
  {
    AppMethodBeat.i(32789);
    Iterator localIterator = this.NFI.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).gwf();
    }
    AppMethodBeat.o(32789);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32790);
    if ((this.NFS) || (System.currentTimeMillis() - this.NFT <= UpdaterService.NGc))
    {
      Log.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.NFS), Long.valueOf(this.NFT), Long.valueOf(System.currentTimeMillis() - this.NFT) });
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
    if (!this.NFS)
    {
      reset();
      bC(1, true);
    }
    AppMethodBeat.o(32791);
  }
  
  static final class a
  {
    public static final k NFZ;
    
    static
    {
      AppMethodBeat.i(32770);
      NFZ = new k((byte)0);
      AppMethodBeat.o(32770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */