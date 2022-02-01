package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxl
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String iAc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iAc != null) {
        paramVarArgs.e(1, this.iAc);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      AppMethodBeat.o(43117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iAc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.iAc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Title);
      }
      AppMethodBeat.o(43117);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(43117);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxl localcxl = (cxl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43117);
          return -1;
        case 1: 
          localcxl.iAc = locala.UbS.readString();
          AppMethodBeat.o(43117);
          return 0;
        }
        localcxl.Title = locala.UbS.readString();
        AppMethodBeat.o(43117);
        return 0;
      }
      AppMethodBeat.o(43117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxl
 * JD-Core Version:    0.7.0.1
 */