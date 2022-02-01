package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dow
  extends com.tencent.mm.bw.a
{
  public int MPS;
  public SKBuiltinBuffer_t MSr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32414);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MSr == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResData");
        AppMethodBeat.o(32414);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MPS);
      if (this.MSr != null)
      {
        paramVarArgs.ni(2, this.MSr.computeSize());
        this.MSr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MPS) + 0;
      paramInt = i;
      if (this.MSr != null) {
        paramInt = i + g.a.a.a.nh(2, this.MSr.computeSize());
      }
      AppMethodBeat.o(32414);
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
      if (this.MSr == null)
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
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dow localdow = (dow)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32414);
        return -1;
      case 1: 
        localdow.MPS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32414);
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
        localdow.MSr = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32414);
      return 0;
    }
    AppMethodBeat.o(32414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dow
 * JD-Core Version:    0.7.0.1
 */