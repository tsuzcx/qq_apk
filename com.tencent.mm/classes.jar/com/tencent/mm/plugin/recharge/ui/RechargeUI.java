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
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI
  extends MMActivity
  implements f, x.a, MallEditText.b
{
  private Button gJr;
  protected Dialog gKM;
  private boolean idp;
  private FrameLayout pWA;
  private ImageView pWB;
  private ImageView pWC;
  private LinearLayout pWD;
  private RechargeUI.a pWE;
  private RechargeUI.a pWF;
  private MallEditText pWG;
  private TextView pWH;
  private int pWI;
  private MallRechargeProduct pWJ;
  private String pWK;
  private MallNews pWL;
  private boolean pWM;
  private Map<String, Integer> pWN;
  private String pWO;
  public String pWP;
  private String pWQ;
  public String pWR;
  private MallFunction pWg;
  private TextView pWw;
  private TextView pWx;
  private TextView pWy;
  private TextView pWz;
  private boolean pvQ;
  private com.tencent.mm.sdk.b.c pvT;
  
  public RechargeUI()
  {
    AppMethodBeat.i(44332);
    this.gJr = null;
    this.pWw = null;
    this.pWx = null;
    this.pWy = null;
    this.pWz = null;
    this.pWA = null;
    this.pWB = null;
    this.pWC = null;
    this.pWD = null;
    this.pWE = null;
    this.pWF = null;
    this.gKM = null;
    this.pWg = null;
    this.pWJ = null;
    this.pWK = null;
    this.pWL = null;
    this.pvQ = false;
    this.pWM = false;
    this.idp = true;
    this.pWN = new HashMap();
    this.pvT = new RechargeUI.10(this);
    AppMethodBeat.o(44332);
  }
  
  private static String A(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(44344);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(44344);
    return paramString1;
  }
  
  private String a(MallRechargeProduct paramMallRechargeProduct)
  {
    AppMethodBeat.i(44338);
    if (!paramMallRechargeProduct.isValid())
    {
      paramMallRechargeProduct = getString(2131301513);
      AppMethodBeat.o(44338);
      return paramMallRechargeProduct;
    }
    if ((paramMallRechargeProduct.pUO != paramMallRechargeProduct.pUP) || ((cfE()) && (this.pWJ.pUT)))
    {
      AppMethodBeat.o(44338);
      return "";
    }
    paramMallRechargeProduct = String.format(getString(2131301516), new Object[] { Float.valueOf(paramMallRechargeProduct.pUO) });
    AppMethodBeat.o(44338);
    return paramMallRechargeProduct;
  }
  
  private boolean asr()
  {
    AppMethodBeat.i(44341);
    if (!this.pWG.cfr()) {}
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.pWJ != null) && (this.pWJ.isValid()))
      {
        if ((cfE()) && (this.pWJ.pUT)) {
          m(new com.tencent.mm.plugin.recharge.model.d(this.pWJ.fnf, this.pWg.pUM, this.pWJ.cqx, this.pWJ.appId, cfC(), cfD()));
        }
        hideVKB();
        this.gJr.setEnabled(true);
        this.gJr.setClickable(true);
        ab.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(44341);
        return true;
      }
      this.gJr.setEnabled(false);
      this.gJr.setClickable(false);
      ab.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      AppMethodBeat.o(44341);
      return false;
    }
  }
  
  private void bJ()
  {
    AppMethodBeat.i(44335);
    ab.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.pWJ);
    if (this.pWJ != null)
    {
      this.pWH.setText(this.pWJ.loz);
      this.pWy.setText(a(this.pWJ));
    }
    if ((this.pWL != null) && (this.pWg.umh != null) && (this.pWL.equals(this.pWg.umh)) && (!"1".equals(this.pWL.umn)))
    {
      this.pWA.setVisibility(8);
      ab.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.pWL.toString());
      this.pWx.setVisibility(4);
      if (!asr()) {
        break label331;
      }
      if ((this.pWJ != null) && (!cfE()))
      {
        this.pWw.setText(this.pWJ.pUN);
        this.pWw.setTextColor(getResources().getColor(2131690168));
      }
    }
    for (;;)
    {
      cfA();
      cfB();
      AppMethodBeat.o(44335);
      return;
      if ((this.pWg.umh != null) && (!bo.isNullOrNil(this.pWg.umh.umr)))
      {
        this.pWK = this.pWg.umh.umr;
        Bitmap localBitmap = x.a(new com.tencent.mm.plugin.recharge.b.a(this.pWK));
        this.pWB.setImageBitmap(localBitmap);
        this.pWA.setVisibility(0);
        ab.d("MicroMsg.MallRechargeUI", "Show banner!");
        break;
      }
      this.pWA.setVisibility(8);
      ab.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break;
      label331:
      this.pWw.setText("");
    }
  }
  
  private void cJ(List<MallRechargeProduct> paramList)
  {
    AppMethodBeat.i(44351);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      int j;
      for (int i = 0; k < paramList.size(); i = j)
      {
        MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)paramList.get(k);
        j = i;
        if (localMallRechargeProduct.fnf == 2)
        {
          j = i;
          if (this.pWJ != null)
          {
            j = i;
            if (localMallRechargeProduct.cqx.equals(this.pWJ.cqx))
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
      this.pWF.cK(localArrayList);
      AppMethodBeat.o(44351);
      return;
    }
    this.pWF.cK(new ArrayList());
    AppMethodBeat.o(44351);
  }
  
  private void cfA()
  {
    AppMethodBeat.i(44336);
    String str = getString(2131301505);
    if (!TextUtils.isEmpty(this.pWP)) {
      str = this.pWP;
    }
    if (!bo.isNullOrNil(this.pWO)) {
      addTextOptionMenu(0, str, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(44324);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", RechargeUI.j(RechargeUI.this));
          com.tencent.mm.bq.d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(44324);
          return true;
        }
      });
    }
    AppMethodBeat.o(44336);
  }
  
  private void cfB()
  {
    AppMethodBeat.i(44337);
    if (!bo.isNullOrNil(this.pWQ)) {
      this.pWz.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.pWR)) {
        this.pWz.setText(this.pWR);
      }
      AppMethodBeat.o(44337);
      return;
      this.pWz.setVisibility(8);
    }
  }
  
  private String cfC()
  {
    AppMethodBeat.i(44342);
    String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.xw(this.pWG.getText());
    AppMethodBeat.o(44342);
    return str;
  }
  
  private String cfD()
  {
    AppMethodBeat.i(44343);
    String str = com.tencent.mm.plugin.recharge.model.b.xw(this.pWG.getText());
    AppMethodBeat.o(44343);
    return str;
  }
  
  private boolean cfE()
  {
    AppMethodBeat.i(44345);
    String str = A(this.pWJ.fnf, this.pWJ.cqx, cfD());
    if (!this.pWN.containsKey(str))
    {
      AppMethodBeat.o(44345);
      return true;
    }
    AppMethodBeat.o(44345);
    return false;
  }
  
  private static List<MallRechargeProduct> f(int paramInt, List<MallRechargeProduct> paramList)
  {
    AppMethodBeat.i(44339);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)paramList.get(i);
        k = j;
        if (localMallRechargeProduct.fnf == paramInt)
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
    AppMethodBeat.o(44339);
    return localArrayList;
  }
  
  private void m(final m paramm)
  {
    AppMethodBeat.i(44340);
    if ((paramm.getType() == 497) || (paramm.getType() == 1555))
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(paramm, 0);
      AppMethodBeat.o(44340);
      return;
    }
    if (!this.idp)
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(paramm, 0);
      AppMethodBeat.o(44340);
      return;
    }
    if ((this.gKM == null) || ((this.gKM != null) && (!this.gKM.isShowing()))) {
      this.gKM = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(44309);
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(paramm);
          AppMethodBeat.o(44309);
        }
      });
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramm, 0);
    AppMethodBeat.o(44340);
  }
  
  public final void cfs()
  {
    AppMethodBeat.i(44347);
    if ((bo.isNullOrNil(this.pWG.getText())) || (this.pWG.asv()))
    {
      this.pWG.setInfoTvImageResource(2130840122);
      AppMethodBeat.o(44347);
      return;
    }
    this.pWG.setInfoTvImageResource(2130839272);
    AppMethodBeat.o(44347);
  }
  
  public int getLayoutId()
  {
    return 2130970536;
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(44356);
    ab.d("MicroMsg.MallRechargeUI", "hideVKB");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(44356);
      return;
    }
    Object localObject = getCurrentFocus();
    if (localObject == null)
    {
      AppMethodBeat.o(44356);
      return;
    }
    localObject = ((View)localObject).getWindowToken();
    if (localObject == null)
    {
      AppMethodBeat.o(44356);
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
    AppMethodBeat.o(44356);
  }
  
  public void initView()
  {
    AppMethodBeat.i(44334);
    setMMTitle(this.pWg.cJt);
    ab.v("MicroMsg.MallRechargeUI", "initView");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(44307);
        RechargeUI.this.hideVKB();
        RechargeUI.this.finish();
        AppMethodBeat.o(44307);
        return true;
      }
    });
    this.pWw = ((TextView)findViewById(2131826834));
    this.pWx = ((TextView)findViewById(2131827103));
    this.pWy = ((TextView)findViewById(2131827102));
    this.gJr = ((Button)findViewById(2131822914));
    this.pWD = ((LinearLayout)findViewById(2131827100));
    this.pWz = ((TextView)findViewById(2131827104));
    this.pWz.setOnClickListener(new RechargeUI.11(this));
    this.gJr.setOnClickListener(new RechargeUI.12(this));
    this.pWG = ((MallEditText)findViewById(2131827099));
    this.pWG.setInfoTvOnClickListener(new RechargeUI.13(this));
    this.pWH = ((TextView)findViewById(2131827101));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = f(0, (List)localObject);
    localObject = f(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.pWI = i;
      this.pWE = new RechargeUI.a(this, (byte)0);
      this.pWE.cK(localList);
      this.pWF = new RechargeUI.a(this, (byte)0);
      this.pWF.cK((List)localObject);
      this.pWD.setOnClickListener(new RechargeUI.14(this));
      this.pWA = ((FrameLayout)findViewById(2131827096));
      this.pWB = ((ImageView)findViewById(2131827097));
      this.pWC = ((ImageView)findViewById(2131827098));
      this.pWC.setOnClickListener(new RechargeUI.15(this));
      this.pWA.setOnClickListener(new RechargeUI.16(this));
      this.pWG.setOnInputValidChangeListener(this);
      this.pWG.setOnClickListener(new RechargeUI.17(this));
      cfs();
      x.a(this);
      bJ();
      AppMethodBeat.o(44334);
      return;
    }
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(44354);
    if (this.pWK == null)
    {
      AppMethodBeat.o(44354);
      return;
    }
    if (paramString.equals(this.pWK)) {
      this.pWB.post(new RechargeUI.9(this, paramBitmap));
    }
    AppMethodBeat.o(44354);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(44352);
    Cursor localCursor1;
    Object localObject2;
    label358:
    label374:
    String str2;
    switch (paramInt1)
    {
    default: 
    case 1: 
      do
      {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(44352);
        return;
      } while (paramInt2 != -1);
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        ab.e("MicroMsg.MallRechargeUI", "uri == null");
        AppMethodBeat.o(44352);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
      {
        ab.e("MicroMsg.MallRechargeUI", "no contact permission");
        AppMethodBeat.o(44352);
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
              ab.d("MicroMsg.MallRechargeUI", "username : ".concat(String.valueOf(str1)));
              if (localObject2 == null) {
                break label575;
              }
              ab.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              localObject2 = com.tencent.mm.plugin.recharge.model.b.xw((String)localObject2);
              ab.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject2)) {
                break label572;
              }
              localObject1 = localObject2;
              ab.d("MicroMsg.MallRechargeUI", "phoneResult : ".concat(String.valueOf(localObject1)));
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
        this.pWN.clear();
        this.pWG.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.pWw.setText("");
        this.pWx.setVisibility(4);
        asr();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.pvQ) {
          break;
        }
        ab.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.cfm().a(this.pWG.getInputRecord());
        finish();
        this.pvQ = true;
        break;
      }
      ab.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
      break;
      label572:
      break label358;
      label575:
      break label374;
      str2 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44333);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.pWg = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.idp = bool;
      if (this.pWg != null) {
        break;
      }
      ab.e("MicroMsg.MallRechargeUI", "function info is null");
      t.makeText(this, "function info is null", 1).show();
      AppMethodBeat.o(44333);
      return;
    }
    if (localArrayList == null)
    {
      ab.d("MicroMsg.MallRechargeUI", "function info : " + this.pWg.cJt);
      m(new e(this.pWg.pUM));
    }
    for (;;)
    {
      ab.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.pWL = com.tencent.mm.plugin.wallet_core.model.mall.c.cUX().afr(this.pWg.pUM);
      initView();
      AppMethodBeat.o(44333);
      return;
      this.pWJ = a.cI(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44353);
    com.tencent.mm.sdk.b.a.ymk.d(this.pvT);
    super.onDestroy();
    AppMethodBeat.o(44353);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(44346);
    if (!paramBoolean)
    {
      this.pWN.clear();
      this.pWw.setText("");
      this.pWx.setVisibility(4);
    }
    asr();
    AppMethodBeat.o(44346);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(44350);
    super.onPause();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(496, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(497, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(498, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1555, this);
    AppMethodBeat.o(44350);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44349);
    super.onResume();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(496, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(497, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(498, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1555, this);
    AppMethodBeat.o(44349);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44348);
    ab.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.gKM != null) && (this.gKM.isShowing()) && (paramm.getType() != 497))
    {
      this.gKM.dismiss();
      this.gKM = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof e))
      {
        paramm = (e)paramm;
        paramString = paramm.pUY;
        if (paramString != null)
        {
          this.pWJ = a.cI(paramString);
          ab.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.pWJ);
        }
        this.pWO = paramm.pUZ;
        this.pWP = paramm.pVa;
        this.pWQ = paramm.pVb;
        this.pWR = paramm.pVc;
        ab.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(paramString)));
        bJ();
        paramm = f(0, paramString);
        paramString = f(2, paramString);
        if (paramm.size() > paramString.size()) {}
        for (paramInt1 = paramm.size();; paramInt1 = paramString.size())
        {
          this.pWI = paramInt1;
          this.pWE.cK(paramm);
          this.pWF.cK(paramString);
          AppMethodBeat.o(44348);
          return;
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        ab.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.pWJ);
        paramm = (com.tencent.mm.plugin.recharge.model.d)paramm;
        if ((this.pWJ != null) && (this.pWJ.cqx != null) && (paramm.pUV != null) && (((this.pWJ.cqx.equals(paramm.pUV.cqx)) && (cfD().equals(paramm.gAF))) || (paramm.fnf != 2)))
        {
          MallRechargeProduct.a(paramm.pUV, this.pWJ);
          this.pWJ.isDefault = true;
          String str = A(paramm.fnf, paramm.pUV.cqx, paramm.gAF);
          this.pWN.put(str, Integer.valueOf(1));
          bJ();
          this.pWx.setText(paramString);
          this.pWx.setVisibility(0);
          this.pWx.setTextColor(getResources().getColor(2131690142));
        }
        if (paramm.fnf == 2)
        {
          if ((this.pWJ == null) || (!this.pWJ.cqx.equals(paramm.pUX)) || (!cfD().equals(paramm.gAF))) {
            break label720;
          }
          if ((((alv)paramm.rr.fsW.fta).wWI == 0) && (this.pWJ.cqx.equals(paramm.pUV.cqx))) {
            break label677;
          }
          this.gJr.setEnabled(false);
          this.gJr.setClickable(false);
          this.pWx.setText(((alv)paramm.rr.fsW.fta).wWJ);
          this.pWx.setVisibility(0);
          this.pWx.setTextColor(getResources().getColor(2131690391));
        }
        for (;;)
        {
          cJ(paramm.pUW);
          ab.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.pWJ);
          AppMethodBeat.o(44348);
          return;
          label677:
          m(new com.tencent.mm.plugin.recharge.model.c(this.pWJ.pUM, cfD(), this.pWJ.loz, this.pWJ.appId, cfC()));
          continue;
          label720:
          this.gJr.setEnabled(true);
          this.gJr.setClickable(true);
          this.pWx.setText(null);
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        paramString = ((com.tencent.mm.plugin.recharge.model.g)paramm).pVo;
        paramString.cCD = 6;
        paramString.wgs = 100;
        com.tencent.mm.pluginsdk.wallet.h.a(this, paramString, 2);
        com.tencent.mm.sdk.b.a.ymk.c(this.pvT);
        AppMethodBeat.o(44348);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.recharge.model.c))
      {
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramm;
        if ((this.pWJ != null) && (this.pWJ.loz.equals(paramString.loz)) && (cfD().equals(paramString.czF)))
        {
          if (((adt)paramString.rr.fsW.fta).wWI != 0)
          {
            this.gJr.setEnabled(false);
            this.gJr.setClickable(false);
            this.pWx.setText(((adt)paramString.rr.fsW.fta).wWJ);
            this.pWx.setVisibility(0);
            this.pWx.setTextColor(getResources().getColor(2131690391));
            AppMethodBeat.o(44348);
          }
        }
        else
        {
          this.gJr.setEnabled(true);
          this.gJr.setClickable(true);
          this.pWx.setText(null);
        }
        AppMethodBeat.o(44348);
      }
    }
    else if (!(paramm instanceof com.tencent.mm.plugin.recharge.model.c))
    {
      if ((paramm instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        if (paramInt2 == 100)
        {
          this.gJr.setEnabled(true);
          this.gJr.setClickable(true);
        }
        for (;;)
        {
          cJ(((com.tencent.mm.plugin.recharge.model.d)paramm).pUW);
          this.pWx.setText(paramString);
          this.pWx.setVisibility(0);
          this.pWx.setTextColor(getResources().getColor(2131690391));
          this.pWw.setText(((com.tencent.mm.plugin.recharge.model.d)paramm).pUN);
          this.pWw.setTextColor(getResources().getColor(2131690391));
          AppMethodBeat.o(44348);
          return;
          this.gJr.setEnabled(false);
          this.gJr.setClickable(false);
        }
      }
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = getString(2131305682);
      }
      com.tencent.mm.ui.base.h.a(this, paramm, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(44348);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void showVKB()
  {
    AppMethodBeat.i(44355);
    ab.d("MicroMsg.MallRechargeUI", "showVKB");
    this.pWG.setInfoTvImageResource(2130839272);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(44355);
      return;
    }
    View localView = getCurrentFocus();
    if (localView == null)
    {
      AppMethodBeat.o(44355);
      return;
    }
    if (localView.getWindowToken() == null)
    {
      AppMethodBeat.o(44355);
      return;
    }
    localInputMethodManager.showSoftInput(localView, 2);
    AppMethodBeat.o(44355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI
 * JD-Core Version:    0.7.0.1
 */