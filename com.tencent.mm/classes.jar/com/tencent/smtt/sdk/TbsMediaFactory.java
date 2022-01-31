package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory
{
  private Context a;
  private bl b;
  private DexLoader c;
  
  public TbsMediaFactory(Context paramContext)
  {
    AppMethodBeat.i(64518);
    this.a = null;
    this.b = null;
    this.c = null;
    this.a = paramContext.getApplicationContext();
    a();
    AppMethodBeat.o(64518);
  }
  
  private void a()
  {
    AppMethodBeat.i(64519);
    if (this.a == null)
    {
      AppMethodBeat.o(64519);
      return;
    }
    if (this.b == null)
    {
      o.a(true).a(this.a, false, false, null);
      this.b = o.a(true).a();
      if (this.b != null) {
        this.c = this.b.b();
      }
    }
    if ((this.b == null) || (this.c == null))
    {
      RuntimeException localRuntimeException = new RuntimeException("tbs core dex(s) load failure !!!");
      AppMethodBeat.o(64519);
      throw localRuntimeException;
    }
    AppMethodBeat.o(64519);
  }
  
  public TbsMediaPlayer createPlayer()
  {
    AppMethodBeat.i(64520);
    if ((this.b == null) || (this.c == null))
    {
      localObject = new RuntimeException("tbs core dex(s) did not loaded !!!");
      AppMethodBeat.o(64520);
      throw ((Throwable)localObject);
    }
    Object localObject = new TbsMediaPlayer(new bb(this.c, this.a));
    AppMethodBeat.o(64520);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaFactory
 * JD-Core Version:    0.7.0.1
 */