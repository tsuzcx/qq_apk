package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahe
  extends com.tencent.mm.bw.a
{
  public int LqP;
  public ahb LqQ;
  public ahb LqR;
  public int LqS;
  public int LqT;
  public int LqU;
  public int LqV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90966);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LqP);
      if (this.LqQ != null)
      {
        paramVarArgs.ni(2, this.LqQ.computeSize());
        this.LqQ.writeFields(paramVarArgs);
      }
      if (this.LqR != null)
      {
        paramVarArgs.ni(3, this.LqR.computeSize());
        this.LqR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.LqS);
      paramVarArgs.aM(5, this.LqT);
      paramVarArgs.aM(6, this.LqU);
      paramVarArgs.aM(7, this.LqV);
      AppMethodBeat.o(90966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LqP) + 0;
      paramInt = i;
      if (this.LqQ != null) {
        paramInt = i + g.a.a.a.nh(2, this.LqQ.computeSize());
      }
      i = paramInt;
      if (this.LqR != null) {
        i = paramInt + g.a.a.a.nh(3, this.LqR.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(4, this.LqS);
      int j = g.a.a.b.b.a.bu(5, this.LqT);
      int k = g.a.a.b.b.a.bu(6, this.LqU);
      int m = g.a.a.b.b.a.bu(7, this.LqV);
      AppMethodBeat.o(90966);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(90966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahe localahe = (ahe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90966);
        return -1;
      case 1: 
        localahe.LqP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(90966);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahe.LqQ = ((ahb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahe.LqR = ((ahb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 4: 
        localahe.LqS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(90966);
        return 0;
      case 5: 
        localahe.LqT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(90966);
        return 0;
      case 6: 
        localahe.LqU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(90966);
        return 0;
      }
      localahe.LqV = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(90966);
      return 0;
    }
    AppMethodBeat.o(90966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahe
 * JD-Core Version:    0.7.0.1
 */