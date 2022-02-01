package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class agt
  extends cvc
{
  public String FGE;
  public b Gcf;
  public b GeN;
  public int tRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FGE != null) {
        paramVarArgs.d(2, this.FGE);
      }
      paramVarArgs.aS(3, this.tRT);
      if (this.GeN != null) {
        paramVarArgs.c(4, this.GeN);
      }
      if (this.Gcf != null) {
        paramVarArgs.c(5, this.Gcf);
      }
      AppMethodBeat.o(124485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FGE != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FGE);
      }
      i += f.a.a.b.b.a.bz(3, this.tRT);
      paramInt = i;
      if (this.GeN != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GeN);
      }
      i = paramInt;
      if (this.Gcf != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.Gcf);
      }
      AppMethodBeat.o(124485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agt localagt = (agt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124485);
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
            localagt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124485);
          return 0;
        case 2: 
          localagt.FGE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124485);
          return 0;
        case 3: 
          localagt.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124485);
          return 0;
        case 4: 
          localagt.GeN = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(124485);
          return 0;
        }
        localagt.Gcf = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(124485);
        return 0;
      }
      AppMethodBeat.o(124485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agt
 * JD-Core Version:    0.7.0.1
 */