package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnw
  extends erp
{
  public String aavf;
  public String aavg;
  public String aavh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259842);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aavf != null) {
        paramVarArgs.g(2, this.aavf);
      }
      if (this.aavg != null) {
        paramVarArgs.g(3, this.aavg);
      }
      if (this.aavh != null) {
        paramVarArgs.g(4, this.aavh);
      }
      AppMethodBeat.o(259842);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aavf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aavf);
      }
      i = paramInt;
      if (this.aavg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aavg);
      }
      paramInt = i;
      if (this.aavh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aavh);
      }
      AppMethodBeat.o(259842);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259842);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cnw localcnw = (cnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259842);
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
            localcnw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259842);
          return 0;
        case 2: 
          localcnw.aavf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259842);
          return 0;
        case 3: 
          localcnw.aavg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259842);
          return 0;
        }
        localcnw.aavh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259842);
        return 0;
      }
      AppMethodBeat.o(259842);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnw
 * JD-Core Version:    0.7.0.1
 */