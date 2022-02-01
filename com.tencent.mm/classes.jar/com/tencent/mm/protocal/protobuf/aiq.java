package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aiq
  extends com.tencent.mm.cd.a
{
  public eae RMR;
  public int Stl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133169);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RMR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133169);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Stl);
      if (this.RMR != null)
      {
        paramVarArgs.oE(2, this.RMR.computeSize());
        this.RMR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Stl) + 0;
      paramInt = i;
      if (this.RMR != null) {
        paramInt = i + g.a.a.a.oD(2, this.RMR.computeSize());
      }
      AppMethodBeat.o(133169);
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
      if (this.RMR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133169);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      aiq localaiq = (aiq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133169);
        return -1;
      case 1: 
        localaiq.Stl = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(133169);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eae localeae = new eae();
        if ((localObject != null) && (localObject.length > 0)) {
          localeae.dd((byte[])localObject);
        }
        localaiq.RMR = localeae;
        paramInt += 1;
      }
      AppMethodBeat.o(133169);
      return 0;
    }
    AppMethodBeat.o(133169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiq
 * JD-Core Version:    0.7.0.1
 */