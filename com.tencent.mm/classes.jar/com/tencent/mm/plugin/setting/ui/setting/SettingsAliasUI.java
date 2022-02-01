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
import com.tencent.mm.ac.i;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.m.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.account.model.f;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.al.g
{
  public static String wgy;
  private String ivl;
  private int iwC;
  private ProgressDialog qLE;
  private String rso;
  private TextView wgt;
  private Button wgu;
  private List<ui> wgv;
  private boolean wgw;
  private boolean wgx;
  private bd wgz;
  
  public SettingsAliasUI()
  {
    AppMethodBeat.i(186539);
    this.wgv = null;
    this.wgz = new bd();
    AppMethodBeat.o(186539);
  }
  
  private void aKg()
  {
    AppMethodBeat.i(186541);
    switch (this.iwC)
    {
    default: 
      if (!bt.isNullOrNil(this.ivl)) {
        a.b(this, this.ivl, 0, true);
      }
      break;
    }
    do
    {
      AppMethodBeat.o(186541);
      return;
      Intent localIntent = new Intent(this, VerifyPwdUI.class);
      localIntent.putExtra("key_scenen", 2);
      startActivityForResult(localIntent, 10001);
      AppMethodBeat.o(186541);
      return;
    } while (bt.isNullOrNil(this.ivl));
    a.b(this, this.ivl, 10002, true);
    AppMethodBeat.o(186541);
  }
  
  private void dnU()
  {
    AppMethodBeat.i(186542);
    MMWizardActivity.V(this, new Intent(this, SettingsModifyAliasCheckUI.class));
    AppMethodBeat.o(186542);
  }
  
  private void pp(boolean paramBoolean)
  {
    AppMethodBeat.i(186540);
    com.tencent.mm.kernel.g.aeS().a(new f(), 0);
    if (paramBoolean) {
      this.qLE = h.b(this, getString(2131755804), false, null);
    }
    AppMethodBeat.o(186540);
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
    this.wgt = ((TextView)findViewById(2131304635));
    String str2 = u.aqH();
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = u.aqG();
    }
    ad.i("MicroMsg.SettingsAliasUI", "curAlias %s", new Object[] { str1 });
    this.wgt.setText(getString(2131755760) + str1);
    this.wgu = ((Button)findViewById(2131304656));
    this.wgu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186538);
        ad.i("MicroMsg.SettingsAliasUI", "click next, allPass %s", new Object[] { Boolean.valueOf(SettingsAliasUI.a(SettingsAliasUI.this)) });
        SettingsAliasUI.b(SettingsAliasUI.this).dFf = 1L;
        if (SettingsAliasUI.a(SettingsAliasUI.this))
        {
          SettingsAliasUI.b(SettingsAliasUI.this).aBj();
          SettingsAliasUI.c(SettingsAliasUI.this);
          AppMethodBeat.o(186538);
          return;
        }
        if ((SettingsAliasUI.d(SettingsAliasUI.this) == null) || (SettingsAliasUI.d(SettingsAliasUI.this).isEmpty()))
        {
          SettingsAliasUI.e(SettingsAliasUI.this);
          SettingsAliasUI.f(SettingsAliasUI.this);
          AppMethodBeat.o(186538);
          return;
        }
        int j = 0;
        int k = 0;
        if (j < SettingsAliasUI.d(SettingsAliasUI.this).size())
        {
          int i = k;
          if (!((ui)SettingsAliasUI.d(SettingsAliasUI.this).get(j)).CVZ) {
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
        SettingsAliasUI.b(SettingsAliasUI.this).dOw = k;
        SettingsAliasUI.b(SettingsAliasUI.this).aBj();
        SettingsAliasUI.g(SettingsAliasUI.this);
        AppMethodBeat.o(186538);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74115);
        SettingsAliasUI.b(SettingsAliasUI.this).dFf = 7L;
        SettingsAliasUI.b(SettingsAliasUI.this).aBj();
        SettingsAliasUI.this.onBackPressed();
        AppMethodBeat.o(74115);
        return true;
      }
    });
    AppMethodBeat.o(74124);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(186543);
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
      ad.i("MicroMsg.SettingsAliasUI", "requestCode %d, resultCode OK %s, data == null %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramIntent != null) {
        break label83;
      }
      AppMethodBeat.o(186543);
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
        localArrayList2.add(this.rso);
        localArrayList2.add(paramIntent.getStringExtra("key_ticket"));
        localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
        localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
        MMWizardActivity.V(this, localIntent);
        AppMethodBeat.o(186543);
      }
    }
    else if ((paramInt1 == 10002) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.getString("result_json"))
      {
        ad.i("MicroMsg.SettingsAliasUI", "face recog, result: %s", new Object[] { paramIntent });
        if (bt.isNullOrNil(paramIntent)) {
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
          localArrayList2.add(this.rso);
          localArrayList2.add(paramIntent);
          localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
          localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
          MMWizardActivity.V(this, localIntent);
          AppMethodBeat.o(186543);
          return;
        }
        catch (Exception paramIntent)
        {
          ad.e("MicroMsg.SettingsAliasUI", "jump face recog error, %s", new Object[] { paramIntent.getMessage() });
        }
      }
    }
    label401:
    AppMethodBeat.o(186543);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74121);
    super.onCreate(paramBundle);
    c.fd(null);
    wgy = "set_alias_" + System.currentTimeMillis();
    this.wgz.hY(wgy);
    initView();
    ad.i("MicroMsg.SettingsAliasUI", "root class %s", new Object[] { getIntent().getStringExtra("WizardRootClass") });
    com.tencent.mm.kernel.g.aeS().a(926, this);
    pp(false);
    if (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(74121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74123);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(926, this);
    AppMethodBeat.o(74123);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74125);
    ad.i("MicroMsg.SettingsAliasUI", "errType %d, errCode %d, errMsg %s, doubleCheck %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(this.wgx) });
    if (this.qLE != null) {
      this.qLE.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.wgv = ((uh)((f)paramn).hdD.gUT.gUX).CVY;
      ad.i("MicroMsg.SettingsAliasUI", "conditions %d", new Object[] { Integer.valueOf(this.wgv.size()) });
      this.iwC = ((uh)((f)paramn).hdD.gUT.gUX).iwC;
      this.ivl = ((uh)((f)paramn).hdD.gUT.gUX).ivl;
      this.rso = ((uh)((f)paramn).hdD.gUT.gUX).dgo;
      if ((this.wgv != null) && (!this.wgv.isEmpty()))
      {
        this.wgw = true;
        c.fd(this.wgv);
        paramString = this.wgv.iterator();
        if (paramString.hasNext())
        {
          paramn = (ui)paramString.next();
          if ((this.wgw) && (paramn.CVZ)) {}
          for (boolean bool = true;; bool = false)
          {
            this.wgw = bool;
            break;
          }
        }
        ad.i("MicroMsg.SettingsAliasUI", "onSceneEnd, allPass %s", new Object[] { Boolean.valueOf(this.wgw) });
        if (this.wgx)
        {
          if (!this.wgw)
          {
            dnU();
            AppMethodBeat.o(74125);
            return;
          }
          aKg();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI
 * JD-Core Version:    0.7.0.1
 */