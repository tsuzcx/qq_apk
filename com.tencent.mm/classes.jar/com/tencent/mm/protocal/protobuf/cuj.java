package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cuj
  extends com.tencent.mm.bv.a
{
  public LinkedList<ctw> ycV;
  public cto ydg;
  public int ydh;
  
  public cuj()
  {
    AppMethodBeat.i(102417);
    this.ycV = new LinkedList();
    AppMethodBeat.o(102417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102418);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ydg == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(102418);
        throw paramVarArgs;
      }
      if (this.ydg != null)
      {
        paramVarArgs.iQ(1, this.ydg.computeSize());
        this.ydg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ycV);
      paramVarArgs.aO(3, this.ydh);
      AppMethodBeat.o(102418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ydg == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = e.a.a.a.iP(1, this.ydg.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.ycV);
      int j = e.a.a.b.b.a.bl(3, this.ydh);
      AppMethodBeat.o(102418);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ycV.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ydg == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(102418);
          throw paramVarArgs;
        }
        AppMethodBeat.o(102418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cuj localcuj = (cuj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(102418);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cto();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cto)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcuj.ydg = ((cto)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(102418);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcuj.ycV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(102418);
          return 0;
        }
        localcuj.ydh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(102418);
        return 0;
      }
      AppMethodBeat.o(102418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuj
 * JD-Core Version:    0.7.0.1
 */