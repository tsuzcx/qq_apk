package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory
{
  private Context a;
  private TbsWizard b;
  private DexLoader c;
  
  public TbsMediaFactory(Context paramContext)
  {
    AppMethodBeat.i(54529);
    this.a = null;
    this.b = null;
    this.c = null;
    this.a = paramContext.getApplicationContext();
    a();
    AppMethodBeat.o(54529);
  }
  
  private void a()
  {
    AppMethodBeat.i(54530);
    if (this.a == null)
    {
      AppMethodBeat.o(54530);
      return;
    }
    if (this.b == null)
    {
      g.a(true).a(this.a, false, false, null);
      this.b = g.a(true).a();
      if (this.b != null) {
        this.c = this.b.dexLoader();
      }
    }
    if ((this.b == null) || (this.c == null))
    {
      RuntimeException localRuntimeException = new RuntimeException("tbs core dex(s) load failure !!!");
      AppMethodBeat.o(54530);
      throw localRuntimeException;
    }
    AppMethodBeat.o(54530);
  }
  
  public TbsMediaPlayer createPlayer()
  {
    AppMethodBeat.i(54531);
    if ((this.b == null) || (this.c == null))
    {
      localObject = new RuntimeException("tbs core dex(s) did not loaded !!!");
      AppMethodBeat.o(54531);
      throw ((Throwable)localObject);
    }
    Object localObject = new TbsMediaPlayer(new r(this.c, this.a));
    AppMethodBeat.o(54531);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaFactory
 * JD-Core Version:    0.7.0.1
 */