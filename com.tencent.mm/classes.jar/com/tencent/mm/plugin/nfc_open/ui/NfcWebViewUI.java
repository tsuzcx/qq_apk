package com.tencent.mm.plugin.nfc_open.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.qu;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NfcWebViewUI
  extends WebViewUI
{
  private String mGt = null;
  private boolean mGu = false;
  private com.tencent.mm.plugin.nfc_open.a.a mGv = new com.tencent.mm.plugin.nfc_open.a.a();
  
  private String JT(String paramString)
  {
    y.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
    this.mGt = "";
    try
    {
      paramString = paramString.split(" ");
      if ((paramString != null) && (paramString.length > 1))
      {
        i = 0;
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
          y.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str1 + " anwser = " + str2);
          bool1 = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str1)), str2);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          i = i + 1 + 1;
        }
        if (bool2)
        {
          this.mGt = paramString[(paramString.length - 1)];
          y.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.mGt);
          paramString = this.mGt;
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
      y.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + paramString.toString());
      int i = com.tencent.mm.plugin.nfc.b.a.a.boy().dU(this.mController.uMN);
      y.e("MicroMsg.NfcWebViewUI", "isConnect:" + i);
      this.mGt = vl(1);
      return this.mGt;
    }
    return this.mGt;
  }
  
  private String JU(String paramString)
  {
    y.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
    this.mGt = "";
    Object localObject1 = new azh();
    if (!bk.bl(paramString)) {}
    for (;;)
    {
      int k;
      try
      {
        ((azh)localObject1).aH(paramString.getBytes("ISO-8859-1"));
        if (((azh)localObject1).sPS != null)
        {
          i = 0;
          int m = 0;
          if (m < ((azh)localObject1).sPS.size())
          {
            paramString = (lu)((azh)localObject1).sPS.get(m);
            Object localObject2 = com.tencent.mm.plugin.nfc.b.a.a.boy();
            if (((com.tencent.mm.plugin.nfc.b.a.a)localObject2).mGm != null) {
              ((com.tencent.mm.plugin.nfc.b.a.a)localObject2).mGm.boz();
            }
            k = i;
            if (paramString != null)
            {
              k = i;
              if (!bk.bl(paramString.srC))
              {
                k = i;
                if (!bk.dk(paramString.sHn))
                {
                  k = 0;
                  if (k >= paramString.sHn.size()) {
                    break label575;
                  }
                  if (bk.dk(((ru)paramString.sHn.get(k)).sPV)) {
                    break label548;
                  }
                  j = 0;
                  if (j >= ((ru)paramString.sHn.get(k)).sPV.size()) {
                    break label545;
                  }
                  if ((((ru)paramString.sHn.get(k)).sPV.get(j) == null) || (bk.bl(((qu)((ru)paramString.sHn.get(k)).sPV.get(j)).sOz)) || (bk.bl(((qu)((ru)paramString.sHn.get(k)).sPV.get(j)).lQN))) {
                    break label542;
                  }
                  localObject2 = ((qu)((ru)paramString.sHn.get(k)).sPV.get(j)).sOz;
                  String str = ((qu)((ru)paramString.sHn.get(k)).sPV.get(j)).lQN;
                  y.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + (String)localObject2 + " anwser = " + str);
                  if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray((String)localObject2)), str)) {
                    break label558;
                  }
                  i = 1;
                  break label551;
                  k = j;
                  if (j != 0)
                  {
                    localObject1 = paramString.srC;
                    y.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                    com.tencent.mm.sdk.f.e.post(new NfcWebViewUI.2(this, (String)localObject1), getClass().getName());
                    paramString = paramString.srC;
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
        return this.mGt;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.NfcWebViewUI", paramString, "", new Object[0]);
        y.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + paramString.toString());
        i = com.tencent.mm.plugin.nfc.b.a.a.boy().dU(this.mController.uMN);
        y.e("MicroMsg.NfcWebViewUI", "isConnect:" + i);
        this.mGt = vl(1);
        return this.mGt;
      }
      label542:
      break label551;
      label545:
      break label560;
      label548:
      break label566;
      label551:
      j += 1;
      continue;
      label558:
      int i = 0;
      label560:
      int j = i;
      if (i == 0)
      {
        label566:
        k += 1;
        continue;
        label575:
        j = i;
      }
    }
  }
  
  private static boolean Q(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      y.e("MicroMsg.NfcWebViewUI", "intent is null");
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
          y.e("MicroMsg.NfcWebViewUI", "extra wrong key = " + str);
          ((Iterator)localObject).remove();
        }
      }
      paramIntent = t.l(paramIntent, "android.nfc.extra.TAG");
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", new Object[] { paramIntent });
      return true;
    }
    if ((paramIntent != null) && ((paramIntent instanceof Tag))) {}
    for (paramIntent = (Tag)paramIntent;; paramIntent = null)
    {
      if (paramIntent == null)
      {
        y.e("MicroMsg.NfcWebViewUI", "tag is null");
        return true;
      }
      return false;
    }
  }
  
  private void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    switch (NfcWebViewUI.3.hSj[parama.ordinal()])
    {
    default: 
      finish();
      return;
    }
    parama = t.l(paramIntent, "android.nfc.extra.TAG");
    if ((parama != null) && ((parama instanceof Tag))) {}
    for (parama = (Tag)parama;; parama = null)
    {
      if (parama == null)
      {
        y.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
        return;
      }
      try
      {
        com.tencent.mm.plugin.nfc.b.a.a.boy().a(parama);
        int i = com.tencent.mm.plugin.nfc.b.a.a.boy().dV(this.mController.uMN);
        y.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : " + i);
        return;
      }
      catch (Exception parama)
      {
        y.e("MicroMsg.NfcWebViewUI", "exp protect");
        return;
      }
    }
  }
  
  private static boolean a(com.tencent.mm.plugin.nfc.a.a parama, String paramString)
  {
    y.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
    parama = com.tencent.mm.plugin.nfc.b.a.a.boy().a(parama).toString();
    if (!bk.bl(parama))
    {
      y.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bk.pm(paramString) + " resp = " + bk.pm(parama));
      if (!Pattern.compile(paramString, 2).matcher(parama).find()) {}
    }
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean boC()
  {
    try
    {
      if (this.gGn.cds())
      {
        y.w("MicroMsg.NfcWebViewUI", "not login");
        Intent localIntent = new Intent(this, getClass());
        localIntent.putExtras(getIntent());
        localIntent.addFlags(67108864);
        this.gGn.ae(localIntent);
        return true;
      }
    }
    catch (RemoteException localRemoteException)
    {
      y.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
      return true;
    }
    return false;
  }
  
  private String boD()
  {
    Object localObject1 = null;
    y.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
    for (;;)
    {
      try
      {
        localObject2 = this.gGn.f(4006, null);
        if (localObject2 == null)
        {
          y.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
          return null;
        }
        ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
        str = ((Bundle)localObject2).getString("debugConfig");
        localObject2 = ((Bundle)localObject2).getString("config");
        if (str == null) {
          continue;
        }
        str = JT(str);
        localObject1 = str;
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject2;
        String str;
        y.e("MicroMsg.NfcWebViewUI", localRemoteException.toString());
        y.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      y.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bk.pm(localObject1));
      return localObject1;
      str = JU((String)localObject2);
      localObject1 = str;
    }
  }
  
  private void boE()
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    com.tencent.mm.br.d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    overridePendingTransition(R.a.anim_not_change, R.a.pop_out);
    y.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
  }
  
  private static String vl(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
    localStringBuilder.append("&type=").append(paramInt);
    String str;
    if ((!com.tencent.mm.sdk.platformtools.e.uen) && (x.cqJ().equals("zh_CN"))) {
      str = "zh_CN";
    }
    for (;;)
    {
      localStringBuilder.append("&lang=").append(str);
      return localStringBuilder.toString();
      if (x.cqH()) {
        str = "zh_TW";
      } else {
        str = "en";
      }
    }
  }
  
  protected final void aoX()
  {
    if (boC())
    {
      finish();
      y.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
      return;
    }
    super.aoX();
    a(AutoLoginActivity.a.rYX, getIntent());
  }
  
  protected final void hX(boolean paramBoolean)
  {
    int i = 1;
    if (this.gGn == null)
    {
      y.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
      return;
    }
    a(AutoLoginActivity.a.rYX, getIntent());
    Object localObject1 = boD();
    if ((paramBoolean) && (!bk.bl(this.caS))) {
      if (this.caS.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error")) {
        if (bk.bl((String)localObject1)) {
          y.e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        }
      }
    }
    for (;;)
    {
      if (bk.bl(this.caS))
      {
        this.caS = vl(0);
        y.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
      }
      getIntent().putExtra("rawUrl", this.caS);
      return;
      y.i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", new Object[] { localObject1 });
      this.caS = ((String)localObject1);
      getIntent().putExtra("rawUrl", this.caS);
      bo(this.caS, false);
      continue;
      for (;;)
      {
        try
        {
          paramBoolean = bk.bl((String)localObject1);
          if (paramBoolean) {
            continue;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject2;
          y.printErrStackTrace("MicroMsg.NfcWebViewUI", localRemoteException, "", new Object[0]);
          continue;
        }
        try
        {
          localObject2 = Uri.parse((String)localObject1);
          localObject1 = Uri.parse(this.caS);
          localObject2 = ((Uri)localObject2).getHost();
          localObject1 = ((Uri)localObject1).getHost();
          y.i("MicroMsg.NfcWebViewUI", "targetHost=" + (String)localObject2 + ", curHost=" + (String)localObject1);
          paramBoolean = ((String)localObject2).equals(localObject1);
          if (paramBoolean)
          {
            if (i != 0) {
              this.rgh.b(4007, new Bundle());
            }
            y.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
            return;
          }
        }
        catch (Exception localException) {}
        i = 0;
      }
      this.caS = localRemoteException;
    }
  }
  
  public void onBackPressed()
  {
    if (this.mGu)
    {
      boE();
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (Q(localIntent)) {
      y.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
    }
    try
    {
      localIntent.putExtra("key_trust_url", false);
      label29:
      super.onCreate(paramBundle);
      finish();
      return;
      localIntent.putExtra("key_trust_url", false);
      super.onCreate(paramBundle);
      com.tencent.mm.sdk.b.a.udP.c(this.mGv);
      com.tencent.mm.br.d.coz();
      y.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + localIntent.getAction());
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          if (NfcWebViewUI.a(NfcWebViewUI.this)) {
            NfcWebViewUI.b(NfcWebViewUI.this);
          }
          for (;;)
          {
            return true;
            NfcWebViewUI.this.finish();
          }
        }
      });
      getIntent().putExtra("showShare", false);
      lj(false);
      return;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  @TargetApi(11)
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.mGv);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (Q(paramIntent))
    {
      y.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
      return;
    }
    paramIntent.putExtra("key_trust_url", false);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    int i = t.a(paramIntent, "wizard_activity_result_code", 2147483647);
    y.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = " + i);
    if (i != 2147483647) {
      this.mGu = true;
    }
    switch (i)
    {
    default: 
    case -1: 
    case 1: 
      for (;;)
      {
        hX(true);
        y.i("Foreground dispatch", "Discovered tag with intent: " + paramIntent);
        return;
        a(AutoLoginActivity.a.rYX, paramIntent);
        continue;
        a(AutoLoginActivity.a.rYZ, paramIntent);
      }
    }
    boC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI
 * JD-Core Version:    0.7.0.1
 */