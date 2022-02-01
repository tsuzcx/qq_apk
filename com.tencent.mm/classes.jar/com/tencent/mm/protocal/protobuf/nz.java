package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nz
  extends com.tencent.mm.bx.a
{
  public String FEO;
  public int FGO;
  public LinkedList<ny> FIZ;
  public og FJa;
  
  public nz()
  {
    AppMethodBeat.i(124435);
    this.FIZ = new LinkedList();
    AppMethodBeat.o(124435);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124436);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FIZ);
      paramVarArgs.aS(3, this.FGO);
      if (this.FEO != null) {
        paramVarArgs.d(4, this.FEO);
      }
      if (this.FJa != null)
      {
        paramVarArgs.lC(5, this.FJa.computeSize());
        this.FJa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FIZ) + 0 + f.a.a.b.b.a.bz(3, this.FGO);
      paramInt = i;
      if (this.FEO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FEO);
      }
      i = paramInt;
      if (this.FJa != null) {
        i = paramInt + f.a.a.a.lB(5, this.FJa.computeSize());
      }
      AppMethodBeat.o(124436);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FIZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      nz localnz = (nz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(124436);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ny();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnz.FIZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124436);
        return 0;
      case 3: 
        localnz.FGO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124436);
        return 0;
      case 4: 
        localnz.FEO = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124436);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new og();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((og)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localnz.FJa = ((og)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    AppMethodBeat.o(124436);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nz
 * JD-Core Version:    0.7.0.1
 */