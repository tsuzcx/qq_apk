package com.tencent.mm.ui.chatting.gallery;

import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class k$1
  implements e.a
{
  k$1(k paramk) {}
  
  public final void Es()
  {
    AppMethodBeat.i(32381);
    this.zNL.zNl.start();
    this.zNL.zNp.post(new k.1.2(this));
    AppMethodBeat.o(32381);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG() {}
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32380);
    this.zNL.zNl.stop();
    String str = (String)((View)this.zNL.zNl).getTag();
    b.G(Base64.encodeToString((d.cmw() + "[ImageGallery] on play sight error, what=" + paramInt1 + ", extra=" + paramInt2 + ", path=" + bo.bf(str, "")).getBytes(), 2), "FullScreenPlaySight");
    al.d(new k.1.1(this, str));
    this.zNL.zNj.put(str, Boolean.TRUE);
    AppMethodBeat.o(32380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.1
 * JD-Core Version:    0.7.0.1
 */