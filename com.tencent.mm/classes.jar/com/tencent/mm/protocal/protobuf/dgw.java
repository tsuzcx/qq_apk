package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgw
  extends cpx
{
  public int EZN;
  public int EZO;
  public SKBuiltinBuffer_t EZP;
  public String FPZ;
  public SKBuiltinBuffer_t Ftw;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EZP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqText");
        AppMethodBeat.o(91711);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EZN);
      paramVarArgs.aR(3, this.EZO);
      if (this.EZP != null)
      {
        paramVarArgs.ln(4, this.EZP.computeSize());
        this.EZP.writeFields(paramVarArgs);
      }
      if (this.Ftw != null)
      {
        paramVarArgs.ln(5, this.Ftw.computeSize());
        this.Ftw.writeFields(paramVarArgs);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.FPZ != null) {
        paramVarArgs.d(7, this.FPZ);
      }
      AppMethodBeat.o(91711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EZN) + f.a.a.b.b.a.bx(3, this.EZO);
      paramInt = i;
      if (this.EZP != null) {
        paramInt = i + f.a.a.a.lm(4, this.EZP.computeSize());
      }
      i = paramInt;
      if (this.Ftw != null) {
        i = paramInt + f.a.a.a.lm(5, this.Ftw.computeSize());
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.FPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FPZ);
      }
      AppMethodBeat.o(91711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EZP == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqText");
          AppMethodBeat.o(91711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgw localdgw = (dgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91711);
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
            localdgw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 2: 
          localdgw.EZN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91711);
          return 0;
        case 3: 
          localdgw.EZO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91711);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgw.EZP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
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
            localdgw.Ftw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 6: 
          localdgw.sign = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91711);
          return 0;
        }
        localdgw.FPZ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91711);
        return 0;
      }
      AppMethodBeat.o(91711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgw
 * JD-Core Version:    0.7.0.1
 */