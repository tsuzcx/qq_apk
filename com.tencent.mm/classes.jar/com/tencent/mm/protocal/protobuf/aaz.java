package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aaz
  extends com.tencent.mm.bv.a
{
  public String wRA;
  public int wRB;
  public int wRC;
  public String wRD;
  public String wRE;
  public int wRl;
  public String wRm;
  public String wRn;
  public String wRz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28402);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wRl);
      if (this.wRm != null) {
        paramVarArgs.e(2, this.wRm);
      }
      if (this.wRz != null) {
        paramVarArgs.e(3, this.wRz);
      }
      if (this.wRA != null) {
        paramVarArgs.e(4, this.wRA);
      }
      paramVarArgs.aO(5, this.wRB);
      paramVarArgs.aO(6, this.wRC);
      if (this.wRD != null) {
        paramVarArgs.e(7, this.wRD);
      }
      if (this.wRn != null) {
        paramVarArgs.e(8, this.wRn);
      }
      if (this.wRE != null) {
        paramVarArgs.e(9, this.wRE);
      }
      AppMethodBeat.o(28402);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wRl) + 0;
      paramInt = i;
      if (this.wRm != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wRm);
      }
      i = paramInt;
      if (this.wRz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wRz);
      }
      paramInt = i;
      if (this.wRA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wRA);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wRB) + e.a.a.b.b.a.bl(6, this.wRC);
      paramInt = i;
      if (this.wRD != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wRD);
      }
      i = paramInt;
      if (this.wRn != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wRn);
      }
      paramInt = i;
      if (this.wRE != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wRE);
      }
      AppMethodBeat.o(28402);
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
      AppMethodBeat.o(28402);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aaz localaaz = (aaz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28402);
        return -1;
      case 1: 
        localaaz.wRl = locala.CLY.sl();
        AppMethodBeat.o(28402);
        return 0;
      case 2: 
        localaaz.wRm = locala.CLY.readString();
        AppMethodBeat.o(28402);
        return 0;
      case 3: 
        localaaz.wRz = locala.CLY.readString();
        AppMethodBeat.o(28402);
        return 0;
      case 4: 
        localaaz.wRA = locala.CLY.readString();
        AppMethodBeat.o(28402);
        return 0;
      case 5: 
        localaaz.wRB = locala.CLY.sl();
        AppMethodBeat.o(28402);
        return 0;
      case 6: 
        localaaz.wRC = locala.CLY.sl();
        AppMethodBeat.o(28402);
        return 0;
      case 7: 
        localaaz.wRD = locala.CLY.readString();
        AppMethodBeat.o(28402);
        return 0;
      case 8: 
        localaaz.wRn = locala.CLY.readString();
        AppMethodBeat.o(28402);
        return 0;
      }
      localaaz.wRE = locala.CLY.readString();
      AppMethodBeat.o(28402);
      return 0;
    }
    AppMethodBeat.o(28402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaz
 * JD-Core Version:    0.7.0.1
 */