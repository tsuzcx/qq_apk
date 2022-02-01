package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftr
  extends erp
{
  public int Idt;
  public int NkN;
  public int NkO;
  public int NkP;
  public gol NkQ;
  public etl abRM;
  public etl abRN;
  public int abRO;
  public int abRP;
  public int abRQ;
  public int abRR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148659);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abRM == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientMediaId");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.abRN == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataMD5");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abRM != null)
      {
        paramVarArgs.qD(2, this.abRM.computeSize());
        this.abRM.writeFields(paramVarArgs);
      }
      if (this.abRN != null)
      {
        paramVarArgs.qD(3, this.abRN.computeSize());
        this.abRN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.NkN);
      paramVarArgs.bS(5, this.NkO);
      paramVarArgs.bS(6, this.NkP);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(7, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.Idt);
      paramVarArgs.bS(9, this.abRO);
      paramVarArgs.bS(10, this.abRP);
      paramVarArgs.bS(11, this.abRQ);
      paramVarArgs.bS(12, this.abRR);
      AppMethodBeat.o(148659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1194;
      }
    }
    label1194:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abRM != null) {
        paramInt = i + i.a.a.a.qC(2, this.abRM.computeSize());
      }
      i = paramInt;
      if (this.abRN != null) {
        i = paramInt + i.a.a.a.qC(3, this.abRN.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(4, this.NkN) + i.a.a.b.b.a.cJ(5, this.NkO) + i.a.a.b.b.a.cJ(6, this.NkP);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(7, this.NkQ.computeSize());
      }
      i = i.a.a.b.b.a.cJ(8, this.Idt);
      int j = i.a.a.b.b.a.cJ(9, this.abRO);
      int k = i.a.a.b.b.a.cJ(10, this.abRP);
      int m = i.a.a.b.b.a.cJ(11, this.abRQ);
      int n = i.a.a.b.b.a.cJ(12, this.abRR);
      AppMethodBeat.o(148659);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abRM == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientMediaId");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.abRN == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataMD5");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftr localftr = (ftr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148659);
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
            localftr.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localftr.abRM = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localftr.abRN = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 4: 
          localftr.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148659);
          return 0;
        case 5: 
          localftr.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148659);
          return 0;
        case 6: 
          localftr.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148659);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localftr.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 8: 
          localftr.Idt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148659);
          return 0;
        case 9: 
          localftr.abRO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148659);
          return 0;
        case 10: 
          localftr.abRP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148659);
          return 0;
        case 11: 
          localftr.abRQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148659);
          return 0;
        }
        localftr.abRR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148659);
        return 0;
      }
      AppMethodBeat.o(148659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftr
 * JD-Core Version:    0.7.0.1
 */