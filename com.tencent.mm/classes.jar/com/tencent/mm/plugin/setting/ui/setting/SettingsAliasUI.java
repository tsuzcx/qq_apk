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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.model.u;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.al.f
{
  public static String yGx;
  private String gOx;
  private int jpO;
  private ProgressDialog sBI;
  private String txJ;
  private TextView yGs;
  private Button yGt;
  private List<wr> yGu;
  private boolean yGv;
  private boolean yGw;
  private dh yGy;
  
  public SettingsAliasUI()
  {
    AppMethodBeat.i(220972);
    this.yGu = null;
    this.yGy = new dh();
    AppMethodBeat.o(220972);
  }
  
  private void aUj()
  {
    AppMethodBeat.i(220974);
    switch (this.jpO)
    {
    default: 
      if (!bt.isNullOrNil(this.gOx)) {
        com.tencent.mm.plugin.account.a.b.a.b(this, this.gOx, 0, true);
      }
      break;
    }
    do
    {
      AppMethodBeat.o(220974);
      return;
      Intent localIntent = new Intent(this, VerifyPwdUI.class);
      localIntent.putExtra("key_scenen", 2);
      startActivityForResult(localIntent, 10001);
      AppMethodBeat.o(220974);
      return;
    } while (bt.isNullOrNil(this.gOx));
    com.tencent.mm.plugin.account.a.b.a.b(this, this.gOx, 10002, true);
    AppMethodBeat.o(220974);
  }
  
  private void dNF()
  {
    AppMethodBeat.i(220975);
    MMWizardActivity.al(this, new Intent(this, SettingsModifyAliasCheckUI.class));
    AppMethodBeat.o(220975);
  }
  
  private void qQ(boolean paramBoolean)
  {
    AppMethodBeat.i(220973);
    com.tencent.mm.kernel.g.aiU().a(new com.tencent.mm.plugin.account.model.f(), 0);
    if (paramBoolean) {
      this.sBI = h.b(this, getString(2131755804), false, null);
    }
    AppMethodBeat.o(220973);
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
    this.yGs = ((TextView)findViewById(2131304635));
    String str2 = u.aAn();
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = u.aAm();
    }
    ad.i("MicroMsg.SettingsAliasUI", "curAlias %s", new Object[] { str1 });
    this.yGs.setText(getString(2131755760) + str1);
    this.yGt = ((Button)findViewById(2131304656));
    this.yGt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220971);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.SettingsAliasUI", "click next, allPass %s", new Object[] { Boolean.valueOf(SettingsAliasUI.a(SettingsAliasUI.this)) });
        SettingsAliasUI.b(SettingsAliasUI.this).dPH = 1L;
        if (SettingsAliasUI.a(SettingsAliasUI.this))
        {
          SettingsAliasUI.b(SettingsAliasUI.this).aLk();
          SettingsAliasUI.c(SettingsAliasUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220971);
          return;
          if ((SettingsAliasUI.d(SettingsAliasUI.this) != null) && (!SettingsAliasUI.d(SettingsAliasUI.this).isEmpty())) {
            break;
          }
          SettingsAliasUI.e(SettingsAliasUI.this);
          SettingsAliasUI.f(SettingsAliasUI.this);
        }
        int j = 0;
        int i = 0;
        label165:
        if (j < SettingsAliasUI.d(SettingsAliasUI.this).size())
        {
          if (((wr)SettingsAliasUI.d(SettingsAliasUI.this).get(j)).FVU) {
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
          SettingsAliasUI.b(SettingsAliasUI.this).efl = i;
          SettingsAliasUI.b(SettingsAliasUI.this).aLk();
          SettingsAliasUI.g(SettingsAliasUI.this);
          break;
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74115);
        SettingsAliasUI.b(SettingsAliasUI.this).dPH = 7L;
        SettingsAliasUI.b(SettingsAliasUI.this).aLk();
        SettingsAliasUI.this.onBackPressed();
        AppMethodBeat.o(74115);
        return true;
      }
    });
    AppMethodBeat.o(74124);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(220976);
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
      AppMethodBeat.o(220976);
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
        localArrayList2.add(this.txJ);
        localArrayList2.add(paramIntent.getStringExtra("key_ticket"));
        localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
        localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
        MMWizardActivity.al(this, localIntent);
        AppMethodBeat.o(220976);
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
          localArrayList2.add(this.txJ);
          localArrayList2.add(paramIntent);
          localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
          localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
          MMWizardActivity.al(this, localIntent);
          AppMethodBeat.o(220976);
          return;
        }
        catch (Exception paramIntent)
        {
          ad.e("MicroMsg.SettingsAliasUI", "jump face recog error, %s", new Object[] { paramIntent.getMessage() });
        }
      }
    }
    label401:
    AppMethodBeat.o(220976);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74121);
    super.onCreate(paramBundle);
    c.fy(null);
    yGx = "set_alias_" + System.currentTimeMillis();
    this.yGy.mw(yGx);
    initView();
    ad.i("MicroMsg.SettingsAliasUI", "root class %s", new Object[] { getIntent().getStringExtra("WizardRootClass") });
    com.tencent.mm.kernel.g.aiU().a(926, this);
    qQ(false);
    if (com.tencent.mm.n.g.acA().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(74121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74123);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(926, this);
    AppMethodBeat.o(74123);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74125);
    ad.i("MicroMsg.SettingsAliasUI", "errType %d, errCode %d, errMsg %s, doubleCheck %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(this.yGw) });
    if (this.sBI != null) {
      this.sBI.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.yGu = ((wq)((com.tencent.mm.plugin.account.model.f)paramn).hWL.hNL.hNQ).FVT;
      ad.i("MicroMsg.SettingsAliasUI", "conditions %d", new Object[] { Integer.valueOf(this.yGu.size()) });
      this.jpO = ((wq)((com.tencent.mm.plugin.account.model.f)paramn).hWL.hNL.hNQ).jpO;
      this.gOx = ((wq)((com.tencent.mm.plugin.account.model.f)paramn).hWL.hNL.hNQ).gOx;
      this.txJ = ((wq)((com.tencent.mm.plugin.account.model.f)paramn).hWL.hNL.hNQ).dpf;
      if ((this.yGu != null) && (!this.yGu.isEmpty()))
      {
        this.yGv = true;
        c.fy(this.yGu);
        paramString = this.yGu.iterator();
        if (paramString.hasNext())
        {
          paramn = (wr)paramString.next();
          if ((this.yGv) && (paramn.FVU)) {}
          for (boolean bool = true;; bool = false)
          {
            this.yGv = bool;
            break;
          }
        }
        ad.i("MicroMsg.SettingsAliasUI", "onSceneEnd, allPass %s", new Object[] { Boolean.valueOf(this.yGv) });
        if (this.yGw)
        {
          if (!this.yGv)
          {
            dNF();
            AppMethodBeat.o(74125);
            return;
          }
          aUj();
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