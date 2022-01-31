package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class SettingsModifyEmailAddrUI
  extends MMActivity
  implements f, m.b
{
  private ProgressDialog dnm;
  private String fbA = null;
  private String fbB = null;
  private EditText nUM;
  private String nUN;
  private String nUO;
  private TextView nUP;
  private TextView nUQ;
  private boolean nUR;
  private boolean nUS;
  private boolean nUT;
  
  private void bzc()
  {
    if (this.nUR)
    {
      this.nUP.setVisibility(0);
      this.nUP.setText(getString(a.i.settings_unbind));
      this.nUQ.setText(getString(a.i.settings_modify_email_addr_warning));
      this.nUQ.setTextColor(getResources().getColor(a.c.account_info_email_warn_color));
      this.nUM.setEnabled(false);
      this.nUM.setFilters(new InputFilter[] { new InputFilter()
      {
        public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          if (paramAnonymousCharSequence.length() <= 0) {
            return paramAnonymousSpanned.subSequence(paramAnonymousInt3, paramAnonymousInt4);
          }
          return "";
        }
      } });
      this.nUP.setOnClickListener(new SettingsModifyEmailAddrUI.22(this));
      hideVKB(this.nUM);
      return;
    }
    if (!bk.bl(this.nUN))
    {
      this.nUP.setVisibility(0);
      this.nUP.setText(getString(a.i.setting_resend_verifyemail));
      this.nUQ.setText(getString(a.i.setting_email_not_verify_tip));
      this.nUQ.setTextColor(getResources().getColor(a.c.red));
      this.nUM.setEnabled(false);
      this.nUM.setFilters(new InputFilter[] { new SettingsModifyEmailAddrUI.23(this) });
      this.nUP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          paramAnonymousView = new aj((String)g.DP().Dz().get(2, null));
          g.Dk().a(paramAnonymousView, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
          AppCompatActivity localAppCompatActivity = SettingsModifyEmailAddrUI.this.mController.uMN;
          SettingsModifyEmailAddrUI.this.getString(a.i.app_tip);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI, h.b(localAppCompatActivity, SettingsModifyEmailAddrUI.this.getString(a.i.settings_confirm_email_tip), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              g.Dk().c(paramAnonymousView);
            }
          }));
          SettingsModifyEmailAddrUI.this.XM();
        }
      });
      addTextOptionMenu(0, getString(a.i.app_edit), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          SettingsModifyEmailAddrUI.b(SettingsModifyEmailAddrUI.this);
          return true;
        }
      });
      hideVKB(this.nUM);
      return;
    }
    bzd();
  }
  
  private void bzd()
  {
    this.nUP.setVisibility(8);
    this.nUP.setText(getString(a.i.settings_unbind));
    this.nUQ.setText(getString(a.i.settings_modify_email_addr_warning));
    this.nUQ.setTextColor(getResources().getColor(a.c.account_info_email_warn_color));
    this.nUM.setEnabled(true);
    this.nUM.setFilters(new InputFilter[] { new SettingsModifyEmailAddrUI.26(this) });
    addTextOptionMenu(0, getString(a.i.app_save), new SettingsModifyEmailAddrUI.27(this));
  }
  
  private void goBack()
  {
    XM();
    finish();
    if (this.nUT)
    {
      setResult(-1);
      return;
    }
    setResult(0);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    com.tencent.mm.sdk.platformtools.y.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    if ((paramm != g.DP().Dz()) || (i <= 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
      return;
    }
    paramm = (Integer)g.DP().Dz().get(7, null);
    this.nUN = ((String)g.DP().Dz().get(5, null));
    if ((paramm != null) && ((paramm.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.nUR = bool;
      this.nUT = this.nUR;
      if (!this.nUS) {
        break;
      }
      bzc();
      return;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_modify_email_addr;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_modify_email_addr);
    this.nUM = ((EditText)findViewById(a.f.settings_modify_email_new_email_et));
    this.nUP = ((TextView)findViewById(a.f.unbind_btn));
    this.nUQ = ((TextView)findViewById(a.f.modify_email_warning_tv));
    this.nUN = ((String)g.DP().Dz().get(5, null));
    this.nUM.setText(this.nUN);
    Integer localInteger = (Integer)g.DP().Dz().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.nUR = bool;
      setBackBtn(new SettingsModifyEmailAddrUI.1(this));
      this.nUS = true;
      bzc();
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.y.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    com.tencent.mm.sdk.platformtools.y.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.nUN + " newEmail: " + this.nUO);
    paramIntent = new com.tencent.mm.plugin.account.friend.a.y(com.tencent.mm.plugin.account.friend.a.y.fgs);
    g.Dk().a(paramIntent, 0);
    getString(a.i.app_tip);
    this.dnm = h.b(this, getString(a.i.settings_loading), true, new SettingsModifyEmailAddrUI.21(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    g.Dk().a(138, this);
    g.Dk().a(254, this);
    g.Dk().a(256, this);
    g.Dk().a(108, this);
    g.Dk().a(255, this);
    g.DP().Dz().a(this);
  }
  
  public void onDestroy()
  {
    g.Dk().b(138, this);
    g.Dk().b(254, this);
    g.Dk().b(256, this);
    g.Dk().b(108, this);
    g.Dk().b(255, this);
    g.DP().Dz().b(this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + paramm.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (b.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramm.getType() != 254) {
                break;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                this.fbB = ((com.tencent.mm.plugin.account.friend.a.y)paramm).WY().sNI;
                this.fbA = ((com.tencent.mm.plugin.account.friend.a.y)paramm).WX();
                if (!bk.bl(this.fbB))
                {
                  paramString = new d(d.fjv, this.nUM.getText().toString().trim());
                  g.Dk().a(paramString, 0);
                  return;
                }
                paramString = new r(2);
                g.Dk().a(paramString, 0);
                return;
              }
              if (this.dnm != null)
              {
                this.dnm.dismiss();
                this.dnm = null;
              }
              if (paramInt2 == -3)
              {
                com.tencent.mm.sdk.platformtools.y.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                h.a(this.mController.uMN, getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new SettingsModifyEmailAddrUI.28(this), new SettingsModifyEmailAddrUI.2(this));
                return;
              }
              if (paramInt2 == -82)
              {
                h.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, new SettingsModifyEmailAddrUI.3(this));
                return;
              }
              if (paramInt2 == -83)
              {
                h.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, new SettingsModifyEmailAddrUI.4(this));
                return;
              }
              if (paramInt2 == -84)
              {
                h.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, new SettingsModifyEmailAddrUI.5(this));
                return;
              }
            } while (paramInt2 != -85);
            h.a(this, a.i.setting_unbind_email_err_bindedbyother, a.i.app_tip, new SettingsModifyEmailAddrUI.6(this));
            return;
            if (paramm.getType() != 256) {
              break;
            }
            b.eUS.tk();
            if (((d)paramm).rN() == d.fju)
            {
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                h.a(this.mController.uMN, a.i.settings_confirm_email_success_tip, a.i.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
                });
                return;
              }
              if (this.dnm != null)
              {
                this.dnm.dismiss();
                this.dnm = null;
              }
              if (paramInt2 == -82)
              {
                h.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
                });
                return;
              }
              if (paramInt2 == -83)
              {
                h.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
                });
                return;
              }
              if (paramInt2 == -84)
              {
                h.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, new SettingsModifyEmailAddrUI.10(this));
                return;
              }
              if (paramInt2 == -85)
              {
                h.a(this, a.i.setting_unbind_email_err_bindedbyother, a.i.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
                });
                return;
              }
              if (paramInt2 == -86)
              {
                h.a(this, a.i.setting_unbind_qq_err_qmail, a.i.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
                });
                return;
              }
              h.a(this.mController.uMN, getString(a.i.settings_confirm_email_fail_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(a.i.app_tip), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              return;
            }
          } while (((d)paramm).rN() != d.fjv);
          if (this.dnm != null)
          {
            this.dnm.dismiss();
            this.dnm = null;
          }
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramInt1 = ((Integer)g.DP().Dz().get(7, null)).intValue();
        g.DP().Dz().o(7, Integer.valueOf(paramInt1 | 0x2));
        if (!bk.bl(this.fbB))
        {
          h.a(this.mController.uMN, this.fbB, "", getString(a.i.app_i_known), new SettingsModifyEmailAddrUI.15(this));
          return;
        }
        h.a(this.mController.uMN, a.i.setting_unbind_email_succ, a.i.app_tip, new SettingsModifyEmailAddrUI.16(this));
        return;
      } while (paramm.getType() == 138);
      if (paramm.getType() == 108)
      {
        if (this.dnm != null)
        {
          this.dnm.dismiss();
          this.dnm = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          h.a(this.mController.uMN, a.i.settings_confirm_email_success_tip, a.i.app_tip, new SettingsModifyEmailAddrUI.17(this));
          return;
        }
        h.a(this.mController.uMN, getString(a.i.settings_confirm_email_fail_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(a.i.app_tip), new SettingsModifyEmailAddrUI.18(this));
        return;
      }
    } while (paramm.getType() != 255);
    if (paramInt2 == 0)
    {
      paramString = new d(d.fjv, this.nUM.getText().toString().trim());
      g.Dk().a(paramString, 0);
      return;
    }
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    h.a(this.mController.uMN, getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new SettingsModifyEmailAddrUI.19(this), new SettingsModifyEmailAddrUI.20(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI
 * JD-Core Version:    0.7.0.1
 */