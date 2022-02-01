package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mv
  extends com.tencent.mm.bx.a
{
  public int FGH;
  public int FGI;
  public int FGJ;
  public String FGK;
  public String FGL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FGH);
      paramVarArgs.aS(2, this.FGI);
      paramVarArgs.aS(3, this.FGJ);
      if (this.FGK != null) {
        paramVarArgs.d(4, this.FGK);
      }
      if (this.FGL != null) {
        paramVarArgs.d(5, this.FGL);
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FGH) + 0 + f.a.a.b.b.a.bz(2, this.FGI) + f.a.a.b.b.a.bz(3, this.FGJ);
      paramInt = i;
      if (this.FGK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FGK);
      }
      i = paramInt;
      if (this.FGL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FGL);
      }
      AppMethodBeat.o(124410);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mv localmv = (mv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124410);
        return -1;
      case 1: 
        localmv.FGH = locala.NPN.zc();
        AppMethodBeat.o(124410);
        return 0;
      case 2: 
        localmv.FGI = locala.NPN.zc();
        AppMethodBeat.o(124410);
        return 0;
      case 3: 
        localmv.FGJ = locala.NPN.zc();
        AppMethodBeat.o(124410);
        return 0;
      case 4: 
        localmv.FGK = locala.NPN.readString();
        AppMethodBeat.o(124410);
        return 0;
      }
      localmv.FGL = locala.NPN.readString();
      AppMethodBeat.o(124410);
      return 0;
    }
    AppMethodBeat.o(124410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mv
 * JD-Core Version:    0.7.0.1
 */