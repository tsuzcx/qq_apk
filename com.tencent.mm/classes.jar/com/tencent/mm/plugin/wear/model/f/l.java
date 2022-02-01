package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.dsg;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l
  extends c
{
  private int hrg;
  private String talker;
  
  public l(int paramInt, String paramString)
  {
    this.hrg = paramInt;
    this.talker = paramString;
  }
  
  public final String getName()
  {
    return "WearVoipControllerTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30134);
    switch (this.hrg)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30134);
      return;
      dsg localdsg = new dsg();
      localdsg.Egc = this.talker;
      localdsg.mBV = h.auR(this.talker);
      try
      {
        a.egZ();
        r.a(this.hrg, localdsg.toByteArray(), false);
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
        a.egZ();
        r.a(this.hrg, this.talker.getBytes("utf8"), false);
        AppMethodBeat.o(30134);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.l
 * JD-Core Version:    0.7.0.1
 */