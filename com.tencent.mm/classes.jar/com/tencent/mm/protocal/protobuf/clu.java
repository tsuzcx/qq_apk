package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clu
  extends com.tencent.mm.bw.a
{
  public String MaZ;
  public long Mrf;
  public long Mrg;
  public int Mrh;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117877);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Scene);
      if (this.MaZ != null) {
        paramVarArgs.e(2, this.MaZ);
      }
      paramVarArgs.bb(3, this.Mrg);
      paramVarArgs.bb(4, this.Mrf);
      paramVarArgs.aM(5, this.Mrh);
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Scene) + 0;
      paramInt = i;
      if (this.MaZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MaZ);
      }
      i = g.a.a.b.b.a.r(3, this.Mrg);
      int j = g.a.a.b.b.a.r(4, this.Mrf);
      int k = g.a.a.b.b.a.bu(5, this.Mrh);
      AppMethodBeat.o(117877);
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
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      clu localclu = (clu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117877);
        return -1;
      case 1: 
        localclu.Scene = locala.UbS.zi();
        AppMethodBeat.o(117877);
        return 0;
      case 2: 
        localclu.MaZ = locala.UbS.readString();
        AppMethodBeat.o(117877);
        return 0;
      case 3: 
        localclu.Mrg = locala.UbS.zl();
        AppMethodBeat.o(117877);
        return 0;
      case 4: 
        localclu.Mrf = locala.UbS.zl();
        AppMethodBeat.o(117877);
        return 0;
      }
      localclu.Mrh = locala.UbS.zi();
      AppMethodBeat.o(117877);
      return 0;
    }
    AppMethodBeat.o(117877);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clu
 * JD-Core Version:    0.7.0.1
 */