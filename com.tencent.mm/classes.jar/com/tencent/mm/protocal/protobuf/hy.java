package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hy
  extends com.tencent.mm.cd.a
{
  public String data;
  public int fBP;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153261);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.data != null) {
        paramVarArgs.f(2, this.data);
      }
      paramVarArgs.aY(3, this.fBP);
      AppMethodBeat.o(153261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.data != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.data);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.fBP);
      AppMethodBeat.o(153261);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153261);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        hy localhy = (hy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153261);
          return -1;
        case 1: 
          localhy.username = locala.abFh.readString();
          AppMethodBeat.o(153261);
          return 0;
        case 2: 
          localhy.data = locala.abFh.readString();
          AppMethodBeat.o(153261);
          return 0;
        }
        localhy.fBP = locala.abFh.AK();
        AppMethodBeat.o(153261);
        return 0;
      }
      AppMethodBeat.o(153261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hy
 * JD-Core Version:    0.7.0.1
 */