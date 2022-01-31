package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(39182);
    com.tencent.mm.plugin.sns.storage.t localt = ag.cpl().mb(5L);
    if (bo.isNullOrNil(localt.field_memberList))
    {
      AppMethodBeat.o(39182);
      return false;
    }
    boolean bool = bo.P(localt.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(39182);
    return bool;
  }
  
  private void ccF()
  {
    AppMethodBeat.i(39181);
    g.RM();
    this.pCt = ((j)g.E(j.class)).YA().arw(this.userName);
    this.pCt.setUsername(this.userName);
    boolean bool1 = this.pCt.NZ();
    boolean bool2 = Xh(this.userName);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("sns_outside_permiss");
    localCheckBoxPreference.vxW = bool1;
    int i = this.pCt.dqC;
    ab.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      localCheckBoxPreference.setTitle(2131303918);
      localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("sns_black_permiss");
      if (i != 1) {
        break label211;
      }
      localCheckBoxPreference.setTitle(2131303783);
    }
    for (;;)
    {
      localCheckBoxPreference.vxW = bool2;
      if (!com.tencent.mm.n.a.je(this.pCt.field_type)) {
        this.screen.aty("sns_black_permiss");
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(39181);
      return;
      if (i != 2) {
        break;
      }
      localCheckBoxPreference.setTitle(2131303917);
      break;
      label211:
      if (i == 2) {
        localCheckBoxPreference.setTitle(2131303782);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39178);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      finish();
      AppMethodBeat.o(39178);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(39178);
    return bool;
  }
  
  public int getResourceId()
  {
    return 2131165300;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39180);
    this.screen = getPreferenceScreen();
    setMMTitle(2131303920);
    setBackBtn(new SnsPermissionUI.1(this));
    ccF();
    AppMethodBeat.o(39180);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39177);
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
    AppMethodBeat.o(39177);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39179);
    super.onDestroy();
    com.tencent.mm.plugin.sns.c.a.gmP.BO();
    g.RM();
    g.RK().eHt.b(291, this);
    if ((this.pCw != 0L) && (this.pCw != -1L))
    {
      rn localrn = new rn();
      localrn.cHS.cHT = this.pCv;
      localrn.cHS.cvx = this.pCw;
      com.tencent.mm.sdk.b.a.ymk.l(localrn);
    }
    AppMethodBeat.o(39179);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(39184);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new ry();
      paramf.cIh.cIj = true;
      paramf.cIh.cIi = false;
      paramf.cIh.username = this.userName;
      com.tencent.mm.sdk.b.a.ymk.l(paramf);
      if (this.pCt.NZ()) {
        com.tencent.mm.model.t.l(this.pCt);
      }
      for (;;)
      {
        AppMethodBeat.o(39184);
        return true;
        com.tencent.mm.model.t.k(this.pCt);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new ry();
      paramf.cIh.cIj = false;
      paramf.cIh.cIi = true;
      paramf.cIh.username = this.userName;
      com.tencent.mm.sdk.b.a.ymk.l(paramf);
      boolean bool = Xh(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label295;
        }
        this.pCu = true;
      }
      for (this.pCv = false;; this.pCv = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new w(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        g.RM();
        g.RK().eHt.a(paramf, 0);
        getString(2131297087);
        this.tipDialog = h.b(this, getString(2131303996), true, new SnsPermissionUI.2(this, paramf));
        AppMethodBeat.o(39184);
        return true;
        i = 1;
        break;
        label295:
        this.pCu = false;
      }
    }
    AppMethodBeat.o(39184);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(39183);
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
      AppMethodBeat.o(39183);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */