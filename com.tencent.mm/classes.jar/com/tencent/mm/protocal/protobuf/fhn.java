package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhn
  extends com.tencent.mm.bx.a
{
  public fho abIc;
  public fhm abId;
  public fhl abIe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125844);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abIc != null)
      {
        paramVarArgs.qD(1, this.abIc.computeSize());
        this.abIc.writeFields(paramVarArgs);
      }
      if (this.abId != null)
      {
        paramVarArgs.qD(2, this.abId.computeSize());
        this.abId.writeFields(paramVarArgs);
      }
      if (this.abIe != null)
      {
        paramVarArgs.qD(3, this.abIe.computeSize());
        this.abIe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abIc == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.abIc.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abId != null) {
        paramInt = i + i.a.a.a.qC(2, this.abId.computeSize());
      }
      i = paramInt;
      if (this.abIe != null) {
        i = paramInt + i.a.a.a.qC(3, this.abIe.computeSize());
      }
      AppMethodBeat.o(125844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fhn localfhn = (fhn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125844);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fho();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fho)localObject2).parseFrom((byte[])localObject1);
            }
            localfhn.abIc = ((fho)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhm)localObject2).parseFrom((byte[])localObject1);
            }
            localfhn.abId = ((fhm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhl)localObject2).parseFrom((byte[])localObject1);
          }
          localfhn.abIe = ((fhl)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhn
 * JD-Core Version:    0.7.0.1
 */