package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxq
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t FAN;
  public int FYU;
  public int qdX;
  public int yhn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.FYU);
      paramVarArgs.aS(2, this.qdX);
      paramVarArgs.aS(3, this.yhn);
      if (this.FAN != null)
      {
        paramVarArgs.lC(4, this.FAN.computeSize());
        this.FAN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FYU) + 0 + f.a.a.b.b.a.bz(2, this.qdX) + f.a.a.b.b.a.bz(3, this.yhn);
      paramInt = i;
      if (this.FAN != null) {
        paramInt = i + f.a.a.a.lB(4, this.FAN.computeSize());
      }
      AppMethodBeat.o(115873);
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
      if (this.FAN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dxq localdxq = (dxq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115873);
        return -1;
      case 1: 
        localdxq.FYU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115873);
        return 0;
      case 2: 
        localdxq.qdX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115873);
        return 0;
      case 3: 
        localdxq.yhn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115873);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdxq.FAN = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    AppMethodBeat.o(115873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxq
 * JD-Core Version:    0.7.0.1
 */