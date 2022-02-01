package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afw
  extends com.tencent.mm.bx.a
{
  public fkv ZoL;
  public fmp ZoM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91425);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZoL != null)
      {
        paramVarArgs.qD(1, this.ZoL.computeSize());
        this.ZoL.writeFields(paramVarArgs);
      }
      if (this.ZoM != null)
      {
        paramVarArgs.qD(2, this.ZoM.computeSize());
        this.ZoM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZoL == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.ZoL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZoM != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZoM.computeSize());
      }
      AppMethodBeat.o(91425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        afw localafw = (afw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91425);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkv)localObject2).parseFrom((byte[])localObject1);
            }
            localafw.ZoL = ((fkv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91425);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmp)localObject2).parseFrom((byte[])localObject1);
          }
          localafw.ZoM = ((fmp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91425);
        return 0;
      }
      AppMethodBeat.o(91425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afw
 * JD-Core Version:    0.7.0.1
 */