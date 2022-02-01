package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crs
  extends ckq
{
  public SKBuiltinBuffer_t CBc;
  public String Ddo;
  public int EjU;
  public String oXj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oXj != null) {
        paramVarArgs.d(2, this.oXj);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(3, this.Ddo);
      }
      if (this.CBc != null)
      {
        paramVarArgs.kX(4, this.CBc.computeSize());
        this.CBc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.EjU);
      AppMethodBeat.o(134257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oXj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oXj);
      }
      i = paramInt;
      if (this.Ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ddo);
      }
      paramInt = i;
      if (this.CBc != null) {
        paramInt = i + f.a.a.a.kW(4, this.CBc.computeSize());
      }
      i = f.a.a.b.b.a.bA(5, this.EjU);
      AppMethodBeat.o(134257);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(134257);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crs localcrs = (crs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134257);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrs.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        case 2: 
          localcrs.oXj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 3: 
          localcrs.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrs.CBc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        }
        localcrs.EjU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(134257);
        return 0;
      }
      AppMethodBeat.o(134257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crs
 * JD-Core Version:    0.7.0.1
 */