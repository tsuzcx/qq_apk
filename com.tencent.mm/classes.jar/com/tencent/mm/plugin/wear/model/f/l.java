package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.fkn;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l
  extends c
{
  private int lYT;
  private String talker;
  
  public l(int paramInt, String paramString)
  {
    this.lYT = paramInt;
    this.talker = paramString;
  }
  
  protected final void gOA()
  {
    AppMethodBeat.i(30134);
    switch (this.lYT)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30134);
      return;
      fkn localfkn = new fkn();
      localfkn.Ueg = this.talker;
      localfkn.rWI = h.bhV(this.talker);
      try
      {
        a.gOx();
        r.a(this.lYT, localfkn.toByteArray(), false);
        AppMethodBeat.o(30134);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(30134);
        return;
      }
      try
      {
        a.gOx();
        r.a(this.lYT, this.talker.getBytes("utf8"), false);
        AppMethodBeat.o(30134);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
  }
  
  public final String getName()
  {
    return "WearVoipControllerTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.l
 * JD-Core Version:    0.7.0.1
 */