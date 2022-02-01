package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.ox.a;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.plugin.music.e.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements com.tencent.mm.plugin.music.e.a.d
{
  private PhoneStatusWatcher LJa;
  protected boolean LJy;
  protected d.a LJz;
  protected String LNL = "";
  protected com.tencent.mm.plugin.music.logic.d LNM;
  protected com.tencent.mm.plugin.music.logic.a LNN;
  protected long LNO = 0L;
  protected LinkedList<d.a> LNP = new LinkedList();
  protected long cPW = 0L;
  protected long duration = 0L;
  public boolean hRP;
  protected long ork = 0L;
  
  public final void L(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(bLk()) });
    this.LNL = "waiting";
    ox localox = new ox();
    localox.hRN.action = 11;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "waiting";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.n(paramf);
    }
  }
  
  public final void M(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(bLk()) });
    this.LNL = "canplay";
    ox localox = new ox();
    localox.hRN.action = 9;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "canplay";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.o(paramf);
    }
  }
  
  public final void N(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(bLk()) });
    this.LNL = "play";
    ox localox = new ox();
    localox.hRN.action = 0;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "play";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.p(paramf);
    }
  }
  
  public final void O(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.LNL = "play";
    ox localox = new ox();
    localox.hRN.action = 1;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "play";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.q(paramf);
    }
  }
  
  public final void P(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.LNL = "pause";
    ox localox = new ox();
    localox.hRN.action = 3;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "pause";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.r(paramf);
    }
  }
  
  public final void Q(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.LNL = "stop";
    ox localox = new ox();
    localox.hRN.action = 2;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "stop";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    ox.a locala = localox.hRN;
    boolean bool = this.hRP;
    this.hRP = false;
    locala.hRP = bool;
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.s(paramf);
    }
  }
  
  public final void R(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.LNL = "seeked";
    ox localox = new ox();
    localox.hRN.action = 8;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "seeked";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.u(paramf);
    }
  }
  
  public final void S(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.LNL = "seeking";
    ox localox = new ox();
    localox.hRN.action = 12;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "seeking";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.v(paramf);
    }
  }
  
  public final void T(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.LNL = "ended";
    ox localox = new ox();
    localox.hRN.action = 7;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "ended";
    localox.hRN.duration = getDuration();
    localox.hRN.musicId = paramf.oOv;
    localox.hRN.hRO = gmi();
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.t(paramf);
    }
  }
  
  public final void U(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public void a(f paramf, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public final void a(d.a parama)
  {
    if (parama == null) {}
    while (this.LNP.contains(parama)) {
      return;
    }
    this.LNP.add(parama);
  }
  
  public final void b(d.a parama)
  {
    if (parama == null) {}
    while (!this.LNP.contains(parama)) {
      return;
    }
    this.LNP.remove(parama);
  }
  
  public final void d(f paramf, int paramInt)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.LNL = "error";
    ox localox = new ox();
    localox.hRN.action = 4;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "error";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = gmi();
    localox.hRN.errCode = e.adK(paramInt);
    localox.hRN.errMsg = e.Cl(paramInt);
    localox.asyncPublish(Looper.getMainLooper());
    if (this.LNN != null) {
      this.LNN.a(paramf, paramInt);
    }
  }
  
  protected abstract void gmZ();
  
  protected final void gmg()
  {
    if (this.LJa != null)
    {
      this.LJa.end();
      this.LJa.clearPhoneCallListener();
      this.LJa = null;
    }
  }
  
  protected final void gos()
  {
    if (this.LJa != null) {
      return;
    }
    if (androidx.core.content.a.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      Log.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.LJa = new PhoneStatusWatcher();
    this.LJa.begin(MMApplicationContext.getContext());
    this.LJa.addPhoneCallListener(new PhoneStatusWatcher.PhoneCallListener()
    {
      public final void onPhoneCall(int paramAnonymousInt)
      {
        AppMethodBeat.i(137297);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(137297);
          return;
          if (a.this.LJy)
          {
            a.this.LJy = false;
            a.this.resume();
            AppMethodBeat.o(137297);
            return;
            if (a.this.bLk())
            {
              a.this.LJy = true;
              a.this.pause();
            }
          }
        }
      }
    });
  }
  
  protected final String got()
  {
    return this.LNL;
  }
  
  public void h(f paramf)
  {
    gmZ();
  }
  
  public void m(f paramf) {}
  
  protected final void onProgress(int paramInt1, int paramInt2)
  {
    if (this.LJz != null) {
      this.LJz.onProgress(paramInt1, paramInt2);
    }
    Iterator localIterator = this.LNP.iterator();
    while (localIterator.hasNext()) {
      ((d.a)localIterator.next()).onProgress(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.a
 * JD-Core Version:    0.7.0.1
 */