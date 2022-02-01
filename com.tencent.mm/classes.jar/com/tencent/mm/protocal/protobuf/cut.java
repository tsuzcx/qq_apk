package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cut
  extends com.tencent.mm.bw.a
{
  public String Bri;
  public int KXP;
  public String UserName;
  public String dRe;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184131);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.Bri != null) {
        paramVarArgs.e(2, this.Bri);
      }
      paramVarArgs.aM(3, this.KXP);
      if (this.oUJ != null) {
        paramVarArgs.e(4, this.oUJ);
      }
      if (this.dRe != null) {
        paramVarArgs.e(5, this.dRe);
      }
      AppMethodBeat.o(184131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Bri != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Bri);
      }
      i += g.a.a.b.b.a.bu(3, this.KXP);
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oUJ);
      }
      i = paramInt;
      if (this.dRe != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dRe);
      }
      AppMethodBeat.o(184131);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(184131);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cut localcut = (cut)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184131);
          return -1;
        case 1: 
          localcut.UserName = locala.UbS.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 2: 
          localcut.Bri = locala.UbS.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 3: 
          localcut.KXP = locala.UbS.zi();
          AppMethodBeat.o(184131);
          return 0;
        case 4: 
          localcut.oUJ = locala.UbS.readString();
          AppMethodBeat.o(184131);
          return 0;
        }
        localcut.dRe = locala.UbS.readString();
        AppMethodBeat.o(184131);
        return 0;
      }
      AppMethodBeat.o(184131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cut
 * JD-Core Version:    0.7.0.1
 */