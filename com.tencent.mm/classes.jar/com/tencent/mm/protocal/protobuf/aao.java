package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aao
  extends com.tencent.mm.bx.a
{
  public cse FZA;
  public float FZB;
  public LinkedList<Integer> FZC;
  public int audioBitrate;
  public int audioChannelCount;
  public int audioSampleRate;
  public int fps;
  public int hVq;
  public int hmx;
  public String pSc;
  public int tJd;
  public int tJe;
  public int targetHeight;
  public int targetWidth;
  public int videoBitrate;
  
  public aao()
  {
    AppMethodBeat.i(215801);
    this.FZC = new LinkedList();
    AppMethodBeat.o(215801);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pSc != null) {
        paramVarArgs.d(1, this.pSc);
      }
      paramVarArgs.aS(4, this.tJd);
      paramVarArgs.aS(5, this.tJe);
      if (this.FZA != null)
      {
        paramVarArgs.lC(6, this.FZA.computeSize());
        this.FZA.writeFields(paramVarArgs);
      }
      paramVarArgs.z(7, this.FZB);
      paramVarArgs.aS(8, this.targetWidth);
      paramVarArgs.aS(9, this.targetHeight);
      paramVarArgs.aS(10, this.videoBitrate);
      paramVarArgs.aS(11, this.fps);
      paramVarArgs.aS(12, this.hmx);
      paramVarArgs.aS(13, this.audioBitrate);
      paramVarArgs.aS(14, this.audioSampleRate);
      paramVarArgs.aS(15, this.audioChannelCount);
      paramVarArgs.e(16, 2, this.FZC);
      paramVarArgs.aS(17, this.hVq);
      AppMethodBeat.o(215802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pSc == null) {
        break label1008;
      }
    }
    label1008:
    for (paramInt = f.a.a.b.b.a.e(1, this.pSc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(4, this.tJd) + f.a.a.b.b.a.bz(5, this.tJe);
      paramInt = i;
      if (this.FZA != null) {
        paramInt = i + f.a.a.a.lB(6, this.FZA.computeSize());
      }
      i = f.a.a.b.b.a.alU(7);
      int j = f.a.a.b.b.a.bz(8, this.targetWidth);
      int k = f.a.a.b.b.a.bz(9, this.targetHeight);
      int m = f.a.a.b.b.a.bz(10, this.videoBitrate);
      int n = f.a.a.b.b.a.bz(11, this.fps);
      int i1 = f.a.a.b.b.a.bz(12, this.hmx);
      int i2 = f.a.a.b.b.a.bz(13, this.audioBitrate);
      int i3 = f.a.a.b.b.a.bz(14, this.audioSampleRate);
      int i4 = f.a.a.b.b.a.bz(15, this.audioChannelCount);
      int i5 = f.a.a.a.c(16, 2, this.FZC);
      int i6 = f.a.a.b.b.a.bz(17, this.hVq);
      AppMethodBeat.o(215802);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FZC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215802);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aao localaao = (aao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          AppMethodBeat.o(215802);
          return -1;
        case 1: 
          localaao.pSc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215802);
          return 0;
        case 4: 
          localaao.tJd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 5: 
          localaao.tJe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaao.FZA = ((cse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215802);
          return 0;
        case 7: 
          localaao.FZB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(215802);
          return 0;
        case 8: 
          localaao.targetWidth = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 9: 
          localaao.targetHeight = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 10: 
          localaao.videoBitrate = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 11: 
          localaao.fps = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 12: 
          localaao.hmx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 13: 
          localaao.audioBitrate = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 14: 
          localaao.audioSampleRate = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 15: 
          localaao.audioChannelCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215802);
          return 0;
        case 16: 
          localaao.FZC.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(215802);
          return 0;
        }
        localaao.hVq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(215802);
        return 0;
      }
      AppMethodBeat.o(215802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aao
 * JD-Core Version:    0.7.0.1
 */