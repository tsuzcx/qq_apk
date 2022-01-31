package com.tencent.mm.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.cd.e;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.ui.y;
import java.util.List;

public final class f
  extends a
{
  private List<u> wwV;
  
  public f(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    super(paramContext, parama);
  }
  
  private int IO(int paramInt)
  {
    int i = paramInt;
    if (this.wwV != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.wwV.size()) {
          i = ((u)this.wwV.get(paramInt)).position;
        }
      }
    }
    return i;
  }
  
  public final int getCount()
  {
    int i;
    if (this.wwV == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = this.wwN * this.lcm;
      i = j;
    } while (j <= this.wwV.size());
    return this.wwV.size();
  }
  
  public final Object getItem(int paramInt)
  {
    com.tencent.mm.u.a.a locala = new com.tencent.mm.u.a.a();
    locala.position = IO(paramInt);
    return locala;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = y.gt(this.mContext).inflate(a.f.smiley_grid_item_s, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramInt = IO(paramInt);
      Drawable localDrawable = e.csH().mW(paramInt);
      paramViewGroup.gSx.setImageDrawable(localDrawable);
      String str2 = e.csH().getText(paramInt);
      String str1 = str2;
      if (bk.bl(str2)) {
        str1 = paramView.getResources().getString(a.h.emoji_store_title);
      }
      paramViewGroup.gSx.setContentDescription(str1);
      if (localDrawable == null) {
        b.i("RecentSmileyAdapter", "drawable is null. realPosition:%d description:%s", new Object[] { Integer.valueOf(paramInt), str1 });
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void update()
  {
    this.wwV = this.wvS.wzT;
    notifyDataSetChanged();
  }
  
  final class a
  {
    ImageView gSx;
    
    public a(View paramView)
    {
      this.gSx = ((ImageView)paramView.findViewById(a.e.art_emoji_icon_iv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.f
 * JD-Core Version:    0.7.0.1
 */