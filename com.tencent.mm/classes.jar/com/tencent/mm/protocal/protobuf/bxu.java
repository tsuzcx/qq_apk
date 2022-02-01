package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bxu
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t FDQ;
  public String FEb;
  public String FEo;
  public afp FzR;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.FzR == null)
      {
        paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.FDQ != null)
      {
        paramVarArgs.lC(1, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      if (this.FzR != null)
      {
        paramVarArgs.lC(2, this.FzR.computeSize());
        this.FzR.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(3, this.nDo);
      }
      if (this.FEb != null) {
        paramVarArgs.d(4, this.FEb);
      }
      if (this.FEo != null) {
        paramVarArgs.d(5, this.FEo);
      }
      AppMethodBeat.o(133178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDQ == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.a.lB(1, this.FDQ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FzR != null) {
        paramInt = i + f.a.a.a.lB(2, this.FzR.computeSize());
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nDo);
      }
      paramInt = i;
      if (this.FEb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FEb);
      }
      i = paramInt;
      if (this.FEo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FEo);
      }
      AppMethodBeat.o(133178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FDQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        if (this.FzR == null)
        {
          paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxu localbxu = (bxu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133178);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxu.FDQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxu.FzR = ((afp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 3: 
          localbxu.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133178);
          return 0;
        case 4: 
          localbxu.FEb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133178);
          return 0;
        }
        localbxu.FEo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133178);
        return 0;
      }
      AppMethodBeat.o(133178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxu
 * JD-Core Version:    0.7.0.1
 */