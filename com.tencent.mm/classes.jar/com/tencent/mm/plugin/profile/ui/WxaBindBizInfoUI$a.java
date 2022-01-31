package com.tencent.mm.plugin.profile.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

final class WxaBindBizInfoUI$a
  extends BaseAdapter
{
  private List<WxaAttributes.WxaEntryInfo> jfV;
  private LayoutInflater mInflater;
  
  public WxaBindBizInfoUI$a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(143681);
    this.mInflater = paramLayoutInflater;
    this.jfV = new LinkedList();
    if (paramList != null) {
      this.jfV.addAll(paramList);
    }
    AppMethodBeat.o(143681);
  }
  
  private WxaAttributes.WxaEntryInfo Bs(int paramInt)
  {
    AppMethodBeat.i(143683);
    WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.jfV.get(paramInt);
    AppMethodBeat.o(143683);
    return localWxaEntryInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(143682);
    int i = this.jfV.size();
    AppMethodBeat.o(143682);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(143684);
    WxaAttributes.WxaEntryInfo localWxaEntryInfo;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130968708, paramViewGroup, false);
      paramViewGroup = new WxaBindBizInfoUI.a.a((byte)0);
      paramViewGroup.iQd = ((ImageView)paramView.findViewById(2131820929));
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131820650));
      paramViewGroup.hsI = ((TextView)paramView.findViewById(2131821213));
      paramViewGroup.gqg = paramView.findViewById(2131821148);
      paramView.setTag(paramViewGroup);
      localWxaEntryInfo = Bs(paramInt);
      b.acD().a(paramViewGroup.iQd, localWxaEntryInfo.iconUrl, a.acC(), f.fqU);
      paramViewGroup.titleTv.setText(bo.nullAsNil(localWxaEntryInfo.title));
      if (!bo.isNullOrNil(localWxaEntryInfo.hkc)) {
        break label201;
      }
      paramViewGroup.hsI.setVisibility(8);
      label148:
      if (this.jfV != null)
      {
        paramViewGroup = paramViewGroup.gqg;
        if (this.jfV.size() - 1 != paramInt) {
          break label224;
        }
      }
    }
    label201:
    label224:
    for (paramInt = 8;; paramInt = 0)
    {
      paramViewGroup.setVisibility(paramInt);
      AppMethodBeat.o(143684);
      return paramView;
      paramViewGroup = (WxaBindBizInfoUI.a.a)paramView.getTag();
      break;
      paramViewGroup.hsI.setVisibility(0);
      paramViewGroup.hsI.setText(localWxaEntryInfo.hkc);
      break label148;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI.a
 * JD-Core Version:    0.7.0.1
 */