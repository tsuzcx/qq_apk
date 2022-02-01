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
import com.tencent.mm.g.a.xv;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  implements com.tencent.mm.ak.g, d.a
{
  private String desc;
  private int errCode;
  private String errMsg;
  private String headUrl;
  private String mAppId;
  protected Dialog tipDialog;
  private boolean vGr;
  private com.tencent.mm.sdk.b.c vGu;
  private int wfM;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> wfN;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> wfO;
  private com.tencent.mm.plugin.wallet.a.e wfP;
  private com.tencent.mm.plugin.wallet.a.e wfQ;
  private com.tencent.mm.plugin.wallet.a.e wfR;
  private com.tencent.mm.plugin.wallet.a.e wfS;
  private com.tencent.mm.plugin.wallet.a.e wfT;
  private ImageView wgA;
  private TextView wgB;
  private MallFormView wgC;
  private TextView wgD;
  private TextView wgE;
  private GridView wgF;
  private GridView wgG;
  private TextView wgH;
  private TextView wgI;
  private TextView wgJ;
  private TextView wgK;
  private TextView wgL;
  private TextView wgM;
  private b wgN;
  private b wgO;
  private MallFunction wgP;
  private String wgQ;
  private int wgR;
  private String wgS;
  private c.b wgT;
  private p wgU;
  private boolean wgV;
  private List<String[]> wgW;
  private View wgz;
  
  public PhoneRechargeUI()
  {
    AppMethodBeat.i(67185);
    this.wgz = null;
    this.wgA = null;
    this.wgB = null;
    this.wgC = null;
    this.wgD = null;
    this.wgE = null;
    this.wgF = null;
    this.wgG = null;
    this.wgH = null;
    this.wgI = null;
    this.wgJ = null;
    this.wgK = null;
    this.wgL = null;
    this.wgM = null;
    this.wgN = null;
    this.wgO = null;
    this.tipDialog = null;
    this.wgP = null;
    this.mAppId = "";
    this.wfN = null;
    this.wfO = null;
    this.wfP = null;
    this.wfQ = null;
    this.wfR = null;
    this.wfS = null;
    this.wfT = null;
    this.errCode = 0;
    this.errMsg = "";
    this.wgQ = "";
    this.desc = "";
    this.wgS = "";
    this.headUrl = "";
    this.vGr = false;
    this.wgT = null;
    this.wgU = null;
    this.wgV = false;
    this.vGu = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67185);
  }
  
  private void W(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67194);
    label103:
    String str;
    if ((this.wgU != null) && (!dtr()))
    {
      this.wgz.setVisibility(0);
      this.wgB.setText(this.wgU.name);
      ac.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
      com.tencent.mm.protocal.g.fS(6, 0);
      this.wgN.wgr = this.wfN;
      this.wgN.notifyDataSetChanged();
      this.wgO.wgr = this.wfO;
      this.wgO.notifyDataSetChanged();
      if (paramBoolean1) {
        break label414;
      }
      this.wgL.setVisibility(8);
      this.wgM.setVisibility(8);
      if (paramBoolean2) {
        addTextOptionMenu(0, this.wfT.name, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(67164);
            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.i(PhoneRechargeUI.this).BgE, PhoneRechargeUI.i(PhoneRechargeUI.this).hlj, PhoneRechargeUI.i(PhoneRechargeUI.this).name, "")) {}
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
                ac.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousMenuItem, "", new Object[0]);
              }
            }
          }
        });
      }
      TextView localTextView = this.wgD;
      if ((this.wfN == null) || (this.wfN.size() <= 0) || (bs.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.wfN.get(0)).Bhj))) {
        break label459;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.wfN.get(0)).Bhj;
      label194:
      localTextView.setText(str);
      localTextView = this.wgE;
      if ((this.wfO == null) || (this.wfO.size() <= 0) || (bs.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.wfO.get(0)).Bhj))) {
        break label470;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.wfO.get(0)).Bhj;
      label258:
      localTextView.setText(str);
      if ((this.wfS != null) && (!bs.isNullOrNil(this.wfS.name))) {
        break label481;
      }
      this.wgI.setVisibility(8);
      label293:
      if ((this.wfP != null) && (!bs.isNullOrNil(this.wfP.name))) {
        break label521;
      }
      this.wgH.setVisibility(8);
      label322:
      if ((this.wfQ != null) && (!bs.isNullOrNil(this.wfQ.name))) {
        break label561;
      }
      this.wgJ.setVisibility(8);
      label351:
      if ((this.wfR != null) && (!bs.isNullOrNil(this.wfR.name))) {
        break label601;
      }
      this.wgK.setVisibility(8);
    }
    for (;;)
    {
      d(this.wgP);
      AppMethodBeat.o(67194);
      return;
      this.wgz.setVisibility(8);
      ac.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break;
      label414:
      if (dtt()) {
        this.wgL.setVisibility(0);
      }
      for (;;)
      {
        if (!dts()) {
          break label457;
        }
        this.wgM.setVisibility(0);
        break;
        this.wgL.setVisibility(8);
      }
      label457:
      break label103;
      label459:
      str = getString(2131765780);
      break label194;
      label470:
      str = getString(2131765781);
      break label258;
      label481:
      this.wgI.setVisibility(0);
      this.wgI.setText(this.wfS.name);
      this.wgI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67165);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).BgE, PhoneRechargeUI.j(PhoneRechargeUI.this).hlj, PhoneRechargeUI.j(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).url);
            ac.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.j(PhoneRechargeUI.this).name, "");
          }
          AppMethodBeat.o(67165);
        }
      });
      break label293;
      label521:
      this.wgH.setVisibility(0);
      this.wgH.setText(this.wfP.name);
      this.wgH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67166);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).BgE, PhoneRechargeUI.k(PhoneRechargeUI.this).hlj, PhoneRechargeUI.k(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).url);
            ac.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.k(PhoneRechargeUI.this).name, "");
          }
          AppMethodBeat.o(67166);
        }
      });
      break label322;
      label561:
      this.wgJ.setVisibility(0);
      this.wgJ.setText(this.wfQ.name);
      this.wgJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67167);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).BgE, PhoneRechargeUI.l(PhoneRechargeUI.this).hlj, PhoneRechargeUI.l(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).url);
            ac.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.l(PhoneRechargeUI.this).name, "");
          }
          AppMethodBeat.o(67167);
        }
      });
      break label351;
      label601:
      this.wgK.setVisibility(0);
      this.wgK.setText(this.wfR.name);
      this.wgK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67168);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).BgE, PhoneRechargeUI.m(PhoneRechargeUI.this).hlj, PhoneRechargeUI.m(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).url);
            ac.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.m(PhoneRechargeUI.this).name, "");
          }
          AppMethodBeat.o(67168);
        }
      });
    }
  }
  
  private String aqm(String paramString)
  {
    AppMethodBeat.i(67188);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67188);
      return "";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    String str1 = paramString;
    try
    {
      if (this.wgT != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.wgT.wgd != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!bs.isNullOrNil(this.wgT.wgd.name))
          {
            str1 = paramString;
            localObject1 = this.wgT.wgd.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(2131765787))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.wgC.getText();
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
        ac.i("MicroMsg.PhoneRechargeUI", "new url");
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
      ac.i("MicroMsg.PhoneRechargeUI", "old url");
      str1 = paramString;
      localObject2 = URLDecoder.decode(paramString, "utf-8");
      str1 = paramString;
      paramString = (String)localObject2 + String.format("?phone=%s&remark=%s", new Object[] { str2, localObject1 });
      AppMethodBeat.o(67188);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ac.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramString, "", new Object[0]);
      AppMethodBeat.o(67188);
    }
    return str1;
  }
  
  private void aqn(final String paramString)
  {
    AppMethodBeat.i(67198);
    View localView = z.jD(this).inflate(2131495212, null);
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131765796), localView, getString(2131765797), getString(2131765795), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(67169);
        paramAnonymousDialogInterface = PhoneRechargeUI.b(PhoneRechargeUI.this, paramString);
        ac.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousDialogInterface });
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
  
  private void aqo(String paramString)
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
    for (this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new PhoneRechargeUI.2(this, paramn));; this.tipDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), true, new PhoneRechargeUI.3(this, paramn)))
    {
      com.tencent.mm.kernel.g.agi().a(paramn, 0);
      AppMethodBeat.o(67191);
      return;
    }
  }
  
  private void d(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67197);
    if (com.tencent.mm.plugin.recharge.model.b.c(paramMallFunction))
    {
      com.tencent.mm.plugin.recharge.model.b.dtm();
      ac.d("MicroMsg.PhoneRechargeUI", this.wgP.BAX.toString());
      aqn(this.wgP.BAX.BBm);
    }
    AppMethodBeat.o(67197);
  }
  
  private void dtq()
  {
    AppMethodBeat.i(67186);
    this.mAppId = "";
    dtu();
    this.errCode = 0;
    this.errMsg = "";
    this.desc = "";
    AppMethodBeat.o(67186);
  }
  
  private boolean dtr()
  {
    AppMethodBeat.i(67189);
    if (this.wgU != null)
    {
      Object localObject1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEO, "");
      if (!bs.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split(";");
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 != null) && (localObject2.equals(String.valueOf(this.wgU.id))))
            {
              ac.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
              AppMethodBeat.o(67189);
              return true;
            }
            i += 1;
          }
        }
        ac.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
        AppMethodBeat.o(67189);
        return false;
      }
      ac.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
      AppMethodBeat.o(67189);
      return false;
    }
    ac.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
    AppMethodBeat.o(67189);
    return true;
  }
  
  private boolean dts()
  {
    AppMethodBeat.i(67195);
    Iterator localIterator = this.wfO.iterator();
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
  
  private boolean dtt()
  {
    AppMethodBeat.i(67196);
    Iterator localIterator = this.wfN.iterator();
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
  
  private void dtu()
  {
    AppMethodBeat.i(67199);
    this.wfN = new ArrayList();
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
    this.wfN.add(localq1);
    this.wfN.add(localq2);
    this.wfN.add(localq3);
    this.wfN.add(localq4);
    this.wfN.add(localq5);
    this.wfN.add(localq6);
    this.wfO = new ArrayList();
    localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(2131765775);
    localq1.status = 0;
    localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(2131765776);
    localq2.status = 0;
    localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(2131765777);
    localq3.status = 0;
    this.wfO.add(localq1);
    this.wfO.add(localq2);
    this.wfO.add(localq3);
    AppMethodBeat.o(67199);
  }
  
  private void dtv()
  {
    AppMethodBeat.i(67203);
    com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.plugin.recharge.model.f(this.wgC.getText()), 0);
    AppMethodBeat.o(67203);
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
  
  public final void dtw()
  {
    AppMethodBeat.i(67204);
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.g.agi().a(localf, 0);
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
        this.wgV = true;
        Object localObject1 = null;
        Object localObject4 = null;
        final ArrayList localArrayList = new ArrayList();
        Object localObject3 = paramIntent.getData();
        if (localObject3 == null)
        {
          ac.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
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
                ac.d("MicroMsg.PhoneRechargeUI", "hy: username : ".concat(String.valueOf(localObject1)));
                if (localObject3 != null)
                {
                  ac.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.GG((String)localObject3);
                  ac.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  if ((PhoneNumberUtils.isGlobalPhoneNumber((String)localObject3)) && (((String)localObject3).length() == 11)) {
                    localArrayList.add(localObject3);
                  }
                  ac.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : ".concat(String.valueOf(localObject3)));
                }
                localCursor2.moveToNext();
              }
            }
          }
        }
        catch (SecurityException localSecurityException)
        {
          ac.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[] { localSecurityException.toString() });
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
            public final void LW(int paramAnonymousInt)
            {
              AppMethodBeat.i(67176);
              ac.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
              PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(paramAnonymousInt), this.whc, 1));
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
          this.wgT.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          dtv();
        }
        else
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131761162), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.vGr)
            {
              ac.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.wgC.getText(), this.wgC.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.dtj().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.vGr = true;
            }
          }
          else {
            ac.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
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
    com.tencent.mm.kernel.g.agi().a(1571, this);
    com.tencent.mm.kernel.g.agi().a(498, this);
    this.wgP = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    dtu();
    if (this.wgP == null)
    {
      ac.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      t.makeText(this, "function info is null", 1).show();
      finish();
      AppMethodBeat.o(67187);
      return;
    }
    setMMTitle(this.wgP.dxZ);
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
    this.wfT = new com.tencent.mm.plugin.wallet.a.e();
    this.wfT.name = getString(2131765783);
    this.wfT.url = getString(2131765784);
    this.wgz = findViewById(2131303235);
    this.wgA = ((ImageView)findViewById(2131302848));
    this.wgB = ((TextView)findViewById(2131302849));
    this.wgC = ((MallFormView)findViewById(2131303820));
    com.tencent.mm.plugin.recharge.ui.form.c.b(this.wgC);
    this.wgT = new c.b(this.wgC);
    paramBundle = this.wgT;
    ac.d(com.tencent.mm.plugin.recharge.ui.form.c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.whL;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).whR != null) {
      ((MallFormView)localObject).whR.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.whL.getContentEditText();
    com.tencent.mm.sdk.g.b.c(new c.b.2(paramBundle), "fetch_phone_book");
    paramBundle.whM = new com.tencent.mm.plugin.recharge.ui.form.d(paramBundle.whL, paramBundle.wgc);
    paramBundle.whM.wiy = new c.b.3(paramBundle);
    paramBundle.whM.wiz = this;
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.whM);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.whL.setOnFocusChangeListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.6(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.wgF = ((GridView)findViewById(2131303838));
    this.wgH = ((TextView)findViewById(2131303844));
    this.wgI = ((TextView)findViewById(2131303845));
    this.wgJ = ((TextView)findViewById(2131303818));
    this.wgK = ((TextView)findViewById(2131303834));
    this.wgD = ((TextView)findViewById(2131303840));
    this.wgE = ((TextView)findViewById(2131303842));
    this.wgG = ((GridView)findViewById(2131303821));
    this.wgL = ((TextView)findViewById(2131303839));
    this.wgM = ((TextView)findViewById(2131303841));
    this.wgC.setOnInputValidChangeListener(new MallFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(67174);
        if (paramAnonymousBoolean)
        {
          PhoneRechargeUI.this.hideVKB();
          final String str = com.tencent.mm.plugin.recharge.model.b.GG(PhoneRechargeUI.a(PhoneRechargeUI.this).getText());
          if (str == null)
          {
            ac.e("MicroMsg.PhoneRechargeUI", "null phone, return");
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
              ac.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67172);
                  PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(locala);
                  PhoneRechargeUI.aqp(PhoneRechargeUI.12.1.this.wgY);
                  AppMethodBeat.o(67172);
                }
              });
              AppMethodBeat.o(67173);
            }
          }, "search_matched_mobile");
          if (!PhoneRechargeUI.c(PhoneRechargeUI.this))
          {
            ac.d("MicroMsg.PhoneRechargeUI", "clear focus");
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
        if (bs.isNullOrNil(PhoneRechargeUI.a(PhoneRechargeUI.this).getText())) {
          ((AutoCompleteTextView)PhoneRechargeUI.a(PhoneRechargeUI.this).getContentEditText()).showDropDown();
        }
        AppMethodBeat.o(67174);
      }
    });
    this.wgC.getInfoIv().setOnClickListener(new PhoneRechargeUI.16(this));
    this.wgN = new b();
    this.wgN.wgs = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67179);
        if (paramAnonymousq == null)
        {
          ac.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
          AppMethodBeat.o(67179);
          return;
        }
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.BgE, paramAnonymousq.hlj, paramAnonymousq.name, paramAnonymousq.desc))
        {
          if (!bs.isNullOrNil(paramAnonymousq.url))
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
    this.wgO = new b();
    this.wgO.wgs = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67180);
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.BgE, paramAnonymousq.hlj, paramAnonymousq.name, paramAnonymousq.desc))
        {
          if (!bs.isNullOrNil(paramAnonymousq.url))
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
          ac.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
        }
        AppMethodBeat.o(67180);
      }
    };
    this.wgF.setAdapter(this.wgN);
    this.wgG.setAdapter(this.wgO);
    this.wgA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67181);
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null) {
          PhoneRechargeUI.g(PhoneRechargeUI.this);
        }
        for (;;)
        {
          PhoneRechargeUI.h(PhoneRechargeUI.this).setVisibility(8);
          AppMethodBeat.o(67181);
          return;
          ac.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
        }
      }
    });
    this.wgB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67182);
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null)
        {
          com.tencent.mm.protocal.g.fS(6, 1);
          if ((!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.f(PhoneRechargeUI.this).BgE, PhoneRechargeUI.f(PhoneRechargeUI.this).hlj, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "")) && (!bs.isNullOrNil(PhoneRechargeUI.f(PhoneRechargeUI.this).url))) {
            try
            {
              paramAnonymousView = URLDecoder.decode(PhoneRechargeUI.f(PhoneRechargeUI.this).url, "utf-8");
              PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "");
              AppMethodBeat.o(67182);
              return;
            }
            catch (UnsupportedEncodingException paramAnonymousView)
            {
              ac.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousView, "", new Object[0]);
            }
          }
        }
        AppMethodBeat.o(67182);
      }
    });
    this.wgC.dtF();
    int i = com.tencent.mm.cc.a.ig(this) / 4 - 20;
    ac.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.wgH.setMaxWidth(i);
    this.wgI.setMaxWidth(i);
    this.wgJ.setMaxWidth(i);
    this.wgK.setMaxWidth(i);
    this.wgR = getResources().getColor(2131100711);
    if ((this.wgT.wgd != null) && (!bs.isNullOrNil(this.wgT.wgd.name))) {
      this.desc = this.wgT.wgd.name;
    }
    this.wgC.getContentEditText().setHintTextColor(getResources().getColor(2131100787));
    if (bs.isNullOrNil(this.wgC.getText()))
    {
      c(new com.tencent.mm.plugin.recharge.model.f(""), false);
      AppMethodBeat.o(67187);
      return;
    }
    c(new com.tencent.mm.plugin.recharge.model.f(this.wgC.getText()), false);
    AppMethodBeat.o(67187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67193);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(1571, this);
    com.tencent.mm.kernel.g.agi().b(498, this);
    com.tencent.mm.sdk.b.a.GpY.d(this.vGu);
    AppMethodBeat.o(67193);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67192);
    super.onResume();
    W(false, true);
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
        if ((!bs.isNullOrNil(paramString.iTD)) && (!paramString.iTD.equals(this.wgC.getText())))
        {
          ac.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.iTD, this.wgC.getText() });
          AppMethodBeat.o(67201);
          return;
        }
        if (paramString.wfL)
        {
          ac.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          aqo(paramString.errMsg);
          dtq();
          AppMethodBeat.o(67201);
          return;
        }
        this.mAppId = paramString.appId;
        this.wfM = paramString.wfM;
        this.wfN = paramString.wfN;
        this.wfP = paramString.wfP;
        this.wfQ = paramString.wfQ;
        this.wfR = paramString.wfR;
        this.wfS = paramString.wfS;
        this.errCode = paramString.errCode;
        this.errMsg = paramString.errMsg;
        this.wgQ = paramString.desc;
        ac.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.wgQ, this.wgC.getText() });
        if (bs.isNullOrNil(this.wgQ))
        {
          this.desc = "";
          this.wgR = getResources().getColor(2131100711);
        }
        for (;;)
        {
          this.wgU = paramString.wfU;
          this.wfO = paramString.wfO;
          if (this.wfO == null) {
            break;
          }
          paramInt1 = this.wfO.size() - 1;
          while (paramInt1 >= 0)
          {
            paramn = (com.tencent.mm.plugin.wallet.a.q)this.wfO.get(paramInt1);
            if (paramn.name.isEmpty()) {
              this.wfO.remove(paramn);
            }
            paramInt1 -= 1;
          }
          if ((this.wgT.wgd != null) && (this.wgT.wgd.wfs.trim().equals(this.wgC.getText())))
          {
            this.wgT.wgd.jIC = this.wgQ;
            this.wgT.setInput(this.wgT.wgd);
          }
        }
        if ((paramString.wfT == null) || ((paramString.wfT.name.equals(this.wfT.name)) && (paramString.wfT.url.equals(this.wfT.url)) && (paramString.wfT.BgE.equals(this.wfT.BgE)) && (paramString.wfT.hlj.equals(this.wfT.hlj)))) {
          break label875;
        }
        ac.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.wfT = paramString.wfT;
      }
    }
    label875:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.wgQ.equals(""))
      {
        bool2 = false;
        W(bool2, bool1);
        paramString = paramString.wfV;
        ac.d("MicroMsg.PhoneRechargeUI", "update record history");
        com.tencent.mm.plugin.recharge.a.a.dtj().eH(paramString);
        if (this.wgT != null)
        {
          if (!bs.isNullOrNil(this.wgC.getText())) {
            break label626;
          }
          this.wgT.pi(true);
        }
      }
      for (;;)
      {
        this.wgC.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67175);
            PhoneRechargeUI.a(PhoneRechargeUI.this).dtG();
            AppMethodBeat.o(67175);
          }
        }, 300L);
        AppMethodBeat.o(67201);
        return;
        bool2 = true;
        break;
        label626:
        this.wgT.pi(false);
      }
      ac.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      AppMethodBeat.o(67201);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        k(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.wallet_core.b.fzz();
          if ((com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pRO, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_MOBILE_FEE_PAY_SWTICH_KEY"))) {}
          for (paramInt1 = i;; paramInt1 = 0)
          {
            paramString = (com.tencent.mm.plugin.recharge.model.g)paramn;
            if (paramInt1 == 0) {
              break;
            }
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(paramString.wfX.dac, 6);
            com.tencent.mm.sdk.b.a.GpY.c(this.vGu);
            AppMethodBeat.o(67201);
            return;
          }
          paramn = paramString.wfX;
          paramn.dqL = 6;
          paramn.DGI = 100;
          paramn.nUG = this.wgC.getText();
          if (this.wgT.wgd != null) {}
          for (paramString = this.wgT.wgd.name;; paramString = "")
          {
            paramn.iAC = paramString;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 2);
            break;
          }
        }
        paramn = paramString;
        if (bs.isNullOrNil(paramString)) {
          paramn = getString(2131765901);
        }
        aqo(paramn);
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