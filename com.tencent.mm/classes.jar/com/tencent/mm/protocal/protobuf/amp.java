package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amp
  extends com.tencent.mm.bx.a
{
  public anj ZtB;
  public int ZtC;
  public LinkedList<amn> ZtD;
  
  public amp()
  {
    AppMethodBeat.i(257485);
    this.ZtD = new LinkedList();
    AppMethodBeat.o(257485);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257490);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZtB != null)
      {
        paramVarArgs.qD(1, this.ZtB.computeSize());
        this.ZtB.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZtC);
      paramVarArgs.e(3, 8, this.ZtD);
      AppMethodBeat.o(257490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZtB == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = i.a.a.a.qC(1, this.ZtB.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZtC);
      int j = i.a.a.a.c(3, 8, this.ZtD);
      AppMethodBeat.o(257490);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZtD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        amp localamp = (amp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257490);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anj)localObject2).parseFrom((byte[])localObject1);
            }
            localamp.ZtB = ((anj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257490);
          return 0;
        case 2: 
          localamp.ZtC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257490);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new amn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((amn)localObject2).parseFrom((byte[])localObject1);
          }
          localamp.ZtD.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257490);
        return 0;
      }
      AppMethodBeat.o(257490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amp
 * JD-Core Version:    0.7.0.1
 */