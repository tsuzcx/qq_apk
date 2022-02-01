package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddc
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
  public int HrV;
  public int HrW;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32446);
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
      paramVarArgs.aS(8, this.HrV);
      paramVarArgs.aS(9, this.HrW);
      paramVarArgs.aS(10, this.Ggz);
      if (this.FzK != null)
      {
        paramVarArgs.lC(11, this.FzK.computeSize());
        this.FzK.writeFields(paramVarArgs);
      }
      if (this.FzL != null)
      {
        paramVarArgs.lC(12, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
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
      i = i + f.a.a.b.b.a.bz(8, this.HrV) + f.a.a.b.b.a.bz(9, this.HrW) + f.a.a.b.b.a.bz(10, this.Ggz);
      paramInt = i;
      if (this.FzK != null) {
        paramInt = i + f.a.a.a.lB(11, this.FzK.computeSize());
      }
      i = paramInt;
      if (this.FzL != null) {
        i = paramInt + f.a.a.a.lB(12, this.FzL.computeSize());
      }
      AppMethodBeat.o(32446);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddc localddc = (ddc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32446);
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
            localddc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32446);
          return 0;
        case 2: 
          localddc.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 3: 
          localddc.FOA = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(32446);
          return 0;
        case 4: 
          localddc.FOB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(32446);
          return 0;
        case 5: 
          localddc.Ggw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 6: 
          localddc.Ggx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32446);
          return 0;
        case 7: 
          localddc.Ggy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32446);
          return 0;
        case 8: 
          localddc.HrV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 9: 
          localddc.HrW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 10: 
          localddc.Ggz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddc.FzK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32446);
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
          localddc.FzL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32446);
        return 0;
      }
      AppMethodBeat.o(32446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddc
 * JD-Core Version:    0.7.0.1
 */