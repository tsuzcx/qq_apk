package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffx
  extends erp
{
  public long Tqa;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257955);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.Tqa);
      paramVarArgs.bS(3, this.action);
      AppMethodBeat.o(257955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.Tqa);
      int j = i.a.a.b.b.a.cJ(3, this.action);
      AppMethodBeat.o(257955);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ffx localffx = (ffx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257955);
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
            localffx.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257955);
          return 0;
        case 2: 
          localffx.Tqa = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257955);
          return 0;
        }
        localffx.action = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257955);
        return 0;
      }
      AppMethodBeat.o(257955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffx
 * JD-Core Version:    0.7.0.1
 */