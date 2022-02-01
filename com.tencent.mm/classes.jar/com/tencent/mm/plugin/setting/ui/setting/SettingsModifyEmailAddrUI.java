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
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.am;
import com.tencent.mm.plugin.account.model.e;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;

public class SettingsModifyEmailAddrUI
  extends MMActivity
  implements i, MStorageEx.IOnStorageChange
{
  private EditText Jik;
  private String Jil;
  private String Jim;
  private TextView Jin;
  private TextView Jio;
  private boolean Jip;
  private boolean Jiq;
  private boolean Jir;
  private ProgressDialog iXX;
  private String mSb = null;
  private String mTk = null;
  
  private void fGl()
  {
    AppMethodBeat.i(74234);
    if (this.Jip)
    {
      this.Jin.setVisibility(0);
      this.Jin.setText(getString(b.i.settings_unbind));
      this.Jio.setText(getString(b.i.settings_modify_email_addr_warning));
      this.Jio.setTextColor(getResources().getColor(b.c.account_info_email_warn_color));
      this.Jik.setEnabled(false);
      this.Jik.setFilters(new InputFilter[] { new InputFilter()
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
      this.Jin.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74222);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = new aa(aa.mWJ);
          com.tencent.mm.kernel.h.aGY().a(paramAnonymousView, 0);
          paramAnonymousView = SettingsModifyEmailAddrUI.this;
          localObject = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(b.i.app_tip);
          SettingsModifyEmailAddrUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.a((Context)localObject, SettingsModifyEmailAddrUI.this.getString(b.i.settings_unbinding), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74222);
        }
      });
      hideVKB(this.Jik);
      AppMethodBeat.o(74234);
      return;
    }
    if (!Util.isNullOrNil(this.Jil))
    {
      this.Jin.setVisibility(0);
      this.Jin.setText(getString(b.i.setting_resend_verifyemail));
      this.Jio.setText(getString(b.i.setting_email_not_verify_tip));
      this.Jio.setTextColor(getResources().getColor(b.c.red));
      this.Jik.setEnabled(false);
      this.Jik.setFilters(new InputFilter[] { new InputFilter()
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
      this.Jin.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(74225);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = new am((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null));
          com.tencent.mm.kernel.h.aGY().a(paramAnonymousView, 0);
          localObject = SettingsModifyEmailAddrUI.this;
          AppCompatActivity localAppCompatActivity = SettingsModifyEmailAddrUI.this.getContext();
          SettingsModifyEmailAddrUI.this.getString(b.i.app_tip);
          SettingsModifyEmailAddrUI.a((SettingsModifyEmailAddrUI)localObject, com.tencent.mm.ui.base.h.a(localAppCompatActivity, SettingsModifyEmailAddrUI.this.getString(b.i.settings_confirm_email_tip), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74224);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousView);
              AppMethodBeat.o(74224);
            }
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74225);
        }
      });
      addTextOptionMenu(0, getString(b.i.app_edit), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74226);
          SettingsModifyEmailAddrUI.b(SettingsModifyEmailAddrUI.this);
          AppMethodBeat.o(74226);
          return true;
        }
      });
      hideVKB(this.Jik);
      AppMethodBeat.o(74234);
      return;
    }
    fGm();
    AppMethodBeat.o(74234);
  }
  
  private void fGm()
  {
    AppMethodBeat.i(74235);
    this.Jin.setVisibility(8);
    this.Jin.setText(getString(b.i.settings_unbind));
    this.Jio.setText(getString(b.i.settings_modify_email_addr_warning));
    this.Jio.setTextColor(getResources().getColor(b.c.account_info_email_warn_color));
    this.Jik.setEnabled(true);
    this.Jik.setFilters(new InputFilter[] { new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        return null;
      }
    } });
    addTextOptionMenu(0, getString(b.i.app_save), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74228);
        SettingsModifyEmailAddrUI.a(SettingsModifyEmailAddrUI.this, SettingsModifyEmailAddrUI.c(SettingsModifyEmailAddrUI.this).getText().toString().trim());
        if (!Util.isValidEmail(SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this)))
        {
          com.tencent.mm.ui.base.h.p(SettingsModifyEmailAddrUI.this.getContext(), b.i.verify_email_err_tip, b.i.app_tip);
          AppMethodBeat.o(74228);
          return true;
        }
        paramAnonymousMenuItem = (Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, null);
        boolean bool;
        if ((paramAnonymousMenuItem != null) && ((paramAnonymousMenuItem.intValue() & 0x2) != 0))
        {
          bool = true;
          if ((SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this).equals(SettingsModifyEmailAddrUI.e(SettingsModifyEmailAddrUI.this))) && (Boolean.valueOf(bool).booleanValue())) {
            break label225;
          }
          paramAnonymousMenuItem = new e(e.mZR, SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this));
          com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI1 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI2 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(b.i.app_tip);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI1, com.tencent.mm.ui.base.h.a(localSettingsModifyEmailAddrUI2, SettingsModifyEmailAddrUI.this.getString(b.i.settings_binding), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74227);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem);
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
          label225:
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
    if (this.Jir)
    {
      setResult(-1);
      AppMethodBeat.o(74236);
      return;
    }
    setResult(0);
    AppMethodBeat.o(74236);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_modify_email_addr;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74233);
    setMMTitle(b.i.settings_modify_email_addr);
    this.Jik = ((EditText)findViewById(b.f.settings_modify_email_new_email_et));
    this.Jin = ((TextView)findViewById(b.f.unbind_btn));
    this.Jio = ((TextView)findViewById(b.f.modify_email_warning_tv));
    this.Jil = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(5, null));
    this.Jik.setText(this.Jil);
    Integer localInteger = (Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Jip = bool;
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
      this.Jiq = true;
      fGl();
      AppMethodBeat.o(74233);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74239);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74239);
      return;
      if (paramInt2 == -1)
      {
        Log.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.Jil + " newEmail: " + this.Jim);
        paramIntent = new aa(aa.mWJ);
        com.tencent.mm.kernel.h.aGY().a(paramIntent, 0);
        getString(b.i.app_tip);
        this.iXX = com.tencent.mm.ui.base.h.a(this, getString(b.i.settings_loading), true, new DialogInterface.OnCancelListener()
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
    com.tencent.mm.kernel.h.aGY().a(138, this);
    com.tencent.mm.kernel.h.aGY().a(254, this);
    com.tencent.mm.kernel.h.aGY().a(256, this);
    com.tencent.mm.kernel.h.aGY().a(108, this);
    com.tencent.mm.kernel.h.aGY().a(255, this);
    com.tencent.mm.kernel.h.aHG().aHp().add(this);
    AppMethodBeat.o(74230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74231);
    com.tencent.mm.kernel.h.aGY().b(138, this);
    com.tencent.mm.kernel.h.aGY().b(254, this);
    com.tencent.mm.kernel.h.aGY().b(256, this);
    com.tencent.mm.kernel.h.aGY().b(108, this);
    com.tencent.mm.kernel.h.aGY().b(255, this);
    com.tencent.mm.kernel.h.aHG().aHp().remove(this);
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
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74232);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.aHG().aHp()) || (i <= 0))
    {
      Log.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74232);
      return;
    }
    paramMStorageEx = (Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, null);
    this.Jil = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(5, null));
    if ((paramMStorageEx != null) && ((paramMStorageEx.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Jip = bool;
      this.Jir = this.Jip;
      if (this.Jiq) {
        fGl();
      }
      AppMethodBeat.o(74232);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74238);
    Log.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + paramq.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (c.mIH.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(74238);
      return;
    }
    if (paramq.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.mSb = ((aa)paramq).byu().Smn;
        this.mTk = ((aa)paramq).byt();
        if (!Util.isNullOrNil(this.mSb))
        {
          paramString = new e(e.mZS, this.Jik.getText().toString().trim());
          com.tencent.mm.kernel.h.aGY().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        paramString = new u(2);
        com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        AppMethodBeat.o(74238);
        return;
      }
      if (this.iXX != null)
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      if (paramInt2 == -3)
      {
        Log.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        com.tencent.mm.ui.base.h.a(getContext(), getString(b.i.settings_unbind_tips_set_user_password), null, getString(b.i.settings_unbind_tips_unbind_btn), getString(b.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74229);
            paramAnonymousDialogInterface = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
            if (WeChatBrands.AppInfo.current().isMainland()) {
              paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(a.i.settings_unbind_set_password_tip));
            }
            for (;;)
            {
              paramAnonymousDialogInterface.putExtra("from_unbind", true);
              SettingsModifyEmailAddrUI.this.startActivityForResult(paramAnonymousDialogInterface, 1);
              AppMethodBeat.o(74229);
              return;
              paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(a.i.settings_unbind_set_password_tip_oversea));
            }
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
        com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_qq_err_one_left, b.i.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -83)
      {
        com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_qq_err_has_unbind, b.i.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -84)
      {
        com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_qq_err_hasbinded, b.i.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -85)
      {
        com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_email_err_bindedbyother, b.i.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
      }
    }
    else if (paramq.getType() == 256)
    {
      c.mIH.abC();
      if (((e)paramq).ZB() == e.mZR)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.ui.base.h.a(getContext(), b.i.settings_confirm_email_success_tip, b.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        if (paramInt2 == -82)
        {
          com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_qq_err_one_left, b.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -83)
        {
          com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_qq_err_has_unbind, b.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -84)
        {
          com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_qq_err_hasbinded, b.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -85)
        {
          com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_email_err_bindedbyother, b.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -86)
        {
          com.tencent.mm.ui.base.h.a(this, b.i.setting_unbind_qq_err_qmail, b.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        com.tencent.mm.ui.base.h.d(getContext(), getString(b.i.settings_confirm_email_fail_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(b.i.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (((e)paramq).ZB() == e.mZS)
      {
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramInt1 = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, null)).intValue();
          com.tencent.mm.kernel.h.aHG().aHp().i(7, Integer.valueOf(paramInt1 | 0x2));
          if (!Util.isNullOrNil(this.mSb))
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.mSb, "", getString(b.i.app_i_known), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(74238);
            return;
          }
          com.tencent.mm.ui.base.h.a(getContext(), b.i.setting_unbind_email_succ, b.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
        }
      }
    }
    else if (paramq.getType() != 138)
    {
      if (paramq.getType() == 108)
      {
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.ui.base.h.a(getContext(), b.i.settings_confirm_email_success_tip, b.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        com.tencent.mm.ui.base.h.d(getContext(), getString(b.i.settings_confirm_email_fail_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(b.i.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramq.getType() == 255)
      {
        if (paramInt2 == 0)
        {
          paramString = new e(e.mZS, this.Jik.getText().toString().trim());
          com.tencent.mm.kernel.h.aGY().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        com.tencent.mm.ui.base.h.a(getContext(), getString(b.i.settings_unbind_tips_set_user_password), null, getString(b.i.settings_unbind_tips_unbind_btn), getString(b.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74221);
            paramAnonymousDialogInterface = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
            if (WeChatBrands.AppInfo.current().isMainland()) {
              paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(a.i.settings_unbind_set_password_tip));
            }
            for (;;)
            {
              paramAnonymousDialogInterface.putExtra("from_unbind", true);
              SettingsModifyEmailAddrUI.this.startActivityForResult(paramAnonymousDialogInterface, 1);
              AppMethodBeat.o(74221);
              return;
              paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(a.i.settings_unbind_set_password_tip_oversea));
            }
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