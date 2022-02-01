package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckg
  extends com.tencent.mm.bw.a
{
  public int KCC;
  public String KQi;
  public String MpD;
  public int MpE;
  public String UUID;
  public String UserName;
  public int oTW;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(232378);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UUID != null) {
        paramVarArgs.e(1, this.UUID);
      }
      paramVarArgs.aM(2, this.oTW);
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      if (this.KQi != null) {
        paramVarArgs.e(4, this.KQi);
      }
      if (this.MpD != null) {
        paramVarArgs.e(5, this.MpD);
      }
      paramVarArgs.aM(6, this.MpE);
      if (this.oUJ != null) {
        paramVarArgs.e(7, this.oUJ);
      }
      paramVarArgs.aM(8, this.KCC);
      AppMethodBeat.o(232378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UUID == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = g.a.a.b.b.a.f(1, this.UUID) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oTW);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.UserName);
      }
      i = paramInt;
      if (this.KQi != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KQi);
      }
      paramInt = i;
      if (this.MpD != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MpD);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.MpE);
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.oUJ);
      }
      i = g.a.a.b.b.a.bu(8, this.KCC);
      AppMethodBeat.o(232378);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(232378);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckg localckg = (ckg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(232378);
          return -1;
        case 1: 
          localckg.UUID = locala.UbS.readString();
          AppMethodBeat.o(232378);
          return 0;
        case 2: 
          localckg.oTW = locala.UbS.zi();
          AppMethodBeat.o(232378);
          return 0;
        case 3: 
          localckg.UserName = locala.UbS.readString();
          AppMethodBeat.o(232378);
          return 0;
        case 4: 
          localckg.KQi = locala.UbS.readString();
          AppMethodBeat.o(232378);
          return 0;
        case 5: 
          localckg.MpD = locala.UbS.readString();
          AppMethodBeat.o(232378);
          return 0;
        case 6: 
          localckg.MpE = locala.UbS.zi();
          AppMethodBeat.o(232378);
          return 0;
        case 7: 
          localckg.oUJ = locala.UbS.readString();
          AppMethodBeat.o(232378);
          return 0;
        }
        localckg.KCC = locala.UbS.zi();
        AppMethodBeat.o(232378);
        return 0;
      }
      AppMethodBeat.o(232378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckg
 * JD-Core Version:    0.7.0.1
 */