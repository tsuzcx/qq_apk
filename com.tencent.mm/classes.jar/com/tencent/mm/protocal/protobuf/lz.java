package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lz
  extends com.tencent.mm.bx.a
{
  public String CIA;
  public int CIw;
  public int CIx;
  public int CIy;
  public String CIz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CIw);
      paramVarArgs.aR(2, this.CIx);
      paramVarArgs.aR(3, this.CIy);
      if (this.CIz != null) {
        paramVarArgs.d(4, this.CIz);
      }
      if (this.CIA != null) {
        paramVarArgs.d(5, this.CIA);
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CIw) + 0 + f.a.a.b.b.a.bA(2, this.CIx) + f.a.a.b.b.a.bA(3, this.CIy);
      paramInt = i;
      if (this.CIz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CIz);
      }
      i = paramInt;
      if (this.CIA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CIA);
      }
      AppMethodBeat.o(124410);
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
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      lz locallz = (lz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124410);
        return -1;
      case 1: 
        locallz.CIw = locala.KhF.xS();
        AppMethodBeat.o(124410);
        return 0;
      case 2: 
        locallz.CIx = locala.KhF.xS();
        AppMethodBeat.o(124410);
        return 0;
      case 3: 
        locallz.CIy = locala.KhF.xS();
        AppMethodBeat.o(124410);
        return 0;
      case 4: 
        locallz.CIz = locala.KhF.readString();
        AppMethodBeat.o(124410);
        return 0;
      }
      locallz.CIA = locala.KhF.readString();
      AppMethodBeat.o(124410);
      return 0;
    }
    AppMethodBeat.o(124410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lz
 * JD-Core Version:    0.7.0.1
 */