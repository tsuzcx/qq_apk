package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adf
  extends com.tencent.mm.cd.a
{
  public String RDj;
  public long SoR;
  public int SpI;
  public LinkedList<ade> SpJ;
  
  public adf()
  {
    AppMethodBeat.i(203492);
    this.SpJ = new LinkedList();
    AppMethodBeat.o(203492);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203496);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SoR);
      if (this.RDj != null) {
        paramVarArgs.f(2, this.RDj);
      }
      paramVarArgs.aY(3, this.SpI);
      paramVarArgs.e(4, 8, this.SpJ);
      AppMethodBeat.o(203496);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.SoR) + 0;
      paramInt = i;
      if (this.RDj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RDj);
      }
      i = g.a.a.b.b.a.bM(3, this.SpI);
      int j = g.a.a.a.c(4, 8, this.SpJ);
      AppMethodBeat.o(203496);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SpJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203496);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      adf localadf = (adf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203496);
        return -1;
      case 1: 
        localadf.SoR = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(203496);
        return 0;
      case 2: 
        localadf.RDj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(203496);
        return 0;
      case 3: 
        localadf.SpI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(203496);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ade localade = new ade();
        if ((localObject != null) && (localObject.length > 0)) {
          localade.parseFrom((byte[])localObject);
        }
        localadf.SpJ.add(localade);
        paramInt += 1;
      }
      AppMethodBeat.o(203496);
      return 0;
    }
    AppMethodBeat.o(203496);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adf
 * JD-Core Version:    0.7.0.1
 */