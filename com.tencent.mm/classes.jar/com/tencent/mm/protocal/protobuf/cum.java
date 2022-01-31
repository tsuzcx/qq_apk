package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cum
  extends com.tencent.mm.bv.a
{
  public cto ydg;
  public int ydh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102421);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ydg == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(102421);
        throw paramVarArgs;
      }
      if (this.ydg != null)
      {
        paramVarArgs.iQ(1, this.ydg.computeSize());
        this.ydg.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.ydh);
      AppMethodBeat.o(102421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ydg == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = e.a.a.a.iP(1, this.ydg.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.ydh);
      AppMethodBeat.o(102421);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ydg == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(102421);
          throw paramVarArgs;
        }
        AppMethodBeat.o(102421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cum localcum = (cum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(102421);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cto();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cto)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcum.ydg = ((cto)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(102421);
          return 0;
        }
        localcum.ydh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(102421);
        return 0;
      }
      AppMethodBeat.o(102421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cum
 * JD-Core Version:    0.7.0.1
 */