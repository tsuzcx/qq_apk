package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgs
  extends cvc
{
  public SKBuiltinBuffer_t GBX;
  public int GBY;
  public int GBZ;
  public SKBuiltinBuffer_t GCa;
  public int ihv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63273);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GBX == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(63273);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ihv);
      if (this.GBX != null)
      {
        paramVarArgs.lC(3, this.GBX.computeSize());
        this.GBX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GBY);
      paramVarArgs.aS(5, this.GBZ);
      if (this.GCa != null)
      {
        paramVarArgs.lC(6, this.GCa.computeSize());
        this.GCa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(63273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ihv);
      paramInt = i;
      if (this.GBX != null) {
        paramInt = i + f.a.a.a.lB(3, this.GBX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GBY) + f.a.a.b.b.a.bz(5, this.GBZ);
      paramInt = i;
      if (this.GCa != null) {
        paramInt = i + f.a.a.a.lB(6, this.GCa.computeSize());
      }
      AppMethodBeat.o(63273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GBX == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(63273);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgs localbgs = (bgs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63273);
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
            localbgs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 2: 
          localbgs.ihv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(63273);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgs.GBX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 4: 
          localbgs.GBY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(63273);
          return 0;
        case 5: 
          localbgs.GBZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(63273);
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
          localbgs.GCa = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      AppMethodBeat.o(63273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgs
 * JD-Core Version:    0.7.0.1
 */