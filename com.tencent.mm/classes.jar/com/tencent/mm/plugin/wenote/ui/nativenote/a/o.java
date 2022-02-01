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
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.s;

public final class o
  extends j
{
  public ImageView qOQ;
  public MMPinProgressBtn qOR;
  public ImageView qOS;
  private ImageView qOT;
  
  public o(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30883);
    this.qOQ = ((ImageView)paramView.findViewById(2131308392));
    this.qOR = ((MMPinProgressBtn)paramView.findViewById(2131309808));
    this.qOS = ((ImageView)paramView.findViewById(2131309829));
    this.qOQ.setImageResource(2131691480);
    this.qOT = ((ImageView)paramView.findViewById(2131309781));
    this.kmg.setVisibility(8);
    this.qOs.setVisibility(8);
    this.qOT.setVisibility(8);
    this.qOw.setTag(this);
    this.qOw.setOnClickListener(this.qOH);
    AppMethodBeat.o(30883);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30884);
    com.tencent.mm.plugin.wenote.model.a.k localk = (com.tencent.mm.plugin.wenote.model.a.k)paramc;
    Object localObject3 = com.tencent.mm.plugin.wenote.c.c.alI(localk.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (s.YS(localk.dUs))
      {
        localObject3 = e.asm(localk.dUs);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (s.YS(localk.thumbPath)) {
          s.deleteFile(localk.thumbPath);
        }
        f.a((Bitmap)localObject3, Bitmap.CompressFormat.JPEG, localk.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label193;
        }
        localObject3 = this.qOS.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.qOS.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.qOS.setImageBitmap(localObject1);
        this.qOS.setBackground(null);
        if (!paramc.qPH) {
          break label269;
        }
        this.qOT.setVisibility(0);
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
      Object localObject2 = this.qOS.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.qOS.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.qOS.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label269:
      this.qOT.setVisibility(8);
    }
  }
  
  public final int cCY()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.o
 * JD-Core Version:    0.7.0.1
 */