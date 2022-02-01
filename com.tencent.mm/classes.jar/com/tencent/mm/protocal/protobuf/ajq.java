package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajq
  extends com.tencent.mm.cd.a
{
  public int CNe;
  public int CPw;
  public LinkedList<exm> Sud;
  public int Sue;
  public boolean Suf;
  
  public ajq()
  {
    AppMethodBeat.i(104763);
    this.Sud = new LinkedList();
    this.Suf = false;
    this.CNe = 0;
    AppMethodBeat.o(104763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104764);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Sud);
      paramVarArgs.aY(2, this.Sue);
      paramVarArgs.co(3, this.Suf);
      paramVarArgs.aY(4, this.CNe);
      paramVarArgs.aY(5, this.CPw);
      AppMethodBeat.o(104764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.Sud);
      i = g.a.a.b.b.a.bM(2, this.Sue);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.bM(4, this.CNe);
      int m = g.a.a.b.b.a.bM(5, this.CPw);
      AppMethodBeat.o(104764);
      return paramInt + 0 + i + (j + 1) + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Sud.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(104764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ajq localajq = (ajq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104764);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          exm localexm = new exm();
          if ((localObject != null) && (localObject.length > 0)) {
            localexm.parseFrom((byte[])localObject);
          }
          localajq.Sud.add(localexm);
          paramInt += 1;
        }
        AppMethodBeat.o(104764);
        return 0;
      case 2: 
        localajq.Sue = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104764);
        return 0;
      case 3: 
        localajq.Suf = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(104764);
        return 0;
      case 4: 
        localajq.CNe = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104764);
        return 0;
      }
      localajq.CPw = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(104764);
      return 0;
    }
    AppMethodBeat.o(104764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajq
 * JD-Core Version:    0.7.0.1
 */