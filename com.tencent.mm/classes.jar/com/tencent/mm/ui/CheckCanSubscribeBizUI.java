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
import com.tencent.mm.al.x.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.api.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI
  extends MMActivity
  implements com.tencent.mm.al.f, k.a, n.b
{
  private int ITV;
  private LinkedList<cwt> ITW;
  private boolean ITX = false;
  private boolean ITY = false;
  private boolean ITZ = false;
  private boolean IUa = false;
  private String IUb;
  private int IUc = 0;
  private String appId;
  private int dnh;
  private String dqz;
  private String drf;
  private String extInfo;
  private int fromScene;
  private boolean hII = false;
  private int scene;
  private String txJ;
  
  private boolean bgs()
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
    this.drf = localIntent.getStringExtra("toUserName");
    if (bt.isNullOrNil(this.drf))
    {
      ad.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.dnh = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.IUc = localIntent.getIntExtra("jump_profile_type", 0);
    switch (this.dnh)
    {
    default: 
      ad.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[] { Integer.valueOf(this.dnh) });
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
      this.ITW = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!bt.isNullOrNil(str))
        {
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.ITW.add(z.IX(str));
        }
        i += 1;
      }
      if (this.ITW.size() == 0)
      {
        ad.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.ITV = this.ITW.size();
    }
    for (;;)
    {
      this.dqz = localIntent.getStringExtra("fromURL");
      AppMethodBeat.o(32974);
      return true;
      this.fromScene = 69;
    }
  }
  
  private void cmf()
  {
    AppMethodBeat.i(32981);
    if (this.dnh == 1) {
      LauncherUI.jF(this);
    }
    AppMethodBeat.o(32981);
  }
  
  private void fva()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32976);
        ad.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.ITX);
        if (this.scene == 1)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.IUb);
          d.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          AppMethodBeat.o(32976);
          return;
        }
        if ((this.scene != 0) || (this.IUc != 1)) {
          break label175;
        }
        if (this.ITZ)
        {
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          AppMethodBeat.o(32976);
          continue;
        }
        this.ITZ = true;
      }
      finally {}
      ba.aiU().a(233, this);
      Object localObject2 = new k(this.extInfo, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
      ba.aiU().a((com.tencent.mm.al.n)localObject2, 0);
      AppMethodBeat.o(32976);
      continue;
      label175:
      if ((fvb()) && (this.ITX))
      {
        if (!this.ITZ)
        {
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.drf);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (bt.isNullOrNil(this.drf)) {
            e.a((Intent)localObject2, this.drf);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.ITY)
          {
            setResult(-1);
            this.ITZ = true;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
      else
      {
        if ((this.ITX) && (!this.ITZ))
        {
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
          localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.drf);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("Contact_Scene", this.fromScene);
          localIntent2.putExtra("Verify_ticket", this.txJ);
          if (localObject2 != null)
          {
            localIntent2.putExtra("Contact_Alias", ((am)localObject2).VA());
            localIntent2.putExtra("Contact_Nick", ((aw)localObject2).field_nickname);
            localIntent2.putExtra("Contact_Signature", ((aw)localObject2).signature);
            localIntent2.putExtra("Contact_RegionCode", ((aw)localObject2).ePA);
            localIntent2.putExtra("Contact_Sex", ((aw)localObject2).ePk);
            localIntent2.putExtra("Contact_VUser_Info", ((aw)localObject2).ePz);
            localIntent2.putExtra("Contact_VUser_Info_Flag", ((aw)localObject2).field_verifyFlag);
            localIntent2.putExtra("Contact_KWeibo_flag", ((aw)localObject2).field_weiboFlag);
            localIntent2.putExtra("Contact_KWeibo", ((aw)localObject2).ePy);
            localIntent2.putExtra("Contact_KWeiboNick", ((aw)localObject2).field_weiboNickname);
          }
          e.u(localIntent2, this.drf);
          if (!this.ITY)
          {
            setResult(-1);
            this.ITZ = true;
            d.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
    }
  }
  
  private boolean fvb()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32977);
        am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.drf);
        if ((localam != null) && ((int)localam.gfj != 0)) {
          break label308;
        }
        ad.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
        i = 1;
        c localc = null;
        if (i == 0) {
          localc = com.tencent.mm.am.g.eS(this.drf);
        }
        if ((localc == null) || (localc.Kh()))
        {
          ad.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + localc + ") is null or should update.");
          i = 1;
        }
        if (this.IUa)
        {
          if (localam == null)
          {
            this.ITX = false;
            setResult(5);
            fvd();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            return bool;
          }
          this.ITX = true;
          this.hII = true;
          if (com.tencent.mm.o.b.lM(localam.field_type)) {
            break label287;
          }
          AppMethodBeat.o(32977);
          bool = false;
          continue;
        }
        if (i != 0)
        {
          if (this.ITX)
          {
            setResult(5);
            fvd();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            continue;
          }
          as.a.hFO.a(this.drf, "", new as.b.a()
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
        if (com.tencent.mm.o.b.lM(localam.field_type)) {
          break label287;
        }
      }
      finally {}
      ad.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
      this.ITX = true;
      AppMethodBeat.o(32977);
      boolean bool = false;
      continue;
      label287:
      this.ITX = true;
      this.hII = true;
      AppMethodBeat.o(32977);
      bool = true;
      continue;
      label308:
      int i = 0;
    }
  }
  
  private void fvc()
  {
    AppMethodBeat.i(32979);
    Toast.makeText(this, getString(2131764651), 1).show();
    cmf();
    AppMethodBeat.o(32979);
  }
  
  private void fvd()
  {
    AppMethodBeat.i(32980);
    Toast.makeText(this, 2131762376, 1).show();
    cmf();
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
    if ((!ba.aBR()) || (ba.aiE()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(32969);
      return;
    }
    ba.aiU().a(605, this);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(this);
    ag.aFZ().add(this);
    if (bgs())
    {
      paramBundle = this.appId;
      String str1 = this.drf;
      String str2 = this.extInfo;
      int i = this.ITV;
      LinkedList localLinkedList = this.ITW;
      String str3 = this.dqz;
      int j = this.dnh;
      int k = this.scene;
      Object localObject = new b.a();
      ((b.a)localObject).hNM = new ws();
      ((b.a)localObject).hNN = new wt();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((b.a)localObject).funcId = 605;
      localObject = ((b.a)localObject).aDC();
      ws localws = (ws)((com.tencent.mm.al.b)localObject).hNK.hNQ;
      localws.gsT = paramBundle;
      localws.uki = str1;
      localws.ukw = str2;
      localws.FVV = i;
      localws.FVW = localLinkedList;
      localws.FVX = null;
      localws.FVY = str3;
      localws.tRT = j;
      localws.Scene = k;
      ad.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      x.a((com.tencent.mm.al.b)localObject, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(32967);
          paramAnonymousb = (wt)paramAnonymousb.hNL.hNQ;
          CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this, paramAnonymousb.FVZ);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!bt.isNullOrNil(paramAnonymousb.FVZ)) && (!bt.isNullOrNil(paramAnonymousb.uki)))
          {
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this, paramAnonymousb.uki);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this, paramAnonymousb.FWa);
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
            AppMethodBeat.o(32967);
            return 0;
          }
          if (y.a.a(CheckCanSubscribeBizUI.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 7))
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
    fvd();
    finish();
    AppMethodBeat.o(32969);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32972);
    super.onDestroy();
    if (this.ITW != null) {
      this.ITW.clear();
    }
    if (ba.ajx())
    {
      ba.aiU().b(605, this);
      ag.aFZ().remove(this);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(this);
    }
    AppMethodBeat.o(32972);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32978);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.ITY = true;
      if (this.ITZ)
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
        ba.aiU().b(233, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (k)paramn;
          paramInt1 = paramString.aKt();
          ad.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 == 15)
          {
            paramString = paramString.aKr();
            ad.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            paramn = new io();
            paramn.dvh.actionCode = paramInt1;
            paramn.dvh.result = paramString;
            paramn.dvh.context = this;
            com.tencent.mm.sdk.b.a.IbL.a(paramn, Looper.myLooper());
            finish();
            AppMethodBeat.o(32975);
            return;
          }
          fvc();
          AppMethodBeat.o(32975);
          return;
        }
        fvc();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI
 * JD-Core Version:    0.7.0.1
 */