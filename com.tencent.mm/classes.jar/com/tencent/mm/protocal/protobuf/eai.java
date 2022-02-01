package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eai
  extends com.tencent.mm.cd.a
{
  public int rVx;
  public LinkedList<eah> rVy;
  
  public eai()
  {
    AppMethodBeat.i(134255);
    this.rVy = new LinkedList();
    AppMethodBeat.o(134255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134256);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rVx);
      paramVarArgs.e(2, 8, this.rVy);
      AppMethodBeat.o(134256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.rVx);
      i = g.a.a.a.c(2, 8, this.rVy);
      AppMethodBeat.o(134256);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rVy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(134256);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eai localeai = (eai)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(134256);
        return -1;
      case 1: 
        localeai.rVx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(134256);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eah localeah = new eah();
        if ((localObject != null) && (localObject.length > 0)) {
          localeah.parseFrom((byte[])localObject);
        }
        localeai.rVy.add(localeah);
        paramInt += 1;
      }
      AppMethodBeat.o(134256);
      return 0;
    }
    AppMethodBeat.o(134256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eai
 * JD-Core Version:    0.7.0.1
 */