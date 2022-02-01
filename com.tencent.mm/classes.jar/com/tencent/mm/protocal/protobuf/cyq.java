package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cyq
  extends erp
{
  public String IJD;
  public String oOI;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89660);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.IJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.IJD != null) {
        paramVarArgs.g(3, this.IJD);
      }
      if (this.pSo != null) {
        paramVarArgs.g(4, this.pSo);
      }
      AppMethodBeat.o(89660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label560;
      }
    }
    label560:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.IJD != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IJD);
      }
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSo);
      }
      AppMethodBeat.o(89660);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.oOI == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        if (this.IJD == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89660);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cyq localcyq = (cyq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89660);
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
            localcyq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(89660);
          return 0;
        case 2: 
          localcyq.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(89660);
          return 0;
        case 3: 
          localcyq.IJD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(89660);
          return 0;
        }
        localcyq.pSo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(89660);
        return 0;
      }
      AppMethodBeat.o(89660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyq
 * JD-Core Version:    0.7.0.1
 */