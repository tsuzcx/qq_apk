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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.wq;
import com.tencent.mm.f.a.xc;
import com.tencent.mm.f.b.a.la;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public class SnsPermissionUI
  extends MMPreference
  implements i
{
  private as HbK = null;
  private boolean HbL = false;
  private boolean HbM = false;
  private long HbN = 0L;
  private int HbO = 0;
  private boolean KVD = false;
  private boolean KVE = false;
  private boolean KVF = false;
  private int scene = 0;
  private f screen;
  public com.tencent.mm.ui.base.s tipDialog = null;
  private String userName = "";
  
  private static boolean aUR(String paramString)
  {
    AppMethodBeat.i(98979);
    com.tencent.mm.plugin.sns.storage.s locals = aj.fOO().Rf(5L);
    if (Util.isNullOrNil(locals.field_memberList))
    {
      AppMethodBeat.o(98979);
      return false;
    }
    boolean bool = Util.stringsToList(locals.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(98979);
    return bool;
  }
  
  private void dFf()
  {
    boolean bool2 = false;
    AppMethodBeat.i(98978);
    com.tencent.mm.kernel.h.aHH();
    this.HbK = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.userName);
    this.HbK.setUsername(this.userName);
    boolean bool1 = this.HbK.ayi();
    boolean bool3 = aUR(this.userName);
    Object localObject = (CheckBoxPreference)this.screen.byG("sns_outside_permiss");
    ((CheckBoxPreference)localObject).setChecked(bool1);
    int i = this.HbK.sex;
    Log.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ((CheckBoxPreference)localObject).setTitle(i.j.sns_outside_permiss_male);
      localObject = (CheckBoxPreference)this.screen.byG("sns_black_permiss");
      if (i != 1) {
        break label298;
      }
      ((CheckBoxPreference)localObject).setTitle(i.j.sns_black_permiss_male);
      label155:
      ((CheckBoxPreference)localObject).setChecked(bool3);
      if (!d.rk(this.HbK.field_type)) {
        this.screen.byI("sns_black_permiss");
      }
      localObject = (PreferenceFooterCategory)this.screen.byG("sns_openim_desc_footer");
      bool1 = bool2;
      if (as.bvK(this.userName))
      {
        bool1 = bool2;
        if ("3552365301".equals(this.HbK.field_openImAppid)) {
          bool1 = true;
        }
      }
      this.KVF = bool1;
      if (!this.KVF) {
        break label314;
      }
      this.screen.dz("sns_outside_permiss", true);
      ((PreferenceFooterCategory)localObject).auI(i.j.sns_outside_permiss_openim_tip);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(98978);
      return;
      if (i != 2) {
        break;
      }
      ((CheckBoxPreference)localObject).setTitle(i.j.sns_outside_permiss_female);
      break;
      label298:
      if (i != 2) {
        break label155;
      }
      ((CheckBoxPreference)localObject).setTitle(i.j.sns_black_permiss_female);
      break label155;
      label314:
      this.screen.dz("sns_openim_desc_footer", true);
    }
  }
  
  private int fqI()
  {
    AppMethodBeat.i(98982);
    int i = 0;
    int j = 0;
    if (this.HbK != null)
    {
      if (this.HbK.ayi()) {
        j = 1;
      }
      i = j;
      if (aUR(this.userName)) {
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
      Log.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
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
    return i.m.sns_premission;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98977);
    this.screen = getPreferenceScreen();
    if ((this.HbK != null) && (as.bvK(this.userName)) && ("3552365301".equals(this.HbK.field_openImAppid))) {
      setMMTitle(i.j.sns_permiss_openim);
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
      this.KVE = aUR(this.userName);
      dFf();
      AppMethodBeat.o(98977);
      return;
      setMMTitle(i.j.sns_permiss);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98974);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.KVD = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.HbN = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    Log.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.h.aHH();
    this.HbK = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.userName);
    if (this.HbK == null)
    {
      Log.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.HbK.setUsername(this.userName);
    initView();
    this.HbO = fqI();
    AppMethodBeat.o(98974);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98976);
    super.onDestroy();
    a.mIH.abC();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(291, this);
    if ((this.HbN != 0L) && (this.HbN != -1L))
    {
      localObject = new wq();
      ((wq)localObject).fVJ.fVK = this.HbM;
      ((wq)localObject).fVJ.fGk = this.HbN;
      EventCenter.instance.publish((IEvent)localObject);
    }
    long l = Util.currentTicks();
    int i = fqI();
    Object localObject = new la().BR(this.userName).BS(com.tencent.mm.plugin.sns.data.t.Qu(this.HbN));
    ((la)localObject).geN = this.HbO;
    ((la)localObject).gPU = i;
    ((la)localObject).ggl = 5;
    ((la)localObject).bpa();
    Log.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.HbO), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    if (this.KVF)
    {
      boolean bool = aUR(this.userName);
      if ((this.KVE) && (!bool))
      {
        localObject = g.Kia;
        g.gj(this.userName, 2);
        AppMethodBeat.o(98976);
        return;
      }
      if ((!this.KVE) && (bool))
      {
        localObject = g.Kia;
        g.gj(this.userName, 3);
        AppMethodBeat.o(98976);
        return;
      }
      localObject = g.Kia;
      g.gj(this.userName, 1);
    }
    AppMethodBeat.o(98976);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98981);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new xc();
      paramf.fVZ.fWb = true;
      paramf.fVZ.fWa = false;
      paramf.fVZ.username = this.userName;
      EventCenter.instance.publish(paramf);
      if (this.HbK.ayi()) {
        ab.C(this.HbK);
      }
      for (;;)
      {
        AppMethodBeat.o(98981);
        return true;
        ab.B(this.HbK);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new xc();
      paramf.fVZ.fWb = false;
      paramf.fVZ.fWa = true;
      paramf.fVZ.username = this.userName;
      EventCenter.instance.publish(paramf);
      boolean bool = aUR(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label295;
        }
        this.HbL = true;
      }
      for (this.HbM = false;; this.HbM = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new x(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(paramf, 0);
        getString(i.j.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(i.j.sns_tag_save), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(98973);
            SnsPermissionUI.a(SnsPermissionUI.this);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(paramf);
            AppMethodBeat.o(98973);
          }
        });
        AppMethodBeat.o(98981);
        return true;
        i = 1;
        break;
        label295:
        this.HbL = false;
      }
    }
    AppMethodBeat.o(98981);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(98980);
    Log.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    if (paramq.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      dFf();
      if (this.HbL) {
        this.HbM = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */