package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import java.util.List;

public final class b
  extends BaseAdapter
  implements k.a
{
  private Context context;
  private List<g> xsD;
  boolean zSy = false;
  
  public b(Context paramContext, List<g> paramList)
  {
    this.context = paramContext;
    this.xsD = paramList;
  }
  
  private int cRx()
  {
    AppMethodBeat.i(29163);
    int i = getRealCount();
    AppMethodBeat.o(29163);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29162);
    int i = this.xsD.size();
    AppMethodBeat.o(29162);
    return i;
  }
  
  public final boolean GF(int paramInt)
  {
    AppMethodBeat.i(29160);
    int i = this.xsD.size();
    if ((paramInt >= i) && (paramInt < i + cRx()))
    {
      AppMethodBeat.o(29160);
      return true;
    }
    AppMethodBeat.o(29160);
    return false;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(29164);
    notifyDataSetChanged();
    AppMethodBeat.o(29164);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(29159);
    int i = getRealCount();
    int j = cRx();
    AppMethodBeat.o(29159);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29161);
    if (GF(paramInt))
    {
      AppMethodBeat.o(29161);
      return null;
    }
    Object localObject = this.xsD.get(paramInt);
    AppMethodBeat.o(29161);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29158);
    if (paramView == null)
    {
      paramViewGroup = new c();
      paramView = View.inflate(this.context, 2131493084, null);
      paramViewGroup.fBA = ((ImageView)paramView.findViewById(2131296905));
      paramViewGroup.zST = ((TextView)paramView.findViewById(2131296904));
      paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131296906));
      paramViewGroup.zSU = paramView.findViewById(2131296907);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.zSU.setVisibility(4);
      if (!GF(paramInt)) {
        break;
      }
      paramViewGroup.fBA.setVisibility(4);
      paramViewGroup.zST.setVisibility(4);
      paramViewGroup.fwQ.setVisibility(4);
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.fBA.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 5, a.getDensity(this.context));
    if (localBitmap == null)
    {
      paramViewGroup.fBA.setBackgroundResource(2131231052);
      paramViewGroup.fwQ.setVisibility(0);
      paramViewGroup.fwQ.setText(h.a(this.context, localg, null));
      if (!this.zSy) {
        break label259;
      }
      paramViewGroup.zST.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup.fBA.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label259:
      paramViewGroup.zST.setVisibility(8);
    }
  }
  
  public final void rX(boolean paramBoolean)
  {
    AppMethodBeat.i(29157);
    this.zSy = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.b
 * JD-Core Version:    0.7.0.1
 */