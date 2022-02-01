package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dua
  extends com.tencent.mm.bw.a
{
  public String DMW;
  public boolean GbR;
  public String GbS;
  public int GbT;
  public int GbU;
  public int GbV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147805);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.GbR);
      if (this.DMW != null) {
        paramVarArgs.d(2, this.DMW);
      }
      if (this.GbS != null) {
        paramVarArgs.d(3, this.GbS);
      }
      paramVarArgs.aR(4, this.GbT);
      paramVarArgs.aR(5, this.GbU);
      paramVarArgs.aR(6, this.GbV);
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0;
      paramInt = i;
      if (this.DMW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DMW);
      }
      i = paramInt;
      if (this.GbS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GbS);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.GbT);
      int j = f.a.a.b.b.a.bx(5, this.GbU);
      int k = f.a.a.b.b.a.bx(6, this.GbV);
      AppMethodBeat.o(147805);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dua localdua = (dua)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147805);
        return -1;
      case 1: 
        localdua.GbR = locala.LVo.fZX();
        AppMethodBeat.o(147805);
        return 0;
      case 2: 
        localdua.DMW = locala.LVo.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 3: 
        localdua.GbS = locala.LVo.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 4: 
        localdua.GbT = locala.LVo.xF();
        AppMethodBeat.o(147805);
        return 0;
      case 5: 
        localdua.GbU = locala.LVo.xF();
        AppMethodBeat.o(147805);
        return 0;
      }
      localdua.GbV = locala.LVo.xF();
      AppMethodBeat.o(147805);
      return 0;
    }
    AppMethodBeat.o(147805);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dua
 * JD-Core Version:    0.7.0.1
 */