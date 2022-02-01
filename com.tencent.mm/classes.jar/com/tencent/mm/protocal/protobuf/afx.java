package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afx
  extends cpx
{
  public String Eyf;
  public String Eyg;
  public long Eyh;
  public double Eyi;
  public double Eyj;
  public String exV;
  public String exW;
  public String pBl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pBl != null) {
        paramVarArgs.d(2, this.pBl);
      }
      if (this.exW != null) {
        paramVarArgs.d(3, this.exW);
      }
      if (this.exV != null) {
        paramVarArgs.d(4, this.exV);
      }
      if (this.Eyf != null) {
        paramVarArgs.d(5, this.Eyf);
      }
      if (this.Eyg != null) {
        paramVarArgs.d(6, this.Eyg);
      }
      paramVarArgs.aO(7, this.Eyh);
      paramVarArgs.e(8, this.Eyi);
      paramVarArgs.e(9, this.Eyj);
      AppMethodBeat.o(91452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label760;
      }
    }
    label760:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pBl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pBl);
      }
      i = paramInt;
      if (this.exW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.exW);
      }
      paramInt = i;
      if (this.exV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.exV);
      }
      i = paramInt;
      if (this.Eyf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eyf);
      }
      paramInt = i;
      if (this.Eyg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Eyg);
      }
      i = f.a.a.b.b.a.p(7, this.Eyh);
      int j = f.a.a.b.b.a.fK(8);
      int k = f.a.a.b.b.a.fK(9);
      AppMethodBeat.o(91452);
      return paramInt + i + (j + 8) + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afx localafx = (afx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91452);
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
            localafx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91452);
          return 0;
        case 2: 
          localafx.pBl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 3: 
          localafx.exW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 4: 
          localafx.exV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 5: 
          localafx.Eyf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 6: 
          localafx.Eyg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 7: 
          localafx.Eyh = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91452);
          return 0;
        case 8: 
          localafx.Eyi = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(91452);
          return 0;
        }
        localafx.Eyj = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(91452);
        return 0;
      }
      AppMethodBeat.o(91452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afx
 * JD-Core Version:    0.7.0.1
 */