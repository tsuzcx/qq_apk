package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anj
  extends com.tencent.mm.cd.a
{
  public long SxB;
  public long SxC;
  public LinkedList<ero> SxD;
  
  public anj()
  {
    AppMethodBeat.i(125722);
    this.SxD = new LinkedList();
    AppMethodBeat.o(125722);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125723);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SxB);
      paramVarArgs.bm(2, this.SxC);
      paramVarArgs.e(3, 8, this.SxD);
      AppMethodBeat.o(125723);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.SxB);
      i = g.a.a.b.b.a.p(2, this.SxC);
      int j = g.a.a.a.c(3, 8, this.SxD);
      AppMethodBeat.o(125723);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SxD.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      anj localanj = (anj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125723);
        return -1;
      case 1: 
        localanj.SxB = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(125723);
        return 0;
      case 2: 
        localanj.SxC = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(125723);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ero localero = new ero();
        if ((localObject != null) && (localObject.length > 0)) {
          localero.parseFrom((byte[])localObject);
        }
        localanj.SxD.add(localero);
        paramInt += 1;
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    AppMethodBeat.o(125723);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anj
 * JD-Core Version:    0.7.0.1
 */