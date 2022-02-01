package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bxs
  extends cpx
{
  public SKBuiltinBuffer_t Fms;
  public SKBuiltinBuffer_t Fmt;
  public String ncR;
  public String pAD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133181);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fms == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133181);
        throw paramVarArgs;
      }
      if (this.Fmt == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133181);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.Fms != null)
      {
        paramVarArgs.ln(3, this.Fms.computeSize());
        this.Fms.writeFields(paramVarArgs);
      }
      if (this.Fmt != null)
      {
        paramVarArgs.ln(4, this.Fmt.computeSize());
        this.Fmt.writeFields(paramVarArgs);
      }
      if (this.pAD != null) {
        paramVarArgs.d(5, this.pAD);
      }
      AppMethodBeat.o(133181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.Fms != null) {
        i = paramInt + f.a.a.a.lm(3, this.Fms.computeSize());
      }
      paramInt = i;
      if (this.Fmt != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fmt.computeSize());
      }
      i = paramInt;
      if (this.pAD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.pAD);
      }
      AppMethodBeat.o(133181);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fms == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133181);
          throw paramVarArgs;
        }
        if (this.Fmt == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(133181);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133181);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxs localbxs = (bxs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133181);
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
            localbxs.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        case 2: 
          localbxs.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133181);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxs.Fms = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
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
            localbxs.Fmt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        }
        localbxs.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133181);
        return 0;
      }
      AppMethodBeat.o(133181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxs
 * JD-Core Version:    0.7.0.1
 */