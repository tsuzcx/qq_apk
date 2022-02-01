package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boi
  extends com.tencent.mm.bx.a
{
  public String FMk;
  public String GIU;
  public long GIV;
  public String GIW;
  public String GIX;
  public String GIY;
  public int state;
  public String title;
  public String xSd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FMk != null) {
        paramVarArgs.d(1, this.FMk);
      }
      paramVarArgs.aS(2, this.state);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.GIU != null) {
        paramVarArgs.d(4, this.GIU);
      }
      paramVarArgs.aY(5, this.GIV);
      if (this.GIW != null) {
        paramVarArgs.d(6, this.GIW);
      }
      if (this.xSd != null) {
        paramVarArgs.d(7, this.xSd);
      }
      if (this.GIX != null) {
        paramVarArgs.d(8, this.GIX);
      }
      if (this.GIY != null) {
        paramVarArgs.d(9, this.GIY);
      }
      AppMethodBeat.o(72500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FMk == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.FMk) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.GIU != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GIU);
      }
      i += f.a.a.b.b.a.p(5, this.GIV);
      paramInt = i;
      if (this.GIW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GIW);
      }
      i = paramInt;
      if (this.xSd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.xSd);
      }
      paramInt = i;
      if (this.GIX != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GIX);
      }
      i = paramInt;
      if (this.GIY != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GIY);
      }
      AppMethodBeat.o(72500);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72500);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        boi localboi = (boi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72500);
          return -1;
        case 1: 
          localboi.FMk = locala.NPN.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 2: 
          localboi.state = locala.NPN.zc();
          AppMethodBeat.o(72500);
          return 0;
        case 3: 
          localboi.title = locala.NPN.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 4: 
          localboi.GIU = locala.NPN.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 5: 
          localboi.GIV = locala.NPN.zd();
          AppMethodBeat.o(72500);
          return 0;
        case 6: 
          localboi.GIW = locala.NPN.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 7: 
          localboi.xSd = locala.NPN.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 8: 
          localboi.GIX = locala.NPN.readString();
          AppMethodBeat.o(72500);
          return 0;
        }
        localboi.GIY = locala.NPN.readString();
        AppMethodBeat.o(72500);
        return 0;
      }
      AppMethodBeat.o(72500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boi
 * JD-Core Version:    0.7.0.1
 */