package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgq
  extends cld
{
  public cgn Ece;
  public int Ecs;
  public int Ect;
  public String Ecu;
  public String pfl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ece == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.Ece != null)
      {
        paramVarArgs.kX(1, this.Ece.computeSize());
        this.Ece.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Ecs);
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pfl != null) {
        paramVarArgs.d(4, this.pfl);
      }
      paramVarArgs.aR(5, this.Ect);
      if (this.Ecu != null) {
        paramVarArgs.d(6, this.Ecu);
      }
      AppMethodBeat.o(32404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ece == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.kW(1, this.Ece.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Ecs);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.kW(3, this.BaseResponse.computeSize());
      }
      i = paramInt;
      if (this.pfl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pfl);
      }
      i += f.a.a.b.b.a.bA(5, this.Ect);
      paramInt = i;
      if (this.Ecu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ecu);
      }
      AppMethodBeat.o(32404);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Ece == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgq localcgq = (cgq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32404);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgq.Ece = ((cgn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 2: 
          localcgq.Ecs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32404);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 4: 
          localcgq.pfl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32404);
          return 0;
        case 5: 
          localcgq.Ect = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32404);
          return 0;
        }
        localcgq.Ecu = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32404);
        return 0;
      }
      AppMethodBeat.o(32404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgq
 * JD-Core Version:    0.7.0.1
 */