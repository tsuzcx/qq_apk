package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eaj
  extends com.tencent.mm.cd.a
{
  public LinkedList<csz> UfC;
  public boolean UfD;
  public boolean UfE;
  public boolean UfF;
  public boolean UfG;
  public boolean UfH;
  
  public eaj()
  {
    AppMethodBeat.i(155454);
    this.UfC = new LinkedList();
    AppMethodBeat.o(155454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.UfC);
      paramVarArgs.co(2, this.UfD);
      paramVarArgs.co(3, this.UfE);
      paramVarArgs.co(4, this.UfF);
      paramVarArgs.co(5, this.UfG);
      paramVarArgs.co(6, this.UfH);
      AppMethodBeat.o(155455);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.UfC);
      i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(155455);
      return paramInt + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UfC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(155455);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eaj localeaj = (eaj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155455);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          csz localcsz = new csz();
          if ((localObject != null) && (localObject.length > 0)) {
            localcsz.parseFrom((byte[])localObject);
          }
          localeaj.UfC.add(localcsz);
          paramInt += 1;
        }
        AppMethodBeat.o(155455);
        return 0;
      case 2: 
        localeaj.UfD = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(155455);
        return 0;
      case 3: 
        localeaj.UfE = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(155455);
        return 0;
      case 4: 
        localeaj.UfF = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(155455);
        return 0;
      case 5: 
        localeaj.UfG = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(155455);
        return 0;
      }
      localeaj.UfH = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(155455);
      return 0;
    }
    AppMethodBeat.o(155455);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaj
 * JD-Core Version:    0.7.0.1
 */