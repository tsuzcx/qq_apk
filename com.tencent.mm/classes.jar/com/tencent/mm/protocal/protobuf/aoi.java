package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoi
  extends com.tencent.mm.bx.a
{
  public String GmW;
  public dij GmX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209318);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GmW != null) {
        paramVarArgs.d(1, this.GmW);
      }
      if (this.GmX != null)
      {
        paramVarArgs.lC(2, this.GmX.computeSize());
        this.GmX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209318);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GmW == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.GmW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GmX != null) {
        i = paramInt + f.a.a.a.lB(2, this.GmX.computeSize());
      }
      AppMethodBeat.o(209318);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209318);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoi localaoi = (aoi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209318);
          return -1;
        case 1: 
          localaoi.GmW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209318);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dij();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaoi.GmX = ((dij)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209318);
        return 0;
      }
      AppMethodBeat.o(209318);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoi
 * JD-Core Version:    0.7.0.1
 */