package com.tencent.mm.plugin.recharge.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.plugin.recharge.ui.form.c.b.1;
import com.tencent.mm.plugin.recharge.ui.form.c.b.2;
import com.tencent.mm.plugin.recharge.ui.form.c.b.3;
import com.tencent.mm.plugin.recharge.ui.form.c.b.4;
import com.tencent.mm.plugin.recharge.ui.form.c.b.5;
import com.tencent.mm.plugin.recharge.ui.form.d;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.w;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI
  extends MMActivity
  implements com.tencent.mm.ai.f, d.a
{
  private String desc;
  private int errCode;
  private String errMsg;
  protected Dialog gKM;
  private String mAppId;
  private View pVQ;
  private ImageView pVR;
  private TextView pVS;
  private MallFormView pVT;
  private TextView pVU;
  private TextView pVV;
  private GridView pVW;
  private GridView pVX;
  private TextView pVY;
  private TextView pVZ;
  private ArrayList<q> pVe;
  private ArrayList<q> pVf;
  private com.tencent.mm.plugin.wallet.a.e pVg;
  private com.tencent.mm.plugin.wallet.a.e pVh;
  private com.tencent.mm.plugin.wallet.a.e pVi;
  private com.tencent.mm.plugin.wallet.a.e pVj;
  private com.tencent.mm.plugin.wallet.a.e pVk;
  private TextView pWa;
  private TextView pWb;
  private TextView pWc;
  private TextView pWd;
  private b pWe;
  private b pWf;
  private MallFunction pWg;
  private String pWh;
  private int pWi;
  private String pWj;
  private String pWk;
  private c.b pWl;
  private com.tencent.mm.plugin.wallet.a.p pWm;
  private boolean pWn;
  private List<String[]> pWo;
  private boolean pvQ;
  private com.tencent.mm.sdk.b.c pvT;
  
  public PhoneRechargeUI()
  {
    AppMethodBeat.i(44276);
    this.pVQ = null;
    this.pVR = null;
    this.pVS = null;
    this.pVT = null;
    this.pVU = null;
    this.pVV = null;
    this.pVW = null;
    this.pVX = null;
    this.pVY = null;
    this.pVZ = null;
    this.pWa = null;
    this.pWb = null;
    this.pWc = null;
    this.pWd = null;
    this.pWe = null;
    this.pWf = null;
    this.gKM = null;
    this.pWg = null;
    this.mAppId = "";
    this.pVe = null;
    this.pVf = null;
    this.pVg = null;
    this.pVh = null;
    this.pVi = null;
    this.pVj = null;
    this.pVk = null;
    this.errCode = 0;
    this.errMsg = "";
    this.pWh = "";
    this.desc = "";
    this.pWj = "";
    this.pWk = "";
    this.pvQ = false;
    this.pWl = null;
    this.pWm = null;
    this.pWn = false;
    this.pvT = new PhoneRechargeUI.14(this);
    AppMethodBeat.o(44276);
  }
  
  private void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(44285);
    label103:
    String str;
    if ((this.pWm != null) && (!cfu()))
    {
      this.pVQ.setVisibility(0);
      this.pVS.setText(this.pWm.name);
      ab.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
      com.tencent.mm.protocal.g.gK(6, 0);
      this.pWe.pVI = this.pVe;
      this.pWe.notifyDataSetChanged();
      this.pWf.pVI = this.pVf;
      this.pWf.notifyDataSetChanged();
      if (paramBoolean1) {
        break label413;
      }
      this.pWc.setVisibility(8);
      this.pWd.setVisibility(8);
      if (paramBoolean2) {
        addTextOptionMenu(0, this.pVk.name, new PhoneRechargeUI.3(this));
      }
      TextView localTextView = this.pVU;
      if ((this.pVe == null) || (this.pVe.size() <= 0) || (bo.isNullOrNil(((q)this.pVe.get(0)).tUE))) {
        break label458;
      }
      str = ((q)this.pVe.get(0)).tUE;
      label194:
      localTextView.setText(str);
      localTextView = this.pVV;
      if ((this.pVf == null) || (this.pVf.size() <= 0) || (bo.isNullOrNil(((q)this.pVf.get(0)).tUE))) {
        break label469;
      }
      str = ((q)this.pVf.get(0)).tUE;
      label258:
      localTextView.setText(str);
      if ((this.pVj != null) && (!bo.isNullOrNil(this.pVj.name))) {
        break label480;
      }
      this.pVZ.setVisibility(8);
      label293:
      if ((this.pVg != null) && (!bo.isNullOrNil(this.pVg.name))) {
        break label520;
      }
      this.pVY.setVisibility(8);
      label322:
      if ((this.pVh != null) && (!bo.isNullOrNil(this.pVh.name))) {
        break label560;
      }
      this.pWa.setVisibility(8);
      label351:
      if ((this.pVi != null) && (!bo.isNullOrNil(this.pVi.name))) {
        break label600;
      }
      this.pWb.setVisibility(8);
    }
    for (;;)
    {
      d(this.pWg);
      AppMethodBeat.o(44285);
      return;
      this.pVQ.setVisibility(8);
      ab.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break;
      label413:
      if (cfw()) {
        this.pWc.setVisibility(0);
      }
      for (;;)
      {
        if (!cfv()) {
          break label456;
        }
        this.pWd.setVisibility(0);
        break;
        this.pWc.setVisibility(8);
      }
      label456:
      break label103;
      label458:
      str = getString(2131305564);
      break label194;
      label469:
      str = getString(2131305565);
      break label258;
      label480:
      this.pVZ.setVisibility(0);
      this.pVZ.setText(this.pVj.name);
      this.pVZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44255);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).tTY, PhoneRechargeUI.j(PhoneRechargeUI.this).fjP))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).url);
            ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.c(PhoneRechargeUI.this, paramAnonymousView);
          }
          AppMethodBeat.o(44255);
        }
      });
      break label293;
      label520:
      this.pVY.setVisibility(0);
      this.pVY.setText(this.pVg.name);
      this.pVY.setOnClickListener(new PhoneRechargeUI.5(this));
      break label322;
      label560:
      this.pWa.setVisibility(0);
      this.pWa.setText(this.pVh.name);
      this.pWa.setOnClickListener(new PhoneRechargeUI.6(this));
      break label351;
      label600:
      this.pWb.setVisibility(0);
      this.pWb.setText(this.pVi.name);
      this.pWb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44258);
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).tTY, PhoneRechargeUI.m(PhoneRechargeUI.this).fjP))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).url);
            ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.c(PhoneRechargeUI.this, paramAnonymousView);
          }
          AppMethodBeat.o(44258);
        }
      });
    }
  }
  
  private String XM(String paramString)
  {
    AppMethodBeat.i(44279);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44279);
      return "";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    String str1 = paramString;
    try
    {
      if (this.pWl != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.pWl.pVu != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!bo.isNullOrNil(this.pWl.pVu.name))
          {
            str1 = paramString;
            localObject1 = this.pWl.pVu.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(2131305571))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.pVT.getText();
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
        ab.i("MicroMsg.PhoneRechargeUI", "new url");
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
          AppMethodBeat.o(44279);
          return paramString;
          str1 = paramString;
          paramString = paramString.replace("{phone}", str2);
          break;
          label243:
          str1 = paramString;
        }
      }
      str1 = paramString;
      ab.i("MicroMsg.PhoneRechargeUI", "old url");
      str1 = paramString;
      localObject2 = URLDecoder.decode(paramString, "utf-8");
      str1 = paramString;
      paramString = (String)localObject2 + String.format("?phone=%s&remark=%s", new Object[] { str2, localObject1 });
      AppMethodBeat.o(44279);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramString, "", new Object[0]);
      AppMethodBeat.o(44279);
    }
    return str1;
  }
  
  private void XN(String paramString)
  {
    AppMethodBeat.i(44289);
    View localView = w.hM(this).inflate(2130970537, null);
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131305580), localView, getString(2131305581), getString(2131305579), new PhoneRechargeUI.8(this, paramString), new PhoneRechargeUI.9(this));
    AppMethodBeat.o(44289);
  }
  
  private void XO(String paramString)
  {
    AppMethodBeat.i(44291);
    com.tencent.mm.ui.base.h.a(this, paramString, "", false, new PhoneRechargeUI.10(this));
    AppMethodBeat.o(44291);
  }
  
  private void b(final m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(44282);
    if ((this.gKM == null) || ((this.gKM != null) && (!this.gKM.isShowing()))) {
      if (!paramBoolean) {
        break label71;
      }
    }
    label71:
    for (this.gKM = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(44275);
            com.tencent.mm.kernel.g.Rc().a(paramm);
            AppMethodBeat.o(44275);
          }
        });; this.gKM = com.tencent.mm.wallet_core.ui.g.c(getContext(), true, new PhoneRechargeUI.2(this, paramm)))
    {
      com.tencent.mm.kernel.g.Rc().a(paramm, 0);
      AppMethodBeat.o(44282);
      return;
    }
  }
  
  private void cft()
  {
    AppMethodBeat.i(44277);
    this.mAppId = "";
    cfx();
    this.errCode = 0;
    this.errMsg = "";
    this.desc = "";
    AppMethodBeat.o(44277);
  }
  
  private boolean cfu()
  {
    AppMethodBeat.i(44280);
    if (this.pWm != null)
    {
      Object localObject1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyF, "");
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split(";");
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 != null) && (localObject2.equals(String.valueOf(this.pWm.id))))
            {
              ab.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
              AppMethodBeat.o(44280);
              return true;
            }
            i += 1;
          }
        }
        ab.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
        AppMethodBeat.o(44280);
        return false;
      }
      ab.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
      AppMethodBeat.o(44280);
      return false;
    }
    ab.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
    AppMethodBeat.o(44280);
    return true;
  }
  
  private boolean cfv()
  {
    AppMethodBeat.i(44286);
    Iterator localIterator = this.pVf.iterator();
    while (localIterator.hasNext()) {
      if (((q)localIterator.next()).status != 0)
      {
        AppMethodBeat.o(44286);
        return false;
      }
    }
    AppMethodBeat.o(44286);
    return true;
  }
  
  private boolean cfw()
  {
    AppMethodBeat.i(44287);
    Iterator localIterator = this.pVe.iterator();
    while (localIterator.hasNext()) {
      if (((q)localIterator.next()).status != 0)
      {
        AppMethodBeat.o(44287);
        return false;
      }
    }
    AppMethodBeat.o(44287);
    return true;
  }
  
  private void cfx()
  {
    AppMethodBeat.i(44290);
    this.pVe = new ArrayList();
    q localq1 = new q();
    localq1.name = getString(2131305554);
    localq1.status = 0;
    q localq2 = new q();
    localq2.name = getString(2131305555);
    localq2.status = 0;
    q localq3 = new q();
    localq3.name = getString(2131305556);
    localq3.status = 0;
    q localq4 = new q();
    localq4.name = getString(2131305557);
    localq4.status = 0;
    q localq5 = new q();
    localq5.name = getString(2131305558);
    localq5.status = 0;
    q localq6 = new q();
    localq6.name = getString(2131305559);
    localq6.status = 0;
    this.pVe.add(localq1);
    this.pVe.add(localq2);
    this.pVe.add(localq3);
    this.pVe.add(localq4);
    this.pVe.add(localq5);
    this.pVe.add(localq6);
    this.pVf = new ArrayList();
    localq1 = new q();
    localq1.name = getString(2131305560);
    localq1.status = 0;
    localq2 = new q();
    localq2.name = getString(2131305561);
    localq2.status = 0;
    localq3 = new q();
    localq3.name = getString(2131305562);
    localq3.status = 0;
    this.pVf.add(localq1);
    this.pVf.add(localq2);
    this.pVf.add(localq3);
    AppMethodBeat.o(44290);
  }
  
  private void cfy()
  {
    AppMethodBeat.i(44294);
    com.tencent.mm.kernel.g.Rc().a(new com.tencent.mm.plugin.recharge.model.f(this.pVT.getText()), 0);
    AppMethodBeat.o(44294);
  }
  
  private void d(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(44288);
    if (com.tencent.mm.plugin.recharge.model.b.c(paramMallFunction))
    {
      com.tencent.mm.plugin.recharge.model.b.cfp();
      ab.d("MicroMsg.PhoneRechargeUI", this.pWg.umh.toString());
      XN(this.pWg.umh.umw);
    }
    AppMethodBeat.o(44288);
  }
  
  private void l(m paramm)
  {
    AppMethodBeat.i(44281);
    if ((this.gKM != null) && (this.gKM.isShowing()) && (paramm.getType() != 497))
    {
      this.gKM.dismiss();
      this.gKM = null;
    }
    AppMethodBeat.o(44281);
  }
  
  public final void cfz()
  {
    AppMethodBeat.i(44295);
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.g.Rc().a(localf, 0);
    AppMethodBeat.o(44295);
  }
  
  public int getLayoutId()
  {
    return 2130970417;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(44293);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(44293);
      return;
      if (paramInt2 == -1)
      {
        this.pWn = true;
        Object localObject1 = null;
        Object localObject4 = null;
        ArrayList localArrayList = new ArrayList();
        Object localObject3 = paramIntent.getData();
        if (localObject3 == null)
        {
          ab.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
          AppMethodBeat.o(44293);
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
                ab.d("MicroMsg.PhoneRechargeUI", "hy: username : ".concat(String.valueOf(localObject1)));
                if (localObject3 != null)
                {
                  ab.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.xw((String)localObject3);
                  ab.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(localObject3)));
                  if ((PhoneNumberUtils.isGlobalPhoneNumber((String)localObject3)) && (((String)localObject3).length() == 11)) {
                    localArrayList.add(localObject3);
                  }
                  ab.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : ".concat(String.valueOf(localObject3)));
                }
                localCursor2.moveToNext();
              }
            }
          }
        }
        catch (SecurityException localSecurityException)
        {
          ab.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[] { localSecurityException.toString() });
          com.tencent.mm.ui.base.h.b(this, getString(2131301517), "", true);
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
          localObject2 = com.tencent.mm.ui.base.h.a(this, getString(2131305574), localArrayList, -1, new PhoneRechargeUI.13(this, localArrayList, (String)localObject3));
          if (localObject2 != null) {
            ((com.tencent.mm.ui.widget.b.c)localObject2).setCanceledOnTouchOutside(true);
          }
        }
        else if (localArrayList.size() == 1)
        {
          this.pWl.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          cfy();
        }
        else
        {
          com.tencent.mm.ui.base.h.b(this, getString(2131301515), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.pvQ)
            {
              ab.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.pVT.getText(), this.pVT.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.cfm().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.pvQ = true;
            }
          }
          else {
            ab.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44278);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    com.tencent.mm.kernel.g.Rc().a(1571, this);
    com.tencent.mm.kernel.g.Rc().a(498, this);
    this.pWg = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    if (this.pWg == null)
    {
      ab.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      t.makeText(this, "function info is null", 1).show();
      finish();
    }
    cfx();
    setMMTitle(this.pWg.cJt);
    setBackBtn(new PhoneRechargeUI.1(this));
    this.pVk = new com.tencent.mm.plugin.wallet.a.e();
    this.pVk.name = getString(2131305567);
    this.pVk.url = getString(2131305568);
    this.pVQ = findViewById(2131826717);
    this.pVR = ((ImageView)findViewById(2131826719));
    this.pVS = ((TextView)findViewById(2131826718));
    this.pVT = ((MallFormView)findViewById(2131826721));
    com.tencent.mm.plugin.recharge.ui.form.c.b(this.pVT);
    this.pWl = new c.b(this.pVT);
    paramBundle = this.pWl;
    ab.d(com.tencent.mm.plugin.recharge.ui.form.c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.pXd;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).pXj != null) {
      ((MallFormView)localObject).pXj.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.pXd.getContentEditText();
    paramBundle.pVt = com.tencent.mm.pluginsdk.a.cL(paramBundle.pXd.getContext());
    paramBundle.pXe = new d(paramBundle.pXd, paramBundle.pVt);
    paramBundle.pXe.pXR = new c.b.2(paramBundle);
    paramBundle.pXe.pXS = this;
    paramBundle.kr(true);
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.pXe);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.3(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.pXd.setOnFocusChangeListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.pVW = ((GridView)findViewById(2131826725));
    this.pVY = ((TextView)findViewById(2131826732));
    this.pVZ = ((TextView)findViewById(2131826731));
    this.pWa = ((TextView)findViewById(2131826733));
    this.pWb = ((TextView)findViewById(2131826730));
    this.pVU = ((TextView)findViewById(2131826723));
    this.pVV = ((TextView)findViewById(2131826726));
    this.pVX = ((GridView)findViewById(2131826728));
    this.pWc = ((TextView)findViewById(2131826724));
    this.pWd = ((TextView)findViewById(2131826727));
    this.pVT.setOnInputValidChangeListener(new PhoneRechargeUI.12(this));
    this.pVT.getInfoIv().setOnClickListener(new PhoneRechargeUI.15(this));
    this.pWe = new b();
    this.pWe.pVJ = new PhoneRechargeUI.16(this);
    this.pWf = new b();
    this.pWf.pVJ = new PhoneRechargeUI.17(this);
    this.pVW.setAdapter(this.pWe);
    this.pVX.setAdapter(this.pWf);
    this.pVR.setOnClickListener(new PhoneRechargeUI.18(this));
    this.pVS.setOnClickListener(new PhoneRechargeUI.19(this));
    this.pVT.cfI();
    int i = com.tencent.mm.cb.a.gw(this) / 4 - 20;
    ab.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.pVY.setMaxWidth(i);
    this.pVZ.setMaxWidth(i);
    this.pWa.setMaxWidth(i);
    this.pWb.setMaxWidth(i);
    this.pWi = getResources().getColor(2131690322);
    if ((this.pWl.pVu != null) && (!bo.isNullOrNil(this.pWl.pVu.name))) {
      this.desc = this.pWl.pVu.name;
    }
    this.pVT.getContentEditText().setHintTextColor(getResources().getColor(2131690380));
    if (bo.isNullOrNil(this.pVT.getText()))
    {
      b(new com.tencent.mm.plugin.recharge.model.f(""), false);
      AppMethodBeat.o(44278);
      return;
    }
    b(new com.tencent.mm.plugin.recharge.model.f(this.pVT.getText()), false);
    AppMethodBeat.o(44278);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44284);
    super.onDestroy();
    com.tencent.mm.kernel.g.Rc().b(1571, this);
    com.tencent.mm.kernel.g.Rc().b(498, this);
    com.tencent.mm.sdk.b.a.ymk.d(this.pvT);
    AppMethodBeat.o(44284);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44283);
    super.onResume();
    G(false, true);
    AppMethodBeat.o(44283);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(44292);
    if ((paramm instanceof com.tencent.mm.plugin.recharge.model.f))
    {
      paramString = (com.tencent.mm.plugin.recharge.model.f)paramm;
      l(paramm);
      if (paramString.cmdId == 0)
      {
        if ((!bo.isNullOrNil(paramString.gFX)) && (!paramString.gFX.equals(this.pVT.getText())))
        {
          ab.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.gFX, this.pVT.getText() });
          AppMethodBeat.o(44292);
          return;
        }
        if (paramString.pVd)
        {
          ab.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          XO(paramString.errMsg);
          cft();
          AppMethodBeat.o(44292);
          return;
        }
        this.mAppId = paramString.appId;
        this.pVe = paramString.pVe;
        this.pVg = paramString.pVg;
        this.pVh = paramString.pVh;
        this.pVi = paramString.pVi;
        this.pVj = paramString.pVj;
        this.errCode = paramString.errCode;
        this.errMsg = paramString.errMsg;
        this.pWh = paramString.desc;
        ab.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.pWh, this.pVT.getText() });
        if (bo.isNullOrNil(this.pWh))
        {
          this.desc = "";
          this.pWi = getResources().getColor(2131690322);
        }
        for (;;)
        {
          this.pWm = paramString.pVl;
          this.pVf = paramString.pVf;
          if (this.pVf == null) {
            break;
          }
          paramInt1 = this.pVf.size() - 1;
          while (paramInt1 >= 0)
          {
            paramm = (q)this.pVf.get(paramInt1);
            if (paramm.name.isEmpty()) {
              this.pVf.remove(paramm);
            }
            paramInt1 -= 1;
          }
          if ((this.pWl.pVu != null) && (this.pWl.pVu.pUJ.trim().equals(this.pVT.getText())))
          {
            this.pWl.pVu.pUK = this.pWh;
            this.pWl.setInput(this.pWl.pVu);
          }
        }
        if ((paramString.pVk == null) || ((paramString.pVk.name.equals(this.pVk.name)) && (paramString.pVk.url.equals(this.pVk.url)) && (paramString.pVk.tTY.equals(this.pVk.tTY)) && (paramString.pVk.fjP.equals(this.pVk.fjP)))) {
          break label865;
        }
        ab.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.pVk = paramString.pVk;
      }
    }
    label865:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.pWh.equals(""))
      {
        bool2 = false;
        G(bool2, bool1);
        paramm = paramString.pVm;
        if (paramm != null)
        {
          ab.d("MicroMsg.PhoneRechargeUI", "update record history");
          com.tencent.mm.plugin.recharge.a.a.cfm().cH(paramm);
          if (this.pWl != null)
          {
            if (!paramString.pVn) {
              break label619;
            }
            this.pWl.kr(true);
          }
        }
      }
      for (;;)
      {
        this.pVT.postDelayed(new PhoneRechargeUI.11(this), 300L);
        AppMethodBeat.o(44292);
        return;
        bool2 = true;
        break;
        label619:
        this.pWl.kr(false);
      }
      ab.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      AppMethodBeat.o(44292);
      return;
      if ((paramm instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        l(paramm);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.wallet_core.b.dRI();
          if ((com.tencent.mm.wallet_core.b.dpQ()) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_MOBILE_FEE_PAY_SWTICH_KEY"))) {}
          for (paramInt1 = i;; paramInt1 = 0)
          {
            paramString = (com.tencent.mm.plugin.recharge.model.g)paramm;
            if (paramInt1 == 0) {
              break;
            }
            ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).startWxpayQueryCashierPay(this, paramString.pVo.cnI, 6);
            com.tencent.mm.sdk.b.a.ymk.c(this.pvT);
            AppMethodBeat.o(44292);
            return;
          }
          paramm = paramString.pVo;
          paramm.cCD = 6;
          paramm.wgs = 100;
          paramm.kmA = this.pVT.getText();
          if (this.pWl.pVu != null) {}
          for (paramString = this.pWl.pVu.name;; paramString = "")
          {
            paramm.hKa = paramString;
            com.tencent.mm.pluginsdk.wallet.h.a(this, paramm, 2);
            break;
          }
        }
        paramm = paramString;
        if (bo.isNullOrNil(paramString)) {
          paramm = getString(2131305682);
        }
        XO(paramm);
      }
      AppMethodBeat.o(44292);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI
 * JD-Core Version:    0.7.0.1
 */