package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkj
  extends com.tencent.mm.bw.a
{
  public int Exx;
  public String FTt;
  public String FTu;
  public int FTv;
  public int FTw;
  public int Height;
  public int Width;
  public int X;
  public int Y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.X);
      paramVarArgs.aR(2, this.Y);
      paramVarArgs.aR(3, this.Width);
      paramVarArgs.aR(4, this.Height);
      if (this.FTt != null) {
        paramVarArgs.d(5, this.FTt);
      }
      if (this.FTu != null) {
        paramVarArgs.d(6, this.FTu);
      }
      paramVarArgs.aR(7, this.FTv);
      paramVarArgs.aR(8, this.Exx);
      paramVarArgs.aR(9, this.FTw);
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.X) + 0 + f.a.a.b.b.a.bx(2, this.Y) + f.a.a.b.b.a.bx(3, this.Width) + f.a.a.b.b.a.bx(4, this.Height);
      paramInt = i;
      if (this.FTt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FTt);
      }
      i = paramInt;
      if (this.FTu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FTu);
      }
      paramInt = f.a.a.b.b.a.bx(7, this.FTv);
      int j = f.a.a.b.b.a.bx(8, this.Exx);
      int k = f.a.a.b.b.a.bx(9, this.FTw);
      AppMethodBeat.o(120960);
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
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dkj localdkj = (dkj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(120960);
        return -1;
      case 1: 
        localdkj.X = locala.LVo.xF();
        AppMethodBeat.o(120960);
        return 0;
      case 2: 
        localdkj.Y = locala.LVo.xF();
        AppMethodBeat.o(120960);
        return 0;
      case 3: 
        localdkj.Width = locala.LVo.xF();
        AppMethodBeat.o(120960);
        return 0;
      case 4: 
        localdkj.Height = locala.LVo.xF();
        AppMethodBeat.o(120960);
        return 0;
      case 5: 
        localdkj.FTt = locala.LVo.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 6: 
        localdkj.FTu = locala.LVo.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 7: 
        localdkj.FTv = locala.LVo.xF();
        AppMethodBeat.o(120960);
        return 0;
      case 8: 
        localdkj.Exx = locala.LVo.xF();
        AppMethodBeat.o(120960);
        return 0;
      }
      localdkj.FTw = locala.LVo.xF();
      AppMethodBeat.o(120960);
      return 0;
    }
    AppMethodBeat.o(120960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkj
 * JD-Core Version:    0.7.0.1
 */