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
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private static final String nmv;
  private Context mContext;
  l saq;
  
  static
  {
    AppMethodBeat.i(8849);
    nmv = b.eQz + "Game/HvMenu/";
    AppMethodBeat.o(8849);
  }
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(8845);
    this.saq = paraml;
    notifyDataSetChanged();
    AppMethodBeat.o(8845);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(8846);
    if (this.saq == null)
    {
      AppMethodBeat.o(8846);
      return 0;
    }
    int i = this.saq.size();
    AppMethodBeat.o(8846);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(8847);
    paramView = LayoutInflater.from(this.mContext).inflate(2130969786, paramViewGroup, false);
    paramViewGroup = new f.a(this, paramView);
    m localm = (m)this.saq.zkW.get(paramInt);
    Object localObject1;
    if ((localm != null) && (localm.getItemId() != -1))
    {
      localObject1 = localm.getTitle().toString();
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).split("__", 2);
        if (localObject1.length == 1)
        {
          paramViewGroup.gui.setText(localObject1[0]);
          paramView.setTag(localm);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(8847);
      return paramView;
      paramViewGroup.gui.setText(localObject1[0]);
      localObject1 = localObject1[1];
      if (((String)localObject1).startsWith("http"))
      {
        Object localObject2 = nmv + g.w(((String)localObject1).getBytes());
        c.a locala = new c.a();
        locala.eNM = true;
        locala.eNO = ((String)localObject2);
        localObject2 = locala.ahY();
        a.ahM().a((String)localObject1, paramViewGroup.iTH, (c)localObject2);
        break;
      }
      paramViewGroup.iTH.setImageResource(ah.getResources().getIdentifier((String)localObject1, "drawable", ah.getPackageName()));
      break;
      paramView.setTag(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.f
 * JD-Core Version:    0.7.0.1
 */