package com.tencent.mm.plugin.recharge.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.plugin.expt.b.c.a;
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
import com.tencent.mm.plugin.recharge.ui.form.d;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.model.n;
import com.tencent.mm.plugin.wallet.model.o;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.a;
import com.tencent.mm.wallet_core.ui.l;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI
  extends MMActivity
  implements com.tencent.mm.am.h, d.a
{
  private int GBd;
  private boolean MSo;
  private IListener MSr;
  private int NwX;
  private ArrayList<o> NwY;
  private ArrayList<o> NwZ;
  private View NxK;
  private ImageView NxL;
  private TextView NxM;
  private MallFormView NxN;
  private TextView NxO;
  private TextView NxP;
  private GridView NxQ;
  private GridView NxR;
  private TextView NxS;
  private TextView NxT;
  private TextView NxU;
  private TextView NxV;
  private TextView NxW;
  private TextView NxX;
  private b NxY;
  private b NxZ;
  private com.tencent.mm.plugin.wallet.model.e Nxa;
  private com.tencent.mm.plugin.wallet.model.e Nxb;
  private com.tencent.mm.plugin.wallet.model.e Nxc;
  private com.tencent.mm.plugin.wallet.model.e Nxd;
  private com.tencent.mm.plugin.wallet.model.e Nxe;
  private MallFunction Nya;
  private String Nyb;
  private String Nyc;
  private c.b Nyd;
  private n Nye;
  private boolean Nyf;
  private List<String[]> Nyg;
  private boolean Nyh;
  private String desc;
  private int errCode;
  private String errMsg;
  private String headUrl;
  private String mAppId;
  protected Dialog tipDialog;
  
  public PhoneRechargeUI()
  {
    AppMethodBeat.i(67185);
    this.NxK = null;
    this.NxL = null;
    this.NxM = null;
    this.NxN = null;
    this.NxO = null;
    this.NxP = null;
    this.NxQ = null;
    this.NxR = null;
    this.NxS = null;
    this.NxT = null;
    this.NxU = null;
    this.NxV = null;
    this.NxW = null;
    this.NxX = null;
    this.NxY = null;
    this.NxZ = null;
    this.tipDialog = null;
    this.Nya = null;
    this.mAppId = "";
    this.NwY = null;
    this.NwZ = null;
    this.Nxa = null;
    this.Nxb = null;
    this.Nxc = null;
    this.Nxd = null;
    this.Nxe = null;
    this.errCode = 0;
    this.errMsg = "";
    this.Nyb = "";
    this.desc = "";
    this.Nyc = "";
    this.headUrl = "";
    this.MSo = false;
    this.Nyd = null;
    this.Nye = null;
    this.Nyf = false;
    this.MSr = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(67185);
  }
  
  private void aI(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67194);
    label105:
    String str;
    if ((this.Nye != null) && (!gFM()))
    {
      this.NxK.setVisibility(0);
      this.NxM.setText(this.Nye.name);
      Log.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
      com.tencent.mm.protocal.g.ik(6, 0);
      this.NxY.NxC = this.NwY;
      this.NxY.notifyDataSetChanged();
      this.NxZ.NxC = this.NwZ;
      this.NxZ.notifyDataSetChanged();
      if (paramBoolean1) {
        break label424;
      }
      this.NxW.setVisibility(8);
      this.NxX.setVisibility(8);
      if (paramBoolean2) {
        addTextOptionMenu(0, this.Nxe.name, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(67164);
            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.i(PhoneRechargeUI.this).Vlq, PhoneRechargeUI.i(PhoneRechargeUI.this).nUS, PhoneRechargeUI.i(PhoneRechargeUI.this).name, "")) {}
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
      TextView localTextView = this.NxO;
      if ((this.NwY == null) || (this.NwY.size() <= 0) || (Util.isNullOrNil(((o)this.NwY.get(0)).VlV))) {
        break label469;
      }
      str = ((o)this.NwY.get(0)).VlV;
      label196:
      localTextView.setText(str);
      localTextView = this.NxP;
      if ((this.NwZ == null) || (this.NwZ.size() <= 0) || (Util.isNullOrNil(((o)this.NwZ.get(0)).VlV))) {
        break label480;
      }
      str = ((o)this.NwZ.get(0)).VlV;
      label260:
      localTextView.setText(str);
      if ((this.Nxd != null) && (!Util.isNullOrNil(this.Nxd.name))) {
        break label491;
      }
      this.NxT.setVisibility(8);
      label295:
      if ((this.Nxa != null) && (!Util.isNullOrNil(this.Nxa.name))) {
        break label531;
      }
      this.NxS.setVisibility(8);
      label324:
      if ((this.Nxb != null) && (!Util.isNullOrNil(this.Nxb.name))) {
        break label571;
      }
      this.NxU.setVisibility(8);
      label353:
      if ((this.Nxc != null) && (!Util.isNullOrNil(this.Nxc.name))) {
        break label611;
      }
      this.NxV.setVisibility(8);
    }
    for (;;)
    {
      if (this.Nyh) {
        h(this.Nya);
      }
      AppMethodBeat.o(67194);
      return;
      this.NxK.setVisibility(8);
      Log.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break;
      label424:
      if (gFO()) {
        this.NxW.setVisibility(0);
      }
      for (;;)
      {
        if (!gFN()) {
          break label467;
        }
        this.NxX.setVisibility(0);
        break;
        this.NxW.setVisibility(8);
      }
      label467:
      break label105;
      label469:
      str = getString(a.i.wallet_recharge_fee_title);
      break label196;
      label480:
      str = getString(a.i.wallet_recharge_flow_title);
      break label260;
      label491:
      this.NxT.setVisibility(0);
      this.NxT.setText(this.Nxd.name);
      this.NxT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67165);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).Vlq, PhoneRechargeUI.j(PhoneRechargeUI.this).nUS, PhoneRechargeUI.j(PhoneRechargeUI.this).name, ""))
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
      this.NxS.setVisibility(0);
      this.NxS.setText(this.Nxa.name);
      this.NxS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67166);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).Vlq, PhoneRechargeUI.k(PhoneRechargeUI.this).nUS, PhoneRechargeUI.k(PhoneRechargeUI.this).name, ""))
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
      this.NxU.setVisibility(0);
      this.NxU.setText(this.Nxb.name);
      this.NxU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).Vlq, PhoneRechargeUI.l(PhoneRechargeUI.this).nUS, PhoneRechargeUI.l(PhoneRechargeUI.this).name, ""))
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
      this.NxV.setVisibility(0);
      this.NxV.setText(this.Nxc.name);
      this.NxV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67168);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).Vlq, PhoneRechargeUI.m(PhoneRechargeUI.this).nUS, PhoneRechargeUI.m(PhoneRechargeUI.this).name, ""))
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
  
  private String aSB(String paramString)
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
      if (this.Nyd != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.Nyd.Nxo != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!Util.isNullOrNil(this.Nyd.Nxo.name))
          {
            str1 = paramString;
            localObject1 = this.Nyd.Nxo.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(a.i.wallet_recharge_me))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.NxN.getText();
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
  
  private void aSC(final String paramString)
  {
    AppMethodBeat.i(67198);
    View localView = af.mU(this).inflate(a.g.recharge_remind_dialog, null);
    k.a(getContext(), getString(a.i.wallet_recharge_unicom_message_title), localView, getString(a.i.wallet_recharge_unicom_message_yes), getString(a.i.wallet_recharge_unicom_message_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(67169);
        paramAnonymousDialogInterface = PhoneRechargeUI.b(PhoneRechargeUI.this, paramString);
        Log.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousDialogInterface });
        PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousDialogInterface, PhoneRechargeUI.this.getString(a.i.wallet_recharge_unicom_message_title), "");
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
  
  private void aSD(String paramString)
  {
    AppMethodBeat.i(67200);
    k.a(this, paramString, "", false, new DialogInterface.OnClickListener()
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
  
  private void c(final p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(67191);
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      if (!paramBoolean) {
        break label71;
      }
    }
    label71:
    for (this.tipDialog = l.a(getContext(), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(67162);
            com.tencent.mm.kernel.h.aZW().a(paramp);
            AppMethodBeat.o(67162);
          }
        });; this.tipDialog = l.c(getContext(), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(67163);
            com.tencent.mm.kernel.h.aZW().a(paramp);
            AppMethodBeat.o(67163);
          }
        }))
    {
      com.tencent.mm.kernel.h.aZW().a(paramp, 0);
      AppMethodBeat.o(67191);
      return;
    }
  }
  
  private void gFL()
  {
    AppMethodBeat.i(67186);
    this.mAppId = "";
    gFP();
    this.errCode = 0;
    this.errMsg = "";
    this.desc = "";
    AppMethodBeat.o(67186);
  }
  
  private boolean gFM()
  {
    AppMethodBeat.i(67189);
    if (this.Nye != null)
    {
      Object localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIZ, "");
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
            if ((localObject2 != null) && (localObject2.equals(String.valueOf(this.Nye.id))))
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
  
  private boolean gFN()
  {
    AppMethodBeat.i(67195);
    Iterator localIterator = this.NwZ.iterator();
    while (localIterator.hasNext()) {
      if (((o)localIterator.next()).status != 0)
      {
        AppMethodBeat.o(67195);
        return false;
      }
    }
    AppMethodBeat.o(67195);
    return true;
  }
  
  private boolean gFO()
  {
    AppMethodBeat.i(67196);
    Iterator localIterator = this.NwY.iterator();
    while (localIterator.hasNext()) {
      if (((o)localIterator.next()).status != 0)
      {
        AppMethodBeat.o(67196);
        return false;
      }
    }
    AppMethodBeat.o(67196);
    return true;
  }
  
  private void gFP()
  {
    AppMethodBeat.i(67199);
    this.NwY = new ArrayList();
    o localo1 = new o();
    localo1.name = getString(a.i.wallet_recharge_default_item_0);
    localo1.status = 0;
    o localo2 = new o();
    localo2.name = getString(a.i.wallet_recharge_default_item_1);
    localo2.status = 0;
    o localo3 = new o();
    localo3.name = getString(a.i.wallet_recharge_default_item_2);
    localo3.status = 0;
    o localo4 = new o();
    localo4.name = getString(a.i.wallet_recharge_default_item_3);
    localo4.status = 0;
    o localo5 = new o();
    localo5.name = getString(a.i.wallet_recharge_default_item_4);
    localo5.status = 0;
    o localo6 = new o();
    localo6.name = getString(a.i.wallet_recharge_default_item_5);
    localo6.status = 0;
    this.NwY.add(localo1);
    this.NwY.add(localo2);
    this.NwY.add(localo3);
    this.NwY.add(localo4);
    this.NwY.add(localo5);
    this.NwY.add(localo6);
    this.NwZ = new ArrayList();
    localo1 = new o();
    localo1.name = getString(a.i.wallet_recharge_default_item_6);
    localo1.status = 0;
    localo2 = new o();
    localo2.name = getString(a.i.wallet_recharge_default_item_7);
    localo2.status = 0;
    localo3 = new o();
    localo3.name = getString(a.i.wallet_recharge_default_item_8);
    localo3.status = 0;
    this.NwZ.add(localo1);
    this.NwZ.add(localo2);
    this.NwZ.add(localo3);
    AppMethodBeat.o(67199);
  }
  
  private void gFQ()
  {
    AppMethodBeat.i(67203);
    com.tencent.mm.kernel.h.aZW().a(new com.tencent.mm.plugin.recharge.model.f(this.NxN.getText()), 0);
    AppMethodBeat.o(67203);
  }
  
  private void h(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67197);
    if (com.tencent.mm.plugin.recharge.model.b.g(paramMallFunction))
    {
      com.tencent.mm.plugin.recharge.model.b.gFH();
      if (this.Nya.VKI == null)
      {
        AppMethodBeat.o(67197);
        return;
      }
      Log.d("MicroMsg.PhoneRechargeUI", this.Nya.VKI.toString());
      aSC(this.Nya.VKI.VKW);
    }
    AppMethodBeat.o(67197);
  }
  
  private void m(p paramp)
  {
    AppMethodBeat.i(67190);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramp.getType() != 497))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(67190);
  }
  
  public final void gFR()
  {
    AppMethodBeat.i(67204);
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.h.aZW().a(localf, 0);
    AppMethodBeat.o(67204);
  }
  
  public int getLayoutId()
  {
    return a.g.phone_recharge_ui;
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
        this.Nyf = true;
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
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.Tu((String)localObject3);
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
          k.c(this, getString(a.i.mall_recharge_read_contact_error), "", true);
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
          localObject2 = k.a(this, getString(a.i.wallet_recharge_pick_phone_number), localArrayList, -1, new k.a()
          {
            public final void agm(int paramAnonymousInt)
            {
              AppMethodBeat.i(67176);
              Log.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
              PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(paramAnonymousInt), this.Nyn, 1));
              PhoneRechargeUI.n(PhoneRechargeUI.this);
              AppMethodBeat.o(67176);
            }
          });
          if (localObject2 != null) {
            ((com.tencent.mm.ui.widget.a.e)localObject2).setCanceledOnTouchOutside(true);
          }
        }
        else if (localArrayList.size() == 1)
        {
          this.Nyd.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          gFQ();
        }
        else
        {
          k.c(this, getString(a.i.mall_recharge_pick_contact_error), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.MSo)
            {
              Log.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.NxN.getText(), this.NxN.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.gFE().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.MSo = true;
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
    com.tencent.mm.kernel.h.aZW().a(1571, this);
    com.tencent.mm.kernel.h.aZW().a(498, this);
    this.Nya = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    this.Nyh = getIntent().getBooleanExtra("key_need_show_remind_dialog", true);
    gFP();
    if (this.Nya == null)
    {
      Log.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      aa.makeText(this, "function info is null", 1).show();
      finish();
      AppMethodBeat.o(67187);
      return;
    }
    setMMTitle(this.Nya.idA);
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
    this.Nxe = new com.tencent.mm.plugin.wallet.model.e();
    this.Nxe.name = getString(a.i.wallet_recharge_hardcode_head_name);
    this.Nxe.url = "http%3A%2F%2Fkf.qq.com%2Ftouch%2Fproduct%2Fwechatrecharge_app.html";
    this.NxK = findViewById(a.f.phone_recharge_banner_rl);
    this.NxL = ((ImageView)findViewById(a.f.news_close));
    this.NxM = ((TextView)findViewById(a.f.news_wording));
    this.NxN = ((MallFormView)findViewById(a.f.recharge_content_input_view));
    c.b(this.NxN);
    this.Nyd = new c.b(this.NxN);
    paramBundle = this.Nyd;
    Log.d(c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.NyW;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).Nzc != null) {
      ((MallFormView)localObject).Nzc.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.NyW.getContentEditText();
    ThreadPool.post(new c.b.2(paramBundle), "fetch_phone_book");
    paramBundle.NyX = new d(paramBundle.NyW, paramBundle.Nxn);
    paramBundle.NyX.NzK = new c.b.3(paramBundle);
    paramBundle.NyX.NzL = this;
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.NyX);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.NyW.setOnFocusChangeListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.6(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.NxQ = ((GridView)findViewById(a.f.recharge_phone_grid));
    this.NxS = ((TextView)findViewById(a.f.recharge_remind));
    this.NxT = ((TextView)findViewById(a.f.recharge_weSim));
    this.NxU = ((TextView)findViewById(a.f.recharge_buy_card));
    this.NxV = ((TextView)findViewById(a.f.recharge_hall));
    this.NxO = ((TextView)findViewById(a.f.recharge_product_1_title));
    this.NxP = ((TextView)findViewById(a.f.recharge_product_2_title));
    this.NxR = ((GridView)findViewById(a.f.recharge_dataflow_grid));
    this.NxW = ((TextView)findViewById(a.f.recharge_product_1_lack_alert));
    this.NxX = ((TextView)findViewById(a.f.recharge_product_2_lack_alert));
    this.NxN.setOnInputValidChangeListener(new MallFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(67174);
        if (paramAnonymousBoolean)
        {
          PhoneRechargeUI.this.hideVKB();
          final String str = com.tencent.mm.plugin.recharge.model.b.Tu(PhoneRechargeUI.a(PhoneRechargeUI.this).getText());
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
                  PhoneRechargeUI.aSE(PhoneRechargeUI.12.1.this.Nyj);
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
        PhoneRechargeUI.a(PhoneRechargeUI.this).getTipsTv().setTextColor(PhoneRechargeUI.this.getResources().getColor(a.c.normal_text_color));
        PhoneRechargeUI.d(PhoneRechargeUI.this);
        PhoneRechargeUI.e(PhoneRechargeUI.this);
        if (Util.isNullOrNil(PhoneRechargeUI.a(PhoneRechargeUI.this).getText())) {
          ((AutoCompleteTextView)PhoneRechargeUI.a(PhoneRechargeUI.this).getContentEditText()).showDropDown();
        }
        AppMethodBeat.o(67174);
      }
    });
    this.NxN.getInfoIv().setOnClickListener(new PhoneRechargeUI.15(this));
    this.NxY = new b();
    this.NxY.NxD = new b.a()
    {
      public final void a(o paramAnonymouso)
      {
        AppMethodBeat.i(67179);
        if (paramAnonymouso == null)
        {
          Log.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
          AppMethodBeat.o(67179);
          return;
        }
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymouso.Vlq, paramAnonymouso.nUS, paramAnonymouso.name, paramAnonymouso.desc))
        {
          if (!Util.isNullOrNil(paramAnonymouso.url))
          {
            String str = PhoneRechargeUI.b(PhoneRechargeUI.this, paramAnonymouso.url);
            PhoneRechargeUI.a(PhoneRechargeUI.this, str, paramAnonymouso.name, paramAnonymouso.desc);
            AppMethodBeat.o(67179);
            return;
          }
          if (PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymouso)) {
            PhoneRechargeUI.b(PhoneRechargeUI.this, paramAnonymouso);
          }
        }
        AppMethodBeat.o(67179);
      }
    };
    this.NxZ = new b();
    this.NxZ.NxD = new b.a()
    {
      public final void a(o paramAnonymouso)
      {
        AppMethodBeat.i(67180);
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymouso.Vlq, paramAnonymouso.nUS, paramAnonymouso.name, paramAnonymouso.desc))
        {
          if (!Util.isNullOrNil(paramAnonymouso.url))
          {
            String str = PhoneRechargeUI.b(PhoneRechargeUI.this, paramAnonymouso.url);
            PhoneRechargeUI.a(PhoneRechargeUI.this, str, paramAnonymouso.name, paramAnonymouso.desc);
            AppMethodBeat.o(67180);
            return;
          }
          if (PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymouso))
          {
            PhoneRechargeUI.b(PhoneRechargeUI.this, paramAnonymouso);
            AppMethodBeat.o(67180);
            return;
          }
          Log.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
        }
        AppMethodBeat.o(67180);
      }
    };
    this.NxQ.setAdapter(this.NxY);
    this.NxR.setAdapter(this.NxZ);
    this.NxL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67181);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.NxM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67182);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null)
        {
          com.tencent.mm.protocal.g.ik(6, 1);
          if ((PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.f(PhoneRechargeUI.this).Vlq, PhoneRechargeUI.f(PhoneRechargeUI.this).nUS, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "")) || (Util.isNullOrNil(PhoneRechargeUI.f(PhoneRechargeUI.this).url))) {}
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
    this.NxN.gGb();
    int i = com.tencent.mm.cd.a.ms(this) / 4 - 20;
    Log.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.NxS.setMaxWidth(i);
    this.NxT.setMaxWidth(i);
    this.NxU.setMaxWidth(i);
    this.NxV.setMaxWidth(i);
    this.GBd = getResources().getColor(a.c.normal_text_color);
    if ((this.Nyd.Nxo != null) && (!Util.isNullOrNil(this.Nyd.Nxo.name))) {
      this.desc = this.Nyd.Nxo.name;
    }
    this.NxN.getContentEditText().setHintTextColor(getResources().getColor(a.c.recharge_no_phone_hint_text_color));
    if (Util.isNullOrNil(this.NxN.getText()))
    {
      c(new com.tencent.mm.plugin.recharge.model.f(""), false);
      AppMethodBeat.o(67187);
      return;
    }
    c(new com.tencent.mm.plugin.recharge.model.f(this.NxN.getText()), false);
    AppMethodBeat.o(67187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67193);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(1571, this);
    com.tencent.mm.kernel.h.aZW().b(498, this);
    this.MSr.dead();
    AppMethodBeat.o(67193);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67192);
    super.onResume();
    aI(false, true);
    AppMethodBeat.o(67192);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67201);
    if ((paramp instanceof com.tencent.mm.plugin.recharge.model.f))
    {
      paramString = (com.tencent.mm.plugin.recharge.model.f)paramp;
      m(paramp);
      if (paramString.cmdId == 0)
      {
        if ((!Util.isNullOrNil(paramString.qcQ)) && (!paramString.qcQ.equals(this.NxN.getText())))
        {
          Log.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.qcQ, this.NxN.getText() });
          AppMethodBeat.o(67201);
          return;
        }
        if (paramString.NwW)
        {
          Log.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          aSD(paramString.errMsg);
          gFL();
          AppMethodBeat.o(67201);
          return;
        }
        this.mAppId = paramString.appId;
        this.NwX = paramString.NwX;
        this.NwY = paramString.NwY;
        this.Nxa = paramString.Nxa;
        this.Nxb = paramString.Nxb;
        this.Nxc = paramString.Nxc;
        this.Nxd = paramString.Nxd;
        this.errCode = paramString.errCode;
        this.errMsg = paramString.errMsg;
        this.Nyb = paramString.desc;
        Log.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.Nyb, this.NxN.getText() });
        if (Util.isNullOrNil(this.Nyb))
        {
          this.desc = "";
          this.GBd = getResources().getColor(a.c.normal_text_color);
        }
        for (;;)
        {
          this.Nye = paramString.Nxf;
          this.NwZ = paramString.NwZ;
          if (this.NwZ == null) {
            break;
          }
          paramInt1 = this.NwZ.size() - 1;
          while (paramInt1 >= 0)
          {
            paramp = (o)this.NwZ.get(paramInt1);
            if (paramp.name.isEmpty()) {
              this.NwZ.remove(paramp);
            }
            paramInt1 -= 1;
          }
          if ((this.Nyd.Nxo != null) && (this.Nyd.Nxo.NwG.trim().equals(this.NxN.getText())))
          {
            this.Nyd.Nxo.mse = this.Nyb;
            this.Nyd.setInput(this.Nyd.Nxo);
          }
        }
        if ((paramString.Nxe == null) || ((paramString.Nxe.name.equals(this.Nxe.name)) && (paramString.Nxe.url.equals(this.Nxe.url)) && (paramString.Nxe.Vlq.equals(this.Nxe.Vlq)) && (paramString.Nxe.nUS.equals(this.Nxe.nUS)))) {
          break label840;
        }
        Log.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.Nxe = paramString.Nxe;
      }
    }
    label840:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.Nyb.equals(""))
      {
        bool2 = false;
        aI(bool2, bool1);
        paramString = paramString.Nxg;
        Log.d("MicroMsg.PhoneRechargeUI", "update record history");
        com.tencent.mm.plugin.recharge.a.a.gFE().jE(paramString);
        if (this.Nyd != null)
        {
          if (!Util.isNullOrNil(this.NxN.getText())) {
            break label623;
          }
          this.Nyd.AR(true);
        }
      }
      for (;;)
      {
        this.NxN.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67175);
            PhoneRechargeUI.a(PhoneRechargeUI.this).gGc();
            AppMethodBeat.o(67175);
          }
        }, 300L);
        AppMethodBeat.o(67201);
        return;
        bool2 = true;
        break;
        label623:
        this.Nyd.AR(false);
      }
      Log.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      AppMethodBeat.o(67201);
      return;
      if ((paramp instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        m(paramp);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.wallet_core.b.jNX();
          bool1 = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
          paramString = (com.tencent.mm.plugin.recharge.model.g)paramp;
          if (bool1)
          {
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(paramString.Nxi.hAT, 6);
            this.MSr.alive();
            AppMethodBeat.o(67201);
            return;
          }
          paramp = paramString.Nxi;
          paramp.hUR = 6;
          paramp.YvD = 100;
          paramp.wsM = this.NxN.getText();
          if (this.Nyd.Nxo != null) {}
          for (paramString = this.Nyd.Nxo.name;; paramString = "")
          {
            paramp.remark = paramString;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramp, 2);
            break;
          }
        }
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = getString(a.i.wallet_unknown_err);
        }
        aSD(paramp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI
 * JD-Core Version:    0.7.0.1
 */