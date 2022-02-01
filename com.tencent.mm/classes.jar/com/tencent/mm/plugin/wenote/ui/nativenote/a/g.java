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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class g
  extends j
{
  private ImageView oOH;
  private int thumbWidth;
  
  public g(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30860);
    this.thumbWidth = 0;
    this.dhf.setVisibility(0);
    this.iRV.setVisibility(8);
    this.oON.setVisibility(8);
    this.dhf.setTag(this);
    this.dhf.setOnClickListener(this.oPc);
    this.oOH = ((ImageView)paramView.findViewById(2131300952));
    this.oOH.setVisibility(8);
    this.thumbWidth = (k.mScreenWidth - (int)k.aU(20.0F));
    AppMethodBeat.o(30860);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30861);
    Object localObject1 = ((f)paramc).dpK;
    Object localObject2 = ((f)paramc).oQg;
    if (!i.eA((String)localObject1)) {
      if (i.eA((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (this.CXj.CWB == 3) {
        if (i.eA((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        label67:
        if (bs.isNullOrNil((String)localObject1))
        {
          localObject1 = null;
          label78:
          this.dhf.setImageBitmap(null);
          localObject2 = this.dhf.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = -1;
          ((ViewGroup.LayoutParams)localObject2).height = -1;
          this.dhf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (localObject1 == null) {
            break label178;
          }
          this.dhf.setImageBitmap((Bitmap)localObject1);
          if (!paramc.oQc) {
            break label237;
          }
          this.oOH.setVisibility(0);
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
          localObject1 = com.tencent.mm.plugin.wenote.c.c.Xe((String)localObject1);
          break label78;
          label178:
          this.dhf.setImageBitmap(null);
          localObject1 = this.dhf.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
          ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
          this.dhf.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.dhf.setBackgroundColor(Color.parseColor("#f6f6f6"));
          break label130;
          label237:
          this.oOH.setVisibility(8);
        }
      }
    }
  }
  
  public final int bZp()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.g
 * JD-Core Version:    0.7.0.1
 */