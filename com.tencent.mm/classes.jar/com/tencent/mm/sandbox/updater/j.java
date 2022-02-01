package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.d.h.a;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class j
  implements a, h
{
  public int RgE;
  public int acmZ;
  public String[] acnB;
  public String acoA;
  public boolean acoB;
  boolean acoC;
  long acoD;
  g acoE;
  private long acoF;
  private b.a acoG;
  com.tencent.mm.sandbox.monitor.c acos;
  public String[] acot;
  public String acou;
  public com.tencent.mm.d.h acov;
  public h.a acow;
  public boolean acox;
  public boolean acoy;
  public boolean acoz;
  ArrayList<h> delegates;
  public String desc;
  public String heq;
  public byte[] ieJ;
  private Intent intent;
  protected Context mContext;
  public String md5;
  public byte[] pnl;
  public byte[] pnp;
  private Notification qSv;
  public int qvp;
  public int size;
  public int uin;
  public int updateMode;
  
  private j()
  {
    AppMethodBeat.i(32771);
    this.acos = null;
    this.delegates = new ArrayList(1);
    this.qvp = com.tencent.mm.protocal.d.Yxh;
    this.acox = false;
    this.acoy = false;
    this.acoz = false;
    this.acoB = false;
    this.acoC = false;
    this.intent = null;
    this.qSv = null;
    this.mContext = null;
    this.acoE = new g(this);
    this.acoF = -1L;
    this.acoG = new b.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, esc paramAnonymousesc)
      {
        AppMethodBeat.i(32767);
        j.this.acoC = false;
        j.this.acoE.stop();
        j.this.acoD = System.currentTimeMillis();
        if (j.this.acos == null)
        {
          j.this.cx(2, true);
          AppMethodBeat.o(32767);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (j.this.RgE != 2) {
            j.a(j.this, 100, 100);
          }
          if (j.this.acox)
          {
            i.bv(j.this.mContext, 0);
            paramAnonymousesc = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aQe());
            j.this.acou = paramAnonymousesc.getString(MMApplicationContext.getPackageName(), "");
            Log.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { j.this.acou, j.this.acos.iSd() });
            if ((Util.isNullOrNil(j.this.acou)) || (BuildInfo.IS_FLAVOR_RED)) {}
          }
          else
          {
            try
            {
              paramAnonymousesc = y.n(j.this.acos.iSd(), true);
              if ((!MMApplicationContext.getContext().getPackageName().equalsIgnoreCase(MMApplicationContext.getPackageName())) || (com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_appcompat_pkg_sig", "0", false, true).equals("1"))) {
                break label433;
              }
              Log.i("MicroMsg.UpdaterManager", "Skip writing apkSig for v2 signing, pkg = " + MMApplicationContext.getPackageName());
              label277:
              Log.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4006), j.this.acou });
            }
            catch (Exception paramAnonymousesc)
            {
              for (;;)
              {
                label330:
                Log.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymousesc.getMessage());
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 7L, 1L, false);
                com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4007), paramAnonymousesc.getMessage() });
              }
            }
            if (j.this.RgE != 1) {
              break label564;
            }
            i.bw(j.this.mContext, 8);
            j.a(j.this);
            j.this.aWn(j.this.acos.iSd());
            if (j.this.acoB)
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 58L, 1L, false);
              Log.d("MicroMsg.UpdaterManager", "boots download success.");
            }
          }
          for (;;)
          {
            i.iSy();
            AppMethodBeat.o(32767);
            return;
            i.bv(j.this.mContext, 9);
            break;
            label433:
            com.tencent.mm.d.c.h(new File(paramAnonymousesc), j.this.acou);
            break label277;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4008) });
            break label330;
            label564:
            if (j.this.RgE == 0)
            {
              j.this.aWn(j.this.acos.iSd());
            }
            else if (j.this.RgE == 2)
            {
              i.bw(j.this.mContext, 1);
              j.a(j.this);
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          Log.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.Fc();
          AppUpdaterUI.iSh();
          i.iSx();
          AppMethodBeat.o(32767);
          return;
        }
        if (((j.this.acos instanceof c)) && (j.this.acmZ != 4))
        {
          Log.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (j.this.acox)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              i.bv(j.this.mContext, paramAnonymousInt1);
            }
            j.this.acox = false;
            if (j.this.RgE == 1) {
              if (j.this.acoB)
              {
                Log.d("MicroMsg.UpdaterManager", "isTinkerPatch boots download failed. %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
                switch (paramAnonymousInt1)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          j.this.a(j.this.acos);
          AppMethodBeat.o(32767);
          return;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 55L, 1L, false);
          continue;
          j.b(j.this);
          continue;
          if (j.this.RgE == 0)
          {
            j.this.cx(1, true);
          }
          else if (j.this.RgE == 2)
          {
            j.c(j.this);
            continue;
            paramAnonymousesc = j.this;
            paramAnonymousInt1 = j.this.size;
            String str = j.this.md5;
            paramAnonymousInt2 = j.this.acmZ;
            int i = j.this.uin;
            byte[] arrayOfByte1 = j.this.pnl;
            byte[] arrayOfByte2 = j.this.ieJ;
            String[] arrayOfString = j.this.acot;
            if (j.this.RgE == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousesc.acos = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              j.d(j.this);
              break;
            }
            Log.e("MicroMsg.UpdaterManager", "update failed");
            i.bv(j.this.mContext, 10);
            if (j.this.RgE == 1) {
              j.e(j.this);
            } else if (j.this.RgE == 0) {
              j.this.cx(1, true);
            }
          }
        }
      }
      
      public final void onProgress(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32766);
        Log.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (j.this.RgE != 2) {
          j.a(j.this, paramAnonymousInt2, paramAnonymousInt1);
        }
        j.this.onProgress(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32766);
      }
      
      public final void yw(long paramAnonymousLong)
      {
        AppMethodBeat.i(32768);
        g localg = j.this.acoE;
        localg.timer.post(new g.2(localg, paramAnonymousLong));
        AppMethodBeat.o(32768);
      }
      
      public final void yx(long paramAnonymousLong)
      {
        AppMethodBeat.i(32769);
        g localg = j.this.acoE;
        localg.timer.post(new g.3(localg, paramAnonymousLong));
        AppMethodBeat.o(32769);
      }
    };
    this.mContext = MMApplicationContext.getContext();
    AppMethodBeat.o(32771);
  }
  
  private void Kt(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(32776);
    Log.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.RgE), Boolean.valueOf(this.acoC) });
    if (this.intent == null)
    {
      Log.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      AppMethodBeat.o(32776);
      return;
    }
    if (this.acoC)
    {
      Log.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      AppMethodBeat.o(32776);
      return;
    }
    if (!com.tencent.mm.compatible.util.g.aQd().equals("mounted"))
    {
      Log.e("MicroMsg.UpdaterManager", "no sdcard.");
      iSA();
      AppMethodBeat.o(32776);
      return;
    }
    if ((this.RgE == 2) && (!paramBoolean)) {
      i.bw(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.aMz(this.md5);
    Log.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      Log.i("MicroMsg.UpdaterManager", "update package already exist.");
      cx(1, true);
      aWn(str1);
      if ((this.RgE == 2) && (!i.bud(this.md5))) {
        i.a(this.md5, this.acou, this.desc, this.size, this.RgE, this.acmZ, this.acoA);
      }
      AppMethodBeat.o(32776);
      return;
    }
    if (this.acoz)
    {
      if (this.acos != null) {
        this.acos.deleteTempFile();
      }
      i.bv(this.mContext, 11);
    }
    if ((!this.acoz) && (this.acox) && (this.acov != null) && (this.acow != null))
    {
      Log.i("MicroMsg.UpdaterManager", "Incresment Update");
      i.bv(this.mContext, 5);
      if (!e.hq(this.size + this.acow.size))
      {
        iSB();
        AppMethodBeat.o(32776);
        return;
      }
      cancel();
      int i = this.acow.size;
      str1 = this.md5;
      int j = this.acmZ;
      String str2 = this.acov.heA + this.acow.url;
      String str3 = this.acow.patchMd5;
      String str4 = this.acow.heD;
      if (this.RgE == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.acos = new c(i, str1, j, str2, str3, str4, paramBoolean);
        iSC();
        AppMethodBeat.o(32776);
        return;
      }
    }
    if (!e.hq(this.size))
    {
      Log.e("MicroMsg.UpdaterManager", "SDCard is full");
      iSB();
      AppMethodBeat.o(32776);
      return;
    }
    iSD();
    AppMethodBeat.o(32776);
  }
  
  private void iSA()
  {
    AppMethodBeat.i(32780);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L).commit();
    cx(2, true);
    iSi();
    AppMethodBeat.o(32780);
  }
  
  private void iSB()
  {
    AppMethodBeat.i(32781);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L).commit();
    cx(2, true);
    iSj();
    AppMethodBeat.o(32781);
  }
  
  private void iSC()
  {
    AppMethodBeat.i(32782);
    if ((this.RgE == 2) && (!NetStatusUtil.isWifi(this.mContext)))
    {
      i.iSw();
      Log.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      AppMethodBeat.o(32782);
      return;
    }
    if ((this.RgE == 2) && (g.buc(this.md5)))
    {
      Log.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.acoE.stop();
      AppMethodBeat.o(32782);
      return;
    }
    this.acoE.iD(this.md5, this.size);
    if (this.acos != null)
    {
      cx(1, false);
      this.acoC = true;
      this.acos.a(this.acoG);
      gZM();
      if (this.RgE == 2) {
        i.iSw();
      }
    }
    AppMethodBeat.o(32782);
  }
  
  private void iSD()
  {
    AppMethodBeat.i(32783);
    cancel();
    Log.i("MicroMsg.UpdaterManager", "downloadFullPack");
    i.bv(this.mContext, 7);
    if ((this.acnB != null) && (this.acnB.length > 0))
    {
      i = this.size;
      str = this.md5;
      j = this.acmZ;
      localObject = this.acnB;
      if (this.RgE == 2) {}
      for (bool = true;; bool = false)
      {
        this.acos = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 76L, 1L, true);
        iSC();
        AppMethodBeat.o(32783);
        return;
      }
    }
    int i = this.size;
    String str = this.md5;
    int j = this.acmZ;
    int k = this.uin;
    Object localObject = this.pnl;
    byte[] arrayOfByte = this.ieJ;
    String[] arrayOfString = this.acot;
    if (this.RgE == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.acos = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(32779);
    cancel();
    this.updateMode = 0;
    this.heq = null;
    this.acot = null;
    this.qvp = com.tencent.mm.protocal.d.Yxh;
    this.acmZ = 0;
    this.pnl = null;
    this.ieJ = null;
    this.pnp = null;
    this.uin = 0;
    this.md5 = null;
    this.size = 0;
    this.desc = null;
    this.acnB = null;
    this.acov = null;
    this.acow = null;
    this.acox = false;
    this.acoy = false;
    this.RgE = 0;
    this.acoz = false;
    this.intent = null;
    this.acoC = false;
    this.qSv = null;
    this.acoF = 0L;
    AppMethodBeat.o(32779);
  }
  
  public final void Kr(boolean paramBoolean)
  {
    AppMethodBeat.i(32772);
    Log.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g localg = this.acoE;
    if (localg.Aey != paramBoolean)
    {
      localg.Ks(true);
      localg.Aey = paramBoolean;
    }
    if ((this.RgE != 2) || (this.acoC))
    {
      Log.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.RgE), Boolean.valueOf(this.acoC) });
      AppMethodBeat.o(32772);
      return;
    }
    if (paramBoolean)
    {
      if (bY(this.intent))
      {
        Kt(true);
        AppMethodBeat.o(32772);
      }
    }
    else if (this.acoC) {
      cancel();
    }
    AppMethodBeat.o(32772);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(32787);
    Iterator localIterator = this.delegates.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(32787);
  }
  
  public final void aWn(String paramString)
  {
    AppMethodBeat.i(32786);
    Iterator localIterator = this.delegates.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).aWn(paramString);
    }
    AppMethodBeat.o(32786);
  }
  
  public final boolean bX(Intent paramIntent)
  {
    AppMethodBeat.i(32773);
    boolean bool = bY(paramIntent);
    Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      Kt(false);
    }
    AppMethodBeat.o(32773);
    return bool;
  }
  
  public final boolean bY(Intent paramIntent)
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
    if ((this.acoC) && (!str.equalsIgnoreCase(this.md5)) && (this.RgE == 2)) {
      cancel();
    }
    Object localObject;
    while (!this.acoC)
    {
      i.iSy();
      reset();
      this.intent = paramIntent;
      this.updateMode = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.heq = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.acot = paramIntent.getStringArrayExtra("intent_short_ips");
      this.qvp = paramIntent.getIntExtra("intent_client_version", com.tencent.mm.protocal.d.Yxh);
      com.tencent.mm.protocal.d.Yxh = this.qvp;
      this.acmZ = j;
      this.pnl = paramIntent.getByteArrayExtra("intent_extra_session");
      this.ieJ = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.pnp = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.md5 = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.acnB = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.RgE = i;
      this.acoz = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject != null)
      {
        Log.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.acov = com.tencent.mm.d.h.ib((String)localObject);
      }
      localObject = paramIntent.getStringExtra("intent_extra_extinfo");
      Log.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject });
      if (!Util.isNullOrNil((String)localObject))
      {
        this.acoA = ((String)XmlParser.parseXml((String)localObject, "extinfo", null).get(".extinfo.notautodownloadrange"));
        Log.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.acoA });
      }
      Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.acoC) });
      if ((j != 999) || (this.acnB == null) || (this.acnB.length <= 0)) {
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
    if (this.acnB != null)
    {
      localObject = this.acnB;
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
      boolean bool = com.tencent.mm.modelcontrol.b.NB(this.acoA);
      Log.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 78L, 1L, true);
        AppMethodBeat.o(32774);
        return false;
      }
    }
    if (this.acov != null)
    {
      Log.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject = com.tencent.mm.pluginsdk.platformtools.g.ju(this.mContext);
      this.acow = this.acov.ia((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder("increase apkMD5 = ").append((String)localObject).append(" : ");
      if (this.acow == null)
      {
        localObject = "not match";
        Log.i("MicroMsg.UpdaterManager", (String)localObject);
      }
    }
    else
    {
      Log.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.acoz) });
      this.acoB = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.acow == null) || (com.tencent.mm.sandbox.monitor.c.btX(str))) && (!this.acoB)) {
        break label823;
      }
      Log.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.acox = true;
    }
    for (;;)
    {
      paramIntent = i.iIZ();
      if ((!Util.isNullOrNil(paramIntent)) && (!paramIntent.equals(str))) {
        i.iSz();
      }
      AppMethodBeat.o(32774);
      return true;
      localObject = "match";
      break;
      label823:
      Log.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void blf()
  {
    AppMethodBeat.i(369602);
    Kt(false);
    AppMethodBeat.o(369602);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32778);
    if (this.acos != null)
    {
      this.acoC = false;
      this.acos.cancel();
      this.acos = null;
      this.acoD = System.currentTimeMillis();
      this.acoE.stop();
    }
    AppMethodBeat.o(32778);
  }
  
  public final void cx(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32777);
    this.acoy = paramBoolean;
    new MMHandler().postDelayed(new j.1(this, paramInt), 300L);
    AppMethodBeat.o(32777);
  }
  
  public final void gZM()
  {
    AppMethodBeat.i(32785);
    Iterator localIterator = this.delegates.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).gZM();
    }
    AppMethodBeat.o(32785);
  }
  
  public final void iSi()
  {
    AppMethodBeat.i(32788);
    Iterator localIterator = this.delegates.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).iSi();
    }
    AppMethodBeat.o(32788);
  }
  
  public final void iSj()
  {
    AppMethodBeat.i(32789);
    Iterator localIterator = this.delegates.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).iSj();
    }
    AppMethodBeat.o(32789);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32790);
    if ((this.acoC) || (System.currentTimeMillis() - this.acoD <= UpdaterService.acoM))
    {
      Log.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.acoC), Long.valueOf(this.acoD), Long.valueOf(System.currentTimeMillis() - this.acoD) });
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
    if (!this.acoC)
    {
      reset();
      cx(1, true);
    }
    AppMethodBeat.o(32791);
  }
  
  public final void onProgress(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32784);
    Iterator localIterator = this.delegates.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).onProgress(paramInt1, paramInt2);
    }
    AppMethodBeat.o(32784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.j
 * JD-Core Version:    0.7.0.1
 */