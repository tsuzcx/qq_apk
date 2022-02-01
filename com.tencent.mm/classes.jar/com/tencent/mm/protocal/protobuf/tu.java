package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tu
  extends com.tencent.mm.bx.a
{
  public String FHU;
  public long FSm;
  public int FSn;
  public int FuY;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHU != null) {
        paramVarArgs.d(1, this.FHU);
      }
      paramVarArgs.aY(2, this.FSm);
      paramVarArgs.aS(3, this.FSn);
      paramVarArgs.aS(4, this.FuY);
      paramVarArgs.aS(5, this.nDG);
      AppMethodBeat.o(93332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FHU == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.FHU) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FSm);
      int j = f.a.a.b.b.a.bz(3, this.FSn);
      int k = f.a.a.b.b.a.bz(4, this.FuY);
      int m = f.a.a.b.b.a.bz(5, this.nDG);
      AppMethodBeat.o(93332);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(93332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tu localtu = (tu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(93332);
          return -1;
        case 1: 
          localtu.FHU = locala.NPN.readString();
          AppMethodBeat.o(93332);
          return 0;
        case 2: 
          localtu.FSm = locala.NPN.zd();
          AppMethodBeat.o(93332);
          return 0;
        case 3: 
          localtu.FSn = locala.NPN.zc();
          AppMethodBeat.o(93332);
          return 0;
        case 4: 
          localtu.FuY = locala.NPN.zc();
          AppMethodBeat.o(93332);
          return 0;
        }
        localtu.nDG = locala.NPN.zc();
        AppMethodBeat.o(93332);
        return 0;
      }
      AppMethodBeat.o(93332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tu
 * JD-Core Version:    0.7.0.1
 */