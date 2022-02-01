package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dki
  extends com.tencent.mm.bx.a
{
  public String CJL;
  public String DRc;
  public int DRd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DRd);
      if (this.CJL != null) {
        paramVarArgs.d(2, this.CJL);
      }
      if (this.DRc != null) {
        paramVarArgs.d(3, this.DRc);
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DRd) + 0;
      paramInt = i;
      if (this.CJL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CJL);
      }
      i = paramInt;
      if (this.DRc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DRc);
      }
      AppMethodBeat.o(176156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dki localdki = (dki)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(176156);
        return -1;
      case 1: 
        localdki.DRd = locala.KhF.xS();
        AppMethodBeat.o(176156);
        return 0;
      case 2: 
        localdki.CJL = locala.KhF.readString();
        AppMethodBeat.o(176156);
        return 0;
      }
      localdki.DRc = locala.KhF.readString();
      AppMethodBeat.o(176156);
      return 0;
    }
    AppMethodBeat.o(176156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dki
 * JD-Core Version:    0.7.0.1
 */