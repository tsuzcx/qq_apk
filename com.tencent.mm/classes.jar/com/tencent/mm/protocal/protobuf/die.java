package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class die
  extends com.tencent.mm.bx.a
{
  public LinkedList<fxx> YCW;
  public String YMe;
  
  public die()
  {
    AppMethodBeat.i(91531);
    this.YCW = new LinkedList();
    AppMethodBeat.o(91531);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91532);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YCW);
      if (this.YMe != null) {
        paramVarArgs.g(2, this.YMe);
      }
      AppMethodBeat.o(91532);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YCW) + 0;
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YMe);
      }
      AppMethodBeat.o(91532);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YCW.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91532);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      die localdie = (die)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91532);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fxx localfxx = new fxx();
          if ((localObject != null) && (localObject.length > 0)) {
            localfxx.parseFrom((byte[])localObject);
          }
          localdie.YCW.add(localfxx);
          paramInt += 1;
        }
        AppMethodBeat.o(91532);
        return 0;
      }
      localdie.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91532);
      return 0;
    }
    AppMethodBeat.o(91532);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.die
 * JD-Core Version:    0.7.0.1
 */