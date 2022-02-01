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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI
  extends MMActivity
  implements i, u.a, MallEditText.b
{
  private TextView BEI;
  private TextView BEJ;
  private TextView BEK;
  private TextView BEL;
  private FrameLayout BEM;
  private ImageView BEN;
  private ImageView BEO;
  private LinearLayout BEP;
  private a BEQ;
  private a BER;
  private MallEditText BES;
  private TextView BET;
  private int BEU;
  private MallRechargeProduct BEV;
  private String BEW;
  private MallNews BEX;
  private boolean BEY;
  private Map<String, Integer> BEZ;
  private MallFunction BEt;
  private String BFa;
  public String BFb;
  private String BFc;
  public String BFd;
  private boolean BaO;
  private IListener BaR;
  private Button krs;
  private boolean mDr;
  protected Dialog tipDialog;
  
  public RechargeUI()
  {
    AppMethodBeat.i(67240);
    this.krs = null;
    this.BEI = null;
    this.BEJ = null;
    this.BEK = null;
    this.BEL = null;
    this.BEM = null;
    this.BEN = null;
    this.BEO = null;
    this.BEP = null;
    this.BEQ = null;
    this.BER = null;
    this.tipDialog = null;
    this.BEt = null;
    this.BEV = null;
    this.BEW = null;
    this.BEX = null;
    this.BaO = false;
    this.BEY = false;
    this.mDr = true;
    this.BEZ = new HashMap();
    this.BaR = new IListener() {};
    AppMethodBeat.o(67240);
  }
  
  private static String L(int paramInt, String paramString1, String paramString2)
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
      paramMallRechargeProduct = getString(2131762947);
      AppMethodBeat.o(67246);
      return paramMallRechargeProduct;
    }
    if ((paramMallRechargeProduct.BDa != paramMallRechargeProduct.BDb) || ((eId()) && (this.BEV.BDf)))
    {
      AppMethodBeat.o(67246);
      return "";
    }
    paramMallRechargeProduct = String.format(getString(2131762950), new Object[] { Float.valueOf(paramMallRechargeProduct.BDa) });
    AppMethodBeat.o(67246);
    return paramMallRechargeProduct;
  }
  
  private boolean bqg()
  {
    AppMethodBeat.i(67249);
    if (!this.BES.eHQ()) {}
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.BEV != null) && (this.BEV.isValid()))
      {
        if ((eId()) && (this.BEV.BDf)) {
          n(new com.tencent.mm.plugin.recharge.model.d(this.BEV.iFf, this.BEt.kHR, this.BEV.productId, this.BEV.appId, eIb(), eIc()));
        }
        hideVKB();
        this.krs.setEnabled(true);
        this.krs.setClickable(true);
        Log.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(67249);
        return true;
      }
      this.krs.setEnabled(false);
      this.krs.setClickable(false);
      Log.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      AppMethodBeat.o(67249);
      return false;
    }
  }
  
  private void eHZ()
  {
    AppMethodBeat.i(67244);
    String str = getString(2131762939);
    if (!TextUtils.isEmpty(this.BFb)) {
      str = this.BFb;
    }
    if (!Util.isNullOrNil(this.BFa)) {
      addTextOptionMenu(0, str, new RechargeUI.18(this));
    }
    AppMethodBeat.o(67244);
  }
  
  private void eIa()
  {
    AppMethodBeat.i(67245);
    if (!Util.isNullOrNil(this.BFc)) {
      this.BEL.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.BFd)) {
        this.BEL.setText(this.BFd);
      }
      AppMethodBeat.o(67245);
      return;
      this.BEL.setVisibility(8);
    }
  }
  
  private String eIb()
  {
    AppMethodBeat.i(67250);
    String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.Ts(this.BES.getText());
    AppMethodBeat.o(67250);
    return str;
  }
  
  private String eIc()
  {
    AppMethodBeat.i(67251);
    String str = com.tencent.mm.plugin.recharge.model.b.Ts(this.BES.getText());
    AppMethodBeat.o(67251);
    return str;
  }
  
  private boolean eId()
  {
    AppMethodBeat.i(67253);
    String str = L(this.BEV.iFf, this.BEV.productId, eIc());
    if (!this.BEZ.containsKey(str))
    {
      AppMethodBeat.o(67253);
      return true;
    }
    AppMethodBeat.o(67253);
    return false;
  }
  
  private void gc(List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.iFf == 2)
        {
          j = i;
          if (this.BEV != null)
          {
            j = i;
            if (localMallRechargeProduct.productId.equals(this.BEV.productId))
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
      this.BER.gd(localArrayList);
      AppMethodBeat.o(67259);
      return;
    }
    this.BER.gd(new ArrayList());
    AppMethodBeat.o(67259);
  }
  
  private void n(q paramq)
  {
    AppMethodBeat.i(67248);
    if ((paramq.getType() == 497) || (paramq.getType() == 1555))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(paramq, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if (!this.mDr)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(paramq, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), true, new RechargeUI.3(this, paramq));
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramq, 0);
    AppMethodBeat.o(67248);
  }
  
  private static List<MallRechargeProduct> q(int paramInt, List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.iFf == paramInt)
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
  
  private void updateView()
  {
    AppMethodBeat.i(67243);
    Log.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.BEV);
    if (this.BEV != null)
    {
      this.BET.setText(this.BEV.rjt);
      this.BEK.setText(a(this.BEV));
    }
    if ((this.BEX != null) && (this.BEt.Icf != null) && (this.BEX.equals(this.BEt.Icf)) && (!"1".equals(this.BEX.Icl)))
    {
      this.BEM.setVisibility(8);
      Log.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.BEX.toString());
      this.BEJ.setVisibility(4);
      if (!bqg()) {
        break label335;
      }
      if ((this.BEV != null) && (!eId()))
      {
        this.BEI.setText(this.BEV.BCZ);
        this.BEI.setTextColor(getResources().getColor(2131100594));
      }
    }
    for (;;)
    {
      eHZ();
      eIa();
      AppMethodBeat.o(67243);
      return;
      if ((this.BEt.Icf != null) && (!Util.isNullOrNil(this.BEt.Icf.Icp)))
      {
        this.BEW = this.BEt.Icf.Icp;
        Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.recharge.b.a(this.BEW));
        this.BEN.setImageBitmap(localBitmap);
        this.BEM.setVisibility(0);
        Log.d("MicroMsg.MallRechargeUI", "Show banner!");
        break;
      }
      this.BEM.setVisibility(8);
      Log.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break;
      label335:
      this.BEI.setText("");
    }
  }
  
  public final void eHR()
  {
    AppMethodBeat.i(67255);
    if ((Util.isNullOrNil(this.BES.getText())) || (this.BES.bql()))
    {
      this.BES.setInfoTvImageResource(2131234625);
      AppMethodBeat.o(67255);
      return;
    }
    this.BES.setInfoTvImageResource(2131233321);
    AppMethodBeat.o(67255);
  }
  
  public int getLayoutId()
  {
    return 2131496054;
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
    setMMTitle(this.BEt.edq);
    Log.v("MicroMsg.MallRechargeUI", "initView");
    setBackBtn(new RechargeUI.1(this));
    this.BEI = ((TextView)findViewById(2131304425));
    this.BEJ = ((TextView)findViewById(2131304473));
    this.BEK = ((TextView)findViewById(2131304475));
    this.krs = ((Button)findViewById(2131305423));
    this.BEP = ((LinearLayout)findViewById(2131304360));
    this.BEL = ((TextView)findViewById(2131304474));
    this.BEL.setOnClickListener(new RechargeUI.11(this));
    this.krs.setOnClickListener(new RechargeUI.12(this));
    this.BES = ((MallEditText)findViewById(2131304363));
    this.BES.setInfoTvOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67227);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (RechargeUI.e(RechargeUI.this).BDE) {
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
    this.BET = ((TextView)findViewById(2131304430));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = q(0, (List)localObject);
    localObject = q(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.BEU = i;
      this.BEQ = new a((byte)0);
      this.BEQ.gd(localList);
      this.BER = new a((byte)0);
      this.BER.gd((List)localObject);
      this.BEP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (((RechargeUI.f(RechargeUI.this) != null) && (RechargeUI.f(RechargeUI.this).getCount() > 0)) || ((RechargeUI.g(RechargeUI.this) != null) && (RechargeUI.g(RechargeUI.this).getCount() > 0))) {
            RechargeUI.this.showDialog(1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67228);
        }
      });
      this.BEM = ((FrameLayout)findViewById(2131304470));
      this.BEN = ((ImageView)findViewById(2131304472));
      this.BEO = ((ImageView)findViewById(2131304471));
      this.BEO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67229);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
          localObject = RechargeUI.h(RechargeUI.this).kHR;
          Log.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(localObject)));
          if ((!Util.isNullOrNil((String)localObject)) && (paramAnonymousView.Icv.containsKey(localObject)))
          {
            localObject = (MallNews)paramAnonymousView.Icv.get(localObject);
            if ("1".equals(((MallNews)localObject).Icl))
            {
              ((MallNews)localObject).Icl = "2";
              paramAnonymousView.eDw();
            }
          }
          RechargeUI.i(RechargeUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67229);
        }
      });
      this.BEM.setOnClickListener(new RechargeUI.16(this));
      this.BES.setOnInputValidChangeListener(this);
      this.BES.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67231);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RechargeUI.e(RechargeUI.this).getFocus();
          if (RechargeUI.e(RechargeUI.this).getInputRecord().sourceType == 2) {
            RechargeUI.e(RechargeUI.this).setInput(null);
          }
          if (Util.isNullOrNil(RechargeUI.e(RechargeUI.this).getText().toString())) {
            RechargeUI.e(RechargeUI.this).BDD.showDropDown();
          }
          RechargeUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67231);
        }
      });
      eHR();
      com.tencent.mm.platformtools.u.a(this);
      updateView();
      AppMethodBeat.o(67242);
      return;
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67262);
    if (this.BEW == null)
    {
      AppMethodBeat.o(67262);
      return;
    }
    if (paramString.equals(this.BEW)) {
      this.BEN.post(new Runnable()
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
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.READ_CONTACTS"))
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
              localObject2 = com.tencent.mm.plugin.recharge.model.b.Ts((String)localObject2);
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
        this.BEZ.clear();
        this.BES.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.BEI.setText("");
        this.BEJ.setVisibility(4);
        bqg();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.BaO) {
          break;
        }
        Log.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.eHL().a(this.BES.getInputRecord());
        finish();
        this.BaO = true;
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
    this.BEt = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mDr = bool;
      if (this.BEt != null) {
        break;
      }
      Log.e("MicroMsg.MallRechargeUI", "function info is null");
      com.tencent.mm.ui.base.u.makeText(this, "function info is null", 1).show();
      AppMethodBeat.o(67241);
      return;
    }
    if (localArrayList == null)
    {
      Log.d("MicroMsg.MallRechargeUI", "function info : " + this.BEt.edq);
      n(new e(this.BEt.kHR));
    }
    for (;;)
    {
      Log.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.BEX = com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVv(this.BEt.kHR);
      initView();
      AppMethodBeat.o(67241);
      return;
      this.BEV = a.gb(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67261);
    EventCenter.instance.removeListener(this.BaR);
    super.onDestroy();
    AppMethodBeat.o(67261);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(67254);
    if (!paramBoolean)
    {
      this.BEZ.clear();
      this.BEI.setText("");
      this.BEJ.setVisibility(4);
    }
    bqg();
    AppMethodBeat.o(67254);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67258);
    super.onPause();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(496, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(497, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(498, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1555, this);
    AppMethodBeat.o(67258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67257);
    super.onResume();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(496, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(497, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(498, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1555, this);
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
        paramString = paramq.BDk;
        if (paramString != null)
        {
          this.BEV = a.gb(paramString);
          Log.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.BEV);
        }
        this.BFa = paramq.BDl;
        this.BFb = paramq.BDm;
        this.BFc = paramq.BDn;
        this.BFd = paramq.BDo;
        Log.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(paramString)));
        updateView();
        paramq = q(0, paramString);
        paramString = q(2, paramString);
        if (paramq.size() > paramString.size()) {}
        for (paramInt1 = paramq.size();; paramInt1 = paramString.size())
        {
          this.BEU = paramInt1;
          this.BEQ.gd(paramq);
          this.BER.gd(paramString);
          AppMethodBeat.o(67256);
          return;
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        Log.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.BEV);
        paramq = (com.tencent.mm.plugin.recharge.model.d)paramq;
        if ((this.BEV != null) && (this.BEV.productId != null) && (paramq.BDh != null) && (((this.BEV.productId.equals(paramq.BDh.productId)) && (eIc().equals(paramq.kik))) || (paramq.iFf != 2)))
        {
          MallRechargeProduct.a(paramq.BDh, this.BEV);
          this.BEV.isDefault = true;
          String str = L(paramq.iFf, paramq.BDh.productId, paramq.kik);
          this.BEZ.put(str, Integer.valueOf(1));
          updateView();
          this.BEJ.setText(paramString);
          this.BEJ.setVisibility(0);
          this.BEJ.setTextColor(getResources().getColor(2131100570));
        }
        if (paramq.iFf == 2)
        {
          if ((this.BEV == null) || (!this.BEV.productId.equals(paramq.BDj)) || (!eIc().equals(paramq.kik))) {
            break label725;
          }
          if ((((bpb)paramq.rr.iLL.iLR).LOv == 0) && (this.BEV.productId.equals(paramq.BDh.productId))) {
            break label682;
          }
          this.krs.setEnabled(false);
          this.krs.setClickable(false);
          this.BEJ.setText(((bpb)paramq.rr.iLL.iLR).LOw);
          this.BEJ.setVisibility(0);
          this.BEJ.setTextColor(getResources().getColor(2131100994));
        }
        for (;;)
        {
          gc(paramq.BDi);
          Log.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.BEV);
          AppMethodBeat.o(67256);
          return;
          label682:
          n(new com.tencent.mm.plugin.recharge.model.c(this.BEV.kHR, eIc(), this.BEV.rjt, this.BEV.appId, eIb()));
          continue;
          label725:
          this.krs.setEnabled(true);
          this.krs.setClickable(true);
          this.BEJ.setText(null);
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        paramString = ((com.tencent.mm.plugin.recharge.model.g)paramq).BDB;
        paramString.dVv = 6;
        paramString.Kxr = 100;
        f.a(this, paramString, 2);
        EventCenter.instance.addListener(this.BaR);
        AppMethodBeat.o(67256);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.recharge.model.c))
      {
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramq;
        if ((this.BEV != null) && (this.BEV.rjt.equals(paramString.rjt)) && (eIc().equals(paramString.dSf)))
        {
          if (((ber)paramString.rr.iLL.iLR).LOv != 0)
          {
            this.krs.setEnabled(false);
            this.krs.setClickable(false);
            this.BEJ.setText(((ber)paramString.rr.iLL.iLR).LOw);
            this.BEJ.setVisibility(0);
            this.BEJ.setTextColor(getResources().getColor(2131100994));
            AppMethodBeat.o(67256);
          }
        }
        else
        {
          this.krs.setEnabled(true);
          this.krs.setClickable(true);
          this.BEJ.setText(null);
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
          this.krs.setEnabled(true);
          this.krs.setClickable(true);
        }
        for (;;)
        {
          gc(((com.tencent.mm.plugin.recharge.model.d)paramq).BDi);
          this.BEJ.setText(paramString);
          this.BEJ.setVisibility(0);
          this.BEJ.setTextColor(getResources().getColor(2131100994));
          this.BEI.setText(((com.tencent.mm.plugin.recharge.model.d)paramq).BCZ);
          this.BEI.setTextColor(getResources().getColor(2131100994));
          AppMethodBeat.o(67256);
          return;
          this.krs.setEnabled(false);
          this.krs.setClickable(false);
        }
      }
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getString(2131768354);
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
    this.BES.setInfoTvImageResource(2131233321);
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
    private List<MallRechargeProduct> BDi = null;
    
    private a() {}
    
    public final void Vr(int paramInt)
    {
      AppMethodBeat.i(67234);
      int i = 0;
      while (i < this.BDi.size())
      {
        ((MallRechargeProduct)this.BDi.get(i)).isDefault = false;
        i += 1;
      }
      ((MallRechargeProduct)this.BDi.get(paramInt)).isDefault = true;
      AppMethodBeat.o(67234);
    }
    
    public final MallRechargeProduct Vs(int paramInt)
    {
      AppMethodBeat.i(67236);
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)this.BDi.get(paramInt);
      AppMethodBeat.o(67236);
      return localMallRechargeProduct;
    }
    
    public final void gd(List<MallRechargeProduct> paramList)
    {
      AppMethodBeat.i(67233);
      this.BDi = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(67233);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67235);
      if (this.BDi == null)
      {
        AppMethodBeat.o(67235);
        return 0;
      }
      int i = this.BDi.size();
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
      paramView = (CheckedTextView)View.inflate(RechargeUI.this, 2131496051, null);
      paramViewGroup = Vs(paramInt);
      paramView.setText(paramViewGroup.rjt);
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
      if (!Vs(paramInt).isValid())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI
 * JD-Core Version:    0.7.0.1
 */