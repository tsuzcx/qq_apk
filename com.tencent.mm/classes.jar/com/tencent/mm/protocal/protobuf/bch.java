package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bch
  extends cvp
{
  public int GyU;
  public int GyV;
  public LinkedList<bru> GyW;
  public String GyX;
  
  public bch()
  {
    AppMethodBeat.i(210600);
    this.GyW = new LinkedList();
    AppMethodBeat.o(210600);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210601);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(210601);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GyU);
      paramVarArgs.aS(3, this.GyV);
      paramVarArgs.e(4, 8, this.GyW);
      if (this.GyX != null) {
        paramVarArgs.d(5, this.GyX);
      }
      AppMethodBeat.o(210601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GyU) + f.a.a.b.b.a.bz(3, this.GyV) + f.a.a.a.c(4, 8, this.GyW);
      paramInt = i;
      if (this.GyX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GyX);
      }
      AppMethodBeat.o(210601);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GyW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(210601);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bch localbch = (bch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210601);
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
            localbch.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210601);
          return 0;
        case 2: 
          localbch.GyU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210601);
          return 0;
        case 3: 
          localbch.GyV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210601);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bru();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbch.GyW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210601);
          return 0;
        }
        localbch.GyX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(210601);
        return 0;
      }
      AppMethodBeat.o(210601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bch
 * JD-Core Version:    0.7.0.1
 */