package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ahu
  extends dpc
{
  public int BsF;
  public int BsG;
  public int BsH;
  public SKBuiltinBuffer_t BsI;
  public String UserName;
  public String jfi;
  public String jfl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9591);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.jfl != null) {
        paramVarArgs.e(3, this.jfl);
      }
      if (this.UserName != null) {
        paramVarArgs.e(4, this.UserName);
      }
      paramVarArgs.aM(5, this.BsF);
      paramVarArgs.aM(6, this.BsG);
      paramVarArgs.aM(7, this.BsH);
      if (this.BsI != null)
      {
        paramVarArgs.ni(8, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(9591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label892;
      }
    }
    label892:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.jfl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.jfl);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.UserName);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.BsF) + g.a.a.b.b.a.bu(6, this.BsG) + g.a.a.b.b.a.bu(7, this.BsH);
      paramInt = i;
      if (this.BsI != null) {
        paramInt = i + g.a.a.a.nh(8, this.BsI.computeSize());
      }
      AppMethodBeat.o(9591);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ahu localahu = (ahu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9591);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localahu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9591);
          return 0;
        case 2: 
          localahu.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 3: 
          localahu.jfl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 4: 
          localahu.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 5: 
          localahu.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9591);
          return 0;
        case 6: 
          localahu.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9591);
          return 0;
        case 7: 
          localahu.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9591);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahu.BsI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      AppMethodBeat.o(9591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahu
 * JD-Core Version:    0.7.0.1
 */