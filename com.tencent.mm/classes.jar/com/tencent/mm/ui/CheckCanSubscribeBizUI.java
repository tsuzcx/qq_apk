package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.autogen.a.kw;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI
  extends MMActivity
  implements com.tencent.mm.am.h, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private int advI;
  private LinkedList<etl> advJ;
  private boolean advK = false;
  private boolean advL = false;
  private boolean advM = false;
  private boolean advN = false;
  private String advO;
  private int advP = 0;
  private String appId;
  private String extInfo;
  private int fromScene;
  private String hGw;
  private String hHa;
  private boolean ooe = false;
  private String pPi;
  private int scene;
  private int source;
  
  private void bSo()
  {
    AppMethodBeat.i(32980);
    Log.e("MicroMsg.CheckCanSubscribeBizUI", "showErrToast");
    Toast.makeText(this, R.l.regbyqq_auth_err_title, 1).show();
    dGQ();
    AppMethodBeat.o(32980);
  }
  
  private boolean cod()
  {
    AppMethodBeat.i(32974);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      Log.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.appId = localIntent.getStringExtra("appId");
    this.hHa = localIntent.getStringExtra("toUserName");
    if (Util.isNullOrNil(this.hHa))
    {
      Log.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.source = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.advP = localIntent.getIntExtra("jump_profile_type", 0);
    switch (this.source)
    {
    default: 
      Log.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[] { Integer.valueOf(this.source) });
      AppMethodBeat.o(32974);
      return false;
    case 1: 
      if (Util.isNullOrNil(this.appId))
      {
        Log.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.fromScene = 68;
      ArrayList localArrayList = localIntent.getStringArrayListExtra("androidPackNameList");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        Log.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.advJ = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!Util.isNullOrNil(str))
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.advJ.add(w.Sk(str));
        }
        i += 1;
      }
      if (this.advJ.size() == 0)
      {
        Log.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.advI = this.advJ.size();
    }
    for (;;)
    {
      this.hGw = localIntent.getStringExtra("fromURL");
      AppMethodBeat.o(32974);
      return true;
      this.fromScene = 69;
    }
  }
  
  private void dGQ()
  {
    AppMethodBeat.i(32981);
    if (this.source == 1) {
      LauncherUI.mK(this);
    }
    AppMethodBeat.o(32981);
  }
  
  private void iKS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32976);
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.advK);
        if (this.scene == 1)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  MM_CHECK_CAN_SUBSCRIBE_BIZ_SCENE_WEBVIEW");
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.advO);
          com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          AppMethodBeat.o(32976);
          return;
        }
        if ((this.scene != 0) || (this.advP != 1)) {
          break label210;
        }
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  MM_CHECK_CAN_SUBSCRIBE_BIZ_SCENE_PROFILE  extInfo:" + this.extInfo);
        if (this.advM)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          AppMethodBeat.o(32976);
          continue;
        }
        this.advM = true;
      }
      finally {}
      bh.aZW().a(233, this);
      Object localObject2 = new com.tencent.mm.modelsimple.n(this.extInfo, null, 4, 0, com.tencent.mm.modelsimple.n.bMd(), new byte[0]);
      bh.aZW().a((p)localObject2, 0);
      AppMethodBeat.o(32976);
      continue;
      label210:
      if ((jhK()) && (this.advK))
      {
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  jumpToChattingUI");
        if (!this.advM)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.hHa);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (Util.isNullOrNil(this.hHa)) {
            e.a((Intent)localObject2, this.hHa);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.advL)
          {
            setResult(-1);
            this.advM = true;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
      else if (this.advK)
      {
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  jumpToContactInfoUI");
        if (!this.advM)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.hHa);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("Contact_Scene", this.fromScene);
          localIntent2.putExtra("Verify_ticket", this.pPi);
          localIntent2.putExtra("force_get_contact", true);
          localIntent2.putExtra("key_use_new_contact_profile", true);
          if (localObject2 != null)
          {
            localIntent2.putExtra("Contact_Alias", ((au)localObject2).aJs());
            localIntent2.putExtra("Contact_Nick", ((az)localObject2).field_nickname);
            localIntent2.putExtra("Contact_Signature", ((az)localObject2).signature);
            localIntent2.putExtra("Contact_RegionCode", ((az)localObject2).kaj);
            localIntent2.putExtra("Contact_Sex", ((az)localObject2).sex);
            localIntent2.putExtra("Contact_VUser_Info", ((az)localObject2).verifyInfo);
            localIntent2.putExtra("Contact_VUser_Info_Flag", ((az)localObject2).field_verifyFlag);
            localIntent2.putExtra("Contact_KWeibo_flag", ((az)localObject2).field_weiboFlag);
            localIntent2.putExtra("Contact_KWeibo", ((az)localObject2).kai);
            localIntent2.putExtra("Contact_KWeiboNick", ((az)localObject2).field_weiboNickname);
          }
          e.t(localIntent2, this.hHa);
          if (!this.advL)
          {
            setResult(-1);
            this.advM = true;
            com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
      else
      {
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  not canJump");
        AppMethodBeat.o(32976);
      }
    }
  }
  
  private boolean jhK()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32977);
        au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.hHa);
        if ((localau != null) && ((int)localau.maN != 0)) {
          break label349;
        }
        StringBuilder localStringBuilder = new StringBuilder("contact is null == ");
        if (localau == null)
        {
          bool = true;
          Log.w("MicroMsg.CheckCanSubscribeBizUI", bool);
          i = 1;
          if (!this.advN) {
            continue;
          }
          if (localau == null)
          {
            Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  contact == null  return false");
            this.advK = false;
            setResult(5);
            bSo();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            return bool;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  isContact :" + d.rs(localau.field_type));
        this.advK = true;
        this.ooe = true;
        if (d.rs(localau.field_type)) {
          break label320;
        }
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  return false");
        AppMethodBeat.o(32977);
        bool = false;
        continue;
        if (i != 0)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  needToAddOrUpdateContact = true  canJump" + this.advK);
          if (this.advK)
          {
            setResult(5);
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            continue;
          }
          az.a.okP.a(this.hHa, "", new az.b.a()
          {
            public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(32966);
              Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  getContactCallBack  succ:".concat(String.valueOf(paramAnonymousBoolean)));
              if (!paramAnonymousBoolean) {
                new MMHandler().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(250658);
                    Log.i("MicroMsg.CheckCanSubscribeBizUI", "getContactCallBack fail run");
                    CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this);
                    if ((!CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this)) && (!CheckCanSubscribeBizUI.this.isDestroyed())) {
                      CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this);
                    }
                    AppMethodBeat.o(250658);
                  }
                });
              }
              AppMethodBeat.o(32966);
            }
          });
          continue;
        }
        if (d.rs(localObject.field_type)) {
          break label320;
        }
      }
      finally {}
      Log.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
      this.advK = true;
      AppMethodBeat.o(32977);
      boolean bool = false;
      continue;
      label320:
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  return true");
      this.advK = true;
      this.ooe = true;
      AppMethodBeat.o(32977);
      bool = true;
      continue;
      label349:
      int i = 0;
    }
  }
  
  private void jhL()
  {
    AppMethodBeat.i(32979);
    Toast.makeText(this, getString(R.l.gXC), 1).show();
    dGQ();
    AppMethodBeat.o(32979);
  }
  
  protected int getLayoutId()
  {
    return R.i.glf;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32969);
    super.onCreate(paramBundle);
    hideTitleView();
    if ((!bh.bCA()) || (bh.aZG()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(32969);
      return;
    }
    bh.aZW().a(605, this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add(this);
    af.bHf().add(this);
    if (cod())
    {
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "onCreate initData  doCheckCanSubscribeBiz");
      paramBundle = this.appId;
      String str1 = this.hHa;
      String str2 = this.extInfo;
      int i = this.advI;
      LinkedList localLinkedList = this.advJ;
      String str3 = this.hGw;
      int j = this.source;
      int k = this.scene;
      Object localObject = new c.a();
      ((c.a)localObject).otE = new aai();
      ((c.a)localObject).otF = new aaj();
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((c.a)localObject).funcId = 605;
      localObject = ((c.a)localObject).bEF();
      aai localaai = (aai)c.b.b(((com.tencent.mm.am.c)localObject).otB);
      localaai.muA = paramBundle;
      localaai.IMg = str1;
      localaai.IMu = str2;
      localaai.ZiG = i;
      localaai.ZiH = localLinkedList;
      localaai.ZiI = null;
      localaai.ZiJ = str3;
      localaai.IcB = j;
      localaai.IJG = k;
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      z.a((com.tencent.mm.am.c)localObject, new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(32967);
          paramAnonymousc = (aaj)c.c.b(paramAnonymousc.otC);
          CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this, paramAnonymousc.ZiK);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!Util.isNullOrNil(paramAnonymousc.ZiK)) && (!Util.isNullOrNil(paramAnonymousc.IMg)))
          {
            Log.i("MicroMsg.CheckCanSubscribeBizUI", "RunCgi.run callback ok");
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this, paramAnonymousc.IMg);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this, paramAnonymousc.ZiL);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this);
            AppMethodBeat.o(32967);
            return 0;
          }
          if (ae.a.a(CheckCanSubscribeBizUI.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 7))
          {
            Log.e("MicroMsg.CheckCanSubscribeBizUI", "RunCgi.run callback RESULT_CODE_NORMAL_ERROR");
            CheckCanSubscribeBizUI.this.setResult(5);
            CheckCanSubscribeBizUI.this.finish();
            AppMethodBeat.o(32967);
            return 0;
          }
          Log.e("MicroMsg.CheckCanSubscribeBizUI", "RunCgi.run callback RESULT_CODE_FORBID");
          CheckCanSubscribeBizUI.d(CheckCanSubscribeBizUI.this);
          CheckCanSubscribeBizUI.this.setResult(3);
          CheckCanSubscribeBizUI.this.finish();
          AppMethodBeat.o(32967);
          return 0;
        }
      });
      AppMethodBeat.o(32969);
      return;
    }
    Log.i("MicroMsg.CheckCanSubscribeBizUI", "onCreate initData fail, RESULT_CODE_PARAMETER_ERROR");
    setResult(2);
    bSo();
    finish();
    AppMethodBeat.o(32969);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32972);
    super.onDestroy();
    if (this.advJ != null) {
      this.advJ.clear();
    }
    if (bh.baz())
    {
      bh.aZW().b(605, this);
      af.bHf().remove(this);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this);
    }
    AppMethodBeat.o(32972);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32978);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.advL = true;
      if (this.advM)
      {
        AppMethodBeat.o(32978);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(32978);
    return bool;
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(32983);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(32983);
      return;
    }
    onNotifyChange((String)paramObject, null);
    AppMethodBeat.o(32983);
  }
  
  public void onNotifyChange(final String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(32982);
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32968);
        Log.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.e(CheckCanSubscribeBizUI.this) + ", userName = " + paramString);
        if (CheckCanSubscribeBizUI.e(CheckCanSubscribeBizUI.this).equals(paramString))
        {
          CheckCanSubscribeBizUI.f(CheckCanSubscribeBizUI.this);
          if (!CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this)) {
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this);
          }
        }
        AppMethodBeat.o(32968);
      }
    });
    AppMethodBeat.o(32982);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(32973);
    super.onPause();
    AppMethodBeat.o(32973);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(32971);
    super.onResume();
    AppMethodBeat.o(32971);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(32975);
    Log.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramp.getType() == 605)
    {
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, MMFunc_CheckCanSubscribeBiz  do nothing");
      AppMethodBeat.o(32975);
      return;
    }
    if (paramp.getType() == 233)
    {
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, MMFunc_GetA8Key");
      bh.aZW().b(233, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.modelsimple.n)paramp;
        paramInt1 = paramString.bLV();
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == 15)
        {
          paramString = paramString.bLT();
          Log.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramp = new kw();
          paramp.hMB.actionCode = paramInt1;
          paramp.hMB.result = paramString;
          paramp.hMB.context = this;
          paramp.asyncPublish(Looper.myLooper());
          finish();
          AppMethodBeat.o(32975);
          return;
        }
        Log.e("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, geta8key  actionCode = ".concat(String.valueOf(paramInt1)));
        jhL();
        AppMethodBeat.o(32975);
        return;
      }
      Log.e("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, geta8key  errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      jhL();
      AppMethodBeat.o(32975);
      return;
    }
    Log.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[] { Integer.valueOf(paramp.getType()) });
    AppMethodBeat.o(32975);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(32970);
    super.onStart();
    AppMethodBeat.o(32970);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI
 * JD-Core Version:    0.7.0.1
 */