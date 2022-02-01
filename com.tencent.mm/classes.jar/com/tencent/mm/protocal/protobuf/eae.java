package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eae
  extends com.tencent.mm.bw.a
{
  public long Id;
  public SKBuiltinBuffer_t MDa;
  public int him;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125795);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Id);
      paramVarArgs.aM(2, this.him);
      if (this.MDa != null)
      {
        paramVarArgs.ni(3, this.MDa.computeSize());
        this.MDa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Id) + 0 + g.a.a.b.b.a.bu(2, this.him);
      paramInt = i;
      if (this.MDa != null) {
        paramInt = i + g.a.a.a.nh(3, this.MDa.computeSize());
      }
      AppMethodBeat.o(125795);
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
      AppMethodBeat.o(125795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eae localeae = (eae)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125795);
        return -1;
      case 1: 
        localeae.Id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125795);
        return 0;
      case 2: 
        localeae.him = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125795);
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
        localeae.MDa = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eae
 * JD-Core Version:    0.7.0.1
 */