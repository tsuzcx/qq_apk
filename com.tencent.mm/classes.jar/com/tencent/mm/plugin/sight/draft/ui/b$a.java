package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.ac.a.b;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.h;

final class b$a
  implements View.OnClickListener
{
  private b$a(b paramb) {}
  
  public final boolean bBw()
  {
    if (b.c(this.ogK) != null)
    {
      b.c(this.ogK).gSy.setVisibility(8);
      b.c(this.ogK).ogP.setCanPlay(false);
      b.c(this.ogK).ogP.aW(null, false);
      Bitmap localBitmap = b.e(this.ogK).r(b.c(this.ogK).ogR.field_fileName, k.nJ(b.c(this.ogK).ogR.field_fileName), true);
      b.c(this.ogK).ogP.setThumbBmp(localBitmap);
      b.c(this.ogK).kiB.setBackgroundResource(R.g.sight_draft_mask);
      h.p(b.c(this.ogK).ogO, 1.0F);
      b.a(this.ogK, null);
      return true;
    }
    return false;
  }
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof b.e)) {
      return;
    }
    paramView = (b.e)paramView.getTag();
    if (paramView.ogR == null)
    {
      y.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(this.ogK) });
      bBw();
      b.a(this.ogK, null);
      return;
    }
    Object localObject1;
    if (b.c(this.ogK) != paramView)
    {
      bBw();
      localObject1 = k.nI(paramView.ogR.field_fileName);
      paramView.ogP.setCanPlay(true);
      paramView.ogP.aW((String)localObject1, false);
      paramView.kiB.setBackgroundResource(R.g.sight_draft_mask_selected);
      localObject1 = paramView.ogO;
      if ((localObject1 != null) && (!d.gG(11))) {
        break label177;
      }
    }
    for (;;)
    {
      b.b(this.ogK, paramView);
      b.a(this.ogK, paramView);
      if (b.d(this.ogK) == null) {
        break;
      }
      b.d(this.ogK).bBu();
      return;
      label177:
      Object localObject2 = (Animator)((View)localObject1).getTag(a.g.property_anim);
      if (localObject2 != null) {
        ((Animator)localObject2).cancel();
      }
      localObject2 = (AnimatorSet)AnimatorInflater.loadAnimator(((View)localObject1).getContext(), a.b.fast_zoom_in_property_anim);
      ((AnimatorSet)localObject2).setTarget(localObject1);
      ((AnimatorSet)localObject2).start();
      ((View)localObject1).setTag(a.g.property_anim, localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b.a
 * JD-Core Version:    0.7.0.1
 */