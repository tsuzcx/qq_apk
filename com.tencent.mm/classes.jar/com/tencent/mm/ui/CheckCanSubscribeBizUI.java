package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x;
import com.tencent.mm.am.f;
import com.tencent.mm.api.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI
  extends MMActivity
  implements com.tencent.mm.al.g, k.a, n.b
{
  private boolean FHA = false;
  private boolean FHB = false;
  private boolean FHC = false;
  private String FHD;
  private int FHE = 0;
  private int FHx;
  private LinkedList<cmf> FHy;
  private boolean FHz = false;
  private String appId;
  private int dep;
  private String dhI;
  private String dio;
  private String extInfo;
  private int fromScene;
  private boolean gPQ = false;
  private String rso;
  private int scene;
  
  private boolean aVQ()
  {
    AppMethodBeat.i(32974);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      ad.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.appId = localIntent.getStringExtra("appId");
    this.dio = localIntent.getStringExtra("toUserName");
    if (bt.isNullOrNil(this.dio))
    {
      ad.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.dep = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.FHE = localIntent.getIntExtra("jump_profile_type", 0);
    switch (this.dep)
    {
    default: 
      ad.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[] { Integer.valueOf(this.dep) });
      AppMethodBeat.o(32974);
      return false;
    case 1: 
      if (bt.isNullOrNil(this.appId))
      {
        ad.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.fromScene = 68;
      ArrayList localArrayList = localIntent.getStringArrayListExtra("androidPackNameList");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        ad.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.FHy = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!bt.isNullOrNil(str))
        {
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.FHy.add(z.BE(str));
        }
        i += 1;
      }
      if (this.FHy.size() == 0)
      {
        ad.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.FHx = this.FHy.size();
    }
    for (;;)
    {
      this.dhI = localIntent.getStringExtra("fromURL");
      AppMethodBeat.o(32974);
      return true;
      this.fromScene = 69;
    }
  }
  
  private void cas()
  {
    AppMethodBeat.i(32981);
    if (this.dep == 1) {
      LauncherUI.jk(this);
    }
    AppMethodBeat.o(32981);
  }
  
  private void ePo()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32976);
        ad.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.FHz);
        if (this.scene == 1)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.FHD);
          d.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          AppMethodBeat.o(32976);
          return;
        }
        if ((this.scene != 0) || (this.FHE != 1)) {
          break label175;
        }
        if (this.FHB)
        {
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          AppMethodBeat.o(32976);
          continue;
        }
        this.FHB = true;
      }
      finally {}
      az.aeS().a(233, this);
      Object localObject2 = new com.tencent.mm.modelsimple.k(this.extInfo, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
      az.aeS().a((com.tencent.mm.al.n)localObject2, 0);
      AppMethodBeat.o(32976);
      continue;
      label175:
      if ((ePp()) && (this.FHz))
      {
        if (!this.FHB)
        {
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.dio);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (bt.isNullOrNil(this.dio)) {
            com.tencent.mm.ui.contact.e.a((Intent)localObject2, this.dio);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.FHA)
          {
            setResult(-1);
            this.FHB = true;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
      else
      {
        if ((this.FHz) && (!this.FHB))
        {
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.dio);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("Contact_Scene", this.fromScene);
          localIntent2.putExtra("Verify_ticket", this.rso);
          if (localObject2 != null)
          {
            localIntent2.putExtra("Contact_Alias", ((com.tencent.mm.storage.af)localObject2).Ss());
            localIntent2.putExtra("Contact_Nick", ((au)localObject2).field_nickname);
            localIntent2.putExtra("Contact_Signature", ((au)localObject2).signature);
            localIntent2.putExtra("Contact_RegionCode", ((au)localObject2).evF);
            localIntent2.putExtra("Contact_Sex", ((au)localObject2).evp);
            localIntent2.putExtra("Contact_VUser_Info", ((au)localObject2).evE);
            localIntent2.putExtra("Contact_VUser_Info_Flag", ((au)localObject2).field_verifyFlag);
            localIntent2.putExtra("Contact_KWeibo_flag", ((au)localObject2).field_weiboFlag);
            localIntent2.putExtra("Contact_KWeibo", ((au)localObject2).evD);
            localIntent2.putExtra("Contact_KWeiboNick", ((au)localObject2).field_weiboNickname);
          }
          com.tencent.mm.ui.contact.e.u(localIntent2, this.dio);
          if (!this.FHA)
          {
            setResult(-1);
            this.FHB = true;
            d.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
    }
  }
  
  private boolean ePp()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32977);
        com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.dio);
        if ((localaf != null) && ((int)localaf.fId != 0)) {
          break label308;
        }
        ad.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
        i = 1;
        c localc = null;
        if (i == 0) {
          localc = f.ei(this.dio);
        }
        if ((localc == null) || (localc.IY()))
        {
          ad.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + localc + ") is null or should update.");
          i = 1;
        }
        if (this.FHC)
        {
          if (localaf == null)
          {
            this.FHz = false;
            setResult(5);
            ePr();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            return bool;
          }
          this.FHz = true;
          this.gPQ = true;
          if (com.tencent.mm.n.b.ls(localaf.field_type)) {
            break label287;
          }
          AppMethodBeat.o(32977);
          bool = false;
          continue;
        }
        if (i != 0)
        {
          if (this.FHz)
          {
            setResult(5);
            ePr();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            continue;
          }
          ar.a.gMW.a(this.dio, "", new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(32966);
              if (!paramAnonymousBoolean)
              {
                CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this);
                CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
              }
              AppMethodBeat.o(32966);
            }
          });
          continue;
        }
        if (com.tencent.mm.n.b.ls(localaf.field_type)) {
          break label287;
        }
      }
      finally {}
      ad.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
      this.FHz = true;
      AppMethodBeat.o(32977);
      boolean bool = false;
      continue;
      label287:
      this.FHz = true;
      this.gPQ = true;
      AppMethodBeat.o(32977);
      bool = true;
      continue;
      label308:
      int i = 0;
    }
  }
  
  private void ePq()
  {
    AppMethodBeat.i(32979);
    Toast.makeText(this, getString(2131764651), 1).show();
    cas();
    AppMethodBeat.o(32979);
  }
  
  private void ePr()
  {
    AppMethodBeat.i(32980);
    Toast.makeText(this, 2131762376, 1).show();
    cas();
    AppMethodBeat.o(32980);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(32983);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(32983);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(32983);
  }
  
  public final void a(final String paramString, m paramm)
  {
    AppMethodBeat.i(32982);
    new ap().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32968);
        ad.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.d(CheckCanSubscribeBizUI.this) + ", userName = " + paramString);
        if (CheckCanSubscribeBizUI.d(CheckCanSubscribeBizUI.this).equals(paramString))
        {
          CheckCanSubscribeBizUI.e(CheckCanSubscribeBizUI.this);
          if (!CheckCanSubscribeBizUI.f(CheckCanSubscribeBizUI.this)) {
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
          }
        }
        AppMethodBeat.o(32968);
      }
    });
    AppMethodBeat.o(32982);
  }
  
  protected int getLayoutId()
  {
    return 2131494530;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32969);
    super.onCreate(paramBundle);
    hideTitleView();
    if ((!az.arW()) || (az.aeC()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(32969);
      return;
    }
    az.aeS().a(605, this);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().a(this);
    com.tencent.mm.am.af.awe().add(this);
    if (aVQ())
    {
      paramBundle = this.appId;
      String str1 = this.dio;
      String str2 = this.extInfo;
      int i = this.FHx;
      LinkedList localLinkedList = this.FHy;
      String str3 = this.dhI;
      int j = this.dep;
      int k = this.scene;
      Object localObject = new b.a();
      ((b.a)localObject).gUU = new uj();
      ((b.a)localObject).gUV = new uk();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((b.a)localObject).funcId = 605;
      localObject = ((b.a)localObject).atI();
      uj localuj = (uj)((com.tencent.mm.al.b)localObject).gUS.gUX;
      localuj.fVC = paramBundle;
      localuj.sdP = str1;
      localuj.sed = str2;
      localuj.CWa = i;
      localuj.CWb = localLinkedList;
      localuj.CWc = null;
      localuj.CWd = str3;
      localuj.rNz = j;
      localuj.Scene = k;
      ad.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      x.a((com.tencent.mm.al.b)localObject, new com.tencent.mm.al.x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(32967);
          paramAnonymousb = (uk)paramAnonymousb.gUT.gUX;
          CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this, paramAnonymousb.CWe);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!bt.isNullOrNil(paramAnonymousb.CWe)) && (!bt.isNullOrNil(paramAnonymousb.sdP)))
          {
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this, paramAnonymousb.sdP);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this, paramAnonymousb.CWf);
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
            AppMethodBeat.o(32967);
            return 0;
          }
          if (x.a.a(CheckCanSubscribeBizUI.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 7))
          {
            CheckCanSubscribeBizUI.this.setResult(5);
            CheckCanSubscribeBizUI.this.finish();
            AppMethodBeat.o(32967);
            return 0;
          }
          CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this);
          CheckCanSubscribeBizUI.this.setResult(3);
          CheckCanSubscribeBizUI.this.finish();
          AppMethodBeat.o(32967);
          return 0;
        }
      });
      AppMethodBeat.o(32969);
      return;
    }
    setResult(2);
    ePr();
    finish();
    AppMethodBeat.o(32969);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32972);
    super.onDestroy();
    if (this.FHy != null) {
      this.FHy.clear();
    }
    if (az.afw())
    {
      az.aeS().b(605, this);
      com.tencent.mm.am.af.awe().remove(this);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(this);
    }
    AppMethodBeat.o(32972);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32978);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.FHA = true;
      if (this.FHB)
      {
        AppMethodBeat.o(32978);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(32978);
    return bool;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(32975);
    ad.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramn.getType() != 605)
    {
      if (paramn.getType() == 233)
      {
        az.aeS().b(233, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.modelsimple.k)paramn;
          paramInt1 = paramString.aAs();
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 == 15)
          {
            paramString = paramString.aAq();
            ad.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            paramn = new hz();
            paramn.dlM.actionCode = paramInt1;
            paramn.dlM.result = paramString;
            paramn.dlM.context = this;
            com.tencent.mm.sdk.b.a.ESL.a(paramn, Looper.myLooper());
            finish();
            AppMethodBeat.o(32975);
            return;
          }
          ePq();
          AppMethodBeat.o(32975);
          return;
        }
        ePq();
        AppMethodBeat.o(32975);
        return;
      }
      ad.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[] { Integer.valueOf(paramn.getType()) });
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI
 * JD-Core Version:    0.7.0.1
 */