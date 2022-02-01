package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class c
  extends BaseAdapter
{
  public com.tencent.mm.plugin.sns.data.b AeT;
  public int kyd;
  private final Context mContext;
  private String vlG;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(97694);
    this.AeT = null;
    this.vlG = null;
    this.kyd = 0;
    this.mContext = paramContext;
    this.AeT = paramb;
    this.vlG = ad.iR(ak.getContext());
    AppMethodBeat.o(97694);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(97695);
    if (this.kyd == 1)
    {
      i = this.AeT.ztd.AHi.zMo.dZs().size();
      AppMethodBeat.o(97695);
      return i;
    }
    int i = 0;
    if (this.AeT.ztd.AHh.zNM != null) {
      i = this.AeT.ztd.AHh.zNM.list.size();
    }
    AppMethodBeat.o(97695);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(97697);
    Object localObject = this.AeT.ztd.AHi.zMo.dZs().get(paramInt);
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
      localView = View.inflate(this.mContext, 2131492941, null);
    }
    localView.setTag(this.AeT);
    paramViewGroup = "";
    Object localObject;
    if (this.kyd == 1)
    {
      localObject = (a.c.a)getItem(paramInt);
      if ("zh_CN".equals(this.vlG))
      {
        paramViewGroup = ((a.c.a)localObject).zMH;
        paramView = paramViewGroup;
        if (bu.isNullOrNil(paramViewGroup)) {
          paramView = ((a.c.a)localObject).zMJ;
        }
        label87:
        paramViewGroup = (TextView)localView.findViewById(2131296444);
        if (!this.AeT.ztd.AHi.zMs) {
          break label464;
        }
        paramViewGroup.setTextColor(this.mContext.getResources().getColor(2131099658));
        label130:
        paramViewGroup.setText(paramView);
        paramView = localView.findViewById(2131296443);
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
      if (("zh_TW".equals(this.vlG)) || ("zh_HK".equals(this.vlG)))
      {
        paramViewGroup = ((a.c.a)localObject).zMI;
        break;
      }
      paramViewGroup = ((a.c.a)localObject).zMJ;
      break;
      if (paramInt == 0)
      {
        paramView = paramViewGroup;
        if (this.AeT == null) {
          break label87;
        }
        paramView = paramViewGroup;
        if (this.AeT.ztd.AHh == null) {
          break label87;
        }
        paramView = this.AeT.ztd.AHi;
        if ("zh_CN".equals(this.vlG)) {
          paramView = paramView.zMp;
        }
        for (;;)
        {
          if (bu.isNullOrNil(paramView)) {
            break label317;
          }
          break;
          if (("zh_TW".equals(this.vlG)) || ("zh_HK".equals(this.vlG))) {
            paramView = paramView.zMr;
          } else {
            paramView = paramView.zMq;
          }
        }
        paramView = this.mContext.getString(2131763767);
        break label87;
      }
      localObject = this.AeT.ztd.AHh.zNM;
      paramView = paramViewGroup;
      if (localObject == null) {
        break label87;
      }
      paramView = paramViewGroup;
      if (paramInt > ((b.f)localObject).list.size()) {
        break label87;
      }
      localObject = (b.g)((b.f)localObject).list.get(paramInt - 1);
      if ("zh_CN".equals(this.vlG)) {
        paramViewGroup = ((b.g)localObject).zOC;
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (!bu.isNullOrNil(paramViewGroup)) {
          break;
        }
        paramView = ((b.g)localObject).zGp;
        break;
        if (("zh_TW".equals(this.vlG)) || ("zh_HK".equals(this.vlG))) {
          paramViewGroup = ((b.g)localObject).zOD;
        } else {
          paramViewGroup = ((b.g)localObject).zGp;
        }
      }
      paramViewGroup.setTextColor(this.mContext.getResources().getColor(2131099769));
      break label130;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c
 * JD-Core Version:    0.7.0.1
 */