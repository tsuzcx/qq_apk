package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dis
  extends com.tencent.mm.cd.a
{
  public int TQj;
  public String nickname;
  public String ueX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229384);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TQj);
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.ueX != null) {
        paramVarArgs.f(3, this.ueX);
      }
      AppMethodBeat.o(229384);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TQj) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.ueX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ueX);
      }
      AppMethodBeat.o(229384);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(229384);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dis localdis = (dis)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(229384);
        return -1;
      case 1: 
        localdis.TQj = locala.abFh.AK();
        AppMethodBeat.o(229384);
        return 0;
      case 2: 
        localdis.nickname = locala.abFh.readString();
        AppMethodBeat.o(229384);
        return 0;
      }
      localdis.ueX = locala.abFh.readString();
      AppMethodBeat.o(229384);
      return 0;
    }
    AppMethodBeat.o(229384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dis
 * JD-Core Version:    0.7.0.1
 */