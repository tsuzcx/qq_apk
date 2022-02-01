package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class jh
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public eaf Tef;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133157);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqV);
      if (this.Tef != null)
      {
        paramVarArgs.oE(2, this.Tef.computeSize());
        this.Tef.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.Tef != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tef.computeSize());
      }
      AppMethodBeat.o(133157);
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
      AppMethodBeat.o(133157);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      jh localjh = (jh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133157);
        return -1;
      case 1: 
        localjh.CqV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(133157);
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
        localjh.Tef = localeaf;
        paramInt += 1;
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    AppMethodBeat.o(133157);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jh
 * JD-Core Version:    0.7.0.1
 */