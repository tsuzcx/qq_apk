package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bvw
  extends dpc
{
  public int MbO;
  public LinkedList<dje> MbP;
  public int MbQ;
  public int MbR;
  public int MbS;
  public bzo MbT;
  public LinkedList<br> xME;
  public LinkedList<bzp> xMi;
  
  public bvw()
  {
    AppMethodBeat.i(152598);
    this.MbP = new LinkedList();
    this.xME = new LinkedList();
    this.xMi = new LinkedList();
    AppMethodBeat.o(152598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152599);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152599);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MbO);
      paramVarArgs.e(3, 8, this.MbP);
      paramVarArgs.aM(4, this.MbQ);
      paramVarArgs.aM(5, this.MbR);
      paramVarArgs.e(6, 8, this.xME);
      paramVarArgs.aM(7, this.MbS);
      paramVarArgs.e(8, 8, this.xMi);
      if (this.MbT != null)
      {
        paramVarArgs.ni(9, this.MbT.computeSize());
        this.MbT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1102;
      }
    }
    label1102:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MbO) + g.a.a.a.c(3, 8, this.MbP) + g.a.a.b.b.a.bu(4, this.MbQ) + g.a.a.b.b.a.bu(5, this.MbR) + g.a.a.a.c(6, 8, this.xME) + g.a.a.b.b.a.bu(7, this.MbS) + g.a.a.a.c(8, 8, this.xMi);
      paramInt = i;
      if (this.MbT != null) {
        paramInt = i + g.a.a.a.nh(9, this.MbT.computeSize());
      }
      AppMethodBeat.o(152599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MbP.clear();
        this.xME.clear();
        this.xMi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152599);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvw localbvw = (bvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152599);
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
            localbvw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 2: 
          localbvw.MbO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152599);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dje();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dje)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbvw.MbP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 4: 
          localbvw.MbQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152599);
          return 0;
        case 5: 
          localbvw.MbR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152599);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new br();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((br)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbvw.xME.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 7: 
          localbvw.MbS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152599);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbvw.xMi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bzo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbvw.MbT = ((bzo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      AppMethodBeat.o(152599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvw
 * JD-Core Version:    0.7.0.1
 */