package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.hv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.account.model.g;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.an.i
{
  public static String JgW;
  private ProgressDialog Apv;
  private String BLy;
  private TextView JgR;
  private Button JgS;
  private List<yk> JgT;
  private boolean JgU;
  private boolean JgV;
  private hv JgX;
  private String kwF;
  private int niJ;
  
  public SettingsAliasUI()
  {
    AppMethodBeat.i(263359);
    this.JgT = null;
    this.JgX = new hv();
    AppMethodBeat.o(263359);
  }
  
  private void bzH()
  {
    AppMethodBeat.i(263368);
    switch (this.niJ)
    {
    default: 
      if (!Util.isNullOrNil(this.kwF)) {
        com.tencent.mm.plugin.account.sdk.b.a.b(this, this.kwF, 0, true);
      }
      break;
    }
    do
    {
      AppMethodBeat.o(263368);
      return;
      Intent localIntent = new Intent(this, VerifyPwdUI.class);
      localIntent.putExtra("key_scenen", 2);
      startActivityForResult(localIntent, 10001);
      AppMethodBeat.o(263368);
      return;
    } while (Util.isNullOrNil(this.kwF));
    com.tencent.mm.plugin.account.sdk.b.a.b(this, this.kwF, 10002, true);
    AppMethodBeat.o(263368);
  }
  
  private void fGh()
  {
    AppMethodBeat.i(263369);
    MMWizardActivity.aH(this, new Intent(this, SettingsModifyAliasCheckUI.class));
    AppMethodBeat.o(263369);
  }
  
  private void xQ(boolean paramBoolean)
  {
    AppMethodBeat.i(263366);
    com.tencent.mm.kernel.h.aGY().a(new g(), 0);
    if (paramBoolean) {
      this.Apv = com.tencent.mm.ui.base.h.a(this, getString(b.i.app_loading), false, null);
    }
    AppMethodBeat.o(263366);
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
    this.JgR = ((TextView)findViewById(b.f.settings_alias_title));
    String str2 = z.bda();
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = z.bcZ();
    }
    Log.i("MicroMsg.SettingsAliasUI", "curAlias %s", new Object[] { str1 });
    this.JgR.setText(getString(b.i.app_field_username) + str1);
    this.JgR.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(264306);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
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
          ((com.tencent.mm.ui.widget.b.a)localObject).Yrf = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(263815);
              paramAnonymous2ContextMenu.add(SettingsAliasUI.this.getString(b.i.app_copy));
              AppMethodBeat.o(263815);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(263885);
              if (paramAnonymous2Int == 0)
              {
                ClipboardHelper.setText(paramAnonymousView);
                com.tencent.mm.ui.base.h.cN(SettingsAliasUI.this, SettingsAliasUI.this.getString(b.i.app_copy_ok));
              }
              AppMethodBeat.o(263885);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).XVa = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(264190);
              String str2 = z.bda();
              String str1 = str2;
              if (Util.isNullOrNil(str2)) {
                str1 = z.bcZ();
              }
              SettingsAliasUI.a(SettingsAliasUI.this).setText(SettingsAliasUI.this.getString(b.i.app_field_username) + str1);
              AppMethodBeat.o(264190);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).eY(0, 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(264306);
        return true;
      }
    });
    this.JgS = ((Button)findViewById(b.f.settings_modify_alias_btn));
    this.JgS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264809);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.SettingsAliasUI", "click next, allPass %s", new Object[] { Boolean.valueOf(SettingsAliasUI.b(SettingsAliasUI.this)) });
        SettingsAliasUI.c(SettingsAliasUI.this).geB = 1L;
        if (SettingsAliasUI.b(SettingsAliasUI.this))
        {
          SettingsAliasUI.c(SettingsAliasUI.this).bpa();
          SettingsAliasUI.d(SettingsAliasUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(264809);
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
          if (((yk)SettingsAliasUI.e(SettingsAliasUI.this).get(j)).Skv) {
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
          SettingsAliasUI.c(SettingsAliasUI.this).gGS = i;
          SettingsAliasUI.c(SettingsAliasUI.this).bpa();
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
        SettingsAliasUI.c(SettingsAliasUI.this).geB = 7L;
        SettingsAliasUI.c(SettingsAliasUI.this).bpa();
        SettingsAliasUI.this.onBackPressed();
        AppMethodBeat.o(74117);
        return true;
      }
    });
    AppMethodBeat.o(74124);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(263373);
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
      AppMethodBeat.o(263373);
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
        localArrayList2.add(this.BLy);
        localArrayList2.add(paramIntent.getStringExtra("key_ticket"));
        localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
        localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
        MMWizardActivity.aH(this, localIntent);
        AppMethodBeat.o(263373);
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
          localArrayList2.add(this.BLy);
          localArrayList2.add(paramIntent);
          localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
          localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
          MMWizardActivity.aH(this, localIntent);
          AppMethodBeat.o(263373);
          return;
        }
        catch (Exception paramIntent)
        {
          Log.e("MicroMsg.SettingsAliasUI", "jump face recog error, %s", new Object[] { paramIntent.getMessage() });
        }
      }
    }
    label406:
    AppMethodBeat.o(263373);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74121);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.setting.d.hl(null);
    JgW = "set_alias_" + System.currentTimeMillis();
    this.JgX.xd(JgW);
    initView();
    Log.i("MicroMsg.SettingsAliasUI", "root class %s", new Object[] { getIntent().getStringExtra("WizardRootClass") });
    com.tencent.mm.kernel.h.aGY().a(926, this);
    xQ(false);
    if (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(74121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74123);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(926, this);
    AppMethodBeat.o(74123);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74125);
    Log.i("MicroMsg.SettingsAliasUI", "errType %d, errCode %d, errMsg %s, doubleCheck %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(this.JgV) });
    if (this.Apv != null) {
      this.Apv.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.JgT = ((yj)d.c.b(((g)paramq).lKU.lBS)).Sku;
      Log.i("MicroMsg.SettingsAliasUI", "conditions %d", new Object[] { Integer.valueOf(this.JgT.size()) });
      this.niJ = ((yj)d.c.b(((g)paramq).lKU.lBS)).niJ;
      this.kwF = ((yj)d.c.b(((g)paramq).lKU.lBS)).kwF;
      this.BLy = ((yj)d.c.b(((g)paramq).lKU.lBS)).fAo;
      if ((this.JgT != null) && (!this.JgT.isEmpty()))
      {
        this.JgU = true;
        com.tencent.mm.plugin.setting.d.hl(this.JgT);
        paramString = this.JgT.iterator();
        if (paramString.hasNext())
        {
          paramq = (yk)paramString.next();
          if ((this.JgU) && (paramq.Skv)) {}
          for (boolean bool = true;; bool = false)
          {
            this.JgU = bool;
            break;
          }
        }
        Log.i("MicroMsg.SettingsAliasUI", "onSceneEnd, allPass %s", new Object[] { Boolean.valueOf(this.JgU) });
        if (this.JgV)
        {
          if (!this.JgU)
          {
            fGh();
            AppMethodBeat.o(74125);
            return;
          }
          bzH();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI
 * JD-Core Version:    0.7.0.1
 */