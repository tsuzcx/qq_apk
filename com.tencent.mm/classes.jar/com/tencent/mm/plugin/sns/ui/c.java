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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class c
  extends BaseAdapter
{
  public int kar;
  private final Context mContext;
  private String tWM;
  public com.tencent.mm.plugin.sns.data.b ywA;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(97694);
    this.ywA = null;
    this.tWM = null;
    this.kar = 0;
    this.mContext = paramContext;
    this.ywA = paramb;
    this.tWM = ab.iC(ai.getContext());
    AppMethodBeat.o(97694);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(97695);
    if (this.kar == 1)
    {
      i = this.ywA.xMy.yYh.yeS.dJD().size();
      AppMethodBeat.o(97695);
      return i;
    }
    int i = 0;
    if (this.ywA.xMy.yYg.ygp != null) {
      i = this.ywA.xMy.yYg.ygp.list.size();
    }
    AppMethodBeat.o(97695);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(97697);
    Object localObject = this.ywA.xMy.yYh.yeS.dJD().get(paramInt);
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
    localView.setTag(this.ywA);
    paramViewGroup = "";
    Object localObject;
    if (this.kar == 1)
    {
      localObject = (a.c.a)getItem(paramInt);
      if ("zh_CN".equals(this.tWM))
      {
        paramViewGroup = ((a.c.a)localObject).yfk;
        paramView = paramViewGroup;
        if (bs.isNullOrNil(paramViewGroup)) {
          paramView = ((a.c.a)localObject).yfm;
        }
        label87:
        paramViewGroup = (TextView)localView.findViewById(2131296444);
        if (!this.ywA.xMy.yYh.yeW) {
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
      if (("zh_TW".equals(this.tWM)) || ("zh_HK".equals(this.tWM)))
      {
        paramViewGroup = ((a.c.a)localObject).yfl;
        break;
      }
      paramViewGroup = ((a.c.a)localObject).yfm;
      break;
      if (paramInt == 0)
      {
        paramView = paramViewGroup;
        if (this.ywA == null) {
          break label87;
        }
        paramView = paramViewGroup;
        if (this.ywA.xMy.yYg == null) {
          break label87;
        }
        paramView = this.ywA.xMy.yYh;
        if ("zh_CN".equals(this.tWM)) {
          paramView = paramView.yeT;
        }
        for (;;)
        {
          if (bs.isNullOrNil(paramView)) {
            break label317;
          }
          break;
          if (("zh_TW".equals(this.tWM)) || ("zh_HK".equals(this.tWM))) {
            paramView = paramView.yeV;
          } else {
            paramView = paramView.yeU;
          }
        }
        paramView = this.mContext.getString(2131763767);
        break label87;
      }
      localObject = this.ywA.xMy.yYg.ygp;
      paramView = paramViewGroup;
      if (localObject == null) {
        break label87;
      }
      paramView = paramViewGroup;
      if (paramInt > ((b.e)localObject).list.size()) {
        break label87;
      }
      localObject = (b.f)((b.e)localObject).list.get(paramInt - 1);
      if ("zh_CN".equals(this.tWM)) {
        paramViewGroup = ((b.f)localObject).ygW;
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (!bs.isNullOrNil(paramViewGroup)) {
          break;
        }
        paramView = ((b.f)localObject).xZb;
        break;
        if (("zh_TW".equals(this.tWM)) || ("zh_HK".equals(this.tWM))) {
          paramViewGroup = ((b.f)localObject).ygX;
        } else {
          paramViewGroup = ((b.f)localObject).xZb;
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