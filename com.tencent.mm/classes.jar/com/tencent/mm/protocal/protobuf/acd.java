package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acd
  extends com.tencent.mm.bw.a
{
  public int KJJ;
  public int LmH;
  public int LmI;
  public int count;
  public String openid;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103205);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.openid != null) {
        paramVarArgs.e(1, this.openid);
      }
      paramVarArgs.aM(2, this.KJJ);
      paramVarArgs.aM(3, this.LmH);
      paramVarArgs.aM(4, this.LmI);
      paramVarArgs.aM(5, this.scene);
      paramVarArgs.aM(6, this.count);
      AppMethodBeat.o(103205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.openid == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = g.a.a.b.b.a.f(1, this.openid) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.KJJ);
      int j = g.a.a.b.b.a.bu(3, this.LmH);
      int k = g.a.a.b.b.a.bu(4, this.LmI);
      int m = g.a.a.b.b.a.bu(5, this.scene);
      int n = g.a.a.b.b.a.bu(6, this.count);
      AppMethodBeat.o(103205);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103205);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        acd localacd = (acd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103205);
          return -1;
        case 1: 
          localacd.openid = locala.UbS.readString();
          AppMethodBeat.o(103205);
          return 0;
        case 2: 
          localacd.KJJ = locala.UbS.zi();
          AppMethodBeat.o(103205);
          return 0;
        case 3: 
          localacd.LmH = locala.UbS.zi();
          AppMethodBeat.o(103205);
          return 0;
        case 4: 
          localacd.LmI = locala.UbS.zi();
          AppMethodBeat.o(103205);
          return 0;
        case 5: 
          localacd.scene = locala.UbS.zi();
          AppMethodBeat.o(103205);
          return 0;
        }
        localacd.count = locala.UbS.zi();
        AppMethodBeat.o(103205);
        return 0;
      }
      AppMethodBeat.o(103205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acd
 * JD-Core Version:    0.7.0.1
 */