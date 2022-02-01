package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byo
  extends com.tencent.mm.bx.a
{
  public int DVq;
  public SKBuiltinBuffer_t DVr;
  public int DVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134248);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DVq);
      if (this.DVr != null)
      {
        paramVarArgs.kX(2, this.DVr.computeSize());
        this.DVr.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.DVs);
      AppMethodBeat.o(134248);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DVq) + 0;
      paramInt = i;
      if (this.DVr != null) {
        paramInt = i + f.a.a.a.kW(2, this.DVr.computeSize());
      }
      i = f.a.a.b.b.a.bA(3, this.DVs);
      AppMethodBeat.o(134248);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(134248);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byo localbyo = (byo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(134248);
        return -1;
      case 1: 
        localbyo.DVq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(134248);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyo.DVr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134248);
        return 0;
      }
      localbyo.DVs = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(134248);
      return 0;
    }
    AppMethodBeat.o(134248);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byo
 * JD-Core Version:    0.7.0.1
 */