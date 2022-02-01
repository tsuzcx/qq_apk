package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fp
  extends com.tencent.mm.bw.a
{
  public int DSE;
  public int DSF;
  public int DSG;
  public int DSH;
  public int DSI;
  public String DSJ;
  public int DSK;
  public int height;
  public long nLx;
  public String url;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103201);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aR(2, this.DSE);
      paramVarArgs.aR(3, this.DSF);
      paramVarArgs.aO(4, this.nLx);
      paramVarArgs.aR(5, this.width);
      paramVarArgs.aR(6, this.height);
      paramVarArgs.aR(10, this.DSG);
      paramVarArgs.aR(11, this.DSH);
      paramVarArgs.aR(12, this.DSI);
      if (this.DSJ != null) {
        paramVarArgs.d(13, this.DSJ);
      }
      paramVarArgs.aR(15, this.DSK);
      AppMethodBeat.o(103201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DSE) + f.a.a.b.b.a.bx(3, this.DSF) + f.a.a.b.b.a.p(4, this.nLx) + f.a.a.b.b.a.bx(5, this.width) + f.a.a.b.b.a.bx(6, this.height) + f.a.a.b.b.a.bx(10, this.DSG) + f.a.a.b.b.a.bx(11, this.DSH) + f.a.a.b.b.a.bx(12, this.DSI);
      paramInt = i;
      if (this.DSJ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DSJ);
      }
      i = f.a.a.b.b.a.bx(15, this.DSK);
      AppMethodBeat.o(103201);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103201);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fp localfp = (fp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        case 8: 
        case 9: 
        case 14: 
        default: 
          AppMethodBeat.o(103201);
          return -1;
        case 1: 
          localfp.url = locala.LVo.readString();
          AppMethodBeat.o(103201);
          return 0;
        case 2: 
          localfp.DSE = locala.LVo.xF();
          AppMethodBeat.o(103201);
          return 0;
        case 3: 
          localfp.DSF = locala.LVo.xF();
          AppMethodBeat.o(103201);
          return 0;
        case 4: 
          localfp.nLx = locala.LVo.xG();
          AppMethodBeat.o(103201);
          return 0;
        case 5: 
          localfp.width = locala.LVo.xF();
          AppMethodBeat.o(103201);
          return 0;
        case 6: 
          localfp.height = locala.LVo.xF();
          AppMethodBeat.o(103201);
          return 0;
        case 10: 
          localfp.DSG = locala.LVo.xF();
          AppMethodBeat.o(103201);
          return 0;
        case 11: 
          localfp.DSH = locala.LVo.xF();
          AppMethodBeat.o(103201);
          return 0;
        case 12: 
          localfp.DSI = locala.LVo.xF();
          AppMethodBeat.o(103201);
          return 0;
        case 13: 
          localfp.DSJ = locala.LVo.readString();
          AppMethodBeat.o(103201);
          return 0;
        }
        localfp.DSK = locala.LVo.xF();
        AppMethodBeat.o(103201);
        return 0;
      }
      AppMethodBeat.o(103201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fp
 * JD-Core Version:    0.7.0.1
 */