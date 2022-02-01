package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boi
  extends com.tencent.mm.cd.a
{
  public long RQn;
  public String RQo;
  public LinkedList<fbs> SZp;
  
  public boi()
  {
    AppMethodBeat.i(110898);
    this.SZp = new LinkedList();
    AppMethodBeat.o(110898);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110899);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RQn);
      paramVarArgs.e(2, 8, this.SZp);
      if (this.RQo != null) {
        paramVarArgs.f(3, this.RQo);
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.RQn) + 0 + g.a.a.a.c(2, 8, this.SZp);
      paramInt = i;
      if (this.RQo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RQo);
      }
      AppMethodBeat.o(110899);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SZp.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      boi localboi = (boi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110899);
        return -1;
      case 1: 
        localboi.RQn = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110899);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fbs localfbs = new fbs();
          if ((localObject != null) && (localObject.length > 0)) {
            localfbs.parseFrom((byte[])localObject);
          }
          localboi.SZp.add(localfbs);
          paramInt += 1;
        }
        AppMethodBeat.o(110899);
        return 0;
      }
      localboi.RQo = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(110899);
      return 0;
    }
    AppMethodBeat.o(110899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boi
 * JD-Core Version:    0.7.0.1
 */