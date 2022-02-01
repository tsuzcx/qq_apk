package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dda
  extends cvc
{
  public float FOB;
  public int FYc;
  public int Fws;
  public int GBY;
  public int GBZ;
  public int HrK;
  public float HrL;
  public float HrM;
  public int ihf;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32444);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xcN != null)
      {
        paramVarArgs.lC(2, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HrK);
      paramVarArgs.aS(4, this.ihf);
      paramVarArgs.z(5, this.HrL);
      paramVarArgs.aS(6, this.FYc);
      paramVarArgs.aS(7, this.Fws);
      paramVarArgs.z(8, this.HrM);
      paramVarArgs.z(9, this.FOB);
      paramVarArgs.aS(10, this.GBY);
      paramVarArgs.aS(11, this.GBZ);
      AppMethodBeat.o(32444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label952;
      }
    }
    label952:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xcN != null) {
        i = paramInt + f.a.a.a.lB(2, this.xcN.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HrK);
      int j = f.a.a.b.b.a.bz(4, this.ihf);
      int k = f.a.a.b.b.a.alU(5);
      int m = f.a.a.b.b.a.bz(6, this.FYc);
      int n = f.a.a.b.b.a.bz(7, this.Fws);
      int i1 = f.a.a.b.b.a.alU(8);
      int i2 = f.a.a.b.b.a.alU(9);
      int i3 = f.a.a.b.b.a.bz(10, this.GBY);
      int i4 = f.a.a.b.b.a.bz(11, this.GBZ);
      AppMethodBeat.o(32444);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32444);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dda localdda = (dda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32444);
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
            localdda.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdda.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 3: 
          localdda.HrK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32444);
          return 0;
        case 4: 
          localdda.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32444);
          return 0;
        case 5: 
          localdda.HrL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(32444);
          return 0;
        case 6: 
          localdda.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32444);
          return 0;
        case 7: 
          localdda.Fws = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32444);
          return 0;
        case 8: 
          localdda.HrM = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(32444);
          return 0;
        case 9: 
          localdda.FOB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(32444);
          return 0;
        case 10: 
          localdda.GBY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32444);
          return 0;
        }
        localdda.GBZ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32444);
        return 0;
      }
      AppMethodBeat.o(32444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dda
 * JD-Core Version:    0.7.0.1
 */