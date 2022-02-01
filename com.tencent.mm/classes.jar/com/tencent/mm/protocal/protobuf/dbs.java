package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dbs
  extends dpc
{
  public long Hth;
  public String Hti;
  public String Htk;
  public String Htl;
  public LinkedList<dbt> MGC;
  public jh MGD;
  public int MGE;
  public int pTZ;
  public String pUa;
  
  public dbs()
  {
    AppMethodBeat.i(91616);
    this.MGC = new LinkedList();
    AppMethodBeat.o(91616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91617);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91617);
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
      paramVarArgs.e(4, 8, this.MGC);
      paramVarArgs.bb(5, this.Hth);
      if (this.Hti != null) {
        paramVarArgs.e(6, this.Hti);
      }
      if (this.MGD != null)
      {
        paramVarArgs.ni(7, this.MGD.computeSize());
        this.MGD.writeFields(paramVarArgs);
      }
      if (this.Htk != null) {
        paramVarArgs.e(8, this.Htk);
      }
      if (this.Htl != null) {
        paramVarArgs.e(9, this.Htl);
      }
      paramVarArgs.aM(10, this.MGE);
      AppMethodBeat.o(91617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1034;
      }
    }
    label1034:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.MGC) + g.a.a.b.b.a.r(5, this.Hth);
      paramInt = i;
      if (this.Hti != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Hti);
      }
      i = paramInt;
      if (this.MGD != null) {
        i = paramInt + g.a.a.a.nh(7, this.MGD.computeSize());
      }
      paramInt = i;
      if (this.Htk != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Htk);
      }
      i = paramInt;
      if (this.Htl != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Htl);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.MGE);
      AppMethodBeat.o(91617);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MGC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbs localdbs = (dbs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91617);
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
            localdbs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 2: 
          localdbs.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91617);
          return 0;
        case 3: 
          localdbs.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbs.MGC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 5: 
          localdbs.Hth = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91617);
          return 0;
        case 6: 
          localdbs.Hti = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbs.MGD = ((jh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 8: 
          localdbs.Htk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 9: 
          localdbs.Htl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91617);
          return 0;
        }
        localdbs.MGE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91617);
        return 0;
      }
      AppMethodBeat.o(91617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbs
 * JD-Core Version:    0.7.0.1
 */