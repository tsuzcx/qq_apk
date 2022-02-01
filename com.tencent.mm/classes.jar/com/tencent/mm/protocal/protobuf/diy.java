package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class diy
  extends com.tencent.mm.bx.a
{
  public diz aaOA;
  public div aaOB;
  public diw aaOC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260167);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaOA != null)
      {
        paramVarArgs.qD(1, this.aaOA.computeSize());
        this.aaOA.writeFields(paramVarArgs);
      }
      if (this.aaOB != null)
      {
        paramVarArgs.qD(2, this.aaOB.computeSize());
        this.aaOB.writeFields(paramVarArgs);
      }
      if (this.aaOC != null)
      {
        paramVarArgs.qD(3, this.aaOC.computeSize());
        this.aaOC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260167);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaOA == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.aaOA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaOB != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaOB.computeSize());
      }
      i = paramInt;
      if (this.aaOC != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaOC.computeSize());
      }
      AppMethodBeat.o(260167);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260167);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        diy localdiy = (diy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260167);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new diz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((diz)localObject2).parseFrom((byte[])localObject1);
            }
            localdiy.aaOA = ((diz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260167);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new div();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((div)localObject2).parseFrom((byte[])localObject1);
            }
            localdiy.aaOB = ((div)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260167);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new diw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((diw)localObject2).parseFrom((byte[])localObject1);
          }
          localdiy.aaOC = ((diw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260167);
        return 0;
      }
      AppMethodBeat.o(260167);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diy
 * JD-Core Version:    0.7.0.1
 */