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
  boolean Bkd = false;
  private Context context;
  private List<g> yHm;
  
  public b(Context paramContext, List<g> paramList)
  {
    this.context = paramContext;
    this.yHm = paramList;
  }
  
  private int dac()
  {
    AppMethodBeat.i(29163);
    int i = getRealCount();
    AppMethodBeat.o(29163);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29162);
    int i = this.yHm.size();
    AppMethodBeat.o(29162);
    return i;
  }
  
  public final boolean HY(int paramInt)
  {
    AppMethodBeat.i(29160);
    int i = this.yHm.size();
    if ((paramInt >= i) && (paramInt < i + dac()))
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
    int j = dac();
    AppMethodBeat.o(29159);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29161);
    if (HY(paramInt))
    {
      AppMethodBeat.o(29161);
      return null;
    }
    Object localObject = this.yHm.get(paramInt);
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
      paramViewGroup.fUN = ((ImageView)paramView.findViewById(2131296905));
      paramViewGroup.Bky = ((TextView)paramView.findViewById(2131296904));
      paramViewGroup.fQd = ((TextView)paramView.findViewById(2131296906));
      paramViewGroup.Bkz = paramView.findViewById(2131296907);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.Bkz.setVisibility(4);
      if (!HY(paramInt)) {
        break;
      }
      paramViewGroup.fUN.setVisibility(4);
      paramViewGroup.Bky.setVisibility(4);
      paramViewGroup.fQd.setVisibility(4);
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.fUN.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 5, a.getDensity(this.context));
    if (localBitmap == null)
    {
      paramViewGroup.fUN.setBackgroundResource(2131231052);
      paramViewGroup.fQd.setVisibility(0);
      paramViewGroup.fQd.setText(h.a(this.context, localg, null));
      if (!this.Bkd) {
        break label259;
      }
      paramViewGroup.Bky.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup.fUN.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label259:
      paramViewGroup.Bky.setVisibility(8);
    }
  }
  
  public final void sD(boolean paramBoolean)
  {
    AppMethodBeat.i(29157);
    this.Bkd = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.b
 * JD-Core Version:    0.7.0.1
 */