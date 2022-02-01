package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyo
  extends erp
{
  public String abzT;
  public long abzU;
  public long eUc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82476);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abzT != null) {
        paramVarArgs.g(2, this.abzT);
      }
      paramVarArgs.bv(3, this.eUc);
      paramVarArgs.bv(4, this.abzU);
      AppMethodBeat.o(82476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abzT != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abzT);
      }
      paramInt = i.a.a.b.b.a.q(3, this.eUc);
      int j = i.a.a.b.b.a.q(4, this.abzU);
      AppMethodBeat.o(82476);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eyo localeyo = (eyo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82476);
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
            localeyo.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82476);
          return 0;
        case 2: 
          localeyo.abzT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82476);
          return 0;
        case 3: 
          localeyo.eUc = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(82476);
          return 0;
        }
        localeyo.abzU = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(82476);
        return 0;
      }
      AppMethodBeat.o(82476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyo
 * JD-Core Version:    0.7.0.1
 */