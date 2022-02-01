package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aco
  extends com.tencent.mm.bw.a
{
  public dlh Lnm;
  public float Lnn;
  public LinkedList<Integer> Lno;
  public boolean Lnp;
  public int Lnq;
  public boolean Lnr;
  public int audioBitrate;
  public int audioChannelCount;
  public int audioSampleRate;
  public int fps;
  public int iTg;
  public int iiH;
  public String rpE;
  public int targetHeight;
  public int targetWidth;
  public int videoBitrate;
  public int xlg;
  public int xlh;
  
  public aco()
  {
    AppMethodBeat.i(201290);
    this.Lno = new LinkedList();
    AppMethodBeat.o(201290);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201291);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rpE != null) {
        paramVarArgs.e(1, this.rpE);
      }
      paramVarArgs.aM(4, this.xlg);
      paramVarArgs.aM(5, this.xlh);
      if (this.Lnm != null)
      {
        paramVarArgs.ni(6, this.Lnm.computeSize());
        this.Lnm.writeFields(paramVarArgs);
      }
      paramVarArgs.E(7, this.Lnn);
      paramVarArgs.aM(8, this.targetWidth);
      paramVarArgs.aM(9, this.targetHeight);
      paramVarArgs.aM(10, this.videoBitrate);
      paramVarArgs.aM(11, this.fps);
      paramVarArgs.aM(12, this.iiH);
      paramVarArgs.aM(13, this.audioBitrate);
      paramVarArgs.aM(14, this.audioSampleRate);
      paramVarArgs.aM(15, this.audioChannelCount);
      paramVarArgs.e(16, 2, this.Lno);
      paramVarArgs.aM(17, this.iTg);
      paramVarArgs.cc(18, this.Lnp);
      paramVarArgs.aM(19, this.Lnq);
      paramVarArgs.cc(20, this.Lnr);
      AppMethodBeat.o(201291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rpE == null) {
        break label1152;
      }
    }
    label1152:
    for (paramInt = g.a.a.b.b.a.f(1, this.rpE) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(4, this.xlg) + g.a.a.b.b.a.bu(5, this.xlh);
      paramInt = i;
      if (this.Lnm != null) {
        paramInt = i + g.a.a.a.nh(6, this.Lnm.computeSize());
      }
      i = g.a.a.b.b.a.fS(7);
      int j = g.a.a.b.b.a.bu(8, this.targetWidth);
      int k = g.a.a.b.b.a.bu(9, this.targetHeight);
      int m = g.a.a.b.b.a.bu(10, this.videoBitrate);
      int n = g.a.a.b.b.a.bu(11, this.fps);
      int i1 = g.a.a.b.b.a.bu(12, this.iiH);
      int i2 = g.a.a.b.b.a.bu(13, this.audioBitrate);
      int i3 = g.a.a.b.b.a.bu(14, this.audioSampleRate);
      int i4 = g.a.a.b.b.a.bu(15, this.audioChannelCount);
      int i5 = g.a.a.a.c(16, 2, this.Lno);
      int i6 = g.a.a.b.b.a.bu(17, this.iTg);
      int i7 = g.a.a.b.b.a.fS(18);
      int i8 = g.a.a.b.b.a.bu(19, this.Lnq);
      int i9 = g.a.a.b.b.a.fS(20);
      AppMethodBeat.o(201291);
      return paramInt + (i + 4) + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + (i7 + 1) + i8 + (i9 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lno.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(201291);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aco localaco = (aco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          AppMethodBeat.o(201291);
          return -1;
        case 1: 
          localaco.rpE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201291);
          return 0;
        case 4: 
          localaco.xlg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 5: 
          localaco.xlh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaco.Lnm = ((dlh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201291);
          return 0;
        case 7: 
          localaco.Lnn = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(201291);
          return 0;
        case 8: 
          localaco.targetWidth = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 9: 
          localaco.targetHeight = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 10: 
          localaco.videoBitrate = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 11: 
          localaco.fps = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 12: 
          localaco.iiH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 13: 
          localaco.audioBitrate = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 14: 
          localaco.audioSampleRate = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 15: 
          localaco.audioChannelCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 16: 
          localaco.Lno.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(201291);
          return 0;
        case 17: 
          localaco.iTg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        case 18: 
          localaco.Lnp = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(201291);
          return 0;
        case 19: 
          localaco.Lnq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201291);
          return 0;
        }
        localaco.Lnr = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(201291);
        return 0;
      }
      AppMethodBeat.o(201291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aco
 * JD-Core Version:    0.7.0.1
 */