package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dix
  extends com.tencent.mm.cd.a
{
  public int TQq;
  public fmo TQr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199069);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TQq);
      if (this.TQr != null)
      {
        paramVarArgs.oE(2, this.TQr.computeSize());
        this.TQr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(199069);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TQq) + 0;
      paramInt = i;
      if (this.TQr != null) {
        paramInt = i + g.a.a.a.oD(2, this.TQr.computeSize());
      }
      AppMethodBeat.o(199069);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(199069);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dix localdix = (dix)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(199069);
        return -1;
      case 1: 
        localdix.TQq = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(199069);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fmo localfmo = new fmo();
        if ((localObject != null) && (localObject.length > 0)) {
          localfmo.parseFrom((byte[])localObject);
        }
        localdix.TQr = localfmo;
        paramInt += 1;
      }
      AppMethodBeat.o(199069);
      return 0;
    }
    AppMethodBeat.o(199069);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dix
 * JD-Core Version:    0.7.0.1
 */