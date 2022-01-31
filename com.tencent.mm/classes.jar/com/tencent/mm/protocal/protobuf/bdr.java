package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bdr
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public bwc wow;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5598);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wow == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(5598);
        throw paramVarArgs;
      }
      if (this.wow != null)
      {
        paramVarArgs.iQ(1, this.wow.computeSize());
        this.wow.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJS);
      AppMethodBeat.o(5598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wow == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = e.a.a.a.iP(1, this.wow.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jJS);
      AppMethodBeat.o(5598);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wow == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(5598);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bdr localbdr = (bdr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5598);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdr.wow = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5598);
          return 0;
        }
        localbdr.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5598);
        return 0;
      }
      AppMethodBeat.o(5598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdr
 * JD-Core Version:    0.7.0.1
 */