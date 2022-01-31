package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.qd;
import com.tencent.mm.h.a.qo;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class SnsPermissionUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private long pbA = 0L;
  private boolean pbw = false;
  private ad pbx = null;
  private boolean pby = false;
  private boolean pbz = false;
  private int scene = 0;
  public com.tencent.mm.ui.base.p tipDialog = null;
  private String userName = "";
  
  private static boolean MQ(String paramString)
  {
    t localt = af.bDL().gv(5L);
    if (bk.bl(localt.field_memberList)) {
      return false;
    }
    return bk.G(localt.field_memberList.split(",")).contains(paramString);
  }
  
  private void bwF()
  {
    g.DQ();
    this.pbx = ((j)g.r(j.class)).Fw().abl(this.userName);
    this.pbx.setUsername(this.userName);
    boolean bool1 = this.pbx.Bk();
    boolean bool2 = MQ(this.userName);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("sns_outside_permiss");
    localCheckBoxPreference.rHo = bool1;
    int i = this.pbx.sex;
    y.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      localCheckBoxPreference.setTitle(i.j.sns_outside_permiss_male);
      localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("sns_black_permiss");
      if (i != 1) {
        break label204;
      }
      localCheckBoxPreference.setTitle(i.j.sns_black_permiss_male);
    }
    for (;;)
    {
      localCheckBoxPreference.rHo = bool2;
      if (!com.tencent.mm.n.a.gR(this.pbx.field_type)) {
        this.dnn.ade("sns_black_permiss");
      }
      this.dnn.notifyDataSetChanged();
      return;
      if (i != 2) {
        break;
      }
      localCheckBoxPreference.setTitle(i.j.sns_outside_permiss_female);
      break;
      label204:
      if (i == 2) {
        localCheckBoxPreference.setTitle(i.j.sns_black_permiss_female);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new qo();
      paramf.bZP.bZR = true;
      paramf.bZP.bZQ = false;
      paramf.bZP.username = this.userName;
      com.tencent.mm.sdk.b.a.udP.m(paramf);
      if (this.pbx.Bk()) {
        s.l(this.pbx);
      }
      for (;;)
      {
        return true;
        s.k(this.pbx);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new qo();
      paramf.bZP.bZR = false;
      paramf.bZP.bZQ = true;
      paramf.bZP.username = this.userName;
      com.tencent.mm.sdk.b.a.udP.m(paramf);
      boolean bool = MQ(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label277;
        }
        this.pby = true;
      }
      for (this.pbz = false;; this.pbz = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new w(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        g.DQ();
        g.DO().dJT.a(paramf, 0);
        getString(i.j.app_tip);
        this.tipDialog = h.b(this, getString(i.j.sns_tag_save), true, new SnsPermissionUI.2(this, paramf));
        return true;
        i = 1;
        break;
        label277:
        this.pby = false;
      }
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      finish();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    setMMTitle(i.j.sns_permiss);
    setBackBtn(new SnsPermissionUI.1(this));
    bwF();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.DQ();
    g.DO().dJT.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.pbw = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.pbA = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    y.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    g.DQ();
    this.pbx = ((j)g.r(j.class)).Fw().abl(this.userName);
    if (this.pbx == null)
    {
      y.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.pbx.setUsername(this.userName);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.plugin.sns.c.a.eUS.tk();
    g.DQ();
    g.DO().dJT.b(291, this);
    if ((this.pbA != 0L) && (this.pbA != -1L))
    {
      qd localqd = new qd();
      localqd.bZA.bZB = this.pbz;
      localqd.bZA.bOf = this.pbA;
      com.tencent.mm.sdk.b.a.udP.m(localqd);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramm.getType());
    if (paramm.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      bwF();
      if (this.pby) {
        this.pbz = true;
      }
      return;
    }
  }
  
  public final int xj()
  {
    return i.m.sns_premission;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */