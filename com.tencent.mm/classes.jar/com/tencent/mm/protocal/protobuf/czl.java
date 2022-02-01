package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czl
  extends com.tencent.mm.bw.a
{
  public int MEJ;
  public SKBuiltinBuffer_t MEK;
  public int MEL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134248);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MEJ);
      if (this.MEK != null)
      {
        paramVarArgs.ni(2, this.MEK.computeSize());
        this.MEK.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.MEL);
      AppMethodBeat.o(134248);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MEJ) + 0;
      paramInt = i;
      if (this.MEK != null) {
        paramInt = i + g.a.a.a.nh(2, this.MEK.computeSize());
      }
      i = g.a.a.b.b.a.bu(3, this.MEL);
      AppMethodBeat.o(134248);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(134248);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      czl localczl = (czl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(134248);
        return -1;
      case 1: 
        localczl.MEJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(134248);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localczl.MEK = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134248);
        return 0;
      }
      localczl.MEL = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(134248);
      return 0;
    }
    AppMethodBeat.o(134248);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czl
 * JD-Core Version:    0.7.0.1
 */