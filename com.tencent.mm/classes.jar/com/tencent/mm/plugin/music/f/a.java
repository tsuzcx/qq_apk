package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.ln.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;

public abstract class a
  implements com.tencent.mm.plugin.music.f.a.d
{
  protected long bbw = 0L;
  public boolean dqo;
  protected long duration = 0L;
  protected long gSP = 0L;
  private bc tUo;
  protected boolean tUp;
  protected d.a tUq;
  protected String tXK = "";
  protected com.tencent.mm.plugin.music.e.d tXL;
  protected com.tencent.mm.plugin.music.e.a tXM;
  protected long tXN = 0L;
  
  public final void B(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(azF()) });
    this.tXK = "waiting";
    ln localln = new ln();
    localln.dql.action = 11;
    localln.dql.dqf = paramf;
    localln.dql.state = "waiting";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
  }
  
  public final void C(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(azF()) });
    this.tXK = "canplay";
    ln localln = new ln();
    localln.dql.action = 9;
    localln.dql.dqf = paramf;
    localln.dql.state = "canplay";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
  }
  
  public final void D(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(azF()) });
    this.tXK = "play";
    ln localln = new ln();
    localln.dql.action = 0;
    localln.dql.dqf = paramf;
    localln.dql.state = "play";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
    if (this.tXM != null) {
      this.tXM.n(paramf);
    }
  }
  
  public final void E(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.tXK = "play";
    ln localln = new ln();
    localln.dql.action = 1;
    localln.dql.dqf = paramf;
    localln.dql.state = "play";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
    if (this.tXM != null) {
      this.tXM.o(paramf);
    }
  }
  
  public final void F(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.tXK = "pause";
    ln localln = new ln();
    localln.dql.action = 3;
    localln.dql.dqf = paramf;
    localln.dql.state = "pause";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
    if (this.tXM != null) {
      this.tXM.p(paramf);
    }
  }
  
  public final void G(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.tXK = "stop";
    ln localln = new ln();
    localln.dql.action = 2;
    localln.dql.dqf = paramf;
    localln.dql.state = "stop";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    ln.a locala = localln.dql;
    boolean bool = this.dqo;
    this.dqo = false;
    locala.dqo = bool;
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
    if (this.tXM != null) {
      this.tXM.q(paramf);
    }
  }
  
  public final void H(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.tXK = "seeked";
    ln localln = new ln();
    localln.dql.action = 8;
    localln.dql.dqf = paramf;
    localln.dql.state = "seeked";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
  }
  
  public final void I(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.tXK = "seeking";
    ln localln = new ln();
    localln.dql.action = 12;
    localln.dql.dqf = paramf;
    localln.dql.state = "seeking";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
  }
  
  public final void J(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.tXK = "ended";
    ln localln = new ln();
    localln.dql.action = 7;
    localln.dql.dqf = paramf;
    localln.dql.state = "ended";
    localln.dql.duration = getDuration();
    localln.dql.dqm = paramf.hnp;
    localln.dql.dqn = cTP();
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
    if (this.tXM != null) {
      this.tXM.r(paramf);
    }
  }
  
  public final void K(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public void a(f paramf, int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public final void a(d.a parama)
  {
    this.tUq = parama;
  }
  
  protected final void cTN()
  {
    if (this.tUo != null)
    {
      this.tUo.end();
      this.tUo.eGl();
      this.tUo = null;
    }
  }
  
  protected abstract void cUL();
  
  protected final void cVA()
  {
    if (this.tUo != null) {
      return;
    }
    if (b.checkSelfPermission(aj.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      ad.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.tUo = new bc();
    this.tUo.iG(aj.getContext());
    this.tUo.a(new bc.a()
    {
      public final void kq(int paramAnonymousInt)
      {
        AppMethodBeat.i(137297);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(137297);
          return;
          if (a.this.tUp)
          {
            a.this.tUp = false;
            a.this.resume();
            AppMethodBeat.o(137297);
            return;
            if (a.this.azF())
            {
              a.this.tUp = true;
              a.this.pause();
            }
          }
        }
      }
    });
  }
  
  protected final String cVB()
  {
    return this.tXK;
  }
  
  public final void d(f paramf, int paramInt)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.tXK = "error";
    ln localln = new ln();
    localln.dql.action = 4;
    localln.dql.dqf = paramf;
    localln.dql.state = "error";
    localln.dql.duration = getDuration();
    localln.dql.dqn = cTP();
    localln.dql.errCode = e.HZ(paramInt);
    localln.dql.errMsg = e.te(paramInt);
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
    if (this.tXM != null) {
      this.tXM.a(paramf, paramInt);
    }
  }
  
  public void h(f paramf)
  {
    cUL();
  }
  
  public void m(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */