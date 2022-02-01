package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxk
  extends cvc
{
  public long GeJ;
  public int HJW;
  public long HfW;
  public long HyS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125509);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HyS);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aY(4, this.HfW);
      paramVarArgs.aS(5, this.HJW);
      AppMethodBeat.o(125509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HyS);
      int j = f.a.a.b.b.a.p(3, this.GeJ);
      int k = f.a.a.b.b.a.p(4, this.HfW);
      int m = f.a.a.b.b.a.bz(5, this.HJW);
      AppMethodBeat.o(125509);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxk localdxk = (dxk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125509);
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
            localdxk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125509);
          return 0;
        case 2: 
          localdxk.HyS = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125509);
          return 0;
        case 3: 
          localdxk.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125509);
          return 0;
        case 4: 
          localdxk.HfW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125509);
          return 0;
        }
        localdxk.HJW = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125509);
        return 0;
      }
      AppMethodBeat.o(125509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxk
 * JD-Core Version:    0.7.0.1
 */