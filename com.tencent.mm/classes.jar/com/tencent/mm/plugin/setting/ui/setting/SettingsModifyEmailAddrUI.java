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
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.am;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SettingsModifyEmailAddrUI
  extends MMActivity
  implements com.tencent.mm.al.g, n.b
{
  private ProgressDialog fpP;
  private String igu = null;
  private String igv = null;
  private EditText whJ;
  private String whK;
  private String whL;
  private TextView whM;
  private TextView whN;
  private boolean whO;
  private boolean whP;
  private boolean whQ;
  
  private void dnY()
  {
    AppMethodBeat.i(74234);
    if (this.whO)
    {
      this.whM.setVisibility(0);
      this.whM.setText(getString(2131763477));
      this.whN.setText(getString(2131763293));
      this.whN.setTextColor(getResources().getColor(2131099872));
      this.whJ.setEnabled(false);
      this.whJ.setFilters(new InputFilter[] { new InputFilter()
      {
        public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(74220);
          if (paramAnonymousCharSequence.length() <= 0)
          {
            paramAnonymousCharSequence = paramAnonymousSpanned.subSequence(paramAnonymousInt3, paramAnonymousInt4);
            AppMethodBeat.o(74220);
            return paramAnonymousCharSequence;
          }
          AppMethodBeat.o(74220);
          return "";
        }
      } });
      this.whM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74222);
          paramAnonymousView = new aa(aa.ikX);
          com.tencent.mm.kernel.g.aeS().a(paramAnonymousView, 0);
          paramAnonymousView = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(2131755906);
          SettingsModifyEmailAddrUI.a(paramAnonymousView, h.b(localSettingsModifyEmailAddrUI, SettingsModifyEmailAddrUI.this.getString(2131763482), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          AppMethodBeat.o(74222);
        }
      });
      hideVKB(this.whJ);
      AppMethodBeat.o(74234);
      return;
    }
    if (!bt.isNullOrNil(this.whK))
    {
      this.whM.setVisibility(0);
      this.whM.setText(getString(2131763118));
      this.whN.setText(getString(2131763106));
      this.whN.setTextColor(getResources().getColor(2131100798));
      this.whJ.setEnabled(false);
      this.whJ.setFilters(new InputFilter[] { new InputFilter()
      {
        public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(74223);
          if (paramAnonymousCharSequence.length() <= 0)
          {
            paramAnonymousCharSequence = paramAnonymousSpanned.subSequence(paramAnonymousInt3, paramAnonymousInt4);
            AppMethodBeat.o(74223);
            return paramAnonymousCharSequence;
          }
          AppMethodBeat.o(74223);
          return "";
        }
      } });
      this.whM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(74225);
          paramAnonymousView = new am((String)com.tencent.mm.kernel.g.afB().afk().get(2, null));
          com.tencent.mm.kernel.g.aeS().a(paramAnonymousView, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
          AppCompatActivity localAppCompatActivity = SettingsModifyEmailAddrUI.this.getContext();
          SettingsModifyEmailAddrUI.this.getString(2131755906);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI, h.b(localAppCompatActivity, SettingsModifyEmailAddrUI.this.getString(2131763203), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74224);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousView);
              AppMethodBeat.o(74224);
            }
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          AppMethodBeat.o(74225);
        }
      });
      addTextOptionMenu(0, getString(2131755721), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74226);
          SettingsModifyEmailAddrUI.b(SettingsModifyEmailAddrUI.this);
          AppMethodBeat.o(74226);
          return true;
        }
      });
      hideVKB(this.whJ);
      AppMethodBeat.o(74234);
      return;
    }
    dnZ();
    AppMethodBeat.o(74234);
  }
  
  private void dnZ()
  {
    AppMethodBeat.i(74235);
    this.whM.setVisibility(8);
    this.whM.setText(getString(2131763477));
    this.whN.setText(getString(2131763293));
    this.whN.setTextColor(getResources().getColor(2131099872));
    this.whJ.setEnabled(true);
    this.whJ.setFilters(new InputFilter[] { new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        return null;
      }
    } });
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74228);
        SettingsModifyEmailAddrUI.a(SettingsModifyEmailAddrUI.this, SettingsModifyEmailAddrUI.c(SettingsModifyEmailAddrUI.this).getText().toString().trim());
        if (!bt.aFV(SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this)))
        {
          h.j(SettingsModifyEmailAddrUI.this.getContext(), 2131764653, 2131755906);
          AppMethodBeat.o(74228);
          return true;
        }
        paramAnonymousMenuItem = (Integer)com.tencent.mm.kernel.g.afB().afk().get(7, null);
        boolean bool;
        if ((paramAnonymousMenuItem != null) && ((paramAnonymousMenuItem.intValue() & 0x2) != 0))
        {
          bool = true;
          if ((SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this).equals(SettingsModifyEmailAddrUI.e(SettingsModifyEmailAddrUI.this))) && (Boolean.valueOf(bool).booleanValue())) {
            break label221;
          }
          paramAnonymousMenuItem = new d(d.iog, SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this));
          com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI1 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI2 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(2131755906);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI1, h.b(localSettingsModifyEmailAddrUI2, SettingsModifyEmailAddrUI.this.getString(2131763188), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74227);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem);
              AppMethodBeat.o(74227);
            }
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
        }
        for (;;)
        {
          AppMethodBeat.o(74228);
          return true;
          bool = false;
          break;
          label221:
          SettingsModifyEmailAddrUI.this.finish();
        }
      }
    });
    AppMethodBeat.o(74235);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(74236);
    hideVKB();
    finish();
    if (this.whQ)
    {
      setResult(-1);
      AppMethodBeat.o(74236);
      return;
    }
    setResult(0);
    AppMethodBeat.o(74236);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74232);
    int i = bt.i(paramObject, 0);
    ad.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.afB().afk()) || (i <= 0))
    {
      ad.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74232);
      return;
    }
    paramn = (Integer)com.tencent.mm.kernel.g.afB().afk().get(7, null);
    this.whK = ((String)com.tencent.mm.kernel.g.afB().afk().get(5, null));
    if ((paramn != null) && ((paramn.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.whO = bool;
      this.whQ = this.whO;
      if (this.whP) {
        dnY();
      }
      AppMethodBeat.o(74232);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495398;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74233);
    setMMTitle(2131763292);
    this.whJ = ((EditText)findViewById(2131304661));
    this.whM = ((TextView)findViewById(2131306180));
    this.whN = ((TextView)findViewById(2131302437));
    this.whK = ((String)com.tencent.mm.kernel.g.afB().afk().get(5, null));
    this.whJ.setText(this.whK);
    Integer localInteger = (Integer)com.tencent.mm.kernel.g.afB().afk().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.whO = bool;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74219);
          SettingsModifyEmailAddrUI.a(SettingsModifyEmailAddrUI.this);
          AppMethodBeat.o(74219);
          return true;
        }
      });
      this.whP = true;
      dnY();
      AppMethodBeat.o(74233);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74239);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74239);
      return;
      if (paramInt2 == -1)
      {
        ad.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.whK + " newEmail: " + this.whL);
        paramIntent = new aa(aa.ikX);
        com.tencent.mm.kernel.g.aeS().a(paramIntent, 0);
        getString(2131755906);
        this.fpP = h.b(this, getString(2131763261), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74230);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.aeS().a(138, this);
    com.tencent.mm.kernel.g.aeS().a(254, this);
    com.tencent.mm.kernel.g.aeS().a(256, this);
    com.tencent.mm.kernel.g.aeS().a(108, this);
    com.tencent.mm.kernel.g.aeS().a(255, this);
    com.tencent.mm.kernel.g.afB().afk().a(this);
    AppMethodBeat.o(74230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74231);
    com.tencent.mm.kernel.g.aeS().b(138, this);
    com.tencent.mm.kernel.g.aeS().b(254, this);
    com.tencent.mm.kernel.g.aeS().b(256, this);
    com.tencent.mm.kernel.g.aeS().b(108, this);
    com.tencent.mm.kernel.g.aeS().b(255, this);
    com.tencent.mm.kernel.g.afB().afk().b(this);
    super.onDestroy();
    AppMethodBeat.o(74231);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74237);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(74237);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(74237);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(74238);
    ad.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + paramn.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (b.hYu.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(74238);
      return;
    }
    if (paramn.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.igv = ((aa)paramn).aIX().CXU;
        this.igu = ((aa)paramn).aIW();
        if (!bt.isNullOrNil(this.igv))
        {
          paramString = new d(d.ioh, this.whJ.getText().toString().trim());
          com.tencent.mm.kernel.g.aeS().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        paramString = new t(2);
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
        AppMethodBeat.o(74238);
        return;
      }
      if (this.fpP != null)
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      if (paramInt2 == -3)
      {
        ad.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        h.a(getContext(), getString(2131763480), null, getString(2131763481), getString(2131763479), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74229);
            paramAnonymousDialogInterface = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
            paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(2131763478));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            SettingsModifyEmailAddrUI.this.startActivityForResult(paramAnonymousDialogInterface, 1);
            AppMethodBeat.o(74229);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -82)
      {
        h.a(this, 2131763138, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -83)
      {
        h.a(this, 2131763135, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -84)
      {
        h.a(this, 2131763136, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -85)
      {
        h.a(this, 2131763129, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
      }
    }
    else if (paramn.getType() == 256)
    {
      b.hYu.Ll();
      if (((d)paramn).JJ() == d.iog)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          h.a(getContext(), 2131763202, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (this.fpP != null)
        {
          this.fpP.dismiss();
          this.fpP = null;
        }
        if (paramInt2 == -82)
        {
          h.a(this, 2131763138, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -83)
        {
          h.a(this, 2131763135, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -84)
        {
          h.a(this, 2131763136, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -85)
        {
          h.a(this, 2131763129, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -86)
        {
          h.a(this, 2131763140, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        h.d(getContext(), getString(2131763201, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (((d)paramn).JJ() == d.ioh)
      {
        if (this.fpP != null)
        {
          this.fpP.dismiss();
          this.fpP = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramInt1 = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(7, null)).intValue();
          com.tencent.mm.kernel.g.afB().afk().set(7, Integer.valueOf(paramInt1 | 0x2));
          if (!bt.isNullOrNil(this.igv))
          {
            h.a(getContext(), this.igv, "", getString(2131755793), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(74238);
            return;
          }
          h.a(getContext(), 2131763131, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
        }
      }
    }
    else if (paramn.getType() != 138)
    {
      if (paramn.getType() == 108)
      {
        if (this.fpP != null)
        {
          this.fpP.dismiss();
          this.fpP = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          h.a(getContext(), 2131763202, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        h.d(getContext(), getString(2131763201, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramn.getType() == 255)
      {
        if (paramInt2 == 0)
        {
          paramString = new d(d.ioh, this.whJ.getText().toString().trim());
          com.tencent.mm.kernel.g.aeS().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        if (this.fpP != null)
        {
          this.fpP.dismiss();
          this.fpP = null;
        }
        h.a(getContext(), getString(2131763480), null, getString(2131763481), getString(2131763479), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74221);
            paramAnonymousDialogInterface = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
            paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(2131763478));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            SettingsModifyEmailAddrUI.this.startActivityForResult(paramAnonymousDialogInterface, 1);
            AppMethodBeat.o(74221);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    AppMethodBeat.o(74238);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI
 * JD-Core Version:    0.7.0.1
 */