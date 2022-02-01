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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.f;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.plugin.order.model.j.a;
import com.tencent.mm.plugin.order.model.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI
  extends WalletBaseUI
  implements u.a
{
  private View.OnClickListener jtG;
  private ListView mListView;
  private String oZO;
  private List<MallOrderDetailObject.a> wCf;
  String wDV;
  private a wDW;
  private View wDX;
  private View wDY;
  private View wDZ;
  protected MallOrderDetailObject wDm;
  private View wEa;
  private View wEb;
  private View wEc;
  private View wEd;
  private boolean wEe;
  private boolean wEf;
  private int wEg;
  private CheckedTextView wEh;
  private CheckedTextView wEi;
  View.OnClickListener wEj;
  private HashMap<String, View> wzA;
  
  public MallOrderDetailInfoUI()
  {
    AppMethodBeat.i(66717);
    this.wCf = new ArrayList();
    this.wDm = null;
    this.wzA = new HashMap();
    this.wEe = false;
    this.oZO = "";
    this.wEf = false;
    this.wEg = 0;
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (paramAnonymousView.getId() == 2131303063) {
          if (MallOrderDetailInfoUI.this.wDm.wCd != null)
          {
            com.tencent.mm.plugin.order.c.c.aU(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.wDm.wCd.ueY);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.wDm.wCd.wCl);
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
        } while ((MallOrderDetailInfoUI.this.wDm.wCe == null) || (MallOrderDetailInfoUI.this.wDm.wCe.size() <= 0));
        if (!TextUtils.isEmpty(((ProductSectionItem)MallOrderDetailInfoUI.this.wDm.wCe.get(0)).jumpUrl)) {}
        for (boolean bool = com.tencent.mm.plugin.order.c.c.aU(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.wDm.wCe.get(0)).jumpUrl);; bool = false)
        {
          if (!bool) {
            com.tencent.mm.plugin.order.c.c.aV(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.wDm.wCe.get(0)).wDT);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.wDm.wCe.get(0)).name);
          break;
          if (paramAnonymousView.getId() == 2131303075)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput();
            paramAnonymousView.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.wDm.wCe);
            paramAnonymousView.putInt("key_enter_id", 0);
            paramAnonymousView.putString("key_trans_id", MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this));
            paramAnonymousView.putString("appname", MallOrderDetailInfoUI.this.wDm.dtE);
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
            if (MallOrderDetailInfoUI.this.wDm != null) {
              ((Bundle)localObject).putParcelable("transaction_data", MallOrderDetailInfoUI.this.wDm.wCc);
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
            if ((MallOrderDetailInfoUI.this.wDm == null) || (MallOrderDetailInfoUI.this.wDm.wCj == null)) {
              break;
            }
            MallOrderDetailInfoUI.this.wDV = MallOrderDetailInfoUI.this.wDm.wCj;
            MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761106));
            break;
          }
          if (paramAnonymousView.getId() != 2131307105) {
            break;
          }
          e.ad(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.wDm.dtE);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761117));
          break;
        }
      }
    };
    this.wEj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    if ((parama != null) && (parama.oxY)) {
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
      str = paramb.wCl;
      if (TextUtils.isEmpty(paramb.wCm)) {
        break label338;
      }
      str = str + "：" + paramb.wCm;
    }
    label338:
    for (;;)
    {
      if (!this.wEe)
      {
        this.wDY.setVisibility(8);
        this.wDX.setVisibility(0);
        ((TextView)this.wDX.findViewById(2131303065)).setText(str);
        ((TextView)this.wDX.findViewById(2131303064)).setText(e.ov(this.wDm.wCk));
        if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (e.aYG(paramb.thumbUrl)))
        {
          s((ImageView)this.wDX.findViewById(2131303074), paramb.thumbUrl);
          AppMethodBeat.o(66723);
          return;
        }
        h((ImageView)this.wDX.findViewById(2131303074));
        AppMethodBeat.o(66723);
        return;
      }
      this.wDX.setVisibility(8);
      this.wDY.setVisibility(0);
      ((TextView)this.wDY.findViewById(2131303065)).setText(str);
      ((TextView)this.wDY.findViewById(2131303064)).setText(e.ov(this.wDm.wCk));
      if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (e.aYG(paramb.thumbUrl)))
      {
        s((ImageView)this.wDY.findViewById(2131303074), paramb.thumbUrl);
        AppMethodBeat.o(66723);
        return;
      }
      h((ImageView)this.wDY.findViewById(2131303074));
      AppMethodBeat.o(66723);
      return;
      this.wDX.setVisibility(8);
      this.wDY.setVisibility(8);
      AppMethodBeat.o(66723);
      return;
    }
  }
  
  private void a(MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66724);
    if (paramMallTransactionObject != null)
    {
      this.wDZ.setVisibility(0);
      ((TextView)findViewById(2131303085)).setText(e.d(paramMallTransactionObject.paV, paramMallTransactionObject.wCF));
      if ((this.wDm != null) && (this.wDm.wCf != null) && (this.wDm.wCf.size() > 0))
      {
        paramMallTransactionObject = (MallOrderDetailObject.a)this.wDm.wCf.get(0);
        a(this.wEa, paramMallTransactionObject);
        AppMethodBeat.o(66724);
      }
    }
    else
    {
      this.wDZ.setVisibility(8);
    }
    AppMethodBeat.o(66724);
  }
  
  private void aUb()
  {
    AppMethodBeat.i(66722);
    if (this.wDm == null)
    {
      AppMethodBeat.o(66722);
      return;
    }
    u.a(this);
    this.wzA.clear();
    a(this.wDm.wCd);
    eH(this.wDm.wCe);
    a(this.wDm.wCc);
    eG(this.wDm.wCf);
    findViewById(2131302034).setVisibility(0);
    if ((this.wDm != null) && (TextUtils.isEmpty(this.wDm.wCj)) && (TextUtils.isEmpty(this.wDm.dtE))) {
      findViewById(2131302034).setVisibility(8);
    }
    for (;;)
    {
      if ((this.wDm != null) && (!TextUtils.isEmpty(this.wDm.wCi))) {
        bWG();
      }
      AppMethodBeat.o(66722);
      return;
      TextView localTextView;
      if ((this.wDm != null) && (!TextUtils.isEmpty(this.wDm.wCj)) && (TextUtils.isEmpty(this.wDm.dtE)))
      {
        findViewById(2131307105).setVisibility(8);
        findViewById(2131307104).setVisibility(8);
        localTextView = (TextView)findViewById(2131300763);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
      else if ((this.wDm != null) && (TextUtils.isEmpty(this.wDm.wCj)) && (!TextUtils.isEmpty(this.wDm.dtE)))
      {
        findViewById(2131300763).setVisibility(8);
        findViewById(2131307104).setVisibility(8);
        localTextView = (TextView)findViewById(2131307105);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
    }
  }
  
  private void bWG()
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
  
  private void dyj()
  {
    AppMethodBeat.i(66733);
    if ((!this.wEf) && (this.wEg != 0))
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(new f(this.oZO, "", this.wEg), 0);
      this.wEf = true;
    }
    AppMethodBeat.o(66733);
  }
  
  private void dyk()
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
  
  private void eG(List<MallOrderDetailObject.a> paramList)
  {
    AppMethodBeat.i(66725);
    if (paramList != null)
    {
      this.wCf.addAll(paramList);
      this.wDW.notifyDataSetChanged();
    }
    AppMethodBeat.o(66725);
  }
  
  private void eH(List<ProductSectionItem> paramList)
  {
    AppMethodBeat.i(66726);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.wEb.setVisibility(8);
      this.wEc.setVisibility(8);
      this.wEd.setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 1)
    {
      this.wEd.setVisibility(8);
      paramList = (ProductSectionItem)paramList.get(0);
      if (!TextUtils.isEmpty(paramList.iconUrl))
      {
        this.wEb.setVisibility(8);
        this.wEc.setVisibility(0);
        ((TextView)this.wEc.findViewById(2131301179)).setText(paramList.name);
        ((TextView)this.wEc.findViewById(2131301181)).setText(paramList.wDS);
        ((TextView)this.wEc.findViewById(2131301177)).setText("+" + paramList.count);
        ((TextView)this.wEc.findViewById(2131301176)).setText(ProductSectionItem.Skus.eF(paramList.wDR));
        if (!TextUtils.isEmpty(paramList.iconUrl))
        {
          s((ImageView)this.wEc.findViewById(2131301180), paramList.iconUrl);
          AppMethodBeat.o(66726);
        }
      }
      else
      {
        this.wEc.setVisibility(8);
        this.wEb.setVisibility(0);
        ((TextView)this.wEb.findViewById(2131301179)).setText(paramList.name);
        if (TextUtils.isEmpty(paramList.jumpUrl))
        {
          paramList = new Rect();
          paramList.set(this.wEb.findViewById(2131301178).getPaddingLeft(), this.wEb.findViewById(2131301178).getPaddingTop(), this.wEb.findViewById(2131301178).getPaddingRight(), this.wEb.findViewById(2131301178).getPaddingBottom());
          this.wEb.findViewById(2131301178).setBackgroundResource(2131232867);
          this.wEb.findViewById(2131301178).setPadding(paramList.left, paramList.top, paramList.right, paramList.bottom);
          AppMethodBeat.o(66726);
          return;
        }
        ((TextView)this.wEb.findViewById(2131301179)).setTextColor(getResources().getColor(2131100611));
      }
      AppMethodBeat.o(66726);
      return;
    }
    this.wEb.setVisibility(8);
    this.wEc.setVisibility(8);
    this.wEd.setVisibility(0);
    if (paramList.size() == 2)
    {
      a(this.wEd.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.wEd.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      this.wEd.findViewById(2131303080).setVisibility(8);
      this.wEd.findViewById(2131303081).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 3)
    {
      a(this.wEd.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.wEd.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      a(this.wEd.findViewById(2131303080), (ProductSectionItem)paramList.get(2));
      this.wEd.findViewById(2131303081).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() >= 4)
    {
      a(this.wEd.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.wEd.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      a(this.wEd.findViewById(2131303080), (ProductSectionItem)paramList.get(2));
      a(this.wEd.findViewById(2131303081), (ProductSectionItem)paramList.get(3));
    }
    AppMethodBeat.o(66726);
  }
  
  private void h(ImageView paramImageView)
  {
    AppMethodBeat.i(66732);
    Bitmap localBitmap = com.tencent.mm.compatible.e.a.decodeResource(getResources(), 2131690787);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.g.a(localBitmap, false, 96.0F));
    }
    AppMethodBeat.o(66732);
  }
  
  private void s(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66728);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)) || (!e.aYG(paramString)))
    {
      AppMethodBeat.o(66728);
      return;
    }
    paramImageView.setImageBitmap(u.a(new com.tencent.mm.plugin.order.c.b(paramString)));
    this.wzA.put(paramString, paramImageView);
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
    dyj();
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
    if (this.wEe)
    {
      com.tencent.mm.plugin.order.a.b.dxY();
      j localj = com.tencent.mm.plugin.order.a.b.dyb().aub(this.oZO);
      if ((localj != null) && (!TextUtils.isEmpty(localj.wDH)) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.wDH)))
      {
        i = bt.getInt(localj.wDH, 0);
        if (i != 2) {
          break label323;
        }
        setMMTitle(2131761103);
      }
    }
    for (;;)
    {
      this.wDX = findViewById(2131303063);
      this.wDY = findViewById(2131303062);
      this.wEc = findViewById(2131303077);
      this.wEd = findViewById(2131303075);
      this.wEb = findViewById(2131303076);
      this.wDZ = findViewById(2131303084);
      this.wEa = findViewById(2131303083);
      this.wDX.setOnClickListener(this.jtG);
      this.wEd.setOnClickListener(this.jtG);
      this.wEc.setOnClickListener(this.jtG);
      this.wEb.setOnClickListener(this.jtG);
      this.wDZ.setOnClickListener(this.jtG);
      findViewById(2131303059).setOnClickListener(this.jtG);
      findViewById(2131300763).setOnClickListener(this.jtG);
      findViewById(2131307105).setOnClickListener(this.jtG);
      this.mListView = ((ListView)findViewById(2131303058));
      this.wDW = new a((byte)0);
      this.mListView.setAdapter(this.wDW);
      this.wDW.notifyDataSetChanged();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(66709);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).get(paramAnonymousInt);
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.jumpUrl)) {
            com.tencent.mm.plugin.order.c.c.aU(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.jumpUrl);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.name);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(66709);
        }
      });
      aUb();
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
    paramString = (ImageView)this.wzA.get(paramString);
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
    paramBundle = com.tencent.mm.wallet_core.a.br(this);
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      paramBundle = getInput().getString("key_trans_id");
      this.oZO = paramBundle;
      if (paramBundle == null) {
        break label91;
      }
      com.tencent.mm.plugin.order.a.b.dxY();
      if (com.tencent.mm.plugin.order.a.b.dyb().aua(paramBundle)) {
        break label91;
      }
      this.wEe = false;
      doSceneProgress(new com.tencent.mm.plugin.order.model.h(paramBundle));
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(66718);
      return;
      label91:
      com.tencent.mm.plugin.order.a.b.dxY();
      if (com.tencent.mm.plugin.order.a.b.dyb().aua(paramBundle))
      {
        this.wEe = true;
        com.tencent.mm.plugin.order.a.b.dxY();
        Object localObject2 = com.tencent.mm.plugin.order.a.b.dyb();
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = (Bundle)localObject1;
        }
        do
        {
          this.wDm = paramBundle;
          if (this.wDm != null) {
            break;
          }
          dyk();
          break;
          ad.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(paramBundle)));
          localObject2 = ((com.tencent.mm.plugin.order.model.c)localObject2).aub(paramBundle);
          paramBundle = (Bundle)localObject1;
        } while (localObject2 == null);
        paramBundle = new MallOrderDetailObject();
        localObject1 = new MallOrderDetailObject.b();
        ((MallOrderDetailObject.b)localObject1).wCl = ((j)localObject2).wDL;
        if ((!TextUtils.isEmpty(((j)localObject2).wDJ)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).wDJ))) {}
        int i;
        Object localObject3;
        MallOrderDetailObject.a locala;
        for (((MallOrderDetailObject.b)localObject1).hbR = bt.getInt(((j)localObject2).wDJ, 0);; ((MallOrderDetailObject.b)localObject1).hbR = ((int)(System.currentTimeMillis() / 1000L)))
        {
          ((MallOrderDetailObject.b)localObject1).thumbUrl = ((j)localObject2).wDK;
          ((MallOrderDetailObject.b)localObject1).ueY = ((j)localObject2).wDM;
          ((MallOrderDetailObject.b)localObject1).wCm = ((j)localObject2).dDP;
          paramBundle.wCd = ((MallOrderDetailObject.b)localObject1);
          localObject1 = ((j)localObject2).wDP;
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramBundle.wCf = new ArrayList();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.a)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.a)localObject3).name;
            locala.value = "";
            locala.jumpUrl = ((j.a)localObject3).jumpUrl;
            locala.oxY = false;
            paramBundle.wCf.add(locala);
            i += 1;
          }
        }
        localObject1 = ((j)localObject2).wDQ;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (paramBundle.wCf == null) {
            paramBundle.wCf = new ArrayList();
          }
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.b)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.b)localObject3).name;
            locala.value = ((j.b)localObject3).value;
            locala.jumpUrl = ((j.b)localObject3).jumpUrl;
            locala.oxY = false;
            if (i == 0) {
              locala.oxY = true;
            }
            paramBundle.wCf.add(locala);
            i += 1;
          }
        }
        paramBundle.wCj = ((j)localObject2).wDO;
        paramBundle.dtE = ((j)localObject2).wDN;
        if ((!TextUtils.isEmpty(((j)localObject2).wDJ)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).wDJ))) {}
        for (paramBundle.wCk = bt.getInt(((j)localObject2).wDJ, 0);; paramBundle.wCk = ((int)(System.currentTimeMillis() / 1000L))) {
          break;
        }
      }
      ad.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
      dyk();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66735);
    dyj();
    super.onDestroy();
    AppMethodBeat.o(66735);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66720);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.br(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.bo(this);
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
        paramString = ((com.tencent.mm.plugin.order.model.h)paramn).wDm;
        ad.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          this.wDm = paramString;
          aUb();
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
    
    private MallOrderDetailObject.a Mt(int paramInt)
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
      paramInt = Mt(paramInt).type;
      AppMethodBeat.o(66715);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66714);
      MallOrderDetailObject.a locala = Mt(paramInt);
      switch (locala.type)
      {
      default: 
        if (paramView == null)
        {
          paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494703, null);
          paramViewGroup = new MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (byte)0);
          paramViewGroup.oJh = ((TextView)paramView.findViewById(2131303057));
          paramViewGroup.oKj = ((TextView)paramView.findViewById(2131303056));
          paramViewGroup.oKk = ((TextView)paramView.findViewById(2131303054));
          paramViewGroup.rY = paramView.findViewById(2131303052);
          paramView.setTag(paramViewGroup);
          paramViewGroup.oJh.setText(locala.name);
          if (!TextUtils.isEmpty(locala.value)) {
            break label432;
          }
          paramViewGroup.oKj.setVisibility(4);
          label153:
          if (!locala.oxY) {
            break label455;
          }
          paramViewGroup.oKk.setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        if (paramInt + 1 < getCount())
        {
          locala = Mt(paramInt + 1);
          MallOrderDetailInfoUI.b(paramViewGroup.rY, locala);
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494705, null);
        paramViewGroup = paramView.findViewById(2131303052);
        MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(2131303055));
        MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(2131303051));
        MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.wEj);
        MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.wEj);
        if (paramInt + 1 < getCount()) {
          MallOrderDetailInfoUI.b(paramViewGroup, Mt(paramInt + 1));
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494704, null);
        paramViewGroup = (TextView)paramView.findViewById(2131303051);
        View localView = paramView.findViewById(2131303052);
        if (bt.getInt(locala.value, 0) >= 0)
        {
          paramViewGroup.setText(2131761101);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131690781, 0);
        }
        for (;;)
        {
          if (paramInt + 1 < getCount()) {
            MallOrderDetailInfoUI.b(localView, Mt(paramInt + 1));
          }
          AppMethodBeat.o(66714);
          return paramView;
          paramViewGroup.setText(2131761100);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131690777, 0);
        }
        paramViewGroup = (MallOrderDetailInfoUI.b)paramView.getTag();
        break;
        label432:
        paramViewGroup.oKj.setVisibility(0);
        paramViewGroup.oKj.setText(locala.value);
        break label153;
        label455:
        paramViewGroup.oKk.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
  }
  
  final class b
  {
    TextView oJh;
    TextView oKj;
    TextView oKk;
    View rY;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */