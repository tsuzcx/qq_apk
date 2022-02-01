package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eno
  extends com.tencent.mm.bx.a
{
  public int GroupCount;
  public LinkedList<enn> absc;
  
  public eno()
  {
    AppMethodBeat.i(6422);
    this.absc = new LinkedList();
    AppMethodBeat.o(6422);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6423);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.GroupCount);
      paramVarArgs.e(2, 8, this.absc);
      AppMethodBeat.o(6423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.GroupCount);
      i = i.a.a.a.c(2, 8, this.absc);
      AppMethodBeat.o(6423);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.absc.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(6423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      eno localeno = (eno)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6423);
        return -1;
      case 1: 
        localeno.GroupCount = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(6423);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        enn localenn = new enn();
        if ((localObject != null) && (localObject.length > 0)) {
          localenn.parseFrom((byte[])localObject);
        }
        localeno.absc.add(localenn);
        paramInt += 1;
      }
      AppMethodBeat.o(6423);
      return 0;
    }
    AppMethodBeat.o(6423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eno
 * JD-Core Version:    0.7.0.1
 */