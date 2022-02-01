package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class egk
  extends cvc
{
  public b FGF;
  public String GNH;
  public String HRz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123696);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GNH != null) {
        paramVarArgs.d(2, this.GNH);
      }
      if (this.FGF != null) {
        paramVarArgs.c(3, this.FGF);
      }
      if (this.HRz != null) {
        paramVarArgs.d(4, this.HRz);
      }
      AppMethodBeat.o(123696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GNH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GNH);
      }
      i = paramInt;
      if (this.FGF != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.FGF);
      }
      paramInt = i;
      if (this.HRz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HRz);
      }
      AppMethodBeat.o(123696);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        egk localegk = (egk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123696);
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
            localegk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123696);
          return 0;
        case 2: 
          localegk.GNH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 3: 
          localegk.FGF = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(123696);
          return 0;
        }
        localegk.HRz = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123696);
        return 0;
      }
      AppMethodBeat.o(123696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egk
 * JD-Core Version:    0.7.0.1
 */