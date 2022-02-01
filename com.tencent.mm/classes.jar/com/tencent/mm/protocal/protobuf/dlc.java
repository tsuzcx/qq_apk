package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlc
  extends com.tencent.mm.bw.a
{
  public int FHC;
  public String FHE;
  public String FHy;
  public String content;
  public int dae;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153308);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHE != null) {
        paramVarArgs.d(1, this.FHE);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.content != null) {
        paramVarArgs.d(3, this.content);
      }
      if (this.FHy != null) {
        paramVarArgs.d(4, this.FHy);
      }
      paramVarArgs.aR(5, this.FHC);
      paramVarArgs.aR(6, this.state);
      AppMethodBeat.o(153308);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FHE == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.FHE) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.content);
      }
      i = paramInt;
      if (this.FHy != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FHy);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.FHC);
      int j = f.a.a.b.b.a.bx(6, this.state);
      AppMethodBeat.o(153308);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153308);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dlc localdlc = (dlc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153308);
          return -1;
        case 1: 
          localdlc.FHE = locala.LVo.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 2: 
          localdlc.dae = locala.LVo.xF();
          AppMethodBeat.o(153308);
          return 0;
        case 3: 
          localdlc.content = locala.LVo.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 4: 
          localdlc.FHy = locala.LVo.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 5: 
          localdlc.FHC = locala.LVo.xF();
          AppMethodBeat.o(153308);
          return 0;
        }
        localdlc.state = locala.LVo.xF();
        AppMethodBeat.o(153308);
        return 0;
      }
      AppMethodBeat.o(153308);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlc
 * JD-Core Version:    0.7.0.1
 */