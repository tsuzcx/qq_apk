package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.ggm;
import java.io.IOException;

public final class k
  extends c
{
  private int code;
  private String msg;
  
  public k(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.msg = paramString;
  }
  
  public final String getName()
  {
    return "WearPushPayResponseTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30133);
    ggm localggm = new ggm();
    switch (this.code)
    {
    }
    for (;;)
    {
      localggm.acbp = this.msg;
      try
      {
        a.inM();
        r.a(20016, localggm.toByteArray(), true);
        AppMethodBeat.o(30133);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(30133);
      }
      localggm.abIu = 0;
      continue;
      localggm.abIu = 196610;
      continue;
      localggm.abIu = 196613;
      continue;
      localggm.abIu = 196614;
      continue;
      localggm.abIu = 196615;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.k
 * JD-Core Version:    0.7.0.1
 */