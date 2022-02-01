package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class fhk
  extends com.tencent.mm.cd.a
{
  public b UHr;
  public String description;
  public String title;
  public String vhY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209278);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhY != null) {
        paramVarArgs.f(1, this.vhY);
      }
      if (this.UHr != null) {
        paramVarArgs.c(2, this.UHr);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.description != null) {
        paramVarArgs.f(4, this.description);
      }
      AppMethodBeat.o(209278);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhY == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.vhY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UHr != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.UHr);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.description);
      }
      AppMethodBeat.o(209278);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(209278);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fhk localfhk = (fhk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209278);
          return -1;
        case 1: 
          localfhk.vhY = locala.abFh.readString();
          AppMethodBeat.o(209278);
          return 0;
        case 2: 
          localfhk.UHr = locala.abFh.iUw();
          AppMethodBeat.o(209278);
          return 0;
        case 3: 
          localfhk.title = locala.abFh.readString();
          AppMethodBeat.o(209278);
          return 0;
        }
        localfhk.description = locala.abFh.readString();
        AppMethodBeat.o(209278);
        return 0;
      }
      AppMethodBeat.o(209278);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhk
 * JD-Core Version:    0.7.0.1
 */