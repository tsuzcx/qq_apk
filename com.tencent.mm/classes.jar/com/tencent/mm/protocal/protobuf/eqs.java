package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class eqs
  extends com.tencent.mm.bw.a
{
  public String MVS;
  public int Noa;
  public String Nob;
  public String Noc;
  public int Nod;
  public String Noe;
  public int Nof;
  public int Nog;
  public String Noh;
  public int Noi;
  public String Noj;
  public int Nok;
  public String Nol;
  public int Nom;
  public String Non;
  public String dNI;
  public String extInfo;
  public int gTn;
  public String iwv;
  public String title;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176157);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      paramVarArgs.aM(3, this.version);
      if (this.iwv != null) {
        paramVarArgs.e(4, this.iwv);
      }
      paramVarArgs.aM(5, this.Noa);
      if (this.Nob != null) {
        paramVarArgs.e(6, this.Nob);
      }
      if (this.Noc != null) {
        paramVarArgs.e(7, this.Noc);
      }
      paramVarArgs.aM(8, this.Nod);
      if (this.Noe != null) {
        paramVarArgs.e(9, this.Noe);
      }
      paramVarArgs.aM(10, this.gTn);
      paramVarArgs.aM(11, this.Nof);
      paramVarArgs.aM(12, this.Nog);
      if (this.Noh != null) {
        paramVarArgs.e(13, this.Noh);
      }
      if (this.MVS != null) {
        paramVarArgs.e(14, this.MVS);
      }
      paramVarArgs.aM(15, this.Noi);
      if (this.Noj != null) {
        paramVarArgs.e(16, this.Noj);
      }
      paramVarArgs.aM(17, this.Nok);
      if (this.Nol != null) {
        paramVarArgs.e(18, this.Nol);
      }
      paramVarArgs.aM(19, this.Nom);
      if (this.extInfo != null) {
        paramVarArgs.e(20, this.extInfo);
      }
      if (this.Non != null) {
        paramVarArgs.e(21, this.Non);
      }
      AppMethodBeat.o(176157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1298;
      }
    }
    label1298:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dNI);
      }
      i += g.a.a.b.b.a.bu(3, this.version);
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iwv);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Noa);
      paramInt = i;
      if (this.Nob != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Nob);
      }
      i = paramInt;
      if (this.Noc != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Noc);
      }
      i += g.a.a.b.b.a.bu(8, this.Nod);
      paramInt = i;
      if (this.Noe != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Noe);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.gTn) + g.a.a.b.b.a.bu(11, this.Nof) + g.a.a.b.b.a.bu(12, this.Nog);
      paramInt = i;
      if (this.Noh != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Noh);
      }
      i = paramInt;
      if (this.MVS != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MVS);
      }
      i += g.a.a.b.b.a.bu(15, this.Noi);
      paramInt = i;
      if (this.Noj != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.Noj);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.Nok);
      paramInt = i;
      if (this.Nol != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.Nol);
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.Nom);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.extInfo);
      }
      i = paramInt;
      if (this.Non != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.Non);
      }
      AppMethodBeat.o(176157);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(176157);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqs localeqs = (eqs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176157);
          return -1;
        case 1: 
          localeqs.title = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 2: 
          localeqs.dNI = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 3: 
          localeqs.version = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 4: 
          localeqs.iwv = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 5: 
          localeqs.Noa = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 6: 
          localeqs.Nob = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 7: 
          localeqs.Noc = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 8: 
          localeqs.Nod = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 9: 
          localeqs.Noe = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 10: 
          localeqs.gTn = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 11: 
          localeqs.Nof = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 12: 
          localeqs.Nog = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 13: 
          localeqs.Noh = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 14: 
          localeqs.MVS = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 15: 
          localeqs.Noi = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 16: 
          localeqs.Noj = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 17: 
          localeqs.Nok = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 18: 
          localeqs.Nol = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 19: 
          localeqs.Nom = locala.UbS.zi();
          AppMethodBeat.o(176157);
          return 0;
        case 20: 
          localeqs.extInfo = locala.UbS.readString();
          AppMethodBeat.o(176157);
          return 0;
        }
        localeqs.Non = locala.UbS.readString();
        AppMethodBeat.o(176157);
        return 0;
      }
      AppMethodBeat.o(176157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqs
 * JD-Core Version:    0.7.0.1
 */