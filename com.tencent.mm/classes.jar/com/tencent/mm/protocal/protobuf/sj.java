package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sj
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int jKs;
  public String nGG;
  public String wKH;
  public String wKI;
  public String wKJ;
  public String wKK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50527);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Scene);
      paramVarArgs.aO(2, this.jKs);
      if (this.wKH != null) {
        paramVarArgs.e(3, this.wKH);
      }
      if (this.wKI != null) {
        paramVarArgs.e(4, this.wKI);
      }
      if (this.nGG != null) {
        paramVarArgs.e(5, this.nGG);
      }
      if (this.wKJ != null) {
        paramVarArgs.e(6, this.wKJ);
      }
      if (this.wKK != null) {
        paramVarArgs.e(7, this.wKK);
      }
      AppMethodBeat.o(50527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.Scene) + 0 + e.a.a.b.b.a.bl(2, this.jKs);
      paramInt = i;
      if (this.wKH != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wKH);
      }
      i = paramInt;
      if (this.wKI != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wKI);
      }
      paramInt = i;
      if (this.nGG != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.nGG);
      }
      i = paramInt;
      if (this.wKJ != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wKJ);
      }
      paramInt = i;
      if (this.wKK != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wKK);
      }
      AppMethodBeat.o(50527);
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
      AppMethodBeat.o(50527);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      sj localsj = (sj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50527);
        return -1;
      case 1: 
        localsj.Scene = locala.CLY.sl();
        AppMethodBeat.o(50527);
        return 0;
      case 2: 
        localsj.jKs = locala.CLY.sl();
        AppMethodBeat.o(50527);
        return 0;
      case 3: 
        localsj.wKH = locala.CLY.readString();
        AppMethodBeat.o(50527);
        return 0;
      case 4: 
        localsj.wKI = locala.CLY.readString();
        AppMethodBeat.o(50527);
        return 0;
      case 5: 
        localsj.nGG = locala.CLY.readString();
        AppMethodBeat.o(50527);
        return 0;
      case 6: 
        localsj.wKJ = locala.CLY.readString();
        AppMethodBeat.o(50527);
        return 0;
      }
      localsj.wKK = locala.CLY.readString();
      AppMethodBeat.o(50527);
      return 0;
    }
    AppMethodBeat.o(50527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sj
 * JD-Core Version:    0.7.0.1
 */