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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
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
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI
  extends WalletBaseUI
  implements u.a
{
  private HashMap<String, View> GEc;
  private List<MallOrderDetailObject.a> GGZ;
  String GIN;
  private a GIO;
  private View GIP;
  private View GIQ;
  private View GIR;
  private View GIS;
  private View GIT;
  private View GIU;
  private View GIV;
  private boolean GIW;
  private boolean GIX;
  private int GIY;
  private CheckedTextView GIZ;
  protected MallOrderDetailObject GIf;
  private CheckedTextView GJa;
  View.OnClickListener GJb;
  private ListView mListView;
  private View.OnClickListener nmC;
  private String tUC;
  
  public MallOrderDetailInfoUI()
  {
    AppMethodBeat.i(66717);
    this.GGZ = new ArrayList();
    this.GIf = null;
    this.GEc = new HashMap();
    this.GIW = false;
    this.tUC = "";
    this.GIX = false;
    this.GIY = 0;
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (paramAnonymousView.getId() == a.f.order_latest_status_info_layout) {
          if (MallOrderDetailInfoUI.this.GIf.GGX != null)
          {
            com.tencent.mm.plugin.order.c.c.by(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.GIf.GGX.CMD);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.GIf.GGX.GHf);
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
        } while ((MallOrderDetailInfoUI.this.GIf.GGY == null) || (MallOrderDetailInfoUI.this.GIf.GGY.size() <= 0));
        if (!TextUtils.isEmpty(((ProductSectionItem)MallOrderDetailInfoUI.this.GIf.GGY.get(0)).jumpUrl)) {}
        for (boolean bool = com.tencent.mm.plugin.order.c.c.by(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.GIf.GGY.get(0)).jumpUrl);; bool = false)
        {
          if (!bool) {
            com.tencent.mm.plugin.order.c.c.bz(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.GIf.GGY.get(0)).GIL);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.GIf.GGY.get(0)).name);
          break;
          if (paramAnonymousView.getId() == a.f.order_product_item_icon_text_x4)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput();
            paramAnonymousView.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.GIf.GGY);
            paramAnonymousView.putInt("key_enter_id", 0);
            paramAnonymousView.putString("key_trans_id", MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this));
            paramAnonymousView.putString("appname", MallOrderDetailInfoUI.this.GIf.appUserName);
            com.tencent.mm.wallet_core.a.l(MallOrderDetailInfoUI.this, new Bundle());
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(a.i.mall_order_products_list_ui_title));
            break;
          }
          if (paramAnonymousView.getId() == a.f.order_transaction_info_parent_layout)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput().getString("key_trans_id");
            localObject = MallOrderDetailInfoUI.this.getInput();
            ((Bundle)localObject).putString("key_trans_id", paramAnonymousView);
            ((Bundle)localObject).putInt("key_enter_id", 1);
            if (MallOrderDetailInfoUI.this.GIf != null) {
              ((Bundle)localObject).putParcelable("transaction_data", MallOrderDetailInfoUI.this.GIf.GGW);
            }
            com.tencent.mm.wallet_core.a.l(MallOrderDetailInfoUI.this, (Bundle)localObject);
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
            if ((MallOrderDetailInfoUI.this.GIf == null) || (MallOrderDetailInfoUI.this.GIf.GHd == null)) {
              break;
            }
            MallOrderDetailInfoUI.this.GIN = MallOrderDetailInfoUI.this.GIf.GHd;
            MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(a.i.mall_order_hot_phone_text));
            break;
          }
          if (paramAnonymousView.getId() != a.f.wx_contact_service_title_tv) {
            break;
          }
          g.an(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.GIf.appUserName);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(a.i.mall_order_wx_service_text));
          break;
        }
      }
    };
    this.GJb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    if ((parama != null) && (parama.toi)) {
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
      u((ImageView)paramView.findViewById(a.f.item_product_logo_img), paramProductSectionItem.iconUrl);
    }
    AppMethodBeat.o(66727);
  }
  
  private void a(MallOrderDetailObject.b paramb)
  {
    AppMethodBeat.i(66723);
    String str;
    if (paramb != null)
    {
      str = paramb.GHf;
      if (TextUtils.isEmpty(paramb.GHg)) {
        break label342;
      }
      str = str + "：" + paramb.GHg;
    }
    label342:
    for (;;)
    {
      if (!this.GIW)
      {
        this.GIQ.setVisibility(8);
        this.GIP.setVisibility(0);
        ((TextView)this.GIP.findViewById(a.f.order_latest_status_title_tv)).setText(str);
        ((TextView)this.GIP.findViewById(a.f.order_latest_status_subtitle_tv)).setText(g.uW(this.GIf.GHe));
        if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (g.bCo(paramb.thumbUrl)))
        {
          u((ImageView)this.GIP.findViewById(a.f.order_merchant_logo_img), paramb.thumbUrl);
          AppMethodBeat.o(66723);
          return;
        }
        k((ImageView)this.GIP.findViewById(a.f.order_merchant_logo_img));
        AppMethodBeat.o(66723);
        return;
      }
      this.GIP.setVisibility(8);
      this.GIQ.setVisibility(0);
      ((TextView)this.GIQ.findViewById(a.f.order_latest_status_title_tv)).setText(str);
      ((TextView)this.GIQ.findViewById(a.f.order_latest_status_subtitle_tv)).setText(g.uW(this.GIf.GHe));
      if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (g.bCo(paramb.thumbUrl)))
      {
        u((ImageView)this.GIQ.findViewById(a.f.order_merchant_logo_img), paramb.thumbUrl);
        AppMethodBeat.o(66723);
        return;
      }
      k((ImageView)this.GIQ.findViewById(a.f.order_merchant_logo_img));
      AppMethodBeat.o(66723);
      return;
      this.GIP.setVisibility(8);
      this.GIQ.setVisibility(8);
      AppMethodBeat.o(66723);
      return;
    }
  }
  
  private void a(MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66724);
    if (paramMallTransactionObject != null)
    {
      this.GIR.setVisibility(0);
      ((TextView)findViewById(a.f.order_transaction_subtitle_tv)).setText(g.d(paramMallTransactionObject.tVK, paramMallTransactionObject.GHz));
      if ((this.GIf != null) && (this.GIf.GGZ != null) && (this.GIf.GGZ.size() > 0))
      {
        paramMallTransactionObject = (MallOrderDetailObject.a)this.GIf.GGZ.get(0);
        a(this.GIS, paramMallTransactionObject);
        AppMethodBeat.o(66724);
      }
    }
    else
    {
      this.GIR.setVisibility(8);
    }
    AppMethodBeat.o(66724);
  }
  
  private void bzz()
  {
    AppMethodBeat.i(66722);
    if (this.GIf == null)
    {
      AppMethodBeat.o(66722);
      return;
    }
    u.a(this);
    this.GEc.clear();
    a(this.GIf.GGX);
    gp(this.GIf.GGY);
    a(this.GIf.GGW);
    go(this.GIf.GGZ);
    findViewById(a.f.mall_order_contact_layout).setVisibility(0);
    if ((this.GIf != null) && (TextUtils.isEmpty(this.GIf.GHd)) && (TextUtils.isEmpty(this.GIf.appUserName))) {
      findViewById(a.f.mall_order_contact_layout).setVisibility(8);
    }
    for (;;)
    {
      if ((this.GIf != null) && (!TextUtils.isEmpty(this.GIf.GHc))) {
        cJn();
      }
      AppMethodBeat.o(66722);
      return;
      TextView localTextView;
      if ((this.GIf != null) && (!TextUtils.isEmpty(this.GIf.GHd)) && (TextUtils.isEmpty(this.GIf.appUserName)))
      {
        findViewById(a.f.wx_contact_service_title_tv).setVisibility(8);
        findViewById(a.f.wx_contact_divider_tv).setVisibility(8);
        localTextView = (TextView)findViewById(a.f.hot_contact_phone_title_tv);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
      else if ((this.GIf != null) && (TextUtils.isEmpty(this.GIf.GHd)) && (!TextUtils.isEmpty(this.GIf.appUserName)))
      {
        findViewById(a.f.hot_contact_phone_title_tv).setVisibility(8);
        findViewById(a.f.wx_contact_divider_tv).setVisibility(8);
        localTextView = (TextView)findViewById(a.f.wx_contact_service_title_tv);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
    }
  }
  
  private void cJn()
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
  
  private void fmR()
  {
    AppMethodBeat.i(66733);
    if ((!this.GIX) && (this.GIY != 0))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(new f(this.tUC, "", this.GIY), 0);
      this.GIX = true;
    }
    AppMethodBeat.o(66733);
  }
  
  private void fmS()
  {
    AppMethodBeat.i(66737);
    com.tencent.mm.ui.base.h.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
  
  private void go(List<MallOrderDetailObject.a> paramList)
  {
    AppMethodBeat.i(66725);
    if (paramList != null)
    {
      this.GGZ.addAll(paramList);
      this.GIO.notifyDataSetChanged();
    }
    AppMethodBeat.o(66725);
  }
  
  private void gp(List<ProductSectionItem> paramList)
  {
    AppMethodBeat.i(66726);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.GIT.setVisibility(8);
      this.GIU.setVisibility(8);
      this.GIV.setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 1)
    {
      this.GIV.setVisibility(8);
      paramList = (ProductSectionItem)paramList.get(0);
      if (!TextUtils.isEmpty(paramList.iconUrl))
      {
        this.GIT.setVisibility(8);
        this.GIU.setVisibility(0);
        ((TextView)this.GIU.findViewById(a.f.item_product_descript_tv)).setText(paramList.name);
        ((TextView)this.GIU.findViewById(a.f.item_product_price_tv)).setText(paramList.price);
        ((TextView)this.GIU.findViewById(a.f.item_product_count_tv)).setText("+" + paramList.count);
        ((TextView)this.GIU.findViewById(a.f.item_product_catalog_tv)).setText(ProductSectionItem.Skus.gn(paramList.GIK));
        if (!TextUtils.isEmpty(paramList.iconUrl))
        {
          u((ImageView)this.GIU.findViewById(a.f.item_product_logo_img), paramList.iconUrl);
          AppMethodBeat.o(66726);
        }
      }
      else
      {
        this.GIU.setVisibility(8);
        this.GIT.setVisibility(0);
        ((TextView)this.GIT.findViewById(a.f.item_product_descript_tv)).setText(paramList.name);
        if (TextUtils.isEmpty(paramList.jumpUrl))
        {
          paramList = new Rect();
          paramList.set(this.GIT.findViewById(a.f.item_product_descript_layout).getPaddingLeft(), this.GIT.findViewById(a.f.item_product_descript_layout).getPaddingTop(), this.GIT.findViewById(a.f.item_product_descript_layout).getPaddingRight(), this.GIT.findViewById(a.f.item_product_descript_layout).getPaddingBottom());
          this.GIT.findViewById(a.f.item_product_descript_layout).setBackgroundResource(a.e.list_item_normal);
          this.GIT.findViewById(a.f.item_product_descript_layout).setPadding(paramList.left, paramList.top, paramList.right, paramList.bottom);
          AppMethodBeat.o(66726);
          return;
        }
        ((TextView)this.GIT.findViewById(a.f.item_product_descript_tv)).setTextColor(getResources().getColor(a.c.mall_order_detail_item_title_color));
      }
      AppMethodBeat.o(66726);
      return;
    }
    this.GIT.setVisibility(8);
    this.GIU.setVisibility(8);
    this.GIV.setVisibility(0);
    if (paramList.size() == 2)
    {
      a(this.GIV.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)paramList.get(0));
      a(this.GIV.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)paramList.get(1));
      this.GIV.findViewById(a.f.order_product_item_x4_3_layout).setVisibility(8);
      this.GIV.findViewById(a.f.order_product_item_x4_4_layout).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 3)
    {
      a(this.GIV.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)paramList.get(0));
      a(this.GIV.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)paramList.get(1));
      a(this.GIV.findViewById(a.f.order_product_item_x4_3_layout), (ProductSectionItem)paramList.get(2));
      this.GIV.findViewById(a.f.order_product_item_x4_4_layout).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() >= 4)
    {
      a(this.GIV.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)paramList.get(0));
      a(this.GIV.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)paramList.get(1));
      a(this.GIV.findViewById(a.f.order_product_item_x4_3_layout), (ProductSectionItem)paramList.get(2));
      a(this.GIV.findViewById(a.f.order_product_item_x4_4_layout), (ProductSectionItem)paramList.get(3));
    }
    AppMethodBeat.o(66726);
  }
  
  private void k(ImageView paramImageView)
  {
    AppMethodBeat.i(66732);
    Bitmap localBitmap = com.tencent.mm.compatible.f.a.decodeResource(getResources(), a.h.mall_order_trade_state_icon);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 96.0F));
    }
    AppMethodBeat.o(66732);
  }
  
  private void u(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66728);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)) || (!g.bCo(paramString)))
    {
      AppMethodBeat.o(66728);
      return;
    }
    paramImageView.setImageBitmap(u.a(new com.tencent.mm.plugin.order.c.b(paramString)));
    this.GEc.put(paramString, paramImageView);
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
    fmR();
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
    if (this.GIW)
    {
      com.tencent.mm.plugin.order.a.b.fmH();
      j localj = com.tencent.mm.plugin.order.a.b.fmK().aTZ(this.tUC);
      if ((localj != null) && (!TextUtils.isEmpty(localj.GIA)) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.GIA)))
      {
        i = Util.getInt(localj.GIA, 0);
        if (i != 2) {
          break label323;
        }
        setMMTitle(a.i.mall_order_detail_ui_for_notify_title);
      }
    }
    for (;;)
    {
      this.GIP = findViewById(a.f.order_latest_status_info_layout);
      this.GIQ = findViewById(a.f.order_latest_status_info_for_msg_layout);
      this.GIU = findViewById(a.f.order_product_item_text_x4);
      this.GIV = findViewById(a.f.order_product_item_icon_text_x4);
      this.GIT = findViewById(a.f.order_product_item_text_x1);
      this.GIR = findViewById(a.f.order_transaction_info_parent_layout);
      this.GIS = findViewById(a.f.order_transaction_info_layout);
      this.GIP.setOnClickListener(this.nmC);
      this.GIV.setOnClickListener(this.nmC);
      this.GIU.setOnClickListener(this.nmC);
      this.GIT.setOnClickListener(this.nmC);
      this.GIR.setOnClickListener(this.nmC);
      findViewById(a.f.order_confirm_result_btn).setOnClickListener(this.nmC);
      findViewById(a.f.hot_contact_phone_title_tv).setOnClickListener(this.nmC);
      findViewById(a.f.wx_contact_service_title_tv).setOnClickListener(this.nmC);
      this.mListView = ((ListView)findViewById(a.f.order_action_list));
      this.GIO = new a((byte)0);
      this.mListView.setAdapter(this.GIO);
      this.GIO.notifyDataSetChanged();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(66709);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).get(paramAnonymousInt);
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.jumpUrl)) {
            com.tencent.mm.plugin.order.c.c.by(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.jumpUrl);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.name);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(66709);
        }
      });
      bzz();
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
    paramString = (ImageView)this.GEc.get(paramString);
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
    paramBundle = com.tencent.mm.wallet_core.a.bF(this);
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      paramBundle = getInput().getString("key_trans_id");
      this.tUC = paramBundle;
      if (paramBundle == null) {
        break label91;
      }
      com.tencent.mm.plugin.order.a.b.fmH();
      if (com.tencent.mm.plugin.order.a.b.fmK().aTY(paramBundle)) {
        break label91;
      }
      this.GIW = false;
      doSceneProgress(new com.tencent.mm.plugin.order.model.h(paramBundle));
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(66718);
      return;
      label91:
      com.tencent.mm.plugin.order.a.b.fmH();
      if (com.tencent.mm.plugin.order.a.b.fmK().aTY(paramBundle))
      {
        this.GIW = true;
        com.tencent.mm.plugin.order.a.b.fmH();
        Object localObject2 = com.tencent.mm.plugin.order.a.b.fmK();
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = (Bundle)localObject1;
        }
        do
        {
          this.GIf = paramBundle;
          if (this.GIf != null) {
            break;
          }
          fmS();
          break;
          Log.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(paramBundle)));
          localObject2 = ((com.tencent.mm.plugin.order.model.c)localObject2).aTZ(paramBundle);
          paramBundle = (Bundle)localObject1;
        } while (localObject2 == null);
        paramBundle = new MallOrderDetailObject();
        localObject1 = new MallOrderDetailObject.b();
        ((MallOrderDetailObject.b)localObject1).GHf = ((j)localObject2).GIE;
        if ((!TextUtils.isEmpty(((j)localObject2).GIC)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).GIC))) {}
        int i;
        Object localObject3;
        MallOrderDetailObject.a locala;
        for (((MallOrderDetailObject.b)localObject1).time = Util.getInt(((j)localObject2).GIC, 0);; ((MallOrderDetailObject.b)localObject1).time = ((int)(System.currentTimeMillis() / 1000L)))
        {
          ((MallOrderDetailObject.b)localObject1).thumbUrl = ((j)localObject2).GID;
          ((MallOrderDetailObject.b)localObject1).CMD = ((j)localObject2).GIF;
          ((MallOrderDetailObject.b)localObject1).GHg = ((j)localObject2).fQs;
          paramBundle.GGX = ((MallOrderDetailObject.b)localObject1);
          localObject1 = ((j)localObject2).GII;
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramBundle.GGZ = new ArrayList();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.a)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.a)localObject3).name;
            locala.value = "";
            locala.jumpUrl = ((j.a)localObject3).jumpUrl;
            locala.toi = false;
            paramBundle.GGZ.add(locala);
            i += 1;
          }
        }
        localObject1 = ((j)localObject2).GIJ;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (paramBundle.GGZ == null) {
            paramBundle.GGZ = new ArrayList();
          }
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.b)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.b)localObject3).name;
            locala.value = ((j.b)localObject3).value;
            locala.jumpUrl = ((j.b)localObject3).jumpUrl;
            locala.toi = false;
            if (i == 0) {
              locala.toi = true;
            }
            paramBundle.GGZ.add(locala);
            i += 1;
          }
        }
        paramBundle.GHd = ((j)localObject2).GIH;
        paramBundle.appUserName = ((j)localObject2).GIG;
        if ((!TextUtils.isEmpty(((j)localObject2).GIC)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).GIC))) {}
        for (paramBundle.GHe = Util.getInt(((j)localObject2).GIC, 0);; paramBundle.GHe = ((int)(System.currentTimeMillis() / 1000L))) {
          break;
        }
      }
      Log.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
      fmS();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66735);
    fmR();
    super.onDestroy();
    AppMethodBeat.o(66735);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66720);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.bF(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.bC(this);
      }
      AppMethodBeat.o(66720);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66720);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66721);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramq).GIf;
        Log.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          this.GIf = paramString;
          bzz();
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
    
    private MallOrderDetailObject.a aaT(int paramInt)
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
      paramInt = aaT(paramInt).type;
      AppMethodBeat.o(66715);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66714);
      MallOrderDetailObject.a locala = aaT(paramInt);
      switch (locala.type)
      {
      default: 
        if (paramView == null)
        {
          paramView = View.inflate(MallOrderDetailInfoUI.this, a.g.mall_order_action_list_item, null);
          paramViewGroup = new MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (byte)0);
          paramViewGroup.tzu = ((TextView)paramView.findViewById(a.f.order_action_item_title_tv));
          paramViewGroup.tAw = ((TextView)paramView.findViewById(a.f.order_action_item_subtitle_tv));
          paramViewGroup.tAx = ((TextView)paramView.findViewById(a.f.order_action_item_divider_tv));
          paramViewGroup.bvK = paramView.findViewById(a.f.order_action_item_content_layout);
          paramView.setTag(paramViewGroup);
          paramViewGroup.tzu.setText(locala.name);
          if (!TextUtils.isEmpty(locala.value)) {
            break label448;
          }
          paramViewGroup.tAw.setVisibility(4);
          label158:
          if (!locala.toi) {
            break label471;
          }
          paramViewGroup.tAx.setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        if (paramInt + 1 < getCount())
        {
          locala = aaT(paramInt + 1);
          MallOrderDetailInfoUI.b(paramViewGroup.bvK, locala);
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, a.g.mall_order_action_list_item_to_be_reted, null);
        paramViewGroup = paramView.findViewById(a.f.order_action_item_content_layout);
        MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(a.f.order_action_item_good_tv));
        MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(a.f.order_action_item_bad_tv));
        MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.GJb);
        MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.GJb);
        if (paramInt + 1 < getCount()) {
          MallOrderDetailInfoUI.b(paramViewGroup, aaT(paramInt + 1));
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
            MallOrderDetailInfoUI.b(localView, aaT(paramInt + 1));
          }
          AppMethodBeat.o(66714);
          return paramView;
          paramViewGroup.setText(a.i.mall_order_detail_rated_bad);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.h.mall_order_detail_bad, 0);
        }
        paramViewGroup = (MallOrderDetailInfoUI.b)paramView.getTag();
        break;
        label448:
        paramViewGroup.tAw.setVisibility(0);
        paramViewGroup.tAw.setText(locala.value);
        break label158;
        label471:
        paramViewGroup.tAx.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
  }
  
  final class b
  {
    View bvK;
    TextView tAw;
    TextView tAx;
    TextView tzu;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */