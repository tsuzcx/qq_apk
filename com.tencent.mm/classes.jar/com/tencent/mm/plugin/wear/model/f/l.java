package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ezw;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l
  extends c
{
  private int jiX;
  private String talker;
  
  public l(int paramInt, String paramString)
  {
    this.jiX = paramInt;
    this.talker = paramString;
  }
  
  public final String getName()
  {
    return "WearVoipControllerTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30134);
    switch (this.jiX)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30134);
      return;
      ezw localezw = new ezw();
      localezw.MRZ = this.talker;
      localezw.oUJ = h.aWo(this.talker);
      try
      {
        a.fVQ();
        r.a(this.jiX, localezw.toByteArray(), false);
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
        a.fVQ();
        r.a(this.jiX, this.talker.getBytes("utf8"), false);
        AppMethodBeat.o(30134);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.l
 * JD-Core Version:    0.7.0.1
 */