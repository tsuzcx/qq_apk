package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.e;

public final class n
  extends i
{
  public ImageView vEd;
  public MMPinProgressBtn vEe;
  public ImageView vEf;
  private ImageView vEg;
  
  public n(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27182);
    this.vEd = ((ImageView)paramView.findViewById(2131820996));
    this.vEe = ((MMPinProgressBtn)paramView.findViewById(2131822192));
    this.vEf = ((ImageView)paramView.findViewById(2131822189));
    this.vEd.setImageResource(2131231980);
    this.vEg = ((ImageView)paramView.findViewById(2131825137));
    this.gEf.setVisibility(8);
    this.vDE.setVisibility(8);
    this.vEg.setVisibility(8);
    this.vDI.setTag(this);
    this.vDI.setOnClickListener(this.nyO);
    AppMethodBeat.o(27182);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27183);
    com.tencent.mm.plugin.wenote.model.a.k localk = (com.tencent.mm.plugin.wenote.model.a.k)paramc;
    Object localObject3 = com.tencent.mm.plugin.wenote.b.c.ajT(localk.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (e.cN(localk.cBD))
      {
        localObject3 = com.tencent.mm.plugin.fav.ui.c.NW(localk.cBD);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (e.cN(localk.thumbPath)) {
          e.deleteFile(localk.thumbPath);
        }
        f.a((Bitmap)localObject3, Bitmap.CompressFormat.JPEG, localk.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label193;
        }
        localObject3 = this.vEf.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.vEf.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.vEf.setImageBitmap(localObject1);
        this.vEf.setBackground(null);
        if (!paramc.vxd) {
          break label269;
        }
        this.vEg.setVisibility(0);
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(27183);
        return;
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
      }
      continue;
      label193:
      Object localObject2 = this.vEf.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.vEf.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.vEf.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label269:
      this.vEg.setVisibility(8);
    }
  }
  
  public final int djX()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.n
 * JD-Core Version:    0.7.0.1
 */