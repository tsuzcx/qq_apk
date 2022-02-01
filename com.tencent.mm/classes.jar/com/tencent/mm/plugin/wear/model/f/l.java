package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.edx;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l
  extends c
{
  private int ikW;
  private String talker;
  
  public l(int paramInt, String paramString)
  {
    this.ikW = paramInt;
    this.talker = paramString;
  }
  
  public final String getName()
  {
    return "WearVoipControllerTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30134);
    switch (this.ikW)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30134);
      return;
      edx localedx = new edx();
      localedx.Hnp = this.talker;
      localedx.nEt = h.aFs(this.talker);
      try
      {
        a.eKz();
        r.a(this.ikW, localedx.toByteArray(), false);
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
        a.eKz();
        r.a(this.ikW, this.talker.getBytes("utf8"), false);
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