package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class g
  extends j
{
  private ImageView olh;
  private int thumbWidth;
  
  public g(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30860);
    this.thumbWidth = 0;
    this.djK.setVisibility(0);
    this.irQ.setVisibility(8);
    this.oln.setVisibility(8);
    this.djK.setTag(this);
    this.djK.setOnClickListener(this.olC);
    this.olh = ((ImageView)paramView.findViewById(2131300952));
    this.olh.setVisibility(8);
    this.thumbWidth = (k.mScreenWidth - (int)k.aQ(20.0F));
    AppMethodBeat.o(30860);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30861);
    Object localObject1 = ((f)paramc).drZ;
    Object localObject2 = ((f)paramc).omG;
    if (!i.eK((String)localObject1)) {
      if (i.eK((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (this.BFc.BEu == 3) {
        if (i.eK((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        label67:
        if (bt.isNullOrNil((String)localObject1))
        {
          localObject1 = null;
          label78:
          this.djK.setImageBitmap(null);
          localObject2 = this.djK.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = -1;
          ((ViewGroup.LayoutParams)localObject2).height = -1;
          this.djK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (localObject1 == null) {
            break label178;
          }
          this.djK.setImageBitmap((Bitmap)localObject1);
          if (!paramc.omC) {
            break label237;
          }
          this.olh.setVisibility(0);
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
          localObject1 = com.tencent.mm.plugin.wenote.c.c.SS((String)localObject1);
          break label78;
          label178:
          this.djK.setImageBitmap(null);
          localObject1 = this.djK.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
          ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
          this.djK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.djK.setBackgroundColor(Color.parseColor("#f6f6f6"));
          break label130;
          label237:
          this.olh.setVisibility(8);
        }
      }
    }
  }
  
  public final int bSa()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.g
 * JD-Core Version:    0.7.0.1
 */