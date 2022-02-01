package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aoj
  extends com.tencent.mm.cd.a
{
  public int SfH;
  public eae SfI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127482);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127482);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.SfH);
      if (this.SfI != null)
      {
        paramVarArgs.oE(3, this.SfI.computeSize());
        this.SfI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SfH) + 0;
      paramInt = i;
      if (this.SfI != null) {
        paramInt = i + g.a.a.a.oD(3, this.SfI.computeSize());
      }
      AppMethodBeat.o(127482);
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
      if (this.SfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127482);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      aoj localaoj = (aoj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(127482);
        return -1;
      case 1: 
        localaoj.SfH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127482);
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
        localaoj.SfI = localeae;
        paramInt += 1;
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    AppMethodBeat.o(127482);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoj
 * JD-Core Version:    0.7.0.1
 */