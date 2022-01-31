package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.util.LinkedList;
import java.util.List;

final class RecordMsgImageUI$a
  extends BaseAdapter
{
  long cpO;
  List<aca> eiJ;
  l pZM;
  
  private RecordMsgImageUI$a()
  {
    AppMethodBeat.i(24307);
    this.eiJ = new LinkedList();
    this.cpO = -1L;
    AppMethodBeat.o(24307);
  }
  
  public final aca Cn(int paramInt)
  {
    AppMethodBeat.i(24309);
    aca localaca = (aca)this.eiJ.get(paramInt);
    AppMethodBeat.o(24309);
    return localaca;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(24308);
    int i = this.eiJ.size();
    AppMethodBeat.o(24308);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24310);
    l locall = this.pZM;
    aca localaca = Cn(paramInt);
    long l = this.cpO;
    Object localObject = locall.a(localaca, l, false);
    if (localObject == null)
    {
      boolean bool = locall.a(localaca, l);
      ab.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.plugin.record.b.n.b(localaca, l, bool);
    }
    if (localObject == null)
    {
      ab.w("MicroMsg.ShowImageUI", "get image fail");
      if (paramView != null)
      {
        localObject = paramView;
        if (!(paramView instanceof MultiTouchImageView)) {}
      }
      else
      {
        localObject = View.inflate(paramViewGroup.getContext(), 2130970737, null);
      }
      ((ImageView)((View)localObject).findViewById(2131822243)).setImageResource(2131231253);
      ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      AppMethodBeat.o(24310);
      return localObject;
    }
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
      paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.n.x(paramView, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramView.setImageBitmap((Bitmap)localObject);
      paramView.setMaxZoomDoubleTab(true);
      AppMethodBeat.o(24310);
      return paramView;
      paramView = (MultiTouchImageView)paramView;
      paramView.cb(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.a
 * JD-Core Version:    0.7.0.1
 */