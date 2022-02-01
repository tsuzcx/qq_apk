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
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NfcWebViewUI
  extends WebViewUI
{
  private String vob;
  private boolean voc;
  private com.tencent.mm.plugin.nfc_open.a.a vod;
  
  public NfcWebViewUI()
  {
    AppMethodBeat.i(26698);
    this.vob = null;
    this.voc = false;
    this.vod = new com.tencent.mm.plugin.nfc_open.a.a();
    AppMethodBeat.o(26698);
  }
  
  private static String Ku(int paramInt)
  {
    AppMethodBeat.i(26707);
    StringBuilder localStringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    localStringBuilder.append("&type=").append(paramInt);
    String str;
    if ((!i.GqM) && (ab.eUO().equals("zh_CN"))) {
      str = "zh_CN";
    }
    for (;;)
    {
      localStringBuilder.append("&lang=").append(str);
      str = localStringBuilder.toString();
      AppMethodBeat.o(26707);
      return str;
      if (ab.eUM()) {
        str = "zh_TW";
      } else {
        str = "en";
      }
    }
  }
  
  private void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(26704);
    switch (3.nmN[parama.ordinal()])
    {
    default: 
      finish();
      AppMethodBeat.o(26704);
      return;
    }
    parama = x.r(paramIntent, "android.nfc.extra.TAG");
    if ((parama != null) && ((parama instanceof Tag))) {}
    for (parama = (Tag)parama;; parama = null)
    {
      if (parama == null)
      {
        ac.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
        AppMethodBeat.o(26704);
        return;
      }
      try
      {
        com.tencent.mm.plugin.nfc.b.a.a.dkm().a(parama);
        ac.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.dkm().fQ(getContext()))));
        AppMethodBeat.o(26704);
        return;
      }
      catch (Exception parama)
      {
        ac.e("MicroMsg.NfcWebViewUI", "exp protect");
        AppMethodBeat.o(26704);
        return;
      }
    }
  }
  
  private static boolean a(com.tencent.mm.plugin.nfc.a.a parama, String paramString)
  {
    AppMethodBeat.i(26711);
    ac.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
    if (ic(paramString, com.tencent.mm.plugin.nfc.b.a.a.dkm().a(parama).toString()))
    {
      AppMethodBeat.o(26711);
      return true;
    }
    AppMethodBeat.o(26711);
    return false;
  }
  
  private String aok(String paramString)
  {
    AppMethodBeat.i(26709);
    ac.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
    this.vob = "";
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
          ac.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str1 + " anwser = " + str2);
          bool1 = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str1)), str2);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          i = i + 1 + 1;
        }
        if (bool2)
        {
          this.vob = paramString[(paramString.length - 1)];
          ac.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.vob);
          paramString = this.vob;
          AppMethodBeat.o(26709);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
      ac.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + paramString.toString());
      ac.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.dkm().fP(getContext()))));
      this.vob = Ku(1);
      paramString = this.vob;
      AppMethodBeat.o(26709);
      return paramString;
    }
    paramString = this.vob;
    AppMethodBeat.o(26709);
    return paramString;
  }
  
  private String aol(String paramString)
  {
    AppMethodBeat.i(26710);
    ac.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
    this.vob = "";
    Object localObject1 = new byc();
    if (!bs.isNullOrNil(paramString)) {}
    for (;;)
    {
      int k;
      try
      {
        ((byc)localObject1).parseFrom(paramString.getBytes("ISO-8859-1"));
        if (((byc)localObject1).EtR != null)
        {
          i = 0;
          int m = 0;
          if (m < ((byc)localObject1).EtR.size())
          {
            paramString = (qx)((byc)localObject1).EtR.get(m);
            Object localObject2 = com.tencent.mm.plugin.nfc.b.a.a.dkm();
            if (((com.tencent.mm.plugin.nfc.b.a.a)localObject2).vnV != null) {
              ((com.tencent.mm.plugin.nfc.b.a.a)localObject2).vnV.dkn();
            }
            k = i;
            if (paramString != null)
            {
              k = i;
              if (!bs.isNullOrNil(paramString.DKP))
              {
                k = i;
                if (!bs.gY(paramString.EhV))
                {
                  k = 0;
                  if (k >= paramString.EhV.size()) {
                    break label594;
                  }
                  if (bs.gY(((zo)paramString.EhV.get(k)).EtU)) {
                    break label567;
                  }
                  j = 0;
                  if (j >= ((zo)paramString.EhV.get(k)).EtU.size()) {
                    break label564;
                  }
                  if ((((zo)paramString.EhV.get(k)).EtU.get(j) == null) || (bs.isNullOrNil(((xt)((zo)paramString.EhV.get(k)).EtU.get(j)).ErI)) || (bs.isNullOrNil(((xt)((zo)paramString.EhV.get(k)).EtU.get(j)).umW))) {
                    break label561;
                  }
                  localObject2 = ((xt)((zo)paramString.EhV.get(k)).EtU.get(j)).ErI;
                  String str = ((xt)((zo)paramString.EhV.get(k)).EtU.get(j)).umW;
                  ac.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + (String)localObject2 + " anwser = " + str);
                  if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray((String)localObject2)), str)) {
                    break label577;
                  }
                  i = 1;
                  break label570;
                  k = j;
                  if (j != 0)
                  {
                    localObject1 = paramString.DKP;
                    ac.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                    b.c(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(26696);
                        com.tencent.mm.plugin.report.service.h.wUl.f(12794, new Object[] { this.vof, Integer.valueOf(0) });
                        ac.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.vof);
                        AppMethodBeat.o(26696);
                      }
                    }, getClass().getName());
                    paramString = paramString.DKP;
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
        paramString = this.vob;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
        ac.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + paramString.toString());
        ac.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.dkm().fP(getContext()))));
        this.vob = Ku(1);
        paramString = this.vob;
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
  
  private static boolean az(Intent paramIntent)
  {
    AppMethodBeat.i(26715);
    if (paramIntent == null)
    {
      ac.e("MicroMsg.NfcWebViewUI", "intent is null");
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
          ac.e("MicroMsg.NfcWebViewUI", "extra wrong key = ".concat(String.valueOf(str)));
          ((Iterator)localObject).remove();
        }
      }
      paramIntent = x.r(paramIntent, "android.nfc.extra.TAG");
    }
    catch (Exception paramIntent)
    {
      ac.e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", new Object[] { paramIntent });
      AppMethodBeat.o(26715);
      return true;
    }
    if ((paramIntent != null) && ((paramIntent instanceof Tag))) {}
    for (paramIntent = (Tag)paramIntent;; paramIntent = null)
    {
      if (paramIntent == null)
      {
        ac.e("MicroMsg.NfcWebViewUI", "tag is null");
        AppMethodBeat.o(26715);
        return true;
      }
      AppMethodBeat.o(26715);
      return false;
    }
  }
  
  private boolean dkq()
  {
    AppMethodBeat.i(26703);
    try
    {
      if (this.kYt.eCO())
      {
        ac.w("MicroMsg.NfcWebViewUI", "not login");
        Intent localIntent = new Intent(this, getClass());
        localIntent.putExtras(getIntent());
        localIntent.addFlags(67108864);
        this.kYt.aV(localIntent);
        AppMethodBeat.o(26703);
        return true;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.NfcWebViewUI", localException, "", new Object[0]);
      AppMethodBeat.o(26703);
      return true;
    }
    AppMethodBeat.o(26703);
    return false;
  }
  
  private boolean dkr()
  {
    AppMethodBeat.i(26706);
    boolean bool = bLL().startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    AppMethodBeat.o(26706);
    return bool;
  }
  
  private String dks()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26708);
    ac.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
    for (;;)
    {
      try
      {
        localObject2 = this.kYt.k(4006, null);
        if (localObject2 == null)
        {
          ac.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
          AppMethodBeat.o(26708);
          return null;
        }
        ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
        str = ((Bundle)localObject2).getString("debugConfig");
        localObject2 = ((Bundle)localObject2).getString("config");
        if (str == null) {
          continue;
        }
        str = aok(str);
        localObject1 = str;
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject2;
        String str;
        ac.e("MicroMsg.NfcWebViewUI", localRemoteException.toString());
        ac.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      ac.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bs.nullAsNil(localObject1));
      AppMethodBeat.o(26708);
      return localObject1;
      str = aol((String)localObject2);
      localObject1 = str;
    }
  }
  
  private void dkt()
  {
    AppMethodBeat.i(26714);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.br.d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    overridePendingTransition(2130771986, 2130772100);
    ac.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    AppMethodBeat.o(26714);
  }
  
  private static boolean ic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26712);
    if (bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26712);
      return false;
    }
    ac.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bs.nullAsNil(paramString1) + " resp = " + bs.nullAsNil(paramString2));
    if (Pattern.compile(paramString1, 2).matcher(paramString2).find())
    {
      AppMethodBeat.o(26712);
      return true;
    }
    AppMethodBeat.o(26712);
    return false;
  }
  
  public final void bvh()
  {
    AppMethodBeat.i(26701);
    super.bvh();
    if (dkq())
    {
      finish();
      ac.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
      AppMethodBeat.o(26701);
      return;
    }
    a(AutoLoginActivity.a.DmK, getIntent());
    oI(false);
    AppMethodBeat.o(26701);
  }
  
  public final void oI(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(26705);
    if (this.kYt == null)
    {
      ac.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
      AppMethodBeat.o(26705);
      return;
    }
    a(AutoLoginActivity.a.DmK, getIntent());
    Object localObject1 = dks();
    if ((paramBoolean) && (!bs.isNullOrNil(bLL()))) {
      if (dkr()) {
        if (bs.isNullOrNil((String)localObject1)) {
          ac.e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        }
      }
    }
    for (;;)
    {
      if (bs.isNullOrNil(bLL()))
      {
        getIntent().putExtra("rawUrl", Ku(0));
        ac.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
      }
      this.Cfr.ao(getIntent());
      AppMethodBeat.o(26705);
      return;
      ac.i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", new Object[] { localObject1 });
      getIntent().putExtra("rawUrl", (String)localObject1);
      this.Cfr.k((String)localObject1, false, -1);
      continue;
      for (;;)
      {
        try
        {
          paramBoolean = bs.isNullOrNil((String)localObject1);
          if (paramBoolean) {
            continue;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject2;
          ac.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
          continue;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject1);
          localObject1 = Uri.parse(bLL());
          localObject2 = ((Uri)localObject2).getHost();
          localObject1 = ((Uri)localObject1).getHost();
          ac.i("MicroMsg.NfcWebViewUI", "targetHost=" + (String)localObject2 + ", curHost=" + (String)localObject1);
          paramBoolean = ((String)localObject2).equals(localObject1);
          if (paramBoolean)
          {
            if (i != 0) {
              this.CkJ.g(4007, new Bundle());
            }
            ac.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
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
    if (this.voc)
    {
      dkt();
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
    if (az(localIntent)) {
      ac.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
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
      com.tencent.mm.sdk.b.a.GpY.c(this.vod);
      com.tencent.mm.br.d.eQD();
      ac.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + localIntent.getAction());
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
      uv(false);
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
    com.tencent.mm.sdk.b.a.GpY.d(this.vod);
    AppMethodBeat.o(26700);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(26702);
    if (az(paramIntent))
    {
      ac.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
      AppMethodBeat.o(26702);
      return;
    }
    paramIntent.putExtra("key_trust_url", false);
    super.onNewIntent(paramIntent);
    String str = bLL();
    setIntent(paramIntent);
    if ((!bs.isNullOrNil(str)) && (bs.isNullOrNil(bLL()))) {
      paramIntent.putExtra("rawUrl", str);
    }
    int i = x.getIntExtra(paramIntent, "wizard_activity_result_code", 2147483647);
    ac.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(i)));
    if (i != 2147483647) {
      this.voc = true;
    }
    switch (i)
    {
    default: 
    case -1: 
    case 1: 
      for (;;)
      {
        oI(true);
        ac.i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(paramIntent)));
        AppMethodBeat.o(26702);
        return;
        a(AutoLoginActivity.a.DmK, paramIntent);
        continue;
        a(AutoLoginActivity.a.DmM, paramIntent);
      }
    }
    dkq();
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