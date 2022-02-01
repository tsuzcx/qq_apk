package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhj
  extends com.tencent.mm.cd.a
{
  public LinkedList<dag> TOv;
  public int type;
  
  public dhj()
  {
    AppMethodBeat.i(117542);
    this.TOv = new LinkedList();
    AppMethodBeat.o(117542);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117543);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      paramVarArgs.e(2, 8, this.TOv);
      AppMethodBeat.o(117543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.type);
      i = g.a.a.a.c(2, 8, this.TOv);
      AppMethodBeat.o(117543);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TOv.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dhj localdhj = (dhj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117543);
        return -1;
      case 1: 
        localdhj.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(117543);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dag localdag = new dag();
        if ((localObject != null) && (localObject.length > 0)) {
          localdag.parseFrom((byte[])localObject);
        }
        localdhj.TOv.add(localdag);
        paramInt += 1;
      }
      AppMethodBeat.o(117543);
      return 0;
    }
    AppMethodBeat.o(117543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhj
 * JD-Core Version:    0.7.0.1
 */