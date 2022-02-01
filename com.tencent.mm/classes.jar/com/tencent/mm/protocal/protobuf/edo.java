package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edo
  extends com.tencent.mm.cd.a
{
  public String jmx;
  public int lAW;
  public String md5;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(284649);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.jmx != null) {
        paramVarArgs.f(2, this.jmx);
      }
      if (this.md5 != null) {
        paramVarArgs.f(3, this.md5);
      }
      paramVarArgs.aY(4, this.lAW);
      AppMethodBeat.o(284649);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jmx != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jmx);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.md5);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.lAW);
      AppMethodBeat.o(284649);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(284649);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        edo localedo = (edo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(284649);
          return -1;
        case 1: 
          localedo.title = locala.abFh.readString();
          AppMethodBeat.o(284649);
          return 0;
        case 2: 
          localedo.jmx = locala.abFh.readString();
          AppMethodBeat.o(284649);
          return 0;
        case 3: 
          localedo.md5 = locala.abFh.readString();
          AppMethodBeat.o(284649);
          return 0;
        }
        localedo.lAW = locala.abFh.AK();
        AppMethodBeat.o(284649);
        return 0;
      }
      AppMethodBeat.o(284649);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edo
 * JD-Core Version:    0.7.0.1
 */