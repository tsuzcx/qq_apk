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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private static final String xEu;
  m HMc;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(81003);
    xEu = b.aKJ() + "Game/HvMenu/";
    AppMethodBeat.o(81003);
  }
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(80999);
    this.HMc = paramm;
    notifyDataSetChanged();
    AppMethodBeat.o(80999);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(81000);
    if (this.HMc == null)
    {
      AppMethodBeat.o(81000);
      return 0;
    }
    int i = this.HMc.size();
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
    paramView = LayoutInflater.from(this.mContext).inflate(2131494910, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    n localn = (n)this.HMc.ORD.get(paramInt);
    Object localObject1;
    if ((localn != null) && (localn.getItemId() != -1))
    {
      localObject1 = localn.getTitle().toString();
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split("__", 2);
        if (localObject1.length == 1)
        {
          paramViewGroup.hbb.setText(localObject1[0]);
          paramView.setTag(localn);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(81001);
      return paramView;
      paramViewGroup.hbb.setText(localObject1[0]);
      localObject1 = localObject1[1];
      if (((String)localObject1).startsWith("http"))
      {
        Object localObject2 = xEu + g.getMessageDigest(((String)localObject1).getBytes());
        c.a locala = new c.a();
        locala.jbf = true;
        locala.fullPath = ((String)localObject2);
        localObject2 = locala.bdv();
        a.bdb().a((String)localObject1, paramViewGroup.kc, (c)localObject2);
        break;
      }
      paramViewGroup.kc.setImageResource(MMApplicationContext.getResources().getIdentifier((String)localObject1, "drawable", MMApplicationContext.getPackageName()));
      break;
      paramView.setTag(null);
    }
  }
  
  public final class a
  {
    TextView hbb;
    ImageView kc;
    
    public a(View paramView)
    {
      AppMethodBeat.i(80998);
      this.hbb = ((TextView)paramView.findViewById(2131309195));
      this.kc = ((ImageView)paramView.findViewById(2131302468));
      AppMethodBeat.o(80998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.f
 * JD-Core Version:    0.7.0.1
 */