package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxp
  extends cpx
{
  public SKBuiltinBuffer_t DUq;
  public SKBuiltinBuffer_t DUr;
  public float Eht;
  public float Ehu;
  public int EyK;
  public String EyL;
  public String EyM;
  public int EyN;
  public int FHn;
  public int FHo;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.x(3, this.Eht);
      paramVarArgs.x(4, this.Ehu);
      paramVarArgs.aR(5, this.EyK);
      if (this.EyL != null) {
        paramVarArgs.d(6, this.EyL);
      }
      if (this.EyM != null) {
        paramVarArgs.d(7, this.EyM);
      }
      paramVarArgs.aR(8, this.FHn);
      paramVarArgs.aR(9, this.FHo);
      paramVarArgs.aR(10, this.EyN);
      if (this.DUq != null)
      {
        paramVarArgs.ln(11, this.DUq.computeSize());
        this.DUq.writeFields(paramVarArgs);
      }
      if (this.DUr != null)
      {
        paramVarArgs.ln(12, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1070;
      }
    }
    label1070:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.OpCode) + (f.a.a.b.b.a.fK(3) + 4) + (f.a.a.b.b.a.fK(4) + 4) + f.a.a.b.b.a.bx(5, this.EyK);
      paramInt = i;
      if (this.EyL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EyL);
      }
      i = paramInt;
      if (this.EyM != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EyM);
      }
      i = i + f.a.a.b.b.a.bx(8, this.FHn) + f.a.a.b.b.a.bx(9, this.FHo) + f.a.a.b.b.a.bx(10, this.EyN);
      paramInt = i;
      if (this.DUq != null) {
        paramInt = i + f.a.a.a.lm(11, this.DUq.computeSize());
      }
      i = paramInt;
      if (this.DUr != null) {
        i = paramInt + f.a.a.a.lm(12, this.DUr.computeSize());
      }
      AppMethodBeat.o(32446);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxp localcxp = (cxp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32446);
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
            localcxp.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32446);
          return 0;
        case 2: 
          localcxp.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32446);
          return 0;
        case 3: 
          localcxp.Eht = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32446);
          return 0;
        case 4: 
          localcxp.Ehu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32446);
          return 0;
        case 5: 
          localcxp.EyK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32446);
          return 0;
        case 6: 
          localcxp.EyL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32446);
          return 0;
        case 7: 
          localcxp.EyM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32446);
          return 0;
        case 8: 
          localcxp.FHn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32446);
          return 0;
        case 9: 
          localcxp.FHo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32446);
          return 0;
        case 10: 
          localcxp.EyN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32446);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxp.DUq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32446);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxp.DUr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32446);
        return 0;
      }
      AppMethodBeat.o(32446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxp
 * JD-Core Version:    0.7.0.1
 */