package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public int iTC;
  public int iTD;
  public int iTE;
  public long iTF;
  public long iTG;
  public String iTH;
  public String iTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91323);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.iTC);
      paramVarArgs.aS(2, this.iTD);
      paramVarArgs.aS(3, this.iTE);
      paramVarArgs.aY(4, this.iTF);
      paramVarArgs.aY(5, this.iTG);
      if (this.iTH != null) {
        paramVarArgs.d(6, this.iTH);
      }
      if (this.iTI != null) {
        paramVarArgs.d(7, this.iTI);
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.iTC) + 0 + f.a.a.b.b.a.bz(2, this.iTD) + f.a.a.b.b.a.bz(3, this.iTE) + f.a.a.b.b.a.p(4, this.iTF) + f.a.a.b.b.a.p(5, this.iTG);
      paramInt = i;
      if (this.iTH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iTH);
      }
      i = paramInt;
      if (this.iTI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iTI);
      }
      AppMethodBeat.o(91323);
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
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91323);
        return -1;
      case 1: 
        locall.iTC = locala.NPN.zc();
        AppMethodBeat.o(91323);
        return 0;
      case 2: 
        locall.iTD = locala.NPN.zc();
        AppMethodBeat.o(91323);
        return 0;
      case 3: 
        locall.iTE = locala.NPN.zc();
        AppMethodBeat.o(91323);
        return 0;
      case 4: 
        locall.iTF = locala.NPN.zd();
        AppMethodBeat.o(91323);
        return 0;
      case 5: 
        locall.iTG = locala.NPN.zd();
        AppMethodBeat.o(91323);
        return 0;
      case 6: 
        locall.iTH = locala.NPN.readString();
        AppMethodBeat.o(91323);
        return 0;
      }
      locall.iTI = locala.NPN.readString();
      AppMethodBeat.o(91323);
      return 0;
    }
    AppMethodBeat.o(91323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.l
 * JD-Core Version:    0.7.0.1
 */