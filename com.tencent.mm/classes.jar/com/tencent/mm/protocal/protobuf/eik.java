package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eik
  extends com.tencent.mm.bx.a
{
  public int JGZ;
  public String JHa;
  public int abnp;
  public int abnq;
  public int abnr;
  public int ytv;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32392);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abnq);
      paramVarArgs.bS(2, this.abnr);
      paramVarArgs.bS(3, this.abnp);
      paramVarArgs.bS(4, this.ytv);
      if (this.ytw != null) {
        paramVarArgs.g(5, this.ytw);
      }
      paramVarArgs.bS(6, this.JGZ);
      if (this.JHa != null) {
        paramVarArgs.g(7, this.JHa);
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abnq) + 0 + i.a.a.b.b.a.cJ(2, this.abnr) + i.a.a.b.b.a.cJ(3, this.abnp) + i.a.a.b.b.a.cJ(4, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ytw);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.JGZ);
      paramInt = i;
      if (this.JHa != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.JHa);
      }
      AppMethodBeat.o(32392);
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
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eik localeik = (eik)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32392);
        return -1;
      case 1: 
        localeik.abnq = locala.ajGk.aar();
        AppMethodBeat.o(32392);
        return 0;
      case 2: 
        localeik.abnr = locala.ajGk.aar();
        AppMethodBeat.o(32392);
        return 0;
      case 3: 
        localeik.abnp = locala.ajGk.aar();
        AppMethodBeat.o(32392);
        return 0;
      case 4: 
        localeik.ytv = locala.ajGk.aar();
        AppMethodBeat.o(32392);
        return 0;
      case 5: 
        localeik.ytw = locala.ajGk.readString();
        AppMethodBeat.o(32392);
        return 0;
      case 6: 
        localeik.JGZ = locala.ajGk.aar();
        AppMethodBeat.o(32392);
        return 0;
      }
      localeik.JHa = locala.ajGk.readString();
      AppMethodBeat.o(32392);
      return 0;
    }
    AppMethodBeat.o(32392);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eik
 * JD-Core Version:    0.7.0.1
 */