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
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
  implements k.a
{
  private Context context;
  private List<g> whn;
  boolean yFk;
  private int yFl;
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(29123);
    this.yFk = false;
    this.yFl = 0;
    this.context = paramContext;
    this.yFl = paramInt;
    init();
    AppMethodBeat.o(29123);
  }
  
  private int cEn()
  {
    AppMethodBeat.i(29131);
    int i = getRealCount();
    AppMethodBeat.o(29131);
    return (4 - i % 4) % 4;
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(29130);
    int i = this.whn.size();
    AppMethodBeat.o(29130);
    return i;
  }
  
  private void init()
  {
    int i = 0;
    AppMethodBeat.i(29124);
    this.whn = new ArrayList();
    Object localObject1 = ap.cZQ();
    int j = this.yFl;
    Object localObject2 = ((j)localObject1).rawQuery("select * from AppInfo where status = " + j + " and (appType is null or appType not like ',1,')", new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      ad.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
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
        if (h.t(this.context, ((g)localObject2).field_appId)) {
          this.whn.add(localObject2);
        }
        i += 1;
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(29124);
  }
  
  public final boolean EJ(int paramInt)
  {
    AppMethodBeat.i(29128);
    int i = this.whn.size();
    if ((paramInt >= i) && (paramInt < i + cEn()))
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
    int j = cEn();
    AppMethodBeat.o(29127);
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(29129);
    if (EJ(paramInt))
    {
      AppMethodBeat.o(29129);
      return null;
    }
    Object localObject = this.whn.get(paramInt);
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
      paramViewGroup.fxT = ((ImageView)paramView.findViewById(2131296905));
      paramViewGroup.yFF = ((TextView)paramView.findViewById(2131296904));
      paramViewGroup.ftj = ((TextView)paramView.findViewById(2131296906));
      paramViewGroup.yFG = paramView.findViewById(2131296907);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.yFG.setVisibility(4);
      if (!EJ(paramInt)) {
        break;
      }
      paramViewGroup.fxT.setVisibility(4);
      paramViewGroup.yFF.setVisibility(4);
      paramViewGroup.ftj.setVisibility(4);
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
    g localg = (g)getItem(paramInt);
    paramViewGroup.fxT.setVisibility(0);
    Bitmap localBitmap = h.c(localg.field_appId, 1, com.tencent.mm.cd.a.getDensity(this.context));
    if (localBitmap == null)
    {
      paramViewGroup.fxT.setBackgroundResource(2131231052);
      paramViewGroup.ftj.setVisibility(0);
      paramViewGroup.ftj.setText(h.a(this.context, localg, null));
      if (!this.yFk) {
        break label259;
      }
      paramViewGroup.yFF.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(29126);
      return paramView;
      paramViewGroup.fxT.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      break;
      label259:
      paramViewGroup.yFF.setVisibility(8);
    }
  }
  
  public final void qZ(boolean paramBoolean)
  {
    AppMethodBeat.i(29125);
    this.yFk = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(29125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.a
 * JD-Core Version:    0.7.0.1
 */