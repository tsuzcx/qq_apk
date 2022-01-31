package com.tencent.mm.plugin.subapp.ui.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.vfs.e;
import java.util.List;

final class GestureGalleryUI$a
  extends BaseAdapter
{
  public GestureGalleryUI$a(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final int getCount()
  {
    y.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.l(this.pwN).size());
    return GestureGalleryUI.l(this.pwN).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GestureGalleryUI.a.a locala;
    View localView;
    String str;
    if (paramView == null)
    {
      locala = new GestureGalleryUI.a.a(this);
      localView = View.inflate(this.pwN, R.i.readerapp_imageview_item, null);
      locala.oZs = ((ProgressBar)localView.findViewById(R.h.progressbar));
      locala.pwQ = ((MMAnimateView)localView.findViewById(R.h.image));
      localView.setTag(locala);
      localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      str = (String)GestureGalleryUI.l(this.pwN).get(paramInt);
      if (!e.bK(str)) {
        break label193;
      }
      label106:
      if (bk.bl(str)) {
        break label500;
      }
      locala.oZs.setVisibility(8);
      if (str != null) {
        break label225;
      }
      paramView = null;
      if (!o.Za(str)) {
        break label405;
      }
    }
    label193:
    label225:
    label368:
    while ((paramView == null) || (paramView.isRecycled()))
    {
      try
      {
        locala.pwQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        locala.pwQ.setVisibility(0);
        locala.pwQ.setImageFilePath(str);
        return localView;
      }
      catch (Exception paramViewGroup)
      {
        boolean bool;
        y.e("MicroMsg.GestureGalleryUI", bk.j(paramViewGroup));
        locala.pwQ.setVisibility(0);
        locala.pwQ.setImageBitmap(paramView);
        return localView;
      }
      locala = (GestureGalleryUI.a.a)paramView.getTag();
      localView = paramView;
      break;
      str = GestureGalleryUI.o(this.pwN).c(str, GestureGalleryUI.m(this.pwN), paramInt, GestureGalleryUI.n(this.pwN));
      break label106;
      paramView = new BitmapFactory.Options();
      paramView.inJustDecodeBounds = true;
      paramView = BitmapFactory.decodeFile(str, paramView);
      if (paramView != null)
      {
        y.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = c.YW(str);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = paramView;
        if (MMNativeJpeg.IsJpegFile(str))
        {
          paramViewGroup = paramView;
          if (MMNativeJpeg.isProgressive(str))
          {
            paramViewGroup = MMNativeJpeg.decodeAsBitmap(str);
            if (paramViewGroup != null) {
              break label368;
            }
          }
        }
      }
      for (bool = true;; bool = false)
      {
        y.i("MicroMsg.GestureGalleryUI", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
        paramView = paramViewGroup;
        if (paramViewGroup != null) {
          break;
        }
        y.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = " + str);
        paramView = null;
        break;
      }
    }
    label405:
    locala.pwQ.setVisibility(8);
    paramViewGroup = new MultiTouchImageView(this.pwN, paramView.getWidth(), paramView.getHeight());
    if (Build.VERSION.SDK_INT == 20) {
      paramViewGroup.setLayerType(1, null);
    }
    for (;;)
    {
      paramViewGroup.setEnableHorLongBmpMode(false);
      paramViewGroup.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramViewGroup.setImageBitmap(paramView);
      return paramViewGroup;
      k.o(paramViewGroup, paramView.getWidth(), paramView.getHeight());
    }
    label500:
    locala.oZs.setVisibility(0);
    locala.pwQ.setVisibility(8);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.a
 * JD-Core Version:    0.7.0.1
 */