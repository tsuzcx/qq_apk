package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwk
  extends com.tencent.mm.bx.a
{
  public int HIR;
  public int HIS;
  public SKBuiltinBuffer_t HIT;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HIT == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.xcL);
      paramVarArgs.aS(2, this.HIR);
      paramVarArgs.aS(3, this.HIS);
      if (this.HIT != null)
      {
        paramVarArgs.lC(4, this.HIT.computeSize());
        this.HIT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xcL) + 0 + f.a.a.b.b.a.bz(2, this.HIR) + f.a.a.b.b.a.bz(3, this.HIS);
      paramInt = i;
      if (this.HIT != null) {
        paramInt = i + f.a.a.a.lB(4, this.HIT.computeSize());
      }
      AppMethodBeat.o(32499);
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
      if (this.HIT == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dwk localdwk = (dwk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32499);
        return -1;
      case 1: 
        localdwk.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32499);
        return 0;
      case 2: 
        localdwk.HIR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32499);
        return 0;
      case 3: 
        localdwk.HIS = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32499);
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
        localdwk.HIT = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    AppMethodBeat.o(32499);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwk
 * JD-Core Version:    0.7.0.1
 */