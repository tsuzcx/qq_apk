package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fhv
  extends com.tencent.mm.bx.a
{
  public int Zvi;
  public int abID;
  public int abIE;
  public int abIF;
  public int abIG;
  public int abIH;
  public int abII;
  public String mut;
  public int vhI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32457);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhI);
      paramVarArgs.bS(2, this.Zvi);
      paramVarArgs.bS(3, this.abID);
      paramVarArgs.bS(4, this.abIE);
      paramVarArgs.bS(5, this.abIF);
      paramVarArgs.bS(6, this.abIG);
      paramVarArgs.bS(7, this.abIH);
      paramVarArgs.bS(8, this.abII);
      if (this.mut != null) {
        paramVarArgs.g(9, this.mut);
      }
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vhI) + 0 + i.a.a.b.b.a.cJ(2, this.Zvi) + i.a.a.b.b.a.cJ(3, this.abID) + i.a.a.b.b.a.cJ(4, this.abIE) + i.a.a.b.b.a.cJ(5, this.abIF) + i.a.a.b.b.a.cJ(6, this.abIG) + i.a.a.b.b.a.cJ(7, this.abIH) + i.a.a.b.b.a.cJ(8, this.abII);
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.mut);
      }
      AppMethodBeat.o(32457);
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
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fhv localfhv = (fhv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32457);
        return -1;
      case 1: 
        localfhv.vhI = locala.ajGk.aar();
        AppMethodBeat.o(32457);
        return 0;
      case 2: 
        localfhv.Zvi = locala.ajGk.aar();
        AppMethodBeat.o(32457);
        return 0;
      case 3: 
        localfhv.abID = locala.ajGk.aar();
        AppMethodBeat.o(32457);
        return 0;
      case 4: 
        localfhv.abIE = locala.ajGk.aar();
        AppMethodBeat.o(32457);
        return 0;
      case 5: 
        localfhv.abIF = locala.ajGk.aar();
        AppMethodBeat.o(32457);
        return 0;
      case 6: 
        localfhv.abIG = locala.ajGk.aar();
        AppMethodBeat.o(32457);
        return 0;
      case 7: 
        localfhv.abIH = locala.ajGk.aar();
        AppMethodBeat.o(32457);
        return 0;
      case 8: 
        localfhv.abII = locala.ajGk.aar();
        AppMethodBeat.o(32457);
        return 0;
      }
      localfhv.mut = locala.ajGk.readString();
      AppMethodBeat.o(32457);
      return 0;
    }
    AppMethodBeat.o(32457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhv
 * JD-Core Version:    0.7.0.1
 */