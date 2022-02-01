package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI
  extends MMActivity
  implements com.tencent.mm.ak.g, k.a, n.b
{
  private int HgF;
  private LinkedList<crm> HgG;
  private boolean HgH = false;
  private boolean HgI = false;
  private boolean HgJ = false;
  private boolean HgK = false;
  private String HgL;
  private int HgM = 0;
  private String appId;
  private int dbL;
  private String dfJ;
  private String dfd;
  private String extInfo;
  private int fromScene;
  private boolean hqq = false;
  private String sBi;
  private int scene;
  
  private boolean bcO()
  {
    AppMethodBeat.i(32974);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      ac.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.appId = localIntent.getStringExtra("appId");
    this.dfJ = localIntent.getStringExtra("toUserName");
    if (bs.isNullOrNil(this.dfJ))
    {
      ac.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.dbL = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.HgM = localIntent.getIntExtra("jump_profile_type", 0);
    switch (this.dbL)
    {
    default: 
      ac.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[] { Integer.valueOf(this.dbL) });
      AppMethodBeat.o(32974);
      return false;
    case 1: 
      if (bs.isNullOrNil(this.appId))
      {
        ac.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.fromScene = 68;
      ArrayList localArrayList = localIntent.getStringArrayListExtra("androidPackNameList");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        ac.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.HgG = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!bs.isNullOrNil(str))
        {
          ac.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.HgG.add(z.FI(str));
        }
        i += 1;
      }
      if (this.HgG.size() == 0)
      {
        ac.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.HgF = this.HgG.size();
    }
    for (;;)
    {
      this.dfd = localIntent.getStringExtra("fromURL");
      AppMethodBeat.o(32974);
      return true;
      this.fromScene = 69;
    }
  }
  
  private void chB()
  {
    AppMethodBeat.i(32981);
    if (this.dbL == 1) {
      LauncherUI.jv(this);
    }
    AppMethodBeat.o(32981);
  }
  
  private void feS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32976);
        ac.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.HgH);
        if (this.scene == 1)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.HgL);
          d.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          AppMethodBeat.o(32976);
          return;
        }
        if ((this.scene != 0) || (this.HgM != 1)) {
          break label175;
        }
        if (this.HgJ)
        {
          ac.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          AppMethodBeat.o(32976);
          continue;
        }
        this.HgJ = true;
      }
      finally {}
      az.agi().a(233, this);
      Object localObject2 = new com.tencent.mm.modelsimple.k(this.extInfo, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
      az.agi().a((com.tencent.mm.ak.n)localObject2, 0);
      AppMethodBeat.o(32976);
      continue;
      label175:
      if ((feT()) && (this.HgH))
      {
        if (!this.HgJ)
        {
          ac.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.dfJ);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (bs.isNullOrNil(this.dfJ)) {
            com.tencent.mm.ui.contact.e.a((Intent)localObject2, this.dfJ);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.HgI)
          {
            setResult(-1);
            this.HgJ = true;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
      else
      {
        if ((this.HgH) && (!this.HgJ))
        {
          ac.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.dfJ);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("Contact_Scene", this.fromScene);
          localIntent2.putExtra("Verify_ticket", this.sBi);
          if (localObject2 != null)
          {
            localIntent2.putExtra("Contact_Alias", ((ai)localObject2).Tl());
            localIntent2.putExtra("Contact_Nick", ((av)localObject2).field_nickname);
            localIntent2.putExtra("Contact_Signature", ((av)localObject2).signature);
            localIntent2.putExtra("Contact_RegionCode", ((av)localObject2).eyb);
            localIntent2.putExtra("Contact_Sex", ((av)localObject2).exL);
            localIntent2.putExtra("Contact_VUser_Info", ((av)localObject2).eya);
            localIntent2.putExtra("Contact_VUser_Info_Flag", ((av)localObject2).field_verifyFlag);
            localIntent2.putExtra("Contact_KWeibo_flag", ((av)localObject2).field_weiboFlag);
            localIntent2.putExtra("Contact_KWeibo", ((av)localObject2).exZ);
            localIntent2.putExtra("Contact_KWeiboNick", ((av)localObject2).field_weiboNickname);
          }
          com.tencent.mm.ui.contact.e.u(localIntent2, this.dfJ);
          if (!this.HgI)
          {
            setResult(-1);
            this.HgJ = true;
            d.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
    }
  }
  
  private boolean feT()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32977);
        ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.dfJ);
        if ((localai != null) && ((int)localai.fLJ != 0)) {
          break label308;
        }
        ac.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
        i = 1;
        c localc = null;
        if (i == 0) {
          localc = f.dX(this.dfJ);
        }
        if ((localc == null) || (localc.IH()))
        {
          ac.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + localc + ") is null or should update.");
          i = 1;
        }
        if (this.HgK)
        {
          if (localai == null)
          {
            this.HgH = false;
            setResult(5);
            feV();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            return bool;
          }
          this.HgH = true;
          this.hqq = true;
          if (com.tencent.mm.n.b.ln(localai.field_type)) {
            break label287;
          }
          AppMethodBeat.o(32977);
          bool = false;
          continue;
        }
        if (i != 0)
        {
          if (this.HgH)
          {
            setResult(5);
            feV();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            continue;
          }
          ar.a.hnw.a(this.dfJ, "", new ar.b.a()
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
        if (com.tencent.mm.n.b.ln(localai.field_type)) {
          break label287;
        }
      }
      finally {}
      ac.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
      this.HgH = true;
      AppMethodBeat.o(32977);
      boolean bool = false;
      continue;
      label287:
      this.HgH = true;
      this.hqq = true;
      AppMethodBeat.o(32977);
      bool = true;
      continue;
      label308:
      int i = 0;
    }
  }
  
  private void feU()
  {
    AppMethodBeat.i(32979);
    Toast.makeText(this, getString(2131764651), 1).show();
    chB();
    AppMethodBeat.o(32979);
  }
  
  private void feV()
  {
    AppMethodBeat.i(32980);
    Toast.makeText(this, 2131762376, 1).show();
    chB();
    AppMethodBeat.o(32980);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(32983);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(32983);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(32983);
  }
  
  public final void a(final String paramString, m paramm)
  {
    AppMethodBeat.i(32982);
    new ao().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32968);
        ac.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.d(CheckCanSubscribeBizUI.this) + ", userName = " + paramString);
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
    if ((!az.ayN()) || (az.afS()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(32969);
      return;
    }
    az.agi().a(605, this);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().a(this);
    af.aCW().add(this);
    if (bcO())
    {
      paramBundle = this.appId;
      String str1 = this.dfJ;
      String str2 = this.extInfo;
      int i = this.HgF;
      LinkedList localLinkedList = this.HgG;
      String str3 = this.dfd;
      int j = this.dbL;
      int k = this.scene;
      Object localObject = new b.a();
      ((b.a)localObject).hvt = new ut();
      ((b.a)localObject).hvu = new uu();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((b.a)localObject).funcId = 605;
      localObject = ((b.a)localObject).aAz();
      ut localut = (ut)((com.tencent.mm.ak.b)localObject).hvr.hvw;
      localut.fZx = paramBundle;
      localut.tlJ = str1;
      localut.tlX = str2;
      localut.EoJ = i;
      localut.EoK = localLinkedList;
      localut.EoL = null;
      localut.EoM = str3;
      localut.sVo = j;
      localut.Scene = k;
      ac.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      x.a((com.tencent.mm.ak.b)localObject, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(32967);
          paramAnonymousb = (uu)paramAnonymousb.hvs.hvw;
          CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this, paramAnonymousb.EoN);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!bs.isNullOrNil(paramAnonymousb.EoN)) && (!bs.isNullOrNil(paramAnonymousb.tlJ)))
          {
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this, paramAnonymousb.tlJ);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this, paramAnonymousb.EoO);
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
    feV();
    finish();
    AppMethodBeat.o(32969);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32972);
    super.onDestroy();
    if (this.HgG != null) {
      this.HgG.clear();
    }
    if (az.agM())
    {
      az.agi().b(605, this);
      af.aCW().remove(this);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this);
    }
    AppMethodBeat.o(32972);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32978);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.HgI = true;
      if (this.HgJ)
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(32975);
    ac.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramn.getType() != 605)
    {
      if (paramn.getType() == 233)
      {
        az.agi().b(233, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.modelsimple.k)paramn;
          paramInt1 = paramString.aHi();
          ac.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 == 15)
          {
            paramString = paramString.aHg();
            ac.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            paramn = new ig();
            paramn.dju.actionCode = paramInt1;
            paramn.dju.result = paramString;
            paramn.dju.context = this;
            com.tencent.mm.sdk.b.a.GpY.a(paramn, Looper.myLooper());
            finish();
            AppMethodBeat.o(32975);
            return;
          }
          feU();
          AppMethodBeat.o(32975);
          return;
        }
        feU();
        AppMethodBeat.o(32975);
        return;
      }
      ac.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[] { Integer.valueOf(paramn.getType()) });
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