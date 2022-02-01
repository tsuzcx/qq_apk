package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dau
  extends erp
{
  public String aaGq;
  public String nUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32330);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaGq != null) {
        paramVarArgs.g(2, this.aaGq);
      }
      if (this.nUB != null) {
        paramVarArgs.g(3, this.nUB);
      }
      AppMethodBeat.o(32330);
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
      if (this.aaGq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaGq);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUB);
      }
      AppMethodBeat.o(32330);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32330);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dau localdau = (dau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32330);
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
            localdau.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32330);
          return 0;
        case 2: 
          localdau.aaGq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32330);
          return 0;
        }
        localdau.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32330);
        return 0;
      }
      AppMethodBeat.o(32330);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dau
 * JD-Core Version:    0.7.0.1
 */