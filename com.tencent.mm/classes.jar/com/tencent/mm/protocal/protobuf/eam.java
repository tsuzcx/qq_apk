package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eam
  extends com.tencent.mm.bw.a
{
  public int Etq;
  public int Etr;
  public String KIC;
  public String KID;
  public String KIE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125804);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KIC != null) {
        paramVarArgs.e(1, this.KIC);
      }
      if (this.KID != null) {
        paramVarArgs.e(2, this.KID);
      }
      if (this.KIE != null) {
        paramVarArgs.e(3, this.KIE);
      }
      paramVarArgs.aM(4, this.Etq);
      paramVarArgs.aM(5, this.Etr);
      AppMethodBeat.o(125804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KIC == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.f(1, this.KIC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KID != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KID);
      }
      i = paramInt;
      if (this.KIE != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KIE);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Etq);
      int j = g.a.a.b.b.a.bu(5, this.Etr);
      AppMethodBeat.o(125804);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125804);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eam localeam = (eam)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125804);
          return -1;
        case 1: 
          localeam.KIC = locala.UbS.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 2: 
          localeam.KID = locala.UbS.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 3: 
          localeam.KIE = locala.UbS.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 4: 
          localeam.Etq = locala.UbS.zi();
          AppMethodBeat.o(125804);
          return 0;
        }
        localeam.Etr = locala.UbS.zi();
        AppMethodBeat.o(125804);
        return 0;
      }
      AppMethodBeat.o(125804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eam
 * JD-Core Version:    0.7.0.1
 */