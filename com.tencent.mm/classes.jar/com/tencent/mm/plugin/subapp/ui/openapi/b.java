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
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.List;

public final class b
  extends BaseAdapter
  implements MStorage.IOnStorageChange
{
  private List<g> PtA;
  boolean SHN = false;
  private Context context;
  
  public b(Context paramContext, List<g> paramList)
  {
    this.context = paramContext;
    this.PtA = paramList;
  }
  
  private int fHy()
  {
    AppMethodBeat.i(29163);
    int i = getRealCount();
    AppMethodBeat.o(29163);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29162);
    int i = this.PtA.size();
    AppMethodBeat.o(29162);
    return i;
  }
  
  public final void Fb(boolean paramBoolean)
  {
    AppMethodBeat.i(29157);
    this.SHN = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29157);
  }
  
  public final boolean XL(int paramInt)
  {
    AppMethodBeat.i(29160);
    int i = this.PtA.size();
    if ((paramInt >= i) && (paramInt < i + fHy()))
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
    int j = fHy();
    AppMethodBeat.o(29159);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29161);
    if (XL(paramInt))
    {
      AppMethodBeat.o(29161);
      return null;
    }
    Object localObject = this.PtA.get(paramInt);
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
      paramView = View.inflate(this.context, R.i.gei, null);
      paramViewGroup.lPb = ((ImageView)paramView.findViewById(R.h.frM));
      paramViewGroup.SIi = ((TextView)paramView.findViewById(R.h.frL));
      paramViewGroup.lDF = ((TextView)paramView.findViewById(R.h.frN));
      paramViewGroup.SIj = paramView.findViewById(R.h.frO);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.SIj.setVisibility(4);
      if (!XL(paramInt)) {
        break;
      }
      paramViewGroup.lPb.setVisibility(4);
      paramViewGroup.SIi.setVisibility(4);
      paramViewGroup.lDF.setVisibility(4);
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.lPb.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 5, a.getDensity(this.context));
    if (localBitmap == null)
    {
      paramViewGroup.lPb.setBackgroundResource(R.g.app_panel_unknowed_icon);
      paramViewGroup.lDF.setVisibility(0);
      paramViewGroup.lDF.setText(h.a(this.context, localg, null));
      if (!this.SHN) {
        break label265;
      }
      paramViewGroup.SIi.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup.lPb.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label265:
      paramViewGroup.SIi.setVisibility(8);
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(29164);
    notifyDataSetChanged();
    AppMethodBeat.o(29164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.b
 * JD-Core Version:    0.7.0.1
 */