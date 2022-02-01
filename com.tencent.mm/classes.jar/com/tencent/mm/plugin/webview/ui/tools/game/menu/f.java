package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import java.util.List;

public class f
  extends BaseAdapter
{
  private static final String CIv;
  o ODY;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(81003);
    CIv = b.aSL() + "Game/HvMenu/";
    AppMethodBeat.o(81003);
  }
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void c(o paramo)
  {
    AppMethodBeat.i(80999);
    this.ODY = paramo;
    notifyDataSetChanged();
    AppMethodBeat.o(80999);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(81000);
    if (this.ODY == null)
    {
      AppMethodBeat.o(81000);
      return 0;
    }
    int i = this.ODY.size();
    AppMethodBeat.o(81000);
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(81001);
    paramView = LayoutInflater.from(this.mContext).inflate(c.g.game_menu_item_view, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    p localp = (p)this.ODY.WkP.get(paramInt);
    Object localObject1;
    if ((localp != null) && (localp.getItemId() != -1))
    {
      localObject1 = localp.getTitle().toString();
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split("__", 2);
        if (localObject1.length == 1)
        {
          paramViewGroup.jMg.setText(localObject1[0]);
          paramView.setTag(localp);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(81001);
      return paramView;
      paramViewGroup.jMg.setText(localObject1[0]);
      localObject1 = localObject1[1];
      if (((String)localObject1).startsWith("http"))
      {
        Object localObject2 = CIv + g.getMessageDigest(((String)localObject1).getBytes());
        c.a locala = new c.a();
        locala.lRD = true;
        locala.fullPath = ((String)localObject2);
        localObject2 = locala.bmL();
        a.bms().a((String)localObject1, paramViewGroup.bwJ, (c)localObject2);
        break;
      }
      paramViewGroup.bwJ.setImageResource(MMApplicationContext.getResources().getIdentifier((String)localObject1, "drawable", MMApplicationContext.getPackageName()));
      break;
      paramView.setTag(null);
    }
  }
  
  public final class a
  {
    ImageView bwJ;
    TextView jMg;
    
    public a(View paramView)
    {
      AppMethodBeat.i(80998);
      this.jMg = ((TextView)paramView.findViewById(c.f.title));
      this.bwJ = ((ImageView)paramView.findViewById(c.f.icon));
      AppMethodBeat.o(80998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.f
 * JD-Core Version:    0.7.0.1
 */