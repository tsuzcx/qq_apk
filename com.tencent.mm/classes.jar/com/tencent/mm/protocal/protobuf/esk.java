package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class esk
  extends com.tencent.mm.bw.a
{
  public String KXr;
  public SKBuiltinBuffer_t Nlq;
  public int NpA;
  public int jeU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148667);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nlq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(148667);
        throw paramVarArgs;
      }
      if (this.Nlq != null)
      {
        paramVarArgs.ni(1, this.Nlq.computeSize());
        this.Nlq.writeFields(paramVarArgs);
      }
      if (this.KXr != null) {
        paramVarArgs.e(2, this.KXr);
      }
      paramVarArgs.aM(3, this.jeU);
      paramVarArgs.aM(4, this.NpA);
      AppMethodBeat.o(148667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nlq == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.nh(1, this.Nlq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KXr != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KXr);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.jeU);
      int j = g.a.a.b.b.a.bu(4, this.NpA);
      AppMethodBeat.o(148667);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Nlq == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(148667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148667);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        esk localesk = (esk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148667);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localesk.Nlq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148667);
          return 0;
        case 2: 
          localesk.KXr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148667);
          return 0;
        case 3: 
          localesk.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148667);
          return 0;
        }
        localesk.NpA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148667);
        return 0;
      }
      AppMethodBeat.o(148667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esk
 * JD-Core Version:    0.7.0.1
 */