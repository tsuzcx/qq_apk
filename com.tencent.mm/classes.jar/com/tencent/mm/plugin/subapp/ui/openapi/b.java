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
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import java.util.List;

public final class b
  extends BaseAdapter
  implements k.a
{
  private Context context;
  private List<f> qIG;
  boolean sYK = false;
  
  public b(Context paramContext, List<f> paramList)
  {
    this.context = paramContext;
    this.qIG = paramList;
  }
  
  private int bHs()
  {
    AppMethodBeat.i(25469);
    int i = getRealCount();
    AppMethodBeat.o(25469);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(25468);
    int i = this.qIG.size();
    AppMethodBeat.o(25468);
    return i;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(25470);
    notifyDataSetChanged();
    AppMethodBeat.o(25470);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25465);
    int i = getRealCount();
    int j = bHs();
    AppMethodBeat.o(25465);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(25467);
    if (xj(paramInt))
    {
      AppMethodBeat.o(25467);
      return null;
    }
    Object localObject = this.qIG.get(paramInt);
    AppMethodBeat.o(25467);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25464);
    if (paramView == null)
    {
      paramViewGroup = new c();
      paramView = View.inflate(this.context, 2130968758, null);
      paramViewGroup.iQd = ((ImageView)paramView.findViewById(2131821482));
      paramViewGroup.sZf = ((TextView)paramView.findViewById(2131821483));
      paramViewGroup.gve = ((TextView)paramView.findViewById(2131821485));
      paramViewGroup.sZg = paramView.findViewById(2131821484);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.sZg.setVisibility(4);
      if (!xj(paramInt)) {
        break;
      }
      paramViewGroup.iQd.setVisibility(4);
      paramViewGroup.sZf.setVisibility(4);
      paramViewGroup.gve.setVisibility(4);
      AppMethodBeat.o(25464);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    f localf = (f)getItem(paramInt);
    paramViewGroup.iQd.setVisibility(0);
    Bitmap localBitmap = g.b(localf.field_appId, 5, a.getDensity(this.context));
    if (localBitmap == null)
    {
      paramViewGroup.iQd.setBackgroundResource(2130837799);
      paramViewGroup.gve.setVisibility(0);
      paramViewGroup.gve.setText(g.b(this.context, localf, null));
      if (!this.sYK) {
        break label259;
      }
      paramViewGroup.sZf.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(25464);
      return paramView;
      paramViewGroup.iQd.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label259:
      paramViewGroup.sZf.setVisibility(8);
    }
  }
  
  public final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(25463);
    this.sYK = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(25463);
  }
  
  public final boolean xj(int paramInt)
  {
    AppMethodBeat.i(25466);
    int i = this.qIG.size();
    if ((paramInt >= i) && (paramInt < i + bHs()))
    {
      AppMethodBeat.o(25466);
      return true;
    }
    AppMethodBeat.o(25466);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.b
 * JD-Core Version:    0.7.0.1
 */