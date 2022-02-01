package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vi
  extends erp
{
  public String iaJ;
  public String wsy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32153);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wsy != null) {
        paramVarArgs.g(2, this.wsy);
      }
      if (this.iaJ != null) {
        paramVarArgs.g(3, this.iaJ);
      }
      AppMethodBeat.o(32153);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label413;
      }
    }
    label413:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wsy);
      }
      i = paramInt;
      if (this.iaJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.iaJ);
      }
      AppMethodBeat.o(32153);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32153);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        vi localvi = (vi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32153);
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
            localvi.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32153);
          return 0;
        case 2: 
          localvi.wsy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32153);
          return 0;
        }
        localvi.iaJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32153);
        return 0;
      }
      AppMethodBeat.o(32153);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vi
 * JD-Core Version:    0.7.0.1
 */