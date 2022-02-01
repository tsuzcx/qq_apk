package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blu
  extends dpc
{
  public LinkedList<Integer> LRr;
  public int LUB;
  public LinkedList<cpl> LUC;
  public LinkedList<eqf> LUD;
  public LinkedList<dtv> LUE;
  
  public blu()
  {
    AppMethodBeat.i(32234);
    this.LUC = new LinkedList();
    this.LRr = new LinkedList();
    this.LUD = new LinkedList();
    this.LUE = new LinkedList();
    AppMethodBeat.o(32234);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32235);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32235);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LUB);
      paramVarArgs.e(3, 8, this.LUC);
      paramVarArgs.f(4, 2, this.LRr);
      paramVarArgs.e(5, 8, this.LUD);
      paramVarArgs.e(6, 8, this.LUE);
      AppMethodBeat.o(32235);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label917;
      }
    }
    label917:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LUB);
      int j = g.a.a.a.c(3, 8, this.LUC);
      int k = g.a.a.a.d(4, 2, this.LRr);
      int m = g.a.a.a.c(5, 8, this.LUD);
      int n = g.a.a.a.c(6, 8, this.LUE);
      AppMethodBeat.o(32235);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LUC.clear();
        this.LRr.clear();
        this.LUD.clear();
        this.LUE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32235);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32235);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        blu localblu = (blu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32235);
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
            localblu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        case 2: 
          localblu.LUB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32235);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localblu.LUC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        case 4: 
          localblu.LRr = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(32235);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eqf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eqf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localblu.LUD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dtv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localblu.LUE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32235);
        return 0;
      }
      AppMethodBeat.o(32235);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blu
 * JD-Core Version:    0.7.0.1
 */