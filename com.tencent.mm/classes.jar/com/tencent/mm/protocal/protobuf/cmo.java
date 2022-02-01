package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cmo
  extends dpc
{
  public String pRK;
  public int pRL;
  public String pRM;
  public String pTY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114045);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114045);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pRK != null) {
        paramVarArgs.e(2, this.pRK);
      }
      paramVarArgs.aM(3, this.pRL);
      if (this.pRM != null) {
        paramVarArgs.e(4, this.pRM);
      }
      if (this.pTY != null) {
        paramVarArgs.e(5, this.pTY);
      }
      AppMethodBeat.o(114045);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pRK != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pRK);
      }
      i += g.a.a.b.b.a.bu(3, this.pRL);
      paramInt = i;
      if (this.pRM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pRM);
      }
      i = paramInt;
      if (this.pTY != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.pTY);
      }
      AppMethodBeat.o(114045);
      return i;
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
          AppMethodBeat.o(114045);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114045);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cmo localcmo = (cmo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114045);
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
            localcmo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114045);
          return 0;
        case 2: 
          localcmo.pRK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114045);
          return 0;
        case 3: 
          localcmo.pRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114045);
          return 0;
        case 4: 
          localcmo.pRM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114045);
          return 0;
        }
        localcmo.pTY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114045);
        return 0;
      }
      AppMethodBeat.o(114045);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmo
 * JD-Core Version:    0.7.0.1
 */