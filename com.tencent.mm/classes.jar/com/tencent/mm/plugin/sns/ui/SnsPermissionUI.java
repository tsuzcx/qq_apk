package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import java.util.LinkedList;
import java.util.List;

public class SnsPermissionUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  private int scene = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  public p tipDialog = null;
  private com.tencent.mm.storage.af uEg = null;
  private boolean uEh = false;
  private boolean uEi = false;
  private long uEj = 0L;
  private int uEk = 0;
  private String userName = "";
  private boolean xCN = false;
  private boolean xCO = false;
  private boolean xCP = false;
  
  private static boolean akH(String paramString)
  {
    AppMethodBeat.i(98979);
    com.tencent.mm.plugin.sns.storage.v localv = com.tencent.mm.plugin.sns.model.af.dtA().tj(5L);
    if (bt.isNullOrNil(localv.field_memberList))
    {
      AppMethodBeat.o(98979);
      return false;
    }
    boolean bool = bt.S(localv.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(98979);
    return bool;
  }
  
  private void dcW()
  {
    boolean bool2 = false;
    AppMethodBeat.i(98978);
    com.tencent.mm.kernel.g.afC();
    this.uEg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.userName);
    this.uEg.setUsername(this.userName);
    boolean bool1 = this.uEg.ZP();
    boolean bool3 = akH(this.userName);
    Object localObject = (CheckBoxPreference)this.screen.aKk("sns_outside_permiss");
    ((CheckBoxPreference)localObject).lG = bool1;
    int i = this.uEg.evp;
    ad.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ((CheckBoxPreference)localObject).setTitle(2131763930);
      localObject = (CheckBoxPreference)this.screen.aKk("sns_black_permiss");
      if (i != 1) {
        break label294;
      }
      ((CheckBoxPreference)localObject).setTitle(2131763786);
      label153:
      ((CheckBoxPreference)localObject).lG = bool3;
      if (!com.tencent.mm.n.b.ls(this.uEg.field_type)) {
        this.screen.aKl("sns_black_permiss");
      }
      localObject = (PreferenceFooterCategory)this.screen.aKk("sns_openim_desc_footer");
      bool1 = bool2;
      if (com.tencent.mm.storage.af.aHH(this.userName))
      {
        bool1 = bool2;
        if ("3552365301".equals(this.uEg.field_openImAppid)) {
          bool1 = true;
        }
      }
      this.xCP = bool1;
      if (!this.xCP) {
        break label309;
      }
      this.screen.cE("sns_outside_permiss", true);
      ((PreferenceFooterCategory)localObject).setSummary(2131763931);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(98978);
      return;
      if (i != 2) {
        break;
      }
      ((CheckBoxPreference)localObject).setTitle(2131763929);
      break;
      label294:
      if (i != 2) {
        break label153;
      }
      ((CheckBoxPreference)localObject).setTitle(2131763785);
      break label153;
      label309:
      this.screen.cE("sns_openim_desc_footer", true);
    }
  }
  
  private int dcX()
  {
    AppMethodBeat.i(98982);
    int i = 0;
    int j = 0;
    if (this.uEg != null)
    {
      if (this.uEg.ZP()) {
        j = 1;
      }
      i = j;
      if (akH(this.userName)) {
        i = j | 0x2;
      }
    }
    AppMethodBeat.o(98982);
    return i;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98975);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      finish();
      AppMethodBeat.o(98975);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98975);
    return bool;
  }
  
  public int getResourceId()
  {
    return 2131951744;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98977);
    this.screen = getPreferenceScreen();
    if ((this.uEg != null) && (com.tencent.mm.storage.af.aHH(this.userName)) && ("3552365301".equals(this.uEg.field_openImAppid))) {
      setMMTitle(2131763934);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98972);
          SnsPermissionUI.this.hideVKB();
          SnsPermissionUI.this.setResult(-1, new Intent());
          SnsPermissionUI.this.finish();
          AppMethodBeat.o(98972);
          return true;
        }
      });
      this.xCO = akH(this.userName);
      dcW();
      AppMethodBeat.o(98977);
      return;
      setMMTitle(2131763933);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98974);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.xCN = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.uEj = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ad.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.g.afC();
    this.uEg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.userName);
    if (this.uEg == null)
    {
      ad.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.uEg.setUsername(this.userName);
    initView();
    this.uEk = dcX();
    AppMethodBeat.o(98974);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98976);
    super.onDestroy();
    com.tencent.mm.plugin.sns.d.a.hYu.Ll();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(291, this);
    if ((this.uEj != 0L) && (this.uEj != -1L))
    {
      localObject = new th();
      ((th)localObject).dyI.dyJ = this.uEi;
      ((th)localObject).dyI.dkU = this.uEj;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    long l = bt.GC();
    int i = dcX();
    Object localObject = new cr().jk(this.userName).jl(com.tencent.mm.plugin.sns.data.q.st(this.uEj));
    ((cr)localObject).dJp = this.uEk;
    ((cr)localObject).dSn = i;
    ((cr)localObject).dJu = 5;
    ((cr)localObject).aBj();
    ad.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.uEk), Integer.valueOf(i), Long.valueOf(bt.aS(l)) });
    if (this.xCP)
    {
      boolean bool = akH(this.userName);
      if ((this.xCO) && (!bool))
      {
        localObject = com.tencent.mm.plugin.sns.k.f.wQY;
        com.tencent.mm.plugin.sns.k.f.ez(this.userName, 2);
        AppMethodBeat.o(98976);
        return;
      }
      if ((!this.xCO) && (bool))
      {
        localObject = com.tencent.mm.plugin.sns.k.f.wQY;
        com.tencent.mm.plugin.sns.k.f.ez(this.userName, 3);
        AppMethodBeat.o(98976);
        return;
      }
      localObject = com.tencent.mm.plugin.sns.k.f.wQY;
      com.tencent.mm.plugin.sns.k.f.ez(this.userName, 1);
    }
    AppMethodBeat.o(98976);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98981);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new ts();
      paramf.dyX.dyZ = true;
      paramf.dyX.dyY = false;
      paramf.dyX.username = this.userName;
      com.tencent.mm.sdk.b.a.ESL.l(paramf);
      if (this.uEg.ZP()) {
        com.tencent.mm.model.w.p(this.uEg);
      }
      for (;;)
      {
        AppMethodBeat.o(98981);
        return true;
        com.tencent.mm.model.w.o(this.uEg);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new ts();
      paramf.dyX.dyZ = false;
      paramf.dyX.dyY = true;
      paramf.dyX.username = this.userName;
      com.tencent.mm.sdk.b.a.ESL.l(paramf);
      boolean bool = akH(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label295;
        }
        this.uEh = true;
      }
      for (this.uEi = false;; this.uEi = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new com.tencent.mm.plugin.sns.model.v(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramf, 0);
        getString(2131755906);
        this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(98973);
            SnsPermissionUI.a(SnsPermissionUI.this);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramf);
            AppMethodBeat.o(98973);
          }
        });
        AppMethodBeat.o(98981);
        return true;
        i = 1;
        break;
        label295:
        this.uEh = false;
      }
    }
    AppMethodBeat.o(98981);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98980);
    ad.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    if (paramn.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      dcW();
      if (this.uEh) {
        this.uEi = true;
      }
      AppMethodBeat.o(98980);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */