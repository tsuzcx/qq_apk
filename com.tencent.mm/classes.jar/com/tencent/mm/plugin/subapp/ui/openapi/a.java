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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
  implements j.a
{
  private Context context;
  private List<f> nUB;
  boolean pwV = false;
  private int pwW = 0;
  
  public a(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    this.pwW = paramInt;
    init();
  }
  
  private int bam()
  {
    return (4 - getRealCount() % 4) % 4;
  }
  
  private int getRealCount()
  {
    return this.nUB.size();
  }
  
  private void init()
  {
    int i = 0;
    this.nUB = new ArrayList();
    Object localObject1 = ap.brn();
    int j = this.pwW;
    Object localObject2 = ((i)localObject1).rawQuery("select * from AppInfo where status = " + j + " and (appType is null or appType not like ',1,')", new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      y.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      j = ((Cursor)localObject1).getCount();
      while (i < j)
      {
        ((Cursor)localObject1).moveToPosition(i);
        localObject2 = new f();
        ((f)localObject2).d((Cursor)localObject1);
        if (g.o(this.context, ((f)localObject2).field_appId)) {
          this.nUB.add(localObject2);
        }
        i += 1;
      }
      ((Cursor)localObject1).close();
    }
  }
  
  public final void a(String paramString, l paraml)
  {
    init();
    super.notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    return getRealCount() + bam();
  }
  
  public final Object getItem(int paramInt)
  {
    if (sk(paramInt)) {
      return null;
    }
    return this.nUB.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new d();
      paramView = View.inflate(this.context, R.i.app_item, null);
      paramViewGroup.heN = ((ImageView)paramView.findViewById(R.h.appitem_icon_iv));
      paramViewGroup.pxr = ((TextView)paramView.findViewById(R.h.appitem_del_tv));
      paramViewGroup.fdt = ((TextView)paramView.findViewById(R.h.appitem_name_tv));
      paramViewGroup.pxs = paramView.findViewById(R.h.appitem_new_icon);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.pxs.setVisibility(4);
      if (!sk(paramInt)) {
        break;
      }
      paramViewGroup.heN.setVisibility(4);
      paramViewGroup.pxr.setVisibility(4);
      paramViewGroup.fdt.setVisibility(4);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
    f localf = (f)getItem(paramInt);
    paramViewGroup.heN.setVisibility(0);
    Bitmap localBitmap = g.b(localf.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
    if (localBitmap == null) {
      paramViewGroup.heN.setBackgroundResource(R.g.app_panel_unknowed_icon);
    }
    for (;;)
    {
      paramViewGroup.fdt.setVisibility(0);
      paramViewGroup.fdt.setText(g.b(this.context, localf, null));
      if (!this.pwV) {
        break;
      }
      paramViewGroup.pxr.setVisibility(0);
      return paramView;
      paramViewGroup.heN.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    paramViewGroup.pxr.setVisibility(8);
    return paramView;
  }
  
  public final void jD(boolean paramBoolean)
  {
    this.pwV = paramBoolean;
    notifyDataSetChanged();
  }
  
  public final boolean sk(int paramInt)
  {
    int i = this.nUB.size();
    return (paramInt >= i) && (paramInt < i + bam());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.a
 * JD-Core Version:    0.7.0.1
 */