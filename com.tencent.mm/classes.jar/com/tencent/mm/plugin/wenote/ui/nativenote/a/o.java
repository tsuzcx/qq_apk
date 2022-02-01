package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.y;

public final class o
  extends j
{
  public ImageView xxr;
  public MMPinProgressBtn xxs;
  public ImageView xxt;
  private ImageView xxu;
  
  public o(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30883);
    this.xxr = ((ImageView)paramView.findViewById(R.h.status_btn));
    this.xxs = ((MMPinProgressBtn)paramView.findViewById(R.h.video_progress));
    this.xxt = ((ImageView)paramView.findViewById(R.h.video_thumb));
    this.xxr.setImageResource(R.k.shortvideo_play_btn);
    this.xxu = ((ImageView)paramView.findViewById(R.h.video_mask));
    this.pZr.setVisibility(8);
    this.xwT.setVisibility(8);
    this.xxu.setVisibility(8);
    this.xwX.setTag(this);
    this.xwX.setOnClickListener(this.xxi);
    AppMethodBeat.o(30883);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30884);
    com.tencent.mm.plugin.wenote.model.a.k localk = (com.tencent.mm.plugin.wenote.model.a.k)paramc;
    Object localObject3 = com.tencent.mm.plugin.wenote.c.c.anq(localk.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (y.ZC(localk.hTM))
      {
        localObject3 = e.auu(localk.hTM);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (y.ZC(localk.thumbPath)) {
          y.deleteFile(localk.thumbPath);
        }
        f.a((Bitmap)localObject3, Bitmap.CompressFormat.JPEG, localk.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label193;
        }
        localObject3 = this.xxt.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.xxt.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.xxt.setImageBitmap(localObject1);
        this.xxt.setBackground(null);
        if (!paramc.xyi) {
          break label269;
        }
        this.xxu.setVisibility(0);
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(30884);
        return;
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
      }
      continue;
      label193:
      Object localObject2 = this.xxt.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.xxt.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.xxt.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label269:
      this.xxu.setVisibility(8);
    }
  }
  
  public final int dvW()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.o
 * JD-Core Version:    0.7.0.1
 */