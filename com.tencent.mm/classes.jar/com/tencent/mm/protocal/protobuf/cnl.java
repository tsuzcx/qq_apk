package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnl
  extends cvp
{
  public String Cyu;
  public String FpY;
  public String HgE;
  public int dCC;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91637);
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
      if (this.HgE != null) {
        paramVarArgs.d(4, this.HgE);
      }
      if (this.FpY != null) {
        paramVarArgs.d(5, this.FpY);
      }
      paramVarArgs.aS(6, this.dCC);
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.HgE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HgE);
      }
      paramInt = i;
      if (this.FpY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FpY);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.dCC);
      paramInt = i;
      if (this.Cyu != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91637);
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
          AppMethodBeat.o(91637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91637);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnl localcnl = (cnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91637);
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
            localcnl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91637);
          return 0;
        case 2: 
          localcnl.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91637);
          return 0;
        case 3: 
          localcnl.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 4: 
          localcnl.HgE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 5: 
          localcnl.FpY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 6: 
          localcnl.dCC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91637);
          return 0;
        }
        localcnl.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91637);
        return 0;
      }
      AppMethodBeat.o(91637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnl
 * JD-Core Version:    0.7.0.1
 */