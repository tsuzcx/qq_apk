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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView.a;
import com.tencent.mm.plugin.recharge.ui.form.c;
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
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.u;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI
  extends MMActivity
  implements i, d.a
{
  private int BDq;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> BDr;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> BDs;
  private com.tencent.mm.plugin.wallet.a.e BDt;
  private com.tencent.mm.plugin.wallet.a.e BDu;
  private com.tencent.mm.plugin.wallet.a.e BDv;
  private com.tencent.mm.plugin.wallet.a.e BDw;
  private com.tencent.mm.plugin.wallet.a.e BDx;
  private boolean BEA;
  private View BEd;
  private ImageView BEe;
  private TextView BEf;
  private MallFormView BEg;
  private TextView BEh;
  private TextView BEi;
  private GridView BEj;
  private GridView BEk;
  private TextView BEl;
  private TextView BEm;
  private TextView BEn;
  private TextView BEo;
  private TextView BEp;
  private TextView BEq;
  private b BEr;
  private b BEs;
  private MallFunction BEt;
  private String BEu;
  private String BEv;
  private c.b BEw;
  private p BEx;
  private boolean BEy;
  private List<String[]> BEz;
  private boolean BaO;
  private IListener BaR;
  private String desc;
  private int errCode;
  private String errMsg;
  private String headUrl;
  private String mAppId;
  protected Dialog tipDialog;
  private int wnT;
  
  public PhoneRechargeUI()
  {
    AppMethodBeat.i(67185);
    this.BEd = null;
    this.BEe = null;
    this.BEf = null;
    this.BEg = null;
    this.BEh = null;
    this.BEi = null;
    this.BEj = null;
    this.BEk = null;
    this.BEl = null;
    this.BEm = null;
    this.BEn = null;
    this.BEo = null;
    this.BEp = null;
    this.BEq = null;
    this.BEr = null;
    this.BEs = null;
    this.tipDialog = null;
    this.BEt = null;
    this.mAppId = "";
    this.BDr = null;
    this.BDs = null;
    this.BDt = null;
    this.BDu = null;
    this.BDv = null;
    this.BDw = null;
    this.BDx = null;
    this.errCode = 0;
    this.errMsg = "";
    this.BEu = "";
    this.desc = "";
    this.BEv = "";
    this.headUrl = "";
    this.BaO = false;
    this.BEw = null;
    this.BEx = null;
    this.BEy = false;
    this.BaR = new IListener() {};
    AppMethodBeat.o(67185);
  }
  
  private String aKS(String paramString)
  {
    AppMethodBeat.i(67188);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67188);
      return "";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    String str1 = paramString;
    try
    {
      if (this.BEw != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.BEw.BDH != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!Util.isNullOrNil(this.BEw.BDH.name))
          {
            str1 = paramString;
            localObject1 = this.BEw.BDH.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(2131768240))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.BEg.getText();
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
        Log.i("MicroMsg.PhoneRechargeUI", "new url");
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
      Log.i("MicroMsg.PhoneRechargeUI", "old url");
      str1 = paramString;
      localObject2 = URLDecoder.decode(paramString, "utf-8");
      str1 = paramString;
      paramString = (String)localObject2 + String.format("?phone=%s&remark=%s", new Object[] { str2, localObject1 });
      AppMethodBeat.o(67188);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramString, "", new Object[0]);
      AppMethodBeat.o(67188);
    }
    return str1;
  }
  
  private void aKT(final String paramString)
  {
    AppMethodBeat.i(67198);
    View localView = aa.jQ(this).inflate(2131496055, null);
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131768249), localView, getString(2131768250), getString(2131768248), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(67169);
        paramAnonymousDialogInterface = PhoneRechargeUI.b(PhoneRechargeUI.this, paramString);
        Log.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousDialogInterface });
        PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousDialogInterface, PhoneRechargeUI.this.getString(2131768249), "");
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
  
  private void aKU(String paramString)
  {
    AppMethodBeat.i(67200);
    com.tencent.mm.ui.base.h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(67171);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(67171);
      }
    });
    AppMethodBeat.o(67200);
  }
  
  private void ad(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67194);
    label105:
    String str;
    if ((this.BEx != null) && (!eHT()))
    {
      this.BEd.setVisibility(0);
      this.BEf.setText(this.BEx.name);
      Log.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
      com.tencent.mm.protocal.g.gH(6, 0);
      this.BEr.BDV = this.BDr;
      this.BEr.notifyDataSetChanged();
      this.BEs.BDV = this.BDs;
      this.BEs.notifyDataSetChanged();
      if (paramBoolean1) {
        break label424;
      }
      this.BEp.setVisibility(8);
      this.BEq.setVisibility(8);
      if (paramBoolean2) {
        addTextOptionMenu(0, this.BDx.name, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(67164);
            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.i(PhoneRechargeUI.this).HEm, PhoneRechargeUI.i(PhoneRechargeUI.this).weappPath, PhoneRechargeUI.i(PhoneRechargeUI.this).name, "")) {}
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
                Log.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousMenuItem, "", new Object[0]);
              }
            }
          }
        });
      }
      TextView localTextView = this.BEh;
      if ((this.BDr == null) || (this.BDr.size() <= 0) || (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.BDr.get(0)).HER))) {
        break label469;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.BDr.get(0)).HER;
      label196:
      localTextView.setText(str);
      localTextView = this.BEi;
      if ((this.BDs == null) || (this.BDs.size() <= 0) || (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.BDs.get(0)).HER))) {
        break label480;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.BDs.get(0)).HER;
      label260:
      localTextView.setText(str);
      if ((this.BDw != null) && (!Util.isNullOrNil(this.BDw.name))) {
        break label491;
      }
      this.BEm.setVisibility(8);
      label295:
      if ((this.BDt != null) && (!Util.isNullOrNil(this.BDt.name))) {
        break label531;
      }
      this.BEl.setVisibility(8);
      label324:
      if ((this.BDu != null) && (!Util.isNullOrNil(this.BDu.name))) {
        break label571;
      }
      this.BEn.setVisibility(8);
      label353:
      if ((this.BDv != null) && (!Util.isNullOrNil(this.BDv.name))) {
        break label611;
      }
      this.BEo.setVisibility(8);
    }
    for (;;)
    {
      if (this.BEA) {
        h(this.BEt);
      }
      AppMethodBeat.o(67194);
      return;
      this.BEd.setVisibility(8);
      Log.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break;
      label424:
      if (eHV()) {
        this.BEp.setVisibility(0);
      }
      for (;;)
      {
        if (!eHU()) {
          break label467;
        }
        this.BEq.setVisibility(0);
        break;
        this.BEp.setVisibility(8);
      }
      label467:
      break label105;
      label469:
      str = getString(2131768233);
      break label196;
      label480:
      str = getString(2131768234);
      break label260;
      label491:
      this.BEm.setVisibility(0);
      this.BEm.setText(this.BDw.name);
      this.BEm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67165);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).HEm, PhoneRechargeUI.j(PhoneRechargeUI.this).weappPath, PhoneRechargeUI.j(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).url);
            Log.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.j(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67165);
        }
      });
      break label295;
      label531:
      this.BEl.setVisibility(0);
      this.BEl.setText(this.BDt.name);
      this.BEl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67166);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).HEm, PhoneRechargeUI.k(PhoneRechargeUI.this).weappPath, PhoneRechargeUI.k(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).url);
            Log.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.k(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67166);
        }
      });
      break label324;
      label571:
      this.BEn.setVisibility(0);
      this.BEn.setText(this.BDu.name);
      this.BEn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).HEm, PhoneRechargeUI.l(PhoneRechargeUI.this).weappPath, PhoneRechargeUI.l(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).url);
            Log.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.l(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67167);
        }
      });
      break label353;
      label611:
      this.BEo.setVisibility(0);
      this.BEo.setText(this.BDv.name);
      this.BEo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67168);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).HEm, PhoneRechargeUI.m(PhoneRechargeUI.this).weappPath, PhoneRechargeUI.m(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).url);
            Log.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.m(PhoneRechargeUI.this).name, "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67168);
        }
      });
    }
  }
  
  private void c(com.tencent.mm.ak.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(67191);
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      if (!paramBoolean) {
        break label71;
      }
    }
    label71:
    for (this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), true, new PhoneRechargeUI.2(this, paramq));; this.tipDialog = com.tencent.mm.wallet_core.ui.h.c(getContext(), true, new PhoneRechargeUI.3(this, paramq)))
    {
      com.tencent.mm.kernel.g.azz().a(paramq, 0);
      AppMethodBeat.o(67191);
      return;
    }
  }
  
  private void eHS()
  {
    AppMethodBeat.i(67186);
    this.mAppId = "";
    eHW();
    this.errCode = 0;
    this.errMsg = "";
    this.desc = "";
    AppMethodBeat.o(67186);
  }
  
  private boolean eHT()
  {
    AppMethodBeat.i(67189);
    if (this.BEx != null)
    {
      Object localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTF, "");
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split(";");
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 != null) && (localObject2.equals(String.valueOf(this.BEx.id))))
            {
              Log.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
              AppMethodBeat.o(67189);
              return true;
            }
            i += 1;
          }
        }
        Log.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
        AppMethodBeat.o(67189);
        return false;
      }
      Log.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
      AppMethodBeat.o(67189);
      return false;
    }
    Log.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
    AppMethodBeat.o(67189);
    return true;
  }
  
  private boolean eHU()
  {
    AppMethodBeat.i(67195);
    Iterator localIterator = this.BDs.iterator();
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
  
  private boolean eHV()
  {
    AppMethodBeat.i(67196);
    Iterator localIterator = this.BDr.iterator();
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
  
  private void eHW()
  {
    AppMethodBeat.i(67199);
    this.BDr = new ArrayList();
    com.tencent.mm.plugin.wallet.a.q localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(2131768222);
    localq1.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(2131768223);
    localq2.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(2131768224);
    localq3.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq4 = new com.tencent.mm.plugin.wallet.a.q();
    localq4.name = getString(2131768225);
    localq4.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq5 = new com.tencent.mm.plugin.wallet.a.q();
    localq5.name = getString(2131768226);
    localq5.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq6 = new com.tencent.mm.plugin.wallet.a.q();
    localq6.name = getString(2131768227);
    localq6.status = 0;
    this.BDr.add(localq1);
    this.BDr.add(localq2);
    this.BDr.add(localq3);
    this.BDr.add(localq4);
    this.BDr.add(localq5);
    this.BDr.add(localq6);
    this.BDs = new ArrayList();
    localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(2131768228);
    localq1.status = 0;
    localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(2131768229);
    localq2.status = 0;
    localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(2131768230);
    localq3.status = 0;
    this.BDs.add(localq1);
    this.BDs.add(localq2);
    this.BDs.add(localq3);
    AppMethodBeat.o(67199);
  }
  
  private void eHX()
  {
    AppMethodBeat.i(67203);
    com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.recharge.model.f(this.BEg.getText()), 0);
    AppMethodBeat.o(67203);
  }
  
  private void h(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67197);
    if (com.tencent.mm.plugin.recharge.model.b.g(paramMallFunction))
    {
      com.tencent.mm.plugin.recharge.model.b.eHO();
      if (this.BEt.Icf == null)
      {
        AppMethodBeat.o(67197);
        return;
      }
      Log.d("MicroMsg.PhoneRechargeUI", this.BEt.Icf.toString());
      aKT(this.BEt.Icf.Ict);
    }
    AppMethodBeat.o(67197);
  }
  
  private void m(com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(67190);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramq.getType() != 497))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(67190);
  }
  
  public final void eHY()
  {
    AppMethodBeat.i(67204);
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.g.azz().a(localf, 0);
    AppMethodBeat.o(67204);
  }
  
  public int getLayoutId()
  {
    return 2131495920;
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
        this.BEy = true;
        Object localObject1 = null;
        Object localObject4 = null;
        final ArrayList localArrayList = new ArrayList();
        Object localObject3 = paramIntent.getData();
        if (localObject3 == null)
        {
          Log.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
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
                Log.d("MicroMsg.PhoneRechargeUI", "hy: username : ".concat(String.valueOf(localObject1)));
                if (localObject3 != null)
                {
                  Log.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.Ts((String)localObject3);
                  Log.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  if ((PhoneNumberUtils.isGlobalPhoneNumber((String)localObject3)) && (((String)localObject3).length() == 11)) {
                    localArrayList.add(localObject3);
                  }
                  Log.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : ".concat(String.valueOf(localObject3)));
                }
                localCursor2.moveToNext();
              }
            }
          }
        }
        catch (SecurityException localSecurityException)
        {
          Log.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[] { localSecurityException.toString() });
          com.tencent.mm.ui.base.h.c(this, getString(2131762951), "", true);
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
          localObject2 = com.tencent.mm.ui.base.h.a(this, getString(2131768243), localArrayList, -1, new h.a()
          {
            public final void Vq(int paramAnonymousInt)
            {
              AppMethodBeat.i(67176);
              Log.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
              PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(paramAnonymousInt), this.BEG, 1));
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
          this.BEw.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          eHX();
        }
        else
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131762949), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.BaO)
            {
              Log.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.BEg.getText(), this.BEg.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.eHL().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.BaO = true;
            }
          }
          else {
            Log.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
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
    com.tencent.mm.kernel.g.azz().a(1571, this);
    com.tencent.mm.kernel.g.azz().a(498, this);
    this.BEt = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    this.BEA = getIntent().getBooleanExtra("key_need_show_remind_dialog", true);
    eHW();
    if (this.BEt == null)
    {
      Log.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      u.makeText(this, "function info is null", 1).show();
      finish();
      AppMethodBeat.o(67187);
      return;
    }
    setMMTitle(this.BEt.edq);
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
    this.BDx = new com.tencent.mm.plugin.wallet.a.e();
    this.BDx.name = getString(2131768236);
    this.BDx.url = getString(2131768237);
    this.BEd = findViewById(2131305903);
    this.BEe = ((ImageView)findViewById(2131305418));
    this.BEf = ((TextView)findViewById(2131305419));
    this.BEg = ((MallFormView)findViewById(2131306627));
    c.b(this.BEg);
    this.BEw = new c.b(this.BEg);
    paramBundle = this.BEw;
    Log.d(c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.BFp;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).BFv != null) {
      ((MallFormView)localObject).BFv.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.BFp.getContentEditText();
    ThreadPool.post(new c.b.2(paramBundle), "fetch_phone_book");
    paramBundle.BFq = new com.tencent.mm.plugin.recharge.ui.form.d(paramBundle.BFp, paramBundle.BDG);
    paramBundle.BFq.BGd = new c.b.3(paramBundle);
    paramBundle.BFq.BGe = this;
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.BFq);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.BFp.setOnFocusChangeListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.6(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.BEj = ((GridView)findViewById(2131306645));
    this.BEl = ((TextView)findViewById(2131306653));
    this.BEm = ((TextView)findViewById(2131306654));
    this.BEn = ((TextView)findViewById(2131306625));
    this.BEo = ((TextView)findViewById(2131306641));
    this.BEh = ((TextView)findViewById(2131306647));
    this.BEi = ((TextView)findViewById(2131306649));
    this.BEk = ((GridView)findViewById(2131306628));
    this.BEp = ((TextView)findViewById(2131306646));
    this.BEq = ((TextView)findViewById(2131306648));
    this.BEg.setOnInputValidChangeListener(new MallFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(67174);
        if (paramAnonymousBoolean)
        {
          PhoneRechargeUI.this.hideVKB();
          final String str = com.tencent.mm.plugin.recharge.model.b.Ts(PhoneRechargeUI.a(PhoneRechargeUI.this).getText());
          if (str == null)
          {
            Log.e("MicroMsg.PhoneRechargeUI", "null phone, return");
            AppMethodBeat.o(67174);
            return;
          }
          ThreadPool.postAtFront(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67173);
              long l = System.currentTimeMillis();
              final com.tencent.mm.plugin.recharge.model.a locala = PhoneRechargeUI.a(PhoneRechargeUI.this, str);
              Log.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67172);
                  PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(locala);
                  PhoneRechargeUI.aKV(PhoneRechargeUI.12.1.this.BEC);
                  AppMethodBeat.o(67172);
                }
              });
              AppMethodBeat.o(67173);
            }
          }, "search_matched_mobile");
          if (!PhoneRechargeUI.c(PhoneRechargeUI.this))
          {
            Log.d("MicroMsg.PhoneRechargeUI", "clear focus");
            PhoneRechargeUI.a(PhoneRechargeUI.this, true);
            AppMethodBeat.o(67174);
            return;
          }
          PhoneRechargeUI.a(PhoneRechargeUI.this, false);
          AppMethodBeat.o(67174);
          return;
        }
        PhoneRechargeUI.a(PhoneRechargeUI.this).getTipsTv().setText("");
        PhoneRechargeUI.a(PhoneRechargeUI.this).getTipsTv().setTextColor(PhoneRechargeUI.this.getResources().getColor(2131100904));
        PhoneRechargeUI.d(PhoneRechargeUI.this);
        PhoneRechargeUI.e(PhoneRechargeUI.this);
        if (Util.isNullOrNil(PhoneRechargeUI.a(PhoneRechargeUI.this).getText())) {
          ((AutoCompleteTextView)PhoneRechargeUI.a(PhoneRechargeUI.this).getContentEditText()).showDropDown();
        }
        AppMethodBeat.o(67174);
      }
    });
    this.BEg.getInfoIv().setOnClickListener(new PhoneRechargeUI.16(this));
    this.BEr = new b();
    this.BEr.BDW = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67179);
        if (paramAnonymousq == null)
        {
          Log.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
          AppMethodBeat.o(67179);
          return;
        }
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.HEm, paramAnonymousq.weappPath, paramAnonymousq.name, paramAnonymousq.desc))
        {
          if (!Util.isNullOrNil(paramAnonymousq.url))
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
    this.BEs = new b();
    this.BEs.BDW = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67180);
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.HEm, paramAnonymousq.weappPath, paramAnonymousq.name, paramAnonymousq.desc))
        {
          if (!Util.isNullOrNil(paramAnonymousq.url))
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
          Log.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
        }
        AppMethodBeat.o(67180);
      }
    };
    this.BEj.setAdapter(this.BEr);
    this.BEk.setAdapter(this.BEs);
    this.BEe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67181);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null) {
          PhoneRechargeUI.g(PhoneRechargeUI.this);
        }
        for (;;)
        {
          PhoneRechargeUI.h(PhoneRechargeUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67181);
          return;
          Log.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
        }
      }
    });
    this.BEf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67182);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null)
        {
          com.tencent.mm.protocal.g.gH(6, 1);
          if ((PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.f(PhoneRechargeUI.this).HEm, PhoneRechargeUI.f(PhoneRechargeUI.this).weappPath, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "")) || (Util.isNullOrNil(PhoneRechargeUI.f(PhoneRechargeUI.this).url))) {}
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
            Log.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousView, "", new Object[0]);
          }
        }
      }
    });
    this.BEg.eIh();
    int i = com.tencent.mm.cb.a.jn(this) / 4 - 20;
    Log.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.BEl.setMaxWidth(i);
    this.BEm.setMaxWidth(i);
    this.BEn.setMaxWidth(i);
    this.BEo.setMaxWidth(i);
    this.wnT = getResources().getColor(2131100904);
    if ((this.BEw.BDH != null) && (!Util.isNullOrNil(this.BEw.BDH.name))) {
      this.desc = this.BEw.BDH.name;
    }
    this.BEg.getContentEditText().setHintTextColor(getResources().getColor(2131100983));
    if (Util.isNullOrNil(this.BEg.getText()))
    {
      c(new com.tencent.mm.plugin.recharge.model.f(""), false);
      AppMethodBeat.o(67187);
      return;
    }
    c(new com.tencent.mm.plugin.recharge.model.f(this.BEg.getText()), false);
    AppMethodBeat.o(67187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67193);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(1571, this);
    com.tencent.mm.kernel.g.azz().b(498, this);
    EventCenter.instance.removeListener(this.BaR);
    AppMethodBeat.o(67193);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67192);
    super.onResume();
    ad(false, true);
    AppMethodBeat.o(67192);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(67201);
    if ((paramq instanceof com.tencent.mm.plugin.recharge.model.f))
    {
      paramString = (com.tencent.mm.plugin.recharge.model.f)paramq;
      m(paramq);
      if (paramString.cmdId == 0)
      {
        if ((!Util.isNullOrNil(paramString.knP)) && (!paramString.knP.equals(this.BEg.getText())))
        {
          Log.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.knP, this.BEg.getText() });
          AppMethodBeat.o(67201);
          return;
        }
        if (paramString.BDp)
        {
          Log.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          aKU(paramString.errMsg);
          eHS();
          AppMethodBeat.o(67201);
          return;
        }
        this.mAppId = paramString.appId;
        this.BDq = paramString.BDq;
        this.BDr = paramString.BDr;
        this.BDt = paramString.BDt;
        this.BDu = paramString.BDu;
        this.BDv = paramString.BDv;
        this.BDw = paramString.BDw;
        this.errCode = paramString.errCode;
        this.errMsg = paramString.errMsg;
        this.BEu = paramString.desc;
        Log.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.BEu, this.BEg.getText() });
        if (Util.isNullOrNil(this.BEu))
        {
          this.desc = "";
          this.wnT = getResources().getColor(2131100904);
        }
        for (;;)
        {
          this.BEx = paramString.BDy;
          this.BDs = paramString.BDs;
          if (this.BDs == null) {
            break;
          }
          paramInt1 = this.BDs.size() - 1;
          while (paramInt1 >= 0)
          {
            paramq = (com.tencent.mm.plugin.wallet.a.q)this.BDs.get(paramInt1);
            if (paramq.name.isEmpty()) {
              this.BDs.remove(paramq);
            }
            paramInt1 -= 1;
          }
          if ((this.BEw.BDH != null) && (this.BEw.BDH.BCX.trim().equals(this.BEg.getText())))
          {
            this.BEw.BDH.ljO = this.BEu;
            this.BEw.setInput(this.BEw.BDH);
          }
        }
        if ((paramString.BDx == null) || ((paramString.BDx.name.equals(this.BDx.name)) && (paramString.BDx.url.equals(this.BDx.url)) && (paramString.BDx.HEm.equals(this.BDx.HEm)) && (paramString.BDx.weappPath.equals(this.BDx.weappPath)))) {
          break label844;
        }
        Log.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.BDx = paramString.BDx;
      }
    }
    label844:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.BEu.equals(""))
      {
        bool2 = false;
        ad(bool2, bool1);
        paramString = paramString.BDz;
        Log.d("MicroMsg.PhoneRechargeUI", "update record history");
        com.tencent.mm.plugin.recharge.a.a.eHL().ga(paramString);
        if (this.BEw != null)
        {
          if (!Util.isNullOrNil(this.BEg.getText())) {
            break label623;
          }
          this.BEw.sY(true);
        }
      }
      for (;;)
      {
        this.BEg.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67175);
            PhoneRechargeUI.a(PhoneRechargeUI.this).eIi();
            AppMethodBeat.o(67175);
          }
        }, 300L);
        AppMethodBeat.o(67201);
        return;
        bool2 = true;
        break;
        label623:
        this.BEw.sY(false);
      }
      Log.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      AppMethodBeat.o(67201);
      return;
      if ((paramq instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        m(paramq);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.wallet_core.b.hgC();
          bool1 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.rWd, true);
          paramString = (com.tencent.mm.plugin.recharge.model.g)paramq;
          if (bool1)
          {
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(paramString.BDB.dDL, 6);
            EventCenter.instance.addListener(this.BaR);
            AppMethodBeat.o(67201);
            return;
          }
          paramq = paramString.BDB;
          paramq.dVv = 6;
          paramq.Kxr = 100;
          paramq.pSm = this.BEg.getText();
          if (this.BEw.BDH != null) {}
          for (paramString = this.BEw.BDH.name;; paramString = "")
          {
            paramq.remark = paramString;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramq, 2);
            break;
          }
        }
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(2131768354);
        }
        aKU(paramq);
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