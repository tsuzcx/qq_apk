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
  private List<g> JhO;
  boolean Mgq;
  private int Mgr;
  private Context context;
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(29123);
    this.Mgq = false;
    this.Mgr = 0;
    this.context = paramContext;
    this.Mgr = paramInt;
    init();
    AppMethodBeat.o(29123);
  }
  
  private int ezA()
  {
    AppMethodBeat.i(29131);
    int i = getRealCount();
    AppMethodBeat.o(29131);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29130);
    int i = this.JhO.size();
    AppMethodBeat.o(29130);
    return i;
  }
  
  private void init()
  {
    int i = 0;
    AppMethodBeat.i(29124);
    this.JhO = new ArrayList();
    Object localObject1 = ao.fmz();
    int j = this.Mgr;
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
        if (h.u(this.context, ((g)localObject2).field_appId)) {
          this.JhO.add(localObject2);
        }
        i += 1;
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(29124);
  }
  
  public final boolean TR(int paramInt)
  {
    AppMethodBeat.i(29128);
    int i = this.JhO.size();
    if ((paramInt >= i) && (paramInt < i + ezA()))
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
    int j = ezA();
    AppMethodBeat.o(29127);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29129);
    if (TR(paramInt))
    {
      AppMethodBeat.o(29129);
      return null;
    }
    Object localObject = this.JhO.get(paramInt);
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
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.jmf.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 1, com.tencent.mm.ci.a.getDensity(this.context));
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
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup.jmf.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label265:
      paramViewGroup.MgL.setVisibility(8);
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(29132);
    init();
    super.notifyDataSetChanged();
    AppMethodBeat.o(29132);
  }
  
  public final void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(29125);
    this.Mgq = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.a
 * JD-Core Version:    0.7.0.1
 */