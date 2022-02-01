package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbg
  extends cpx
{
  public String EJp;
  public SKBuiltinBuffer_t EQj;
  public int EQl;
  public double ERP;
  public double ERQ;
  public double Ecf;
  public double Ecg;
  public int OpCode;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56249);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EQj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56249);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Scene);
      paramVarArgs.aR(3, this.OpCode);
      if (this.EJp != null) {
        paramVarArgs.d(4, this.EJp);
      }
      if (this.EQj != null)
      {
        paramVarArgs.ln(5, this.EQj.computeSize());
        this.EQj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, this.Ecf);
      paramVarArgs.e(7, this.Ecg);
      paramVarArgs.e(8, this.ERP);
      paramVarArgs.e(9, this.ERQ);
      paramVarArgs.aR(10, this.EQl);
      AppMethodBeat.o(56249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Scene) + f.a.a.b.b.a.bx(3, this.OpCode);
      paramInt = i;
      if (this.EJp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EJp);
      }
      i = paramInt;
      if (this.EQj != null) {
        i = paramInt + f.a.a.a.lm(5, this.EQj.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(6);
      int j = f.a.a.b.b.a.fK(7);
      int k = f.a.a.b.b.a.fK(8);
      int m = f.a.a.b.b.a.fK(9);
      int n = f.a.a.b.b.a.bx(10, this.EQl);
      AppMethodBeat.o(56249);
      return i + (paramInt + 8) + (j + 8) + (k + 8) + (m + 8) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EQj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56249);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56249);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbg localbbg = (bbg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56249);
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
            localbbg.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 2: 
          localbbg.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(56249);
          return 0;
        case 3: 
          localbbg.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(56249);
          return 0;
        case 4: 
          localbbg.EJp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(56249);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbg.EQj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 6: 
          localbbg.Ecf = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(56249);
          return 0;
        case 7: 
          localbbg.Ecg = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(56249);
          return 0;
        case 8: 
          localbbg.ERP = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(56249);
          return 0;
        case 9: 
          localbbg.ERQ = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(56249);
          return 0;
        }
        localbbg.EQl = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(56249);
        return 0;
      }
      AppMethodBeat.o(56249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbg
 * JD-Core Version:    0.7.0.1
 */