package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.HashMap;
import java.util.LinkedList;

public final class g
{
  protected HashMap<String, Long> Kms;
  private bf hTx;
  private int mScrollState;
  protected f<String, Bitmap> tYV;
  public LinkedList<String> tYX;
  private boolean tYZ;
  
  public g()
  {
    AppMethodBeat.i(36076);
    this.tYV = new b(4, new f.b() {}, getClass());
    this.Kms = new HashMap();
    this.tYX = new LinkedList();
    this.hTx = new bf(1, "chatting-image-gallery-preload-loader");
    this.tYZ = false;
    this.mScrollState = 0;
    AppMethodBeat.o(36076);
  }
  
  public final void cYL()
  {
    AppMethodBeat.i(36077);
    this.tYV.a(new f.a() {});
    AppMethodBeat.o(36077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.g
 * JD-Core Version:    0.7.0.1
 */