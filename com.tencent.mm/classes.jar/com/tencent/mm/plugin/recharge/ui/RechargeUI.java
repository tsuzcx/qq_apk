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
import com.tencent.mm.g.a.yp;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.bcx;
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
  implements com.tencent.mm.al.f, u.a, MallEditText.b
{
  private Button jqk;
  private boolean lrV;
  protected Dialog tipDialog;
  private com.tencent.mm.sdk.b.c wNB;
  private boolean wNy;
  private TextView xoN;
  private TextView xoO;
  private TextView xoP;
  private TextView xoQ;
  private FrameLayout xoR;
  private ImageView xoS;
  private ImageView xoT;
  private LinearLayout xoU;
  private a xoV;
  private a xoW;
  private MallEditText xoX;
  private TextView xoY;
  private int xoZ;
  private MallFunction xox;
  private MallRechargeProduct xpa;
  private String xpb;
  private MallNews xpc;
  private boolean xpd;
  private Map<String, Integer> xpe;
  private String xpf;
  public String xpg;
  private String xph;
  public String xpi;
  
  public RechargeUI()
  {
    AppMethodBeat.i(67240);
    this.jqk = null;
    this.xoN = null;
    this.xoO = null;
    this.xoP = null;
    this.xoQ = null;
    this.xoR = null;
    this.xoS = null;
    this.xoT = null;
    this.xoU = null;
    this.xoV = null;
    this.xoW = null;
    this.tipDialog = null;
    this.xox = null;
    this.xpa = null;
    this.xpb = null;
    this.xpc = null;
    this.wNy = false;
    this.xpd = false;
    this.lrV = true;
    this.xpe = new HashMap();
    this.wNB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67240);
  }
  
  private static String J(int paramInt, String paramString1, String paramString2)
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
    if ((paramMallRechargeProduct.xne != paramMallRechargeProduct.xnf) || ((dDY()) && (this.xpa.xnj)))
    {
      AppMethodBeat.o(67246);
      return "";
    }
    paramMallRechargeProduct = String.format(getString(2131761163), new Object[] { Float.valueOf(paramMallRechargeProduct.xne) });
    AppMethodBeat.o(67246);
    return paramMallRechargeProduct;
  }
  
  private boolean aUW()
  {
    AppMethodBeat.i(67249);
    if (!this.xoX.dDL()) {}
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.xpa != null) && (this.xpa.isValid()))
      {
        if ((dDY()) && (this.xpa.xnj)) {
          l(new com.tencent.mm.plugin.recharge.model.d(this.xpa.hHz, this.xox.jDb, this.xpa.dok, this.xpa.appId, dDW(), dDX()));
        }
        hideVKB();
        this.jqk.setEnabled(true);
        this.jqk.setClickable(true);
        ad.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(67249);
        return true;
      }
      this.jqk.setEnabled(false);
      this.jqk.setClickable(false);
      ad.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      AppMethodBeat.o(67249);
      return false;
    }
  }
  
  private void dDU()
  {
    AppMethodBeat.i(67244);
    String str = getString(2131761152);
    if (!TextUtils.isEmpty(this.xpg)) {
      str = this.xpg;
    }
    if (!bt.isNullOrNil(this.xpf)) {
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
  
  private void dDV()
  {
    AppMethodBeat.i(67245);
    if (!bt.isNullOrNil(this.xph)) {
      this.xoQ.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.xpi)) {
        this.xoQ.setText(this.xpi);
      }
      AppMethodBeat.o(67245);
      return;
      this.xoQ.setVisibility(8);
    }
  }
  
  private String dDW()
  {
    AppMethodBeat.i(67250);
    String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.JV(this.xoX.getText());
    AppMethodBeat.o(67250);
    return str;
  }
  
  private String dDX()
  {
    AppMethodBeat.i(67251);
    String str = com.tencent.mm.plugin.recharge.model.b.JV(this.xoX.getText());
    AppMethodBeat.o(67251);
    return str;
  }
  
  private boolean dDY()
  {
    AppMethodBeat.i(67253);
    String str = J(this.xpa.hHz, this.xpa.dok, dDX());
    if (!this.xpe.containsKey(str))
    {
      AppMethodBeat.o(67253);
      return true;
    }
    AppMethodBeat.o(67253);
    return false;
  }
  
  private void eY(List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.hHz == 2)
        {
          j = i;
          if (this.xpa != null)
          {
            j = i;
            if (localMallRechargeProduct.dok.equals(this.xpa.dok))
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
      this.xoW.eZ(localArrayList);
      AppMethodBeat.o(67259);
      return;
    }
    this.xoW.eZ(new ArrayList());
    AppMethodBeat.o(67259);
  }
  
  private static List<MallRechargeProduct> k(int paramInt, List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.hHz == paramInt)
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
  
  private void l(final n paramn)
  {
    AppMethodBeat.i(67248);
    if ((paramn.getType() == 497) || (paramn.getType() == 1555))
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(paramn, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if (!this.lrV)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(paramn, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(67218);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(paramn);
          AppMethodBeat.o(67218);
        }
      });
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramn, 0);
    AppMethodBeat.o(67248);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(67243);
    ad.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.xpa);
    if (this.xpa != null)
    {
      this.xoY.setText(this.xpa.pLO);
      this.xoP.setText(a(this.xpa));
    }
    if ((this.xpc != null) && (this.xox.Dbp != null) && (this.xpc.equals(this.xox.Dbp)) && (!"1".equals(this.xpc.Dbv)))
    {
      this.xoR.setVisibility(8);
      ad.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.xpc.toString());
      this.xoO.setVisibility(4);
      if (!aUW()) {
        break label335;
      }
      if ((this.xpa != null) && (!dDY()))
      {
        this.xoN.setText(this.xpa.xnd);
        this.xoN.setTextColor(getResources().getColor(2131100490));
      }
    }
    for (;;)
    {
      dDU();
      dDV();
      AppMethodBeat.o(67243);
      return;
      if ((this.xox.Dbp != null) && (!bt.isNullOrNil(this.xox.Dbp.Dbz)))
      {
        this.xpb = this.xox.Dbp.Dbz;
        Bitmap localBitmap = u.a(new com.tencent.mm.plugin.recharge.b.a(this.xpb));
        this.xoS.setImageBitmap(localBitmap);
        this.xoR.setVisibility(0);
        ad.d("MicroMsg.MallRechargeUI", "Show banner!");
        break;
      }
      this.xoR.setVisibility(8);
      ad.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break;
      label335:
      this.xoN.setText("");
    }
  }
  
  public final void dDM()
  {
    AppMethodBeat.i(67255);
    if ((bt.isNullOrNil(this.xoX.getText())) || (this.xoX.aVa()))
    {
      this.xoX.setInfoTvImageResource(2131233803);
      AppMethodBeat.o(67255);
      return;
    }
    this.xoX.setInfoTvImageResource(2131232862);
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
    setMMTitle(this.xox.dKm);
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
    this.xoN = ((TextView)findViewById(2131302086));
    this.xoO = ((TextView)findViewById(2131302134));
    this.xoP = ((TextView)findViewById(2131302136));
    this.jqk = ((Button)findViewById(2131302852));
    this.xoU = ((LinearLayout)findViewById(2131302021));
    this.xoQ = ((TextView)findViewById(2131302135));
    this.xoQ.setOnClickListener(new RechargeUI.11(this));
    this.jqk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((RechargeUI.b(RechargeUI.this)) && (RechargeUI.c(RechargeUI.this))) {
          RechargeUI.d(RechargeUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67226);
      }
    });
    this.xoX = ((MallEditText)findViewById(2131302024));
    this.xoX.setInfoTvOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67227);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (RechargeUI.e(RechargeUI.this).xnI) {
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
    this.xoY = ((TextView)findViewById(2131302091));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = k(0, (List)localObject);
    localObject = k(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.xoZ = i;
      this.xoV = new a((byte)0);
      this.xoV.eZ(localList);
      this.xoW = new a((byte)0);
      this.xoW.eZ((List)localObject);
      this.xoU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (((RechargeUI.f(RechargeUI.this) != null) && (RechargeUI.f(RechargeUI.this).getCount() > 0)) || ((RechargeUI.g(RechargeUI.this) != null) && (RechargeUI.g(RechargeUI.this).getCount() > 0))) {
            RechargeUI.this.showDialog(1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67228);
        }
      });
      this.xoR = ((FrameLayout)findViewById(2131302131));
      this.xoS = ((ImageView)findViewById(2131302133));
      this.xoT = ((ImageView)findViewById(2131302132));
      this.xoT.setOnClickListener(new RechargeUI.15(this));
      this.xoR.setOnClickListener(new RechargeUI.16(this));
      this.xoX.setOnInputValidChangeListener(this);
      this.xoX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67231);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          RechargeUI.e(RechargeUI.this).getFocus();
          if (RechargeUI.e(RechargeUI.this).getInputRecord().sourceType == 2) {
            RechargeUI.e(RechargeUI.this).setInput(null);
          }
          if (bt.isNullOrNil(RechargeUI.e(RechargeUI.this).getText().toString())) {
            RechargeUI.e(RechargeUI.this).xnH.showDropDown();
          }
          RechargeUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67231);
        }
      });
      dDM();
      u.a(this);
      updateView();
      AppMethodBeat.o(67242);
      return;
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67262);
    if (this.xpb == null)
    {
      AppMethodBeat.o(67262);
      return;
    }
    if (paramString.equals(this.xpb)) {
      this.xoS.post(new Runnable()
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
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.READ_CONTACTS"))
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
              localObject2 = com.tencent.mm.plugin.recharge.model.b.JV((String)localObject2);
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
        this.xpe.clear();
        this.xoX.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.xoN.setText("");
        this.xoO.setVisibility(4);
        aUW();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.wNy) {
          break;
        }
        ad.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.dDG().a(this.xoX.getInputRecord());
        finish();
        this.wNy = true;
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
    this.xox = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.lrV = bool;
      if (this.xox != null) {
        break;
      }
      ad.e("MicroMsg.MallRechargeUI", "function info is null");
      t.makeText(this, "function info is null", 1).show();
      AppMethodBeat.o(67241);
      return;
    }
    if (localArrayList == null)
    {
      ad.d("MicroMsg.MallRechargeUI", "function info : " + this.xox.dKm);
      l(new e(this.xox.jDb));
    }
    for (;;)
    {
      ad.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.xpc = com.tencent.mm.plugin.wallet_core.model.mall.c.eGT().aEC(this.xox.jDb);
      initView();
      AppMethodBeat.o(67241);
      return;
      this.xpa = a.eX(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67261);
    com.tencent.mm.sdk.b.a.IbL.d(this.wNB);
    super.onDestroy();
    AppMethodBeat.o(67261);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(67254);
    if (!paramBoolean)
    {
      this.xpe.clear();
      this.xoN.setText("");
      this.xoO.setVisibility(4);
    }
    aUW();
    AppMethodBeat.o(67254);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67258);
    super.onPause();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(496, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(497, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(498, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1555, this);
    AppMethodBeat.o(67258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67257);
    super.onResume();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(496, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(497, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(498, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1555, this);
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
        paramString = paramn.xno;
        if (paramString != null)
        {
          this.xpa = a.eX(paramString);
          ad.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.xpa);
        }
        this.xpf = paramn.xnp;
        this.xpg = paramn.xnq;
        this.xph = paramn.xnr;
        this.xpi = paramn.xns;
        ad.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(paramString)));
        updateView();
        paramn = k(0, paramString);
        paramString = k(2, paramString);
        if (paramn.size() > paramString.size()) {}
        for (paramInt1 = paramn.size();; paramInt1 = paramString.size())
        {
          this.xoZ = paramInt1;
          this.xoV.eZ(paramn);
          this.xoW.eZ(paramString);
          AppMethodBeat.o(67256);
          return;
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        ad.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.xpa);
        paramn = (com.tencent.mm.plugin.recharge.model.d)paramn;
        if ((this.xpa != null) && (this.xpa.dok != null) && (paramn.xnl != null) && (((this.xpa.dok.equals(paramn.xnl.dok)) && (dDX().equals(paramn.jhp))) || (paramn.hHz != 2)))
        {
          MallRechargeProduct.a(paramn.xnl, this.xpa);
          this.xpa.isDefault = true;
          String str = J(paramn.hHz, paramn.xnl.dok, paramn.jhp);
          this.xpe.put(str, Integer.valueOf(1));
          updateView();
          this.xoO.setText(paramString);
          this.xoO.setVisibility(0);
          this.xoO.setTextColor(getResources().getColor(2131100468));
        }
        if (paramn.hHz == 2)
        {
          if ((this.xpa == null) || (!this.xpa.dok.equals(paramn.xnn)) || (!dDX().equals(paramn.jhp))) {
            break label725;
          }
          if ((((bcx)paramn.rr.hNL.hNQ).Grd == 0) && (this.xpa.dok.equals(paramn.xnl.dok))) {
            break label682;
          }
          this.jqk.setEnabled(false);
          this.jqk.setClickable(false);
          this.xoO.setText(((bcx)paramn.rr.hNL.hNQ).Gre);
          this.xoO.setVisibility(0);
          this.xoO.setTextColor(getResources().getColor(2131100798));
        }
        for (;;)
        {
          eY(paramn.xnm);
          ad.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.xpa);
          AppMethodBeat.o(67256);
          return;
          label682:
          l(new com.tencent.mm.plugin.recharge.model.c(this.xpa.jDb, dDX(), this.xpa.pLO, this.xpa.appId, dDW()));
          continue;
          label725:
          this.jqk.setEnabled(true);
          this.jqk.setClickable(true);
          this.xoO.setText(null);
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        paramString = ((com.tencent.mm.plugin.recharge.model.g)paramn).xnF;
        paramString.dCC = 6;
        paramString.FlP = 100;
        com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 2);
        com.tencent.mm.sdk.b.a.IbL.c(this.wNB);
        AppMethodBeat.o(67256);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.c))
      {
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramn;
        if ((this.xpa != null) && (this.xpa.pLO.equals(paramString.pLO)) && (dDX().equals(paramString.dzn)))
        {
          if (((atb)paramString.rr.hNL.hNQ).Grd != 0)
          {
            this.jqk.setEnabled(false);
            this.jqk.setClickable(false);
            this.xoO.setText(((atb)paramString.rr.hNL.hNQ).Gre);
            this.xoO.setVisibility(0);
            this.xoO.setTextColor(getResources().getColor(2131100798));
            AppMethodBeat.o(67256);
          }
        }
        else
        {
          this.jqk.setEnabled(true);
          this.jqk.setClickable(true);
          this.xoO.setText(null);
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
          this.jqk.setEnabled(true);
          this.jqk.setClickable(true);
        }
        for (;;)
        {
          eY(((com.tencent.mm.plugin.recharge.model.d)paramn).xnm);
          this.xoO.setText(paramString);
          this.xoO.setVisibility(0);
          this.xoO.setTextColor(getResources().getColor(2131100798));
          this.xoN.setText(((com.tencent.mm.plugin.recharge.model.d)paramn).xnd);
          this.xoN.setTextColor(getResources().getColor(2131100798));
          AppMethodBeat.o(67256);
          return;
          this.jqk.setEnabled(false);
          this.jqk.setClickable(false);
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
    this.xoX.setInfoTvImageResource(2131232862);
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
    private List<MallRechargeProduct> xnm = null;
    
    private a() {}
    
    public final void Nw(int paramInt)
    {
      AppMethodBeat.i(67234);
      int i = 0;
      while (i < this.xnm.size())
      {
        ((MallRechargeProduct)this.xnm.get(i)).isDefault = false;
        i += 1;
      }
      ((MallRechargeProduct)this.xnm.get(paramInt)).isDefault = true;
      AppMethodBeat.o(67234);
    }
    
    public final MallRechargeProduct Nx(int paramInt)
    {
      AppMethodBeat.i(67236);
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)this.xnm.get(paramInt);
      AppMethodBeat.o(67236);
      return localMallRechargeProduct;
    }
    
    public final void eZ(List<MallRechargeProduct> paramList)
    {
      AppMethodBeat.i(67233);
      this.xnm = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(67233);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67235);
      if (this.xnm == null)
      {
        AppMethodBeat.o(67235);
        return 0;
      }
      int i = this.xnm.size();
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
      paramViewGroup = Nx(paramInt);
      paramView.setText(paramViewGroup.pLO);
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
      if (!Nx(paramInt).isValid())
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