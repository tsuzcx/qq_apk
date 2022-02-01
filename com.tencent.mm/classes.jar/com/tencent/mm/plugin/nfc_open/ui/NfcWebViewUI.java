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
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NfcWebViewUI
  extends WebViewUI
{
  private String wJd;
  private boolean wJe;
  private com.tencent.mm.plugin.nfc_open.a.a wJf;
  
  public NfcWebViewUI()
  {
    AppMethodBeat.i(26698);
    this.wJd = null;
    this.wJe = false;
    this.wJf = new com.tencent.mm.plugin.nfc_open.a.a();
    AppMethodBeat.o(26698);
  }
  
  private static String MB(int paramInt)
  {
    AppMethodBeat.i(26707);
    StringBuilder localStringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    localStringBuilder.append("&type=").append(paramInt);
    String str;
    if ((!k.IwL) && (ad.fom().equals("zh_CN"))) {
      str = "zh_CN";
    }
    for (;;)
    {
      localStringBuilder.append("&lang=").append(str);
      str = localStringBuilder.toString();
      AppMethodBeat.o(26707);
      return str;
      if (ad.fok()) {
        str = "zh_TW";
      } else {
        str = "en";
      }
    }
  }
  
  private void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(26704);
    switch (3.nSR[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(26704);
      return;
    }
    parama = z.r(paramIntent, "android.nfc.extra.TAG");
    if ((parama != null) && ((parama instanceof Tag))) {}
    for (parama = (Tag)parama;; parama = null)
    {
      if (parama == null)
      {
        ae.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
        AppMethodBeat.o(26704);
        return;
      }
      try
      {
        com.tencent.mm.plugin.nfc.b.a.a.dxO().a(parama);
        ae.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.dxO().gb(getContext()))));
        AppMethodBeat.o(26704);
        return;
      }
      catch (Exception parama)
      {
        ae.e("MicroMsg.NfcWebViewUI", "exp protect");
        AppMethodBeat.o(26704);
        return;
      }
    }
  }
  
  private static boolean a(com.tencent.mm.plugin.nfc.a.a parama, String paramString)
  {
    AppMethodBeat.i(26711);
    ae.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
    if (it(paramString, com.tencent.mm.plugin.nfc.b.a.a.dxO().a(parama).toString()))
    {
      AppMethodBeat.o(26711);
      return true;
    }
    AppMethodBeat.o(26711);
    return false;
  }
  
  private static boolean aF(Intent paramIntent)
  {
    AppMethodBeat.i(26715);
    if (paramIntent == null)
    {
      ae.e("MicroMsg.NfcWebViewUI", "intent is null");
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
          ae.e("MicroMsg.NfcWebViewUI", "extra wrong key = ".concat(String.valueOf(str)));
          ((Iterator)localObject).remove();
        }
      }
      paramIntent = z.r(paramIntent, "android.nfc.extra.TAG");
    }
    catch (Exception paramIntent)
    {
      ae.e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", new Object[] { paramIntent });
      AppMethodBeat.o(26715);
      return true;
    }
    if ((paramIntent != null) && ((paramIntent instanceof Tag))) {}
    for (paramIntent = (Tag)paramIntent;; paramIntent = null)
    {
      if (paramIntent == null)
      {
        ae.e("MicroMsg.NfcWebViewUI", "tag is null");
        AppMethodBeat.o(26715);
        return true;
      }
      AppMethodBeat.o(26715);
      return false;
    }
  }
  
  private String auw(String paramString)
  {
    AppMethodBeat.i(26709);
    ae.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
    this.wJd = "";
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
          ae.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str1 + " anwser = " + str2);
          bool1 = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str1)), str2);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          i = i + 1 + 1;
        }
        if (bool2)
        {
          this.wJd = paramString[(paramString.length - 1)];
          ae.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.wJd);
          paramString = this.wJd;
          AppMethodBeat.o(26709);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
      ae.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + paramString.toString());
      ae.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.dxO().ga(getContext()))));
      this.wJd = MB(1);
      paramString = this.wJd;
      AppMethodBeat.o(26709);
      return paramString;
    }
    paramString = this.wJd;
    AppMethodBeat.o(26709);
    return paramString;
  }
  
  private String aux(String paramString)
  {
    AppMethodBeat.i(26710);
    ae.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
    this.wJd = "";
    Object localObject1 = new cdn();
    if (!bu.isNullOrNil(paramString)) {}
    for (;;)
    {
      int k;
      try
      {
        ((cdn)localObject1).parseFrom(paramString.getBytes("ISO-8859-1"));
        if (((cdn)localObject1).GtQ != null)
        {
          i = 0;
          int m = 0;
          if (m < ((cdn)localObject1).GtQ.size())
          {
            paramString = (ss)((cdn)localObject1).GtQ.get(m);
            Object localObject2 = com.tencent.mm.plugin.nfc.b.a.a.dxO();
            if (((com.tencent.mm.plugin.nfc.b.a.a)localObject2).wIX != null) {
              ((com.tencent.mm.plugin.nfc.b.a.a)localObject2).wIX.dxP();
            }
            k = i;
            if (paramString != null)
            {
              k = i;
              if (!bu.isNullOrNil(paramString.FIt))
              {
                k = i;
                if (!bu.ht(paramString.GhE))
                {
                  k = 0;
                  if (k >= paramString.GhE.size()) {
                    break label597;
                  }
                  if (bu.ht(((abx)paramString.GhE.get(k)).GtT)) {
                    break label570;
                  }
                  j = 0;
                  if (j >= ((abx)paramString.GhE.get(k)).GtT.size()) {
                    break label567;
                  }
                  if ((((abx)paramString.GhE.get(k)).GtT.get(j) == null) || (bu.isNullOrNil(((zv)((abx)paramString.GhE.get(k)).GtT.get(j)).Grr)) || (bu.isNullOrNil(((zv)((abx)paramString.GhE.get(k)).GtT.get(j)).vBH))) {
                    break label564;
                  }
                  localObject2 = ((zv)((abx)paramString.GhE.get(k)).GtT.get(j)).Grr;
                  String str = ((zv)((abx)paramString.GhE.get(k)).GtT.get(j)).vBH;
                  ae.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + (String)localObject2 + " anwser = " + str);
                  if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray((String)localObject2)), str)) {
                    break label580;
                  }
                  i = 1;
                  break label573;
                  k = j;
                  if (j != 0)
                  {
                    localObject1 = paramString.FIt;
                    ae.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                    b.c(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(26696);
                        g.yxI.f(12794, new Object[] { this.wJh, Integer.valueOf(0) });
                        ae.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.wJh);
                        AppMethodBeat.o(26696);
                      }
                    }, getClass().getName());
                    paramString = paramString.FIt;
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
        paramString = this.wJd;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
        ae.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + paramString.toString());
        ae.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.dxO().ga(getContext()))));
        this.wJd = MB(1);
        paramString = this.wJd;
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
  
  private boolean dxS()
  {
    AppMethodBeat.i(26703);
    try
    {
      if (this.lzT.eVr())
      {
        ae.w("MicroMsg.NfcWebViewUI", "not login");
        Intent localIntent = new Intent(this, getClass());
        localIntent.putExtras(getIntent());
        localIntent.addFlags(67108864);
        this.lzT.bb(localIntent);
        AppMethodBeat.o(26703);
        return true;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.NfcWebViewUI", localException, "", new Object[0]);
      AppMethodBeat.o(26703);
      return true;
    }
    AppMethodBeat.o(26703);
    return false;
  }
  
  private boolean dxT()
  {
    AppMethodBeat.i(26706);
    boolean bool = bRn().startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    AppMethodBeat.o(26706);
    return bool;
  }
  
  private String dxU()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26708);
    ae.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
    for (;;)
    {
      try
      {
        localObject2 = this.lzT.k(4006, null);
        if (localObject2 == null)
        {
          ae.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
          AppMethodBeat.o(26708);
          return null;
        }
        ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
        str = ((Bundle)localObject2).getString("debugConfig");
        localObject2 = ((Bundle)localObject2).getString("config");
        if (str == null) {
          continue;
        }
        str = auw(str);
        localObject1 = str;
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject2;
        String str;
        ae.e("MicroMsg.NfcWebViewUI", localRemoteException.toString());
        ae.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      ae.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bu.nullAsNil(localObject1));
      AppMethodBeat.o(26708);
      return localObject1;
      str = aux((String)localObject2);
      localObject1 = str;
    }
  }
  
  private void dxV()
  {
    AppMethodBeat.i(26714);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.br.d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    overridePendingTransition(2130771986, 2130772100);
    ae.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    AppMethodBeat.o(26714);
  }
  
  private static boolean it(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26712);
    if (bu.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26712);
      return false;
    }
    ae.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bu.nullAsNil(paramString1) + " resp = " + bu.nullAsNil(paramString2));
    if (Pattern.compile(paramString1, 2).matcher(paramString2).find())
    {
      AppMethodBeat.o(26712);
      return true;
    }
    AppMethodBeat.o(26712);
    return false;
  }
  
  public final void bAi()
  {
    AppMethodBeat.i(26701);
    super.bAi();
    if (dxS())
    {
      finish();
      ae.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
      AppMethodBeat.o(26701);
      return;
    }
    a(AutoLoginActivity.a.Fki, getIntent());
    pp(false);
    AppMethodBeat.o(26701);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26713);
    if (this.wJe)
    {
      dxV();
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
    if (aF(localIntent)) {
      ae.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
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
      com.tencent.mm.sdk.b.a.IvT.c(this.wJf);
      com.tencent.mm.br.d.fjx();
      ae.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + localIntent.getAction());
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
      vo(false);
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
    com.tencent.mm.sdk.b.a.IvT.d(this.wJf);
    AppMethodBeat.o(26700);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(26702);
    if (aF(paramIntent))
    {
      ae.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
      AppMethodBeat.o(26702);
      return;
    }
    paramIntent.putExtra("key_trust_url", false);
    super.onNewIntent(paramIntent);
    String str = bRn();
    setIntent(paramIntent);
    if ((!bu.isNullOrNil(str)) && (bu.isNullOrNil(bRn()))) {
      paramIntent.putExtra("rawUrl", str);
    }
    int i = z.getIntExtra(paramIntent, "wizard_activity_result_code", 2147483647);
    ae.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    if (i != 2147483647) {
      this.wJe = true;
    }
    switch (i)
    {
    default: 
    case -1: 
    case 1: 
      for (;;)
      {
        pp(true);
        ae.i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(paramIntent)));
        AppMethodBeat.o(26702);
        return;
        a(AutoLoginActivity.a.Fki, paramIntent);
        continue;
        a(AutoLoginActivity.a.Fkk, paramIntent);
      }
    }
    dxS();
    AppMethodBeat.o(26702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pp(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(26705);
    if (this.lzT == null)
    {
      ae.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
      AppMethodBeat.o(26705);
      return;
    }
    a(AutoLoginActivity.a.Fki, getIntent());
    Object localObject1 = dxU();
    if ((paramBoolean) && (!bu.isNullOrNil(bRn()))) {
      if (dxT()) {
        if (bu.isNullOrNil((String)localObject1)) {
          ae.e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        }
      }
    }
    for (;;)
    {
      if (bu.isNullOrNil(bRn()))
      {
        getIntent().putExtra("rawUrl", MB(0));
        ae.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
      }
      this.Eat.au(getIntent());
      AppMethodBeat.o(26705);
      return;
      ae.i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", new Object[] { localObject1 });
      getIntent().putExtra("rawUrl", (String)localObject1);
      this.Eat.k((String)localObject1, false, -1);
      continue;
      for (;;)
      {
        try
        {
          paramBoolean = bu.isNullOrNil((String)localObject1);
          if (paramBoolean) {
            continue;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject2;
          ae.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
          continue;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject1);
          localObject1 = Uri.parse(bRn());
          localObject2 = ((Uri)localObject2).getHost();
          localObject1 = ((Uri)localObject1).getHost();
          ae.i("MicroMsg.NfcWebViewUI", "targetHost=" + (String)localObject2 + ", curHost=" + (String)localObject1);
          paramBoolean = ((String)localObject2).equals(localObject1);
          if (paramBoolean)
          {
            if (i != 0) {
              this.EfN.g(4007, new Bundle());
            }
            ae.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
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