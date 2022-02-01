package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aer
  extends com.tencent.mm.bx.a
{
  public int GcD;
  public aeo GcE;
  public aeo GcF;
  public int GcG;
  public int GcH;
  public int GcI;
  public int GcJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GcD);
      if (this.GcE != null)
      {
        paramVarArgs.lC(2, this.GcE.computeSize());
        this.GcE.writeFields(paramVarArgs);
      }
      if (this.GcF != null)
      {
        paramVarArgs.lC(3, this.GcF.computeSize());
        this.GcF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GcG);
      paramVarArgs.aS(5, this.GcH);
      paramVarArgs.aS(6, this.GcI);
      paramVarArgs.aS(7, this.GcJ);
      AppMethodBeat.o(90966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GcD) + 0;
      paramInt = i;
      if (this.GcE != null) {
        paramInt = i + f.a.a.a.lB(2, this.GcE.computeSize());
      }
      i = paramInt;
      if (this.GcF != null) {
        i = paramInt + f.a.a.a.lB(3, this.GcF.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GcG);
      int j = f.a.a.b.b.a.bz(5, this.GcH);
      int k = f.a.a.b.b.a.bz(6, this.GcI);
      int m = f.a.a.b.b.a.bz(7, this.GcJ);
      AppMethodBeat.o(90966);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(90966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aer localaer = (aer)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90966);
        return -1;
      case 1: 
        localaer.GcD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(90966);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aeo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aeo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaer.GcE = ((aeo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aeo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aeo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaer.GcF = ((aeo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 4: 
        localaer.GcG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(90966);
        return 0;
      case 5: 
        localaer.GcH = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(90966);
        return 0;
      case 6: 
        localaer.GcI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(90966);
        return 0;
      }
      localaer.GcJ = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(90966);
      return 0;
    }
    AppMethodBeat.o(90966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aer
 * JD-Core Version:    0.7.0.1
 */