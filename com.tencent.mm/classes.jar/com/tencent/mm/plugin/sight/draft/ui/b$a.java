package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a
  implements View.OnClickListener
{
  private b$a(b paramb) {}
  
  public final boolean cmW()
  {
    AppMethodBeat.i(24998);
    if (b.c(this.qUZ) != null)
    {
      b.c(this.qUZ).ivt.setVisibility(8);
      b.c(this.qUZ).qVe.setCanPlay(false);
      b.c(this.qUZ).qVe.bl(null, false);
      Bitmap localBitmap = b.e(this.qUZ).x(b.c(this.qUZ).qVg.field_fileName, k.uW(b.c(this.qUZ).qVg.field_fileName), true);
      b.c(this.qUZ).qVe.setThumbBmp(localBitmap);
      b.c(this.qUZ).mDg.setBackgroundResource(2130840324);
      com.tencent.mm.ui.tools.j.s(b.c(this.qUZ).qVd, 1.0F);
      b.a(this.qUZ, null);
      AppMethodBeat.o(24998);
      return true;
    }
    AppMethodBeat.o(24998);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24997);
    if (!(paramView.getTag() instanceof b.e))
    {
      AppMethodBeat.o(24997);
      return;
    }
    paramView = (b.e)paramView.getTag();
    if (paramView.qVg == null)
    {
      ab.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(this.qUZ) });
      cmW();
      b.a(this.qUZ, null);
      AppMethodBeat.o(24997);
      return;
    }
    Object localObject1;
    if (b.c(this.qUZ) != paramView)
    {
      cmW();
      localObject1 = k.uV(paramView.qVg.field_fileName);
      paramView.qVe.setCanPlay(true);
      paramView.qVe.bl((String)localObject1, false);
      paramView.mDg.setBackgroundResource(2130840325);
      localObject1 = paramView.qVd;
      if ((localObject1 != null) && (!d.fw(11))) {
        break label200;
      }
    }
    for (;;)
    {
      b.b(this.qUZ, paramView);
      b.a(this.qUZ, paramView);
      if (b.d(this.qUZ) != null) {
        b.d(this.qUZ).cmU();
      }
      AppMethodBeat.o(24997);
      return;
      label200:
      Object localObject2 = (Animator)((View)localObject1).getTag(2131820653);
      if (localObject2 != null) {
        ((Animator)localObject2).cancel();
      }
      localObject2 = (AnimatorSet)AnimatorInflater.loadAnimator(((View)localObject1).getContext(), 2131099652);
      ((AnimatorSet)localObject2).setTarget(localObject1);
      ((AnimatorSet)localObject2).start();
      ((View)localObject1).setTag(2131820653, localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b.a
 * JD-Core Version:    0.7.0.1
 */