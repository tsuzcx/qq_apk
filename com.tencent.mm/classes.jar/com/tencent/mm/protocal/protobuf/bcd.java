package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcd
  extends com.tencent.mm.bx.a
{
  public bnj FCT;
  public int GyM;
  public int Ret;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      if (this.FCT != null)
      {
        paramVarArgs.lC(2, this.FCT.computeSize());
        this.FCT.writeFields(paramVarArgs);
      }
      if (this.xbo != null) {
        paramVarArgs.d(3, this.xbo);
      }
      paramVarArgs.aS(4, this.GyM);
      AppMethodBeat.o(82415);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FCT != null) {
        paramInt = i + f.a.a.a.lB(2, this.FCT.computeSize());
      }
      i = paramInt;
      if (this.xbo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xbo);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GyM);
      AppMethodBeat.o(82415);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(82415);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bcd localbcd = (bcd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82415);
        return -1;
      case 1: 
        localbcd.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(82415);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcd.FCT = ((bnj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82415);
        return 0;
      case 3: 
        localbcd.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82415);
        return 0;
      }
      localbcd.GyM = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(82415);
      return 0;
    }
    AppMethodBeat.o(82415);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcd
 * JD-Core Version:    0.7.0.1
 */