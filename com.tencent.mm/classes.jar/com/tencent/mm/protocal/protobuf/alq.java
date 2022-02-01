package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class alq
  extends dpc
{
  public cdh Lus;
  public int dDN;
  public String qwn;
  public String wFL;
  public String yQE;
  public String yXL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91457);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91457);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.yQE != null) {
        paramVarArgs.e(4, this.yQE);
      }
      if (this.wFL != null) {
        paramVarArgs.e(5, this.wFL);
      }
      if (this.yXL != null) {
        paramVarArgs.e(6, this.yXL);
      }
      if (this.Lus != null)
      {
        paramVarArgs.ni(7, this.Lus.computeSize());
        this.Lus.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91457);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.yQE != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.yQE);
      }
      paramInt = i;
      if (this.wFL != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.wFL);
      }
      i = paramInt;
      if (this.yXL != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.yXL);
      }
      paramInt = i;
      if (this.Lus != null) {
        paramInt = i + g.a.a.a.nh(7, this.Lus.computeSize());
      }
      AppMethodBeat.o(91457);
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
          AppMethodBeat.o(91457);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91457);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        alq localalq = (alq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91457);
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
            localalq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91457);
          return 0;
        case 2: 
          localalq.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91457);
          return 0;
        case 3: 
          localalq.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 4: 
          localalq.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 5: 
          localalq.wFL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 6: 
          localalq.yXL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91457);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localalq.Lus = ((cdh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91457);
        return 0;
      }
      AppMethodBeat.o(91457);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alq
 * JD-Core Version:    0.7.0.1
 */