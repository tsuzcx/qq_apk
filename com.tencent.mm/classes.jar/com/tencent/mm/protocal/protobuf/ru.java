package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ru
  extends cvc
{
  public b FNU;
  public b FNV;
  public int FNW;
  public int FNX;
  public int FNY;
  public int inh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FNU != null) {
        paramVarArgs.c(2, this.FNU);
      }
      paramVarArgs.aS(3, this.inh);
      if (this.FNV != null) {
        paramVarArgs.c(4, this.FNV);
      }
      paramVarArgs.aS(5, this.FNW);
      paramVarArgs.aS(6, this.FNX);
      paramVarArgs.aS(7, this.FNY);
      AppMethodBeat.o(219340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FNU != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FNU);
      }
      i += f.a.a.b.b.a.bz(3, this.inh);
      paramInt = i;
      if (this.FNV != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FNV);
      }
      i = f.a.a.b.b.a.bz(5, this.FNW);
      int j = f.a.a.b.b.a.bz(6, this.FNX);
      int k = f.a.a.b.b.a.bz(7, this.FNY);
      AppMethodBeat.o(219340);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(219340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ru localru = (ru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(219340);
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
            localru.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(219340);
          return 0;
        case 2: 
          localru.FNU = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(219340);
          return 0;
        case 3: 
          localru.inh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(219340);
          return 0;
        case 4: 
          localru.FNV = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(219340);
          return 0;
        case 5: 
          localru.FNW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(219340);
          return 0;
        case 6: 
          localru.FNX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(219340);
          return 0;
        }
        localru.FNY = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(219340);
        return 0;
      }
      AppMethodBeat.o(219340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ru
 * JD-Core Version:    0.7.0.1
 */