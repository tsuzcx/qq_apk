package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.az;
import java.util.HashMap;
import java.util.LinkedList;

public final class g
{
  private az fwL;
  private int mScrollState;
  protected f<String, Bitmap> nfR;
  public LinkedList<String> nfT;
  private boolean nfV;
  protected HashMap<String, Long> zLC;
  
  public g()
  {
    AppMethodBeat.i(32163);
    this.nfR = new b(4, new g.1(this), getClass());
    this.zLC = new HashMap();
    this.nfT = new LinkedList();
    this.fwL = new az(1, "chatting-image-gallery-preload-loader");
    this.nfV = false;
    this.mScrollState = 0;
    AppMethodBeat.o(32163);
  }
  
  public final void bEy()
  {
    AppMethodBeat.i(32164);
    this.nfR.a(new g.2(this));
    AppMethodBeat.o(32164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.g
 * JD-Core Version:    0.7.0.1
 */