package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsq
  extends cpx
{
  public int Exf;
  public long Exg;
  public int FYn;
  public LinkedList<bxf> FYo;
  public int Fwc;
  public int GaL;
  public int GaM;
  public LinkedList<dst> GaN;
  public int GaO;
  public int GaP;
  public int GaQ;
  
  public dsq()
  {
    AppMethodBeat.i(115905);
    this.GaN = new LinkedList();
    this.FYo = new LinkedList();
    AppMethodBeat.o(115905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115906);
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
      paramVarArgs.aR(4, this.Fwc);
      paramVarArgs.aR(5, this.GaL);
      paramVarArgs.aR(6, this.GaM);
      paramVarArgs.e(7, 8, this.GaN);
      paramVarArgs.aR(8, this.GaO);
      paramVarArgs.aR(9, this.FYn);
      paramVarArgs.e(10, 8, this.FYo);
      paramVarArgs.aR(11, this.GaP);
      paramVarArgs.aR(12, this.GaQ);
      AppMethodBeat.o(115906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Exf);
      int j = f.a.a.b.b.a.p(3, this.Exg);
      int k = f.a.a.b.b.a.bx(4, this.Fwc);
      int m = f.a.a.b.b.a.bx(5, this.GaL);
      int n = f.a.a.b.b.a.bx(6, this.GaM);
      int i1 = f.a.a.a.c(7, 8, this.GaN);
      int i2 = f.a.a.b.b.a.bx(8, this.GaO);
      int i3 = f.a.a.b.b.a.bx(9, this.FYn);
      int i4 = f.a.a.a.c(10, 8, this.FYo);
      int i5 = f.a.a.b.b.a.bx(11, this.GaP);
      int i6 = f.a.a.b.b.a.bx(12, this.GaQ);
      AppMethodBeat.o(115906);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GaN.clear();
        this.FYo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsq localdsq = (dsq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115906);
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
            localdsq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 2: 
          localdsq.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115906);
          return 0;
        case 3: 
          localdsq.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115906);
          return 0;
        case 4: 
          localdsq.Fwc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115906);
          return 0;
        case 5: 
          localdsq.GaL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115906);
          return 0;
        case 6: 
          localdsq.GaM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115906);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dst();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dst)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsq.GaN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 8: 
          localdsq.GaO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115906);
          return 0;
        case 9: 
          localdsq.FYn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115906);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsq.FYo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 11: 
          localdsq.GaP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115906);
          return 0;
        }
        localdsq.GaQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115906);
        return 0;
      }
      AppMethodBeat.o(115906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsq
 * JD-Core Version:    0.7.0.1
 */