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
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.s;
import java.util.List;

public final class h
  extends a
{
  private List<s> ASd;
  
  public h(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    super(paramContext, parama);
  }
  
  private int RI(int paramInt)
  {
    AppMethodBeat.i(62994);
    if ((this.ASd != null) && (paramInt >= 0) && (paramInt < this.ASd.size()))
    {
      paramInt = ((s)this.ASd.get(paramInt)).position;
      AppMethodBeat.o(62994);
      return paramInt;
    }
    AppMethodBeat.o(62994);
    return paramInt;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(62992);
    if (this.ASd == null)
    {
      AppMethodBeat.o(62992);
      return 0;
    }
    int i = this.ARP * this.nAh;
    if (i > this.ASd.size())
    {
      i = this.ASd.size();
      AppMethodBeat.o(62992);
      return i;
    }
    AppMethodBeat.o(62992);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(62993);
    i locali = new i();
    locali.position = RI(paramInt);
    AppMethodBeat.o(62993);
    return locali;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62995);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970761, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramViewGroup = new h.a(this, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramInt = RI(paramInt);
      Drawable localDrawable = e.dve().qA(paramInt);
      paramViewGroup.ivs.setImageDrawable(localDrawable);
      String str2 = e.dve().getText(paramInt);
      String str1 = str2;
      if (bo.isNullOrNil(str2)) {
        str1 = paramView.getResources().getString(2131299253);
      }
      paramViewGroup.ivs.setContentDescription(str1);
      if (localDrawable == null) {
        com.tencent.mm.ipcinvoker.h.b.i("RecentSmileyAdapter", "drawable is null. realPosition:%d description:%s", new Object[] { Integer.valueOf(paramInt), str1 });
      }
      AppMethodBeat.o(62995);
      return paramView;
      paramViewGroup = (h.a)paramView.getTag();
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(62991);
    this.ASd = this.AQU.AVp;
    notifyDataSetChanged();
    com.tencent.mm.emoji.c.b.Pa().exp = getCount();
    AppMethodBeat.o(62991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.view.a.h
 * JD-Core Version:    0.7.0.1
 */