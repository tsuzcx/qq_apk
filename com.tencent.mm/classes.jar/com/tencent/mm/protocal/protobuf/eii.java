package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eii
  extends com.tencent.mm.cd.a
{
  public int Ukp;
  public LinkedList<eos> Ukq;
  
  public eii()
  {
    AppMethodBeat.i(133195);
    this.Ukq = new LinkedList();
    AppMethodBeat.o(133195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133196);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Ukp);
      paramVarArgs.e(2, 8, this.Ukq);
      AppMethodBeat.o(133196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Ukp);
      i = g.a.a.a.c(2, 8, this.Ukq);
      AppMethodBeat.o(133196);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ukq.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(133196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eii localeii = (eii)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133196);
        return -1;
      case 1: 
        localeii.Ukp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(133196);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eos localeos = new eos();
        if ((localObject != null) && (localObject.length > 0)) {
          localeos.parseFrom((byte[])localObject);
        }
        localeii.Ukq.add(localeos);
        paramInt += 1;
      }
      AppMethodBeat.o(133196);
      return 0;
    }
    AppMethodBeat.o(133196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eii
 * JD-Core Version:    0.7.0.1
 */