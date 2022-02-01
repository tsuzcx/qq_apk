package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dby
  extends cvc
{
  public int GvE;
  public nl GvG;
  public int mask;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124551);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GvG == null)
      {
        paramVarArgs = new b("Not all required fields were included: attr");
        AppMethodBeat.o(124551);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GvE);
      paramVarArgs.aS(3, this.mask);
      if (this.GvG != null)
      {
        paramVarArgs.lC(4, this.GvG.computeSize());
        this.GvG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GvE) + f.a.a.b.b.a.bz(3, this.mask);
      paramInt = i;
      if (this.GvG != null) {
        paramInt = i + f.a.a.a.lB(4, this.GvG.computeSize());
      }
      AppMethodBeat.o(124551);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GvG == null)
        {
          paramVarArgs = new b("Not all required fields were included: attr");
          AppMethodBeat.o(124551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dby localdby = (dby)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124551);
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
            localdby.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124551);
          return 0;
        case 2: 
          localdby.GvE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124551);
          return 0;
        case 3: 
          localdby.mask = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124551);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdby.GvG = ((nl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124551);
        return 0;
      }
      AppMethodBeat.o(124551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dby
 * JD-Core Version:    0.7.0.1
 */