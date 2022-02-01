package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cot
  extends com.tencent.mm.bx.a
{
  public cos aavH;
  public cor aavI;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259550);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aavH != null)
      {
        paramVarArgs.qD(1, this.aavH.computeSize());
        this.aavH.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.scene);
      if (this.aavI != null)
      {
        paramVarArgs.qD(3, this.aavI.computeSize());
        this.aavI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aavH == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = i.a.a.a.qC(1, this.aavH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.aavI != null) {
        paramInt = i + i.a.a.a.qC(3, this.aavI.computeSize());
      }
      AppMethodBeat.o(259550);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cot localcot = (cot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259550);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cos();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cos)localObject2).parseFrom((byte[])localObject1);
            }
            localcot.aavH = ((cos)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259550);
          return 0;
        case 2: 
          localcot.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259550);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cor();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cor)localObject2).parseFrom((byte[])localObject1);
          }
          localcot.aavI = ((cor)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259550);
        return 0;
      }
      AppMethodBeat.o(259550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cot
 * JD-Core Version:    0.7.0.1
 */