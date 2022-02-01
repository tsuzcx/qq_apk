package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fcb
  extends com.tencent.mm.bw.a
{
  public String MbJ;
  public SKBuiltinBuffer_t MbL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133209);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MbL == null)
      {
        paramVarArgs = new b("Not all required fields were included: VerifyBuff");
        AppMethodBeat.o(133209);
        throw paramVarArgs;
      }
      if (this.MbJ != null) {
        paramVarArgs.e(1, this.MbJ);
      }
      if (this.MbL != null)
      {
        paramVarArgs.ni(2, this.MbL.computeSize());
        this.MbL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MbJ == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = g.a.a.b.b.a.f(1, this.MbJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MbL != null) {
        i = paramInt + g.a.a.a.nh(2, this.MbL.computeSize());
      }
      AppMethodBeat.o(133209);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MbL == null)
        {
          paramVarArgs = new b("Not all required fields were included: VerifyBuff");
          AppMethodBeat.o(133209);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcb localfcb = (fcb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133209);
          return -1;
        case 1: 
          localfcb.MbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133209);
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
          localfcb.MbL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133209);
        return 0;
      }
      AppMethodBeat.o(133209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcb
 * JD-Core Version:    0.7.0.1
 */