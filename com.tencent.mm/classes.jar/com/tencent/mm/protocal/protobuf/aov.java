package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aov
  extends com.tencent.mm.bx.a
{
  public int ZvX;
  public int ZvY;
  public int ZvZ;
  public String Zwa;
  public int Zwb;
  public String Zwc;
  public int Zwd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259601);
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
      paramVarArgs.bS(7, this.Zwd);
      AppMethodBeat.o(259601);
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
      i = i.a.a.b.b.a.cJ(7, this.Zwd);
      AppMethodBeat.o(259601);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259601);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aov localaov = (aov)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259601);
        return -1;
      case 1: 
        localaov.ZvX = locala.ajGk.aar();
        AppMethodBeat.o(259601);
        return 0;
      case 2: 
        localaov.ZvY = locala.ajGk.aar();
        AppMethodBeat.o(259601);
        return 0;
      case 3: 
        localaov.ZvZ = locala.ajGk.aar();
        AppMethodBeat.o(259601);
        return 0;
      case 4: 
        localaov.Zwa = locala.ajGk.readString();
        AppMethodBeat.o(259601);
        return 0;
      case 5: 
        localaov.Zwb = locala.ajGk.aar();
        AppMethodBeat.o(259601);
        return 0;
      case 6: 
        localaov.Zwc = locala.ajGk.readString();
        AppMethodBeat.o(259601);
        return 0;
      }
      localaov.Zwd = locala.ajGk.aar();
      AppMethodBeat.o(259601);
      return 0;
    }
    AppMethodBeat.o(259601);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aov
 * JD-Core Version:    0.7.0.1
 */