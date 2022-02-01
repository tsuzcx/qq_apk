package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.fjy;
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
  
  protected final void gOA()
  {
    AppMethodBeat.i(30133);
    fjy localfjy = new fjy();
    switch (this.code)
    {
    }
    for (;;)
    {
      localfjy.Uht = this.msg;
      try
      {
        a.gOx();
        r.a(20016, localfjy.toByteArray(), true);
        AppMethodBeat.o(30133);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(30133);
      }
      localfjy.Upv = 0;
      continue;
      localfjy.Upv = 196610;
      continue;
      localfjy.Upv = 196613;
      continue;
      localfjy.Upv = 196614;
      continue;
      localfjy.Upv = 196615;
    }
  }
  
  public final String getName()
  {
    return "WearPushPayResponseTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.k
 * JD-Core Version:    0.7.0.1
 */