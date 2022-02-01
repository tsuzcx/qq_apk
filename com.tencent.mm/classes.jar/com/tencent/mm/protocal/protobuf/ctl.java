package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctl
  extends cvc
{
  public int FEY;
  public LinkedList<nx> HlE;
  public int HlF;
  public int HlG;
  
  public ctl()
  {
    AppMethodBeat.i(6424);
    this.HlE = new LinkedList();
    AppMethodBeat.o(6424);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.HlE);
      paramVarArgs.aS(3, this.HlF);
      paramVarArgs.aS(4, this.HlG);
      paramVarArgs.aS(5, this.FEY);
      AppMethodBeat.o(6425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label601;
      }
    }
    label601:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.HlE);
      int j = f.a.a.b.b.a.bz(3, this.HlF);
      int k = f.a.a.b.b.a.bz(4, this.HlG);
      int m = f.a.a.b.b.a.bz(5, this.FEY);
      AppMethodBeat.o(6425);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HlE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(6425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctl localctl = (ctl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6425);
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
            localctl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctl.HlE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 3: 
          localctl.HlF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6425);
          return 0;
        case 4: 
          localctl.HlG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6425);
          return 0;
        }
        localctl.FEY = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(6425);
        return 0;
      }
      AppMethodBeat.o(6425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctl
 * JD-Core Version:    0.7.0.1
 */