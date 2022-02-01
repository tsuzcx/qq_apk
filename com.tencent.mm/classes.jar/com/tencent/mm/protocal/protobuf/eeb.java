package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eeb
  extends com.tencent.mm.bw.a
{
  public long Nds;
  public SKBuiltinBuffer_t Neu;
  public int him;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118463);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Neu == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Nds);
      paramVarArgs.aM(2, this.him);
      if (this.Neu != null)
      {
        paramVarArgs.ni(3, this.Neu.computeSize());
        this.Neu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Nds) + 0 + g.a.a.b.b.a.bu(2, this.him);
      paramInt = i;
      if (this.Neu != null) {
        paramInt = i + g.a.a.a.nh(3, this.Neu.computeSize());
      }
      AppMethodBeat.o(118463);
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
      if (this.Neu == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eeb localeeb = (eeb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118463);
        return -1;
      case 1: 
        localeeb.Nds = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(118463);
        return 0;
      case 2: 
        localeeb.him = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118463);
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
        localeeb.Neu = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    AppMethodBeat.o(118463);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeb
 * JD-Core Version:    0.7.0.1
 */