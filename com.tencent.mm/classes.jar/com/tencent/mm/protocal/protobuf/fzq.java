package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fzq
  extends esc
{
  public int YKK;
  public LinkedList<fzn> YKL;
  public long ZvA;
  public int Zvz;
  public int abWY;
  public gbb abWZ;
  public int abXa;
  public int abXb;
  public int abXc;
  public int abXd;
  public gol abXe;
  public int abXj;
  public LinkedList<gbd> abXk;
  public int abXl;
  public int abXm;
  public int abXn;
  public int abXo;
  public int abXp;
  public int abXq;
  public int abXr;
  public int abXs;
  public int abXt;
  public int abXu;
  public int abXv;
  public int abXw;
  public int abXx;
  public int abXy;
  
  public fzq()
  {
    AppMethodBeat.i(115865);
    this.YKL = new LinkedList();
    this.abXk = new LinkedList();
    AppMethodBeat.o(115865);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115866);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.abWZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RelayData");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YKK);
      paramVarArgs.e(3, 8, this.YKL);
      paramVarArgs.bS(4, this.Zvz);
      paramVarArgs.bv(5, this.ZvA);
      paramVarArgs.bS(6, this.abWY);
      if (this.abWZ != null)
      {
        paramVarArgs.qD(7, this.abWZ.computeSize());
        this.abWZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.abXj);
      paramVarArgs.e(9, 8, this.abXk);
      paramVarArgs.bS(10, this.abXl);
      paramVarArgs.bS(11, this.abXm);
      paramVarArgs.bS(12, this.abXn);
      paramVarArgs.bS(13, this.abXo);
      paramVarArgs.bS(14, this.abXp);
      paramVarArgs.bS(15, this.abXq);
      paramVarArgs.bS(16, this.abXa);
      paramVarArgs.bS(17, this.abXr);
      paramVarArgs.bS(18, this.abXs);
      paramVarArgs.bS(19, this.abXb);
      paramVarArgs.bS(20, this.abXt);
      paramVarArgs.bS(21, this.abXu);
      paramVarArgs.bS(22, this.abXv);
      paramVarArgs.bS(23, this.abXw);
      paramVarArgs.bS(24, this.abXc);
      paramVarArgs.bS(25, this.abXd);
      paramVarArgs.bS(26, this.abXx);
      paramVarArgs.bS(27, this.abXy);
      if (this.abXe != null)
      {
        paramVarArgs.qD(28, this.abXe.computeSize());
        this.abXe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1892;
      }
    }
    label1892:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YKK) + i.a.a.a.c(3, 8, this.YKL) + i.a.a.b.b.a.cJ(4, this.Zvz) + i.a.a.b.b.a.q(5, this.ZvA) + i.a.a.b.b.a.cJ(6, this.abWY);
      paramInt = i;
      if (this.abWZ != null) {
        paramInt = i + i.a.a.a.qC(7, this.abWZ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abXj) + i.a.a.a.c(9, 8, this.abXk) + i.a.a.b.b.a.cJ(10, this.abXl) + i.a.a.b.b.a.cJ(11, this.abXm) + i.a.a.b.b.a.cJ(12, this.abXn) + i.a.a.b.b.a.cJ(13, this.abXo) + i.a.a.b.b.a.cJ(14, this.abXp) + i.a.a.b.b.a.cJ(15, this.abXq) + i.a.a.b.b.a.cJ(16, this.abXa) + i.a.a.b.b.a.cJ(17, this.abXr) + i.a.a.b.b.a.cJ(18, this.abXs) + i.a.a.b.b.a.cJ(19, this.abXb) + i.a.a.b.b.a.cJ(20, this.abXt) + i.a.a.b.b.a.cJ(21, this.abXu) + i.a.a.b.b.a.cJ(22, this.abXv) + i.a.a.b.b.a.cJ(23, this.abXw) + i.a.a.b.b.a.cJ(24, this.abXc) + i.a.a.b.b.a.cJ(25, this.abXd) + i.a.a.b.b.a.cJ(26, this.abXx) + i.a.a.b.b.a.cJ(27, this.abXy);
      paramInt = i;
      if (this.abXe != null) {
        paramInt = i + i.a.a.a.qC(28, this.abXe.computeSize());
      }
      AppMethodBeat.o(115866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YKL.clear();
        this.abXk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        if (this.abWZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: RelayData");
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fzq localfzq = (fzq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115866);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfzq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 2: 
          localfzq.YKK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzn)localObject2).parseFrom((byte[])localObject1);
            }
            localfzq.YKL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 4: 
          localfzq.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 5: 
          localfzq.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115866);
          return 0;
        case 6: 
          localfzq.abWY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbb)localObject2).parseFrom((byte[])localObject1);
            }
            localfzq.abWZ = ((gbb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 8: 
          localfzq.abXj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbd)localObject2).parseFrom((byte[])localObject1);
            }
            localfzq.abXk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 10: 
          localfzq.abXl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 11: 
          localfzq.abXm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 12: 
          localfzq.abXn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 13: 
          localfzq.abXo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 14: 
          localfzq.abXp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 15: 
          localfzq.abXq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 16: 
          localfzq.abXa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 17: 
          localfzq.abXr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 18: 
          localfzq.abXs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 19: 
          localfzq.abXb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 20: 
          localfzq.abXt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 21: 
          localfzq.abXu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 22: 
          localfzq.abXv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 23: 
          localfzq.abXw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 24: 
          localfzq.abXc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 25: 
          localfzq.abXd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 26: 
          localfzq.abXx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        case 27: 
          localfzq.abXy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115866);
          return 0;
        }
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
          localfzq.abXe = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115866);
        return 0;
      }
      AppMethodBeat.o(115866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzq
 * JD-Core Version:    0.7.0.1
 */