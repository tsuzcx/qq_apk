package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgc
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t HaC;
  public long Id;
  public int gsV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Id);
      paramVarArgs.aS(2, this.gsV);
      if (this.HaC != null)
      {
        paramVarArgs.lC(3, this.HaC.computeSize());
        this.HaC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0 + f.a.a.b.b.a.bz(2, this.gsV);
      paramInt = i;
      if (this.HaC != null) {
        paramInt = i + f.a.a.a.lB(3, this.HaC.computeSize());
      }
      AppMethodBeat.o(125795);
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
      AppMethodBeat.o(125795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dgc localdgc = (dgc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125795);
        return -1;
      case 1: 
        localdgc.Id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125795);
        return 0;
      case 2: 
        localdgc.gsV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125795);
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
        localdgc.HaC = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125795);
      return 0;
    }
    AppMethodBeat.o(125795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgc
 * JD-Core Version:    0.7.0.1
 */