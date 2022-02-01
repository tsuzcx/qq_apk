package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecp
  extends com.tencent.mm.bx.a
{
  public int abid;
  public String abie;
  public String nUu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124538);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abid);
      if (this.abie != null) {
        paramVarArgs.g(2, this.abie);
      }
      if (this.nUu != null) {
        paramVarArgs.g(3, this.nUu);
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abid) + 0;
      paramInt = i;
      if (this.abie != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abie);
      }
      i = paramInt;
      if (this.nUu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUu);
      }
      AppMethodBeat.o(124538);
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
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ecp localecp = (ecp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124538);
        return -1;
      case 1: 
        localecp.abid = locala.ajGk.aar();
        AppMethodBeat.o(124538);
        return 0;
      case 2: 
        localecp.abie = locala.ajGk.readString();
        AppMethodBeat.o(124538);
        return 0;
      }
      localecp.nUu = locala.ajGk.readString();
      AppMethodBeat.o(124538);
      return 0;
    }
    AppMethodBeat.o(124538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecp
 * JD-Core Version:    0.7.0.1
 */