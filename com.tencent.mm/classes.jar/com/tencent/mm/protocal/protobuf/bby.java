package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bby
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public boolean xqZ;
  public boolean xra;
  public int xrb;
  public int xrc;
  public String xrd;
  public boolean xre;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51000);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xqZ);
      paramVarArgs.aS(2, this.xra);
      paramVarArgs.aO(3, this.xrb);
      paramVarArgs.aO(4, this.xrc);
      if (this.xrd != null) {
        paramVarArgs.e(5, this.xrd);
      }
      paramVarArgs.aS(6, this.xre);
      if (this.cwc != null) {
        paramVarArgs.e(7, this.cwc);
      }
      AppMethodBeat.o(51000);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0 + (e.a.a.b.b.a.eW(2) + 1) + e.a.a.b.b.a.bl(3, this.xrb) + e.a.a.b.b.a.bl(4, this.xrc);
      paramInt = i;
      if (this.xrd != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xrd);
      }
      i = paramInt + (e.a.a.b.b.a.eW(6) + 1);
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.cwc);
      }
      AppMethodBeat.o(51000);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51000);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bby localbby = (bby)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(51000);
        return -1;
      case 1: 
        localbby.xqZ = locala.CLY.emu();
        AppMethodBeat.o(51000);
        return 0;
      case 2: 
        localbby.xra = locala.CLY.emu();
        AppMethodBeat.o(51000);
        return 0;
      case 3: 
        localbby.xrb = locala.CLY.sl();
        AppMethodBeat.o(51000);
        return 0;
      case 4: 
        localbby.xrc = locala.CLY.sl();
        AppMethodBeat.o(51000);
        return 0;
      case 5: 
        localbby.xrd = locala.CLY.readString();
        AppMethodBeat.o(51000);
        return 0;
      case 6: 
        localbby.xre = locala.CLY.emu();
        AppMethodBeat.o(51000);
        return 0;
      }
      localbby.cwc = locala.CLY.readString();
      AppMethodBeat.o(51000);
      return 0;
    }
    AppMethodBeat.o(51000);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bby
 * JD-Core Version:    0.7.0.1
 */