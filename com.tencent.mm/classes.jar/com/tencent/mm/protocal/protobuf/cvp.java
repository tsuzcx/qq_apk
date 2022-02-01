package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cvp
  extends dpc
{
  public String KPw;
  public ddb KPx;
  public cxc KPy;
  public String MAO;
  public String MAW;
  public cdf MAY;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72531);
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
      if (this.KPw != null) {
        paramVarArgs.e(5, this.KPw);
      }
      if (this.MAW != null) {
        paramVarArgs.e(6, this.MAW);
      }
      if (this.KPx != null)
      {
        paramVarArgs.ni(7, this.KPx.computeSize());
        this.KPx.writeFields(paramVarArgs);
      }
      if (this.KPy != null)
      {
        paramVarArgs.ni(8, this.KPy.computeSize());
        this.KPy.writeFields(paramVarArgs);
      }
      if (this.MAY != null)
      {
        paramVarArgs.ni(9, this.MAY.computeSize());
        this.MAY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
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
      if (this.KPw != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KPw);
      }
      i = paramInt;
      if (this.MAW != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MAW);
      }
      paramInt = i;
      if (this.KPx != null) {
        paramInt = i + g.a.a.a.nh(7, this.KPx.computeSize());
      }
      i = paramInt;
      if (this.KPy != null) {
        i = paramInt + g.a.a.a.nh(8, this.KPy.computeSize());
      }
      paramInt = i;
      if (this.MAY != null) {
        paramInt = i + g.a.a.a.nh(9, this.MAY.computeSize());
      }
      AppMethodBeat.o(72531);
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
          AppMethodBeat.o(72531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvp localcvp = (cvp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72531);
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
            localcvp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 2: 
          localcvp.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72531);
          return 0;
        case 3: 
          localcvp.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 4: 
          localcvp.MAO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 5: 
          localcvp.KPw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 6: 
          localcvp.MAW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcvp.KPx = ((ddb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcvp.KPy = ((cxc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcvp.MAY = ((cdf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      AppMethodBeat.o(72531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvp
 * JD-Core Version:    0.7.0.1
 */