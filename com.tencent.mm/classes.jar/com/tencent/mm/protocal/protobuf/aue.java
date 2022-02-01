package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aue
  extends com.tencent.mm.bx.a
{
  public fes ZEH;
  public ht ZEI;
  public String id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258034);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZEH != null)
      {
        paramVarArgs.qD(1, this.ZEH.computeSize());
        this.ZEH.writeFields(paramVarArgs);
      }
      if (this.id != null) {
        paramVarArgs.g(2, this.id);
      }
      if (this.ZEI != null)
      {
        paramVarArgs.qD(3, this.ZEI.computeSize());
        this.ZEI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258034);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZEH == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.ZEH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.id);
      }
      i = paramInt;
      if (this.ZEI != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZEI.computeSize());
      }
      AppMethodBeat.o(258034);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258034);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aue localaue = (aue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258034);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fes();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fes)localObject2).parseFrom((byte[])localObject1);
            }
            localaue.ZEH = ((fes)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258034);
          return 0;
        case 2: 
          localaue.id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258034);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ht();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ht)localObject2).parseFrom((byte[])localObject1);
          }
          localaue.ZEI = ((ht)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258034);
        return 0;
      }
      AppMethodBeat.o(258034);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aue
 * JD-Core Version:    0.7.0.1
 */