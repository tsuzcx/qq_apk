package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dqt
  extends dpc
{
  public String MTC;
  public int dDN;
  public int pTI;
  public String qwn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91680);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91680);
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
      paramVarArgs.aM(4, this.pTI);
      if (this.MTC != null) {
        paramVarArgs.e(5, this.MTC);
      }
      AppMethodBeat.o(91680);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.pTI);
      paramInt = i;
      if (this.MTC != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MTC);
      }
      AppMethodBeat.o(91680);
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
          AppMethodBeat.o(91680);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91680);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dqt localdqt = (dqt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91680);
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
            localdqt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91680);
          return 0;
        case 2: 
          localdqt.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91680);
          return 0;
        case 3: 
          localdqt.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91680);
          return 0;
        case 4: 
          localdqt.pTI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91680);
          return 0;
        }
        localdqt.MTC = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91680);
        return 0;
      }
      AppMethodBeat.o(91680);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqt
 * JD-Core Version:    0.7.0.1
 */