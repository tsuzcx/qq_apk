package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;
import java.util.LinkedList;

public final class g
{
  protected HashMap<String, Long> GBV;
  private be gXM;
  private int mScrollState;
  protected f<String, Bitmap> rJL;
  public LinkedList<String> rJN;
  private boolean rJP;
  
  public g()
  {
    AppMethodBeat.i(36076);
    this.rJL = new b(4, new f.b() {}, getClass());
    this.GBV = new HashMap();
    this.rJN = new LinkedList();
    this.gXM = new be(1, "chatting-image-gallery-preload-loader");
    this.rJP = false;
    this.mScrollState = 0;
    AppMethodBeat.o(36076);
  }
  
  public final void cAE()
  {
    AppMethodBeat.i(36077);
    this.rJL.a(new f.a() {});
    AppMethodBeat.o(36077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.g
 * JD-Core Version:    0.7.0.1
 */