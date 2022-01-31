package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.util.List;

public final class b
  extends BaseAdapter
  implements j.a
{
  private Context context;
  private List<f> nUB;
  boolean pwV = false;
  
  public b(Context paramContext, List<f> paramList)
  {
    this.context = paramContext;
    this.nUB = paramList;
  }
  
  private int bam()
  {
    return (4 - getRealCount() % 4) % 4;
  }
  
  private int getRealCount()
  {
    return this.nUB.size();
  }
  
  public final void a(String paramString, l paraml)
  {
    notifyDataSetChanged();
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
      paramViewGroup = new c();
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
      paramViewGroup = (c)paramView.getTag();
    }
    f localf = (f)getItem(paramInt);
    paramViewGroup.heN.setVisibility(0);
    Bitmap localBitmap = g.b(localf.field_appId, 5, a.getDensity(this.context));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.b
 * JD-Core Version:    0.7.0.1
 */