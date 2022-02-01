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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class g
  extends j
{
  private ImageView qOm;
  private int thumbWidth;
  
  public g(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30860);
    this.thumbWidth = 0;
    this.dKU.setVisibility(0);
    this.kmg.setVisibility(8);
    this.qOs.setVisibility(8);
    this.dKU.setTag(this);
    this.dKU.setOnClickListener(this.qOH);
    this.qOm = ((ImageView)paramView.findViewById(2131302585));
    this.qOm.setVisibility(8);
    this.thumbWidth = (k.mScreenWidth - (int)k.be(20.0F));
    AppMethodBeat.o(30860);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30861);
    Object localObject1 = ((f)paramc).dUs;
    Object localObject2 = ((f)paramc).qPL;
    if (!s.YS((String)localObject1)) {
      if (s.YS((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (this.JJu.JIH == 3) {
        if (s.YS((String)localObject2)) {
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
          this.dKU.setImageBitmap(null);
          localObject2 = this.dKU.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = -1;
          ((ViewGroup.LayoutParams)localObject2).height = -1;
          this.dKU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (localObject1 == null) {
            break label178;
          }
          this.dKU.setImageBitmap((Bitmap)localObject1);
          if (!paramc.qPH) {
            break label237;
          }
          this.qOm.setVisibility(0);
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
          localObject1 = com.tencent.mm.plugin.wenote.c.c.alI((String)localObject1);
          break label78;
          label178:
          this.dKU.setImageBitmap(null);
          localObject1 = this.dKU.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
          ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
          this.dKU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.dKU.setBackgroundColor(Color.parseColor("#f6f6f6"));
          break label130;
          label237:
          this.qOm.setVisibility(8);
        }
      }
    }
  }
  
  public final int cCY()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.g
 * JD-Core Version:    0.7.0.1
 */