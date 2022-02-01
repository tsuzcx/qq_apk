package com.tencent.mm.plugin.order.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
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
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI
  extends WalletBaseUI
  implements r.a
{
  private HashMap<String, View> MAv;
  private List<MallOrderDetailObject.a> MDQ;
  protected MallOrderDetailObject MEV;
  String MFC;
  private a MFD;
  private View MFE;
  private View MFF;
  private View MFG;
  private View MFH;
  private View MFI;
  private View MFJ;
  private View MFK;
  private boolean MFL;
  private boolean MFM;
  private int MFN;
  private CheckedTextView MFO;
  private CheckedTextView MFP;
  View.OnClickListener MFQ;
  private ListView mListView;
  private View.OnClickListener qjL;
  private String wXY;
  
  public MallOrderDetailInfoUI()
  {
    AppMethodBeat.i(66717);
    this.MDQ = new ArrayList();
    this.MEV = null;
    this.MAv = new HashMap();
    this.MFL = false;
    this.wXY = "";
    this.MFM = false;
    this.MFN = 0;
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (paramAnonymousView.getId() == a.f.order_latest_status_info_layout) {
          if (MallOrderDetailInfoUI.this.MEV.MDO != null)
          {
            com.tencent.mm.plugin.order.c.c.bA(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.MEV.MDO.IGI);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.MEV.MDO.MDW);
          }
        }
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66706);
          return;
          if ((paramAnonymousView.getId() != a.f.order_product_item_text_x4) && (paramAnonymousView.getId() != a.f.order_product_item_text_x1)) {
            break;
          }
        } while ((MallOrderDetailInfoUI.this.MEV.MDP == null) || (MallOrderDetailInfoUI.this.MEV.MDP.size() <= 0));
        if (!TextUtils.isEmpty(((ProductSectionItem)MallOrderDetailInfoUI.this.MEV.MDP.get(0)).jumpUrl)) {}
        for (boolean bool = com.tencent.mm.plugin.order.c.c.bA(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.MEV.MDP.get(0)).jumpUrl);; bool = false)
        {
          if (!bool) {
            com.tencent.mm.plugin.order.c.c.bB(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.MEV.MDP.get(0)).ycW);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.MEV.MDP.get(0)).name);
          break;
          if (paramAnonymousView.getId() == a.f.order_product_item_icon_text_x4)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput();
            paramAnonymousView.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.MEV.MDP);
            paramAnonymousView.putInt("key_enter_id", 0);
            paramAnonymousView.putString("key_trans_id", MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this));
            paramAnonymousView.putString("appname", MallOrderDetailInfoUI.this.MEV.appUserName);
            com.tencent.mm.wallet_core.a.k(MallOrderDetailInfoUI.this, new Bundle());
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(a.i.mall_order_products_list_ui_title));
            break;
          }
          if (paramAnonymousView.getId() == a.f.order_transaction_info_parent_layout)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput().getString("key_trans_id");
            localObject = MallOrderDetailInfoUI.this.getInput();
            ((Bundle)localObject).putString("key_trans_id", paramAnonymousView);
            ((Bundle)localObject).putInt("key_enter_id", 1);
            if (MallOrderDetailInfoUI.this.MEV != null) {
              ((Bundle)localObject).putParcelable("transaction_data", MallOrderDetailInfoUI.this.MEV.MDN);
            }
            com.tencent.mm.wallet_core.a.k(MallOrderDetailInfoUI.this, (Bundle)localObject);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(a.i.mall_order_merchant_info_text));
            break;
          }
          if (paramAnonymousView.getId() == a.f.order_confirm_result_btn)
          {
            MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this);
            break;
          }
          if (paramAnonymousView.getId() == a.f.hot_contact_phone_title_tv)
          {
            if ((MallOrderDetailInfoUI.this.MEV == null) || (MallOrderDetailInfoUI.this.MEV.MDU == null)) {
              break;
            }
            MallOrderDetailInfoUI.this.MFC = MallOrderDetailInfoUI.this.MEV.MDU;
            MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(a.i.mall_order_hot_phone_text));
            break;
          }
          if (paramAnonymousView.getId() != a.f.wx_contact_service_title_tv) {
            break;
          }
          i.ao(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.MEV.appUserName);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(a.i.mall_order_wx_service_text));
          break;
        }
      }
    };
    this.MFQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this) != null) && (MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this) != null))
        {
          if (paramAnonymousView.getId() != a.f.order_action_item_good_tv) {
            break label114;
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
          label114:
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
    if ((parama != null) && (parama.wsJ)) {
      paramView.setBackgroundResource(a.e.mm_trans);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      AppMethodBeat.o(66730);
      return;
      paramView.setBackgroundResource(a.e.list_item_normal);
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
    TextView localTextView = (TextView)paramView.findViewById(a.f.item_product_descript_tv);
    if (localTextView != null) {
      localTextView.setText(paramProductSectionItem.name);
    }
    if (!TextUtils.isEmpty(paramProductSectionItem.iconUrl)) {
      v((ImageView)paramView.findViewById(a.f.item_product_logo_img), paramProductSectionItem.iconUrl);
    }
    AppMethodBeat.o(66727);
  }
  
  private void a(MallOrderDetailObject.b paramb)
  {
    AppMethodBeat.i(66723);
    String str;
    if (paramb != null)
    {
      str = paramb.MDW;
      if (TextUtils.isEmpty(paramb.MDX)) {
        break label342;
      }
      str = str + "：" + paramb.MDX;
    }
    label342:
    for (;;)
    {
      if (!this.MFL)
      {
        this.MFF.setVisibility(8);
        this.MFE.setVisibility(0);
        ((TextView)this.MFE.findViewById(a.f.order_latest_status_title_tv)).setText(str);
        ((TextView)this.MFE.findViewById(a.f.order_latest_status_subtitle_tv)).setText(i.vh(this.MEV.MDV));
        if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (i.bEM(paramb.thumbUrl)))
        {
          v((ImageView)this.MFE.findViewById(a.f.order_merchant_logo_img), paramb.thumbUrl);
          AppMethodBeat.o(66723);
          return;
        }
        r((ImageView)this.MFE.findViewById(a.f.order_merchant_logo_img));
        AppMethodBeat.o(66723);
        return;
      }
      this.MFE.setVisibility(8);
      this.MFF.setVisibility(0);
      ((TextView)this.MFF.findViewById(a.f.order_latest_status_title_tv)).setText(str);
      ((TextView)this.MFF.findViewById(a.f.order_latest_status_subtitle_tv)).setText(i.vh(this.MEV.MDV));
      if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (i.bEM(paramb.thumbUrl)))
      {
        v((ImageView)this.MFF.findViewById(a.f.order_merchant_logo_img), paramb.thumbUrl);
        AppMethodBeat.o(66723);
        return;
      }
      r((ImageView)this.MFF.findViewById(a.f.order_merchant_logo_img));
      AppMethodBeat.o(66723);
      return;
      this.MFE.setVisibility(8);
      this.MFF.setVisibility(8);
      AppMethodBeat.o(66723);
      return;
    }
  }
  
  private void a(MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66724);
    if (paramMallTransactionObject != null)
    {
      this.MFG.setVisibility(0);
      ((TextView)findViewById(a.f.order_transaction_subtitle_tv)).setText(i.e(paramMallTransactionObject.wZe, paramMallTransactionObject.MEq));
      if ((this.MEV != null) && (this.MEV.MDQ != null) && (this.MEV.MDQ.size() > 0))
      {
        paramMallTransactionObject = (MallOrderDetailObject.a)this.MEV.MDQ.get(0);
        a(this.MFH, paramMallTransactionObject);
        AppMethodBeat.o(66724);
      }
    }
    else
    {
      this.MFG.setVisibility(8);
    }
    AppMethodBeat.o(66724);
  }
  
  private void bYl()
  {
    AppMethodBeat.i(66722);
    if (this.MEV == null)
    {
      AppMethodBeat.o(66722);
      return;
    }
    r.a(this);
    this.MAv.clear();
    a(this.MEV.MDO);
    jp(this.MEV.MDP);
    a(this.MEV.MDN);
    jo(this.MEV.MDQ);
    findViewById(a.f.mall_order_contact_layout).setVisibility(0);
    if ((this.MEV != null) && (TextUtils.isEmpty(this.MEV.MDU)) && (TextUtils.isEmpty(this.MEV.appUserName))) {
      findViewById(a.f.mall_order_contact_layout).setVisibility(8);
    }
    for (;;)
    {
      if ((this.MEV != null) && (!TextUtils.isEmpty(this.MEV.MDT))) {
        dmE();
      }
      AppMethodBeat.o(66722);
      return;
      TextView localTextView;
      if ((this.MEV != null) && (!TextUtils.isEmpty(this.MEV.MDU)) && (TextUtils.isEmpty(this.MEV.appUserName)))
      {
        findViewById(a.f.wx_contact_service_title_tv).setVisibility(8);
        findViewById(a.f.wx_contact_divider_tv).setVisibility(8);
        localTextView = (TextView)findViewById(a.f.hot_contact_phone_title_tv);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
      else if ((this.MEV != null) && (TextUtils.isEmpty(this.MEV.MDU)) && (!TextUtils.isEmpty(this.MEV.appUserName)))
      {
        findViewById(a.f.hot_contact_phone_title_tv).setVisibility(8);
        findViewById(a.f.wx_contact_divider_tv).setVisibility(8);
        localTextView = (TextView)findViewById(a.f.wx_contact_service_title_tv);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
    }
  }
  
  private void dmE()
  {
    AppMethodBeat.i(66729);
    addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
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
  
  private void gxF()
  {
    AppMethodBeat.i(66733);
    if ((!this.MFM) && (this.MFN != 0))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new f(this.wXY, "", this.MFN), 0);
      this.MFM = true;
    }
    AppMethodBeat.o(66733);
  }
  
  private void gxG()
  {
    AppMethodBeat.i(66737);
    k.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
  
  private void jo(List<MallOrderDetailObject.a> paramList)
  {
    AppMethodBeat.i(66725);
    if (paramList != null)
    {
      this.MDQ.addAll(paramList);
      this.MFD.notifyDataSetChanged();
    }
    AppMethodBeat.o(66725);
  }
  
  private void jp(List<ProductSectionItem> paramList)
  {
    AppMethodBeat.i(66726);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.MFI.setVisibility(8);
      this.MFJ.setVisibility(8);
      this.MFK.setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 1)
    {
      this.MFK.setVisibility(8);
      paramList = (ProductSectionItem)paramList.get(0);
      if (!TextUtils.isEmpty(paramList.iconUrl))
      {
        this.MFI.setVisibility(8);
        this.MFJ.setVisibility(0);
        ((TextView)this.MFJ.findViewById(a.f.item_product_descript_tv)).setText(paramList.name);
        ((TextView)this.MFJ.findViewById(a.f.item_product_price_tv)).setText(paramList.price);
        ((TextView)this.MFJ.findViewById(a.f.item_product_count_tv)).setText("+" + paramList.count);
        ((TextView)this.MFJ.findViewById(a.f.item_product_catalog_tv)).setText(ProductSectionItem.Skus.jn(paramList.MFA));
        if (!TextUtils.isEmpty(paramList.iconUrl))
        {
          v((ImageView)this.MFJ.findViewById(a.f.item_product_logo_img), paramList.iconUrl);
          AppMethodBeat.o(66726);
        }
      }
      else
      {
        this.MFJ.setVisibility(8);
        this.MFI.setVisibility(0);
        ((TextView)this.MFI.findViewById(a.f.item_product_descript_tv)).setText(paramList.name);
        if (TextUtils.isEmpty(paramList.jumpUrl))
        {
          paramList = new Rect();
          paramList.set(this.MFI.findViewById(a.f.item_product_descript_layout).getPaddingLeft(), this.MFI.findViewById(a.f.item_product_descript_layout).getPaddingTop(), this.MFI.findViewById(a.f.item_product_descript_layout).getPaddingRight(), this.MFI.findViewById(a.f.item_product_descript_layout).getPaddingBottom());
          this.MFI.findViewById(a.f.item_product_descript_layout).setBackgroundResource(a.e.list_item_normal);
          this.MFI.findViewById(a.f.item_product_descript_layout).setPadding(paramList.left, paramList.top, paramList.right, paramList.bottom);
          AppMethodBeat.o(66726);
          return;
        }
        ((TextView)this.MFI.findViewById(a.f.item_product_descript_tv)).setTextColor(getResources().getColor(a.c.mall_order_detail_item_title_color));
      }
      AppMethodBeat.o(66726);
      return;
    }
    this.MFI.setVisibility(8);
    this.MFJ.setVisibility(8);
    this.MFK.setVisibility(0);
    if (paramList.size() == 2)
    {
      a(this.MFK.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)paramList.get(0));
      a(this.MFK.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)paramList.get(1));
      this.MFK.findViewById(a.f.order_product_item_x4_3_layout).setVisibility(8);
      this.MFK.findViewById(a.f.order_product_item_x4_4_layout).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 3)
    {
      a(this.MFK.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)paramList.get(0));
      a(this.MFK.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)paramList.get(1));
      a(this.MFK.findViewById(a.f.order_product_item_x4_3_layout), (ProductSectionItem)paramList.get(2));
      this.MFK.findViewById(a.f.order_product_item_x4_4_layout).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() >= 4)
    {
      a(this.MFK.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)paramList.get(0));
      a(this.MFK.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)paramList.get(1));
      a(this.MFK.findViewById(a.f.order_product_item_x4_3_layout), (ProductSectionItem)paramList.get(2));
      a(this.MFK.findViewById(a.f.order_product_item_x4_4_layout), (ProductSectionItem)paramList.get(3));
    }
    AppMethodBeat.o(66726);
  }
  
  private void r(ImageView paramImageView)
  {
    AppMethodBeat.i(66732);
    Bitmap localBitmap = com.tencent.mm.compatible.f.a.decodeResource(getResources(), a.h.mall_order_trade_state_icon);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 96.0F));
    }
    AppMethodBeat.o(66732);
  }
  
  private void v(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66728);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)) || (!i.bEM(paramString)))
    {
      AppMethodBeat.o(66728);
      return;
    }
    paramImageView.setImageBitmap(r.a(new com.tencent.mm.plugin.order.c.b(paramString)));
    this.MAv.put(paramString, paramImageView);
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
    gxF();
    super.finish();
    AppMethodBeat.o(66734);
  }
  
  public int getLayoutId()
  {
    return a.g.mall_order_detail_info_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66719);
    int i;
    if (this.MFL)
    {
      com.tencent.mm.plugin.order.a.b.gxv();
      j localj = com.tencent.mm.plugin.order.a.b.gxy().aRf(this.wXY);
      if ((localj != null) && (!TextUtils.isEmpty(localj.MFq)) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.MFq)))
      {
        i = Util.getInt(localj.MFq, 0);
        if (i != 2) {
          break label323;
        }
        setMMTitle(a.i.mall_order_detail_ui_for_notify_title);
      }
    }
    for (;;)
    {
      this.MFE = findViewById(a.f.order_latest_status_info_layout);
      this.MFF = findViewById(a.f.order_latest_status_info_for_msg_layout);
      this.MFJ = findViewById(a.f.order_product_item_text_x4);
      this.MFK = findViewById(a.f.order_product_item_icon_text_x4);
      this.MFI = findViewById(a.f.order_product_item_text_x1);
      this.MFG = findViewById(a.f.order_transaction_info_parent_layout);
      this.MFH = findViewById(a.f.order_transaction_info_layout);
      this.MFE.setOnClickListener(this.qjL);
      this.MFK.setOnClickListener(this.qjL);
      this.MFJ.setOnClickListener(this.qjL);
      this.MFI.setOnClickListener(this.qjL);
      this.MFG.setOnClickListener(this.qjL);
      findViewById(a.f.order_confirm_result_btn).setOnClickListener(this.qjL);
      findViewById(a.f.hot_contact_phone_title_tv).setOnClickListener(this.qjL);
      findViewById(a.f.wx_contact_service_title_tv).setOnClickListener(this.qjL);
      this.mListView = ((ListView)findViewById(a.f.order_action_list));
      this.MFD = new a((byte)0);
      this.mListView.setAdapter(this.MFD);
      this.MFD.notifyDataSetChanged();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(66709);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).get(paramAnonymousInt);
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.jumpUrl)) {
            com.tencent.mm.plugin.order.c.c.bA(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.jumpUrl);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.name);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(66709);
        }
      });
      bYl();
      AppMethodBeat.o(66719);
      return;
      i = -1;
      break;
      label323:
      if (i == 1)
      {
        setMMTitle(a.i.mall_order_detail_ui_for_reminder_title);
        continue;
        setMMTitle(a.i.mall_order_detail_ui_title);
      }
    }
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(66731);
    paramString = (ImageView)this.MAv.get(paramString);
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
    paramBundle = com.tencent.mm.wallet_core.a.cm(this);
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      paramBundle = getInput().getString("key_trans_id");
      this.wXY = paramBundle;
      if (paramBundle == null) {
        break label91;
      }
      com.tencent.mm.plugin.order.a.b.gxv();
      if (com.tencent.mm.plugin.order.a.b.gxy().aRe(paramBundle)) {
        break label91;
      }
      this.MFL = false;
      doSceneProgress(new com.tencent.mm.plugin.order.model.h(paramBundle));
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(66718);
      return;
      label91:
      com.tencent.mm.plugin.order.a.b.gxv();
      if (com.tencent.mm.plugin.order.a.b.gxy().aRe(paramBundle))
      {
        this.MFL = true;
        com.tencent.mm.plugin.order.a.b.gxv();
        Object localObject2 = com.tencent.mm.plugin.order.a.b.gxy();
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = (Bundle)localObject1;
        }
        do
        {
          this.MEV = paramBundle;
          if (this.MEV != null) {
            break;
          }
          gxG();
          break;
          Log.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(paramBundle)));
          localObject2 = ((com.tencent.mm.plugin.order.model.c)localObject2).aRf(paramBundle);
          paramBundle = (Bundle)localObject1;
        } while (localObject2 == null);
        paramBundle = new MallOrderDetailObject();
        localObject1 = new MallOrderDetailObject.b();
        ((MallOrderDetailObject.b)localObject1).MDW = ((j)localObject2).MFu;
        if ((!TextUtils.isEmpty(((j)localObject2).MFs)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).MFs))) {}
        int i;
        Object localObject3;
        MallOrderDetailObject.a locala;
        for (((MallOrderDetailObject.b)localObject1).time = Util.getInt(((j)localObject2).MFs, 0);; ((MallOrderDetailObject.b)localObject1).time = ((int)(System.currentTimeMillis() / 1000L)))
        {
          ((MallOrderDetailObject.b)localObject1).thumbUrl = ((j)localObject2).MFt;
          ((MallOrderDetailObject.b)localObject1).IGI = ((j)localObject2).MFv;
          ((MallOrderDetailObject.b)localObject1).MDX = ((j)localObject2).hWn;
          paramBundle.MDO = ((MallOrderDetailObject.b)localObject1);
          localObject1 = ((j)localObject2).MFy;
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramBundle.MDQ = new ArrayList();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.a)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.a)localObject3).name;
            locala.value = "";
            locala.jumpUrl = ((j.a)localObject3).jumpUrl;
            locala.wsJ = false;
            paramBundle.MDQ.add(locala);
            i += 1;
          }
        }
        localObject1 = ((j)localObject2).MFz;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (paramBundle.MDQ == null) {
            paramBundle.MDQ = new ArrayList();
          }
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.b)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.b)localObject3).name;
            locala.value = ((j.b)localObject3).value;
            locala.jumpUrl = ((j.b)localObject3).jumpUrl;
            locala.wsJ = false;
            if (i == 0) {
              locala.wsJ = true;
            }
            paramBundle.MDQ.add(locala);
            i += 1;
          }
        }
        paramBundle.MDU = ((j)localObject2).MFx;
        paramBundle.appUserName = ((j)localObject2).MFw;
        if ((!TextUtils.isEmpty(((j)localObject2).MFs)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).MFs))) {}
        for (paramBundle.MDV = Util.getInt(((j)localObject2).MFs, 0);; paramBundle.MDV = ((int)(System.currentTimeMillis() / 1000L))) {
          break;
        }
      }
      Log.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
      gxG();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66735);
    gxF();
    super.onDestroy();
    AppMethodBeat.o(66735);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66720);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.cm(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.cj(this);
      }
      AppMethodBeat.o(66720);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66720);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(66721);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramp).MEV;
        Log.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          this.MEV = paramString;
          bYl();
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
    
    private MallOrderDetailObject.a afl(int paramInt)
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
      paramInt = afl(paramInt).type;
      AppMethodBeat.o(66715);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66714);
      MallOrderDetailObject.a locala = afl(paramInt);
      switch (locala.type)
      {
      default: 
        if (paramView == null)
        {
          paramView = View.inflate(MallOrderDetailInfoUI.this, a.g.mall_order_action_list_item, null);
          paramViewGroup = new MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (byte)0);
          paramViewGroup.wDQ = ((TextView)paramView.findViewById(a.f.order_action_item_title_tv));
          paramViewGroup.wET = ((TextView)paramView.findViewById(a.f.order_action_item_subtitle_tv));
          paramViewGroup.wEU = ((TextView)paramView.findViewById(a.f.order_action_item_divider_tv));
          paramViewGroup.doN = paramView.findViewById(a.f.order_action_item_content_layout);
          paramView.setTag(paramViewGroup);
          paramViewGroup.wDQ.setText(locala.name);
          if (!TextUtils.isEmpty(locala.value)) {
            break label448;
          }
          paramViewGroup.wET.setVisibility(4);
          label158:
          if (!locala.wsJ) {
            break label471;
          }
          paramViewGroup.wEU.setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        if (paramInt + 1 < getCount())
        {
          locala = afl(paramInt + 1);
          MallOrderDetailInfoUI.b(paramViewGroup.doN, locala);
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, a.g.mall_order_action_list_item_to_be_reted, null);
        paramViewGroup = paramView.findViewById(a.f.order_action_item_content_layout);
        MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(a.f.order_action_item_good_tv));
        MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(a.f.order_action_item_bad_tv));
        MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.MFQ);
        MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.MFQ);
        if (paramInt + 1 < getCount()) {
          MallOrderDetailInfoUI.b(paramViewGroup, afl(paramInt + 1));
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, a.g.mall_order_action_list_item_reted, null);
        paramViewGroup = (TextView)paramView.findViewById(a.f.order_action_item_bad_tv);
        View localView = paramView.findViewById(a.f.order_action_item_content_layout);
        if (Util.getInt(locala.value, 0) >= 0)
        {
          paramViewGroup.setText(a.i.mall_order_detail_rated_good);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.h.mall_order_detail_good, 0);
        }
        for (;;)
        {
          if (paramInt + 1 < getCount()) {
            MallOrderDetailInfoUI.b(localView, afl(paramInt + 1));
          }
          AppMethodBeat.o(66714);
          return paramView;
          paramViewGroup.setText(a.i.mall_order_detail_rated_bad);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.h.mall_order_detail_bad, 0);
        }
        paramViewGroup = (MallOrderDetailInfoUI.b)paramView.getTag();
        break;
        label448:
        paramViewGroup.wET.setVisibility(0);
        paramViewGroup.wET.setText(locala.value);
        break label158;
        label471:
        paramViewGroup.wEU.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
  }
  
  final class b
  {
    View doN;
    TextView wDQ;
    TextView wET;
    TextView wEU;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */