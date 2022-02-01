package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fia
  extends com.tencent.mm.bx.a
{
  public String IJC;
  public String ThumbUrl;
  public String UserName;
  public long abIO;
  public int abIP;
  public int abIQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118434);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      paramVarArgs.bv(2, this.abIO);
      paramVarArgs.bS(3, this.abIP);
      if (this.ThumbUrl != null) {
        paramVarArgs.g(4, this.ThumbUrl);
      }
      paramVarArgs.bS(5, this.abIQ);
      if (this.IJC != null) {
        paramVarArgs.g(6, this.IJC);
      }
      AppMethodBeat.o(118434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.abIO) + i.a.a.b.b.a.cJ(3, this.abIP);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ThumbUrl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abIQ);
      paramInt = i;
      if (this.IJC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IJC);
      }
      AppMethodBeat.o(118434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118434);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fia localfia = (fia)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118434);
          return -1;
        case 1: 
          localfia.UserName = locala.ajGk.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 2: 
          localfia.abIO = locala.ajGk.aaw();
          AppMethodBeat.o(118434);
          return 0;
        case 3: 
          localfia.abIP = locala.ajGk.aar();
          AppMethodBeat.o(118434);
          return 0;
        case 4: 
          localfia.ThumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 5: 
          localfia.abIQ = locala.ajGk.aar();
          AppMethodBeat.o(118434);
          return 0;
        }
        localfia.IJC = locala.ajGk.readString();
        AppMethodBeat.o(118434);
        return 0;
      }
      AppMethodBeat.o(118434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fia
 * JD-Core Version:    0.7.0.1
 */