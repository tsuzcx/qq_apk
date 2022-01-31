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
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
  implements k.a
{
  private Context context;
  private List<f> qIG;
  boolean sYK;
  private int sYL;
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(25429);
    this.sYK = false;
    this.sYL = 0;
    this.context = paramContext;
    this.sYL = paramInt;
    init();
    AppMethodBeat.o(25429);
  }
  
  private int bHs()
  {
    AppMethodBeat.i(25437);
    int i = getRealCount();
    AppMethodBeat.o(25437);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(25436);
    int i = this.qIG.size();
    AppMethodBeat.o(25436);
    return i;
  }
  
  private void init()
  {
    int i = 0;
    AppMethodBeat.i(25430);
    this.qIG = new ArrayList();
    Object localObject1 = al.cac();
    int j = this.sYL;
    Object localObject2 = ((i)localObject1).rawQuery("select * from AppInfo where status = " + j + " and (appType is null or appType not like ',1,')", new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      j = ((Cursor)localObject1).getCount();
      while (i < j)
      {
        ((Cursor)localObject1).moveToPosition(i);
        localObject2 = new f();
        ((f)localObject2).convertFrom((Cursor)localObject1);
        if (g.u(this.context, ((f)localObject2).field_appId)) {
          this.qIG.add(localObject2);
        }
        i += 1;
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(25430);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(25438);
    init();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25438);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25433);
    int i = getRealCount();
    int j = bHs();
    AppMethodBeat.o(25433);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(25435);
    if (xj(paramInt))
    {
      AppMethodBeat.o(25435);
      return null;
    }
    Object localObject = this.qIG.get(paramInt);
    AppMethodBeat.o(25435);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25432);
    if (paramView == null)
    {
      paramViewGroup = new d();
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
      AppMethodBeat.o(25432);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
    f localf = (f)getItem(paramInt);
    paramViewGroup.iQd.setVisibility(0);
    Bitmap localBitmap = g.b(localf.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
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
      AppMethodBeat.o(25432);
      return paramView;
      paramViewGroup.iQd.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label259:
      paramViewGroup.sZf.setVisibility(8);
    }
  }
  
  public final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(25431);
    this.sYK = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(25431);
  }
  
  public final boolean xj(int paramInt)
  {
    AppMethodBeat.i(25434);
    int i = this.qIG.size();
    if ((paramInt >= i) && (paramInt < i + bHs()))
    {
      AppMethodBeat.o(25434);
      return true;
    }
    AppMethodBeat.o(25434);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.a
 * JD-Core Version:    0.7.0.1
 */