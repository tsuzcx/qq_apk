package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bga
  extends cpx
{
  public SKBuiltinBuffer_t DYu;
  public crm EVs;
  public crm EVt;
  public SKBuiltinBuffer_t EVu;
  public crm EuE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155420);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.EVs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Pwd");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EuE != null)
      {
        paramVarArgs.ln(2, this.EuE.computeSize());
        this.EuE.writeFields(paramVarArgs);
      }
      if (this.EVs != null)
      {
        paramVarArgs.ln(3, this.EVs.computeSize());
        this.EVs.writeFields(paramVarArgs);
      }
      if (this.EVt != null)
      {
        paramVarArgs.ln(4, this.EVt.computeSize());
        this.EVt.writeFields(paramVarArgs);
      }
      if (this.DYu != null)
      {
        paramVarArgs.ln(5, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      if (this.EVu != null)
      {
        paramVarArgs.ln(6, this.EVu.computeSize());
        this.EVu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1178;
      }
    }
    label1178:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EuE != null) {
        paramInt = i + f.a.a.a.lm(2, this.EuE.computeSize());
      }
      i = paramInt;
      if (this.EVs != null) {
        i = paramInt + f.a.a.a.lm(3, this.EVs.computeSize());
      }
      paramInt = i;
      if (this.EVt != null) {
        paramInt = i + f.a.a.a.lm(4, this.EVt.computeSize());
      }
      i = paramInt;
      if (this.DYu != null) {
        i = paramInt + f.a.a.a.lm(5, this.DYu.computeSize());
      }
      paramInt = i;
      if (this.EVu != null) {
        paramInt = i + f.a.a.a.lm(6, this.EVu.computeSize());
      }
      AppMethodBeat.o(155420);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EuE == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        if (this.EVs == null)
        {
          paramVarArgs = new b("Not all required fields were included: Pwd");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bga localbga = (bga)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155420);
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
            localbga.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbga.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbga.EVs = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbga.EVt = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
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
            localbga.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
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
          localbga.EVu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      AppMethodBeat.o(155420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bga
 * JD-Core Version:    0.7.0.1
 */