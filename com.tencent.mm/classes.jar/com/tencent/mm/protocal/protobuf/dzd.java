package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dzd
  extends com.tencent.mm.bw.a
{
  public SnsObject MYH;
  public dqi MYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125765);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MYH == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125765);
        throw paramVarArgs;
      }
      if (this.MYH != null)
      {
        paramVarArgs.ni(1, this.MYH.computeSize());
        this.MYH.writeFields(paramVarArgs);
      }
      if (this.MYI != null)
      {
        paramVarArgs.ni(2, this.MYI.computeSize());
        this.MYI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125765);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MYH == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.a.nh(1, this.MYH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MYI != null) {
        i = paramInt + g.a.a.a.nh(2, this.MYI.computeSize());
      }
      AppMethodBeat.o(125765);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MYH == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125765);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125765);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzd localdzd = (dzd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125765);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzd.MYH = ((SnsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125765);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdzd.MYI = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125765);
        return 0;
      }
      AppMethodBeat.o(125765);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzd
 * JD-Core Version:    0.7.0.1
 */