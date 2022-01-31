package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgc
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String jKG;
  public int lGw;
  public String wNM;
  public int wRe;
  public String wvs;
  public int xmj;
  public String xuV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73744);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.lGw);
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.wvs != null) {
        paramVarArgs.e(3, this.wvs);
      }
      if (this.wNM != null) {
        paramVarArgs.e(4, this.wNM);
      }
      if (this.jJA != null) {
        paramVarArgs.e(5, this.jJA);
      }
      paramVarArgs.aO(6, this.xmj);
      paramVarArgs.aO(7, this.wRe);
      if (this.xuV != null) {
        paramVarArgs.e(8, this.xuV);
      }
      AppMethodBeat.o(73744);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.lGw) + 0;
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.wvs != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wvs);
      }
      paramInt = i;
      if (this.wNM != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wNM);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJA);
      }
      i = i + e.a.a.b.b.a.bl(6, this.xmj) + e.a.a.b.b.a.bl(7, this.wRe);
      paramInt = i;
      if (this.xuV != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xuV);
      }
      AppMethodBeat.o(73744);
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
      AppMethodBeat.o(73744);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bgc localbgc = (bgc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(73744);
        return -1;
      case 1: 
        localbgc.lGw = locala.CLY.sl();
        AppMethodBeat.o(73744);
        return 0;
      case 2: 
        localbgc.jKG = locala.CLY.readString();
        AppMethodBeat.o(73744);
        return 0;
      case 3: 
        localbgc.wvs = locala.CLY.readString();
        AppMethodBeat.o(73744);
        return 0;
      case 4: 
        localbgc.wNM = locala.CLY.readString();
        AppMethodBeat.o(73744);
        return 0;
      case 5: 
        localbgc.jJA = locala.CLY.readString();
        AppMethodBeat.o(73744);
        return 0;
      case 6: 
        localbgc.xmj = locala.CLY.sl();
        AppMethodBeat.o(73744);
        return 0;
      case 7: 
        localbgc.wRe = locala.CLY.sl();
        AppMethodBeat.o(73744);
        return 0;
      }
      localbgc.xuV = locala.CLY.readString();
      AppMethodBeat.o(73744);
      return 0;
    }
    AppMethodBeat.o(73744);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgc
 * JD-Core Version:    0.7.0.1
 */