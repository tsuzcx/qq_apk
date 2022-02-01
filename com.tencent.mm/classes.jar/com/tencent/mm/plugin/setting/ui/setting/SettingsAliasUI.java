package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.m.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.account.model.f;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.g
{
  public static String xrO;
  private String guM;
  private int iWF;
  private ProgressDialog rGq;
  private String sBi;
  private TextView xrJ;
  private Button xrK;
  private List<us> xrL;
  private boolean xrM;
  private boolean xrN;
  private cp xrP;
  
  public SettingsAliasUI()
  {
    AppMethodBeat.i(191005);
    this.xrL = null;
    this.xrP = new cp();
    AppMethodBeat.o(191005);
  }
  
  private void aQX()
  {
    AppMethodBeat.i(191007);
    switch (this.iWF)
    {
    default: 
      if (!bs.isNullOrNil(this.guM)) {
        a.b(this, this.guM, 0, true);
      }
      break;
    }
    do
    {
      AppMethodBeat.o(191007);
      return;
      Intent localIntent = new Intent(this, VerifyPwdUI.class);
      localIntent.putExtra("key_scenen", 2);
      startActivityForResult(localIntent, 10001);
      AppMethodBeat.o(191007);
      return;
    } while (bs.isNullOrNil(this.guM));
    a.b(this, this.guM, 10002, true);
    AppMethodBeat.o(191007);
  }
  
  private void dCc()
  {
    AppMethodBeat.i(191008);
    MMWizardActivity.aj(this, new Intent(this, SettingsModifyAliasCheckUI.class));
    AppMethodBeat.o(191008);
  }
  
  private void qo(boolean paramBoolean)
  {
    AppMethodBeat.i(191006);
    com.tencent.mm.kernel.g.agi().a(new f(), 0);
    if (paramBoolean) {
      this.rGq = h.b(this, getString(2131755804), false, null);
    }
    AppMethodBeat.o(191006);
  }
  
  public int getLayoutId()
  {
    return 2131495384;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74124);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.xrJ = ((TextView)findViewById(2131304635));
    String str2 = u.axx();
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = u.axw();
    }
    ac.i("MicroMsg.SettingsAliasUI", "curAlias %s", new Object[] { str1 });
    this.xrJ.setText(getString(2131755760) + str1);
    this.xrK = ((Button)findViewById(2131304656));
    this.xrK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191004);
        ac.i("MicroMsg.SettingsAliasUI", "click next, allPass %s", new Object[] { Boolean.valueOf(SettingsAliasUI.a(SettingsAliasUI.this)) });
        SettingsAliasUI.b(SettingsAliasUI.this).dCS = 1L;
        if (SettingsAliasUI.a(SettingsAliasUI.this))
        {
          SettingsAliasUI.b(SettingsAliasUI.this).aHZ();
          SettingsAliasUI.c(SettingsAliasUI.this);
          AppMethodBeat.o(191004);
          return;
        }
        if ((SettingsAliasUI.d(SettingsAliasUI.this) == null) || (SettingsAliasUI.d(SettingsAliasUI.this).isEmpty()))
        {
          SettingsAliasUI.e(SettingsAliasUI.this);
          SettingsAliasUI.f(SettingsAliasUI.this);
          AppMethodBeat.o(191004);
          return;
        }
        int j = 0;
        int k = 0;
        if (j < SettingsAliasUI.d(SettingsAliasUI.this).size())
        {
          int i = k;
          if (!((us)SettingsAliasUI.d(SettingsAliasUI.this).get(j)).EoI) {
            if (j != 0) {
              break label185;
            }
          }
          label185:
          for (i = k | 0x1;; i = k | 0x2)
          {
            j += 1;
            k = i;
            break;
          }
        }
        SettingsAliasUI.b(SettingsAliasUI.this).dPX = k;
        SettingsAliasUI.b(SettingsAliasUI.this).aHZ();
        SettingsAliasUI.g(SettingsAliasUI.this);
        AppMethodBeat.o(191004);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74115);
        SettingsAliasUI.b(SettingsAliasUI.this).dCS = 7L;
        SettingsAliasUI.b(SettingsAliasUI.this).aHZ();
        SettingsAliasUI.this.onBackPressed();
        AppMethodBeat.o(74115);
        return true;
      }
    });
    AppMethodBeat.o(74124);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(191009);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt2 == -1)
    {
      bool1 = true;
      if (paramIntent != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool2 = true;; bool2 = false)
    {
      ac.i("MicroMsg.SettingsAliasUI", "requestCode %d, resultCode OK %s, data == null %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramIntent != null) {
        break label83;
      }
      AppMethodBeat.o(191009);
      return;
      bool1 = false;
      break;
    }
    label83:
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
        localArrayList2.add(this.sBi);
        localArrayList2.add(paramIntent.getStringExtra("key_ticket"));
        localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
        localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
        MMWizardActivity.aj(this, localIntent);
        AppMethodBeat.o(191009);
      }
    }
    else if ((paramInt1 == 10002) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.getString("result_json"))
      {
        ac.i("MicroMsg.SettingsAliasUI", "face recog, result: %s", new Object[] { paramIntent });
        if (bs.isNullOrNil(paramIntent)) {
          break label401;
        }
        try
        {
          paramIntent = new i(paramIntent).getString("ticket");
          localIntent = new Intent(this, SettingsModifyAliasUI.class);
          localArrayList1 = new ArrayList();
          localArrayList1.add(Integer.valueOf(1));
          localArrayList1.add(Integer.valueOf(3));
          localArrayList2 = new ArrayList();
          localArrayList2.add(this.sBi);
          localArrayList2.add(paramIntent);
          localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
          localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
          MMWizardActivity.aj(this, localIntent);
          AppMethodBeat.o(191009);
          return;
        }
        catch (Exception paramIntent)
        {
          ac.e("MicroMsg.SettingsAliasUI", "jump face recog error, %s", new Object[] { paramIntent.getMessage() });
        }
      }
    }
    label401:
    AppMethodBeat.o(191009);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74121);
    super.onCreate(paramBundle);
    c.fl(null);
    xrO = "set_alias_" + System.currentTimeMillis();
    this.xrP.kA(xrO);
    initView();
    ac.i("MicroMsg.SettingsAliasUI", "root class %s", new Object[] { getIntent().getStringExtra("WizardRootClass") });
    com.tencent.mm.kernel.g.agi().a(926, this);
    qo(false);
    if (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(74121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74123);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(926, this);
    AppMethodBeat.o(74123);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74125);
    ac.i("MicroMsg.SettingsAliasUI", "errType %d, errCode %d, errMsg %s, doubleCheck %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(this.xrN) });
    if (this.rGq != null) {
      this.rGq.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.xrL = ((ur)((f)paramn).hEg.hvs.hvw).EoH;
      ac.i("MicroMsg.SettingsAliasUI", "conditions %d", new Object[] { Integer.valueOf(this.xrL.size()) });
      this.iWF = ((ur)((f)paramn).hEg.hvs.hvw).iWF;
      this.guM = ((ur)((f)paramn).hEg.hvs.hvw).guM;
      this.sBi = ((ur)((f)paramn).hEg.hvs.hvw).ddJ;
      if ((this.xrL != null) && (!this.xrL.isEmpty()))
      {
        this.xrM = true;
        c.fl(this.xrL);
        paramString = this.xrL.iterator();
        if (paramString.hasNext())
        {
          paramn = (us)paramString.next();
          if ((this.xrM) && (paramn.EoI)) {}
          for (boolean bool = true;; bool = false)
          {
            this.xrM = bool;
            break;
          }
        }
        ac.i("MicroMsg.SettingsAliasUI", "onSceneEnd, allPass %s", new Object[] { Boolean.valueOf(this.xrM) });
        if (this.xrN)
        {
          if (!this.xrM)
          {
            dCc();
            AppMethodBeat.o(74125);
            return;
          }
          aQX();
          AppMethodBeat.o(74125);
        }
      }
      else
      {
        Toast.makeText(this, getString(2131755732), 0).show();
        AppMethodBeat.o(74125);
      }
    }
    else
    {
      Toast.makeText(this, getString(2131755733), 0).show();
    }
    AppMethodBeat.o(74125);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI
 * JD-Core Version:    0.7.0.1
 */