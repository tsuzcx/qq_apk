package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.d;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.recharge.model.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI
  extends MMActivity
  implements com.tencent.mm.am.h, r.a, MallEditText.b
{
  private boolean MSo;
  private IListener MSr;
  private TextView NyA;
  private int NyB;
  private MallRechargeProduct NyC;
  private String NyD;
  private MallNews NyE;
  private boolean NyF;
  private Map<String, Integer> NyG;
  private String NyH;
  public String NyI;
  private String NyJ;
  public String NyK;
  private MallFunction Nya;
  private TextView Nyp;
  private TextView Nyq;
  private TextView Nyr;
  private TextView Nys;
  private FrameLayout Nyt;
  private ImageView Nyu;
  private ImageView Nyv;
  private LinearLayout Nyw;
  private a Nyx;
  private a Nyy;
  private MallEditText Nyz;
  private Button qgp;
  private boolean sHP;
  protected Dialog tipDialog;
  
  public RechargeUI()
  {
    AppMethodBeat.i(67240);
    this.qgp = null;
    this.Nyp = null;
    this.Nyq = null;
    this.Nyr = null;
    this.Nys = null;
    this.Nyt = null;
    this.Nyu = null;
    this.Nyv = null;
    this.Nyw = null;
    this.Nyx = null;
    this.Nyy = null;
    this.tipDialog = null;
    this.Nya = null;
    this.NyC = null;
    this.NyD = null;
    this.NyE = null;
    this.MSo = false;
    this.NyF = false;
    this.sHP = true;
    this.NyG = new HashMap();
    this.MSr = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(67240);
  }
  
  private static List<MallRechargeProduct> O(int paramInt, List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.omE == paramInt)
        {
          localArrayList.add(localMallRechargeProduct);
          k = j;
          if (localMallRechargeProduct.oBZ)
          {
            if (j != 0) {
              localMallRechargeProduct.oBZ = false;
            }
            k = 1;
          }
        }
        i += 1;
      }
      if ((j == 0) && (localArrayList.size() > 0)) {
        ((MallRechargeProduct)localArrayList.get(0)).oBZ = true;
      }
    }
    AppMethodBeat.o(67247);
    return localArrayList;
  }
  
  private static String R(int paramInt, String paramString1, String paramString2)
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
    if ((paramMallRechargeProduct.NwJ != paramMallRechargeProduct.NwK) || ((gFW()) && (this.NyC.NwM)))
    {
      AppMethodBeat.o(67246);
      return "";
    }
    paramMallRechargeProduct = String.format(getString(a.i.mall_recharge_price), new Object[] { Float.valueOf(paramMallRechargeProduct.NwJ) });
    AppMethodBeat.o(67246);
    return paramMallRechargeProduct;
  }
  
  private boolean bZk()
  {
    AppMethodBeat.i(67249);
    if (!this.Nyz.gFJ()) {}
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.NyC != null) && (this.NyC.isValid()))
      {
        if ((gFW()) && (this.NyC.NwM)) {
          n(new d(this.NyC.omE, this.Nya.qBb, this.NyC.productId, this.NyC.appId, gFU(), gFV()));
        }
        hideVKB();
        this.qgp.setEnabled(true);
        this.qgp.setClickable(true);
        Log.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(67249);
        return true;
      }
      if ((!this.NyF) && (i == 0) && (this.NyC != null)) {
        this.NyC.isValid();
      }
      this.qgp.setEnabled(false);
      this.qgp.setClickable(false);
      Log.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      AppMethodBeat.o(67249);
      return false;
    }
  }
  
  private void gFS()
  {
    AppMethodBeat.i(67244);
    String str = getString(a.i.mall_recharge_balance);
    if (!TextUtils.isEmpty(this.NyI)) {
      str = this.NyI;
    }
    if (!Util.isNullOrNil(this.NyH)) {
      addTextOptionMenu(0, str, new RechargeUI.17(this));
    }
    AppMethodBeat.o(67244);
  }
  
  private void gFT()
  {
    AppMethodBeat.i(67245);
    if (!Util.isNullOrNil(this.NyJ)) {
      this.Nys.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.NyK)) {
        this.Nys.setText(this.NyK);
      }
      AppMethodBeat.o(67245);
      return;
      this.Nys.setVisibility(8);
    }
  }
  
  private String gFU()
  {
    AppMethodBeat.i(67250);
    String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.Tu(this.Nyz.getText());
    AppMethodBeat.o(67250);
    return str;
  }
  
  private String gFV()
  {
    AppMethodBeat.i(67251);
    String str = com.tencent.mm.plugin.recharge.model.b.Tu(this.Nyz.getText());
    AppMethodBeat.o(67251);
    return str;
  }
  
  private boolean gFW()
  {
    AppMethodBeat.i(67253);
    String str = R(this.NyC.omE, this.NyC.productId, gFV());
    if (!this.NyG.containsKey(str))
    {
      AppMethodBeat.o(67253);
      return true;
    }
    AppMethodBeat.o(67253);
    return false;
  }
  
  private void jG(List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.omE == 2)
        {
          j = i;
          if (this.NyC != null)
          {
            j = i;
            if (localMallRechargeProduct.productId.equals(this.NyC.productId))
            {
              localMallRechargeProduct.oBZ = true;
              j = 1;
            }
          }
          localArrayList.add(localMallRechargeProduct);
        }
        k += 1;
      }
      if ((i == 0) && (localArrayList.size() > 0)) {
        ((MallRechargeProduct)localArrayList.get(0)).oBZ = true;
      }
      this.Nyy.jH(localArrayList);
      AppMethodBeat.o(67259);
      return;
    }
    this.Nyy.jH(new ArrayList());
    AppMethodBeat.o(67259);
  }
  
  private void n(p paramp)
  {
    AppMethodBeat.i(67248);
    if ((paramp.getType() == 497) || (paramp.getType() == 1555))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramp, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if (!this.sHP)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramp, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      this.tipDialog = l.a(getContext(), true, new RechargeUI.3(this, paramp));
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramp, 0);
    AppMethodBeat.o(67248);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(67243);
    Log.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.NyC);
    if (this.NyC != null)
    {
      this.NyA.setText(this.NyC.xVh);
      this.Nyr.setText(a(this.NyC));
    }
    if ((this.NyE != null) && (this.Nya.VKI != null) && (this.NyE.equals(this.Nya.VKI)) && (!"1".equals(this.NyE.VKO)))
    {
      this.Nyt.setVisibility(8);
      Log.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.NyE.toString());
      this.Nyq.setVisibility(4);
      if (!bZk()) {
        break label335;
      }
      if ((this.NyC != null) && (!gFW()))
      {
        this.Nyp.setText(this.NyC.NwI);
        this.Nyp.setTextColor(getResources().getColor(a.c.hint_text_color));
      }
    }
    for (;;)
    {
      gFS();
      gFT();
      AppMethodBeat.o(67243);
      return;
      if ((this.Nya.VKI != null) && (!Util.isNullOrNil(this.Nya.VKI.VKS)))
      {
        this.NyD = this.Nya.VKI.VKS;
        Bitmap localBitmap = r.a(new com.tencent.mm.plugin.recharge.b.a(this.NyD));
        this.Nyu.setImageBitmap(localBitmap);
        this.Nyt.setVisibility(0);
        Log.d("MicroMsg.MallRechargeUI", "Show banner!");
        break;
      }
      this.Nyt.setVisibility(8);
      Log.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break;
      label335:
      this.Nyp.setText("");
    }
  }
  
  public final void gFK()
  {
    AppMethodBeat.i(67255);
    if ((Util.isNullOrNil(this.Nyz.getText())) || (this.Nyz.bZp()))
    {
      this.Nyz.setInfoTvImageResource(a.e.recharge_phone_contact);
      AppMethodBeat.o(67255);
      return;
    }
    this.Nyz.setInfoTvImageResource(a.e.list_clear);
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
    setMMTitle(this.Nya.idA);
    Log.v("MicroMsg.MallRechargeUI", "initView");
    setBackBtn(new RechargeUI.1(this));
    this.Nyp = ((TextView)findViewById(a.f.mall_product_desc));
    this.Nyq = ((TextView)findViewById(a.f.mall_recharge_err_msg));
    this.Nyr = ((TextView)findViewById(a.f.mall_sell_price));
    this.qgp = ((Button)findViewById(a.f.next_btn));
    this.Nyw = ((LinearLayout)findViewById(a.f.mall_input_ll));
    this.Nys = ((TextView)findViewById(a.f.mall_recharge_phone_recharge_card));
    this.Nys.setOnClickListener(new RechargeUI.10(this));
    this.qgp.setOnClickListener(new RechargeUI.11(this));
    this.Nyz = ((MallEditText)findViewById(a.f.mall_mobile_et));
    this.Nyz.setInfoTvOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67227);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (RechargeUI.e(RechargeUI.this).Nxl) {
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
    this.NyA = ((TextView)findViewById(a.f.mall_product_name));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = O(0, (List)localObject);
    localObject = O(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.NyB = i;
      this.Nyx = new a((byte)0);
      this.Nyx.jH(localList);
      this.Nyy = new a((byte)0);
      this.Nyy.jH((List)localObject);
      this.Nyw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (((RechargeUI.f(RechargeUI.this) != null) && (RechargeUI.f(RechargeUI.this).getCount() > 0)) || ((RechargeUI.g(RechargeUI.this) != null) && (RechargeUI.g(RechargeUI.this).getCount() > 0))) {
            RechargeUI.this.showDialog(1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67228);
        }
      });
      this.Nyt = ((FrameLayout)findViewById(a.f.mall_recharge_banner));
      this.Nyu = ((ImageView)findViewById(a.f.mall_recharge_banner_iv));
      this.Nyv = ((ImageView)findViewById(a.f.mall_recharge_banner_close_iv));
      this.Nyv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67229);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.mall.c.ikd();
          localObject = RechargeUI.h(RechargeUI.this).qBb;
          Log.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(localObject)));
          if ((!Util.isNullOrNil((String)localObject)) && (paramAnonymousView.VKY.containsKey(localObject)))
          {
            localObject = (MallNews)paramAnonymousView.VKY.get(localObject);
            if ("1".equals(((MallNews)localObject).VKO))
            {
              ((MallNews)localObject).VKO = "2";
              paramAnonymousView.gAt();
            }
          }
          RechargeUI.i(RechargeUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67229);
        }
      });
      this.Nyt.setOnClickListener(new RechargeUI.15(this));
      this.Nyz.setOnInputValidChangeListener(this);
      this.Nyz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67231);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RechargeUI.e(RechargeUI.this).getFocus();
          if (RechargeUI.e(RechargeUI.this).getInputRecord().sourceType == 2) {
            RechargeUI.e(RechargeUI.this).setInput(null);
          }
          if (Util.isNullOrNil(RechargeUI.e(RechargeUI.this).getText().toString())) {
            RechargeUI.e(RechargeUI.this).Nxk.showDropDown();
          }
          RechargeUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67231);
        }
      });
      gFK();
      r.a(this);
      updateView();
      AppMethodBeat.o(67242);
      return;
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67262);
    if (this.NyD == null)
    {
      AppMethodBeat.o(67262);
      return;
    }
    if (paramString.equals(this.NyD)) {
      this.Nyu.post(new Runnable()
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
      if (!com.tencent.mm.pluginsdk.permission.b.s(this, "android.permission.READ_CONTACTS"))
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
              localObject2 = com.tencent.mm.plugin.recharge.model.b.Tu((String)localObject2);
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
        this.NyG.clear();
        this.Nyz.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.Nyp.setText("");
        this.Nyq.setVisibility(4);
        bZk();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.MSo) {
          break;
        }
        Log.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.gFE().a(this.Nyz.getInputRecord());
        finish();
        this.MSo = true;
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
    this.Nya = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.sHP = bool;
      if (this.Nya != null) {
        break;
      }
      Log.e("MicroMsg.MallRechargeUI", "function info is null");
      aa.makeText(this, "function info is null", 1).show();
      AppMethodBeat.o(67241);
      return;
    }
    if (localArrayList == null)
    {
      Log.d("MicroMsg.MallRechargeUI", "function info : " + this.Nya.idA);
      n(new e(this.Nya.qBb));
    }
    for (;;)
    {
      Log.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.NyE = com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bgO(this.Nya.qBb);
      initView();
      AppMethodBeat.o(67241);
      return;
      this.NyC = a.jF(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67261);
    this.MSr.dead();
    super.onDestroy();
    AppMethodBeat.o(67261);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(67254);
    if (!paramBoolean)
    {
      this.NyG.clear();
      this.Nyp.setText("");
      this.Nyq.setVisibility(4);
    }
    bZk();
    AppMethodBeat.o(67254);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67258);
    super.onPause();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(496, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(497, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(498, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1555, this);
    AppMethodBeat.o(67258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67257);
    super.onResume();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(496, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(497, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(498, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1555, this);
    AppMethodBeat.o(67257);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67256);
    Log.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramp.getType() != 497))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof e))
      {
        paramp = (e)paramp;
        paramString = paramp.NwR;
        if (paramString != null)
        {
          this.NyC = a.jF(paramString);
          Log.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.NyC);
        }
        this.NyH = paramp.NwS;
        this.NyI = paramp.NwT;
        this.NyJ = paramp.NwU;
        this.NyK = paramp.NwV;
        Log.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(paramString)));
        updateView();
        paramp = O(0, paramString);
        paramString = O(2, paramString);
        if (paramp.size() > paramString.size()) {}
        for (paramInt1 = paramp.size();; paramInt1 = paramString.size())
        {
          this.NyB = paramInt1;
          this.Nyx.jH(paramp);
          this.Nyy.jH(paramString);
          AppMethodBeat.o(67256);
          return;
        }
      }
      if ((paramp instanceof d))
      {
        Log.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.NyC);
        paramp = (d)paramp;
        if ((this.NyC != null) && (this.NyC.productId != null) && (paramp.NwO != null) && (((this.NyC.productId.equals(paramp.NwO.productId)) && (gFV().equals(paramp.pWt))) || (paramp.omE != 2)))
        {
          MallRechargeProduct.a(paramp.NwO, this.NyC);
          this.NyC.oBZ = true;
          String str = R(paramp.omE, paramp.NwO.productId, paramp.pWt);
          this.NyG.put(str, Integer.valueOf(1));
          updateView();
          this.Nyq.setText(paramString);
          this.Nyq.setVisibility(0);
          this.Nyq.setTextColor(getResources().getColor(a.c.grey));
        }
        if (paramp.omE == 2)
        {
          if ((this.NyC == null) || (!this.NyC.productId.equals(paramp.NwQ)) || (!gFV().equals(paramp.pWt))) {
            break label725;
          }
          if ((((clz)c.c.b(paramp.rr.otC)).aaiK == 0) && (this.NyC.productId.equals(paramp.NwO.productId))) {
            break label682;
          }
          this.qgp.setEnabled(false);
          this.qgp.setClickable(false);
          this.Nyq.setText(((clz)c.c.b(paramp.rr.otC)).aaiL);
          this.Nyq.setVisibility(0);
          this.Nyq.setTextColor(getResources().getColor(a.c.red));
        }
        for (;;)
        {
          jG(paramp.NwP);
          Log.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.NyC);
          AppMethodBeat.o(67256);
          return;
          label682:
          n(new com.tencent.mm.plugin.recharge.model.c(this.NyC.qBb, gFV(), this.NyC.xVh, this.NyC.appId, gFU()));
          continue;
          label725:
          this.qgp.setEnabled(true);
          this.qgp.setClickable(true);
          this.Nyq.setText(null);
        }
      }
      if ((paramp instanceof g))
      {
        paramString = ((g)paramp).Nxi;
        paramString.hUR = 6;
        paramString.YvD = 100;
        com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 2);
        this.MSr.alive();
        AppMethodBeat.o(67256);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.recharge.model.c))
      {
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramp;
        if ((this.NyC != null) && (this.NyC.xVh.equals(paramString.xVh)) && (gFV().equals(paramString.hRk)))
        {
          if (((bzn)c.c.b(paramString.rr.otC)).aaiK != 0)
          {
            this.qgp.setEnabled(false);
            this.qgp.setClickable(false);
            this.Nyq.setText(((bzn)c.c.b(paramString.rr.otC)).aaiL);
            this.Nyq.setVisibility(0);
            this.Nyq.setTextColor(getResources().getColor(a.c.red));
            AppMethodBeat.o(67256);
          }
        }
        else
        {
          this.qgp.setEnabled(true);
          this.qgp.setClickable(true);
          this.Nyq.setText(null);
        }
        AppMethodBeat.o(67256);
      }
    }
    else if (!(paramp instanceof com.tencent.mm.plugin.recharge.model.c))
    {
      if ((paramp instanceof d))
      {
        if (paramInt2 == 100)
        {
          this.qgp.setEnabled(true);
          this.qgp.setClickable(true);
        }
        for (;;)
        {
          jG(((d)paramp).NwP);
          this.Nyq.setText(paramString);
          this.Nyq.setVisibility(0);
          this.Nyq.setTextColor(getResources().getColor(a.c.red));
          this.Nyp.setText(((d)paramp).NwI);
          this.Nyp.setTextColor(getResources().getColor(a.c.red));
          AppMethodBeat.o(67256);
          return;
          this.qgp.setEnabled(false);
          this.qgp.setClickable(false);
        }
      }
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = getString(a.i.wallet_unknown_err);
      }
      k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
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
    this.Nyz.setInfoTvImageResource(a.e.list_clear);
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
    private List<MallRechargeProduct> NwP = null;
    
    private a() {}
    
    public final void agn(int paramInt)
    {
      AppMethodBeat.i(67234);
      int i = 0;
      while (i < this.NwP.size())
      {
        ((MallRechargeProduct)this.NwP.get(i)).oBZ = false;
        i += 1;
      }
      ((MallRechargeProduct)this.NwP.get(paramInt)).oBZ = true;
      AppMethodBeat.o(67234);
    }
    
    public final MallRechargeProduct ago(int paramInt)
    {
      AppMethodBeat.i(67236);
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)this.NwP.get(paramInt);
      AppMethodBeat.o(67236);
      return localMallRechargeProduct;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67235);
      if (this.NwP == null)
      {
        AppMethodBeat.o(67235);
        return 0;
      }
      int i = this.NwP.size();
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
      paramViewGroup = ago(paramInt);
      paramView.setText(paramViewGroup.xVh);
      paramView.setEnabled(paramViewGroup.isValid());
      if (paramViewGroup.oBZ) {
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
      if (!ago(paramInt).isValid())
      {
        AppMethodBeat.o(67237);
        return false;
      }
      boolean bool = super.isEnabled(paramInt);
      AppMethodBeat.o(67237);
      return bool;
    }
    
    public final void jH(List<MallRechargeProduct> paramList)
    {
      AppMethodBeat.i(67233);
      this.NwP = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(67233);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI
 * JD-Core Version:    0.7.0.1
 */