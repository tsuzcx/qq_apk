package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cik
  extends com.tencent.mm.cd.a
{
  public String Tpo;
  public String Tpp;
  public String icon;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72495);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tpo != null) {
        paramVarArgs.f(1, this.Tpo);
      }
      if (this.Tpp != null) {
        paramVarArgs.f(2, this.Tpp);
      }
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      if (this.icon != null) {
        paramVarArgs.f(4, this.icon);
      }
      AppMethodBeat.o(72495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tpo == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.Tpo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tpp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tpp);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.url);
      }
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.icon);
      }
      AppMethodBeat.o(72495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72495);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cik localcik = (cik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72495);
          return -1;
        case 1: 
          localcik.Tpo = locala.abFh.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 2: 
          localcik.Tpp = locala.abFh.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 3: 
          localcik.url = locala.abFh.readString();
          AppMethodBeat.o(72495);
          return 0;
        }
        localcik.icon = locala.abFh.readString();
        AppMethodBeat.o(72495);
        return 0;
      }
      AppMethodBeat.o(72495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cik
 * JD-Core Version:    0.7.0.1
 */