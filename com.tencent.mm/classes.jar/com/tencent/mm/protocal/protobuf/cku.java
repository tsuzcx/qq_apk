package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cku
  extends com.tencent.mm.cd.a
{
  public String Tsl;
  public String Tsm;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82431);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.Tsl != null) {
        paramVarArgs.f(3, this.Tsl);
      }
      if (this.Tsm != null) {
        paramVarArgs.f(4, this.Tsm);
      }
      AppMethodBeat.o(82431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.Tsl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tsl);
      }
      paramInt = i;
      if (this.Tsm != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tsm);
      }
      AppMethodBeat.o(82431);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82431);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cku localcku = (cku)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82431);
          return -1;
        case 1: 
          localcku.title = locala.abFh.readString();
          AppMethodBeat.o(82431);
          return 0;
        case 2: 
          localcku.desc = locala.abFh.readString();
          AppMethodBeat.o(82431);
          return 0;
        case 3: 
          localcku.Tsl = locala.abFh.readString();
          AppMethodBeat.o(82431);
          return 0;
        }
        localcku.Tsm = locala.abFh.readString();
        AppMethodBeat.o(82431);
        return 0;
      }
      AppMethodBeat.o(82431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cku
 * JD-Core Version:    0.7.0.1
 */