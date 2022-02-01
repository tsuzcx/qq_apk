package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwy
  extends cvc
{
  public int FzW;
  public long GeJ;
  public String HJO;
  public long HfW;
  public int HfX;
  public long HyS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HfX);
      paramVarArgs.aY(3, this.HyS);
      paramVarArgs.aY(4, this.GeJ);
      if (this.HJO != null) {
        paramVarArgs.d(5, this.HJO);
      }
      paramVarArgs.aY(6, this.HfW);
      paramVarArgs.aS(7, this.FzW);
      AppMethodBeat.o(125494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HfX) + f.a.a.b.b.a.p(3, this.HyS) + f.a.a.b.b.a.p(4, this.GeJ);
      paramInt = i;
      if (this.HJO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HJO);
      }
      i = f.a.a.b.b.a.p(6, this.HfW);
      int j = f.a.a.b.b.a.bz(7, this.FzW);
      AppMethodBeat.o(125494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwy localdwy = (dwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125494);
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
            localdwy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125494);
          return 0;
        case 2: 
          localdwy.HfX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125494);
          return 0;
        case 3: 
          localdwy.HyS = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125494);
          return 0;
        case 4: 
          localdwy.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125494);
          return 0;
        case 5: 
          localdwy.HJO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125494);
          return 0;
        case 6: 
          localdwy.HfW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125494);
          return 0;
        }
        localdwy.FzW = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125494);
        return 0;
      }
      AppMethodBeat.o(125494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwy
 * JD-Core Version:    0.7.0.1
 */