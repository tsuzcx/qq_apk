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
import com.tencent.mm.plugin.nfc.b.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NfcWebViewUI
  extends WebViewUI
{
  private static final String AEo;
  private String AEp;
  private boolean AEq;
  private com.tencent.mm.plugin.nfc_open.a.a AEr;
  
  static
  {
    AppMethodBeat.i(231766);
    AEo = "https://" + WeChatHosts.domainString(2131761742) + "/security/readtemplate?t=bus_recharge/index_error";
    AppMethodBeat.o(231766);
  }
  
  public NfcWebViewUI()
  {
    AppMethodBeat.i(26698);
    this.AEp = null;
    this.AEq = false;
    this.AEr = new com.tencent.mm.plugin.nfc_open.a.a();
    AppMethodBeat.o(26698);
  }
  
  private static String TI(int paramInt)
  {
    AppMethodBeat.i(26707);
    StringBuilder localStringBuilder = new StringBuilder(AEo);
    localStringBuilder.append("&type=").append(paramInt);
    String str;
    if ((!ChannelUtil.isNokiaAol) && (LocaleUtil.getApplicationLanguage().equals("zh_CN"))) {
      str = "zh_CN";
    }
    for (;;)
    {
      localStringBuilder.append("&lang=").append(str);
      str = localStringBuilder.toString();
      AppMethodBeat.o(26707);
      return str;
      if (LocaleUtil.isTraditionalChineseAppLang()) {
        str = "zh_TW";
      } else {
        str = "en";
      }
    }
  }
  
  private void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(26704);
    switch (3.pdF[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(26704);
      return;
    }
    parama = IntentUtil.getParcelableExtra(paramIntent, "android.nfc.extra.TAG");
    if ((parama != null) && ((parama instanceof Tag))) {}
    for (parama = (Tag)parama;; parama = null)
    {
      if (parama == null)
      {
        Log.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
        AppMethodBeat.o(26704);
        return;
      }
      try
      {
        com.tencent.mm.plugin.nfc.b.a.a.exw().a(parama);
        Log.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.exw().gJ(getContext()))));
        AppMethodBeat.o(26704);
        return;
      }
      catch (Exception parama)
      {
        Log.e("MicroMsg.NfcWebViewUI", "exp protect");
        AppMethodBeat.o(26704);
        return;
      }
    }
  }
  
  private static boolean a(com.tencent.mm.plugin.nfc.a.a parama, String paramString)
  {
    AppMethodBeat.i(26711);
    Log.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
    if (je(paramString, com.tencent.mm.plugin.nfc.b.a.a.exw().a(parama).toString()))
    {
      AppMethodBeat.o(26711);
      return true;
    }
    AppMethodBeat.o(26711);
    return false;
  }
  
  private String aIF(String paramString)
  {
    AppMethodBeat.i(26709);
    Log.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
    this.AEp = "";
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
          Log.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str1 + " anwser = " + str2);
          bool1 = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str1)), str2);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          i = i + 1 + 1;
        }
        if (bool2)
        {
          this.AEp = paramString[(paramString.length - 1)];
          Log.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.AEp);
          paramString = this.AEp;
          AppMethodBeat.o(26709);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
      Log.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + paramString.toString());
      Log.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.exw().gI(getContext()))));
      this.AEp = TI(1);
      paramString = this.AEp;
      AppMethodBeat.o(26709);
      return paramString;
    }
    paramString = this.AEp;
    AppMethodBeat.o(26709);
    return paramString;
  }
  
  private String aIG(String paramString)
  {
    AppMethodBeat.i(26710);
    Log.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
    this.AEp = "";
    Object localObject1 = new ctt();
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      int k;
      try
      {
        ((ctt)localObject1).parseFrom(paramString.getBytes("ISO-8859-1"));
        if (((ctt)localObject1).Lps != null)
        {
          i = 0;
          int m = 0;
          if (m < ((ctt)localObject1).Lps.size())
          {
            paramString = (tx)((ctt)localObject1).Lps.get(m);
            Object localObject2 = com.tencent.mm.plugin.nfc.b.a.a.exw();
            if (((com.tencent.mm.plugin.nfc.b.a.a)localObject2).AEi != null) {
              ((com.tencent.mm.plugin.nfc.b.a.a)localObject2).AEi.exx();
            }
            k = i;
            if (paramString != null)
            {
              k = i;
              if (!Util.isNullOrNil(paramString.KBH))
              {
                k = i;
                if (!Util.isNullOrNil(paramString.Lch))
                {
                  k = 0;
                  if (k >= paramString.Lch.size()) {
                    break label594;
                  }
                  if (Util.isNullOrNil(((adz)paramString.Lch.get(k)).Lpv)) {
                    break label567;
                  }
                  j = 0;
                  if (j >= ((adz)paramString.Lch.get(k)).Lpv.size()) {
                    break label564;
                  }
                  if ((((adz)paramString.Lch.get(k)).Lpv.get(j) == null) || (Util.isNullOrNil(((abl)((adz)paramString.Lch.get(k)).Lpv.get(j)).Lmp)) || (Util.isNullOrNil(((abl)((adz)paramString.Lch.get(k)).Lpv.get(j)).yWF))) {
                    break label561;
                  }
                  localObject2 = ((abl)((adz)paramString.Lch.get(k)).Lpv.get(j)).Lmp;
                  String str = ((abl)((adz)paramString.Lch.get(k)).Lpv.get(j)).yWF;
                  Log.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + (String)localObject2 + " anwser = " + str);
                  if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray((String)localObject2)), str)) {
                    break label577;
                  }
                  i = 1;
                  break label570;
                  k = j;
                  if (j != 0)
                  {
                    localObject1 = paramString.KBH;
                    Log.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                    ThreadPool.post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(26696);
                        h.CyF.a(12794, new Object[] { this.AEt, Integer.valueOf(0) });
                        Log.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.AEt);
                        AppMethodBeat.o(26696);
                      }
                    }, getClass().getName());
                    paramString = paramString.KBH;
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
        paramString = this.AEp;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
        Log.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + paramString.toString());
        Log.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.exw().gI(getContext()))));
        this.AEp = TI(1);
        paramString = this.AEp;
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
  
  private static boolean aN(Intent paramIntent)
  {
    AppMethodBeat.i(26715);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.NfcWebViewUI", "intent is null");
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
          Log.e("MicroMsg.NfcWebViewUI", "extra wrong key = ".concat(String.valueOf(str)));
          ((Iterator)localObject).remove();
        }
      }
      paramIntent = IntentUtil.getParcelableExtra(paramIntent, "android.nfc.extra.TAG");
    }
    catch (Exception paramIntent)
    {
      Log.e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", new Object[] { paramIntent });
      AppMethodBeat.o(26715);
      return true;
    }
    if ((paramIntent != null) && ((paramIntent instanceof Tag))) {}
    for (paramIntent = (Tag)paramIntent;; paramIntent = null)
    {
      if (paramIntent == null)
      {
        Log.e("MicroMsg.NfcWebViewUI", "tag is null");
        AppMethodBeat.o(26715);
        return true;
      }
      AppMethodBeat.o(26715);
      return false;
    }
  }
  
  private boolean exA()
  {
    AppMethodBeat.i(26703);
    try
    {
      if (this.mHh.gei())
      {
        Log.w("MicroMsg.NfcWebViewUI", "not login");
        Intent localIntent = new Intent(this, getClass());
        localIntent.putExtras(getIntent());
        localIntent.addFlags(67108864);
        this.mHh.bm(localIntent);
        AppMethodBeat.o(26703);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.NfcWebViewUI", localException, "", new Object[0]);
      AppMethodBeat.o(26703);
      return true;
    }
    AppMethodBeat.o(26703);
    return false;
  }
  
  private boolean exB()
  {
    AppMethodBeat.i(26706);
    boolean bool = coX().startsWith(AEo);
    AppMethodBeat.o(26706);
    return bool;
  }
  
  private String exC()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26708);
    Log.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
    for (;;)
    {
      try
      {
        localObject2 = this.mHh.j(4006, null);
        if (localObject2 == null)
        {
          Log.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
          AppMethodBeat.o(26708);
          return null;
        }
        ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
        str = ((Bundle)localObject2).getString("debugConfig");
        localObject2 = ((Bundle)localObject2).getString("config");
        if (str == null) {
          continue;
        }
        str = aIF(str);
        localObject1 = str;
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject2;
        String str;
        Log.e("MicroMsg.NfcWebViewUI", localRemoteException.toString());
        Log.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      Log.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + Util.nullAsNil(localObject1));
      AppMethodBeat.o(26708);
      return localObject1;
      str = aIG((String)localObject2);
      localObject1 = str;
    }
  }
  
  private void exD()
  {
    AppMethodBeat.i(26714);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.br.c.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    overridePendingTransition(2130771986, 2130772124);
    Log.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    AppMethodBeat.o(26714);
  }
  
  private static boolean je(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26712);
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26712);
      return false;
    }
    Log.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + Util.nullAsNil(paramString1) + " resp = " + Util.nullAsNil(paramString2));
    if (Pattern.compile(paramString1, 2).matcher(paramString2).find())
    {
      AppMethodBeat.o(26712);
      return true;
    }
    AppMethodBeat.o(26712);
    return false;
  }
  
  public final void bXg()
  {
    AppMethodBeat.i(26701);
    super.bXg();
    if (exA())
    {
      finish();
      Log.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
      AppMethodBeat.o(26701);
      return;
    }
    a(AutoLoginActivity.a.Kba, getIntent());
    su(false);
    AppMethodBeat.o(26701);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26713);
    if (this.AEq)
    {
      exD();
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
    if (aN(localIntent)) {
      Log.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
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
      EventCenter.instance.addListener(this.AEr);
      com.tencent.mm.br.c.gsX();
      Log.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + localIntent.getAction());
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
      zj(false);
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
    EventCenter.instance.removeListener(this.AEr);
    AppMethodBeat.o(26700);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(26702);
    if (aN(paramIntent))
    {
      Log.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
      AppMethodBeat.o(26702);
      return;
    }
    paramIntent.putExtra("key_trust_url", false);
    super.onNewIntent(paramIntent);
    String str = coX();
    setIntent(paramIntent);
    if ((!Util.isNullOrNil(str)) && (Util.isNullOrNil(coX()))) {
      paramIntent.putExtra("rawUrl", str);
    }
    int i = IntentUtil.getIntExtra(paramIntent, "wizard_activity_result_code", 2147483647);
    Log.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    if (i != 2147483647) {
      this.AEq = true;
    }
    switch (i)
    {
    default: 
    case -1: 
    case 1: 
      for (;;)
      {
        su(true);
        Log.i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(paramIntent)));
        AppMethodBeat.o(26702);
        return;
        a(AutoLoginActivity.a.Kba, paramIntent);
        continue;
        a(AutoLoginActivity.a.Kbc, paramIntent);
      }
    }
    exA();
    AppMethodBeat.o(26702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void su(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(26705);
    if (this.mHh == null)
    {
      Log.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
      AppMethodBeat.o(26705);
      return;
    }
    a(AutoLoginActivity.a.Kba, getIntent());
    Object localObject1 = exC();
    if ((paramBoolean) && (!Util.isNullOrNil(coX()))) {
      if (exB()) {
        if (Util.isNullOrNil((String)localObject1)) {
          Log.e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        }
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil(coX()))
      {
        getIntent().putExtra("rawUrl", TI(0));
        Log.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
      }
      this.IMH.aB(getIntent());
      AppMethodBeat.o(26705);
      return;
      Log.i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", new Object[] { localObject1 });
      getIntent().putExtra("rawUrl", (String)localObject1);
      this.IMH.k((String)localObject1, false, -1);
      continue;
      for (;;)
      {
        try
        {
          paramBoolean = Util.isNullOrNil((String)localObject1);
          if (paramBoolean) {
            continue;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject2;
          Log.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
          continue;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject1);
          localObject1 = Uri.parse(coX());
          localObject2 = ((Uri)localObject2).getHost();
          localObject1 = ((Uri)localObject1).getHost();
          Log.i("MicroMsg.NfcWebViewUI", "targetHost=" + (String)localObject2 + ", curHost=" + (String)localObject1);
          paramBoolean = ((String)localObject2).equals(localObject1);
          if (paramBoolean)
          {
            if (i != 0) {
              this.ISw.f(4007, new Bundle());
            }
            Log.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
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