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
import com.tencent.mm.plugin.sns.storage.b.d;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class c
  extends BaseAdapter
{
  public int jzV;
  private final Context mContext;
  private String sOz;
  public com.tencent.mm.plugin.sns.data.b xjH;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(97694);
    this.xjH = null;
    this.sOz = null;
    this.jzV = 0;
    this.mContext = paramContext;
    this.xjH = paramb;
    this.sOz = ac.ir(aj.getContext());
    AppMethodBeat.o(97694);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(97695);
    if (this.jzV == 1)
    {
      i = this.xjH.wAe.xLs.wSm.dve().size();
      AppMethodBeat.o(97695);
      return i;
    }
    int i = 0;
    if (this.xjH.wAe.xLr.wTF != null) {
      i = this.xjH.wAe.xLr.wTF.list.size();
    }
    AppMethodBeat.o(97695);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(97697);
    Object localObject = this.xjH.wAe.xLs.wSm.dve().get(paramInt);
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
    localView.setTag(this.xjH);
    paramViewGroup = "";
    Object localObject;
    if (this.jzV == 1)
    {
      localObject = (a.c.a)getItem(paramInt);
      if ("zh_CN".equals(this.sOz))
      {
        paramViewGroup = ((a.c.a)localObject).wSA;
        paramView = paramViewGroup;
        if (bt.isNullOrNil(paramViewGroup)) {
          paramView = ((a.c.a)localObject).wSC;
        }
        label87:
        paramViewGroup = (TextView)localView.findViewById(2131296444);
        if (!this.xjH.wAe.xLs.wSq) {
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
      if (("zh_TW".equals(this.sOz)) || ("zh_HK".equals(this.sOz)))
      {
        paramViewGroup = ((a.c.a)localObject).wSB;
        break;
      }
      paramViewGroup = ((a.c.a)localObject).wSC;
      break;
      if (paramInt == 0)
      {
        paramView = paramViewGroup;
        if (this.xjH == null) {
          break label87;
        }
        paramView = paramViewGroup;
        if (this.xjH.wAe.xLr == null) {
          break label87;
        }
        paramView = this.xjH.wAe.xLs;
        if ("zh_CN".equals(this.sOz)) {
          paramView = paramView.wSn;
        }
        for (;;)
        {
          if (bt.isNullOrNil(paramView)) {
            break label317;
          }
          break;
          if (("zh_TW".equals(this.sOz)) || ("zh_HK".equals(this.sOz))) {
            paramView = paramView.wSp;
          } else {
            paramView = paramView.wSo;
          }
        }
        paramView = this.mContext.getString(2131763767);
        break label87;
      }
      localObject = this.xjH.wAe.xLr.wTF;
      paramView = paramViewGroup;
      if (localObject == null) {
        break label87;
      }
      paramView = paramViewGroup;
      if (paramInt > ((b.d)localObject).list.size()) {
        break label87;
      }
      localObject = (b.e)((b.d)localObject).list.get(paramInt - 1);
      if ("zh_CN".equals(this.sOz)) {
        paramViewGroup = ((b.e)localObject).wUi;
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (!bt.isNullOrNil(paramViewGroup)) {
          break;
        }
        paramView = ((b.e)localObject).wMv;
        break;
        if (("zh_TW".equals(this.sOz)) || ("zh_HK".equals(this.sOz))) {
          paramViewGroup = ((b.e)localObject).wUj;
        } else {
          paramViewGroup = ((b.e)localObject).wMv;
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