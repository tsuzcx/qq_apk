package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drk
  extends cvc
{
  public SKBuiltinBuffer_t FDQ;
  public String HEO;
  public String HEP;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130921);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HEO != null) {
        paramVarArgs.d(2, this.HEO);
      }
      if (this.HEP != null) {
        paramVarArgs.d(3, this.HEP);
      }
      paramVarArgs.aS(4, this.Scene);
      if (this.FDQ != null)
      {
        paramVarArgs.lC(5, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(130921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HEO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HEO);
      }
      i = paramInt;
      if (this.HEP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HEP);
      }
      i += f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.FDQ != null) {
        paramInt = i + f.a.a.a.lB(5, this.FDQ.computeSize());
      }
      AppMethodBeat.o(130921);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drk localdrk = (drk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130921);
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
            localdrk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(130921);
          return 0;
        case 2: 
          localdrk.HEO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 3: 
          localdrk.HEP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 4: 
          localdrk.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(130921);
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
          localdrk.FDQ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      AppMethodBeat.o(130921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drk
 * JD-Core Version:    0.7.0.1
 */