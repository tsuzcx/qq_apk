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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.am;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SettingsModifyEmailAddrUI
  extends MMActivity
  implements i, MStorageEx.IOnStorageChange
{
  private EditText DcJ;
  private String DcK;
  private String DcL;
  private TextView DcM;
  private TextView DcN;
  private boolean DcO;
  private boolean DcP;
  private boolean DcQ;
  private ProgressDialog gtM;
  private String kaI = null;
  private String kaJ = null;
  
  private void eTh()
  {
    AppMethodBeat.i(74234);
    if (this.DcO)
    {
      this.DcM.setVisibility(0);
      this.DcM.setText(getString(2131765660));
      this.DcN.setText(getString(2131765468));
      this.DcN.setTextColor(getResources().getColor(2131099890));
      this.DcJ.setEnabled(false);
      this.DcJ.setFilters(new InputFilter[] { new InputFilter()
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
      this.DcM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74222);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          paramAnonymousView = new aa(aa.kfk);
          g.azz().a(paramAnonymousView, 0);
          paramAnonymousView = SettingsModifyEmailAddrUI.this;
          localObject = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(2131755998);
          SettingsModifyEmailAddrUI.a(paramAnonymousView, h.a((Context)localObject, SettingsModifyEmailAddrUI.this.getString(2131765666), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74222);
        }
      });
      hideVKB(this.DcJ);
      AppMethodBeat.o(74234);
      return;
    }
    if (!Util.isNullOrNil(this.DcK))
    {
      this.DcM.setVisibility(0);
      this.DcM.setText(getString(2131765284));
      this.DcN.setText(getString(2131765268));
      this.DcN.setTextColor(getResources().getColor(2131100994));
      this.DcJ.setEnabled(false);
      this.DcJ.setFilters(new InputFilter[] { new InputFilter()
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
      this.DcM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(74225);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          paramAnonymousView = new am((String)g.aAh().azQ().get(2, null));
          g.azz().a(paramAnonymousView, 0);
          localObject = SettingsModifyEmailAddrUI.this;
          AppCompatActivity localAppCompatActivity = SettingsModifyEmailAddrUI.this.getContext();
          SettingsModifyEmailAddrUI.this.getString(2131755998);
          SettingsModifyEmailAddrUI.a((SettingsModifyEmailAddrUI)localObject, h.a(localAppCompatActivity, SettingsModifyEmailAddrUI.this.getString(2131765371), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74224);
              g.azz().a(paramAnonymousView);
              AppMethodBeat.o(74224);
            }
          }));
          SettingsModifyEmailAddrUI.this.hideVKB();
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74225);
        }
      });
      addTextOptionMenu(0, getString(2131755792), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74226);
          SettingsModifyEmailAddrUI.b(SettingsModifyEmailAddrUI.this);
          AppMethodBeat.o(74226);
          return true;
        }
      });
      hideVKB(this.DcJ);
      AppMethodBeat.o(74234);
      return;
    }
    eTi();
    AppMethodBeat.o(74234);
  }
  
  private void eTi()
  {
    AppMethodBeat.i(74235);
    this.DcM.setVisibility(8);
    this.DcM.setText(getString(2131765660));
    this.DcN.setText(getString(2131765468));
    this.DcN.setTextColor(getResources().getColor(2131099890));
    this.DcJ.setEnabled(true);
    this.DcJ.setFilters(new InputFilter[] { new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        return null;
      }
    } });
    addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74228);
        SettingsModifyEmailAddrUI.a(SettingsModifyEmailAddrUI.this, SettingsModifyEmailAddrUI.c(SettingsModifyEmailAddrUI.this).getText().toString().trim());
        if (!Util.isValidEmail(SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this)))
        {
          h.n(SettingsModifyEmailAddrUI.this.getContext(), 2131767024, 2131755998);
          AppMethodBeat.o(74228);
          return true;
        }
        paramAnonymousMenuItem = (Integer)g.aAh().azQ().get(7, null);
        boolean bool;
        if ((paramAnonymousMenuItem != null) && ((paramAnonymousMenuItem.intValue() & 0x2) != 0))
        {
          bool = true;
          if ((SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this).equals(SettingsModifyEmailAddrUI.e(SettingsModifyEmailAddrUI.this))) && (Boolean.valueOf(bool).booleanValue())) {
            break label221;
          }
          paramAnonymousMenuItem = new com.tencent.mm.plugin.account.model.e(com.tencent.mm.plugin.account.model.e.kir, SettingsModifyEmailAddrUI.d(SettingsModifyEmailAddrUI.this));
          g.azz().a(paramAnonymousMenuItem, 0);
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI1 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI localSettingsModifyEmailAddrUI2 = SettingsModifyEmailAddrUI.this;
          SettingsModifyEmailAddrUI.this.getString(2131755998);
          SettingsModifyEmailAddrUI.a(localSettingsModifyEmailAddrUI1, h.a(localSettingsModifyEmailAddrUI2, SettingsModifyEmailAddrUI.this.getString(2131765356), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74227);
              g.azz().a(paramAnonymousMenuItem);
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
    if (this.DcQ)
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
    return 2131496259;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74233);
    setMMTitle(2131765467);
    this.DcJ = ((EditText)findViewById(2131307713));
    this.DcM = ((TextView)findViewById(2131309568));
    this.DcN = ((TextView)findViewById(2131304837));
    this.DcK = ((String)g.aAh().azQ().get(5, null));
    this.DcJ.setText(this.DcK);
    Integer localInteger = (Integer)g.aAh().azQ().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.DcO = bool;
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
      this.DcP = true;
      eTh();
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
        Log.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.DcK + " newEmail: " + this.DcL);
        paramIntent = new aa(aa.kfk);
        g.azz().a(paramIntent, 0);
        getString(2131755998);
        this.gtM = h.a(this, getString(2131765431), true, new DialogInterface.OnCancelListener()
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
    g.azz().a(138, this);
    g.azz().a(254, this);
    g.azz().a(256, this);
    g.azz().a(108, this);
    g.azz().a(255, this);
    g.aAh().azQ().add(this);
    AppMethodBeat.o(74230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74231);
    g.azz().b(138, this);
    g.azz().b(254, this);
    g.azz().b(256, this);
    g.azz().b(108, this);
    g.azz().b(255, this);
    g.aAh().azQ().remove(this);
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
    if ((paramMStorageEx != g.aAh().azQ()) || (i <= 0))
    {
      Log.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74232);
      return;
    }
    paramMStorageEx = (Integer)g.aAh().azQ().get(7, null);
    this.DcK = ((String)g.aAh().azQ().get(5, null));
    if ((paramMStorageEx != null) && ((paramMStorageEx.intValue() & 0x2) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.DcO = bool;
      this.DcQ = this.DcO;
      if (this.DcP) {
        eTh();
      }
      AppMethodBeat.o(74232);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74238);
    Log.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + paramq.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (c.jRu.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(74238);
      return;
    }
    if (paramq.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.kaJ = ((aa)paramq).bol().Lle;
        this.kaI = ((aa)paramq).bok();
        if (!Util.isNullOrNil(this.kaJ))
        {
          paramString = new com.tencent.mm.plugin.account.model.e(com.tencent.mm.plugin.account.model.e.kis, this.DcJ.getText().toString().trim());
          g.azz().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        paramString = new u(2);
        g.azz().a(paramString, 0);
        AppMethodBeat.o(74238);
        return;
      }
      if (this.gtM != null)
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      if (paramInt2 == -3)
      {
        Log.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        h.a(getContext(), getString(2131765664), null, getString(2131765665), getString(2131765663), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74229);
            paramAnonymousDialogInterface = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
            if (WeChatBrands.AppInfo.current().isMainland()) {
              paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(2131765661));
            }
            for (;;)
            {
              paramAnonymousDialogInterface.putExtra("from_unbind", true);
              SettingsModifyEmailAddrUI.this.startActivityForResult(paramAnonymousDialogInterface, 1);
              AppMethodBeat.o(74229);
              return;
              paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(2131765662));
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
        h.a(this, 2131765304, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -83)
      {
        h.a(this, 2131765301, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -84)
      {
        h.a(this, 2131765302, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (paramInt2 == -85)
      {
        h.a(this, 2131765295, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
      }
    }
    else if (paramq.getType() == 256)
    {
      c.jRu.WZ();
      if (((com.tencent.mm.plugin.account.model.e)paramq).Vj() == com.tencent.mm.plugin.account.model.e.kir)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          h.a(getContext(), 2131765370, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        if (paramInt2 == -82)
        {
          h.a(this, 2131765304, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -83)
        {
          h.a(this, 2131765301, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -84)
        {
          h.a(this, 2131765302, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -85)
        {
          h.a(this, 2131765295, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        if (paramInt2 == -86)
        {
          h.a(this, 2131765306, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        h.d(getContext(), getString(2131765369, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131755998), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(74238);
        return;
      }
      if (((com.tencent.mm.plugin.account.model.e)paramq).Vj() == com.tencent.mm.plugin.account.model.e.kis)
      {
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramInt1 = ((Integer)g.aAh().azQ().get(7, null)).intValue();
          g.aAh().azQ().set(7, Integer.valueOf(paramInt1 | 0x2));
          if (!Util.isNullOrNil(this.kaJ))
          {
            h.a(getContext(), this.kaJ, "", getString(2131755874), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(74238);
            return;
          }
          h.a(getContext(), 2131765297, 2131755998, new DialogInterface.OnClickListener()
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
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          h.a(getContext(), 2131765370, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(74238);
          return;
        }
        h.d(getContext(), getString(2131765369, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131755998), new DialogInterface.OnClickListener()
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
          paramString = new com.tencent.mm.plugin.account.model.e(com.tencent.mm.plugin.account.model.e.kis, this.DcJ.getText().toString().trim());
          g.azz().a(paramString, 0);
          AppMethodBeat.o(74238);
          return;
        }
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        h.a(getContext(), getString(2131765664), null, getString(2131765665), getString(2131765663), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74221);
            paramAnonymousDialogInterface = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
            if (WeChatBrands.AppInfo.current().isMainland()) {
              paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(2131765661));
            }
            for (;;)
            {
              paramAnonymousDialogInterface.putExtra("from_unbind", true);
              SettingsModifyEmailAddrUI.this.startActivityForResult(paramAnonymousDialogInterface, 1);
              AppMethodBeat.o(74221);
              return;
              paramAnonymousDialogInterface.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(2131765662));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI
 * JD-Core Version:    0.7.0.1
 */