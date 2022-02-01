package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axz
  extends com.tencent.mm.bw.a
{
  public long Ghu;
  public long Ghw;
  public int LIl;
  public String LIm;
  public int LIn;
  public int UtY;
  public long refObjectId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209580);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Ghu);
      paramVarArgs.aM(2, this.LIl);
      paramVarArgs.bb(3, this.refObjectId);
      if (this.LIm != null) {
        paramVarArgs.e(4, this.LIm);
      }
      paramVarArgs.bb(5, this.Ghw);
      paramVarArgs.aM(6, this.LIn);
      paramVarArgs.aM(7, this.UtY);
      AppMethodBeat.o(209580);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Ghu) + 0 + g.a.a.b.b.a.bu(2, this.LIl) + g.a.a.b.b.a.r(3, this.refObjectId);
      paramInt = i;
      if (this.LIm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LIm);
      }
      i = g.a.a.b.b.a.r(5, this.Ghw);
      int j = g.a.a.b.b.a.bu(6, this.LIn);
      int k = g.a.a.b.b.a.bu(7, this.UtY);
      AppMethodBeat.o(209580);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209580);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      axz localaxz = (axz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209580);
        return -1;
      case 1: 
        localaxz.Ghu = locala.UbS.zl();
        AppMethodBeat.o(209580);
        return 0;
      case 2: 
        localaxz.LIl = locala.UbS.zi();
        AppMethodBeat.o(209580);
        return 0;
      case 3: 
        localaxz.refObjectId = locala.UbS.zl();
        AppMethodBeat.o(209580);
        return 0;
      case 4: 
        localaxz.LIm = locala.UbS.readString();
        AppMethodBeat.o(209580);
        return 0;
      case 5: 
        localaxz.Ghw = locala.UbS.zl();
        AppMethodBeat.o(209580);
        return 0;
      case 6: 
        localaxz.LIn = locala.UbS.zi();
        AppMethodBeat.o(209580);
        return 0;
      }
      localaxz.UtY = locala.UbS.zi();
      AppMethodBeat.o(209580);
      return 0;
    }
    AppMethodBeat.o(209580);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axz
 * JD-Core Version:    0.7.0.1
 */