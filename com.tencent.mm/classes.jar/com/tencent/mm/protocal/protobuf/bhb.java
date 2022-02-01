package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhb
  extends cpx
{
  public SKBuiltinBuffer_t DTI;
  public SKBuiltinBuffer_t EKU;
  public String EWe;
  public int Scene;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32315);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTI == null)
      {
        paramVarArgs = new b("Not all required fields were included: A2Key");
        AppMethodBeat.o(32315);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DTI != null)
      {
        paramVarArgs.ln(2, this.DTI.computeSize());
        this.DTI.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(3, this.ncR);
      }
      paramVarArgs.aR(4, this.Scene);
      if (this.EWe != null) {
        paramVarArgs.d(5, this.EWe);
      }
      if (this.EKU != null)
      {
        paramVarArgs.ln(6, this.EKU.computeSize());
        this.EKU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DTI != null) {
        paramInt = i + f.a.a.a.lm(2, this.DTI.computeSize());
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ncR);
      }
      i += f.a.a.b.b.a.bx(4, this.Scene);
      paramInt = i;
      if (this.EWe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EWe);
      }
      i = paramInt;
      if (this.EKU != null) {
        i = paramInt + f.a.a.a.lm(6, this.EKU.computeSize());
      }
      AppMethodBeat.o(32315);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DTI == null)
        {
          paramVarArgs = new b("Not all required fields were included: A2Key");
          AppMethodBeat.o(32315);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhb localbhb = (bhb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32315);
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
            localbhb.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
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
            localbhb.DTI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
          return 0;
        case 3: 
          localbhb.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32315);
          return 0;
        case 4: 
          localbhb.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32315);
          return 0;
        case 5: 
          localbhb.EWe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32315);
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
          localbhb.EKU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      AppMethodBeat.o(32315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhb
 * JD-Core Version:    0.7.0.1
 */