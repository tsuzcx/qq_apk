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
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.sdk.platformtools.bk;

public class b
  extends a
{
  public b(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    super(paramContext, parama);
  }
  
  public final int IO(int paramInt)
  {
    return (this.wwK - 1) * this.wwL + paramInt;
  }
  
  public int getCount()
  {
    return this.wwK;
  }
  
  public Object getItem(int paramInt)
  {
    com.tencent.mm.u.a.a locala = new com.tencent.mm.u.a.a();
    if (paramInt == getCount() - 1)
    {
      locala.position = -1;
      return locala;
    }
    locala.position = IO(paramInt);
    return locala;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = com.tencent.mm.ui.y.gt(this.mContext).inflate(a.f.smiley_grid_item_s, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramViewGroup = new b.a(this, paramView);
      paramView.setTag(paramViewGroup);
      if (paramInt != getCount() - 1) {
        break label104;
      }
      paramViewGroup.gSx.setImageResource(a.d.del_btn);
      paramViewGroup.gSx.setContentDescription(this.mContext.getString(a.h.delete_btn));
    }
    label104:
    Drawable localDrawable;
    String str1;
    do
    {
      return paramView;
      paramViewGroup = (b.a)paramView.getTag();
      break;
      paramInt = IO(paramInt);
      if (paramInt > this.dsr - 1)
      {
        paramViewGroup.gSx.setImageDrawable(null);
        paramViewGroup.gSx.setContentDescription("");
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.DefaultSmileyAdapter", "real position is bigger real count.");
        return paramView;
      }
      localDrawable = e.csH().mW(paramInt);
      paramViewGroup.gSx.setImageDrawable(localDrawable);
      String str2 = e.csH().getText(paramInt);
      str1 = str2;
      if (bk.bl(str2)) {
        str1 = paramView.getResources().getString(a.h.emoji_store_title);
      }
      paramViewGroup.gSx.setContentDescription(str1);
    } while (localDrawable != null);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.DefaultSmileyAdapter", "drawable is null. realPosition:%d description:%s", new Object[] { Integer.valueOf(paramInt), str1 });
    return paramView;
  }
  
  public boolean pY(int paramInt)
  {
    return paramInt != getCount() - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.a.b
 * JD-Core Version:    0.7.0.1
 */