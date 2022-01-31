package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class c
  extends BaseAdapter
{
  public int hAu;
  private final Context mContext;
  private String nZZ;
  public com.tencent.mm.plugin.sns.data.b rDX;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(38073);
    this.rDX = null;
    this.nZZ = null;
    this.hAu = 0;
    this.mContext = paramContext;
    this.rDX = paramb;
    this.nZZ = aa.gP(ah.getContext());
    AppMethodBeat.o(38073);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38074);
    if (this.hAu == 1)
    {
      i = this.rDX.rba.scr.rpz.cqj().size();
      AppMethodBeat.o(38074);
      return i;
    }
    int i = 0;
    if (this.rDX.rba.scq.rqK != null) {
      i = this.rDX.rba.scq.rqK.list.size();
    }
    AppMethodBeat.o(38074);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(38076);
    Object localObject = this.rDX.rba.scr.rpz.cqj().get(paramInt);
    AppMethodBeat.o(38076);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38075);
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(this.mContext, 2130968633, null);
    }
    localView.setTag(this.rDX);
    paramViewGroup = "";
    Object localObject;
    if (this.hAu == 1)
    {
      localObject = (a.b.a)getItem(paramInt);
      if ("zh_CN".equals(this.nZZ))
      {
        paramViewGroup = ((a.b.a)localObject).rpJ;
        paramView = paramViewGroup;
        if (bo.isNullOrNil(paramViewGroup)) {
          paramView = ((a.b.a)localObject).rpL;
        }
        label87:
        paramViewGroup = (TextView)localView.findViewById(2131821051);
        if (!this.rDX.rba.scr.rpD) {
          break label457;
        }
        paramViewGroup.setTextColor(Color.parseColor("#3A3A3A"));
        label123:
        paramViewGroup.setText(paramView);
        paramView = localView.findViewById(2131821052);
        if (paramInt != getCount() - 1) {
          break label469;
        }
      }
    }
    label310:
    label457:
    label469:
    for (paramInt = 8;; paramInt = 0)
    {
      paramView.setVisibility(paramInt);
      AppMethodBeat.o(38075);
      return localView;
      if (("zh_TW".equals(this.nZZ)) || ("zh_HK".equals(this.nZZ)))
      {
        paramViewGroup = ((a.b.a)localObject).rpK;
        break;
      }
      paramViewGroup = ((a.b.a)localObject).rpL;
      break;
      if (paramInt == 0)
      {
        paramView = paramViewGroup;
        if (this.rDX == null) {
          break label87;
        }
        paramView = paramViewGroup;
        if (this.rDX.rba.scq == null) {
          break label87;
        }
        paramView = this.rDX.rba.scr;
        if ("zh_CN".equals(this.nZZ)) {
          paramView = paramView.rpA;
        }
        for (;;)
        {
          if (bo.isNullOrNil(paramView)) {
            break label310;
          }
          break;
          if (("zh_TW".equals(this.nZZ)) || ("zh_HK".equals(this.nZZ))) {
            paramView = paramView.rpC;
          } else {
            paramView = paramView.rpB;
          }
        }
        paramView = this.mContext.getString(2131303764);
        break label87;
      }
      localObject = this.rDX.rba.scq.rqK;
      paramView = paramViewGroup;
      if (localObject == null) {
        break label87;
      }
      paramView = paramViewGroup;
      if (paramInt > ((b.a)localObject).list.size()) {
        break label87;
      }
      localObject = (b.b)((b.a)localObject).list.get(paramInt - 1);
      if ("zh_CN".equals(this.nZZ)) {
        paramViewGroup = ((b.b)localObject).rqT;
      }
      for (;;)
      {
        paramView = paramViewGroup;
        if (!bo.isNullOrNil(paramViewGroup)) {
          break;
        }
        paramView = ((b.b)localObject).rkp;
        break;
        if (("zh_TW".equals(this.nZZ)) || ("zh_HK".equals(this.nZZ))) {
          paramViewGroup = ((b.b)localObject).rqU;
        } else {
          paramViewGroup = ((b.b)localObject).rkp;
        }
      }
      paramViewGroup.setTextColor(Color.parseColor("#576B95"));
      break label123;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c
 * JD-Core Version:    0.7.0.1
 */