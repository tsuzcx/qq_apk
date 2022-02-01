package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import g.a.a.b;
import java.util.LinkedList;

public final class rk
  extends dpc
{
  public c Iah;
  public long Iaj;
  public long KYQ;
  public LinkedList<String> KYR;
  public int KYS;
  public int KYT;
  public String KYU;
  public String KYV;
  public String KYW;
  public boolean KYX;
  public int pTZ;
  public String pUa;
  
  public rk()
  {
    AppMethodBeat.i(91377);
    this.KYR = new LinkedList();
    AppMethodBeat.o(91377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91378);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91378);
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
      paramVarArgs.bb(4, this.Iaj);
      if (this.Iah != null)
      {
        paramVarArgs.ni(5, this.Iah.computeSize());
        this.Iah.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.KYQ);
      paramVarArgs.e(7, 1, this.KYR);
      paramVarArgs.aM(8, this.KYS);
      paramVarArgs.aM(9, this.KYT);
      if (this.KYU != null) {
        paramVarArgs.e(10, this.KYU);
      }
      if (this.KYV != null) {
        paramVarArgs.e(11, this.KYV);
      }
      if (this.KYW != null) {
        paramVarArgs.e(12, this.KYW);
      }
      paramVarArgs.cc(13, this.KYX);
      AppMethodBeat.o(91378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.Iaj);
      paramInt = i;
      if (this.Iah != null) {
        paramInt = i + g.a.a.a.nh(5, this.Iah.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.KYQ) + g.a.a.a.c(7, 1, this.KYR) + g.a.a.b.b.a.bu(8, this.KYS) + g.a.a.b.b.a.bu(9, this.KYT);
      paramInt = i;
      if (this.KYU != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KYU);
      }
      i = paramInt;
      if (this.KYV != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.KYV);
      }
      paramInt = i;
      if (this.KYW != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KYW);
      }
      i = g.a.a.b.b.a.fS(13);
      AppMethodBeat.o(91378);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KYR.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rk localrk = (rk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91378);
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
            localrk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 2: 
          localrk.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91378);
          return 0;
        case 3: 
          localrk.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 4: 
          localrk.Iaj = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91378);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrk.Iah = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 6: 
          localrk.KYQ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91378);
          return 0;
        case 7: 
          localrk.KYR.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91378);
          return 0;
        case 8: 
          localrk.KYS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91378);
          return 0;
        case 9: 
          localrk.KYT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91378);
          return 0;
        case 10: 
          localrk.KYU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 11: 
          localrk.KYV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 12: 
          localrk.KYW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91378);
          return 0;
        }
        localrk.KYX = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(91378);
        return 0;
      }
      AppMethodBeat.o(91378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rk
 * JD-Core Version:    0.7.0.1
 */