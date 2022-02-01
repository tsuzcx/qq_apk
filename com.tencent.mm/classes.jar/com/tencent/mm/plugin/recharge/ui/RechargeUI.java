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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements com.tencent.mm.al.g, u.a, MallEditText.b
{
  private Button iwY;
  private boolean ktI;
  protected Dialog tipDialog;
  private TextView uYA;
  private int uYB;
  private MallRechargeProduct uYC;
  private String uYD;
  private MallNews uYE;
  private boolean uYF;
  private Map<String, Integer> uYG;
  private String uYH;
  public String uYI;
  private String uYJ;
  public String uYK;
  private MallFunction uYa;
  private TextView uYp;
  private TextView uYq;
  private TextView uYr;
  private TextView uYs;
  private FrameLayout uYt;
  private ImageView uYu;
  private ImageView uYv;
  private LinearLayout uYw;
  private a uYx;
  private a uYy;
  private MallEditText uYz;
  private com.tencent.mm.sdk.b.c uxB;
  private boolean uxy;
  
  public RechargeUI()
  {
    AppMethodBeat.i(67240);
    this.iwY = null;
    this.uYp = null;
    this.uYq = null;
    this.uYr = null;
    this.uYs = null;
    this.uYt = null;
    this.uYu = null;
    this.uYv = null;
    this.uYw = null;
    this.uYx = null;
    this.uYy = null;
    this.tipDialog = null;
    this.uYa = null;
    this.uYC = null;
    this.uYD = null;
    this.uYE = null;
    this.uxy = false;
    this.uYF = false;
    this.ktI = true;
    this.uYG = new HashMap();
    this.uxB = new com.tencent.mm.sdk.b.c() {};
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
    if ((paramMallRechargeProduct.uWH != paramMallRechargeProduct.uWI) || ((dfU()) && (this.uYC.uWM)))
    {
      AppMethodBeat.o(67246);
      return "";
    }
    paramMallRechargeProduct = String.format(getString(2131761163), new Object[] { Float.valueOf(paramMallRechargeProduct.uWH) });
    AppMethodBeat.o(67246);
    return paramMallRechargeProduct;
  }
  
  private boolean aKT()
  {
    AppMethodBeat.i(67249);
    if (!this.uYz.dfH()) {}
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.uYC != null) && (this.uYC.isValid()))
      {
        if ((dfU()) && (this.uYC.uWM)) {
          m(new com.tencent.mm.plugin.recharge.model.d(this.uYC.gOH, this.uYa.uWF, this.uYC.dft, this.uYC.appId, dfS(), dfT()));
        }
        hideVKB();
        this.iwY.setEnabled(true);
        this.iwY.setClickable(true);
        ad.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(67249);
        return true;
      }
      this.iwY.setEnabled(false);
      this.iwY.setClickable(false);
      ad.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      AppMethodBeat.o(67249);
      return false;
    }
  }
  
  private void cE()
  {
    AppMethodBeat.i(67243);
    ad.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.uYC);
    if (this.uYC != null)
    {
      this.uYA.setText(this.uYC.oEN);
      this.uYr.setText(a(this.uYC));
    }
    if ((this.uYE != null) && (this.uYa.AiC != null) && (this.uYE.equals(this.uYa.AiC)) && (!"1".equals(this.uYE.AiI)))
    {
      this.uYt.setVisibility(8);
      ad.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.uYE.toString());
      this.uYq.setVisibility(4);
      if (!aKT()) {
        break label335;
      }
      if ((this.uYC != null) && (!dfU()))
      {
        this.uYp.setText(this.uYC.uWG);
        this.uYp.setTextColor(getResources().getColor(2131100490));
      }
    }
    for (;;)
    {
      dfQ();
      dfR();
      AppMethodBeat.o(67243);
      return;
      if ((this.uYa.AiC != null) && (!bt.isNullOrNil(this.uYa.AiC.AiM)))
      {
        this.uYD = this.uYa.AiC.AiM;
        Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.recharge.b.a(this.uYD));
        this.uYu.setImageBitmap(localBitmap);
        this.uYt.setVisibility(0);
        ad.d("MicroMsg.MallRechargeUI", "Show banner!");
        break;
      }
      this.uYt.setVisibility(8);
      ad.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break;
      label335:
      this.uYp.setText("");
    }
  }
  
  private void dfQ()
  {
    AppMethodBeat.i(67244);
    String str = getString(2131761152);
    if (!TextUtils.isEmpty(this.uYI)) {
      str = this.uYI;
    }
    if (!bt.isNullOrNil(this.uYH)) {
      addTextOptionMenu(0, str, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67232);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", RechargeUI.j(RechargeUI.this));
          com.tencent.mm.bs.d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(67232);
          return true;
        }
      });
    }
    AppMethodBeat.o(67244);
  }
  
  private void dfR()
  {
    AppMethodBeat.i(67245);
    if (!bt.isNullOrNil(this.uYJ)) {
      this.uYs.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.uYK)) {
        this.uYs.setText(this.uYK);
      }
      AppMethodBeat.o(67245);
      return;
      this.uYs.setVisibility(8);
    }
  }
  
  private String dfS()
  {
    AppMethodBeat.i(67250);
    String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.CD(this.uYz.getText());
    AppMethodBeat.o(67250);
    return str;
  }
  
  private String dfT()
  {
    AppMethodBeat.i(67251);
    String str = com.tencent.mm.plugin.recharge.model.b.CD(this.uYz.getText());
    AppMethodBeat.o(67251);
    return str;
  }
  
  private boolean dfU()
  {
    AppMethodBeat.i(67253);
    String str = H(this.uYC.gOH, this.uYC.dft, dfT());
    if (!this.uYG.containsKey(str))
    {
      AppMethodBeat.o(67253);
      return true;
    }
    AppMethodBeat.o(67253);
    return false;
  }
  
  private void eF(List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.gOH == 2)
        {
          j = i;
          if (this.uYC != null)
          {
            j = i;
            if (localMallRechargeProduct.dft.equals(this.uYC.dft))
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
      this.uYy.eG(localArrayList);
      AppMethodBeat.o(67259);
      return;
    }
    this.uYy.eG(new ArrayList());
    AppMethodBeat.o(67259);
  }
  
  private static List<MallRechargeProduct> g(int paramInt, List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.gOH == paramInt)
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
  
  private void m(final n paramn)
  {
    AppMethodBeat.i(67248);
    if ((paramn.getType() == 497) || (paramn.getType() == 1555))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramn, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if (!this.ktI)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramn, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(67218);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(paramn);
          AppMethodBeat.o(67218);
        }
      });
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramn, 0);
    AppMethodBeat.o(67248);
  }
  
  public final void dfI()
  {
    AppMethodBeat.i(67255);
    if ((bt.isNullOrNil(this.uYz.getText())) || (this.uYz.aKX()))
    {
      this.uYz.setInfoTvImageResource(2131233803);
      AppMethodBeat.o(67255);
      return;
    }
    this.uYz.setInfoTvImageResource(2131232862);
    AppMethodBeat.o(67255);
  }
  
  public int getLayoutId()
  {
    return 2131495211;
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(67264);
    ad.d("MicroMsg.MallRechargeUI", "hideVKB");
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
    setMMTitle(this.uYa.dAn);
    ad.v("MicroMsg.MallRechargeUI", "initView");
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
    this.uYp = ((TextView)findViewById(2131302086));
    this.uYq = ((TextView)findViewById(2131302134));
    this.uYr = ((TextView)findViewById(2131302136));
    this.iwY = ((Button)findViewById(2131302852));
    this.uYw = ((LinearLayout)findViewById(2131302021));
    this.uYs = ((TextView)findViewById(2131302135));
    this.uYs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67225);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", RechargeUI.a(RechargeUI.this));
        com.tencent.mm.bs.d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(67225);
      }
    });
    this.iwY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67226);
        if ((RechargeUI.b(RechargeUI.this)) && (RechargeUI.c(RechargeUI.this))) {
          RechargeUI.d(RechargeUI.this);
        }
        AppMethodBeat.o(67226);
      }
    });
    this.uYz = ((MallEditText)findViewById(2131302024));
    this.uYz.setInfoTvOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67227);
        if (RechargeUI.e(RechargeUI.this).uXl)
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
    this.uYA = ((TextView)findViewById(2131302091));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = g(0, (List)localObject);
    localObject = g(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.uYB = i;
      this.uYx = new a((byte)0);
      this.uYx.eG(localList);
      this.uYy = new a((byte)0);
      this.uYy.eG((List)localObject);
      this.uYw.setOnClickListener(new View.OnClickListener()
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
      this.uYt = ((FrameLayout)findViewById(2131302131));
      this.uYu = ((ImageView)findViewById(2131302133));
      this.uYv = ((ImageView)findViewById(2131302132));
      this.uYv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67229);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.mall.c.eds();
          Object localObject = RechargeUI.h(RechargeUI.this).uWF;
          ad.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(localObject)));
          if ((!bt.isNullOrNil((String)localObject)) && (paramAnonymousView.AiT.containsKey(localObject)))
          {
            localObject = (MallNews)paramAnonymousView.AiT.get(localObject);
            if ("1".equals(((MallNews)localObject).AiI))
            {
              ((MallNews)localObject).AiI = "2";
              paramAnonymousView.dbD();
            }
          }
          RechargeUI.i(RechargeUI.this).setVisibility(8);
          AppMethodBeat.o(67229);
        }
      });
      this.uYt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67230);
          if (!bt.isNullOrNil(RechargeUI.h(RechargeUI.this).AiC.AiL))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", RechargeUI.h(RechargeUI.this).AiC.AiL);
            paramAnonymousView.putExtra("geta8key_username", com.tencent.mm.model.u.aqG());
            com.tencent.mm.bs.d.b(RechargeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView);
          }
          AppMethodBeat.o(67230);
        }
      });
      this.uYz.setOnInputValidChangeListener(this);
      this.uYz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67231);
          RechargeUI.e(RechargeUI.this).getFocus();
          if (RechargeUI.e(RechargeUI.this).getInputRecord().sourceType == 2) {
            RechargeUI.e(RechargeUI.this).setInput(null);
          }
          if (bt.isNullOrNil(RechargeUI.e(RechargeUI.this).getText().toString())) {
            RechargeUI.e(RechargeUI.this).uXk.showDropDown();
          }
          RechargeUI.this.showVKB();
          AppMethodBeat.o(67231);
        }
      });
      dfI();
      com.tencent.mm.platformtools.u.a(this);
      cE();
      AppMethodBeat.o(67242);
      return;
    }
  }
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67262);
    if (this.uYD == null)
    {
      AppMethodBeat.o(67262);
      return;
    }
    if (paramString.equals(this.uYD)) {
      this.uYu.post(new Runnable()
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
        ad.e("MicroMsg.MallRechargeUI", "uri == null");
        AppMethodBeat.o(67260);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
      {
        ad.e("MicroMsg.MallRechargeUI", "no contact permission");
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
              ad.d("MicroMsg.MallRechargeUI", "username : ".concat(String.valueOf(str1)));
              if (localObject2 == null) {
                break label583;
              }
              ad.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              localObject2 = com.tencent.mm.plugin.recharge.model.b.CD((String)localObject2);
              ad.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject2)) {
                break label580;
              }
              localObject1 = localObject2;
              ad.d("MicroMsg.MallRechargeUI", "phoneResult : ".concat(String.valueOf(localObject1)));
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
        this.uYG.clear();
        this.uYz.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.uYp.setText("");
        this.uYq.setVisibility(4);
        aKT();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.uxy) {
          break;
        }
        ad.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.dfC().a(this.uYz.getInputRecord());
        finish();
        this.uxy = true;
        break;
      }
      ad.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
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
    this.uYa = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ktI = bool;
      if (this.uYa != null) {
        break;
      }
      ad.e("MicroMsg.MallRechargeUI", "function info is null");
      t.makeText(this, "function info is null", 1).show();
      AppMethodBeat.o(67241);
      return;
    }
    if (localArrayList == null)
    {
      ad.d("MicroMsg.MallRechargeUI", "function info : " + this.uYa.dAn);
      m(new e(this.uYa.uWF));
    }
    for (;;)
    {
      ad.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.uYE = com.tencent.mm.plugin.wallet_core.model.mall.c.eds().aua(this.uYa.uWF);
      initView();
      AppMethodBeat.o(67241);
      return;
      this.uYC = a.eE(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67261);
    com.tencent.mm.sdk.b.a.ESL.d(this.uxB);
    super.onDestroy();
    AppMethodBeat.o(67261);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(67254);
    if (!paramBoolean)
    {
      this.uYG.clear();
      this.uYp.setText("");
      this.uYq.setVisibility(4);
    }
    aKT();
    AppMethodBeat.o(67254);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67258);
    super.onPause();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(496, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(497, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(498, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1555, this);
    AppMethodBeat.o(67258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67257);
    super.onResume();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(496, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(497, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(498, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1555, this);
    AppMethodBeat.o(67257);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67256);
    ad.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2);
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
        paramString = paramn.uWR;
        if (paramString != null)
        {
          this.uYC = a.eE(paramString);
          ad.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.uYC);
        }
        this.uYH = paramn.uWS;
        this.uYI = paramn.uWT;
        this.uYJ = paramn.uWU;
        this.uYK = paramn.uWV;
        ad.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(paramString)));
        cE();
        paramn = g(0, paramString);
        paramString = g(2, paramString);
        if (paramn.size() > paramString.size()) {}
        for (paramInt1 = paramn.size();; paramInt1 = paramString.size())
        {
          this.uYB = paramInt1;
          this.uYx.eG(paramn);
          this.uYy.eG(paramString);
          AppMethodBeat.o(67256);
          return;
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        ad.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.uYC);
        paramn = (com.tencent.mm.plugin.recharge.model.d)paramn;
        if ((this.uYC != null) && (this.uYC.dft != null) && (paramn.uWO != null) && (((this.uYC.dft.equals(paramn.uWO.dft)) && (dfT().equals(paramn.ioa))) || (paramn.gOH != 2)))
        {
          MallRechargeProduct.a(paramn.uWO, this.uYC);
          this.uYC.isDefault = true;
          String str = H(paramn.gOH, paramn.uWO.dft, paramn.ioa);
          this.uYG.put(str, Integer.valueOf(1));
          cE();
          this.uYq.setText(paramString);
          this.uYq.setVisibility(0);
          this.uYq.setTextColor(getResources().getColor(2131100468));
        }
        if (paramn.gOH == 2)
        {
          if ((this.uYC == null) || (!this.uYC.dft.equals(paramn.uWQ)) || (!dfT().equals(paramn.ioa))) {
            break label725;
          }
          if ((((avn)paramn.rr.gUT.gUX).Dnm == 0) && (this.uYC.dft.equals(paramn.uWO.dft))) {
            break label682;
          }
          this.iwY.setEnabled(false);
          this.iwY.setClickable(false);
          this.uYq.setText(((avn)paramn.rr.gUT.gUX).Dnn);
          this.uYq.setVisibility(0);
          this.uYq.setTextColor(getResources().getColor(2131100798));
        }
        for (;;)
        {
          eF(paramn.uWP);
          ad.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.uYC);
          AppMethodBeat.o(67256);
          return;
          label682:
          m(new com.tencent.mm.plugin.recharge.model.c(this.uYC.uWF, dfT(), this.uYC.oEN, this.uYC.appId, dfS()));
          continue;
          label725:
          this.iwY.setEnabled(true);
          this.iwY.setClickable(true);
          this.uYq.setText(null);
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        paramString = ((com.tencent.mm.plugin.recharge.model.g)paramn).uXi;
        paramString.dtb = 6;
        paramString.Cop = 100;
        f.a(this, paramString, 2);
        com.tencent.mm.sdk.b.a.ESL.c(this.uxB);
        AppMethodBeat.o(67256);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.c))
      {
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramn;
        if ((this.uYC != null) && (this.uYC.oEN.equals(paramString.oEN)) && (dfT().equals(paramString.dpO)))
        {
          if (((ame)paramString.rr.gUT.gUX).Dnm != 0)
          {
            this.iwY.setEnabled(false);
            this.iwY.setClickable(false);
            this.uYq.setText(((ame)paramString.rr.gUT.gUX).Dnn);
            this.uYq.setVisibility(0);
            this.uYq.setTextColor(getResources().getColor(2131100798));
            AppMethodBeat.o(67256);
          }
        }
        else
        {
          this.iwY.setEnabled(true);
          this.iwY.setClickable(true);
          this.uYq.setText(null);
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
          this.iwY.setEnabled(true);
          this.iwY.setClickable(true);
        }
        for (;;)
        {
          eF(((com.tencent.mm.plugin.recharge.model.d)paramn).uWP);
          this.uYq.setText(paramString);
          this.uYq.setVisibility(0);
          this.uYq.setTextColor(getResources().getColor(2131100798));
          this.uYp.setText(((com.tencent.mm.plugin.recharge.model.d)paramn).uWG);
          this.uYp.setTextColor(getResources().getColor(2131100798));
          AppMethodBeat.o(67256);
          return;
          this.iwY.setEnabled(false);
          this.iwY.setClickable(false);
        }
      }
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
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
    ad.d("MicroMsg.MallRechargeUI", "showVKB");
    this.uYz.setInfoTvImageResource(2131232862);
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
    private List<MallRechargeProduct> uWP = null;
    
    private a() {}
    
    public final void JY(int paramInt)
    {
      AppMethodBeat.i(67234);
      int i = 0;
      while (i < this.uWP.size())
      {
        ((MallRechargeProduct)this.uWP.get(i)).isDefault = false;
        i += 1;
      }
      ((MallRechargeProduct)this.uWP.get(paramInt)).isDefault = true;
      AppMethodBeat.o(67234);
    }
    
    public final MallRechargeProduct JZ(int paramInt)
    {
      AppMethodBeat.i(67236);
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)this.uWP.get(paramInt);
      AppMethodBeat.o(67236);
      return localMallRechargeProduct;
    }
    
    public final void eG(List<MallRechargeProduct> paramList)
    {
      AppMethodBeat.i(67233);
      this.uWP = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(67233);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67235);
      if (this.uWP == null)
      {
        AppMethodBeat.o(67235);
        return 0;
      }
      int i = this.uWP.size();
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
      paramViewGroup = JZ(paramInt);
      paramView.setText(paramViewGroup.oEN);
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
      if (!JZ(paramInt).isValid())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI
 * JD-Core Version:    0.7.0.1
 */