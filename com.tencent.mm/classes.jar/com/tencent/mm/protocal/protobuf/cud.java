package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cud
  extends com.tencent.mm.cd.a
{
  public LinkedList<cue> SKD;
  
  public cud()
  {
    AppMethodBeat.i(210830);
    this.SKD = new LinkedList();
    AppMethodBeat.o(210830);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210832);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).e(1, 8, this.SKD);
      AppMethodBeat.o(210832);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.SKD);
      AppMethodBeat.o(210832);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SKD.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(210832);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      cud localcud = (cud)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(210832);
        return -1;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cue localcue = new cue();
        if ((localObject != null) && (localObject.length > 0)) {
          localcue.parseFrom((byte[])localObject);
        }
        localcud.SKD.add(localcue);
        paramInt += 1;
      }
      AppMethodBeat.o(210832);
      return 0;
    }
    AppMethodBeat.o(210832);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cud
 * JD-Core Version:    0.7.0.1
 */