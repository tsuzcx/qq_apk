package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gns
  extends com.tencent.mm.bx.a
{
  public String IMs;
  public String IMu;
  public String IMv;
  public int IMw;
  public String IcC;
  public int aciH;
  public String aciI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152730);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aciH);
      if (this.IcC != null) {
        paramVarArgs.g(2, this.IcC);
      }
      if (this.IMs != null) {
        paramVarArgs.g(3, this.IMs);
      }
      if (this.aciI != null) {
        paramVarArgs.g(4, this.aciI);
      }
      if (this.IMu != null) {
        paramVarArgs.g(5, this.IMu);
      }
      if (this.IMv != null) {
        paramVarArgs.g(6, this.IMv);
      }
      paramVarArgs.bS(7, this.IMw);
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aciH) + 0;
      paramInt = i;
      if (this.IcC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IcC);
      }
      i = paramInt;
      if (this.IMs != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMs);
      }
      paramInt = i;
      if (this.aciI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aciI);
      }
      i = paramInt;
      if (this.IMu != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IMu);
      }
      paramInt = i;
      if (this.IMv != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IMv);
      }
      i = i.a.a.b.b.a.cJ(7, this.IMw);
      AppMethodBeat.o(152730);
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
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gns localgns = (gns)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152730);
        return -1;
      case 1: 
        localgns.aciH = locala.ajGk.aar();
        AppMethodBeat.o(152730);
        return 0;
      case 2: 
        localgns.IcC = locala.ajGk.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 3: 
        localgns.IMs = locala.ajGk.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 4: 
        localgns.aciI = locala.ajGk.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 5: 
        localgns.IMu = locala.ajGk.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 6: 
        localgns.IMv = locala.ajGk.readString();
        AppMethodBeat.o(152730);
        return 0;
      }
      localgns.IMw = locala.ajGk.aar();
      AppMethodBeat.o(152730);
      return 0;
    }
    AppMethodBeat.o(152730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gns
 * JD-Core Version:    0.7.0.1
 */