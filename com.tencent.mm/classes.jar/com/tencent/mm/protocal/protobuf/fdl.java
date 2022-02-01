package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdl
  extends com.tencent.mm.bw.a
{
  public int KXD;
  public String MxW;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123705);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.MxW != null) {
        paramVarArgs.e(2, this.MxW);
      }
      paramVarArgs.aM(3, this.KXD);
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      AppMethodBeat.o(123705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MxW != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MxW);
      }
      i += g.a.a.b.b.a.bu(3, this.KXD);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.path);
      }
      AppMethodBeat.o(123705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123705);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fdl localfdl = (fdl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123705);
          return -1;
        case 1: 
          localfdl.username = locala.UbS.readString();
          AppMethodBeat.o(123705);
          return 0;
        case 2: 
          localfdl.MxW = locala.UbS.readString();
          AppMethodBeat.o(123705);
          return 0;
        case 3: 
          localfdl.KXD = locala.UbS.zi();
          AppMethodBeat.o(123705);
          return 0;
        }
        localfdl.path = locala.UbS.readString();
        AppMethodBeat.o(123705);
        return 0;
      }
      AppMethodBeat.o(123705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdl
 * JD-Core Version:    0.7.0.1
 */