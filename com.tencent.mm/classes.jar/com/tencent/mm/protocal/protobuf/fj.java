package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fj
  extends com.tencent.mm.cd.a
{
  public LinkedList<dby> RKA;
  public String sSX;
  
  public fj()
  {
    AppMethodBeat.i(208889);
    this.RKA = new LinkedList();
    AppMethodBeat.o(208889);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208890);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RKA);
      if (this.sSX != null) {
        paramVarArgs.f(2, this.sSX);
      }
      AppMethodBeat.o(208890);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.RKA) + 0;
      paramInt = i;
      if (this.sSX != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.sSX);
      }
      AppMethodBeat.o(208890);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RKA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(208890);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fj localfj = (fj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(208890);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dby localdby = new dby();
          if ((localObject != null) && (localObject.length > 0)) {
            localdby.parseFrom((byte[])localObject);
          }
          localfj.RKA.add(localdby);
          paramInt += 1;
        }
        AppMethodBeat.o(208890);
        return 0;
      }
      localfj.sSX = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(208890);
      return 0;
    }
    AppMethodBeat.o(208890);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fj
 * JD-Core Version:    0.7.0.1
 */