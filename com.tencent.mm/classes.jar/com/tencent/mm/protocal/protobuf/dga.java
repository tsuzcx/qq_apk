package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dga
  extends com.tencent.mm.bw.a
{
  public String Eoe;
  public int Etx;
  public int FwI;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.Eoe != null) {
        paramVarArgs.d(2, this.Eoe);
      }
      paramVarArgs.aR(3, this.FwI);
      paramVarArgs.aR(4, this.Etx);
      AppMethodBeat.o(32460);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eoe != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eoe);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FwI);
      int j = f.a.a.b.b.a.bx(4, this.Etx);
      AppMethodBeat.o(32460);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32460);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dga localdga = (dga)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32460);
          return -1;
        case 1: 
          localdga.ncR = locala.LVo.readString();
          AppMethodBeat.o(32460);
          return 0;
        case 2: 
          localdga.Eoe = locala.LVo.readString();
          AppMethodBeat.o(32460);
          return 0;
        case 3: 
          localdga.FwI = locala.LVo.xF();
          AppMethodBeat.o(32460);
          return 0;
        }
        localdga.Etx = locala.LVo.xF();
        AppMethodBeat.o(32460);
        return 0;
      }
      AppMethodBeat.o(32460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dga
 * JD-Core Version:    0.7.0.1
 */