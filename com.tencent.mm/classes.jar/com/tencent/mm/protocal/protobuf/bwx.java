package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwx
  extends com.tencent.mm.bw.a
{
  public int ESl;
  public String ESm;
  public int EnO;
  public String wYr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wYr != null) {
        paramVarArgs.d(1, this.wYr);
      }
      paramVarArgs.aR(2, this.ESl);
      if (this.ESm != null) {
        paramVarArgs.d(3, this.ESm);
      }
      paramVarArgs.aR(4, this.EnO);
      AppMethodBeat.o(116456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wYr == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.wYr) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ESl);
      paramInt = i;
      if (this.ESm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ESm);
      }
      i = f.a.a.b.b.a.bx(4, this.EnO);
      AppMethodBeat.o(116456);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwx localbwx = (bwx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116456);
          return -1;
        case 1: 
          localbwx.wYr = locala.LVo.readString();
          AppMethodBeat.o(116456);
          return 0;
        case 2: 
          localbwx.ESl = locala.LVo.xF();
          AppMethodBeat.o(116456);
          return 0;
        case 3: 
          localbwx.ESm = locala.LVo.readString();
          AppMethodBeat.o(116456);
          return 0;
        }
        localbwx.EnO = locala.LVo.xF();
        AppMethodBeat.o(116456);
        return 0;
      }
      AppMethodBeat.o(116456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwx
 * JD-Core Version:    0.7.0.1
 */