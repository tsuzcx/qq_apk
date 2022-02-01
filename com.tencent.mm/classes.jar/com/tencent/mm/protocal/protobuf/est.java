package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class est
  extends dpc
{
  public int KMC;
  public LinkedList<esq> KMD;
  public int LsZ;
  public long Lta;
  public int NpR;
  public eue NpS;
  public int NpT;
  public int NpU;
  public int NpV;
  public int NpW;
  public SKBuiltinBuffer_t NpX;
  public int Nqc;
  public LinkedList<eug> Nqd;
  public int Nqe;
  public int Nqf;
  public int Nqg;
  public int Nqh;
  public int Nqi;
  public int Nqj;
  public int Nqk;
  public int Nql;
  public int Nqm;
  public int Nqn;
  public int Nqo;
  public int Nqp;
  public int Nqq;
  public int Nqr;
  
  public est()
  {
    AppMethodBeat.i(115865);
    this.KMD = new LinkedList();
    this.Nqd = new LinkedList();
    AppMethodBeat.o(115865);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115866);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.NpS == null)
      {
        paramVarArgs = new b("Not all required fields were included: RelayData");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KMC);
      paramVarArgs.e(3, 8, this.KMD);
      paramVarArgs.aM(4, this.LsZ);
      paramVarArgs.bb(5, this.Lta);
      paramVarArgs.aM(6, this.NpR);
      if (this.NpS != null)
      {
        paramVarArgs.ni(7, this.NpS.computeSize());
        this.NpS.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.Nqc);
      paramVarArgs.e(9, 8, this.Nqd);
      paramVarArgs.aM(10, this.Nqe);
      paramVarArgs.aM(11, this.Nqf);
      paramVarArgs.aM(12, this.Nqg);
      paramVarArgs.aM(13, this.Nqh);
      paramVarArgs.aM(14, this.Nqi);
      paramVarArgs.aM(15, this.Nqj);
      paramVarArgs.aM(16, this.NpT);
      paramVarArgs.aM(17, this.Nqk);
      paramVarArgs.aM(18, this.Nql);
      paramVarArgs.aM(19, this.NpU);
      paramVarArgs.aM(20, this.Nqm);
      paramVarArgs.aM(21, this.Nqn);
      paramVarArgs.aM(22, this.Nqo);
      paramVarArgs.aM(23, this.Nqp);
      paramVarArgs.aM(24, this.NpV);
      paramVarArgs.aM(25, this.NpW);
      paramVarArgs.aM(26, this.Nqq);
      paramVarArgs.aM(27, this.Nqr);
      if (this.NpX != null)
      {
        paramVarArgs.ni(28, this.NpX.computeSize());
        this.NpX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2006;
      }
    }
    label2006:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KMC) + g.a.a.a.c(3, 8, this.KMD) + g.a.a.b.b.a.bu(4, this.LsZ) + g.a.a.b.b.a.r(5, this.Lta) + g.a.a.b.b.a.bu(6, this.NpR);
      paramInt = i;
      if (this.NpS != null) {
        paramInt = i + g.a.a.a.nh(7, this.NpS.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.Nqc) + g.a.a.a.c(9, 8, this.Nqd) + g.a.a.b.b.a.bu(10, this.Nqe) + g.a.a.b.b.a.bu(11, this.Nqf) + g.a.a.b.b.a.bu(12, this.Nqg) + g.a.a.b.b.a.bu(13, this.Nqh) + g.a.a.b.b.a.bu(14, this.Nqi) + g.a.a.b.b.a.bu(15, this.Nqj) + g.a.a.b.b.a.bu(16, this.NpT) + g.a.a.b.b.a.bu(17, this.Nqk) + g.a.a.b.b.a.bu(18, this.Nql) + g.a.a.b.b.a.bu(19, this.NpU) + g.a.a.b.b.a.bu(20, this.Nqm) + g.a.a.b.b.a.bu(21, this.Nqn) + g.a.a.b.b.a.bu(22, this.Nqo) + g.a.a.b.b.a.bu(23, this.Nqp) + g.a.a.b.b.a.bu(24, this.NpV) + g.a.a.b.b.a.bu(25, this.NpW) + g.a.a.b.b.a.bu(26, this.Nqq) + g.a.a.b.b.a.bu(27, this.Nqr);
      paramInt = i;
      if (this.NpX != null) {
        paramInt = i + g.a.a.a.nh(28, this.NpX.computeSize());
      }
      AppMethodBeat.o(115866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KMD.clear();
        this.Nqd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        if (this.NpS == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        est localest = (est)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115866);
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
            localest.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 2: 
          localest.KMC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localest.KMD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 4: 
          localest.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 5: 
          localest.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115866);
          return 0;
        case 6: 
          localest.NpR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eue();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eue)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localest.NpS = ((eue)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 8: 
          localest.Nqc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eug();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eug)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localest.Nqd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 10: 
          localest.Nqe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 11: 
          localest.Nqf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 12: 
          localest.Nqg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 13: 
          localest.Nqh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 14: 
          localest.Nqi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 15: 
          localest.Nqj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 16: 
          localest.NpT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 17: 
          localest.Nqk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 18: 
          localest.Nql = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 19: 
          localest.NpU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 20: 
          localest.Nqm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 21: 
          localest.Nqn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 22: 
          localest.Nqo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 23: 
          localest.Nqp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 24: 
          localest.NpV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 25: 
          localest.NpW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 26: 
          localest.Nqq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        case 27: 
          localest.Nqr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115866);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localest.NpX = ((SKBuiltinBuffer_t)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.est
 * JD-Core Version:    0.7.0.1
 */