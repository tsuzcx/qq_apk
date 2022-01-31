package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cyc;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l
  extends c
{
  private int fOC;
  private String talker;
  
  public l(int paramInt, String paramString)
  {
    this.fOC = paramInt;
    this.talker = paramString;
  }
  
  public final String getName()
  {
    return "WearVoipControllerTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(26452);
    switch (this.fOC)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26452);
      return;
      cyc localcyc = new cyc();
      localcyc.xlH = this.talker;
      localcyc.jKG = h.agg(this.talker);
      try
      {
        a.cYy();
        r.a(this.fOC, localcyc.toByteArray(), false);
        AppMethodBeat.o(26452);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(26452);
        return;
      }
      try
      {
        a.cYy();
        r.a(this.fOC, this.talker.getBytes("utf8"), false);
        AppMethodBeat.o(26452);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.l
 * JD-Core Version:    0.7.0.1
 */