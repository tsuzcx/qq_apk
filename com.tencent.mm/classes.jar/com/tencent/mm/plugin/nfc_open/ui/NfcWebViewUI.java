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
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NfcWebViewUI
  extends WebViewUI
{
  private boolean pgA;
  private com.tencent.mm.plugin.nfc_open.a.a pgB;
  private String pgz;
  
  public NfcWebViewUI()
  {
    AppMethodBeat.i(23072);
    this.pgz = null;
    this.pgA = false;
    this.pgB = new com.tencent.mm.plugin.nfc_open.a.a();
    AppMethodBeat.o(23072);
  }
  
  private static String AJ(int paramInt)
  {
    AppMethodBeat.i(23081);
    StringBuilder localStringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    localStringBuilder.append("&type=").append(paramInt);
    String str;
    if ((!g.ymO) && (aa.dsG().equals("zh_CN"))) {
      str = "zh_CN";
    }
    for (;;)
    {
      localStringBuilder.append("&lang=").append(str);
      str = localStringBuilder.toString();
      AppMethodBeat.o(23081);
      return str;
      if (aa.dsE()) {
        str = "zh_TW";
      } else {
        str = "en";
      }
    }
  }
  
  private String VT(String paramString)
  {
    AppMethodBeat.i(23083);
    ab.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
    this.pgz = "";
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
          ab.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str1 + " anwser = " + str2);
          bool1 = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str1)), str2);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          i = i + 1 + 1;
        }
        if (bool2)
        {
          this.pgz = paramString[(paramString.length - 1)];
          ab.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.pgz);
          paramString = this.pgz;
          AppMethodBeat.o(23083);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
      ab.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + paramString.toString());
      ab.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.bWY().eI(getContext()))));
      this.pgz = AJ(1);
      paramString = this.pgz;
      AppMethodBeat.o(23083);
      return paramString;
    }
    paramString = this.pgz;
    AppMethodBeat.o(23083);
    return paramString;
  }
  
  private String VU(String paramString)
  {
    AppMethodBeat.i(23084);
    ab.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
    this.pgz = "";
    Object localObject1 = new bgk();
    if (!bo.isNullOrNil(paramString)) {}
    for (;;)
    {
      int k;
      try
      {
        ((bgk)localObject1).parseFrom(paramString.getBytes("ISO-8859-1"));
        if (((bgk)localObject1).wOn != null)
        {
          i = 0;
          int m = 0;
          if (m < ((bgk)localObject1).wOn.size())
          {
            paramString = (oi)((bgk)localObject1).wOn.get(m);
            Object localObject2 = com.tencent.mm.plugin.nfc.b.a.a.bWY();
            if (((com.tencent.mm.plugin.nfc.b.a.a)localObject2).pgs != null) {
              ((com.tencent.mm.plugin.nfc.b.a.a)localObject2).pgs.bWZ();
            }
            k = i;
            if (paramString != null)
            {
              k = i;
              if (!bo.isNullOrNil(paramString.wki))
              {
                k = i;
                if (!bo.es(paramString.wDJ))
                {
                  k = 0;
                  if (k >= paramString.wDJ.size()) {
                    break label592;
                  }
                  if (bo.es(((vp)paramString.wDJ.get(k)).wOq)) {
                    break label565;
                  }
                  j = 0;
                  if (j >= ((vp)paramString.wDJ.get(k)).wOq.size()) {
                    break label562;
                  }
                  if ((((vp)paramString.wDJ.get(k)).wOq.get(j) == null) || (bo.isNullOrNil(((ub)((vp)paramString.wDJ.get(k)).wOq.get(j)).wMy)) || (bo.isNullOrNil(((ub)((vp)paramString.wDJ.get(k)).wOq.get(j)).ooD))) {
                    break label559;
                  }
                  localObject2 = ((ub)((vp)paramString.wDJ.get(k)).wOq.get(j)).wMy;
                  String str = ((ub)((vp)paramString.wDJ.get(k)).wOq.get(j)).ooD;
                  ab.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + (String)localObject2 + " anwser = " + str);
                  if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray((String)localObject2)), str)) {
                    break label575;
                  }
                  i = 1;
                  break label568;
                  k = j;
                  if (j != 0)
                  {
                    localObject1 = paramString.wki;
                    ab.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                    com.tencent.mm.sdk.g.d.post(new NfcWebViewUI.2(this, (String)localObject1), getClass().getName());
                    paramString = paramString.wki;
                    AppMethodBeat.o(23084);
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
        paramString = this.pgz;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
        ab.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + paramString.toString());
        ab.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.bWY().eI(getContext()))));
        this.pgz = AJ(1);
        paramString = this.pgz;
        AppMethodBeat.o(23084);
        return paramString;
      }
      AppMethodBeat.o(23084);
      return paramString;
      label559:
      break label568;
      label562:
      break label577;
      label565:
      break label583;
      label568:
      j += 1;
      continue;
      label575:
      int i = 0;
      label577:
      int j = i;
      if (i == 0)
      {
        label583:
        k += 1;
        continue;
        label592:
        j = i;
      }
    }
  }
  
  private void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(23078);
    switch (3.jLR[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(23078);
      return;
    }
    parama = w.p(paramIntent, "android.nfc.extra.TAG");
    if ((parama != null) && ((parama instanceof Tag))) {}
    for (parama = (Tag)parama;; parama = null)
    {
      if (parama == null)
      {
        ab.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
        AppMethodBeat.o(23078);
        return;
      }
      try
      {
        com.tencent.mm.plugin.nfc.b.a.a.bWY().a(parama);
        ab.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.bWY().eJ(getContext()))));
        AppMethodBeat.o(23078);
        return;
      }
      catch (Exception parama)
      {
        ab.e("MicroMsg.NfcWebViewUI", "exp protect");
        AppMethodBeat.o(23078);
        return;
      }
    }
  }
  
  private static boolean a(com.tencent.mm.plugin.nfc.a.a parama, String paramString)
  {
    AppMethodBeat.i(23085);
    ab.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
    if (fC(paramString, com.tencent.mm.plugin.nfc.b.a.a.bWY().a(parama).toString()))
    {
      AppMethodBeat.o(23085);
      return true;
    }
    AppMethodBeat.o(23085);
    return false;
  }
  
  private static boolean aj(Intent paramIntent)
  {
    AppMethodBeat.i(23089);
    if (paramIntent == null)
    {
      ab.e("MicroMsg.NfcWebViewUI", "intent is null");
      AppMethodBeat.o(23089);
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
          ab.e("MicroMsg.NfcWebViewUI", "extra wrong key = ".concat(String.valueOf(str)));
          ((Iterator)localObject).remove();
        }
      }
      paramIntent = w.p(paramIntent, "android.nfc.extra.TAG");
    }
    catch (Exception paramIntent)
    {
      ab.e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", new Object[] { paramIntent });
      AppMethodBeat.o(23089);
      return true;
    }
    if ((paramIntent != null) && ((paramIntent instanceof Tag))) {}
    for (paramIntent = (Tag)paramIntent;; paramIntent = null)
    {
      if (paramIntent == null)
      {
        ab.e("MicroMsg.NfcWebViewUI", "tag is null");
        AppMethodBeat.o(23089);
        return true;
      }
      AppMethodBeat.o(23089);
      return false;
    }
  }
  
  private boolean bXc()
  {
    AppMethodBeat.i(23077);
    try
    {
      if (this.igU.ddn())
      {
        ab.w("MicroMsg.NfcWebViewUI", "not login");
        Intent localIntent = new Intent(this, getClass());
        localIntent.putExtras(getIntent());
        localIntent.addFlags(67108864);
        this.igU.aA(localIntent);
        AppMethodBeat.o(23077);
        return true;
      }
    }
    catch (RemoteException localRemoteException)
    {
      ab.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(23077);
      return true;
    }
    AppMethodBeat.o(23077);
    return false;
  }
  
  private boolean bXd()
  {
    AppMethodBeat.i(23080);
    boolean bool = this.cJr.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    AppMethodBeat.o(23080);
    return bool;
  }
  
  private String bXe()
  {
    Object localObject1 = null;
    AppMethodBeat.i(23082);
    ab.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
    for (;;)
    {
      try
      {
        localObject2 = this.igU.i(4006, null);
        if (localObject2 == null)
        {
          ab.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
          AppMethodBeat.o(23082);
          return null;
        }
        ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
        str = ((Bundle)localObject2).getString("debugConfig");
        localObject2 = ((Bundle)localObject2).getString("config");
        if (str == null) {
          continue;
        }
        str = VT(str);
        localObject1 = str;
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject2;
        String str;
        ab.e("MicroMsg.NfcWebViewUI", localRemoteException.toString());
        ab.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      ab.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bo.nullAsNil(localObject1));
      AppMethodBeat.o(23082);
      return localObject1;
      str = VU((String)localObject2);
      localObject1 = str;
    }
  }
  
  private void bXf()
  {
    AppMethodBeat.i(23088);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.bq.d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    overridePendingTransition(2131034130, 2131034222);
    ab.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    AppMethodBeat.o(23088);
  }
  
  private static boolean fC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23086);
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(23086);
      return false;
    }
    ab.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bo.nullAsNil(paramString1) + " resp = " + bo.nullAsNil(paramString2));
    if (Pattern.compile(paramString1, 2).matcher(paramString2).find())
    {
      AppMethodBeat.o(23086);
      return true;
    }
    AppMethodBeat.o(23086);
    return false;
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(23075);
    if (bXc())
    {
      finish();
      ab.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
      AppMethodBeat.o(23075);
      return;
    }
    super.aMf();
    a(AutoLoginActivity.a.vPN, getIntent());
    AppMethodBeat.o(23075);
  }
  
  public final void jT(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(23079);
    if (this.igU == null)
    {
      ab.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
      AppMethodBeat.o(23079);
      return;
    }
    a(AutoLoginActivity.a.vPN, getIntent());
    Object localObject1 = bXe();
    if ((paramBoolean) && (!bo.isNullOrNil(this.cJr))) {
      if (bXd()) {
        if (bo.isNullOrNil((String)localObject1)) {
          ab.e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        }
      }
    }
    for (;;)
    {
      if (bo.isNullOrNil(this.cJr))
      {
        this.cJr = AJ(0);
        ab.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
      }
      getIntent().putExtra("rawUrl", this.cJr);
      AppMethodBeat.o(23079);
      return;
      ab.i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", new Object[] { localObject1 });
      this.cJr = ((String)localObject1);
      getIntent().putExtra("rawUrl", this.cJr);
      ax(this.cJr, false);
      continue;
      for (;;)
      {
        try
        {
          paramBoolean = bo.isNullOrNil((String)localObject1);
          if (paramBoolean) {
            continue;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject2;
          ab.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
          continue;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject1);
          localObject1 = Uri.parse(this.cJr);
          localObject2 = ((Uri)localObject2).getHost();
          localObject1 = ((Uri)localObject1).getHost();
          ab.i("MicroMsg.NfcWebViewUI", "targetHost=" + (String)localObject2 + ", curHost=" + (String)localObject1);
          paramBoolean = ((String)localObject2).equals(localObject1);
          if (paramBoolean)
          {
            if (i != 0) {
              this.uWu.e(4007, new Bundle());
            }
            ab.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
            AppMethodBeat.o(23079);
            return;
          }
        }
        catch (Exception localException) {}
        i = 0;
      }
      this.cJr = localRemoteException;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(23087);
    if (this.pgA)
    {
      bXf();
      AppMethodBeat.o(23087);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(23087);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23073);
    Intent localIntent = getIntent();
    if (aj(localIntent)) {
      ab.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
    }
    try
    {
      localIntent.putExtra("key_trust_url", false);
      label35:
      super.onCreate(paramBundle);
      finish();
      AppMethodBeat.o(23073);
      return;
      localIntent.putExtra("key_trust_url", false);
      super.onCreate(paramBundle);
      com.tencent.mm.sdk.b.a.ymk.c(this.pgB);
      com.tencent.mm.bq.d.dpU();
      ab.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + localIntent.getAction());
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(23069);
          if (NfcWebViewUI.a(NfcWebViewUI.this)) {
            NfcWebViewUI.b(NfcWebViewUI.this);
          }
          for (;;)
          {
            AppMethodBeat.o(23069);
            return true;
            NfcWebViewUI.this.finish();
          }
        }
      });
      getIntent().putExtra("showShare", false);
      or(false);
      AppMethodBeat.o(23073);
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
    AppMethodBeat.i(23074);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ymk.d(this.pgB);
    AppMethodBeat.o(23074);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(23076);
    if (aj(paramIntent))
    {
      ab.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
      AppMethodBeat.o(23076);
      return;
    }
    paramIntent.putExtra("key_trust_url", false);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    int i = w.a(paramIntent, "wizard_activity_result_code", 2147483647);
    ab.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    if (i != 2147483647) {
      this.pgA = true;
    }
    switch (i)
    {
    default: 
    case -1: 
    case 1: 
      for (;;)
      {
        jT(true);
        ab.i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(paramIntent)));
        AppMethodBeat.o(23076);
        return;
        a(AutoLoginActivity.a.vPN, paramIntent);
        continue;
        a(AutoLoginActivity.a.vPP, paramIntent);
      }
    }
    bXc();
    AppMethodBeat.o(23076);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI
 * JD-Core Version:    0.7.0.1
 */