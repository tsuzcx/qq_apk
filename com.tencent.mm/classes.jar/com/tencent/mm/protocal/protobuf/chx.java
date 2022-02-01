package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chx
  extends cpx
{
  public int EqS;
  public long FvQ;
  public int FvR;
  public String FvS;
  public int FvZ;
  public int Fwa;
  public int Fwb;
  public String tlJ;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tlK != null) {
        paramVarArgs.d(2, this.tlK);
      }
      if (this.FvS != null) {
        paramVarArgs.d(3, this.FvS);
      }
      paramVarArgs.aR(4, this.EqS);
      paramVarArgs.aO(5, this.FvQ);
      paramVarArgs.aR(6, this.FvR);
      if (this.tlJ != null) {
        paramVarArgs.d(7, this.tlJ);
      }
      paramVarArgs.aR(8, this.Fwa);
      paramVarArgs.aR(9, this.FvZ);
      paramVarArgs.aR(10, this.Fwb);
      AppMethodBeat.o(32378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tlK);
      }
      i = paramInt;
      if (this.FvS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FvS);
      }
      i = i + f.a.a.b.b.a.bx(4, this.EqS) + f.a.a.b.b.a.p(5, this.FvQ) + f.a.a.b.b.a.bx(6, this.FvR);
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.tlJ);
      }
      i = f.a.a.b.b.a.bx(8, this.Fwa);
      int j = f.a.a.b.b.a.bx(9, this.FvZ);
      int k = f.a.a.b.b.a.bx(10, this.Fwb);
      AppMethodBeat.o(32378);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chx localchx = (chx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32378);
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
            localchx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32378);
          return 0;
        case 2: 
          localchx.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 3: 
          localchx.FvS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 4: 
          localchx.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32378);
          return 0;
        case 5: 
          localchx.FvQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32378);
          return 0;
        case 6: 
          localchx.FvR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32378);
          return 0;
        case 7: 
          localchx.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 8: 
          localchx.Fwa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32378);
          return 0;
        case 9: 
          localchx.FvZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32378);
          return 0;
        }
        localchx.Fwb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32378);
        return 0;
      }
      AppMethodBeat.o(32378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chx
 * JD-Core Version:    0.7.0.1
 */