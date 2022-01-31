package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.rs;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI
  extends MMActivity
  implements com.tencent.mm.ai.f, k.a, n.b
{
  private String appId;
  private int cpt;
  private String csM;
  private String extInfo;
  private boolean fon = false;
  private int fromScene;
  private String mVw;
  private int scene;
  private String toUserName;
  private int yUH;
  private LinkedList<bwc> yUI;
  private boolean yUJ = false;
  private boolean yUK = false;
  private boolean yUL = false;
  private boolean yUM = false;
  private String yUN;
  private int yUO = 0;
  
  private boolean aAj()
  {
    AppMethodBeat.i(29149);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      ab.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
      AppMethodBeat.o(29149);
      return false;
    }
    this.appId = localIntent.getStringExtra("appId");
    this.toUserName = localIntent.getStringExtra("toUserName");
    if (bo.isNullOrNil(this.toUserName))
    {
      ab.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      AppMethodBeat.o(29149);
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.cpt = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.yUO = localIntent.getIntExtra("jump_profile_type", 0);
    switch (this.cpt)
    {
    default: 
      ab.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[] { Integer.valueOf(this.cpt) });
      AppMethodBeat.o(29149);
      return false;
    case 1: 
      if (bo.isNullOrNil(this.appId))
      {
        ab.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
        AppMethodBeat.o(29149);
        return false;
      }
      this.fromScene = 68;
      ArrayList localArrayList = localIntent.getStringArrayListExtra("androidPackNameList");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        ab.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
        AppMethodBeat.o(29149);
        return false;
      }
      this.yUI = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!bo.isNullOrNil(str))
        {
          ab.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.yUI.add(aa.wA(str));
        }
        i += 1;
      }
      if (this.yUI.size() == 0)
      {
        ab.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        AppMethodBeat.o(29149);
        return false;
      }
      this.yUH = this.yUI.size();
    }
    for (;;)
    {
      this.csM = localIntent.getStringExtra("fromURL");
      AppMethodBeat.o(29149);
      return true;
      this.fromScene = 69;
    }
  }
  
  private void bqK()
  {
    AppMethodBeat.i(29156);
    if (this.cpt == 1) {
      LauncherUI.hG(this);
    }
    AppMethodBeat.o(29156);
  }
  
  private void dAQ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(29151);
        ab.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.yUJ);
        if (this.scene == 1)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.yUN);
          com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          AppMethodBeat.o(29151);
          return;
        }
        if ((this.scene != 0) || (this.yUO != 1)) {
          break label179;
        }
        if (this.yUL)
        {
          ab.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          AppMethodBeat.o(29151);
          continue;
        }
        this.yUL = true;
      }
      finally {}
      aw.Rc().a(233, this);
      Object localObject2 = new com.tencent.mm.modelsimple.j(this.extInfo, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
      aw.Rc().a((com.tencent.mm.ai.m)localObject2, 0);
      AppMethodBeat.o(29151);
      continue;
      label179:
      if ((dAR()) && (this.yUJ))
      {
        if (!this.yUL)
        {
          ab.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.toUserName);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (bo.isNullOrNil(this.toUserName)) {
            com.tencent.mm.ui.contact.e.a((Intent)localObject2, this.toUserName);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.yUK)
          {
            setResult(-1);
            this.yUL = true;
            startActivity((Intent)localObject2);
            finish();
          }
        }
        AppMethodBeat.o(29151);
      }
      else
      {
        if ((this.yUJ) && (!this.yUL))
        {
          ab.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.toUserName);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("Contact_Scene", this.fromScene);
          localIntent2.putExtra("Verify_ticket", this.mVw);
          if (localObject2 != null)
          {
            localIntent2.putExtra("Contact_Alias", ((ad)localObject2).Hq());
            localIntent2.putExtra("Contact_Nick", ((aq)localObject2).field_nickname);
            localIntent2.putExtra("Contact_Signature", ((aq)localObject2).signature);
            localIntent2.putExtra("Contact_RegionCode", ((aq)localObject2).dqQ);
            localIntent2.putExtra("Contact_Sex", ((aq)localObject2).dqC);
            localIntent2.putExtra("Contact_VUser_Info", ((aq)localObject2).dqP);
            localIntent2.putExtra("Contact_VUser_Info_Flag", ((aq)localObject2).field_verifyFlag);
            localIntent2.putExtra("Contact_KWeibo_flag", ((aq)localObject2).field_weiboFlag);
            localIntent2.putExtra("Contact_KWeibo", ((aq)localObject2).dqO);
            localIntent2.putExtra("Contact_KWeiboNick", ((aq)localObject2).field_weiboNickname);
          }
          com.tencent.mm.ui.contact.e.r(localIntent2, this.toUserName);
          if (!this.yUK)
          {
            setResult(-1);
            this.yUL = true;
            com.tencent.mm.bq.d.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
            finish();
          }
        }
        AppMethodBeat.o(29151);
      }
    }
  }
  
  private boolean dAR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(29152);
        ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.toUserName);
        if ((localad != null) && ((int)localad.euF != 0)) {
          break label308;
        }
        ab.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
        i = 1;
        com.tencent.mm.aj.d locald = null;
        if (i == 0) {
          locald = com.tencent.mm.aj.f.rS(this.toUserName);
        }
        if ((locald == null) || (locald.aea()))
        {
          ab.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + locald + ") is null or should update.");
          i = 1;
        }
        if (this.yUM)
        {
          if (localad == null)
          {
            this.yUJ = false;
            setResult(5);
            dAT();
            finish();
            AppMethodBeat.o(29152);
            bool = false;
            return bool;
          }
          this.yUJ = true;
          this.fon = true;
          if (com.tencent.mm.n.a.je(localad.field_type)) {
            break label287;
          }
          AppMethodBeat.o(29152);
          bool = false;
          continue;
        }
        if (i != 0)
        {
          if (this.yUJ)
          {
            setResult(5);
            dAT();
            finish();
            AppMethodBeat.o(29152);
            bool = false;
            continue;
          }
          ao.a.flI.a(this.toUserName, "", new CheckCanSubscribeBizUI.1(this));
          continue;
        }
        if (com.tencent.mm.n.a.je(localad.field_type)) {
          break label287;
        }
      }
      finally {}
      ab.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
      this.yUJ = true;
      AppMethodBeat.o(29152);
      boolean bool = false;
      continue;
      label287:
      this.yUJ = true;
      this.fon = true;
      AppMethodBeat.o(29152);
      bool = true;
      continue;
      label308:
      int i = 0;
    }
  }
  
  private void dAS()
  {
    AppMethodBeat.i(29154);
    Toast.makeText(this, getString(2131304494), 1).show();
    bqK();
    AppMethodBeat.o(29154);
  }
  
  private void dAT()
  {
    AppMethodBeat.i(29155);
    Toast.makeText(this, 2131302473, 1).show();
    bqK();
    AppMethodBeat.o(29155);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(29158);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(29158);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(29158);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(29157);
    new ak().post(new CheckCanSubscribeBizUI.3(this, paramString));
    AppMethodBeat.o(29157);
  }
  
  protected int getLayoutId()
  {
    return 2130969950;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29144);
    super.onCreate(paramBundle);
    hideTitleView();
    if ((!aw.aaB()) || (aw.QP()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(29144);
      return;
    }
    aw.Rc().a(605, this);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().a(this);
    z.afi().add(this);
    if (aAj())
    {
      paramBundle = this.appId;
      String str1 = this.toUserName;
      String str2 = this.extInfo;
      int i = this.yUH;
      LinkedList localLinkedList = this.yUI;
      String str3 = this.csM;
      int j = this.cpt;
      int k = this.scene;
      Object localObject = new b.a();
      ((b.a)localObject).fsX = new rr();
      ((b.a)localObject).fsY = new rs();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((b.a)localObject).funcId = 605;
      localObject = ((b.a)localObject).ado();
      rr localrr = (rr)((b)localObject).fsV.fta;
      localrr.npZ = paramBundle;
      localrr.nul = str1;
      localrr.nuz = str2;
      localrr.wJO = i;
      localrr.wJP = localLinkedList;
      localrr.wJQ = null;
      localrr.wJR = str3;
      localrr.niK = j;
      localrr.Scene = k;
      ab.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      w.a((b)localObject, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, com.tencent.mm.ai.m paramAnonymousm)
        {
          AppMethodBeat.i(29142);
          paramAnonymousb = (rs)paramAnonymousb.fsW.fta;
          CheckCanSubscribeBizUI.a(CheckCanSubscribeBizUI.this, paramAnonymousb.wJS);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!bo.isNullOrNil(paramAnonymousb.wJS)) && (!bo.isNullOrNil(paramAnonymousb.nul)))
          {
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this, paramAnonymousb.nul);
            CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this, paramAnonymousb.wJT);
            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
            AppMethodBeat.o(29142);
            return 0;
          }
          if (v.a.a(CheckCanSubscribeBizUI.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 7))
          {
            CheckCanSubscribeBizUI.this.setResult(5);
            CheckCanSubscribeBizUI.this.finish();
            AppMethodBeat.o(29142);
            return 0;
          }
          CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this);
          CheckCanSubscribeBizUI.this.setResult(3);
          CheckCanSubscribeBizUI.this.finish();
          AppMethodBeat.o(29142);
          return 0;
        }
      });
      AppMethodBeat.o(29144);
      return;
    }
    setResult(2);
    dAT();
    finish();
    AppMethodBeat.o(29144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29147);
    super.onDestroy();
    if (this.yUI != null) {
      this.yUI.clear();
    }
    if (aw.RG())
    {
      aw.Rc().b(605, this);
      z.afi().remove(this);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(this);
    }
    AppMethodBeat.o(29147);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29153);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.yUK = true;
      if (this.yUL)
      {
        AppMethodBeat.o(29153);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(29153);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29148);
    super.onPause();
    AppMethodBeat.o(29148);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29146);
    super.onResume();
    AppMethodBeat.o(29146);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(29150);
    ab.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramm.getType() != 605)
    {
      if (paramm.getType() == 233)
      {
        aw.Rc().b(233, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.modelsimple.j)paramm;
          paramInt1 = paramString.ajn();
          ab.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 == 15)
          {
            paramString = paramString.ajl();
            ab.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            paramm = new hf();
            paramm.cwn.actionCode = paramInt1;
            paramm.cwn.result = paramString;
            paramm.cwn.context = this;
            com.tencent.mm.sdk.b.a.ymk.a(paramm, Looper.myLooper());
            finish();
            AppMethodBeat.o(29150);
            return;
          }
          dAS();
          AppMethodBeat.o(29150);
          return;
        }
        dAS();
        AppMethodBeat.o(29150);
        return;
      }
      ab.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[] { Integer.valueOf(paramm.getType()) });
    }
    AppMethodBeat.o(29150);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29145);
    super.onStart();
    AppMethodBeat.o(29145);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI
 * JD-Core Version:    0.7.0.1
 */