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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.i
{
  public static String Dbv;
  private TextView Dbq;
  private Button Dbr;
  private List<ye> Dbs;
  private boolean Dbt;
  private boolean Dbu;
  private gc Dbw;
  private String hJl;
  private int kqW;
  private ProgressDialog vIA;
  private String wZz;
  
  public SettingsAliasUI()
  {
    AppMethodBeat.i(256516);
    this.Dbs = null;
    this.Dbw = new gc();
    AppMethodBeat.o(256516);
  }
  
  private void bpv()
  {
    AppMethodBeat.i(256518);
    switch (this.kqW)
    {
    default: 
      if (!Util.isNullOrNil(this.hJl)) {
        com.tencent.mm.plugin.account.a.b.a.b(this, this.hJl, 0, true);
      }
      break;
    }
    do
    {
      AppMethodBeat.o(256518);
      return;
      Intent localIntent = new Intent(this, VerifyPwdUI.class);
      localIntent.putExtra("key_scenen", 2);
      startActivityForResult(localIntent, 10001);
      AppMethodBeat.o(256518);
      return;
    } while (Util.isNullOrNil(this.hJl));
    com.tencent.mm.plugin.account.a.b.a.b(this, this.hJl, 10002, true);
    AppMethodBeat.o(256518);
  }
  
  private void eTd()
  {
    AppMethodBeat.i(256519);
    MMWizardActivity.ay(this, new Intent(this, SettingsModifyAliasCheckUI.class));
    AppMethodBeat.o(256519);
  }
  
  private void us(boolean paramBoolean)
  {
    AppMethodBeat.i(256517);
    com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.account.model.g(), 0);
    if (paramBoolean) {
      this.vIA = com.tencent.mm.ui.base.h.a(this, getString(2131755886), false, null);
    }
    AppMethodBeat.o(256517);
  }
  
  public int getLayoutId()
  {
    return 2131496245;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74124);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.Dbq = ((TextView)findViewById(2131307688));
    String str2 = z.aTZ();
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = z.aTY();
    }
    Log.i("MicroMsg.SettingsAliasUI", "curAlias %s", new Object[] { str1 });
    this.Dbq.setText(getString(2131755837) + str1);
    this.Dbq.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(256514);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
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
          ((SpannableString)localObject).setSpan(new BackgroundColorSpan(SettingsAliasUI.this.getResources().getColor(2131100677)), i + 1, SettingsAliasUI.a(SettingsAliasUI.this).getText().length(), 33);
          SettingsAliasUI.a(SettingsAliasUI.this).setText((CharSequence)localObject);
          localObject = new com.tencent.mm.ui.widget.b.a(SettingsAliasUI.this, SettingsAliasUI.a(SettingsAliasUI.this));
          ((com.tencent.mm.ui.widget.b.a)localObject).QSs = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(256511);
              paramAnonymous2ContextMenu.add(SettingsAliasUI.this.getString(2131755772));
              AppMethodBeat.o(256511);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(256512);
              if (paramAnonymous2Int == 0)
              {
                ClipboardHelper.setText(paramAnonymousView);
                com.tencent.mm.ui.base.h.cC(SettingsAliasUI.this, SettingsAliasUI.this.getString(2131755773));
              }
              AppMethodBeat.o(256512);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).QwU = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(256513);
              String str2 = z.aTZ();
              String str1 = str2;
              if (Util.isNullOrNil(str2)) {
                str1 = z.aTY();
              }
              SettingsAliasUI.a(SettingsAliasUI.this).setText(SettingsAliasUI.this.getString(2131755837) + str1);
              AppMethodBeat.o(256513);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).ez(0, 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(256514);
        return true;
      }
    });
    this.Dbr = ((Button)findViewById(2131307709));
    this.Dbr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256515);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.SettingsAliasUI", "click next, allPass %s", new Object[] { Boolean.valueOf(SettingsAliasUI.b(SettingsAliasUI.this)) });
        SettingsAliasUI.c(SettingsAliasUI.this).ejW = 1L;
        if (SettingsAliasUI.b(SettingsAliasUI.this))
        {
          SettingsAliasUI.c(SettingsAliasUI.this).bfK();
          SettingsAliasUI.d(SettingsAliasUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256515);
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
          if (((ye)SettingsAliasUI.e(SettingsAliasUI.this).get(j)).Lje) {
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
          SettingsAliasUI.c(SettingsAliasUI.this).eIu = i;
          SettingsAliasUI.c(SettingsAliasUI.this).bfK();
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
        SettingsAliasUI.c(SettingsAliasUI.this).ejW = 7L;
        SettingsAliasUI.c(SettingsAliasUI.this).bfK();
        SettingsAliasUI.this.onBackPressed();
        AppMethodBeat.o(74117);
        return true;
      }
    });
    AppMethodBeat.o(74124);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256520);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt2 == -1)
    {
      bool1 = true;
      if (paramIntent != null) {
        break label78;
      }
    }
    label78:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.SettingsAliasUI", "requestCode %d, resultCode OK %s, data == null %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramIntent != null) {
        break label84;
      }
      AppMethodBeat.o(256520);
      return;
      bool1 = false;
      break;
    }
    label84:
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
        localArrayList2.add(this.wZz);
        localArrayList2.add(paramIntent.getStringExtra("key_ticket"));
        localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
        localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
        MMWizardActivity.ay(this, localIntent);
        AppMethodBeat.o(256520);
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
          break label402;
        }
        try
        {
          paramIntent = new com.tencent.mm.ab.i(paramIntent).getString("ticket");
          localIntent = new Intent(this, SettingsModifyAliasUI.class);
          localArrayList1 = new ArrayList();
          localArrayList1.add(Integer.valueOf(1));
          localArrayList1.add(Integer.valueOf(3));
          localArrayList2 = new ArrayList();
          localArrayList2.add(this.wZz);
          localArrayList2.add(paramIntent);
          localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
          localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
          MMWizardActivity.ay(this, localIntent);
          AppMethodBeat.o(256520);
          return;
        }
        catch (Exception paramIntent)
        {
          Log.e("MicroMsg.SettingsAliasUI", "jump face recog error, %s", new Object[] { paramIntent.getMessage() });
        }
      }
    }
    label402:
    AppMethodBeat.o(256520);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74121);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.setting.d.gF(null);
    Dbv = "set_alias_" + System.currentTimeMillis();
    this.Dbw.tm(Dbv);
    initView();
    Log.i("MicroMsg.SettingsAliasUI", "root class %s", new Object[] { getIntent().getStringExtra("WizardRootClass") });
    com.tencent.mm.kernel.g.azz().a(926, this);
    us(false);
    if (com.tencent.mm.n.h.aqJ().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(74121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74123);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(926, this);
    AppMethodBeat.o(74123);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74125);
    Log.i("MicroMsg.SettingsAliasUI", "errType %d, errCode %d, errMsg %s, doubleCheck %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(this.Dbu) });
    if (this.vIA != null) {
      this.vIA.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.Dbs = ((yd)((com.tencent.mm.plugin.account.model.g)paramq).iUB.iLL.iLR).Ljd;
      Log.i("MicroMsg.SettingsAliasUI", "conditions %d", new Object[] { Integer.valueOf(this.Dbs.size()) });
      this.kqW = ((yd)((com.tencent.mm.plugin.account.model.g)paramq).iUB.iLL.iLR).kqW;
      this.hJl = ((yd)((com.tencent.mm.plugin.account.model.g)paramq).iUB.iLL.iLR).hJl;
      this.wZz = ((yd)((com.tencent.mm.plugin.account.model.g)paramq).iUB.iLL.iLR).dHx;
      if ((this.Dbs != null) && (!this.Dbs.isEmpty()))
      {
        this.Dbt = true;
        com.tencent.mm.plugin.setting.d.gF(this.Dbs);
        paramString = this.Dbs.iterator();
        if (paramString.hasNext())
        {
          paramq = (ye)paramString.next();
          if ((this.Dbt) && (paramq.Lje)) {}
          for (boolean bool = true;; bool = false)
          {
            this.Dbt = bool;
            break;
          }
        }
        Log.i("MicroMsg.SettingsAliasUI", "onSceneEnd, allPass %s", new Object[] { Boolean.valueOf(this.Dbt) });
        if (this.Dbu)
        {
          if (!this.Dbt)
          {
            eTd();
            AppMethodBeat.o(74125);
            return;
          }
          bpv();
          AppMethodBeat.o(74125);
        }
      }
      else
      {
        Toast.makeText(this, getString(2131755803), 0).show();
        AppMethodBeat.o(74125);
      }
    }
    else
    {
      Toast.makeText(this, getString(2131755804), 0).show();
    }
    AppMethodBeat.o(74125);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI
 * JD-Core Version:    0.7.0.1
 */