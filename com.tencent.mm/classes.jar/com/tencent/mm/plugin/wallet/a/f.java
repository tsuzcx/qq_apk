package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.cd.a
{
  public String Owg;
  public String Owh;
  public String Owi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91290);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Owg != null) {
        paramVarArgs.f(1, this.Owg);
      }
      if (this.Owh != null) {
        paramVarArgs.f(2, this.Owh);
      }
      if (this.Owi != null) {
        paramVarArgs.f(3, this.Owi);
      }
      AppMethodBeat.o(91290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Owg == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.Owg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Owh != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Owh);
      }
      i = paramInt;
      if (this.Owi != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Owi);
      }
      AppMethodBeat.o(91290);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91290);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91290);
          return -1;
        case 1: 
          localf.Owg = locala.abFh.readString();
          AppMethodBeat.o(91290);
          return 0;
        case 2: 
          localf.Owh = locala.abFh.readString();
          AppMethodBeat.o(91290);
          return 0;
        }
        localf.Owi = locala.abFh.readString();
        AppMethodBeat.o(91290);
        return 0;
      }
      AppMethodBeat.o(91290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.f
 * JD-Core Version:    0.7.0.1
 */