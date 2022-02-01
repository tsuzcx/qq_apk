package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axh
  extends cvc
{
  public SKBuiltinBuffer_t FDQ;
  public String Gvv;
  public int Gvw;
  public int Scene;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.Scene);
      if (this.Gvv != null) {
        paramVarArgs.d(4, this.Gvv);
      }
      if (this.FDQ != null)
      {
        paramVarArgs.lC(5, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Gvw);
      AppMethodBeat.o(104367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.Gvv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gvv);
      }
      i = paramInt;
      if (this.FDQ != null) {
        i = paramInt + f.a.a.a.lB(5, this.FDQ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Gvw);
      AppMethodBeat.o(104367);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104367);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axh localaxh = (axh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104367);
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
            localaxh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        case 2: 
          localaxh.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104367);
          return 0;
        case 3: 
          localaxh.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104367);
          return 0;
        case 4: 
          localaxh.Gvv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104367);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxh.FDQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        }
        localaxh.Gvw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104367);
        return 0;
      }
      AppMethodBeat.o(104367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axh
 * JD-Core Version:    0.7.0.1
 */