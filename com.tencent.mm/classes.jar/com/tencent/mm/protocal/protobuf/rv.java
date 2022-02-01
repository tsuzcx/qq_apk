package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rv
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b SaV;
  public com.tencent.mm.cd.b SaW;
  public LinkedList<eex> SaX;
  
  public rv()
  {
    AppMethodBeat.i(117851);
    this.SaX = new LinkedList();
    AppMethodBeat.o(117851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117852);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SaV == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.SaW == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ServiceUrl");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.SaV != null) {
        paramVarArgs.c(1, this.SaV);
      }
      if (this.SaW != null) {
        paramVarArgs.c(2, this.SaW);
      }
      paramVarArgs.e(3, 8, this.SaX);
      AppMethodBeat.o(117852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SaV == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = g.a.a.b.b.a.b(1, this.SaV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SaW != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.SaW);
      }
      paramInt = g.a.a.a.c(3, 8, this.SaX);
      AppMethodBeat.o(117852);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SaX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SaV == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        if (this.SaW == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: ServiceUrl");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        rv localrv = (rv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117852);
          return -1;
        case 1: 
          localrv.SaV = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(117852);
          return 0;
        case 2: 
          localrv.SaW = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(117852);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eex localeex = new eex();
          if ((localObject != null) && (localObject.length > 0)) {
            localeex.parseFrom((byte[])localObject);
          }
          localrv.SaX.add(localeex);
          paramInt += 1;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      AppMethodBeat.o(117852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rv
 * JD-Core Version:    0.7.0.1
 */