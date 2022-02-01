package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class een
  extends dpc
{
  public int KCC;
  public String MZg;
  public int NaG;
  public long NdN;
  public int NeH;
  public LinkedList<eea> NeI;
  public int NeJ;
  public int NeK;
  
  public een()
  {
    AppMethodBeat.i(118477);
    this.NeI = new LinkedList();
    AppMethodBeat.o(118477);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118478);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118478);
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
      paramVarArgs.aM(3, this.NeH);
      paramVarArgs.e(4, 8, this.NeI);
      paramVarArgs.aM(5, this.NeJ);
      paramVarArgs.aM(6, this.NeK);
      paramVarArgs.aM(7, this.NaG);
      paramVarArgs.bb(8, this.NdN);
      paramVarArgs.aM(9, this.KCC);
      AppMethodBeat.o(118478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MZg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MZg);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.NeH);
      int j = g.a.a.a.c(4, 8, this.NeI);
      int k = g.a.a.b.b.a.bu(5, this.NeJ);
      int m = g.a.a.b.b.a.bu(6, this.NeK);
      int n = g.a.a.b.b.a.bu(7, this.NaG);
      int i1 = g.a.a.b.b.a.r(8, this.NdN);
      int i2 = g.a.a.b.b.a.bu(9, this.KCC);
      AppMethodBeat.o(118478);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NeI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118478);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        een localeen = (een)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118478);
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
            localeen.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 2: 
          localeen.MZg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118478);
          return 0;
        case 3: 
          localeen.NeH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118478);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eea();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eea)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeen.NeI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 5: 
          localeen.NeJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118478);
          return 0;
        case 6: 
          localeen.NeK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118478);
          return 0;
        case 7: 
          localeen.NaG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118478);
          return 0;
        case 8: 
          localeen.NdN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(118478);
          return 0;
        }
        localeen.KCC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118478);
        return 0;
      }
      AppMethodBeat.o(118478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.een
 * JD-Core Version:    0.7.0.1
 */