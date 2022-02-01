package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nu
  extends ckq
{
  public String CLu;
  public int CLv;
  public com.tencent.mm.bx.b CLw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191091);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLu == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: main_brand_user_name");
        AppMethodBeat.o(191091);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CLu != null) {
        paramVarArgs.d(2, this.CLu);
      }
      paramVarArgs.aR(3, this.CLv);
      if (this.CLw != null) {
        paramVarArgs.c(4, this.CLw);
      }
      AppMethodBeat.o(191091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CLu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CLu);
      }
      i += f.a.a.b.b.a.bA(3, this.CLv);
      paramInt = i;
      if (this.CLw != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.CLw);
      }
      AppMethodBeat.o(191091);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CLu == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: main_brand_user_name");
          AppMethodBeat.o(191091);
          throw paramVarArgs;
        }
        AppMethodBeat.o(191091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nu localnu = (nu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(191091);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(191091);
          return 0;
        case 2: 
          localnu.CLu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(191091);
          return 0;
        case 3: 
          localnu.CLv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(191091);
          return 0;
        }
        localnu.CLw = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(191091);
        return 0;
      }
      AppMethodBeat.o(191091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nu
 * JD-Core Version:    0.7.0.1
 */