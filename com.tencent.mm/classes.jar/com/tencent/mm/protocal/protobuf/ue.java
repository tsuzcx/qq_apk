package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ue
  extends com.tencent.mm.bw.a
{
  public String LdB;
  public int LdC;
  public String LdD;
  public un LdE;
  public String LdF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113956);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LdB != null) {
        paramVarArgs.e(1, this.LdB);
      }
      paramVarArgs.aM(2, this.LdC);
      if (this.LdD != null) {
        paramVarArgs.e(3, this.LdD);
      }
      if (this.LdE != null)
      {
        paramVarArgs.ni(4, this.LdE.computeSize());
        this.LdE.writeFields(paramVarArgs);
      }
      if (this.LdF != null) {
        paramVarArgs.e(5, this.LdF);
      }
      AppMethodBeat.o(113956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LdB == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = g.a.a.b.b.a.f(1, this.LdB) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LdC);
      paramInt = i;
      if (this.LdD != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LdD);
      }
      i = paramInt;
      if (this.LdE != null) {
        i = paramInt + g.a.a.a.nh(4, this.LdE.computeSize());
      }
      paramInt = i;
      if (this.LdF != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LdF);
      }
      AppMethodBeat.o(113956);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ue localue = (ue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113956);
          return -1;
        case 1: 
          localue.LdB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 2: 
          localue.LdC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113956);
          return 0;
        case 3: 
          localue.LdD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localue.LdE = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113956);
          return 0;
        }
        localue.LdF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113956);
        return 0;
      }
      AppMethodBeat.o(113956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ue
 * JD-Core Version:    0.7.0.1
 */