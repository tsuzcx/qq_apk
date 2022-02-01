package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bto
  extends cvc
{
  public float FOA;
  public float FOB;
  public SKBuiltinBuffer_t FzK;
  public SKBuiltinBuffer_t FzL;
  public int Ggw;
  public String Ggx;
  public String Ggy;
  public int Ggz;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      paramVarArgs.z(3, this.FOA);
      paramVarArgs.z(4, this.FOB);
      paramVarArgs.aS(5, this.Ggw);
      if (this.Ggx != null) {
        paramVarArgs.d(6, this.Ggx);
      }
      if (this.Ggy != null) {
        paramVarArgs.d(7, this.Ggy);
      }
      paramVarArgs.aS(8, this.Ggz);
      if (this.FzK != null)
      {
        paramVarArgs.lC(9, this.FzK.computeSize());
        this.FzK.writeFields(paramVarArgs);
      }
      if (this.FzL != null)
      {
        paramVarArgs.lC(10, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label960;
      }
    }
    label960:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode) + f.a.a.b.b.a.alU(3) + f.a.a.b.b.a.alU(4) + f.a.a.b.b.a.bz(5, this.Ggw);
      paramInt = i;
      if (this.Ggx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ggx);
      }
      i = paramInt;
      if (this.Ggy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ggy);
      }
      i += f.a.a.b.b.a.bz(8, this.Ggz);
      paramInt = i;
      if (this.FzK != null) {
        paramInt = i + f.a.a.a.lB(9, this.FzK.computeSize());
      }
      i = paramInt;
      if (this.FzL != null) {
        i = paramInt + f.a.a.a.lB(10, this.FzL.computeSize());
      }
      AppMethodBeat.o(89926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(89926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bto localbto = (bto)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89926);
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
            localbto.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89926);
          return 0;
        case 2: 
          localbto.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89926);
          return 0;
        case 3: 
          localbto.FOA = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(89926);
          return 0;
        case 4: 
          localbto.FOB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(89926);
          return 0;
        case 5: 
          localbto.Ggw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89926);
          return 0;
        case 6: 
          localbto.Ggx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89926);
          return 0;
        case 7: 
          localbto.Ggy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89926);
          return 0;
        case 8: 
          localbto.Ggz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89926);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbto.FzK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89926);
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
          localbto.FzL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89926);
        return 0;
      }
      AppMethodBeat.o(89926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bto
 * JD-Core Version:    0.7.0.1
 */