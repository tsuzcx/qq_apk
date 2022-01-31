package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class f
  extends i
{
  private int fgR;
  private ImageView vDx;
  
  public f(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27159);
    this.fgR = 0;
    this.cuM.setVisibility(0);
    this.gEf.setVisibility(8);
    this.vDE.setVisibility(8);
    this.cuM.setTag(this);
    this.cuM.setOnClickListener(this.nyO);
    this.vDx = ((ImageView)paramView.findViewById(2131826241));
    this.vDx.setVisibility(8);
    this.fgR = (k.mScreenWidth - (int)k.bo(20.0F));
    AppMethodBeat.o(27159);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27160);
    Object localObject1 = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).cBD;
    Object localObject2 = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).vxt;
    if (!e.cN((String)localObject1)) {
      if (e.cN((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (this.vBM.vzL == 3) {
        if (e.cN((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        label67:
        if (bo.isNullOrNil((String)localObject1))
        {
          localObject1 = null;
          label78:
          this.cuM.setImageBitmap(null);
          localObject2 = this.cuM.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = -1;
          ((ViewGroup.LayoutParams)localObject2).height = -1;
          this.cuM.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (localObject1 == null) {
            break label178;
          }
          this.cuM.setImageBitmap((Bitmap)localObject1);
          if (!paramc.vxd) {
            break label237;
          }
          this.vDx.setVisibility(0);
        }
        for (;;)
        {
          label130:
          super.a(paramc, paramInt1, paramInt2);
          AppMethodBeat.o(27160);
          return;
          localObject1 = null;
          break;
          break label67;
          localObject1 = com.tencent.mm.plugin.wenote.b.c.ajT((String)localObject1);
          break label78;
          label178:
          this.cuM.setImageBitmap(null);
          localObject1 = this.cuM.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.fgR;
          ((ViewGroup.LayoutParams)localObject1).height = this.fgR;
          this.cuM.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.cuM.setBackgroundColor(Color.parseColor("#f6f6f6"));
          break label130;
          label237:
          this.vDx.setVisibility(8);
        }
      }
    }
  }
  
  public final int djX()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.f
 * JD-Core Version:    0.7.0.1
 */