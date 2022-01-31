package com.tencent.mm.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.view.f.a;

public final class f
  extends d
{
  public int ASa = 1;
  private ImageView ASb;
  private ImageView ASc;
  
  public f(Context paramContext, a parama)
  {
    super(paramContext, parama);
  }
  
  public final boolean RJ(int paramInt)
  {
    return (this.ASa == 0) && (paramInt == this.nAh * this.ARP - 5);
  }
  
  public final void bD(float paramFloat)
  {
    AppMethodBeat.i(62989);
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      if (this.ASb != null)
      {
        if (paramFloat > 0.01F) {
          break label67;
        }
        this.ASb.setVisibility(4);
      }
      while (this.ASc != null) {
        if (paramFloat >= 0.99F)
        {
          this.ASc.setVisibility(4);
          AppMethodBeat.o(62989);
          return;
          label67:
          this.ASb.setVisibility(0);
          this.ASb.setImageAlpha((int)(255.0F * paramFloat));
        }
        else
        {
          this.ASc.setVisibility(0);
          this.ASc.setImageAlpha((int)((1.0F - paramFloat) * 255.0F));
        }
      }
    }
    AppMethodBeat.o(62989);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62988);
    if (paramInt == this.nAh * this.ARP - 5)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970759, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.ASb = ((ImageView)paramViewGroup.findViewById(2131827800));
      this.ASc = ((ImageView)paramViewGroup.findViewById(2131827799));
      paramInt = RI(paramInt);
      paramView = e.dve().qA(paramInt);
      this.ASb.setImageDrawable(paramView);
      String str = e.dve().getText(paramInt);
      paramView = str;
      if (bo.isNullOrNil(str)) {
        paramView = paramViewGroup.getResources().getString(2131299253);
      }
      this.ASb.setContentDescription(paramView);
      this.ASc.setImageResource(2130838499);
      this.ASc.setContentDescription(this.mContext.getString(2131298947));
      bD(this.ASa);
    }
    for (paramView = paramViewGroup;; paramView = super.getView(paramInt, paramView, paramViewGroup))
    {
      AppMethodBeat.o(62988);
      return paramView;
    }
  }
  
  public final boolean uu(int paramInt)
  {
    AppMethodBeat.i(62987);
    if ((super.uu(paramInt)) && (!RJ(paramInt)))
    {
      AppMethodBeat.o(62987);
      return true;
    }
    AppMethodBeat.o(62987);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.f
 * JD-Core Version:    0.7.0.1
 */