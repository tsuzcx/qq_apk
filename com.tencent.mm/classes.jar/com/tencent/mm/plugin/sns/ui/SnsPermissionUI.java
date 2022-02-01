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
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.b.a.fg;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  implements com.tencent.mm.ak.f
{
  private boolean Ayj = false;
  private boolean Ayk = false;
  private boolean Ayl = false;
  private int scene = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  public p tipDialog = null;
  private String userName = "";
  private an xjX = null;
  private boolean xjY = false;
  private boolean xjZ = false;
  private long xka = 0L;
  private int xkb = 0;
  
  private static boolean awb(String paramString)
  {
    AppMethodBeat.i(98979);
    v localv = ah.dXK().AI(5L);
    if (bu.isNullOrNil(localv.field_memberList))
    {
      AppMethodBeat.o(98979);
      return false;
    }
    boolean bool = bu.U(localv.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(98979);
    return bool;
  }
  
  private void dEy()
  {
    boolean bool2 = false;
    AppMethodBeat.i(98978);
    g.ajS();
    this.xjX = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.userName);
    this.xjX.setUsername(this.userName);
    boolean bool1 = this.xjX.ady();
    boolean bool3 = awb(this.userName);
    Object localObject = (CheckBoxPreference)this.screen.aXe("sns_outside_permiss");
    ((CheckBoxPreference)localObject).setChecked(bool1);
    int i = this.xjX.eQV;
    ae.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ((CheckBoxPreference)localObject).setTitle(2131763930);
      localObject = (CheckBoxPreference)this.screen.aXe("sns_black_permiss");
      if (i != 1) {
        break label294;
      }
      ((CheckBoxPreference)localObject).setTitle(2131763786);
      label153:
      ((CheckBoxPreference)localObject).setChecked(bool3);
      if (!c.lO(this.xjX.field_type)) {
        this.screen.aXf("sns_black_permiss");
      }
      localObject = (PreferenceFooterCategory)this.screen.aXe("sns_openim_desc_footer");
      bool1 = bool2;
      if (an.aUq(this.userName))
      {
        bool1 = bool2;
        if ("3552365301".equals(this.xjX.field_openImAppid)) {
          bool1 = true;
        }
      }
      this.Ayl = bool1;
      if (!this.Ayl) {
        break label309;
      }
      this.screen.cT("sns_outside_permiss", true);
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
      this.screen.cT("sns_openim_desc_footer", true);
    }
  }
  
  private int dEz()
  {
    AppMethodBeat.i(98982);
    int i = 0;
    int j = 0;
    if (this.xjX != null)
    {
      if (this.xjX.ady()) {
        j = 1;
      }
      i = j;
      if (awb(this.userName)) {
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
      ae.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
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
    if ((this.xjX != null) && (an.aUq(this.userName)) && ("3552365301".equals(this.xjX.field_openImAppid))) {
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
      this.Ayk = awb(this.userName);
      dEy();
      AppMethodBeat.o(98977);
      return;
      setMMTitle(2131763933);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98974);
    super.onCreate(paramBundle);
    g.ajS();
    g.ajQ().gDv.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.Ayj = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.xka = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ae.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    g.ajS();
    this.xjX = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.userName);
    if (this.xjX == null)
    {
      ae.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.xjX.setUsername(this.userName);
    initView();
    this.xkb = dEz();
    AppMethodBeat.o(98974);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98976);
    super.onDestroy();
    com.tencent.mm.plugin.sns.c.a.iUA.MM();
    g.ajS();
    g.ajQ().gDv.b(291, this);
    if ((this.xka != 0L) && (this.xka != -1L))
    {
      localObject = new un();
      ((un)localObject).dJU.dJV = this.xjZ;
      ((un)localObject).dJU.dvu = this.xka;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    long l = bu.HQ();
    int i = dEz();
    Object localObject = new fg().oI(this.userName).oJ(r.zV(this.xka));
    ((fg)localObject).dRj = this.xkb;
    ((fg)localObject).ema = i;
    ((fg)localObject).dTw = 5;
    ((fg)localObject).aLH();
    ae.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.xkb), Integer.valueOf(i), Long.valueOf(bu.aO(l)) });
    if (this.Ayl)
    {
      boolean bool = awb(this.userName);
      if ((this.Ayk) && (!bool))
      {
        localObject = e.zKO;
        e.fi(this.userName, 2);
        AppMethodBeat.o(98976);
        return;
      }
      if ((!this.Ayk) && (bool))
      {
        localObject = e.zKO;
        e.fi(this.userName, 3);
        AppMethodBeat.o(98976);
        return;
      }
      localObject = e.zKO;
      e.fi(this.userName, 1);
    }
    AppMethodBeat.o(98976);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98981);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new uy();
      paramf.dKj.dKl = true;
      paramf.dKj.dKk = false;
      paramf.dKj.username = this.userName;
      com.tencent.mm.sdk.b.a.IvT.l(paramf);
      if (this.xjX.ady()) {
        x.w(this.xjX);
      }
      for (;;)
      {
        AppMethodBeat.o(98981);
        return true;
        x.v(this.xjX);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new uy();
      paramf.dKj.dKl = false;
      paramf.dKj.dKk = true;
      paramf.dKj.username = this.userName;
      com.tencent.mm.sdk.b.a.IvT.l(paramf);
      boolean bool = awb(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label295;
        }
        this.xjY = true;
      }
      for (this.xjZ = false;; this.xjZ = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new com.tencent.mm.plugin.sns.model.w(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        g.ajS();
        g.ajQ().gDv.a(paramf, 0);
        getString(2131755906);
        this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(98973);
            SnsPermissionUI.a(SnsPermissionUI.this);
            g.ajS();
            g.ajQ().gDv.a(paramf);
            AppMethodBeat.o(98973);
          }
        });
        AppMethodBeat.o(98981);
        return true;
        i = 1;
        break;
        label295:
        this.xjY = false;
      }
    }
    AppMethodBeat.o(98981);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98980);
    ae.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
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
      ae.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      dEy();
      if (this.xjY) {
        this.xjZ = true;
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