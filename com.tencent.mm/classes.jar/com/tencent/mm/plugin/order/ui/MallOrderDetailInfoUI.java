package com.tencent.mm.plugin.order.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.f;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI
  extends WalletBaseUI
  implements x.a
{
  private ListView Nn;
  private View.OnClickListener fvj = new MallOrderDetailInfoUI.1(this);
  private String iGK = "";
  private HashMap<String, View> mMl = new HashMap();
  private List<MallOrderDetailObject.a> mOz = new ArrayList();
  protected MallOrderDetailObject mPG = null;
  private boolean mQA = false;
  private boolean mQB = false;
  private int mQC = 0;
  private CheckedTextView mQD;
  private CheckedTextView mQE;
  View.OnClickListener mQF = new MallOrderDetailInfoUI.7(this);
  String mQr;
  private MallOrderDetailInfoUI.a mQs;
  private View mQt;
  private View mQu;
  private View mQv;
  private View mQw;
  private View mQx;
  private View mQy;
  private View mQz;
  
  private void XS()
  {
    if (this.mPG == null) {
      return;
    }
    x.a(this);
    this.mMl.clear();
    MallOrderDetailObject.b localb = this.mPG.mOx;
    Object localObject;
    if (localb != null)
    {
      localObject = localb.mOF;
      if (TextUtils.isEmpty(localb.mOG)) {
        break label1497;
      }
      localObject = (String)localObject + "：" + localb.mOG;
    }
    label331:
    label1495:
    label1497:
    for (;;)
    {
      if (!this.mQA)
      {
        this.mQu.setVisibility(8);
        this.mQt.setVisibility(0);
        ((TextView)this.mQt.findViewById(a.f.order_latest_status_title_tv)).setText((CharSequence)localObject);
        ((TextView)this.mQt.findViewById(a.f.order_latest_status_subtitle_tv)).setText(e.hP(this.mPG.mOE));
        if ((!TextUtils.isEmpty(localb.thumbUrl)) && (e.afi(localb.thumbUrl)))
        {
          l((ImageView)this.mQt.findViewById(a.f.order_merchant_logo_img), localb.thumbUrl);
          localObject = this.mPG.mOy;
          if ((localObject != null) && (((List)localObject).size() != 0)) {
            break label619;
          }
          this.mQx.setVisibility(8);
          this.mQy.setVisibility(8);
          this.mQz.setVisibility(8);
          label230:
          localObject = this.mPG.mOw;
          if (localObject == null) {
            break label1323;
          }
          this.mQv.setVisibility(0);
          ((TextView)findViewById(a.f.order_transaction_subtitle_tv)).setText(e.d(((MallTransactionObject)localObject).iHP, ((MallTransactionObject)localObject).mOZ));
          if ((this.mPG != null) && (this.mPG.mOz != null) && (this.mPG.mOz.size() > 0))
          {
            localObject = (MallOrderDetailObject.a)this.mPG.mOz.get(0);
            a(this.mQw, (MallOrderDetailObject.a)localObject);
          }
          localObject = this.mPG.mOz;
          if (localObject != null)
          {
            this.mOz.addAll((Collection)localObject);
            this.mQs.notifyDataSetChanged();
          }
          findViewById(a.f.mall_order_contact_layout).setVisibility(0);
          if ((this.mPG == null) || (!TextUtils.isEmpty(this.mPG.mOD)) || (!TextUtils.isEmpty(this.mPG.bNZ))) {
            break label1335;
          }
          findViewById(a.f.mall_order_contact_layout).setVisibility(8);
        }
      }
      for (;;)
      {
        if ((this.mPG == null) || (TextUtils.isEmpty(this.mPG.mOC))) {
          break label1495;
        }
        addIconOptionMenu(0, a.e.mm_title_btn_menu, new MallOrderDetailInfoUI.4(this));
        return;
        f((ImageView)this.mQt.findViewById(a.f.order_merchant_logo_img));
        break;
        this.mQt.setVisibility(8);
        this.mQu.setVisibility(0);
        ((TextView)this.mQu.findViewById(a.f.order_latest_status_title_tv)).setText((CharSequence)localObject);
        ((TextView)this.mQu.findViewById(a.f.order_latest_status_subtitle_tv)).setText(e.hP(this.mPG.mOE));
        if ((!TextUtils.isEmpty(localb.thumbUrl)) && (e.afi(localb.thumbUrl)))
        {
          l((ImageView)this.mQu.findViewById(a.f.order_merchant_logo_img), localb.thumbUrl);
          break;
        }
        f((ImageView)this.mQu.findViewById(a.f.order_merchant_logo_img));
        break;
        this.mQt.setVisibility(8);
        this.mQu.setVisibility(8);
        break;
        label619:
        if (((List)localObject).size() == 1)
        {
          this.mQz.setVisibility(8);
          localObject = (ProductSectionItem)((List)localObject).get(0);
          if (!TextUtils.isEmpty(((ProductSectionItem)localObject).iconUrl))
          {
            this.mQx.setVisibility(8);
            this.mQy.setVisibility(0);
            ((TextView)this.mQy.findViewById(a.f.item_product_descript_tv)).setText(((ProductSectionItem)localObject).name);
            ((TextView)this.mQy.findViewById(a.f.item_product_price_tv)).setText(((ProductSectionItem)localObject).mQn);
            ((TextView)this.mQy.findViewById(a.f.item_product_count_tv)).setText("+" + ((ProductSectionItem)localObject).count);
            ((TextView)this.mQy.findViewById(a.f.item_product_catalog_tv)).setText(ProductSectionItem.Skus.bT(((ProductSectionItem)localObject).mQm));
            if (TextUtils.isEmpty(((ProductSectionItem)localObject).iconUrl)) {
              break label230;
            }
            l((ImageView)this.mQy.findViewById(a.f.item_product_logo_img), ((ProductSectionItem)localObject).iconUrl);
            break label230;
          }
          this.mQy.setVisibility(8);
          this.mQx.setVisibility(0);
          ((TextView)this.mQx.findViewById(a.f.item_product_descript_tv)).setText(((ProductSectionItem)localObject).name);
          if (TextUtils.isEmpty(((ProductSectionItem)localObject).jumpUrl))
          {
            localObject = new Rect();
            ((Rect)localObject).set(this.mQx.findViewById(a.f.item_product_descript_layout).getPaddingLeft(), this.mQx.findViewById(a.f.item_product_descript_layout).getPaddingTop(), this.mQx.findViewById(a.f.item_product_descript_layout).getPaddingRight(), this.mQx.findViewById(a.f.item_product_descript_layout).getPaddingBottom());
            this.mQx.findViewById(a.f.item_product_descript_layout).setBackgroundResource(a.e.list_item_normal);
            this.mQx.findViewById(a.f.item_product_descript_layout).setPadding(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
            break label230;
          }
          ((TextView)this.mQx.findViewById(a.f.item_product_descript_tv)).setTextColor(getResources().getColor(a.c.mall_order_detail_item_title_color));
          break label230;
        }
        this.mQx.setVisibility(8);
        this.mQy.setVisibility(8);
        this.mQz.setVisibility(0);
        if (((List)localObject).size() == 2)
        {
          a(this.mQz.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)((List)localObject).get(0));
          a(this.mQz.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)((List)localObject).get(1));
          this.mQz.findViewById(a.f.order_product_item_x4_3_layout).setVisibility(8);
          this.mQz.findViewById(a.f.order_product_item_x4_4_layout).setVisibility(8);
          break label230;
        }
        if (((List)localObject).size() == 3)
        {
          a(this.mQz.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)((List)localObject).get(0));
          a(this.mQz.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)((List)localObject).get(1));
          a(this.mQz.findViewById(a.f.order_product_item_x4_3_layout), (ProductSectionItem)((List)localObject).get(2));
          this.mQz.findViewById(a.f.order_product_item_x4_4_layout).setVisibility(8);
          break label230;
        }
        if (((List)localObject).size() < 4) {
          break label230;
        }
        a(this.mQz.findViewById(a.f.order_product_item_x4_1_layout), (ProductSectionItem)((List)localObject).get(0));
        a(this.mQz.findViewById(a.f.order_product_item_x4_2_layout), (ProductSectionItem)((List)localObject).get(1));
        a(this.mQz.findViewById(a.f.order_product_item_x4_3_layout), (ProductSectionItem)((List)localObject).get(2));
        a(this.mQz.findViewById(a.f.order_product_item_x4_4_layout), (ProductSectionItem)((List)localObject).get(3));
        break label230;
        this.mQv.setVisibility(8);
        break label331;
        if ((this.mPG != null) && (!TextUtils.isEmpty(this.mPG.mOD)) && (TextUtils.isEmpty(this.mPG.bNZ)))
        {
          findViewById(a.f.wx_contact_service_title_tv).setVisibility(8);
          findViewById(a.f.wx_contact_divider_tv).setVisibility(8);
          localObject = (TextView)findViewById(a.f.hot_contact_phone_title_tv);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setGravity(3);
        }
        else if ((this.mPG != null) && (TextUtils.isEmpty(this.mPG.mOD)) && (!TextUtils.isEmpty(this.mPG.bNZ)))
        {
          findViewById(a.f.hot_contact_phone_title_tv).setVisibility(8);
          findViewById(a.f.wx_contact_divider_tv).setVisibility(8);
          localObject = (TextView)findViewById(a.f.wx_contact_service_title_tv);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setGravity(3);
        }
      }
      break;
    }
  }
  
  private static void a(View paramView, MallOrderDetailObject.a parama)
  {
    if (parama == null) {
      return;
    }
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if ((parama != null) && (parama.ilA)) {
      paramView.setBackgroundResource(a.e.mm_trans);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      return;
      paramView.setBackgroundResource(a.e.list_item_normal);
    }
  }
  
  private void a(View paramView, ProductSectionItem paramProductSectionItem)
  {
    if ((paramView == null) || (paramProductSectionItem == null)) {}
    do
    {
      return;
      paramView.setVisibility(0);
      TextView localTextView = (TextView)paramView.findViewById(a.f.item_product_descript_tv);
      if (localTextView != null) {
        localTextView.setText(paramProductSectionItem.name);
      }
    } while (TextUtils.isEmpty(paramProductSectionItem.iconUrl));
    l((ImageView)paramView.findViewById(a.f.item_product_logo_img), paramProductSectionItem.iconUrl);
  }
  
  private void brG()
  {
    if ((!this.mQB) && (this.mQC != 0))
    {
      g.DQ();
      g.DO().dJT.a(new f(this.iGK, "", this.mQC), 0);
      this.mQB = true;
    }
  }
  
  private void brH()
  {
    com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new MallOrderDetailInfoUI.8(this));
  }
  
  private void f(ImageView paramImageView)
  {
    Bitmap localBitmap = com.tencent.mm.compatible.g.a.decodeResource(getResources(), a.h.mall_order_trade_state_icon);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(localBitmap, false, 96.0F));
    }
  }
  
  private void l(ImageView paramImageView, String paramString)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)) || (!e.afi(paramString))) {
      return;
    }
    paramImageView.setImageBitmap(x.a(new com.tencent.mm.plugin.order.c.b(paramString)));
    this.mMl.put(paramString, paramImageView);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramm).mPG;
        y.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:" + paramString);
        if (paramString != null)
        {
          this.mPG = paramString;
          XS();
        }
      }
      return true;
    }
    return false;
  }
  
  public void finish()
  {
    brG();
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.mall_order_detail_info_ui;
  }
  
  protected final void initView()
  {
    int i;
    if (this.mQA)
    {
      com.tencent.mm.plugin.order.a.b.brv();
      j localj = com.tencent.mm.plugin.order.a.b.bry().KI(this.iGK);
      if ((localj != null) && (!TextUtils.isEmpty(localj.mQc)) && (com.tencent.mm.plugin.order.c.c.yS(localj.mQc)))
      {
        i = Integer.valueOf(localj.mQc).intValue();
        if (i != 2) {
          break label313;
        }
        setMMTitle(a.i.mall_order_detail_ui_for_notify_title);
      }
    }
    for (;;)
    {
      this.mQt = findViewById(a.f.order_latest_status_info_layout);
      this.mQu = findViewById(a.f.order_latest_status_info_for_msg_layout);
      this.mQy = findViewById(a.f.order_product_item_text_x4);
      this.mQz = findViewById(a.f.order_product_item_icon_text_x4);
      this.mQx = findViewById(a.f.order_product_item_text_x1);
      this.mQv = findViewById(a.f.order_transaction_info_parent_layout);
      this.mQw = findViewById(a.f.order_transaction_info_layout);
      this.mQt.setOnClickListener(this.fvj);
      this.mQz.setOnClickListener(this.fvj);
      this.mQy.setOnClickListener(this.fvj);
      this.mQx.setOnClickListener(this.fvj);
      this.mQv.setOnClickListener(this.fvj);
      findViewById(a.f.order_confirm_result_btn).setOnClickListener(this.fvj);
      findViewById(a.f.hot_contact_phone_title_tv).setOnClickListener(this.fvj);
      findViewById(a.f.wx_contact_service_title_tv).setOnClickListener(this.fvj);
      this.Nn = ((ListView)findViewById(a.f.order_action_list));
      this.mQs = new MallOrderDetailInfoUI.a(this, (byte)0);
      this.Nn.setAdapter(this.mQs);
      this.mQs.notifyDataSetChanged();
      this.Nn.setOnItemClickListener(new MallOrderDetailInfoUI.6(this));
      XS();
      return;
      i = -1;
      break;
      label313:
      if (i == 1)
      {
        setMMTitle(a.i.mall_order_detail_ui_for_reminder_title);
        continue;
        setMMTitle(a.i.mall_order_detail_ui_title);
      }
    }
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.mMl.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.wallet_core.a.aj(this);
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      paramBundle = this.BX.getString("key_trans_id");
      this.iGK = paramBundle;
      if (paramBundle == null) {
        break label79;
      }
      com.tencent.mm.plugin.order.a.b.brv();
      if (com.tencent.mm.plugin.order.a.b.bry().KH(paramBundle)) {
        break label79;
      }
      this.mQA = false;
      a(new com.tencent.mm.plugin.order.model.h(paramBundle), true, true);
    }
    for (;;)
    {
      initView();
      return;
      label79:
      com.tencent.mm.plugin.order.a.b.brv();
      if (com.tencent.mm.plugin.order.a.b.bry().KH(paramBundle))
      {
        this.mQA = true;
        com.tencent.mm.plugin.order.a.b.brv();
        com.tencent.mm.plugin.order.model.c localc = com.tencent.mm.plugin.order.a.b.bry();
        if (TextUtils.isEmpty(paramBundle)) {}
        for (paramBundle = null;; paramBundle = com.tencent.mm.plugin.order.model.c.a(localc.KI(paramBundle)))
        {
          this.mPG = paramBundle;
          if (this.mPG != null) {
            break;
          }
          brH();
          break;
          y.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:" + paramBundle);
        }
      }
      y.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
      brH();
    }
  }
  
  public void onDestroy()
  {
    brG();
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.aj(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.ag(this);
      }
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void st(int paramInt)
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */