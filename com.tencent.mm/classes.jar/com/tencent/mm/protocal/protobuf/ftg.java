package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ftg
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public String MD5;
  public int NkN;
  public int NkO;
  public String aaro;
  public boolean abRy;
  public boolean abRz = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104841);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      paramVarArgs.bS(2, this.NkO);
      paramVarArgs.bS(3, this.NkN);
      if (this.MD5 != null) {
        paramVarArgs.g(4, this.MD5);
      }
      paramVarArgs.di(5, this.abRy);
      if (this.aaro != null) {
        paramVarArgs.g(6, this.aaro);
      }
      paramVarArgs.di(7, this.abRz);
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Idd) + 0 + i.a.a.b.b.a.cJ(2, this.NkO) + i.a.a.b.b.a.cJ(3, this.NkN);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MD5);
      }
      i = paramInt + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.aaro != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaro);
      }
      i = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(104841);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ftg localftg = (ftg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104841);
        return -1;
      case 1: 
        localftg.Idd = locala.ajGk.aar();
        AppMethodBeat.o(104841);
        return 0;
      case 2: 
        localftg.NkO = locala.ajGk.aar();
        AppMethodBeat.o(104841);
        return 0;
      case 3: 
        localftg.NkN = locala.ajGk.aar();
        AppMethodBeat.o(104841);
        return 0;
      case 4: 
        localftg.MD5 = locala.ajGk.readString();
        AppMethodBeat.o(104841);
        return 0;
      case 5: 
        localftg.abRy = locala.ajGk.aai();
        AppMethodBeat.o(104841);
        return 0;
      case 6: 
        localftg.aaro = locala.ajGk.readString();
        AppMethodBeat.o(104841);
        return 0;
      }
      localftg.abRz = locala.ajGk.aai();
      AppMethodBeat.o(104841);
      return 0;
    }
    AppMethodBeat.o(104841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftg
 * JD-Core Version:    0.7.0.1
 */