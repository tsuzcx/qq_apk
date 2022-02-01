package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class coq
  extends cvp
{
  public String Cyu;
  public int Hhv;
  public String Hhw;
  public String Hhx;
  public bmw Hhy;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91642);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91642);
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
      paramVarArgs.aS(4, this.Hhv);
      if (this.Hhw != null) {
        paramVarArgs.d(5, this.Hhw);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(6, this.Hhx);
      }
      if (this.Hhy != null)
      {
        paramVarArgs.lC(7, this.Hhy.computeSize());
        this.Hhy.writeFields(paramVarArgs);
      }
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Hhv);
      paramInt = i;
      if (this.Hhw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hhw);
      }
      i = paramInt;
      if (this.Hhx != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hhx);
      }
      paramInt = i;
      if (this.Hhy != null) {
        paramInt = i + f.a.a.a.lB(7, this.Hhy.computeSize());
      }
      i = paramInt;
      if (this.Cyu != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91642);
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
          AppMethodBeat.o(91642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coq localcoq = (coq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91642);
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
            localcoq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        case 2: 
          localcoq.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91642);
          return 0;
        case 3: 
          localcoq.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 4: 
          localcoq.Hhv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91642);
          return 0;
        case 5: 
          localcoq.Hhw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 6: 
          localcoq.Hhx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoq.Hhy = ((bmw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        }
        localcoq.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91642);
        return 0;
      }
      AppMethodBeat.o(91642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coq
 * JD-Core Version:    0.7.0.1
 */