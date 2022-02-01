package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class btp
  extends cvp
{
  public int GOh;
  public int GOi;
  public int GOj;
  public int GwU;
  public LinkedList<btk> GwV;
  public int zib;
  
  public btp()
  {
    AppMethodBeat.i(89927);
    this.GwV = new LinkedList();
    AppMethodBeat.o(89927);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89928);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89928);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GwU);
      paramVarArgs.e(3, 8, this.GwV);
      paramVarArgs.aS(4, this.zib);
      paramVarArgs.aS(5, this.GOh);
      paramVarArgs.aS(6, this.GOi);
      paramVarArgs.aS(7, this.GOj);
      AppMethodBeat.o(89928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GwU);
      int j = f.a.a.a.c(3, 8, this.GwV);
      int k = f.a.a.b.b.a.bz(4, this.zib);
      int m = f.a.a.b.b.a.bz(5, this.GOh);
      int n = f.a.a.b.b.a.bz(6, this.GOi);
      int i1 = f.a.a.b.b.a.bz(7, this.GOj);
      AppMethodBeat.o(89928);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GwV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89928);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btp localbtp = (btp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89928);
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
            localbtp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 2: 
          localbtp.GwU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89928);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtp.GwV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 4: 
          localbtp.zib = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89928);
          return 0;
        case 5: 
          localbtp.GOh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89928);
          return 0;
        case 6: 
          localbtp.GOi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89928);
          return 0;
        }
        localbtp.GOj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(89928);
        return 0;
      }
      AppMethodBeat.o(89928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btp
 * JD-Core Version:    0.7.0.1
 */