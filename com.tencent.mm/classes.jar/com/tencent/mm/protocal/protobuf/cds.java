package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cds
  extends com.tencent.mm.bx.a
{
  public int FKZ;
  public String dym;
  public String nDo;
  public String nEt;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184131);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.xbo != null) {
        paramVarArgs.d(2, this.xbo);
      }
      paramVarArgs.aS(3, this.FKZ);
      if (this.nEt != null) {
        paramVarArgs.d(4, this.nEt);
      }
      if (this.dym != null) {
        paramVarArgs.d(5, this.dym);
      }
      AppMethodBeat.o(184131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xbo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xbo);
      }
      i += f.a.a.b.b.a.bz(3, this.FKZ);
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nEt);
      }
      i = paramInt;
      if (this.dym != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dym);
      }
      AppMethodBeat.o(184131);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(184131);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cds localcds = (cds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184131);
          return -1;
        case 1: 
          localcds.nDo = locala.NPN.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 2: 
          localcds.xbo = locala.NPN.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 3: 
          localcds.FKZ = locala.NPN.zc();
          AppMethodBeat.o(184131);
          return 0;
        case 4: 
          localcds.nEt = locala.NPN.readString();
          AppMethodBeat.o(184131);
          return 0;
        }
        localcds.dym = locala.NPN.readString();
        AppMethodBeat.o(184131);
        return 0;
      }
      AppMethodBeat.o(184131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cds
 * JD-Core Version:    0.7.0.1
 */