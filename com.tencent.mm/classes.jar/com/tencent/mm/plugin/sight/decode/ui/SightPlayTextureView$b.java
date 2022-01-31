package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;

final class SightPlayTextureView$b
  extends b
{
  private WeakReference<SightPlayTextureView> qUh;
  
  public SightPlayTextureView$b(SightPlayTextureView paramSightPlayTextureView)
  {
    super(1, paramSightPlayTextureView);
    AppMethodBeat.i(24978);
    this.qUh = new WeakReference(paramSightPlayTextureView);
    AppMethodBeat.o(24978);
  }
  
  public final void S(Bitmap paramBitmap) {}
  
  public final int cmz()
  {
    return 2131034258;
  }
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24979);
    if (this.qUh.get() == null)
    {
      ab.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
      clear();
      AppMethodBeat.o(24979);
      return;
    }
    SightPlayTextureView.a((SightPlayTextureView)this.qUh.get(), paramInt1);
    SightPlayTextureView.b((SightPlayTextureView)this.qUh.get(), paramInt2);
    ab.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(SightPlayTextureView.a((SightPlayTextureView)this.qUh.get())) });
    final ViewGroup.LayoutParams localLayoutParams = ((SightPlayTextureView)this.qUh.get()).getLayoutParams();
    if ((SightPlayTextureView.a((SightPlayTextureView)this.qUh.get())) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramInt1 >= paramInt2) {
        SightPlayTextureView.c((SightPlayTextureView)this.qUh.get(), a.fromDPToPix(((SightPlayTextureView)this.qUh.get()).getContext(), 150));
      }
    }
    else if (localLayoutParams.height != SightPlayTextureView.b((SightPlayTextureView)this.qUh.get()) * paramInt2 / paramInt1)
    {
      localLayoutParams.width = SightPlayTextureView.b((SightPlayTextureView)this.qUh.get());
      localLayoutParams.height = (SightPlayTextureView.b((SightPlayTextureView)this.qUh.get()) * paramInt2 / paramInt1);
      if ((SightPlayTextureView.a((SightPlayTextureView)this.qUh.get())) && (localLayoutParams.height < a.fromDPToPix(((SightPlayTextureView)this.qUh.get()).getContext(), 50))) {
        localLayoutParams.height = a.fromDPToPix(((SightPlayTextureView)this.qUh.get()).getContext(), 50);
      }
      ab.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      if (!al.isMainThread()) {
        break label450;
      }
      ((SightPlayTextureView)this.qUh.get()).setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.qSJ = b.b(((SightPlayTextureView)this.qUh.get()).getContext(), SightPlayTextureView.c((SightPlayTextureView)this.qUh.get()), SightPlayTextureView.b((SightPlayTextureView)this.qUh.get()), paramInt1, paramInt2);
      AppMethodBeat.o(24979);
      return;
      SightPlayTextureView.c((SightPlayTextureView)this.qUh.get(), a.fromDPToPix(((SightPlayTextureView)this.qUh.get()).getContext(), 85));
      break;
      label450:
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24977);
          ((SightPlayTextureView)SightPlayTextureView.b.a(SightPlayTextureView.b.this).get()).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(24977);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.b
 * JD-Core Version:    0.7.0.1
 */