package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c
  extends BaseAdapter
{
  public int ghE = 0;
  private String lCN = null;
  private final Context mContext;
  public com.tencent.mm.plugin.sns.data.b oMm = null;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.data.b paramb)
  {
    this.mContext = paramContext;
    this.oMm = paramb;
    this.lCN = x.fB(ae.getContext());
  }
  
  public final int getCount()
  {
    if (this.ghE == 1) {
      return this.oMm.omM.pjN.oAp.bED().size();
    }
    int i = 0;
    if (this.oMm.omM.pjM.oBz != null) {
      i = this.oMm.omM.pjM.oBz.list.size();
    }
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.oMm.omM.pjN.oAp.bED().get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(this.mContext, i.g.ad_unlike_reason_item, null);
    }
    localView.setTag(this.oMm);
    paramViewGroup = "";
    Object localObject;
    if (this.ghE == 1)
    {
      localObject = (a.b.a)getItem(paramInt);
      if ("zh_CN".equals(this.lCN))
      {
        paramViewGroup = ((a.b.a)localObject).oAz;
        paramView = paramViewGroup;
        if (bk.bl(paramViewGroup)) {
          paramView = ((a.b.a)localObject).oAB;
        }
        label83:
        paramViewGroup = (TextView)localView.findViewById(i.f.ad_unlike_reason_tv);
        if (!this.oMm.omM.pjN.oAt) {
          break label451;
        }
        paramViewGroup.setTextColor(Color.parseColor("#3A3A3A"));
        label120:
        paramViewGroup.setText(paramView);
        paramView = localView.findViewById(i.f.ad_unlike_reason_sep);
        if (paramInt != getCount() - 1) {
          break label463;
        }
      }
    }
    label303:
    label451:
    label463:
    for (paramInt = 8;; paramInt = 0)
    {
      paramView.setVisibility(paramInt);
      return localView;
      if (("zh_TW".equals(this.lCN)) || ("zh_HK".equals(this.lCN)))
      {
        paramViewGroup = ((a.b.a)localObject).oAA;
        break;
      }
      paramViewGroup = ((a.b.a)localObject).oAB;
      break;
      if (paramInt == 0)
      {
        paramView = paramViewGroup;
        if (this.oMm == null) {
          break label83;
        }
        paramView = paramViewGroup;
        if (this.oMm.omM.pjM == null) {
          break label83;
        }
        paramView = this.oMm.omM.pjN;
        if ("zh_CN".equals(this.lCN)) {
          paramView = paramView.oAq;
        }
        for (;;)
        {
          if (bk.bl(paramView)) {
            break label303;
          }
          break;
          if (("zh_TW".equals(this.lCN)) || ("zh_HK".equals(this.lCN))) {
            paramView = paramView.oAs;
          } else {
            paramView = paramView.oAr;
          }
        }
        paramView = this.mContext.getString(i.j.sns_ad_unlike);
        break label83;
      }
      localObject = this.oMm.omM.pjM.oBz;
      paramView = paramViewGroup;
      if (localObject == null) {
        break label83;
      }
      paramView = paramViewGroup;
      if (paramInt > ((b.a)localObject).list.size()) {
        break label83;
      }
      localObject = (b.b)((b.a)localObject).list.get(paramInt - 1);
      if ("zh_CN".equals(this.lCN)) {
        paramViewGroup = ((b.b)localObject).oBI;
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (!bk.bl(paramViewGroup)) {
          break;
        }
        paramView = ((b.b)localObject).ovu;
        break;
        if (("zh_TW".equals(this.lCN)) || ("zh_HK".equals(this.lCN))) {
          paramViewGroup = ((b.b)localObject).oBJ;
        } else {
          paramViewGroup = ((b.b)localObject).ovu;
        }
      }
      paramViewGroup.setTextColor(Color.parseColor("#576B95"));
      break label120;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c
 * JD-Core Version:    0.7.0.1
 */