package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmb
  extends cvc
{
  public int FuY;
  public int GeI;
  public long GeJ;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.FuY);
      paramVarArgs.aS(5, this.Scene);
      AppMethodBeat.o(32464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label505;
      }
    }
    label505:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GeI);
      int j = f.a.a.b.b.a.p(3, this.GeJ);
      int k = f.a.a.b.b.a.bz(4, this.FuY);
      int m = f.a.a.b.b.a.bz(5, this.Scene);
      AppMethodBeat.o(32464);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmb localdmb = (dmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32464);
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
            localdmb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32464);
          return 0;
        case 2: 
          localdmb.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32464);
          return 0;
        case 3: 
          localdmb.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32464);
          return 0;
        case 4: 
          localdmb.FuY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32464);
          return 0;
        }
        localdmb.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32464);
        return 0;
      }
      AppMethodBeat.o(32464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmb
 * JD-Core Version:    0.7.0.1
 */