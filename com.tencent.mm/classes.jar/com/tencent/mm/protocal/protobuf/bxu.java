package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxu
  extends com.tencent.mm.bw.a
{
  public String DXX;
  public String Etm;
  public int Exx;
  public int Fbe;
  public String Fmx;
  public String ncR;
  public String ndW;
  public int pAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.pAs);
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.DXX != null) {
        paramVarArgs.d(3, this.DXX);
      }
      if (this.Etm != null) {
        paramVarArgs.d(4, this.Etm);
      }
      if (this.ncR != null) {
        paramVarArgs.d(5, this.ncR);
      }
      paramVarArgs.aR(6, this.Fbe);
      paramVarArgs.aR(7, this.Exx);
      if (this.Fmx != null) {
        paramVarArgs.d(8, this.Fmx);
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.pAs) + 0;
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.DXX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DXX);
      }
      paramInt = i;
      if (this.Etm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Etm);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncR);
      }
      i = i + f.a.a.b.b.a.bx(6, this.Fbe) + f.a.a.b.b.a.bx(7, this.Exx);
      paramInt = i;
      if (this.Fmx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fmx);
      }
      AppMethodBeat.o(155445);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxu localbxu = (bxu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155445);
        return -1;
      case 1: 
        localbxu.pAs = locala.LVo.xF();
        AppMethodBeat.o(155445);
        return 0;
      case 2: 
        localbxu.ndW = locala.LVo.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 3: 
        localbxu.DXX = locala.LVo.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 4: 
        localbxu.Etm = locala.LVo.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 5: 
        localbxu.ncR = locala.LVo.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 6: 
        localbxu.Fbe = locala.LVo.xF();
        AppMethodBeat.o(155445);
        return 0;
      case 7: 
        localbxu.Exx = locala.LVo.xF();
        AppMethodBeat.o(155445);
        return 0;
      }
      localbxu.Fmx = locala.LVo.readString();
      AppMethodBeat.o(155445);
      return 0;
    }
    AppMethodBeat.o(155445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxu
 * JD-Core Version:    0.7.0.1
 */