package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ahx
  extends com.tencent.mm.cd.a
{
  public int SsH;
  public ahy SsI;
  public int SsJ;
  public ahy SsK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43094);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.SsK == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.SsH);
      if (this.SsI != null)
      {
        paramVarArgs.oE(2, this.SsI.computeSize());
        this.SsI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.SsJ);
      if (this.SsK != null)
      {
        paramVarArgs.oE(4, this.SsK.computeSize());
        this.SsK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SsH) + 0;
      paramInt = i;
      if (this.SsI != null) {
        paramInt = i + g.a.a.a.oD(2, this.SsI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SsJ);
      paramInt = i;
      if (this.SsK != null) {
        paramInt = i + g.a.a.a.oD(4, this.SsK.computeSize());
      }
      AppMethodBeat.o(43094);
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
      if (this.SsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.SsK == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ahx localahx = (ahx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ahy localahy;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43094);
        return -1;
      case 1: 
        localahx.SsH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43094);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localahy = new ahy();
          if ((localObject != null) && (localObject.length > 0)) {
            localahy.parseFrom((byte[])localObject);
          }
          localahx.SsI = localahy;
          paramInt += 1;
        }
        AppMethodBeat.o(43094);
        return 0;
      case 3: 
        localahx.SsJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43094);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localahy = new ahy();
        if ((localObject != null) && (localObject.length > 0)) {
          localahy.parseFrom((byte[])localObject);
        }
        localahx.SsK = localahy;
        paramInt += 1;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    AppMethodBeat.o(43094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahx
 * JD-Core Version:    0.7.0.1
 */