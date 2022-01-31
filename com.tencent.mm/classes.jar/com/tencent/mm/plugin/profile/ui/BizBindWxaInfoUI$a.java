package com.tencent.mm.plugin.profile.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.List;

final class BizBindWxaInfoUI$a
  extends BaseAdapter
{
  private LayoutInflater Lu;
  private List<WxaAttributes.WxaEntryInfo> heL;
  
  public BizBindWxaInfoUI$a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    this.Lu = paramLayoutInflater;
    this.heL = new LinkedList();
    if (paramList != null) {
      this.heL.addAll(paramList);
    }
  }
  
  private WxaAttributes.WxaEntryInfo mp(int paramInt)
  {
    return (WxaAttributes.WxaEntryInfo)this.heL.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.heL.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.Lu.inflate(y.h.app_brand_launcher_recents_item_as_normal, paramViewGroup, false);
      paramViewGroup = new BizBindWxaInfoUI.a.a((byte)0);
      paramViewGroup.heN = ((ImageView)paramView.findViewById(y.g.icon));
      paramViewGroup.eXr = ((TextView)paramView.findViewById(y.g.primary_text));
      paramViewGroup.eYp = paramView.findViewById(y.g.divider);
      paramView.setTag(paramViewGroup);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = mp(paramInt);
      b.JD().a(paramViewGroup.heN, localWxaEntryInfo.iconUrl, a.JC(), f.eaL);
      paramViewGroup.eXr.setText(bk.pm(localWxaEntryInfo.title));
      if (this.heL != null)
      {
        paramViewGroup = paramViewGroup.eYp;
        if (this.heL.size() - 1 != paramInt) {
          break label162;
        }
      }
    }
    label162:
    for (paramInt = 8;; paramInt = 0)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (BizBindWxaInfoUI.a.a)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI.a
 * JD-Core Version:    0.7.0.1
 */