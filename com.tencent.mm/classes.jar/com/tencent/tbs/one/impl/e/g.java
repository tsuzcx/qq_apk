package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.c;
import com.tencent.tbs.one.impl.common.d;

public final class g
  implements TBSOneOnlineService
{
  j a;
  private i b;
  
  public g(i parami)
  {
    this.b = parami;
  }
  
  private void a(com.tencent.tbs.one.impl.a.j paramj)
  {
    AppMethodBeat.i(173965);
    this.a = null;
    paramj.a();
    AppMethodBeat.o(173965);
  }
  
  public final void cancelUpdate()
  {
    AppMethodBeat.i(173964);
    f.a("[%s] Canceling update", new Object[] { this.b.b });
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174075);
        g.a(g.this);
        AppMethodBeat.o(174075);
      }
    });
    AppMethodBeat.o(173964);
  }
  
  public final void update(final Bundle paramBundle, final TBSOneCallback<Void> paramTBSOneCallback)
  {
    AppMethodBeat.i(190667);
    String str = this.b.b;
    f.a("[%s] Updating", new Object[] { str });
    if (this.b.h())
    {
      f.a("[%s] No need to update because the last update has not applied", new Object[] { str });
      if (paramTBSOneCallback != null) {
        paramTBSOneCallback.onCompleted(null);
      }
      AppMethodBeat.o(190667);
      return;
    }
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174138);
        g.a(g.this, paramBundle, paramTBSOneCallback);
        AppMethodBeat.o(174138);
      }
    });
    AppMethodBeat.o(190667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.g
 * JD-Core Version:    0.7.0.1
 */