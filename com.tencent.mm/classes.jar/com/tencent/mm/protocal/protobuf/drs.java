package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class drs
  extends cpx
{
  public int Exf;
  public long Exg;
  public long FYl;
  public dta FZg;
  public int FZh;
  public int FZi;
  public int FvR;
  public String Fwn;
  public String tlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115868);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115868);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fwn != null) {
        paramVarArgs.d(2, this.Fwn);
      }
      paramVarArgs.aR(3, this.Exf);
      paramVarArgs.aO(4, this.Exg);
      if (this.tlJ != null) {
        paramVarArgs.d(6, this.tlJ);
      }
      if (this.FZg != null)
      {
        paramVarArgs.ln(8, this.FZg.computeSize());
        this.FZg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.FZh);
      paramVarArgs.aO(10, this.FYl);
      paramVarArgs.aR(11, this.FvR);
      paramVarArgs.aR(12, this.FZi);
      AppMethodBeat.o(115868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fwn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fwn);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Exf) + f.a.a.b.b.a.p(4, this.Exg);
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tlJ);
      }
      i = paramInt;
      if (this.FZg != null) {
        i = paramInt + f.a.a.a.lm(8, this.FZg.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(9, this.FZh);
      int j = f.a.a.b.b.a.p(10, this.FYl);
      int k = f.a.a.b.b.a.bx(11, this.FvR);
      int m = f.a.a.b.b.a.bx(12, this.FZi);
      AppMethodBeat.o(115868);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FZg == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115868);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115868);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drs localdrs = (drs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(115868);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrs.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 2: 
          localdrs.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 3: 
          localdrs.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115868);
          return 0;
        case 4: 
          localdrs.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115868);
          return 0;
        case 6: 
          localdrs.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrs.FZg = ((dta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 9: 
          localdrs.FZh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115868);
          return 0;
        case 10: 
          localdrs.FYl = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115868);
          return 0;
        case 11: 
          localdrs.FvR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115868);
          return 0;
        }
        localdrs.FZi = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115868);
        return 0;
      }
      AppMethodBeat.o(115868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drs
 * JD-Core Version:    0.7.0.1
 */