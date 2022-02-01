package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqp
  extends com.tencent.mm.bx.a
{
  public String DDP;
  public LinkedList<bxw> EjA;
  
  public cqp()
  {
    AppMethodBeat.i(122536);
    this.DDP = "";
    this.EjA = new LinkedList();
    AppMethodBeat.o(122536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DDP != null) {
        paramVarArgs.d(1, this.DDP);
      }
      paramVarArgs.e(2, 8, this.EjA);
      AppMethodBeat.o(122537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DDP == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.DDP) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.EjA);
      AppMethodBeat.o(122537);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EjA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqp localcqp = (cqp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122537);
          return -1;
        case 1: 
          localcqp.DDP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122537);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bxw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqp.EjA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      AppMethodBeat.o(122537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqp
 * JD-Core Version:    0.7.0.1
 */