package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dfx
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KLU;
  public int LrO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197137);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(197137);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.LrO);
      if (this.KLU != null)
      {
        paramVarArgs.ni(2, this.KLU.computeSize());
        this.KLU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197137);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LrO) + 0;
      paramInt = i;
      if (this.KLU != null) {
        paramInt = i + g.a.a.a.nh(2, this.KLU.computeSize());
      }
      AppMethodBeat.o(197137);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(197137);
        throw paramVarArgs;
      }
      AppMethodBeat.o(197137);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dfx localdfx = (dfx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197137);
        return -1;
      case 1: 
        localdfx.LrO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(197137);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdfx.KLU = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(197137);
      return 0;
    }
    AppMethodBeat.o(197137);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfx
 * JD-Core Version:    0.7.0.1
 */