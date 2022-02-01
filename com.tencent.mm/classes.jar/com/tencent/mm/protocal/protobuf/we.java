package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class we
  extends cvc
{
  public String FVD;
  public String FVE;
  public String dkR;
  public String uJF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FVD != null) {
        paramVarArgs.d(2, this.FVD);
      }
      if (this.FVE != null) {
        paramVarArgs.d(3, this.FVE);
      }
      if (this.uJF != null) {
        paramVarArgs.d(4, this.uJF);
      }
      if (this.dkR != null) {
        paramVarArgs.d(5, this.dkR);
      }
      AppMethodBeat.o(72452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FVD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FVD);
      }
      i = paramInt;
      if (this.FVE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVE);
      }
      paramInt = i;
      if (this.uJF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uJF);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dkR);
      }
      AppMethodBeat.o(72452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        we localwe = (we)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72452);
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
            localwe.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72452);
          return 0;
        case 2: 
          localwe.FVD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 3: 
          localwe.FVE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 4: 
          localwe.uJF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72452);
          return 0;
        }
        localwe.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72452);
        return 0;
      }
      AppMethodBeat.o(72452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.we
 * JD-Core Version:    0.7.0.1
 */