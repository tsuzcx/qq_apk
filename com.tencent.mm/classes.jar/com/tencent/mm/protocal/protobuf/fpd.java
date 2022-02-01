package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fpd
  extends com.tencent.mm.bx.a
{
  public fqe abPg;
  public foz abPh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257777);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abPg == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaEncryptData");
        AppMethodBeat.o(257777);
        throw paramVarArgs;
      }
      if (this.abPh == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesEncryptData");
        AppMethodBeat.o(257777);
        throw paramVarArgs;
      }
      if (this.abPg != null)
      {
        paramVarArgs.qD(1, this.abPg.computeSize());
        this.abPg.writeFields(paramVarArgs);
      }
      if (this.abPh != null)
      {
        paramVarArgs.qD(2, this.abPh.computeSize());
        this.abPh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abPg == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.abPg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abPh != null) {
        i = paramInt + i.a.a.a.qC(2, this.abPh.computeSize());
      }
      AppMethodBeat.o(257777);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abPg == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaEncryptData");
          AppMethodBeat.o(257777);
          throw paramVarArgs;
        }
        if (this.abPh == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesEncryptData");
          AppMethodBeat.o(257777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fpd localfpd = (fpd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257777);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqe)localObject2).parseFrom((byte[])localObject1);
            }
            localfpd.abPg = ((fqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257777);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new foz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((foz)localObject2).parseFrom((byte[])localObject1);
          }
          localfpd.abPh = ((foz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257777);
        return 0;
      }
      AppMethodBeat.o(257777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpd
 * JD-Core Version:    0.7.0.1
 */