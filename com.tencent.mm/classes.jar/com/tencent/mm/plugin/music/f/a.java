package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.np.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements com.tencent.mm.plugin.music.f.a.d
{
  protected boolean FOD;
  protected d.a FOE;
  private PhoneStatusWatcher FOe;
  protected String FSP = "";
  protected com.tencent.mm.plugin.music.e.d FSQ;
  protected com.tencent.mm.plugin.music.e.a FSR;
  protected long FSS = 0L;
  protected LinkedList<d.a> FST = new LinkedList();
  protected long aWa = 0L;
  protected long duration = 0L;
  public boolean fMf;
  protected long lzJ = 0L;
  
  public final void G(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(bnx()) });
    this.FSP = "waiting";
    np localnp = new np();
    localnp.fMc.action = 11;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "waiting";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
  }
  
  public final void H(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(bnx()) });
    this.FSP = "canplay";
    np localnp = new np();
    localnp.fMc.action = 9;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "canplay";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
  }
  
  public final void I(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(bnx()) });
    this.FSP = "play";
    np localnp = new np();
    localnp.fMc.action = 0;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "play";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
    if (this.FSR != null) {
      this.FSR.n(paramf);
    }
  }
  
  public final void J(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.FSP = "play";
    np localnp = new np();
    localnp.fMc.action = 1;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "play";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
    if (this.FSR != null) {
      this.FSR.o(paramf);
    }
  }
  
  public final void K(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.FSP = "pause";
    np localnp = new np();
    localnp.fMc.action = 3;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "pause";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
    if (this.FSR != null) {
      this.FSR.p(paramf);
    }
  }
  
  public final void L(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.FSP = "stop";
    np localnp = new np();
    localnp.fMc.action = 2;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "stop";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    np.a locala = localnp.fMc;
    boolean bool = this.fMf;
    this.fMf = false;
    locala.fMf = bool;
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
    if (this.FSR != null) {
      this.FSR.q(paramf);
    }
  }
  
  public final void M(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.FSP = "seeked";
    np localnp = new np();
    localnp.fMc.action = 8;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "seeked";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
  }
  
  public final void N(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.FSP = "seeking";
    np localnp = new np();
    localnp.fMc.action = 12;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "seeking";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
  }
  
  public final void O(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.FSP = "ended";
    np localnp = new np();
    localnp.fMc.action = 7;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "ended";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMd = paramf.lVt;
    localnp.fMc.fMe = fdf();
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
    if (this.FSR != null) {
      this.FSR.r(paramf);
    }
  }
  
  public final void P(f paramf)
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
    while (this.FST.contains(parama)) {
      return;
    }
    this.FST.add(parama);
  }
  
  public final void b(d.a parama)
  {
    if (parama == null) {}
    while (!this.FST.contains(parama)) {
      return;
    }
    this.FST.remove(parama);
  }
  
  public final void d(f paramf, int paramInt)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.FSP = "error";
    np localnp = new np();
    localnp.fMc.action = 4;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "error";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = fdf();
    localnp.fMc.errCode = e.Zx(paramInt);
    localnp.fMc.errMsg = e.BW(paramInt);
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
    if (this.FSR != null) {
      this.FSR.a(paramf, paramInt);
    }
  }
  
  protected final void fK(int paramInt1, int paramInt2)
  {
    if (this.FOE != null) {
      this.FOE.fK(paramInt1, paramInt2);
    }
    Iterator localIterator = this.FST.iterator();
    while (localIterator.hasNext()) {
      ((d.a)localIterator.next()).fK(paramInt1, paramInt2);
    }
  }
  
  protected abstract void fdW();
  
  protected final void fdd()
  {
    if (this.FOe != null)
    {
      this.FOe.end();
      this.FOe.clearPhoneCallListener();
      this.FOe = null;
    }
  }
  
  protected final void ffj()
  {
    if (this.FOe != null) {
      return;
    }
    if (androidx.core.content.a.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      Log.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.FOe = new PhoneStatusWatcher();
    this.FOe.begin(MMApplicationContext.getContext());
    this.FOe.addPhoneCallListener(new PhoneStatusWatcher.PhoneCallListener()
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
          if (a.this.FOD)
          {
            a.this.FOD = false;
            a.this.resume();
            AppMethodBeat.o(137297);
            return;
            if (a.this.bnx())
            {
              a.this.FOD = true;
              a.this.pause();
            }
          }
        }
      }
    });
  }
  
  protected final String ffk()
  {
    return this.FSP;
  }
  
  public void h(f paramf)
  {
    fdW();
  }
  
  public void m(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */