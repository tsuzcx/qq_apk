package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blp
  extends com.tencent.mm.bw.a
{
  public int Fbe;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      paramVarArgs.aR(2, this.Fbe);
      AppMethodBeat.o(32333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Fbe);
      AppMethodBeat.o(32333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32333);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        blp localblp = (blp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32333);
          return -1;
        case 1: 
          localblp.ncR = locala.LVo.readString();
          AppMethodBeat.o(32333);
          return 0;
        }
        localblp.Fbe = locala.LVo.xF();
        AppMethodBeat.o(32333);
        return 0;
      }
      AppMethodBeat.o(32333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blp
 * JD-Core Version:    0.7.0.1
 */