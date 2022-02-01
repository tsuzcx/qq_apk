package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbq
  extends erp
{
  public int ZrN;
  public long abWT;
  public gbp abXP;
  public gbp abZU;
  public gbp abZV;
  public gbp abZW;
  public gbp abZX;
  public int abZY;
  public LinkedList<etl> abZZ;
  public int abtq;
  public LinkedList<etl> acaa;
  public LinkedList<etl> acab;
  public int acac;
  public LinkedList<etl> acad;
  
  public gbq()
  {
    AppMethodBeat.i(115921);
    this.abZZ = new LinkedList();
    this.acaa = new LinkedList();
    this.acab = new LinkedList();
    this.acad = new LinkedList();
    AppMethodBeat.o(115921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115922);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abXP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abXP != null)
      {
        paramVarArgs.qD(2, this.abXP.computeSize());
        this.abXP.writeFields(paramVarArgs);
      }
      if (this.abZU != null)
      {
        paramVarArgs.qD(3, this.abZU.computeSize());
        this.abZU.writeFields(paramVarArgs);
      }
      if (this.abZV != null)
      {
        paramVarArgs.qD(4, this.abZV.computeSize());
        this.abZV.writeFields(paramVarArgs);
      }
      if (this.abZW != null)
      {
        paramVarArgs.qD(5, this.abZW.computeSize());
        this.abZW.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.abWT);
      if (this.abZX != null)
      {
        paramVarArgs.qD(7, this.abZX.computeSize());
        this.abZX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.abZY);
      paramVarArgs.e(9, 8, this.abZZ);
      paramVarArgs.bS(10, this.ZrN);
      paramVarArgs.e(11, 8, this.acaa);
      paramVarArgs.bS(12, this.abtq);
      paramVarArgs.e(13, 8, this.acab);
      paramVarArgs.bS(14, this.acac);
      paramVarArgs.e(15, 8, this.acad);
      AppMethodBeat.o(115922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1718;
      }
    }
    label1718:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abXP != null) {
        paramInt = i + i.a.a.a.qC(2, this.abXP.computeSize());
      }
      i = paramInt;
      if (this.abZU != null) {
        i = paramInt + i.a.a.a.qC(3, this.abZU.computeSize());
      }
      paramInt = i;
      if (this.abZV != null) {
        paramInt = i + i.a.a.a.qC(4, this.abZV.computeSize());
      }
      i = paramInt;
      if (this.abZW != null) {
        i = paramInt + i.a.a.a.qC(5, this.abZW.computeSize());
      }
      i += i.a.a.b.b.a.q(6, this.abWT);
      paramInt = i;
      if (this.abZX != null) {
        paramInt = i + i.a.a.a.qC(7, this.abZX.computeSize());
      }
      i = i.a.a.b.b.a.cJ(8, this.abZY);
      int j = i.a.a.a.c(9, 8, this.abZZ);
      int k = i.a.a.b.b.a.cJ(10, this.ZrN);
      int m = i.a.a.a.c(11, 8, this.acaa);
      int n = i.a.a.b.b.a.cJ(12, this.abtq);
      int i1 = i.a.a.a.c(13, 8, this.acab);
      int i2 = i.a.a.b.b.a.cJ(14, this.acac);
      int i3 = i.a.a.a.c(15, 8, this.acad);
      AppMethodBeat.o(115922);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abZZ.clear();
        this.acaa.clear();
        this.acab.clear();
        this.acad.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abXP == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gbq localgbq = (gbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115922);
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
            localgbq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbp)localObject2).parseFrom((byte[])localObject1);
            }
            localgbq.abXP = ((gbp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbp)localObject2).parseFrom((byte[])localObject1);
            }
            localgbq.abZU = ((gbp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbp)localObject2).parseFrom((byte[])localObject1);
            }
            localgbq.abZV = ((gbp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbp)localObject2).parseFrom((byte[])localObject1);
            }
            localgbq.abZW = ((gbp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 6: 
          localgbq.abWT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115922);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbp)localObject2).parseFrom((byte[])localObject1);
            }
            localgbq.abZX = ((gbp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 8: 
          localgbq.abZY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115922);
          return 0;
        case 9: 
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
            localgbq.abZZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 10: 
          localgbq.ZrN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115922);
          return 0;
        case 11: 
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
            localgbq.acaa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 12: 
          localgbq.abtq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115922);
          return 0;
        case 13: 
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
            localgbq.acab.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 14: 
          localgbq.acac = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115922);
          return 0;
        }
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
          localgbq.acad.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      AppMethodBeat.o(115922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbq
 * JD-Core Version:    0.7.0.1
 */