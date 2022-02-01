package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djv
  extends com.tencent.mm.bw.a
{
  public aen MNM;
  public boolean MNN;
  public boolean MNO;
  public boolean MNP;
  public boolean MNQ;
  public boolean MNR;
  public boolean MNS;
  public boolean MNT;
  public boolean MNU;
  public boolean MNV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91659);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MNM != null)
      {
        paramVarArgs.ni(1, this.MNM.computeSize());
        this.MNM.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.MNN);
      paramVarArgs.cc(3, this.MNO);
      paramVarArgs.cc(4, this.MNP);
      paramVarArgs.cc(5, this.MNQ);
      paramVarArgs.cc(6, this.MNR);
      paramVarArgs.cc(7, this.MNS);
      paramVarArgs.cc(8, this.MNT);
      paramVarArgs.cc(9, this.MNU);
      paramVarArgs.cc(10, this.MNV);
      AppMethodBeat.o(91659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MNM == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = g.a.a.a.nh(1, this.MNM.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.fS(6);
      int i1 = g.a.a.b.b.a.fS(7);
      int i2 = g.a.a.b.b.a.fS(8);
      int i3 = g.a.a.b.b.a.fS(9);
      int i4 = g.a.a.b.b.a.fS(10);
      AppMethodBeat.o(91659);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1) + (i3 + 1) + (i4 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djv localdjv = (djv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91659);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aen();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aen)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdjv.MNM = ((aen)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91659);
          return 0;
        case 2: 
          localdjv.MNN = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91659);
          return 0;
        case 3: 
          localdjv.MNO = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91659);
          return 0;
        case 4: 
          localdjv.MNP = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91659);
          return 0;
        case 5: 
          localdjv.MNQ = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91659);
          return 0;
        case 6: 
          localdjv.MNR = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91659);
          return 0;
        case 7: 
          localdjv.MNS = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91659);
          return 0;
        case 8: 
          localdjv.MNT = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91659);
          return 0;
        case 9: 
          localdjv.MNU = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91659);
          return 0;
        }
        localdjv.MNV = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(91659);
        return 0;
      }
      AppMethodBeat.o(91659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djv
 * JD-Core Version:    0.7.0.1
 */