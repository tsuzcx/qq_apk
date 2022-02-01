package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hz
  extends com.tencent.mm.bx.a
{
  public int VSw;
  public boolean YJG;
  public String YJH;
  public String hMA;
  public String hMz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19404);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.YJG);
      paramVarArgs.bS(2, this.VSw);
      if (this.hMz != null) {
        paramVarArgs.g(3, this.hMz);
      }
      if (this.hMA != null) {
        paramVarArgs.g(4, this.hMA);
      }
      if (this.YJH != null) {
        paramVarArgs.g(5, this.YJH);
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0 + i.a.a.b.b.a.cJ(2, this.VSw);
      paramInt = i;
      if (this.hMz != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hMz);
      }
      i = paramInt;
      if (this.hMA != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.hMA);
      }
      paramInt = i;
      if (this.YJH != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YJH);
      }
      AppMethodBeat.o(19404);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      hz localhz = (hz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19404);
        return -1;
      case 1: 
        localhz.YJG = locala.ajGk.aai();
        AppMethodBeat.o(19404);
        return 0;
      case 2: 
        localhz.VSw = locala.ajGk.aar();
        AppMethodBeat.o(19404);
        return 0;
      case 3: 
        localhz.hMz = locala.ajGk.readString();
        AppMethodBeat.o(19404);
        return 0;
      case 4: 
        localhz.hMA = locala.ajGk.readString();
        AppMethodBeat.o(19404);
        return 0;
      }
      localhz.YJH = locala.ajGk.readString();
      AppMethodBeat.o(19404);
      return 0;
    }
    AppMethodBeat.o(19404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hz
 * JD-Core Version:    0.7.0.1
 */