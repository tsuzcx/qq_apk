package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R.a;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class SightPlayTextureView$b
  extends b
{
  private WeakReference<SightPlayTextureView> ofS;
  
  public SightPlayTextureView$b(SightPlayTextureView paramSightPlayTextureView)
  {
    super(1, paramSightPlayTextureView);
    this.ofS = new WeakReference(paramSightPlayTextureView);
  }
  
  public final void G(Bitmap paramBitmap) {}
  
  protected final int bAZ()
  {
    return R.a.sight_loop;
  }
  
  public final void cw(int paramInt1, int paramInt2)
  {
    if (this.ofS.get() == null)
    {
      y.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
      clear();
      return;
    }
    SightPlayTextureView.a((SightPlayTextureView)this.ofS.get(), paramInt1);
    SightPlayTextureView.b((SightPlayTextureView)this.ofS.get(), paramInt2);
    y.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(SightPlayTextureView.a((SightPlayTextureView)this.ofS.get())) });
    final ViewGroup.LayoutParams localLayoutParams = ((SightPlayTextureView)this.ofS.get()).getLayoutParams();
    if ((SightPlayTextureView.a((SightPlayTextureView)this.ofS.get())) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramInt1 >= paramInt2) {
        SightPlayTextureView.c((SightPlayTextureView)this.ofS.get(), a.fromDPToPix(((SightPlayTextureView)this.ofS.get()).getContext(), 150));
      }
    }
    else if (localLayoutParams.height != SightPlayTextureView.b((SightPlayTextureView)this.ofS.get()) * paramInt2 / paramInt1)
    {
      localLayoutParams.width = SightPlayTextureView.b((SightPlayTextureView)this.ofS.get());
      localLayoutParams.height = (SightPlayTextureView.b((SightPlayTextureView)this.ofS.get()) * paramInt2 / paramInt1);
      if ((SightPlayTextureView.a((SightPlayTextureView)this.ofS.get())) && (localLayoutParams.height < a.fromDPToPix(((SightPlayTextureView)this.ofS.get()).getContext(), 50))) {
        localLayoutParams.height = a.fromDPToPix(((SightPlayTextureView)this.ofS.get()).getContext(), 50);
      }
      y.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      if (!ai.isMainThread()) {
        break label432;
      }
      ((SightPlayTextureView)this.ofS.get()).setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.oeu = b.b(((SightPlayTextureView)this.ofS.get()).getContext(), SightPlayTextureView.c((SightPlayTextureView)this.ofS.get()), SightPlayTextureView.b((SightPlayTextureView)this.ofS.get()), paramInt1, paramInt2);
      return;
      SightPlayTextureView.c((SightPlayTextureView)this.ofS.get(), a.fromDPToPix(((SightPlayTextureView)this.ofS.get()).getContext(), 85));
      break;
      label432:
      ai.d(new Runnable()
      {
        public final void run()
        {
          ((SightPlayTextureView)SightPlayTextureView.b.a(SightPlayTextureView.b.this).get()).setLayoutParams(localLayoutParams);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.b
 * JD-Core Version:    0.7.0.1
 */