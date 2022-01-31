package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.w;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.op;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI
  extends MMActivity
  implements com.tencent.mm.ah.f, j.a, m.b
{
  private String appId;
  private String bLs;
  private boolean dYj = false;
  private String extInfo;
  private int fromScene;
  private String kzG;
  private int scene;
  private int source;
  private String toUserName;
  private boolean uHA = false;
  private boolean uHB = false;
  private String uHC;
  private int uHD = 0;
  private int uHw;
  private LinkedList<bml> uHx;
  private boolean uHy = false;
  private boolean uHz = false;
  
  private void aMw()
  {
    if (this.source == 1) {
      LauncherUI.gp(this);
    }
  }
  
  private boolean afF()
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      y.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
      return false;
    }
    this.appId = localIntent.getStringExtra("appId");
    this.toUserName = localIntent.getStringExtra("toUserName");
    if (bk.bl(this.toUserName))
    {
      y.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
      return false;
    }
    this.extInfo = localIntent.getStringExtra("extInfo");
    this.source = localIntent.getIntExtra("source", -1);
    this.scene = localIntent.getIntExtra("scene", 0);
    this.uHD = localIntent.getIntExtra("jump_profile_type", 0);
    switch (this.source)
    {
    default: 
      y.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[] { Integer.valueOf(this.source) });
      return false;
    case 1: 
      if (bk.bl(this.appId))
      {
        y.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
        return false;
      }
      this.fromScene = 68;
      ArrayList localArrayList = localIntent.getStringArrayListExtra("androidPackNameList");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        y.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
        return false;
      }
      this.uHx = new LinkedList();
      int i = 0;
      while (i < localArrayList.size())
      {
        String str = (String)localArrayList.get(i);
        if (!bk.bl(str))
        {
          y.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[] { Integer.valueOf(i), str });
          this.uHx.add(aa.pj(str));
        }
        i += 1;
      }
      if (this.uHx.size() == 0)
      {
        y.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
        return false;
      }
      this.uHw = this.uHx.size();
    }
    for (;;)
    {
      this.bLs = localIntent.getStringExtra("fromURL");
      return true;
      this.fromScene = 69;
    }
  }
  
  private void cxT()
  {
    for (;;)
    {
      try
      {
        y.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.uHy);
        if (this.scene == 1)
        {
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("rawUrl", this.uHC);
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent1);
          finish();
          return;
        }
        if ((this.scene != 0) || (this.uHD != 1)) {
          break label155;
        }
        if (this.uHA)
        {
          y.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
          continue;
        }
        this.uHA = true;
      }
      finally {}
      au.Dk().a(233, this);
      Object localObject2 = new h(this.extInfo, null, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
      au.Dk().a((com.tencent.mm.ah.m)localObject2, 0);
      continue;
      label155:
      if ((cxU()) && (this.uHy))
      {
        if (!this.uHA)
        {
          y.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
          localObject2 = new Intent().putExtra("Chat_User", this.toUserName);
          ((Intent)localObject2).putExtra("finish_direct", true);
          if (bk.bl(this.toUserName)) {
            com.tencent.mm.ui.contact.e.a((Intent)localObject2, this.toUserName);
          }
          ((Intent)localObject2).setClass(this, ChattingUI.class);
          if (!this.uHz)
          {
            setResult(-1);
            this.uHA = true;
            startActivity((Intent)localObject2);
            finish();
          }
        }
      }
      else if ((this.uHy) && (!this.uHA))
      {
        y.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
        localObject2 = ((j)g.r(j.class)).Fw().abl(this.toUserName);
        Intent localIntent2 = new Intent();
        localIntent2.putExtra("Contact_Scene", this.fromScene);
        localIntent2.putExtra("Verify_ticket", this.kzG);
        if (localObject2 != null)
        {
          localIntent2.putExtra("Contact_Alias", ((ad)localObject2).vk());
          localIntent2.putExtra("Contact_Nick", ((ao)localObject2).field_nickname);
          localIntent2.putExtra("Contact_Signature", ((ao)localObject2).signature);
          localIntent2.putExtra("Contact_RegionCode", ((ao)localObject2).cCG);
          localIntent2.putExtra("Contact_Sex", ((ao)localObject2).sex);
          localIntent2.putExtra("Contact_VUser_Info", ((ao)localObject2).cCF);
          localIntent2.putExtra("Contact_VUser_Info_Flag", ((ao)localObject2).field_verifyFlag);
          localIntent2.putExtra("Contact_KWeibo_flag", ((ao)localObject2).field_weiboFlag);
          localIntent2.putExtra("Contact_KWeibo", ((ao)localObject2).cCE);
          localIntent2.putExtra("Contact_KWeiboNick", ((ao)localObject2).field_weiboNickname);
        }
        com.tencent.mm.ui.contact.e.m(localIntent2, this.toUserName);
        if (!this.uHz)
        {
          setResult(-1);
          this.uHA = true;
          com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", localIntent2);
          finish();
        }
      }
    }
  }
  
  private boolean cxU()
  {
    for (;;)
    {
      ad localad;
      int i;
      boolean bool;
      try
      {
        localad = ((j)g.r(j.class)).Fw().abl(this.toUserName);
        if ((localad != null) && ((int)localad.dBe != 0)) {
          break label270;
        }
        y.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
        i = 1;
        com.tencent.mm.ai.d locald = null;
        if (i == 0) {
          locald = com.tencent.mm.ai.f.kX(this.toUserName);
        }
        if ((locald == null) || (locald.Ls()))
        {
          y.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + locald + ") is null or should update.");
          i = 1;
        }
        if (this.uHB)
        {
          if (localad == null)
          {
            this.uHy = false;
            setResult(5);
            cxW();
            finish();
            bool = false;
            return bool;
          }
          this.uHy = true;
          this.dYj = true;
          if (com.tencent.mm.n.a.gR(localad.field_type)) {
            break label255;
          }
          bool = false;
          continue;
        }
        if (i != 0) {
          if (this.uHy)
          {
            setResult(5);
            cxW();
            finish();
          }
          else
          {
            am.a.dVy.a(this.toUserName, "", new CheckCanSubscribeBizUI.1(this));
          }
        }
      }
      finally {}
      if (!com.tencent.mm.n.a.gR(localad.field_type))
      {
        y.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
        this.uHy = true;
        bool = false;
      }
      else
      {
        label255:
        this.uHy = true;
        this.dYj = true;
        bool = true;
        continue;
        label270:
        i = 0;
        continue;
        bool = false;
      }
    }
  }
  
  private void cxV()
  {
    Toast.makeText(this, getString(R.l.verify_authority_err), 1).show();
    aMw();
  }
  
  private void cxW()
  {
    Toast.makeText(this, R.l.regbyqq_auth_err_title, 1).show();
    aMw();
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      y.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(String paramString, l paraml)
  {
    new ah().post(new CheckCanSubscribeBizUI.3(this, paramString));
  }
  
  protected final int getLayoutId()
  {
    return R.i.jump_to_biz_profile_loading;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    if ((!au.Hz()) || (au.CW()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      return;
    }
    au.Dk().a(605, this);
    ((j)g.r(j.class)).Fw().a(this);
    z.My().c(this);
    if (afF())
    {
      paramBundle = this.appId;
      String str1 = this.toUserName;
      String str2 = this.extInfo;
      int i = this.uHw;
      LinkedList localLinkedList = this.uHx;
      String str3 = this.bLs;
      int j = this.source;
      int k = this.scene;
      Object localObject = new b.a();
      ((b.a)localObject).ecH = new op();
      ((b.a)localObject).ecI = new oq();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
      ((b.a)localObject).ecG = 605;
      localObject = ((b.a)localObject).Kt();
      op localop = (op)((b)localObject).ecE.ecN;
      localop.kRX = paramBundle;
      localop.kWm = str1;
      localop.kWx = str2;
      localop.sMb = i;
      localop.sMc = localLinkedList;
      localop.sMd = null;
      localop.sMe = str3;
      localop.swS = j;
      localop.pyo = k;
      y.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[] { paramBundle, str1, str2, Integer.valueOf(i), Integer.valueOf(k) });
      w.a((b)localObject, new CheckCanSubscribeBizUI.2(this));
      return;
    }
    setResult(2);
    cxW();
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.uHx != null) {
      this.uHx.clear();
    }
    if (au.DK())
    {
      au.Dk().b(605, this);
      z.My().d(this);
      ((j)g.r(j.class)).Fw().b(this);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.uHz = true;
      if (this.uHA) {
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramm.getType() != 605)
    {
      if (paramm.getType() != 233) {
        break label198;
      }
      au.Dk().b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label193;
      }
      paramString = (h)paramm;
      paramInt1 = paramString.Qh();
      y.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 == 15)
      {
        paramString = paramString.Qf();
        y.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
        paramm = new hc();
        paramm.bOW.actionCode = paramInt1;
        paramm.bOW.result = paramString;
        paramm.bOW.context = this;
        com.tencent.mm.sdk.b.a.udP.a(paramm, Looper.myLooper());
        finish();
      }
    }
    else
    {
      return;
    }
    cxV();
    return;
    label193:
    cxV();
    return;
    label198:
    y.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[] { Integer.valueOf(paramm.getType()) });
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI
 * JD-Core Version:    0.7.0.1
 */