package com.tencent.mm.plugin.order.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class MallOrderDetailInfoUI$a
  extends BaseAdapter
{
  private MallOrderDetailInfoUI$a(MallOrderDetailInfoUI paramMallOrderDetailInfoUI) {}
  
  private MallOrderDetailObject.a vI(int paramInt)
  {
    return (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(this.mQG).get(paramInt);
  }
  
  public final int getCount()
  {
    return MallOrderDetailInfoUI.e(this.mQG).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return vI(paramInt).type;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MallOrderDetailObject.a locala = vI(paramInt);
    Object localObject;
    switch (locala.type)
    {
    default: 
      if (paramView == null)
      {
        paramViewGroup = View.inflate(this.mQG, a.g.mall_order_action_list_item, null);
        localObject = new MallOrderDetailInfoUI.b(this.mQG, (byte)0);
        ((MallOrderDetailInfoUI.b)localObject).iwq = ((TextView)paramViewGroup.findViewById(a.f.order_action_item_title_tv));
        ((MallOrderDetailInfoUI.b)localObject).ixt = ((TextView)paramViewGroup.findViewById(a.f.order_action_item_subtitle_tv));
        ((MallOrderDetailInfoUI.b)localObject).ixu = ((TextView)paramViewGroup.findViewById(a.f.order_action_item_divider_tv));
        ((MallOrderDetailInfoUI.b)localObject).hNa = paramViewGroup.findViewById(a.f.order_action_item_content_layout);
        paramViewGroup.setTag(localObject);
        ((MallOrderDetailInfoUI.b)localObject).iwq.setText(locala.name);
        if (!TextUtils.isEmpty(locala.value)) {
          break label450;
        }
        ((MallOrderDetailInfoUI.b)localObject).ixt.setVisibility(4);
        label162:
        if (!locala.ilA) {
          break label475;
        }
        ((MallOrderDetailInfoUI.b)localObject).ixu.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      paramView = paramViewGroup;
      if (paramInt + 1 < getCount())
      {
        paramView = vI(paramInt + 1);
        MallOrderDetailInfoUI.b(((MallOrderDetailInfoUI.b)localObject).hNa, paramView);
        paramView = paramViewGroup;
      }
      do
      {
        return paramView;
        paramViewGroup = View.inflate(this.mQG, a.g.mall_order_action_list_item_to_be_reted, null);
        localObject = paramViewGroup.findViewById(a.f.order_action_item_content_layout);
        MallOrderDetailInfoUI.a(this.mQG, (CheckedTextView)paramViewGroup.findViewById(a.f.order_action_item_good_tv));
        MallOrderDetailInfoUI.b(this.mQG, (CheckedTextView)paramViewGroup.findViewById(a.f.order_action_item_bad_tv));
        MallOrderDetailInfoUI.f(this.mQG).setOnClickListener(this.mQG.mQF);
        MallOrderDetailInfoUI.g(this.mQG).setOnClickListener(this.mQG.mQF);
        paramView = paramViewGroup;
      } while (paramInt + 1 >= getCount());
      MallOrderDetailInfoUI.b((View)localObject, vI(paramInt + 1));
      return paramViewGroup;
      paramViewGroup = View.inflate(this.mQG, a.g.mall_order_action_list_item_reted, null);
      paramView = (TextView)paramViewGroup.findViewById(a.f.order_action_item_bad_tv);
      localObject = paramViewGroup.findViewById(a.f.order_action_item_content_layout);
      if (bk.getInt(locala.value, 0) >= 0)
      {
        paramView.setText(a.i.mall_order_detail_rated_good);
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.h.mall_order_detail_good, 0);
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (paramInt + 1 >= getCount()) {
          break;
        }
        MallOrderDetailInfoUI.b((View)localObject, vI(paramInt + 1));
        return paramViewGroup;
        paramView.setText(a.i.mall_order_detail_rated_bad);
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.h.mall_order_detail_bad, 0);
      }
      localObject = (MallOrderDetailInfoUI.b)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label450:
      ((MallOrderDetailInfoUI.b)localObject).ixt.setVisibility(0);
      ((MallOrderDetailInfoUI.b)localObject).ixt.setText(locala.value);
      break label162;
      label475:
      ((MallOrderDetailInfoUI.b)localObject).ixu.setVisibility(8);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.a
 * JD-Core Version:    0.7.0.1
 */