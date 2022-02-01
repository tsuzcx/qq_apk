package com.tencent.mm.plugin.recharge.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView.a;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.plugin.recharge.ui.form.c.b.1;
import com.tencent.mm.plugin.recharge.ui.form.c.b.2;
import com.tencent.mm.plugin.recharge.ui.form.c.b.3;
import com.tencent.mm.plugin.recharge.ui.form.c.b.4;
import com.tencent.mm.plugin.recharge.ui.form.c.b.5;
import com.tencent.mm.plugin.recharge.ui.form.c.b.6;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.z;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI
  extends MMActivity
  implements com.tencent.mm.ak.f, d.a
{
  private String desc;
  private int errCode;
  private String errMsg;
  private String headUrl;
  private String mAppId;
  protected Dialog tipDialog;
  private int xDr;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> xDs;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> xDt;
  private com.tencent.mm.plugin.wallet.a.e xDu;
  private com.tencent.mm.plugin.wallet.a.e xDv;
  private com.tencent.mm.plugin.wallet.a.e xDw;
  private com.tencent.mm.plugin.wallet.a.e xDx;
  private com.tencent.mm.plugin.wallet.a.e xDy;
  private boolean xEA;
  private List<String[]> xEB;
  private boolean xEC;
  private View xEe;
  private ImageView xEf;
  private TextView xEg;
  private MallFormView xEh;
  private TextView xEi;
  private TextView xEj;
  private GridView xEk;
  private GridView xEl;
  private TextView xEm;
  private TextView xEn;
  private TextView xEo;
  private TextView xEp;
  private TextView xEq;
  private TextView xEr;
  private b xEs;
  private b xEt;
  private MallFunction xEu;
  private String xEv;
  private int xEw;
  private String xEx;
  private c.b xEy;
  private p xEz;
  private boolean xdm;
  private com.tencent.mm.sdk.b.c xdp;
  
  public PhoneRechargeUI()
  {
    AppMethodBeat.i(67185);
    this.xEe = null;
    this.xEf = null;
    this.xEg = null;
    this.xEh = null;
    this.xEi = null;
    this.xEj = null;
    this.xEk = null;
    this.xEl = null;
    this.xEm = null;
    this.xEn = null;
    this.xEo = null;
    this.xEp = null;
    this.xEq = null;
    this.xEr = null;
    this.xEs = null;
    this.xEt = null;
    this.tipDialog = null;
    this.xEu = null;
    this.mAppId = "";
    this.xDs = null;
    this.xDt = null;
    this.xDu = null;
    this.xDv = null;
    this.xDw = null;
    this.xDx = null;
    this.xDy = null;
    this.errCode = 0;
    this.errMsg = "";
    this.xEv = "";
    this.desc = "";
    this.xEx = "";
    this.headUrl = "";
    this.xdm = false;
    this.xEy = null;
    this.xEz = null;
    this.xEA = false;
    this.xdp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67185);
  }
  
  private void Z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67194);
    label103:
    String str;
    if ((this.xEz != null) && (!dHf()))
    {
      this.xEe.setVisibility(0);
      this.xEg.setText(this.xEz.name);
      ae.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
      com.tencent.mm.protocal.g.gi(6, 0);
      this.xEs.xDW = this.xDs;
      this.xEs.notifyDataSetChanged();
      this.xEt.xDW = this.xDt;
      this.xEt.notifyDataSetChanged();
      if (paramBoolean1) {
        break label421;
      }
      this.xEq.setVisibility(8);
      this.xEr.setVisibility(8);
      if (paramBoolean2) {
        addTextOptionMenu(0, this.xDy.name, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(67164);
            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.i(PhoneRechargeUI.this).CYy, PhoneRechargeUI.i(PhoneRechargeUI.this).hGk, PhoneRechargeUI.i(PhoneRechargeUI.this).name, "")) {}
            try
            {
              paramAnonymousMenuItem = URLDecoder.decode(PhoneRechargeUI.i(PhoneRechargeUI.this).url, "utf-8");
              PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousMenuItem, PhoneRechargeUI.i(PhoneRechargeUI.this).name, "");
              AppMethodBeat.o(67164);
              return false;
            }
            catch (UnsupportedEncodingException paramAnonymousMenuItem)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousMenuItem, "", new Object[0]);
              }
            }
          }
        });
      }
      TextView localTextView = this.xEi;
      if ((this.xDs == null) || (this.xDs.size() <= 0) || (bu.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.xDs.get(0)).CZd))) {
        break label466;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.xDs.get(0)).CZd;
      label194:
      localTextView.setText(str);
      localTextView = this.xEj;
      if ((this.xDt == null) || (this.xDt.size() <= 0) || (bu.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.xDt.get(0)).CZd))) {
        break label477;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.xDt.get(0)).CZd;
      label258:
      localTextView.setText(str);
      if ((this.xDx != null) && (!bu.isNullOrNil(this.xDx.name))) {
        break label488;
      }
      this.xEn.setVisibility(8);
      label293:
      if ((this.xDu != null) && (!bu.isNullOrNil(this.xDu.name))) {
        break label528;
      }
      this.xEm.setVisibility(8);
      label322:
      if ((this.xDv != null) && (!bu.isNullOrNil(this.xDv.name))) {
        break label568;
      }
      this.xEo.setVisibility(8);
      label351:
      if ((this.xDw != null) && (!bu.isNullOrNil(this.xDw.name))) {
        break label608;
      }
      this.xEp.setVisibility(8);
    }
    for (;;)
    {
      if (this.xEC) {
        h(this.xEu);
      }
      AppMethodBeat.o(67194);
      return;
      this.xEe.setVisibility(8);
      ae.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break;
      label421:
      if (dHh()) {
        this.xEq.setVisibility(0);
      }
      for (;;)
      {
        if (!dHg()) {
          break label464;
        }
        this.xEr.setVisibility(0);
        break;
        this.xEq.setVisibility(8);
      }
      label464:
      break label103;
      label466:
      str = getString(2131765780);
      break label194;
      label477:
      str = getString(2131765781);
      break label258;
      label488:
      this.xEn.setVisibility(0);
      this.xEn.setText(this.xDx.name);
      this.xEn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67165);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).CYy, PhoneRechargeUI.j(PhoneRechargeUI.this).hGk, PhoneRechargeUI.j(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).url);
            ae.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.j(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67165);
        }
      });
      break label293;
      label528:
      this.xEm.setVisibility(0);
      this.xEm.setText(this.xDu.name);
      this.xEm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67166);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).CYy, PhoneRechargeUI.k(PhoneRechargeUI.this).hGk, PhoneRechargeUI.k(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).url);
            ae.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.k(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67166);
        }
      });
      break label322;
      label568:
      this.xEo.setVisibility(0);
      this.xEo.setText(this.xDv.name);
      this.xEo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).CYy, PhoneRechargeUI.l(PhoneRechargeUI.this).hGk, PhoneRechargeUI.l(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).url);
            ae.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.l(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67167);
        }
      });
      break label351;
      label608:
      this.xEp.setVisibility(0);
      this.xEp.setText(this.xDw.name);
      this.xEp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67168);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).CYy, PhoneRechargeUI.m(PhoneRechargeUI.this).hGk, PhoneRechargeUI.m(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).url);
            ae.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.m(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67168);
        }
      });
    }
  }
  
  private String awA(String paramString)
  {
    AppMethodBeat.i(67188);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67188);
      return "";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    String str1 = paramString;
    try
    {
      if (this.xEy != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.xEy.xDI != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!bu.isNullOrNil(this.xEy.xDI.name))
          {
            str1 = paramString;
            localObject1 = this.xEy.xDI.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(2131765787))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.xEh.getText();
      str1 = paramString;
      localObject1 = URLEncoder.encode(URLEncoder.encode((String)localObject2, "utf-8"), "utf-8");
      str1 = paramString;
      if (!paramString.startsWith("http://"))
      {
        str1 = paramString;
        if (!paramString.startsWith("https://")) {}
      }
      else
      {
        str1 = paramString;
        ae.i("MicroMsg.PhoneRechargeUI", "new url");
        str1 = paramString;
        if (paramString.indexOf("%7Bphone%7D") > 0)
        {
          str1 = paramString;
          paramString = paramString.replace("%7Bphone%7D", str2);
          str1 = paramString;
          if (paramString.indexOf("%7Bremark%7D") <= 0) {
            break label243;
          }
          str1 = paramString;
        }
        for (paramString = paramString.replace("%7Bremark%7D", (CharSequence)localObject1);; paramString = paramString.replace("{remark}", (CharSequence)localObject1))
        {
          AppMethodBeat.o(67188);
          return paramString;
          str1 = paramString;
          paramString = paramString.replace("{phone}", str2);
          break;
          label243:
          str1 = paramString;
        }
      }
      str1 = paramString;
      ae.i("MicroMsg.PhoneRechargeUI", "old url");
      str1 = paramString;
      localObject2 = URLDecoder.decode(paramString, "utf-8");
      str1 = paramString;
      paramString = (String)localObject2 + String.format("?phone=%s&remark=%s", new Object[] { str2, localObject1 });
      AppMethodBeat.o(67188);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ae.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramString, "", new Object[0]);
      AppMethodBeat.o(67188);
    }
    return str1;
  }
  
  private void awB(final String paramString)
  {
    AppMethodBeat.i(67198);
    View localView = z.jV(this).inflate(2131495212, null);
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131765796), localView, getString(2131765797), getString(2131765795), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(67169);
        paramAnonymousDialogInterface = PhoneRechargeUI.b(PhoneRechargeUI.this, paramString);
        ae.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousDialogInterface });
        PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousDialogInterface, PhoneRechargeUI.this.getString(2131765796), "");
        AppMethodBeat.o(67169);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(67170);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(67170);
      }
    });
    AppMethodBeat.o(67198);
  }
  
  private void awC(String paramString)
  {
    AppMethodBeat.i(67200);
    com.tencent.mm.ui.base.h.a(this, paramString, "", false, new PhoneRechargeUI.11(this));
    AppMethodBeat.o(67200);
  }
  
  private void c(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(67191);
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      if (!paramBoolean) {
        break label71;
      }
    }
    label71:
    for (this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), true, new PhoneRechargeUI.2(this, paramn));; this.tipDialog = com.tencent.mm.wallet_core.ui.h.c(getContext(), true, new PhoneRechargeUI.3(this, paramn)))
    {
      com.tencent.mm.kernel.g.ajj().a(paramn, 0);
      AppMethodBeat.o(67191);
      return;
    }
  }
  
  private void dHe()
  {
    AppMethodBeat.i(67186);
    this.mAppId = "";
    dHi();
    this.errCode = 0;
    this.errMsg = "";
    this.desc = "";
    AppMethodBeat.o(67186);
  }
  
  private boolean dHf()
  {
    AppMethodBeat.i(67189);
    if (this.xEz != null)
    {
      Object localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILD, "");
      if (!bu.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split(";");
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 != null) && (localObject2.equals(String.valueOf(this.xEz.id))))
            {
              ae.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
              AppMethodBeat.o(67189);
              return true;
            }
            i += 1;
          }
        }
        ae.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
        AppMethodBeat.o(67189);
        return false;
      }
      ae.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
      AppMethodBeat.o(67189);
      return false;
    }
    ae.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
    AppMethodBeat.o(67189);
    return true;
  }
  
  private boolean dHg()
  {
    AppMethodBeat.i(67195);
    Iterator localIterator = this.xDt.iterator();
    while (localIterator.hasNext()) {
      if (((com.tencent.mm.plugin.wallet.a.q)localIterator.next()).status != 0)
      {
        AppMethodBeat.o(67195);
        return false;
      }
    }
    AppMethodBeat.o(67195);
    return true;
  }
  
  private boolean dHh()
  {
    AppMethodBeat.i(67196);
    Iterator localIterator = this.xDs.iterator();
    while (localIterator.hasNext()) {
      if (((com.tencent.mm.plugin.wallet.a.q)localIterator.next()).status != 0)
      {
        AppMethodBeat.o(67196);
        return false;
      }
    }
    AppMethodBeat.o(67196);
    return true;
  }
  
  private void dHi()
  {
    AppMethodBeat.i(67199);
    this.xDs = new ArrayList();
    com.tencent.mm.plugin.wallet.a.q localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(2131765769);
    localq1.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(2131765770);
    localq2.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(2131765771);
    localq3.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq4 = new com.tencent.mm.plugin.wallet.a.q();
    localq4.name = getString(2131765772);
    localq4.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq5 = new com.tencent.mm.plugin.wallet.a.q();
    localq5.name = getString(2131765773);
    localq5.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq6 = new com.tencent.mm.plugin.wallet.a.q();
    localq6.name = getString(2131765774);
    localq6.status = 0;
    this.xDs.add(localq1);
    this.xDs.add(localq2);
    this.xDs.add(localq3);
    this.xDs.add(localq4);
    this.xDs.add(localq5);
    this.xDs.add(localq6);
    this.xDt = new ArrayList();
    localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(2131765775);
    localq1.status = 0;
    localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(2131765776);
    localq2.status = 0;
    localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(2131765777);
    localq3.status = 0;
    this.xDt.add(localq1);
    this.xDt.add(localq2);
    this.xDt.add(localq3);
    AppMethodBeat.o(67199);
  }
  
  private void dHj()
  {
    AppMethodBeat.i(67203);
    com.tencent.mm.kernel.g.ajj().a(new com.tencent.mm.plugin.recharge.model.f(this.xEh.getText()), 0);
    AppMethodBeat.o(67203);
  }
  
  private void h(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67197);
    if (com.tencent.mm.plugin.recharge.model.b.g(paramMallFunction))
    {
      com.tencent.mm.plugin.recharge.model.b.dHa();
      if (this.xEu.DsT == null)
      {
        AppMethodBeat.o(67197);
        return;
      }
      ae.d("MicroMsg.PhoneRechargeUI", this.xEu.DsT.toString());
      awB(this.xEu.DsT.Dti);
    }
    AppMethodBeat.o(67197);
  }
  
  private void k(n paramn)
  {
    AppMethodBeat.i(67190);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramn.getType() != 497))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(67190);
  }
  
  public final void dHk()
  {
    AppMethodBeat.i(67204);
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.g.ajj().a(localf, 0);
    AppMethodBeat.o(67204);
  }
  
  public int getLayoutId()
  {
    return 2131495083;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67202);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(67202);
      return;
      if (paramInt2 == -1)
      {
        this.xEA = true;
        Object localObject1 = null;
        Object localObject4 = null;
        final ArrayList localArrayList = new ArrayList();
        Object localObject3 = paramIntent.getData();
        if (localObject3 == null)
        {
          ae.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
          AppMethodBeat.o(67202);
          return;
        }
        Cursor localCursor1;
        Cursor localCursor2;
        try
        {
          localCursor1 = getContentResolver().query((Uri)localObject3, null, null, null, null);
          localObject3 = localObject1;
          if (localCursor1 == null) {
            break label474;
          }
          localObject3 = localObject1;
          if (localCursor1.getCount() <= 0) {
            break label474;
          }
          localCursor1.moveToFirst();
          int i = localCursor1.getColumnIndex("has_phone_number");
          if (i > 0)
          {
            localObject3 = localObject1;
            if (localCursor1.getInt(i) <= 0) {
              break label474;
            }
          }
          localObject1 = localCursor1.getString(localCursor1.getColumnIndex("_id"));
          localCursor2 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ".concat(String.valueOf(localObject1)), null, null);
          localObject1 = localObject4;
          if (localCursor2 != null)
          {
            localObject1 = localObject4;
            if (localCursor2.moveToFirst())
            {
              localObject1 = null;
              while (!localCursor2.isAfterLast())
              {
                i = localCursor2.getColumnIndex("data1");
                int j = localCursor2.getColumnIndex("display_name");
                localObject3 = localCursor2.getString(i);
                localObject1 = localCursor2.getString(j);
                ae.d("MicroMsg.PhoneRechargeUI", "hy: username : ".concat(String.valueOf(localObject1)));
                if (localObject3 != null)
                {
                  ae.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.Ku((String)localObject3);
                  ae.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  if ((PhoneNumberUtils.isGlobalPhoneNumber((String)localObject3)) && (((String)localObject3).length() == 11)) {
                    localArrayList.add(localObject3);
                  }
                  ae.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : ".concat(String.valueOf(localObject3)));
                }
                localCursor2.moveToNext();
              }
            }
          }
        }
        catch (SecurityException localSecurityException)
        {
          ae.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[] { localSecurityException.toString() });
          com.tencent.mm.ui.base.h.c(this, getString(2131761164), "", true);
        }
        localObject3 = localSecurityException;
        if (localCursor2 != null)
        {
          localCursor2.close();
          localObject3 = localSecurityException;
        }
        label474:
        if ((localCursor1 != null) && (!localCursor1.isClosed())) {
          localCursor1.close();
        }
        Object localObject2;
        if (localArrayList.size() > 1)
        {
          localObject2 = com.tencent.mm.ui.base.h.a(this, getString(2131765790), localArrayList, -1, new h.a()
          {
            public final void Ob(int paramAnonymousInt)
            {
              AppMethodBeat.i(67176);
              ae.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
              PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(paramAnonymousInt), this.xEI, 1));
              PhoneRechargeUI.n(PhoneRechargeUI.this);
              AppMethodBeat.o(67176);
            }
          });
          if (localObject2 != null) {
            ((com.tencent.mm.ui.widget.a.d)localObject2).setCanceledOnTouchOutside(true);
          }
        }
        else if (localArrayList.size() == 1)
        {
          this.xEy.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          dHj();
        }
        else
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131761162), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.xdm)
            {
              ae.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.xEh.getText(), this.xEh.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.dGX().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.xdm = true;
            }
          }
          else {
            ae.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67187);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    com.tencent.mm.kernel.g.ajj().a(1571, this);
    com.tencent.mm.kernel.g.ajj().a(498, this);
    this.xEu = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    this.xEC = getIntent().getBooleanExtra("key_need_show_remind_dialog", true);
    dHi();
    if (this.xEu == null)
    {
      ae.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      t.makeText(this, "function info is null", 1).show();
      finish();
      AppMethodBeat.o(67187);
      return;
    }
    setMMTitle(this.xEu.dLB);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67161);
        PhoneRechargeUI.this.hideVKB();
        PhoneRechargeUI.this.finish();
        AppMethodBeat.o(67161);
        return true;
      }
    });
    this.xDy = new com.tencent.mm.plugin.wallet.a.e();
    this.xDy.name = getString(2131765783);
    this.xDy.url = getString(2131765784);
    this.xEe = findViewById(2131303235);
    this.xEf = ((ImageView)findViewById(2131302848));
    this.xEg = ((TextView)findViewById(2131302849));
    this.xEh = ((MallFormView)findViewById(2131303820));
    com.tencent.mm.plugin.recharge.ui.form.c.b(this.xEh);
    this.xEy = new c.b(this.xEh);
    paramBundle = this.xEy;
    ae.d(com.tencent.mm.plugin.recharge.ui.form.c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.xFr;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).xFx != null) {
      ((MallFormView)localObject).xFx.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.xFr.getContentEditText();
    com.tencent.mm.sdk.g.b.c(new c.b.2(paramBundle), "fetch_phone_book");
    paramBundle.xFs = new com.tencent.mm.plugin.recharge.ui.form.d(paramBundle.xFr, paramBundle.xDH);
    paramBundle.xFs.xGe = new c.b.3(paramBundle);
    paramBundle.xFs.xGf = this;
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.xFs);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.xFr.setOnFocusChangeListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.6(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.xEk = ((GridView)findViewById(2131303838));
    this.xEm = ((TextView)findViewById(2131303844));
    this.xEn = ((TextView)findViewById(2131303845));
    this.xEo = ((TextView)findViewById(2131303818));
    this.xEp = ((TextView)findViewById(2131303834));
    this.xEi = ((TextView)findViewById(2131303840));
    this.xEj = ((TextView)findViewById(2131303842));
    this.xEl = ((GridView)findViewById(2131303821));
    this.xEq = ((TextView)findViewById(2131303839));
    this.xEr = ((TextView)findViewById(2131303841));
    this.xEh.setOnInputValidChangeListener(new MallFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(67174);
        if (paramAnonymousBoolean)
        {
          PhoneRechargeUI.this.hideVKB();
          final String str = com.tencent.mm.plugin.recharge.model.b.Ku(PhoneRechargeUI.a(PhoneRechargeUI.this).getText());
          if (str == null)
          {
            ae.e("MicroMsg.PhoneRechargeUI", "null phone, return");
            AppMethodBeat.o(67174);
            return;
          }
          com.tencent.mm.sdk.g.b.e(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67173);
              long l = System.currentTimeMillis();
              final com.tencent.mm.plugin.recharge.model.a locala = PhoneRechargeUI.a(PhoneRechargeUI.this, str);
              ae.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67172);
                  PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(locala);
                  PhoneRechargeUI.awD(PhoneRechargeUI.12.1.this.xEE);
                  AppMethodBeat.o(67172);
                }
              });
              AppMethodBeat.o(67173);
            }
          }, "search_matched_mobile");
          if (!PhoneRechargeUI.c(PhoneRechargeUI.this))
          {
            ae.d("MicroMsg.PhoneRechargeUI", "clear focus");
            PhoneRechargeUI.a(PhoneRechargeUI.this, true);
            AppMethodBeat.o(67174);
            return;
          }
          PhoneRechargeUI.a(PhoneRechargeUI.this, false);
          AppMethodBeat.o(67174);
          return;
        }
        PhoneRechargeUI.a(PhoneRechargeUI.this).getTipsTv().setText("");
        PhoneRechargeUI.a(PhoneRechargeUI.this).getTipsTv().setTextColor(PhoneRechargeUI.this.getResources().getColor(2131100711));
        PhoneRechargeUI.d(PhoneRechargeUI.this);
        PhoneRechargeUI.e(PhoneRechargeUI.this);
        if (bu.isNullOrNil(PhoneRechargeUI.a(PhoneRechargeUI.this).getText())) {
          ((AutoCompleteTextView)PhoneRechargeUI.a(PhoneRechargeUI.this).getContentEditText()).showDropDown();
        }
        AppMethodBeat.o(67174);
      }
    });
    this.xEh.getInfoIv().setOnClickListener(new PhoneRechargeUI.16(this));
    this.xEs = new b();
    this.xEs.xDX = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67179);
        if (paramAnonymousq == null)
        {
          ae.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
          AppMethodBeat.o(67179);
          return;
        }
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.CYy, paramAnonymousq.hGk, paramAnonymousq.name, paramAnonymousq.desc))
        {
          if (!bu.isNullOrNil(paramAnonymousq.url))
          {
            String str = PhoneRechargeUI.b(PhoneRechargeUI.this, paramAnonymousq.url);
            PhoneRechargeUI.a(PhoneRechargeUI.this, str, paramAnonymousq.name, paramAnonymousq.desc);
            AppMethodBeat.o(67179);
            return;
          }
          if (PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq)) {
            PhoneRechargeUI.b(PhoneRechargeUI.this, paramAnonymousq);
          }
        }
        AppMethodBeat.o(67179);
      }
    };
    this.xEt = new b();
    this.xEt.xDX = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67180);
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.CYy, paramAnonymousq.hGk, paramAnonymousq.name, paramAnonymousq.desc))
        {
          if (!bu.isNullOrNil(paramAnonymousq.url))
          {
            String str = PhoneRechargeUI.b(PhoneRechargeUI.this, paramAnonymousq.url);
            PhoneRechargeUI.a(PhoneRechargeUI.this, str, paramAnonymousq.name, paramAnonymousq.desc);
            AppMethodBeat.o(67180);
            return;
          }
          if (PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq))
          {
            PhoneRechargeUI.b(PhoneRechargeUI.this, paramAnonymousq);
            AppMethodBeat.o(67180);
            return;
          }
          ae.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
        }
        AppMethodBeat.o(67180);
      }
    };
    this.xEk.setAdapter(this.xEs);
    this.xEl.setAdapter(this.xEt);
    this.xEf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67181);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null) {
          PhoneRechargeUI.g(PhoneRechargeUI.this);
        }
        for (;;)
        {
          PhoneRechargeUI.h(PhoneRechargeUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67181);
          return;
          ae.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
        }
      }
    });
    this.xEg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67182);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null)
        {
          com.tencent.mm.protocal.g.gi(6, 1);
          if ((PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.f(PhoneRechargeUI.this).CYy, PhoneRechargeUI.f(PhoneRechargeUI.this).hGk, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "")) || (bu.isNullOrNil(PhoneRechargeUI.f(PhoneRechargeUI.this).url))) {}
        }
        try
        {
          paramAnonymousView = URLDecoder.decode(PhoneRechargeUI.f(PhoneRechargeUI.this).url, "utf-8");
          PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67182);
          return;
        }
        catch (UnsupportedEncodingException paramAnonymousView)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousView, "", new Object[0]);
          }
        }
      }
    });
    this.xEh.dHt();
    int i = com.tencent.mm.cb.a.iu(this) / 4 - 20;
    ae.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.xEm.setMaxWidth(i);
    this.xEn.setMaxWidth(i);
    this.xEo.setMaxWidth(i);
    this.xEp.setMaxWidth(i);
    this.xEw = getResources().getColor(2131100711);
    if ((this.xEy.xDI != null) && (!bu.isNullOrNil(this.xEy.xDI.name))) {
      this.desc = this.xEy.xDI.name;
    }
    this.xEh.getContentEditText().setHintTextColor(getResources().getColor(2131100787));
    if (bu.isNullOrNil(this.xEh.getText()))
    {
      c(new com.tencent.mm.plugin.recharge.model.f(""), false);
      AppMethodBeat.o(67187);
      return;
    }
    c(new com.tencent.mm.plugin.recharge.model.f(this.xEh.getText()), false);
    AppMethodBeat.o(67187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67193);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(1571, this);
    com.tencent.mm.kernel.g.ajj().b(498, this);
    com.tencent.mm.sdk.b.a.IvT.d(this.xdp);
    AppMethodBeat.o(67193);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67192);
    super.onResume();
    Z(false, true);
    AppMethodBeat.o(67192);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(67201);
    if ((paramn instanceof com.tencent.mm.plugin.recharge.model.f))
    {
      paramString = (com.tencent.mm.plugin.recharge.model.f)paramn;
      k(paramn);
      if (paramString.cmdId == 0)
      {
        if ((!bu.isNullOrNil(paramString.jpF)) && (!paramString.jpF.equals(this.xEh.getText())))
        {
          ae.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.jpF, this.xEh.getText() });
          AppMethodBeat.o(67201);
          return;
        }
        if (paramString.xDq)
        {
          ae.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          awC(paramString.errMsg);
          dHe();
          AppMethodBeat.o(67201);
          return;
        }
        this.mAppId = paramString.appId;
        this.xDr = paramString.xDr;
        this.xDs = paramString.xDs;
        this.xDu = paramString.xDu;
        this.xDv = paramString.xDv;
        this.xDw = paramString.xDw;
        this.xDx = paramString.xDx;
        this.errCode = paramString.errCode;
        this.errMsg = paramString.errMsg;
        this.xEv = paramString.desc;
        ae.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.xEv, this.xEh.getText() });
        if (bu.isNullOrNil(this.xEv))
        {
          this.desc = "";
          this.xEw = getResources().getColor(2131100711);
        }
        for (;;)
        {
          this.xEz = paramString.xDz;
          this.xDt = paramString.xDt;
          if (this.xDt == null) {
            break;
          }
          paramInt1 = this.xDt.size() - 1;
          while (paramInt1 >= 0)
          {
            paramn = (com.tencent.mm.plugin.wallet.a.q)this.xDt.get(paramInt1);
            if (paramn.name.isEmpty()) {
              this.xDt.remove(paramn);
            }
            paramInt1 -= 1;
          }
          if ((this.xEy.xDI != null) && (this.xEy.xDI.xCY.trim().equals(this.xEh.getText())))
          {
            this.xEy.xDI.kgf = this.xEv;
            this.xEy.setInput(this.xEy.xDI);
          }
        }
        if ((paramString.xDy == null) || ((paramString.xDy.name.equals(this.xDy.name)) && (paramString.xDy.url.equals(this.xDy.url)) && (paramString.xDy.CYy.equals(this.xDy.CYy)) && (paramString.xDy.hGk.equals(this.xDy.hGk)))) {
          break label875;
        }
        ae.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.xDy = paramString.xDy;
      }
    }
    label875:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.xEv.equals(""))
      {
        bool2 = false;
        Z(bool2, bool1);
        paramString = paramString.xDA;
        ae.d("MicroMsg.PhoneRechargeUI", "update record history");
        com.tencent.mm.plugin.recharge.a.a.dGX().fe(paramString);
        if (this.xEy != null)
        {
          if (!bu.isNullOrNil(this.xEh.getText())) {
            break label626;
          }
          this.xEy.pN(true);
        }
      }
      for (;;)
      {
        this.xEh.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67175);
            PhoneRechargeUI.a(PhoneRechargeUI.this).dHu();
            AppMethodBeat.o(67175);
          }
        }, 300L);
        AppMethodBeat.o(67201);
        return;
        bool2 = true;
        break;
        label626:
        this.xEy.pN(false);
      }
      ae.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      AppMethodBeat.o(67201);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        k(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.wallet_core.b.fVf();
          if ((com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qDk, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_MOBILE_FEE_PAY_SWTICH_KEY"))) {}
          for (paramInt1 = i;; paramInt1 = 0)
          {
            paramString = (com.tencent.mm.plugin.recharge.model.g)paramn;
            if (paramInt1 == 0) {
              break;
            }
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(paramString.xDC.dmw, 6);
            com.tencent.mm.sdk.b.a.IvT.c(this.xdp);
            AppMethodBeat.o(67201);
            return;
          }
          paramn = paramString.xDC;
          paramn.dDH = 6;
          paramn.FEn = 100;
          paramn.oED = this.xEh.getText();
          if (this.xEy.xDI != null) {}
          for (paramString = this.xEy.xDI.name;; paramString = "")
          {
            paramn.iWF = paramString;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 2);
            break;
          }
        }
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramn = getString(2131765901);
        }
        awC(paramn);
      }
      AppMethodBeat.o(67201);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI
 * JD-Core Version:    0.7.0.1
 */