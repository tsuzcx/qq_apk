package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxt
  extends cvp
{
  public int GWO;
  public int GeI;
  public long GeJ;
  public int HKl;
  public int Hgi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115877);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.Hgi);
      paramVarArgs.aS(5, this.GWO);
      paramVarArgs.aS(6, this.HKl);
      AppMethodBeat.o(115877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GeI);
      int j = f.a.a.b.b.a.p(3, this.GeJ);
      int k = f.a.a.b.b.a.bz(4, this.Hgi);
      int m = f.a.a.b.b.a.bz(5, this.GWO);
      int n = f.a.a.b.b.a.bz(6, this.HKl);
      AppMethodBeat.o(115877);
      return paramInt + i + j + k + m + n;
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
          AppMethodBeat.o(115877);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxt localdxt = (dxt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115877);
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
            localdxt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115877);
          return 0;
        case 2: 
          localdxt.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115877);
          return 0;
        case 3: 
          localdxt.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115877);
          return 0;
        case 4: 
          localdxt.Hgi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115877);
          return 0;
        case 5: 
          localdxt.GWO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115877);
          return 0;
        }
        localdxt.HKl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115877);
        return 0;
      }
      AppMethodBeat.o(115877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxt
 * JD-Core Version:    0.7.0.1
 */