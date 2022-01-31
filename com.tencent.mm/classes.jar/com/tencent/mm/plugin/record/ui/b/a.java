package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements h.b
{
  private ListView Nn;
  j gvM;
  Map<String, nb> kbT = new HashMap();
  private c kbV = new a.4(this);
  private View.OnClickListener kdc = new a.1(this);
  View.OnLongClickListener kfL = new a.2(this);
  h.a ntP;
  int nur;
  
  public a(h.a parama, ListView paramListView)
  {
    this.ntP = parama;
    this.Nn = paramListView;
    com.tencent.mm.sdk.b.a.udP.c(this.kbV);
  }
  
  public final void a(View paramView, int paramInt, b paramb)
  {
    paramView = (ImageView)paramView.findViewById(R.h.record_listitem_content);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.kdc);
    if (paramb.aYU == 1) {
      paramView.setOnLongClickListener(this.kfL);
    }
    h.a.b localb = new h.a.b();
    if (paramb.aYU == 0) {
      localb.ntR = paramb.bIt;
    }
    for (;;)
    {
      localb.bNt = paramb.bNt;
      localb.bNw = true;
      localb.maxWidth = this.nur;
      Bitmap localBitmap = this.ntP.a(localb);
      if (localBitmap == null) {
        break;
      }
      y.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { localb.bNt.kgC, localBitmap });
      a(paramView, localBitmap, R.k.fav_list_img_default, paramb.bNt.kgC);
      return;
      if (paramb.aYU == 1) {
        localb.ntR = paramb.khA.field_localId;
      }
    }
    au.DS().O(new a.3(this, paramb, paramView));
  }
  
  final void a(ImageView paramImageView, Bitmap paramBitmap, int paramInt, String paramString)
  {
    if (!((b)paramImageView.getTag()).bNt.kgC.equals(paramString))
    {
      y.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = paramImageView.getLayoutParams();
      paramBitmap.height = 200;
      paramBitmap.width = 280;
      paramImageView.setImageResource(paramInt);
      paramImageView.setBackgroundResource(R.e.light_grey);
      return;
    }
    y.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramImageView.getWidth()), Integer.valueOf(paramImageView.getHeight()) });
    paramString = paramImageView.getLayoutParams();
    paramInt = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    float f;
    if (i >= paramInt)
    {
      f = i / paramInt;
      if (f <= 2.5D) {
        break label428;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, (paramBitmap.getHeight() - (int)(paramBitmap.getWidth() * 2.5F)) / 2, paramBitmap.getWidth(), (int)(paramBitmap.getWidth() * 2.5F));
      f = 2.5F;
    }
    label428:
    for (;;)
    {
      if (f <= 2.0F)
      {
        paramInt = com.tencent.mm.cb.a.ab(paramImageView.getContext(), R.f.ChatImgLimitWidth);
        i = (int)(paramInt / f);
      }
      for (;;)
      {
        paramString.width = i;
        paramString.height = paramInt;
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        k.o(paramImageView, i, paramInt);
        if (paramImageView.getLayerType() == 1) {
          this.Nn.setLayerType(1, null);
        }
        paramImageView.setImageBitmap(paramBitmap);
        paramImageView.setBackgroundResource(0);
        return;
        i = com.tencent.mm.cb.a.ab(paramImageView.getContext(), R.f.ChatImgMinWidth);
        paramInt = (int)(i * f);
      }
      f = paramInt / i;
      if (f > 2.5D)
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - (int)(paramBitmap.getHeight() * 2.5F)) / 2, 0, (int)(paramBitmap.getHeight() * 2.5F), paramBitmap.getHeight());
        f = 2.5F;
      }
      for (;;)
      {
        if (f <= 2.0F)
        {
          i = com.tencent.mm.cb.a.ab(paramImageView.getContext(), R.f.ChatImgLimitWidth);
          paramInt = (int)(i / f);
          break;
        }
        paramInt = com.tencent.mm.cb.a.ab(paramImageView.getContext(), R.f.ChatImgMinWidth);
        i = (int)(paramInt * f);
        break;
      }
    }
  }
  
  public final View dZ(Context paramContext)
  {
    View localView = View.inflate(paramContext, R.i.record_listitem_image, null);
    this.nur = com.tencent.mm.cb.a.fromDPToPix(paramContext, 200);
    return localView;
  }
  
  public final void destroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.kbV);
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a
 * JD-Core Version:    0.7.0.1
 */