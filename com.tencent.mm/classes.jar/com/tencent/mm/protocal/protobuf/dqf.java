package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqf
  extends com.tencent.mm.cd.a
{
  public int SXM;
  public LinkedList<dqe> TWY;
  public int rVx;
  
  public dqf()
  {
    AppMethodBeat.i(155449);
    this.TWY = new LinkedList();
    AppMethodBeat.o(155449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SXM);
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.e(3, 8, this.TWY);
      AppMethodBeat.o(155450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SXM);
      i = g.a.a.b.b.a.bM(2, this.rVx);
      int j = g.a.a.a.c(3, 8, this.TWY);
      AppMethodBeat.o(155450);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TWY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dqf localdqf = (dqf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155450);
        return -1;
      case 1: 
        localdqf.SXM = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(155450);
        return 0;
      case 2: 
        localdqf.rVx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(155450);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dqe localdqe = new dqe();
        if ((localObject != null) && (localObject.length > 0)) {
          localdqe.parseFrom((byte[])localObject);
        }
        localdqf.TWY.add(localdqe);
        paramInt += 1;
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    AppMethodBeat.o(155450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqf
 * JD-Core Version:    0.7.0.1
 */