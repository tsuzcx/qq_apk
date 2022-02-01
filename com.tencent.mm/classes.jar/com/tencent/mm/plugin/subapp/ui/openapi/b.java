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
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.List;

public final class b
  extends BaseAdapter
  implements MStorage.IOnStorageChange
{
  private List<g> Dcn;
  boolean FMo = false;
  private Context context;
  
  public b(Context paramContext, List<g> paramList)
  {
    this.context = paramContext;
    this.Dcn = paramList;
  }
  
  private int dWu()
  {
    AppMethodBeat.i(29163);
    int i = getRealCount();
    AppMethodBeat.o(29163);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29162);
    int i = this.Dcn.size();
    AppMethodBeat.o(29162);
    return i;
  }
  
  public final boolean Ox(int paramInt)
  {
    AppMethodBeat.i(29160);
    int i = this.Dcn.size();
    if ((paramInt >= i) && (paramInt < i + dWu()))
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
    int j = dWu();
    AppMethodBeat.o(29159);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29161);
    if (Ox(paramInt))
    {
      AppMethodBeat.o(29161);
      return null;
    }
    Object localObject = this.Dcn.get(paramInt);
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
      paramView = View.inflate(this.context, 2131493126, null);
      paramViewGroup.gBZ = ((ImageView)paramView.findViewById(2131297007));
      paramViewGroup.FMJ = ((TextView)paramView.findViewById(2131297006));
      paramViewGroup.gxs = ((TextView)paramView.findViewById(2131297008));
      paramViewGroup.FMK = paramView.findViewById(2131297009);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.FMK.setVisibility(4);
      if (!Ox(paramInt)) {
        break;
      }
      paramViewGroup.gBZ.setVisibility(4);
      paramViewGroup.FMJ.setVisibility(4);
      paramViewGroup.gxs.setVisibility(4);
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.gBZ.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 5, a.getDensity(this.context));
    if (localBitmap == null)
    {
      paramViewGroup.gBZ.setBackgroundResource(2131231085);
      paramViewGroup.gxs.setVisibility(0);
      paramViewGroup.gxs.setText(h.a(this.context, localg, null));
      if (!this.FMo) {
        break label259;
      }
      paramViewGroup.FMJ.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(29158);
      return paramView;
      paramViewGroup.gBZ.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label259:
      paramViewGroup.FMJ.setVisibility(8);
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(29164);
    notifyDataSetChanged();
    AppMethodBeat.o(29164);
  }
  
  public final void we(boolean paramBoolean)
  {
    AppMethodBeat.i(29157);
    this.FMo = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.b
 * JD-Core Version:    0.7.0.1
 */