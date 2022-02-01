package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhp
  extends com.tencent.mm.bw.a
{
  public int cZX;
  public String oGN;
  public String path;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127285);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.cZX);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.oGN != null) {
        paramVarArgs.d(3, this.oGN);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.cZX) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.oGN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oGN);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      AppMethodBeat.o(127285);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhp localdhp = (dhp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127285);
        return -1;
      case 1: 
        localdhp.cZX = locala.LVo.xF();
        AppMethodBeat.o(127285);
        return 0;
      case 2: 
        localdhp.title = locala.LVo.readString();
        AppMethodBeat.o(127285);
        return 0;
      case 3: 
        localdhp.oGN = locala.LVo.readString();
        AppMethodBeat.o(127285);
        return 0;
      }
      localdhp.path = locala.LVo.readString();
      AppMethodBeat.o(127285);
      return 0;
    }
    AppMethodBeat.o(127285);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhp
 * JD-Core Version:    0.7.0.1
 */