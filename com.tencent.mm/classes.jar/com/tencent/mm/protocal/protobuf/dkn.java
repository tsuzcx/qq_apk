package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dkn
  extends com.tencent.mm.bw.a
{
  public int FTC;
  public int FTD;
  public String FTE;
  public b FTF;
  public int FTG;
  public int FTH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FTC);
      paramVarArgs.aR(2, this.FTD);
      if (this.FTE != null) {
        paramVarArgs.d(3, this.FTE);
      }
      if (this.FTF != null) {
        paramVarArgs.c(4, this.FTF);
      }
      paramVarArgs.aR(5, this.FTG);
      paramVarArgs.aR(6, this.FTH);
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FTC) + 0 + f.a.a.b.b.a.bx(2, this.FTD);
      paramInt = i;
      if (this.FTE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FTE);
      }
      i = paramInt;
      if (this.FTF != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.FTF);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.FTG);
      int j = f.a.a.b.b.a.bx(6, this.FTH);
      AppMethodBeat.o(82481);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dkn localdkn = (dkn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82481);
        return -1;
      case 1: 
        localdkn.FTC = locala.LVo.xF();
        AppMethodBeat.o(82481);
        return 0;
      case 2: 
        localdkn.FTD = locala.LVo.xF();
        AppMethodBeat.o(82481);
        return 0;
      case 3: 
        localdkn.FTE = locala.LVo.readString();
        AppMethodBeat.o(82481);
        return 0;
      case 4: 
        localdkn.FTF = locala.LVo.gfk();
        AppMethodBeat.o(82481);
        return 0;
      case 5: 
        localdkn.FTG = locala.LVo.xF();
        AppMethodBeat.o(82481);
        return 0;
      }
      localdkn.FTH = locala.LVo.xF();
      AppMethodBeat.o(82481);
      return 0;
    }
    AppMethodBeat.o(82481);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkn
 * JD-Core Version:    0.7.0.1
 */