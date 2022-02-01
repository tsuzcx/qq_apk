package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bur
  extends com.tencent.mm.bw.a
{
  public int Fkz;
  public String xom;
  public int xon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xom != null) {
        paramVarArgs.d(1, this.xom);
      }
      paramVarArgs.aR(2, this.xon);
      paramVarArgs.aR(3, this.Fkz);
      AppMethodBeat.o(147773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xom == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.xom) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.xon);
      int j = f.a.a.b.b.a.bx(3, this.Fkz);
      AppMethodBeat.o(147773);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147773);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bur localbur = (bur)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147773);
          return -1;
        case 1: 
          localbur.xom = locala.LVo.readString();
          AppMethodBeat.o(147773);
          return 0;
        case 2: 
          localbur.xon = locala.LVo.xF();
          AppMethodBeat.o(147773);
          return 0;
        }
        localbur.Fkz = locala.LVo.xF();
        AppMethodBeat.o(147773);
        return 0;
      }
      AppMethodBeat.o(147773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bur
 * JD-Core Version:    0.7.0.1
 */