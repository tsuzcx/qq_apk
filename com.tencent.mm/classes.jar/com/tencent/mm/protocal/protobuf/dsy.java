package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsy
  extends com.tencent.mm.cd.a
{
  public LinkedList<dsz> TZo;
  public int count;
  public int dXr;
  
  public dsy()
  {
    AppMethodBeat.i(32400);
    this.TZo = new LinkedList();
    AppMethodBeat.o(32400);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32401);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.count);
      paramVarArgs.e(2, 8, this.TZo);
      paramVarArgs.aY(3, this.dXr);
      AppMethodBeat.o(32401);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.count);
      i = g.a.a.a.c(2, 8, this.TZo);
      int j = g.a.a.b.b.a.bM(3, this.dXr);
      AppMethodBeat.o(32401);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TZo.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32401);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dsy localdsy = (dsy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32401);
        return -1;
      case 1: 
        localdsy.count = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32401);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dsz localdsz = new dsz();
          if ((localObject != null) && (localObject.length > 0)) {
            localdsz.parseFrom((byte[])localObject);
          }
          localdsy.TZo.add(localdsz);
          paramInt += 1;
        }
        AppMethodBeat.o(32401);
        return 0;
      }
      localdsy.dXr = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(32401);
      return 0;
    }
    AppMethodBeat.o(32401);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsy
 * JD-Core Version:    0.7.0.1
 */