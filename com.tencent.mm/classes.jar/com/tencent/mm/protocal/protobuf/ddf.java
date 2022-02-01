package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddf
  extends cvp
{
  public String GDJ;
  public int ihf;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32449);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32449);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ihf);
      paramVarArgs.aS(3, this.nEf);
      if (this.GDJ != null) {
        paramVarArgs.d(4, this.GDJ);
      }
      AppMethodBeat.o(32449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ihf) + f.a.a.b.b.a.bz(3, this.nEf);
      paramInt = i;
      if (this.GDJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GDJ);
      }
      AppMethodBeat.o(32449);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddf localddf = (ddf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32449);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32449);
          return 0;
        case 2: 
          localddf.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32449);
          return 0;
        case 3: 
          localddf.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32449);
          return 0;
        }
        localddf.GDJ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32449);
        return 0;
      }
      AppMethodBeat.o(32449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddf
 * JD-Core Version:    0.7.0.1
 */