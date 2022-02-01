package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class gfk
  extends com.tencent.mm.bx.a
{
  public String Username;
  public long accG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32515);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32515);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.accG);
      if (this.Username != null) {
        paramVarArgs.g(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.accG) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32515);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gfk localgfk = (gfk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32515);
        return -1;
      case 1: 
        localgfk.accG = locala.ajGk.aaw();
        AppMethodBeat.o(32515);
        return 0;
      }
      localgfk.Username = locala.ajGk.readString();
      AppMethodBeat.o(32515);
      return 0;
    }
    AppMethodBeat.o(32515);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfk
 * JD-Core Version:    0.7.0.1
 */