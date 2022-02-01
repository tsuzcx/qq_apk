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
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.i;

public final class o
  extends j
{
  public ImageView olL;
  public MMPinProgressBtn olM;
  public ImageView olN;
  private ImageView olO;
  
  public o(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30883);
    this.olL = ((ImageView)paramView.findViewById(2131305196));
    this.olM = ((MMPinProgressBtn)paramView.findViewById(2131306379));
    this.olN = ((ImageView)paramView.findViewById(2131306398));
    this.olL.setImageResource(2131691166);
    this.olO = ((ImageView)paramView.findViewById(2131306355));
    this.irQ.setVisibility(8);
    this.oln.setVisibility(8);
    this.olO.setVisibility(8);
    this.olr.setTag(this);
    this.olr.setOnClickListener(this.olC);
    AppMethodBeat.o(30883);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30884);
    com.tencent.mm.plugin.wenote.model.a.k localk = (com.tencent.mm.plugin.wenote.model.a.k)paramc;
    Object localObject3 = com.tencent.mm.plugin.wenote.c.c.SS(localk.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (i.eK(localk.drZ))
      {
        localObject3 = e.Yw(localk.drZ);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (i.eK(localk.thumbPath)) {
          i.deleteFile(localk.thumbPath);
        }
        f.a((Bitmap)localObject3, Bitmap.CompressFormat.JPEG, localk.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label193;
        }
        localObject3 = this.olN.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.olN.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.olN.setImageBitmap(localObject1);
        this.olN.setBackground(null);
        if (!paramc.omC) {
          break label269;
        }
        this.olO.setVisibility(0);
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
      Object localObject2 = this.olN.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.olN.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.olN.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label269:
      this.olO.setVisibility(8);
    }
  }
  
  public final int bSa()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.o
 * JD-Core Version:    0.7.0.1
 */