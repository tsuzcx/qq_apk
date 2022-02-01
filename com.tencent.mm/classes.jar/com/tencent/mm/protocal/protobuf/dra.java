package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dra
  extends cpx
{
  public int EqS;
  public int Exf;
  public long Exg;
  public dss FYh;
  public dss FYi;
  public long FYl;
  public int FYm;
  public int FYn;
  public LinkedList<bxf> FYo;
  public int FYy;
  public int FYz;
  public String Fwn;
  
  public dra()
  {
    AppMethodBeat.i(115863);
    this.FYo = new LinkedList();
    AppMethodBeat.o(115863);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fwn != null) {
        paramVarArgs.d(2, this.Fwn);
      }
      paramVarArgs.aR(3, this.Exf);
      paramVarArgs.aR(4, this.FYy);
      if (this.FYh != null)
      {
        paramVarArgs.ln(5, this.FYh.computeSize());
        this.FYh.writeFields(paramVarArgs);
      }
      if (this.FYi != null)
      {
        paramVarArgs.ln(6, this.FYi.computeSize());
        this.FYi.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.Exg);
      paramVarArgs.aR(8, this.EqS);
      paramVarArgs.aO(9, this.FYl);
      paramVarArgs.aR(10, this.FYz);
      paramVarArgs.aR(11, this.FYm);
      paramVarArgs.aR(12, this.FYn);
      paramVarArgs.e(13, 8, this.FYo);
      AppMethodBeat.o(115864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fwn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fwn);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Exf) + f.a.a.b.b.a.bx(4, this.FYy);
      paramInt = i;
      if (this.FYh != null) {
        paramInt = i + f.a.a.a.lm(5, this.FYh.computeSize());
      }
      i = paramInt;
      if (this.FYi != null) {
        i = paramInt + f.a.a.a.lm(6, this.FYi.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(7, this.Exg);
      int j = f.a.a.b.b.a.bx(8, this.EqS);
      int k = f.a.a.b.b.a.p(9, this.FYl);
      int m = f.a.a.b.b.a.bx(10, this.FYz);
      int n = f.a.a.b.b.a.bx(11, this.FYm);
      int i1 = f.a.a.b.b.a.bx(12, this.FYn);
      int i2 = f.a.a.a.c(13, 8, this.FYo);
      AppMethodBeat.o(115864);
      return i + paramInt + j + k + m + n + i1 + i2;
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
        AppMethodBeat.o(115864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dra localdra = (dra)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115864);
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
            localdra.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 2: 
          localdra.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115864);
          return 0;
        case 3: 
          localdra.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115864);
          return 0;
        case 4: 
          localdra.FYy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115864);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdra.FYh = ((dss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
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
            localdra.FYi = ((dss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 7: 
          localdra.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115864);
          return 0;
        case 8: 
          localdra.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115864);
          return 0;
        case 9: 
          localdra.FYl = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115864);
          return 0;
        case 10: 
          localdra.FYz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115864);
          return 0;
        case 11: 
          localdra.FYm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115864);
          return 0;
        case 12: 
          localdra.FYn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115864);
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
          localdra.FYo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      AppMethodBeat.o(115864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dra
 * JD-Core Version:    0.7.0.1
 */