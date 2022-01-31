package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wallet_index.c.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(7)
public class WalletSendC2CMsgUI
  extends WalletBaseUI
{
  private int fzn;
  private Map<String, String> qMq = null;
  
  private boolean QW(String paramString)
  {
    String str4;
    String str5;
    String str6;
    String str3;
    Object localObject;
    String str1;
    String str2;
    if (this.fzn == 1)
    {
      paramString = getIntent().getStringExtra("key_receiver");
      str4 = getIntent().getStringExtra("key_sender_des");
      str5 = getIntent().getStringExtra("key_receiver_des");
      str6 = URLEncoder.encode(getIntent().getStringExtra("key_url"));
      str3 = getIntent().getStringExtra("key_templateid");
      localObject = getIntent().getStringExtra("key_sceneid");
      str1 = getIntent().getStringExtra("key_receivertitle");
      str2 = getIntent().getStringExtra("key_sendertitle");
    }
    for (;;)
    {
      if ((!bk.bl(str6)) && (!bk.bl(str3)))
      {
        y.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to" + paramString);
        a(new g(paramString, str1, str2, str3, str4, str5, str6, (String)localObject), true, true);
        return true;
        localObject = bXE();
        if ((localObject != null) && (!bk.bl(paramString)))
        {
          str1 = URLDecoder.decode(bk.pm((String)((Map)localObject).get("receivertitle")));
          str2 = URLDecoder.decode(bk.pm((String)((Map)localObject).get("sendertitle")));
          str4 = URLDecoder.decode(bk.pm((String)((Map)localObject).get("senderdes")));
          str5 = URLDecoder.decode(bk.pm((String)((Map)localObject).get("receiverdes")));
          str6 = bk.pm((String)((Map)localObject).get("url"));
          str3 = URLDecoder.decode(bk.pm((String)((Map)localObject).get("templateid")));
          localObject = URLDecoder.decode(bk.pm((String)((Map)localObject).get("senceid")));
        }
      }
      else
      {
        y.w("MicroMsg.WalletSendC2CMsgUI", "url = " + bk.bl(str6) + "templateId=" + bk.bl(str3));
        return false;
      }
      localObject = null;
      str3 = null;
      str6 = null;
      str5 = null;
      str4 = null;
      str2 = null;
      str1 = null;
    }
  }
  
  private Map<String, String> bXE()
  {
    if (this.qMq == null)
    {
      Object localObject = getIntent().getStringExtra("packageExt");
      y.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: " + (String)localObject);
      if (!bk.bl((String)localObject))
      {
        localObject = ((String)localObject).split("&");
        this.qMq = new HashMap();
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          while (i < localObject.length)
          {
            if (!bk.bl(localObject[i]))
            {
              String[] arrayOfString = localObject[i].split("=");
              if ((arrayOfString.length == 2) && (!bk.bl(arrayOfString[0]))) {
                this.qMq.put(arrayOfString[0], arrayOfString[1]);
              }
            }
            i += 1;
          }
        }
      }
    }
    return this.qMq;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
      {
        y.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
        f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
        y.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
        paramString = bXE();
        paramInt1 = i;
        if (paramString != null)
        {
          paramInt1 = i;
          if (paramString.containsKey("togroup"))
          {
            paramInt1 = i;
            if ("0".equals(paramString.get("togroup"))) {
              paramInt1 = 1;
            }
          }
        }
        paramString = new Intent();
        if (paramInt1 == 0) {
          break label272;
        }
      }
    }
    label272:
    for (paramInt1 = 7;; paramInt1 = 3)
    {
      paramString.putExtra("select_is_ret", true);
      paramString.putExtra("Select_Conv_Type", paramInt1);
      d.c(this, ".ui.transmit.SelectConversationUI", paramString, 1);
      return true;
      if ((paramm instanceof g))
      {
        y.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
        if (this.fzn == 1) {
          h.bC(this, getString(a.i.wallet_send_c2c_msg_resent));
        }
        for (;;)
        {
          finish();
          return true;
          h.bC(this, getString(a.i.has_send));
          setResult(-1);
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
        {
          y.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
          setResult(-1000);
          finish();
          return true;
        }
        if ((paramm instanceof g))
        {
          if (this.fzn == 1) {
            h.bC(this, paramString);
          }
          for (;;)
          {
            finish();
            return true;
            setResult(-1000);
          }
        }
        setResult(-1000);
        finish();
      }
      return false;
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      y.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        y.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + bk.pm(paramIntent));
        if (!QW(paramIntent))
        {
          y.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
          setResult(-1000);
          finish();
        }
        return;
        y.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
      }
      else
      {
        y.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
        setResult(0);
        finish();
        return;
      }
    }
    y.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = " + paramInt1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(8);
    this.fzn = getIntent().getIntExtra("key_scene", 0);
    y.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.fzn);
    if (this.fzn == 0)
    {
      kh(580);
      if (getIntent() == null)
      {
        y.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
        setResult(-1000);
        finish();
      }
    }
    while (QW(null))
    {
      return;
      a(new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 6, "getSendC2CMessageRequest", getIntent().getIntExtra("pay_channel", 0)), true, false);
      return;
    }
    y.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
    setResult(-1000);
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletSendC2CMsgUI
 * JD-Core Version:    0.7.0.1
 */