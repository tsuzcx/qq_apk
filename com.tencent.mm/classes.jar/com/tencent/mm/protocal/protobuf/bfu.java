package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfu
  extends cvc
{
  public int FCo;
  public int FCp;
  public int GBv;
  public int GBw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FCo);
      paramVarArgs.aS(3, this.FCp);
      paramVarArgs.aS(4, this.GBv);
      paramVarArgs.aS(5, this.GBw);
      AppMethodBeat.o(91499);
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
      int i = f.a.a.b.b.a.bz(2, this.FCo);
      int j = f.a.a.b.b.a.bz(3, this.FCp);
      int k = f.a.a.b.b.a.bz(4, this.GBv);
      int m = f.a.a.b.b.a.bz(5, this.GBw);
      AppMethodBeat.o(91499);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfu localbfu = (bfu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91499);
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
            localbfu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91499);
          return 0;
        case 2: 
          localbfu.FCo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91499);
          return 0;
        case 3: 
          localbfu.FCp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91499);
          return 0;
        case 4: 
          localbfu.GBv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91499);
          return 0;
        }
        localbfu.GBw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91499);
        return 0;
      }
      AppMethodBeat.o(91499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfu
 * JD-Core Version:    0.7.0.1
 */