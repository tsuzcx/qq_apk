package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afp
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t FzN;
  public int GdB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FzN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133169);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GdB);
      if (this.FzN != null)
      {
        paramVarArgs.lC(2, this.FzN.computeSize());
        this.FzN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GdB) + 0;
      paramInt = i;
      if (this.FzN != null) {
        paramInt = i + f.a.a.a.lB(2, this.FzN.computeSize());
      }
      AppMethodBeat.o(133169);
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
      if (this.FzN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133169);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afp localafp = (afp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133169);
        return -1;
      case 1: 
        localafp.GdB = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133169);
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
        localafp.FzN = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    AppMethodBeat.o(133169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afp
 * JD-Core Version:    0.7.0.1
 */