package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cuh
  extends cpx
{
  public bjb DYb;
  public SKBuiltinBuffer_t EYm;
  public bjf FFQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYb == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.FFQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceMsg");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.EYm == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DYb != null)
      {
        paramVarArgs.ln(2, this.DYb.computeSize());
        this.DYb.writeFields(paramVarArgs);
      }
      if (this.FFQ != null)
      {
        paramVarArgs.ln(3, this.FFQ.computeSize());
        this.FFQ.writeFields(paramVarArgs);
      }
      if (this.EYm != null)
      {
        paramVarArgs.ln(4, this.EYm.computeSize());
        this.EYm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label932;
      }
    }
    label932:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DYb != null) {
        paramInt = i + f.a.a.a.lm(2, this.DYb.computeSize());
      }
      i = paramInt;
      if (this.FFQ != null) {
        i = paramInt + f.a.a.a.lm(3, this.FFQ.computeSize());
      }
      paramInt = i;
      if (this.EYm != null) {
        paramInt = i + f.a.a.a.lm(4, this.EYm.computeSize());
      }
      AppMethodBeat.o(32428);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DYb == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        if (this.FFQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceMsg");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        if (this.EYm == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuh localcuh = (cuh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32428);
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
            localcuh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuh.DYb = ((bjb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuh.FFQ = ((bjf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
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
          localcuh.EYm = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32428);
        return 0;
      }
      AppMethodBeat.o(32428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuh
 * JD-Core Version:    0.7.0.1
 */