package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aam
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public LinkedList<arl> ZiY;
  public ary ZiZ;
  
  public aam()
  {
    AppMethodBeat.i(127449);
    this.ZiY = new LinkedList();
    AppMethodBeat.o(127449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127450);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZiY);
      paramVarArgs.bS(2, this.IJG);
      if (this.ZiZ != null)
      {
        paramVarArgs.qD(3, this.ZiZ.computeSize());
        this.ZiZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZiY) + 0 + i.a.a.b.b.a.cJ(2, this.IJG);
      paramInt = i;
      if (this.ZiZ != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZiZ.computeSize());
      }
      AppMethodBeat.o(127450);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZiY.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      aam localaam = (aam)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127450);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new arl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((arl)localObject2).parseFrom((byte[])localObject1);
          }
          localaam.ZiY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(127450);
        return 0;
      case 2: 
        localaam.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(127450);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ary();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ary)localObject2).parseFrom((byte[])localObject1);
        }
        localaam.ZiZ = ((ary)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    AppMethodBeat.o(127450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aam
 * JD-Core Version:    0.7.0.1
 */