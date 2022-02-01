package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejh
  extends com.tencent.mm.cd.a
{
  public eaf UkV;
  public long Ulj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125769);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Ulj);
      if (this.UkV != null)
      {
        paramVarArgs.oE(2, this.UkV.computeSize());
        this.UkV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125769);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Ulj) + 0;
      paramInt = i;
      if (this.UkV != null) {
        paramInt = i + g.a.a.a.oD(2, this.UkV.computeSize());
      }
      AppMethodBeat.o(125769);
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
      AppMethodBeat.o(125769);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ejh localejh = (ejh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125769);
        return -1;
      case 1: 
        localejh.Ulj = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(125769);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eaf localeaf = new eaf();
        if ((localObject != null) && (localObject.length > 0)) {
          localeaf.de((byte[])localObject);
        }
        localejh.UkV = localeaf;
        paramInt += 1;
      }
      AppMethodBeat.o(125769);
      return 0;
    }
    AppMethodBeat.o(125769);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejh
 * JD-Core Version:    0.7.0.1
 */