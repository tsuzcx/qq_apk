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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.am;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SettingsModifyEmailAddrUI
  extends MMActivity
  implements f, n.b
{
  private ProgressDialog fOC;
  private String jcF = null;
  private String jcG = null;
  private EditText yXR;
  private String yXS;
  private String yXT;
  private TextView yXU;
  private TextView yXV;
  private boolean yXW;
  private boolean yXX;
  private boolean yXY;
  
  private void dRg()
  {
    AppMethodBeat.i(74234);
    if (this.yXW)
    {
      this.yXU.setVisibility(0);
      this.yXU.setText(getString(2131763477));
      this.yXV.setText(getString(2131763293));
      this.yXV.setTextColor(getResources().getColor(2131099872));
      this.yXR.setEnabled(false);
      this.yXR.setFilters(new InputFilter[] { new InputFilter()
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
      this.yXU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74222);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = new aa(aa.jhg);
          g.ajj().a(paramAnonymousView, 0);
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
      hideVKB(this.yXR);
      AppMethodBeat.o(74234);
      return;
    }
    if (!bu.isNullOrNil(this.yXS))
    {
      this.yXU.setVisibility(0);
      this.yXU.setText(getString(2131763118));
      this.yXV.setText(getString(2131763106));
      this.yXV.setTextColor(getResources().getColor(2131100798));
      this.yXR.setEnabled(false);
      this.yXR.setFilters(new InputFilter[] { new InputFilter()
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
      this.yXU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(74225);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = new am((String)g.ajR().ajA().get(2, null));
          g.ajj().a(paramAnonymousView, 0);
          localObject = SettingsModifyEmailAddrUI.this;
          AppCompatActivity localAppCompatActivity = SettingsModifyEmailAddrUI.this.getContext();
          SettingsModifyEmailAddrUI.this.getString(2131755906);
          SettingsModifyEmailAddrUI.a((SettingsModifyEmailAddrUI)localObject, h.b(localAppCompatActivity, SettingsModifyEmailAddrUI.this.getString(2131763203), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74224);
              g.ajj().a(paramAnonymousView);
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
      hideVKB(this.yXR);
      AppMethodBeat.o(74234);
      return;
    }
    dRh();
    AppMethodBeat.o(74234);
  }
  
  private void dRh()
  {
    AppMethodBeat.i(74235);
    this.yXU.setVisibility(8);
    this.yXU.setText(getString(2131763477));
    this.yXV.setText(getString(2131763293));
    this.yXV.setTextColor(getResources().getColor(2131099872));
    this.yXR.setEnabled(true);
    this.yXR.setFilters(new InputFilter[] { new InputFilter()
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
        if (!bu.aSp(SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this)))
        {
          h.l(SettingsModifyEmailAddrUI.this.getContext(), 2131764653, 2131755906);
          AppMethodBeat.o(74228);
          return true;
        }
        paramAnonymousMenuItem = (Integer)g.ajR().ajA().get(7, null);
        boolean bool;
        if ((paramAnonymousMenuItem != null) && ((paramAnonymousMenuItem.intValue() & 0x2) != 0))
        {
          bool = true;
          if ((SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this).equals(SettingsModifyEmailAddrUI.e(SettingsModifyEmailAddrUI.this))) && (Boolean.valueOf(bool).booleanValue())) {
            break label221;
          }
          paramAnonymousMenuItem = new d(d.jko, SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this));
          g.ajj().a(paramAnonymousMenuItem, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI1 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI2 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(2131755906);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI1, h.b(localSettingsModifyEmailAddrUI2, SettingsModifyEmailAddrUI.this.getString(2131763188), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74227);
              g.ajj().a(paramAnonymousMenuItem);
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
    if (this.yXY)
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
    int i = bu.m(paramObject, 0);
    ae.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != g.ajR().ajA()) || (i <= 0))
    {
      ae.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74232);
      return;
    }
    paramn = (Integer)g.ajR().ajA().get(7, null);
    this.yXS = ((String)g.ajR().ajA().get(5, null));
    if ((paramn != null) && ((paramn.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.yXW = bool;
      this.yXY = this.yXW;
      if (this.yXX) {
        dRg();
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
    this.yXR = ((EditText)findViewById(2131304661));
    this.yXU = ((TextView)findViewById(2131306180));
    this.yXV = ((TextView)findViewById(2131302437));
    this.yXS = ((String)g.ajR().ajA().get(5, null));
    this.yXR.setText(this.yXS);
    Integer localInteger = (Integer)g.ajR().ajA().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.yXW = bool;
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
      this.yXX = true;
      dRg();
      AppMethodBeat.o(74233);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74239);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74239);
      return;
      if (paramInt2 == -1)
      {
        ae.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.yXS + " newEmail: " + this.yXT);
        paramIntent = new aa(aa.jhg);
        g.ajj().a(paramIntent, 0);
        getString(2131755906);
        this.fOC = h.b(this, getString(2131763261), true, new DialogInterface.OnCancelListener()
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
    g.ajj().a(138, this);
    g.ajj().a(254, this);
    g.ajj().a(256, this);
    g.ajj().a(108, this);
    g.ajj().a(255, this);
    g.ajR().ajA().a(this);
    AppMethodBeat.o(74230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74231);
    g.ajj().b(138, this);
    g.ajj().b(254, this);
    g.ajj().b(256, this);
    g.ajj().b(108, this);
    g.ajj().b(255, this);
    g.ajR().ajA().b(this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(74238);
    ae.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + paramn.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (c.iUA.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(74238);
      return;
    }
    if (paramn.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.jcG = ((aa)paramn).aTz().Gqm;
        this.jcF = ((aa)paramn).aTy();
        if (!bu.isNullOrNil(this.jcG))
        {
          paramString = new d(d.jkp, this.yXR.getText().toString().trim());
          g.ajj().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        paramString = new u(2);
        g.ajj().a(paramString, 0);
        AppMethodBeat.o(74238);
        return;
      }
      if (this.fOC != null)
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if (paramInt2 == -3)
      {
        ae.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
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
      c.iUA.MM();
      if (((d)paramn).KZ() == d.jko)
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
        if (this.fOC != null)
        {
          this.fOC.dismiss();
          this.fOC = null;
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
      if (((d)paramn).KZ() == d.jkp)
      {
        if (this.fOC != null)
        {
          this.fOC.dismiss();
          this.fOC = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramInt1 = ((Integer)g.ajR().ajA().get(7, null)).intValue();
          g.ajR().ajA().set(7, Integer.valueOf(paramInt1 | 0x2));
          if (!bu.isNullOrNil(this.jcG))
          {
            h.a(getContext(), this.jcG, "", getString(2131755793), new DialogInterface.OnClickListener()
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
        if (this.fOC != null)
        {
          this.fOC.dismiss();
          this.fOC = null;
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
          paramString = new d(d.jkp, this.yXR.getText().toString().trim());
          g.ajj().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        if (this.fOC != null)
        {
          this.fOC.dismiss();
          this.fOC = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI
 * JD-Core Version:    0.7.0.1
 */