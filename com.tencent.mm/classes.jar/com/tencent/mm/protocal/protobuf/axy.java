package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axy
  extends cvp
{
  public int FMr;
  public LinkedList<caa> GvJ;
  public int Version;
  public int nDi;
  
  public axy()
  {
    AppMethodBeat.i(32224);
    this.GvJ = new LinkedList();
    AppMethodBeat.o(32224);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32225);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32225);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nDi);
      paramVarArgs.e(5, 8, this.GvJ);
      paramVarArgs.aS(6, this.Version);
      paramVarArgs.aS(7, this.FMr);
      AppMethodBeat.o(32225);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label661;
      }
    }
    label661:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nDi);
      int j = f.a.a.a.c(5, 8, this.GvJ);
      int k = f.a.a.b.b.a.bz(6, this.Version);
      int m = f.a.a.b.b.a.bz(7, this.FMr);
      AppMethodBeat.o(32225);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GvJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32225);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32225);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axy localaxy = (axy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(32225);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32225);
          return 0;
        case 2: 
          localaxy.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32225);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxy.GvJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32225);
          return 0;
        case 6: 
          localaxy.Version = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32225);
          return 0;
        }
        localaxy.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32225);
        return 0;
      }
      AppMethodBeat.o(32225);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axy
 * JD-Core Version:    0.7.0.1
 */