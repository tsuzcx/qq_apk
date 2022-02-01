package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzo
  extends com.tencent.mm.bw.a
{
  public String ETZ;
  public SKBuiltinBuffer_t EUc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133209);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EUc == null)
      {
        paramVarArgs = new b("Not all required fields were included: VerifyBuff");
        AppMethodBeat.o(133209);
        throw paramVarArgs;
      }
      if (this.ETZ != null) {
        paramVarArgs.d(1, this.ETZ);
      }
      if (this.EUc != null)
      {
        paramVarArgs.ln(2, this.EUc.computeSize());
        this.EUc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ETZ == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.ETZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EUc != null) {
        i = paramInt + f.a.a.a.lm(2, this.EUc.computeSize());
      }
      AppMethodBeat.o(133209);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EUc == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzo localdzo = (dzo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133209);
          return -1;
        case 1: 
          localdzo.ETZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133209);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzo.EUc = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzo
 * JD-Core Version:    0.7.0.1
 */