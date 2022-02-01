package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bnl
  extends cvc
{
  public bnj FDx;
  public int GHG;
  public SKBuiltinBuffer_t GHH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32318);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDx == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32318);
        throw paramVarArgs;
      }
      if (this.GHH == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthBuffer");
        AppMethodBeat.o(32318);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FDx != null)
      {
        paramVarArgs.lC(2, this.FDx.computeSize());
        this.FDx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GHG);
      if (this.GHH != null)
      {
        paramVarArgs.lC(4, this.GHH.computeSize());
        this.GHH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32318);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label772;
      }
    }
    label772:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FDx != null) {
        i = paramInt + f.a.a.a.lB(2, this.FDx.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.GHG);
      paramInt = i;
      if (this.GHH != null) {
        paramInt = i + f.a.a.a.lB(4, this.GHH.computeSize());
      }
      AppMethodBeat.o(32318);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FDx == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32318);
          throw paramVarArgs;
        }
        if (this.GHH == null)
        {
          paramVarArgs = new b("Not all required fields were included: AuthBuffer");
          AppMethodBeat.o(32318);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32318);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnl localbnl = (bnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32318);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32318);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnl.FDx = ((bnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32318);
          return 0;
        case 3: 
          localbnl.GHG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32318);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbnl.GHH = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32318);
        return 0;
      }
      AppMethodBeat.o(32318);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnl
 * JD-Core Version:    0.7.0.1
 */