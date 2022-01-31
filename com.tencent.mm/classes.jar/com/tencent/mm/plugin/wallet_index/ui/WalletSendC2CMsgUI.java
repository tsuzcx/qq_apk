package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletSendC2CMsgUI
  extends WalletBaseUI
{
  private int mScene;
  private Map<String, String> uBy = null;
  
  private boolean afU(String paramString)
  {
    AppMethodBeat.i(48311);
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
      if ((!bo.isNullOrNil(str6)) && (!bo.isNullOrNil(str3)))
      {
        ab.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to".concat(String.valueOf(paramString)));
        doSceneProgress(new com.tencent.mm.plugin.wallet_index.c.h(paramString, str1, str2, str3, str4, str5, str6, (String)localObject));
        AppMethodBeat.o(48311);
        return true;
        localObject = cXm();
        if ((localObject != null) && (!bo.isNullOrNil(paramString)))
        {
          str1 = URLDecoder.decode(bo.nullAsNil((String)((Map)localObject).get("receivertitle")));
          str2 = URLDecoder.decode(bo.nullAsNil((String)((Map)localObject).get("sendertitle")));
          str4 = URLDecoder.decode(bo.nullAsNil((String)((Map)localObject).get("senderdes")));
          str5 = URLDecoder.decode(bo.nullAsNil((String)((Map)localObject).get("receiverdes")));
          str6 = bo.nullAsNil((String)((Map)localObject).get("url"));
          str3 = URLDecoder.decode(bo.nullAsNil((String)((Map)localObject).get("templateid")));
          localObject = URLDecoder.decode(bo.nullAsNil((String)((Map)localObject).get("senceid")));
        }
      }
      else
      {
        ab.w("MicroMsg.WalletSendC2CMsgUI", "url = " + bo.isNullOrNil(str6) + "templateId=" + bo.isNullOrNil(str3));
        AppMethodBeat.o(48311);
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
  
  private Map<String, String> cXm()
  {
    AppMethodBeat.i(48312);
    if (this.uBy == null)
    {
      localObject = getIntent().getStringExtra("packageExt");
      ab.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: ".concat(String.valueOf(localObject)));
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("&");
        this.uBy = new HashMap();
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          while (i < localObject.length)
          {
            if (!bo.isNullOrNil(localObject[i]))
            {
              String[] arrayOfString = localObject[i].split("=");
              if ((arrayOfString.length == 2) && (!bo.isNullOrNil(arrayOfString[0]))) {
                this.uBy.put(arrayOfString[0], arrayOfString[1]);
              }
            }
            i += 1;
          }
        }
      }
    }
    Object localObject = this.uBy;
    AppMethodBeat.o(48312);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48310);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ab.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        ab.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + bo.nullAsNil(paramIntent));
        if (!afU(paramIntent))
        {
          ab.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
          setResult(-1000);
          finish();
          AppMethodBeat.o(48310);
          return;
          ab.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
        }
        else
        {
          AppMethodBeat.o(48310);
        }
      }
      else
      {
        ab.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
        setResult(0);
        finish();
        AppMethodBeat.o(48310);
        return;
      }
    }
    ab.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(48310);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48307);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    ab.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.mScene);
    if (this.mScene == 0)
    {
      addSceneEndListener(580);
      if (getIntent() == null)
      {
        ab.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
        setResult(-1000);
        finish();
        AppMethodBeat.o(48307);
        return;
      }
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 6, "getSendC2CMessageRequest", getIntent().getIntExtra("pay_channel", 0)));
      AppMethodBeat.o(48307);
      return;
    }
    if (!afU(null))
    {
      ab.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
      setResult(-1000);
      finish();
      AppMethodBeat.o(48307);
      return;
    }
    AppMethodBeat.o(48307);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48308);
    super.onDestroy();
    removeSceneEndListener(580);
    AppMethodBeat.o(48308);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(48309);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        ab.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
        g.ana(((com.tencent.mm.plugin.wallet_core.c.d)paramm).cSW());
        ab.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
        paramString = cXm();
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
      com.tencent.mm.bq.d.b(this, ".ui.transmit.SelectConversationUI", paramString, 1);
      AppMethodBeat.o(48309);
      return true;
      if ((paramm instanceof com.tencent.mm.plugin.wallet_index.c.h))
      {
        ab.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
        if (this.mScene == 1) {
          com.tencent.mm.ui.base.h.bO(this, getString(2131305647));
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(48309);
          return true;
          com.tencent.mm.ui.base.h.bO(this, getString(2131300637));
          setResult(-1);
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.d))
        {
          ab.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
          setResult(-1000);
          finish();
          AppMethodBeat.o(48309);
          return true;
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet_index.c.h))
        {
          if (this.mScene == 1) {
            com.tencent.mm.ui.base.h.bO(this, paramString);
          }
          for (;;)
          {
            finish();
            AppMethodBeat.o(48309);
            return true;
            setResult(-1000);
          }
        }
        setResult(-1000);
        finish();
      }
      AppMethodBeat.o(48309);
      return false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletSendC2CMsgUI
 * JD-Core Version:    0.7.0.1
 */