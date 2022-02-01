package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dsy
  extends cpx
{
  public int EqS;
  public int Exf;
  public int FLI;
  public int FLJ;
  public int FLK;
  public int FLL;
  public int FLM;
  public LinkedList<Integer> FLN;
  public int FLO;
  public int FLP;
  public LinkedList<Integer> FLQ;
  public int FLR;
  public int FLS;
  
  public dsy()
  {
    AppMethodBeat.i(115916);
    this.FLN = new LinkedList();
    this.FLQ = new LinkedList();
    AppMethodBeat.o(115916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115917);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aR(3, this.FLI);
      paramVarArgs.aR(4, this.EqS);
      paramVarArgs.aR(5, this.FLJ);
      paramVarArgs.aR(6, this.FLK);
      paramVarArgs.aR(7, this.FLL);
      paramVarArgs.aR(8, this.FLM);
      paramVarArgs.f(9, 2, this.FLN);
      paramVarArgs.aR(10, this.FLO);
      paramVarArgs.aR(11, this.FLP);
      paramVarArgs.f(12, 2, this.FLQ);
      paramVarArgs.aR(13, this.FLR);
      paramVarArgs.aR(14, this.FLS);
      AppMethodBeat.o(115917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label984;
      }
    }
    label984:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Exf);
      int j = f.a.a.b.b.a.bx(3, this.FLI);
      int k = f.a.a.b.b.a.bx(4, this.EqS);
      int m = f.a.a.b.b.a.bx(5, this.FLJ);
      int n = f.a.a.b.b.a.bx(6, this.FLK);
      int i1 = f.a.a.b.b.a.bx(7, this.FLL);
      int i2 = f.a.a.b.b.a.bx(8, this.FLM);
      int i3 = f.a.a.a.d(9, 2, this.FLN);
      int i4 = f.a.a.b.b.a.bx(10, this.FLO);
      int i5 = f.a.a.b.b.a.bx(11, this.FLP);
      int i6 = f.a.a.a.d(12, 2, this.FLQ);
      int i7 = f.a.a.b.b.a.bx(13, this.FLR);
      int i8 = f.a.a.b.b.a.bx(14, this.FLS);
      AppMethodBeat.o(115917);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FLN.clear();
        this.FLQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsy localdsy = (dsy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115917);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsy.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115917);
          return 0;
        case 2: 
          localdsy.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 3: 
          localdsy.FLI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 4: 
          localdsy.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 5: 
          localdsy.FLJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 6: 
          localdsy.FLK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 7: 
          localdsy.FLL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 8: 
          localdsy.FLM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 9: 
          localdsy.FLN = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
          AppMethodBeat.o(115917);
          return 0;
        case 10: 
          localdsy.FLO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 11: 
          localdsy.FLP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        case 12: 
          localdsy.FLQ = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
          AppMethodBeat.o(115917);
          return 0;
        case 13: 
          localdsy.FLR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115917);
          return 0;
        }
        localdsy.FLS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115917);
        return 0;
      }
      AppMethodBeat.o(115917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsy
 * JD-Core Version:    0.7.0.1
 */