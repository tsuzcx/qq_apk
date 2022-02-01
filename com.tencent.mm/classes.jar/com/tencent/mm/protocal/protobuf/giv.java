package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class giv
  extends com.tencent.mm.bx.a
{
  public String IcC;
  public String Md5;
  public int acff;
  public int acfg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110860);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.IcC == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.g(1, this.Md5);
      }
      if (this.IcC != null) {
        paramVarArgs.g(2, this.IcC);
      }
      paramVarArgs.bS(3, this.acff);
      paramVarArgs.bS(4, this.acfg);
      AppMethodBeat.o(110860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = i.a.a.b.b.a.h(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IcC != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IcC);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.acff);
      int j = i.a.a.b.b.a.cJ(4, this.acfg);
      AppMethodBeat.o(110860);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        if (this.IcC == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        giv localgiv = (giv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110860);
          return -1;
        case 1: 
          localgiv.Md5 = locala.ajGk.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 2: 
          localgiv.IcC = locala.ajGk.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 3: 
          localgiv.acff = locala.ajGk.aar();
          AppMethodBeat.o(110860);
          return 0;
        }
        localgiv.acfg = locala.ajGk.aar();
        AppMethodBeat.o(110860);
        return 0;
      }
      AppMethodBeat.o(110860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.giv
 * JD-Core Version:    0.7.0.1
 */