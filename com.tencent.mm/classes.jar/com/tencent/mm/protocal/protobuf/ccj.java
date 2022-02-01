package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ccj
  extends cvc
{
  public SKBuiltinBuffer_t GWb;
  public SKBuiltinBuffer_t GWc;
  public String nDo;
  public String qei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133181);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GWb == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133181);
        throw paramVarArgs;
      }
      if (this.GWc == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133181);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.GWb != null)
      {
        paramVarArgs.lC(3, this.GWb.computeSize());
        this.GWb.writeFields(paramVarArgs);
      }
      if (this.GWc != null)
      {
        paramVarArgs.lC(4, this.GWc.computeSize());
        this.GWc.writeFields(paramVarArgs);
      }
      if (this.qei != null) {
        paramVarArgs.d(5, this.qei);
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
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.GWb != null) {
        i = paramInt + f.a.a.a.lB(3, this.GWb.computeSize());
      }
      paramInt = i;
      if (this.GWc != null) {
        paramInt = i + f.a.a.a.lB(4, this.GWc.computeSize());
      }
      i = paramInt;
      if (this.qei != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.qei);
      }
      AppMethodBeat.o(133181);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GWb == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133181);
          throw paramVarArgs;
        }
        if (this.GWc == null)
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
        ccj localccj = (ccj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133181);
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
            localccj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        case 2: 
          localccj.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133181);
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
            localccj.GWb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccj.GWc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        }
        localccj.qei = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133181);
        return 0;
      }
      AppMethodBeat.o(133181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccj
 * JD-Core Version:    0.7.0.1
 */