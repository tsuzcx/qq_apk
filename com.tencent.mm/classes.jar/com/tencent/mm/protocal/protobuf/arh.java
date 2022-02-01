package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arh
  extends com.tencent.mm.cd.a
{
  public int SEo;
  public LinkedList<ari> lpz;
  
  public arh()
  {
    AppMethodBeat.i(209619);
    this.lpz = new LinkedList();
    AppMethodBeat.o(209619);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209622);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.lpz);
      paramVarArgs.aY(2, this.SEo);
      AppMethodBeat.o(209622);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.lpz);
      i = g.a.a.b.b.a.bM(2, this.SEo);
      AppMethodBeat.o(209622);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lpz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(209622);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      arh localarh = (arh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209622);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ari localari = new ari();
          if ((localObject != null) && (localObject.length > 0)) {
            localari.parseFrom((byte[])localObject);
          }
          localarh.lpz.add(localari);
          paramInt += 1;
        }
        AppMethodBeat.o(209622);
        return 0;
      }
      localarh.SEo = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(209622);
      return 0;
    }
    AppMethodBeat.o(209622);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arh
 * JD-Core Version:    0.7.0.1
 */