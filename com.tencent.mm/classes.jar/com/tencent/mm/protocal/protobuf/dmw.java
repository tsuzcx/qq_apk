package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmw
  extends com.tencent.mm.cd.a
{
  public int TUd;
  public LinkedList<eph> TUe;
  public int jUk;
  
  public dmw()
  {
    AppMethodBeat.i(152661);
    this.TUe = new LinkedList();
    AppMethodBeat.o(152661);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152662);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jUk);
      paramVarArgs.aY(2, this.TUd);
      paramVarArgs.e(3, 8, this.TUe);
      AppMethodBeat.o(152662);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.jUk);
      i = g.a.a.b.b.a.bM(2, this.TUd);
      int j = g.a.a.a.c(3, 8, this.TUe);
      AppMethodBeat.o(152662);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TUe.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dmw localdmw = (dmw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152662);
        return -1;
      case 1: 
        localdmw.jUk = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152662);
        return 0;
      case 2: 
        localdmw.TUd = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152662);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eph localeph = new eph();
        if ((localObject != null) && (localObject.length > 0)) {
          localeph.parseFrom((byte[])localObject);
        }
        localdmw.TUe.add(localeph);
        paramInt += 1;
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    AppMethodBeat.o(152662);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmw
 * JD-Core Version:    0.7.0.1
 */