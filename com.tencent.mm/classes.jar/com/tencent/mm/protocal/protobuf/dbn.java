package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dbn
  extends cpx
{
  public SKBuiltinBuffer_t FIP;
  public int FIR;
  public String FJm;
  public long FJn;
  public long FKA;
  public int FKB;
  public LinkedList<Long> FKC;
  public int FKD;
  public int FKE;
  public long FKF;
  public long FKG;
  public long FKy;
  public int FKz;
  
  public dbn()
  {
    AppMethodBeat.i(125826);
    this.FKC = new LinkedList();
    AppMethodBeat.o(125826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125827);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FJm != null) {
        paramVarArgs.d(2, this.FJm);
      }
      paramVarArgs.aO(3, this.FJn);
      paramVarArgs.aO(4, this.FKy);
      paramVarArgs.aR(5, this.FKz);
      paramVarArgs.aO(6, this.FKA);
      if (this.FIP != null)
      {
        paramVarArgs.ln(7, this.FIP.computeSize());
        this.FIP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.FIR);
      paramVarArgs.aR(11, this.FKB);
      paramVarArgs.f(12, 3, this.FKC);
      paramVarArgs.aR(13, this.FKD);
      paramVarArgs.aR(14, this.FKE);
      paramVarArgs.aO(15, this.FKF);
      paramVarArgs.aO(16, this.FKG);
      AppMethodBeat.o(125827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FJm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FJm);
      }
      i = i + f.a.a.b.b.a.p(3, this.FJn) + f.a.a.b.b.a.p(4, this.FKy) + f.a.a.b.b.a.bx(5, this.FKz) + f.a.a.b.b.a.p(6, this.FKA);
      paramInt = i;
      if (this.FIP != null) {
        paramInt = i + f.a.a.a.lm(7, this.FIP.computeSize());
      }
      i = f.a.a.b.b.a.bx(8, this.FIR);
      int j = f.a.a.b.b.a.bx(11, this.FKB);
      int k = f.a.a.a.d(12, 3, this.FKC);
      int m = f.a.a.b.b.a.bx(13, this.FKD);
      int n = f.a.a.b.b.a.bx(14, this.FKE);
      int i1 = f.a.a.b.b.a.p(15, this.FKF);
      int i2 = f.a.a.b.b.a.p(16, this.FKG);
      AppMethodBeat.o(125827);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FKC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbn localdbn = (dbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(125827);
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
            localdbn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 2: 
          localdbn.FJm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125827);
          return 0;
        case 3: 
          localdbn.FJn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125827);
          return 0;
        case 4: 
          localdbn.FKy = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125827);
          return 0;
        case 5: 
          localdbn.FKz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125827);
          return 0;
        case 6: 
          localdbn.FKA = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125827);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbn.FIP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 8: 
          localdbn.FIR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125827);
          return 0;
        case 11: 
          localdbn.FKB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125827);
          return 0;
        case 12: 
          localdbn.FKC = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfj();
          AppMethodBeat.o(125827);
          return 0;
        case 13: 
          localdbn.FKD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125827);
          return 0;
        case 14: 
          localdbn.FKE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125827);
          return 0;
        case 15: 
          localdbn.FKF = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125827);
          return 0;
        }
        localdbn.FKG = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(125827);
        return 0;
      }
      AppMethodBeat.o(125827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbn
 * JD-Core Version:    0.7.0.1
 */