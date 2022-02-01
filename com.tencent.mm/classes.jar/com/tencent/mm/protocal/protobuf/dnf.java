package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnf
  extends ckq
{
  public double CJD;
  public double CJE;
  public int CYi;
  public int DdZ;
  public long Dea;
  public LinkedList<cwu> Duw;
  public long EDR;
  public cmf EDS;
  public cmf EDT;
  public int EDU;
  
  public dnf()
  {
    AppMethodBeat.i(115913);
    this.Duw = new LinkedList();
    AppMethodBeat.o(115913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115914);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EDS == null)
      {
        paramVarArgs = new b("Not all required fields were included: NetName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.EDT == null)
      {
        paramVarArgs = new b("Not all required fields were included: WifiName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.EDR);
      paramVarArgs.aG(3, this.Dea);
      paramVarArgs.aR(4, this.CYi);
      if (this.EDS != null)
      {
        paramVarArgs.kX(5, this.EDS.computeSize());
        this.EDS.writeFields(paramVarArgs);
      }
      if (this.EDT != null)
      {
        paramVarArgs.kX(6, this.EDT.computeSize());
        this.EDT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, this.CJD);
      paramVarArgs.e(8, this.CJE);
      paramVarArgs.aR(9, this.DdZ);
      paramVarArgs.aR(10, this.EDU);
      paramVarArgs.e(11, 8, this.Duw);
      AppMethodBeat.o(115914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1184;
      }
    }
    label1184:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.EDR) + f.a.a.b.b.a.q(3, this.Dea) + f.a.a.b.b.a.bA(4, this.CYi);
      paramInt = i;
      if (this.EDS != null) {
        paramInt = i + f.a.a.a.kW(5, this.EDS.computeSize());
      }
      i = paramInt;
      if (this.EDT != null) {
        i = paramInt + f.a.a.a.kW(6, this.EDT.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(7);
      int j = f.a.a.b.b.a.fY(8);
      int k = f.a.a.b.b.a.bA(9, this.DdZ);
      int m = f.a.a.b.b.a.bA(10, this.EDU);
      int n = f.a.a.a.c(11, 8, this.Duw);
      AppMethodBeat.o(115914);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Duw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EDS == null)
        {
          paramVarArgs = new b("Not all required fields were included: NetName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        if (this.EDT == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnf localdnf = (dnf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115914);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 2: 
          localdnf.EDR = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115914);
          return 0;
        case 3: 
          localdnf.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115914);
          return 0;
        case 4: 
          localdnf.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115914);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnf.EDS = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnf.EDT = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 7: 
          localdnf.CJD = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(115914);
          return 0;
        case 8: 
          localdnf.CJE = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(115914);
          return 0;
        case 9: 
          localdnf.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115914);
          return 0;
        case 10: 
          localdnf.EDU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115914);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdnf.Duw.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnf
 * JD-Core Version:    0.7.0.1
 */