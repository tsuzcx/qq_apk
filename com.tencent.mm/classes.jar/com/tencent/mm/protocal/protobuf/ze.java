package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ze
  extends com.tencent.mm.bx.a
{
  public int FYI;
  public SKBuiltinBuffer_t FYJ;
  public int FYK;
  public SKBuiltinBuffer_t FYL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FYJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.FYI);
      if (this.FYJ != null)
      {
        paramVarArgs.lC(2, this.FYJ.computeSize());
        this.FYJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FYK);
      if (this.FYL != null)
      {
        paramVarArgs.lC(4, this.FYL.computeSize());
        this.FYL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FYI) + 0;
      paramInt = i;
      if (this.FYJ != null) {
        paramInt = i + f.a.a.a.lB(2, this.FYJ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FYK);
      paramInt = i;
      if (this.FYL != null) {
        paramInt = i + f.a.a.a.lB(4, this.FYL.computeSize());
      }
      AppMethodBeat.o(145668);
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
      if (this.FYJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ze localze = (ze)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(145668);
        return -1;
      case 1: 
        localze.FYI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(145668);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localze.FYJ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(145668);
        return 0;
      case 3: 
        localze.FYK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(145668);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localze.FYL = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    AppMethodBeat.o(145668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ze
 * JD-Core Version:    0.7.0.1
 */