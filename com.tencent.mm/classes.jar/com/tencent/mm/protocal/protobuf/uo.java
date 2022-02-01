package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uo
  extends cvp
{
  public int FNY;
  public com.tencent.mm.bx.b FUa;
  public int FUb;
  public int dlw;
  public String paA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91409);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.FUa != null) {
        paramVarArgs.c(4, this.FUa);
      }
      paramVarArgs.aS(5, this.FNY);
      paramVarArgs.aS(6, this.FUb);
      AppMethodBeat.o(91409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.FUa != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.FUa);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.FNY);
      int j = f.a.a.b.b.a.bz(6, this.FUb);
      AppMethodBeat.o(91409);
      return i + paramInt + j;
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91409);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uo localuo = (uo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91409);
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
            localuo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91409);
          return 0;
        case 2: 
          localuo.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91409);
          return 0;
        case 3: 
          localuo.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91409);
          return 0;
        case 4: 
          localuo.FUa = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91409);
          return 0;
        case 5: 
          localuo.FNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91409);
          return 0;
        }
        localuo.FUb = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91409);
        return 0;
      }
      AppMethodBeat.o(91409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uo
 * JD-Core Version:    0.7.0.1
 */