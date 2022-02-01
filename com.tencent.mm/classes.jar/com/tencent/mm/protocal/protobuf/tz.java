package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tz
  extends com.tencent.mm.bw.a
{
  public String LcI;
  public String LcJ;
  public String LcK;
  public int LcL;
  public un LcM;
  public int LcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113950);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LcI != null) {
        paramVarArgs.e(1, this.LcI);
      }
      if (this.LcJ != null) {
        paramVarArgs.e(2, this.LcJ);
      }
      if (this.LcK != null) {
        paramVarArgs.e(3, this.LcK);
      }
      paramVarArgs.aM(4, this.LcL);
      if (this.LcM != null)
      {
        paramVarArgs.ni(5, this.LcM.computeSize());
        this.LcM.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.LcN);
      AppMethodBeat.o(113950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LcI == null) {
        break label582;
      }
    }
    label582:
    for (int i = g.a.a.b.b.a.f(1, this.LcI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LcJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LcJ);
      }
      i = paramInt;
      if (this.LcK != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LcK);
      }
      i += g.a.a.b.b.a.bu(4, this.LcL);
      paramInt = i;
      if (this.LcM != null) {
        paramInt = i + g.a.a.a.nh(5, this.LcM.computeSize());
      }
      i = g.a.a.b.b.a.bu(6, this.LcN);
      AppMethodBeat.o(113950);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        tz localtz = (tz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113950);
          return -1;
        case 1: 
          localtz.LcI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 2: 
          localtz.LcJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 3: 
          localtz.LcK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 4: 
          localtz.LcL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113950);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localtz.LcM = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113950);
          return 0;
        }
        localtz.LcN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113950);
        return 0;
      }
      AppMethodBeat.o(113950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tz
 * JD-Core Version:    0.7.0.1
 */