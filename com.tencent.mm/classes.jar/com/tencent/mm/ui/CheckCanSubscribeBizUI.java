package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.protocal.protobuf.yg;
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
  private boolean OyA = false;
  private boolean OyB = false;
  private boolean OyC = false;
  private String OyD;
  private int OyE = 0;
  private int Oyx;
  private LinkedList<dqi> Oyy;
  private boolean Oyz = false;
  private String appId;
  private String dIQ;
  private String dJw;
  private String extInfo;
  private int fromScene;
  private boolean iGD = false;
  private int scene;
  private int source;
  private String wZz;
  
  private boolean bCt()
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
    this.dJw = localIntent.getStringExtra("toUserName");
    if (Util.isNullOrNil(this.dJw))
    {
      Log.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      AppMethodBeat.o(32974);
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.source = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.OyE = localIntent.getIntExtra("jump_profile_type", 0);
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
      this.Oyy = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!Util.isNullOrNil(str))
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.Oyy.add(z.Su(str));
        }
        i += 1;
      }
      if (this.Oyy.size() == 0)
      {
        Log.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        AppMethodBeat.o(32974);
        return false;
      }
      this.Oyx = this.Oyy.size();
    }
    for (;;)
    {
      this.dIQ = localIntent.getStringExtra("fromURL");
      AppMethodBeat.o(32974);
      return true;
      this.fromScene = 69;
    }
  }
  
  private void cLI()
  {
    AppMethodBeat.i(32981);
    if (this.source == 1) {
      LauncherUI.jI(this);
    }
    AppMethodBeat.o(32981);
  }
  
  private void gGP()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32976);
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.Oyz);
        if (this.scene == 1)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.OyD);
          com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          AppMethodBeat.o(32976);
          return;
        }
        if ((this.scene != 0) || (this.OyE != 1)) {
          break label175;
        }
        if (this.OyB)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          AppMethodBeat.o(32976);
          continue;
        }
        this.OyB = true;
      }
      finally {}
      bg.azz().a(233, this);
      Object localObject2 = new com.tencent.mm.modelsimple.l(this.extInfo, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
      bg.azz().a((q)localObject2, 0);
      AppMethodBeat.o(32976);
      continue;
      label175:
      if ((gGQ()) && (this.Oyz))
      {
        if (!this.OyB)
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.dJw);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (Util.isNullOrNil(this.dJw)) {
            e.a((Intent)localObject2, this.dJw);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.OyA)
          {
            setResult(-1);
            this.OyB = true;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
      else
      {
        if ((this.Oyz) && (!this.OyB))
        {
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.dJw);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("Contact_Scene", this.fromScene);
          localIntent2.putExtra("Verify_ticket", this.wZz);
          if (localObject2 != null)
          {
            localIntent2.putExtra("Contact_Alias", ((as)localObject2).ajx());
            localIntent2.putExtra("Contact_Nick", ((ax)localObject2).field_nickname);
            localIntent2.putExtra("Contact_Signature", ((ax)localObject2).signature);
            localIntent2.putExtra("Contact_RegionCode", ((ax)localObject2).fuO);
            localIntent2.putExtra("Contact_Sex", ((ax)localObject2).fuA);
            localIntent2.putExtra("Contact_VUser_Info", ((ax)localObject2).fuN);
            localIntent2.putExtra("Contact_VUser_Info_Flag", ((ax)localObject2).field_verifyFlag);
            localIntent2.putExtra("Contact_KWeibo_flag", ((ax)localObject2).field_weiboFlag);
            localIntent2.putExtra("Contact_KWeibo", ((ax)localObject2).fuM);
            localIntent2.putExtra("Contact_KWeiboNick", ((ax)localObject2).field_weiboNickname);
          }
          e.s(localIntent2, this.dJw);
          if (!this.OyA)
          {
            setResult(-1);
            this.OyB = true;
            com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
            finish();
          }
        }
        AppMethodBeat.o(32976);
      }
    }
  }
  
  private boolean gGQ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32977);
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.dJw);
        if ((localas != null) && ((int)localas.gMZ != 0)) {
          break label308;
        }
        Log.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
        i = 1;
        com.tencent.mm.api.c localc = null;
        if (i == 0) {
          localc = com.tencent.mm.al.g.fJ(this.dJw);
        }
        if ((localc == null) || (localc.Uz()))
        {
          Log.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + localc + ") is null or should update.");
          i = 1;
        }
        if (this.OyC)
        {
          if (localas == null)
          {
            this.Oyz = false;
            setResult(5);
            gGS();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            return bool;
          }
          this.Oyz = true;
          this.iGD = true;
          if (com.tencent.mm.contact.c.oR(localas.field_type)) {
            break label287;
          }
          AppMethodBeat.o(32977);
          bool = false;
          continue;
        }
        if (i != 0)
        {
          if (this.Oyz)
          {
            setResult(5);
            gGS();
            finish();
            AppMethodBeat.o(32977);
            bool = false;
            continue;
          }
          ay.a.iDq.a(this.dJw, "", new ay.b.a()
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
        if (com.tencent.mm.contact.c.oR(localas.field_type)) {
          break label287;
        }
      }
      finally {}
      Log.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
      this.Oyz = true;
      AppMethodBeat.o(32977);
      boolean bool = false;
      continue;
      label287:
      this.Oyz = true;
      this.iGD = true;
      AppMethodBeat.o(32977);
      bool = true;
      continue;
      label308:
      int i = 0;
    }
  }
  
  private void gGR()
  {
    AppMethodBeat.i(32979);
    Toast.makeText(this, getString(2131767022), 1).show();
    cLI();
    AppMethodBeat.o(32979);
  }
  
  private void gGS()
  {
    AppMethodBeat.i(32980);
    Toast.makeText(this, 2131764442, 1).show();
    cLI();
    AppMethodBeat.o(32980);
  }
  
  protected int getLayoutId()
  {
    return 2131495126;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32969);
    super.onCreate(paramBundle);
    hideTitleView();
    if ((!bg.aVG()) || (bg.azj()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(32969);
      return;
    }
    bg.azz().a(605, this);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().add(this);
    ag.bah().add(this);
    if (bCt())
    {
      paramBundle = this.appId;
      String str1 = this.dJw;
      String str2 = this.extInfo;
      int i = this.Oyx;
      LinkedList localLinkedList = this.Oyy;
      String str3 = this.dIQ;
      int j = this.source;
      int k = this.scene;
      Object localObject = new d.a();
      ((d.a)localObject).iLN = new yf();
      ((d.a)localObject).iLO = new yg();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((d.a)localObject).funcId = 605;
      localObject = ((d.a)localObject).aXF();
      yf localyf = (yf)((d)localObject).iLK.iLR;
      localyf.hik = paramBundle;
      localyf.xNG = str1;
      localyf.xNU = str2;
      localyf.Ljf = i;
      localyf.Ljg = localLinkedList;
      localyf.Ljh = null;
      localyf.Lji = str3;
      localyf.xub = j;
      localyf.Scene = k;
      Log.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      aa.a((d)localObject, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(32967);
          paramAnonymousd = (yg)paramAnonymousd.iLL.iLR;
          CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this, paramAnonymousd.Ljj);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!Util.isNullOrNil(paramAnonymousd.Ljj)) && (!Util.isNullOrNil(paramAnonymousd.xNG)))
          {
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this, paramAnonymousd.xNG);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this, paramAnonymousd.Ljk);
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
            AppMethodBeat.o(32967);
            return 0;
          }
          if (z.a.a(CheckCanSubscribeBizUI.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 7))
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
    gGS();
    finish();
    AppMethodBeat.o(32969);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32972);
    super.onDestroy();
    if (this.Oyy != null) {
      this.Oyy.clear();
    }
    if (bg.aAc())
    {
      bg.azz().b(605, this);
      ag.bah().remove(this);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this);
    }
    AppMethodBeat.o(32972);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32978);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.OyA = true;
      if (this.OyB)
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
        Log.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.d(CheckCanSubscribeBizUI.this) + ", userName = " + paramString);
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
    if (paramq.getType() != 605)
    {
      if (paramq.getType() == 233)
      {
        bg.azz().b(233, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.modelsimple.l)paramq;
          paramInt1 = paramString.beS();
          Log.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 == 15)
          {
            paramString = paramString.beQ();
            Log.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            paramq = new je();
            paramq.dNT.actionCode = paramInt1;
            paramq.dNT.result = paramString;
            paramq.dNT.context = this;
            EventCenter.instance.asyncPublish(paramq, Looper.myLooper());
            finish();
            AppMethodBeat.o(32975);
            return;
          }
          gGR();
          AppMethodBeat.o(32975);
          return;
        }
        gGR();
        AppMethodBeat.o(32975);
        return;
      }
      Log.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[] { Integer.valueOf(paramq.getType()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI
 * JD-Core Version:    0.7.0.1
 */