package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhn
  extends com.tencent.mm.bw.a
{
  public int gMk;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127284);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.gMk);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.gMk) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      AppMethodBeat.o(127284);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhn localdhn = (dhn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127284);
        return -1;
      case 1: 
        localdhn.gMk = locala.LVo.xF();
        AppMethodBeat.o(127284);
        return 0;
      case 2: 
        localdhn.title = locala.LVo.readString();
        AppMethodBeat.o(127284);
        return 0;
      }
      localdhn.url = locala.LVo.readString();
      AppMethodBeat.o(127284);
      return 0;
    }
    AppMethodBeat.o(127284);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhn
 * JD-Core Version:    0.7.0.1
 */