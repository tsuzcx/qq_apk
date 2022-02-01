package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public int iAs;
  public int iAt;
  public int iAu;
  public long iAv;
  public long iAw;
  public String iAx;
  public String iAy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91323);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.iAs);
      paramVarArgs.aR(2, this.iAt);
      paramVarArgs.aR(3, this.iAu);
      paramVarArgs.aO(4, this.iAv);
      paramVarArgs.aO(5, this.iAw);
      if (this.iAx != null) {
        paramVarArgs.d(6, this.iAx);
      }
      if (this.iAy != null) {
        paramVarArgs.d(7, this.iAy);
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.iAs) + 0 + f.a.a.b.b.a.bx(2, this.iAt) + f.a.a.b.b.a.bx(3, this.iAu) + f.a.a.b.b.a.p(4, this.iAv) + f.a.a.b.b.a.p(5, this.iAw);
      paramInt = i;
      if (this.iAx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iAx);
      }
      i = paramInt;
      if (this.iAy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iAy);
      }
      AppMethodBeat.o(91323);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91323);
        return -1;
      case 1: 
        locall.iAs = locala.LVo.xF();
        AppMethodBeat.o(91323);
        return 0;
      case 2: 
        locall.iAt = locala.LVo.xF();
        AppMethodBeat.o(91323);
        return 0;
      case 3: 
        locall.iAu = locala.LVo.xF();
        AppMethodBeat.o(91323);
        return 0;
      case 4: 
        locall.iAv = locala.LVo.xG();
        AppMethodBeat.o(91323);
        return 0;
      case 5: 
        locall.iAw = locala.LVo.xG();
        AppMethodBeat.o(91323);
        return 0;
      case 6: 
        locall.iAx = locala.LVo.readString();
        AppMethodBeat.o(91323);
        return 0;
      }
      locall.iAy = locala.LVo.readString();
      AppMethodBeat.o(91323);
      return 0;
    }
    AppMethodBeat.o(91323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.l
 * JD-Core Version:    0.7.0.1
 */