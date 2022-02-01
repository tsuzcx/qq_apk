package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class crb
  extends cld
{
  public int CAr;
  public int EjO;
  public String fVC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32435);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fVC != null) {
        paramVarArgs.d(2, this.fVC);
      }
      paramVarArgs.aR(3, this.CAr);
      paramVarArgs.aR(4, this.EjO);
      AppMethodBeat.o(32435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fVC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fVC);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.CAr);
      int j = f.a.a.b.b.a.bA(4, this.EjO);
      AppMethodBeat.o(32435);
      return i + paramInt + j;
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
          AppMethodBeat.o(32435);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crb localcrb = (crb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32435);
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
            localcrb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32435);
          return 0;
        case 2: 
          localcrb.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32435);
          return 0;
        case 3: 
          localcrb.CAr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32435);
          return 0;
        }
        localcrb.EjO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32435);
        return 0;
      }
      AppMethodBeat.o(32435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crb
 * JD-Core Version:    0.7.0.1
 */