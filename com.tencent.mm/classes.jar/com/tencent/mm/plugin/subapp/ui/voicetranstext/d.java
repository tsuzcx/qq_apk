package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.c.cds;

public final class d
{
  public static cds aK(int paramInt, String paramString)
  {
    cds localcds = new cds();
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      localcds.sxR = 0;
      localcds.sxS = 0;
      localcds.sxP = 0;
      localcds.sxQ = 0;
      return localcds;
    case 0: 
      localcds.sxR = 8000;
      localcds.sxS = 16;
      localcds.sxP = 5;
      localcds.sxQ = 5;
      return localcds;
    case 1: 
      localcds.sxR = 16000;
      localcds.sxS = 16;
      localcds.sxP = 4;
      localcds.sxQ = 4;
      return localcds;
    }
    localcds.sxR = 16000;
    paramString = q.ox(paramString);
    if (paramString != null)
    {
      paramInt = MediaRecorder.SilkGetEncSampleRate(((h)paramString).bz(0, 1).buf);
      if (paramInt >= 8000) {
        localcds.sxR = paramInt;
      }
    }
    localcds.sxS = 16;
    localcds.sxP = 6;
    localcds.sxQ = 6;
    return localcds;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.d
 * JD-Core Version:    0.7.0.1
 */