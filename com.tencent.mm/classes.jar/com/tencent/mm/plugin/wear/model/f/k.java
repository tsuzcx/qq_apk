package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.cxn;
import java.io.IOException;

public final class k
  extends c
{
  private String bjm;
  private int code;
  
  public k(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.bjm = paramString;
  }
  
  public final String getName()
  {
    return "WearPushPayResponseTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(26451);
    cxn localcxn = new cxn();
    switch (this.code)
    {
    }
    for (;;)
    {
      localcxn.xKK = this.bjm;
      try
      {
        a.cYy();
        r.a(20016, localcxn.toByteArray(), true);
        AppMethodBeat.o(26451);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(26451);
      }
      localcxn.xRf = 0;
      continue;
      localcxn.xRf = 196610;
      continue;
      localcxn.xRf = 196613;
      continue;
      localcxn.xRf = 196614;
      continue;
      localcxn.xRf = 196615;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.k
 * JD-Core Version:    0.7.0.1
 */