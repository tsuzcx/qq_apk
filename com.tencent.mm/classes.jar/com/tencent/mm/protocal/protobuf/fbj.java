package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fbj
  extends com.tencent.mm.bw.a
{
  public String Md5;
  public int NxA;
  public int NxB;
  public String xuc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110860);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.xuc == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      if (this.xuc != null) {
        paramVarArgs.e(2, this.xuc);
      }
      paramVarArgs.aM(3, this.NxA);
      paramVarArgs.aM(4, this.NxB);
      AppMethodBeat.o(110860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = g.a.a.b.b.a.f(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xuc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xuc);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.NxA);
      int j = g.a.a.b.b.a.bu(4, this.NxB);
      AppMethodBeat.o(110860);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        if (this.xuc == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110860);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbj localfbj = (fbj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110860);
          return -1;
        case 1: 
          localfbj.Md5 = locala.UbS.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 2: 
          localfbj.xuc = locala.UbS.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 3: 
          localfbj.NxA = locala.UbS.zi();
          AppMethodBeat.o(110860);
          return 0;
        }
        localfbj.NxB = locala.UbS.zi();
        AppMethodBeat.o(110860);
        return 0;
      }
      AppMethodBeat.o(110860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbj
 * JD-Core Version:    0.7.0.1
 */