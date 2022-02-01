package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eym
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String iAc;
  public int xNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32523);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      if (this.iAc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.xNF);
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.iAc != null) {
        paramVarArgs.e(3, this.iAc);
      }
      AppMethodBeat.o(32523);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xNF) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iAc);
      }
      AppMethodBeat.o(32523);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      if (this.iAc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32523);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eym localeym = (eym)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32523);
        return -1;
      case 1: 
        localeym.xNF = locala.UbS.zi();
        AppMethodBeat.o(32523);
        return 0;
      case 2: 
        localeym.Title = locala.UbS.readString();
        AppMethodBeat.o(32523);
        return 0;
      }
      localeym.iAc = locala.UbS.readString();
      AppMethodBeat.o(32523);
      return 0;
    }
    AppMethodBeat.o(32523);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eym
 * JD-Core Version:    0.7.0.1
 */