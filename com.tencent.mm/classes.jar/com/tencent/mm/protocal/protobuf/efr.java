package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efr
  extends com.tencent.mm.bx.a
{
  public String GDw;
  public String GDx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133208);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GDw != null) {
        paramVarArgs.d(1, this.GDw);
      }
      if (this.GDx != null) {
        paramVarArgs.d(2, this.GDx);
      }
      AppMethodBeat.o(133208);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GDw == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.GDw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GDx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GDx);
      }
      AppMethodBeat.o(133208);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133208);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efr localefr = (efr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133208);
          return -1;
        case 1: 
          localefr.GDw = locala.NPN.readString();
          AppMethodBeat.o(133208);
          return 0;
        }
        localefr.GDx = locala.NPN.readString();
        AppMethodBeat.o(133208);
        return 0;
      }
      AppMethodBeat.o(133208);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efr
 * JD-Core Version:    0.7.0.1
 */