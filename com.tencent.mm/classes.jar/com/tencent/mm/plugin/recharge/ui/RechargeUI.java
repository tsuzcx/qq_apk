package com.tencent.mm.plugin.recharge.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI
  extends MMActivity
  implements com.tencent.mm.ak.g, u.a, MallEditText.b
{
  private Button iXb;
  private boolean kUX;
  protected Dialog tipDialog;
  private boolean vGr;
  private com.tencent.mm.sdk.b.c vGu;
  private MallFunction wgP;
  private TextView whe;
  private TextView whf;
  private TextView whg;
  private TextView whh;
  private FrameLayout whi;
  private ImageView whj;
  private ImageView whk;
  private LinearLayout whl;
  private a whm;
  private a whn;
  private MallEditText who;
  private TextView whp;
  private int whq;
  private MallRechargeProduct whr;
  private String whs;
  private MallNews wht;
  private boolean whu;
  private Map<String, Integer> whv;
  private String whw;
  public String whx;
  private String why;
  public String whz;
  
  public RechargeUI()
  {
    AppMethodBeat.i(67240);
    this.iXb = null;
    this.whe = null;
    this.whf = null;
    this.whg = null;
    this.whh = null;
    this.whi = null;
    this.whj = null;
    this.whk = null;
    this.whl = null;
    this.whm = null;
    this.whn = null;
    this.tipDialog = null;
    this.wgP = null;
    this.whr = null;
    this.whs = null;
    this.wht = null;
    this.vGr = false;
    this.whu = false;
    this.kUX = true;
    this.whv = new HashMap();
    this.vGu = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67240);
  }
  
  private static String H(int paramInt, String paramString1, String paramString2)
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
      paramMallRechargeProduct = getString(2131761160);
      AppMethodBeat.o(67246);
      return paramMallRechargeProduct;
    }
    if ((paramMallRechargeProduct.wfw != paramMallRechargeProduct.wfx) || ((dtB()) && (this.whr.wfB)))
    {
      AppMethodBeat.o(67246);
      return "";
    }
    paramMallRechargeProduct = String.format(getString(2131761163), new Object[] { Float.valueOf(paramMallRechargeProduct.wfw) });
    AppMethodBeat.o(67246);
    return paramMallRechargeProduct;
  }
  
  private boolean aRK()
  {
    AppMethodBeat.i(67249);
    if (!this.who.dto()) {}
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.whr != null) && (this.whr.isValid()))
      {
        if ((dtB()) && (this.whr.wfB)) {
          l(new com.tencent.mm.plugin.recharge.model.d(this.whr.hph, this.wgP.wfu, this.whr.dcO, this.whr.appId, dtz(), dtA()));
        }
        hideVKB();
        this.iXb.setEnabled(true);
        this.iXb.setClickable(true);
        ac.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(67249);
        return true;
      }
      this.iXb.setEnabled(false);
      this.iXb.setClickable(false);
      ac.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      AppMethodBeat.o(67249);
      return false;
    }
  }
  
  private void cL()
  {
    AppMethodBeat.i(67243);
    ac.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.whr);
    if (this.whr != null)
    {
      this.whp.setText(this.whr.pio);
      this.whg.setText(a(this.whr));
    }
    if ((this.wht != null) && (this.wgP.BAX != null) && (this.wht.equals(this.wgP.BAX)) && (!"1".equals(this.wht.BBd)))
    {
      this.whi.setVisibility(8);
      ac.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.wht.toString());
      this.whf.setVisibility(4);
      if (!aRK()) {
        break label335;
      }
      if ((this.whr != null) && (!dtB()))
      {
        this.whe.setText(this.whr.wfv);
        this.whe.setTextColor(getResources().getColor(2131100490));
      }
    }
    for (;;)
    {
      dtx();
      dty();
      AppMethodBeat.o(67243);
      return;
      if ((this.wgP.BAX != null) && (!bs.isNullOrNil(this.wgP.BAX.BBh)))
      {
        this.whs = this.wgP.BAX.BBh;
        Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.recharge.b.a(this.whs));
        this.whj.setImageBitmap(localBitmap);
        this.whi.setVisibility(0);
        ac.d("MicroMsg.MallRechargeUI", "Show banner!");
        break;
      }
      this.whi.setVisibility(8);
      ac.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break;
      label335:
      this.whe.setText("");
    }
  }
  
  private String dtA()
  {
    AppMethodBeat.i(67251);
    String str = com.tencent.mm.plugin.recharge.model.b.GG(this.who.getText());
    AppMethodBeat.o(67251);
    return str;
  }
  
  private boolean dtB()
  {
    AppMethodBeat.i(67253);
    String str = H(this.whr.hph, this.whr.dcO, dtA());
    if (!this.whv.containsKey(str))
    {
      AppMethodBeat.o(67253);
      return true;
    }
    AppMethodBeat.o(67253);
    return false;
  }
  
  private void dtx()
  {
    AppMethodBeat.i(67244);
    String str = getString(2131761152);
    if (!TextUtils.isEmpty(this.whx)) {
      str = this.whx;
    }
    if (!bs.isNullOrNil(this.whw)) {
      addTextOptionMenu(0, str, new RechargeUI.18(this));
    }
    AppMethodBeat.o(67244);
  }
  
  private void dty()
  {
    AppMethodBeat.i(67245);
    if (!bs.isNullOrNil(this.why)) {
      this.whh.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.whz)) {
        this.whh.setText(this.whz);
      }
      AppMethodBeat.o(67245);
      return;
      this.whh.setVisibility(8);
    }
  }
  
  private String dtz()
  {
    AppMethodBeat.i(67250);
    String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.GG(this.who.getText());
    AppMethodBeat.o(67250);
    return str;
  }
  
  private void eJ(List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.hph == 2)
        {
          j = i;
          if (this.whr != null)
          {
            j = i;
            if (localMallRechargeProduct.dcO.equals(this.whr.dcO))
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
      this.whn.eK(localArrayList);
      AppMethodBeat.o(67259);
      return;
    }
    this.whn.eK(new ArrayList());
    AppMethodBeat.o(67259);
  }
  
  private static List<MallRechargeProduct> j(int paramInt, List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.hph == paramInt)
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
    AppMethodBeat.o(67247);
    return localArrayList;
  }
  
  private void l(n paramn)
  {
    AppMethodBeat.i(67248);
    if ((paramn.getType() == 497) || (paramn.getType() == 1555))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramn, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if (!this.kUX)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramn, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new RechargeUI.3(this, paramn));
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramn, 0);
    AppMethodBeat.o(67248);
  }
  
  public final void dtp()
  {
    AppMethodBeat.i(67255);
    if ((bs.isNullOrNil(this.who.getText())) || (this.who.aRO()))
    {
      this.who.setInfoTvImageResource(2131233803);
      AppMethodBeat.o(67255);
      return;
    }
    this.who.setInfoTvImageResource(2131232862);
    AppMethodBeat.o(67255);
  }
  
  public int getLayoutId()
  {
    return 2131495211;
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(67264);
    ac.d("MicroMsg.MallRechargeUI", "hideVKB");
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
    setMMTitle(this.wgP.dxZ);
    ac.v("MicroMsg.MallRechargeUI", "initView");
    setBackBtn(new RechargeUI.1(this));
    this.whe = ((TextView)findViewById(2131302086));
    this.whf = ((TextView)findViewById(2131302134));
    this.whg = ((TextView)findViewById(2131302136));
    this.iXb = ((Button)findViewById(2131302852));
    this.whl = ((LinearLayout)findViewById(2131302021));
    this.whh = ((TextView)findViewById(2131302135));
    this.whh.setOnClickListener(new RechargeUI.11(this));
    this.iXb.setOnClickListener(new RechargeUI.12(this));
    this.who = ((MallEditText)findViewById(2131302024));
    this.who.setInfoTvOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67227);
        if (RechargeUI.e(RechargeUI.this).wga)
        {
          RechargeUI.e(RechargeUI.this).setInput(null);
          AppMethodBeat.o(67227);
          return;
        }
        paramAnonymousView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        RechargeUI.this.startActivityForResult(paramAnonymousView, 1);
        AppMethodBeat.o(67227);
      }
    });
    this.whp = ((TextView)findViewById(2131302091));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = j(0, (List)localObject);
    localObject = j(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.whq = i;
      this.whm = new a((byte)0);
      this.whm.eK(localList);
      this.whn = new a((byte)0);
      this.whn.eK((List)localObject);
      this.whl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67228);
          if (((RechargeUI.f(RechargeUI.this) != null) && (RechargeUI.f(RechargeUI.this).getCount() > 0)) || ((RechargeUI.g(RechargeUI.this) != null) && (RechargeUI.g(RechargeUI.this).getCount() > 0))) {
            RechargeUI.this.showDialog(1);
          }
          AppMethodBeat.o(67228);
        }
      });
      this.whi = ((FrameLayout)findViewById(2131302131));
      this.whj = ((ImageView)findViewById(2131302133));
      this.whk = ((ImageView)findViewById(2131302132));
      this.whk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67229);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.mall.c.esN();
          Object localObject = RechargeUI.h(RechargeUI.this).wfu;
          ac.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(localObject)));
          if ((!bs.isNullOrNil((String)localObject)) && (paramAnonymousView.BBo.containsKey(localObject)))
          {
            localObject = (MallNews)paramAnonymousView.BBo.get(localObject);
            if ("1".equals(((MallNews)localObject).BBd))
            {
              ((MallNews)localObject).BBd = "2";
              paramAnonymousView.dpl();
            }
          }
          RechargeUI.i(RechargeUI.this).setVisibility(8);
          AppMethodBeat.o(67229);
        }
      });
      this.whi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67230);
          if (!bs.isNullOrNil(RechargeUI.h(RechargeUI.this).BAX.BBg))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", RechargeUI.h(RechargeUI.this).BAX.BBg);
            paramAnonymousView.putExtra("geta8key_username", com.tencent.mm.model.u.axw());
            com.tencent.mm.br.d.b(RechargeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView);
          }
          AppMethodBeat.o(67230);
        }
      });
      this.who.setOnInputValidChangeListener(this);
      this.who.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67231);
          RechargeUI.e(RechargeUI.this).getFocus();
          if (RechargeUI.e(RechargeUI.this).getInputRecord().sourceType == 2) {
            RechargeUI.e(RechargeUI.this).setInput(null);
          }
          if (bs.isNullOrNil(RechargeUI.e(RechargeUI.this).getText().toString())) {
            RechargeUI.e(RechargeUI.this).wfZ.showDropDown();
          }
          RechargeUI.this.showVKB();
          AppMethodBeat.o(67231);
        }
      });
      dtp();
      com.tencent.mm.platformtools.u.a(this);
      cL();
      AppMethodBeat.o(67242);
      return;
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67262);
    if (this.whs == null)
    {
      AppMethodBeat.o(67262);
      return;
    }
    if (paramString.equals(this.whs)) {
      this.whj.post(new Runnable()
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
        ac.e("MicroMsg.MallRechargeUI", "uri == null");
        AppMethodBeat.o(67260);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
      {
        ac.e("MicroMsg.MallRechargeUI", "no contact permission");
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
              ac.d("MicroMsg.MallRechargeUI", "username : ".concat(String.valueOf(str1)));
              if (localObject2 == null) {
                break label583;
              }
              ac.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              localObject2 = com.tencent.mm.plugin.recharge.model.b.GG((String)localObject2);
              ac.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject2)) {
                break label580;
              }
              localObject1 = localObject2;
              ac.d("MicroMsg.MallRechargeUI", "phoneResult : ".concat(String.valueOf(localObject1)));
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
        this.whv.clear();
        this.who.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.whe.setText("");
        this.whf.setVisibility(4);
        aRK();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.vGr) {
          break;
        }
        ac.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.dtj().a(this.who.getInputRecord());
        finish();
        this.vGr = true;
        break;
      }
      ac.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
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
    this.wgP = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.kUX = bool;
      if (this.wgP != null) {
        break;
      }
      ac.e("MicroMsg.MallRechargeUI", "function info is null");
      t.makeText(this, "function info is null", 1).show();
      AppMethodBeat.o(67241);
      return;
    }
    if (localArrayList == null)
    {
      ac.d("MicroMsg.MallRechargeUI", "function info : " + this.wgP.dxZ);
      l(new e(this.wgP.wfu));
    }
    for (;;)
    {
      ac.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.wht = com.tencent.mm.plugin.wallet_core.model.mall.c.esN().azs(this.wgP.wfu);
      initView();
      AppMethodBeat.o(67241);
      return;
      this.whr = a.eI(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67261);
    com.tencent.mm.sdk.b.a.GpY.d(this.vGu);
    super.onDestroy();
    AppMethodBeat.o(67261);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(67254);
    if (!paramBoolean)
    {
      this.whv.clear();
      this.whe.setText("");
      this.whf.setVisibility(4);
    }
    aRK();
    AppMethodBeat.o(67254);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67258);
    super.onPause();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(496, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(497, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(498, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1555, this);
    AppMethodBeat.o(67258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67257);
    super.onResume();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(496, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(497, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(498, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1555, this);
    AppMethodBeat.o(67257);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67256);
    ac.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramn.getType() != 497))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof e))
      {
        paramn = (e)paramn;
        paramString = paramn.wfG;
        if (paramString != null)
        {
          this.whr = a.eI(paramString);
          ac.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.whr);
        }
        this.whw = paramn.wfH;
        this.whx = paramn.wfI;
        this.why = paramn.wfJ;
        this.whz = paramn.wfK;
        ac.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(paramString)));
        cL();
        paramn = j(0, paramString);
        paramString = j(2, paramString);
        if (paramn.size() > paramString.size()) {}
        for (paramInt1 = paramn.size();; paramInt1 = paramString.size())
        {
          this.whq = paramInt1;
          this.whm.eK(paramn);
          this.whn.eK(paramString);
          AppMethodBeat.o(67256);
          return;
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        ac.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.whr);
        paramn = (com.tencent.mm.plugin.recharge.model.d)paramn;
        if ((this.whr != null) && (this.whr.dcO != null) && (paramn.wfD != null) && (((this.whr.dcO.equals(paramn.wfD.dcO)) && (dtA().equals(paramn.iOg))) || (paramn.hph != 2)))
        {
          MallRechargeProduct.a(paramn.wfD, this.whr);
          this.whr.isDefault = true;
          String str = H(paramn.hph, paramn.wfD.dcO, paramn.iOg);
          this.whv.put(str, Integer.valueOf(1));
          cL();
          this.whf.setText(paramString);
          this.whf.setVisibility(0);
          this.whf.setTextColor(getResources().getColor(2131100468));
        }
        if (paramn.hph == 2)
        {
          if ((this.whr == null) || (!this.whr.dcO.equals(paramn.wfF)) || (!dtA().equals(paramn.iOg))) {
            break label725;
          }
          if ((((ayt)paramn.rr.hvs.hvw).EIm == 0) && (this.whr.dcO.equals(paramn.wfD.dcO))) {
            break label682;
          }
          this.iXb.setEnabled(false);
          this.iXb.setClickable(false);
          this.whf.setText(((ayt)paramn.rr.hvs.hvw).EIn);
          this.whf.setVisibility(0);
          this.whf.setTextColor(getResources().getColor(2131100798));
        }
        for (;;)
        {
          eJ(paramn.wfE);
          ac.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.whr);
          AppMethodBeat.o(67256);
          return;
          label682:
          l(new com.tencent.mm.plugin.recharge.model.c(this.whr.wfu, dtA(), this.whr.pio, this.whr.appId, dtz()));
          continue;
          label725:
          this.iXb.setEnabled(true);
          this.iXb.setClickable(true);
          this.whf.setText(null);
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        paramString = ((com.tencent.mm.plugin.recharge.model.g)paramn).wfX;
        paramString.dqL = 6;
        paramString.DGI = 100;
        f.a(this, paramString, 2);
        com.tencent.mm.sdk.b.a.GpY.c(this.vGu);
        AppMethodBeat.o(67256);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.c))
      {
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramn;
        if ((this.whr != null) && (this.whr.pio.equals(paramString.pio)) && (dtA().equals(paramString.dnz)))
        {
          if (((aph)paramString.rr.hvs.hvw).EIm != 0)
          {
            this.iXb.setEnabled(false);
            this.iXb.setClickable(false);
            this.whf.setText(((aph)paramString.rr.hvs.hvw).EIn);
            this.whf.setVisibility(0);
            this.whf.setTextColor(getResources().getColor(2131100798));
            AppMethodBeat.o(67256);
          }
        }
        else
        {
          this.iXb.setEnabled(true);
          this.iXb.setClickable(true);
          this.whf.setText(null);
        }
        AppMethodBeat.o(67256);
      }
    }
    else if (!(paramn instanceof com.tencent.mm.plugin.recharge.model.c))
    {
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        if (paramInt2 == 100)
        {
          this.iXb.setEnabled(true);
          this.iXb.setClickable(true);
        }
        for (;;)
        {
          eJ(((com.tencent.mm.plugin.recharge.model.d)paramn).wfE);
          this.whf.setText(paramString);
          this.whf.setVisibility(0);
          this.whf.setTextColor(getResources().getColor(2131100798));
          this.whe.setText(((com.tencent.mm.plugin.recharge.model.d)paramn).wfv);
          this.whe.setTextColor(getResources().getColor(2131100798));
          AppMethodBeat.o(67256);
          return;
          this.iXb.setEnabled(false);
          this.iXb.setClickable(false);
        }
      }
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = getString(2131765901);
      }
      h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
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
    ac.d("MicroMsg.MallRechargeUI", "showVKB");
    this.who.setInfoTvImageResource(2131232862);
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
    private List<MallRechargeProduct> wfE = null;
    
    private a() {}
    
    public final void LX(int paramInt)
    {
      AppMethodBeat.i(67234);
      int i = 0;
      while (i < this.wfE.size())
      {
        ((MallRechargeProduct)this.wfE.get(i)).isDefault = false;
        i += 1;
      }
      ((MallRechargeProduct)this.wfE.get(paramInt)).isDefault = true;
      AppMethodBeat.o(67234);
    }
    
    public final MallRechargeProduct LY(int paramInt)
    {
      AppMethodBeat.i(67236);
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)this.wfE.get(paramInt);
      AppMethodBeat.o(67236);
      return localMallRechargeProduct;
    }
    
    public final void eK(List<MallRechargeProduct> paramList)
    {
      AppMethodBeat.i(67233);
      this.wfE = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(67233);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67235);
      if (this.wfE == null)
      {
        AppMethodBeat.o(67235);
        return 0;
      }
      int i = this.wfE.size();
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
      paramView = (CheckedTextView)View.inflate(RechargeUI.this, 2131495208, null);
      paramViewGroup = LY(paramInt);
      paramView.setText(paramViewGroup.pio);
      paramView.setEnabled(paramViewGroup.isValid());
      if (paramViewGroup.isDefault) {
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
      if (!LY(paramInt).isValid())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI
 * JD-Core Version:    0.7.0.1
 */