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
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NfcWebViewUI
  extends WebViewUI
{
  private String ufc;
  private boolean ufd;
  private com.tencent.mm.plugin.nfc_open.a.a ufe;
  
  public NfcWebViewUI()
  {
    AppMethodBeat.i(26698);
    this.ufc = null;
    this.ufd = false;
    this.ufe = new com.tencent.mm.plugin.nfc_open.a.a();
    AppMethodBeat.o(26698);
  }
  
  private static String Iv(int paramInt)
  {
    AppMethodBeat.i(26707);
    StringBuilder localStringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    localStringBuilder.append("&type=").append(paramInt);
    String str;
    if ((!i.ETz) && (ac.eFu().equals("zh_CN"))) {
      str = "zh_CN";
    }
    for (;;)
    {
      localStringBuilder.append("&lang=").append(str);
      str = localStringBuilder.toString();
      AppMethodBeat.o(26707);
      return str;
      if (ac.eFs()) {
        str = "zh_TW";
      } else {
        str = "en";
      }
    }
  }
  
  private void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(26704);
    switch (3.mKE[parama.ordinal()])
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
        com.tencent.mm.plugin.nfc.b.a.a.cWE().a(parama);
        ad.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.cWE().fE(getContext()))));
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
    if (hJ(paramString, com.tencent.mm.plugin.nfc.b.a.a.cWE().a(parama).toString()))
    {
      AppMethodBeat.o(26711);
      return true;
    }
    AppMethodBeat.o(26711);
    return false;
  }
  
  private String ajm(String paramString)
  {
    AppMethodBeat.i(26709);
    ad.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
    this.ufc = "";
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
          this.ufc = paramString[(paramString.length - 1)];
          ad.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.ufc);
          paramString = this.ufc;
          AppMethodBeat.o(26709);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
      ad.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + paramString.toString());
      ad.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.cWE().fD(getContext()))));
      this.ufc = Iv(1);
      paramString = this.ufc;
      AppMethodBeat.o(26709);
      return paramString;
    }
    paramString = this.ufc;
    AppMethodBeat.o(26709);
    return paramString;
  }
  
  private String ajn(String paramString)
  {
    AppMethodBeat.i(26710);
    ad.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
    this.ufc = "";
    Object localObject1 = new btl();
    if (!bt.isNullOrNil(paramString)) {}
    for (;;)
    {
      int k;
      try
      {
        ((btl)localObject1).parseFrom(paramString.getBytes("ISO-8859-1"));
        if (((btl)localObject1).DaU != null)
        {
          i = 0;
          int m = 0;
          if (m < ((btl)localObject1).DaU.size())
          {
            paramString = (qn)((btl)localObject1).DaU.get(m);
            Object localObject2 = com.tencent.mm.plugin.nfc.b.a.a.cWE();
            if (((com.tencent.mm.plugin.nfc.b.a.a)localObject2).ueW != null) {
              ((com.tencent.mm.plugin.nfc.b.a.a)localObject2).ueW.cWF();
            }
            k = i;
            if (paramString != null)
            {
              k = i;
              if (!bt.isNullOrNil(paramString.Csy))
              {
                k = i;
                if (!bt.gL(paramString.CPk))
                {
                  k = 0;
                  if (k >= paramString.CPk.size()) {
                    break label594;
                  }
                  if (bt.gL(((yt)paramString.CPk.get(k)).DaX)) {
                    break label567;
                  }
                  j = 0;
                  if (j >= ((yt)paramString.CPk.get(k)).DaX.size()) {
                    break label564;
                  }
                  if ((((yt)paramString.CPk.get(k)).DaX.get(j) == null) || (bt.isNullOrNil(((xb)((yt)paramString.CPk.get(k)).DaX.get(j)).CYV)) || (bt.isNullOrNil(((xb)((yt)paramString.CPk.get(k)).DaX.get(j)).teH))) {
                    break label561;
                  }
                  localObject2 = ((xb)((yt)paramString.CPk.get(k)).DaX.get(j)).CYV;
                  String str = ((xb)((yt)paramString.CPk.get(k)).DaX.get(j)).teH;
                  ad.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + (String)localObject2 + " anwser = " + str);
                  if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray((String)localObject2)), str)) {
                    break label577;
                  }
                  i = 1;
                  break label570;
                  k = j;
                  if (j != 0)
                  {
                    localObject1 = paramString.Csy;
                    ad.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                    b.c(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(26696);
                        com.tencent.mm.plugin.report.service.h.vKh.f(12794, new Object[] { this.ufg, Integer.valueOf(0) });
                        ad.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.ufg);
                        AppMethodBeat.o(26696);
                      }
                    }, getClass().getName());
                    paramString = paramString.Csy;
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
        paramString = this.ufc;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
        ad.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + paramString.toString());
        ad.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.cWE().fD(getContext()))));
        this.ufc = Iv(1);
        paramString = this.ufc;
        AppMethodBeat.o(26710);
        return paramString;
      }
      AppMethodBeat.o(26710);
      return paramString;
      label561:
      break label570;
      label564:
      break label579;
      label567:
      break label585;
      label570:
      j += 1;
      continue;
      label577:
      int i = 0;
      label579:
      int j = i;
      if (i == 0)
      {
        label585:
        k += 1;
        continue;
        label594:
        j = i;
      }
    }
  }
  
  private static boolean ay(Intent paramIntent)
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
  
  private boolean cWI()
  {
    AppMethodBeat.i(26703);
    try
    {
      if (this.kxf.env())
      {
        ad.w("MicroMsg.NfcWebViewUI", "not login");
        Intent localIntent = new Intent(this, getClass());
        localIntent.putExtras(getIntent());
        localIntent.addFlags(67108864);
        this.kxf.aT(localIntent);
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
  
  private boolean cWJ()
  {
    AppMethodBeat.i(26706);
    boolean bool = bEx().startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    AppMethodBeat.o(26706);
    return bool;
  }
  
  private String cWK()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26708);
    ad.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
    for (;;)
    {
      try
      {
        localObject2 = this.kxf.j(4006, null);
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
        str = ajm(str);
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
      str = ajn((String)localObject2);
      localObject1 = str;
    }
  }
  
  private void cWL()
  {
    AppMethodBeat.i(26714);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.bs.d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    overridePendingTransition(2130771986, 2130772100);
    ad.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    AppMethodBeat.o(26714);
  }
  
  private static boolean hJ(String paramString1, String paramString2)
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
  
  public final void bol()
  {
    AppMethodBeat.i(26701);
    super.bol();
    if (cWI())
    {
      finish();
      ad.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
      AppMethodBeat.o(26701);
      return;
    }
    a(AutoLoginActivity.a.BUu, getIntent());
    nO(false);
    AppMethodBeat.o(26701);
  }
  
  public final void nO(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(26705);
    if (this.kxf == null)
    {
      ad.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
      AppMethodBeat.o(26705);
      return;
    }
    a(AutoLoginActivity.a.BUu, getIntent());
    Object localObject1 = cWK();
    if ((paramBoolean) && (!bt.isNullOrNil(bEx()))) {
      if (cWJ()) {
        if (bt.isNullOrNil((String)localObject1)) {
          ad.e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        }
      }
    }
    for (;;)
    {
      if (bt.isNullOrNil(bEx()))
      {
        getIntent().putExtra("rawUrl", Iv(0));
        ad.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
      }
      this.AMZ.an(getIntent());
      AppMethodBeat.o(26705);
      return;
      ad.i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", new Object[] { localObject1 });
      getIntent().putExtra("rawUrl", (String)localObject1);
      this.AMZ.k((String)localObject1, false, -1);
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
          localObject1 = Uri.parse(bEx());
          localObject2 = ((Uri)localObject2).getHost();
          localObject1 = ((Uri)localObject1).getHost();
          ad.i("MicroMsg.NfcWebViewUI", "targetHost=" + (String)localObject2 + ", curHost=" + (String)localObject1);
          paramBoolean = ((String)localObject2).equals(localObject1);
          if (paramBoolean)
          {
            if (i != 0) {
              this.ASw.f(4007, new Bundle());
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
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26713);
    if (this.ufd)
    {
      cWL();
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
    if (ay(localIntent)) {
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
      com.tencent.mm.sdk.b.a.ESL.c(this.ufe);
      com.tencent.mm.bs.d.eBj();
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
      tt(false);
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
    com.tencent.mm.sdk.b.a.ESL.d(this.ufe);
    AppMethodBeat.o(26700);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(26702);
    if (ay(paramIntent))
    {
      ad.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
      AppMethodBeat.o(26702);
      return;
    }
    paramIntent.putExtra("key_trust_url", false);
    super.onNewIntent(paramIntent);
    String str = bEx();
    setIntent(paramIntent);
    if ((!bt.isNullOrNil(str)) && (bt.isNullOrNil(bEx()))) {
      paramIntent.putExtra("rawUrl", str);
    }
    int i = y.getIntExtra(paramIntent, "wizard_activity_result_code", 2147483647);
    ad.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    if (i != 2147483647) {
      this.ufd = true;
    }
    switch (i)
    {
    default: 
    case -1: 
    case 1: 
      for (;;)
      {
        nO(true);
        ad.i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(paramIntent)));
        AppMethodBeat.o(26702);
        return;
        a(AutoLoginActivity.a.BUu, paramIntent);
        continue;
        a(AutoLoginActivity.a.BUw, paramIntent);
      }
    }
    cWI();
    AppMethodBeat.o(26702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI
 * JD-Core Version:    0.7.0.1
 */