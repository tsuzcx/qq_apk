package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eqv
  extends com.tencent.mm.cd.a
{
  public int Twy;
  public eaf Uti;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uti == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(32467);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Twy);
      if (this.Uti != null)
      {
        paramVarArgs.oE(2, this.Uti.computeSize());
        this.Uti.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Twy) + 0;
      paramInt = i;
      if (this.Uti != null) {
        paramInt = i + g.a.a.a.oD(2, this.Uti.computeSize());
      }
      AppMethodBeat.o(32467);
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
      if (this.Uti == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(32467);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eqv localeqv = (eqv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32467);
        return -1;
      case 1: 
        localeqv.Twy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32467);
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
        localeqv.Uti = localeaf;
        paramInt += 1;
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    AppMethodBeat.o(32467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqv
 * JD-Core Version:    0.7.0.1
 */