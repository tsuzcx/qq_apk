package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gbe
  extends com.tencent.mm.bx.a
{
  public int Uzx;
  public int Uzy;
  public String hPy;
  public String userName;
  public int vll;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115904);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vll);
      paramVarArgs.bS(2, this.Uzy);
      paramVarArgs.bS(3, this.Uzx);
      if (this.userName != null) {
        paramVarArgs.g(4, this.userName);
      }
      if (this.hPy != null) {
        paramVarArgs.g(5, this.hPy);
      }
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vll) + 0 + i.a.a.b.b.a.cJ(2, this.Uzy) + i.a.a.b.b.a.cJ(3, this.Uzx);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.userName);
      }
      i = paramInt;
      if (this.hPy != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hPy);
      }
      AppMethodBeat.o(115904);
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
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gbe localgbe = (gbe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115904);
        return -1;
      case 1: 
        localgbe.vll = locala.ajGk.aar();
        AppMethodBeat.o(115904);
        return 0;
      case 2: 
        localgbe.Uzy = locala.ajGk.aar();
        AppMethodBeat.o(115904);
        return 0;
      case 3: 
        localgbe.Uzx = locala.ajGk.aar();
        AppMethodBeat.o(115904);
        return 0;
      case 4: 
        localgbe.userName = locala.ajGk.readString();
        AppMethodBeat.o(115904);
        return 0;
      }
      localgbe.hPy = locala.ajGk.readString();
      AppMethodBeat.o(115904);
      return 0;
    }
    AppMethodBeat.o(115904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbe
 * JD-Core Version:    0.7.0.1
 */