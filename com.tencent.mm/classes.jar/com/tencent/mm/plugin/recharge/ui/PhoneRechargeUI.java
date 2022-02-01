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
import com.tencent.mm.g.a.xk;
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
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.y;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI
  extends MMActivity
  implements com.tencent.mm.al.g, d.a
{
  private String desc;
  private int errCode;
  private String errMsg;
  private String headUrl;
  private String mAppId;
  protected Dialog tipDialog;
  private int uWX;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> uWY;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> uWZ;
  private View uXK;
  private ImageView uXL;
  private TextView uXM;
  private MallFormView uXN;
  private TextView uXO;
  private TextView uXP;
  private GridView uXQ;
  private GridView uXR;
  private TextView uXS;
  private TextView uXT;
  private TextView uXU;
  private TextView uXV;
  private TextView uXW;
  private TextView uXX;
  private b uXY;
  private b uXZ;
  private com.tencent.mm.plugin.wallet.a.e uXa;
  private com.tencent.mm.plugin.wallet.a.e uXb;
  private com.tencent.mm.plugin.wallet.a.e uXc;
  private com.tencent.mm.plugin.wallet.a.e uXd;
  private com.tencent.mm.plugin.wallet.a.e uXe;
  private MallFunction uYa;
  private String uYb;
  private int uYc;
  private String uYd;
  private c.b uYe;
  private p uYf;
  private boolean uYg;
  private List<String[]> uYh;
  private com.tencent.mm.sdk.b.c uxB;
  private boolean uxy;
  
  public PhoneRechargeUI()
  {
    AppMethodBeat.i(67185);
    this.uXK = null;
    this.uXL = null;
    this.uXM = null;
    this.uXN = null;
    this.uXO = null;
    this.uXP = null;
    this.uXQ = null;
    this.uXR = null;
    this.uXS = null;
    this.uXT = null;
    this.uXU = null;
    this.uXV = null;
    this.uXW = null;
    this.uXX = null;
    this.uXY = null;
    this.uXZ = null;
    this.tipDialog = null;
    this.uYa = null;
    this.mAppId = "";
    this.uWY = null;
    this.uWZ = null;
    this.uXa = null;
    this.uXb = null;
    this.uXc = null;
    this.uXd = null;
    this.uXe = null;
    this.errCode = 0;
    this.errMsg = "";
    this.uYb = "";
    this.desc = "";
    this.uYd = "";
    this.headUrl = "";
    this.uxy = false;
    this.uYe = null;
    this.uYf = null;
    this.uYg = false;
    this.uxB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67185);
  }
  
  private void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67194);
    label103:
    String str;
    if ((this.uYf != null) && (!dfK()))
    {
      this.uXK.setVisibility(0);
      this.uXM.setText(this.uYf.name);
      ad.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
      com.tencent.mm.protocal.g.fL(6, 0);
      this.uXY.uXC = this.uWY;
      this.uXY.notifyDataSetChanged();
      this.uXZ.uXC = this.uWZ;
      this.uXZ.notifyDataSetChanged();
      if (paramBoolean1) {
        break label414;
      }
      this.uXW.setVisibility(8);
      this.uXX.setVisibility(8);
      if (paramBoolean2) {
        addTextOptionMenu(0, this.uXe.name, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(67164);
            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.i(PhoneRechargeUI.this).zOk, PhoneRechargeUI.i(PhoneRechargeUI.this).gKJ, PhoneRechargeUI.i(PhoneRechargeUI.this).name, "")) {}
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
      TextView localTextView = this.uXO;
      if ((this.uWY == null) || (this.uWY.size() <= 0) || (bt.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.uWY.get(0)).zOP))) {
        break label459;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.uWY.get(0)).zOP;
      label194:
      localTextView.setText(str);
      localTextView = this.uXP;
      if ((this.uWZ == null) || (this.uWZ.size() <= 0) || (bt.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.uWZ.get(0)).zOP))) {
        break label470;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.uWZ.get(0)).zOP;
      label258:
      localTextView.setText(str);
      if ((this.uXd != null) && (!bt.isNullOrNil(this.uXd.name))) {
        break label481;
      }
      this.uXT.setVisibility(8);
      label293:
      if ((this.uXa != null) && (!bt.isNullOrNil(this.uXa.name))) {
        break label521;
      }
      this.uXS.setVisibility(8);
      label322:
      if ((this.uXb != null) && (!bt.isNullOrNil(this.uXb.name))) {
        break label561;
      }
      this.uXU.setVisibility(8);
      label351:
      if ((this.uXc != null) && (!bt.isNullOrNil(this.uXc.name))) {
        break label601;
      }
      this.uXV.setVisibility(8);
    }
    for (;;)
    {
      d(this.uYa);
      AppMethodBeat.o(67194);
      return;
      this.uXK.setVisibility(8);
      ad.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break;
      label414:
      if (dfM()) {
        this.uXW.setVisibility(0);
      }
      for (;;)
      {
        if (!dfL()) {
          break label457;
        }
        this.uXX.setVisibility(0);
        break;
        this.uXW.setVisibility(8);
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
      this.uXT.setVisibility(0);
      this.uXT.setText(this.uXd.name);
      this.uXT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67165);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).zOk, PhoneRechargeUI.j(PhoneRechargeUI.this).gKJ, PhoneRechargeUI.j(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).url);
            ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.j(PhoneRechargeUI.this).name, "");
          }
          AppMethodBeat.o(67165);
        }
      });
      break label293;
      label521:
      this.uXS.setVisibility(0);
      this.uXS.setText(this.uXa.name);
      this.uXS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67166);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).zOk, PhoneRechargeUI.k(PhoneRechargeUI.this).gKJ, PhoneRechargeUI.k(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).url);
            ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.k(PhoneRechargeUI.this).name, "");
          }
          AppMethodBeat.o(67166);
        }
      });
      break label322;
      label561:
      this.uXU.setVisibility(0);
      this.uXU.setText(this.uXb.name);
      this.uXU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67167);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).zOk, PhoneRechargeUI.l(PhoneRechargeUI.this).gKJ, PhoneRechargeUI.l(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).url);
            ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.l(PhoneRechargeUI.this).name, "");
          }
          AppMethodBeat.o(67167);
        }
      });
      break label351;
      label601:
      this.uXV.setVisibility(0);
      this.uXV.setText(this.uXc.name);
      this.uXV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67168);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).zOk, PhoneRechargeUI.m(PhoneRechargeUI.this).gKJ, PhoneRechargeUI.m(PhoneRechargeUI.this).name, ""))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).url);
            ad.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.m(PhoneRechargeUI.this).name, "");
          }
          AppMethodBeat.o(67168);
        }
      });
    }
  }
  
  private String aln(String paramString)
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
      if (this.uYe != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.uYe.uXo != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!bt.isNullOrNil(this.uYe.uXo.name))
          {
            str1 = paramString;
            localObject1 = this.uYe.uXo.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(2131765787))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.uXN.getText();
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
  
  private void alo(final String paramString)
  {
    AppMethodBeat.i(67198);
    View localView = y.js(this).inflate(2131495212, null);
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131765796), localView, getString(2131765797), getString(2131765795), new DialogInterface.OnClickListener()new PhoneRechargeUI.10
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
  
  private void alp(String paramString)
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
      com.tencent.mm.kernel.g.aeS().a(paramn, 0);
      AppMethodBeat.o(67191);
      return;
    }
  }
  
  private void d(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67197);
    if (com.tencent.mm.plugin.recharge.model.b.c(paramMallFunction))
    {
      com.tencent.mm.plugin.recharge.model.b.dfF();
      ad.d("MicroMsg.PhoneRechargeUI", this.uYa.AiC.toString());
      alo(this.uYa.AiC.AiR);
    }
    AppMethodBeat.o(67197);
  }
  
  private void dfJ()
  {
    AppMethodBeat.i(67186);
    this.mAppId = "";
    dfN();
    this.errCode = 0;
    this.errMsg = "";
    this.desc = "";
    AppMethodBeat.o(67186);
  }
  
  private boolean dfK()
  {
    AppMethodBeat.i(67189);
    if (this.uYf != null)
    {
      Object localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fha, "");
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
            if ((localObject2 != null) && (localObject2.equals(String.valueOf(this.uYf.id))))
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
  
  private boolean dfL()
  {
    AppMethodBeat.i(67195);
    Iterator localIterator = this.uWZ.iterator();
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
  
  private boolean dfM()
  {
    AppMethodBeat.i(67196);
    Iterator localIterator = this.uWY.iterator();
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
  
  private void dfN()
  {
    AppMethodBeat.i(67199);
    this.uWY = new ArrayList();
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
    this.uWY.add(localq1);
    this.uWY.add(localq2);
    this.uWY.add(localq3);
    this.uWY.add(localq4);
    this.uWY.add(localq5);
    this.uWY.add(localq6);
    this.uWZ = new ArrayList();
    localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(2131765775);
    localq1.status = 0;
    localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(2131765776);
    localq2.status = 0;
    localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(2131765777);
    localq3.status = 0;
    this.uWZ.add(localq1);
    this.uWZ.add(localq2);
    this.uWZ.add(localq3);
    AppMethodBeat.o(67199);
  }
  
  private void dfO()
  {
    AppMethodBeat.i(67203);
    com.tencent.mm.kernel.g.aeS().a(new com.tencent.mm.plugin.recharge.model.f(this.uXN.getText()), 0);
    AppMethodBeat.o(67203);
  }
  
  private void l(n paramn)
  {
    AppMethodBeat.i(67190);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramn.getType() != 497))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(67190);
  }
  
  public final void dfP()
  {
    AppMethodBeat.i(67204);
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.g.aeS().a(localf, 0);
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
        this.uYg = true;
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
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.CD((String)localObject3);
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
            public final void JX(int paramAnonymousInt)
            {
              AppMethodBeat.i(67176);
              ad.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
              PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(paramAnonymousInt), this.uYn, 1));
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
          this.uYe.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          dfO();
        }
        else
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131761162), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.uxy)
            {
              ad.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.uXN.getText(), this.uXN.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.dfC().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.uxy = true;
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
    com.tencent.mm.kernel.g.aeS().a(1571, this);
    com.tencent.mm.kernel.g.aeS().a(498, this);
    this.uYa = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    dfN();
    if (this.uYa == null)
    {
      ad.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      t.makeText(this, "function info is null", 1).show();
      finish();
      AppMethodBeat.o(67187);
      return;
    }
    setMMTitle(this.uYa.dAn);
    setBackBtn(new PhoneRechargeUI.1(this));
    this.uXe = new com.tencent.mm.plugin.wallet.a.e();
    this.uXe.name = getString(2131765783);
    this.uXe.url = getString(2131765784);
    this.uXK = findViewById(2131303235);
    this.uXL = ((ImageView)findViewById(2131302848));
    this.uXM = ((TextView)findViewById(2131302849));
    this.uXN = ((MallFormView)findViewById(2131303820));
    com.tencent.mm.plugin.recharge.ui.form.c.b(this.uXN);
    this.uYe = new c.b(this.uXN);
    paramBundle = this.uYe;
    ad.d(com.tencent.mm.plugin.recharge.ui.form.c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.uYW;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).uZc != null) {
      ((MallFormView)localObject).uZc.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.uYW.getContentEditText();
    com.tencent.mm.sdk.g.b.c(new c.b.2(paramBundle), "fetch_phone_book");
    paramBundle.uYX = new com.tencent.mm.plugin.recharge.ui.form.d(paramBundle.uYW, paramBundle.uXn);
    paramBundle.uYX.uZK = new c.b.3(paramBundle);
    paramBundle.uYX.uZL = this;
    paramBundle.oo(true);
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.uYX);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.uYW.setOnFocusChangeListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.6(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.uXQ = ((GridView)findViewById(2131303838));
    this.uXS = ((TextView)findViewById(2131303844));
    this.uXT = ((TextView)findViewById(2131303845));
    this.uXU = ((TextView)findViewById(2131303818));
    this.uXV = ((TextView)findViewById(2131303834));
    this.uXO = ((TextView)findViewById(2131303840));
    this.uXP = ((TextView)findViewById(2131303842));
    this.uXR = ((GridView)findViewById(2131303821));
    this.uXW = ((TextView)findViewById(2131303839));
    this.uXX = ((TextView)findViewById(2131303841));
    this.uXN.setOnInputValidChangeListener(new MallFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(67174);
        if (paramAnonymousBoolean)
        {
          PhoneRechargeUI.this.hideVKB();
          final String str = com.tencent.mm.plugin.recharge.model.b.CD(PhoneRechargeUI.a(PhoneRechargeUI.this).getText());
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
                  PhoneRechargeUI.alq(PhoneRechargeUI.12.1.this.uYj);
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
    this.uXN.getInfoIv().setOnClickListener(new PhoneRechargeUI.16(this));
    this.uXY = new b();
    this.uXY.uXD = new b.a()
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
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.zOk, paramAnonymousq.gKJ, paramAnonymousq.name, paramAnonymousq.desc))
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
    this.uXZ = new b();
    this.uXZ.uXD = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67180);
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.zOk, paramAnonymousq.gKJ, paramAnonymousq.name, paramAnonymousq.desc))
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
    this.uXQ.setAdapter(this.uXY);
    this.uXR.setAdapter(this.uXZ);
    this.uXL.setOnClickListener(new View.OnClickListener()
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
          ad.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
        }
      }
    });
    this.uXM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67182);
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null)
        {
          com.tencent.mm.protocal.g.fL(6, 1);
          if ((!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.f(PhoneRechargeUI.this).zOk, PhoneRechargeUI.f(PhoneRechargeUI.this).gKJ, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "")) && (!bt.isNullOrNil(PhoneRechargeUI.f(PhoneRechargeUI.this).url))) {
            try
            {
              paramAnonymousView = URLDecoder.decode(PhoneRechargeUI.f(PhoneRechargeUI.this).url, "utf-8");
              PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousView, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "");
              AppMethodBeat.o(67182);
              return;
            }
            catch (UnsupportedEncodingException paramAnonymousView)
            {
              ad.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramAnonymousView, "", new Object[0]);
            }
          }
        }
        AppMethodBeat.o(67182);
      }
    });
    this.uXN.dfY();
    int i = com.tencent.mm.cd.a.hV(this) / 4 - 20;
    ad.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.uXS.setMaxWidth(i);
    this.uXT.setMaxWidth(i);
    this.uXU.setMaxWidth(i);
    this.uXV.setMaxWidth(i);
    this.uYc = getResources().getColor(2131100711);
    if ((this.uYe.uXo != null) && (!bt.isNullOrNil(this.uYe.uXo.name))) {
      this.desc = this.uYe.uXo.name;
    }
    this.uXN.getContentEditText().setHintTextColor(getResources().getColor(2131100787));
    if (bt.isNullOrNil(this.uXN.getText()))
    {
      c(new com.tencent.mm.plugin.recharge.model.f(""), false);
      AppMethodBeat.o(67187);
      return;
    }
    c(new com.tencent.mm.plugin.recharge.model.f(this.uXN.getText()), false);
    AppMethodBeat.o(67187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67193);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(1571, this);
    com.tencent.mm.kernel.g.aeS().b(498, this);
    com.tencent.mm.sdk.b.a.ESL.d(this.uxB);
    AppMethodBeat.o(67193);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67192);
    super.onResume();
    T(false, true);
    AppMethodBeat.o(67192);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(67201);
    if ((paramn instanceof com.tencent.mm.plugin.recharge.model.f))
    {
      paramString = (com.tencent.mm.plugin.recharge.model.f)paramn;
      l(paramn);
      if (paramString.cmdId == 0)
      {
        if ((!bt.isNullOrNil(paramString.ity)) && (!paramString.ity.equals(this.uXN.getText())))
        {
          ad.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.ity, this.uXN.getText() });
          AppMethodBeat.o(67201);
          return;
        }
        if (paramString.uWW)
        {
          ad.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          alp(paramString.errMsg);
          dfJ();
          AppMethodBeat.o(67201);
          return;
        }
        this.mAppId = paramString.appId;
        this.uWX = paramString.uWX;
        this.uWY = paramString.uWY;
        this.uXa = paramString.uXa;
        this.uXb = paramString.uXb;
        this.uXc = paramString.uXc;
        this.uXd = paramString.uXd;
        this.errCode = paramString.errCode;
        this.errMsg = paramString.errMsg;
        this.uYb = paramString.desc;
        ad.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.uYb, this.uXN.getText() });
        if (bt.isNullOrNil(this.uYb))
        {
          this.desc = "";
          this.uYc = getResources().getColor(2131100711);
        }
        for (;;)
        {
          this.uYf = paramString.uXf;
          this.uWZ = paramString.uWZ;
          if (this.uWZ == null) {
            break;
          }
          paramInt1 = this.uWZ.size() - 1;
          while (paramInt1 >= 0)
          {
            paramn = (com.tencent.mm.plugin.wallet.a.q)this.uWZ.get(paramInt1);
            if (paramn.name.isEmpty()) {
              this.uWZ.remove(paramn);
            }
            paramInt1 -= 1;
          }
          if ((this.uYe.uXo != null) && (this.uYe.uXo.uWD.trim().equals(this.uXN.getText())))
          {
            this.uYe.uXo.jio = this.uYb;
            this.uYe.setInput(this.uYe.uXo);
          }
        }
        if ((paramString.uXe == null) || ((paramString.uXe.name.equals(this.uXe.name)) && (paramString.uXe.url.equals(this.uXe.url)) && (paramString.uXe.zOk.equals(this.uXe.zOk)) && (paramString.uXe.gKJ.equals(this.uXe.gKJ)))) {
          break label876;
        }
        ad.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.uXe = paramString.uXe;
      }
    }
    label876:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.uYb.equals(""))
      {
        bool2 = false;
        T(bool2, bool1);
        paramn = paramString.uXg;
        if (paramn != null)
        {
          ad.d("MicroMsg.PhoneRechargeUI", "update record history");
          com.tencent.mm.plugin.recharge.a.a.dfC().eD(paramn);
          if (this.uYe != null)
          {
            if (!paramString.uXh) {
              break label627;
            }
            this.uYe.oo(true);
          }
        }
      }
      for (;;)
      {
        this.uXN.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67175);
            PhoneRechargeUI.a(PhoneRechargeUI.this).dfZ();
            AppMethodBeat.o(67175);
          }
        }, 300L);
        AppMethodBeat.o(67201);
        return;
        bool2 = true;
        break;
        label627:
        this.uYe.oo(false);
      }
      ad.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      AppMethodBeat.o(67201);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        l(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.wallet_core.b.fjk();
          if ((com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pom, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_MOBILE_FEE_PAY_SWTICH_KEY"))) {}
          for (paramInt1 = i;; paramInt1 = 0)
          {
            paramString = (com.tencent.mm.plugin.recharge.model.g)paramn;
            if (paramInt1 == 0) {
              break;
            }
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(paramString.uXi.dcE, 6);
            com.tencent.mm.sdk.b.a.ESL.c(this.uxB);
            AppMethodBeat.o(67201);
            return;
          }
          paramn = paramString.uXi;
          paramn.dtb = 6;
          paramn.Cop = 100;
          paramn.nrG = this.uXN.getText();
          if (this.uYe.uXo != null) {}
          for (paramString = this.uYe.uXo.name;; paramString = "")
          {
            paramn.iaz = paramString;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 2);
            break;
          }
        }
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = getString(2131765901);
        }
        alp(paramn);
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