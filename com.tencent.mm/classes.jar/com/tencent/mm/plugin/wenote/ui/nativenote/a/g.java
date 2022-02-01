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
import com.tencent.mm.vfs.u;

public final class g
  extends j
{
  private int thumbWidth;
  private ImageView uqq;
  
  public g(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30860);
    this.thumbWidth = 0;
    this.fDJ.setVisibility(0);
    this.ndX.setVisibility(8);
    this.uqw.setVisibility(8);
    this.fDJ.setTag(this);
    this.fDJ.setOnClickListener(this.uqL);
    this.uqq = ((ImageView)paramView.findViewById(R.h.image_mask));
    this.uqq.setVisibility(8);
    this.thumbWidth = (k.mScreenWidth - (int)k.bd(20.0F));
    AppMethodBeat.o(30860);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30861);
    Object localObject1 = ((f)paramc).fNU;
    Object localObject2 = ((f)paramc).urR;
    if (!u.agG((String)localObject1)) {
      if (u.agG((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (this.QIM.QHZ == 3) {
        if (u.agG((String)localObject2)) {
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
          this.fDJ.setImageBitmap(null);
          localObject2 = this.fDJ.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = -1;
          ((ViewGroup.LayoutParams)localObject2).height = -1;
          this.fDJ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (localObject1 == null) {
            break label178;
          }
          this.fDJ.setImageBitmap((Bitmap)localObject1);
          if (!paramc.urN) {
            break label237;
          }
          this.uqq.setVisibility(0);
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
          localObject1 = com.tencent.mm.plugin.wenote.d.c.atB((String)localObject1);
          break label78;
          label178:
          this.fDJ.setImageBitmap(null);
          localObject1 = this.fDJ.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
          ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
          this.fDJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.fDJ.setBackgroundColor(Color.parseColor("#f6f6f6"));
          break label130;
          label237:
          this.uqq.setVisibility(8);
        }
      }
    }
  }
  
  public final int cRD()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.g
 * JD-Core Version:    0.7.0.1
 */