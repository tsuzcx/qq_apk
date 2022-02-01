package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edb
  extends com.tencent.mm.bw.a
{
  public long Nds;
  public int Ndt;
  public int Ndu;
  public String ThumbUrl;
  public String UserName;
  public String xLk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118434);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      paramVarArgs.bb(2, this.Nds);
      paramVarArgs.aM(3, this.Ndt);
      if (this.ThumbUrl != null) {
        paramVarArgs.e(4, this.ThumbUrl);
      }
      paramVarArgs.aM(5, this.Ndu);
      if (this.xLk != null) {
        paramVarArgs.e(6, this.xLk);
      }
      AppMethodBeat.o(118434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.Nds) + g.a.a.b.b.a.bu(3, this.Ndt);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ThumbUrl);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Ndu);
      paramInt = i;
      if (this.xLk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xLk);
      }
      AppMethodBeat.o(118434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(118434);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        edb localedb = (edb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118434);
          return -1;
        case 1: 
          localedb.UserName = locala.UbS.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 2: 
          localedb.Nds = locala.UbS.zl();
          AppMethodBeat.o(118434);
          return 0;
        case 3: 
          localedb.Ndt = locala.UbS.zi();
          AppMethodBeat.o(118434);
          return 0;
        case 4: 
          localedb.ThumbUrl = locala.UbS.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 5: 
          localedb.Ndu = locala.UbS.zi();
          AppMethodBeat.o(118434);
          return 0;
        }
        localedb.xLk = locala.UbS.readString();
        AppMethodBeat.o(118434);
        return 0;
      }
      AppMethodBeat.o(118434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edb
 * JD-Core Version:    0.7.0.1
 */