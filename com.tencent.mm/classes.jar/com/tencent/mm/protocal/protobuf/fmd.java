package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fmd
  extends com.tencent.mm.cd.a
{
  public LinkedList<fma> UKV;
  public boolean UKW;
  
  public fmd()
  {
    AppMethodBeat.i(110861);
    this.UKV = new LinkedList();
    AppMethodBeat.o(110861);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110862);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.UKV);
      paramVarArgs.co(2, this.UKW);
      AppMethodBeat.o(110862);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.UKV);
      i = g.a.a.b.b.a.gL(2);
      AppMethodBeat.o(110862);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UKV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110862);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fmd localfmd = (fmd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110862);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fma localfma = new fma();
          if ((localObject != null) && (localObject.length > 0)) {
            localfma.parseFrom((byte[])localObject);
          }
          localfmd.UKV.add(localfma);
          paramInt += 1;
        }
        AppMethodBeat.o(110862);
        return 0;
      }
      localfmd.UKW = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(110862);
      return 0;
    }
    AppMethodBeat.o(110862);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmd
 * JD-Core Version:    0.7.0.1
 */