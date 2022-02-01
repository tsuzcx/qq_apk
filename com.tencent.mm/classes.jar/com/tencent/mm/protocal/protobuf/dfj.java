package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dfj
  extends com.tencent.mm.bx.a
{
  public String key;
  public String onf;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258249);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(258249);
        throw paramVarArgs;
      }
      if (this.onf == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(258249);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.type);
      if (this.key != null) {
        paramVarArgs.g(2, this.key);
      }
      if (this.onf != null) {
        paramVarArgs.g(3, this.onf);
      }
      AppMethodBeat.o(258249);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.key != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.key);
      }
      i = paramInt;
      if (this.onf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.onf);
      }
      AppMethodBeat.o(258249);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(258249);
        throw paramVarArgs;
      }
      if (this.onf == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(258249);
        throw paramVarArgs;
      }
      AppMethodBeat.o(258249);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dfj localdfj = (dfj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258249);
        return -1;
      case 1: 
        localdfj.type = locala.ajGk.aar();
        AppMethodBeat.o(258249);
        return 0;
      case 2: 
        localdfj.key = locala.ajGk.readString();
        AppMethodBeat.o(258249);
        return 0;
      }
      localdfj.onf = locala.ajGk.readString();
      AppMethodBeat.o(258249);
      return 0;
    }
    AppMethodBeat.o(258249);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfj
 * JD-Core Version:    0.7.0.1
 */