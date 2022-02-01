package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dph
  extends com.tencent.mm.cd.a
{
  public int DQd;
  public int Svu;
  public long Svv;
  public LinkedList<dpq> TWr;
  
  public dph()
  {
    AppMethodBeat.i(32381);
    this.TWr = new LinkedList();
    AppMethodBeat.o(32381);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32382);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Svu);
      paramVarArgs.bm(2, this.Svv);
      paramVarArgs.e(3, 8, this.TWr);
      paramVarArgs.aY(4, this.DQd);
      AppMethodBeat.o(32382);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Svu);
      i = g.a.a.b.b.a.p(2, this.Svv);
      int j = g.a.a.a.c(3, 8, this.TWr);
      int k = g.a.a.b.b.a.bM(4, this.DQd);
      AppMethodBeat.o(32382);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TWr.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dph localdph = (dph)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32382);
        return -1;
      case 1: 
        localdph.Svu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32382);
        return 0;
      case 2: 
        localdph.Svv = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(32382);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dpq localdpq = new dpq();
          if ((localObject != null) && (localObject.length > 0)) {
            localdpq.parseFrom((byte[])localObject);
          }
          localdph.TWr.add(localdpq);
          paramInt += 1;
        }
        AppMethodBeat.o(32382);
        return 0;
      }
      localdph.DQd = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(32382);
      return 0;
    }
    AppMethodBeat.o(32382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dph
 * JD-Core Version:    0.7.0.1
 */