package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
  implements MStorage.IOnStorageChange
{
  private List<g> Dcn;
  boolean FMo;
  private int FMp;
  private Context context;
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(29123);
    this.FMo = false;
    this.FMp = 0;
    this.context = paramContext;
    this.FMp = paramInt;
    init();
    AppMethodBeat.o(29123);
  }
  
  private int dWu()
  {
    AppMethodBeat.i(29131);
    int i = getRealCount();
    AppMethodBeat.o(29131);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29130);
    int i = this.Dcn.size();
    AppMethodBeat.o(29130);
    return i;
  }
  
  private void init()
  {
    int i = 0;
    AppMethodBeat.i(29124);
    this.Dcn = new ArrayList();
    Object localObject1 = ao.eAS();
    int j = this.FMp;
    Object localObject2 = ((j)localObject1).rawQuery("select * from AppInfo where status = " + j + " and (appType is null or appType not like ',1,')", new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      j = ((Cursor)localObject1).getCount();
      while (i < j)
      {
        ((Cursor)localObject1).moveToPosition(i);
        localObject2 = new g();
        ((g)localObject2).convertFrom((Cursor)localObject1);
        if (h.s(this.context, ((g)localObject2).field_appId)) {
          this.Dcn.add(localObject2);
        }
        i += 1;
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(29124);
  }
  
  public final boolean Ox(int paramInt)
  {
    AppMethodBeat.i(29128);
    int i = this.Dcn.size();
    if ((paramInt >= i) && (paramInt < i + dWu()))
    {
      AppMethodBeat.o(29128);
      return true;
    }
    AppMethodBeat.o(29128);
    return false;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(29127);
    int i = getRealCount();
    int j = dWu();
    AppMethodBeat.o(29127);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29129);
    if (Ox(paramInt))
    {
      AppMethodBeat.o(29129);
      return null;
    }
    Object localObject = this.Dcn.get(paramInt);
    AppMethodBeat.o(29129);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29126);
    if (paramView == null)
    {
      paramViewGroup = new d();
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
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.gBZ.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
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
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup.gBZ.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label259:
      paramViewGroup.FMJ.setVisibility(8);
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(29132);
    init();
    super.notifyDataSetChanged();
    AppMethodBeat.o(29132);
  }
  
  public final void we(boolean paramBoolean)
  {
    AppMethodBeat.i(29125);
    this.FMo = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.a
 * JD-Core Version:    0.7.0.1
 */