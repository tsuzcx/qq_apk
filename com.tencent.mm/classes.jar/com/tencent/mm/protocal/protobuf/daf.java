package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daf
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public long HlH;
  public String UserName;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138184);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.UserName != null) {
        paramVarArgs.f(3, this.UserName);
      }
      paramVarArgs.bm(4, this.HlH);
      AppMethodBeat.o(138184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMB);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UserName);
      }
      paramInt = g.a.a.b.b.a.p(4, this.HlH);
      AppMethodBeat.o(138184);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(138184);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        daf localdaf = (daf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138184);
          return -1;
        case 1: 
          localdaf.fwr = locala.abFh.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 2: 
          localdaf.CMB = locala.abFh.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 3: 
          localdaf.UserName = locala.abFh.readString();
          AppMethodBeat.o(138184);
          return 0;
        }
        localdaf.HlH = locala.abFh.AN();
        AppMethodBeat.o(138184);
        return 0;
      }
      AppMethodBeat.o(138184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daf
 * JD-Core Version:    0.7.0.1
 */