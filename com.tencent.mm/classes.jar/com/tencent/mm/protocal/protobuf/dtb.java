package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtb
  extends cpx
{
  public int Evz;
  public int FBe;
  public long FYl;
  public dta FZg;
  public dta Gbl;
  public dta Gbm;
  public dta Gbn;
  public dta Gbo;
  public int Gbp;
  public LinkedList<crm> Gbq;
  public LinkedList<crm> Gbr;
  public LinkedList<crm> Gbs;
  public int Gbt;
  public LinkedList<crm> Gbu;
  
  public dtb()
  {
    AppMethodBeat.i(115921);
    this.Gbq = new LinkedList();
    this.Gbr = new LinkedList();
    this.Gbs = new LinkedList();
    this.Gbu = new LinkedList();
    AppMethodBeat.o(115921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FZg != null)
      {
        paramVarArgs.ln(2, this.FZg.computeSize());
        this.FZg.writeFields(paramVarArgs);
      }
      if (this.Gbl != null)
      {
        paramVarArgs.ln(3, this.Gbl.computeSize());
        this.Gbl.writeFields(paramVarArgs);
      }
      if (this.Gbm != null)
      {
        paramVarArgs.ln(4, this.Gbm.computeSize());
        this.Gbm.writeFields(paramVarArgs);
      }
      if (this.Gbn != null)
      {
        paramVarArgs.ln(5, this.Gbn.computeSize());
        this.Gbn.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.FYl);
      if (this.Gbo != null)
      {
        paramVarArgs.ln(7, this.Gbo.computeSize());
        this.Gbo.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Gbp);
      paramVarArgs.e(9, 8, this.Gbq);
      paramVarArgs.aR(10, this.Evz);
      paramVarArgs.e(11, 8, this.Gbr);
      paramVarArgs.aR(12, this.FBe);
      paramVarArgs.e(13, 8, this.Gbs);
      paramVarArgs.aR(14, this.Gbt);
      paramVarArgs.e(15, 8, this.Gbu);
      AppMethodBeat.o(115922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1942;
      }
    }
    label1942:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZg != null) {
        paramInt = i + f.a.a.a.lm(2, this.FZg.computeSize());
      }
      i = paramInt;
      if (this.Gbl != null) {
        i = paramInt + f.a.a.a.lm(3, this.Gbl.computeSize());
      }
      paramInt = i;
      if (this.Gbm != null) {
        paramInt = i + f.a.a.a.lm(4, this.Gbm.computeSize());
      }
      i = paramInt;
      if (this.Gbn != null) {
        i = paramInt + f.a.a.a.lm(5, this.Gbn.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.FYl);
      paramInt = i;
      if (this.Gbo != null) {
        paramInt = i + f.a.a.a.lm(7, this.Gbo.computeSize());
      }
      i = f.a.a.b.b.a.bx(8, this.Gbp);
      int j = f.a.a.a.c(9, 8, this.Gbq);
      int k = f.a.a.b.b.a.bx(10, this.Evz);
      int m = f.a.a.a.c(11, 8, this.Gbr);
      int n = f.a.a.b.b.a.bx(12, this.FBe);
      int i1 = f.a.a.a.c(13, 8, this.Gbs);
      int i2 = f.a.a.b.b.a.bx(14, this.Gbt);
      int i3 = f.a.a.a.c(15, 8, this.Gbu);
      AppMethodBeat.o(115922);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gbq.clear();
        this.Gbr.clear();
        this.Gbs.clear();
        this.Gbu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FZg == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtb localdtb = (dtb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115922);
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
            localdtb.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtb.FZg = ((dta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtb.Gbl = ((dta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtb.Gbm = ((dta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtb.Gbn = ((dta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 6: 
          localdtb.FYl = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115922);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtb.Gbo = ((dta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 8: 
          localdtb.Gbp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115922);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtb.Gbq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 10: 
          localdtb.Evz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115922);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtb.Gbr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 12: 
          localdtb.FBe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115922);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtb.Gbs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 14: 
          localdtb.Gbt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115922);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdtb.Gbu.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtb
 * JD-Core Version:    0.7.0.1
 */