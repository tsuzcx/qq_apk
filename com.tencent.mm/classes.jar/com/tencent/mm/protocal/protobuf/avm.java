package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avm
  extends cvp
{
  public LinkedList<com.tencent.mm.bx.b> Guu;
  public int Guv;
  public LinkedList<Integer> Guw;
  public int Timestamp;
  
  public avm()
  {
    AppMethodBeat.i(153147);
    this.Guu = new LinkedList();
    this.Guw = new LinkedList();
    AppMethodBeat.o(153147);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153148);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153148);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 6, this.Guu);
      paramVarArgs.aS(3, this.Guv);
      paramVarArgs.aS(4, this.Timestamp);
      paramVarArgs.e(5, 2, this.Guw);
      AppMethodBeat.o(153148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label573;
      }
    }
    label573:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 6, this.Guu);
      int j = f.a.a.b.b.a.bz(3, this.Guv);
      int k = f.a.a.b.b.a.bz(4, this.Timestamp);
      int m = f.a.a.a.c(5, 2, this.Guw);
      AppMethodBeat.o(153148);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Guu.clear();
        this.Guw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avm localavm = (avm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153148);
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
            localavm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153148);
          return 0;
        case 2: 
          localavm.Guu.add(((f.a.a.a.a)localObject1).NPN.gxI());
          AppMethodBeat.o(153148);
          return 0;
        case 3: 
          localavm.Guv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153148);
          return 0;
        case 4: 
          localavm.Timestamp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153148);
          return 0;
        }
        localavm.Guw.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
        AppMethodBeat.o(153148);
        return 0;
      }
      AppMethodBeat.o(153148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avm
 * JD-Core Version:    0.7.0.1
 */