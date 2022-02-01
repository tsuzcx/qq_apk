package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czo
  extends cld
{
  public int CEu;
  public String CEv;
  public String Erq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91701);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91701);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Erq != null) {
        paramVarArgs.d(2, this.Erq);
      }
      paramVarArgs.aR(3, this.CEu);
      if (this.CEv != null) {
        paramVarArgs.d(4, this.CEv);
      }
      AppMethodBeat.o(91701);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Erq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Erq);
      }
      i += f.a.a.b.b.a.bA(3, this.CEu);
      paramInt = i;
      if (this.CEv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CEv);
      }
      AppMethodBeat.o(91701);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91701);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91701);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czo localczo = (czo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91701);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91701);
          return 0;
        case 2: 
          localczo.Erq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91701);
          return 0;
        case 3: 
          localczo.CEu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91701);
          return 0;
        }
        localczo.CEv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91701);
        return 0;
      }
      AppMethodBeat.o(91701);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czo
 * JD-Core Version:    0.7.0.1
 */