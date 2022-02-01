package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.cd.a
{
  public an HnD;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249735);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.uin);
      if (this.HnD != null)
      {
        paramVarArgs.oE(2, this.HnD.computeSize());
        this.HnD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(249735);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.uin) + 0;
      paramInt = i;
      if (this.HnD != null) {
        paramInt = i + g.a.a.a.oD(2, this.HnD.computeSize());
      }
      AppMethodBeat.o(249735);
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
      AppMethodBeat.o(249735);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      aw localaw = (aw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(249735);
        return -1;
      case 1: 
        localaw.uin = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(249735);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        an localan = new an();
        if ((localObject != null) && (localObject.length > 0)) {
          localan.parseFrom((byte[])localObject);
        }
        localaw.HnD = localan;
        paramInt += 1;
      }
      AppMethodBeat.o(249735);
      return 0;
    }
    AppMethodBeat.o(249735);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.aw
 * JD-Core Version:    0.7.0.1
 */