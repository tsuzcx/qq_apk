package com.tencent.mm.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.cd.e;
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.f.a;

public final class d
  extends b
{
  public int wwS = 1;
  private ImageView wwT;
  private ImageView wwU;
  
  public d(Context paramContext, a parama)
  {
    super(paramContext, parama);
  }
  
  public final boolean IP(int paramInt)
  {
    return (this.wwS == 0) && (paramInt == this.lcm * this.wwN - 5);
  }
  
  public final void aS(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {
      if (this.wwT != null)
      {
        if (paramFloat > 0.01F) {
          break label57;
        }
        this.wwT.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.wwU != null)
      {
        if (paramFloat < 0.99F) {
          break;
        }
        this.wwU.setVisibility(4);
      }
      return;
      label57:
      this.wwT.setVisibility(0);
      this.wwT.setImageAlpha((int)(255.0F * paramFloat));
    }
    this.wwU.setVisibility(0);
    this.wwU.setImageAlpha((int)((1.0F - paramFloat) * 255.0F));
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == this.lcm * this.wwN - 5)
    {
      View localView = y.gt(this.mContext).inflate(a.f.smiley_grid_item_cross_fade, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.wwT = ((ImageView)localView.findViewById(a.e.art_emoji_icon_origin));
      this.wwU = ((ImageView)localView.findViewById(a.e.art_emoji_icon_delete));
      paramInt = IO(paramInt);
      paramView = e.csH().mW(paramInt);
      this.wwT.setImageDrawable(paramView);
      paramViewGroup = e.csH().getText(paramInt);
      paramView = paramViewGroup;
      if (bk.bl(paramViewGroup)) {
        paramView = localView.getResources().getString(a.h.emoji_store_title);
      }
      this.wwT.setContentDescription(paramView);
      this.wwU.setImageResource(a.d.del_btn);
      this.wwU.setContentDescription(this.mContext.getString(a.h.delete_btn));
      aS(this.wwS);
      return localView;
    }
    return super.getView(paramInt, paramView, paramViewGroup);
  }
  
  public final boolean pY(int paramInt)
  {
    return (super.pY(paramInt)) && (!IP(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.a.d
 * JD-Core Version:    0.7.0.1
 */