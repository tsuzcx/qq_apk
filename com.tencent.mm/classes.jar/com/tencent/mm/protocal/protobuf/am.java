package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  extends com.tencent.mm.bv.a
{
  public String content;
  public String crs;
  public String pxP;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28297);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.crs != null) {
        paramVarArgs.e(2, this.crs);
      }
      if (this.pxP != null) {
        paramVarArgs.e(3, this.pxP);
      }
      if (this.content != null) {
        paramVarArgs.e(4, this.content);
      }
      AppMethodBeat.o(28297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label404;
      }
    }
    label404:
    for (int i = e.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.crs != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.crs);
      }
      i = paramInt;
      if (this.pxP != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.pxP);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.content);
      }
      AppMethodBeat.o(28297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28297);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28297);
          return -1;
        case 1: 
          localam.username = locala.CLY.readString();
          AppMethodBeat.o(28297);
          return 0;
        case 2: 
          localam.crs = locala.CLY.readString();
          AppMethodBeat.o(28297);
          return 0;
        case 3: 
          localam.pxP = locala.CLY.readString();
          AppMethodBeat.o(28297);
          return 0;
        }
        localam.content = locala.CLY.readString();
        AppMethodBeat.o(28297);
        return 0;
      }
      AppMethodBeat.o(28297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.am
 * JD-Core Version:    0.7.0.1
 */