package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.jy;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.model.g;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.d;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.am.h
{
  public static String PrO;
  private ProgressDialog FPA;
  private TextView PrJ;
  private Button PrK;
  private List<aah> PrL;
  private boolean PrM;
  private boolean PrN;
  private jy PrP;
  private String nag;
  private String pPi;
  private int qfX;
  
  public SettingsAliasUI()
  {
    AppMethodBeat.i(298624);
    this.PrL = null;
    this.PrP = new jy();
    AppMethodBeat.o(298624);
  }
  
  private void CI(boolean paramBoolean)
  {
    AppMethodBeat.i(298628);
    com.tencent.mm.kernel.h.aZW().a(new g(), 0);
    if (paramBoolean) {
      this.FPA = k.a(this, getString(b.i.app_loading), false, null);
    }
    AppMethodBeat.o(298628);
  }
  
  private void bYw()
  {
    AppMethodBeat.i(298633);
    switch (this.qfX)
    {
    default: 
      if (!Util.isNullOrNil(this.nag)) {
        com.tencent.mm.plugin.account.sdk.c.a.b(this, this.nag, 0, true);
      }
      break;
    }
    do
    {
      AppMethodBeat.o(298633);
      return;
      Intent localIntent = new Intent(this, VerifyPwdUI.class);
      localIntent.putExtra("key_scenen", 2);
      startActivityForResult(localIntent, 10001);
      AppMethodBeat.o(298633);
      return;
    } while (Util.isNullOrNil(this.nag));
    com.tencent.mm.plugin.account.sdk.c.a.b(this, this.nag, 10002, true);
    AppMethodBeat.o(298633);
  }
  
  private void gVD()
  {
    AppMethodBeat.i(298639);
    MMWizardActivity.aQ(this, new Intent(this, SettingsModifyAliasCheckUI.class));
    AppMethodBeat.o(298639);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_alias;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74124);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.white));
    this.PrJ = ((TextView)findViewById(b.f.settings_alias_title));
    String str2 = z.bAN();
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = z.bAM();
    }
    Log.i("MicroMsg.SettingsAliasUI", "curAlias %s", new Object[] { str1 });
    this.PrJ.setText(getString(b.i.app_field_username) + str1);
    this.PrJ.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(298772);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aYj());
        if (SettingsAliasUI.a(SettingsAliasUI.this).getText() != null)
        {
          localObject = SettingsAliasUI.a(SettingsAliasUI.this).getText().toString();
          int i = ((String)localObject).indexOf(':');
          paramAnonymousView = (View)localObject;
          if (i >= 0)
          {
            paramAnonymousView = (View)localObject;
            if (i < ((String)localObject).length()) {
              paramAnonymousView = ((String)localObject).substring(i + 1).trim();
            }
          }
          localObject = new SpannableString(SettingsAliasUI.a(SettingsAliasUI.this).getText());
          ((SpannableString)localObject).setSpan(new BackgroundColorSpan(SettingsAliasUI.this.getResources().getColor(b.c.light_blue_bg_color)), i + 1, SettingsAliasUI.a(SettingsAliasUI.this).getText().length(), 33);
          SettingsAliasUI.a(SettingsAliasUI.this).setText((CharSequence)localObject);
          localObject = new com.tencent.mm.ui.widget.b.a(SettingsAliasUI.this, SettingsAliasUI.a(SettingsAliasUI.this));
          ((com.tencent.mm.ui.widget.b.a)localObject).agjt = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(298854);
              paramAnonymous2ContextMenu.add(SettingsAliasUI.this.getString(b.i.app_copy));
              AppMethodBeat.o(298854);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(298855);
              if (paramAnonymous2Int == 0)
              {
                ClipboardHelper.setText(paramAnonymousView);
                k.cY(SettingsAliasUI.this, SettingsAliasUI.this.getString(b.i.app_copy_ok));
              }
              AppMethodBeat.o(298855);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).afLp = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(298851);
              String str2 = z.bAN();
              String str1 = str2;
              if (Util.isNullOrNil(str2)) {
                str1 = z.bAM();
              }
              SettingsAliasUI.a(SettingsAliasUI.this).setText(SettingsAliasUI.this.getString(b.i.app_field_username) + str1);
              AppMethodBeat.o(298851);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).cMz();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(298772);
        return true;
      }
    });
    this.PrK = ((Button)findViewById(b.f.settings_modify_alias_btn));
    this.PrK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(298755);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.SettingsAliasUI", "click next, allPass %s", new Object[] { Boolean.valueOf(SettingsAliasUI.b(SettingsAliasUI.this)) });
        SettingsAliasUI.c(SettingsAliasUI.this).ila = 1L;
        if (SettingsAliasUI.b(SettingsAliasUI.this))
        {
          SettingsAliasUI.c(SettingsAliasUI.this).bMH();
          SettingsAliasUI.d(SettingsAliasUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(298755);
          return;
          if ((SettingsAliasUI.e(SettingsAliasUI.this) != null) && (!SettingsAliasUI.e(SettingsAliasUI.this).isEmpty())) {
            break;
          }
          SettingsAliasUI.f(SettingsAliasUI.this);
          SettingsAliasUI.g(SettingsAliasUI.this);
        }
        int j = 0;
        int i = 0;
        label165:
        if (j < SettingsAliasUI.e(SettingsAliasUI.this).size())
        {
          if (((aah)SettingsAliasUI.e(SettingsAliasUI.this).get(j)).ZiF) {
            break label258;
          }
          if (j == 0) {
            i |= 0x1;
          }
        }
        label258:
        for (;;)
        {
          j += 1;
          break label165;
          i |= 0x2;
          continue;
          SettingsAliasUI.c(SettingsAliasUI.this).iUO = i;
          SettingsAliasUI.c(SettingsAliasUI.this).bMH();
          SettingsAliasUI.h(SettingsAliasUI.this);
          break;
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74117);
        SettingsAliasUI.c(SettingsAliasUI.this).ila = 7L;
        SettingsAliasUI.c(SettingsAliasUI.this).bMH();
        SettingsAliasUI.this.onBackPressed();
        AppMethodBeat.o(74117);
        return true;
      }
    });
    AppMethodBeat.o(74124);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(298675);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt2 == -1)
    {
      bool1 = true;
      if (paramIntent != null) {
        break label80;
      }
    }
    label80:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.SettingsAliasUI", "requestCode %d, resultCode OK %s, data == null %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramIntent != null) {
        break label86;
      }
      AppMethodBeat.o(298675);
      return;
      bool1 = false;
      break;
    }
    label86:
    Intent localIntent;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if (paramInt1 == 10001)
    {
      if (paramInt2 == -1)
      {
        localIntent = new Intent(this, SettingsModifyAliasUI.class);
        localArrayList1 = new ArrayList();
        localArrayList1.add(Integer.valueOf(1));
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2 = new ArrayList();
        localArrayList2.add(this.pPi);
        localArrayList2.add(paramIntent.getStringExtra("key_ticket"));
        localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
        localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
        MMWizardActivity.aQ(this, localIntent);
        AppMethodBeat.o(298675);
      }
    }
    else if ((paramInt1 == 10002) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.getString("result_json"))
      {
        Log.i("MicroMsg.SettingsAliasUI", "face recog, result: %s", new Object[] { paramIntent });
        if (Util.isNullOrNil(paramIntent)) {
          break label406;
        }
        try
        {
          paramIntent = new com.tencent.mm.ad.i(paramIntent).getString("ticket");
          localIntent = new Intent(this, SettingsModifyAliasUI.class);
          localArrayList1 = new ArrayList();
          localArrayList1.add(Integer.valueOf(1));
          localArrayList1.add(Integer.valueOf(3));
          localArrayList2 = new ArrayList();
          localArrayList2.add(this.pPi);
          localArrayList2.add(paramIntent);
          localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
          localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
          MMWizardActivity.aQ(this, localIntent);
          AppMethodBeat.o(298675);
          return;
        }
        catch (Exception paramIntent)
        {
          Log.e("MicroMsg.SettingsAliasUI", "jump face recog error, %s", new Object[] { paramIntent.getMessage() });
        }
      }
    }
    label406:
    AppMethodBeat.o(298675);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74121);
    super.onCreate(paramBundle);
    d.kn(null);
    PrO = "set_alias_" + System.currentTimeMillis();
    this.PrP.sq(PrO);
    initView();
    Log.i("MicroMsg.SettingsAliasUI", "root class %s", new Object[] { getIntent().getStringExtra("WizardRootClass") });
    com.tencent.mm.kernel.h.aZW().a(926, this);
    CI(false);
    if (com.tencent.mm.k.i.aRC().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(74121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74123);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(926, this);
    AppMethodBeat.o(74123);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(74125);
    Log.i("MicroMsg.SettingsAliasUI", "errType %d, errCode %d, errMsg %s, doubleCheck %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(this.PrN) });
    if (this.FPA != null) {
      this.FPA.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.PrL = ((aag)c.c.b(((g)paramp).oDw.otC)).ZiE;
      Log.i("MicroMsg.SettingsAliasUI", "conditions %d", new Object[] { Integer.valueOf(this.PrL.size()) });
      this.qfX = ((aag)c.c.b(((g)paramp).oDw.otC)).qfX;
      this.nag = ((aag)c.c.b(((g)paramp).oDw.otC)).nag;
      this.pPi = ((aag)c.c.b(((g)paramp).oDw.otC)).hFb;
      if ((this.PrL != null) && (!this.PrL.isEmpty()))
      {
        this.PrM = true;
        d.kn(this.PrL);
        paramString = this.PrL.iterator();
        if (paramString.hasNext())
        {
          paramp = (aah)paramString.next();
          if ((this.PrM) && (paramp.ZiF)) {}
          for (boolean bool = true;; bool = false)
          {
            this.PrM = bool;
            break;
          }
        }
        Log.i("MicroMsg.SettingsAliasUI", "onSceneEnd, allPass %s", new Object[] { Boolean.valueOf(this.PrM) });
        if (this.PrN)
        {
          if (!this.PrM)
          {
            gVD();
            AppMethodBeat.o(74125);
            return;
          }
          bYw();
          AppMethodBeat.o(74125);
        }
      }
      else
      {
        Toast.makeText(this, getString(b.i.app_err_server_busy_tip), 0).show();
        AppMethodBeat.o(74125);
      }
    }
    else
    {
      Toast.makeText(this, getString(b.i.app_err_system_busy_tip), 0).show();
    }
    AppMethodBeat.o(74125);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI
 * JD-Core Version:    0.7.0.1
 */