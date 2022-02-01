package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axy
  extends com.tencent.mm.cd.a
{
  public blm SKr;
  public long zaO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230086);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.zaO);
      if (this.SKr != null)
      {
        paramVarArgs.oE(2, this.SKr.computeSize());
        this.SKr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.zaO) + 0;
      paramInt = i;
      if (this.SKr != null) {
        paramInt = i + g.a.a.a.oD(2, this.SKr.computeSize());
      }
      AppMethodBeat.o(230086);
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
      AppMethodBeat.o(230086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      axy localaxy = (axy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(230086);
        return -1;
      case 1: 
        localaxy.zaO = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(230086);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        blm localblm = new blm();
        if ((localObject != null) && (localObject.length > 0)) {
          localblm.parseFrom((byte[])localObject);
        }
        localaxy.SKr = localblm;
        paramInt += 1;
      }
      AppMethodBeat.o(230086);
      return 0;
    }
    AppMethodBeat.o(230086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axy
 * JD-Core Version:    0.7.0.1
 */