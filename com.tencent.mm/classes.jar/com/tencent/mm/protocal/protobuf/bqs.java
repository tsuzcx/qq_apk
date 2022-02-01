package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqs
  extends com.tencent.mm.bx.a
{
  public bve ACr;
  public LinkedList<FinderObject> ZIQ;
  
  public bqs()
  {
    AppMethodBeat.i(257622);
    this.ZIQ = new LinkedList();
    AppMethodBeat.o(257622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257628);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ACr != null)
      {
        paramVarArgs.qD(1, this.ACr.computeSize());
        this.ACr.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZIQ);
      AppMethodBeat.o(257628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ACr == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.a.qC(1, this.ACr.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.ZIQ);
      AppMethodBeat.o(257628);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZIQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257628);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bqs localbqs = (bqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257628);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bve)localObject2).parseFrom((byte[])localObject1);
            }
            localbqs.ACr = ((bve)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257628);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localbqs.ZIQ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257628);
        return 0;
      }
      AppMethodBeat.o(257628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqs
 * JD-Core Version:    0.7.0.1
 */