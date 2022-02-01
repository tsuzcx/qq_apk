package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbl
  extends erp
{
  public double YTc;
  public double YTd;
  public int ZkT;
  public long ZvA;
  public int Zvz;
  public LinkedList<fgs> aasW;
  public long abZN;
  public etl abZO;
  public etl abZP;
  public int abZQ;
  
  public gbl()
  {
    AppMethodBeat.i(115913);
    this.aasW = new LinkedList();
    AppMethodBeat.o(115913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115914);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abZO == null)
      {
        paramVarArgs = new b("Not all required fields were included: NetName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.abZP == null)
      {
        paramVarArgs = new b("Not all required fields were included: WifiName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.abZN);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.ZkT);
      if (this.abZO != null)
      {
        paramVarArgs.qD(5, this.abZO.computeSize());
        this.abZO.writeFields(paramVarArgs);
      }
      if (this.abZP != null)
      {
        paramVarArgs.qD(6, this.abZP.computeSize());
        this.abZP.writeFields(paramVarArgs);
      }
      paramVarArgs.d(7, this.YTc);
      paramVarArgs.d(8, this.YTd);
      paramVarArgs.bS(9, this.Zvz);
      paramVarArgs.bS(10, this.abZQ);
      paramVarArgs.e(11, 8, this.aasW);
      AppMethodBeat.o(115914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1092;
      }
    }
    label1092:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.abZN) + i.a.a.b.b.a.q(3, this.ZvA) + i.a.a.b.b.a.cJ(4, this.ZkT);
      paramInt = i;
      if (this.abZO != null) {
        paramInt = i + i.a.a.a.qC(5, this.abZO.computeSize());
      }
      i = paramInt;
      if (this.abZP != null) {
        i = paramInt + i.a.a.a.qC(6, this.abZP.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(7);
      int j = i.a.a.b.b.a.ko(8);
      int k = i.a.a.b.b.a.cJ(9, this.Zvz);
      int m = i.a.a.b.b.a.cJ(10, this.abZQ);
      int n = i.a.a.a.c(11, 8, this.aasW);
      AppMethodBeat.o(115914);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aasW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abZO == null)
        {
          paramVarArgs = new b("Not all required fields were included: NetName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        if (this.abZP == null)
        {
          paramVarArgs = new b("Not all required fields were included: WifiName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gbl localgbl = (gbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115914);
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
            localgbl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 2: 
          localgbl.abZN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115914);
          return 0;
        case 3: 
          localgbl.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115914);
          return 0;
        case 4: 
          localgbl.ZkT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115914);
          return 0;
        case 5: 
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
            localgbl.abZO = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 6: 
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
            localgbl.abZP = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 7: 
          localgbl.YTc = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(115914);
          return 0;
        case 8: 
          localgbl.YTd = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(115914);
          return 0;
        case 9: 
          localgbl.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115914);
          return 0;
        case 10: 
          localgbl.abZQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115914);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fgs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fgs)localObject2).parseFrom((byte[])localObject1);
          }
          localgbl.aasW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      AppMethodBeat.o(115914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbl
 * JD-Core Version:    0.7.0.1
 */