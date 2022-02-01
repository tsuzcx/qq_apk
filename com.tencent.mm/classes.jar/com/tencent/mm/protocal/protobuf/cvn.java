package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cvn
  extends dpc
{
  public String KPv;
  public ddb KPx;
  public String MAO;
  public boolean MAQ;
  public boolean MAR;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72529);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72529);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.MAO != null) {
        paramVarArgs.e(4, this.MAO);
      }
      if (this.KPv != null) {
        paramVarArgs.e(7, this.KPv);
      }
      if (this.KPx != null)
      {
        paramVarArgs.ni(8, this.KPx.computeSize());
        this.KPx.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(9, this.MAQ);
      paramVarArgs.cc(10, this.MAR);
      AppMethodBeat.o(72529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.MAO != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MAO);
      }
      paramInt = i;
      if (this.KPv != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KPv);
      }
      i = paramInt;
      if (this.KPx != null) {
        i = paramInt + g.a.a.a.nh(8, this.KPx.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(9);
      int j = g.a.a.b.b.a.fS(10);
      AppMethodBeat.o(72529);
      return i + (paramInt + 1) + (j + 1);
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
          AppMethodBeat.o(72529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvn localcvn = (cvn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(72529);
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
            localcvn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 2: 
          localcvn.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72529);
          return 0;
        case 3: 
          localcvn.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 4: 
          localcvn.MAO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 7: 
          localcvn.KPv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcvn.KPx = ((ddb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 9: 
          localcvn.MAQ = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72529);
          return 0;
        }
        localcvn.MAR = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(72529);
        return 0;
      }
      AppMethodBeat.o(72529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvn
 * JD-Core Version:    0.7.0.1
 */