package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.e;
import com.tencent.mm.plugin.sns.storage.ADXml.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private String Ejr;
  public e KAz;
  private final Context mContext;
  public int oxQ;
  
  public c(Context paramContext, e parame)
  {
    AppMethodBeat.i(97694);
    this.KAz = null;
    this.Ejr = null;
    this.oxQ = 0;
    this.mContext = paramContext;
    this.KAz = parame;
    this.Ejr = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(97694);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(97695);
    if (this.oxQ == 1)
    {
      i = this.KAz.JPW.LeY.adUnlikeInfo.fQA().size();
      AppMethodBeat.o(97695);
      return i;
    }
    int i = 0;
    if (this.KAz.JPW.LeX.adFeedbackInfo != null) {
      i = this.KAz.JPW.LeX.adFeedbackInfo.list.size();
    }
    AppMethodBeat.o(97695);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(97697);
    Object localObject = this.KAz.JPW.LeY.adUnlikeInfo.fQA().get(paramInt);
    AppMethodBeat.o(97697);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(97696);
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(this.mContext, i.g.ad_unlike_reason_item, null);
    }
    localView.setTag(this.KAz);
    paramViewGroup = "";
    Object localObject;
    if (this.oxQ == 1)
    {
      localObject = (ADInfo.c.a)getItem(paramInt);
      if ("zh_CN".equals(this.Ejr))
      {
        paramViewGroup = ((ADInfo.c.a)localObject).Kjk;
        paramView = paramViewGroup;
        if (Util.isNullOrNil(paramViewGroup)) {
          paramView = ((ADInfo.c.a)localObject).Kjm;
        }
        label88:
        paramViewGroup = (TextView)localView.findViewById(i.f.ad_unlike_reason_tv);
        if (!this.KAz.JPW.LeY.forbidClick) {
          break label469;
        }
        paramViewGroup.setTextColor(this.mContext.getResources().getColor(i.c.BW_0_Alpha_0_2));
        label133:
        paramViewGroup.setText(paramView);
        paramView = localView.findViewById(i.f.ad_unlike_reason_sep);
        if (paramInt != getCount() - 1) {
          break label489;
        }
      }
    }
    label321:
    label469:
    label489:
    for (paramInt = 8;; paramInt = 0)
    {
      paramView.setVisibility(paramInt);
      AppMethodBeat.o(97696);
      return localView;
      if (("zh_TW".equals(this.Ejr)) || ("zh_HK".equals(this.Ejr)))
      {
        paramViewGroup = ((ADInfo.c.a)localObject).Kjl;
        break;
      }
      paramViewGroup = ((ADInfo.c.a)localObject).Kjm;
      break;
      if (paramInt == 0)
      {
        paramView = paramViewGroup;
        if (this.KAz == null) {
          break label88;
        }
        paramView = paramViewGroup;
        if (this.KAz.JPW.LeX == null) {
          break label88;
        }
        paramView = this.KAz.JPW.LeY;
        if ("zh_CN".equals(this.Ejr)) {
          paramView = paramView.adDislikeInfoTitle_cn;
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramView)) {
            break label321;
          }
          break;
          if (("zh_TW".equals(this.Ejr)) || ("zh_HK".equals(this.Ejr))) {
            paramView = paramView.adDislikeInfoTitle_tw;
          } else {
            paramView = paramView.adDislikeInfoTitle_en;
          }
        }
        paramView = this.mContext.getString(i.j.sns_ad_unlike);
        break label88;
      }
      localObject = this.KAz.JPW.LeX.adFeedbackInfo;
      paramView = paramViewGroup;
      if (localObject == null) {
        break label88;
      }
      paramView = paramViewGroup;
      if (paramInt > ((ADXml.e)localObject).list.size()) {
        break label88;
      }
      localObject = (ADXml.f)((ADXml.e)localObject).list.get(paramInt - 1);
      if ("zh_CN".equals(this.Ejr)) {
        paramViewGroup = ((ADXml.f)localObject).KjF;
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (!Util.isNullOrNil(paramViewGroup)) {
          break;
        }
        paramView = ((ADXml.f)localObject).Kdw;
        break;
        if (("zh_TW".equals(this.Ejr)) || ("zh_HK".equals(this.Ejr))) {
          paramViewGroup = ((ADXml.f)localObject).KjG;
        } else {
          paramViewGroup = ((ADXml.f)localObject).Kdw;
        }
      }
      paramViewGroup.setTextColor(this.mContext.getResources().getColor(i.c.Link));
      break label133;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c
 * JD-Core Version:    0.7.0.1
 */