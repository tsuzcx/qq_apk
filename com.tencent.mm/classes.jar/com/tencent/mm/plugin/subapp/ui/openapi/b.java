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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ci.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.List;

public final class b
  extends BaseAdapter
  implements MStorage.IOnStorageChange
{
  private List<g> JhO;
  boolean Mgq = false;
  private Context context;
  
  public b(Context paramContext, List<g> paramList)
  {
    this.context = paramContext;
    this.JhO = paramList;
  }
  
  private int ezA()
  {
    AppMethodBeat.i(29163);
    int i = getRealCount();
    AppMethodBeat.o(29163);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29162);
    int i = this.JhO.size();
    AppMethodBeat.o(29162);
    return i;
  }
  
  public final boolean TR(int paramInt)
  {
    AppMethodBeat.i(29160);
    int i = this.JhO.size();
    if ((paramInt >= i) && (paramInt < i + ezA()))
    {
      AppMethodBeat.o(29160);
      return true;
    }
    AppMethodBeat.o(29160);
    return false;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(29159);
    int i = getRealCount();
    int j = ezA();
    AppMethodBeat.o(29159);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29161);
    if (TR(paramInt))
    {
      AppMethodBeat.o(29161);
      return null;
    }
    Object localObject = this.JhO.get(paramInt);
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
      paramView = View.inflate(this.context, R.i.ebA, null);
      paramViewGroup.jmf = ((ImageView)paramView.findViewById(R.h.dru));
      paramViewGroup.MgL = ((TextView)paramView.findViewById(R.h.drt));
      paramViewGroup.jbF = ((TextView)paramView.findViewById(R.h.drv));
      paramViewGroup.MgM = paramView.findViewById(R.h.drw);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.MgM.setVisibility(4);
      if (!TR(paramInt)) {
        break;
      }
      paramViewGroup.jmf.setVisibility(4);
      paramViewGroup.MgL.setVisibility(4);
      paramViewGroup.jbF.setVisibility(4);
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.jmf.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 5, a.getDensity(this.context));
    if (localBitmap == null)
    {
      paramViewGroup.jmf.setBackgroundResource(R.g.app_panel_unknowed_icon);
      paramViewGroup.jbF.setVisibility(0);
      paramViewGroup.jbF.setText(h.a(this.context, localg, null));
      if (!this.Mgq) {
        break label265;
      }
      paramViewGroup.MgL.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup.jmf.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label265:
      paramViewGroup.MgL.setVisibility(8);
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(29164);
    notifyDataSetChanged();
    AppMethodBeat.o(29164);
  }
  
  public final void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(29157);
    this.Mgq = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.b
 * JD-Core Version:    0.7.0.1
 */