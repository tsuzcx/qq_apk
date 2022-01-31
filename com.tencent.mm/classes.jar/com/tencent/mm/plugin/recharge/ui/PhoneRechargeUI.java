package com.tencent.mm.plugin.recharge.ui;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.plugin.recharge.ui.form.c.b.1;
import com.tencent.mm.plugin.recharge.ui.form.c.b.2;
import com.tencent.mm.plugin.recharge.ui.form.c.b.3;
import com.tencent.mm.plugin.recharge.ui.form.c.b.4;
import com.tencent.mm.plugin.recharge.ui.form.c.b.5;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI
  extends MMActivity
  implements com.tencent.mm.ah.f, d.a
{
  private String aox = "";
  private String desc = "";
  private int errCode = 0;
  protected Dialog ftk = null;
  private String mAppId = "";
  private boolean mTK = false;
  private com.tencent.mm.sdk.b.c mTN = new PhoneRechargeUI.14(this);
  private ArrayList<n> npQ = null;
  private ArrayList<n> npR = null;
  private com.tencent.mm.plugin.wallet.a.d npS = null;
  private com.tencent.mm.plugin.wallet.a.d npT = null;
  private com.tencent.mm.plugin.wallet.a.d npU = null;
  private com.tencent.mm.plugin.wallet.a.d npV = null;
  private com.tencent.mm.plugin.wallet.a.d npW = null;
  private View nqC = null;
  private ImageView nqD = null;
  private TextView nqE = null;
  private MallFormView nqF = null;
  private TextView nqG = null;
  private TextView nqH = null;
  private GridView nqI = null;
  private GridView nqJ = null;
  private TextView nqK = null;
  private TextView nqL = null;
  private TextView nqM = null;
  private TextView nqN = null;
  private TextView nqO = null;
  private TextView nqP = null;
  private b nqQ = null;
  private b nqR = null;
  private MallFunction nqS = null;
  private String nqT = "";
  private int nqU;
  private String nqV = "";
  private String nqW = "";
  private c.b nqX = null;
  private com.tencent.mm.plugin.wallet.a.m nqY = null;
  private boolean nqZ = false;
  private List<String[]> nra;
  
  private void C(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    int i;
    Object localObject2;
    if (this.nqY != null) {
      if (this.nqY != null)
      {
        localObject1 = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uoJ, "");
        if (!bk.bl((String)localObject1))
        {
          localObject1 = ((String)localObject1).split(";");
          if (localObject1 != null)
          {
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject2 = localObject1[i];
              if ((localObject2 != null) && (((String)localObject2).equals(String.valueOf(this.nqY.id))))
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                i = 1;
                label106:
                if (i != 0) {
                  break label680;
                }
                this.nqC.setVisibility(0);
                this.nqE.setText(this.nqY.name);
                com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
                com.tencent.mm.protocal.f.eZ(6, 0);
                label145:
                this.nqQ.nqu = this.npQ;
                this.nqQ.notifyDataSetChanged();
                this.nqR.nqu = this.npR;
                this.nqR.notifyDataSetChanged();
                if (paramBoolean1) {
                  break label700;
                }
                this.nqO.setVisibility(8);
                label194:
                this.nqP.setVisibility(8);
                if (paramBoolean2) {
                  addTextOptionMenu(0, this.npW.name, new PhoneRechargeUI.3(this));
                }
                localObject2 = this.nqG;
                if ((this.npQ == null) || (this.npQ.size() <= 0) || (bk.bl(((n)this.npQ.get(0)).qls))) {
                  break label823;
                }
                localObject1 = ((n)this.npQ.get(0)).qls;
                label286:
                ((TextView)localObject2).setText((CharSequence)localObject1);
                localObject2 = this.nqH;
                if ((this.npR == null) || (this.npR.size() <= 0) || (bk.bl(((n)this.npR.get(0)).qls))) {
                  break label835;
                }
                localObject1 = ((n)this.npR.get(0)).qls;
                label352:
                ((TextView)localObject2).setText((CharSequence)localObject1);
                if ((this.npV != null) && (!bk.bl(this.npV.name))) {
                  break label847;
                }
                this.nqL.setVisibility(8);
                label388:
                if ((this.npS != null) && (!bk.bl(this.npS.name))) {
                  break label887;
                }
                this.nqK.setVisibility(8);
                label417:
                if ((this.npT != null) && (!bk.bl(this.npT.name))) {
                  break label927;
                }
                this.nqM.setVisibility(8);
                label446:
                if ((this.npU != null) && (!bk.bl(this.npU.name))) {
                  break label967;
                }
                this.nqN.setVisibility(8);
                label475:
                localObject1 = this.nqS;
                if ((((MallFunction)localObject1).qzx != null) && (((MallFunction)localObject1).qzx.qxA == 1) && (!bk.bl(((MallFunction)localObject1).qzx.qzM))) {
                  break label1007;
                }
                i = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usF, Boolean.valueOf(true));
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", this.nqS.qzx.toString());
        localObject1 = this.nqS.qzx.qzM;
        localObject2 = com.tencent.mm.ui.y.gt(this).inflate(a.g.recharge_remind_dialog, null);
        com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.wallet_recharge_unicom_message_title), (View)localObject2, getString(a.i.wallet_recharge_unicom_message_yes), getString(a.i.wallet_recharge_unicom_message_no), new PhoneRechargeUI.8(this, (String)localObject1), new PhoneRechargeUI.9(this));
      }
      return;
      i += 1;
      break;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
      i = 0;
      break label106;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
      i = 0;
      break label106;
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
      i = 1;
      break label106;
      label680:
      this.nqC.setVisibility(8);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
      break label145;
      label700:
      localObject1 = this.npQ.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((n)((Iterator)localObject1).next()).status != 0)
        {
          i = 0;
          label737:
          if (i == 0) {
            break label806;
          }
          this.nqO.setVisibility(0);
          label749:
          localObject1 = this.npR.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
          } while (((n)((Iterator)localObject1).next()).status == 0);
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label821;
        }
        this.nqP.setVisibility(0);
        break;
        i = 1;
        break label737;
        label806:
        this.nqO.setVisibility(8);
        break label749;
      }
      label821:
      break label194;
      label823:
      localObject1 = getString(a.i.wallet_recharge_fee_title);
      break label286;
      label835:
      localObject1 = getString(a.i.wallet_recharge_flow_title);
      break label352;
      label847:
      this.nqL.setVisibility(0);
      this.nqL.setText(this.npV.name);
      this.nqL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).qkP, PhoneRechargeUI.j(PhoneRechargeUI.this).dTJ))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.j(PhoneRechargeUI.this).url);
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.c(PhoneRechargeUI.this, paramAnonymousView);
          }
        }
      });
      break label388;
      label887:
      this.nqK.setVisibility(0);
      this.nqK.setText(this.npS.name);
      this.nqK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).qkP, PhoneRechargeUI.k(PhoneRechargeUI.this).dTJ))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.k(PhoneRechargeUI.this).url);
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.c(PhoneRechargeUI.this, paramAnonymousView);
          }
        }
      });
      break label417;
      label927:
      this.nqM.setVisibility(0);
      this.nqM.setText(this.npT.name);
      this.nqM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).qkP, PhoneRechargeUI.l(PhoneRechargeUI.this).dTJ))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.l(PhoneRechargeUI.this).url);
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.c(PhoneRechargeUI.this, paramAnonymousView);
          }
        }
      });
      break label446;
      label967:
      this.nqN.setVisibility(0);
      this.nqN.setText(this.npU.name);
      this.nqN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).qkP, PhoneRechargeUI.m(PhoneRechargeUI.this).dTJ))
          {
            paramAnonymousView = PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.m(PhoneRechargeUI.this).url);
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramAnonymousView });
            PhoneRechargeUI.c(PhoneRechargeUI.this, paramAnonymousView);
          }
        }
      });
      break label475;
      label1007:
      com.tencent.mm.kernel.g.DQ();
      if (!((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usF, Boolean.valueOf(false))).booleanValue()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private String LC(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    String str1 = paramString;
    try
    {
      if (this.nqX != null)
      {
        localObject1 = localObject2;
        str1 = paramString;
        if (this.nqX.nqg != null)
        {
          localObject1 = localObject2;
          str1 = paramString;
          if (!bk.bl(this.nqX.nqg.name))
          {
            str1 = paramString;
            localObject1 = this.nqX.nqg.name;
          }
        }
      }
      localObject2 = localObject1;
      str1 = paramString;
      if (((String)localObject1).equals(getString(a.i.wallet_recharge_me))) {
        localObject2 = "WeChatAccountBindNumber";
      }
      str1 = paramString;
      String str2 = this.nqF.getText();
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
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "new url");
        str1 = paramString;
        if (paramString.indexOf("%7Bphone%7D") > 0) {
          str1 = paramString;
        }
        for (paramString = paramString.replace("%7Bphone%7D", str2);; paramString = paramString.replace("{phone}", str2))
        {
          str1 = paramString;
          if (paramString.indexOf("%7Bremark%7D") <= 0) {
            break;
          }
          str1 = paramString;
          return paramString.replace("%7Bremark%7D", (CharSequence)localObject1);
          str1 = paramString;
        }
        str1 = paramString;
        return paramString.replace("{remark}", (CharSequence)localObject1);
      }
      str1 = paramString;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "old url");
      str1 = paramString;
      localObject2 = URLDecoder.decode(paramString, "utf-8");
      str1 = paramString;
      paramString = (String)localObject2 + String.format("?phone=%s&remark=%s", new Object[] { str2, localObject1 });
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramString, "", new Object[0]);
    }
    return str1;
  }
  
  private void LD(String paramString)
  {
    com.tencent.mm.ui.base.h.a(this, paramString, "", false, new PhoneRechargeUI.10(this));
  }
  
  private void bvf()
  {
    this.mAppId = "";
    bvg();
    this.errCode = 0;
    this.aox = "";
    this.desc = "";
  }
  
  private void bvg()
  {
    this.npQ = new ArrayList();
    n localn1 = new n();
    localn1.name = getString(a.i.wallet_recharge_default_item_0);
    localn1.status = 0;
    n localn2 = new n();
    localn2.name = getString(a.i.wallet_recharge_default_item_1);
    localn2.status = 0;
    n localn3 = new n();
    localn3.name = getString(a.i.wallet_recharge_default_item_2);
    localn3.status = 0;
    n localn4 = new n();
    localn4.name = getString(a.i.wallet_recharge_default_item_3);
    localn4.status = 0;
    n localn5 = new n();
    localn5.name = getString(a.i.wallet_recharge_default_item_4);
    localn5.status = 0;
    n localn6 = new n();
    localn6.name = getString(a.i.wallet_recharge_default_item_5);
    localn6.status = 0;
    this.npQ.add(localn1);
    this.npQ.add(localn2);
    this.npQ.add(localn3);
    this.npQ.add(localn4);
    this.npQ.add(localn5);
    this.npQ.add(localn6);
    this.npR = new ArrayList();
    localn1 = new n();
    localn1.name = getString(a.i.wallet_recharge_default_item_6);
    localn1.status = 0;
    localn2 = new n();
    localn2.name = getString(a.i.wallet_recharge_default_item_7);
    localn2.status = 0;
    localn3 = new n();
    localn3.name = getString(a.i.wallet_recharge_default_item_8);
    localn3.status = 0;
    this.npR.add(localn1);
    this.npR.add(localn2);
    this.npR.add(localn3);
  }
  
  private void bvh()
  {
    com.tencent.mm.kernel.g.Dk().a(new com.tencent.mm.plugin.recharge.model.f(this.nqF.getText()), 0);
  }
  
  private void c(com.tencent.mm.ah.m paramm, boolean paramBoolean)
  {
    if ((this.ftk == null) || ((this.ftk != null) && (!this.ftk.isShowing()))) {
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (this.ftk = com.tencent.mm.wallet_core.ui.g.a(this.mController.uMN, true, new PhoneRechargeUI.21(this, paramm));; this.ftk = com.tencent.mm.wallet_core.ui.g.b(this.mController.uMN, true, new PhoneRechargeUI.2(this, paramm)))
    {
      com.tencent.mm.kernel.g.Dk().a(paramm, 0);
      return;
    }
  }
  
  private void m(com.tencent.mm.ah.m paramm)
  {
    if ((this.ftk != null) && (this.ftk.isShowing()) && (paramm.getType() != 497))
    {
      this.ftk.dismiss();
      this.ftk = null;
    }
  }
  
  public final void bvi()
  {
    com.tencent.mm.plugin.recharge.model.f localf = new com.tencent.mm.plugin.recharge.model.f("", 1);
    com.tencent.mm.kernel.g.Dk().a(localf, 0);
  }
  
  protected final int getLayoutId()
  {
    return a.g.phone_recharge_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        this.nqZ = true;
        ArrayList localArrayList = new ArrayList();
        Object localObject3 = paramIntent.getData();
        if (localObject3 == null)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
          return;
        }
        if (android.support.v4.content.b.checkSelfPermission(this, "android.permission.READ_CONTACTS") != 0)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.PhoneRechargeUI", "no contact permission");
          return;
        }
        Cursor localCursor1;
        Cursor localCursor2;
        try
        {
          localCursor1 = getContentResolver().query((Uri)localObject3, null, null, null, null);
          localObject3 = localObject1;
          if (localCursor1 == null) {
            break label510;
          }
          localObject3 = localObject1;
          if (localCursor1.getCount() <= 0) {
            break label510;
          }
          localCursor1.moveToFirst();
          int i = localCursor1.getColumnIndex("has_phone_number");
          if (i > 0)
          {
            localObject3 = localObject1;
            if (localCursor1.getInt(i) <= 0) {
              break label510;
            }
          }
          localObject1 = localCursor1.getString(localCursor1.getColumnIndex("_id"));
          localCursor2 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + (String)localObject1, null, null);
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
                com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "hy: username : " + (String)localObject1);
                if (localObject3 != null)
                {
                  com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + (String)localObject3);
                  localObject3 = com.tencent.mm.plugin.recharge.model.b.qa((String)localObject3);
                  com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + (String)localObject3);
                  if ((PhoneNumberUtils.isGlobalPhoneNumber((String)localObject3)) && (((String)localObject3).length() == 11)) {
                    localArrayList.add(localObject3);
                  }
                  com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : " + (String)localObject3);
                }
                localCursor2.moveToNext();
              }
            }
          }
        }
        catch (SecurityException localSecurityException)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[] { localSecurityException.toString() });
          com.tencent.mm.ui.base.h.b(this, getString(a.i.mall_recharge_read_contact_error), "", true);
        }
        localObject3 = localSecurityException;
        if (localCursor2 != null)
        {
          localCursor2.close();
          localObject3 = localSecurityException;
        }
        label510:
        if ((localCursor1 != null) && (!localCursor1.isClosed())) {
          localCursor1.close();
        }
        Object localObject2;
        if (localArrayList.size() > 1)
        {
          localObject2 = com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_recharge_pick_phone_number), localArrayList, -1, new PhoneRechargeUI.13(this, localArrayList, (String)localObject3));
          if (localObject2 != null) {
            ((com.tencent.mm.ui.widget.a.c)localObject2).setCanceledOnTouchOutside(true);
          }
        }
        else if (localArrayList.size() == 1)
        {
          this.nqX.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localArrayList.get(0), (String)localObject3, 1));
          bvh();
        }
        else
        {
          com.tencent.mm.ui.base.h.b(this, getString(a.i.mall_recharge_pick_contact_error), "", true);
          continue;
          if (paramInt2 == -1)
          {
            if (!this.mTK)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(this.nqF.getText(), this.nqF.getTipsTv().getText().toString(), 0);
              com.tencent.mm.plugin.recharge.a.a.bva().a((com.tencent.mm.plugin.recharge.model.a)localObject2);
              finish();
              this.mTK = true;
            }
          }
          else {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    ta(this.mController.czv());
    com.tencent.mm.kernel.g.Dk().a(1571, this);
    com.tencent.mm.kernel.g.Dk().a(498, this);
    this.nqS = ((MallFunction)getIntent().getParcelableExtra("key_func_info"));
    if (this.nqS == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
      com.tencent.mm.ui.base.s.makeText(this, "function info is null", 1).show();
      finish();
    }
    bvg();
    setMMTitle(this.nqS.caU);
    setBackBtn(new PhoneRechargeUI.1(this));
    this.npW = new com.tencent.mm.plugin.wallet.a.d();
    this.npW.name = getString(a.i.wallet_recharge_hardcode_head_name);
    this.npW.url = getString(a.i.wallet_recharge_hardcode_head_url);
    this.nqC = findViewById(a.f.phone_recharge_banner_rl);
    this.nqD = ((ImageView)findViewById(a.f.news_close));
    this.nqE = ((TextView)findViewById(a.f.news_wording));
    this.nqF = ((MallFormView)findViewById(a.f.recharge_content_input_view));
    com.tencent.mm.plugin.recharge.ui.form.c.b(this.nqF);
    this.nqX = new c.b(this.nqF);
    paramBundle = this.nqX;
    com.tencent.mm.sdk.platformtools.y.d(com.tencent.mm.plugin.recharge.ui.form.c.access$100(), "hy: setMobileEditTv");
    Object localObject = paramBundle.nrP;
    c.b.1 local1 = new c.b.1(paramBundle);
    if (((MallFormView)localObject).nrV != null) {
      ((MallFormView)localObject).nrV.addTextChangedListener(local1);
    }
    localObject = (InstantAutoCompleteTextView)paramBundle.nrP.getContentEditText();
    paramBundle.nqf = com.tencent.mm.pluginsdk.a.ck(paramBundle.nrP.getContext());
    paramBundle.nrQ = new com.tencent.mm.plugin.recharge.ui.form.d(paramBundle.nrP, paramBundle.nqf);
    paramBundle.nrQ.nsD = new c.b.2(paramBundle);
    paramBundle.nrQ.nsE = this;
    paramBundle.ip(true);
    ((InstantAutoCompleteTextView)localObject).setShowAlways(true);
    ((InstantAutoCompleteTextView)localObject).setAdapter(paramBundle.nrQ);
    ((InstantAutoCompleteTextView)localObject).setOnItemClickListener(new c.b.3(paramBundle, (InstantAutoCompleteTextView)localObject));
    paramBundle.nrP.setOnFocusChangeListener(new c.b.4(paramBundle, (InstantAutoCompleteTextView)localObject));
    ((InstantAutoCompleteTextView)localObject).setOnClickListener(new c.b.5(paramBundle, (InstantAutoCompleteTextView)localObject));
    this.nqI = ((GridView)findViewById(a.f.recharge_phone_grid));
    this.nqK = ((TextView)findViewById(a.f.recharge_remind));
    this.nqL = ((TextView)findViewById(a.f.recharge_weSim));
    this.nqM = ((TextView)findViewById(a.f.recharge_buy_card));
    this.nqN = ((TextView)findViewById(a.f.recharge_hall));
    this.nqG = ((TextView)findViewById(a.f.recharge_product_1_title));
    this.nqH = ((TextView)findViewById(a.f.recharge_product_2_title));
    this.nqJ = ((GridView)findViewById(a.f.recharge_dataflow_grid));
    this.nqO = ((TextView)findViewById(a.f.recharge_product_1_lack_alert));
    this.nqP = ((TextView)findViewById(a.f.recharge_product_2_lack_alert));
    this.nqF.setOnInputValidChangeListener(new PhoneRechargeUI.12(this));
    this.nqF.getInfoIv().setOnClickListener(new PhoneRechargeUI.15(this));
    this.nqQ = new b();
    this.nqQ.nqv = new PhoneRechargeUI.16(this);
    this.nqR = new b();
    this.nqR.nqv = new PhoneRechargeUI.17(this);
    this.nqI.setAdapter(this.nqQ);
    this.nqJ.setAdapter(this.nqR);
    this.nqD.setOnClickListener(new PhoneRechargeUI.18(this));
    this.nqE.setOnClickListener(new PhoneRechargeUI.19(this));
    this.nqF.bvp();
    int i = com.tencent.mm.cb.a.fj(this) / 4 - 20;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[] { Integer.valueOf(i) });
    this.nqK.setMaxWidth(i);
    this.nqL.setMaxWidth(i);
    this.nqM.setMaxWidth(i);
    this.nqN.setMaxWidth(i);
    this.nqU = getResources().getColor(a.c.normal_text_color);
    if ((this.nqX.nqg != null) && (!bk.bl(this.nqX.nqg.name))) {
      this.desc = this.nqX.nqg.name;
    }
    this.nqF.getContentEditText().setHintTextColor(getResources().getColor(a.c.recharge_no_phone_hint_text_color));
    if (bk.bl(this.nqF.getText()))
    {
      c(new com.tencent.mm.plugin.recharge.model.f(""), false);
      return;
    }
    c(new com.tencent.mm.plugin.recharge.model.f(this.nqF.getText()), false);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.Dk().b(1571, this);
    com.tencent.mm.kernel.g.Dk().b(498, this);
    com.tencent.mm.sdk.b.a.udP.d(this.mTN);
  }
  
  protected void onResume()
  {
    super.onResume();
    C(false, true);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.recharge.model.f))
    {
      paramString = (com.tencent.mm.plugin.recharge.model.f)paramm;
      if (paramString.cmdId == 0)
      {
        if ((!bk.bl(paramString.foD)) && (!paramString.foD.equals(this.nqF.getText())))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[] { paramString.foD, this.nqF.getText() });
          return;
        }
        m(paramm);
        if (paramString.npP)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
          LD(paramString.aox);
          bvf();
          return;
        }
        this.mAppId = paramString.appId;
        this.npQ = paramString.npQ;
        this.npS = paramString.npS;
        this.npT = paramString.npT;
        this.npU = paramString.npU;
        this.npV = paramString.npV;
        this.errCode = paramString.errCode;
        this.aox = paramString.aox;
        this.nqT = paramString.desc;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[] { this.nqT, this.nqF.getText() });
        if (bk.bl(this.nqT))
        {
          this.desc = "";
          this.nqU = getResources().getColor(a.c.normal_text_color);
        }
        for (;;)
        {
          this.nqY = paramString.npX;
          this.npR = paramString.npR;
          if (this.npR == null) {
            break;
          }
          paramInt1 = this.npR.size() - 1;
          while (paramInt1 >= 0)
          {
            paramm = (n)this.npR.get(paramInt1);
            if (paramm.name.isEmpty()) {
              this.npR.remove(paramm);
            }
            paramInt1 -= 1;
          }
          if ((this.nqX.nqg != null) && (this.nqX.nqg.npv.trim().equals(this.nqF.getText())))
          {
            this.nqX.nqg.npw = this.nqT;
            this.nqX.setInput(this.nqX.nqg);
          }
        }
        if ((paramString.npW == null) || ((paramString.npW.name.equals(this.npW.name)) && (paramString.npW.url.equals(this.npW.url)) && (paramString.npW.qkP.equals(this.npW.qkP)) && (paramString.npW.dTJ.equals(this.npW.dTJ)))) {
          break label749;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "need to update head");
        this.npW = paramString.npW;
      }
    }
    label592:
    label749:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.nqT.equals(""))
      {
        bool2 = false;
        C(bool2, bool1);
        paramm = paramString.npY;
        if (paramm != null)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeUI", "update record history");
          com.tencent.mm.plugin.recharge.a.a.bva().ce(paramm);
          if (this.nqX != null)
          {
            if (!paramString.npZ) {
              break label592;
            }
            this.nqX.ip(true);
          }
        }
      }
      for (;;)
      {
        this.nqF.postDelayed(new PhoneRechargeUI.11(this), 300L);
        return;
        bool2 = true;
        break;
        this.nqX.ip(false);
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
      return;
      if (!(paramm instanceof com.tencent.mm.plugin.recharge.model.g)) {
        break;
      }
      m(paramm);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = ((com.tencent.mm.plugin.recharge.model.g)paramm).nqa;
        paramm.bUV = 6;
        paramm.snU = 100;
        paramm.ilD = this.nqF.getText();
        if (this.nqX.nqg != null) {}
        for (paramString = this.nqX.nqg.name;; paramString = "")
        {
          paramm.fGK = paramString;
          com.tencent.mm.pluginsdk.wallet.h.a(this, paramm, 2);
          com.tencent.mm.sdk.b.a.udP.c(this.mTN);
          return;
        }
      }
      paramm = paramString;
      if (bk.bl(paramString)) {
        paramm = getString(a.i.wallet_unknown_err);
      }
      LD(paramm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI
 * JD-Core Version:    0.7.0.1
 */