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
import com.tencent.mm.ak.i;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.b.a.ir;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
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
  private as BhU = null;
  private boolean BhV = false;
  private boolean BhW = false;
  private long BhX = 0L;
  private int BhY = 0;
  private boolean EHB = false;
  private boolean EHC = false;
  private boolean EHD = false;
  private int scene = 0;
  private f screen;
  public com.tencent.mm.ui.base.q tipDialog = null;
  private String userName = "";
  
  private static boolean aKt(String paramString)
  {
    AppMethodBeat.i(98979);
    s locals = aj.faU().JL(5L);
    if (Util.isNullOrNil(locals.field_memberList))
    {
      AppMethodBeat.o(98979);
      return false;
    }
    boolean bool = Util.stringsToList(locals.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(98979);
    return bool;
  }
  
  private void dmp()
  {
    boolean bool2 = false;
    AppMethodBeat.i(98978);
    g.aAi();
    this.BhU = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
    this.BhU.setUsername(this.userName);
    boolean bool1 = this.BhU.arB();
    boolean bool3 = aKt(this.userName);
    Object localObject = (CheckBoxPreference)this.screen.bmg("sns_outside_permiss");
    ((CheckBoxPreference)localObject).setChecked(bool1);
    int i = this.BhU.fuA;
    Log.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ((CheckBoxPreference)localObject).setTitle(2131766157);
      localObject = (CheckBoxPreference)this.screen.bmg("sns_black_permiss");
      if (i != 1) {
        break label294;
      }
      ((CheckBoxPreference)localObject).setTitle(2131766008);
      label153:
      ((CheckBoxPreference)localObject).setChecked(bool3);
      if (!c.oR(this.BhU.field_type)) {
        this.screen.bmi("sns_black_permiss");
      }
      localObject = (PreferenceFooterCategory)this.screen.bmg("sns_openim_desc_footer");
      bool1 = bool2;
      if (as.bjp(this.userName))
      {
        bool1 = bool2;
        if ("3552365301".equals(this.BhU.field_openImAppid)) {
          bool1 = true;
        }
      }
      this.EHD = bool1;
      if (!this.EHD) {
        break label309;
      }
      this.screen.jdMethod_do("sns_outside_permiss", true);
      ((PreferenceFooterCategory)localObject).setSummary(2131766158);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(98978);
      return;
      if (i != 2) {
        break;
      }
      ((CheckBoxPreference)localObject).setTitle(2131766156);
      break;
      label294:
      if (i != 2) {
        break label153;
      }
      ((CheckBoxPreference)localObject).setTitle(2131766007);
      break label153;
      label309:
      this.screen.jdMethod_do("sns_openim_desc_footer", true);
    }
  }
  
  private int eEU()
  {
    AppMethodBeat.i(98982);
    int i = 0;
    int j = 0;
    if (this.BhU != null)
    {
      if (this.BhU.arB()) {
        j = 1;
      }
      i = j;
      if (aKt(this.userName)) {
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
    return 2132017289;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98977);
    this.screen = getPreferenceScreen();
    if ((this.BhU != null) && (as.bjp(this.userName)) && ("3552365301".equals(this.BhU.field_openImAppid))) {
      setMMTitle(2131766161);
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
      this.EHC = aKt(this.userName);
      dmp();
      AppMethodBeat.o(98977);
      return;
      setMMTitle(2131766160);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98974);
    super.onCreate(paramBundle);
    g.aAi();
    g.aAg().hqi.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.EHB = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.BhX = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    Log.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    g.aAi();
    this.BhU = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
    if (this.BhU == null)
    {
      Log.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.BhU.setUsername(this.userName);
    initView();
    this.BhY = eEU();
    AppMethodBeat.o(98974);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98976);
    super.onDestroy();
    a.jRu.WZ();
    g.aAi();
    g.aAg().hqi.b(291, this);
    if ((this.BhX != 0L) && (this.BhX != -1L))
    {
      localObject = new vl();
      ((vl)localObject).ebH.ebI = this.BhW;
      ((vl)localObject).ebH.dNa = this.BhX;
      EventCenter.instance.publish((IEvent)localObject);
    }
    long l = Util.currentTicks();
    int i = eEU();
    Object localObject = new ir().wq(this.userName).wr(r.Jb(this.BhX));
    ((ir)localObject).eki = this.BhY;
    ((ir)localObject).ePy = i;
    ((ir)localObject).enq = 5;
    ((ir)localObject).bfK();
    Log.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.BhY), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    if (this.EHD)
    {
      boolean bool = aKt(this.userName);
      if ((this.EHC) && (!bool))
      {
        localObject = e.DUQ;
        e.fG(this.userName, 2);
        AppMethodBeat.o(98976);
        return;
      }
      if ((!this.EHC) && (bool))
      {
        localObject = e.DUQ;
        e.fG(this.userName, 3);
        AppMethodBeat.o(98976);
        return;
      }
      localObject = e.DUQ;
      e.fG(this.userName, 1);
    }
    AppMethodBeat.o(98976);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98981);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new vx();
      paramf.ebX.ebZ = true;
      paramf.ebX.ebY = false;
      paramf.ebX.username = this.userName;
      EventCenter.instance.publish(paramf);
      if (this.BhU.arB()) {
        ab.w(this.BhU);
      }
      for (;;)
      {
        AppMethodBeat.o(98981);
        return true;
        ab.v(this.BhU);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new vx();
      paramf.ebX.ebZ = false;
      paramf.ebX.ebY = true;
      paramf.ebX.username = this.userName;
      EventCenter.instance.publish(paramf);
      boolean bool = aKt(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label295;
        }
        this.BhV = true;
      }
      for (this.BhW = false;; this.BhW = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new x(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        g.aAi();
        g.aAg().hqi.a(paramf, 0);
        getString(2131755998);
        this.tipDialog = h.a(this, getString(2131766251), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(98973);
            SnsPermissionUI.a(SnsPermissionUI.this);
            g.aAi();
            g.aAg().hqi.a(paramf);
            AppMethodBeat.o(98973);
          }
        });
        AppMethodBeat.o(98981);
        return true;
        i = 1;
        break;
        label295:
        this.BhV = false;
      }
    }
    AppMethodBeat.o(98981);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      dmp();
      if (this.BhV) {
        this.BhW = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */