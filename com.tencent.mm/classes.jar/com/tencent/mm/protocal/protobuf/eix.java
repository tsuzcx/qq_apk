package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eix
  extends com.tencent.mm.bw.a
{
  public long NiK;
  public long NiL;
  public long Niv;
  public String mediaId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153014);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mediaId != null) {
        paramVarArgs.e(1, this.mediaId);
      }
      paramVarArgs.bb(2, this.NiK);
      paramVarArgs.bb(3, this.NiL);
      paramVarArgs.bb(4, this.Niv);
      AppMethodBeat.o(153014);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mediaId == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.f(1, this.mediaId) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.NiK);
      int j = g.a.a.b.b.a.r(3, this.NiL);
      int k = g.a.a.b.b.a.r(4, this.Niv);
      AppMethodBeat.o(153014);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153014);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eix localeix = (eix)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153014);
          return -1;
        case 1: 
          localeix.mediaId = locala.UbS.readString();
          AppMethodBeat.o(153014);
          return 0;
        case 2: 
          localeix.NiK = locala.UbS.zl();
          AppMethodBeat.o(153014);
          return 0;
        case 3: 
          localeix.NiL = locala.UbS.zl();
          AppMethodBeat.o(153014);
          return 0;
        }
        localeix.Niv = locala.UbS.zl();
        AppMethodBeat.o(153014);
        return 0;
      }
      AppMethodBeat.o(153014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eix
 * JD-Core Version:    0.7.0.1
 */