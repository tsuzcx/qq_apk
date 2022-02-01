package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class edr
  extends dpc
{
  public int KCC;
  public String MZg;
  public int NaG;
  public long NdN;
  public int NdX;
  public LinkedList<edp> NdY;
  
  public edr()
  {
    AppMethodBeat.i(118450);
    this.NdY = new LinkedList();
    AppMethodBeat.o(118450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MZg != null) {
        paramVarArgs.e(2, this.MZg);
      }
      paramVarArgs.aM(3, this.NdX);
      paramVarArgs.e(4, 8, this.NdY);
      paramVarArgs.aM(5, this.NaG);
      paramVarArgs.bb(6, this.NdN);
      paramVarArgs.aM(7, this.KCC);
      AppMethodBeat.o(118451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MZg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MZg);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.NdX);
      int j = g.a.a.a.c(4, 8, this.NdY);
      int k = g.a.a.b.b.a.bu(5, this.NaG);
      int m = g.a.a.b.b.a.r(6, this.NdN);
      int n = g.a.a.b.b.a.bu(7, this.KCC);
      AppMethodBeat.o(118451);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NdY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        edr localedr = (edr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118451);
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
            localedr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 2: 
          localedr.MZg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118451);
          return 0;
        case 3: 
          localedr.NdX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118451);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localedr.NdY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 5: 
          localedr.NaG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118451);
          return 0;
        case 6: 
          localedr.NdN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(118451);
          return 0;
        }
        localedr.KCC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118451);
        return 0;
      }
      AppMethodBeat.o(118451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edr
 * JD-Core Version:    0.7.0.1
 */