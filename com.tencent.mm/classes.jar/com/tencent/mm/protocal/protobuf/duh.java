package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duh
  extends com.tencent.mm.cd.a
{
  public long Tkj;
  public aaz Tkk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50102);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Tkj);
      if (this.Tkk != null)
      {
        paramVarArgs.oE(2, this.Tkk.computeSize());
        this.Tkk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50102);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Tkj) + 0;
      paramInt = i;
      if (this.Tkk != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tkk.computeSize());
      }
      AppMethodBeat.o(50102);
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
      AppMethodBeat.o(50102);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      duh localduh = (duh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(50102);
        return -1;
      case 1: 
        localduh.Tkj = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(50102);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        aaz localaaz = new aaz();
        if ((localObject != null) && (localObject.length > 0)) {
          localaaz.parseFrom((byte[])localObject);
        }
        localduh.Tkk = localaaz;
        paramInt += 1;
      }
      AppMethodBeat.o(50102);
      return 0;
    }
    AppMethodBeat.o(50102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duh
 * JD-Core Version:    0.7.0.1
 */