package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ctb
  extends com.tencent.mm.cd.a
{
  public int RRw;
  public eae TAI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(284938);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TAI == null)
      {
        paramVarArgs = new b("Not all required fields were included: NotifyData");
        AppMethodBeat.o(284938);
        throw paramVarArgs;
      }
      if (this.TAI != null)
      {
        paramVarArgs.oE(1, this.TAI.computeSize());
        this.TAI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RRw);
      AppMethodBeat.o(284938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TAI == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.a.oD(1, this.TAI.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RRw);
      AppMethodBeat.o(284938);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TAI == null)
        {
          paramVarArgs = new b("Not all required fields were included: NotifyData");
          AppMethodBeat.o(284938);
          throw paramVarArgs;
        }
        AppMethodBeat.o(284938);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ctb localctb = (ctb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(284938);
          return -1;
        case 1: 
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
            localctb.TAI = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(284938);
          return 0;
        }
        localctb.RRw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(284938);
        return 0;
      }
      AppMethodBeat.o(284938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctb
 * JD-Core Version:    0.7.0.1
 */