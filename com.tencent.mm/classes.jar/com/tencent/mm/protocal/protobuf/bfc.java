package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfc
  extends com.tencent.mm.bx.a
{
  public int Cta;
  public String tfG;
  public String tfH;
  public String tfI;
  public String tfJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72497);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Cta);
      if (this.tfG != null) {
        paramVarArgs.d(2, this.tfG);
      }
      if (this.tfH != null) {
        paramVarArgs.d(3, this.tfH);
      }
      if (this.tfI != null) {
        paramVarArgs.d(4, this.tfI);
      }
      if (this.tfJ != null) {
        paramVarArgs.d(5, this.tfJ);
      }
      AppMethodBeat.o(72497);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Cta) + 0;
      paramInt = i;
      if (this.tfG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tfG);
      }
      i = paramInt;
      if (this.tfH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tfH);
      }
      paramInt = i;
      if (this.tfI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tfI);
      }
      i = paramInt;
      if (this.tfJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tfJ);
      }
      AppMethodBeat.o(72497);
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
      AppMethodBeat.o(72497);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bfc localbfc = (bfc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72497);
        return -1;
      case 1: 
        localbfc.Cta = locala.KhF.xS();
        AppMethodBeat.o(72497);
        return 0;
      case 2: 
        localbfc.tfG = locala.KhF.readString();
        AppMethodBeat.o(72497);
        return 0;
      case 3: 
        localbfc.tfH = locala.KhF.readString();
        AppMethodBeat.o(72497);
        return 0;
      case 4: 
        localbfc.tfI = locala.KhF.readString();
        AppMethodBeat.o(72497);
        return 0;
      }
      localbfc.tfJ = locala.KhF.readString();
      AppMethodBeat.o(72497);
      return 0;
    }
    AppMethodBeat.o(72497);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfc
 * JD-Core Version:    0.7.0.1
 */