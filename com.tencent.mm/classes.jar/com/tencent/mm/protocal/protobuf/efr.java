package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efr
  extends com.tencent.mm.cd.a
{
  public LinkedList<dhw> RXm;
  public String fFe;
  
  public efr()
  {
    AppMethodBeat.i(122544);
    this.RXm = new LinkedList();
    AppMethodBeat.o(122544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fFe != null) {
        paramVarArgs.f(1, this.fFe);
      }
      paramVarArgs.e(2, 8, this.RXm);
      AppMethodBeat.o(122545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fFe == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.fFe) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RXm);
      AppMethodBeat.o(122545);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RXm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        efr localefr = (efr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122545);
          return -1;
        case 1: 
          localefr.fFe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122545);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dhw localdhw = new dhw();
          if ((localObject != null) && (localObject.length > 0)) {
            localdhw.parseFrom((byte[])localObject);
          }
          localefr.RXm.add(localdhw);
          paramInt += 1;
        }
        AppMethodBeat.o(122545);
        return 0;
      }
      AppMethodBeat.o(122545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efr
 * JD-Core Version:    0.7.0.1
 */