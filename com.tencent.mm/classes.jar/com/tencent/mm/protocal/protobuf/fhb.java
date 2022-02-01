package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhb
  extends com.tencent.mm.cd.a
{
  public LinkedList<fha> UHi;
  public int rVx;
  
  public fhb()
  {
    AppMethodBeat.i(32513);
    this.UHi = new LinkedList();
    AppMethodBeat.o(32513);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32514);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.UHi);
      paramVarArgs.aY(2, this.rVx);
      AppMethodBeat.o(32514);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.UHi);
      i = g.a.a.b.b.a.bM(2, this.rVx);
      AppMethodBeat.o(32514);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UHi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32514);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fhb localfhb = (fhb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32514);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fha localfha = new fha();
          if ((localObject != null) && (localObject.length > 0)) {
            localfha.parseFrom((byte[])localObject);
          }
          localfhb.UHi.add(localfha);
          paramInt += 1;
        }
        AppMethodBeat.o(32514);
        return 0;
      }
      localfhb.rVx = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(32514);
      return 0;
    }
    AppMethodBeat.o(32514);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhb
 * JD-Core Version:    0.7.0.1
 */