package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.am;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SettingsModifyEmailAddrUI
  extends MMActivity
  implements f, n.b
{
  private ProgressDialog fMu;
  private String iZM = null;
  private String iZN = null;
  private EditText yHH;
  private String yHI;
  private String yHJ;
  private TextView yHK;
  private TextView yHL;
  private boolean yHM;
  private boolean yHN;
  private boolean yHO;
  
  private void dNJ()
  {
    AppMethodBeat.i(74234);
    if (this.yHM)
    {
      this.yHK.setVisibility(0);
      this.yHK.setText(getString(2131763477));
      this.yHL.setText(getString(2131763293));
      this.yHL.setTextColor(getResources().getColor(2131099872));
      this.yHH.setEnabled(false);
      this.yHH.setFilters(new InputFilter[] { new InputFilter()
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
      this.yHK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74222);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = new aa(aa.jen);
          g.aiU().a(paramAnonymousView, 0);
          paramAnonymousView = SettingsModifyEmailAddrUI.this;
          localObject = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(2131755906);
          SettingsModifyEmailAddrUI.a(paramAnonymousView, h.b((Context)localObject, SettingsModifyEmailAddrUI.this.getString(2131763482), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74222);
        }
      });
      hideVKB(this.yHH);
      AppMethodBeat.o(74234);
      return;
    }
    if (!bt.isNullOrNil(this.yHI))
    {
      this.yHK.setVisibility(0);
      this.yHK.setText(getString(2131763118));
      this.yHL.setText(getString(2131763106));
      this.yHL.setTextColor(getResources().getColor(2131100798));
      this.yHH.setEnabled(false);
      this.yHH.setFilters(new InputFilter[] { new InputFilter()
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
      this.yHK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(74225);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = new am((String)g.ajC().ajl().get(2, null));
          g.aiU().a(paramAnonymousView, 0);
          localObject = SettingsModifyEmailAddrUI.this;
          AppCompatActivity localAppCompatActivity = SettingsModifyEmailAddrUI.this.getContext();
          SettingsModifyEmailAddrUI.this.getString(2131755906);
          SettingsModifyEmailAddrUI.a((SettingsModifyEmailAddrUI)localObject, h.b(localAppCompatActivity, SettingsModifyEmailAddrUI.this.getString(2131763203), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74224);
              g.aiU().a(paramAnonymousView);
              AppMethodBeat.o(74224);
            }
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      hideVKB(this.yHH);
      AppMethodBeat.o(74234);
      return;
    }
    dNK();
    AppMethodBeat.o(74234);
  }
  
  private void dNK()
  {
    AppMethodBeat.i(74235);
    this.yHK.setVisibility(8);
    this.yHK.setText(getString(2131763477));
    this.yHL.setText(getString(2131763293));
    this.yHL.setTextColor(getResources().getColor(2131099872));
    this.yHH.setEnabled(true);
    this.yHH.setFilters(new InputFilter[] { new InputFilter()
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
        if (!bt.aQS(SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this)))
        {
          h.l(SettingsModifyEmailAddrUI.this.getContext(), 2131764653, 2131755906);
          AppMethodBeat.o(74228);
          return true;
        }
        paramAnonymousMenuItem = (Integer)g.ajC().ajl().get(7, null);
        boolean bool;
        if ((paramAnonymousMenuItem != null) && ((paramAnonymousMenuItem.intValue() & 0x2) != 0))
        {
          bool = true;
          if ((SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this).equals(SettingsModifyEmailAddrUI.e(SettingsModifyEmailAddrUI.this))) && (Boolean.valueOf(bool).booleanValue())) {
            break label221;
          }
          paramAnonymousMenuItem = new d(d.jhv, SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this));
          g.aiU().a(paramAnonymousMenuItem, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI1 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI2 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(2131755906);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI1, h.b(localSettingsModifyEmailAddrUI2, SettingsModifyEmailAddrUI.this.getString(2131763188), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74227);
              g.aiU().a(paramAnonymousMenuItem);
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
    if (this.yHO)
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
    int i = bt.m(paramObject, 0);
    ad.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != g.ajC().ajl()) || (i <= 0))
    {
      ad.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74232);
      return;
    }
    paramn = (Integer)g.ajC().ajl().get(7, null);
    this.yHI = ((String)g.ajC().ajl().get(5, null));
    if ((paramn != null) && ((paramn.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.yHM = bool;
      this.yHO = this.yHM;
      if (this.yHN) {
        dNJ();
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
    this.yHH = ((EditText)findViewById(2131304661));
    this.yHK = ((TextView)findViewById(2131306180));
    this.yHL = ((TextView)findViewById(2131302437));
    this.yHI = ((String)g.ajC().ajl().get(5, null));
    this.yHH.setText(this.yHI);
    Integer localInteger = (Integer)g.ajC().ajl().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.yHM = bool;
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
      this.yHN = true;
      dNJ();
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
        ad.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.yHI + " newEmail: " + this.yHJ);
        paramIntent = new aa(aa.jen);
        g.aiU().a(paramIntent, 0);
        getString(2131755906);
        this.fMu = h.b(this, getString(2131763261), true, new DialogInterface.OnCancelListener()
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
    g.aiU().a(138, this);
    g.aiU().a(254, this);
    g.aiU().a(256, this);
    g.aiU().a(108, this);
    g.aiU().a(255, this);
    g.ajC().ajl().a(this);
    AppMethodBeat.o(74230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74231);
    g.aiU().b(138, this);
    g.aiU().b(254, this);
    g.aiU().b(256, this);
    g.aiU().b(108, this);
    g.aiU().b(255, this);
    g.ajC().ajl().b(this);
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
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (com.tencent.mm.plugin.setting.b.iRH.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(74238);
      return;
    }
    if (paramn.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.iZN = ((aa)paramn).aTa().FXN;
        this.iZM = ((aa)paramn).aSZ();
        if (!bt.isNullOrNil(this.iZN))
        {
          paramString = new d(d.jhw, this.yHH.getText().toString().trim());
          g.aiU().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        paramString = new t(2);
        g.aiU().a(paramString, 0);
        AppMethodBeat.o(74238);
        return;
      }
      if (this.fMu != null)
      {
        this.fMu.dismiss();
        this.fMu = null;
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
      com.tencent.mm.plugin.setting.b.iRH.MR();
      if (((d)paramn).KR() == d.jhv)
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
        if (this.fMu != null)
        {
          this.fMu.dismiss();
          this.fMu = null;
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
      if (((d)paramn).KR() == d.jhw)
      {
        if (this.fMu != null)
        {
          this.fMu.dismiss();
          this.fMu = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramInt1 = ((Integer)g.ajC().ajl().get(7, null)).intValue();
          g.ajC().ajl().set(7, Integer.valueOf(paramInt1 | 0x2));
          if (!bt.isNullOrNil(this.iZN))
          {
            h.a(getContext(), this.iZN, "", getString(2131755793), new DialogInterface.OnClickListener()
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
        if (this.fMu != null)
        {
          this.fMu.dismiss();
          this.fMu = null;
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
          paramString = new d(d.jhw, this.yHH.getText().toString().trim());
          g.aiU().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        if (this.fMu != null)
        {
          this.fMu.dismiss();
          this.fMu = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI
 * JD-Core Version:    0.7.0.1
 */