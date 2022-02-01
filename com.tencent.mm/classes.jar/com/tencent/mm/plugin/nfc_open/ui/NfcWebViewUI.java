package com.tencent.mm.plugin.nfc_open.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NfcWebViewUI
  extends WebViewUI
{
  private String wtt;
  private boolean wtu;
  private com.tencent.mm.plugin.nfc_open.a.a wtv;
  
  public NfcWebViewUI()
  {
    AppMethodBeat.i(26698);
    this.wtt = null;
    this.wtu = false;
    this.wtv = new com.tencent.mm.plugin.nfc_open.a.a();
    AppMethodBeat.o(26698);
  }
  
  private static String LW(int paramInt)
  {
    AppMethodBeat.i(26707);
    StringBuilder localStringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    localStringBuilder.append("&type=").append(paramInt);
    String str;
    if ((!j.IcA) && (ac.fks().equals("zh_CN"))) {
      str = "zh_CN";
    }
    for (;;)
    {
      localStringBuilder.append("&lang=").append(str);
      str = localStringBuilder.toString();
      AppMethodBeat.o(26707);
      return str;
      if (ac.fkq()) {
        str = "zh_TW";
      } else {
        str = "en";
      }
    }
  }
  
  private void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(26704);
    switch (3.nNm[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(26704);
      return;
    }
    parama = y.r(paramIntent, "android.nfc.extra.TAG");
    if ((parama != null) && ((parama instanceof Tag))) {}
    for (parama = (Tag)parama;; parama = null)
    {
      if (parama == null)
      {
        ad.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
        AppMethodBeat.o(26704);
        return;
      }
      try
      {
        com.tencent.mm.plugin.nfc.b.a.a.duy().a(parama);
        ad.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.duy().fV(getContext()))));
        AppMethodBeat.o(26704);
        return;
      }
      catch (Exception parama)
      {
        ad.e("MicroMsg.NfcWebViewUI", "exp protect");
        AppMethodBeat.o(26704);
        return;
      }
    }
  }
  
  private static boolean a(com.tencent.mm.plugin.nfc.a.a parama, String paramString)
  {
    AppMethodBeat.i(26711);
    ad.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
    if (in(paramString, com.tencent.mm.plugin.nfc.b.a.a.duy().a(parama).toString()))
    {
      AppMethodBeat.o(26711);
      return true;
    }
    AppMethodBeat.o(26711);
    return false;
  }
  
  private static boolean aE(Intent paramIntent)
  {
    AppMethodBeat.i(26715);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.NfcWebViewUI", "intent is null");
      AppMethodBeat.o(26715);
      return true;
    }
    Object localObject = paramIntent.getExtras();
    try
    {
      localObject = ((Bundle)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((str != null) && (!str.startsWith("android.nfc")))
        {
          ad.e("MicroMsg.NfcWebViewUI", "extra wrong key = ".concat(String.valueOf(str)));
          ((Iterator)localObject).remove();
        }
      }
      paramIntent = y.r(paramIntent, "android.nfc.extra.TAG");
    }
    catch (Exception paramIntent)
    {
      ad.e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", new Object[] { paramIntent });
      AppMethodBeat.o(26715);
      return true;
    }
    if ((paramIntent != null) && ((paramIntent instanceof Tag))) {}
    for (paramIntent = (Tag)paramIntent;; paramIntent = null)
    {
      if (paramIntent == null)
      {
        ad.e("MicroMsg.NfcWebViewUI", "tag is null");
        AppMethodBeat.o(26715);
        return true;
      }
      AppMethodBeat.o(26715);
      return false;
    }
  }
  
  private String atj(String paramString)
  {
    AppMethodBeat.i(26709);
    ad.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
    this.wtt = "";
    try
    {
      paramString = paramString.split(" ");
      if ((paramString != null) && (paramString.length > 1))
      {
        int i = 0;
        boolean bool1 = false;
        boolean bool2;
        for (;;)
        {
          bool2 = bool1;
          if (i >= paramString.length - 1) {
            break;
          }
          String str1 = paramString[i];
          String str2 = paramString[(i + 1)];
          ad.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str1 + " anwser = " + str2);
          bool1 = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str1)), str2);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          i = i + 1 + 1;
        }
        if (bool2)
        {
          this.wtt = paramString[(paramString.length - 1)];
          ad.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.wtt);
          paramString = this.wtt;
          AppMethodBeat.o(26709);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
      ad.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + paramString.toString());
      ad.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.duy().fU(getContext()))));
      this.wtt = LW(1);
      paramString = this.wtt;
      AppMethodBeat.o(26709);
      return paramString;
    }
    paramString = this.wtt;
    AppMethodBeat.o(26709);
    return paramString;
  }
  
  private String atk(String paramString)
  {
    AppMethodBeat.i(26710);
    ad.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
    this.wtt = "";
    Object localObject1 = new cct();
    if (!bt.isNullOrNil(paramString)) {}
    for (;;)
    {
      int k;
      try
      {
        ((cct)localObject1).parseFrom(paramString.getBytes("ISO-8859-1"));
        if (((cct)localObject1).Gbj != null)
        {
          i = 0;
          int m = 0;
          if (m < ((cct)localObject1).Gbj.size())
          {
            paramString = (sq)((cct)localObject1).Gbj.get(m);
            Object localObject2 = com.tencent.mm.plugin.nfc.b.a.a.duy();
            if (((com.tencent.mm.plugin.nfc.b.a.a)localObject2).wtn != null) {
              ((com.tencent.mm.plugin.nfc.b.a.a)localObject2).wtn.duz();
            }
            k = i;
            if (paramString != null)
            {
              k = i;
              if (!bt.isNullOrNil(paramString.FpV))
              {
                k = i;
                if (!bt.hj(paramString.FPf))
                {
                  k = 0;
                  if (k >= paramString.FPf.size()) {
                    break label597;
                  }
                  if (bt.hj(((abo)paramString.FPf.get(k)).Gbm)) {
                    break label570;
                  }
                  j = 0;
                  if (j >= ((abo)paramString.FPf.get(k)).Gbm.size()) {
                    break label567;
                  }
                  if ((((abo)paramString.FPf.get(k)).Gbm.get(j) == null) || (bt.isNullOrNil(((zs)((abo)paramString.FPf.get(k)).Gbm.get(j)).FYR)) || (bt.isNullOrNil(((zs)((abo)paramString.FPf.get(k)).Gbm.get(j)).vpC))) {
                    break label564;
                  }
                  localObject2 = ((zs)((abo)paramString.FPf.get(k)).Gbm.get(j)).FYR;
                  String str = ((zs)((abo)paramString.FPf.get(k)).Gbm.get(j)).vpC;
                  ad.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + (String)localObject2 + " anwser = " + str);
                  if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray((String)localObject2)), str)) {
                    break label580;
                  }
                  i = 1;
                  break label573;
                  k = j;
                  if (j != 0)
                  {
                    localObject1 = paramString.FpV;
                    ad.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                    b.c(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(26696);
                        g.yhR.f(12794, new Object[] { this.wtx, Integer.valueOf(0) });
                        ad.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.wtx);
                        AppMethodBeat.o(26696);
                      }
                    }, getClass().getName());
                    paramString = paramString.FpV;
                    AppMethodBeat.o(26710);
                    return paramString;
                  }
                }
              }
            }
            i = k;
            m += 1;
            continue;
          }
        }
        paramString = this.wtt;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
        ad.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + paramString.toString());
        ad.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.duy().fU(getContext()))));
        this.wtt = LW(1);
        paramString = this.wtt;
        AppMethodBeat.o(26710);
        return paramString;
      }
      AppMethodBeat.o(26710);
      return paramString;
      label564:
      break label573;
      label567:
      break label582;
      label570:
      break label588;
      label573:
      j += 1;
      continue;
      label580:
      int i = 0;
      label582:
      int j = i;
      if (i == 0)
      {
        label588:
        k += 1;
        continue;
        label597:
        j = i;
      }
    }
  }
  
  private boolean duC()
  {
    AppMethodBeat.i(26703);
    try
    {
      if (this.lvv.eRF())
      {
        ad.w("MicroMsg.NfcWebViewUI", "not login");
        Intent localIntent = new Intent(this, getClass());
        localIntent.putExtras(getIntent());
        localIntent.addFlags(67108864);
        this.lvv.ba(localIntent);
        AppMethodBeat.o(26703);
        return true;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.NfcWebViewUI", localException, "", new Object[0]);
      AppMethodBeat.o(26703);
      return true;
    }
    AppMethodBeat.o(26703);
    return false;
  }
  
  private boolean duD()
  {
    AppMethodBeat.i(26706);
    boolean bool = bQm().startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    AppMethodBeat.o(26706);
    return bool;
  }
  
  private String duE()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26708);
    ad.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
    for (;;)
    {
      try
      {
        localObject2 = this.lvv.k(4006, null);
        if (localObject2 == null)
        {
          ad.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
          AppMethodBeat.o(26708);
          return null;
        }
        ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
        str = ((Bundle)localObject2).getString("debugConfig");
        localObject2 = ((Bundle)localObject2).getString("config");
        if (str == null) {
          continue;
        }
        str = atj(str);
        localObject1 = str;
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject2;
        String str;
        ad.e("MicroMsg.NfcWebViewUI", localRemoteException.toString());
        ad.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      ad.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bt.nullAsNil(localObject1));
      AppMethodBeat.o(26708);
      return localObject1;
      str = atk((String)localObject2);
      localObject1 = str;
    }
  }
  
  private void duF()
  {
    AppMethodBeat.i(26714);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.bs.d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    overridePendingTransition(2130771986, 2130772100);
    ad.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    AppMethodBeat.o(26714);
  }
  
  private static boolean in(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26712);
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26712);
      return false;
    }
    ad.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bt.nullAsNil(paramString1) + " resp = " + bt.nullAsNil(paramString2));
    if (Pattern.compile(paramString1, 2).matcher(paramString2).find())
    {
      AppMethodBeat.o(26712);
      return true;
    }
    AppMethodBeat.o(26712);
    return false;
  }
  
  public final void bzn()
  {
    AppMethodBeat.i(26701);
    super.bzn();
    if (duC())
    {
      finish();
      ad.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
      AppMethodBeat.o(26701);
      return;
    }
    a(AutoLoginActivity.a.ERN, getIntent());
    ph(false);
    AppMethodBeat.o(26701);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26713);
    if (this.wtu)
    {
      duF();
      AppMethodBeat.o(26713);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(26713);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26699);
    Intent localIntent = getIntent();
    if (aE(localIntent)) {
      ad.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
    }
    try
    {
      localIntent.putExtra("key_trust_url", false);
      label35:
      super.onCreate(paramBundle);
      finish();
      AppMethodBeat.o(26699);
      return;
      localIntent.putExtra("key_trust_url", false);
      super.onCreate(paramBundle);
      com.tencent.mm.sdk.b.a.IbL.c(this.wtv);
      com.tencent.mm.bs.d.ffH();
      ad.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + localIntent.getAction());
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26695);
          if (NfcWebViewUI.a(NfcWebViewUI.this)) {
            NfcWebViewUI.b(NfcWebViewUI.this);
          }
          for (;;)
          {
            AppMethodBeat.o(26695);
            return true;
            NfcWebViewUI.this.finish();
          }
        }
      });
      getIntent().putExtra("showShare", false);
      vg(false);
      AppMethodBeat.o(26699);
      return;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  @TargetApi(11)
  public void onDestroy()
  {
    AppMethodBeat.i(26700);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d(this.wtv);
    AppMethodBeat.o(26700);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(26702);
    if (aE(paramIntent))
    {
      ad.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
      AppMethodBeat.o(26702);
      return;
    }
    paramIntent.putExtra("key_trust_url", false);
    super.onNewIntent(paramIntent);
    String str = bQm();
    setIntent(paramIntent);
    if ((!bt.isNullOrNil(str)) && (bt.isNullOrNil(bQm()))) {
      paramIntent.putExtra("rawUrl", str);
    }
    int i = y.getIntExtra(paramIntent, "wizard_activity_result_code", 2147483647);
    ad.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    if (i != 2147483647) {
      this.wtu = true;
    }
    switch (i)
    {
    default: 
    case -1: 
    case 1: 
      for (;;)
      {
        ph(true);
        ad.i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(paramIntent)));
        AppMethodBeat.o(26702);
        return;
        a(AutoLoginActivity.a.ERN, paramIntent);
        continue;
        a(AutoLoginActivity.a.ERP, paramIntent);
      }
    }
    duC();
    AppMethodBeat.o(26702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void ph(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(26705);
    if (this.lvv == null)
    {
      ad.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
      AppMethodBeat.o(26705);
      return;
    }
    a(AutoLoginActivity.a.ERN, getIntent());
    Object localObject1 = duE();
    if ((paramBoolean) && (!bt.isNullOrNil(bQm()))) {
      if (duD()) {
        if (bt.isNullOrNil((String)localObject1)) {
          ad.e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        }
      }
    }
    for (;;)
    {
      if (bt.isNullOrNil(bQm()))
      {
        getIntent().putExtra("rawUrl", LW(0));
        ad.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
      }
      this.DIv.at(getIntent());
      AppMethodBeat.o(26705);
      return;
      ad.i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", new Object[] { localObject1 });
      getIntent().putExtra("rawUrl", (String)localObject1);
      this.DIv.k((String)localObject1, false, -1);
      continue;
      for (;;)
      {
        try
        {
          paramBoolean = bt.isNullOrNil((String)localObject1);
          if (paramBoolean) {
            continue;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject2;
          ad.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
          continue;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject1);
          localObject1 = Uri.parse(bQm());
          localObject2 = ((Uri)localObject2).getHost();
          localObject1 = ((Uri)localObject1).getHost();
          ad.i("MicroMsg.NfcWebViewUI", "targetHost=" + (String)localObject2 + ", curHost=" + (String)localObject1);
          paramBoolean = ((String)localObject2).equals(localObject1);
          if (paramBoolean)
          {
            if (i != 0) {
              this.DNO.g(4007, new Bundle());
            }
            ad.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
            AppMethodBeat.o(26705);
            return;
          }
        }
        catch (Exception localException) {}
        i = 0;
      }
      getIntent().putExtra("rawUrl", localRemoteException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI
 * JD-Core Version:    0.7.0.1
 */