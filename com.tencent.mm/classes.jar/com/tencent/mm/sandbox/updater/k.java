package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class k
  implements a, h
{
  public int AkV;
  public int IqR;
  public String[] Irs;
  com.tencent.mm.sandbox.monitor.c Isi;
  ArrayList<h> Isj;
  public String[] Isk;
  public String Isl;
  public i Ism;
  public i.a Isn;
  public boolean Iso;
  public boolean Isp;
  public boolean Isq;
  public String Isr;
  public boolean Iss;
  boolean Ist;
  long Isu;
  g Isv;
  private long Isw;
  private b.a Isx;
  public int cSO;
  public String cSQ;
  public byte[] dMA;
  public String desc;
  public byte[] iHf;
  public byte[] iHj;
  private Intent intent;
  public int ioL;
  private Notification jVC;
  protected Context mContext;
  public String md5;
  public int size;
  public int uin;
  
  private k()
  {
    AppMethodBeat.i(32771);
    this.Isi = null;
    this.Isj = new ArrayList(1);
    this.ioL = d.FFH;
    this.Iso = false;
    this.Isp = false;
    this.Isq = false;
    this.Iss = false;
    this.Ist = false;
    this.intent = null;
    this.jVC = null;
    this.mContext = null;
    this.Isv = new g(this);
    this.Isw = -1L;
    this.Isx = new b.a()
    {
      public final void Dm(long paramAnonymousLong)
      {
        AppMethodBeat.i(32768);
        g localg = k.this.Isv;
        localg.cYd.post(new g.2(localg, paramAnonymousLong));
        AppMethodBeat.o(32768);
      }
      
      public final void Dn(long paramAnonymousLong)
      {
        AppMethodBeat.i(32769);
        g localg = k.this.Isv;
        localg.cYd.post(new g.3(localg, paramAnonymousLong));
        AppMethodBeat.o(32769);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, cwj paramAnonymouscwj)
      {
        AppMethodBeat.i(32767);
        k.this.Ist = false;
        k.this.Isv.stop();
        k.this.Isu = System.currentTimeMillis();
        if (k.this.Isi == null)
        {
          k.this.bi(2, true);
          AppMethodBeat.o(32767);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          ae.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (k.this.AkV != 2) {
            k.a(k.this, 100, 100);
          }
          if (k.this.Iso)
          {
            j.aB(k.this.mContext, 0);
            paramAnonymouscwj = MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.abv());
            k.this.Isl = paramAnonymouscwj.getString(ak.getPackageName(), "");
            ae.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { k.this.Isl, k.this.Isi.fml() });
            if ((bu.isNullOrNil(k.this.Isl)) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)) {
              break label462;
            }
          }
          for (;;)
          {
            try
            {
              com.tencent.mm.d.c.g(new File(o.k(k.this.Isi.fml(), true)), k.this.Isl);
              ae.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4006), k.this.Isl });
              if (k.this.AkV != 1) {
                break label501;
              }
              j.aC(k.this.mContext, 8);
              k.a(k.this);
              k.this.ayY(k.this.Isi.fml());
              if (k.this.Iss)
              {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 58L, 1L, false);
                ae.d("MicroMsg.UpdaterManager", "boots download success.");
              }
              j.fmH();
              AppMethodBeat.o(32767);
              return;
              j.aB(k.this.mContext, 9);
            }
            catch (Exception paramAnonymouscwj)
            {
              ae.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymouscwj.getMessage());
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4007), paramAnonymouscwj.getMessage() });
              continue;
            }
            label462:
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4008) });
            continue;
            label501:
            if (k.this.AkV == 0)
            {
              k.this.ayY(k.this.Isi.fml());
            }
            else if (k.this.AkV == 2)
            {
              j.aC(k.this.mContext, 1);
              k.a(k.this);
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          ae.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.fD();
          AppUpdaterUI.fmp();
          j.fmG();
          AppMethodBeat.o(32767);
          return;
        }
        if (((k.this.Isi instanceof c)) && (k.this.IqR != 4))
        {
          ae.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (k.this.Iso)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              j.aB(k.this.mContext, paramAnonymousInt1);
            }
            k.this.Iso = false;
            if (k.this.AkV == 1) {
              if (k.this.Iss)
              {
                ae.d("MicroMsg.UpdaterManager", "boots download failed. %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
                switch (paramAnonymousInt1)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          k.this.a(k.this.Isi);
          AppMethodBeat.o(32767);
          return;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 55L, 1L, false);
          continue;
          k.b(k.this);
          continue;
          if (k.this.AkV == 0)
          {
            k.this.bi(1, true);
          }
          else if (k.this.AkV == 2)
          {
            k.c(k.this);
            continue;
            paramAnonymouscwj = k.this;
            paramAnonymousInt1 = k.this.size;
            String str = k.this.md5;
            paramAnonymousInt2 = k.this.IqR;
            int i = k.this.uin;
            byte[] arrayOfByte1 = k.this.iHf;
            byte[] arrayOfByte2 = k.this.dMA;
            String[] arrayOfString = k.this.Isk;
            if (k.this.AkV == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymouscwj.Isi = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              k.d(k.this);
              break;
            }
            ae.e("MicroMsg.UpdaterManager", "update failed");
            j.aB(k.this.mContext, 10);
            if (k.this.AkV == 1) {
              k.e(k.this);
            } else if (k.this.AkV == 0) {
              k.this.bi(1, true);
            }
          }
        }
      }
      
      public final void fa(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32766);
        ae.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (k.this.AkV != 2) {
          k.a(k.this, paramAnonymousInt2, paramAnonymousInt1);
        }
        k.this.fa(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32766);
      }
    };
    this.mContext = ak.getContext();
    AppMethodBeat.o(32771);
  }
  
  private void fmJ()
  {
    AppMethodBeat.i(32780);
    MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bu.aRi() - 86400L).commit();
    bi(2, true);
    fmr();
    AppMethodBeat.o(32780);
  }
  
  private void fmK()
  {
    AppMethodBeat.i(32781);
    MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bu.aRi() - 86400L).commit();
    bi(2, true);
    fms();
    AppMethodBeat.o(32781);
  }
  
  private void fmL()
  {
    AppMethodBeat.i(32782);
    if ((this.AkV == 2) && (!az.isWifi(this.mContext)))
    {
      j.fmF();
      ae.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      AppMethodBeat.o(32782);
      return;
    }
    if ((this.AkV == 2) && (g.aRi(this.md5)))
    {
      ae.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.Isv.stop();
      AppMethodBeat.o(32782);
      return;
    }
    this.Isv.go(this.md5, this.size);
    if (this.Isi != null)
    {
      bi(1, false);
      this.Ist = true;
      this.Isi.a(this.Isx);
      dVu();
      if (this.AkV == 2) {
        j.fmF();
      }
    }
    AppMethodBeat.o(32782);
  }
  
  private void fmM()
  {
    AppMethodBeat.i(32783);
    cancel();
    ae.i("MicroMsg.UpdaterManager", "downloadFullPack");
    j.aB(this.mContext, 7);
    if ((this.Irs != null) && (this.Irs.length > 0))
    {
      i = this.size;
      str = this.md5;
      j = this.IqR;
      localObject = this.Irs;
      if (this.AkV == 2) {}
      for (bool = true;; bool = false)
      {
        this.Isi = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 76L, 1L, true);
        fmL();
        AppMethodBeat.o(32783);
        return;
      }
    }
    int i = this.size;
    String str = this.md5;
    int j = this.IqR;
    int k = this.uin;
    Object localObject = this.iHf;
    byte[] arrayOfByte = this.dMA;
    String[] arrayOfString = this.Isk;
    if (this.AkV == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.Isi = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 77L, 1L, true);
      break;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(32779);
    cancel();
    this.cSO = 0;
    this.cSQ = null;
    this.Isk = null;
    this.ioL = d.FFH;
    this.IqR = 0;
    this.iHf = null;
    this.dMA = null;
    this.iHj = null;
    this.uin = 0;
    this.md5 = null;
    this.size = 0;
    this.desc = null;
    this.Irs = null;
    this.Ism = null;
    this.Isn = null;
    this.Iso = false;
    this.Isp = false;
    this.AkV = 0;
    this.Isq = false;
    this.intent = null;
    this.Ist = false;
    this.jVC = null;
    this.Isw = 0L;
    AppMethodBeat.o(32779);
  }
  
  private void wA(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(32776);
    ae.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ae.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.AkV), Boolean.valueOf(this.Ist) });
    if (this.intent == null)
    {
      ae.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      AppMethodBeat.o(32776);
      return;
    }
    if (this.Ist)
    {
      ae.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      AppMethodBeat.o(32776);
      return;
    }
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      ae.e("MicroMsg.UpdaterManager", "no sdcard.");
      fmJ();
      AppMethodBeat.o(32776);
      return;
    }
    if ((this.AkV == 2) && (!paramBoolean)) {
      j.aC(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.arX(this.md5);
    ae.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      ae.i("MicroMsg.UpdaterManager", "update package already exist.");
      bi(1, true);
      ayY(str1);
      if ((this.AkV == 2) && (!j.aRj(this.md5))) {
        j.a(this.md5, this.Isl, this.desc, this.size, this.AkV, this.IqR, this.Isr);
      }
      AppMethodBeat.o(32776);
      return;
    }
    if (this.Isq)
    {
      if (this.Isi != null) {
        this.Isi.deleteTempFile();
      }
      j.aB(this.mContext, 11);
    }
    if ((!this.Isq) && (this.Iso) && (this.Ism != null) && (this.Isn != null))
    {
      ae.i("MicroMsg.UpdaterManager", "Incresment Update");
      j.aB(this.mContext, 5);
      if (!e.re(this.size + this.Isn.size))
      {
        fmK();
        AppMethodBeat.o(32776);
        return;
      }
      cancel();
      int i = this.Isn.size;
      str1 = this.md5;
      int j = this.IqR;
      String str2 = this.Ism.cTb + this.Isn.url;
      String str3 = this.Isn.patchMd5;
      String str4 = this.Isn.cTe;
      if (this.AkV == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.Isi = new c(i, str1, j, str2, str3, str4, paramBoolean);
        fmL();
        AppMethodBeat.o(32776);
        return;
      }
    }
    if (!e.re(this.size))
    {
      ae.e("MicroMsg.UpdaterManager", "SDCard is full");
      fmK();
      AppMethodBeat.o(32776);
      return;
    }
    fmM();
    AppMethodBeat.o(32776);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(32787);
    Iterator localIterator = this.Isj.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(32787);
  }
  
  public final void ayY(String paramString)
  {
    AppMethodBeat.i(32786);
    Iterator localIterator = this.Isj.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).ayY(paramString);
    }
    AppMethodBeat.o(32786);
  }
  
  public final void bi(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32777);
    this.Isp = paramBoolean;
    new aq().postDelayed(new k.1(this, paramInt), 300L);
    AppMethodBeat.o(32777);
  }
  
  public final boolean bi(Intent paramIntent)
  {
    AppMethodBeat.i(32773);
    boolean bool = bj(paramIntent);
    ae.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      wA(false);
    }
    AppMethodBeat.o(32773);
    return bool;
  }
  
  public final boolean bj(Intent paramIntent)
  {
    AppMethodBeat.i(32774);
    ae.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
    if (paramIntent == null)
    {
      ae.i("MicroMsg.UpdaterManager", "intent == null");
      AppMethodBeat.o(32774);
      return false;
    }
    int j = paramIntent.getIntExtra("intent_update_type", 3);
    int i = paramIntent.getIntExtra("intent_extra_download_mode", 1);
    String str = paramIntent.getStringExtra("intent_extra_md5");
    if ((this.Ist) && (!str.equalsIgnoreCase(this.md5)) && (this.AkV == 2)) {
      cancel();
    }
    Object localObject;
    while (!this.Ist)
    {
      j.fmH();
      reset();
      this.intent = paramIntent;
      this.cSO = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.cSQ = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.Isk = paramIntent.getStringArrayExtra("intent_short_ips");
      this.ioL = paramIntent.getIntExtra("intent_client_version", d.FFH);
      d.FFH = this.ioL;
      this.IqR = j;
      this.iHf = paramIntent.getByteArrayExtra("intent_extra_session");
      this.dMA = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.iHj = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.md5 = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.Irs = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.AkV = i;
      this.Isq = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject != null)
      {
        ae.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.Ism = i.fd((String)localObject);
      }
      localObject = paramIntent.getStringExtra("intent_extra_extinfo");
      ae.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject });
      if (!bu.isNullOrNil((String)localObject))
      {
        this.Isr = ((String)bx.M((String)localObject, "extinfo").get(".extinfo.notautodownloadrange"));
        ae.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.Isr });
      }
      ae.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.Ist) });
      if ((j != 999) || (this.Irs == null) || (this.Irs.length <= 0)) {
        break;
      }
      if (i == 2) {
        ae.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
      }
      AppMethodBeat.o(32774);
      return true;
    }
    ae.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
    AppMethodBeat.o(32774);
    return true;
    if (this.Irs != null)
    {
      localObject = this.Irs;
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        ae.i("MicroMsg.UpdaterManager", "download url : ".concat(String.valueOf(localObject[i])));
        i += 1;
      }
    }
    ae.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[] { str, Integer.valueOf(this.size) });
    if ((str == null) || (this.size == 0))
    {
      AppMethodBeat.o(32774);
      return false;
    }
    if (j == 2)
    {
      boolean bool = com.tencent.mm.modelcontrol.b.Fv(this.Isr);
      ae.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 78L, 1L, true);
        AppMethodBeat.o(32774);
        return false;
      }
    }
    if (this.Ism != null)
    {
      ae.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject = com.tencent.mm.pluginsdk.i.j.hC(this.mContext);
      this.Isn = this.Ism.fc((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder("increase apkMD5 = ").append((String)localObject).append(" : ");
      if (this.Isn == null)
      {
        localObject = "not match";
        ae.i("MicroMsg.UpdaterManager", (String)localObject);
      }
    }
    else
    {
      ae.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.Isq) });
      this.Iss = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.Isn == null) || (com.tencent.mm.sandbox.monitor.c.aRd(str))) && (!this.Iss)) {
        break label837;
      }
      ae.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.Iso = true;
    }
    for (;;)
    {
      paramIntent = j.fej();
      if ((!bu.isNullOrNil(paramIntent)) && (!paramIntent.equals(str))) {
        j.fmI();
      }
      AppMethodBeat.o(32774);
      return true;
      localObject = "match";
      break;
      label837:
      ae.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32778);
    if (this.Isi != null)
    {
      this.Ist = false;
      this.Isi.cancel();
      this.Isi = null;
      this.Isu = System.currentTimeMillis();
      this.Isv.stop();
    }
    AppMethodBeat.o(32778);
  }
  
  public final void ckB()
  {
    AppMethodBeat.i(224184);
    wA(false);
    AppMethodBeat.o(224184);
  }
  
  public final void dVu()
  {
    AppMethodBeat.i(32785);
    Iterator localIterator = this.Isj.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).dVu();
    }
    AppMethodBeat.o(32785);
  }
  
  public final void fa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32784);
    Iterator localIterator = this.Isj.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).fa(paramInt1, paramInt2);
    }
    AppMethodBeat.o(32784);
  }
  
  public final void fmr()
  {
    AppMethodBeat.i(32788);
    Iterator localIterator = this.Isj.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).fmr();
    }
    AppMethodBeat.o(32788);
  }
  
  public final void fms()
  {
    AppMethodBeat.i(32789);
    Iterator localIterator = this.Isj.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).fms();
    }
    AppMethodBeat.o(32789);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32790);
    if ((this.Ist) || (System.currentTimeMillis() - this.Isu <= UpdaterService.IsD))
    {
      ae.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.Ist), Long.valueOf(this.Isu), Long.valueOf(System.currentTimeMillis() - this.Isu) });
      AppMethodBeat.o(32790);
      return true;
    }
    ae.i("MicroMsg.UpdaterManager", "not busy");
    AppMethodBeat.o(32790);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32791);
    ae.i("MicroMsg.UpdaterManager", "onDestroy");
    if (!this.Ist)
    {
      reset();
      bi(1, true);
    }
    AppMethodBeat.o(32791);
  }
  
  public final void wy(boolean paramBoolean)
  {
    AppMethodBeat.i(32772);
    ae.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g localg = this.Isv;
    if (localg.rCA != paramBoolean)
    {
      localg.wz(true);
      localg.rCA = paramBoolean;
    }
    if ((this.AkV != 2) || (this.Ist))
    {
      ae.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.AkV), Boolean.valueOf(this.Ist) });
      AppMethodBeat.o(32772);
      return;
    }
    if (paramBoolean)
    {
      if (bj(this.intent))
      {
        wA(true);
        AppMethodBeat.o(32772);
      }
    }
    else if (this.Ist) {
      cancel();
    }
    AppMethodBeat.o(32772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */