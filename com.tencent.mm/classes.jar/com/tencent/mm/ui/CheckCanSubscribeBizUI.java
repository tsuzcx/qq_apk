package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI
  extends MMActivity
  implements com.tencent.mm.ak.f, k.a, n.b
{
  private int JoD;
  private LinkedList<cxn> JoE;
  private boolean JoF = false;
  private boolean JoG = false;
  private boolean JoH = false;
  private boolean JoI = false;
  private String JoJ;
  private int JoK = 0;
  private String appId;
  private int doj;
  private String drE;
  private String dsk;
  private String extInfo;
  private int fromScene;
  private boolean hLB = false;
  private int scene;
  private String tIA;
  
  private boolean bha()
  {
    AppMethodBeat.i(32974);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      ae.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.appId = localIntent.getStringExtra("appId");
    this.dsk = localIntent.getStringExtra("toUserName");
    if (bu.isNullOrNil(this.dsk))
    {
      ae.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.doj = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.JoK = localIntent.getIntExtra("jump_profile_type", 0);
    switch (this.doj)
    {
    default: 
      ae.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[] { Integer.valueOf(this.doj) });
      AppMethodBeat.o(32974);
      return false;
    case 1: 
      if (bu.isNullOrNil(this.appId))
      {
        ae.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.fromScene = 68;
      ArrayList localArrayList = localIntent.getStringArrayListExtra("androidPackNameList");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        ae.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.JoE = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!bu.isNullOrNil(str))
        {
          ae.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.JoE.add(z.Jw(str));
        }
        i += 1;
      }
      if (this.JoE.size() == 0)
      {
        ae.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.JoD = this.JoE.size();
    }
    for (;;)
    {
      this.drE = localIntent.getStringExtra("fromURL");
      AppMethodBeat.o(32974);
      return true;
      this.fromScene = 69;
    }
  }
  
  private void cnv()
  {
    AppMethodBeat.i(32981);
    if (this.doj == 1) {
      LauncherUI.jM(this);
    }
    AppMethodBeat.o(32981);
  }
  
  private void fzb()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32976);
        ae.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.JoF);
        if (this.scene == 1)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.JoJ);
          d.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          AppMethodBeat.o(32976);
          return;
        }
        if ((this.scene != 0) || (this.JoK != 1)) {
          break label175;
        }
        if (this.JoH)
        {
          ae.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          AppMethodBeat.o(32976);
          continue;
        }
        this.JoH = true;
      }
      finally {}
      bc.ajj().a(233, this);
      Object localObject2 = new com.tencent.mm.modelsimple.l(this.extInfo, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
      bc.ajj().a((com.tencent.mm.ak.n)localObject2, 0);
      AppMethodBeat.o(32976);
      continue;
      label175:
      if ((fzc()) && (this.JoF))
      {
        if (!this.JoH)
        {
          ae.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.dsk);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (bu.isNullOrNil(this.dsk)) {
            e.a((Intent)localObject2, this.dsk);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.JoG)
          {
            setResult(-1);
            this.JoH = true;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
      else
      {
        if ((this.JoF) && (!this.JoH))
        {
          ae.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.dsk);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("Contact_Scene", this.fromScene);
          localIntent2.putExtra("Verify_ticket", this.tIA);
          if (localObject2 != null)
          {
            localIntent2.putExtra("Contact_Alias", ((an)localObject2).VI());
            localIntent2.putExtra("Contact_Nick", ((aw)localObject2).field_nickname);
            localIntent2.putExtra("Contact_Signature", ((aw)localObject2).signature);
            localIntent2.putExtra("Contact_RegionCode", ((aw)localObject2).eRl);
            localIntent2.putExtra("Contact_Sex", ((aw)localObject2).eQV);
            localIntent2.putExtra("Contact_VUser_Info", ((aw)localObject2).eRk);
            localIntent2.putExtra("Contact_VUser_Info_Flag", ((aw)localObject2).field_verifyFlag);
            localIntent2.putExtra("Contact_KWeibo_flag", ((aw)localObject2).field_weiboFlag);
            localIntent2.putExtra("Contact_KWeibo", ((aw)localObject2).eRj);
            localIntent2.putExtra("Contact_KWeiboNick", ((aw)localObject2).field_weiboNickname);
          }
          e.u(localIntent2, this.dsk);
          if (!this.JoG)
          {
            setResult(-1);
            this.JoH = true;
            d.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
    }
  }
  
  private boolean fzc()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32977);
        an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.dsk);
        if ((localan != null) && ((int)localan.ght != 0)) {
          break label308;
        }
        ae.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
        i = 1;
        com.tencent.mm.api.c localc = null;
        if (i == 0) {
          localc = com.tencent.mm.al.g.eX(this.dsk);
        }
        if ((localc == null) || (localc.Kp()))
        {
          ae.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + localc + ") is null or should update.");
          i = 1;
        }
        if (this.JoI)
        {
          if (localan == null)
          {
            this.JoF = false;
            setResult(5);
            fze();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            return bool;
          }
          this.JoF = true;
          this.hLB = true;
          if (com.tencent.mm.contact.c.lO(localan.field_type)) {
            break label287;
          }
          AppMethodBeat.o(32977);
          bool = false;
          continue;
        }
        if (i != 0)
        {
          if (this.JoF)
          {
            setResult(5);
            fze();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            continue;
          }
          au.a.hIG.a(this.dsk, "", new au.b.a()
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
        if (com.tencent.mm.contact.c.lO(localan.field_type)) {
          break label287;
        }
      }
      finally {}
      ae.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
      this.JoF = true;
      AppMethodBeat.o(32977);
      boolean bool = false;
      continue;
      label287:
      this.JoF = true;
      this.hLB = true;
      AppMethodBeat.o(32977);
      bool = true;
      continue;
      label308:
      int i = 0;
    }
  }
  
  private void fzd()
  {
    AppMethodBeat.i(32979);
    Toast.makeText(this, getString(2131764651), 1).show();
    cnv();
    AppMethodBeat.o(32979);
  }
  
  private void fze()
  {
    AppMethodBeat.i(32980);
    Toast.makeText(this, 2131762376, 1).show();
    cnv();
    AppMethodBeat.o(32980);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(32983);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(32983);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(32983);
  }
  
  public final void a(final String paramString, m paramm)
  {
    AppMethodBeat.i(32982);
    new aq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32968);
        ae.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.d(CheckCanSubscribeBizUI.this) + ", userName = " + paramString);
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
    if ((!bc.aCh()) || (bc.aiT()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(32969);
      return;
    }
    bc.ajj().a(605, this);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().a(this);
    ag.aGp().add(this);
    if (bha())
    {
      paramBundle = this.appId;
      String str1 = this.dsk;
      String str2 = this.extInfo;
      int i = this.JoD;
      LinkedList localLinkedList = this.JoE;
      String str3 = this.drE;
      int j = this.doj;
      int k = this.scene;
      Object localObject = new b.a();
      ((b.a)localObject).hQF = new wv();
      ((b.a)localObject).hQG = new ww();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((b.a)localObject).funcId = 605;
      localObject = ((b.a)localObject).aDS();
      wv localwv = (wv)((b)localObject).hQD.hQJ;
      localwv.gvv = paramBundle;
      localwv.uvF = str1;
      localwv.uvT = str2;
      localwv.Gou = i;
      localwv.Gov = localLinkedList;
      localwv.Gow = null;
      localwv.Gox = str3;
      localwv.ucK = j;
      localwv.Scene = k;
      ae.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      x.a((b)localObject, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(32967);
          paramAnonymousb = (ww)paramAnonymousb.hQE.hQJ;
          CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this, paramAnonymousb.Goy);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!bu.isNullOrNil(paramAnonymousb.Goy)) && (!bu.isNullOrNil(paramAnonymousb.uvF)))
          {
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this, paramAnonymousb.uvF);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this, paramAnonymousb.Goz);
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
    fze();
    finish();
    AppMethodBeat.o(32969);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32972);
    super.onDestroy();
    if (this.JoE != null) {
      this.JoE.clear();
    }
    if (bc.ajM())
    {
      bc.ajj().b(605, this);
      ag.aGp().remove(this);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(this);
    }
    AppMethodBeat.o(32972);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32978);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.JoG = true;
      if (this.JoH)
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
    ae.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramn.getType() != 605)
    {
      if (paramn.getType() == 233)
      {
        bc.ajj().b(233, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.modelsimple.l)paramn;
          paramInt1 = paramString.aKQ();
          ae.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 == 15)
          {
            paramString = paramString.aKO();
            ae.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            paramn = new ip();
            paramn.dwm.actionCode = paramInt1;
            paramn.dwm.result = paramString;
            paramn.dwm.context = this;
            com.tencent.mm.sdk.b.a.IvT.a(paramn, Looper.myLooper());
            finish();
            AppMethodBeat.o(32975);
            return;
          }
          fzd();
          AppMethodBeat.o(32975);
          return;
        }
        fzd();
        AppMethodBeat.o(32975);
        return;
      }
      ae.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[] { Integer.valueOf(paramn.getType()) });
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