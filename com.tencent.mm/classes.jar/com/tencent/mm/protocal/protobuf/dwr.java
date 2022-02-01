package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwr
  extends erp
{
  public String abcC;
  public int muC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32362);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.muC);
      if (this.abcC != null) {
        paramVarArgs.g(3, this.abcC);
      }
      AppMethodBeat.o(32362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label397;
      }
    }
    label397:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.muC);
      paramInt = i;
      if (this.abcC != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abcC);
      }
      AppMethodBeat.o(32362);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dwr localdwr = (dwr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32362);
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
            localdwr.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32362);
          return 0;
        case 2: 
          localdwr.muC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32362);
          return 0;
        }
        localdwr.abcC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32362);
        return 0;
      }
      AppMethodBeat.o(32362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwr
 * JD-Core Version:    0.7.0.1
 */