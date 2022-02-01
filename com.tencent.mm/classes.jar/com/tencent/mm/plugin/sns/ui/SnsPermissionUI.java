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
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.b.a.fe;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  implements com.tencent.mm.al.f
{
  private boolean AgX = false;
  private boolean AgY = false;
  private boolean AgZ = false;
  private int scene = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  public p tipDialog = null;
  private String userName = "";
  private am wUg = null;
  private boolean wUh = false;
  private boolean wUi = false;
  private long wUj = 0L;
  private int wUk = 0;
  
  private static boolean auM(String paramString)
  {
    AppMethodBeat.i(98979);
    com.tencent.mm.plugin.sns.storage.v localv = ag.dUk().Ak(5L);
    if (bt.isNullOrNil(localv.field_memberList))
    {
      AppMethodBeat.o(98979);
      return false;
    }
    boolean bool = bt.U(localv.field_memberList.split(",")).contains(paramString);
    AppMethodBeat.o(98979);
    return bool;
  }
  
  private void dBh()
  {
    boolean bool2 = false;
    AppMethodBeat.i(98978);
    g.ajD();
    this.wUg = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.userName);
    this.wUg.setUsername(this.userName);
    boolean bool1 = this.wUg.adn();
    boolean bool3 = auM(this.userName);
    Object localObject = (CheckBoxPreference)this.screen.aVD("sns_outside_permiss");
    ((CheckBoxPreference)localObject).oB = bool1;
    int i = this.wUg.ePk;
    ad.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ((CheckBoxPreference)localObject).setTitle(2131763930);
      localObject = (CheckBoxPreference)this.screen.aVD("sns_black_permiss");
      if (i != 1) {
        break label294;
      }
      ((CheckBoxPreference)localObject).setTitle(2131763786);
      label153:
      ((CheckBoxPreference)localObject).oB = bool3;
      if (!com.tencent.mm.o.b.lM(this.wUg.field_type)) {
        this.screen.aVE("sns_black_permiss");
      }
      localObject = (PreferenceFooterCategory)this.screen.aVD("sns_openim_desc_footer");
      bool1 = bool2;
      if (am.aSQ(this.userName))
      {
        bool1 = bool2;
        if ("3552365301".equals(this.wUg.field_openImAppid)) {
          bool1 = true;
        }
      }
      this.AgZ = bool1;
      if (!this.AgZ) {
        break label309;
      }
      this.screen.cP("sns_outside_permiss", true);
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
      this.screen.cP("sns_openim_desc_footer", true);
    }
  }
  
  private int dBi()
  {
    AppMethodBeat.i(98982);
    int i = 0;
    int j = 0;
    if (this.wUg != null)
    {
      if (this.wUg.adn()) {
        j = 1;
      }
      i = j;
      if (auM(this.userName)) {
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
    if ((this.wUg != null) && (am.aSQ(this.userName)) && ("3552365301".equals(this.wUg.field_openImAppid))) {
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
      this.AgY = auM(this.userName);
      dBh();
      AppMethodBeat.o(98977);
      return;
      setMMTitle(2131763933);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98974);
    super.onCreate(paramBundle);
    g.ajD();
    g.ajB().gAO.a(291, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.AgX = getIntent().getBooleanExtra("sns_permission_anim", false);
    this.wUj = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ad.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    g.ajD();
    this.wUg = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.userName);
    if (this.wUg == null)
    {
      ad.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.wUg.setUsername(this.userName);
    initView();
    this.wUk = dBi();
    AppMethodBeat.o(98974);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98976);
    super.onDestroy();
    com.tencent.mm.plugin.sns.c.a.iRH.MR();
    g.ajD();
    g.ajB().gAO.b(291, this);
    if ((this.wUj != 0L) && (this.wUj != -1L))
    {
      localObject = new uj();
      ((uj)localObject).dIG.dIH = this.wUi;
      ((uj)localObject).dIG.dup = this.wUj;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    long l = bt.HI();
    int i = dBi();
    Object localObject = new fe().on(this.userName).oo(com.tencent.mm.plugin.sns.data.q.zw(this.wUj));
    ((fe)localObject).dPT = this.wUk;
    ((fe)localObject).ekt = i;
    ((fe)localObject).dSg = 5;
    ((fe)localObject).aLk();
    ad.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.wUk), Integer.valueOf(i), Long.valueOf(bt.aO(l)) });
    if (this.AgZ)
    {
      boolean bool = auM(this.userName);
      if ((this.AgY) && (!bool))
      {
        localObject = e.ztz;
        e.eZ(this.userName, 2);
        AppMethodBeat.o(98976);
        return;
      }
      if ((!this.AgY) && (bool))
      {
        localObject = e.ztz;
        e.eZ(this.userName, 3);
        AppMethodBeat.o(98976);
        return;
      }
      localObject = e.ztz;
      e.eZ(this.userName, 1);
    }
    AppMethodBeat.o(98976);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98981);
    paramf = paramPreference.mKey;
    if (paramf.equals("sns_outside_permiss"))
    {
      paramf = new uu();
      paramf.dIV.dIX = true;
      paramf.dIV.dIW = false;
      paramf.dIV.username = this.userName;
      com.tencent.mm.sdk.b.a.IbL.l(paramf);
      if (this.wUg.adn()) {
        com.tencent.mm.model.w.p(this.wUg);
      }
      for (;;)
      {
        AppMethodBeat.o(98981);
        return true;
        com.tencent.mm.model.w.o(this.wUg);
      }
    }
    if (paramf.equals("sns_black_permiss"))
    {
      paramf = new uu();
      paramf.dIV.dIX = false;
      paramf.dIV.dIW = true;
      paramf.dIV.username = this.userName;
      com.tencent.mm.sdk.b.a.IbL.l(paramf);
      boolean bool = auM(this.userName);
      paramf = this.userName;
      int i;
      if (bool)
      {
        i = 2;
        if ((i != 1) || (5L != 5L)) {
          break label295;
        }
        this.wUh = true;
      }
      for (this.wUi = false;; this.wUi = false)
      {
        paramPreference = new LinkedList();
        paramPreference.add(paramf);
        paramf = new com.tencent.mm.plugin.sns.model.v(i, 5L, "", paramPreference.size(), paramPreference, this.scene);
        g.ajD();
        g.ajB().gAO.a(paramf, 0);
        getString(2131755906);
        this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(98973);
            SnsPermissionUI.a(SnsPermissionUI.this);
            g.ajD();
            g.ajB().gAO.a(paramf);
            AppMethodBeat.o(98973);
          }
        });
        AppMethodBeat.o(98981);
        return true;
        i = 1;
        break;
        label295:
        this.wUh = false;
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
      dBh();
      if (this.wUh) {
        this.wUi = true;
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