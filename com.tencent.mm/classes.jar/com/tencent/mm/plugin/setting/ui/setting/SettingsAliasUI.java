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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.model.v;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.setting.d;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.f
{
  public static String yWG;
  private String gRf;
  private int jsH;
  private ProgressDialog sMH;
  private String tIA;
  private TextView yWB;
  private Button yWC;
  private List<wu> yWD;
  private boolean yWE;
  private boolean yWF;
  private dh yWH;
  
  public SettingsAliasUI()
  {
    AppMethodBeat.i(190343);
    this.yWD = null;
    this.yWH = new dh();
    AppMethodBeat.o(190343);
  }
  
  private void aUI()
  {
    AppMethodBeat.i(190345);
    switch (this.jsH)
    {
    default: 
      if (!bu.isNullOrNil(this.gRf)) {
        com.tencent.mm.plugin.account.a.b.a.b(this, this.gRf, 0, true);
      }
      break;
    }
    do
    {
      AppMethodBeat.o(190345);
      return;
      Intent localIntent = new Intent(this, VerifyPwdUI.class);
      localIntent.putExtra("key_scenen", 2);
      startActivityForResult(localIntent, 10001);
      AppMethodBeat.o(190345);
      return;
    } while (bu.isNullOrNil(this.gRf));
    com.tencent.mm.plugin.account.a.b.a.b(this, this.gRf, 10002, true);
    AppMethodBeat.o(190345);
  }
  
  private void dRc()
  {
    AppMethodBeat.i(190346);
    MMWizardActivity.al(this, new Intent(this, SettingsModifyAliasCheckUI.class));
    AppMethodBeat.o(190346);
  }
  
  private void qX(boolean paramBoolean)
  {
    AppMethodBeat.i(190344);
    com.tencent.mm.kernel.g.ajj().a(new com.tencent.mm.plugin.account.model.f(), 0);
    if (paramBoolean) {
      this.sMH = h.b(this, getString(2131755804), false, null);
    }
    AppMethodBeat.o(190344);
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
    this.yWB = ((TextView)findViewById(2131304635));
    String str2 = v.aAD();
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = v.aAC();
    }
    ae.i("MicroMsg.SettingsAliasUI", "curAlias %s", new Object[] { str1 });
    this.yWB.setText(getString(2131755760) + str1);
    this.yWC = ((Button)findViewById(2131304656));
    this.yWC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190342);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.SettingsAliasUI", "click next, allPass %s", new Object[] { Boolean.valueOf(SettingsAliasUI.a(SettingsAliasUI.this)) });
        SettingsAliasUI.b(SettingsAliasUI.this).dQX = 1L;
        if (SettingsAliasUI.a(SettingsAliasUI.this))
        {
          SettingsAliasUI.b(SettingsAliasUI.this).aLH();
          SettingsAliasUI.c(SettingsAliasUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(190342);
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
          if (((wu)SettingsAliasUI.d(SettingsAliasUI.this).get(j)).Got) {
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
          SettingsAliasUI.b(SettingsAliasUI.this).egM = i;
          SettingsAliasUI.b(SettingsAliasUI.this).aLH();
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
        SettingsAliasUI.b(SettingsAliasUI.this).dQX = 7L;
        SettingsAliasUI.b(SettingsAliasUI.this).aLH();
        SettingsAliasUI.this.onBackPressed();
        AppMethodBeat.o(74115);
        return true;
      }
    });
    AppMethodBeat.o(74124);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190347);
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
      ae.i("MicroMsg.SettingsAliasUI", "requestCode %d, resultCode OK %s, data == null %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramIntent != null) {
        break label83;
      }
      AppMethodBeat.o(190347);
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
        localArrayList2.add(this.tIA);
        localArrayList2.add(paramIntent.getStringExtra("key_ticket"));
        localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
        localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
        MMWizardActivity.al(this, localIntent);
        AppMethodBeat.o(190347);
      }
    }
    else if ((paramInt1 == 10002) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.getString("result_json"))
      {
        ae.i("MicroMsg.SettingsAliasUI", "face recog, result: %s", new Object[] { paramIntent });
        if (bu.isNullOrNil(paramIntent)) {
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
          localArrayList2.add(this.tIA);
          localArrayList2.add(paramIntent);
          localIntent.putIntegerArrayListExtra("key_ticket_type", localArrayList1);
          localIntent.putStringArrayListExtra("key_ticket", localArrayList2);
          MMWizardActivity.al(this, localIntent);
          AppMethodBeat.o(190347);
          return;
        }
        catch (Exception paramIntent)
        {
          ae.e("MicroMsg.SettingsAliasUI", "jump face recog error, %s", new Object[] { paramIntent.getMessage() });
        }
      }
    }
    label401:
    AppMethodBeat.o(190347);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74121);
    super.onCreate(paramBundle);
    d.fG(null);
    yWG = "set_alias_" + System.currentTimeMillis();
    this.yWH.mO(yWG);
    initView();
    ae.i("MicroMsg.SettingsAliasUI", "root class %s", new Object[] { getIntent().getStringExtra("WizardRootClass") });
    com.tencent.mm.kernel.g.ajj().a(926, this);
    qX(false);
    if (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(74121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74123);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(926, this);
    AppMethodBeat.o(74123);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74125);
    ae.i("MicroMsg.SettingsAliasUI", "errType %d, errCode %d, errMsg %s, doubleCheck %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(this.yWF) });
    if (this.sMH != null) {
      this.sMH.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.yWD = ((wt)((com.tencent.mm.plugin.account.model.f)paramn).hZD.hQE.hQJ).Gos;
      ae.i("MicroMsg.SettingsAliasUI", "conditions %d", new Object[] { Integer.valueOf(this.yWD.size()) });
      this.jsH = ((wt)((com.tencent.mm.plugin.account.model.f)paramn).hZD.hQE.hQJ).jsH;
      this.gRf = ((wt)((com.tencent.mm.plugin.account.model.f)paramn).hZD.hQE.hQJ).gRf;
      this.tIA = ((wt)((com.tencent.mm.plugin.account.model.f)paramn).hZD.hQE.hQJ).dqk;
      if ((this.yWD != null) && (!this.yWD.isEmpty()))
      {
        this.yWE = true;
        d.fG(this.yWD);
        paramString = this.yWD.iterator();
        if (paramString.hasNext())
        {
          paramn = (wu)paramString.next();
          if ((this.yWE) && (paramn.Got)) {}
          for (boolean bool = true;; bool = false)
          {
            this.yWE = bool;
            break;
          }
        }
        ae.i("MicroMsg.SettingsAliasUI", "onSceneEnd, allPass %s", new Object[] { Boolean.valueOf(this.yWE) });
        if (this.yWF)
        {
          if (!this.yWE)
          {
            dRc();
            AppMethodBeat.o(74125);
            return;
          }
          aUI();
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