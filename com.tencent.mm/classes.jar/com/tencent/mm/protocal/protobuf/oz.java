package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oz
  extends com.tencent.mm.cd.a
{
  public long RXl;
  public LinkedList<cjq> RXm;
  
  public oz()
  {
    AppMethodBeat.i(252113);
    this.RXl = 0L;
    this.RXm = new LinkedList();
    AppMethodBeat.o(252113);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RXl);
      paramVarArgs.e(2, 8, this.RXm);
      AppMethodBeat.o(252117);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.RXl);
      i = g.a.a.a.c(2, 8, this.RXm);
      AppMethodBeat.o(252117);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RXm.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(252117);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      oz localoz = (oz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(252117);
        return -1;
      case 1: 
        localoz.RXl = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(252117);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cjq localcjq = new cjq();
        if ((localObject != null) && (localObject.length > 0)) {
          localcjq.parseFrom((byte[])localObject);
        }
        localoz.RXm.add(localcjq);
        paramInt += 1;
      }
      AppMethodBeat.o(252117);
      return 0;
    }
    AppMethodBeat.o(252117);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oz
 * JD-Core Version:    0.7.0.1
 */