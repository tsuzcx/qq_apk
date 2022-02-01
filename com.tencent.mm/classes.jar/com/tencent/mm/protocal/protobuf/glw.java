package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class glw
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public String Kmn;
  public boolean achn;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153328);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.HTK);
      if (this.Kmn != null) {
        paramVarArgs.g(2, this.Kmn);
      }
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      paramVarArgs.di(4, this.achn);
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.HTK) + 0;
      paramInt = i;
      if (this.Kmn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Kmn);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nickname);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(153328);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      glw localglw = (glw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153328);
        return -1;
      case 1: 
        localglw.HTK = locala.ajGk.aar();
        AppMethodBeat.o(153328);
        return 0;
      case 2: 
        localglw.Kmn = locala.ajGk.readString();
        AppMethodBeat.o(153328);
        return 0;
      case 3: 
        localglw.nickname = locala.ajGk.readString();
        AppMethodBeat.o(153328);
        return 0;
      }
      localglw.achn = locala.ajGk.aai();
      AppMethodBeat.o(153328);
      return 0;
    }
    AppMethodBeat.o(153328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glw
 * JD-Core Version:    0.7.0.1
 */