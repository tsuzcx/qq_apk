package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eup
  extends com.tencent.mm.cd.a
{
  public String DNV;
  public String IfQ;
  public String Igm;
  public String Ign;
  public String Igo;
  public String Igp;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Igm != null) {
        paramVarArgs.f(1, this.Igm);
      }
      if (this.Ign != null) {
        paramVarArgs.f(2, this.Ign);
      }
      if (this.IfQ != null) {
        paramVarArgs.f(3, this.IfQ);
      }
      if (this.DNV != null) {
        paramVarArgs.f(4, this.DNV);
      }
      if (this.fvP != null) {
        paramVarArgs.f(5, this.fvP);
      }
      if (this.Igo != null) {
        paramVarArgs.f(6, this.Igo);
      }
      if (this.Igp != null) {
        paramVarArgs.f(7, this.Igp);
      }
      AppMethodBeat.o(72612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Igm == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.g(1, this.Igm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ign != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Ign);
      }
      i = paramInt;
      if (this.IfQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.IfQ);
      }
      paramInt = i;
      if (this.DNV != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.DNV);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fvP);
      }
      paramInt = i;
      if (this.Igo != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Igo);
      }
      i = paramInt;
      if (this.Igp != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Igp);
      }
      AppMethodBeat.o(72612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72612);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eup localeup = (eup)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72612);
          return -1;
        case 1: 
          localeup.Igm = locala.abFh.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 2: 
          localeup.Ign = locala.abFh.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 3: 
          localeup.IfQ = locala.abFh.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 4: 
          localeup.DNV = locala.abFh.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 5: 
          localeup.fvP = locala.abFh.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 6: 
          localeup.Igo = locala.abFh.readString();
          AppMethodBeat.o(72612);
          return 0;
        }
        localeup.Igp = locala.abFh.readString();
        AppMethodBeat.o(72612);
        return 0;
      }
      AppMethodBeat.o(72612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eup
 * JD-Core Version:    0.7.0.1
 */