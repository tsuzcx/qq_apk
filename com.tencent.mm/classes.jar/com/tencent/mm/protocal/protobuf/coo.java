package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class coo
  extends cvp
{
  public rs GyZ;
  public bon Gzb;
  public String HdQ;
  public String HdR;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72563);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72563);
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
      if (this.Gzb != null)
      {
        paramVarArgs.lC(4, this.Gzb.computeSize());
        this.Gzb.writeFields(paramVarArgs);
      }
      if (this.HdQ != null) {
        paramVarArgs.d(5, this.HdQ);
      }
      if (this.HdR != null) {
        paramVarArgs.d(6, this.HdR);
      }
      if (this.GyZ != null)
      {
        paramVarArgs.lC(7, this.GyZ.computeSize());
        this.GyZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.Gzb != null) {
        i = paramInt + f.a.a.a.lB(4, this.Gzb.computeSize());
      }
      paramInt = i;
      if (this.HdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HdQ);
      }
      i = paramInt;
      if (this.HdR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HdR);
      }
      paramInt = i;
      if (this.GyZ != null) {
        paramInt = i + f.a.a.a.lB(7, this.GyZ.computeSize());
      }
      AppMethodBeat.o(72563);
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
          AppMethodBeat.o(72563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coo localcoo = (coo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72563);
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
            localcoo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 2: 
          localcoo.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72563);
          return 0;
        case 3: 
          localcoo.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bon();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bon)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoo.Gzb = ((bon)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 5: 
          localcoo.HdQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 6: 
          localcoo.HdR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72563);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcoo.GyZ = ((rs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      AppMethodBeat.o(72563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coo
 * JD-Core Version:    0.7.0.1
 */