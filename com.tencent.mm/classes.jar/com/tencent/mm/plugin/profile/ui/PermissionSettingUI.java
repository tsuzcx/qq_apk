package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;

public class PermissionSettingUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private boolean pCs = false;
  private ad pCt = null;
  private boolean pCu = false;
  private boolean pCv = false;
  private long pCw = 0L;
  private int scene = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  public com.tencent.mm.ui.base.p tipDialog = null;
  private String userName = "";
  
  private static boolean Xh(String paramString)
  {
    AppMethodBeat.i(23750);
    boolean bool = n.raT.Xh(paramString);
    AppMethodBeat.o(23750);
    return bool;
  }
  
  private void ccF()
  {
    AppMethodBeat.i(23749);
    g.RM();
    this.pCt = ((j)g.E(j.class)).YA().arw(this.userName);
    this.pCt.setUsername(this.userName);
    boolean bool1 = this.pCt.NZ();
    boolean bool2 = Xh(this.userName);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("star_contact");
    boolean bool3 = this.pCt.NY();
    Object localObject;
    int i;
    if (bool3)
    {
      localObject = getContext().getResources().getString(2131298822);
      localCheckBoxPreference.setTitle((CharSequence)localObject);
      localCheckBoxPreference.vxW = bool3;
      this.screen.cl("star_contact", true);
      localObject = (CheckBoxPreference)this.screen.atx("sns_outside_permiss");
      ((CheckBoxPreference)localObject).vxW = bool1;
      i = this.pCt.dqC;
      ab.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label285;
      }
      ((CheckBoxPreference)localObject).setTitle(2131303918);
      label193:
      localObject = (CheckBoxPreference)this.screen.atx("sns_black_permiss");
      if (i != 1) {
        break label300;
      }
      ((CheckBoxPreference)localObject).setTitle(2131303783);
    }
    for (;;)
    {
      ((CheckBoxPreference)localObject).vxW = bool2;
      if (!com.tencent.mm.n.a.je(this.pCt.field_type)) {
        this.screen.aty("sns_black_permiss");
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(23749);
      return;
      localObject = getContext().getResources().getString(2131298604);
      break;
      label285:
      if (i != 2) {
        break label193;
      }
      ((CheckBoxPreference)localObject).setTitle(2131303917);
      break label193;
      label300:
      if (i == 2) {
        ((CheckBoxPreference)localObject).setTitle(2131303782);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(23746);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      finish();
      AppMethodBeat.o(23746);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(23746);
    return bool;
  }
  
  public int getResourceId()
  {
    return 2131165257;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23748);
    this.screen = getPreferenceScreen();
    setMMTitle(2131303920);
    setBackBtn(new PermissionSettingUI.1(this));
    ccF();
    AppMethodBeat.o(23748);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23745);
    super.onCreate(paramBundle);
    g.RM();
    g.RK().eHt.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.pCs = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.pCw = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ab.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    g.RM();
    this.pCt = ((j)g.E(j.class)).YA().arw(this.userName);
    if (this.pCt == null)
    {
      ab.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.pCt.setUsername(this.userName);
    initView();
    paramBundle = new id();
    paramBundle.cxs.cut = 1;
    com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
    AppMethodBeat.o(23745);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23747);
    super.onDestroy();
    com.tencent.mm.plugin.profile.b.gmP.BO();
    g.RM();
    g.RK().eHt.b(291, this);
    if ((this.pCw != 0L) && (this.pCw != -1L))
    {
      rn localrn = new rn();
      localrn.cHS.cHT = this.pCv;
      localrn.cHS.cvx = this.pCw;
      com.tencent.mm.sdk.b.a.ymk.l(localrn);
    }
    AppMethodBeat.o(23747);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(23752);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new ry();
      paramf.cIh.cIj = true;
      paramf.cIh.cIi = false;
      paramf.cIh.username = this.userName;
      com.tencent.mm.sdk.b.a.ymk.l(paramf);
      if (this.pCt.NZ()) {
        t.l(this.pCt);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(getIntent())), Integer.valueOf(13), Integer.valueOf(1), this.userName });
        AppMethodBeat.o(23752);
        return true;
        t.k(this.pCt);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new ry();
      paramf.cIh.cIj = false;
      paramf.cIh.cIi = true;
      paramf.cIh.username = this.userName;
      boolean bool = Xh(this.userName);
      paramf.cIh.cIk = bool;
      Object localObject = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label402;
        }
        this.pCu = true;
      }
      for (this.pCv = false;; this.pCv = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(localObject);
        localObject = new mu();
        ((mu)localObject).cCP.list = paramPreference;
        ((mu)localObject).cCP.ctW = i;
        ((mu)localObject).cCP.cCQ = 5L;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        getString(2131297087);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131298581), true, null);
        com.tencent.mm.sdk.b.a.ymk.l(paramf);
        com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(getIntent())), Integer.valueOf(12), Integer.valueOf(1), this.userName });
        AppMethodBeat.o(23752);
        return true;
        i = 1;
        break;
        label402:
        this.pCu = false;
      }
    }
    if (paramf.equals("star_contact"))
    {
      if (this.pCt.NY()) {
        t.n(this.pCt);
      }
      for (;;)
      {
        AppMethodBeat.o(23752);
        return true;
        t.m(this.pCt);
      }
    }
    AppMethodBeat.o(23752);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(23751);
    ab.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramm.getType());
    if (paramm.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      ccF();
      if (this.pCu) {
        this.pCv = true;
      }
      AppMethodBeat.o(23751);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI
 * JD-Core Version:    0.7.0.1
 */