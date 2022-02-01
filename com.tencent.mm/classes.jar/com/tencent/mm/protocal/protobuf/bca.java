package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bca
  extends com.tencent.mm.bx.a
{
  public bnj FCT;
  public int GyM;
  public int GyN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FCT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GyM);
      paramVarArgs.aS(2, this.GyN);
      if (this.FCT != null)
      {
        paramVarArgs.lC(3, this.FCT.computeSize());
        this.FCT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GyM) + 0 + f.a.a.b.b.a.bz(2, this.GyN);
      paramInt = i;
      if (this.FCT != null) {
        paramInt = i + f.a.a.a.lB(3, this.FCT.computeSize());
      }
      AppMethodBeat.o(82410);
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
      if (this.FCT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bca localbca = (bca)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82410);
        return -1;
      case 1: 
        localbca.GyM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(82410);
        return 0;
      case 2: 
        localbca.GyN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(82410);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bnj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbca.FCT = ((bnj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    AppMethodBeat.o(82410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bca
 * JD-Core Version:    0.7.0.1
 */