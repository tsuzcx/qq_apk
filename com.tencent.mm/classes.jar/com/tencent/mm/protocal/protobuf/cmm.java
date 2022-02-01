package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cmm
  extends com.tencent.mm.bx.a
{
  public LinkedList<bsg> HfP;
  public String id;
  
  public cmm()
  {
    AppMethodBeat.i(210612);
    this.HfP = new LinkedList();
    AppMethodBeat.o(210612);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210613);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(210613);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.e(2, 8, this.HfP);
      AppMethodBeat.o(210613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.HfP);
      AppMethodBeat.o(210613);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HfP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(210613);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmm localcmm = (cmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210613);
          return -1;
        case 1: 
          localcmm.id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210613);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bsg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmm.HfP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(210613);
        return 0;
      }
      AppMethodBeat.o(210613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmm
 * JD-Core Version:    0.7.0.1
 */