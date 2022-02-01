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
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abh;
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
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
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
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.w;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI
  extends MMActivity
  implements com.tencent.mm.an.i, d.a
{
  private int AYZ;
  private boolean GUM;
  private IListener GUP;
  private c.b HAA;
  private p HAB;
  private boolean HAC;
  private List<String[]> HAD;
  private boolean HAE;
  private View HAh;
  private ImageView HAi;
  private TextView HAj;
  private MallFormView HAk;
  private TextView HAl;
  private TextView HAm;
  private GridView HAn;
  private GridView HAo;
  private TextView HAp;
  private TextView HAq;
  private TextView HAr;
  private TextView HAs;
  private TextView HAt;
  private TextView HAu;
  private b HAv;
  private b HAw;
  private MallFunction HAx;
  private String HAy;
  private String HAz;
  private e HzA;
  private e HzB;
  private int Hzu;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> Hzv;
  private ArrayList<com.tencent.mm.plugin.wallet.a.q> Hzw;
  private e Hzx;
  private e Hzy;
  private e Hzz;
  private String desc;
  private int errCode;
  private String errMsg;
  private String headUrl;
  private String mAppId;
  protected Dialog tipDialog;
  
  public PhoneRechargeUI()
  {
    AppMethodBeat.i(67185);
    this.HAh = null;
    this.HAi = null;
    this.HAj = null;
    this.HAk = null;
    this.HAl = null;
    this.HAm = null;
    this.HAn = null;
    this.HAo = null;
    this.HAp = null;
    this.HAq = null;
    this.HAr = null;
    this.HAs = null;
    this.HAt = null;
    this.HAu = null;
    this.HAv = null;
    this.HAw = null;
    this.tipDialog = null;
    this.HAx = null;
    this.mAppId = "";
    this.Hzv = null;
    this.Hzw = null;
    this.Hzx = null;
    this.Hzy = null;
    this.Hzz = null;
    this.HzA = null;
    this.HzB = null;
    this.errCode = 0;
    this.errMsg = "";
    this.HAy = "";
    this.desc = "";
    this.HAz = "";
    this.headUrl = "";
    this.GUM = false;
    this.HAA = null;
    this.HAB = null;
    this.HAC = false;
    this.GUP = new IListener() {};
    AppMethodBeat.o(67185);
  }
  
  private String aVt(String paramString)
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
      if (this.HAA != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.HAA.HzL != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!Util.isNullOrNil(this.HAA.HzL.name))
          {
            str1 = paramString;
            localObject1 = this.HAA.HzL.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(a.i.wallet_recharge_me))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.HAk.getText();
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
  
  private void aVu(final String paramString)
  {
    AppMethodBeat.i(67198);
    View localView = ad.kS(this).inflate(a.g.recharge_remind_dialog, null);
    com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.wallet_recharge_unicom_message_title), localView, getString(a.i.wallet_recharge_unicom_message_yes), getString(a.i.wallet_recharge_unicom_message_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private void aVv(String paramString)
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
  
  private void ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67194);
    label105:
    String str;
    if ((this.HAB != null) && (!ftY()))
    {
      this.HAh.setVisibility(0);
      this.HAj.setText(this.HAB.name);
      Log.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
      com.tencent.mm.protocal.g.gU(6, 0);
      this.HAv.HzZ = this.Hzv;
      this.HAv.notifyDataSetChanged();
      this.HAw.HzZ = this.Hzw;
      this.HAw.notifyDataSetChanged();
      if (paramBoolean1) {
        break label424;
      }
      this.HAt.setVisibility(8);
      this.HAu.setVisibility(8);
      if (paramBoolean2) {
        addTextOptionMenu(0, this.HzB.name, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(67164);
            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.i(PhoneRechargeUI.this).Owf, PhoneRechargeUI.i(PhoneRechargeUI.this).lpQ, PhoneRechargeUI.i(PhoneRechargeUI.this).name, "")) {}
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
      TextView localTextView = this.HAl;
      if ((this.Hzv == null) || (this.Hzv.size() <= 0) || (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.Hzv.get(0)).OwK))) {
        break label469;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.Hzv.get(0)).OwK;
      label196:
      localTextView.setText(str);
      localTextView = this.HAm;
      if ((this.Hzw == null) || (this.Hzw.size() <= 0) || (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.a.q)this.Hzw.get(0)).OwK))) {
        break label480;
      }
      str = ((com.tencent.mm.plugin.wallet.a.q)this.Hzw.get(0)).OwK;
      label260:
      localTextView.setText(str);
      if ((this.HzA != null) && (!Util.isNullOrNil(this.HzA.name))) {
        break label491;
      }
      this.HAq.setVisibility(8);
      label295:
      if ((this.Hzx != null) && (!Util.isNullOrNil(this.Hzx.name))) {
        break label531;
      }
      this.HAp.setVisibility(8);
      label324:
      if ((this.Hzy != null) && (!Util.isNullOrNil(this.Hzy.name))) {
        break label571;
      }
      this.HAr.setVisibility(8);
      label353:
      if ((this.Hzz != null) && (!Util.isNullOrNil(this.Hzz.name))) {
        break label611;
      }
      this.HAs.setVisibility(8);
    }
    for (;;)
    {
      if (this.HAE) {
        h(this.HAx);
      }
      AppMethodBeat.o(67194);
      return;
      this.HAh.setVisibility(8);
      Log.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break;
      label424:
      if (fua()) {
        this.HAt.setVisibility(0);
      }
      for (;;)
      {
        if (!ftZ()) {
          break label467;
        }
        this.HAu.setVisibility(0);
        break;
        this.HAt.setVisibility(8);
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
      this.HAq.setVisibility(0);
      this.HAq.setText(this.HzA.name);
      this.HAq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67165);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).Owf, PhoneRechargeUI.j(PhoneRechargeUI.this).lpQ, PhoneRechargeUI.j(PhoneRechargeUI.this).name, ""))
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
      this.HAp.setVisibility(0);
      this.HAp.setText(this.Hzx.name);
      this.HAp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67166);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).Owf, PhoneRechargeUI.k(PhoneRechargeUI.this).lpQ, PhoneRechargeUI.k(PhoneRechargeUI.this).name, ""))
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
      this.HAr.setVisibility(0);
      this.HAr.setText(this.Hzy.name);
      this.HAr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).Owf, PhoneRechargeUI.l(PhoneRechargeUI.this).lpQ, PhoneRechargeUI.l(PhoneRechargeUI.this).name, ""))
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
      this.HAs.setVisibility(0);
      this.HAs.setText(this.Hzz.name);
      this.HAs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67168);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).Owf, PhoneRechargeUI.m(PhoneRechargeUI.this).lpQ, PhoneRechargeUI.m(PhoneRechargeUI.this).name, ""))
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
  
  private void c(final com.tencent.mm.an.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(67191);
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      if (!paramBoolean) {
        break label71;
      }
    }
    label71:
    for (this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(getContext(), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(67162);
            com.tencent.mm.kernel.h.aGY().a(paramq);
            AppMethodBeat.o(67162);
          }
        });; this.tipDialog = com.tencent.mm.wallet_core.ui.i.c(getContext(), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(67163);
            com.tencent.mm.kernel.h.aGY().a(paramq);
            AppMethodBeat.o(67163);
          }
        }))
    {
      com.tencent.mm.kernel.h.aGY().a(paramq, 0);
      AppMethodBeat.o(67191);
      return;
    }
  }
  
  private void ftX()
  {
    AppMethodBeat.i(67186);
    this.mAppId = "";
    fub();
    this.errCode = 0;
    this.errMsg = "";
    this.desc = "";
    AppMethodBeat.o(67186);
  }
  
  private boolean ftY()
  {
    AppMethodBeat.i(67189);
    if (this.HAB != null)
    {
      Object localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VhF, "");
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
            if ((localObject2 != null) && (localObject2.equals(String.valueOf(this.HAB.id))))
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
  
  private boolean ftZ()
  {
    AppMethodBeat.i(67195);
    Iterator localIterator = this.Hzw.iterator();
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
  
  private boolean fua()
  {
    AppMethodBeat.i(67196);
    Iterator localIterator = this.Hzv.iterator();
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
  
  private void fub()
  {
    AppMethodBeat.i(67199);
    this.Hzv = new ArrayList();
    com.tencent.mm.plugin.wallet.a.q localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(a.i.wallet_recharge_default_item_0);
    localq1.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(a.i.wallet_recharge_default_item_1);
    localq2.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(a.i.wallet_recharge_default_item_2);
    localq3.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq4 = new com.tencent.mm.plugin.wallet.a.q();
    localq4.name = getString(a.i.wallet_recharge_default_item_3);
    localq4.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq5 = new com.tencent.mm.plugin.wallet.a.q();
    localq5.name = getString(a.i.wallet_recharge_default_item_4);
    localq5.status = 0;
    com.tencent.mm.plugin.wallet.a.q localq6 = new com.tencent.mm.plugin.wallet.a.q();
    localq6.name = getString(a.i.wallet_recharge_default_item_5);
    localq6.status = 0;
    this.Hzv.add(localq1);
    this.Hzv.add(localq2);
    this.Hzv.add(localq3);
    this.Hzv.add(localq4);
    this.Hzv.add(localq5);
    this.Hzv.add(localq6);
    this.Hzw = new ArrayList();
    localq1 = new com.tencent.mm.plugin.wallet.a.q();
    localq1.name = getString(a.i.wallet_recharge_default_item_6);
    localq1.status = 0;
    localq2 = new com.tencent.mm.plugin.wallet.a.q();
    localq2.name = getString(a.i.wallet_recharge_default_item_7);
    localq2.status = 0;
    localq3 = new com.tencent.mm.plugin.wallet.a.q();
    localq3.name = getString(a.i.wallet_recharge_default_item_8);
    localq3.status = 0;
    this.Hzw.add(localq1);
    this.Hzw.add(localq2);
    this.Hzw.add(localq3);
    AppMethodBeat.o(67199);
  }
  
  private void fuc()
  {
    AppMethodBeat.i(67203);
    com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.plugin.recharge.model.f(this.HAk.getText()), 0);
    AppMethodBeat.o(67203);
  }
  
  private void h(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67197);
    if (com.tencent.mm.plugin.recharge.model.b.g(paramMallFunction))
    {
      com.tencent.mm.plugin.recharge.model.b.ftT();
      if (this.HAx.OUr == null)
      {
        AppMethodBeat.o(67197);
        return;
      }
      Log.d("MicroMsg.PhoneRechargeUI", this.HAx.OUr.toString());
      aVu(this.HAx.OUr.OUF);
    }
    AppMethodBeat.o(67197);
  }
  
  private void m(com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(67190);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramq.getType() != 497))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(67190);
  }
  
  public final void fud()
  {
    AppMethodBeat.i(67204);
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.h.aGY().a(localf, 0);
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
        this.HAC = true;
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
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.aaY((String)localObject3);
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
          com.tencent.mm.ui.base.h.c(this, getString(a.i.mall_recharge_read_contact_error), "", true);
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
          localObject2 = com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_recharge_pick_phone_number), localArrayList, -1, new h.a()
          {
            public final void abY(int paramAnonymousInt)
            {
              AppMethodBeat.i(67176);
              Log.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
              PhoneRechargeUI.b(PhoneRechargeUI.this).setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(paramAnonymousInt), this.HAK, 1));
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
          this.HAA.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          fuc();
        }
        else
        {
          com.tencent.mm.ui.base.h.c(this, getString(a.i.mall_recharge_pick_contact_error), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.GUM)
            {
              Log.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.HAk.getText(), this.HAk.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.ftQ().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.GUM = true;
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
    com.tencent.mm.kernel.h.aGY().a(1571, this);
    com.tencent.mm.kernel.h.aGY().a(498, this);
    this.HAx = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    this.HAE = getIntent().getBooleanExtra("key_need_show_remind_dialog", true);
    fub();
    if (this.HAx == null)
    {
      Log.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      w.makeText(this, "function info is null", 1).show();
      finish();
      AppMethodBeat.o(67187);
      return;
    }
    setMMTitle(this.HAx.fXz);
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
    this.HzB = new e();
    this.HzB.name = getString(a.i.wallet_recharge_hardcode_head_name);
    this.HzB.url = getString(a.i.wallet_recharge_hardcode_head_url);
    this.HAh = findViewById(a.f.phone_recharge_banner_rl);
    this.HAi = ((ImageView)findViewById(a.f.news_close));
    this.HAj = ((TextView)findViewById(a.f.news_wording));
    this.HAk = ((MallFormView)findViewById(a.f.recharge_content_input_view));
    c.b(this.HAk);
    this.HAA = new c.b(this.HAk);
    paramBundle = this.HAA;
    Log.d(c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.HBt;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).HBz != null) {
      ((MallFormView)localObject).HBz.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.HBt.getContentEditText();
    ThreadPool.post(new c.b.2(paramBundle), "fetch_phone_book");
    paramBundle.HBu = new com.tencent.mm.plugin.recharge.ui.form.d(paramBundle.HBt, paramBundle.HzK);
    paramBundle.HBu.HCh = new c.b.3(paramBundle);
    paramBundle.HBu.HCi = this;
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.HBu);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.HBt.setOnFocusChangeListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.6(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.HAn = ((GridView)findViewById(a.f.recharge_phone_grid));
    this.HAp = ((TextView)findViewById(a.f.recharge_remind));
    this.HAq = ((TextView)findViewById(a.f.recharge_weSim));
    this.HAr = ((TextView)findViewById(a.f.recharge_buy_card));
    this.HAs = ((TextView)findViewById(a.f.recharge_hall));
    this.HAl = ((TextView)findViewById(a.f.recharge_product_1_title));
    this.HAm = ((TextView)findViewById(a.f.recharge_product_2_title));
    this.HAo = ((GridView)findViewById(a.f.recharge_dataflow_grid));
    this.HAt = ((TextView)findViewById(a.f.recharge_product_1_lack_alert));
    this.HAu = ((TextView)findViewById(a.f.recharge_product_2_lack_alert));
    this.HAk.setOnInputValidChangeListener(new MallFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(67174);
        if (paramAnonymousBoolean)
        {
          PhoneRechargeUI.this.hideVKB();
          final String str = com.tencent.mm.plugin.recharge.model.b.aaY(PhoneRechargeUI.a(PhoneRechargeUI.this).getText());
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
                  PhoneRechargeUI.aVw(PhoneRechargeUI.12.1.this.HAG);
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
    this.HAk.getInfoIv().setOnClickListener(new PhoneRechargeUI.16(this));
    this.HAv = new b();
    this.HAv.HAa = new b.a()
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
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.Owf, paramAnonymousq.lpQ, paramAnonymousq.name, paramAnonymousq.desc))
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
    this.HAw = new b();
    this.HAw.HAa = new b.a()
    {
      public final void a(com.tencent.mm.plugin.wallet.a.q paramAnonymousq)
      {
        AppMethodBeat.i(67180);
        if (!PhoneRechargeUI.a(PhoneRechargeUI.this, paramAnonymousq.Owf, paramAnonymousq.lpQ, paramAnonymousq.name, paramAnonymousq.desc))
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
    this.HAn.setAdapter(this.HAv);
    this.HAo.setAdapter(this.HAw);
    this.HAi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67181);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    this.HAj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67182);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (PhoneRechargeUI.f(PhoneRechargeUI.this) != null)
        {
          com.tencent.mm.protocal.g.gU(6, 1);
          if ((PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.f(PhoneRechargeUI.this).Owf, PhoneRechargeUI.f(PhoneRechargeUI.this).lpQ, PhoneRechargeUI.f(PhoneRechargeUI.this).name, "")) || (Util.isNullOrNil(PhoneRechargeUI.f(PhoneRechargeUI.this).url))) {}
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
    this.HAk.fum();
    int i = com.tencent.mm.ci.a.kr(this) / 4 - 20;
    Log.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.HAp.setMaxWidth(i);
    this.HAq.setMaxWidth(i);
    this.HAr.setMaxWidth(i);
    this.HAs.setMaxWidth(i);
    this.AYZ = getResources().getColor(a.c.normal_text_color);
    if ((this.HAA.HzL != null) && (!Util.isNullOrNil(this.HAA.HzL.name))) {
      this.desc = this.HAA.HzL.name;
    }
    this.HAk.getContentEditText().setHintTextColor(getResources().getColor(a.c.recharge_no_phone_hint_text_color));
    if (Util.isNullOrNil(this.HAk.getText()))
    {
      c(new com.tencent.mm.plugin.recharge.model.f(""), false);
      AppMethodBeat.o(67187);
      return;
    }
    c(new com.tencent.mm.plugin.recharge.model.f(this.HAk.getText()), false);
    AppMethodBeat.o(67187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67193);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(1571, this);
    com.tencent.mm.kernel.h.aGY().b(498, this);
    EventCenter.instance.removeListener(this.GUP);
    AppMethodBeat.o(67193);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67192);
    super.onResume();
    ap(false, true);
    AppMethodBeat.o(67192);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(67201);
    if ((paramq instanceof com.tencent.mm.plugin.recharge.model.f))
    {
      paramString = (com.tencent.mm.plugin.recharge.model.f)paramq;
      m(paramq);
      if (paramString.cmdId == 0)
      {
        if ((!Util.isNullOrNil(paramString.nfH)) && (!paramString.nfH.equals(this.HAk.getText())))
        {
          Log.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.nfH, this.HAk.getText() });
          AppMethodBeat.o(67201);
          return;
        }
        if (paramString.Hzt)
        {
          Log.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          aVv(paramString.errMsg);
          ftX();
          AppMethodBeat.o(67201);
          return;
        }
        this.mAppId = paramString.appId;
        this.Hzu = paramString.Hzu;
        this.Hzv = paramString.Hzv;
        this.Hzx = paramString.Hzx;
        this.Hzy = paramString.Hzy;
        this.Hzz = paramString.Hzz;
        this.HzA = paramString.HzA;
        this.errCode = paramString.errCode;
        this.errMsg = paramString.errMsg;
        this.HAy = paramString.desc;
        Log.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.HAy, this.HAk.getText() });
        if (Util.isNullOrNil(this.HAy))
        {
          this.desc = "";
          this.AYZ = getResources().getColor(a.c.normal_text_color);
        }
        for (;;)
        {
          this.HAB = paramString.HzC;
          this.Hzw = paramString.Hzw;
          if (this.Hzw == null) {
            break;
          }
          paramInt1 = this.Hzw.size() - 1;
          while (paramInt1 >= 0)
          {
            paramq = (com.tencent.mm.plugin.wallet.a.q)this.Hzw.get(paramInt1);
            if (paramq.name.isEmpty()) {
              this.Hzw.remove(paramq);
            }
            paramInt1 -= 1;
          }
          if ((this.HAA.HzL != null) && (this.HAA.HzL.Hzb.trim().equals(this.HAk.getText())))
          {
            this.HAA.HzL.oex = this.HAy;
            this.HAA.setInput(this.HAA.HzL);
          }
        }
        if ((paramString.HzB == null) || ((paramString.HzB.name.equals(this.HzB.name)) && (paramString.HzB.url.equals(this.HzB.url)) && (paramString.HzB.Owf.equals(this.HzB.Owf)) && (paramString.HzB.lpQ.equals(this.HzB.lpQ)))) {
          break label844;
        }
        Log.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.HzB = paramString.HzB;
      }
    }
    label844:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.HAy.equals(""))
      {
        bool2 = false;
        ap(bool2, bool1);
        paramString = paramString.HzD;
        Log.d("MicroMsg.PhoneRechargeUI", "update record history");
        com.tencent.mm.plugin.recharge.a.a.ftQ().gE(paramString);
        if (this.HAA != null)
        {
          if (!Util.isNullOrNil(this.HAk.getText())) {
            break label623;
          }
          this.HAA.ws(true);
        }
      }
      for (;;)
      {
        this.HAk.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67175);
            PhoneRechargeUI.a(PhoneRechargeUI.this).fun();
            AppMethodBeat.o(67175);
          }
        }, 300L);
        AppMethodBeat.o(67201);
        return;
        bool2 = true;
        break;
        label623:
        this.HAA.ws(false);
      }
      Log.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      AppMethodBeat.o(67201);
      return;
      if ((paramq instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        m(paramq);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.wallet_core.b.iie();
          bool1 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.vCG, true);
          paramString = (com.tencent.mm.plugin.recharge.model.g)paramq;
          if (bool1)
          {
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(paramString.HzF.fwv, 6);
            EventCenter.instance.addListener(this.GUP);
            AppMethodBeat.o(67201);
            return;
          }
          paramq = paramString.HzF;
          paramq.fOY = 6;
          paramq.Rzf = 100;
          paramq.tol = this.HAk.getText();
          if (this.HAA.HzL != null) {}
          for (paramString = this.HAA.HzL.name;; paramString = "")
          {
            paramq.remark = paramString;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramq, 2);
            break;
          }
        }
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(a.i.wallet_unknown_err);
        }
        aVv(paramq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI
 * JD-Core Version:    0.7.0.1
 */