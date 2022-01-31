package com.tencent.mm.plugin.sns.ui;

import android.os.StrictMode;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.protocal.c.bto;

final class i$1$2
  implements Runnable
{
  i$1$2(i.1 param1, n paramn, a.c paramc, View paramView) {}
  
  public final void run()
  {
    if (this.oNW.oNT.oNC != null) {
      this.oNW.oNT.oNC.ota.x(this.oNX);
    }
    Object localObject1;
    Object localObject2;
    int i;
    if (this.oNY.pmB == 0)
    {
      localObject1 = aj.q(this.oNX);
      localObject2 = com.tencent.mm.modelsns.b.jd(707);
      ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.j(this.oNX)).jg(this.oNX.field_type).cb(this.oNX.yr(32)).ni(this.oNX.bGM()).ni(this.oNX.field_userName).jg(((bto)localObject1).tJW).jg(((bto)localObject1).tJZ);
      ((com.tencent.mm.modelsns.b)localObject2).QX();
      StrictMode.allowThreadDiskReads();
      this.oNY.pmB = 1;
      this.oNX.field_likeFlag = this.oNY.pmB;
      h.a(this.oNX.bGk(), this.oNX);
      ((TextView)this.hdG.findViewById(i.f.album_like_tv)).setText(i.j.sns_has_liked);
      localObject1 = this.oNX;
      if (this.oNX.yr(32))
      {
        i = 7;
        am.a.a((n)localObject1, i, "", 0);
      }
    }
    for (;;)
    {
      localObject1 = this.oNW.oNT.owd;
      localObject2 = (LinearLayout)this.hdG;
      i.1.2.1 local1 = new i.1.2.1(this);
      ImageView localImageView = (ImageView)((LinearLayout)localObject2).findViewById(i.f.album_like_icon);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.9F, 1.2F, 0.9F, 1.2F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(400L);
      localScaleAnimation.setStartOffset(100L);
      localScaleAnimation.setRepeatCount(0);
      localImageView.clearAnimation();
      localImageView.startAnimation(localScaleAnimation);
      localScaleAnimation.setAnimationListener(new au.7((au)localObject1, (LinearLayout)localObject2, local1));
      return;
      i = 1;
      break;
      this.oNY.pmB = 0;
      this.oNX.field_likeFlag = this.oNY.pmB;
      h.a(this.oNX.bGk(), this.oNX);
      ((TextView)this.hdG.findViewById(i.f.album_like_tv)).setText(i.j.sns_like);
      am.a.NI(this.oNX.bGk());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.1.2
 * JD-Core Version:    0.7.0.1
 */