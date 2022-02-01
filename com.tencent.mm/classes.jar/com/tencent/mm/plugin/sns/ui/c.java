package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public com.tencent.mm.plugin.sns.data.c Enq;
  public int lCq;
  private final Context mContext;
  private String yFy;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.data.c paramc)
  {
    AppMethodBeat.i(97694);
    this.Enq = null;
    this.yFy = null;
    this.lCq = 0;
    this.mContext = paramContext;
    this.Enq = paramc;
    this.yFy = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(97694);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(97695);
    if (this.lCq == 1)
    {
      i = this.Enq.DDr.EQZ.adUnlikeInfo.fcH().size();
      AppMethodBeat.o(97695);
      return i;
    }
    int i = 0;
    if (this.Enq.DDr.EQY.adFeedbackInfo != null) {
      i = this.Enq.DDr.EQY.adFeedbackInfo.list.size();
    }
    AppMethodBeat.o(97695);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(97697);
    Object localObject = this.Enq.DDr.EQZ.adUnlikeInfo.fcH().get(paramInt);
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
      localView = View.inflate(this.mContext, 2131492974, null);
    }
    localView.setTag(this.Enq);
    paramViewGroup = "";
    Object localObject;
    if (this.lCq == 1)
    {
      localObject = (ADInfo.c.a)getItem(paramInt);
      if ("zh_CN".equals(this.yFy))
      {
        paramViewGroup = ((ADInfo.c.a)localObject).DWa;
        paramView = paramViewGroup;
        if (Util.isNullOrNil(paramViewGroup)) {
          paramView = ((ADInfo.c.a)localObject).DWc;
        }
        label87:
        paramViewGroup = (TextView)localView.findViewById(2131296515);
        if (!this.Enq.DDr.EQZ.forbidClick) {
          break label464;
        }
        paramViewGroup.setTextColor(this.mContext.getResources().getColor(2131099660));
        label130:
        paramViewGroup.setText(paramView);
        paramView = localView.findViewById(2131296514);
        if (paramInt != getCount() - 1) {
          break label483;
        }
      }
    }
    label317:
    label464:
    label483:
    for (paramInt = 8;; paramInt = 0)
    {
      paramView.setVisibility(paramInt);
      AppMethodBeat.o(97696);
      return localView;
      if (("zh_TW".equals(this.yFy)) || ("zh_HK".equals(this.yFy)))
      {
        paramViewGroup = ((ADInfo.c.a)localObject).DWb;
        break;
      }
      paramViewGroup = ((ADInfo.c.a)localObject).DWc;
      break;
      if (paramInt == 0)
      {
        paramView = paramViewGroup;
        if (this.Enq == null) {
          break label87;
        }
        paramView = paramViewGroup;
        if (this.Enq.DDr.EQY == null) {
          break label87;
        }
        paramView = this.Enq.DDr.EQZ;
        if ("zh_CN".equals(this.yFy)) {
          paramView = paramView.adDislikeInfoTitle_cn;
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramView)) {
            break label317;
          }
          break;
          if (("zh_TW".equals(this.yFy)) || ("zh_HK".equals(this.yFy))) {
            paramView = paramView.adDislikeInfoTitle_tw;
          } else {
            paramView = paramView.adDislikeInfoTitle_en;
          }
        }
        paramView = this.mContext.getString(2131765988);
        break label87;
      }
      localObject = this.Enq.DDr.EQY.adFeedbackInfo;
      paramView = paramViewGroup;
      if (localObject == null) {
        break label87;
      }
      paramView = paramViewGroup;
      if (paramInt > ((ADXml.e)localObject).list.size()) {
        break label87;
      }
      localObject = (ADXml.f)((ADXml.e)localObject).list.get(paramInt - 1);
      if ("zh_CN".equals(this.yFy)) {
        paramViewGroup = ((ADXml.f)localObject).DWu;
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (!Util.isNullOrNil(paramViewGroup)) {
          break;
        }
        paramView = ((ADXml.f)localObject).DQp;
        break;
        if (("zh_TW".equals(this.yFy)) || ("zh_HK".equals(this.yFy))) {
          paramViewGroup = ((ADXml.f)localObject).DWv;
        } else {
          paramViewGroup = ((ADXml.f)localObject).DQp;
        }
      }
      paramViewGroup.setTextColor(this.mContext.getResources().getColor(2131099783));
      break label130;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c
 * JD-Core Version:    0.7.0.1
 */