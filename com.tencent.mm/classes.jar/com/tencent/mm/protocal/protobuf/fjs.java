package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fjs
  extends com.tencent.mm.cd.a
{
  public boolean Tic;
  public LinkedList<fjq> TlE;
  public boolean UIN;
  
  public fjs()
  {
    AppMethodBeat.i(32541);
    this.TlE = new LinkedList();
    AppMethodBeat.o(32541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.Tic);
      paramVarArgs.e(2, 8, this.TlE);
      paramVarArgs.co(3, this.UIN);
      AppMethodBeat.o(32542);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      i = g.a.a.a.c(2, 8, this.TlE);
      int j = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(32542);
      return paramInt + 1 + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TlE.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32542);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fjs localfjs = (fjs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32542);
        return -1;
      case 1: 
        localfjs.Tic = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(32542);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fjq localfjq = new fjq();
          if ((localObject != null) && (localObject.length > 0)) {
            localfjq.parseFrom((byte[])localObject);
          }
          localfjs.TlE.add(localfjq);
          paramInt += 1;
        }
        AppMethodBeat.o(32542);
        return 0;
      }
      localfjs.UIN = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(32542);
      return 0;
    }
    AppMethodBeat.o(32542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjs
 * JD-Core Version:    0.7.0.1
 */