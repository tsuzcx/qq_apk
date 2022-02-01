package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwd
  extends com.tencent.mm.bx.a
{
  public String Fts;
  public String iht;
  public String uiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219264);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht != null) {
        paramVarArgs.d(1, this.iht);
      }
      if (this.uiR != null) {
        paramVarArgs.d(2, this.uiR);
      }
      if (this.Fts != null) {
        paramVarArgs.d(3, this.Fts);
      }
      AppMethodBeat.o(219264);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iht == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.iht) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uiR);
      }
      i = paramInt;
      if (this.Fts != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fts);
      }
      AppMethodBeat.o(219264);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(219264);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwd localcwd = (cwd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(219264);
          return -1;
        case 1: 
          localcwd.iht = locala.NPN.readString();
          AppMethodBeat.o(219264);
          return 0;
        case 2: 
          localcwd.uiR = locala.NPN.readString();
          AppMethodBeat.o(219264);
          return 0;
        }
        localcwd.Fts = locala.NPN.readString();
        AppMethodBeat.o(219264);
        return 0;
      }
      AppMethodBeat.o(219264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwd
 * JD-Core Version:    0.7.0.1
 */