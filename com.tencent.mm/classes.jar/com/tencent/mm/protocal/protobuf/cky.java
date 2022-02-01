package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cky
  extends com.tencent.mm.bx.a
{
  public String CIj;
  public String GBE;
  public int GGs;
  public String Gdh;
  public String Hem;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GBE != null) {
        paramVarArgs.d(1, this.GBE);
      }
      if (this.Hem != null) {
        paramVarArgs.d(2, this.Hem);
      }
      if (this.CIj != null) {
        paramVarArgs.d(3, this.CIj);
      }
      if (this.Gdh != null) {
        paramVarArgs.d(4, this.Gdh);
      }
      paramVarArgs.aS(5, this.GGs);
      AppMethodBeat.o(72549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GBE == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.GBE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hem != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hem);
      }
      i = paramInt;
      if (this.CIj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CIj);
      }
      paramInt = i;
      if (this.Gdh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gdh);
      }
      i = f.a.a.b.b.a.bz(5, this.GGs);
      AppMethodBeat.o(72549);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72549);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cky localcky = (cky)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72549);
          return -1;
        case 1: 
          localcky.GBE = locala.NPN.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 2: 
          localcky.Hem = locala.NPN.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 3: 
          localcky.CIj = locala.NPN.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 4: 
          localcky.Gdh = locala.NPN.readString();
          AppMethodBeat.o(72549);
          return 0;
        }
        localcky.GGs = locala.NPN.zc();
        AppMethodBeat.o(72549);
        return 0;
      }
      AppMethodBeat.o(72549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cky
 * JD-Core Version:    0.7.0.1
 */