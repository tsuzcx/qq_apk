package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dse
  extends cpx
{
  public int EqS;
  public int Exf;
  public long Exg;
  public int FLI;
  public dss FYh;
  public dss FYi;
  public long FYl;
  public int FYm;
  public int FYn;
  public LinkedList<bxf> FYo;
  public int FZh;
  public int FZt;
  public LinkedList<crm> FZu;
  public int FZv;
  public int FvR;
  public String Fwn;
  
  public dse()
  {
    AppMethodBeat.i(115883);
    this.FZu = new LinkedList();
    this.FYo = new LinkedList();
    AppMethodBeat.o(115883);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115884);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FYh == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.FYi == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115884);
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
      paramVarArgs.aR(3, this.FZt);
      paramVarArgs.e(4, 8, this.FZu);
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
      paramVarArgs.aR(9, this.FLI);
      paramVarArgs.aR(10, this.Exf);
      paramVarArgs.aO(11, this.Exg);
      paramVarArgs.aR(12, this.FZh);
      paramVarArgs.aO(13, this.FYl);
      paramVarArgs.aR(14, this.FZv);
      paramVarArgs.aR(15, this.FvR);
      paramVarArgs.aR(16, this.FYm);
      paramVarArgs.aR(17, this.FYn);
      paramVarArgs.e(18, 8, this.FYo);
      AppMethodBeat.o(115884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1586;
      }
    }
    label1586:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fwn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fwn);
      }
      i = i + f.a.a.b.b.a.bx(3, this.FZt) + f.a.a.a.c(4, 8, this.FZu);
      paramInt = i;
      if (this.FYh != null) {
        paramInt = i + f.a.a.a.lm(6, this.FYh.computeSize());
      }
      i = paramInt;
      if (this.FYi != null) {
        i = paramInt + f.a.a.a.lm(7, this.FYi.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(8, this.EqS);
      int j = f.a.a.b.b.a.bx(9, this.FLI);
      int k = f.a.a.b.b.a.bx(10, this.Exf);
      int m = f.a.a.b.b.a.p(11, this.Exg);
      int n = f.a.a.b.b.a.bx(12, this.FZh);
      int i1 = f.a.a.b.b.a.p(13, this.FYl);
      int i2 = f.a.a.b.b.a.bx(14, this.FZv);
      int i3 = f.a.a.b.b.a.bx(15, this.FvR);
      int i4 = f.a.a.b.b.a.bx(16, this.FYm);
      int i5 = f.a.a.b.b.a.bx(17, this.FYn);
      int i6 = f.a.a.a.c(18, 8, this.FYo);
      AppMethodBeat.o(115884);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FZu.clear();
        this.FYo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FYh == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        if (this.FYi == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dse localdse = (dse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115884);
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
            localdse.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 2: 
          localdse.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115884);
          return 0;
        case 3: 
          localdse.FZt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdse.FZu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
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
            localdse.FYh = ((dss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
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
            localdse.FYi = ((dss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 8: 
          localdse.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
          return 0;
        case 9: 
          localdse.FLI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
          return 0;
        case 10: 
          localdse.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
          return 0;
        case 11: 
          localdse.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115884);
          return 0;
        case 12: 
          localdse.FZh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
          return 0;
        case 13: 
          localdse.FYl = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115884);
          return 0;
        case 14: 
          localdse.FZv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
          return 0;
        case 15: 
          localdse.FvR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
          return 0;
        case 16: 
          localdse.FYm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
          return 0;
        case 17: 
          localdse.FYn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115884);
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
          localdse.FYo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      AppMethodBeat.o(115884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dse
 * JD-Core Version:    0.7.0.1
 */