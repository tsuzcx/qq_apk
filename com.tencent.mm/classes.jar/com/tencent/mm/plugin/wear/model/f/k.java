package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.drr;
import java.io.IOException;

public final class k
  extends c
{
  private String bLg;
  private int code;
  
  public k(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.bLg = paramString;
  }
  
  public final String getName()
  {
    return "WearPushPayResponseTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30133);
    drr localdrr = new drr();
    switch (this.code)
    {
    }
    for (;;)
    {
      localdrr.Eit = this.bLg;
      try
      {
        a.egZ();
        r.a(20016, localdrr.toByteArray(), true);
        AppMethodBeat.o(30133);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(30133);
      }
      localdrr.Epz = 0;
      continue;
      localdrr.Epz = 196610;
      continue;
      localdrr.Epz = 196613;
      continue;
      localdrr.Epz = 196614;
      continue;
      localdrr.Epz = 196615;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.k
 * JD-Core Version:    0.7.0.1
 */