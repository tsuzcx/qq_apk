package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.eez;
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
    eez localeez = new eez();
    switch (this.code)
    {
    }
    for (;;)
    {
      localeez.HJs = this.msg;
      try
      {
        a.eOh();
        r.a(20016, localeez.toByteArray(), true);
        AppMethodBeat.o(30133);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(30133);
      }
      localeez.HQX = 0;
      continue;
      localeez.HQX = 196610;
      continue;
      localeez.HQX = 196613;
      continue;
      localeez.HQX = 196614;
      continue;
      localeez.HQX = 196615;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.k
 * JD-Core Version:    0.7.0.1
 */