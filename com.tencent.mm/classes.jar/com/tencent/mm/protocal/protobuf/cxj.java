package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxj
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String ntu;
  public int nuk;
  public int xLK;
  public String xlH;
  public com.tencent.mm.bv.b yeB;
  public boolean yeS;
  public boolean yeT;
  public boolean yeU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28746);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(28746);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(28746);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(28746);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.nuk);
      if (this.xlH != null) {
        paramVarArgs.e(2, this.xlH);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.ntu != null) {
        paramVarArgs.e(4, this.ntu);
      }
      paramVarArgs.aO(5, this.xLK);
      if (this.yeB != null) {
        paramVarArgs.c(6, this.yeB);
      }
      paramVarArgs.aS(7, this.yeS);
      paramVarArgs.aS(8, this.yeT);
      paramVarArgs.aS(9, this.yeU);
      AppMethodBeat.o(28746);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nuk) + 0;
      paramInt = i;
      if (this.xlH != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xlH);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntu);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xLK);
      paramInt = i;
      if (this.yeB != null) {
        paramInt = i + e.a.a.b.b.a.b(6, this.yeB);
      }
      i = e.a.a.b.b.a.eW(7);
      int j = e.a.a.b.b.a.eW(8);
      int k = e.a.a.b.b.a.eW(9);
      AppMethodBeat.o(28746);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xlH == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(28746);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(28746);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(28746);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28746);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cxj localcxj = (cxj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28746);
        return -1;
      case 1: 
        localcxj.nuk = locala.CLY.sl();
        AppMethodBeat.o(28746);
        return 0;
      case 2: 
        localcxj.xlH = locala.CLY.readString();
        AppMethodBeat.o(28746);
        return 0;
      case 3: 
        localcxj.Title = locala.CLY.readString();
        AppMethodBeat.o(28746);
        return 0;
      case 4: 
        localcxj.ntu = locala.CLY.readString();
        AppMethodBeat.o(28746);
        return 0;
      case 5: 
        localcxj.xLK = locala.CLY.sl();
        AppMethodBeat.o(28746);
        return 0;
      case 6: 
        localcxj.yeB = locala.CLY.eqS();
        AppMethodBeat.o(28746);
        return 0;
      case 7: 
        localcxj.yeS = locala.CLY.emu();
        AppMethodBeat.o(28746);
        return 0;
      case 8: 
        localcxj.yeT = locala.CLY.emu();
        AppMethodBeat.o(28746);
        return 0;
      }
      localcxj.yeU = locala.CLY.emu();
      AppMethodBeat.o(28746);
      return 0;
    }
    AppMethodBeat.o(28746);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxj
 * JD-Core Version:    0.7.0.1
 */