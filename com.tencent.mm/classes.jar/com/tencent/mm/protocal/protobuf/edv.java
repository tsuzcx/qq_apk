package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edv
  extends dyl
{
  public int rVx;
  public LinkedList<cxi> rVy;
  
  public edv()
  {
    AppMethodBeat.i(43127);
    this.rVy = new LinkedList();
    AppMethodBeat.o(43127);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43128);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rVx);
      paramVarArgs.e(2, 8, this.rVy);
      AppMethodBeat.o(43128);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.rVx);
      i = g.a.a.a.c(2, 8, this.rVy);
      AppMethodBeat.o(43128);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rVy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(43128);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      edv localedv = (edv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43128);
        return -1;
      case 1: 
        localedv.rVx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43128);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cxi localcxi = new cxi();
        if ((localObject != null) && (localObject.length > 0)) {
          localcxi.parseFrom((byte[])localObject);
        }
        localedv.rVy.add(localcxi);
        paramInt += 1;
      }
      AppMethodBeat.o(43128);
      return 0;
    }
    AppMethodBeat.o(43128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edv
 * JD-Core Version:    0.7.0.1
 */