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
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
  implements k.a
{
  boolean BBC;
  private int BBD;
  private Context context;
  private List<g> yXw;
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(29123);
    this.BBC = false;
    this.BBD = 0;
    this.context = paramContext;
    this.BBD = paramInt;
    init();
    AppMethodBeat.o(29123);
  }
  
  private int dcN()
  {
    AppMethodBeat.i(29131);
    int i = getRealCount();
    AppMethodBeat.o(29131);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29130);
    int i = this.yXw.size();
    AppMethodBeat.o(29130);
    return i;
  }
  
  private void init()
  {
    int i = 0;
    AppMethodBeat.i(29124);
    this.yXw = new ArrayList();
    Object localObject1 = ao.dBg();
    int j = this.BBD;
    Object localObject2 = ((j)localObject1).rawQuery("select * from AppInfo where status = " + j + " and (appType is null or appType not like ',1,')", new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      ae.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
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
          this.yXw.add(localObject2);
        }
        i += 1;
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(29124);
  }
  
  public final boolean Iw(int paramInt)
  {
    AppMethodBeat.i(29128);
    int i = this.yXw.size();
    if ((paramInt >= i) && (paramInt < i + dcN()))
    {
      AppMethodBeat.o(29128);
      return true;
    }
    AppMethodBeat.o(29128);
    return false;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(29132);
    init();
    super.notifyDataSetChanged();
    AppMethodBeat.o(29132);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(29127);
    int i = getRealCount();
    int j = dcN();
    AppMethodBeat.o(29127);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29129);
    if (Iw(paramInt))
    {
      AppMethodBeat.o(29129);
      return null;
    }
    Object localObject = this.yXw.get(paramInt);
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
      paramView = View.inflate(this.context, 2131493084, null);
      paramViewGroup.fWT = ((ImageView)paramView.findViewById(2131296905));
      paramViewGroup.BBX = ((TextView)paramView.findViewById(2131296904));
      paramViewGroup.fSj = ((TextView)paramView.findViewById(2131296906));
      paramViewGroup.BBY = paramView.findViewById(2131296907);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.BBY.setVisibility(4);
      if (!Iw(paramInt)) {
        break;
      }
      paramViewGroup.fWT.setVisibility(4);
      paramViewGroup.BBX.setVisibility(4);
      paramViewGroup.fSj.setVisibility(4);
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.fWT.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
    if (localBitmap == null)
    {
      paramViewGroup.fWT.setBackgroundResource(2131231052);
      paramViewGroup.fSj.setVisibility(0);
      paramViewGroup.fSj.setText(h.a(this.context, localg, null));
      if (!this.BBC) {
        break label259;
      }
      paramViewGroup.BBX.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup.fWT.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label259:
      paramViewGroup.BBX.setVisibility(8);
    }
  }
  
  public final void sK(boolean paramBoolean)
  {
    AppMethodBeat.i(29125);
    this.BBC = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.a
 * JD-Core Version:    0.7.0.1
 */