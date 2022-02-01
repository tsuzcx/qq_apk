package com.tencent.mm.ui.n.a;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.n;
import com.tencent.mm.ui.n.a.a.b;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public class e
{
  g XJI;
  public d XJJ;
  WeakReference<com.tencent.mm.ui.chatting.e.a> XJK;
  bh XJL;
  final ConcurrentLinkedDeque<a> XJM;
  final n XJN;
  public final String mAppId;
  public boolean mIsRunning;
  private volatile r ntI;
  
  public e(g paramg)
  {
    AppMethodBeat.i(283650);
    this.XJJ = null;
    this.XJK = null;
    this.mIsRunning = false;
    this.XJL = null;
    this.ntI = null;
    this.XJM = new ConcurrentLinkedDeque();
    this.XJN = new n()
    {
      public final void hGU() {}
      
      public final void hGV() {}
      
      public final void hGW() {}
      
      public final void hGX()
      {
        AppMethodBeat.i(199934);
        Log.i("MicroMsg.MagicEmojiRuntime", "hy: chatting resume");
        AppMethodBeat.o(199934);
      }
      
      public final void hGY()
      {
        AppMethodBeat.i(199937);
        Log.i("MicroMsg.MagicEmojiRuntime", "hy: chatting pause");
        e.this.UJ();
        AppMethodBeat.o(199937);
      }
      
      public final void hGZ() {}
      
      public final void hHa() {}
    };
    Log.i("MicroMsg.MagicEmojiRuntime", "hy: establish magic emoji runtime, %s", new Object[] { paramg.getAppId() });
    this.mAppId = paramg.getAppId();
    this.XJI = paramg;
    AppMethodBeat.o(283650);
  }
  
  private void UI()
  {
    AppMethodBeat.i(283655);
    try
    {
      ConcurrentLinkedDeque localConcurrentLinkedDeque = new ConcurrentLinkedDeque(this.XJM);
      while (!localConcurrentLinkedDeque.isEmpty()) {
        Objects.requireNonNull(localConcurrentLinkedDeque.poll());
      }
    }
    finally
    {
      AppMethodBeat.o(283655);
    }
    a(this.XJI, true);
    a(this.XJJ, true);
    AppMethodBeat.o(283655);
  }
  
  static void a(a parama)
  {
    AppMethodBeat.i(283657);
    if (parama != null) {
      parama.notifyDestroy();
    }
    AppMethodBeat.o(283657);
  }
  
  static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(283659);
    if (parama != null) {
      parama.GW(paramBoolean);
    }
    AppMethodBeat.o(283659);
  }
  
  final void UJ()
  {
    AppMethodBeat.i(283660);
    try
    {
      ConcurrentLinkedDeque localConcurrentLinkedDeque = new ConcurrentLinkedDeque(this.XJM);
      while (!localConcurrentLinkedDeque.isEmpty()) {
        ((a)Objects.requireNonNull(localConcurrentLinkedDeque.poll())).onPause();
      }
    }
    finally
    {
      AppMethodBeat.o(283660);
    }
    a(this.XJJ, false);
    a(this.XJI, false);
    AppMethodBeat.o(283660);
  }
  
  public final void a(a parama)
  {
    try
    {
      AppMethodBeat.i(283658);
      this.XJM.add(parama);
      AppMethodBeat.o(283658);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(283651);
    Log.d("MicroMsg.MagicEmojiRuntime", "hy: notify message come %s", new Object[] { paramc.toString() });
    com.tencent.mm.ui.chatting.e.a locala = (com.tencent.mm.ui.chatting.e.a)paramc.XJw.get();
    FrameLayout localFrameLayout = (FrameLayout)paramc.XJx.get();
    if ((locala == null) || (localFrameLayout == null) || (!locala.dgo))
    {
      Log.w("MicroMsg.MagicEmojiRuntime", "hy: chatting or holder lost. ignore");
      com.tencent.mm.ui.n.b.a.bAw("chatting or holder lost. ignore the msg");
      AppMethodBeat.o(283651);
      return;
    }
    if (this.XJJ == null)
    {
      Log.e("MicroMsg.MagicEmojiRuntime", "hy: page not prepared!!");
      AppMethodBeat.o(283651);
      return;
    }
    if ((this.XJK == null) || (locala != this.XJK.get()))
    {
      Log.i("MicroMsg.MagicEmojiRuntime", "hy: last chatting released or changed to new chatting");
      if ((this.XJK != null) && (this.XJK.get() != null)) {
        ((j)((com.tencent.mm.ui.chatting.e.a)this.XJK.get()).bC(j.class)).b(this.XJN);
      }
      ((j)locala.bC(j.class)).a(this.XJN);
      this.XJK = new WeakReference(locala);
    }
    UI();
    this.XJJ.i(localFrameLayout);
    this.XJJ.hXm();
    this.XJI.b(paramc);
    AppMethodBeat.o(283651);
  }
  
  public String bnR()
  {
    return this.XJL.field_pkgPath;
  }
  
  public final r getFileSystem()
  {
    AppMethodBeat.i(283652);
    if (this.ntI == null) {}
    try
    {
      if (this.ntI == null) {
        this.ntI = new b(this);
      }
      r localr = this.ntI;
      AppMethodBeat.o(283652);
      return localr;
    }
    finally
    {
      AppMethodBeat.o(283652);
    }
  }
  
  public String hXo()
  {
    return this.XJL.field_versionMd5;
  }
  
  public final void hXp()
  {
    try
    {
      AppMethodBeat.i(283661);
      if (this.ntI != null) {
        this.ntI.release();
      }
      AppMethodBeat.o(283661);
      return;
    }
    finally {}
  }
  
  public final com.tencent.mm.ui.chatting.e.a hXq()
  {
    AppMethodBeat.i(283662);
    if (this.XJK != null)
    {
      com.tencent.mm.ui.chatting.e.a locala = (com.tencent.mm.ui.chatting.e.a)this.XJK.get();
      AppMethodBeat.o(283662);
      return locala;
    }
    AppMethodBeat.o(283662);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void onDestroy();
    
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.e
 * JD-Core Version:    0.7.0.1
 */