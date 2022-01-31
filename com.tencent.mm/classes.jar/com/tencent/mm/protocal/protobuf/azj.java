package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azj
  extends com.tencent.mm.bv.a
{
  public int wld;
  public String xhl;
  public String xoF;
  public boolean xoG;
  public String xoH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96272);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wld);
      if (this.xoF != null) {
        paramVarArgs.e(2, this.xoF);
      }
      paramVarArgs.aS(3, this.xoG);
      if (this.xoH != null) {
        paramVarArgs.e(4, this.xoH);
      }
      if (this.xhl != null) {
        paramVarArgs.e(5, this.xhl);
      }
      AppMethodBeat.o(96272);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wld) + 0;
      paramInt = i;
      if (this.xoF != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xoF);
      }
      i = paramInt + (e.a.a.b.b.a.eW(3) + 1);
      paramInt = i;
      if (this.xoH != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xoH);
      }
      i = paramInt;
      if (this.xhl != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xhl);
      }
      AppMethodBeat.o(96272);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96272);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      azj localazj = (azj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96272);
        return -1;
      case 1: 
        localazj.wld = locala.CLY.sl();
        AppMethodBeat.o(96272);
        return 0;
      case 2: 
        localazj.xoF = locala.CLY.readString();
        AppMethodBeat.o(96272);
        return 0;
      case 3: 
        localazj.xoG = locala.CLY.emu();
        AppMethodBeat.o(96272);
        return 0;
      case 4: 
        localazj.xoH = locala.CLY.readString();
        AppMethodBeat.o(96272);
        return 0;
      }
      localazj.xhl = locala.CLY.readString();
      AppMethodBeat.o(96272);
      return 0;
    }
    AppMethodBeat.o(96272);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azj
 * JD-Core Version:    0.7.0.1
 */