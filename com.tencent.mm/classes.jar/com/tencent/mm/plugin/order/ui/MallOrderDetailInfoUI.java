package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.plugin.order.model.j.a;
import com.tencent.mm.plugin.order.model.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI
  extends WalletBaseUI
  implements u.a
{
  private View.OnClickListener jwB;
  private ListView mListView;
  private String pgs;
  private HashMap<String, View> wPl;
  private List<MallOrderDetailObject.a> wRQ;
  protected MallOrderDetailObject wSX;
  String wTG;
  private a wTH;
  private View wTI;
  private View wTJ;
  private View wTK;
  private View wTL;
  private View wTM;
  private View wTN;
  private View wTO;
  private boolean wTP;
  private boolean wTQ;
  private int wTR;
  private CheckedTextView wTS;
  private CheckedTextView wTT;
  View.OnClickListener wTU;
  
  public MallOrderDetailInfoUI()
  {
    AppMethodBeat.i(66717);
    this.wRQ = new ArrayList();
    this.wSX = null;
    this.wPl = new HashMap();
    this.wTP = false;
    this.pgs = "";
    this.wTQ = false;
    this.wTR = 0;
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (paramAnonymousView.getId() == 2131303063) {
          if (MallOrderDetailInfoUI.this.wSX.wRO != null)
          {
            com.tencent.mm.plugin.order.c.c.aW(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.wSX.wRO.uqf);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.wSX.wRO.wRW);
          }
        }
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66706);
          return;
          if ((paramAnonymousView.getId() != 2131303077) && (paramAnonymousView.getId() != 2131303076)) {
            break;
          }
        } while ((MallOrderDetailInfoUI.this.wSX.wRP == null) || (MallOrderDetailInfoUI.this.wSX.wRP.size() <= 0));
        if (!TextUtils.isEmpty(((ProductSectionItem)MallOrderDetailInfoUI.this.wSX.wRP.get(0)).jumpUrl)) {}
        for (boolean bool = com.tencent.mm.plugin.order.c.c.aW(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.wSX.wRP.get(0)).jumpUrl);; bool = false)
        {
          if (!bool) {
            com.tencent.mm.plugin.order.c.c.aX(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.wSX.wRP.get(0)).wTE);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.wSX.wRP.get(0)).name);
          break;
          if (paramAnonymousView.getId() == 2131303075)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput();
            paramAnonymousView.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.wSX.wRP);
            paramAnonymousView.putInt("key_enter_id", 0);
            paramAnonymousView.putString("key_trans_id", MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this));
            paramAnonymousView.putString("appname", MallOrderDetailInfoUI.this.wSX.duJ);
            com.tencent.mm.wallet_core.a.k(MallOrderDetailInfoUI.this, new Bundle());
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761111));
            break;
          }
          if (paramAnonymousView.getId() == 2131303084)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput().getString("key_trans_id");
            localObject = MallOrderDetailInfoUI.this.getInput();
            ((Bundle)localObject).putString("key_trans_id", paramAnonymousView);
            ((Bundle)localObject).putInt("key_enter_id", 1);
            if (MallOrderDetailInfoUI.this.wSX != null) {
              ((Bundle)localObject).putParcelable("transaction_data", MallOrderDetailInfoUI.this.wSX.wRN);
            }
            com.tencent.mm.wallet_core.a.k(MallOrderDetailInfoUI.this, (Bundle)localObject);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761108));
            break;
          }
          if (paramAnonymousView.getId() == 2131303059)
          {
            MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this);
            break;
          }
          if (paramAnonymousView.getId() == 2131300763)
          {
            if ((MallOrderDetailInfoUI.this.wSX == null) || (MallOrderDetailInfoUI.this.wSX.wRU == null)) {
              break;
            }
            MallOrderDetailInfoUI.this.wTG = MallOrderDetailInfoUI.this.wSX.wRU;
            MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761106));
            break;
          }
          if (paramAnonymousView.getId() != 2131307105) {
            break;
          }
          com.tencent.mm.wallet_core.ui.f.af(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.wSX.duJ);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761117));
          break;
        }
      }
    };
    this.wTU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this) != null) && (MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this) != null))
        {
          if (paramAnonymousView.getId() != 2131303055) {
            break label113;
          }
          MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setSelected(true);
          MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setSelected(false);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, 100);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66710);
          return;
          label113:
          MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setSelected(false);
          MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setSelected(true);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, -100);
        }
      }
    };
    AppMethodBeat.o(66717);
  }
  
  private static void a(View paramView, MallOrderDetailObject.a parama)
  {
    AppMethodBeat.i(66730);
    if (parama == null)
    {
      AppMethodBeat.o(66730);
      return;
    }
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if ((parama != null) && (parama.oEA)) {
      paramView.setBackgroundResource(2131233299);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      AppMethodBeat.o(66730);
      return;
      paramView.setBackgroundResource(2131232867);
    }
  }
  
  private void a(View paramView, ProductSectionItem paramProductSectionItem)
  {
    AppMethodBeat.i(66727);
    if ((paramView == null) || (paramProductSectionItem == null))
    {
      AppMethodBeat.o(66727);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131301179);
    if (localTextView != null) {
      localTextView.setText(paramProductSectionItem.name);
    }
    if (!TextUtils.isEmpty(paramProductSectionItem.iconUrl)) {
      s((ImageView)paramView.findViewById(2131301180), paramProductSectionItem.iconUrl);
    }
    AppMethodBeat.o(66727);
  }
  
  private void a(MallOrderDetailObject.b paramb)
  {
    AppMethodBeat.i(66723);
    String str;
    if (paramb != null)
    {
      str = paramb.wRW;
      if (TextUtils.isEmpty(paramb.wRX)) {
        break label338;
      }
      str = str + "：" + paramb.wRX;
    }
    label338:
    for (;;)
    {
      if (!this.wTP)
      {
        this.wTJ.setVisibility(8);
        this.wTI.setVisibility(0);
        ((TextView)this.wTI.findViewById(2131303065)).setText(str);
        ((TextView)this.wTI.findViewById(2131303064)).setText(com.tencent.mm.wallet_core.ui.f.oy(this.wSX.wRV));
        if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (com.tencent.mm.wallet_core.ui.f.baj(paramb.thumbUrl)))
        {
          s((ImageView)this.wTI.findViewById(2131303074), paramb.thumbUrl);
          AppMethodBeat.o(66723);
          return;
        }
        h((ImageView)this.wTI.findViewById(2131303074));
        AppMethodBeat.o(66723);
        return;
      }
      this.wTI.setVisibility(8);
      this.wTJ.setVisibility(0);
      ((TextView)this.wTJ.findViewById(2131303065)).setText(str);
      ((TextView)this.wTJ.findViewById(2131303064)).setText(com.tencent.mm.wallet_core.ui.f.oy(this.wSX.wRV));
      if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (com.tencent.mm.wallet_core.ui.f.baj(paramb.thumbUrl)))
      {
        s((ImageView)this.wTJ.findViewById(2131303074), paramb.thumbUrl);
        AppMethodBeat.o(66723);
        return;
      }
      h((ImageView)this.wTJ.findViewById(2131303074));
      AppMethodBeat.o(66723);
      return;
      this.wTI.setVisibility(8);
      this.wTJ.setVisibility(8);
      AppMethodBeat.o(66723);
      return;
    }
  }
  
  private void a(MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66724);
    if (paramMallTransactionObject != null)
    {
      this.wTK.setVisibility(0);
      ((TextView)findViewById(2131303085)).setText(com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.phz, paramMallTransactionObject.wSq));
      if ((this.wSX != null) && (this.wSX.wRQ != null) && (this.wSX.wRQ.size() > 0))
      {
        paramMallTransactionObject = (MallOrderDetailObject.a)this.wSX.wRQ.get(0);
        a(this.wTL, paramMallTransactionObject);
        AppMethodBeat.o(66724);
      }
    }
    else
    {
      this.wTK.setVisibility(8);
    }
    AppMethodBeat.o(66724);
  }
  
  private void aUA()
  {
    AppMethodBeat.i(66722);
    if (this.wSX == null)
    {
      AppMethodBeat.o(66722);
      return;
    }
    u.a(this);
    this.wPl.clear();
    a(this.wSX.wRO);
    eO(this.wSX.wRP);
    a(this.wSX.wRN);
    eN(this.wSX.wRQ);
    findViewById(2131302034).setVisibility(0);
    if ((this.wSX != null) && (TextUtils.isEmpty(this.wSX.wRU)) && (TextUtils.isEmpty(this.wSX.duJ))) {
      findViewById(2131302034).setVisibility(8);
    }
    for (;;)
    {
      if ((this.wSX != null) && (!TextUtils.isEmpty(this.wSX.wRT))) {
        bXV();
      }
      AppMethodBeat.o(66722);
      return;
      TextView localTextView;
      if ((this.wSX != null) && (!TextUtils.isEmpty(this.wSX.wRU)) && (TextUtils.isEmpty(this.wSX.duJ)))
      {
        findViewById(2131307105).setVisibility(8);
        findViewById(2131307104).setVisibility(8);
        localTextView = (TextView)findViewById(2131300763);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
      else if ((this.wSX != null) && (TextUtils.isEmpty(this.wSX.wRU)) && (!TextUtils.isEmpty(this.wSX.duJ)))
      {
        findViewById(2131300763).setVisibility(8);
        findViewById(2131307104).setVisibility(8);
        localTextView = (TextView)findViewById(2131307105);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
    }
  }
  
  private void bXV()
  {
    AppMethodBeat.i(66729);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66707);
        MallOrderDetailInfoUI.d(MallOrderDetailInfoUI.this);
        AppMethodBeat.o(66707);
        return true;
      }
    });
    AppMethodBeat.o(66729);
  }
  
  private void dBA()
  {
    AppMethodBeat.i(66737);
    com.tencent.mm.ui.base.h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66711);
        MallOrderDetailInfoUI.this.finish();
        AppMethodBeat.o(66711);
      }
    });
    AppMethodBeat.o(66737);
  }
  
  private void dBz()
  {
    AppMethodBeat.i(66733);
    if ((!this.wTQ) && (this.wTR != 0))
    {
      g.ajS();
      g.ajQ().gDv.a(new com.tencent.mm.plugin.order.model.f(this.pgs, "", this.wTR), 0);
      this.wTQ = true;
    }
    AppMethodBeat.o(66733);
  }
  
  private void eN(List<MallOrderDetailObject.a> paramList)
  {
    AppMethodBeat.i(66725);
    if (paramList != null)
    {
      this.wRQ.addAll(paramList);
      this.wTH.notifyDataSetChanged();
    }
    AppMethodBeat.o(66725);
  }
  
  private void eO(List<ProductSectionItem> paramList)
  {
    AppMethodBeat.i(66726);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.wTM.setVisibility(8);
      this.wTN.setVisibility(8);
      this.wTO.setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 1)
    {
      this.wTO.setVisibility(8);
      paramList = (ProductSectionItem)paramList.get(0);
      if (!TextUtils.isEmpty(paramList.iconUrl))
      {
        this.wTM.setVisibility(8);
        this.wTN.setVisibility(0);
        ((TextView)this.wTN.findViewById(2131301179)).setText(paramList.name);
        ((TextView)this.wTN.findViewById(2131301181)).setText(paramList.wTD);
        ((TextView)this.wTN.findViewById(2131301177)).setText("+" + paramList.count);
        ((TextView)this.wTN.findViewById(2131301176)).setText(ProductSectionItem.Skus.eM(paramList.wTC));
        if (!TextUtils.isEmpty(paramList.iconUrl))
        {
          s((ImageView)this.wTN.findViewById(2131301180), paramList.iconUrl);
          AppMethodBeat.o(66726);
        }
      }
      else
      {
        this.wTN.setVisibility(8);
        this.wTM.setVisibility(0);
        ((TextView)this.wTM.findViewById(2131301179)).setText(paramList.name);
        if (TextUtils.isEmpty(paramList.jumpUrl))
        {
          paramList = new Rect();
          paramList.set(this.wTM.findViewById(2131301178).getPaddingLeft(), this.wTM.findViewById(2131301178).getPaddingTop(), this.wTM.findViewById(2131301178).getPaddingRight(), this.wTM.findViewById(2131301178).getPaddingBottom());
          this.wTM.findViewById(2131301178).setBackgroundResource(2131232867);
          this.wTM.findViewById(2131301178).setPadding(paramList.left, paramList.top, paramList.right, paramList.bottom);
          AppMethodBeat.o(66726);
          return;
        }
        ((TextView)this.wTM.findViewById(2131301179)).setTextColor(getResources().getColor(2131100611));
      }
      AppMethodBeat.o(66726);
      return;
    }
    this.wTM.setVisibility(8);
    this.wTN.setVisibility(8);
    this.wTO.setVisibility(0);
    if (paramList.size() == 2)
    {
      a(this.wTO.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.wTO.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      this.wTO.findViewById(2131303080).setVisibility(8);
      this.wTO.findViewById(2131303081).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 3)
    {
      a(this.wTO.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.wTO.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      a(this.wTO.findViewById(2131303080), (ProductSectionItem)paramList.get(2));
      this.wTO.findViewById(2131303081).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() >= 4)
    {
      a(this.wTO.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.wTO.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      a(this.wTO.findViewById(2131303080), (ProductSectionItem)paramList.get(2));
      a(this.wTO.findViewById(2131303081), (ProductSectionItem)paramList.get(3));
    }
    AppMethodBeat.o(66726);
  }
  
  private void h(ImageView paramImageView)
  {
    AppMethodBeat.i(66732);
    Bitmap localBitmap = com.tencent.mm.compatible.e.a.decodeResource(getResources(), 2131690787);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.h.a(localBitmap, false, 96.0F));
    }
    AppMethodBeat.o(66732);
  }
  
  private void s(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66728);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)) || (!com.tencent.mm.wallet_core.ui.f.baj(paramString)))
    {
      AppMethodBeat.o(66728);
      return;
    }
    paramImageView.setImageBitmap(u.a(new com.tencent.mm.plugin.order.c.b(paramString)));
    this.wPl.put(paramString, paramImageView);
    AppMethodBeat.o(66728);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(66736);
    finish();
    AppMethodBeat.o(66736);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66734);
    dBz();
    super.finish();
    AppMethodBeat.o(66734);
  }
  
  public int getLayoutId()
  {
    return 2131494711;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66719);
    int i;
    if (this.wTP)
    {
      com.tencent.mm.plugin.order.a.b.dBo();
      j localj = com.tencent.mm.plugin.order.a.b.dBr().avq(this.pgs);
      if ((localj != null) && (!TextUtils.isEmpty(localj.wTs)) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.wTs)))
      {
        i = bu.getInt(localj.wTs, 0);
        if (i != 2) {
          break label323;
        }
        setMMTitle(2131761103);
      }
    }
    for (;;)
    {
      this.wTI = findViewById(2131303063);
      this.wTJ = findViewById(2131303062);
      this.wTN = findViewById(2131303077);
      this.wTO = findViewById(2131303075);
      this.wTM = findViewById(2131303076);
      this.wTK = findViewById(2131303084);
      this.wTL = findViewById(2131303083);
      this.wTI.setOnClickListener(this.jwB);
      this.wTO.setOnClickListener(this.jwB);
      this.wTN.setOnClickListener(this.jwB);
      this.wTM.setOnClickListener(this.jwB);
      this.wTK.setOnClickListener(this.jwB);
      findViewById(2131303059).setOnClickListener(this.jwB);
      findViewById(2131300763).setOnClickListener(this.jwB);
      findViewById(2131307105).setOnClickListener(this.jwB);
      this.mListView = ((ListView)findViewById(2131303058));
      this.wTH = new a((byte)0);
      this.mListView.setAdapter(this.wTH);
      this.wTH.notifyDataSetChanged();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(66709);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousAdapterView = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).get(paramAnonymousInt);
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.jumpUrl)) {
            com.tencent.mm.plugin.order.c.c.aW(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.jumpUrl);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.name);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(66709);
        }
      });
      aUA();
      AppMethodBeat.o(66719);
      return;
      i = -1;
      break;
      label323:
      if (i == 1)
      {
        setMMTitle(2131761104);
        continue;
        setMMTitle(2131761105);
      }
    }
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(66731);
    paramString = (ImageView)this.wPl.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(66731);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(66718);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.wallet_core.a.bs(this);
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      paramBundle = getInput().getString("key_trans_id");
      this.pgs = paramBundle;
      if (paramBundle == null) {
        break label91;
      }
      com.tencent.mm.plugin.order.a.b.dBo();
      if (com.tencent.mm.plugin.order.a.b.dBr().avp(paramBundle)) {
        break label91;
      }
      this.wTP = false;
      doSceneProgress(new com.tencent.mm.plugin.order.model.h(paramBundle));
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(66718);
      return;
      label91:
      com.tencent.mm.plugin.order.a.b.dBo();
      if (com.tencent.mm.plugin.order.a.b.dBr().avp(paramBundle))
      {
        this.wTP = true;
        com.tencent.mm.plugin.order.a.b.dBo();
        Object localObject2 = com.tencent.mm.plugin.order.a.b.dBr();
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = (Bundle)localObject1;
        }
        do
        {
          this.wSX = paramBundle;
          if (this.wSX != null) {
            break;
          }
          dBA();
          break;
          ae.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(paramBundle)));
          localObject2 = ((com.tencent.mm.plugin.order.model.c)localObject2).avq(paramBundle);
          paramBundle = (Bundle)localObject1;
        } while (localObject2 == null);
        paramBundle = new MallOrderDetailObject();
        localObject1 = new MallOrderDetailObject.b();
        ((MallOrderDetailObject.b)localObject1).wRW = ((j)localObject2).wTw;
        if ((!TextUtils.isEmpty(((j)localObject2).wTu)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).wTu))) {}
        int i;
        Object localObject3;
        MallOrderDetailObject.a locala;
        for (((MallOrderDetailObject.b)localObject1).heF = bu.getInt(((j)localObject2).wTu, 0);; ((MallOrderDetailObject.b)localObject1).heF = ((int)(System.currentTimeMillis() / 1000L)))
        {
          ((MallOrderDetailObject.b)localObject1).thumbUrl = ((j)localObject2).wTv;
          ((MallOrderDetailObject.b)localObject1).uqf = ((j)localObject2).wTx;
          ((MallOrderDetailObject.b)localObject1).wRX = ((j)localObject2).dEU;
          paramBundle.wRO = ((MallOrderDetailObject.b)localObject1);
          localObject1 = ((j)localObject2).wTA;
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramBundle.wRQ = new ArrayList();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.a)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.a)localObject3).name;
            locala.value = "";
            locala.jumpUrl = ((j.a)localObject3).jumpUrl;
            locala.oEA = false;
            paramBundle.wRQ.add(locala);
            i += 1;
          }
        }
        localObject1 = ((j)localObject2).wTB;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (paramBundle.wRQ == null) {
            paramBundle.wRQ = new ArrayList();
          }
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.b)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.b)localObject3).name;
            locala.value = ((j.b)localObject3).value;
            locala.jumpUrl = ((j.b)localObject3).jumpUrl;
            locala.oEA = false;
            if (i == 0) {
              locala.oEA = true;
            }
            paramBundle.wRQ.add(locala);
            i += 1;
          }
        }
        paramBundle.wRU = ((j)localObject2).wTz;
        paramBundle.duJ = ((j)localObject2).wTy;
        if ((!TextUtils.isEmpty(((j)localObject2).wTu)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).wTu))) {}
        for (paramBundle.wRV = bu.getInt(((j)localObject2).wTu, 0);; paramBundle.wRV = ((int)(System.currentTimeMillis() / 1000L))) {
          break;
        }
      }
      ae.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
      dBA();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66735);
    dBz();
    super.onDestroy();
    AppMethodBeat.o(66735);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66720);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.bs(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.bp(this);
      }
      AppMethodBeat.o(66720);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66720);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66721);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramn).wSX;
        ae.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          this.wSX = paramString;
          aUA();
        }
      }
      AppMethodBeat.o(66721);
      return true;
    }
    AppMethodBeat.o(66721);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private MallOrderDetailObject.a MY(int paramInt)
    {
      AppMethodBeat.i(66713);
      MallOrderDetailObject.a locala = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).get(paramInt);
      AppMethodBeat.o(66713);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66712);
      int i = MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).size();
      AppMethodBeat.o(66712);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(66715);
      paramInt = MY(paramInt).type;
      AppMethodBeat.o(66715);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66714);
      MallOrderDetailObject.a locala = MY(paramInt);
      switch (locala.type)
      {
      default: 
        if (paramView == null)
        {
          paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494703, null);
          paramViewGroup = new MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (byte)0);
          paramViewGroup.oPJ = ((TextView)paramView.findViewById(2131303057));
          paramViewGroup.oQL = ((TextView)paramView.findViewById(2131303056));
          paramViewGroup.oQM = ((TextView)paramView.findViewById(2131303054));
          paramViewGroup.rY = paramView.findViewById(2131303052);
          paramView.setTag(paramViewGroup);
          paramViewGroup.oPJ.setText(locala.name);
          if (!TextUtils.isEmpty(locala.value)) {
            break label432;
          }
          paramViewGroup.oQL.setVisibility(4);
          label153:
          if (!locala.oEA) {
            break label455;
          }
          paramViewGroup.oQM.setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        if (paramInt + 1 < getCount())
        {
          locala = MY(paramInt + 1);
          MallOrderDetailInfoUI.b(paramViewGroup.rY, locala);
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494705, null);
        paramViewGroup = paramView.findViewById(2131303052);
        MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(2131303055));
        MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(2131303051));
        MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.wTU);
        MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.wTU);
        if (paramInt + 1 < getCount()) {
          MallOrderDetailInfoUI.b(paramViewGroup, MY(paramInt + 1));
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494704, null);
        paramViewGroup = (TextView)paramView.findViewById(2131303051);
        View localView = paramView.findViewById(2131303052);
        if (bu.getInt(locala.value, 0) >= 0)
        {
          paramViewGroup.setText(2131761101);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131690781, 0);
        }
        for (;;)
        {
          if (paramInt + 1 < getCount()) {
            MallOrderDetailInfoUI.b(localView, MY(paramInt + 1));
          }
          AppMethodBeat.o(66714);
          return paramView;
          paramViewGroup.setText(2131761100);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131690777, 0);
        }
        paramViewGroup = (MallOrderDetailInfoUI.b)paramView.getTag();
        break;
        label432:
        paramViewGroup.oQL.setVisibility(0);
        paramViewGroup.oQL.setText(locala.value);
        break label153;
        label455:
        paramViewGroup.oQM.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
  }
  
  final class b
  {
    TextView oPJ;
    TextView oQL;
    TextView oQM;
    View rY;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */