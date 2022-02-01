package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anj
  extends com.tencent.mm.bw.a
{
  public int GFo;
  public int GFp;
  public int GFq;
  public int GFr;
  public int GFs;
  public int GFt;
  public int pullType;
  public int scene;
  public int syE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189330);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.scene);
      paramVarArgs.aS(2, this.GFo);
      paramVarArgs.aS(3, this.pullType);
      paramVarArgs.aS(4, this.syE);
      paramVarArgs.aS(5, this.GFp);
      paramVarArgs.aS(6, this.GFq);
      paramVarArgs.aS(7, this.GFr);
      paramVarArgs.aS(8, this.GFs);
      paramVarArgs.aS(9, this.GFt);
      AppMethodBeat.o(189330);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.scene);
      int i = f.a.a.b.b.a.bz(2, this.GFo);
      int j = f.a.a.b.b.a.bz(3, this.pullType);
      int k = f.a.a.b.b.a.bz(4, this.syE);
      int m = f.a.a.b.b.a.bz(5, this.GFp);
      int n = f.a.a.b.b.a.bz(6, this.GFq);
      int i1 = f.a.a.b.b.a.bz(7, this.GFr);
      int i2 = f.a.a.b.b.a.bz(8, this.GFs);
      int i3 = f.a.a.b.b.a.bz(9, this.GFt);
      AppMethodBeat.o(189330);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189330);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      anj localanj = (anj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189330);
        return -1;
      case 1: 
        localanj.scene = locala.OmT.zc();
        AppMethodBeat.o(189330);
        return 0;
      case 2: 
        localanj.GFo = locala.OmT.zc();
        AppMethodBeat.o(189330);
        return 0;
      case 3: 
        localanj.pullType = locala.OmT.zc();
        AppMethodBeat.o(189330);
        return 0;
      case 4: 
        localanj.syE = locala.OmT.zc();
        AppMethodBeat.o(189330);
        return 0;
      case 5: 
        localanj.GFp = locala.OmT.zc();
        AppMethodBeat.o(189330);
        return 0;
      case 6: 
        localanj.GFq = locala.OmT.zc();
        AppMethodBeat.o(189330);
        return 0;
      case 7: 
        localanj.GFr = locala.OmT.zc();
        AppMethodBeat.o(189330);
        return 0;
      case 8: 
        localanj.GFs = locala.OmT.zc();
        AppMethodBeat.o(189330);
        return 0;
      }
      localanj.GFt = locala.OmT.zc();
      AppMethodBeat.o(189330);
      return 0;
    }
    AppMethodBeat.o(189330);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anj
 * JD-Core Version:    0.7.0.1
 */