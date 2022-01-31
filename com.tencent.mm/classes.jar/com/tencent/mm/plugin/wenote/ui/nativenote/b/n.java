package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class n
  extends i
{
  public MMPinProgressBtn rNA;
  public ImageView rNB;
  private ImageView rNC;
  public ImageView rNz;
  
  public n(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    this.rNz = ((ImageView)paramView.findViewById(R.h.status_btn));
    this.rNA = ((MMPinProgressBtn)paramView.findViewById(R.h.video_progress));
    this.rNB = ((ImageView)paramView.findViewById(R.h.video_thumb));
    this.rNz.setImageResource(R.k.shortvideo_play_btn);
    this.rNC = ((ImageView)paramView.findViewById(R.h.video_mask));
    this.fmL.setVisibility(8);
    this.rNa.setVisibility(8);
    this.rNC.setVisibility(8);
    this.rNe.setTag(this);
    this.rNe.setOnClickListener(this.laS);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    com.tencent.mm.plugin.wenote.model.a.k localk = (com.tencent.mm.plugin.wenote.model.a.k)paramc;
    Object localObject3 = com.tencent.mm.plugin.wenote.b.c.UD(localk.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (com.tencent.mm.vfs.e.bK(localk.bTY))
      {
        localObject3 = com.tencent.mm.plugin.fav.ui.c.CU(localk.bTY);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (com.tencent.mm.vfs.e.bK(localk.thumbPath)) {
          com.tencent.mm.vfs.e.deleteFile(localk.thumbPath);
        }
        com.tencent.mm.pluginsdk.i.e.a((Bitmap)localObject3, Bitmap.CompressFormat.JPEG, localk.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label181;
        }
        localObject3 = this.rNB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.rNB.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.rNB.setImageBitmap(localObject1);
        this.rNB.setBackground(null);
        if (!paramc.rGu) {
          break label257;
        }
        this.rNC.setVisibility(0);
        super.a(paramc, paramInt1, paramInt2);
        return;
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
      }
      continue;
      label181:
      Object localObject2 = this.rNB.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.rNB.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.rNB.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label257:
      this.rNC.setVisibility(8);
    }
  }
  
  public final int cjv()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.n
 * JD-Core Version:    0.7.0.1
 */