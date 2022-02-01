package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezf
  extends com.tencent.mm.cd.a
{
  public LinkedList<ezg> UzI;
  public ezg UzJ;
  
  public ezf()
  {
    AppMethodBeat.i(186274);
    this.UzI = new LinkedList();
    AppMethodBeat.o(186274);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186279);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.UzI);
      if (this.UzJ != null)
      {
        paramVarArgs.oE(2, this.UzJ.computeSize());
        this.UzJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(186279);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.UzI) + 0;
      paramInt = i;
      if (this.UzJ != null) {
        paramInt = i + g.a.a.a.oD(2, this.UzJ.computeSize());
      }
      AppMethodBeat.o(186279);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UzI.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(186279);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ezf localezf = (ezf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ezg localezg;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(186279);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localezg = new ezg();
          if ((localObject != null) && (localObject.length > 0)) {
            localezg.parseFrom((byte[])localObject);
          }
          localezf.UzI.add(localezg);
          paramInt += 1;
        }
        AppMethodBeat.o(186279);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localezg = new ezg();
        if ((localObject != null) && (localObject.length > 0)) {
          localezg.parseFrom((byte[])localObject);
        }
        localezf.UzJ = localezg;
        paramInt += 1;
      }
      AppMethodBeat.o(186279);
      return 0;
    }
    AppMethodBeat.o(186279);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezf
 * JD-Core Version:    0.7.0.1
 */