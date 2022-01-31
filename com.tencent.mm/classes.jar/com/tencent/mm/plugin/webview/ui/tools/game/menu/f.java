package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.a.g;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private static final String kOy = b.bkH + "Game/HvMenu/";
  private Context mContext;
  l phJ;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getCount()
  {
    if (this.phJ == null) {
      return 0;
    }
    return this.phJ.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.mContext).inflate(R.i.game_menu_item_view, paramViewGroup, false);
    paramViewGroup = new f.a(this, paramView);
    m localm = (m)this.phJ.uWD.get(paramInt);
    if ((localm != null) && (localm.getItemId() != -1))
    {
      Object localObject1 = localm.getTitle().toString();
      if (!bk.bl((String)localObject1))
      {
        localObject1 = ((String)localObject1).split("__", 2);
        if (localObject1.length == 1) {
          paramViewGroup.fcy.setText(localObject1[0]);
        }
        for (;;)
        {
          paramView.setTag(localm);
          return paramView;
          paramViewGroup.fcy.setText(localObject1[0]);
          localObject1 = localObject1[1];
          if (((String)localObject1).startsWith("http"))
          {
            Object localObject2 = kOy + g.o(((String)localObject1).getBytes());
            c.a locala = new c.a();
            locala.erf = true;
            locala.erh = ((String)localObject2);
            localObject2 = locala.OV();
            a.OT().a((String)localObject1, paramViewGroup.hic, (c)localObject2);
          }
          else
          {
            paramViewGroup.hic.setImageResource(ae.getResources().getIdentifier((String)localObject1, "drawable", ae.getPackageName()));
          }
        }
      }
    }
    paramView.setTag(null);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.f
 * JD-Core Version:    0.7.0.1
 */