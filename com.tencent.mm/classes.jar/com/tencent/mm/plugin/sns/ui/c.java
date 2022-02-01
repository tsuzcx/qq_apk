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
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class c
  extends BaseAdapter
{
  public int kuN;
  private final Context mContext;
  private String uZv;
  public com.tencent.mm.plugin.sns.data.b zNM;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(97694);
    this.zNM = null;
    this.uZv = null;
    this.kuN = 0;
    this.mContext = paramContext;
    this.zNM = paramb;
    this.uZv = ac.iM(aj.getContext());
    AppMethodBeat.o(97694);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(97695);
    if (this.kuN == 1)
    {
      i = this.zNM.zcq.ApS.zuT.dVR().size();
      AppMethodBeat.o(97695);
      return i;
    }
    int i = 0;
    if (this.zNM.zcq.ApR.zwr != null) {
      i = this.zNM.zcq.ApR.zwr.list.size();
    }
    AppMethodBeat.o(97695);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(97697);
    Object localObject = this.zNM.zcq.ApS.zuT.dVR().get(paramInt);
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
    localView.setTag(this.zNM);
    paramViewGroup = "";
    Object localObject;
    if (this.kuN == 1)
    {
      localObject = (a.c.a)getItem(paramInt);
      if ("zh_CN".equals(this.uZv))
      {
        paramViewGroup = ((a.c.a)localObject).zvm;
        paramView = paramViewGroup;
        if (bt.isNullOrNil(paramViewGroup)) {
          paramView = ((a.c.a)localObject).zvo;
        }
        label87:
        paramViewGroup = (TextView)localView.findViewById(2131296444);
        if (!this.zNM.zcq.ApS.zuX) {
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
      if (("zh_TW".equals(this.uZv)) || ("zh_HK".equals(this.uZv)))
      {
        paramViewGroup = ((a.c.a)localObject).zvn;
        break;
      }
      paramViewGroup = ((a.c.a)localObject).zvo;
      break;
      if (paramInt == 0)
      {
        paramView = paramViewGroup;
        if (this.zNM == null) {
          break label87;
        }
        paramView = paramViewGroup;
        if (this.zNM.zcq.ApR == null) {
          break label87;
        }
        paramView = this.zNM.zcq.ApS;
        if ("zh_CN".equals(this.uZv)) {
          paramView = paramView.zuU;
        }
        for (;;)
        {
          if (bt.isNullOrNil(paramView)) {
            break label317;
          }
          break;
          if (("zh_TW".equals(this.uZv)) || ("zh_HK".equals(this.uZv))) {
            paramView = paramView.zuW;
          } else {
            paramView = paramView.zuV;
          }
        }
        paramView = this.mContext.getString(2131763767);
        break label87;
      }
      localObject = this.zNM.zcq.ApR.zwr;
      paramView = paramViewGroup;
      if (localObject == null) {
        break label87;
      }
      paramView = paramViewGroup;
      if (paramInt > ((b.e)localObject).list.size()) {
        break label87;
      }
      localObject = (b.f)((b.e)localObject).list.get(paramInt - 1);
      if ("zh_CN".equals(this.uZv)) {
        paramViewGroup = ((b.f)localObject).zxd;
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (!bt.isNullOrNil(paramViewGroup)) {
          break;
        }
        paramView = ((b.f)localObject).zpa;
        break;
        if (("zh_TW".equals(this.uZv)) || ("zh_HK".equals(this.uZv))) {
          paramViewGroup = ((b.f)localObject).zxe;
        } else {
          paramViewGroup = ((b.f)localObject).zpa;
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