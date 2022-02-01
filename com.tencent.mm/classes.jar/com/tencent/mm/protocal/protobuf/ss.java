package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ss
  extends com.tencent.mm.bw.a
{
  public String FIt;
  public LinkedList<abx> GhE;
  public int GhF;
  public String GhG;
  public String name;
  
  public ss()
  {
    AppMethodBeat.i(32155);
    this.GhE = new LinkedList();
    AppMethodBeat.o(32155);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GhE);
      if (this.FIt != null) {
        paramVarArgs.d(2, this.FIt);
      }
      paramVarArgs.aS(3, this.GhF);
      if (this.GhG != null) {
        paramVarArgs.d(4, this.GhG);
      }
      if (this.name != null) {
        paramVarArgs.d(5, this.name);
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GhE) + 0;
      paramInt = i;
      if (this.FIt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FIt);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GhF);
      paramInt = i;
      if (this.GhG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GhG);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.name);
      }
      AppMethodBeat.o(32156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GhE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ss localss = (ss)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32156);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((abx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localss.GhE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32156);
        return 0;
      case 2: 
        localss.FIt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32156);
        return 0;
      case 3: 
        localss.GhF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32156);
        return 0;
      case 4: 
        localss.GhG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32156);
        return 0;
      }
      localss.name = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(32156);
      return 0;
    }
    AppMethodBeat.o(32156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ss
 * JD-Core Version:    0.7.0.1
 */