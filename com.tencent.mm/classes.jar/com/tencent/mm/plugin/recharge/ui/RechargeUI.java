package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.d;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.protocal.c.zg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI
  extends MMActivity
  implements f, x.a, MallEditText.b
{
  private Button frP = null;
  protected Dialog ftk = null;
  private boolean gEk = true;
  private boolean mTK = false;
  private com.tencent.mm.sdk.b.c mTN = new RechargeUI.10(this);
  private MallFunction nqS = null;
  private String nrA;
  public String nrB;
  private String nrC;
  public String nrD;
  private TextView nri = null;
  private TextView nrj = null;
  private TextView nrk = null;
  private TextView nrl = null;
  private FrameLayout nrm = null;
  private ImageView nrn = null;
  private ImageView nro = null;
  private LinearLayout nrp = null;
  private RechargeUI.a nrq = null;
  private RechargeUI.a nrr = null;
  private MallEditText nrs;
  private TextView nrt;
  private int nru;
  private MallRechargeProduct nrv = null;
  private String nrw = null;
  private MallNews nrx = null;
  private boolean nry = false;
  private Map<String, Integer> nrz = new HashMap();
  
  private boolean YH()
  {
    MallEditText localMallEditText = this.nrs;
    if (localMallEditText.getVisibility() == 0) {
      if (bk.bl(localMallEditText.getText()))
      {
        y.d("MicroMsg.MallEditText", "View:" + localMallEditText.fuk + ", editType:" + localMallEditText.ful + " checkInputValid : empty ");
        i = 0;
        if (i != 0) {
          break label294;
        }
      }
    }
    label294:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.nrv != null) && (this.nrv.isValid()))
      {
        if ((bvl()) && (this.nrv.npF)) {
          n(new d(this.nrv.dWX, this.nqS.npy, this.nrv.bJd, this.nrv.appId, bvj(), bvk()));
        }
        XM();
        this.frP.setEnabled(true);
        this.frP.setClickable(true);
        y.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        return true;
        if (!localMallEditText.fup)
        {
          y.d("MicroMsg.MallEditText", "View:" + localMallEditText.fuk + ", editType:" + localMallEditText.ful + " checkInputValid : illegal ");
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((!this.nry) && (i == 0) && (this.nrv != null)) {
        this.nrv.isValid();
      }
      this.frP.setEnabled(false);
      this.frP.setClickable(false);
      y.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      return false;
    }
  }
  
  private void aZ()
  {
    y.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.nrv);
    Object localObject;
    if (this.nrv != null)
    {
      this.nrt.setText(this.nrv.jfG);
      TextView localTextView = this.nrk;
      localObject = this.nrv;
      if (!((MallRechargeProduct)localObject).isValid())
      {
        localObject = getString(a.i.mall_recharge_out_of_stock);
        localTextView.setText((CharSequence)localObject);
      }
    }
    else
    {
      if ((this.nrx == null) || (this.nqS.qzx == null) || (!this.nrx.equals(this.nqS.qzx)) || ("1".equals(this.nrx.qzD))) {
        break label373;
      }
      this.nrm.setVisibility(8);
      y.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.nrx.toString());
      label162:
      this.nrj.setVisibility(4);
      if (!YH()) {
        break label475;
      }
      if ((this.nrv != null) && (!bvl()))
      {
        this.nri.setText(this.nrv.npz);
        this.nri.setTextColor(getResources().getColor(a.c.hint_text_color));
      }
      label222:
      localObject = getString(a.i.mall_recharge_balance);
      if (!TextUtils.isEmpty(this.nrB)) {
        localObject = this.nrB;
      }
      if (!bk.bl(this.nrA)) {
        addTextOptionMenu(0, (String)localObject, new RechargeUI.18(this));
      }
      if (bk.bl(this.nrC)) {
        break label488;
      }
      this.nrl.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.nrD)) {
        this.nrl.setText(this.nrD);
      }
      return;
      if ((((MallRechargeProduct)localObject).npA != ((MallRechargeProduct)localObject).npB) || ((bvl()) && (this.nrv.npF)))
      {
        localObject = "";
        break;
      }
      localObject = String.format(getString(a.i.mall_recharge_price), new Object[] { Float.valueOf(((MallRechargeProduct)localObject).npA) });
      break;
      label373:
      if ((this.nqS.qzx != null) && (!bk.bl(this.nqS.qzx.qzH)))
      {
        this.nrw = this.nqS.qzx.qzH;
        localObject = x.a(new com.tencent.mm.plugin.recharge.b.a(this.nrw));
        this.nrn.setImageBitmap((Bitmap)localObject);
        this.nrm.setVisibility(0);
        y.d("MicroMsg.MallRechargeUI", "Show banner!");
        break label162;
      }
      this.nrm.setVisibility(8);
      y.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break label162;
      label475:
      this.nri.setText("");
      break label222;
      label488:
      this.nrl.setVisibility(8);
    }
  }
  
  private String bvj()
  {
    return "mobile=" + com.tencent.mm.plugin.recharge.model.b.qa(this.nrs.getText());
  }
  
  private String bvk()
  {
    return com.tencent.mm.plugin.recharge.model.b.qa(this.nrs.getText());
  }
  
  private boolean bvl()
  {
    String str = q(this.nrv.dWX, this.nrv.bJd, bvk());
    return !this.nrz.containsKey(str);
  }
  
  private void cg(List<MallRechargeProduct> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      int j;
      for (int i = 0; k < paramList.size(); i = j)
      {
        MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)paramList.get(k);
        j = i;
        if (localMallRechargeProduct.dWX == 2)
        {
          j = i;
          if (this.nrv != null)
          {
            j = i;
            if (localMallRechargeProduct.bJd.equals(this.nrv.bJd))
            {
              localMallRechargeProduct.isDefault = true;
              j = 1;
            }
          }
          localArrayList.add(localMallRechargeProduct);
        }
        k += 1;
      }
      if ((i == 0) && (localArrayList.size() > 0)) {
        ((MallRechargeProduct)localArrayList.get(0)).isDefault = true;
      }
      this.nrr.ch(localArrayList);
      return;
    }
    this.nrr.ch(new ArrayList());
  }
  
  private static List<MallRechargeProduct> e(int paramInt, List<MallRechargeProduct> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)paramList.get(i);
        k = j;
        if (localMallRechargeProduct.dWX == paramInt)
        {
          localArrayList.add(localMallRechargeProduct);
          k = j;
          if (localMallRechargeProduct.isDefault)
          {
            if (j != 0) {
              localMallRechargeProduct.isDefault = false;
            }
            k = 1;
          }
        }
        i += 1;
      }
      if ((j == 0) && (localArrayList.size() > 0)) {
        ((MallRechargeProduct)localArrayList.get(0)).isDefault = true;
      }
    }
    return localArrayList;
  }
  
  private void n(final m paramm)
  {
    if ((paramm.getType() == 497) || (paramm.getType() == 1555))
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(paramm, 0);
      return;
    }
    if (!this.gEk)
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(paramm, 0);
      return;
    }
    if ((this.ftk == null) || ((this.ftk != null) && (!this.ftk.isShowing()))) {
      this.ftk = com.tencent.mm.wallet_core.ui.g.a(this.mController.uMN, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.c(paramm);
        }
      });
    }
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramm, 0);
  }
  
  private static String q(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public final void XM()
  {
    y.d("MicroMsg.MallRechargeUI", "hideVKB");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getCurrentFocus();
      } while (localObject == null);
      localObject = ((View)localObject).getWindowToken();
    } while (localObject == null);
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
  }
  
  public final void bve()
  {
    if ((bk.bl(this.nrs.getText())) || (this.nrs.YL()))
    {
      this.nrs.setInfoTvImageResource(a.e.recharge_phone_contact);
      return;
    }
    this.nrs.setInfoTvImageResource(a.e.list_clear);
  }
  
  public final void gG(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.nrz.clear();
      this.nri.setText("");
      this.nrj.setVisibility(4);
    }
    YH();
  }
  
  protected final int getLayoutId()
  {
    return a.g.recharge_recharge_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(this.nqS.caU);
    y.v("MicroMsg.MallRechargeUI", "initView");
    setBackBtn(new RechargeUI.1(this));
    this.nri = ((TextView)findViewById(a.f.mall_product_desc));
    this.nrj = ((TextView)findViewById(a.f.mall_recharge_err_msg));
    this.nrk = ((TextView)findViewById(a.f.mall_sell_price));
    this.frP = ((Button)findViewById(a.f.next_btn));
    this.nrp = ((LinearLayout)findViewById(a.f.mall_input_ll));
    this.nrl = ((TextView)findViewById(a.f.mall_recharge_phone_recharge_card));
    this.nrl.setOnClickListener(new RechargeUI.11(this));
    this.frP.setOnClickListener(new RechargeUI.12(this));
    this.nrs = ((MallEditText)findViewById(a.f.mall_mobile_et));
    this.nrs.setInfoTvOnClickListener(new RechargeUI.13(this));
    this.nrt = ((TextView)findViewById(a.f.mall_product_name));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = e(0, (List)localObject);
    localObject = e(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.nru = i;
      this.nrq = new RechargeUI.a(this, (byte)0);
      this.nrq.ch(localList);
      this.nrr = new RechargeUI.a(this, (byte)0);
      this.nrr.ch((List)localObject);
      this.nrp.setOnClickListener(new RechargeUI.14(this));
      this.nrm = ((FrameLayout)findViewById(a.f.mall_recharge_banner));
      this.nrn = ((ImageView)findViewById(a.f.mall_recharge_banner_iv));
      this.nro = ((ImageView)findViewById(a.f.mall_recharge_banner_close_iv));
      this.nro.setOnClickListener(new RechargeUI.15(this));
      this.nrm.setOnClickListener(new RechargeUI.16(this));
      this.nrs.setOnInputValidChangeListener(this);
      this.nrs.setOnClickListener(new RechargeUI.17(this));
      bve();
      x.a(this);
      aZ();
      return;
    }
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if (this.nrw == null) {}
    while (!paramString.equals(this.nrw)) {
      return;
    }
    this.nrn.post(new RechargeUI.9(this, paramBitmap));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Cursor localCursor1;
    Object localObject2;
    label364:
    String str2;
    switch (paramInt1)
    {
    default: 
    case 1: 
      do
      {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      } while (paramInt2 != -1);
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        y.e("MicroMsg.MallRechargeUI", "uri == null");
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.a.j(this, "android.permission.READ_CONTACTS"))
      {
        y.e("MicroMsg.MallRechargeUI", "no contact permission");
        return;
      }
      localCursor1 = getContentResolver().query((Uri)localObject1, null, null, null, null);
      if ((localCursor1 != null) && (localCursor1.getCount() > 0))
      {
        localCursor1.moveToFirst();
        int i = localCursor1.getColumnIndex("has_phone_number");
        if ((i <= 0) || (localCursor1.getInt(i) > 0))
        {
          localObject1 = localCursor1.getString(localCursor1.getColumnIndex("_id"));
          Cursor localCursor2 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + (String)localObject1, null, null);
          if (localCursor2.moveToFirst())
          {
            str1 = null;
            localObject1 = null;
            for (;;)
            {
              localObject2 = localObject1;
              if (localCursor2.isAfterLast()) {
                break;
              }
              i = localCursor2.getColumnIndex("data1");
              int j = localCursor2.getColumnIndex("display_name");
              localObject2 = localCursor2.getString(i);
              str1 = localCursor2.getString(j);
              y.d("MicroMsg.MallRechargeUI", "username : " + str1);
              if (localObject2 == null) {
                break label589;
              }
              y.d("MicroMsg.MallRechargeUI", "phoneNumber : " + (String)localObject2);
              localObject2 = com.tencent.mm.plugin.recharge.model.b.qa((String)localObject2);
              y.d("MicroMsg.MallRechargeUI", "phoneNumber : " + (String)localObject2);
              if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject2)) {
                break label586;
              }
              localObject1 = localObject2;
              y.d("MicroMsg.MallRechargeUI", "phoneResult : " + (String)localObject1);
              label387:
              localCursor2.moveToNext();
            }
          }
          String str1 = null;
          localObject2 = null;
          localObject1 = localObject2;
          str2 = str1;
          if (!localCursor2.isClosed())
          {
            localCursor2.close();
            str2 = str1;
          }
        }
      }
      break;
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if ((localCursor1 != null) && (!localCursor1.isClosed())) {
        localCursor1.close();
      }
      if (PhoneNumberUtils.isGlobalPhoneNumber((String)localObject1))
      {
        this.nrz.clear();
        this.nrs.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.nri.setText("");
        this.nrj.setVisibility(4);
        YH();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.mTK) {
          break;
        }
        y.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.bva().a(this.nrs.getInputRecord());
        finish();
        this.mTK = true;
        break;
      }
      y.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
      break;
      label586:
      break label364;
      label589:
      break label387;
      str2 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.nqS = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.gEk = bool;
      if (this.nqS != null) {
        break;
      }
      y.e("MicroMsg.MallRechargeUI", "function info is null");
      com.tencent.mm.ui.base.s.makeText(this, "function info is null", 1).show();
      return;
    }
    if (localArrayList == null)
    {
      y.d("MicroMsg.MallRechargeUI", "function info : " + this.nqS.caU);
      n(new e(this.nqS.npy));
    }
    for (;;)
    {
      y.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.nrx = com.tencent.mm.plugin.wallet_core.model.mall.c.bWg().Qx(this.nqS.npy);
      initView();
      return;
      this.nrv = a.cf(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.mTN);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(496, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(497, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(498, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1555, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(496, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(497, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(498, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(1555, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.ftk != null) && (this.ftk.isShowing()) && (paramm.getType() != 497))
    {
      this.ftk.dismiss();
      this.ftk = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof e))
      {
        paramm = (e)paramm;
        paramString = paramm.npK;
        if (paramString != null)
        {
          this.nrv = a.cf(paramString);
          y.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.nrv);
        }
        this.nrA = paramm.npL;
        this.nrB = paramm.npM;
        this.nrC = paramm.npN;
        this.nrD = paramm.npO;
        y.d("MicroMsg.MallRechargeUI", "mProductList " + paramString);
        aZ();
        paramm = e(0, paramString);
        paramString = e(2, paramString);
        if (paramm.size() > paramString.size())
        {
          paramInt1 = paramm.size();
          this.nru = paramInt1;
          this.nrq.ch(paramm);
          this.nrr.ch(paramString);
        }
      }
    }
    label666:
    label709:
    while ((paramm instanceof com.tencent.mm.plugin.recharge.model.c))
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            paramInt1 = paramString.size();
          }
          if ((paramm instanceof d))
          {
            y.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.nrv);
            paramm = (d)paramm;
            if ((this.nrv != null) && (this.nrv.bJd != null) && (paramm.npH != null) && (((this.nrv.bJd.equals(paramm.npH.bJd)) && (bvk().equals(paramm.fjn))) || (paramm.dWX != 2)))
            {
              MallRechargeProduct.a(paramm.npH, this.nrv);
              this.nrv.isDefault = true;
              String str = q(paramm.dWX, paramm.npH.bJd, paramm.fjn);
              this.nrz.put(str, Integer.valueOf(1));
              aZ();
              this.nrj.setText(paramString);
              this.nrj.setVisibility(0);
              this.nrj.setTextColor(getResources().getColor(a.c.grey));
            }
            if (paramm.dWX == 2)
            {
              if ((this.nrv == null) || (!this.nrv.bJd.equals(paramm.npJ)) || (!bvk().equals(paramm.fjn))) {
                break label709;
              }
              if ((((aha)paramm.dmK.ecF.ecN).sYC == 0) && (this.nrv.bJd.equals(paramm.npH.bJd))) {
                break label666;
              }
              this.frP.setEnabled(false);
              this.frP.setClickable(false);
              this.nrj.setText(((aha)paramm.dmK.ecF.ecN).sYD);
              this.nrj.setVisibility(0);
              this.nrj.setTextColor(getResources().getColor(a.c.red));
            }
            for (;;)
            {
              cg(paramm.npI);
              y.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.nrv);
              return;
              n(new com.tencent.mm.plugin.recharge.model.c(this.nrv.npy, bvk(), this.nrv.jfG, this.nrv.appId, bvj()));
              continue;
              this.frP.setEnabled(true);
              this.frP.setClickable(true);
              this.nrj.setText(null);
            }
          }
          if ((paramm instanceof com.tencent.mm.plugin.recharge.model.g))
          {
            paramString = ((com.tencent.mm.plugin.recharge.model.g)paramm).nqa;
            paramString.bUV = 6;
            paramString.snU = 100;
            com.tencent.mm.pluginsdk.wallet.h.a(this, paramString, 2);
            com.tencent.mm.sdk.b.a.udP.c(this.mTN);
            return;
          }
        } while (!(paramm instanceof com.tencent.mm.plugin.recharge.model.c));
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramm;
        if ((this.nrv == null) || (!this.nrv.jfG.equals(paramString.jfG)) || (!bvk().equals(paramString.bSe))) {
          break;
        }
      } while (((zg)paramString.dmK.ecF.ecN).sYC == 0);
      this.frP.setEnabled(false);
      this.frP.setClickable(false);
      this.nrj.setText(((zg)paramString.dmK.ecF.ecN).sYD);
      this.nrj.setVisibility(0);
      this.nrj.setTextColor(getResources().getColor(a.c.red));
      return;
      this.frP.setEnabled(true);
      this.frP.setClickable(true);
      this.nrj.setText(null);
      return;
    }
    if ((paramm instanceof d))
    {
      if (paramInt2 == 100)
      {
        this.frP.setEnabled(true);
        this.frP.setClickable(true);
      }
      for (;;)
      {
        cg(((d)paramm).npI);
        this.nrj.setText(paramString);
        this.nrj.setVisibility(0);
        this.nrj.setTextColor(getResources().getColor(a.c.red));
        this.nri.setText(((d)paramm).npz);
        this.nri.setTextColor(getResources().getColor(a.c.red));
        return;
        this.frP.setEnabled(false);
        this.frP.setClickable(false);
      }
    }
    paramm = paramString;
    if (bk.bl(paramString)) {
      paramm = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.h.a(this, paramm, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  public final void showVKB()
  {
    y.d("MicroMsg.MallRechargeUI", "showVKB");
    this.nrs.setInfoTvImageResource(a.e.list_clear);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {}
    View localView;
    do
    {
      return;
      localView = getCurrentFocus();
    } while ((localView == null) || (localView.getWindowToken() == null));
    localInputMethodManager.showSoftInput(localView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI
 * JD-Core Version:    0.7.0.1
 */