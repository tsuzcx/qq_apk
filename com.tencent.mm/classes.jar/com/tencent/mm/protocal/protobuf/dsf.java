package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsf
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
  public dsm FYq;
  public int FYr;
  public int FYs;
  public int FYt;
  public int FYu;
  public SKBuiltinBuffer_t FYv;
  public int FZw;
  public int FZx;
  public int FZy;
  public int Fwc;
  
  public dsf()
  {
    AppMethodBeat.i(115885);
    this.DVd = new LinkedList();
    this.FYB = new LinkedList();
    AppMethodBeat.o(115885);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115886);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aR(3, this.DVc);
      paramVarArgs.e(4, 8, this.DVd);
      paramVarArgs.aO(5, this.Exg);
      paramVarArgs.aR(6, this.Fwc);
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
      paramVarArgs.aR(14, this.FZw);
      paramVarArgs.aR(15, this.FYG);
      paramVarArgs.aR(16, this.FYH);
      paramVarArgs.aR(17, this.FYr);
      paramVarArgs.aR(18, this.FYI);
      paramVarArgs.aR(19, this.FYJ);
      paramVarArgs.aR(20, this.FYs);
      paramVarArgs.aR(21, this.FYK);
      paramVarArgs.aR(22, this.FYL);
      paramVarArgs.aR(23, this.FYM);
      paramVarArgs.aR(24, this.FZx);
      paramVarArgs.aR(25, this.FYN);
      paramVarArgs.aR(26, this.FZy);
      paramVarArgs.aR(27, this.FYt);
      paramVarArgs.aR(28, this.FYu);
      paramVarArgs.aR(29, this.FYO);
      paramVarArgs.aR(30, this.FYP);
      if (this.FYv != null)
      {
        paramVarArgs.ln(31, this.FYv.computeSize());
        this.FYv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2090;
      }
    }
    label2090:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.bx(3, this.DVc) + f.a.a.a.c(4, 8, this.DVd) + f.a.a.b.b.a.p(5, this.Exg) + f.a.a.b.b.a.bx(6, this.Fwc);
      paramInt = i;
      if (this.FYq != null) {
        paramInt = i + f.a.a.a.lm(7, this.FYq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FYA) + f.a.a.a.c(9, 8, this.FYB) + f.a.a.b.b.a.bx(10, this.FYC) + f.a.a.b.b.a.bx(11, this.FYD) + f.a.a.b.b.a.bx(12, this.FYE) + f.a.a.b.b.a.bx(13, this.FYF) + f.a.a.b.b.a.bx(14, this.FZw) + f.a.a.b.b.a.bx(15, this.FYG) + f.a.a.b.b.a.bx(16, this.FYH) + f.a.a.b.b.a.bx(17, this.FYr) + f.a.a.b.b.a.bx(18, this.FYI) + f.a.a.b.b.a.bx(19, this.FYJ) + f.a.a.b.b.a.bx(20, this.FYs) + f.a.a.b.b.a.bx(21, this.FYK) + f.a.a.b.b.a.bx(22, this.FYL) + f.a.a.b.b.a.bx(23, this.FYM) + f.a.a.b.b.a.bx(24, this.FZx) + f.a.a.b.b.a.bx(25, this.FYN) + f.a.a.b.b.a.bx(26, this.FZy) + f.a.a.b.b.a.bx(27, this.FYt) + f.a.a.b.b.a.bx(28, this.FYu) + f.a.a.b.b.a.bx(29, this.FYO) + f.a.a.b.b.a.bx(30, this.FYP);
      paramInt = i;
      if (this.FYv != null) {
        paramInt = i + f.a.a.a.lm(31, this.FYv.computeSize());
      }
      AppMethodBeat.o(115886);
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
          AppMethodBeat.o(115886);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115886);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsf localdsf = (dsf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115886);
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
            localdsf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 2: 
          localdsf.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 3: 
          localdsf.DVc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsf.DVd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 5: 
          localdsf.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115886);
          return 0;
        case 6: 
          localdsf.Fwc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
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
            localdsf.FYq = ((dsm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 8: 
          localdsf.FYA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
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
            localdsf.FYB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 10: 
          localdsf.FYC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 11: 
          localdsf.FYD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 12: 
          localdsf.FYE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 13: 
          localdsf.FYF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 14: 
          localdsf.FZw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 15: 
          localdsf.FYG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 16: 
          localdsf.FYH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 17: 
          localdsf.FYr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 18: 
          localdsf.FYI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 19: 
          localdsf.FYJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 20: 
          localdsf.FYs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 21: 
          localdsf.FYK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 22: 
          localdsf.FYL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 23: 
          localdsf.FYM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 24: 
          localdsf.FZx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 25: 
          localdsf.FYN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 26: 
          localdsf.FZy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 27: 
          localdsf.FYt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 28: 
          localdsf.FYu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 29: 
          localdsf.FYO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
          return 0;
        case 30: 
          localdsf.FYP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115886);
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
          localdsf.FYv = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115886);
        return 0;
      }
      AppMethodBeat.o(115886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsf
 * JD-Core Version:    0.7.0.1
 */