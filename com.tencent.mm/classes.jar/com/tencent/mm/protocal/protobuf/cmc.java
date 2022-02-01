package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cmc
  extends erp
{
  public String LensId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104805);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.LensId == null)
      {
        paramVarArgs = new b("Not all required fields were included: LensId");
        AppMethodBeat.o(104805);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LensId != null) {
        paramVarArgs.g(2, this.LensId);
      }
      AppMethodBeat.o(104805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LensId != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.LensId);
      }
      AppMethodBeat.o(104805);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.LensId == null)
        {
          paramVarArgs = new b("Not all required fields were included: LensId");
          AppMethodBeat.o(104805);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104805);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cmc localcmc = (cmc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104805);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localcmc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(104805);
          return 0;
        }
        localcmc.LensId = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(104805);
        return 0;
      }
      AppMethodBeat.o(104805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmc
 * JD-Core Version:    0.7.0.1
 */