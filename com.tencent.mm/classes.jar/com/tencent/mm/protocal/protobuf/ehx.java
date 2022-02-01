package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehx
  extends com.tencent.mm.bw.a
{
  public int dDG;
  public String path;
  public String qGB;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127285);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dDG);
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.qGB != null) {
        paramVarArgs.e(3, this.qGB);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.dDG) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.qGB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qGB);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.path);
      }
      AppMethodBeat.o(127285);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ehx localehx = (ehx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127285);
        return -1;
      case 1: 
        localehx.dDG = locala.UbS.zi();
        AppMethodBeat.o(127285);
        return 0;
      case 2: 
        localehx.title = locala.UbS.readString();
        AppMethodBeat.o(127285);
        return 0;
      case 3: 
        localehx.qGB = locala.UbS.readString();
        AppMethodBeat.o(127285);
        return 0;
      }
      localehx.path = locala.UbS.readString();
      AppMethodBeat.o(127285);
      return 0;
    }
    AppMethodBeat.o(127285);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehx
 * JD-Core Version:    0.7.0.1
 */