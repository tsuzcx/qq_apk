package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class air
  extends cvc
{
  public int GfX;
  public int dNM;
  public double latitude;
  public double longitude;
  public int par;
  public int wNV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.par);
      paramVarArgs.aS(3, this.wNV);
      paramVarArgs.aS(4, this.dNM);
      paramVarArgs.aS(5, this.GfX);
      paramVarArgs.e(6, this.latitude);
      paramVarArgs.e(7, this.longitude);
      AppMethodBeat.o(91456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.par);
      int j = f.a.a.b.b.a.bz(3, this.wNV);
      int k = f.a.a.b.b.a.bz(4, this.dNM);
      int m = f.a.a.b.b.a.bz(5, this.GfX);
      int n = f.a.a.b.b.a.alT(6);
      int i1 = f.a.a.b.b.a.alT(7);
      AppMethodBeat.o(91456);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91456);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        air localair = (air)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91456);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localair.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91456);
          return 0;
        case 2: 
          localair.par = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91456);
          return 0;
        case 3: 
          localair.wNV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91456);
          return 0;
        case 4: 
          localair.dNM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91456);
          return 0;
        case 5: 
          localair.GfX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91456);
          return 0;
        case 6: 
          localair.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(91456);
          return 0;
        }
        localair.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(91456);
        return 0;
      }
      AppMethodBeat.o(91456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.air
 * JD-Core Version:    0.7.0.1
 */