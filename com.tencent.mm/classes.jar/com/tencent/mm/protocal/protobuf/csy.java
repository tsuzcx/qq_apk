package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csy
  extends cvc
{
  public int Hli;
  public dwk Hlj;
  public int Hlk;
  public int nEe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hlj == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nEe);
      paramVarArgs.aS(3, this.Hli);
      if (this.Hlj != null)
      {
        paramVarArgs.lC(4, this.Hlj.computeSize());
        this.Hlj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Hlk);
      AppMethodBeat.o(32412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label657;
      }
    }
    label657:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEe) + f.a.a.b.b.a.bz(3, this.Hli);
      paramInt = i;
      if (this.Hlj != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hlj.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.Hlk);
      AppMethodBeat.o(32412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hlj == null)
        {
          paramVarArgs = new b("Not all required fields were included: PieceData");
          AppMethodBeat.o(32412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csy localcsy = (csy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32412);
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
            localcsy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        case 2: 
          localcsy.nEe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32412);
          return 0;
        case 3: 
          localcsy.Hli = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32412);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsy.Hlj = ((dwk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        }
        localcsy.Hlk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32412);
        return 0;
      }
      AppMethodBeat.o(32412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csy
 * JD-Core Version:    0.7.0.1
 */