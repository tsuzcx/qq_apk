package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxz
  extends com.tencent.mm.bw.a
{
  public int Fdx;
  public int Fne;
  public int Fnf;
  public int Fng;
  public int Fnh;
  public int Fni;
  public int Fnj;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fdx);
      paramVarArgs.aR(2, this.Fne);
      paramVarArgs.aR(3, this.Fnf);
      paramVarArgs.aR(4, this.Fng);
      paramVarArgs.aR(5, this.Fnh);
      paramVarArgs.aR(6, this.Fni);
      paramVarArgs.aR(7, this.Fnj);
      paramVarArgs.aR(8, this.ndI);
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Fdx);
      int i = f.a.a.b.b.a.bx(2, this.Fne);
      int j = f.a.a.b.b.a.bx(3, this.Fnf);
      int k = f.a.a.b.b.a.bx(4, this.Fng);
      int m = f.a.a.b.b.a.bx(5, this.Fnh);
      int n = f.a.a.b.b.a.bx(6, this.Fni);
      int i1 = f.a.a.b.b.a.bx(7, this.Fnj);
      int i2 = f.a.a.b.b.a.bx(8, this.ndI);
      AppMethodBeat.o(143985);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxz localbxz = (bxz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143985);
        return -1;
      case 1: 
        localbxz.Fdx = locala.LVo.xF();
        AppMethodBeat.o(143985);
        return 0;
      case 2: 
        localbxz.Fne = locala.LVo.xF();
        AppMethodBeat.o(143985);
        return 0;
      case 3: 
        localbxz.Fnf = locala.LVo.xF();
        AppMethodBeat.o(143985);
        return 0;
      case 4: 
        localbxz.Fng = locala.LVo.xF();
        AppMethodBeat.o(143985);
        return 0;
      case 5: 
        localbxz.Fnh = locala.LVo.xF();
        AppMethodBeat.o(143985);
        return 0;
      case 6: 
        localbxz.Fni = locala.LVo.xF();
        AppMethodBeat.o(143985);
        return 0;
      case 7: 
        localbxz.Fnj = locala.LVo.xF();
        AppMethodBeat.o(143985);
        return 0;
      }
      localbxz.ndI = locala.LVo.xF();
      AppMethodBeat.o(143985);
      return 0;
    }
    AppMethodBeat.o(143985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxz
 * JD-Core Version:    0.7.0.1
 */