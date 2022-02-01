package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehy
  extends com.tencent.mm.cd.a
{
  public ead UjV;
  public int yAT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206019);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.yAT);
      if (this.UjV != null)
      {
        paramVarArgs.oE(2, this.UjV.computeSize());
        this.UjV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(206019);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.yAT) + 0;
      paramInt = i;
      if (this.UjV != null) {
        paramInt = i + g.a.a.a.oD(2, this.UjV.computeSize());
      }
      AppMethodBeat.o(206019);
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
      AppMethodBeat.o(206019);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ehy localehy = (ehy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(206019);
        return -1;
      case 1: 
        localehy.yAT = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206019);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ead localead = new ead();
        if ((localObject != null) && (localObject.length > 0)) {
          localead.parseFrom((byte[])localObject);
        }
        localehy.UjV = localead;
        paramInt += 1;
      }
      AppMethodBeat.o(206019);
      return 0;
    }
    AppMethodBeat.o(206019);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehy
 * JD-Core Version:    0.7.0.1
 */