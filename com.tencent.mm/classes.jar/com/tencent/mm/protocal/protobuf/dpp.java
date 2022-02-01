package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpp
  extends erp
{
  public int IJG;
  public int YFt;
  public LinkedList<dpr> YMT;
  public int aaWp;
  public LinkedList<dpo> aaWq;
  public int aaWr;
  public String aaWs;
  
  public dpp()
  {
    AppMethodBeat.i(127498);
    this.aaWq = new LinkedList();
    this.YMT = new LinkedList();
    AppMethodBeat.o(127498);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127499);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YFt);
      paramVarArgs.bS(3, this.aaWp);
      paramVarArgs.e(4, 8, this.aaWq);
      paramVarArgs.bS(5, this.aaWr);
      paramVarArgs.e(6, 8, this.YMT);
      if (this.aaWs != null) {
        paramVarArgs.g(7, this.aaWs);
      }
      paramVarArgs.bS(8, this.IJG);
      AppMethodBeat.o(127499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label756;
      }
    }
    label756:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YFt) + i.a.a.b.b.a.cJ(3, this.aaWp) + i.a.a.a.c(4, 8, this.aaWq) + i.a.a.b.b.a.cJ(5, this.aaWr) + i.a.a.a.c(6, 8, this.YMT);
      paramInt = i;
      if (this.aaWs != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaWs);
      }
      i = i.a.a.b.b.a.cJ(8, this.IJG);
      AppMethodBeat.o(127499);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaWq.clear();
        this.YMT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dpp localdpp = (dpp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127499);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdpp.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 2: 
          localdpp.YFt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127499);
          return 0;
        case 3: 
          localdpp.aaWp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127499);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dpo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dpo)localObject2).parseFrom((byte[])localObject1);
            }
            localdpp.aaWq.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 5: 
          localdpp.aaWr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(127499);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dpr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dpr)localObject2).parseFrom((byte[])localObject1);
            }
            localdpp.YMT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 7: 
          localdpp.aaWs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(127499);
          return 0;
        }
        localdpp.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(127499);
        return 0;
      }
      AppMethodBeat.o(127499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpp
 * JD-Core Version:    0.7.0.1
 */