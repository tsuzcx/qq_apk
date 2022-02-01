package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctc
  extends com.tencent.mm.bw.a
{
  public ccb KQj;
  public qy KQk;
  public ctb KQl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133180);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KQj != null)
      {
        paramVarArgs.ni(1, this.KQj.computeSize());
        this.KQj.writeFields(paramVarArgs);
      }
      if (this.KQl != null)
      {
        paramVarArgs.ni(2, this.KQl.computeSize());
        this.KQl.writeFields(paramVarArgs);
      }
      if (this.KQk != null)
      {
        paramVarArgs.ni(3, this.KQk.computeSize());
        this.KQk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KQj == null) {
        break label618;
      }
    }
    label618:
    for (int i = g.a.a.a.nh(1, this.KQj.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KQl != null) {
        paramInt = i + g.a.a.a.nh(2, this.KQl.computeSize());
      }
      i = paramInt;
      if (this.KQk != null) {
        i = paramInt + g.a.a.a.nh(3, this.KQk.computeSize());
      }
      AppMethodBeat.o(133180);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctc localctc = (ctc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133180);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctc.KQj = ((ccb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctc.KQl = ((ctb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localctc.KQk = ((qy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      AppMethodBeat.o(133180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctc
 * JD-Core Version:    0.7.0.1
 */