package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffi
  extends com.tencent.mm.bw.a
{
  public int NAD;
  public String NAE;
  public String xNS;
  public String xNU;
  public String xNV;
  public int xNW;
  public String xuc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152730);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NAD);
      if (this.xuc != null) {
        paramVarArgs.e(2, this.xuc);
      }
      if (this.xNS != null) {
        paramVarArgs.e(3, this.xNS);
      }
      if (this.NAE != null) {
        paramVarArgs.e(4, this.NAE);
      }
      if (this.xNU != null) {
        paramVarArgs.e(5, this.xNU);
      }
      if (this.xNV != null) {
        paramVarArgs.e(6, this.xNV);
      }
      paramVarArgs.aM(7, this.xNW);
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NAD) + 0;
      paramInt = i;
      if (this.xuc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xuc);
      }
      i = paramInt;
      if (this.xNS != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNS);
      }
      paramInt = i;
      if (this.NAE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NAE);
      }
      i = paramInt;
      if (this.xNU != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xNU);
      }
      paramInt = i;
      if (this.xNV != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xNV);
      }
      i = g.a.a.b.b.a.bu(7, this.xNW);
      AppMethodBeat.o(152730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ffi localffi = (ffi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152730);
        return -1;
      case 1: 
        localffi.NAD = locala.UbS.zi();
        AppMethodBeat.o(152730);
        return 0;
      case 2: 
        localffi.xuc = locala.UbS.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 3: 
        localffi.xNS = locala.UbS.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 4: 
        localffi.NAE = locala.UbS.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 5: 
        localffi.xNU = locala.UbS.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 6: 
        localffi.xNV = locala.UbS.readString();
        AppMethodBeat.o(152730);
        return 0;
      }
      localffi.xNW = locala.UbS.zi();
      AppMethodBeat.o(152730);
      return 0;
    }
    AppMethodBeat.o(152730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffi
 * JD-Core Version:    0.7.0.1
 */