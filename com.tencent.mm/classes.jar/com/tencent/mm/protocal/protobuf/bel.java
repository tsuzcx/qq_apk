package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bel
  extends com.tencent.mm.cd.a
{
  public String app_id;
  public String path;
  public String ueW;
  public String ufC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198085);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.f(1, this.app_id);
      }
      if (this.path != null) {
        paramVarArgs.f(2, this.path);
      }
      if (this.ueW != null) {
        paramVarArgs.f(3, this.ueW);
      }
      if (this.ufC != null) {
        paramVarArgs.f(4, this.ufC);
      }
      AppMethodBeat.o(198085);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.path);
      }
      i = paramInt;
      if (this.ueW != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ueW);
      }
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ufC);
      }
      AppMethodBeat.o(198085);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198085);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bel localbel = (bel)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(198085);
          return -1;
        case 1: 
          localbel.app_id = locala.abFh.readString();
          AppMethodBeat.o(198085);
          return 0;
        case 2: 
          localbel.path = locala.abFh.readString();
          AppMethodBeat.o(198085);
          return 0;
        case 3: 
          localbel.ueW = locala.abFh.readString();
          AppMethodBeat.o(198085);
          return 0;
        }
        localbel.ufC = locala.abFh.readString();
        AppMethodBeat.o(198085);
        return 0;
      }
      AppMethodBeat.o(198085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bel
 * JD-Core Version:    0.7.0.1
 */