package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dst
  extends com.tencent.mm.bw.a
{
  public int GaZ;
  public int Gba;
  public int Gbb;
  public int Gbc;
  public int Gbd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115910);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.GaZ);
      paramVarArgs.aR(2, this.Gba);
      paramVarArgs.aR(3, this.Gbb);
      paramVarArgs.aR(4, this.Gbc);
      paramVarArgs.aR(5, this.Gbd);
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.GaZ);
      int i = f.a.a.b.b.a.bx(2, this.Gba);
      int j = f.a.a.b.b.a.bx(3, this.Gbb);
      int k = f.a.a.b.b.a.bx(4, this.Gbc);
      int m = f.a.a.b.b.a.bx(5, this.Gbd);
      AppMethodBeat.o(115910);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dst localdst = (dst)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115910);
        return -1;
      case 1: 
        localdst.GaZ = locala.LVo.xF();
        AppMethodBeat.o(115910);
        return 0;
      case 2: 
        localdst.Gba = locala.LVo.xF();
        AppMethodBeat.o(115910);
        return 0;
      case 3: 
        localdst.Gbb = locala.LVo.xF();
        AppMethodBeat.o(115910);
        return 0;
      case 4: 
        localdst.Gbc = locala.LVo.xF();
        AppMethodBeat.o(115910);
        return 0;
      }
      localdst.Gbd = locala.LVo.xF();
      AppMethodBeat.o(115910);
      return 0;
    }
    AppMethodBeat.o(115910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dst
 * JD-Core Version:    0.7.0.1
 */