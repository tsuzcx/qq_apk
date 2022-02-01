package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dot
  extends com.tencent.mm.cd.a
{
  public LinkedList<cop> TVU;
  public String id;
  
  public dot()
  {
    AppMethodBeat.i(257585);
    this.TVU = new LinkedList();
    AppMethodBeat.o(257585);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257587);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(257587);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      paramVarArgs.e(2, 8, this.TVU);
      AppMethodBeat.o(257587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label384;
      }
    }
    label384:
    for (paramInt = g.a.a.b.b.a.g(1, this.id) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.TVU);
      AppMethodBeat.o(257587);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TVU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(257587);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dot localdot = (dot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257587);
          return -1;
        case 1: 
          localdot.id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(257587);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cop localcop = new cop();
          if ((localObject != null) && (localObject.length > 0)) {
            localcop.parseFrom((byte[])localObject);
          }
          localdot.TVU.add(localcop);
          paramInt += 1;
        }
        AppMethodBeat.o(257587);
        return 0;
      }
      AppMethodBeat.o(257587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dot
 * JD-Core Version:    0.7.0.1
 */