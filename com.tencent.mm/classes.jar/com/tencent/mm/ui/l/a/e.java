package com.tencent.mm.ui.l.a;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.l.a.a.b;
import com.tencent.mm.ui.m;
import java.lang.ref.WeakReference;

public class e
{
  g QlU;
  public d QlV;
  private WeakReference<com.tencent.mm.ui.chatting.e.a> QlW;
  bd QlX;
  private m QlY;
  volatile q kAz;
  public final String mAppId;
  boolean mIsRunning;
  
  public e(g paramg)
  {
    AppMethodBeat.i(234382);
    this.QlV = null;
    this.QlW = null;
    this.mIsRunning = false;
    this.QlX = null;
    this.kAz = null;
    this.QlY = new m()
    {
      public final void cFx()
      {
        AppMethodBeat.i(234380);
        Log.i("MicroMsg.MagicEmojiRuntime", "hy: chatting resume");
        AppMethodBeat.o(234380);
      }
      
      public final void cFy()
      {
        AppMethodBeat.i(234381);
        Log.i("MicroMsg.MagicEmojiRuntime", "hy: chatting pause");
        e locale = e.this;
        e.a(locale.QlU, false);
        e.a(locale.QlV, false);
        ((com.tencent.mm.plugin.emoji.magicemoji.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFy();
        AppMethodBeat.o(234381);
      }
      
      public final void gIk() {}
      
      public final void gIl() {}
      
      public final void gIm() {}
      
      public final void gIn() {}
      
      public final void gIo() {}
    };
    Log.i("MicroMsg.MagicEmojiRuntime", "hy: establish magic emoji runtime, %s", new Object[] { paramg.getAppId() });
    this.mAppId = paramg.getAppId();
    this.QlU = paramg;
    AppMethodBeat.o(234382);
  }
  
  private void CC(boolean paramBoolean)
  {
    AppMethodBeat.i(234385);
    a(this.QlU, true);
    a(this.QlV, true);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.emoji.magicemoji.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFx();
    }
    AppMethodBeat.o(234385);
  }
  
  static void a(a parama)
  {
    AppMethodBeat.i(234386);
    if (parama != null) {
      parama.notifyDestroy();
    }
    AppMethodBeat.o(234386);
  }
  
  static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(234387);
    if (parama != null) {
      parama.CB(paramBoolean);
    }
    AppMethodBeat.o(234387);
  }
  
  public final void a(c paramc)
  {
    boolean bool3 = false;
    AppMethodBeat.i(234383);
    Log.d("MicroMsg.MagicEmojiRuntime", "hy: notify message come %s", new Object[] { paramc.toString() });
    com.tencent.mm.ui.chatting.e.a locala = (com.tencent.mm.ui.chatting.e.a)paramc.QlK.get();
    FrameLayout localFrameLayout = (FrameLayout)paramc.QlL.get();
    if ((locala == null) || (localFrameLayout == null) || (!locala.cQp))
    {
      Log.w("MicroMsg.MagicEmojiRuntime", "hy: chatting or holder lost. ignore");
      com.tencent.mm.ui.l.b.a.bnK("chatting or holder lost. ignore the msg");
      AppMethodBeat.o(234383);
      return;
    }
    if (this.QlV == null)
    {
      Log.e("MicroMsg.MagicEmojiRuntime", "hy: page not prepared!!");
      AppMethodBeat.o(234383);
      return;
    }
    int i;
    boolean bool1;
    if ((this.QlW == null) || (this.QlW.get() == null))
    {
      i = 1;
      if ((this.QlW != null) && (locala == this.QlW.get())) {
        break label360;
      }
      Log.i("MicroMsg.MagicEmojiRuntime", "hy: last chatting released or changed to new chatting");
      if ((this.QlW == null) || (this.QlW.get() == null)) {
        break label355;
      }
      ((j)((com.tencent.mm.ui.chatting.e.a)this.QlW.get()).bh(j.class)).b(this.QlY);
      bool1 = true;
      label197:
      ((j)locala.bh(j.class)).a(this.QlY);
      this.QlW = new WeakReference(locala);
    }
    for (;;)
    {
      if ((this.QlV.gWC() != null) && (this.QlV.gWC() != localFrameLayout)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.d("MicroMsg.MagicEmojiRuntime", "hy: on message come, is holder change %b, is context change %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        this.QlV.e(localFrameLayout);
        if (bool1) {
          this.QlV.aG(localFrameLayout.getContext());
        }
        this.QlV.gWD();
        this.QlU.a(paramc);
        if (!bool1)
        {
          bool1 = bool3;
          if (i == 0) {}
        }
        else
        {
          bool1 = true;
        }
        CC(bool1);
        AppMethodBeat.o(234383);
        return;
        i = 0;
        break;
      }
      label355:
      bool1 = false;
      break label197;
      label360:
      bool1 = false;
    }
  }
  
  public String bes()
  {
    return this.QlX.field_pkgPath;
  }
  
  public String gWF()
  {
    return this.QlX.field_versionMd5;
  }
  
  public final com.tencent.mm.ui.chatting.e.a gWG()
  {
    AppMethodBeat.i(234388);
    if (this.QlW != null)
    {
      com.tencent.mm.ui.chatting.e.a locala = (com.tencent.mm.ui.chatting.e.a)this.QlW.get();
      AppMethodBeat.o(234388);
      return locala;
    }
    AppMethodBeat.o(234388);
    return null;
  }
  
  public final q getFileSystem()
  {
    AppMethodBeat.i(234384);
    if (this.kAz == null) {}
    try
    {
      if (this.kAz == null) {
        this.kAz = new b(this);
      }
      q localq = this.kAz;
      AppMethodBeat.o(234384);
      return localq;
    }
    finally
    {
      AppMethodBeat.o(234384);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.e
 * JD-Core Version:    0.7.0.1
 */