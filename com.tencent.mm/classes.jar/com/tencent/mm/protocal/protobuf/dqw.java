package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqw
  extends cpx
{
  public int EqS;
  public int Exf;
  public long Exg;
  public int FYg;
  public dss FYh;
  public dss FYi;
  public String FYj;
  public int FYk;
  public long FYl;
  public int FYm;
  public int FYn;
  public LinkedList<bxf> FYo;
  public String Fwn;
  
  public dqw()
  {
    AppMethodBeat.i(115857);
    this.FYo = new LinkedList();
    AppMethodBeat.o(115857);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115858);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aO(3, this.Exg);
      if (this.Fwn != null) {
        paramVarArgs.d(4, this.Fwn);
      }
      paramVarArgs.aR(5, this.FYg);
      if (this.FYh != null)
      {
        paramVarArgs.ln(6, this.FYh.computeSize());
        this.FYh.writeFields(paramVarArgs);
      }
      if (this.FYi != null)
      {
        paramVarArgs.ln(7, this.FYi.computeSize());
        this.FYi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.EqS);
      if (this.FYj != null) {
        paramVarArgs.d(9, this.FYj);
      }
      paramVarArgs.aR(10, this.FYk);
      paramVarArgs.aO(11, this.FYl);
      paramVarArgs.aR(12, this.FYm);
      paramVarArgs.aR(13, this.FYn);
      paramVarArgs.e(14, 8, this.FYo);
      AppMethodBeat.o(115858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.p(3, this.Exg);
      paramInt = i;
      if (this.Fwn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fwn);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FYg);
      paramInt = i;
      if (this.FYh != null) {
        paramInt = i + f.a.a.a.lm(6, this.FYh.computeSize());
      }
      i = paramInt;
      if (this.FYi != null) {
        i = paramInt + f.a.a.a.lm(7, this.FYi.computeSize());
      }
      i += f.a.a.b.b.a.bx(8, this.EqS);
      paramInt = i;
      if (this.FYj != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FYj);
      }
      i = f.a.a.b.b.a.bx(10, this.FYk);
      int j = f.a.a.b.b.a.p(11, this.FYl);
      int k = f.a.a.b.b.a.bx(12, this.FYm);
      int m = f.a.a.b.b.a.bx(13, this.FYn);
      int n = f.a.a.a.c(14, 8, this.FYo);
      AppMethodBeat.o(115858);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FYo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqw localdqw = (dqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115858);
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
            localdqw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 2: 
          localdqw.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115858);
          return 0;
        case 3: 
          localdqw.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115858);
          return 0;
        case 4: 
          localdqw.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 5: 
          localdqw.FYg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115858);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqw.FYh = ((dss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqw.FYi = ((dss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 8: 
          localdqw.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115858);
          return 0;
        case 9: 
          localdqw.FYj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 10: 
          localdqw.FYk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115858);
          return 0;
        case 11: 
          localdqw.FYl = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115858);
          return 0;
        case 12: 
          localdqw.FYm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115858);
          return 0;
        case 13: 
          localdqw.FYn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115858);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqw.FYo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      AppMethodBeat.o(115858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqw
 * JD-Core Version:    0.7.0.1
 */