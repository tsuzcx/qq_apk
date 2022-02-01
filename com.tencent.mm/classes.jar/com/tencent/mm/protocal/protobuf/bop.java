package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bop
  extends dpc
{
  public long LWJ;
  public String LWK;
  public String LWL;
  public abq LWM;
  public djt LWN;
  public String LWO;
  public boolean LWP = true;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214302);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(214302);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.LWJ);
      if (this.LWK != null) {
        paramVarArgs.e(3, this.LWK);
      }
      if (this.LWL != null) {
        paramVarArgs.e(4, this.LWL);
      }
      if (this.LWM != null)
      {
        paramVarArgs.ni(5, this.LWM.computeSize());
        this.LWM.writeFields(paramVarArgs);
      }
      if (this.LWN != null)
      {
        paramVarArgs.ni(6, this.LWN.computeSize());
        this.LWN.writeFields(paramVarArgs);
      }
      if (this.LWO != null) {
        paramVarArgs.e(7, this.LWO);
      }
      paramVarArgs.cc(8, this.LWP);
      AppMethodBeat.o(214302);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LWJ);
      paramInt = i;
      if (this.LWK != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LWK);
      }
      i = paramInt;
      if (this.LWL != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LWL);
      }
      paramInt = i;
      if (this.LWM != null) {
        paramInt = i + g.a.a.a.nh(5, this.LWM.computeSize());
      }
      i = paramInt;
      if (this.LWN != null) {
        i = paramInt + g.a.a.a.nh(6, this.LWN.computeSize());
      }
      paramInt = i;
      if (this.LWO != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LWO);
      }
      i = g.a.a.b.b.a.fS(8);
      AppMethodBeat.o(214302);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(214302);
          throw paramVarArgs;
        }
        AppMethodBeat.o(214302);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bop localbop = (bop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214302);
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
            localbop.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214302);
          return 0;
        case 2: 
          localbop.LWJ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214302);
          return 0;
        case 3: 
          localbop.LWK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214302);
          return 0;
        case 4: 
          localbop.LWL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214302);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbop.LWM = ((abq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214302);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbop.LWN = ((djt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214302);
          return 0;
        case 7: 
          localbop.LWO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214302);
          return 0;
        }
        localbop.LWP = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(214302);
        return 0;
      }
      AppMethodBeat.o(214302);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bop
 * JD-Core Version:    0.7.0.1
 */