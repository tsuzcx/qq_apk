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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.b.a.ef;
import com.tencent.mm.g.c.av;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  implements com.tencent.mm.ak.g
{
  private int scene = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  public p tipDialog = null;
  private String userName = "";
  private ai vMX = null;
  private boolean vMY = false;
  private boolean vMZ = false;
  private long vNa = 0L;
  private int vNb = 0;
  private boolean yPB = false;
  private boolean yPC = false;
  private boolean yPD = false;
  
  private static boolean apG(String paramString)
  {
    AppMethodBeat.i(98979);
    com.tencent.mm.plugin.sns.storage.v localv = af.dHX().xM(5L);
    if (bs.isNullOrNil(localv.field_memberList))
    {
      AppMethodBeat.o(98979);
      return false;
    }
    boolean bool = bs.S(localv.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(98979);
    return bool;
  }
  
  private void dqE()
  {
    boolean bool2 = false;
    AppMethodBeat.i(98978);
    com.tencent.mm.kernel.g.agS();
    this.vMX = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.userName);
    this.vMX.setUsername(this.userName);
    boolean bool1 = this.vMX.aaK();
    boolean bool3 = apG(this.userName);
    Object localObject = (CheckBoxPreference)this.screen.aPN("sns_outside_permiss");
    ((CheckBoxPreference)localObject).mF = bool1;
    int i = this.vMX.exL;
    ac.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ((CheckBoxPreference)localObject).setTitle(2131763930);
      localObject = (CheckBoxPreference)this.screen.aPN("sns_black_permiss");
      if (i != 1) {
        break label294;
      }
      ((CheckBoxPreference)localObject).setTitle(2131763786);
      label153:
      ((CheckBoxPreference)localObject).mF = bool3;
      if (!com.tencent.mm.n.b.ln(this.vMX.field_type)) {
        this.screen.aPO("sns_black_permiss");
      }
      localObject = (PreferenceFooterCategory)this.screen.aPN("sns_openim_desc_footer");
      bool1 = bool2;
      if (ai.aNc(this.userName))
      {
        bool1 = bool2;
        if ("3552365301".equals(this.vMX.field_openImAppid)) {
          bool1 = true;
        }
      }
      this.yPD = bool1;
      if (!this.yPD) {
        break label309;
      }
      this.screen.cK("sns_outside_permiss", true);
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
      this.screen.cK("sns_openim_desc_footer", true);
    }
  }
  
  private int dqF()
  {
    AppMethodBeat.i(98982);
    int i = 0;
    int j = 0;
    if (this.vMX != null)
    {
      if (this.vMX.aaK()) {
        j = 1;
      }
      i = j;
      if (apG(this.userName)) {
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
      ac.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
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
    if ((this.vMX != null) && (ai.aNc(this.userName)) && ("3552365301".equals(this.vMX.field_openImAppid))) {
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
      this.yPC = apG(this.userName);
      dqE();
      AppMethodBeat.o(98977);
      return;
      setMMTitle(2131763933);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98974);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.yPB = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.vNa = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ac.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.g.agS();
    this.vMX = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.userName);
    if (this.vMX == null)
    {
      ac.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.vMX.setUsername(this.userName);
    initView();
    this.vNb = dqF();
    AppMethodBeat.o(98974);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98976);
    super.onDestroy();
    com.tencent.mm.plugin.sns.c.a.iyy.Lj();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(291, this);
    if ((this.vNa != 0L) && (this.vNa != -1L))
    {
      localObject = new tq();
      ((tq)localObject).dwu.dwv = this.vMZ;
      ((tq)localObject).dwu.diD = this.vNa;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    long l = bs.Gn();
    int i = dqF();
    Object localObject = new ef().ma(this.userName).mb(com.tencent.mm.plugin.sns.data.q.wW(this.vNa));
    ((ef)localObject).dHr = this.vNb;
    ((ef)localObject).dUb = i;
    ((ef)localObject).dHw = 5;
    ((ef)localObject).aHZ();
    ac.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.vNb), Integer.valueOf(i), Long.valueOf(bs.aO(l)) });
    if (this.yPD)
    {
      boolean bool = apG(this.userName);
      if ((this.yPC) && (!bool))
      {
        localObject = com.tencent.mm.plugin.sns.j.f.ydE;
        com.tencent.mm.plugin.sns.j.f.eH(this.userName, 2);
        AppMethodBeat.o(98976);
        return;
      }
      if ((!this.yPC) && (bool))
      {
        localObject = com.tencent.mm.plugin.sns.j.f.ydE;
        com.tencent.mm.plugin.sns.j.f.eH(this.userName, 3);
        AppMethodBeat.o(98976);
        return;
      }
      localObject = com.tencent.mm.plugin.sns.j.f.ydE;
      com.tencent.mm.plugin.sns.j.f.eH(this.userName, 1);
    }
    AppMethodBeat.o(98976);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98981);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new ub();
      paramf.dwJ.dwL = true;
      paramf.dwJ.dwK = false;
      paramf.dwJ.username = this.userName;
      com.tencent.mm.sdk.b.a.GpY.l(paramf);
      if (this.vMX.aaK()) {
        com.tencent.mm.model.w.p(this.vMX);
      }
      for (;;)
      {
        AppMethodBeat.o(98981);
        return true;
        com.tencent.mm.model.w.o(this.vMX);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new ub();
      paramf.dwJ.dwL = false;
      paramf.dwJ.dwK = true;
      paramf.dwJ.username = this.userName;
      com.tencent.mm.sdk.b.a.GpY.l(paramf);
      boolean bool = apG(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label295;
        }
        this.vMY = true;
      }
      for (this.vMZ = false;; this.vMZ = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new com.tencent.mm.plugin.sns.model.v(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(paramf, 0);
        getString(2131755906);
        this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(98973);
            SnsPermissionUI.a(SnsPermissionUI.this);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(paramf);
            AppMethodBeat.o(98973);
          }
        });
        AppMethodBeat.o(98981);
        return true;
        i = 1;
        break;
        label295:
        this.vMY = false;
      }
    }
    AppMethodBeat.o(98981);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98980);
    ac.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
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
      ac.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      dqE();
      if (this.vMY) {
        this.vMZ = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */