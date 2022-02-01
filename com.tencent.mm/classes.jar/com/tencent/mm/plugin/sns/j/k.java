package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.cd.a
{
  public long KaQ;
  public LinkedList<l> Kff;
  public long Kfg;
  
  public k()
  {
    AppMethodBeat.i(179119);
    this.Kff = new LinkedList();
    AppMethodBeat.o(179119);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179120);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Kff);
      paramVarArgs.bm(2, this.Kfg);
      paramVarArgs.bm(3, this.KaQ);
      AppMethodBeat.o(179120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.Kff);
      i = g.a.a.b.b.a.p(2, this.Kfg);
      int j = g.a.a.b.b.a.p(3, this.KaQ);
      AppMethodBeat.o(179120);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Kff.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(179120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(179120);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          l locall = new l();
          if ((localObject != null) && (localObject.length > 0)) {
            locall.parseFrom((byte[])localObject);
          }
          localk.Kff.add(locall);
          paramInt += 1;
        }
        AppMethodBeat.o(179120);
        return 0;
      case 2: 
        localk.Kfg = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(179120);
        return 0;
      }
      localk.KaQ = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(179120);
      return 0;
    }
    AppMethodBeat.o(179120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.k
 * JD-Core Version:    0.7.0.1
 */