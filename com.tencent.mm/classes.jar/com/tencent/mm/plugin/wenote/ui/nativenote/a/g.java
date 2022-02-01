package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class g
  extends j
{
  private int thumbWidth;
  private ImageView xwN;
  
  public g(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30860);
    this.thumbWidth = 0;
    this.hIz.setVisibility(0);
    this.pZr.setVisibility(8);
    this.xwT.setVisibility(8);
    this.hIz.setTag(this);
    this.hIz.setOnClickListener(this.xxi);
    this.xwN = ((ImageView)paramView.findViewById(R.h.image_mask));
    this.xwN.setVisibility(8);
    this.thumbWidth = (k.mScreenWidth - (int)k.cg(20.0F));
    AppMethodBeat.o(30860);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30861);
    Object localObject1 = ((f)paramc).hTM;
    Object localObject2 = ((f)paramc).xym;
    if (!y.ZC((String)localObject1)) {
      if (y.ZC((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (this.XCl.XBx == 3) {
        if (y.ZC((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        label67:
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject1 = null;
          label78:
          this.hIz.setImageBitmap(null);
          localObject2 = this.hIz.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = -1;
          ((ViewGroup.LayoutParams)localObject2).height = -1;
          this.hIz.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (localObject1 == null) {
            break label178;
          }
          this.hIz.setImageBitmap((Bitmap)localObject1);
          if (!paramc.xyi) {
            break label237;
          }
          this.xwN.setVisibility(0);
        }
        for (;;)
        {
          label130:
          super.a(paramc, paramInt1, paramInt2);
          AppMethodBeat.o(30861);
          return;
          localObject1 = null;
          break;
          break label67;
          localObject1 = com.tencent.mm.plugin.wenote.c.c.anq((String)localObject1);
          break label78;
          label178:
          this.hIz.setImageBitmap(null);
          localObject1 = this.hIz.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
          ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
          this.hIz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.hIz.setBackgroundColor(Color.parseColor("#f6f6f6"));
          break label130;
          label237:
          this.xwN.setVisibility(8);
        }
      }
    }
  }
  
  public final int dvW()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.g
 * JD-Core Version:    0.7.0.1
 */