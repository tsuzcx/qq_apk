package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afi
  extends com.tencent.mm.bx.a
{
  public long ZnE;
  public akd ZnF;
  public akg ZnG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90958);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZnE);
      if (this.ZnF != null)
      {
        paramVarArgs.qD(2, this.ZnF.computeSize());
        this.ZnF.writeFields(paramVarArgs);
      }
      if (this.ZnG != null)
      {
        paramVarArgs.qD(3, this.ZnG.computeSize());
        this.ZnG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ZnE) + 0;
      paramInt = i;
      if (this.ZnF != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZnF.computeSize());
      }
      i = paramInt;
      if (this.ZnG != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZnG.computeSize());
      }
      AppMethodBeat.o(90958);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      afi localafi = (afi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90958);
        return -1;
      case 1: 
        localafi.ZnE = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(90958);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akd)localObject2).parseFrom((byte[])localObject1);
          }
          localafi.ZnF = ((akd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(90958);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new akg();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((akg)localObject2).parseFrom((byte[])localObject1);
        }
        localafi.ZnG = ((akg)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    AppMethodBeat.o(90958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afi
 * JD-Core Version:    0.7.0.1
 */