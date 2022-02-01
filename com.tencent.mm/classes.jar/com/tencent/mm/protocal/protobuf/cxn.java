package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cxn
  extends cpx
{
  public int DRa;
  public int ESF;
  public int ESG;
  public float Ehu;
  public int EqS;
  public int FHc;
  public float FHd;
  public float FHe;
  public int hNR;
  public SKBuiltinBuffer_t vTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32444);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vTK != null)
      {
        paramVarArgs.ln(2, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.FHc);
      paramVarArgs.aR(4, this.hNR);
      paramVarArgs.x(5, this.FHd);
      paramVarArgs.aR(6, this.EqS);
      paramVarArgs.aR(7, this.DRa);
      paramVarArgs.x(8, this.FHe);
      paramVarArgs.x(9, this.Ehu);
      paramVarArgs.aR(10, this.ESF);
      paramVarArgs.aR(11, this.ESG);
      AppMethodBeat.o(32444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label960;
      }
    }
    label960:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vTK != null) {
        i = paramInt + f.a.a.a.lm(2, this.vTK.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FHc);
      int j = f.a.a.b.b.a.bx(4, this.hNR);
      int k = f.a.a.b.b.a.fK(5);
      int m = f.a.a.b.b.a.bx(6, this.EqS);
      int n = f.a.a.b.b.a.bx(7, this.DRa);
      int i1 = f.a.a.b.b.a.fK(8);
      int i2 = f.a.a.b.b.a.fK(9);
      int i3 = f.a.a.b.b.a.bx(10, this.ESF);
      int i4 = f.a.a.b.b.a.bx(11, this.ESG);
      AppMethodBeat.o(32444);
      return i + paramInt + j + (k + 4) + m + n + (i1 + 4) + (i2 + 4) + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32444);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxn localcxn = (cxn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32444);
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
            localcxn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxn.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 3: 
          localcxn.FHc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32444);
          return 0;
        case 4: 
          localcxn.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32444);
          return 0;
        case 5: 
          localcxn.FHd = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32444);
          return 0;
        case 6: 
          localcxn.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32444);
          return 0;
        case 7: 
          localcxn.DRa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32444);
          return 0;
        case 8: 
          localcxn.FHe = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32444);
          return 0;
        case 9: 
          localcxn.Ehu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32444);
          return 0;
        case 10: 
          localcxn.ESF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32444);
          return 0;
        }
        localcxn.ESG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32444);
        return 0;
      }
      AppMethodBeat.o(32444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxn
 * JD-Core Version:    0.7.0.1
 */