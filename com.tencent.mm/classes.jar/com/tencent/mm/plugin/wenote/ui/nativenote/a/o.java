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
import com.tencent.mm.pluginsdk.m.g;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;

public final class o
  extends j
{
  public ImageView uqU;
  public MMPinProgressBtn uqV;
  public ImageView uqW;
  private ImageView uqX;
  
  public o(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30883);
    this.uqU = ((ImageView)paramView.findViewById(R.h.status_btn));
    this.uqV = ((MMPinProgressBtn)paramView.findViewById(R.h.video_progress));
    this.uqW = ((ImageView)paramView.findViewById(R.h.video_thumb));
    this.uqU.setImageResource(R.k.shortvideo_play_btn);
    this.uqX = ((ImageView)paramView.findViewById(R.h.video_mask));
    this.ndX.setVisibility(8);
    this.uqw.setVisibility(8);
    this.uqX.setVisibility(8);
    this.uqA.setTag(this);
    this.uqA.setOnClickListener(this.uqL);
    AppMethodBeat.o(30883);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30884);
    com.tencent.mm.plugin.wenote.model.a.k localk = (com.tencent.mm.plugin.wenote.model.a.k)paramc;
    Object localObject3 = com.tencent.mm.plugin.wenote.d.c.atB(localk.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (u.agG(localk.fNU))
      {
        localObject3 = e.aAn(localk.fNU);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (u.agG(localk.thumbPath)) {
          u.deleteFile(localk.thumbPath);
        }
        g.a((Bitmap)localObject3, Bitmap.CompressFormat.JPEG, localk.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label193;
        }
        localObject3 = this.uqW.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.uqW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.uqW.setImageBitmap(localObject1);
        this.uqW.setBackground(null);
        if (!paramc.urN) {
          break label269;
        }
        this.uqX.setVisibility(0);
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
      Object localObject2 = this.uqW.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.uqW.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.uqW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label269:
      this.uqX.setVisibility(8);
    }
  }
  
  public final int cRD()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.o
 * JD-Core Version:    0.7.0.1
 */