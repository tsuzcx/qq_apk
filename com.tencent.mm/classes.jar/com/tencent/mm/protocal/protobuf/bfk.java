package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bfk
  extends cvc
{
  public double FIb;
  public double FIc;
  public double GBh;
  public double GBi;
  public String Gsr;
  public SKBuiltinBuffer_t GzA;
  public int GzC;
  public int OpCode;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56249);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GzA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56249);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Scene);
      paramVarArgs.aS(3, this.OpCode);
      if (this.Gsr != null) {
        paramVarArgs.d(4, this.Gsr);
      }
      if (this.GzA != null)
      {
        paramVarArgs.lC(5, this.GzA.computeSize());
        this.GzA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, this.FIb);
      paramVarArgs.e(7, this.FIc);
      paramVarArgs.e(8, this.GBh);
      paramVarArgs.e(9, this.GBi);
      paramVarArgs.aS(10, this.GzC);
      AppMethodBeat.o(56249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Scene) + f.a.a.b.b.a.bz(3, this.OpCode);
      paramInt = i;
      if (this.Gsr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gsr);
      }
      i = paramInt;
      if (this.GzA != null) {
        i = paramInt + f.a.a.a.lB(5, this.GzA.computeSize());
      }
      paramInt = f.a.a.b.b.a.alT(6);
      int j = f.a.a.b.b.a.alT(7);
      int k = f.a.a.b.b.a.alT(8);
      int m = f.a.a.b.b.a.alT(9);
      int n = f.a.a.b.b.a.bz(10, this.GzC);
      AppMethodBeat.o(56249);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GzA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56249);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56249);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfk localbfk = (bfk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56249);
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
            localbfk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 2: 
          localbfk.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56249);
          return 0;
        case 3: 
          localbfk.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56249);
          return 0;
        case 4: 
          localbfk.Gsr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(56249);
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
            localbfk.GzA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 6: 
          localbfk.FIb = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(56249);
          return 0;
        case 7: 
          localbfk.FIc = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(56249);
          return 0;
        case 8: 
          localbfk.GBh = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(56249);
          return 0;
        case 9: 
          localbfk.GBi = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(56249);
          return 0;
        }
        localbfk.GzC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(56249);
        return 0;
      }
      AppMethodBeat.o(56249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfk
 * JD-Core Version:    0.7.0.1
 */