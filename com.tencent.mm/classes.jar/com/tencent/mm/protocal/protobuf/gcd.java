package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gcd
  extends com.tencent.mm.bx.a
{
  public b Zsu;
  public int bUl;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147789);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.bUl);
      if (this.uuid != null) {
        paramVarArgs.g(2, this.uuid);
      }
      if (this.Zsu != null) {
        paramVarArgs.d(3, this.Zsu);
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.bUl) + 0;
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.uuid);
      }
      i = paramInt;
      if (this.Zsu != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.Zsu);
      }
      AppMethodBeat.o(147789);
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
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gcd localgcd = (gcd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147789);
        return -1;
      case 1: 
        localgcd.bUl = locala.ajGk.aar();
        AppMethodBeat.o(147789);
        return 0;
      case 2: 
        localgcd.uuid = locala.ajGk.readString();
        AppMethodBeat.o(147789);
        return 0;
      }
      localgcd.Zsu = locala.ajGk.kFX();
      AppMethodBeat.o(147789);
      return 0;
    }
    AppMethodBeat.o(147789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcd
 * JD-Core Version:    0.7.0.1
 */