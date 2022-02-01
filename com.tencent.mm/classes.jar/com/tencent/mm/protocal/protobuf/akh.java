package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akh
  extends com.tencent.mm.bx.a
{
  public String FGP;
  public LinkedList<akb> GjA;
  public akb GjB;
  public int gsV;
  
  public akh()
  {
    AppMethodBeat.i(127478);
    this.GjA = new LinkedList();
    AppMethodBeat.o(127478);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127479);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.gsV);
      if (this.FGP != null) {
        paramVarArgs.d(2, this.FGP);
      }
      paramVarArgs.e(3, 8, this.GjA);
      if (this.GjB != null)
      {
        paramVarArgs.lC(4, this.GjB.computeSize());
        this.GjB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.gsV) + 0;
      paramInt = i;
      if (this.FGP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FGP);
      }
      i = paramInt + f.a.a.a.c(3, 8, this.GjA);
      paramInt = i;
      if (this.GjB != null) {
        paramInt = i + f.a.a.a.lB(4, this.GjB.computeSize());
      }
      AppMethodBeat.o(127479);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GjA.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      akh localakh = (akh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127479);
        return -1;
      case 1: 
        localakh.gsV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127479);
        return 0;
      case 2: 
        localakh.FGP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127479);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((akb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakh.GjA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127479);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new akb();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((akb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localakh.GjB = ((akb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    AppMethodBeat.o(127479);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akh
 * JD-Core Version:    0.7.0.1
 */