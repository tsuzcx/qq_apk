package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ars
  extends cld
{
  public String DrT;
  public rr DrU;
  public int DrV;
  public con DrW;
  public String ntw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114023);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114023);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ntw != null) {
        paramVarArgs.d(2, this.ntw);
      }
      if (this.DrT != null) {
        paramVarArgs.d(3, this.DrT);
      }
      if (this.DrU != null)
      {
        paramVarArgs.kX(4, this.DrU.computeSize());
        this.DrU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.DrV);
      if (this.DrW != null)
      {
        paramVarArgs.kX(6, this.DrW.computeSize());
        this.DrW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ntw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ntw);
      }
      i = paramInt;
      if (this.DrT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DrT);
      }
      paramInt = i;
      if (this.DrU != null) {
        paramInt = i + f.a.a.a.kW(4, this.DrU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DrV);
      paramInt = i;
      if (this.DrW != null) {
        paramInt = i + f.a.a.a.kW(6, this.DrW.computeSize());
      }
      AppMethodBeat.o(114023);
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
          AppMethodBeat.o(114023);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ars localars = (ars)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114023);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 2: 
          localars.ntw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 3: 
          localars.DrT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.DrU = ((rr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 5: 
          localars.DrV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114023);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new con();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((con)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localars.DrW = ((con)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      AppMethodBeat.o(114023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ars
 * JD-Core Version:    0.7.0.1
 */