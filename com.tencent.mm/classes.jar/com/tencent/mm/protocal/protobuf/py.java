package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class py
  extends com.tencent.mm.bx.a
{
  public String YPl;
  public int YRD;
  public LinkedList<px> YUi;
  public qk YUj;
  
  public py()
  {
    AppMethodBeat.i(124435);
    this.YUi = new LinkedList();
    AppMethodBeat.o(124435);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124436);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YUi);
      paramVarArgs.bS(3, this.YRD);
      if (this.YPl != null) {
        paramVarArgs.g(4, this.YPl);
      }
      if (this.YUj != null)
      {
        paramVarArgs.qD(5, this.YUj.computeSize());
        this.YUj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YUi) + 0 + i.a.a.b.b.a.cJ(3, this.YRD);
      paramInt = i;
      if (this.YPl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YPl);
      }
      i = paramInt;
      if (this.YUj != null) {
        i = paramInt + i.a.a.a.qC(5, this.YUj.computeSize());
      }
      AppMethodBeat.o(124436);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YUi.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      py localpy = (py)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(124436);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new px();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((px)localObject2).parseFrom((byte[])localObject1);
          }
          localpy.YUi.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124436);
        return 0;
      case 3: 
        localpy.YRD = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(124436);
        return 0;
      case 4: 
        localpy.YPl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(124436);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new qk();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((qk)localObject2).parseFrom((byte[])localObject1);
        }
        localpy.YUj = ((qk)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    AppMethodBeat.o(124436);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.py
 * JD-Core Version:    0.7.0.1
 */