package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhk
  extends com.tencent.mm.bx.a
{
  public int aaMG = 0;
  public dtx aaMH;
  public dhm aaMI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257635);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaMG);
      if (this.aaMH != null)
      {
        paramVarArgs.qD(2, this.aaMH.computeSize());
        this.aaMH.writeFields(paramVarArgs);
      }
      if (this.aaMI != null)
      {
        paramVarArgs.qD(3, this.aaMI.computeSize());
        this.aaMI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257635);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaMG) + 0;
      paramInt = i;
      if (this.aaMH != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaMH.computeSize());
      }
      i = paramInt;
      if (this.aaMI != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaMI.computeSize());
      }
      AppMethodBeat.o(257635);
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
      AppMethodBeat.o(257635);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dhk localdhk = (dhk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257635);
        return -1;
      case 1: 
        localdhk.aaMG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257635);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dtx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dtx)localObject2).parseFrom((byte[])localObject1);
          }
          localdhk.aaMH = ((dtx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257635);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dhm();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dhm)localObject2).parseFrom((byte[])localObject1);
        }
        localdhk.aaMI = ((dhm)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257635);
      return 0;
    }
    AppMethodBeat.o(257635);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhk
 * JD-Core Version:    0.7.0.1
 */