package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzk
  extends com.tencent.mm.bw.a
{
  public String LRU;
  public String MZd;
  public int MZe;
  public int MZf;
  public int MmV;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125773);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MZd != null) {
        paramVarArgs.e(1, this.MZd);
      }
      paramVarArgs.aM(2, this.MZe);
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      if (this.LRU != null) {
        paramVarArgs.e(4, this.LRU);
      }
      paramVarArgs.aM(5, this.MmV);
      paramVarArgs.aM(6, this.MZf);
      AppMethodBeat.o(125773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MZd == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.b.b.a.f(1, this.MZd) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MZe);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.UserName);
      }
      i = paramInt;
      if (this.LRU != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LRU);
      }
      paramInt = g.a.a.b.b.a.bu(5, this.MmV);
      int j = g.a.a.b.b.a.bu(6, this.MZf);
      AppMethodBeat.o(125773);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125773);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dzk localdzk = (dzk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125773);
          return -1;
        case 1: 
          localdzk.MZd = locala.UbS.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 2: 
          localdzk.MZe = locala.UbS.zi();
          AppMethodBeat.o(125773);
          return 0;
        case 3: 
          localdzk.UserName = locala.UbS.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 4: 
          localdzk.LRU = locala.UbS.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 5: 
          localdzk.MmV = locala.UbS.zi();
          AppMethodBeat.o(125773);
          return 0;
        }
        localdzk.MZf = locala.UbS.zi();
        AppMethodBeat.o(125773);
        return 0;
      }
      AppMethodBeat.o(125773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzk
 * JD-Core Version:    0.7.0.1
 */