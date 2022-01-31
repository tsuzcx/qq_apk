package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SettingsModifyEmailAddrUI
  extends MMActivity
  implements f, n.b
{
  private ProgressDialog eeN;
  private String gts = null;
  private String gtt = null;
  private EditText qIR;
  private String qIS;
  private String qIT;
  private TextView qIU;
  private TextView qIV;
  private boolean qIW;
  private boolean qIX;
  private boolean qIY;
  
  private void ckm()
  {
    AppMethodBeat.i(127296);
    if (this.qIW)
    {
      this.qIU.setVisibility(0);
      this.qIU.setText(getString(2131303495));
      this.qIV.setText(getString(2131303313));
      this.qIV.setTextColor(getResources().getColor(2131689640));
      this.qIR.setEnabled(false);
      this.qIR.setFilters(new InputFilter[] { new SettingsModifyEmailAddrUI.12(this) });
      this.qIU.setOnClickListener(new SettingsModifyEmailAddrUI.22(this));
      hideVKB(this.qIR);
      AppMethodBeat.o(127296);
      return;
    }
    if (!bo.isNullOrNil(this.qIS))
    {
      this.qIU.setVisibility(0);
      this.qIU.setText(getString(2131303152));
      this.qIV.setText(getString(2131303145));
      this.qIV.setTextColor(getResources().getColor(2131690391));
      this.qIR.setEnabled(false);
      this.qIR.setFilters(new InputFilter[] { new SettingsModifyEmailAddrUI.23(this) });
      this.qIU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(127287);
          paramAnonymousView = new aj((String)g.RL().Ru().get(2, null));
          g.Rc().a(paramAnonymousView, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
          AppCompatActivity localAppCompatActivity = SettingsModifyEmailAddrUI.this.getContext();
          SettingsModifyEmailAddrUI.this.getString(2131297087);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI, h.b(localAppCompatActivity, SettingsModifyEmailAddrUI.this.getString(2131303235), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(127286);
              g.Rc().a(paramAnonymousView);
              AppMethodBeat.o(127286);
            }
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          AppMethodBeat.o(127287);
        }
      });
      addTextOptionMenu(0, getString(2131296914), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(127288);
          SettingsModifyEmailAddrUI.b(SettingsModifyEmailAddrUI.this);
          AppMethodBeat.o(127288);
          return true;
        }
      });
      hideVKB(this.qIR);
      AppMethodBeat.o(127296);
      return;
    }
    ckn();
    AppMethodBeat.o(127296);
  }
  
  private void ckn()
  {
    AppMethodBeat.i(127297);
    this.qIU.setVisibility(8);
    this.qIU.setText(getString(2131303495));
    this.qIV.setText(getString(2131303313));
    this.qIV.setTextColor(getResources().getColor(2131689640));
    this.qIR.setEnabled(true);
    this.qIR.setFilters(new InputFilter[] { new SettingsModifyEmailAddrUI.26(this) });
    addTextOptionMenu(0, getString(2131297063), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127290);
        SettingsModifyEmailAddrUI.a(SettingsModifyEmailAddrUI.this, SettingsModifyEmailAddrUI.c(SettingsModifyEmailAddrUI.this).getText().toString().trim());
        if (!bo.apH(SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this)))
        {
          h.h(SettingsModifyEmailAddrUI.this.getContext(), 2131304496, 2131297087);
          AppMethodBeat.o(127290);
          return true;
        }
        paramAnonymousMenuItem = (Integer)g.RL().Ru().get(7, null);
        boolean bool;
        if ((paramAnonymousMenuItem != null) && ((paramAnonymousMenuItem.intValue() & 0x2) != 0))
        {
          bool = true;
          if ((SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this).equals(SettingsModifyEmailAddrUI.e(SettingsModifyEmailAddrUI.this))) && (Boolean.valueOf(bool).booleanValue())) {
            break label221;
          }
          paramAnonymousMenuItem = new d(d.gAM, SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this));
          g.Rc().a(paramAnonymousMenuItem, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI1 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI2 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(2131297087);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI1, h.b(localSettingsModifyEmailAddrUI2, SettingsModifyEmailAddrUI.this.getString(2131303220), true, new SettingsModifyEmailAddrUI.27.1(this, paramAnonymousMenuItem)));
          SettingsModifyEmailAddrUI.this.hideVKB();
        }
        for (;;)
        {
          AppMethodBeat.o(127290);
          return true;
          bool = false;
          break;
          label221:
          SettingsModifyEmailAddrUI.this.finish();
        }
      }
    });
    AppMethodBeat.o(127297);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(127298);
    hideVKB();
    finish();
    if (this.qIY)
    {
      setResult(-1);
      AppMethodBeat.o(127298);
      return;
    }
    setResult(0);
    AppMethodBeat.o(127298);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(127294);
    int i = bo.f(paramObject, 0);
    ab.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != g.RL().Ru()) || (i <= 0))
    {
      ab.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(127294);
      return;
    }
    paramn = (Integer)g.RL().Ru().get(7, null);
    this.qIS = ((String)g.RL().Ru().get(5, null));
    if ((paramn != null) && ((paramn.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.qIW = bool;
      this.qIY = this.qIW;
      if (this.qIX) {
        ckm();
      }
      AppMethodBeat.o(127294);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970695;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127295);
    setMMTitle(2131303312);
    this.qIR = ((EditText)findViewById(2131827620));
    this.qIU = ((TextView)findViewById(2131827622));
    this.qIV = ((TextView)findViewById(2131827621));
    this.qIS = ((String)g.RL().Ru().get(5, null));
    this.qIR.setText(this.qIS);
    Integer localInteger = (Integer)g.RL().Ru().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.qIW = bool;
      setBackBtn(new SettingsModifyEmailAddrUI.1(this));
      this.qIX = true;
      ckm();
      AppMethodBeat.o(127295);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127301);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127301);
      return;
      if (paramInt2 == -1)
      {
        ab.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.qIS + " newEmail: " + this.qIT);
        paramIntent = new y(y.gya);
        g.Rc().a(paramIntent, 0);
        getString(2131297087);
        this.eeN = h.b(this, getString(2131303292), true, new SettingsModifyEmailAddrUI.21(this));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127292);
    super.onCreate(paramBundle);
    initView();
    g.Rc().a(138, this);
    g.Rc().a(254, this);
    g.Rc().a(256, this);
    g.Rc().a(108, this);
    g.Rc().a(255, this);
    g.RL().Ru().a(this);
    AppMethodBeat.o(127292);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127293);
    g.Rc().b(138, this);
    g.Rc().b(254, this);
    g.Rc().b(256, this);
    g.Rc().b(108, this);
    g.Rc().b(255, this);
    g.RL().Ru().b(this);
    super.onDestroy();
    AppMethodBeat.o(127293);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127299);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(127299);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127299);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(127300);
    ab.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + paramm.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (b.gmP.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(127300);
      return;
    }
    if (paramm.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gtt = ((y)paramm).aqC().wLC;
        this.gts = ((y)paramm).aqB();
        if (!bo.isNullOrNil(this.gtt))
        {
          paramString = new d(d.gAN, this.qIR.getText().toString().trim());
          g.Rc().a(paramString, 0);
          AppMethodBeat.o(127300);
          return;
        }
        paramString = new t(2);
        g.Rc().a(paramString, 0);
        AppMethodBeat.o(127300);
        return;
      }
      if (this.eeN != null)
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      if (paramInt2 == -3)
      {
        ab.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        h.a(getContext(), getString(2131303498), null, getString(2131303499), getString(2131303497), true, new SettingsModifyEmailAddrUI.28(this), new SettingsModifyEmailAddrUI.2(this));
        AppMethodBeat.o(127300);
        return;
      }
      if (paramInt2 == -82)
      {
        h.a(this, 2131303172, 2131297087, new SettingsModifyEmailAddrUI.3(this));
        AppMethodBeat.o(127300);
        return;
      }
      if (paramInt2 == -83)
      {
        h.a(this, 2131303169, 2131297087, new SettingsModifyEmailAddrUI.4(this));
        AppMethodBeat.o(127300);
        return;
      }
      if (paramInt2 == -84)
      {
        h.a(this, 2131303170, 2131297087, new SettingsModifyEmailAddrUI.5(this));
        AppMethodBeat.o(127300);
        return;
      }
      if (paramInt2 == -85)
      {
        h.a(this, 2131303163, 2131297087, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127300);
      }
    }
    else if (paramm.getType() == 256)
    {
      b.gmP.BO();
      if (((d)paramm).Ac() == d.gAM)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          h.a(getContext(), 2131303234, 2131297087, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(127300);
          return;
        }
        if (this.eeN != null)
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        if (paramInt2 == -82)
        {
          h.a(this, 2131303172, 2131297087, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(127300);
          return;
        }
        if (paramInt2 == -83)
        {
          h.a(this, 2131303169, 2131297087, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(127300);
          return;
        }
        if (paramInt2 == -84)
        {
          h.a(this, 2131303170, 2131297087, new SettingsModifyEmailAddrUI.10(this));
          AppMethodBeat.o(127300);
          return;
        }
        if (paramInt2 == -85)
        {
          h.a(this, 2131303163, 2131297087, new SettingsModifyEmailAddrUI.11(this));
          AppMethodBeat.o(127300);
          return;
        }
        if (paramInt2 == -86)
        {
          h.a(this, 2131303174, 2131297087, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(127300);
          return;
        }
        h.a(getContext(), getString(2131303233, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131297087), new SettingsModifyEmailAddrUI.14(this));
        AppMethodBeat.o(127300);
        return;
      }
      if (((d)paramm).Ac() == d.gAN)
      {
        if (this.eeN != null)
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramInt1 = ((Integer)g.RL().Ru().get(7, null)).intValue();
          g.RL().Ru().set(7, Integer.valueOf(paramInt1 | 0x2));
          if (!bo.isNullOrNil(this.gtt))
          {
            h.a(getContext(), this.gtt, "", getString(2131296977), new SettingsModifyEmailAddrUI.15(this));
            AppMethodBeat.o(127300);
            return;
          }
          h.a(getContext(), 2131303165, 2131297087, new SettingsModifyEmailAddrUI.16(this));
          AppMethodBeat.o(127300);
        }
      }
    }
    else if (paramm.getType() != 138)
    {
      if (paramm.getType() == 108)
      {
        if (this.eeN != null)
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          h.a(getContext(), 2131303234, 2131297087, new SettingsModifyEmailAddrUI.17(this));
          AppMethodBeat.o(127300);
          return;
        }
        h.a(getContext(), getString(2131303233, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131297087), new SettingsModifyEmailAddrUI.18(this));
        AppMethodBeat.o(127300);
        return;
      }
      if (paramm.getType() == 255)
      {
        if (paramInt2 == 0)
        {
          paramString = new d(d.gAN, this.qIR.getText().toString().trim());
          g.Rc().a(paramString, 0);
          AppMethodBeat.o(127300);
          return;
        }
        if (this.eeN != null)
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        h.a(getContext(), getString(2131303498), null, getString(2131303499), getString(2131303497), true, new SettingsModifyEmailAddrUI.19(this), new SettingsModifyEmailAddrUI.20(this));
      }
    }
    AppMethodBeat.o(127300);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI
 * JD-Core Version:    0.7.0.1
 */