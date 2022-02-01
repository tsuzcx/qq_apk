package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbl
  extends cvp
{
  public long Fvd;
  public int Gyu;
  public int Gyv;
  public int Gyw;
  public long nDF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127496);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Fvd);
      paramVarArgs.aY(3, this.nDF);
      paramVarArgs.aS(4, this.Gyu);
      paramVarArgs.aS(5, this.Gyv);
      paramVarArgs.aS(6, this.Gyw);
      AppMethodBeat.o(127496);
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
      int i = f.a.a.b.b.a.p(2, this.Fvd);
      int j = f.a.a.b.b.a.p(3, this.nDF);
      int k = f.a.a.b.b.a.bz(4, this.Gyu);
      int m = f.a.a.b.b.a.bz(5, this.Gyv);
      int n = f.a.a.b.b.a.bz(6, this.Gyw);
      AppMethodBeat.o(127496);
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
          AppMethodBeat.o(127496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbl localbbl = (bbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127496);
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
            localbbl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127496);
          return 0;
        case 2: 
          localbbl.Fvd = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(127496);
          return 0;
        case 3: 
          localbbl.nDF = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(127496);
          return 0;
        case 4: 
          localbbl.Gyu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127496);
          return 0;
        case 5: 
          localbbl.Gyv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127496);
          return 0;
        }
        localbbl.Gyw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127496);
        return 0;
      }
      AppMethodBeat.o(127496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbl
 * JD-Core Version:    0.7.0.1
 */