package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxn
  extends com.tencent.mm.bw.a
{
  public String MD5;
  public String Title;
  public String URL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.e(1, this.URL);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.MD5 != null) {
        paramVarArgs.e(3, this.MD5);
      }
      AppMethodBeat.o(32453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label343;
      }
    }
    label343:
    for (int i = g.a.a.b.b.a.f(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MD5);
      }
      AppMethodBeat.o(32453);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32453);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dxn localdxn = (dxn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32453);
          return -1;
        case 1: 
          localdxn.URL = locala.UbS.readString();
          AppMethodBeat.o(32453);
          return 0;
        case 2: 
          localdxn.Title = locala.UbS.readString();
          AppMethodBeat.o(32453);
          return 0;
        }
        localdxn.MD5 = locala.UbS.readString();
        AppMethodBeat.o(32453);
        return 0;
      }
      AppMethodBeat.o(32453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxn
 * JD-Core Version:    0.7.0.1
 */