package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lx
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int DPJ;
  public int Eaj;
  public int Eak;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124398);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Eaj);
      paramVarArgs.aR(2, this.CreateTime);
      paramVarArgs.aR(3, this.DPJ);
      paramVarArgs.aR(4, this.ndI);
      paramVarArgs.aR(5, this.Eak);
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Eaj);
      int i = f.a.a.b.b.a.bx(2, this.CreateTime);
      int j = f.a.a.b.b.a.bx(3, this.DPJ);
      int k = f.a.a.b.b.a.bx(4, this.ndI);
      int m = f.a.a.b.b.a.bx(5, this.Eak);
      AppMethodBeat.o(124398);
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
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      lx locallx = (lx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124398);
        return -1;
      case 1: 
        locallx.Eaj = locala.LVo.xF();
        AppMethodBeat.o(124398);
        return 0;
      case 2: 
        locallx.CreateTime = locala.LVo.xF();
        AppMethodBeat.o(124398);
        return 0;
      case 3: 
        locallx.DPJ = locala.LVo.xF();
        AppMethodBeat.o(124398);
        return 0;
      case 4: 
        locallx.ndI = locala.LVo.xF();
        AppMethodBeat.o(124398);
        return 0;
      }
      locallx.Eak = locala.LVo.xF();
      AppMethodBeat.o(124398);
      return 0;
    }
    AppMethodBeat.o(124398);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lx
 * JD-Core Version:    0.7.0.1
 */