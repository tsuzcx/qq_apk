package com.tencent.mm.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class d
  extends a
{
  public d(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    super(paramContext, parama);
  }
  
  public final int RI(int paramInt)
  {
    return (this.ARM - 1) * this.ARN + paramInt;
  }
  
  public int getCount()
  {
    return this.ARM;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(62977);
    i locali = new i();
    if (paramInt == getCount() - 1) {}
    for (locali.position = -1;; locali.position = RI(paramInt))
    {
      AppMethodBeat.o(62977);
      return locali;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62979);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970761, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramViewGroup = new d.a(this, paramView);
      paramView.setTag(paramViewGroup);
      if (paramInt != getCount() - 1) {
        break label111;
      }
      paramViewGroup.ivs.setImageResource(2130838499);
      paramViewGroup.ivs.setContentDescription(this.mContext.getString(2131298947));
    }
    for (;;)
    {
      AppMethodBeat.o(62979);
      return paramView;
      paramViewGroup = (d.a)paramView.getTag();
      break;
      label111:
      paramInt = RI(paramInt);
      if (paramInt > this.ejZ - 1)
      {
        paramViewGroup.ivs.setImageDrawable(null);
        paramViewGroup.ivs.setContentDescription("");
        ab.i("MicroMsg.emoji.DefaultSmileyAdapter", "real position is bigger real count.");
      }
      else
      {
        Drawable localDrawable = e.dve().qA(paramInt);
        paramViewGroup.ivs.setImageDrawable(localDrawable);
        String str2 = e.dve().getText(paramInt);
        String str1 = str2;
        if (bo.isNullOrNil(str2)) {
          str1 = paramView.getResources().getString(2131299253);
        }
        paramViewGroup.ivs.setContentDescription(str1);
        if (localDrawable == null) {
          ab.i("MicroMsg.emoji.DefaultSmileyAdapter", "drawable is null. realPosition:%d description:%s", new Object[] { Integer.valueOf(paramInt), str1 });
        }
      }
    }
  }
  
  public boolean uu(int paramInt)
  {
    AppMethodBeat.i(62978);
    if (paramInt != getCount() - 1)
    {
      AppMethodBeat.o(62978);
      return true;
    }
    AppMethodBeat.o(62978);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.d
 * JD-Core Version:    0.7.0.1
 */