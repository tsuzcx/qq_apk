package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.dxi;
import java.io.IOException;

public final class k
  extends c
{
  private String bIO;
  private int code;
  
  public k(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.bIO = paramString;
  }
  
  public final String getName()
  {
    return "WearPushPayResponseTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30133);
    dxi localdxi = new dxi();
    switch (this.code)
    {
    }
    for (;;)
    {
      localdxi.FFr = this.bIO;
      try
      {
        a.ewt();
        r.a(20016, localdxi.toByteArray(), true);
        AppMethodBeat.o(30133);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(30133);
      }
      localdxi.FMB = 0;
      continue;
      localdxi.FMB = 196610;
      continue;
      localdxi.FMB = 196613;
      continue;
      localdxi.FMB = 196614;
      continue;
      localdxi.FMB = 196615;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.k
 * JD-Core Version:    0.7.0.1
 */