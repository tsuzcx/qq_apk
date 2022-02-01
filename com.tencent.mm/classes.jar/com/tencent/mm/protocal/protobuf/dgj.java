package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgj
  extends com.tencent.mm.bw.a
{
  public String Liq;
  public int LoT;
  public int MKY;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32393);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.Liq != null) {
        paramVarArgs.e(2, this.Liq);
      }
      paramVarArgs.aM(3, this.MKY);
      paramVarArgs.aM(4, this.LoT);
      AppMethodBeat.o(32393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Liq != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Liq);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MKY);
      int j = g.a.a.b.b.a.bu(4, this.LoT);
      AppMethodBeat.o(32393);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32393);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dgj localdgj = (dgj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32393);
          return -1;
        case 1: 
          localdgj.UserName = locala.UbS.readString();
          AppMethodBeat.o(32393);
          return 0;
        case 2: 
          localdgj.Liq = locala.UbS.readString();
          AppMethodBeat.o(32393);
          return 0;
        case 3: 
          localdgj.MKY = locala.UbS.zi();
          AppMethodBeat.o(32393);
          return 0;
        }
        localdgj.LoT = locala.UbS.zi();
        AppMethodBeat.o(32393);
        return 0;
      }
      AppMethodBeat.o(32393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgj
 * JD-Core Version:    0.7.0.1
 */