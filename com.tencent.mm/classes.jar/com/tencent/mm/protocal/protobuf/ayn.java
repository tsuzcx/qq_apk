package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayn
  extends cvc
{
  public String FQk;
  public long FQx;
  public int FRm;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114015);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FQk != null) {
        paramVarArgs.d(2, this.FQk);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.aY(5, this.FQx);
      paramVarArgs.aS(6, this.FRm);
      paramVarArgs.aS(7, this.scene);
      AppMethodBeat.o(114015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FQk != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FQk);
      }
      paramInt = f.a.a.b.b.a.alT(3);
      int j = f.a.a.b.b.a.alT(4);
      int k = f.a.a.b.b.a.p(5, this.FQx);
      int m = f.a.a.b.b.a.bz(6, this.FRm);
      int n = f.a.a.b.b.a.bz(7, this.scene);
      AppMethodBeat.o(114015);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayn localayn = (ayn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114015);
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
            localayn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114015);
          return 0;
        case 2: 
          localayn.FQk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114015);
          return 0;
        case 3: 
          localayn.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(114015);
          return 0;
        case 4: 
          localayn.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(114015);
          return 0;
        case 5: 
          localayn.FQx = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(114015);
          return 0;
        case 6: 
          localayn.FRm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114015);
          return 0;
        }
        localayn.scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(114015);
        return 0;
      }
      AppMethodBeat.o(114015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayn
 * JD-Core Version:    0.7.0.1
 */