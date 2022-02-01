package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoz
  extends com.tencent.mm.bx.a
{
  public int ZvX;
  public int ZvY;
  public int ZvZ;
  public String Zwa;
  public int Zwb;
  public String Zwc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122488);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZvX);
      paramVarArgs.bS(2, this.ZvY);
      paramVarArgs.bS(3, this.ZvZ);
      if (this.Zwa != null) {
        paramVarArgs.g(4, this.Zwa);
      }
      paramVarArgs.bS(5, this.Zwb);
      if (this.Zwc != null) {
        paramVarArgs.g(6, this.Zwc);
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZvX) + 0 + i.a.a.b.b.a.cJ(2, this.ZvY) + i.a.a.b.b.a.cJ(3, this.ZvZ);
      paramInt = i;
      if (this.Zwa != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zwa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Zwb);
      paramInt = i;
      if (this.Zwc != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zwc);
      }
      AppMethodBeat.o(122488);
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
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aoz localaoz = (aoz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122488);
        return -1;
      case 1: 
        localaoz.ZvX = locala.ajGk.aar();
        AppMethodBeat.o(122488);
        return 0;
      case 2: 
        localaoz.ZvY = locala.ajGk.aar();
        AppMethodBeat.o(122488);
        return 0;
      case 3: 
        localaoz.ZvZ = locala.ajGk.aar();
        AppMethodBeat.o(122488);
        return 0;
      case 4: 
        localaoz.Zwa = locala.ajGk.readString();
        AppMethodBeat.o(122488);
        return 0;
      case 5: 
        localaoz.Zwb = locala.ajGk.aar();
        AppMethodBeat.o(122488);
        return 0;
      }
      localaoz.Zwc = locala.ajGk.readString();
      AppMethodBeat.o(122488);
      return 0;
    }
    AppMethodBeat.o(122488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoz
 * JD-Core Version:    0.7.0.1
 */