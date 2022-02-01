package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.yj;
import com.tencent.mm.autogen.a.yv;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.nz;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;
import java.util.LinkedList;
import java.util.List;

public class SnsPermissionUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private au MZR = null;
  private boolean MZS = false;
  private boolean MZT = false;
  private long MZU = 0L;
  private int MZV = 0;
  private boolean RvA = false;
  private boolean RvB = false;
  private boolean RvC = false;
  private int scene = 0;
  private f screen;
  public w tipDialog = null;
  private String userName = "";
  
  private static boolean aRZ(String paramString)
  {
    AppMethodBeat.i(98979);
    ac localac = al.hgI().vl(5L);
    if (Util.isNullOrNil(localac.field_memberList))
    {
      AppMethodBeat.o(98979);
      return false;
    }
    boolean bool = Util.stringsToList(localac.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(98979);
    return bool;
  }
  
  private void evt()
  {
    boolean bool2 = false;
    AppMethodBeat.i(98978);
    com.tencent.mm.kernel.h.baF();
    this.MZR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.userName);
    this.MZR.setUsername(this.userName);
    boolean bool1 = this.MZR.aSL();
    boolean bool3 = aRZ(this.userName);
    Object localObject = (CheckBoxPreference)this.screen.bAi("sns_outside_permiss");
    ((CheckBoxPreference)localObject).setChecked(bool1);
    int i = this.MZR.sex;
    Log.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ((CheckBoxPreference)localObject).setTitle(b.j.sns_outside_permiss_male);
      localObject = (CheckBoxPreference)this.screen.bAi("sns_black_permiss");
      if (i != 1) {
        break label298;
      }
      ((CheckBoxPreference)localObject).setTitle(b.j.sns_black_permiss_male);
      label155:
      ((CheckBoxPreference)localObject).setChecked(bool3);
      if (!d.rs(this.MZR.field_type)) {
        this.screen.bAk("sns_black_permiss");
      }
      localObject = (PreferenceFooterCategory)this.screen.bAi("sns_openim_desc_footer");
      bool1 = bool2;
      if (au.bwO(this.userName))
      {
        bool1 = bool2;
        if ("3552365301".equals(this.MZR.field_openImAppid)) {
          bool1 = true;
        }
      }
      this.RvC = bool1;
      if (!this.RvC) {
        break label314;
      }
      this.screen.eh("sns_outside_permiss", true);
      ((PreferenceFooterCategory)localObject).aBk(b.j.sns_outside_permiss_openim_tip);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(98978);
      return;
      if (i != 2) {
        break;
      }
      ((CheckBoxPreference)localObject).setTitle(b.j.sns_outside_permiss_female);
      break;
      label298:
      if (i != 2) {
        break label155;
      }
      ((CheckBoxPreference)localObject).setTitle(b.j.sns_black_permiss_female);
      break label155;
      label314:
      this.screen.eh("sns_openim_desc_footer", true);
    }
  }
  
  private int gCc()
  {
    AppMethodBeat.i(98982);
    int i = 0;
    int j = 0;
    if (this.MZR != null)
    {
      if (this.MZR.aSL()) {
        j = 1;
      }
      i = j;
      if (aRZ(this.userName)) {
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
    return b.m.sns_premission;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98977);
    this.screen = getPreferenceScreen();
    if ((this.MZR != null) && (au.bwO(this.userName)) && ("3552365301".equals(this.MZR.field_openImAppid))) {
      setMMTitle(b.j.sns_permiss_openim);
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
      this.RvB = aRZ(this.userName);
      evt();
      AppMethodBeat.o(98977);
      return;
      setMMTitle(b.j.sns_permiss);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98974);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.RvA = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.MZU = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    Log.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.h.baF();
    this.MZR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.userName);
    if (this.MZR == null)
    {
      Log.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.MZR.setUsername(this.userName);
    initView();
    this.MZV = gCc();
    AppMethodBeat.o(98974);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98976);
    super.onDestroy();
    a.pFo.aDx();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(291, this);
    if ((this.MZU != 0L) && (this.MZU != -1L))
    {
      localObject = new yj();
      ((yj)localObject).ibJ.ibK = this.MZT;
      ((yj)localObject).ibJ.hLB = this.MZU;
      ((yj)localObject).publish();
    }
    long l = Util.currentTicks();
    int i = gCc();
    Object localObject = new nz().wb(this.userName).wc(t.uA(this.MZU));
    ((nz)localObject).ilm = this.MZV;
    ((nz)localObject).jhc = i;
    ((nz)localObject).imW = 5;
    ((nz)localObject).bMH();
    Log.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.MZV), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    if (this.RvC)
    {
      boolean bool = aRZ(this.userName);
      if ((this.RvB) && (!bool))
      {
        localObject = j.QFS;
        j.hd(this.userName, 2);
        AppMethodBeat.o(98976);
        return;
      }
      if ((!this.RvB) && (bool))
      {
        localObject = j.QFS;
        j.hd(this.userName, 3);
        AppMethodBeat.o(98976);
        return;
      }
      localObject = j.QFS;
      j.hd(this.userName, 1);
    }
    AppMethodBeat.o(98976);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98981);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new yv();
      paramf.ibZ.icb = true;
      paramf.ibZ.ica = false;
      paramf.ibZ.username = this.userName;
      paramf.publish();
      if (this.MZR.aSL()) {
        ab.D(this.MZR);
      }
      for (;;)
      {
        AppMethodBeat.o(98981);
        return true;
        ab.C(this.MZR);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new yv();
      paramf.ibZ.icb = false;
      paramf.ibZ.ica = true;
      paramf.ibZ.username = this.userName;
      paramf.publish();
      boolean bool = aRZ(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label289;
        }
        this.MZS = true;
      }
      for (this.MZT = false;; this.MZT = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new x(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(paramf, 0);
        getString(b.j.app_tip);
        this.tipDialog = k.a(this, getString(b.j.sns_tag_save), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(98973);
            SnsPermissionUI.a(SnsPermissionUI.this);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(paramf);
            AppMethodBeat.o(98973);
          }
        });
        AppMethodBeat.o(98981);
        return true;
        i = 1;
        break;
        label289:
        this.MZS = false;
      }
    }
    AppMethodBeat.o(98981);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(98980);
    Log.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    if (paramp.getType() == 291)
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
      evt();
      if (this.MZS) {
        this.MZT = true;
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