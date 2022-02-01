package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import java.util.HashMap;
import java.util.LinkedList;

public final class k
{
  protected f<String, Bitmap> CcE;
  public LinkedList<String> CcG;
  private boolean CcI;
  protected HashMap<String, Long> WSO;
  private QueueWorkerThread lFb;
  private int mScrollState;
  
  public k()
  {
    AppMethodBeat.i(36076);
    this.CcE = new b(4, new f.b() {}, getClass());
    this.WSO = new HashMap();
    this.CcG = new LinkedList();
    this.lFb = new QueueWorkerThread(1, "chatting-image-gallery-preload-loader");
    this.CcI = false;
    this.mScrollState = 0;
    AppMethodBeat.o(36076);
  }
  
  public final void euK()
  {
    AppMethodBeat.i(36077);
    this.CcE.a(new f.a() {});
    AppMethodBeat.o(36077);
  }
  
  public static final class a
  {
    public static k WSQ;
    
    static
    {
      AppMethodBeat.i(36075);
      WSQ = new k();
      AppMethodBeat.o(36075);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */