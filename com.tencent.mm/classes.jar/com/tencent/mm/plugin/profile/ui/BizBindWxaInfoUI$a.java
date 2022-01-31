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

final class BizBindWxaInfoUI$a
  extends BaseAdapter
{
  private List<WxaAttributes.WxaEntryInfo> jfV;
  private LayoutInflater mInflater;
  
  public BizBindWxaInfoUI$a(LayoutInflater paramLayoutInflater, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(134414);
    this.mInflater = paramLayoutInflater;
    this.jfV = new LinkedList();
    if (paramList != null) {
      this.jfV.addAll(paramList);
    }
    AppMethodBeat.o(134414);
  }
  
  private WxaAttributes.WxaEntryInfo Bs(int paramInt)
  {
    AppMethodBeat.i(134416);
    WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.jfV.get(paramInt);
    AppMethodBeat.o(134416);
    return localWxaEntryInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(134415);
    int i = this.jfV.size();
    AppMethodBeat.o(134415);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(134417);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130968695, paramViewGroup, false);
      paramViewGroup = new BizBindWxaInfoUI.a.a((byte)0);
      paramViewGroup.iQd = ((ImageView)paramView.findViewById(2131820929));
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131820650));
      paramViewGroup.gqg = paramView.findViewById(2131821148);
      paramView.setTag(paramViewGroup);
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = Bs(paramInt);
      b.acD().a(paramViewGroup.iQd, localWxaEntryInfo.iconUrl, a.acC(), f.fqU);
      paramViewGroup.titleTv.setText(bo.nullAsNil(localWxaEntryInfo.title));
      if (this.jfV != null)
      {
        paramViewGroup = paramViewGroup.gqg;
        if (this.jfV.size() - 1 != paramInt) {
          break label168;
        }
      }
    }
    label168:
    for (paramInt = 8;; paramInt = 0)
    {
      paramViewGroup.setVisibility(paramInt);
      AppMethodBeat.o(134417);
      return paramView;
      paramViewGroup = (BizBindWxaInfoUI.a.a)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI.a
 * JD-Core Version:    0.7.0.1
 */