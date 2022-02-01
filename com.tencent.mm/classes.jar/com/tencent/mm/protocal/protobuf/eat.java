package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eat
  extends com.tencent.mm.bx.a
{
  public String FEp;
  public SKBuiltinBuffer_t FEt;
  public SKBuiltinBuffer_t Fvm;
  public String HNB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133207);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FEt == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.HNB != null) {
        paramVarArgs.d(1, this.HNB);
      }
      if (this.FEt != null)
      {
        paramVarArgs.lC(2, this.FEt.computeSize());
        this.FEt.writeFields(paramVarArgs);
      }
      if (this.FEp != null) {
        paramVarArgs.d(3, this.FEp);
      }
      if (this.Fvm != null)
      {
        paramVarArgs.lC(4, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HNB == null) {
        break label682;
      }
    }
    label682:
    for (int i = f.a.a.b.b.a.e(1, this.HNB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FEt != null) {
        paramInt = i + f.a.a.a.lB(2, this.FEt.computeSize());
      }
      i = paramInt;
      if (this.FEp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FEp);
      }
      paramInt = i;
      if (this.Fvm != null) {
        paramInt = i + f.a.a.a.lB(4, this.Fvm.computeSize());
      }
      AppMethodBeat.o(133207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FEt == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        if (this.Fvm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eat localeat = (eat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133207);
          return -1;
        case 1: 
          localeat.HNB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133207);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeat.FEt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133207);
          return 0;
        case 3: 
          localeat.FEp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133207);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeat.Fvm = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      AppMethodBeat.o(133207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eat
 * JD-Core Version:    0.7.0.1
 */