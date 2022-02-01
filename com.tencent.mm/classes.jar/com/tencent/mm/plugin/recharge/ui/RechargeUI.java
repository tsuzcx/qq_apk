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
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.recharge.model.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI
  extends MMActivity
  implements com.tencent.mm.an.i, u.a, MallEditText.b
{
  private boolean GUM;
  private IListener GUP;
  private TextView HAM;
  private TextView HAN;
  private TextView HAO;
  private TextView HAP;
  private FrameLayout HAQ;
  private ImageView HAR;
  private ImageView HAS;
  private LinearLayout HAT;
  private a HAU;
  private a HAV;
  private MallEditText HAW;
  private TextView HAX;
  private int HAY;
  private MallRechargeProduct HAZ;
  private MallFunction HAx;
  private String HBa;
  private MallNews HBb;
  private boolean HBc;
  private Map<String, Integer> HBd;
  private String HBe;
  public String HBf;
  private String HBg;
  public String HBh;
  private Button njb;
  private boolean pCD;
  protected Dialog tipDialog;
  
  public RechargeUI()
  {
    AppMethodBeat.i(67240);
    this.njb = null;
    this.HAM = null;
    this.HAN = null;
    this.HAO = null;
    this.HAP = null;
    this.HAQ = null;
    this.HAR = null;
    this.HAS = null;
    this.HAT = null;
    this.HAU = null;
    this.HAV = null;
    this.tipDialog = null;
    this.HAx = null;
    this.HAZ = null;
    this.HBa = null;
    this.HBb = null;
    this.GUM = false;
    this.HBc = false;
    this.pCD = true;
    this.HBd = new HashMap();
    this.GUP = new IListener() {};
    AppMethodBeat.o(67240);
  }
  
  private static String O(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(67252);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(67252);
    return paramString1;
  }
  
  private String a(MallRechargeProduct paramMallRechargeProduct)
  {
    AppMethodBeat.i(67246);
    if (!paramMallRechargeProduct.isValid())
    {
      paramMallRechargeProduct = getString(a.i.mall_recharge_out_of_stock);
      AppMethodBeat.o(67246);
      return paramMallRechargeProduct;
    }
    if ((paramMallRechargeProduct.Hze != paramMallRechargeProduct.Hzf) || ((fui()) && (this.HAZ.Hzj)))
    {
      AppMethodBeat.o(67246);
      return "";
    }
    paramMallRechargeProduct = String.format(getString(a.i.mall_recharge_price), new Object[] { Float.valueOf(paramMallRechargeProduct.Hze) });
    AppMethodBeat.o(67246);
    return paramMallRechargeProduct;
  }
  
  private boolean bAu()
  {
    AppMethodBeat.i(67249);
    if (!this.HAW.ftV()) {}
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.HAZ != null) && (this.HAZ.isValid()))
      {
        if ((fui()) && (this.HAZ.Hzj)) {
          n(new com.tencent.mm.plugin.recharge.model.d(this.HAZ.lvh, this.HAx.nBK, this.HAZ.productId, this.HAZ.appId, fug(), fuh()));
        }
        hideVKB();
        this.njb.setEnabled(true);
        this.njb.setClickable(true);
        Log.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(67249);
        return true;
      }
      if ((!this.HBc) && (i == 0) && (this.HAZ != null)) {
        this.HAZ.isValid();
      }
      this.njb.setEnabled(false);
      this.njb.setClickable(false);
      Log.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      AppMethodBeat.o(67249);
      return false;
    }
  }
  
  private void fue()
  {
    AppMethodBeat.i(67244);
    String str = getString(a.i.mall_recharge_balance);
    if (!TextUtils.isEmpty(this.HBf)) {
      str = this.HBf;
    }
    if (!Util.isNullOrNil(this.HBe)) {
      addTextOptionMenu(0, str, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67232);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", RechargeUI.j(RechargeUI.this));
          com.tencent.mm.by.c.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(67232);
          return true;
        }
      });
    }
    AppMethodBeat.o(67244);
  }
  
  private void fuf()
  {
    AppMethodBeat.i(67245);
    if (!Util.isNullOrNil(this.HBg)) {
      this.HAP.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.HBh)) {
        this.HAP.setText(this.HBh);
      }
      AppMethodBeat.o(67245);
      return;
      this.HAP.setVisibility(8);
    }
  }
  
  private String fug()
  {
    AppMethodBeat.i(67250);
    String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.aaY(this.HAW.getText());
    AppMethodBeat.o(67250);
    return str;
  }
  
  private String fuh()
  {
    AppMethodBeat.i(67251);
    String str = com.tencent.mm.plugin.recharge.model.b.aaY(this.HAW.getText());
    AppMethodBeat.o(67251);
    return str;
  }
  
  private boolean fui()
  {
    AppMethodBeat.i(67253);
    String str = O(this.HAZ.lvh, this.HAZ.productId, fuh());
    if (!this.HBd.containsKey(str))
    {
      AppMethodBeat.o(67253);
      return true;
    }
    AppMethodBeat.o(67253);
    return false;
  }
  
  private void gG(List<MallRechargeProduct> paramList)
  {
    AppMethodBeat.i(67259);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      int j;
      for (int i = 0; k < paramList.size(); i = j)
      {
        MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)paramList.get(k);
        j = i;
        if (localMallRechargeProduct.lvh == 2)
        {
          j = i;
          if (this.HAZ != null)
          {
            j = i;
            if (localMallRechargeProduct.productId.equals(this.HAZ.productId))
            {
              localMallRechargeProduct.lJx = true;
              j = 1;
            }
          }
          localArrayList.add(localMallRechargeProduct);
        }
        k += 1;
      }
      if ((i == 0) && (localArrayList.size() > 0)) {
        ((MallRechargeProduct)localArrayList.get(0)).lJx = true;
      }
      this.HAV.gH(localArrayList);
      AppMethodBeat.o(67259);
      return;
    }
    this.HAV.gH(new ArrayList());
    AppMethodBeat.o(67259);
  }
  
  private void n(final q paramq)
  {
    AppMethodBeat.i(67248);
    if ((paramq.getType() == 497) || (paramq.getType() == 1555))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(paramq, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if (!this.pCD)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(paramq, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(67218);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(paramq);
          AppMethodBeat.o(67218);
        }
      });
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramq, 0);
    AppMethodBeat.o(67248);
  }
  
  private static List<MallRechargeProduct> t(int paramInt, List<MallRechargeProduct> paramList)
  {
    AppMethodBeat.i(67247);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)paramList.get(i);
        k = j;
        if (localMallRechargeProduct.lvh == paramInt)
        {
          localArrayList.add(localMallRechargeProduct);
          k = j;
          if (localMallRechargeProduct.lJx)
          {
            if (j != 0) {
              localMallRechargeProduct.lJx = false;
            }
            k = 1;
          }
        }
        i += 1;
      }
      if ((j == 0) && (localArrayList.size() > 0)) {
        ((MallRechargeProduct)localArrayList.get(0)).lJx = true;
      }
    }
    AppMethodBeat.o(67247);
    return localArrayList;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(67243);
    Log.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.HAZ);
    if (this.HAZ != null)
    {
      this.HAX.setText(this.HAZ.uMF);
      this.HAO.setText(a(this.HAZ));
    }
    if ((this.HBb != null) && (this.HAx.OUr != null) && (this.HBb.equals(this.HAx.OUr)) && (!"1".equals(this.HBb.OUx)))
    {
      this.HAQ.setVisibility(8);
      Log.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.HBb.toString());
      this.HAN.setVisibility(4);
      if (!bAu()) {
        break label335;
      }
      if ((this.HAZ != null) && (!fui()))
      {
        this.HAM.setText(this.HAZ.Hzd);
        this.HAM.setTextColor(getResources().getColor(a.c.hint_text_color));
      }
    }
    for (;;)
    {
      fue();
      fuf();
      AppMethodBeat.o(67243);
      return;
      if ((this.HAx.OUr != null) && (!Util.isNullOrNil(this.HAx.OUr.OUB)))
      {
        this.HBa = this.HAx.OUr.OUB;
        Bitmap localBitmap = u.a(new com.tencent.mm.plugin.recharge.b.a(this.HBa));
        this.HAR.setImageBitmap(localBitmap);
        this.HAQ.setVisibility(0);
        Log.d("MicroMsg.MallRechargeUI", "Show banner!");
        break;
      }
      this.HAQ.setVisibility(8);
      Log.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break;
      label335:
      this.HAM.setText("");
    }
  }
  
  public final void ftW()
  {
    AppMethodBeat.i(67255);
    if ((Util.isNullOrNil(this.HAW.getText())) || (this.HAW.bAz()))
    {
      this.HAW.setInfoTvImageResource(a.e.recharge_phone_contact);
      AppMethodBeat.o(67255);
      return;
    }
    this.HAW.setInfoTvImageResource(a.e.list_clear);
    AppMethodBeat.o(67255);
  }
  
  public int getLayoutId()
  {
    return a.g.recharge_recharge_ui;
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(67264);
    Log.d("MicroMsg.MallRechargeUI", "hideVKB");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(67264);
      return;
    }
    Object localObject = getCurrentFocus();
    if (localObject == null)
    {
      AppMethodBeat.o(67264);
      return;
    }
    localObject = ((View)localObject).getWindowToken();
    if (localObject == null)
    {
      AppMethodBeat.o(67264);
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
    AppMethodBeat.o(67264);
  }
  
  public void initView()
  {
    AppMethodBeat.i(67242);
    setMMTitle(this.HAx.fXz);
    Log.v("MicroMsg.MallRechargeUI", "initView");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67216);
        RechargeUI.this.hideVKB();
        RechargeUI.this.finish();
        AppMethodBeat.o(67216);
        return true;
      }
    });
    this.HAM = ((TextView)findViewById(a.f.mall_product_desc));
    this.HAN = ((TextView)findViewById(a.f.mall_recharge_err_msg));
    this.HAO = ((TextView)findViewById(a.f.mall_sell_price));
    this.njb = ((Button)findViewById(a.f.next_btn));
    this.HAT = ((LinearLayout)findViewById(a.f.mall_input_ll));
    this.HAP = ((TextView)findViewById(a.f.mall_recharge_phone_recharge_card));
    this.HAP.setOnClickListener(new RechargeUI.11(this));
    this.njb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((RechargeUI.b(RechargeUI.this)) && (RechargeUI.c(RechargeUI.this))) {
          RechargeUI.d(RechargeUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67226);
      }
    });
    this.HAW = ((MallEditText)findViewById(a.f.mall_mobile_et));
    this.HAW.setInfoTvOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67227);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (RechargeUI.e(RechargeUI.this).HzI) {
          RechargeUI.e(RechargeUI.this).setInput(null);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67227);
          return;
          paramAnonymousView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
          RechargeUI.this.startActivityForResult(paramAnonymousView, 1);
        }
      }
    });
    this.HAX = ((TextView)findViewById(a.f.mall_product_name));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = t(0, (List)localObject);
    localObject = t(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.HAY = i;
      this.HAU = new a((byte)0);
      this.HAU.gH(localList);
      this.HAV = new a((byte)0);
      this.HAV.gH((List)localObject);
      this.HAT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (((RechargeUI.f(RechargeUI.this) != null) && (RechargeUI.f(RechargeUI.this).getCount() > 0)) || ((RechargeUI.g(RechargeUI.this) != null) && (RechargeUI.g(RechargeUI.this).getCount() > 0))) {
            RechargeUI.this.showDialog(1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67228);
        }
      });
      this.HAQ = ((FrameLayout)findViewById(a.f.mall_recharge_banner));
      this.HAR = ((ImageView)findViewById(a.f.mall_recharge_banner_iv));
      this.HAS = ((ImageView)findViewById(a.f.mall_recharge_banner_close_iv));
      this.HAS.setOnClickListener(new RechargeUI.15(this));
      this.HAQ.setOnClickListener(new RechargeUI.16(this));
      this.HAW.setOnInputValidChangeListener(this);
      this.HAW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67231);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RechargeUI.e(RechargeUI.this).getFocus();
          if (RechargeUI.e(RechargeUI.this).getInputRecord().sourceType == 2) {
            RechargeUI.e(RechargeUI.this).setInput(null);
          }
          if (Util.isNullOrNil(RechargeUI.e(RechargeUI.this).getText().toString())) {
            RechargeUI.e(RechargeUI.this).HzH.showDropDown();
          }
          RechargeUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67231);
        }
      });
      ftW();
      u.a(this);
      updateView();
      AppMethodBeat.o(67242);
      return;
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67262);
    if (this.HBa == null)
    {
      AppMethodBeat.o(67262);
      return;
    }
    if (paramString.equals(this.HBa)) {
      this.HAR.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67223);
          RechargeUI.o(RechargeUI.this).setImageBitmap(paramBitmap);
          AppMethodBeat.o(67223);
        }
      });
    }
    AppMethodBeat.o(67262);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67260);
    Cursor localCursor1;
    Object localObject2;
    label363:
    label380:
    String str2;
    switch (paramInt1)
    {
    default: 
    case 1: 
      do
      {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(67260);
        return;
      } while (paramInt2 != -1);
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.MallRechargeUI", "uri == null");
        AppMethodBeat.o(67260);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
      {
        Log.e("MicroMsg.MallRechargeUI", "no contact permission");
        AppMethodBeat.o(67260);
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
          Cursor localCursor2 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ".concat(String.valueOf(localObject1)), null, null);
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
              Log.d("MicroMsg.MallRechargeUI", "username : ".concat(String.valueOf(str1)));
              if (localObject2 == null) {
                break label583;
              }
              Log.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              localObject2 = com.tencent.mm.plugin.recharge.model.b.aaY((String)localObject2);
              Log.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject2)) {
                break label580;
              }
              localObject1 = localObject2;
              Log.d("MicroMsg.MallRechargeUI", "phoneResult : ".concat(String.valueOf(localObject1)));
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
        this.HBd.clear();
        this.HAW.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.HAM.setText("");
        this.HAN.setVisibility(4);
        bAu();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.GUM) {
          break;
        }
        Log.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.ftQ().a(this.HAW.getInputRecord());
        finish();
        this.GUM = true;
        break;
      }
      Log.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
      break;
      label580:
      break label363;
      label583:
      break label380;
      str2 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67241);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.HAx = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.pCD = bool;
      if (this.HAx != null) {
        break;
      }
      Log.e("MicroMsg.MallRechargeUI", "function info is null");
      w.makeText(this, "function info is null", 1).show();
      AppMethodBeat.o(67241);
      return;
    }
    if (localArrayList == null)
    {
      Log.d("MicroMsg.MallRechargeUI", "function info : " + this.HAx.fXz);
      n(new e(this.HAx.nBK));
    }
    for (;;)
    {
      Log.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.HBb = com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().bhe(this.HAx.nBK);
      initView();
      AppMethodBeat.o(67241);
      return;
      this.HAZ = a.gF(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67261);
    EventCenter.instance.removeListener(this.GUP);
    super.onDestroy();
    AppMethodBeat.o(67261);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(67254);
    if (!paramBoolean)
    {
      this.HBd.clear();
      this.HAM.setText("");
      this.HAN.setVisibility(4);
    }
    bAu();
    AppMethodBeat.o(67254);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67258);
    super.onPause();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(496, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(497, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(498, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1555, this);
    AppMethodBeat.o(67258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67257);
    super.onResume();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(496, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(497, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(498, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1555, this);
    AppMethodBeat.o(67257);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67256);
    Log.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramq.getType() != 497))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof e))
      {
        paramq = (e)paramq;
        paramString = paramq.Hzo;
        if (paramString != null)
        {
          this.HAZ = a.gF(paramString);
          Log.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.HAZ);
        }
        this.HBe = paramq.Hzp;
        this.HBf = paramq.Hzq;
        this.HBg = paramq.Hzr;
        this.HBh = paramq.Hzs;
        Log.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(paramString)));
        updateView();
        paramq = t(0, paramString);
        paramString = t(2, paramString);
        if (paramq.size() > paramString.size()) {}
        for (paramInt1 = paramq.size();; paramInt1 = paramString.size())
        {
          this.HAY = paramInt1;
          this.HAU.gH(paramq);
          this.HAV.gH(paramString);
          AppMethodBeat.o(67256);
          return;
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        Log.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.HAZ);
        paramq = (com.tencent.mm.plugin.recharge.model.d)paramq;
        if ((this.HAZ != null) && (this.HAZ.productId != null) && (paramq.Hzl != null) && (((this.HAZ.productId.equals(paramq.Hzl.productId)) && (fuh().equals(paramq.mZK))) || (paramq.lvh != 2)))
        {
          MallRechargeProduct.a(paramq.Hzl, this.HAZ);
          this.HAZ.lJx = true;
          String str = O(paramq.lvh, paramq.Hzl.productId, paramq.mZK);
          this.HBd.put(str, Integer.valueOf(1));
          updateView();
          this.HAN.setText(paramString);
          this.HAN.setVisibility(0);
          this.HAN.setTextColor(getResources().getColor(a.c.grey));
        }
        if (paramq.lvh == 2)
        {
          if ((this.HAZ == null) || (!this.HAZ.productId.equals(paramq.Hzn)) || (!fuh().equals(paramq.mZK))) {
            break label725;
          }
          if ((((bww)d.c.b(paramq.rr.lBS)).SWT == 0) && (this.HAZ.productId.equals(paramq.Hzl.productId))) {
            break label682;
          }
          this.njb.setEnabled(false);
          this.njb.setClickable(false);
          this.HAN.setText(((bww)d.c.b(paramq.rr.lBS)).SWU);
          this.HAN.setVisibility(0);
          this.HAN.setTextColor(getResources().getColor(a.c.red));
        }
        for (;;)
        {
          gG(paramq.Hzm);
          Log.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.HAZ);
          AppMethodBeat.o(67256);
          return;
          label682:
          n(new com.tencent.mm.plugin.recharge.model.c(this.HAZ.nBK, fuh(), this.HAZ.uMF, this.HAZ.appId, fug()));
          continue;
          label725:
          this.njb.setEnabled(true);
          this.njb.setClickable(true);
          this.HAN.setText(null);
        }
      }
      if ((paramq instanceof g))
      {
        paramString = ((g)paramq).HzF;
        paramString.fOY = 6;
        paramString.Rzf = 100;
        f.a(this, paramString, 2);
        EventCenter.instance.addListener(this.GUP);
        AppMethodBeat.o(67256);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.recharge.model.c))
      {
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramq;
        if ((this.HAZ != null) && (this.HAZ.uMF.equals(paramString.uMF)) && (fuh().equals(paramString.fLC)))
        {
          if (((blv)d.c.b(paramString.rr.lBS)).SWT != 0)
          {
            this.njb.setEnabled(false);
            this.njb.setClickable(false);
            this.HAN.setText(((blv)d.c.b(paramString.rr.lBS)).SWU);
            this.HAN.setVisibility(0);
            this.HAN.setTextColor(getResources().getColor(a.c.red));
            AppMethodBeat.o(67256);
          }
        }
        else
        {
          this.njb.setEnabled(true);
          this.njb.setClickable(true);
          this.HAN.setText(null);
        }
        AppMethodBeat.o(67256);
      }
    }
    else if (!(paramq instanceof com.tencent.mm.plugin.recharge.model.c))
    {
      if ((paramq instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        if (paramInt2 == 100)
        {
          this.njb.setEnabled(true);
          this.njb.setClickable(true);
        }
        for (;;)
        {
          gG(((com.tencent.mm.plugin.recharge.model.d)paramq).Hzm);
          this.HAN.setText(paramString);
          this.HAN.setVisibility(0);
          this.HAN.setTextColor(getResources().getColor(a.c.red));
          this.HAM.setText(((com.tencent.mm.plugin.recharge.model.d)paramq).Hzd);
          this.HAM.setTextColor(getResources().getColor(a.c.red));
          AppMethodBeat.o(67256);
          return;
          this.njb.setEnabled(false);
          this.njb.setClickable(false);
        }
      }
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getString(a.i.wallet_unknown_err);
      }
      com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(67256);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void showVKB()
  {
    AppMethodBeat.i(67263);
    Log.d("MicroMsg.MallRechargeUI", "showVKB");
    this.HAW.setInfoTvImageResource(a.e.list_clear);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(67263);
      return;
    }
    View localView = getCurrentFocus();
    if (localView == null)
    {
      AppMethodBeat.o(67263);
      return;
    }
    if (localView.getWindowToken() == null)
    {
      AppMethodBeat.o(67263);
      return;
    }
    localInputMethodManager.showSoftInput(localView, 2);
    AppMethodBeat.o(67263);
  }
  
  final class a
    extends BaseAdapter
  {
    private List<MallRechargeProduct> Hzm = null;
    
    private a() {}
    
    public final void abZ(int paramInt)
    {
      AppMethodBeat.i(67234);
      int i = 0;
      while (i < this.Hzm.size())
      {
        ((MallRechargeProduct)this.Hzm.get(i)).lJx = false;
        i += 1;
      }
      ((MallRechargeProduct)this.Hzm.get(paramInt)).lJx = true;
      AppMethodBeat.o(67234);
    }
    
    public final MallRechargeProduct aca(int paramInt)
    {
      AppMethodBeat.i(67236);
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)this.Hzm.get(paramInt);
      AppMethodBeat.o(67236);
      return localMallRechargeProduct;
    }
    
    public final void gH(List<MallRechargeProduct> paramList)
    {
      AppMethodBeat.i(67233);
      this.Hzm = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(67233);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67235);
      if (this.Hzm == null)
      {
        AppMethodBeat.o(67235);
        return 0;
      }
      int i = this.Hzm.size();
      AppMethodBeat.o(67235);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(67238);
      paramView = (CheckedTextView)View.inflate(RechargeUI.this, a.g.recharge_list_dialog_item_singlechoice, null);
      paramViewGroup = aca(paramInt);
      paramView.setText(paramViewGroup.uMF);
      paramView.setEnabled(paramViewGroup.isValid());
      if (paramViewGroup.lJx) {
        paramView.setChecked(true);
      }
      for (;;)
      {
        AppMethodBeat.o(67238);
        return paramView;
        paramView.setChecked(false);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(67237);
      if (!aca(paramInt).isValid())
      {
        AppMethodBeat.o(67237);
        return false;
      }
      boolean bool = super.isEnabled(paramInt);
      AppMethodBeat.o(67237);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI
 * JD-Core Version:    0.7.0.1
 */