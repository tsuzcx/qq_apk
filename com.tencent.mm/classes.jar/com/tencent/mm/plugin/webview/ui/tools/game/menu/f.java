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
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private static final String uba;
  l Ekt;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(81003);
    uba = b.arU() + "Game/HvMenu/";
    AppMethodBeat.o(81003);
  }
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(80999);
    this.Ekt = paraml;
    notifyDataSetChanged();
    AppMethodBeat.o(80999);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(81000);
    if (this.Ekt == null)
    {
      AppMethodBeat.o(81000);
      return 0;
    }
    int i = this.Ekt.size();
    AppMethodBeat.o(81000);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(81001);
    paramView = LayoutInflater.from(this.mContext).inflate(2131494345, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    m localm = (m)this.Ekt.JlY.get(paramInt);
    Object localObject1;
    if ((localm != null) && (localm.getItemId() != -1))
    {
      localObject1 = localm.getTitle().toString();
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split("__", 2);
        if (localObject1.length == 1)
        {
          paramViewGroup.gnM.setText(localObject1[0]);
          paramView.setTag(localm);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(81001);
      return paramView;
      paramViewGroup.gnM.setText(localObject1[0]);
      localObject1 = localObject1[1];
      if (((String)localObject1).startsWith("http"))
      {
        Object localObject2 = uba + g.getMessageDigest(((String)localObject1).getBytes());
        c.a locala = new c.a();
        locala.idr = true;
        locala.hdP = ((String)localObject2);
        localObject2 = locala.aJc();
        a.aIP().a((String)localObject1, paramViewGroup.ka, (c)localObject2);
        break;
      }
      paramViewGroup.ka.setImageResource(aj.getResources().getIdentifier((String)localObject1, "drawable", aj.getPackageName()));
      break;
      paramView.setTag(null);
    }
  }
  
  public final class a
  {
    TextView gnM;
    ImageView ka;
    
    public a(View paramView)
    {
      AppMethodBeat.i(80998);
      this.gnM = ((TextView)paramView.findViewById(2131305902));
      this.ka = ((ImageView)paramView.findViewById(2131300874));
      AppMethodBeat.o(80998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.f
 * JD-Core Version:    0.7.0.1
 */