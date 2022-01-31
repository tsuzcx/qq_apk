package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.protocal.protobuf.crd;

public final class d
{
  public static crd bm(int paramInt, String paramString)
  {
    AppMethodBeat.i(25590);
    crd localcrd = new crd();
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      localcrd.wru = 0;
      localcrd.wrv = 0;
      localcrd.wrs = 0;
      localcrd.wrt = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(25590);
      return localcrd;
      localcrd.wru = 8000;
      localcrd.wrv = 16;
      localcrd.wrs = 5;
      localcrd.wrt = 5;
      continue;
      localcrd.wru = 16000;
      localcrd.wrv = 16;
      localcrd.wrs = 4;
      localcrd.wrt = 4;
      continue;
      localcrd.wru = 16000;
      paramString = s.vK(paramString);
      if ((paramString != null) && ((paramString instanceof j)))
      {
        paramInt = ((j)paramString).getSampleRate();
        if (paramInt >= 8000) {
          localcrd.wru = paramInt;
        }
      }
      localcrd.wrv = 16;
      localcrd.wrs = 6;
      localcrd.wrt = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.d
 * JD-Core Version:    0.7.0.1
 */