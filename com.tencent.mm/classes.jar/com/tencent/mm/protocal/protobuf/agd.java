package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agd
  extends com.tencent.mm.cd.a
{
  public LinkedList<dfd> RIQ;
  public String mye;
  
  public agd()
  {
    AppMethodBeat.i(152531);
    this.RIQ = new LinkedList();
    AppMethodBeat.o(152531);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152532);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mye != null) {
        paramVarArgs.f(1, this.mye);
      }
      paramVarArgs.e(2, 8, this.RIQ);
      AppMethodBeat.o(152532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mye == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.mye) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RIQ);
      AppMethodBeat.o(152532);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152532);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        agd localagd = (agd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152532);
          return -1;
        case 1: 
          localagd.mye = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152532);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dfd localdfd = new dfd();
          if ((localObject != null) && (localObject.length > 0)) {
            localdfd.parseFrom((byte[])localObject);
          }
          localagd.RIQ.add(localdfd);
          paramInt += 1;
        }
        AppMethodBeat.o(152532);
        return 0;
      }
      AppMethodBeat.o(152532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agd
 * JD-Core Version:    0.7.0.1
 */