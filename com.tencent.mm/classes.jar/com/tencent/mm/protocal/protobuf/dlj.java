package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlj
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public int HiB;
  public int HzS;
  public aet HzT;
  public aet HzU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91706);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HiB);
      paramVarArgs.aS(2, this.HzS);
      if (this.FBS != null) {
        paramVarArgs.d(3, this.FBS);
      }
      if (this.HzT != null)
      {
        paramVarArgs.lC(4, this.HzT.computeSize());
        this.HzT.writeFields(paramVarArgs);
      }
      if (this.HzU != null)
      {
        paramVarArgs.lC(5, this.HzU.computeSize());
        this.HzU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HiB) + 0 + f.a.a.b.b.a.bz(2, this.HzS);
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FBS);
      }
      i = paramInt;
      if (this.HzT != null) {
        i = paramInt + f.a.a.a.lB(4, this.HzT.computeSize());
      }
      paramInt = i;
      if (this.HzU != null) {
        paramInt = i + f.a.a.a.lB(5, this.HzU.computeSize());
      }
      AppMethodBeat.o(91706);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dlj localdlj = (dlj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91706);
        return -1;
      case 1: 
        localdlj.HiB = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91706);
        return 0;
      case 2: 
        localdlj.HzS = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91706);
        return 0;
      case 3: 
        localdlj.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91706);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aet();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlj.HzT = ((aet)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91706);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aet();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdlj.HzU = ((aet)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    AppMethodBeat.o(91706);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlj
 * JD-Core Version:    0.7.0.1
 */