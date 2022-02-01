package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ckx
  extends com.tencent.mm.bx.a
{
  public int EdY;
  public SKBuiltinBuffer_t Egu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egu == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResData");
        AppMethodBeat.o(32414);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.EdY);
      if (this.Egu != null)
      {
        paramVarArgs.kX(2, this.Egu.computeSize());
        this.Egu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.EdY) + 0;
      paramInt = i;
      if (this.Egu != null) {
        paramInt = i + f.a.a.a.kW(2, this.Egu.computeSize());
      }
      AppMethodBeat.o(32414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Egu == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResData");
        AppMethodBeat.o(32414);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ckx localckx = (ckx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32414);
        return -1;
      case 1: 
        localckx.EdY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32414);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localckx.Egu = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32414);
      return 0;
    }
    AppMethodBeat.o(32414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckx
 * JD-Core Version:    0.7.0.1
 */