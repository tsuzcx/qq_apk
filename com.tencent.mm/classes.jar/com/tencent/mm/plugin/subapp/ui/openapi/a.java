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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.model.app.as;
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
  private List<g> PtA;
  boolean SHN;
  private int SHO;
  private Context context;
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(29123);
    this.SHN = false;
    this.SHO = 0;
    this.context = paramContext;
    this.SHO = paramInt;
    init();
    AppMethodBeat.o(29123);
  }
  
  private int fHy()
  {
    AppMethodBeat.i(29131);
    int i = getRealCount();
    AppMethodBeat.o(29131);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29130);
    int i = this.PtA.size();
    AppMethodBeat.o(29130);
    return i;
  }
  
  private void init()
  {
    int i = 0;
    AppMethodBeat.i(29124);
    this.PtA = new ArrayList();
    Object localObject1 = as.gxn();
    int j = this.SHO;
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
        if (h.y(this.context, ((g)localObject2).field_appId)) {
          this.PtA.add(localObject2);
        }
        i += 1;
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(29124);
  }
  
  public final void Fb(boolean paramBoolean)
  {
    AppMethodBeat.i(29125);
    this.SHN = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29125);
  }
  
  public final boolean XL(int paramInt)
  {
    AppMethodBeat.i(29128);
    int i = this.PtA.size();
    if ((paramInt >= i) && (paramInt < i + fHy()))
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
    int j = fHy();
    AppMethodBeat.o(29127);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29129);
    if (XL(paramInt))
    {
      AppMethodBeat.o(29129);
      return null;
    }
    Object localObject = this.PtA.get(paramInt);
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
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.lPb.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 1, com.tencent.mm.cd.a.getDensity(this.context));
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
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup.lPb.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label265:
      paramViewGroup.SIi.setVisibility(8);
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(29132);
    init();
    super.notifyDataSetChanged();
    AppMethodBeat.o(29132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.a
 * JD-Core Version:    0.7.0.1
 */