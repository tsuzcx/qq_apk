package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebt
  extends com.tencent.mm.cd.a
{
  public eae TdH;
  public String TdI;
  public long TdK;
  public int lpw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104834);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TdI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.lpw);
      if (this.TdI != null) {
        paramVarArgs.f(2, this.TdI);
      }
      if (this.TdH != null)
      {
        paramVarArgs.oE(3, this.TdH.computeSize());
        this.TdH.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(4, this.TdK);
      AppMethodBeat.o(104834);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.lpw) + 0;
      paramInt = i;
      if (this.TdI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TdI);
      }
      i = paramInt;
      if (this.TdH != null) {
        i = paramInt + g.a.a.a.oD(3, this.TdH.computeSize());
      }
      paramInt = g.a.a.b.b.a.p(4, this.TdK);
      AppMethodBeat.o(104834);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TdI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104834);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ebt localebt = (ebt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104834);
        return -1;
      case 1: 
        localebt.lpw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104834);
        return 0;
      case 2: 
        localebt.TdI = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(104834);
        return 0;
      case 3: 
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
          localebt.TdH = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(104834);
        return 0;
      }
      localebt.TdK = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(104834);
      return 0;
    }
    AppMethodBeat.o(104834);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebt
 * JD-Core Version:    0.7.0.1
 */