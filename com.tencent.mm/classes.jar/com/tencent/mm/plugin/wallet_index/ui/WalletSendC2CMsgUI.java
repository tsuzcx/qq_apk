package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_index.c.i;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletSendC2CMsgUI
  extends WalletBaseUI
{
  private Map<String, String> PkX = null;
  private int mScene;
  
  private boolean bhL(String paramString)
  {
    AppMethodBeat.i(71952);
    String str4;
    String str5;
    String str6;
    String str3;
    Object localObject;
    String str1;
    String str2;
    if (this.mScene == 1)
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
      if ((!Util.isNullOrNil(str6)) && (!Util.isNullOrNil(str3)))
      {
        Log.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to".concat(String.valueOf(paramString)));
        doSceneProgress(new i(paramString, str1, str2, str3, str4, str5, str6, (String)localObject));
        AppMethodBeat.o(71952);
        return true;
        localObject = gNe();
        if ((localObject != null) && (!Util.isNullOrNil(paramString)))
        {
          str1 = URLDecoder.decode(Util.nullAsNil((String)((Map)localObject).get("receivertitle")));
          str2 = URLDecoder.decode(Util.nullAsNil((String)((Map)localObject).get("sendertitle")));
          str4 = URLDecoder.decode(Util.nullAsNil((String)((Map)localObject).get("senderdes")));
          str5 = URLDecoder.decode(Util.nullAsNil((String)((Map)localObject).get("receiverdes")));
          str6 = Util.nullAsNil((String)((Map)localObject).get("url"));
          str3 = URLDecoder.decode(Util.nullAsNil((String)((Map)localObject).get("templateid")));
          localObject = URLDecoder.decode(Util.nullAsNil((String)((Map)localObject).get("senceid")));
        }
      }
      else
      {
        Log.w("MicroMsg.WalletSendC2CMsgUI", "url = " + Util.isNullOrNil(str6) + "templateId=" + Util.isNullOrNil(str3));
        AppMethodBeat.o(71952);
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
  
  private Map<String, String> gNe()
  {
    AppMethodBeat.i(71953);
    if (this.PkX == null)
    {
      localObject = getIntent().getStringExtra("packageExt");
      Log.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: ".concat(String.valueOf(localObject)));
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("&");
        this.PkX = new HashMap();
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          while (i < localObject.length)
          {
            if (!Util.isNullOrNil(localObject[i]))
            {
              String[] arrayOfString = localObject[i].split("=");
              if ((arrayOfString.length == 2) && (!Util.isNullOrNil(arrayOfString[0]))) {
                this.PkX.put(arrayOfString[0], arrayOfString[1]);
              }
            }
            i += 1;
          }
        }
      }
    }
    Object localObject = this.PkX;
    AppMethodBeat.o(71953);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71951);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      Log.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        Log.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + Util.nullAsNil(paramIntent));
        if (!bhL(paramIntent))
        {
          Log.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
          setResult(-1000);
          finish();
          AppMethodBeat.o(71951);
          return;
          Log.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
        }
        else
        {
          AppMethodBeat.o(71951);
        }
      }
      else
      {
        Log.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
        setResult(0);
        finish();
        AppMethodBeat.o(71951);
        return;
      }
    }
    Log.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(71951);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71948);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    Log.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.mScene);
    if (this.mScene == 0)
    {
      addSceneEndListener(580);
      if (getIntent() == null)
      {
        Log.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
        setResult(-1000);
        finish();
        AppMethodBeat.o(71948);
        return;
      }
      doSceneForceProgress(new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 6, "getSendC2CMessageRequest", getIntent().getIntExtra("pay_channel", 0)));
      AppMethodBeat.o(71948);
      return;
    }
    if (!bhL(null))
    {
      Log.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
      setResult(-1000);
      finish();
      AppMethodBeat.o(71948);
      return;
    }
    AppMethodBeat.o(71948);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71949);
    super.onDestroy();
    removeSceneEndListener(580);
    AppMethodBeat.o(71949);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 0;
    AppMethodBeat.i(71950);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof d))
      {
        Log.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
        e.bsi(((d)paramq).gIv());
        Log.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
        paramString = gNe();
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
          break label318;
        }
      }
    }
    label318:
    for (paramInt1 = 7;; paramInt1 = 3)
    {
      paramString.putExtra("select_is_ret", true);
      paramString.putExtra("Select_Conv_Type", paramInt1);
      c.d(this, ".ui.transmit.SelectConversationUI", paramString, 1);
      AppMethodBeat.o(71950);
      return true;
      if ((paramq instanceof i))
      {
        Log.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
        if (this.mScene == 1) {
          h.cO(this, getString(a.i.wallet_send_c2c_msg_resent));
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(71950);
          return true;
          h.cO(this, getString(a.i.has_send));
          setResult(-1);
        }
        if ((paramq instanceof d))
        {
          Log.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
          setResult(-1000);
          finish();
          AppMethodBeat.o(71950);
          return true;
        }
        if ((paramq instanceof i))
        {
          if (this.mScene == 1) {
            h.cO(this, paramString);
          }
          for (;;)
          {
            finish();
            AppMethodBeat.o(71950);
            return true;
            setResult(-1000);
          }
        }
        setResult(-1000);
        finish();
      }
      AppMethodBeat.o(71950);
      return false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletSendC2CMsgUI
 * JD-Core Version:    0.7.0.1
 */