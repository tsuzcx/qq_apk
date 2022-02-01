package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dry
  extends dpc
{
  public SKBuiltinBuffer_t LUY;
  public long LVb;
  public String MUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104835);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.MUB == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchResult");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MUB != null) {
        paramVarArgs.e(2, this.MUB);
      }
      if (this.LUY != null)
      {
        paramVarArgs.ni(3, this.LUY.computeSize());
        this.LUY.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(4, this.LVb);
      AppMethodBeat.o(104835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label666;
      }
    }
    label666:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MUB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MUB);
      }
      i = paramInt;
      if (this.LUY != null) {
        i = paramInt + g.a.a.a.nh(3, this.LUY.computeSize());
      }
      paramInt = g.a.a.b.b.a.r(4, this.LVb);
      AppMethodBeat.o(104835);
      return i + paramInt;
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
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        if (this.MUB == null)
        {
          paramVarArgs = new b("Not all required fields were included: SearchResult");
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dry localdry = (dry)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104835);
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
            localdry.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        case 2: 
          localdry.MUB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104835);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdry.LUY = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        }
        localdry.LVb = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(104835);
        return 0;
      }
      AppMethodBeat.o(104835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dry
 * JD-Core Version:    0.7.0.1
 */