package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fqv
  extends erp
{
  public int YFu;
  public cyx YNR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32473);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YNR == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32473);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YNR != null)
      {
        paramVarArgs.qD(2, this.YNR.computeSize());
        this.YNR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.YFu);
      AppMethodBeat.o(32473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label523;
      }
    }
    label523:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YNR != null) {
        i = paramInt + i.a.a.a.qC(2, this.YNR.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.YFu);
      AppMethodBeat.o(32473);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YNR == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32473);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fqv localfqv = (fqv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(32473);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfqv.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32473);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyx)localObject2).parseFrom((byte[])localObject1);
            }
            localfqv.YNR = ((cyx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32473);
          return 0;
        }
        localfqv.YFu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32473);
        return 0;
      }
      AppMethodBeat.o(32473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqv
 * JD-Core Version:    0.7.0.1
 */