package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class ShowImageUI$a
  extends BaseAdapter
{
  String imagePath;
  
  private ShowImageUI$a(ShowImageUI paramShowImageUI) {}
  
  public final int getCount()
  {
    return 1;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39191);
    if (t.aFm(this.imagePath))
    {
      localObject = paramViewGroup.getContext();
      paramViewGroup = this.imagePath;
      new com.tencent.mm.plugin.gif.f(paramViewGroup);
      if ((paramView == null) || (!(paramView instanceof MMAnimateView))) {}
      for (paramView = new MMAnimateView((Context)localObject);; paramView = (MMAnimateView)paramView)
      {
        paramView.gD(paramViewGroup, paramViewGroup);
        paramView.a(paramViewGroup, new k()
        {
          public final void invalidate()
          {
            AppMethodBeat.i(39190);
            paramView.invalidate();
            AppMethodBeat.o(39190);
          }
        });
        paramView.stop();
        paramView.start();
        AppMethodBeat.o(39191);
        return paramView;
      }
    }
    Object localObject = u.BA(this.imagePath);
    paramInt = Exif.fromFile(this.imagePath).getOrientationInDegree();
    ad.d("MicroMsg.ShowImageUI", "imagePath : %s degree : %d", new Object[] { this.imagePath, Integer.valueOf(paramInt) });
    localObject = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, paramInt);
    if (localObject == null)
    {
      ad.w("MicroMsg.ShowImageUI", "get image fail");
      if (paramView != null)
      {
        localObject = paramView;
        if (!(paramView instanceof MultiTouchImageView)) {}
      }
      else
      {
        localObject = View.inflate(paramViewGroup.getContext(), 2131495442, null);
      }
      ((ImageView)((View)localObject).findViewById(2131300943)).setImageResource(2131690066);
      ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      AppMethodBeat.o(39191);
      return localObject;
    }
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
      paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), (byte)0);
    }
    for (;;)
    {
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramView.setImageBitmap((Bitmap)localObject);
      paramView.setMaxZoomDoubleTab(true);
      AppMethodBeat.o(39191);
      return paramView;
      paramView = (MultiTouchImageView)paramView;
      paramView.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI.a
 * JD-Core Version:    0.7.0.1
 */