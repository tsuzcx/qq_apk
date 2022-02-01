package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccy
  extends com.tencent.mm.bw.a
{
  public String Ewy;
  public int FrB;
  public int FrC;
  public int FrD;
  public long FrE;
  public int FrF;
  public int FrG;
  public String tlX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FrB);
      paramVarArgs.aR(2, this.FrC);
      paramVarArgs.aR(3, this.FrD);
      if (this.tlX != null) {
        paramVarArgs.d(4, this.tlX);
      }
      paramVarArgs.aO(5, this.FrE);
      paramVarArgs.aR(6, this.FrF);
      if (this.Ewy != null) {
        paramVarArgs.d(7, this.Ewy);
      }
      paramVarArgs.aR(8, this.FrG);
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FrB) + 0 + f.a.a.b.b.a.bx(2, this.FrC) + f.a.a.b.b.a.bx(3, this.FrD);
      paramInt = i;
      if (this.tlX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tlX);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.FrE) + f.a.a.b.b.a.bx(6, this.FrF);
      paramInt = i;
      if (this.Ewy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ewy);
      }
      i = f.a.a.b.b.a.bx(8, this.FrG);
      AppMethodBeat.o(104825);
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
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ccy localccy = (ccy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104825);
        return -1;
      case 1: 
        localccy.FrB = locala.LVo.xF();
        AppMethodBeat.o(104825);
        return 0;
      case 2: 
        localccy.FrC = locala.LVo.xF();
        AppMethodBeat.o(104825);
        return 0;
      case 3: 
        localccy.FrD = locala.LVo.xF();
        AppMethodBeat.o(104825);
        return 0;
      case 4: 
        localccy.tlX = locala.LVo.readString();
        AppMethodBeat.o(104825);
        return 0;
      case 5: 
        localccy.FrE = locala.LVo.xG();
        AppMethodBeat.o(104825);
        return 0;
      case 6: 
        localccy.FrF = locala.LVo.xF();
        AppMethodBeat.o(104825);
        return 0;
      case 7: 
        localccy.Ewy = locala.LVo.readString();
        AppMethodBeat.o(104825);
        return 0;
      }
      localccy.FrG = locala.LVo.xF();
      AppMethodBeat.o(104825);
      return 0;
    }
    AppMethodBeat.o(104825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccy
 * JD-Core Version:    0.7.0.1
 */