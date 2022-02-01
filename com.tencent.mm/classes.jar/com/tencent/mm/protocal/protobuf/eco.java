package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eco
  extends com.tencent.mm.bw.a
{
  public ecp NcH;
  public ecn NcI;
  public ecm NcJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125844);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NcH != null)
      {
        paramVarArgs.ni(1, this.NcH.computeSize());
        this.NcH.writeFields(paramVarArgs);
      }
      if (this.NcI != null)
      {
        paramVarArgs.ni(2, this.NcI.computeSize());
        this.NcI.writeFields(paramVarArgs);
      }
      if (this.NcJ != null)
      {
        paramVarArgs.ni(3, this.NcJ.computeSize());
        this.NcJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NcH == null) {
        break label618;
      }
    }
    label618:
    for (int i = g.a.a.a.nh(1, this.NcH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NcI != null) {
        paramInt = i + g.a.a.a.nh(2, this.NcI.computeSize());
      }
      i = paramInt;
      if (this.NcJ != null) {
        i = paramInt + g.a.a.a.nh(3, this.NcJ.computeSize());
      }
      AppMethodBeat.o(125844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eco localeco = (eco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125844);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeco.NcH = ((ecp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeco.NcI = ((ecn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ecm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeco.NcJ = ((ecm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      AppMethodBeat.o(125844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eco
 * JD-Core Version:    0.7.0.1
 */