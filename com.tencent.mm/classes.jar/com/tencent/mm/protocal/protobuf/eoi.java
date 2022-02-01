package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eoi
  extends dpc
{
  public int Brl;
  public long Brn;
  public int CreateTime;
  public String KIz;
  public int KUy;
  public int KXq;
  public int KZk;
  public int LbO;
  public int LrF;
  public int jeU;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148662);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148662);
        throw paramVarArgs;
      }
      if (this.xNH != null) {
        paramVarArgs.e(1, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(2, this.xNG);
      }
      paramVarArgs.aM(3, this.KZk);
      paramVarArgs.aM(4, this.KUy);
      paramVarArgs.aM(5, this.CreateTime);
      if (this.KIz != null) {
        paramVarArgs.e(6, this.KIz);
      }
      paramVarArgs.aM(7, this.Brl);
      paramVarArgs.aM(8, this.KXq);
      paramVarArgs.aM(9, this.jeU);
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(10, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.LrF);
      paramVarArgs.bb(12, this.Brn);
      paramVarArgs.aM(13, this.LbO);
      AppMethodBeat.o(148662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNH == null) {
        break label946;
      }
    }
    label946:
    for (paramInt = g.a.a.b.b.a.f(1, this.xNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xNG);
      }
      i = i + g.a.a.b.b.a.bu(3, this.KZk) + g.a.a.b.b.a.bu(4, this.KUy) + g.a.a.b.b.a.bu(5, this.CreateTime);
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KIz);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.Brl) + g.a.a.b.b.a.bu(8, this.KXq) + g.a.a.b.b.a.bu(9, this.jeU);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + g.a.a.a.nh(10, this.BaseResponse.computeSize());
      }
      i = g.a.a.b.b.a.bu(11, this.LrF);
      int j = g.a.a.b.b.a.r(12, this.Brn);
      int k = g.a.a.b.b.a.bu(13, this.LbO);
      AppMethodBeat.o(148662);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(148662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eoi localeoi = (eoi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148662);
          return -1;
        case 1: 
          localeoi.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 2: 
          localeoi.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 3: 
          localeoi.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148662);
          return 0;
        case 4: 
          localeoi.KUy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148662);
          return 0;
        case 5: 
          localeoi.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148662);
          return 0;
        case 6: 
          localeoi.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 7: 
          localeoi.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148662);
          return 0;
        case 8: 
          localeoi.KXq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148662);
          return 0;
        case 9: 
          localeoi.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148662);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeoi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148662);
          return 0;
        case 11: 
          localeoi.LrF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148662);
          return 0;
        case 12: 
          localeoi.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(148662);
          return 0;
        }
        localeoi.LbO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148662);
        return 0;
      }
      AppMethodBeat.o(148662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoi
 * JD-Core Version:    0.7.0.1
 */