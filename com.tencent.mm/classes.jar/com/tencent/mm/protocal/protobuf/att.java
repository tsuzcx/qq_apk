package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class att
  extends cld
{
  public String DtA;
  public int DtK;
  public String bLg;
  public int fWw;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(108146);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ret);
      if (this.bLg != null) {
        paramVarArgs.d(3, this.bLg);
      }
      if (this.DtA != null) {
        paramVarArgs.d(4, this.DtA);
      }
      paramVarArgs.aR(5, this.DtK);
      paramVarArgs.aR(6, this.fWw);
      AppMethodBeat.o(108146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ret);
      paramInt = i;
      if (this.bLg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.bLg);
      }
      i = paramInt;
      if (this.DtA != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DtA);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.DtK);
      int j = f.a.a.b.b.a.bA(6, this.fWw);
      AppMethodBeat.o(108146);
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
          AppMethodBeat.o(108146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(108146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        att localatt = (att)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(108146);
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
            localatt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108146);
          return 0;
        case 2: 
          localatt.ret = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(108146);
          return 0;
        case 3: 
          localatt.bLg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108146);
          return 0;
        case 4: 
          localatt.DtA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108146);
          return 0;
        case 5: 
          localatt.DtK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(108146);
          return 0;
        }
        localatt.fWw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(108146);
        return 0;
      }
      AppMethodBeat.o(108146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.att
 * JD-Core Version:    0.7.0.1
 */