package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbh
  extends cvp
{
  public String CYX;
  public int Gyr;
  public String Gys;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213197);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(213197);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.aS(4, this.Gyr);
      if (this.Gys != null) {
        paramVarArgs.d(5, this.Gys);
      }
      if (this.CYX != null) {
        paramVarArgs.d(6, this.CYX);
      }
      AppMethodBeat.o(213197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Gyr);
      paramInt = i;
      if (this.Gys != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gys);
      }
      i = paramInt;
      if (this.CYX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CYX);
      }
      AppMethodBeat.o(213197);
      return i;
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
          AppMethodBeat.o(213197);
          throw paramVarArgs;
        }
        AppMethodBeat.o(213197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbh localbbh = (bbh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(213197);
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
            localbbh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(213197);
          return 0;
        case 2: 
          localbbh.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(213197);
          return 0;
        case 3: 
          localbbh.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(213197);
          return 0;
        case 4: 
          localbbh.Gyr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(213197);
          return 0;
        case 5: 
          localbbh.Gys = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(213197);
          return 0;
        }
        localbbh.CYX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(213197);
        return 0;
      }
      AppMethodBeat.o(213197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbh
 * JD-Core Version:    0.7.0.1
 */