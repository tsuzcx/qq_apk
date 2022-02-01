package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aar
  extends com.tencent.mm.bw.a
{
  public csy Gsa;
  public float Gsb;
  public LinkedList<Integer> Gsc;
  public int audioBitrate;
  public int audioChannelCount;
  public int audioSampleRate;
  public int fps;
  public int hYi;
  public int hpl;
  public String pYH;
  public int tTU;
  public int tTV;
  public int targetHeight;
  public int targetWidth;
  public int videoBitrate;
  
  public aar()
  {
    AppMethodBeat.i(212472);
    this.Gsc = new LinkedList();
    AppMethodBeat.o(212472);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pYH != null) {
        paramVarArgs.d(1, this.pYH);
      }
      paramVarArgs.aS(4, this.tTU);
      paramVarArgs.aS(5, this.tTV);
      if (this.Gsa != null)
      {
        paramVarArgs.lJ(6, this.Gsa.computeSize());
        this.Gsa.writeFields(paramVarArgs);
      }
      paramVarArgs.y(7, this.Gsb);
      paramVarArgs.aS(8, this.targetWidth);
      paramVarArgs.aS(9, this.targetHeight);
      paramVarArgs.aS(10, this.videoBitrate);
      paramVarArgs.aS(11, this.fps);
      paramVarArgs.aS(12, this.hpl);
      paramVarArgs.aS(13, this.audioBitrate);
      paramVarArgs.aS(14, this.audioSampleRate);
      paramVarArgs.aS(15, this.audioChannelCount);
      paramVarArgs.e(16, 2, this.Gsc);
      paramVarArgs.aS(17, this.hYi);
      AppMethodBeat.o(212473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pYH == null) {
        break label1008;
      }
    }
    label1008:
    for (paramInt = f.a.a.b.b.a.e(1, this.pYH) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(4, this.tTU) + f.a.a.b.b.a.bz(5, this.tTV);
      paramInt = i;
      if (this.Gsa != null) {
        paramInt = i + f.a.a.a.lI(6, this.Gsa.computeSize());
      }
      i = f.a.a.b.b.a.amE(7);
      int j = f.a.a.b.b.a.bz(8, this.targetWidth);
      int k = f.a.a.b.b.a.bz(9, this.targetHeight);
      int m = f.a.a.b.b.a.bz(10, this.videoBitrate);
      int n = f.a.a.b.b.a.bz(11, this.fps);
      int i1 = f.a.a.b.b.a.bz(12, this.hpl);
      int i2 = f.a.a.b.b.a.bz(13, this.audioBitrate);
      int i3 = f.a.a.b.b.a.bz(14, this.audioSampleRate);
      int i4 = f.a.a.b.b.a.bz(15, this.audioChannelCount);
      int i5 = f.a.a.a.c(16, 2, this.Gsc);
      int i6 = f.a.a.b.b.a.bz(17, this.hYi);
      AppMethodBeat.o(212473);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gsc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(212473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aar localaar = (aar)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          AppMethodBeat.o(212473);
          return -1;
        case 1: 
          localaar.pYH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(212473);
          return 0;
        case 4: 
          localaar.tTU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 5: 
          localaar.tTV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaar.Gsa = ((csy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212473);
          return 0;
        case 7: 
          localaar.Gsb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(212473);
          return 0;
        case 8: 
          localaar.targetWidth = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 9: 
          localaar.targetHeight = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 10: 
          localaar.videoBitrate = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 11: 
          localaar.fps = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 12: 
          localaar.hpl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 13: 
          localaar.audioBitrate = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 14: 
          localaar.audioSampleRate = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 15: 
          localaar.audioChannelCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212473);
          return 0;
        case 16: 
          localaar.Gsc.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(212473);
          return 0;
        }
        localaar.hYi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(212473);
        return 0;
      }
      AppMethodBeat.o(212473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aar
 * JD-Core Version:    0.7.0.1
 */