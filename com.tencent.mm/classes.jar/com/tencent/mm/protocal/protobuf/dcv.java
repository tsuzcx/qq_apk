package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcv
  extends com.tencent.mm.bw.a
{
  public String DHe;
  public String FMv;
  public int FMw;
  public int dbL;
  public int yft;
  public String yvb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.yft);
      if (this.FMv != null) {
        paramVarArgs.d(2, this.FMv);
      }
      if (this.DHe != null) {
        paramVarArgs.d(3, this.DHe);
      }
      paramVarArgs.aR(4, this.dbL);
      if (this.yvb != null) {
        paramVarArgs.d(5, this.yvb);
      }
      paramVarArgs.aR(6, this.FMw);
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.yft) + 0;
      paramInt = i;
      if (this.FMv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FMv);
      }
      i = paramInt;
      if (this.DHe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DHe);
      }
      i += f.a.a.b.b.a.bx(4, this.dbL);
      paramInt = i;
      if (this.yvb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.yvb);
      }
      i = f.a.a.b.b.a.bx(6, this.FMw);
      AppMethodBeat.o(125845);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dcv localdcv = (dcv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125845);
        return -1;
      case 1: 
        localdcv.yft = locala.LVo.xF();
        AppMethodBeat.o(125845);
        return 0;
      case 2: 
        localdcv.FMv = locala.LVo.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 3: 
        localdcv.DHe = locala.LVo.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 4: 
        localdcv.dbL = locala.LVo.xF();
        AppMethodBeat.o(125845);
        return 0;
      case 5: 
        localdcv.yvb = locala.LVo.readString();
        AppMethodBeat.o(125845);
        return 0;
      }
      localdcv.FMw = locala.LVo.xF();
      AppMethodBeat.o(125845);
      return 0;
    }
    AppMethodBeat.o(125845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcv
 * JD-Core Version:    0.7.0.1
 */