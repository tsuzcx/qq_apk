package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ro
  extends com.tencent.mm.cd.a
{
  public String CNj;
  public String Sau;
  public String Sav;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117844);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNj == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(117844);
        throw paramVarArgs;
      }
      if (this.CNj != null) {
        paramVarArgs.f(1, this.CNj);
      }
      if (this.Sau != null) {
        paramVarArgs.f(2, this.Sau);
      }
      if (this.Sav != null) {
        paramVarArgs.f(3, this.Sav);
      }
      AppMethodBeat.o(117844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNj == null) {
        break label382;
      }
    }
    label382:
    for (int i = g.a.a.b.b.a.g(1, this.CNj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sau != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sau);
      }
      i = paramInt;
      if (this.Sav != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sav);
      }
      AppMethodBeat.o(117844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CNj == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(117844);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117844);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ro localro = (ro)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117844);
          return -1;
        case 1: 
          localro.CNj = locala.abFh.readString();
          AppMethodBeat.o(117844);
          return 0;
        case 2: 
          localro.Sau = locala.abFh.readString();
          AppMethodBeat.o(117844);
          return 0;
        }
        localro.Sav = locala.abFh.readString();
        AppMethodBeat.o(117844);
        return 0;
      }
      AppMethodBeat.o(117844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ro
 * JD-Core Version:    0.7.0.1
 */