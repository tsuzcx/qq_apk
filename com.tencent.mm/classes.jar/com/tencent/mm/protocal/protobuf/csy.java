package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csy
  extends com.tencent.mm.bw.a
{
  public int KXD;
  public String MxW;
  public String MxX;
  public String path;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123630);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.MxW != null) {
        paramVarArgs.e(2, this.MxW);
      }
      if (this.MxX != null) {
        paramVarArgs.e(3, this.MxX);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      paramVarArgs.aM(5, this.KXD);
      paramVarArgs.aM(6, this.type);
      AppMethodBeat.o(123630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label486;
      }
    }
    label486:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MxW != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MxW);
      }
      i = paramInt;
      if (this.MxX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MxX);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.path);
      }
      i = g.a.a.b.b.a.bu(5, this.KXD);
      int j = g.a.a.b.b.a.bu(6, this.type);
      AppMethodBeat.o(123630);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123630);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        csy localcsy = (csy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123630);
          return -1;
        case 1: 
          localcsy.username = locala.UbS.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 2: 
          localcsy.MxW = locala.UbS.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 3: 
          localcsy.MxX = locala.UbS.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 4: 
          localcsy.path = locala.UbS.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 5: 
          localcsy.KXD = locala.UbS.zi();
          AppMethodBeat.o(123630);
          return 0;
        }
        localcsy.type = locala.UbS.zi();
        AppMethodBeat.o(123630);
        return 0;
      }
      AppMethodBeat.o(123630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csy
 * JD-Core Version:    0.7.0.1
 */