package com.tencent.mm.ui.chatting.gallery;

import android.util.Base64;
import android.view.View;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

final class k$1
  implements f.a
{
  k$1(k paramk) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA() {}
  
  public final void onError(int paramInt1, int paramInt2)
  {
    this.vxz.vxb.stop();
    String str = (String)((View)this.vxz.vxb).getTag();
    b.t(Base64.encodeToString((d.bAW() + "[ImageGallery] on play sight error, what=" + paramInt1 + ", extra=" + paramInt2 + ", path=" + bk.aM(str, "")).getBytes(), 2), "FullScreenPlaySight");
    ai.d(new k.1.1(this, str));
    this.vxz.vwZ.put(str, Boolean.valueOf(true));
  }
  
  public final void ug()
  {
    this.vxz.vxb.start();
    this.vxz.vxf.post(new k.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.1
 * JD-Core Version:    0.7.0.1
 */