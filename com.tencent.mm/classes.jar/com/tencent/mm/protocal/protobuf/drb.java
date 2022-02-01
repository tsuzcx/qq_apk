package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class drb
  extends cqk
{
  public int DVc;
  public LinkedList<dqy> DVd;
  public int Exf;
  public long Exg;
  public int FYA;
  public LinkedList<dso> FYB;
  public int FYC;
  public int FYD;
  public int FYE;
  public int FYF;
  public int FYG;
  public int FYH;
  public int FYI;
  public int FYJ;
  public int FYK;
  public int FYL;
  public int FYM;
  public int FYN;
  public int FYO;
  public int FYP;
  public int FYp;
  public dsm FYq;
  public int FYr;
  public int FYs;
  public int FYt;
  public int FYu;
  public SKBuiltinBuffer_t FYv;
  
  public drb()
  {
    AppMethodBeat.i(115865);
    this.DVd = new LinkedList();
    this.FYB = new LinkedList();
    AppMethodBeat.o(115865);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.FYq == null)
      {
        paramVarArgs = new b("Not all required fields were included: RelayData");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DVc);
      paramVarArgs.e(3, 8, this.DVd);
      paramVarArgs.aR(4, this.Exf);
      paramVarArgs.aO(5, this.Exg);
      paramVarArgs.aR(6, this.FYp);
      if (this.FYq != null)
      {
        paramVarArgs.ln(7, this.FYq.computeSize());
        this.FYq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.FYA);
      paramVarArgs.e(9, 8, this.FYB);
      paramVarArgs.aR(10, this.FYC);
      paramVarArgs.aR(11, this.FYD);
      paramVarArgs.aR(12, this.FYE);
      paramVarArgs.aR(13, this.FYF);
      paramVarArgs.aR(14, this.FYG);
      paramVarArgs.aR(15, this.FYH);
      paramVarArgs.aR(16, this.FYr);
      paramVarArgs.aR(17, this.FYI);
      paramVarArgs.aR(18, this.FYJ);
      paramVarArgs.aR(19, this.FYs);
      paramVarArgs.aR(20, this.FYK);
      paramVarArgs.aR(21, this.FYL);
      paramVarArgs.aR(22, this.FYM);
      paramVarArgs.aR(23, this.FYN);
      paramVarArgs.aR(24, this.FYt);
      paramVarArgs.aR(25, this.FYu);
      paramVarArgs.aR(26, this.FYO);
      paramVarArgs.aR(27, this.FYP);
      if (this.FYv != null)
      {
        paramVarArgs.ln(28, this.FYv.computeSize());
        this.FYv.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DVc) + f.a.a.a.c(3, 8, this.DVd) + f.a.a.b.b.a.bx(4, this.Exf) + f.a.a.b.b.a.p(5, this.Exg) + f.a.a.b.b.a.bx(6, this.FYp);
      paramInt = i;
      if (this.FYq != null) {
        paramInt = i + f.a.a.a.lm(7, this.FYq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FYA) + f.a.a.a.c(9, 8, this.FYB) + f.a.a.b.b.a.bx(10, this.FYC) + f.a.a.b.b.a.bx(11, this.FYD) + f.a.a.b.b.a.bx(12, this.FYE) + f.a.a.b.b.a.bx(13, this.FYF) + f.a.a.b.b.a.bx(14, this.FYG) + f.a.a.b.b.a.bx(15, this.FYH) + f.a.a.b.b.a.bx(16, this.FYr) + f.a.a.b.b.a.bx(17, this.FYI) + f.a.a.b.b.a.bx(18, this.FYJ) + f.a.a.b.b.a.bx(19, this.FYs) + f.a.a.b.b.a.bx(20, this.FYK) + f.a.a.b.b.a.bx(21, this.FYL) + f.a.a.b.b.a.bx(22, this.FYM) + f.a.a.b.b.a.bx(23, this.FYN) + f.a.a.b.b.a.bx(24, this.FYt) + f.a.a.b.b.a.bx(25, this.FYu) + f.a.a.b.b.a.bx(26, this.FYO) + f.a.a.b.b.a.bx(27, this.FYP);
      paramInt = i;
      if (this.FYv != null) {
        paramInt = i + f.a.a.a.lm(28, this.FYv.computeSize());
      }
      AppMethodBeat.o(115866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DVd.clear();
        this.FYB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        if (this.FYq == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drb localdrb = (drb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115866);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 2: 
          localdrb.DVc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrb.DVd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 4: 
          localdrb.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 5: 
          localdrb.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115866);
          return 0;
        case 6: 
          localdrb.FYp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dsm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dsm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrb.FYq = ((dsm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 8: 
          localdrb.FYA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dso();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dso)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrb.FYB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 10: 
          localdrb.FYC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 11: 
          localdrb.FYD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 12: 
          localdrb.FYE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 13: 
          localdrb.FYF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 14: 
          localdrb.FYG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 15: 
          localdrb.FYH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 16: 
          localdrb.FYr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 17: 
          localdrb.FYI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 18: 
          localdrb.FYJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 19: 
          localdrb.FYs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 20: 
          localdrb.FYK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 21: 
          localdrb.FYL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 22: 
          localdrb.FYM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 23: 
          localdrb.FYN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 24: 
          localdrb.FYt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 25: 
          localdrb.FYu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 26: 
          localdrb.FYO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        case 27: 
          localdrb.FYP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115866);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdrb.FYv = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drb
 * JD-Core Version:    0.7.0.1
 */