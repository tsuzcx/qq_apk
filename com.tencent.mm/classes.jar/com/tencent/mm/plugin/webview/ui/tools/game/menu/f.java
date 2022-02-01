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
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private static final String tdk;
  l CGH;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(81003);
    tdk = b.aph() + "Game/HvMenu/";
    AppMethodBeat.o(81003);
  }
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(80999);
    this.CGH = paraml;
    notifyDataSetChanged();
    AppMethodBeat.o(80999);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(81000);
    if (this.CGH == null)
    {
      AppMethodBeat.o(81000);
      return 0;
    }
    int i = this.CGH.size();
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
    m localm = (m)this.CGH.Hyi.get(paramInt);
    Object localObject1;
    if ((localm != null) && (localm.getItemId() != -1))
    {
      localObject1 = localm.getTitle().toString();
      if (!bs.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split("__", 2);
        if (localObject1.length == 1)
        {
          paramViewGroup.fUk.setText(localObject1[0]);
          paramView.setTag(localm);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(81001);
      return paramView;
      paramViewGroup.fUk.setText(localObject1[0]);
      localObject1 = localObject1[1];
      if (((String)localObject1).startsWith("http"))
      {
        Object localObject2 = tdk + g.getMessageDigest(((String)localObject1).getBytes());
        c.a locala = new c.a();
        locala.hKx = true;
        locala.gKe = ((String)localObject2);
        localObject2 = locala.aFT();
        a.aFG().a((String)localObject1, paramViewGroup.ig, (c)localObject2);
        break;
      }
      paramViewGroup.ig.setImageResource(ai.getResources().getIdentifier((String)localObject1, "drawable", ai.getPackageName()));
      break;
      paramView.setTag(null);
    }
  }
  
  public final class a
  {
    TextView fUk;
    ImageView ig;
    
    public a(View paramView)
    {
      AppMethodBeat.i(80998);
      this.fUk = ((TextView)paramView.findViewById(2131305902));
      this.ig = ((ImageView)paramView.findViewById(2131300874));
      AppMethodBeat.o(80998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.f
 * JD-Core Version:    0.7.0.1
 */