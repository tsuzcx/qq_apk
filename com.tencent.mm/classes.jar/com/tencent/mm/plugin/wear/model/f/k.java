package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.edi;
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
    edi localedi = new edi();
    switch (this.code)
    {
    }
    for (;;)
    {
      localedi.HpQ = this.msg;
      try
      {
        a.eKz();
        r.a(20016, localedi.toByteArray(), true);
        AppMethodBeat.o(30133);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(30133);
      }
      localedi.Hxm = 0;
      continue;
      localedi.Hxm = 196610;
      continue;
      localedi.Hxm = 196613;
      continue;
      localedi.Hxm = 196614;
      continue;
      localedi.Hxm = 196615;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.k
 * JD-Core Version:    0.7.0.1
 */