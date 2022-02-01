package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ah
  extends dpc
{
  public int KCD;
  public String KCE;
  public dyj KCF;
  public dmc KCG;
  public int KCN;
  public add KCR;
  public boolean KCS;
  public int KCT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32100);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32100);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KCD);
      if (this.KCE != null) {
        paramVarArgs.e(3, this.KCE);
      }
      if (this.KCF != null)
      {
        paramVarArgs.ni(4, this.KCF.computeSize());
        this.KCF.writeFields(paramVarArgs);
      }
      if (this.KCG != null)
      {
        paramVarArgs.ni(5, this.KCG.computeSize());
        this.KCG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.KCN);
      if (this.KCR != null)
      {
        paramVarArgs.ni(7, this.KCR.computeSize());
        this.KCR.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(8, this.KCS);
      paramVarArgs.aM(9, this.KCT);
      AppMethodBeat.o(32100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1081;
      }
    }
    label1081:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KCD);
      paramInt = i;
      if (this.KCE != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KCE);
      }
      i = paramInt;
      if (this.KCF != null) {
        i = paramInt + g.a.a.a.nh(4, this.KCF.computeSize());
      }
      paramInt = i;
      if (this.KCG != null) {
        paramInt = i + g.a.a.a.nh(5, this.KCG.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.KCN);
      paramInt = i;
      if (this.KCR != null) {
        paramInt = i + g.a.a.a.nh(7, this.KCR.computeSize());
      }
      i = g.a.a.b.b.a.fS(8);
      int j = g.a.a.b.b.a.bu(9, this.KCT);
      AppMethodBeat.o(32100);
      return paramInt + (i + 1) + j;
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
          AppMethodBeat.o(32100);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32100);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ah localah = (ah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32100);
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
            localah.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 2: 
          localah.KCD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32100);
          return 0;
        case 3: 
          localah.KCE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32100);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localah.KCF = ((dyj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localah.KCG = ((dmc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 6: 
          localah.KCN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32100);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new add();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((add)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localah.KCR = ((add)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 8: 
          localah.KCS = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32100);
          return 0;
        }
        localah.KCT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32100);
        return 0;
      }
      AppMethodBeat.o(32100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ah
 * JD-Core Version:    0.7.0.1
 */