package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctg
  extends com.tencent.mm.bw.a
{
  public String FFe;
  public int FFf;
  public String dnz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FFe != null) {
        paramVarArgs.d(1, this.FFe);
      }
      if (this.dnz != null) {
        paramVarArgs.d(2, this.dnz);
      }
      paramVarArgs.aR(3, this.FFf);
      AppMethodBeat.o(152686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FFe == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FFe) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dnz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dnz);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FFf);
      AppMethodBeat.o(152686);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152686);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctg localctg = (ctg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152686);
          return -1;
        case 1: 
          localctg.FFe = locala.LVo.readString();
          AppMethodBeat.o(152686);
          return 0;
        case 2: 
          localctg.dnz = locala.LVo.readString();
          AppMethodBeat.o(152686);
          return 0;
        }
        localctg.FFf = locala.LVo.xF();
        AppMethodBeat.o(152686);
        return 0;
      }
      AppMethodBeat.o(152686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctg
 * JD-Core Version:    0.7.0.1
 */