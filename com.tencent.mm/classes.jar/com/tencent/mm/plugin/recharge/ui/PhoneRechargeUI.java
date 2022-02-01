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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yp;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
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
  implements com.tencent.mm.al.f, d.a
{
  private String desc;
  private int errCode;
  private String errMsg;
  private String headUrl;
  private String mAppId;
  protected Dialog tipDialog;
  private com.tencent.mm.sdk.b.c wNB;
  private boolean wNy;
  private com.tencent.mm.plugin.wallet.a.e xnA;
  private com.tencent.mm.plugin.wallet.a.e xnB;
  private int xnu;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> xnv;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> xnw;
  private com.tencent.mm.plugin.wallet.a.e xnx;
  private com.tencent.mm.plugin.wallet.a.e xny;
  private com.tencent.mm.plugin.wallet.a.e xnz;
  private String xoA;
  private c.b xoB;
  private p xoC;
  private boolean xoD;
  private List<String[]> xoE;
  private boolean xoF;
  private View xoh;
  private ImageView xoi;
  private TextView xoj;
  private MallFormView xok;
  private TextView xol;
  private TextView xom;
  private GridView xon;
  private GridView xoo;
  private TextView xop;
  private TextView xoq;
  private TextView xor;
  private TextView xos;
  private TextView xot;
  private TextView xou;
  private b xov;
  private b xow;
  private MallFunction xox;
  private String xoy;
  private int xoz;
  
  public PhoneRechargeUI()
  {
    AppMethodBeat.i(67185);
    this.xoh = null;
    this.xoi = null;
    this.xoj = null;
    this.xok = null;
    this.xol = null;
    this.xom = null;
    this.xon = null;
    this.xoo = null;
    this.xop = null;
    this.xoq = null;
    this.xor = null;
    this.xos = null;
    this.xot = null;
    this.xou = null;
    this.xov = null;
    this.xow = null;
    this.tipDialog = null;
    this.xox = null;
    this.mAppId = "";
    this.xnv = null;
    this.xnw = null;
    this.xnx = null;
    this.xny = null;
    this.xnz = null;
    this.xnA = null;
    this.xnB = null;
    this.errCode = 0;
    this.errMsg = "";
    this.xoy = "";
    this.desc = "";
    this.xoA = "";
    this.headUrl = "";
    this.wNy = false;
    this.xoB = null;
    this.xoC = null;
    this.xoD = false;
    this.wNB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67185);
  }
  
  private void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67194);
    label105:
    String str;
    if ((this.xoC != null) && (!dDO()))
    {
      this.xoh.setVisibility(0);
      this.xoj.setText(this.xoC.name);
      ad.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
      com.tencent.mm.protocal.g.gi(6, 0);
      this.xov.xnZ = this.xnv;
      this.xov.notifyDataSetChanged();
      this.xow.xnZ = this.xnw;
      this.xow.notifyDataSetChanged();
      if (paramBoolean1) {
        break label424;
      }
      this.xot.setVisibility(8);
      this.xou.setVisibility(8);
      if (paramBoolean2) {
        addTextOptionMenu(0, this.xnB.name, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(67164);
            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.i(PhoneRechargeUI.this).CGS, PhoneRechargeUI.i(PhoneRechargeUI.this).hDs, PhoneRechargeUI.i(PhoneRechargeUI.this).name, "")) {}
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
                ad.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousMenuItem, "", new Object[0]);
              }
            }
          }
        });
      }
      TextView localTextView = this.xol;
      if ((this.xnv == null) || (this.xnv.size() <= 0) || (bt.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.xnv.get(0)).CHx))) {
        break label469;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.xnv.get(0)).CHx;
      label196:
      localTextView.setText(str);
      localTextView = this.xom;
      if ((this.xnw == null) || (this.xnw.size() <= 0) || (bt.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.xnw.get(0)).CHx))) {
        break label480;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.xnw.get(0)).CHx;
      label260:
      localTextView.setText(str);
      if ((this.xnA != null) && (!bt.isNullOrNil(this.xnA.name))) {
        break label491;
      }
      this.xoq.setVisibility(8);
      label295:
      if ((this.xnx != null) && (!bt.isNullOrNil(this.xnx.name))) {
        break label531;
      }
      this.xop.setVisibility(8);
      label324:
      if ((this.xny != null) && (!bt.isNullOrNil(this.xny.name))) {
        break label571;
      }
      this.xor.setVisibility(8);
      label353:
      if ((this.xnz != null) && (!bt.isNullOrNil(this.xnz.name))) {
        break label611;
      }
      this.xos.setVisibility(8);
    }
    for (;;)
    {
      if (this.xoF) {
        h(this.xox);
      }
      AppMethodBeat.o(67194);
      return;
      this.xoh.setVisibility(8);
      ad.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break;
      label424:
      if (dDQ()) {
        this.xot.setVisibility(0);
      }
      for (;;)
      {
        if (!dDP()) {
          break label467;
        }
        this.xou.setVisibility(0);
        break;
        this.xot.setVisibility(8);
      }
      label467:
      break label105;
      label469:
      str = getString(2131765780);
      break label196;
      label480:
      str = getString(2131765781);
      break label260;
      label491:
      this.xoq.setVisibility(0);
      this.xoq.setText(this.xnA.name);
      this.xoq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67165);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).CGS, PhoneRechargeUI.j(PhoneRechargeUI.this).hDs, PhoneRechargeUI.j(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).url);
            ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.j(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67165);
        }
      });
      break label295;
      label531:
      this.xop.setVisibility(0);
      this.xop.setText(this.xnx.name);
      this.xop.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67166);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).CGS, PhoneRechargeUI.k(PhoneRechargeUI.this).hDs, PhoneRechargeUI.k(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).url);
            ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.k(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67166);
        }
      });
      break label324;
      label571:
      this.xor.setVisibility(0);
      this.xor.setText(this.xny.name);
      this.xor.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).CGS, PhoneRechargeUI.l(PhoneRechargeUI.this).hDs, PhoneRechargeUI.l(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).url);
            ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.l(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67167);
        }
      });
      break label353;
      label611:
      this.xos.setVisibility(0);
      this.xos.setText(this.xnz.name);
      this.xos.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67168);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).CGS, PhoneRechargeUI.m(PhoneRechargeUI.this).hDs, PhoneRechargeUI.m(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).url);
            ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.m(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67168);
        }
      });
    }
  }
  
  private String avl(String paramString)
  {
    AppMethodBeat.i(67188);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67188);
      return "";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    String str1 = paramString;
    try
    {
      if (this.xoB != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.xoB.xnL != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!bt.isNullOrNil(this.xoB.xnL.name))
          {
            str1 = paramString;
            localObject1 = this.xoB.xnL.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(2131765787))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.xok.getText();
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
        ad.i("MicroMsg.PhoneRechargeUI", "new url");
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
      ad.i("MicroMsg.PhoneRechargeUI", "old url");
      str1 = paramString;
      localObject2 = URLDecoder.decode(paramString, "utf-8");
      str1 = paramString;
      paramString = (String)localObject2 + String.format("?phone=%s&remark=%s", new Object[] { str2, localObject1 });
      AppMethodBeat.o(67188);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ad.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramString, "", new Object[0]);
      AppMethodBeat.o(67188);
    }
    return str1;
  }
  
  private void avm(final String paramString)
  {
    AppMethodBeat.i(67198);
    View localView = z.jO(this).inflate(2131495212, null);
    h.a(getContext(), getString(2131765796), localView, getString(2131765797), getString(2131765795), new DialogInterface.OnClickListener()new PhoneRechargeUI.10
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(67169);
        paramAnonymousDialogInterface = PhoneRechargeUI.b(PhoneRechargeUI.this, paramString);
        ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousDialogInterface });
        PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousDialogInterface, PhoneRechargeUI.this.getString(2131765796), "");
        AppMethodBeat.o(67169);
      }
    }, new PhoneRechargeUI.10(this));
    AppMethodBeat.o(67198);
  }
  
  private void avn(String paramString)
  {
    AppMethodBeat.i(67200);
    h.a(this, paramString, "", false, new PhoneRechargeUI.11(this));
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
    for (this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new PhoneRechargeUI.2(this, paramn));; this.tipDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), true, new PhoneRechargeUI.3(this, paramn)))
    {
      com.tencent.mm.kernel.g.aiU().a(paramn, 0);
      AppMethodBeat.o(67191);
      return;
    }
  }
  
  private void dDN()
  {
    AppMethodBeat.i(67186);
    this.mAppId = "";
    dDR();
    this.errCode = 0;
    this.errMsg = "";
    this.desc = "";
    AppMethodBeat.o(67186);
  }
  
  private boolean dDO()
  {
    AppMethodBeat.i(67189);
    if (this.xoC != null)
    {
      Object localObject1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irh, "");
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split(";");
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 != null) && (localObject2.equals(String.valueOf(this.xoC.id))))
            {
              ad.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
              AppMethodBeat.o(67189);
              return true;
            }
            i += 1;
          }
        }
        ad.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
        AppMethodBeat.o(67189);
        return false;
      }
      ad.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
      AppMethodBeat.o(67189);
      return false;
    }
    ad.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
    AppMethodBeat.o(67189);
    return true;
  }
  
  private boolean dDP()
  {
    AppMethodBeat.i(67195);
    Iterator localIterator = this.xnw.iterator();
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
  
  private boolean dDQ()
  {
    AppMethodBeat.i(67196);
    Iterator localIterator = this.xnv.iterator();
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
  
  private void dDR()
  {
    AppMethodBeat.i(67199);
    this.xnv = new ArrayList();
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
    this.xnv.add(localq1);
    this.xnv.add(localq2);
    this.xnv.add(localq3);
    this.xnv.add(localq4);
    this.xnv.add(localq5);
    this.xnv.add(localq6);
    this.xnw = new ArrayList();
    localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(2131765775);
    localq1.status = 0;
    localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(2131765776);
    localq2.status = 0;
    localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(2131765777);
    localq3.status = 0;
    this.xnw.add(localq1);
    this.xnw.add(localq2);
    this.xnw.add(localq3);
    AppMethodBeat.o(67199);
  }
  
  private void dDS()
  {
    AppMethodBeat.i(67203);
    com.tencent.mm.kernel.g.aiU().a(new com.tencent.mm.plugin.recharge.model.f(this.xok.getText()), 0);
    AppMethodBeat.o(67203);
  }
  
  private void h(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67197);
    if (com.tencent.mm.plugin.recharge.model.b.g(paramMallFunction))
    {
      com.tencent.mm.plugin.recharge.model.b.dDJ();
      if (this.xox.Dbp == null)
      {
        AppMethodBeat.o(67197);
        return;
      }
      ad.d("MicroMsg.PhoneRechargeUI", this.xox.Dbp.toString());
      avm(this.xox.Dbp.DbE);
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
  
  public final void dDT()
  {
    AppMethodBeat.i(67204);
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.g.aiU().a(localf, 0);
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
        this.xoD = true;
        Object localObject1 = null;
        Object localObject4 = null;
        final ArrayList localArrayList = new ArrayList();
        Object localObject3 = paramIntent.getData();
        if (localObject3 == null)
        {
          ad.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
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
                ad.d("MicroMsg.PhoneRechargeUI", "hy: username : ".concat(String.valueOf(localObject1)));
                if (localObject3 != null)
                {
                  ad.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.JV((String)localObject3);
                  ad.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  if ((PhoneNumberUtils.isGlobalPhoneNumber((String)localObject3)) && (((String)localObject3).length() == 11)) {
                    localArrayList.add(localObject3);
                  }
                  ad.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : ".concat(String.valueOf(localObject3)));
                }
                localCursor2.moveToNext();
              }
            }
          }
        }
        catch (SecurityException localSecurityException)
        {
          ad.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[] { localSecurityException.toString() });
          h.c(this, getString(2131761164), "", true);
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
          localObject2 = h.a(this, getString(2131765790), localArrayList, -1, new h.a()
          {
            public final void Nv(int paramAnonymousInt)
            {
              AppMethodBeat.i(67176);
              ad.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
              PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(paramAnonymousInt), this.xoL, 1));
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
          this.xoB.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          dDS();
        }
        else
        {
          h.c(this, getString(2131761162), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.wNy)
            {
              ad.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.xok.getText(), this.xok.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.dDG().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.wNy = true;
            }
          }
          else {
            ad.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
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
    com.tencent.mm.kernel.g.aiU().a(1571, this);
    com.tencent.mm.kernel.g.aiU().a(498, this);
    this.xox = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    this.xoF = getIntent().getBooleanExtra("key_need_show_remind_dialog", true);
    dDR();
    if (this.xox == null)
    {
      ad.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      t.makeText(this, "function info is null", 1).show();
      finish();
      AppMethodBeat.o(67187);
      return;
    }
    setMMTitle(this.xox.dKm);
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
    this.xnB = new com.tencent.mm.plugin.wallet.a.e();
    this.xnB.name = getString(2131765783);
    this.xnB.url = getString(2131765784);
    this.xoh = findViewById(2131303235);
    this.xoi = ((ImageView)findViewById(2131302848));
    this.xoj = ((TextView)findViewById(2131302849));
    this.xok = ((MallFormView)findViewById(2131303820));
    com.tencent.mm.plugin.recharge.ui.form.c.b(this.xok);
    this.xoB = new c.b(this.xok);
    paramBundle = this.xoB;
    ad.d(com.tencent.mm.plugin.recharge.ui.form.c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.xpu;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).xpA != null) {
      ((MallFormView)localObject).xpA.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.xpu.getContentEditText();
    com.tencent.mm.sdk.g.b.c(new c.b.2(paramBundle), "fetch_phone_book");
    paramBundle.xpv = new com.tencent.mm.plugin.recharge.ui.form.d(paramBundle.xpu, paramBundle.xnK);
    paramBundle.xpv.xqh = new c.b.3(paramBundle);
    paramBundle.xpv.xqi = this;
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.xpv);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.xpu.setOnFocusChangeListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.6(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.xon = ((GridView)findViewById(2131303838));
    this.xop = ((TextView)findViewById(2131303844));
    this.xoq = ((TextView)findViewById(2131303845));
    this.xor = ((TextView)findViewById(2131303818));
    this.xos = ((TextView)findViewById(2131303834));
    this.xol = ((TextView)findViewById(2131303840));
    this.xom = ((TextView)findViewById(2131303842));
    this.xoo = ((GridView)findViewById(2131303821));
    this.xot = ((TextView)findViewById(2131303839));
    this.xou = ((TextView)findViewById(2131303841));
    this.xok.setOnInputValidChangeListener(new MallFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(67174);
        if (paramAnonymousBoolean)
        {
          PhoneRechargeUI.this.hideVKB();
          final String str = com.tencent.mm.plugin.recharge.model.b.JV(PhoneRechargeUI.a(PhoneRechargeUI.this).getText());
          if (str == null)
          {
            ad.e("MicroMsg.PhoneRechargeUI", "null phone, return");
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
              ad.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67172);
                  PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(locala);
                  PhoneRechargeUI.avo(PhoneRechargeUI.12.1.this.xoH);
                  AppMethodBeat.o(67172);
                }
              });
              AppMethodBeat.o(67173);
            }
          }, "search_matched_mobile");
          if (!PhoneRechargeUI.c(PhoneRechargeUI.this))
          {
            ad.d("MicroMsg.PhoneRechargeUI", "clear focus");
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
        if (bt.isNullOrNil(PhoneRechargeUI.a(PhoneRechargeUI.this).getText())) {
          ((AutoCompleteTextView)PhoneRechargeUI.a(PhoneRechargeUI.this).getContentEditText()).showDropDown();
        }
        AppMethodBeat.o(67174);
      }
    });
    this.xok.getInfoIv().setOnClickListener(new PhoneRechargeUI.16(this));
    this.xov = new b();
    this.xov.xoa = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67179);
        if (paramAnonymousq == null)
        {
          ad.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
          AppMethodBeat.o(67179);
          return;
        }
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.CGS, paramAnonymousq.hDs, paramAnonymousq.name, paramAnonymousq.desc))
        {
          if (!bt.isNullOrNil(paramAnonymousq.url))
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
    this.xow = new b();
    this.xow.xoa = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67180);
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.CGS, paramAnonymousq.hDs, paramAnonymousq.name, paramAnonymousq.desc))
        {
          if (!bt.isNullOrNil(paramAnonymousq.url))
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
          ad.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
        }
        AppMethodBeat.o(67180);
      }
    };
    this.xon.setAdapter(this.xov);
    this.xoo.setAdapter(this.xow);
    this.xoi.setOnClickListener(new PhoneRechargeUI.19(this));
    this.xoj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67182);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null)
        {
          com.tencent.mm.protocal.g.gi(6, 1);
          if ((PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.f(PhoneRechargeUI.this).CGS, PhoneRechargeUI.f(PhoneRechargeUI.this).hDs, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "")) || (bt.isNullOrNil(PhoneRechargeUI.f(PhoneRechargeUI.this).url))) {}
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
            ad.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousView, "", new Object[0]);
          }
        }
      }
    });
    this.xok.dEc();
    int i = com.tencent.mm.cc.a.ip(this) / 4 - 20;
    ad.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.xop.setMaxWidth(i);
    this.xoq.setMaxWidth(i);
    this.xor.setMaxWidth(i);
    this.xos.setMaxWidth(i);
    this.xoz = getResources().getColor(2131100711);
    if ((this.xoB.xnL != null) && (!bt.isNullOrNil(this.xoB.xnL.name))) {
      this.desc = this.xoB.xnL.name;
    }
    this.xok.getContentEditText().setHintTextColor(getResources().getColor(2131100787));
    if (bt.isNullOrNil(this.xok.getText()))
    {
      c(new com.tencent.mm.plugin.recharge.model.f(""), false);
      AppMethodBeat.o(67187);
      return;
    }
    c(new com.tencent.mm.plugin.recharge.model.f(this.xok.getText()), false);
    AppMethodBeat.o(67187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67193);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(1571, this);
    com.tencent.mm.kernel.g.aiU().b(498, this);
    com.tencent.mm.sdk.b.a.IbL.d(this.wNB);
    AppMethodBeat.o(67193);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67192);
    super.onResume();
    aa(false, true);
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
        if ((!bt.isNullOrNil(paramString.jmL)) && (!paramString.jmL.equals(this.xok.getText())))
        {
          ad.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.jmL, this.xok.getText() });
          AppMethodBeat.o(67201);
          return;
        }
        if (paramString.xnt)
        {
          ad.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          avn(paramString.errMsg);
          dDN();
          AppMethodBeat.o(67201);
          return;
        }
        this.mAppId = paramString.appId;
        this.xnu = paramString.xnu;
        this.xnv = paramString.xnv;
        this.xnx = paramString.xnx;
        this.xny = paramString.xny;
        this.xnz = paramString.xnz;
        this.xnA = paramString.xnA;
        this.errCode = paramString.errCode;
        this.errMsg = paramString.errMsg;
        this.xoy = paramString.desc;
        ad.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.xoy, this.xok.getText() });
        if (bt.isNullOrNil(this.xoy))
        {
          this.desc = "";
          this.xoz = getResources().getColor(2131100711);
        }
        for (;;)
        {
          this.xoC = paramString.xnC;
          this.xnw = paramString.xnw;
          if (this.xnw == null) {
            break;
          }
          paramInt1 = this.xnw.size() - 1;
          while (paramInt1 >= 0)
          {
            paramn = (com.tencent.mm.plugin.wallet.a.q)this.xnw.get(paramInt1);
            if (paramn.name.isEmpty()) {
              this.xnw.remove(paramn);
            }
            paramInt1 -= 1;
          }
          if ((this.xoB.xnL != null) && (this.xoB.xnL.xnb.trim().equals(this.xok.getText())))
          {
            this.xoB.xnL.kcO = this.xoy;
            this.xoB.setInput(this.xoB.xnL);
          }
        }
        if ((paramString.xnB == null) || ((paramString.xnB.name.equals(this.xnB.name)) && (paramString.xnB.url.equals(this.xnB.url)) && (paramString.xnB.CGS.equals(this.xnB.CGS)) && (paramString.xnB.hDs.equals(this.xnB.hDs)))) {
          break label875;
        }
        ad.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.xnB = paramString.xnB;
      }
    }
    label875:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.xoy.equals(""))
      {
        bool2 = false;
        aa(bool2, bool1);
        paramString = paramString.xnD;
        ad.d("MicroMsg.PhoneRechargeUI", "update record history");
        com.tencent.mm.plugin.recharge.a.a.dDG().eW(paramString);
        if (this.xoB != null)
        {
          if (!bt.isNullOrNil(this.xok.getText())) {
            break label626;
          }
          this.xoB.pF(true);
        }
      }
      for (;;)
      {
        this.xok.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67175);
            PhoneRechargeUI.a(PhoneRechargeUI.this).dEd();
            AppMethodBeat.o(67175);
          }
        }, 300L);
        AppMethodBeat.o(67201);
        return;
        bool2 = true;
        break;
        label626:
        this.xoB.pF(false);
      }
      ad.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      AppMethodBeat.o(67201);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        k(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.wallet_core.b.fQJ();
          if ((com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qwl, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_MOBILE_FEE_PAY_SWTICH_KEY"))) {}
          for (paramInt1 = i;; paramInt1 = 0)
          {
            paramString = (com.tencent.mm.plugin.recharge.model.g)paramn;
            if (paramInt1 == 0) {
              break;
            }
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(paramString.xnF.dlu, 6);
            com.tencent.mm.sdk.b.a.IbL.c(this.wNB);
            AppMethodBeat.o(67201);
            return;
          }
          paramn = paramString.xnF;
          paramn.dCC = 6;
          paramn.FlP = 100;
          paramn.oyb = this.xok.getText();
          if (this.xoB.xnL != null) {}
          for (paramString = this.xoB.xnL.name;; paramString = "")
          {
            paramn.iTM = paramString;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 2);
            break;
          }
        }
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = getString(2131765901);
        }
        avn(paramn);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI
 * JD-Core Version:    0.7.0.1
 */