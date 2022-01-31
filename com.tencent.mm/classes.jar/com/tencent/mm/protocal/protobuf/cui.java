package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cui
  extends com.tencent.mm.bv.a
{
  public boolean yda;
  public String ydb;
  public String ydc;
  public int ydd;
  public int yde;
  public int ydf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102416);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.yda);
      if (this.ydb != null) {
        paramVarArgs.e(2, this.ydb);
      }
      if (this.ydc != null) {
        paramVarArgs.e(3, this.ydc);
      }
      paramVarArgs.aO(4, this.ydd);
      paramVarArgs.aO(5, this.yde);
      paramVarArgs.aO(6, this.ydf);
      AppMethodBeat.o(102416);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0;
      paramInt = i;
      if (this.ydb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ydb);
      }
      i = paramInt;
      if (this.ydc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ydc);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.ydd);
      int j = e.a.a.b.b.a.bl(5, this.yde);
      int k = e.a.a.b.b.a.bl(6, this.ydf);
      AppMethodBeat.o(102416);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(102416);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cui localcui = (cui)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102416);
        return -1;
      case 1: 
        localcui.yda = locala.CLY.emu();
        AppMethodBeat.o(102416);
        return 0;
      case 2: 
        localcui.ydb = locala.CLY.readString();
        AppMethodBeat.o(102416);
        return 0;
      case 3: 
        localcui.ydc = locala.CLY.readString();
        AppMethodBeat.o(102416);
        return 0;
      case 4: 
        localcui.ydd = locala.CLY.sl();
        AppMethodBeat.o(102416);
        return 0;
      case 5: 
        localcui.yde = locala.CLY.sl();
        AppMethodBeat.o(102416);
        return 0;
      }
      localcui.ydf = locala.CLY.sl();
      AppMethodBeat.o(102416);
      return 0;
    }
    AppMethodBeat.o(102416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cui
 * JD-Core Version:    0.7.0.1
 */