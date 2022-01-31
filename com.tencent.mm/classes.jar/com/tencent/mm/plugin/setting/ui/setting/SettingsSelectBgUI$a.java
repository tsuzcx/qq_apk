package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.a;
import com.tencent.mm.ba.m;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.p;

final class SettingsSelectBgUI$a
  extends p<m>
{
  private Context context;
  private int itemWidth;
  
  public SettingsSelectBgUI$a(SettingsSelectBgUI paramSettingsSelectBgUI, Context paramContext, int paramInt)
  {
    super(paramContext, new m());
    AppMethodBeat.i(127474);
    this.context = paramContext;
    this.itemWidth = paramInt;
    AppMethodBeat.o(127474);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(127477);
    setCursor(r.aiP().aiL());
    super.notifyDataSetChanged();
    AppMethodBeat.o(127477);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(127476);
    Ku();
    AppMethodBeat.o(127476);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(127475);
    int i = getCursor().getCount();
    AppMethodBeat.o(127475);
    return i + 2;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127478);
    int i;
    a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130970702, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.itemWidth, this.itemWidth));
      paramViewGroup = new b();
      paramViewGroup.qLM = ((LinearLayout)paramView.findViewById(2131827643));
      paramViewGroup.qLN = ((LinearLayout)paramView.findViewById(2131827646));
      paramViewGroup.qLO = ((LinearLayout)paramView.findViewById(2131827647));
      paramViewGroup.qLP = ((LinearLayout)paramView.findViewById(2131827648));
      paramViewGroup.qLQ = ((LinearLayout)paramView.findViewById(2131827649));
      paramView.setTag(paramViewGroup);
      i = bo.a((Integer)g.RL().Ru().get(12311, null), -2);
      locala = r.aiQ().tS(SettingsSelectBgUI.f(this.qKf));
      if (paramInt != 0) {
        break label278;
      }
      if (((!SettingsSelectBgUI.c(this.qKf)) || (i != -2)) && ((SettingsSelectBgUI.c(this.qKf)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.fMk != -2))) {
        break label269;
      }
      paramViewGroup.YY("using");
    }
    for (;;)
    {
      paramViewGroup = d.a(BitmapFactory.decodeResource(this.context.getResources(), 2130838301), true, 10.0F);
      ((ImageView)paramView.findViewById(2131827642)).setImageBitmap(paramViewGroup);
      AppMethodBeat.o(127478);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label269:
      paramViewGroup.YY("downloaded");
    }
    label278:
    if (paramInt == 1)
    {
      if (((SettingsSelectBgUI.c(this.qKf)) && (i == 0)) || ((!SettingsSelectBgUI.c(this.qKf)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.fMk == 0))) {
        paramViewGroup.YY("using");
      }
      for (;;)
      {
        paramViewGroup = d.a(BitmapFactory.decodeResource(this.context.getResources(), 2130838300), true, 10.0F);
        ((ImageView)paramView.findViewById(2131827642)).setImageBitmap(paramViewGroup);
        AppMethodBeat.o(127478);
        return paramView;
        paramViewGroup.YY("downloaded");
      }
    }
    m localm = (m)getItem(paramInt - 2);
    r.aiP();
    if (!g.RL().isSDCardAvailable()) {}
    for (Bitmap localBitmap = BitmapFactory.decodeResource(this.qKf.getResources(), 2130839822); localBitmap == null; localBitmap = d.aoV(n.aiM() + n.cA(localm.id, localm.cvs)))
    {
      AppMethodBeat.o(127478);
      return paramView;
    }
    localBitmap = d.a(localBitmap, true, 10.0F);
    ((ImageView)paramView.findViewById(2131827642)).setImageBitmap(localBitmap);
    switch (localm.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127478);
      return paramView;
      paramViewGroup.YY("downloading");
      continue;
      if ((!SettingsSelectBgUI.c(this.qKf)) && (locala != null) && (locala.fMk == localm.id))
      {
        paramViewGroup.YY("using");
      }
      else
      {
        paramViewGroup.YY("downloaded");
        continue;
        paramViewGroup.YY("undownloaded");
        continue;
        if ((!SettingsSelectBgUI.c(this.qKf)) && (locala != null) && (locala.fMk != localm.id))
        {
          paramViewGroup.YY("downloaded");
        }
        else
        {
          paramViewGroup.YY("using");
          continue;
          paramViewGroup.YY("canceling");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.a
 * JD-Core Version:    0.7.0.1
 */