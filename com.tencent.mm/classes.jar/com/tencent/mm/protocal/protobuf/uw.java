package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class uw
  extends cvc
{
  public int FNY = 4;
  public b FTY;
  public b FTZ;
  public String paY;
  public int vls;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.vls);
      if (this.FTY != null) {
        paramVarArgs.c(3, this.FTY);
      }
      if (this.FTZ != null) {
        paramVarArgs.c(4, this.FTZ);
      }
      if (this.paY != null) {
        paramVarArgs.d(5, this.paY);
      }
      paramVarArgs.aS(6, this.FNY);
      AppMethodBeat.o(91410);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.vls);
      paramInt = i;
      if (this.FTY != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.FTY);
      }
      i = paramInt;
      if (this.FTZ != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.FTZ);
      }
      paramInt = i;
      if (this.paY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.paY);
      }
      i = f.a.a.b.b.a.bz(6, this.FNY);
      AppMethodBeat.o(91410);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91410);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uw localuw = (uw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91410);
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
            localuw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91410);
          return 0;
        case 2: 
          localuw.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91410);
          return 0;
        case 3: 
          localuw.FTY = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91410);
          return 0;
        case 4: 
          localuw.FTZ = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91410);
          return 0;
        case 5: 
          localuw.paY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91410);
          return 0;
        }
        localuw.FNY = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91410);
        return 0;
      }
      AppMethodBeat.o(91410);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uw
 * JD-Core Version:    0.7.0.1
 */