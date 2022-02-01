package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.ju;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI
  extends MMActivity
  implements i, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private String BLy;
  private int VRA;
  private LinkedList<eaf> VRB;
  private boolean VRC = false;
  private boolean VRD = false;
  private boolean VRE = false;
  private boolean VRF = false;
  private String VRG;
  private int VRH = 0;
  private String appId;
  private String extInfo;
  private String fBH;
  private String fCl;
  private int fromScene;
  private boolean lwF = false;
  private int scene;
  private int source;
  
  private boolean bNO()
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
    this.fCl = localIntent.getStringExtra("toUserName");
    if (Util.isNullOrNil(this.fCl))
    {
      Log.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.source = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.VRH = localIntent.getIntExtra("jump_profile_type", 0);
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
      this.VRB = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!Util.isNullOrNil(str))
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.VRB.add(z.ZW(str));
        }
        i += 1;
      }
      if (this.VRB.size() == 0)
      {
        Log.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.VRA = this.VRB.size();
    }
    for (;;)
    {
      this.fBH = localIntent.getStringExtra("fromURL");
      AppMethodBeat.o(32974);
      return true;
      this.fromScene = 69;
    }
  }
  
  private void dav()
  {
    AppMethodBeat.i(32981);
    if (this.source == 1) {
      LauncherUI.kH(this);
    }
    AppMethodBeat.o(32981);
  }
  
  private boolean hFx()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32977);
        as localas = ((n)h.ae(n.class)).bbL().RG(this.fCl);
        if ((localas != null) && ((int)localas.jxt != 0)) {
          break label341;
        }
        StringBuilder localStringBuilder = new StringBuilder("contact is null == ");
        if (localas == null)
        {
          bool = true;
          Log.w("MicroMsg.CheckCanSubscribeBizUI", bool);
          i = 1;
          if (!this.VRF) {
            continue;
          }
          if (localas == null)
          {
            Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  contact == null  return false");
            this.VRC = false;
            setResult(5);
            hFz();
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
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  isContact :" + com.tencent.mm.contact.d.rk(localas.field_type));
        this.VRC = true;
        this.lwF = true;
        if (com.tencent.mm.contact.d.rk(localas.field_type)) {
          break label313;
        }
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  return false");
        AppMethodBeat.o(32977);
        bool = false;
        continue;
        if (i != 0)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  needToAddOrUpdateContact = true  canJump" + this.VRC);
          if (this.VRC)
          {
            setResult(5);
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            continue;
          }
          az.a.ltq.a(this.fCl, "", new az.b.a()
          {
            public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(32966);
              Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  getContactCallBack  succ:".concat(String.valueOf(paramAnonymousBoolean)));
              if (!paramAnonymousBoolean) {
                new MMHandler().post(new CheckCanSubscribeBizUI.1.1(this));
              }
              AppMethodBeat.o(32966);
            }
          });
          continue;
        }
        if (com.tencent.mm.contact.d.rk(localObject.field_type)) {
          break label313;
        }
      }
      finally {}
      Log.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
      this.VRC = true;
      AppMethodBeat.o(32977);
      boolean bool = false;
      continue;
      label313:
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "hasConcerned  return true");
      this.VRC = true;
      this.lwF = true;
      AppMethodBeat.o(32977);
      bool = true;
      continue;
      label341:
      int i = 0;
    }
  }
  
  private void hFy()
  {
    AppMethodBeat.i(32979);
    Toast.makeText(this, getString(R.l.eUD), 1).show();
    dav();
    AppMethodBeat.o(32979);
  }
  
  private void hFz()
  {
    AppMethodBeat.i(32980);
    Log.e("MicroMsg.CheckCanSubscribeBizUI", "showErrToast");
    Toast.makeText(this, R.l.regbyqq_auth_err_title, 1).show();
    dav();
    AppMethodBeat.o(32980);
  }
  
  private void hka()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32976);
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.VRC);
        if (this.scene == 1)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  MM_CHECK_CAN_SUBSCRIBE_BIZ_SCENE_WEBVIEW");
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.VRG);
          c.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          AppMethodBeat.o(32976);
          return;
        }
        if ((this.scene != 0) || (this.VRH != 1)) {
          break label216;
        }
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  MM_CHECK_CAN_SUBSCRIBE_BIZ_SCENE_PROFILE  extInfo:" + this.extInfo);
        if (this.VRE)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          AppMethodBeat.o(32976);
          continue;
        }
        this.VRE = true;
      }
      finally {}
      bh.aGY().a(233, this);
      Object localObject2 = new l(this.extInfo, null, 4, 0, l.boo(), new byte[0]);
      bh.aGY().a((q)localObject2, 0);
      AppMethodBeat.o(32976);
      continue;
      label216:
      if ((hFx()) && (this.VRC))
      {
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  jumpToChattingUI");
        if (!this.VRE)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.fCl);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (Util.isNullOrNil(this.fCl)) {
            e.a((Intent)localObject2, this.fCl);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.VRD)
          {
            setResult(-1);
            this.VRE = true;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
      else if (this.VRC)
      {
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess  jumpToContactInfoUI");
        if (!this.VRE)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
          localObject2 = ((n)h.ae(n.class)).bbL().RG(this.fCl);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("Contact_Scene", this.fromScene);
          localIntent2.putExtra("Verify_ticket", this.BLy);
          localIntent2.putExtra("force_get_contact", true);
          localIntent2.putExtra("key_use_new_contact_profile", true);
          if (localObject2 != null)
          {
            localIntent2.putExtra("Contact_Alias", ((as)localObject2).apf());
            localIntent2.putExtra("Contact_Nick", ((ax)localObject2).field_nickname);
            localIntent2.putExtra("Contact_Signature", ((ax)localObject2).signature);
            localIntent2.putExtra("Contact_RegionCode", ((ax)localObject2).hDn);
            localIntent2.putExtra("Contact_Sex", ((ax)localObject2).sex);
            localIntent2.putExtra("Contact_VUser_Info", ((ax)localObject2).verifyInfo);
            localIntent2.putExtra("Contact_VUser_Info_Flag", ((ax)localObject2).field_verifyFlag);
            localIntent2.putExtra("Contact_KWeibo_flag", ((ax)localObject2).field_weiboFlag);
            localIntent2.putExtra("Contact_KWeibo", ((ax)localObject2).hDm);
            localIntent2.putExtra("Contact_KWeiboNick", ((ax)localObject2).field_weiboNickname);
          }
          e.r(localIntent2, this.fCl);
          if (!this.VRD)
          {
            setResult(-1);
            this.VRE = true;
            c.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
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
  
  protected int getLayoutId()
  {
    return R.i.eik;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32969);
    super.onCreate(paramBundle);
    hideTitleView();
    if ((!bh.beJ()) || (bh.aGE()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(32969);
      return;
    }
    bh.aGY().a(605, this);
    ((n)h.ae(n.class)).bbL().add(this);
    af.bjv().add(this);
    if (bNO())
    {
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "onCreate initData  doCheckCanSubscribeBiz");
      paramBundle = this.appId;
      String str1 = this.fCl;
      String str2 = this.extInfo;
      int i = this.VRA;
      LinkedList localLinkedList = this.VRB;
      String str3 = this.fBH;
      int j = this.source;
      int k = this.scene;
      Object localObject = new d.a();
      ((d.a)localObject).lBU = new yl();
      ((d.a)localObject).lBV = new ym();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((d.a)localObject).funcId = 605;
      localObject = ((d.a)localObject).bgN();
      yl localyl = (yl)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
      localyl.jUi = paramBundle;
      localyl.CRQ = str1;
      localyl.CSe = str2;
      localyl.Skw = i;
      localyl.Skx = localLinkedList;
      localyl.Sky = null;
      localyl.Skz = str3;
      localyl.Cqs = j;
      localyl.CPw = k;
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      aa.a((com.tencent.mm.an.d)localObject, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(32967);
          paramAnonymousd = (ym)d.c.b(paramAnonymousd.lBS);
          CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this, paramAnonymousd.SkA);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!Util.isNullOrNil(paramAnonymousd.SkA)) && (!Util.isNullOrNil(paramAnonymousd.CRQ)))
          {
            Log.i("MicroMsg.CheckCanSubscribeBizUI", "RunCgi.run callback ok");
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this, paramAnonymousd.CRQ);
            CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this, paramAnonymousd.SkB);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this);
            AppMethodBeat.o(32967);
            return 0;
          }
          if (ac.a.a(CheckCanSubscribeBizUI.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 7))
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
    hFz();
    finish();
    AppMethodBeat.o(32969);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32972);
    super.onDestroy();
    if (this.VRB != null) {
      this.VRB.clear();
    }
    if (bh.aHB())
    {
      bh.aGY().b(605, this);
      af.bjv().remove(this);
      ((n)h.ae(n.class)).bbL().remove(this);
    }
    AppMethodBeat.o(32972);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32978);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.VRD = true;
      if (this.VRE)
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(32975);
    Log.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramq.getType() == 605)
    {
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, MMFunc_CheckCanSubscribeBiz  do nothing");
      AppMethodBeat.o(32975);
      return;
    }
    if (paramq.getType() == 233)
    {
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, MMFunc_GetA8Key");
      bh.aGY().b(233, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (l)paramq;
        paramInt1 = paramString.boh();
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == 15)
        {
          paramString = paramString.bof();
          Log.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramq = new ju();
          paramq.fHe.actionCode = paramInt1;
          paramq.fHe.result = paramString;
          paramq.fHe.context = this;
          EventCenter.instance.asyncPublish(paramq, Looper.myLooper());
          finish();
          AppMethodBeat.o(32975);
          return;
        }
        Log.e("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, geta8key  actionCode = ".concat(String.valueOf(paramInt1)));
        hFy();
        AppMethodBeat.o(32975);
        return;
      }
      Log.e("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, geta8key  errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      hFy();
      AppMethodBeat.o(32975);
      return;
    }
    Log.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[] { Integer.valueOf(paramq.getType()) });
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