package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crk
  extends com.tencent.mm.bw.a
{
  public long Brn;
  public String Desc;
  public String Title;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138184);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      paramVarArgs.bb(4, this.Brn);
      AppMethodBeat.o(138184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UserName);
      }
      paramInt = g.a.a.b.b.a.r(4, this.Brn);
      AppMethodBeat.o(138184);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(138184);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crk localcrk = (crk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138184);
          return -1;
        case 1: 
          localcrk.Title = locala.UbS.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 2: 
          localcrk.Desc = locala.UbS.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 3: 
          localcrk.UserName = locala.UbS.readString();
          AppMethodBeat.o(138184);
          return 0;
        }
        localcrk.Brn = locala.UbS.zl();
        AppMethodBeat.o(138184);
        return 0;
      }
      AppMethodBeat.o(138184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crk
 * JD-Core Version:    0.7.0.1
 */