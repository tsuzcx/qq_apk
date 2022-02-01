package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crj
  extends com.tencent.mm.cd.a
{
  public LinkedList<fbm> RGi;
  public String ROQ;
  
  public crj()
  {
    AppMethodBeat.i(91531);
    this.RGi = new LinkedList();
    AppMethodBeat.o(91531);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91532);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RGi);
      if (this.ROQ != null) {
        paramVarArgs.f(2, this.ROQ);
      }
      AppMethodBeat.o(91532);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.RGi) + 0;
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ROQ);
      }
      AppMethodBeat.o(91532);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RGi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91532);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      crj localcrj = (crj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91532);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fbm localfbm = new fbm();
          if ((localObject != null) && (localObject.length > 0)) {
            localfbm.parseFrom((byte[])localObject);
          }
          localcrj.RGi.add(localfbm);
          paramInt += 1;
        }
        AppMethodBeat.o(91532);
        return 0;
      }
      localcrj.ROQ = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(91532);
      return 0;
    }
    AppMethodBeat.o(91532);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crj
 * JD-Core Version:    0.7.0.1
 */