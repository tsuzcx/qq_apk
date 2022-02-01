package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbx
  extends com.tencent.mm.cd.a
{
  public int RYM;
  public String TJv;
  public String TJw;
  public String path;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123630);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.TJv != null) {
        paramVarArgs.f(2, this.TJv);
      }
      if (this.TJw != null) {
        paramVarArgs.f(3, this.TJw);
      }
      if (this.path != null) {
        paramVarArgs.f(4, this.path);
      }
      paramVarArgs.aY(5, this.RYM);
      paramVarArgs.aY(6, this.type);
      AppMethodBeat.o(123630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label486;
      }
    }
    label486:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TJv != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TJv);
      }
      i = paramInt;
      if (this.TJw != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TJw);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.path);
      }
      i = g.a.a.b.b.a.bM(5, this.RYM);
      int j = g.a.a.b.b.a.bM(6, this.type);
      AppMethodBeat.o(123630);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123630);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbx localdbx = (dbx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123630);
          return -1;
        case 1: 
          localdbx.username = locala.abFh.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 2: 
          localdbx.TJv = locala.abFh.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 3: 
          localdbx.TJw = locala.abFh.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 4: 
          localdbx.path = locala.abFh.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 5: 
          localdbx.RYM = locala.abFh.AK();
          AppMethodBeat.o(123630);
          return 0;
        }
        localdbx.type = locala.abFh.AK();
        AppMethodBeat.o(123630);
        return 0;
      }
      AppMethodBeat.o(123630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbx
 * JD-Core Version:    0.7.0.1
 */