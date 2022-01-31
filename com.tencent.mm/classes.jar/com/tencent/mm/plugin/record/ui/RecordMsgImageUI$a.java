package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.util.LinkedList;
import java.util.List;

final class RecordMsgImageUI$a
  extends BaseAdapter
{
  long bIt = -1L;
  List<xv> drc = new LinkedList();
  f nud;
  
  public final int getCount()
  {
    return this.drc.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    f localf = this.nud;
    xv localxv = wC(paramInt);
    long l = this.bIt;
    Object localObject = localf.a(localxv, l, false);
    if (localObject == null)
    {
      boolean bool = localf.a(localxv, l);
      y.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
      h.b(localxv, l, bool);
    }
    if (localObject == null)
    {
      y.w("MicroMsg.ShowImageUI", "get image fail");
      if (paramView != null)
      {
        localObject = paramView;
        if (!(paramView instanceof MultiTouchImageView)) {}
      }
      else
      {
        localObject = View.inflate(paramViewGroup.getContext(), R.i.show_image_ui_item, null);
      }
      ((ImageView)((View)localObject).findViewById(R.h.image_iv)).setImageResource(R.k.download_image_icon);
      ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      return localObject;
    }
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
      paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
    for (;;)
    {
      k.o(paramView, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramView.setImageBitmap((Bitmap)localObject);
      paramView.setMaxZoomDoubleTab(true);
      return paramView;
      paramView = (MultiTouchImageView)paramView;
      paramView.fs(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
  }
  
  public final xv wC(int paramInt)
  {
    return (xv)this.drc.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.a
 * JD-Core Version:    0.7.0.1
 */