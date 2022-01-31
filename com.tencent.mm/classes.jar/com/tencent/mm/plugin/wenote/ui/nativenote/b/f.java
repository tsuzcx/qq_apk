package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.vfs.e;

public final class f
  extends i
{
  private int dQQ = 0;
  private ImageView rMT;
  
  public f(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.bNu.setVisibility(0);
    this.fmL.setVisibility(8);
    this.rNa.setVisibility(8);
    this.bNu.setTag(this);
    this.bNu.setOnClickListener(this.laS);
    this.rMT = ((ImageView)paramView.findViewById(R.h.image_mask));
    this.rMT.setVisibility(8);
    this.dQQ = (k.mScreenWidth - (int)k.az(20.0F));
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    Object localObject1 = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).bTY;
    Object localObject2 = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).rGK;
    if (!e.bK((String)localObject1)) {
      if (e.bK((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (this.rLi.rJg == 3) {
        if (e.bK((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        label61:
        if (bk.bl((String)localObject1))
        {
          localObject1 = null;
          label72:
          this.bNu.setImageBitmap(null);
          localObject2 = this.bNu.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = -1;
          ((ViewGroup.LayoutParams)localObject2).height = -1;
          this.bNu.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (localObject1 == null) {
            break label166;
          }
          this.bNu.setImageBitmap((Bitmap)localObject1);
          label124:
          if (!paramc.rGu) {
            break label225;
          }
          this.rMT.setVisibility(0);
        }
        for (;;)
        {
          super.a(paramc, paramInt1, paramInt2);
          return;
          localObject1 = null;
          break;
          break label61;
          localObject1 = com.tencent.mm.plugin.wenote.b.c.UD((String)localObject1);
          break label72;
          label166:
          this.bNu.setImageBitmap(null);
          localObject1 = this.bNu.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.dQQ;
          ((ViewGroup.LayoutParams)localObject1).height = this.dQQ;
          this.bNu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.bNu.setBackgroundColor(Color.parseColor("#f6f6f6"));
          break label124;
          label225:
          this.rMT.setVisibility(8);
        }
      }
    }
  }
  
  public final int cjv()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.f
 * JD-Core Version:    0.7.0.1
 */