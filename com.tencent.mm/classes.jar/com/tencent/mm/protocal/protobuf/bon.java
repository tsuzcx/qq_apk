package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bon
  extends dpc
{
  public String LWH;
  public String LWI;
  public String xuc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32242);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32242);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LWH != null) {
        paramVarArgs.e(2, this.LWH);
      }
      if (this.LWI != null) {
        paramVarArgs.e(3, this.LWI);
      }
      if (this.xuc != null) {
        paramVarArgs.e(4, this.xuc);
      }
      AppMethodBeat.o(32242);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label552;
      }
    }
    label552:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LWH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LWH);
      }
      i = paramInt;
      if (this.LWI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LWI);
      }
      paramInt = i;
      if (this.xuc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xuc);
      }
      AppMethodBeat.o(32242);
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
          AppMethodBeat.o(32242);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32242);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bon localbon = (bon)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32242);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbon.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32242);
          return 0;
        case 2: 
          localbon.LWH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32242);
          return 0;
        case 3: 
          localbon.LWI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32242);
          return 0;
        }
        localbon.xuc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32242);
        return 0;
      }
      AppMethodBeat.o(32242);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bon
 * JD-Core Version:    0.7.0.1
 */