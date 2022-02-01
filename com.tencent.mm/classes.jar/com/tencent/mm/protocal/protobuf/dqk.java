package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqk
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String KLO;
  public String Lke;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134254);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.Lke != null) {
        paramVarArgs.e(2, this.Lke);
      }
      if (this.KLO != null) {
        paramVarArgs.e(3, this.KLO);
      }
      paramVarArgs.aM(4, this.CreateTime);
      AppMethodBeat.o(134254);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lke != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lke);
      }
      i = paramInt;
      if (this.KLO != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KLO);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.CreateTime);
      AppMethodBeat.o(134254);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(134254);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dqk localdqk = (dqk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134254);
          return -1;
        case 1: 
          localdqk.Name = locala.UbS.readString();
          AppMethodBeat.o(134254);
          return 0;
        case 2: 
          localdqk.Lke = locala.UbS.readString();
          AppMethodBeat.o(134254);
          return 0;
        case 3: 
          localdqk.KLO = locala.UbS.readString();
          AppMethodBeat.o(134254);
          return 0;
        }
        localdqk.CreateTime = locala.UbS.zi();
        AppMethodBeat.o(134254);
        return 0;
      }
      AppMethodBeat.o(134254);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqk
 * JD-Core Version:    0.7.0.1
 */