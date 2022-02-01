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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bdn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI
  extends MMActivity
  implements com.tencent.mm.ak.f, u.a, MallEditText.b
{
  private Button jtd;
  private boolean lwv;
  protected Dialog tipDialog;
  private TextView xEK;
  private TextView xEL;
  private TextView xEM;
  private TextView xEN;
  private FrameLayout xEO;
  private ImageView xEP;
  private ImageView xEQ;
  private LinearLayout xER;
  private a xES;
  private a xET;
  private MallEditText xEU;
  private TextView xEV;
  private int xEW;
  private MallRechargeProduct xEX;
  private String xEY;
  private MallNews xEZ;
  private MallFunction xEu;
  private boolean xFa;
  private Map<String, Integer> xFb;
  private String xFc;
  public String xFd;
  private String xFe;
  public String xFf;
  private boolean xdm;
  private com.tencent.mm.sdk.b.c xdp;
  
  public RechargeUI()
  {
    AppMethodBeat.i(67240);
    this.jtd = null;
    this.xEK = null;
    this.xEL = null;
    this.xEM = null;
    this.xEN = null;
    this.xEO = null;
    this.xEP = null;
    this.xEQ = null;
    this.xER = null;
    this.xES = null;
    this.xET = null;
    this.tipDialog = null;
    this.xEu = null;
    this.xEX = null;
    this.xEY = null;
    this.xEZ = null;
    this.xdm = false;
    this.xFa = false;
    this.lwv = true;
    this.xFb = new HashMap();
    this.xdp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67240);
  }
  
  private static String I(int paramInt, String paramString1, String paramString2)
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
    if ((paramMallRechargeProduct.xDb != paramMallRechargeProduct.xDc) || ((dHp()) && (this.xEX.xDg)))
    {
      AppMethodBeat.o(67246);
      return "";
    }
    paramMallRechargeProduct = String.format(getString(2131761163), new Object[] { Float.valueOf(paramMallRechargeProduct.xDb) });
    AppMethodBeat.o(67246);
    return paramMallRechargeProduct;
  }
  
  private boolean aVv()
  {
    AppMethodBeat.i(67249);
    if (!this.xEU.dHc()) {}
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (this.xEX != null) && (this.xEX.isValid()))
      {
        if ((dHp()) && (this.xEX.xDg)) {
          l(new com.tencent.mm.plugin.recharge.model.d(this.xEX.hKr, this.xEu.jFZ, this.xEX.dpp, this.xEX.appId, dHn(), dHo()));
        }
        hideVKB();
        this.jtd.setEnabled(true);
        this.jtd.setClickable(true);
        ae.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(67249);
        return true;
      }
      this.jtd.setEnabled(false);
      this.jtd.setClickable(false);
      ae.d("MicroMsg.MallRechargeUI", "checkInfo : false");
      AppMethodBeat.o(67249);
      return false;
    }
  }
  
  private void dHl()
  {
    AppMethodBeat.i(67244);
    String str = getString(2131761152);
    if (!TextUtils.isEmpty(this.xFd)) {
      str = this.xFd;
    }
    if (!bu.isNullOrNil(this.xFc)) {
      addTextOptionMenu(0, str, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67232);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", RechargeUI.j(RechargeUI.this));
          com.tencent.mm.br.d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(67232);
          return true;
        }
      });
    }
    AppMethodBeat.o(67244);
  }
  
  private void dHm()
  {
    AppMethodBeat.i(67245);
    if (!bu.isNullOrNil(this.xFe)) {
      this.xEN.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.xFf)) {
        this.xEN.setText(this.xFf);
      }
      AppMethodBeat.o(67245);
      return;
      this.xEN.setVisibility(8);
    }
  }
  
  private String dHn()
  {
    AppMethodBeat.i(67250);
    String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.Ku(this.xEU.getText());
    AppMethodBeat.o(67250);
    return str;
  }
  
  private String dHo()
  {
    AppMethodBeat.i(67251);
    String str = com.tencent.mm.plugin.recharge.model.b.Ku(this.xEU.getText());
    AppMethodBeat.o(67251);
    return str;
  }
  
  private boolean dHp()
  {
    AppMethodBeat.i(67253);
    String str = I(this.xEX.hKr, this.xEX.dpp, dHo());
    if (!this.xFb.containsKey(str))
    {
      AppMethodBeat.o(67253);
      return true;
    }
    AppMethodBeat.o(67253);
    return false;
  }
  
  private void fg(List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.hKr == 2)
        {
          j = i;
          if (this.xEX != null)
          {
            j = i;
            if (localMallRechargeProduct.dpp.equals(this.xEX.dpp))
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
      this.xET.fh(localArrayList);
      AppMethodBeat.o(67259);
      return;
    }
    this.xET.fh(new ArrayList());
    AppMethodBeat.o(67259);
  }
  
  private static List<MallRechargeProduct> l(int paramInt, List<MallRechargeProduct> paramList)
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
        if (localMallRechargeProduct.hKr == paramInt)
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
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramn, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if (!this.lwv)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramn, 0);
      AppMethodBeat.o(67248);
      return;
    }
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(67218);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramn);
          AppMethodBeat.o(67218);
        }
      });
    }
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramn, 0);
    AppMethodBeat.o(67248);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(67243);
    ae.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.xEX);
    if (this.xEX != null)
    {
      this.xEV.setText(this.xEX.pSt);
      this.xEM.setText(a(this.xEX));
    }
    if ((this.xEZ != null) && (this.xEu.DsT != null) && (this.xEZ.equals(this.xEu.DsT)) && (!"1".equals(this.xEZ.DsZ)))
    {
      this.xEO.setVisibility(8);
      ae.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.xEZ.toString());
      this.xEL.setVisibility(4);
      if (!aVv()) {
        break label335;
      }
      if ((this.xEX != null) && (!dHp()))
      {
        this.xEK.setText(this.xEX.xDa);
        this.xEK.setTextColor(getResources().getColor(2131100490));
      }
    }
    for (;;)
    {
      dHl();
      dHm();
      AppMethodBeat.o(67243);
      return;
      if ((this.xEu.DsT != null) && (!bu.isNullOrNil(this.xEu.DsT.Dtd)))
      {
        this.xEY = this.xEu.DsT.Dtd;
        Bitmap localBitmap = u.a(new com.tencent.mm.plugin.recharge.b.a(this.xEY));
        this.xEP.setImageBitmap(localBitmap);
        this.xEO.setVisibility(0);
        ae.d("MicroMsg.MallRechargeUI", "Show banner!");
        break;
      }
      this.xEO.setVisibility(8);
      ae.d("MicroMsg.MallRechargeUI", "dismiss banner!");
      break;
      label335:
      this.xEK.setText("");
    }
  }
  
  public final void dHd()
  {
    AppMethodBeat.i(67255);
    if ((bu.isNullOrNil(this.xEU.getText())) || (this.xEU.aVz()))
    {
      this.xEU.setInfoTvImageResource(2131233803);
      AppMethodBeat.o(67255);
      return;
    }
    this.xEU.setInfoTvImageResource(2131232862);
    AppMethodBeat.o(67255);
  }
  
  public int getLayoutId()
  {
    return 2131495211;
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(67264);
    ae.d("MicroMsg.MallRechargeUI", "hideVKB");
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
    setMMTitle(this.xEu.dLB);
    ae.v("MicroMsg.MallRechargeUI", "initView");
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
    this.xEK = ((TextView)findViewById(2131302086));
    this.xEL = ((TextView)findViewById(2131302134));
    this.xEM = ((TextView)findViewById(2131302136));
    this.jtd = ((Button)findViewById(2131302852));
    this.xER = ((LinearLayout)findViewById(2131302021));
    this.xEN = ((TextView)findViewById(2131302135));
    this.xEN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67225);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", RechargeUI.a(RechargeUI.this));
        com.tencent.mm.br.d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67225);
      }
    });
    this.jtd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((RechargeUI.b(RechargeUI.this)) && (RechargeUI.c(RechargeUI.this))) {
          RechargeUI.d(RechargeUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67226);
      }
    });
    this.xEU = ((MallEditText)findViewById(2131302024));
    this.xEU.setInfoTvOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67227);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (RechargeUI.e(RechargeUI.this).xDF) {
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
    this.xEV = ((TextView)findViewById(2131302091));
    Object localObject = getIntent().getParcelableArrayListExtra("key_product_list");
    List localList = l(0, (List)localObject);
    localObject = l(2, (List)localObject);
    if (localList.size() > ((List)localObject).size()) {}
    for (int i = localList.size();; i = ((List)localObject).size())
    {
      this.xEW = i;
      this.xES = new a((byte)0);
      this.xES.fh(localList);
      this.xET = new a((byte)0);
      this.xET.fh((List)localObject);
      this.xER.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (((RechargeUI.f(RechargeUI.this) != null) && (RechargeUI.f(RechargeUI.this).getCount() > 0)) || ((RechargeUI.g(RechargeUI.this) != null) && (RechargeUI.g(RechargeUI.this).getCount() > 0))) {
            RechargeUI.this.showDialog(1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67228);
        }
      });
      this.xEO = ((FrameLayout)findViewById(2131302131));
      this.xEP = ((ImageView)findViewById(2131302133));
      this.xEQ = ((ImageView)findViewById(2131302132));
      this.xEQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67229);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.mall.c.eKB();
          localObject = RechargeUI.h(RechargeUI.this).jFZ;
          ae.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(localObject)));
          if ((!bu.isNullOrNil((String)localObject)) && (paramAnonymousView.Dtk.containsKey(localObject)))
          {
            localObject = (MallNews)paramAnonymousView.Dtk.get(localObject);
            if ("1".equals(((MallNews)localObject).DsZ))
            {
              ((MallNews)localObject).DsZ = "2";
              paramAnonymousView.dDe();
            }
          }
          RechargeUI.i(RechargeUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67229);
        }
      });
      this.xEO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67230);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!bu.isNullOrNil(RechargeUI.h(RechargeUI.this).DsT.Dtc))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", RechargeUI.h(RechargeUI.this).DsT.Dtc);
            paramAnonymousView.putExtra("geta8key_username", v.aAC());
            com.tencent.mm.br.d.b(RechargeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67230);
        }
      });
      this.xEU.setOnInputValidChangeListener(this);
      this.xEU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67231);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RechargeUI.e(RechargeUI.this).getFocus();
          if (RechargeUI.e(RechargeUI.this).getInputRecord().sourceType == 2) {
            RechargeUI.e(RechargeUI.this).setInput(null);
          }
          if (bu.isNullOrNil(RechargeUI.e(RechargeUI.this).getText().toString())) {
            RechargeUI.e(RechargeUI.this).xDE.showDropDown();
          }
          RechargeUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67231);
        }
      });
      dHd();
      u.a(this);
      updateView();
      AppMethodBeat.o(67242);
      return;
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67262);
    if (this.xEY == null)
    {
      AppMethodBeat.o(67262);
      return;
    }
    if (paramString.equals(this.xEY)) {
      this.xEP.post(new Runnable()
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
        ae.e("MicroMsg.MallRechargeUI", "uri == null");
        AppMethodBeat.o(67260);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.READ_CONTACTS"))
      {
        ae.e("MicroMsg.MallRechargeUI", "no contact permission");
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
              ae.d("MicroMsg.MallRechargeUI", "username : ".concat(String.valueOf(str1)));
              if (localObject2 == null) {
                break label583;
              }
              ae.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              localObject2 = com.tencent.mm.plugin.recharge.model.b.Ku((String)localObject2);
              ae.d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(localObject2)));
              if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject2)) {
                break label580;
              }
              localObject1 = localObject2;
              ae.d("MicroMsg.MallRechargeUI", "phoneResult : ".concat(String.valueOf(localObject1)));
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
        this.xFb.clear();
        this.xEU.setInput(new com.tencent.mm.plugin.recharge.model.a((String)localObject1, str2, 1));
        this.xEK.setText("");
        this.xEL.setVisibility(4);
        aVv();
        break;
      }
      showDialog(2);
      break;
      if (paramInt2 == -1)
      {
        if (this.xdm) {
          break;
        }
        ae.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
        com.tencent.mm.plugin.recharge.a.a.dGX().a(this.xEU.getInputRecord());
        finish();
        this.xdm = true;
        break;
      }
      ae.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
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
    this.xEu = ((MallFunction)paramBundle.getParcelableExtra("key_func_info"));
    ArrayList localArrayList = paramBundle.getParcelableArrayListExtra("key_product_list");
    if (!paramBundle.getBooleanExtra("key_is_hide_progress", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.lwv = bool;
      if (this.xEu != null) {
        break;
      }
      ae.e("MicroMsg.MallRechargeUI", "function info is null");
      t.makeText(this, "function info is null", 1).show();
      AppMethodBeat.o(67241);
      return;
    }
    if (localArrayList == null)
    {
      ae.d("MicroMsg.MallRechargeUI", "function info : " + this.xEu.dLB);
      l(new e(this.xEu.jFZ));
    }
    for (;;)
    {
      ae.i("MicroMsg.MallRechargeUI", "onCreate()");
      this.xEZ = com.tencent.mm.plugin.wallet_core.model.mall.c.eKB().aFW(this.xEu.jFZ);
      initView();
      AppMethodBeat.o(67241);
      return;
      this.xEX = a.ff(localArrayList);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67261);
    com.tencent.mm.sdk.b.a.IvT.d(this.xdp);
    super.onDestroy();
    AppMethodBeat.o(67261);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(67254);
    if (!paramBoolean)
    {
      this.xFb.clear();
      this.xEK.setText("");
      this.xEL.setVisibility(4);
    }
    aVv();
    AppMethodBeat.o(67254);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67258);
    super.onPause();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(496, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(497, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(498, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1555, this);
    AppMethodBeat.o(67258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67257);
    super.onResume();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(496, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(497, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(498, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1555, this);
    AppMethodBeat.o(67257);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67256);
    ae.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2);
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
        paramString = paramn.xDl;
        if (paramString != null)
        {
          this.xEX = a.ff(paramString);
          ae.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.xEX);
        }
        this.xFc = paramn.xDm;
        this.xFd = paramn.xDn;
        this.xFe = paramn.xDo;
        this.xFf = paramn.xDp;
        ae.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(paramString)));
        updateView();
        paramn = l(0, paramString);
        paramString = l(2, paramString);
        if (paramn.size() > paramString.size()) {}
        for (paramInt1 = paramn.size();; paramInt1 = paramString.size())
        {
          this.xEW = paramInt1;
          this.xES.fh(paramn);
          this.xET.fh(paramString);
          AppMethodBeat.o(67256);
          return;
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.d))
      {
        ae.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.xEX);
        paramn = (com.tencent.mm.plugin.recharge.model.d)paramn;
        if ((this.xEX != null) && (this.xEX.dpp != null) && (paramn.xDi != null) && (((this.xEX.dpp.equals(paramn.xDi.dpp)) && (dHo().equals(paramn.jki))) || (paramn.hKr != 2)))
        {
          MallRechargeProduct.a(paramn.xDi, this.xEX);
          this.xEX.isDefault = true;
          String str = I(paramn.hKr, paramn.xDi.dpp, paramn.jki);
          this.xFb.put(str, Integer.valueOf(1));
          updateView();
          this.xEL.setText(paramString);
          this.xEL.setVisibility(0);
          this.xEL.setTextColor(getResources().getColor(2131100468));
        }
        if (paramn.hKr == 2)
        {
          if ((this.xEX == null) || (!this.xEX.dpp.equals(paramn.xDk)) || (!dHo().equals(paramn.jki))) {
            break label725;
          }
          if ((((bdn)paramn.rr.hQE.hQJ).GKB == 0) && (this.xEX.dpp.equals(paramn.xDi.dpp))) {
            break label682;
          }
          this.jtd.setEnabled(false);
          this.jtd.setClickable(false);
          this.xEL.setText(((bdn)paramn.rr.hQE.hQJ).GKC);
          this.xEL.setVisibility(0);
          this.xEL.setTextColor(getResources().getColor(2131100798));
        }
        for (;;)
        {
          fg(paramn.xDj);
          ae.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.xEX);
          AppMethodBeat.o(67256);
          return;
          label682:
          l(new com.tencent.mm.plugin.recharge.model.c(this.xEX.jFZ, dHo(), this.xEX.pSt, this.xEX.appId, dHn()));
          continue;
          label725:
          this.jtd.setEnabled(true);
          this.jtd.setClickable(true);
          this.xEL.setText(null);
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.g))
      {
        paramString = ((com.tencent.mm.plugin.recharge.model.g)paramn).xDC;
        paramString.dDH = 6;
        paramString.FEn = 100;
        com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 2);
        com.tencent.mm.sdk.b.a.IvT.c(this.xdp);
        AppMethodBeat.o(67256);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.recharge.model.c))
      {
        paramString = (com.tencent.mm.plugin.recharge.model.c)paramn;
        if ((this.xEX != null) && (this.xEX.pSt.equals(paramString.pSt)) && (dHo().equals(paramString.dAs)))
        {
          if (((atr)paramString.rr.hQE.hQJ).GKB != 0)
          {
            this.jtd.setEnabled(false);
            this.jtd.setClickable(false);
            this.xEL.setText(((atr)paramString.rr.hQE.hQJ).GKC);
            this.xEL.setVisibility(0);
            this.xEL.setTextColor(getResources().getColor(2131100798));
            AppMethodBeat.o(67256);
          }
        }
        else
        {
          this.jtd.setEnabled(true);
          this.jtd.setClickable(true);
          this.xEL.setText(null);
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
          this.jtd.setEnabled(true);
          this.jtd.setClickable(true);
        }
        for (;;)
        {
          fg(((com.tencent.mm.plugin.recharge.model.d)paramn).xDj);
          this.xEL.setText(paramString);
          this.xEL.setVisibility(0);
          this.xEL.setTextColor(getResources().getColor(2131100798));
          this.xEK.setText(((com.tencent.mm.plugin.recharge.model.d)paramn).xDa);
          this.xEK.setTextColor(getResources().getColor(2131100798));
          AppMethodBeat.o(67256);
          return;
          this.jtd.setEnabled(false);
          this.jtd.setClickable(false);
        }
      }
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = getString(2131765901);
      }
      com.tencent.mm.ui.base.h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
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
    ae.d("MicroMsg.MallRechargeUI", "showVKB");
    this.xEU.setInfoTvImageResource(2131232862);
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
    private List<MallRechargeProduct> xDj = null;
    
    private a() {}
    
    public final void Oc(int paramInt)
    {
      AppMethodBeat.i(67234);
      int i = 0;
      while (i < this.xDj.size())
      {
        ((MallRechargeProduct)this.xDj.get(i)).isDefault = false;
        i += 1;
      }
      ((MallRechargeProduct)this.xDj.get(paramInt)).isDefault = true;
      AppMethodBeat.o(67234);
    }
    
    public final MallRechargeProduct Od(int paramInt)
    {
      AppMethodBeat.i(67236);
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)this.xDj.get(paramInt);
      AppMethodBeat.o(67236);
      return localMallRechargeProduct;
    }
    
    public final void fh(List<MallRechargeProduct> paramList)
    {
      AppMethodBeat.i(67233);
      this.xDj = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(67233);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67235);
      if (this.xDj == null)
      {
        AppMethodBeat.o(67235);
        return 0;
      }
      int i = this.xDj.size();
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
      paramViewGroup = Od(paramInt);
      paramView.setText(paramViewGroup.pSt);
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
      if (!Od(paramInt).isValid())
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