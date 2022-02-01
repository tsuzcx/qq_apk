package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exf
  extends com.tencent.mm.bx.a
{
  public String lPJ;
  public String md5;
  public int osy;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259582);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.lPJ != null) {
        paramVarArgs.g(2, this.lPJ);
      }
      if (this.md5 != null) {
        paramVarArgs.g(3, this.md5);
      }
      paramVarArgs.bS(4, this.osy);
      AppMethodBeat.o(259582);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lPJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.lPJ);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.md5);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.osy);
      AppMethodBeat.o(259582);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259582);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        exf localexf = (exf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259582);
          return -1;
        case 1: 
          localexf.title = locala.ajGk.readString();
          AppMethodBeat.o(259582);
          return 0;
        case 2: 
          localexf.lPJ = locala.ajGk.readString();
          AppMethodBeat.o(259582);
          return 0;
        case 3: 
          localexf.md5 = locala.ajGk.readString();
          AppMethodBeat.o(259582);
          return 0;
        }
        localexf.osy = locala.ajGk.aar();
        AppMethodBeat.o(259582);
        return 0;
      }
      AppMethodBeat.o(259582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exf
 * JD-Core Version:    0.7.0.1
 */